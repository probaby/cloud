package com.example.inputstream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class Demo {
    final static byte[] keyBytes = { 0x11, 0x22, 0x4F, 0x58,

            (byte) 0x88, 0x10, 0x40, 0x38, 0x28, 0x25, 0x79, 0x51,

            (byte) 0xCB, (byte) 0xDD, 0x55, 0x66

    };

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        InputStream in = new FileInputStream("D:\\one\\c.txt");
        encrypt(in);
        InputStream inB = new FileInputStream("D:\\one" +
                "\\a.txt");
        decrypt(inB);
    }

    //加密
    public static void encrypt(InputStream in) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException{
        int len = -1;
        byte[] buffer = new byte[512 * 1024 - 16];
        Cipher ci = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        ci.init(Cipher.ENCRYPT_MODE, key);
        CipherInputStream fastin = new CipherInputStream(in, ci);
        OutputStream ou = new FileOutputStream("D:\\one\\a.txt");
        CipherOutputStream outDemo = new CipherOutputStream(ou,ci);
        while ((len = in.read(buffer)) != -1) {
            outDemo.write(buffer, 0, len);
            outDemo.flush();
        }
        outDemo.close();
    }

    public static void decrypt(InputStream in) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException{
        Cipher ci = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        byte[] buffer = new byte[512 * 1024 - 16];
        ci.init(Cipher.DECRYPT_MODE, key);
        CipherInputStream fastin = new CipherInputStream(in, ci);
        OutputStream outDemo = new FileOutputStream("D:\\one\\b.txt");
        int length;
        while ((length = fastin.read(buffer)) != -1) {
            outDemo.write(buffer, 0, length);
            outDemo.flush();
        }
        outDemo.close();
    }
}
