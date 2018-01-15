package com.shu.nitin.streams.bytes.input;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayInputStreamDemo {

    public static void main(String[] args) {
        byte[] buffer = new byte[32];
        InputStream inputStream = new ByteArrayInputStream(buffer);
    }

}
