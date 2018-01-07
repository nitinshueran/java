package com.shu.nitin.overriding.e3;

import java.util.List;

public class Child extends Parent {

    private List<String> names;

    public Child() {
        // TODO Auto-generated constructor stub
    }

    public Child(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

}
