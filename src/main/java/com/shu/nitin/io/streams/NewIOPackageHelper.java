package com.shu.nitin.io.streams;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NewIOPackageHelper {

    public void readAllLines(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void readFileByFilesNIOPackage(String filePath) {
        try (InputStream ip = Files.newInputStream(Paths.get(filePath))) {
            printFromInputStream(ip);
        }catch(IOException e) {
            
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
