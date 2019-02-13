package com.magic.platform.util;


import com.magic.platform.encrypt.DigestMessageEncrypt;
import com.magic.platform.encrypt.enumeration.DigestMessageType;

public class DigestMessageUtil {

	public static DigestMessageUtil getInstance(){
		return SingletonHolder.instance;
	}
	
	private static class SingletonHolder{
		private static final DigestMessageUtil instance = new DigestMessageUtil();
	}
	
	private DigestMessageUtil(){
		super();
	}
	
	public String encodeWithBASE64(String plainText, DigestMessageType type) throws Exception{
		
		if(null == plainText || "".equals(plainText)){
			return null;
		}
		
		byte[] bytes = DigestMessageEncrypt.encode(plainText, type.getName());
		if(bytes == null|| bytes.length<=0){
			return null;
		}
		return Base64Util.getInstance().base64Encode(bytes);
	}
	
	public String encodeWithHex(String plainText, DigestMessageType type) throws Exception{
		
		if(null == plainText || "".equals(plainText)){
			return null;
		}
		
		byte[] bytes = DigestMessageEncrypt.encode(plainText, type.getName());
		if(bytes == null|| bytes.length<=0){
			return null;
		}
		return bytesToHexString(bytes);
	}
	
	private static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
	
}
