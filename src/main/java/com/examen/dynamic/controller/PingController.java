package com.examen.dynamic.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping()
    @ApiOperation(value = "Ping service", response = String.class)
    public String doPing() {
	return "pong: " + System.currentTimeMillis() + "\n";
    }
}
