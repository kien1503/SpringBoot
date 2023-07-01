package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.DongSanPham;
import com.example.assignment.kienptph26901.entity.MauSac;
import com.example.assignment.kienptph26901.service.DongSanPhamService;
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
@RequestMapping("/dong-san-pham/")
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("list", dongSanPhamService.getAll(pageNo, 5));
        return "/mausac/trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        DongSanPham dongSanPham = dongSanPhamService.getOne(id);
        model.addAttribute("list", dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        dongSanPhamService.delete(id);
        return "/mausac/trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        DongSanPham dongSanPham = dongSanPhamService.getOne(id);
        model.addAttribute("list", dongSanPham);
        return "/mausac/update";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten) {
        DongSanPham dongSanPham = DongSanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        dongSanPhamService.saveOrUpdate(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("ma") String ma,
                         @RequestParam("ten") String ten) {
        DongSanPham dongSanPham = DongSanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        dongSanPhamService.saveOrUpdate(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }
}