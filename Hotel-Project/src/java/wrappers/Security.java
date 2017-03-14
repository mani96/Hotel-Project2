/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import java.io.Serializable;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Anirudh
 */
public class Security implements Serializable{

    private static final String ALGORITHM = "AES";
    private final byte[] KEY;

    /**
     * Constructor that allows custom encryption using a sixteen bit text!
     * @param bitSixteenText, Sixteen bit text that will be used as the key for encryption
     */
    public Security(String bitSixteenText) {
        KEY = bitSixteenText.getBytes();
    }

    /**
     * Constructor that just uses the standard encryption key(Already provided) for this project
     */
    public Security() {
        this.KEY = "HotelEncryption1".getBytes();
    }
    
    /**
     * This method encypts the data and gives the encypted text as a return.
     * @param Data, Data to be encrypted.
     * @return Encrypted(Non readable and secure) text
     * @throws Exception, May throw an exception of an unknown source.
     */
    public String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }
    
    /**
     * This method decrypts the data and gives the plain text as a return.
     * @param encryptedData, Encrypted(Non readable and secure) text
     * @return Plain old readable text.
     * @throws Exception, May throw an exception of an unknown source.
     */
    public String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    /***
     * This method generates the Key for the methods in here.
     * @return Key object to be used.
     * @throws Exception, May throw an exception of an unknown source.
     */
    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(KEY, ALGORITHM);
        return key;
    }
    
}
