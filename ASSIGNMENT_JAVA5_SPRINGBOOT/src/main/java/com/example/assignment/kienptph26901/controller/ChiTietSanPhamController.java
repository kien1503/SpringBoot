package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.MauSac;
import com.example.assignment.kienptph26901.service.ChatLieuService;
import com.example.assignment.kienptph26901.service.ChiTietSanPhamService;
import com.example.assignment.kienptph26901.service.DongSanPhamService;
import com.example.assignment.kienptph26901.service.KichThuocService;
import com.example.assignment.kienptph26901.service.MauSacService;
import com.example.assignment.kienptph26901.service.NhaSanXuatService;
import com.example.assignment.kienptph26901.service.SanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chi-tiet-san-pham/")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private ChatLieuService chatLieuService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @Autowired
    private KichThuocService kichThuocService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo,
                          Model model) {
        session.setAttribute("list", chiTietSanPhamService.getAll(pageNo, 5));
        session.setAttribute("listCL", chatLieuService.getCL());
        session.setAttribute("listSP", sanPhamService.getSP());
        session.setAttribute("listNSX", nhaSanXuatService.getNSX());
        session.setAttribute("listDSP", dongSanPhamService.getDongSP());
        session.setAttribute("listKT", kichThuocService.getKT());
        session.setAttribute("listMS", mauSacService.getMS());
        return "/ctsp/trang-chu";
    }

}
