package com.shu.nit.overriding.java8.spring;

public class SpringDIDemo {

    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        Shape triangle = new Triangle();
        triangle.draw();

        Drawing circleDrwaing = new Drawing();
        circleDrwaing.setShape(circle);

        Drawing triangleDrwaing = new Drawing();
        triangleDrwaing.setShape(circle);
    }

}
