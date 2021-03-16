package com.derellea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/question")
public class questionController {
    @RequestMapping("/list")
    @ResponseBody
    public void list(){

    }
}
