package com.shu.nit.overriding.e3;

import java.util.ArrayList;
import java.util.List;

public class TestExample3 {
    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("Nitin");
        names.add("Ritu");
        Parent p = new Child(names);
        List<String> ou = (List<String>) p.getNames();
        for (String str : ou) {
            System.out.println(str);
        }

        Parent p2 = new Child2("Child 2");

        System.out.println(p2.getNames());
    }
}
