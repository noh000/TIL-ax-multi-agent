package com.sesac.aibackendintegrationspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sesac.aibackendintegrationspring.util.MessageFormatter;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final MessageFormatter formatter;

    public String hello(String name) {
        return formatter.format(name);
    }
}
