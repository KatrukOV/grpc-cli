package com.katruk.grpc.client.service;

import com.katruk.grpc.client.client.HelloRepository;
import com.katruk.grpc.client.client.pb.Hello;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public String trySay(final String name) {
        return this.helloRepository.trySay(name)
                .map(Hello.HelloResponse::getGreeting)
                .orElse("Got error on " + name);
    }

    public List<String> manyTry(final int count, final String name) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String result = trySay(name + "_" + i);
            if (!result.startsWith("Got")) {
                resultList.add(result);
            } else {
                log.error(result);
            }
        }
        return resultList;
    }

    public String cfSay(final String name) {
        return this.helloRepository.cfSay(name)
                .map(Hello.HelloResponse::getGreeting)
                .orElse("Got error on " + name);

    }

}
