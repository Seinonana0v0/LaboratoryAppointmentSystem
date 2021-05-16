package hhu.edu.cn.controller.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().contains("adminLogin")){
            return true;
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("admin")!=null){
            return true;
        }

        request.getRequestDispatcher("/adminlogin.jsp").forward(request,response);
        return false;
    }
}
