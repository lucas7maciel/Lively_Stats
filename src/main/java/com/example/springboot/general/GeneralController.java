package com.example.springboot.general;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Validated
public class GeneralController {

    @GetMapping("/")
    public String getMethodName() {
        return "Testando";
        // this.requestHandlerMapping.getHandlerMethods()
        // .forEach((key, value) -> ));
    }

}
