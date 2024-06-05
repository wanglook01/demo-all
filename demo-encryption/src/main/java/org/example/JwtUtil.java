package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JwtUtil {

    //私钥 生成签名的时候使用的秘钥secret，一般可以从本地配置文件中读取
    private final static String secret = "4heMlRS/CLl717LlQkE2CZiQ+bUIVBajLoW1xZZMZO4=";

    /**
     * 创建jwt
     */
    public static String createJwtToken() {

        // Header
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");


        //Payload
        Map<String, Object> claims = new HashMap<String, Object>();
        //自定义数据，根据业务需要添加
        claims.put("id", "123456");
        claims.put("userName", "admin");
        //标准中注册的声明
        claims.put("iss", "lee");

        //
        SecretKey key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "AES");


        //生成jwt
        return Jwts.builder()
                .header().add(map)         // 添加Header信息
                .and()
                .claims(claims)      // 添加Payload信息
                .id("thisisaid")  //设置jti：是JWT的唯一标识
                .issuedAt(new Date())  // 设置iat: jwt的签发时间
                .expiration(new Date(System.currentTimeMillis() + 120 * 1000))  // 设置exp：jwt过期时间，3600秒=1小时,这里是2分钟
                .subject("Jack")   //设置sub：代表这个jwt所面向的用户
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())  //设置签名：通过签名算法和秘钥生成签名
                .compact();
    }

    /**
     * 从jwt中获取 Payload 信息
     */
    private static Claims getClaimsFromJwt(String jwt) {

        //return new SecretKeySpec(bytes, this.JCA_NAME);


        Claims claims = null;
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret.getBytes(StandardCharsets.UTF_8)).build().parseSignedClaims(jwt);
            claims = claimsJws.getPayload();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    public static void main(String[] args) throws Exception {
        String jwtToken = createJwtToken();
        System.out.println("JWT Token: " + jwtToken);
        System.out.println("=======================================================");

        Claims claims = getClaimsFromJwt(jwtToken);
        System.out.println("claims: " + claims);
        Thread.sleep(1000 * 60 * 3);
        //io.jsonwebtoken.ExpiredJwtException: JWT expired 60951 milliseconds ago at 2024-05-18T10:34:29.000Z. Current time: 2024-05-18T10:35:29.951Z. Allowed clock skew: 0 milliseconds.
        Claims claims2 = getClaimsFromJwt(jwtToken);
        System.out.println("claims: " + claims2);
    }
}