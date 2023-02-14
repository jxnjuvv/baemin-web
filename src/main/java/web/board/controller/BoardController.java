package web.baemin.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.baemin.board.dto.Board;
import web.baemin.board.service.BoardService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void index(Model model){

        List<Board> boardList = boardService.boardList();
        System.out.println("boardList = " + boardList.toString());

        model.addAttribute("boardList", boardList);
    }

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(RedirectAttributes redirectAttributes, Board board){
        System.out.println("board = " + board);

        boardService.boardInsert(board);

        redirectAttributes.addFlashAttribute("msg", null);

        return "redirect:/board/list";
    }

    @GetMapping("/modify")
    public void modify(Model model, @RequestParam String id){
        System.out.println("id = " + id);

        Board board = boardService.boardRead(id);

        model.addAttribute("board", board);

    }

    @PostMapping("/modify")
    public String modify(RedirectAttributes redirectAttributes, Board board){
        System.out.println("board = " + board);

        boardService.boardUpdate(board);

        redirectAttributes.addFlashAttribute("msg", null);

        return "redirect:/board/list";
    }
}
