package com.derellea.controller;


import com.derellea.domain.Vedio;
import com.derellea.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VedioController {

    @Autowired
    private VedioService vedioService;

    @RequestMapping("/vedio/{vcId}")
    public ModelAndView list(@PathVariable(name = "vcId") int vcId){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("list",vedioService.findByvcId(vcId));
        modelAndView.setViewName("/vedio.jsp");
        return modelAndView;
    }


}
