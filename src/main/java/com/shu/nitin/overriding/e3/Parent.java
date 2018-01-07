package com.shu.nitin.overriding.e3;

import java.util.ArrayList;

public class Parent {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNames() {
        return new ArrayList<String>();
    }

}
