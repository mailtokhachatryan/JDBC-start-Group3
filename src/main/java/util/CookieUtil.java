package util;

import util.constants.Parameter;

import javax.servlet.http.Cookie;
import java.util.Arrays;

public class CookieUtil {

    public static Cookie getCookieByName(Cookie[] cookies) {
        return Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(Parameter.REMEMBER_COOKIE))
                .findFirst()
                .orElse(null);
    }

    public static void updateCookie(Cookie[] cookies,String value) {
        Cookie cookie1 = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(Parameter.REMEMBER_COOKIE))
                .findFirst()
                .orElse(null);
        if(cookie1!=null) {
            cookie1.setMaxAge(360000);
            cookie1.setValue(value);
        }


    }

}
