package com.controller;

import com.DTO.SizeDTO;
import com.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/size")
public class SizeController {
    @Autowired
    SizeService sizeService;

    @GetMapping
    public ResponseEntity<List<SizeDTO>> getAll(){
        return ResponseEntity.ok(sizeService.findAll());
    }

    @PostMapping
    public ResponseEntity<SizeDTO> createSize(@RequestBody SizeDTO size){
        return ResponseEntity.ok(sizeService.create(size));
    }

    @PutMapping
    public ResponseEntity<SizeDTO> updateSize(@RequestBody SizeDTO size){
        return ResponseEntity.ok(sizeService.update(size));
    }

    @DeleteMapping
    public ResponseEntity removeSize(@RequestBody List<Integer> id){
        sizeService.remove(id);
        return ResponseEntity.ok().build();
    }
}
