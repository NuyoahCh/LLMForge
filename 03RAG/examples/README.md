# RAG 示例

该目录提供最小可运行的检索增强生成（RAG）示例，帮助你快速理解索引构建与问答流程。

## minimal_rag_demo.py

- 使用 LangChain + FAISS 构建内存向量库，并调用 OpenAI Chat Completion 模型完成问答。
- 默认读取 `sample_corpus/` 下的两份示例文档，可替换为你的业务资料。
- 运行前请确保：
  1. 安装依赖：`pip install langchain langchain-community openai faiss-cpu tiktoken`
  2. 设置环境变量：`export OPENAI_API_KEY=sk-...`
  3. 在项目根目录执行：`python 03RAG/examples/minimal_rag_demo.py`

> 如果无法访问 OpenAI，可将 `OpenAIEmbeddings` 与 `ChatOpenAI` 替换为阿里通义、火山方舟等兼容 API 的实现，或使用开源模型搭配本地向量化服务。
