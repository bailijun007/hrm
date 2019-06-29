package com.ihrm.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

@Setter
@Getter
@ConfigurationProperties("jwt.config")
public class JwtUtils {
    private String key;
    private long ttl;

    /**
     * 设置token认证
     * @param id 登录用户id
     * @param name 登录用户名
     * @param map
     * @return
     */
    public String createJwt(String id, String name, Map<String,Object>map){
    long now = System.currentTimeMillis();
    long exp=now+ttl;
    JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
            .setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, key);
        jwtBuilder.setClaims(map);
        //设置失效时间
        jwtBuilder.setExpiration(new Date(exp));
    String token = jwtBuilder.compact();
    return token;
}

public  Claims parseJwt(String token){
    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    return claims;
}

}
