package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.NhanVien;
import com.example.assignment.kienptph26901.repository.NhanVienRepository;
import com.example.assignment.kienptph26901.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> getAll(Integer pageNo, Integer size) {
        return nhanVienRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<NhanVien> getNV() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nhanVienRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }
}
