package com.noynoy.domain.user;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by noynoy on 2016. 1. 20..
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @Column(nullable = false)
    private String name;


}
