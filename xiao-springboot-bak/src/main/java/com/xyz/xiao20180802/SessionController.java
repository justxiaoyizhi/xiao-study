package com.xyz.xiao20180802;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    public static final String SESSION_PREFIX = "gw_login";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Integer userId) {
        HttpSession session = request.getSession();

        session.setAttribute(SESSION_PREFIX, userId);

        return "ok";
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public Object sessions(HttpServletRequest request) {
        HttpSession session = request.getSession();

        Object attribute = session.getAttribute(SESSION_PREFIX);

        return attribute;
    }

}
