package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> listByProjectId(long id);

    List<CategoryDTO> createMultiple(List<CategoryDTO> categoryDTOList);

    CategoryDTO create(CategoryDTO categoryDTO);

    String delete(long id);
}
