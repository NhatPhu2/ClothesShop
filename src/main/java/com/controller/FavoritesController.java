package com.controller;

import java.util.List;

import com.DTO.FavoriteDTO;
import com.entity.Favorite;
import com.service.FavoriteService;
import com.utils.Convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@RestController
public class FavoritesController {
	
	@Autowired
	private  FavoriteService favoriteService;
	@GetMapping("favorites/all")
	public ResponseEntity<List<FavoriteDTO>> getFavorites(){
		return  ResponseEntity.ok(favoriteService.findAll());
	}
	@PostMapping("favorites")
	public ResponseEntity<?> favorite( @RequestBody CustommerAndProduct cap){
	Favorite favorite = favoriteService.checkInDB(cap.idCustomer, cap.idProduct);
		return ResponseEntity.ok().build();
	}
	
}


@Data
class CustommerAndProduct{
	int idCustomer;
	int idProduct;
}