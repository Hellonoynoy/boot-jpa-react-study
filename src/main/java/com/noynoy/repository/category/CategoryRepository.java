package com.noynoy.repository.category;

import com.noynoy.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by noynoy on 2016. 1. 22..
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    List<Category> findByDepthOrderBySortAsc(int depth);

    List<Category> findByDepthAndParentOrderBySortAsc(int depth, int parent);

    List<Category> findByIdNotAndParent(@Param("id") int id,
                                        @Param("parent") int parent);

    @Query("select count(c) from Category c where c.id <> :parent and c.parent = :parent")
    Integer countByParent(@Param("parent") int parent);

    @Query("select ifnull(max(c.sort),0) + 1 from Category c where c.parent = :parent")
    Integer findMaxSort(@Param("parent") int parent);
}
