package com.example.storeeverything.data;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Category {
    String name;
    public Category(String s){
        name=s;
    }
}
