package com.ProTeen.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // 웹 소켓 기능 활성화
public class MessageBrokerConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 웹 소캣 연결 주소
        registry.addEndpoint("/ws").setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 스프링에서 제공하는 내장 브로커 사용
        // "/sub"가 prefix로 붙은 경로로 메시지가 송신 되었을 때, SimpleBroker가 구독자에게 전달
        // <convention> /queue -> 1:1 /topic -> 1:m
        registry.enableSimpleBroker("/sub");
        // "/pub"이 붙어있는 경로로 송신되면, 해당 경로를 처리하고 있는 핸들러로 라우팅 >> @MessageMapping
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
