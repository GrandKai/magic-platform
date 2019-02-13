package com.magic.platform.encrypt;

import java.security.MessageDigest;

public abstract class DigestMessageEncrypt {
	/**
	 * 信息摘要
	 * 
	 * @param plainText 待做摘要处理的数据
	 * @param method    {MD5,SHA,SHA-256,SHA-384,SHA-512}
	 * @return byte[] 信息摘要
	 * @throws Exception
	 * 
	 */
	public static byte[] encode(String plainText, String method) throws Exception {
		
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance(method);
		
		// 执行消息摘要
		return md.digest(plainText.getBytes());
	}

}
