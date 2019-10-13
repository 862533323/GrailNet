package cn.rfh.grailnet.controller;

import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class BaseController {

    protected static final String ACCOUNT="account";
    protected static final String EMAIL="email";
    protected static final String PWD="pwd";
    protected static final String CHECK_PWD="checkPwd";
    protected static final String NAME="name";
    protected static final String PHONE="phone";
    protected static final String AUTO_LOGIN="autoLogin";
    protected static final String VERIFICATION_CODE="verifycode";
    protected static final String ROLES="roles";

    protected static final String TOKEN="Admin-Token";
    protected static final String STATUS="status";
    protected static final String MESSAGE="message";
    public static final String USER_INF="userInf";

    protected static final int STATUS_SUCCESS = 2000,STATUS_FALSE = 4000;
    protected static final String MESSAGE_SUCCESS="success";
    protected static final String STRING_SUCCESS="success";

    protected static final String TOKEN_FAULT = "fault";


    protected static final String ADMIN="admin",USER="user",AVATAR="avatar",ROOT="root";

    protected JSONObject jsonObject;
    protected void rebuildJSONObject(){
        jsonObject=new JSONObject();
    }
}
