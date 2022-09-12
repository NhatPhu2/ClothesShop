package com.serviceImpl;

import com.DAO.CustomerDAO;
import com.DAO.EmployeeDAO;
import com.DAO.FavoriteDAO;
import com.DAO.ProductDAO;
import com.DTO.FavoriteDTO;
import com.entity.Customer;
import com.entity.Favorite;
import com.entity.Product;
import com.service.FavoriteService;
import com.utils.Convert;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor
@Slf4j
public class FavoriteServiceImpl implements FavoriteService {
	
	private final FavoriteDAO favoriteDAO;
	
	private final CustomerDAO customerDAO;
	
	private final ProductDAO productDAO;
	
	private final Convert convert;
	
    @Override
    public List<FavoriteDTO> findAll() {
    	return favoriteDAO.findAll().stream().map(t -> convert.toDto(t, FavoriteDTO.class) ).collect(Collectors.toList());
    }

    @Override
    public FavoriteDTO findById(Integer id) {
        return null;
    }

    @Override
    public void create(FavoriteDTO FavoriteDto) {

    }

    @Override
    public void update(FavoriteDTO FavoriteDto) {

    }

    @Override
    public void remove(Integer id) {

    }
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Favorite checkInDB(int idCustomer, int idProduct) {
    	Customer c = customerDAO.findById(idCustomer).orElse(null);
    	Product p = productDAO.findById(idProduct).orElse(null);
    	Favorite f = favoriteDAO.findByCustomerAndProduct(p, c);
    	
    	if (f==null) {
    		favoriteDAO.save(new Favorite(null, new Date(), p, c));
    		return f;
    	}
    	else {
    		favoriteDAO.delete(f);
    		return null;
    	}
    
    	
    }
    
    
}
