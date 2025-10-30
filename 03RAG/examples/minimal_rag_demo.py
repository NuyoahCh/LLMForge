"""Minimal RAG demo using LangChain and an in-memory FAISS vector store.

Prerequisites::

    pip install langchain langchain-community openai faiss-cpu tiktoken

Set the following environment variables before running the script:
- OPENAI_API_KEY: API key for calling OpenAI compatible LLMs

The script loads a small set of domain notes, builds a FAISS index, and
performs retrieval augmented generation for a user query.
"""

from __future__ import annotations

import os
from dataclasses import dataclass
from typing import List

from langchain.chains import RetrievalQA
from langchain_community.document_loaders import TextLoader
from langchain_community.embeddings import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_openai import ChatOpenAI
from langchain.text_splitter import RecursiveCharacterTextSplitter


DATA_DIR = os.path.join(os.path.dirname(__file__), "sample_corpus")


@dataclass
class DocumentSource:
    """Simple helper describing a text file that should be indexed."""

    path: str
    metadata: dict

    def load(self) -> List[str]:
        loader = TextLoader(self.path, encoding="utf-8")
        docs = loader.load()
        for doc in docs:
            doc.metadata.update(self.metadata)
        return docs


def build_vector_store(sources: List[DocumentSource]) -> FAISS:
    """Load documents, split them into chunks, and index with FAISS."""

    splitter = RecursiveCharacterTextSplitter(
        chunk_size=400,
        chunk_overlap=80,
        add_start_index=True,
    )

    docs = []
    for source in sources:
        docs.extend(source.load())

    split_docs = splitter.split_documents(docs)
    embeddings = OpenAIEmbeddings()  # uses OPENAI_API_KEY by default
    return FAISS.from_documents(split_docs, embeddings)


def run_query(vector_store: FAISS, question: str) -> str:
    """Execute retrieval augmented QA with the configured vector store."""

    llm = ChatOpenAI(model_name="gpt-3.5-turbo", temperature=0.2)
    qa_chain = RetrievalQA.from_chain_type(
        llm=llm,
        chain_type="stuff",
        retriever=vector_store.as_retriever(search_kwargs={"k": 3}),
    )
    result = qa_chain.invoke({"query": question})
    return result["result"]


def main() -> None:
    if not os.getenv("OPENAI_API_KEY"):
        raise RuntimeError("Please set the OPENAI_API_KEY environment variable before running the demo.")

    sources = [
        DocumentSource(
            path=os.path.join(DATA_DIR, "rag_concepts.txt"),
            metadata={"category": "concept"},
        ),
        DocumentSource(
            path=os.path.join(DATA_DIR, "pipeline_checklist.txt"),
            metadata={"category": "checklist"},
        ),
    ]

    vector_store = build_vector_store(sources)
    question = "如何设计一个基础的 RAG 流程，并关注哪些评估指标？"
    answer = run_query(vector_store, question)
    print("Question:\n", question)
    print("\nAnswer:\n", answer)


if __name__ == "__main__":
    main()
