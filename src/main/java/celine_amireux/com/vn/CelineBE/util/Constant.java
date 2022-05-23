package celine_amireux.com.vn.CelineBE.util;

public class Constant {
    public static final String SESSION_USERNAME = "username";
    public static final String COOKIE_REMEMBER = "username";

    public static class Path {
        public static final String LOGIN = "/view/client/view/login.jsp";
        public static final String REGISTER = "/view/client/view/register.jsp";
        public static final String HOME = "/view/client/view/index.jsp";
        public static final String DASHBOARD = "/view/admin/view/login.jsp";

    }
    public static String GOOGLE_CLIENT_ID = "244932279445-jrl3r41jt8ci3on7mkbnm1bbg4bjvse4.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/AccessGoogle/login-google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
