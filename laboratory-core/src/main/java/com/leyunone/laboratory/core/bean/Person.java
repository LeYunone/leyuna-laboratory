package com.leyunone.laboratory.core.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leyunone
 * @date 2022-04-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String id;

    private String name;

    private int age;

    public Person(int age){
        this.age=age;
    }
}
