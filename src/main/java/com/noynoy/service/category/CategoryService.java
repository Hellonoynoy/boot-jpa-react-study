package com.noynoy.service.category;

import com.noynoy.domain.category.Category;
import com.noynoy.domain.category.CategoryForm;
import com.noynoy.repository.category.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by noynoy on 2016. 6. 4..
 */
@Service
@Slf4j
public class CategoryService {

    @Autowired private CategoryRepository categoryRepository;

    public List<Category> findAll() {

        final int defaultDepth  = 1;

        List<Category> categorys = categoryRepository.findByDepthOrderBySortAsc(defaultDepth);


        /**
         *
         * JPA 재귀호출 관련하여 refactoring >>
         *
         * 서브쿼리로 count 추출하여 돌리는것도 방법이긴 하나 추후로 ㅋ
         *
         */
        categorys.forEach(category -> {

            if (getChildCountByCategory(category) != 0) {
                category.setChildCategorys(categoryRecursion(category, defaultDepth));
            }

        });

        return categorys;
    }

    public List<Category> findByDepth(int depth) {
        return categoryRepository.findByDepthOrderBySortAsc(depth);
    }

    @Transactional
    public Category save(CategoryForm categoryForm) {

        try {

            Category category = new Category();
            category.setName(categoryForm.getName());

            if(!categoryForm.getParent().equals("top")) {
                category.setParent(Integer.valueOf(categoryForm.getParent()));
            }

            if(category.getParent() != 0) {
                category.setDepth(categoryRepository.findOne(category.getParent()).getDepth() + 1);
            }

            category.setSort(categoryRepository.findMaxSort(category.getParent()));

            categoryRepository.save(category);
            return category;
        } catch(Exception e) {
            log.debug("category save error {}", e.getMessage());
            return null;
        }

    }

    @Transactional
    public Category edit(CategoryForm categoryForm) {
        try {

            Category category = categoryRepository.findOne(Integer.parseInt(categoryForm.getId()));
            category.setName(categoryForm.getName());
            categoryRepository.save(category);
            return category;
        } catch(Exception e) {
            log.debug("category edit error {}", e.getMessage());
            return null;
        }
    }

    @Transactional
    public int delete(int id) {
        try {
            categoryRepository.delete(id);
            return id;
        } catch(Exception e) {
            log.debug("category delete error {}", e.getMessage());
            return 0;
        }
    }

    private List<Category> categoryRecursion(Category category, int depth) {

        List<Category> resultList   = new ArrayList();
        List<Category> categorys = categoryRepository.findByIdNotAndParent(category.getId(), category.getId());

        categorys.forEach( sub -> {

//            log.info(" sub category name {}", sub.getName());

            if(getChildCountByCategory(sub) != 0) {
                sub.setChildCategorys(categoryRecursion(sub, depth));
            }

            resultList.add(sub);

        });

        return resultList;
    }

    private int getChildCountByCategory(Category category) {
        return categoryRepository.countByParent(category.getId());
    }

}
