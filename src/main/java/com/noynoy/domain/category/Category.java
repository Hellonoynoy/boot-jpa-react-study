package com.noynoy.domain.category;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by noynoy on 2016. 1. 22..
 */
@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
    private String type;
    private int depth   = 1;
    private int parent  = 0;
    private int sort    = 1;

    @Transient
    private List<Category> childCategorys;


}
