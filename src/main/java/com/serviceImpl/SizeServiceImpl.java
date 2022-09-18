package com.serviceImpl;

import com.DAO.SizeDAO;
import com.DTO.SizeDTO;
import com.entity.Size;
import com.service.SizeService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeDAO sizeDAO;

    @Autowired
    Convert convert;
    @Override
    public List<SizeDTO> findAll() {
        List <Size> sizes = sizeDao.findAll();
        List <SizeDTO> sizeDTOs =  sizes.stream().map(size -> convert.toDto( size, SizeDTO.class))
                .collect(Collectors.toList());
        return sizeDTOs;
    }

    @Override
    public SizeDTO findById(Integer id) {
        return convert.toDto(sizeDAO.findById(id).get(),SizeDTO.class);
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public SizeDTO create(SizeDTO SizeDto) {
        return convert.toDto(sizeDao.save(convert.toEntity(SizeDto, Size.class)), SizeDTO.class);
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public SizeDTO update(SizeDTO SizeDto) {
        return convert.toDto(sizeDao.save(convert.toEntity(SizeDto, Size.class)), SizeDTO.class);
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void remove(List<Integer> id) {
        sizeDao.deleteAllById(id);
    }
}
