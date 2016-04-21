package com.es.example.model;

import lombok.Data;

/**
 * Created by maomao on 2015/12/23.
 */
@Data
public class Medicine {

    private Integer id;
    private String name;
    private String function;

    public Medicine() {
    }

    public Medicine(Integer id, String name, String function) {
        this.id = id;
        this.name = name;
        this.function = function;
    }
}
