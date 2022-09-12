package com.serviceImpl;

import com.DAO.CustomerDAO;
import com.DTO.CustomerDTO;
import com.entity.Customer;
import com.service.CustomerService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO customerDao;
    @Autowired
    Convert convert;
    @Override
    public List<CustomerDTO> findAll() {
        return null;
    }

    @Override
    public CustomerDTO findById(Integer id) {
        return null;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public CustomerDTO create(CustomerDTO CustomerDto) {
        Customer newCustomer = convert.toEntity(CustomerDto, Customer.class);
        CustomerDTO customerDTO2 = convert.toDto(customerDao.save(newCustomer), CustomerDTO.class);
        return customerDTO2;
    }

    @Override
    public CustomerDTO update(CustomerDTO CustomerDto) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
