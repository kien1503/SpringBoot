package com.example.assignment.kienptph26901.controller;

import com.example.assignment.kienptph26901.entity.CuaHang;
import com.example.assignment.kienptph26901.entity.NhanVien;
import com.example.assignment.kienptph26901.service.ChucVuService;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private HttpSession session;

    @GetMapping("hien-thi")
    public String viewAll(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {
        session.setAttribute("listNV", nhanVienService.getAll(pageNo, 5));
        session.setAttribute("listCV", chucVuService.getCV());
        session.setAttribute("listCH", cuaHangService.getCH());
        return "trang-chu";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        NhanVien nhanVien = nhanVienService.getOne(id);
        model.addAttribute("listNV", nhanVien);
        return "detail";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        nhanVienService.delete(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        NhanVien nhanVien = nhanVienService.getOne(id);
        model.addAttribute("listNV", nhanVien);
        session.setAttribute("listCV", chucVuService.getCV());
        session.setAttribute("listCH", cuaHangService.getCH());
        model.addAttribute("cuaHang", nhanVien.getCuaHang());
        model.addAttribute("chucVu", nhanVien.getChucVu());
        model.addAttribute("ns", new SimpleDateFormat("yyyy-MM-dd").format(nhanVien.getNgaySinh()));
        return "update";
    }

    @PostMapping("add")
    public String add(@RequestParam("maNV") String maNV,
                      @RequestParam("maCH") String maCH,
                      @RequestParam("maCV") String maCV,
                      @RequestParam("ten") String ten,
                      @RequestParam("tenDem") String tenDem,
                      @RequestParam("ho") String ho,
                      @RequestParam("gioiTinh") String gioiTinh,
                      @RequestParam("ngaySinh") String ngaySinh,
                      @RequestParam("trangThai") String trangThai) throws ParseException {
        UUID maCuaHang = UUID.fromString(maCH);
        UUID maChucVu = UUID.fromString(maCV);
        NhanVien nhanVien = NhanVien.builder()
                .ma(maNV)
                .cuaHang(cuaHangService.getOne(maCuaHang))
                .chucVu(chucVuService.getOne(maChucVu))
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .gioiTinh(Integer.valueOf(gioiTinh))
                .ngaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh))
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.saveOrUpdate(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("update")
    public String update(@RequestParam("id") String id,
                         @RequestParam("maNV") String maNV,
                         @RequestParam("maCH") String maCH,
                         @RequestParam("maCV") String maCV,
                         @RequestParam("ten") String ten,
                         @RequestParam("tenDem") String tenDem,
                         @RequestParam("ho") String ho,
                         @RequestParam("gioiTinh") String gioiTinh,
                         @RequestParam("ngaySinh") String ngaySinh,
                         @RequestParam("trangThai") String trangThai) throws ParseException {
        NhanVien nhanVien = NhanVien.builder()
                .id(UUID.fromString(id))
                .ma(maNV)
                .cuaHang(cuaHangService.getOne(UUID.fromString(maCH)))
                .chucVu(chucVuService.getOne(UUID.fromString(maCV)))
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .gioiTinh(Integer.valueOf(gioiTinh))
                .ngaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh))
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.saveOrUpdate(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
