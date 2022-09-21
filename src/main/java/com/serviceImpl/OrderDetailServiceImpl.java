package com.serviceImpl;

import com.DAO.OrderDetailDAO;
import com.DTO.OrderDetailDTO;
import com.entity.OrderDetail;
import com.entity.ReportBestSellingProduct;
import com.service.OrderDetailService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Autowired
    Convert convert;
    @Override
    public List<OrderDetailDTO> findAll() {
        return null;
    }

    @Override
    public OrderDetailDTO findById(Integer id) {
        return null;
    }

    @Override
    public OrderDetailDTO create(OrderDetailDTO orderDetailDto) {
        OrderDetail orderDetail = convert.toEntity(orderDetailDto,OrderDetail.class);
        OrderDetailDTO orderDetailDTO = convert.toDto(orderDetailDAO.save(orderDetail),OrderDetailDTO.class);
        return orderDetailDTO;
    }

    @Override
    public List<ReportBestSellingProduct> reportBestSellingProducts(Integer fromYear,
                                                                    Integer toYear,
                                                                    Integer month){
        return orderDetailDAO.reportBestSellingOfProduct(fromYear,toYear,month);
    }

    @Override
    public void update(OrderDetailDTO OrderDetailDto) {

    }

    @Override
    public void remove(Integer id) {

    }
}
