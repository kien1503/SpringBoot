package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.ChatLieu;
import com.example.assignment.kienptph26901.entity.ChucVu;
import com.example.assignment.kienptph26901.service.ChatLieuService;
import com.example.assignment.kienptph26901.service.ChucVuService;
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
@RequestMapping("/chuc-vu/")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("list", chucVuService.getAll(pageNo, 5));
        return "/chucvu/trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        ChucVu chucVu = chucVuService.getOne(id);
        model.addAttribute("list", chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        chucVuService.delete(id);
        return "/chucvu/trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        ChucVu chucVu = chucVuService.getOne(id);
        model.addAttribute("list", chucVu);
        return "/chucvu/update";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten) {
        ChucVu chucVu = ChucVu.builder()
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.saveOrUpdate(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("ma") String ma,
                         @RequestParam("ten") String ten) {
        ChucVu chucVu = ChucVu.builder()
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.saveOrUpdate(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
}