package com.katruk.grpc.cli.api;

import com.katruk.grpc.cli.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping(value = "/")
    public String path(@RequestParam String name) {
        LocalDateTime start = LocalDateTime.now();
        String result = this.helloService.say(name);
        log.info("Result: {}, TimeOF: {}", result, Duration.between(start, now()));
        return result;
    }

}
