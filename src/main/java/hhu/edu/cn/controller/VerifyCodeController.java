package hhu.edu.cn.controller;

import hhu.edu.cn.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


@Controller
@RequestMapping("/verifyCodeController")
public class VerifyCodeController {
    @RequestMapping(value="verifyCode")
    public void verifyCode(Model model, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("img/jpeg");
        try {
            OutputStream outputStream=response.getOutputStream();
            int w = 100, h = 40;
            String code = VerifyCodeUtils.generateVerifyCode(4);
            request.getSession().setAttribute("code",code);
            VerifyCodeUtils.outputImage(w, h, outputStream, code);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
