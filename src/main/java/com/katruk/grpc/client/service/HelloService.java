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
        Hello.HelloResponse say = this.helloRepository.trySay(name);
        return say.getGreeting();
    }

    public String cfSay(final String name) {
        Hello.HelloResponse say = this.helloRepository.cfSay(name);
        return say.getGreeting();
    }

}
