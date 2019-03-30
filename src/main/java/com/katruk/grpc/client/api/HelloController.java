package com.katruk.grpc.client.api;

import com.katruk.grpc.client.service.HelloService;
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
    public String say(@RequestParam String name) {
        LocalDateTime start = LocalDateTime.now();
        String result = this.helloService.trySay(name);
        log.info("Result: {}, TimeOF: {}", result, Duration.between(start, now()));
        return result;
    }

    @GetMapping(value = "/many-try")
    public String trySay(@RequestParam int count, @RequestParam String name) {
        for (int i = 0; i < count; i++) {
            LocalDateTime start = LocalDateTime.now();
            String result = this.helloService.trySay(name + "_" + i);
            log.info("Result: {}, TimeOF: {}", result, Duration.between(start, now()));
        }
        return "Done";
    }

    @GetMapping(value = "/many-cf")
    public String cfSay(@RequestParam int count, @RequestParam String name) {
        for (int i = 0; i < count; i++) {
            LocalDateTime start = LocalDateTime.now();
            String result = this.helloService.cfSay(name + "_" + i);
            log.info("Result: {}, TimeOF: {}", result, Duration.between(start, now()));
        }
        return "Done";
    }

}
