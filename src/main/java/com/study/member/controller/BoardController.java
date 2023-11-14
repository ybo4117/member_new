package com.study.member.controller;


import com.study.member.dto.BoardDTO;
import com.study.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board_save")
    public String saveForm(){
        return "board_save";
    }

    //@RequestParam으로 값을 받아와도됨
    //DTO클래스객체에 담아서 보낼꺼임
    @PostMapping("/board_save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    @GetMapping("/board_list")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "board_list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        /*
            해당 게시글의 조회수를 하나 올리고
            게시글 데이터를 가져와서 detail.html에 출력
        */

        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board" , boardDTO);
        return "board_detail";

    }
}
