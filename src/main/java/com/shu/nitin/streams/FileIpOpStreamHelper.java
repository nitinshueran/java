package com.shu.nitin.streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileIpOpStreamHelper {

    public void readFileByInputStream(String filePath) {

        try (InputStream ip = new FileInputStream(filePath)) {
            printFromInputStream(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileByBufferedIpStream(String filePath) {
        try (InputStream ip = new BufferedInputStream(new FileInputStream(filePath))) {
            printFromInputStream(ip);
        } catch (IOException e) {

        }
    }

    private void printFromInputStream(InputStream ip) throws IOException {
        byte[] buffer = new byte[8];
        int length;
        while ((length = ip.read(buffer)) >= 0) {
            for (int i = 0; i < length; i++) {
                System.out.print((char) buffer[i]);
            }
        }
    }

}
