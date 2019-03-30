package com.katruk.grpc.client.service;

import com.katruk.grpc.client.client.HelloRepository;
import com.katruk.grpc.client.client.pb.Hello;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public String say(final String name) {
        Hello.HelloResponse say = this.helloRepository.say(name);
        return say.getGreeting();
    }

}
