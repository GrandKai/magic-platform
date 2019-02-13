package com.magic.platform.core.jwt;

import com.magic.platform.core.exception.CustomException;
import com.magic.platform.core.exception.ExceptionEnum;
import com.magic.platform.util.UUIDUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.DefaultClaims;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * @Author: zhangyn
 * @Description:
 * @Date: Created in 2018-05-15 13:13
 * @Modified By:
 */

@Slf4j
public class Token {

  private static final Base64.Decoder decoder = Base64.getDecoder();
  private static final Base64.Encoder encoder = Base64.getEncoder();

  private static final PrivateKey ACCESS_TOKEN_PRIVATE_KEY;
  private static final PublicKey ACCESS_TOKEN_PUBLIC_KEY;


  private static final PrivateKey REFRESH_TOKEN_PRIVATE_KEY;
  private static final PublicKey REFRESH_TOKEN_PUBLIC_KEY;

  static {

    // 运行环境 - 使用如下配置
    ACCESS_TOKEN_PRIVATE_KEY = loadPrivateKey("jwt/access_token_private_key.pem");
    ACCESS_TOKEN_PUBLIC_KEY = loadPublicKey("jwt/access_token_public_key.pem");

    REFRESH_TOKEN_PRIVATE_KEY = loadPrivateKey("jwt/refresh_token_private_key.pem");
    REFRESH_TOKEN_PUBLIC_KEY = loadPublicKey("jwt/refresh_token_public_key.pem");

  }

  /**
   * 加载资源文件
   *
   * @param filePath 资源文件路径
   * @return 资源文件中的文本内容
   */
  private static String loadKey(String filePath) {

    StringBuilder sb = new StringBuilder();

    InputStream inputStream = Token.class.getClassLoader().getResourceAsStream(filePath);

    InputStreamReader reader = new InputStreamReader(inputStream);

    BufferedReader bufferedReader = new BufferedReader(reader);

    try {
      String str;
      while ((str = bufferedReader.readLine()) != null) {
        sb.append(str).append("\r\n");
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        bufferedReader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return sb.toString();
  }

  /**
   * 加载私钥
   *
   * @param filePath 私钥路径
   * @return 私钥信息
   */
  private static PrivateKey loadPrivateKey(String filePath) {
    return getPrivateKey(loadKey(filePath));
  }


  /**
   * 加载公钥
   *
   * @param filePath 公钥文件路径
   */
  private static PublicKey loadPublicKey(String filePath) {
    return getPublicKey(loadKey(filePath));
  }

  /**
   * 生成私钥
   *
   * @param privateKeyContent 私钥文本内容
   * @return 私钥信息
   */
  private static PrivateKey getPrivateKey(String privateKeyContent) {
    String realPrivateKey = privateKeyContent.replaceAll("-----END PRIVATE KEY-----", "")
        .replaceAll("-----BEGIN PRIVATE KEY-----", "")
        .replaceAll("-----END RSA PRIVATE KEY-----", "")
        .replaceAll("-----BEGIN RSA PRIVATE KEY-----", "")
        .replaceAll("\r\n", "");

    byte[] encodedKey = decoder.decode(realPrivateKey);

    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);

    PrivateKey jwtPrivateKey = null;
    try {
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      jwtPrivateKey = keyFactory.generatePrivate(keySpec);

    } catch (NoSuchAlgorithmException e) {
      throw new CustomException(e);
    } catch (InvalidKeySpecException e) {
      throw new CustomException(e);
    }

    return jwtPrivateKey;
  }


  /**
   * 生成公钥
   *
   * @param publicKeyContent 私钥文本内容
   * @return 私钥信息
   */
  private static PublicKey getPublicKey(String publicKeyContent) {
    String realPublicKey = publicKeyContent.replaceAll("-----BEGIN PUBLIC KEY-----", "")
        .replaceAll("-----END PUBLIC KEY-----", "")
        .replaceAll("-----END RSA PUBLIC KEY-----", "")
        .replaceAll("-----BEGIN RSA PUBLIC KEY-----", "")
        .replaceAll("\r\n", "");

    byte[] encodedKey = decoder.decode(realPublicKey);

    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedKey);

    PublicKey jwtPublicKey = null;
    try {
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      jwtPublicKey = keyFactory.generatePublic(keySpec);

    } catch (NoSuchAlgorithmException e) {
      throw new CustomException(e);
    } catch (InvalidKeySpecException e) {
      throw new CustomException(e);
    }

    return jwtPublicKey;
  }

  /*************************** 以下方法用户生成 token 开始*****************************/

  /**
   * @param claims 声明信息
   * @param expiration 过期时间，单位秒（s）
   * @return jwt
   */
  private static String generateToken(Claims claims, Integer expiration, Key key) {
    long nowMillis = System.currentTimeMillis();

    Claims defaultClaims = new DefaultClaims();

    defaultClaims.setId(UUIDUtils.uuid())
        .setIssuer("zhangyn")
        .setIssuedAt(new Date(nowMillis));

    if (expiration != null && expiration > 0) {
      defaultClaims.setExpiration(new Date(nowMillis + expiration * 1000));
    }

    if (claims != null) {
      defaultClaims.putAll(claims);
    }

    JwtBuilder builder = Jwts.builder();
    builder.setHeaderParam("typ", "JWT");
    builder.setClaims(defaultClaims);

    if (key != null) {
      builder.signWith(SignatureAlgorithm.RS256, key);
    }

    return builder.compact();
  }

  /**
   * 生成 jwt accessToken
   *
   * @param claims 声明信息
   * @param expiration 过期时间
   * @return jwt
   */
  public static String generateAccessToken(Claims claims, Integer expiration) {
    return generateToken(claims, expiration, ACCESS_TOKEN_PRIVATE_KEY);
  }

  /**
   * 生成 jwt refreshToken
   *
   * @param claims 声明信息
   * @param expiration 过期时间
   * @return jwt
   */
  public static String generateRefreshToken(Claims claims, Integer expiration) {
    return generateToken(claims, expiration, REFRESH_TOKEN_PRIVATE_KEY);
  }

   /**
   * 生成 jwt refreshToken
   *
   * 不设置过期时间
   * @param claims 声明信息
   * @return jwt
   */
  public static String generateRefreshToken(Claims claims) {
    return generateToken(claims, null, REFRESH_TOKEN_PRIVATE_KEY);
  }

  /*************************** 以下方法用户生成 token 结束 *****************************/


  /**
   * 解析并验证 jwt AccessToken
   * @param accessToken
   * @return
   */
  public static Claims parseAccessToken2Claims(String accessToken) {

    if (StringUtils.isEmpty(accessToken)) {
      throw ExceptionEnum.ACCESS_TOKEN_NOT_NULL.getException();
    }

    Jws<Claims> jws = null;
    try {
      jws = Jwts.parser().setSigningKey(ACCESS_TOKEN_PUBLIC_KEY).parseClaimsJws(accessToken);
    } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException ex) {
      log.error("token无效: ", ex);
      throw ExceptionEnum.ACCESS_TOKEN_INVALID.getException();

    } catch (ExpiredJwtException ex) {
      log.error("token过期: ", ex);
      throw ExceptionEnum.ACCESS_TOKEN_EXPIRED.getException();
    }

    if (jws == null) {
      throw ExceptionEnum.ACCESS_TOKEN_PARSED_EXCEPTION.getException();
    }


/*
    String sign = jwtToken.substring(jwtToken.lastIndexOf(".") + 1);
    if (StringUtils.isEmpty(sign)) {
      throw CustomSystemExceptionConst.ACCESS_TOKEN_INVALID_SIGN.getException();
    }
    if (!jwt.getSignature().equals(sign)) {
      throw CustomSystemExceptionConst.ACCESS_TOKEN_INTERPOLATED.getException();
    }
*/

    return jws.getBody();
  }

  /**
   * 解析并验证 jwt refreshToken
   * @param refreshToken
   * @return
   */
  public static Claims parseRefreshToken2Claims(String refreshToken) {

    if (StringUtils.isEmpty(refreshToken)) {
      throw ExceptionEnum.REFRESH_TOKEN_NOT_NULL.getException();
    }

    Jws<Claims> jws = null;
    try {
      jws = Jwts.parser().setSigningKey(REFRESH_TOKEN_PUBLIC_KEY).parseClaimsJws(refreshToken);
    } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException ex) {
      log.error("token无效: ", ex);
      throw ExceptionEnum.REFRESH_TOKEN_INVALID.getException();

    } catch (ExpiredJwtException ex) {
      log.error("token过期: ", ex);
      throw ExceptionEnum.REFRESH_TOKEN_EXPIRED.getException();
    }

    if (jws == null) {
      throw ExceptionEnum.REFRESH_TOKEN_PARSED_EXCEPTION.getException();
    }


/*
    String sign = jwtToken.substring(jwtToken.lastIndexOf(".") + 1);
    if (StringUtils.isEmpty(sign)) {
      throw CustomSystemExceptionConst.REFRESH_TOKEN_INVALID_SIGN.getException();
    }
    if (!jwt.getSignature().equals(sign)) {
      throw CustomSystemExceptionConst.REFRESH_TOKEN_INTERPOLATED.getException();
    }
*/

    return jws.getBody();
  }


  /**
   * 验证 accessToken
   * @param accessToken
   * @return
   */
  public static boolean verifyAccessToken(String accessToken) {

    if (StringUtils.isEmpty(accessToken)) {
      throw ExceptionEnum.ACCESS_TOKEN_NOT_NULL.getException();
    }

    Jws<Claims> jwt = null;
    try {
      jwt = Jwts.parser().setSigningKey(ACCESS_TOKEN_PUBLIC_KEY).parseClaimsJws(accessToken);
    } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException ex) {
      log.error("token无效: {}", ex);
      throw ExceptionEnum.ACCESS_TOKEN_INVALID.getException();

    } catch (ExpiredJwtException ex) {
      log.error("token过期: {}", ex);
      throw ExceptionEnum.ACCESS_TOKEN_EXPIRED.getException();
    }

    if (jwt == null) {
      throw ExceptionEnum.ACCESS_TOKEN_PARSED_EXCEPTION.getException();
    }

    // FIXME: 思考信息篡改
/*    String sign = jwtToken.substring(jwtToken.lastIndexOf("."));
    if (StringUtils.isEmpty(sign)) {
      throw CustomSystemExceptionConst.ACCESS_TOKEN_INVALID_SIGN.getException();
    }
    if (!jwt.getSignature().equals(sign)) {
      throw CustomSystemExceptionConst.ACCESS_TOKEN_INTERPOLATED.getException();
    }*/

    return true;
  }


  /**
   * 验证 refreshToken
   * @param refreshToken
   * @return
   */
  public static boolean verifyRefreshToken(String refreshToken) {

    if (StringUtils.isEmpty(refreshToken)) {
      throw ExceptionEnum.REFRESH_TOKEN_NOT_NULL.getException();
    }

    Jws<Claims> jwt = null;
    try {
      jwt = Jwts.parser().setSigningKey(REFRESH_TOKEN_PUBLIC_KEY).parseClaimsJws(refreshToken);
    } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException ex) {
      log.error("token无效: {}", ex);
      throw ExceptionEnum.REFRESH_TOKEN_INVALID.getException();

    } catch (ExpiredJwtException ex) {
      log.error("token过期: {}", ex);
      throw ExceptionEnum.REFRESH_TOKEN_EXPIRED.getException();
    }

    if (jwt == null) {
      throw ExceptionEnum.REFRESH_TOKEN_PARSED_EXCEPTION.getException();
    }

    // FIXME: 思考信息篡改
/*    String sign = jwtToken.substring(jwtToken.lastIndexOf("."));
    if (StringUtils.isEmpty(sign)) {
      throw CustomSystemExceptionConst.REFRESH_TOKEN_INVALID_SIGN.getException();
    }
    if (!jwt.getSignature().equals(sign)) {
      throw CustomSystemExceptionConst.REFRESH_TOKEN_INTERPOLATED.getException();
    }*/

    return true;
  }

}
