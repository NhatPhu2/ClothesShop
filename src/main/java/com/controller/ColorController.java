package com.controller;

import com.DTO.ColorDTO;
import com.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/color")
public class ColorController {
    @Autowired
    ColorService colorService;

    @GetMapping
    public ResponseEntity<List<ColorDTO>> getAll(){
        return ResponseEntity.ok(colorService.findAll());
    }

    @PostMapping
    public ResponseEntity<ColorDTO> createColor(@RequestBody ColorDTO colorDTO){
        return ResponseEntity.ok(colorService.create(colorDTO));
    }

    @PutMapping
    public ResponseEntity<ColorDTO> updateColor(@RequestBody ColorDTO colorDTO){
        return ResponseEntity.ok(colorService.create(colorDTO));
    }

    @DeleteMapping
    public ResponseEntity deleteColor(@RequestBody List<Integer> id){
        colorService.remove(id);
        return ResponseEntity.ok().build();
    }
}
