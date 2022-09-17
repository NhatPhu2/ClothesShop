package com.serviceImpl;

import com.DAO.SizeDAO;
import com.DTO.SizeDTO;
import com.service.SizeService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeDAO sizeDAO;

    @Autowired
    Convert convert;
    @Override
    public List<SizeDTO> findAll() {
        return null;
    }

    @Override
    public SizeDTO findById(Integer id) {
        return convert.toDto(sizeDAO.findById(id).get(),SizeDTO.class);
    }

    @Override
    public void create(SizeDTO SizeDto) {

    }

    @Override
    public void update(SizeDTO SizeDto) {

    }

    @Override
    public void remove(Integer id) {

    }
}
