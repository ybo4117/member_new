package com.study.member.controller;


import com.study.member.dto.CommentDTO;
import com.study.member.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/board_save")
    public @ResponseBody String save(@ModelAttribute CommentDTO commentDTO){
        System.out.println("commentDTO = " + commentDTO);
        Long saveResult = commentService.save(commentDTO);
        if( saveResult != null){
            // 작성 성공하면 댓글 목록을 가져와서 리턴
            // 댓글 목록 : 해당 게시글의 댓글 전체
            List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());

        } else{
            return "작성 실패";
        }

    }
}
