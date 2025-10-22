package com.zoe.java.ai.langchain4j.controller;

import com.zoe.java.ai.langchain4j.assistant.ZoeAgent;
import com.zoe.java.ai.langchain4j.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "zoe-agent")
@RestController
@RequestMapping("/zoe")
public class ZoeController {

    @Autowired
    private ZoeAgent zoeAgent;
    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm)  {
        return zoeAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}