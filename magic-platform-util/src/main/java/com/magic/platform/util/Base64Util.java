package com.magic.platform.util;

import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

public class Base64Util {

	private Base64Util(){
		super();
		Security.addProvider(new BouncyCastleProvider());
	}

	private static class SingletonHolder{
		private static Base64Util INSTANCE = new Base64Util();
	}

	public static Base64Util getInstance(){
		return SingletonHolder.INSTANCE;
	}

	/**
	 * 將陣列資料編碼為BASE64
	 * @param data byte[]
	 * @return String
	 */
	public String base64Encode(byte[] data){
		//return Base64.encodeBase64String(data);
		return new String(Base64.encode(data));
	}

	/**
	 * 將Base64資料解碼為陣列
	 * @param data String
	 * @return byte[]
	 */
	public byte[] base64Decode(String data){
		//return Base64.decodeBase64(data);
		return Base64.decode(data.getBytes());
	}

}
