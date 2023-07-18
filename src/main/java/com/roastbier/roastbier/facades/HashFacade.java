package com.roastbier.roastbier.facades;

import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFacade {

    public static String gerarHash(String string) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
            m.update(string.getBytes(),0,string.length());
            return new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean compare(String rawString, String encodedString) {
        return gerarHash(rawString).equals(encodedString);
    }
}
