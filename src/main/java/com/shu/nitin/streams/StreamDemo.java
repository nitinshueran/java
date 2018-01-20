package com.shu.nitin.streams;

public class StreamDemo {

    public static void main(String[] args) {
        String fromFilePath = "src/main/resources/stream.txt";
        String toFilePath = "src/main/resources/to-stream.txt";
        FileReaderWriterHelper fileReaderWriterHelper = new FileReaderWriterHelper();
        System.out.print("Reading file using try-catch finally block, Output: ");
        fileReaderWriterHelper.readFileTryCatchFinally(fromFilePath);
        System.out.println();

        System.out.print("Reading file using try with resources, Output:");
        fileReaderWriterHelper.readFileTryWithResources(fromFilePath);
        System.out.println();

        fileReaderWriterHelper.readFileTryWithResourcesMulti(fromFilePath, toFilePath);
        System.out.println("Read file: " + fromFilePath + ", written to file: " + toFilePath);

        System.out.print("Buffered reader and writer example, Output: ");
        fileReaderWriterHelper.readFileUsingBufferedReader(fromFilePath);
        System.out.println();

        System.out.print("Read file using InputStream, output: ");
        FileIpOpStreamHelper fileIpOpHelper = new FileIpOpStreamHelper();
        fileIpOpHelper.readFileByInputStream(fromFilePath);
        System.out.println();

        System.out.print("Read file using new IO package classes, Output: ");
        NewIOPackageHelper newIOPackageHelper = new NewIOPackageHelper();
        newIOPackageHelper.readFileByFilesNIOPackage(fromFilePath);
        System.out.println();

        System.out.print("Read all line by using helper methods of new IO package, Output: ");
        newIOPackageHelper.readAllLines(fromFilePath);
        System.out.println();

        System.out.println("AutoClosable demo");
        try (MyAutoClosable myAutoClosable = new MyAutoClosable()) {
            myAutoClosable.doNothingButThrowException();
        } catch (Exception e) {
            System.out.println("Handling exception thrown by either the invoked method or while invoking close method");
        }

    }

}
