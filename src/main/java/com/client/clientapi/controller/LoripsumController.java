package com.client.clientapi.controller;

import com.client.clientapi.client.LoripsumClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class LoripsumController {
    private LoripsumClient loripsumClient;

    @Autowired
    public LoripsumController(LoripsumClient loripsumClient) {
        this.loripsumClient = loripsumClient;
    }

    @GetMapping("/content")
    public String getContent() {
        return loripsumClient.getLoripsum();
    }
}
