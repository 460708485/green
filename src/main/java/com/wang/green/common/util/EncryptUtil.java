package com.wang.green.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EncryptUtil {


	private static Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

	public static final String apikeyStr = ""; // 转化为公钥的字符串

	public static final String secretStr = ""; // 转化为私钥的字符串

	private static String strkey = "p12mm345";
	
	private static final byte[] AES_PASSWORD = "Aes#$%(2017)06".getBytes();

	private static byte[] deskey = strkey.getBytes();
	
	private static final String GENDER_MALE = "1";
	
	private static final String GENDER_FEMALE = "2";
	
	private static final String GENDER_UNKNOWN = "3";

	/**
	 * <li>加密 ,生成效验串</li> <li>(将传过来的参数字符串转化为加密后的 字符串sig)</li>
	 * 
	 * @author 
	 * @param map
	 *            参数数组,参数名称作为key ，参数值作为value
	 * @return 返回加密后的字符串
	 */
	public static String encodeStr(Map<Object, Object> map) {
		String source = "";
		if (map != null && map.size() > 0) {
			// 获取参数集合的key 集合
			Set<Object> key = map.keySet();
			Object[] keys = (Object[]) key.toArray();
			Arrays.sort(keys);
			// 拼接字符串，格式为：param1=val1param2=val2param3=val3....
			for (int i = 0; i < keys.length; i++) {
				source += keys[i] + "=" + map.get(keys[i]);
			}
			// 拼接上经过md5加密的私钥
			source += "secret=" + md5(secretStr);
		}
		// 将获取的参数与私钥拼接的字符串进行MD5加密返回
		return md5(source);
	}

	/***************************************************************************
	 * MD5 加密
	 * 
	 * @param source
	 *            加密源文件
	 * @return 加密后的字符串
	 */
	public static String md5(String source) {
		StringBuffer sb = new StringBuffer();
		String part = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String str = source + "12ps3ads";
			byte[] bytes = str.getBytes();
			byte[] md5 = md.digest(bytes);
			for (int i = 0; i < md5.length; i++) {
				part = Integer.toHexString(md5[i] & 0xFF);
				if (part.length() == 1) {
					part = "0" + part;
				}
				sb.append(part);
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}

		return sb.toString();
	}

	public static byte[] desEncrypt(byte[] plainText) throws Exception {
		SecureRandom sr = new SecureRandom();
		byte rawKeyData[] = deskey;
		DESKeySpec dks = new DESKeySpec(rawKeyData);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key, sr);
		byte data[] = plainText;
		byte encryptedData[] = cipher.doFinal(data);
		return encryptedData;
	}

	public static byte[] desDecrypt(byte[] encryptText) throws Exception {
		SecureRandom sr = new SecureRandom();
		byte rawKeyData[] = deskey;
		DESKeySpec dks = new DESKeySpec(rawKeyData);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key, sr);
		byte encryptedData[] = encryptText;
		byte decryptedData[] = cipher.doFinal(encryptedData);
		return decryptedData;
	}
	
	public static String encrypt(String input) throws Exception {
		return AESEncrypter.encrypt(input, AES_PASSWORD);
	}
	
	public static String decrypt(String input) throws Exception {
		return AESEncrypter.decrypt(input, AES_PASSWORD);
	}
	
	/**
	 * 用于生成相对url安全的加密串
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static String encryptUrlSafe(String input) throws Exception {
		String encryptStr = AESEncrypter.encrypt(input, AES_PASSWORD);
		return Base64.encodeBase64URLSafeString(encryptStr.getBytes());
	}
	
	/**
	 * 解密相对url安全的加密串
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static String decryptUrlSafe(String input) throws Exception {
		byte[] decodeStr = Base64.decodeBase64(input);
		return AESEncrypter.decrypt(new String(decodeStr), AES_PASSWORD);
	}

	public static String base64Encode(byte[] s) {
		if (s == null)
			return null;
		return Base64.encodeBase64String(s);
	}

	public static byte[] base64Decode(String s) throws IOException {
		if (s == null)
			return null;
		byte[] b = Base64.decodeBase64(s);
		return b;
	}
	
	public static String maskOtherIdNum(String val){
		
		return val;
	}

	/**
	 * 姓名掩码
	 * @param name
	 * @return
	 */
	public static String maskName(String name){
		if (org.apache.commons.lang3.StringUtils.isBlank(name) || name.length() < 2){
			throw new IllegalArgumentException("invalid name");
		}
		return maskLeft(name,"*",2,1);
	}

	/**
	 * 手机号掩码
	 * @param mobile
	 * @return
	 */
	public static String maskMobile(String mobile){
		if (StringUtils.isBlank(mobile) || mobile.length() != 11){
			throw new IllegalArgumentException("invalid mobile");
		}
		return maskMiddle(mobile,3,4,"*");
	}

	/**
	 * 身份证号掩码
	 * @param idcard
	 * @return
	 */
	public static String maskIdcard(String idcard){
		if (StringUtils.isBlank(idcard) && (idcard.length() != 15 || idcard.length() != 18)){
			throw new IllegalArgumentException("invalid idcard");
		}
		return maskMiddle(idcard,4,2,"*");
	}

	/**
	 * 单向hase加密
	 * @param str
	 * @return
	 */
	public static String hashEncrypt(String str){
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			str = "9a9f4eb6d0036a16" + str + "4588b6ee74390442";
			byte[] bt = md.digest(str.getBytes("utf-8"));
			result = javax.xml.bind.DatatypeConverter.printHexBinary(bt).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			logger.error("nosush algorithm exception:",e);
		}catch (UnsupportedEncodingException e) {
			logger.error("unsupported encoding exception:",e);
		}
		return result;
	}

	/**
	 * 根据身份证获取性别
	 * @param idcard
	 * @return
	 */
	public static String getGenderCode(String idcard){
		char gender = 3;
		if (StringUtils.isBlank(idcard) && (idcard.length() != 15 || idcard.length() != 18)){
			throw new IllegalArgumentException("invalid idcard");
		}else if(idcard.length()==15){
			gender =idcard.charAt(14);
		}else if(idcard.length()==18){
			gender =idcard.charAt(16);
		}else{
			return GENDER_UNKNOWN;
		}
		if((gender & 1)==0){
			return GENDER_FEMALE;
		}
		return GENDER_MALE;
	}

	/**
	 * 字符串左边掩码处理
	 * @param str
	 * @param maskChar 掩码字符
	 * @param maskCount 掩码个数，为-1时，自动按字符长度补充掩码
	 * @param rightPos
	 * @return
	 */
	public static String maskLeft(String str,String maskChar,int maskCount,int rightPos){
		if (StringUtils.isBlank(str)){
			throw new IllegalArgumentException("invalid string");
		}
		int length = str.length() - rightPos;
		if(maskCount == -1){
			maskCount = length;
		}
		return StringUtils.repeat(maskChar,maskCount).concat(str.substring(length));
	}

	/**
	 * 字符串 中间掩码处理
	 * @param str
	 * @param prefixLen 前缀明文长度
	 * @param suffixLen 后缀明文长度
	 * @param maskChar  掩码字符
	 * @return
	 */
	public static String maskMiddle(String str, int prefixLen, int suffixLen, String maskChar){
		if (StringUtils.isBlank(str)){
			throw new IllegalArgumentException("invalid string");
		}
		int len = str.length();
		String prefixStr = str.substring(0,prefixLen);
		String midStr = StringUtils.mid(str,prefixLen,len-(prefixLen + suffixLen));
		String suffixStr = str.substring(len - suffixLen);
		return prefixStr.concat(StringUtils.repeat(maskChar,midStr.length())).concat(suffixStr);
	}


}
