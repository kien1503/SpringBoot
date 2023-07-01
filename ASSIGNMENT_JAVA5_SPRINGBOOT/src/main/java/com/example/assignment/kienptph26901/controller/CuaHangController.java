package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.CuaHang;
import com.example.assignment.kienptph26901.service.CuaHangService;
import com.example.assignment.kienptph26901.service.NhanVienService;
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
@RequestMapping("/cua-hang/")
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        session.setAttribute("list", cuaHangService.getAll(pageNo, 5));
        session.setAttribute("listNV", nhanVienService.getNV());
        return "trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        CuaHang cuaHang = cuaHangService.getOne(id);
        model.addAttribute("list", cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        cuaHangService.delete(id);
        return "trang-chu";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        CuaHang cuaHang = cuaHangService.getOne(id);
        model.addAttribute("list", cuaHang);
        return "/cuahang/update";
    }

    @PostMapping("add")
    public String add(@RequestParam("ma") String ma,
                      @RequestParam("ten") String ten,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("thanhPho") String thanhPho,
                      @RequestParam("quocGia") String quocGia) {
        CuaHang cuaHang = CuaHang.builder()
                .ma(ma)
                .ten(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        cuaHangService.saveOrUpdate(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("ma") String ma,
                         @RequestParam("ten") String ten,
                         @RequestParam("diaChi") String diaChi,
                         @RequestParam("thanhPho") String thanhPho,
                         @RequestParam("quocGia") String quocGia) {
        CuaHang cuaHang = CuaHang.builder()
                .ma(ma)
                .ten(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        cuaHangService.saveOrUpdate(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
}