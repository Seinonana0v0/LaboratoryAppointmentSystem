package hhu.edu.cn.controller;

import hhu.edu.cn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/ajaxShowClassNames")
    public @ResponseBody
    List<String> ajaxShowClassNames(@RequestParam String tea_id){
        System.out.println(tea_id);
        return teacherService.showClassNames(Integer.parseInt(tea_id));
    }
}
