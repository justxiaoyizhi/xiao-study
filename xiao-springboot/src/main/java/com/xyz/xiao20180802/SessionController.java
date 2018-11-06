//package com.xyz.xiao20180802;
//
//import org.springframework.session.ExpiringSession;
//import org.springframework.session.FindByIndexNameSessionRepository;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.Collection;
//
//@RestController
//public class SessionController {
//
//    private static final String SESSION_PREFIX = "gw_login";
//
//    @Resource
//    private FindByIndexNameSessionRepository<? extends ExpiringSession> sessions;
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(HttpServletRequest request, Integer userId) {
//        HttpSession session = request.getSession();
//
//        session.setAttribute(SESSION_PREFIX, userId);
//        session.setAttribute(FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, "gw_login:" + userId);
//
//        return "login ok!";
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String delete(HttpServletRequest request, Integer userId) {
//
//        Collection<? extends ExpiringSession> usersSessions = sessions.findByIndexNameAndIndexValue(
//                FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, "gw_login:" + userId).values();
//
//        for (ExpiringSession usersSession : usersSessions) {
//            String sessionId = usersSession.getId();
//            sessions.delete(sessionId);
//        }
//
//        return "delete ok!";
//    }
//
//
//    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
//    public Object sessions(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//
//        Object attribute = session.getAttribute(SESSION_PREFIX);
//
//        return attribute;
//    }
//
//}
