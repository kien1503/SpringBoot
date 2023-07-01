package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.ChatLieu;
import com.example.assignment.kienptph26901.service.ChatLieuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/chat-lieu/")
public class ChatLieuController {

    @Autowired
    private ChatLieuService chatLieuService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("list", chatLieuService.getAll(pageNo, 5));
        return "/chat-lieu/trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        ChatLieu chatLieu = chatLieuService.getOne(id);
        model.addAttribute("list", chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        chatLieuService.delete(id);
        return "/chat-lieu/trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        ChatLieu chatLieu = chatLieuService.getOne(id);
        model.addAttribute("list", chatLieu);
        return "/chat-lieu/update";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                        @RequestParam("ten") String ten) {
        ChatLieu chatLieu = ChatLieu.builder()
                .ma(ma)
                .ten(ten)
                .build();
        chatLieuService.saveOrUpdate(chatLieu);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("ma") String ma,
                           @RequestParam("ten") String ten) {
        ChatLieu chatLieu = ChatLieu.builder()
                .ma(ma)
                .ten(ten)
                .build();
        chatLieuService.saveOrUpdate(chatLieu);
        return "redirect:/san-pham/hien-thi";
    }
}