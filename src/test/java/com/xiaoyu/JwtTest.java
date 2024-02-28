package com.xiaoyu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/19/17:33
 * @Description:
 */
public class JwtTest {
    @Test
    public void testGen(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        //生成jwt代码
        String token=JWT.create()
                .withClaim("user",claims)//添加荷载
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*120))//添加过期时间
                .sign(Algorithm.HMAC256("xiaoyu"));//指定算法，配置秘钥
        System.out.println(token);
    }
    @Test
    public void testParse(){
        //定义字符串，模拟用户传递过来的token
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
                "eyJleHAiOjE3MDk1MzA2NzksInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19." +
                "nY_RR4nN29b6Yp-e8WbM2XLQnbJwFHgiH5uqO22qlZ0";
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256("xiaoyu")).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);//验证token，生成一个解析后的Jwt对象
        Map<String, Claim> claims=decodedJWT.getClaims();
        System.out.println(claims.get("user" ));


    }
}
