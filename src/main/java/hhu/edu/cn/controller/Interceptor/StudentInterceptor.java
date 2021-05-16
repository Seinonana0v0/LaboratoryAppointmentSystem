package hhu.edu.cn.controller.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().contains("studentLogin")){
            return true;
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("student")!=null){
            return true;
        }

        request.getRequestDispatcher("/studentlogin.jsp").forward(request,response);
        return false;
    }
}
