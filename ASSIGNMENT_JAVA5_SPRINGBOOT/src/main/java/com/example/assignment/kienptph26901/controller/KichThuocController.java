package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.KichThuoc;
import com.example.assignment.kienptph26901.entity.MauSac;
import com.example.assignment.kienptph26901.service.KichThuocService;
import com.example.assignment.kienptph26901.service.MauSacService;
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
@RequestMapping("/kich-thuoc/")
public class KichThuocController {

    @Autowired
    private KichThuocService kichThuocService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("list", kichThuocService.getAll(pageNo, 5));
        return "/mausac/trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        KichThuoc kichThuoc = kichThuocService.getOne(id);
        model.addAttribute("list", kichThuoc);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        kichThuocService.delete(id);
        return "/mausac/trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        KichThuoc kichThuoc = kichThuocService.getOne(id);
        model.addAttribute("list", kichThuoc);
        return "/mausac/update";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten) {
        KichThuoc kichThuoc = KichThuoc.builder()
                .ma(ma)
                .ten(ten)
                .build();
        kichThuocService.saveOrUpdate(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("ma") String ma,
                         @RequestParam("ten") String ten) {
        KichThuoc kichThuoc = KichThuoc.builder()
                .ma(ma)
                .ten(ten)
                .build();
        kichThuocService.saveOrUpdate(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }
}