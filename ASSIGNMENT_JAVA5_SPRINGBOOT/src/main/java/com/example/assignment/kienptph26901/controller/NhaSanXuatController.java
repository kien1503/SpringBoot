package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.KichThuoc;
import com.example.assignment.kienptph26901.entity.NhaSanXuat;
import com.example.assignment.kienptph26901.service.KichThuocService;
import com.example.assignment.kienptph26901.service.NhaSanXuatService;
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
@RequestMapping("/nha-san-xuat/")
public class NhaSanXuatController {

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("list", nhaSanXuatService.getAll(pageNo, 5));
        return "/nsx/trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getOne(id);
        model.addAttribute("list", nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        nhaSanXuatService.delete(id);
        return "/nsx/trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getOne(id);
        model.addAttribute("list", nhaSanXuat);
        return "/nsx/update";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten) {
        NhaSanXuat nhaSanXuat = NhaSanXuat.builder()
                .ma(ma)
                .ten(ten)
                .build();
        nhaSanXuatService.saveOrUpdate(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("ma") String ma,
                         @RequestParam("ten") String ten) {
        NhaSanXuat nhaSanXuat = NhaSanXuat.builder()
                .ma(ma)
                .ten(ten)
                .build();
        nhaSanXuatService.saveOrUpdate(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }
}