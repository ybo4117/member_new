package com.study.member.controller;


import com.study.member.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    @PostMapping("/board_save")
    public @ResponseBody String save(@ModelAttribute CommentDTO commentDTO){
        System.out.println("commentDTO = " + commentDTO);
        return "요청 성공";
    }
}
