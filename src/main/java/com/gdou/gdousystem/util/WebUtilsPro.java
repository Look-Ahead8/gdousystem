package com.gdou.gdousystem.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Meng
 * @date 2019/12/23
 */
public class WebUtilsPro {
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }
}
