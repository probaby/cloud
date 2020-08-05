package com.example.inputstream;

//import org.bouncycastle.crypto.CryptoException;
//
//import javax.crypto.*;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.*;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//
//import static org.apache.activemq.transport.stomp.Stomp.Headers.TRANSFORMATION;
//import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

/**
 * @author huangbiaof
 * @data 创建时间：2019/5/27 19:00
 */

public class EncryptAESDemo {

//    public static void main(final String[] args) {
//
////        final EncryptAESDemo cip = new EncryptAESDemo();
////        cip.runExperiments();
//
//
//        String key = "Mary has one cat1";
//        File inputFile = new File("document.txt");
//        File encryptedFile = new File("document.encrypted");
//        File decryptedFile = new File("document.decrypted");
//
//        try {
//            encrypt(key, inputFile, encryptedFile);
//            decrypt(key, encryptedFile, decryptedFile);
//        } catch (CryptoException ex) {
//            System.out.println(ex.getMessage());
//            ex.printStackTrace();
//        }
//
//    }
//
//
//    public static void encrypt(String key, File inputFile, File outputFile)
//            throws CryptoException {
//        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
//    }
//
//    public static void decrypt(String key, File inputFile, File outputFile)
//            throws CryptoException {
//        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
//    }
//
//    private static void doCrypto(int cipherMode, String key, File inputFile,
//                                 File outputFile) throws CryptoException {
//        try {
//            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
//            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
//            cipher.init(cipherMode, secretKey);
//
//            FileInputStream inputStream = new FileInputStream(inputFile);
//            byte[] inputBytes = new byte[(int) inputFile.length()];
//            inputStream.read(inputBytes);
//
//            byte[] outputBytes = cipher.doFinal(inputBytes);
//
//            FileOutputStream outputStream = new FileOutputStream(outputFile);
//            outputStream.write(outputBytes);
//
//            inputStream.close();
//            outputStream.close();
//
//        } catch (NoSuchPaddingException | NoSuchAlgorithmException
//                | InvalidKeyException | BadPaddingException
//                | IllegalBlockSizeException | IOException ex) {
//            throw new CryptoException("");
//        }
//    }
//
//    private void runExperiments() {
//
//        CipherOutputStream output = null;
//        CipherInputStream input = null;
//        FileOutputStream fileOutput = null;
//        FileInputStream fileInput = null;
//
//        try {
//
//            fileOutput = new FileOutputStream("CipherOutput.txt");
//            fileInput = new FileInputStream("CipherOutput.txt");
//
//            final KeyGenerator kg = KeyGenerator.getInstance("AES");
//            kg.init(new SecureRandom(new byte[]{1, 2, 3}));
//            final SecretKey key = kg.generateKey();
//
//            final Cipher c = Cipher.getInstance("AES");
//            c.init(Cipher.ENCRYPT_MODE, key);
//            output = new CipherOutputStream(fileOutput, c);
//
//            final PrintWriter pw = new PrintWriter(output);
//            pw.println("Cipher Streams are working correctly.");
//            pw.flush();
//            pw.close();
//
//
//
//            final KeyGenerator kg2 = KeyGenerator.getInstance("AES");
//            kg2.init(new SecureRandom(new byte[]{1, 2, 3}));
//            final SecretKey key2 = kg2.generateKey();
//
//            final Cipher c2 = Cipher.getInstance("AES");
//            c2.init(Cipher.DECRYPT_MODE, key2);
//            input = new CipherInputStream(fileInput, c2);
//
//            final InputStreamReader r = new InputStreamReader(input);
//            final BufferedReader reader = new BufferedReader(r);
//            final String line = reader.readLine();
//            System.out.println("Line : " + line);
//
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("Specified Algorithm does not exist");
//        } catch (NoSuchPaddingException e) {
//            System.out.println("Specified Padding does not exist");
//        } catch (FileNotFoundException e) {
//            System.out.println("Could not find specified file to read / write to");
//        } catch (InvalidKeyException e) {
//            System.out.println("Specified key is invalid");
//        } catch (IOException e) {
//            System.out.println("IOException from BufferedReader when reading file");
//        } finally {
//            try {
//                if (fileInput != null) {
//                    fileInput.close();
//                }
//                if (fileOutput != null) {
//                    fileOutput.flush();
//                    fileOutput.close();
//                }
//                if (output != null) {
//                    output.flush();
//                    output.close();
//                }
//                if (input != null) {
//                    input.close();
//                }
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
