package com.noynoy.domain.menu;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by noynoy on 2016. 1. 22..
 */
@Data
@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int parent = 1;

    @Column(nullable = false)
    private int depth = 1;

    @Column(nullable = false)
    private int sort = 1;

    private String useYN;
    private String url;
    private String role;
    private String icon;


}
