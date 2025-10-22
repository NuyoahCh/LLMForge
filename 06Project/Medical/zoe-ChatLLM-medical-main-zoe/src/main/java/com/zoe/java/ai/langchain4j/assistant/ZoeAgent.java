package com.zoe.java.ai.langchain4j.assistant;

import dev.langchain4j.service.*;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

//@AiService(
//        wiringMode = EXPLICIT,
//        chatModel = "qwenChatModel",
//        chatMemoryProvider = "chatMemoryProviderZoe",
//        tools = "appointmentTools", //tools配置
//        contentRetriever = "contentRetrieverzoe" //配置向量存储
//)
//
//
//public interface ZoeAgent {
//
//	@SystemMessage(fromResource = "zoe-prompt-template.txt")
//    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
//}


@AiService(
        wiringMode = EXPLICIT,
        streamingChatModel = "qwenStreamingChatModel",
        chatMemoryProvider = "chatMemoryProviderZoe",
        tools = "appointmentTools", //tools配置
        contentRetriever = "contentRetrieverzoe" //配置向量存储
)


public interface ZoeAgent {

    @SystemMessage(fromResource = "zoe-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}