package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.dto.CategoryDTO;
import com.alejandroct.taskerdone.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<CategoryDTO>> listByProjectId(@PathVariable long id){
        return ResponseEntity.ok(this.categoryService.listByProjectId(id));
    }

    @PostMapping("/create-multiple")
    public ResponseEntity<List<CategoryDTO>> createMultipleCategory(@RequestBody List<CategoryDTO> categoryDTOList){
        return new ResponseEntity<>(this.categoryService.createMultiple(categoryDTOList), HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(this.categoryService.create(categoryDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id){
        return ResponseEntity.ok(this.categoryService.delete(id));
    }

}
