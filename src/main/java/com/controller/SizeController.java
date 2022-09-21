package com.controller;

import com.DTO.SizeDTO;
import com.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class SizeController {
    @Autowired
    SizeService sizeService;

    @GetMapping("sizes")
    public ResponseEntity<List<SizeDTO>> getAll(){
        return ResponseEntity.ok(sizeService.findAll());
    }

    @PostMapping("sizes")
    public ResponseEntity<SizeDTO> createSize(@Valid @RequestBody SizeDTO size){
        return ResponseEntity.ok(sizeService.create(size));
    }

    @PutMapping("sizes")
    public ResponseEntity<SizeDTO> updateSize(@Valid @RequestBody SizeDTO size){
        return ResponseEntity.ok(sizeService.update(size));
    }

    @DeleteMapping("sizes")
    public ResponseEntity removeSize(@RequestBody List<Integer> id){
        sizeService.remove(id);
        return ResponseEntity.ok().build();
    }
}
