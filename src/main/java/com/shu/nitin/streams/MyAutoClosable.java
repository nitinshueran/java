package com.shu.nitin.streams;

public class MyAutoClosable implements AutoCloseable {

    public void doNothing() {
        System.out.println("I am just printing in MyAutoClosable");
    }

    public void doNothingButThrowException() throws Exception {
        System.out.println("I am just throwing an exception");
        throw new Exception();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Inside autoclosing MyAutoClosable resource");
    }

}
