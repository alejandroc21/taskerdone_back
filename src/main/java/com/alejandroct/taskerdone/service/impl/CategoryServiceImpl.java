package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.dto.CategoryDTO;
import com.alejandroct.taskerdone.mapper.Mappers;
import com.alejandroct.taskerdone.model.Category;
import com.alejandroct.taskerdone.repository.CategoryRepository;
import com.alejandroct.taskerdone.service.ICategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDTO findById(long id){
        Optional<Category> optional = this.categoryRepository.findById(id);
        if(optional.isEmpty()){
            throw new EntityNotFoundException("category not found");
        }
        return Mappers.getCategoryDTO(optional.get());
    }

    @Override
    public List<CategoryDTO> listByProjectId(long id) {
        return this.categoryRepository.findByProjectId(id).stream().map(Mappers::getCategoryDTO).toList();
    }

    @Override
    public List<CategoryDTO> createMultiple(List<CategoryDTO> categoryDTOList) {
        List<Category> categories = categoryDTOList.stream().map(Mappers::getCategory).toList();
        List<Category> saved = (List<Category>) this.categoryRepository.saveAll(categories);
        return saved.stream().map(Mappers::getCategoryDTO).toList();
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return Mappers.getCategoryDTO(this.categoryRepository.save(Mappers.getCategory(categoryDTO)));
    }

    @Override
    public String delete(long id) {
        this.findById(id);
        this.categoryRepository.deleteById(id);
        return "deleted";
    }
}
