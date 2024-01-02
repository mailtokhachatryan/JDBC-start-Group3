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

}
