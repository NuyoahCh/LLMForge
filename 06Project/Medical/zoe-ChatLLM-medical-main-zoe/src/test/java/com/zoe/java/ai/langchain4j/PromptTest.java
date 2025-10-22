package com.zoe.java.ai.langchain4j;

import com.zoe.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.zoe.java.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(3,"我是谁，今天几号");
        System.out.println(answer);
    }


    @Test
    public void testSystemMessage1() {
        String answer = separateChatAssistant.chat(4,"我是谁，今天几号");
        System.out.println(answer);
    }


    @Test
    public void testSystemMessage2() {
        String answer = separateChatAssistant.chat(5,"我是谁，今天几号");
        System.out.println(answer);
    }


    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testUserMessage() {
        String answer1 = memoryChatAssistant.chat("我是zoe");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat("我24岁");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("你知道我是谁吗");
        System.out.println(answer3);
    }

    @Test
    public void testV() {
        String answer1 = separateChatAssistant.chat2(5, "我是zoe");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat2(5, "我是谁");
        System.out.println(answer2);
    }

    @Test
    public void testUserInfo() {
        String answer = separateChatAssistant.chat3(10, "我是谁，我多大了", "翠花", 18);
        System.out.println(answer);
    }

}