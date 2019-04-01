package com.katruk.grpc.client.service;

import com.katruk.grpc.client.client.HelloRepository;
import com.katruk.grpc.client.client.pb.Hello;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public String trySay(final String name) {
        return this.helloRepository.trySay(name)
                .map(Hello.HelloResponse::getGreeting)
                .orElse("Got error on " + name);
    }

    public String cfSay(final String name) {
        return this.helloRepository.cfSay(name)
                .map(Hello.HelloResponse::getGreeting)
                .orElse("Got error on " + name);

    }

}
