package com.shu.nitin.streams;

public class StreamDemo {

    public static void main(String[] args) {
        String fromFilePath = "src/main/resources/stream.txt";
        String toFilePath = "src/main/resources/to-stream.txt";
        ReaderDemo readerDemo = new ReaderDemo();
        readerDemo.readFileTryCatchFinally(fromFilePath);
        System.out.println();
        readerDemo.readFileTryWithResources(fromFilePath);

        System.out.println();
        readerDemo.readFileTryWithResourcesMulti(fromFilePath, toFilePath);

        System.out.println("AutoClosable demo");
        try (MyAutoClosable myAutoClosable = new MyAutoClosable()) {
            myAutoClosable.doNothing();
            myAutoClosable.doNothingButThrowException();
        } catch (Exception e) {
            System.out.println("Handling exception thrown by either the invoked method or while invoking close method");
        }

    }

}
