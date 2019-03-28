package com.katruk.grpc.cli.api;

import com.katruk.grpc.cli.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping(value = "/")
    public String path(@PathVariable String name) {

        String result = this.helloService.say(name);
        log.info("Result  = {}", result);
        return result;
    }

}
