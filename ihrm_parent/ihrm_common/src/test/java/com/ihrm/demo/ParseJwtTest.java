package com.ihrm.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJwtTest {
    public static void main(String[] args) {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4OCIsInN1YiI6IuWwj-eZvSIsImlhdCI6MTU2MTMwMDQyNSwiY29tcGFueUlkIjoiMTIzNDU2IiwiY29tcGFueU5hbWUiOiLogZTlrabovr4ifQ.Or1bGQ_effW1tqiY4J1TUigrxdJo_WCWkRlcVhbstOk";
        Claims claims = Jwts.parser().setSigningKey("hupa").parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
        String companyId = (String) claims.get("companyId");
        String companyName = (String) claims.get("companyName");
        System.out.println(companyId+"---"+companyName);

    }
}
