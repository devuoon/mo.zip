package com.mozip.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Project 테이블과 관련된 URL매핑(recruit_create,detail,list / show_crate,detail,list)
 */
@RequiredArgsConstructor
@Controller
public class ProjectController {

    // 메인페이지
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // recruit_create 페이지
    @GetMapping("/project/create") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String recruitCreateForm() {
        return "/project/recruit_create";
    }

    // recruit_detail 페이지
    @GetMapping("/project/projectId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String recruitDetailForm(){
        return "/project/recruit_detail";
    }

    // recruit_list 페이지
    @GetMapping("/project")
    public String recruitListForm(){
        return "/project/recruit_list";
    }

    // show_detail 페이지
    @GetMapping("/project/show/projectId") // TODO : {}로 묶어야함(쿼리 파라미터)
    public String showDetailForm(){
        return "/project/show_detail";
    }

    // show_list 페이지
    @GetMapping("/project/show")
    public String showListForm(){
        return "/project/show_list";
    }
}
