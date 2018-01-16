package com.shu.nitin.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderDemo {

    public void readFileTryCatchFinally(String filePath) {
        Reader reader = null;
        try {
            reader = new FileReader(filePath);
            readFromReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public void readFileTryWithResources(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            readFromReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFileTryWithResourcesMulti(String fromFileName, String toFileName) {
        char[] buffer = new char[8];
        int length;
        try (Reader reader = new FileReader(fromFileName); Writer writer = new FileWriter(toFileName)) {
            while ((length = reader.read(buffer)) >= 0) {
                writer.write(buffer, 0, length);
            }
        } catch (IOException e) {

        }
    }

    private void readFromReader(Reader reader) throws IOException {
        char[] buffer = new char[8];
        int length;
        while ((length = reader.read(buffer)) >= 0) {
            for (int i = 0; i < length; i++) {
                System.out.print(buffer[i]);
            }
        }
    }

}
