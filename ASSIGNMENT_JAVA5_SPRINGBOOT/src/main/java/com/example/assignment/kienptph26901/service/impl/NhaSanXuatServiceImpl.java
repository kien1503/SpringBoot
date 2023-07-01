package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.NhaSanXuat;
import com.example.assignment.kienptph26901.repository.NhaSanXuatRepository;
import com.example.assignment.kienptph26901.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public Page<NhaSanXuat> getAll(Integer pageNo, Integer size) {
        return nhaSanXuatRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<NhaSanXuat> getNSX() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public NhaSanXuat getOne(UUID id) {
        return nhaSanXuatRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void delete(UUID id) {
        nhaSanXuatRepository.deleteById(id);
    }
}
