package com.derellea.controller;

import com.derellea.domain.VedioCategory;
import com.derellea.service.VedioCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VedioCategoryController {
        @Autowired
        private VedioCategoryService vedioCategoryService;

        @RequestMapping("/vediocategory")
        @ResponseBody
        public List<VedioCategory> vediocategory(){
            return vedioCategoryService.findAll();
        }
}
