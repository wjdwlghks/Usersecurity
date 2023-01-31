package com.ProTeen.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class TestController {

//    @GetMapping("/main/signup")
//    public ModelAndView signup() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("/signuppage");
//        return mv;
//    }

    @GetMapping("/main/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/loginpage");
        return mv;
    }

    @GetMapping("/main")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/main");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView dologin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/loginpage");
        return mv;
    }

    @GetMapping("/main/chat")
    public ModelAndView chat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/chat");
        return mv;
    }
}
