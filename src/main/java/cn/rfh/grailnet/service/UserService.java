package cn.rfh.grailnet.service;

import cn.rfh.grailnet.dao.UserDao;
import cn.rfh.grailnet.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User findUserById(long id){
        return userDao.findUserById(id);
    }
    public User findUserByName(String name){
        return userDao.findUserByName(name);
    }

    public void logout(User user){
        if (user.getAutoLogin()){
            user.setAutoLogin(false);
        }
        userDao.save(user);
    }
    public User findUserByPhone(String phone){
        return userDao.findUserByPhone(phone);
    }
    public void saveUser(User user){
        user.setPwd(passwordEncode(user.getPwd()));
        userDao.save(user);
    }

    public User login(String account,String pwd){
        User user;
        user=userDao.findUserByAccount(account);
        if (user!=null){
            if (user.getPwd().equals(passwordEncode(pwd))){
                return user;
            }
        }
        return null;
    }


    String passwordEncode(String password){
        return JWT.create().withClaim("password",password)//withAudience()存入需要保存在token的信息
                .sign(Algorithm.HMAC256(password));
    }
    static final String password="password";
    static final String uid="uid",time="time";
    public String getToken(User user) {
        String temp_str="";
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        temp_str=sdf.format(dt);
        String token="";
        String id=String.valueOf(user.getId());
        token= JWT.create().withClaim(uid,id)//withAudience()存入需要保存在token的信息
                .withClaim(time,temp_str)
                .sign(Algorithm.HMAC256(password));//Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端
        System.out.println("[Get token]:  "+token);
        return token;
    }
    public Integer getUserId(String token){
        DecodedJWT jwt = deToken(token);
        return Integer.parseInt(jwt.getClaim(uid).asString());
    }

    public String getTime(String token){
        DecodedJWT jwt = deToken(token);
        return jwt.getClaim(time).asString();
    }

    DecodedJWT deToken(final String token) {
        DecodedJWT jwt = null;
        try {
            // 使用了HMAC256加密算法。
            // mysecret是用来加密数字签名的密钥。
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(password))
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            exception.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jwt;
    }
}
