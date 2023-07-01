package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.ChucVu;
import com.example.assignment.kienptph26901.entity.MauSac;
import com.example.assignment.kienptph26901.service.ChucVuService;
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
@RequestMapping("/mau-sac/")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("list", mauSacService.getAll(pageNo, 5));
        return "/mausac/trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        MauSac mauSac = mauSacService.getOne(id);
        model.addAttribute("list", mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        mauSacService.delete(id);
        return "/mausac/trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        MauSac mauSac = mauSacService.getOne(id);
        model.addAttribute("list", mauSac);
        return "/mausac/update";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten) {
        MauSac mauSac = MauSac.builder()
                .ma(ma)
                .ten(ten)
                .build();
        mauSacService.saveOrUpdate(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("ma") String ma,
                         @RequestParam("ten") String ten) {
        MauSac mauSac = MauSac.builder()
                .ma(ma)
                .ten(ten)
                .build();
        mauSacService.saveOrUpdate(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}