package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.SanPham;
import com.example.assignment.kienptph26901.service.SanPhamService;
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
@RequestMapping("/san-pham/")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("listSP", sanPhamService.getAll(pageNo, 5));
        return "/san-pham/trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detailSP(@PathVariable("id") UUID id, Model model) {
        SanPham sanPham = sanPhamService.getOne(id);
        model.addAttribute("listSP", sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeSP(@PathVariable("id") UUID id) {
        sanPhamService.delete(id);
        return "/san-pham/trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateSP(@PathVariable("id") UUID id, Model model) {
        SanPham sanPham = sanPhamService.getOne(id);
        model.addAttribute("listSP", sanPham);
        return "/san-pham/update";
    }

    @PostMapping("add")
    public String addSP(@RequestParam("ma") String ma,
                        @RequestParam("ten") String ten) {
        SanPham sanPham = SanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.saveOrUpdate(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("update")
    public String updateSP(@RequestParam("ma") String ma,
                           @RequestParam("ten") String ten) {
        SanPham sanPham = SanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.saveOrUpdate(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}