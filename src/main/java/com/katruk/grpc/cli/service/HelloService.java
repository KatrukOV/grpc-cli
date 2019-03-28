package com.katruk.grpc.cli.service;

import com.katruk.grpc.cli.client.HelloRepository;
import com.katruk.grpc.cli.client.pb.Hello;
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
