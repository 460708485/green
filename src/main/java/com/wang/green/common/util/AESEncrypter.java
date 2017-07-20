package com.wang.green.common.util;

import org.apache.commons.codec.binary.Base64;

import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;


public class AESEncrypter {
	public static byte[] iv = new byte[] { 82, 22, 50, 44, -16, 124, -40, -114,
			-87, -40, 37, 23, -56, 23, -33, 75 };

	private AESEncrypter() {
	}

	/**
	 * AES加密
	 * @param plainSource
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String plainSource, byte[] password)
			throws Exception {
		return  Base64.encodeBase64String(encrypt(plainSource.getBytes(), password));
	}

	/**
	 * AES加密
	 * @param plainSource
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] plainSource, byte[] password)
			throws Exception {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );     
            secureRandom.setSeed(password);     
            kgen.init(128, secureRandom);  
            
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			SecretKey key = kgen.generateKey();
			Cipher ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			return ecipher.doFinal(plainSource);
		} catch (Exception ex) {
			throw new Exception("AES:"+ex.getMessage());
		}
	}

	/**
	 * AES解密
	 * @param encryptSource
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encryptSource, byte[] password)
			throws Exception {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );     
            secureRandom.setSeed(password);     
            kgen.init(128, secureRandom);  
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			SecretKey key = kgen.generateKey();
			Cipher dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			return dcipher.doFinal(encryptSource);
		} catch (Exception ex) {
			throw new Exception("AES:"+ex.getMessage());
		}
	}

	/**
	 * AES解密
	 * @param encryptBase64Source
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String encryptBase64Source, byte[] password)
			throws Exception {
		return new String(decrypt(new Base64().decode(encryptBase64Source),password));
	}
	
}
