package com.example.service.impl;

import com.example.mapper.loginMapper;
import com.example.model.po.userPO;
import com.example.model.vo.userVO;
import com.example.service.loginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class loginServiceImpl implements loginService {

    // 将mapper层注入service层
    @Resource
    private loginMapper loginMapper;

    @Override
    public userVO sign(String userID) {
        userPO userPO = loginMapper.sign(userID);
        return new userVO(userPO);
    }

    @Override
    public void login(String userID, String name) {
        loginMapper.login(userID, name);
    }


    public String getUserID(String code) throws IOException {
        String appid = "wx1385ceb7ea19a733";
        String appsecrete = "27935c5142afdf2993894ad2ab272a1d";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid
                + "&secret=" + appsecrete
                + "&js_code=" + code
                + "&grant_type=authorization_code";
        BufferedReader in = null;
        String s = null;
        try{
            URL wechatUrl = new URL(url);
            URLConnection connection = wechatUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=in.readLine())!= null){
                sb.append(line);
            }
            s = sb.toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(in != null) in.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        // 获得openid作为用户的userID
        String pattern = "(\\{session_key:.*,)(openid:)(.*)(})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        return (m.find()) ? m.group(3) : null;
    }

}
