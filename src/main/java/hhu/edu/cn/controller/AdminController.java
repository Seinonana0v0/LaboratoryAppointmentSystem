package hhu.edu.cn.controller;

import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import hhu.edu.cn.domain.Admin;
import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.StuAppointment;
import hhu.edu.cn.domain.TeaAppointment;
import hhu.edu.cn.service.AdminService;
import hhu.edu.cn.service.StuAppointmentService;
import hhu.edu.cn.service.StudentService;
import hhu.edu.cn.service.TeaAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StuAppointmentService stuAppointmentService;
    @Autowired
    private TeaAppointmentService teaAppointmentService;
    @Autowired
    private StudentService studentService;


    /**
     * 管理员登陆
     * @param admin_name
     * @param admin_password
     * @param verifycode
     * @param request
     * @param session
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(String admin_name, String admin_password, String verifycode, HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        Admin loginAdmin = new Admin();
        loginAdmin.setAdmin_name(admin_name);
        loginAdmin.setAdmin_password(admin_password);
        Admin admin = adminService.adminLogin(loginAdmin);
        String code = (String) session.getAttribute("code");
        if(admin!=null&&code.equalsIgnoreCase(verifycode)){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String lastLoginTime = sf.format(new Date());
            session.setAttribute("lastLoginTime",lastLoginTime);
            session.setAttribute("admin",admin);
            return "adminmain";
        }else if(!code.equalsIgnoreCase(verifycode)){
            request.setAttribute("msg","验证码错误");
            return "adminlogin";
        }else{
            request.setAttribute("msg","账号或密码错误");
            return "adminlogin";
        }
    }


    /**
     * 查询学生预约记录
     * @param page
     * @param size
     * @param dataTable
     * @param id
     * @param appoint_date
     * @return
     */
    @RequestMapping("/findByCondition_Stu")
    public ModelAndView findByCondition_Stu(@RequestParam(name="page",required = true,defaultValue = "1") int page,
                                            @RequestParam(name = "size",defaultValue = "5") int size,
                                            @RequestParam(name = "dataTable",defaultValue = "laboratory_stu1") String dataTable,
                                            @RequestParam(name = "id",required = false,defaultValue = "0") int id,
                                            @RequestParam(name = "appoint_date",required = false) String appoint_date)  {
        ModelAndView mv = new ModelAndView();

        //封装查询条件
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Condition condition = new Condition();
        condition.setDataTable(dataTable);
        condition.setId(id);
        if(appoint_date==null){
            condition.setAppoint_date(null);
        }else{
            try {
                condition.setAppoint_date(format.parse(appoint_date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //将条件查询参数处理后存入request域
        mv.addObject("condition",condition);
        switch (condition.getDataTable()){
            case "laboratory_stu1" :mv.addObject("condition_dataTable","学生实验室一");break;
            case "laboratory_stu2" :mv.addObject("condition_dataTable","学生实验室二");break;
            case "laboratory_stu3" :mv.addObject("condition_dataTable","学生实验室三");break;
            case "laboratory_stu4" :mv.addObject("condition_dataTable","学生实验室四");break;
            case "laboratory_stu5" :mv.addObject("condition_dataTable","学生实验室五");break;
        }

        if(condition.getId()==0){
            mv.addObject("condition_id","未选择");
        }else{
            mv.addObject("condition_id",condition.getId());
        }

        if(condition.getAppoint_date()==null){
            mv.addObject("condition_appointDate","未选择");
        }else {
            String condition_formatDate = format.format(condition.getAppoint_date());
            mv.addObject("condition_appointDate",condition_formatDate);
        }

        //获取查询结果
        List<StuAppointment> stuAppointmentList = stuAppointmentService.findByCondition_Stu(condition, page, size);

        for (StuAppointment stuAppointment : stuAppointmentList) {
            System.out.println(stuAppointment);
            //设置格式化日期
            String formatDate = format.format(stuAppointment.getAppoint_date());
            stuAppointment.setFormatDate(formatDate);

            //如果超时且状态不为以上报,修改状态为未上报
            if((stuAppointment.getAppoint_date().getTime()+86400000)<new Date().getTime()&&!stuAppointment.getStatus().equals("已上报"))
            {
                System.out.println(dataTable);
                stuAppointmentService.setStatusNotReport(dataTable,stuAppointment.getId());
                stuAppointment.setStatus("未上报");
            }
        }

        //将分页后结果存入request域
        PageInfo pageInfo = new PageInfo(stuAppointmentList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("studentappointment");

        return mv;
    }

    @RequestMapping("/findByCondition_Tea")
    public ModelAndView findByCondition_Tea(@RequestParam(name="page",required = true,defaultValue = "1") int page,
                                            @RequestParam(name = "size",defaultValue = "5") int size,
                                            @RequestParam(name = "dataTable",defaultValue = "laboratory_tea1") String dataTable,
                                            @RequestParam(name = "id",required = false,defaultValue = "0") int id,
                                            @RequestParam(name = "appoint_date",required = false) String appoint_date){
        ModelAndView mv = new ModelAndView();

        //封装查询条件
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Condition condition = new Condition();
        condition.setDataTable(dataTable);
        condition.setId(id);
        if(appoint_date==null){
            condition.setAppoint_date(null);
        }else{
            try {
                condition.setAppoint_date(format.parse(appoint_date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //将条件查询参数处理后存入request域
        mv.addObject("condition",condition);
        switch (condition.getDataTable()){
            case "laboratory_tea1" :mv.addObject("condition_dataTable","上课实验室一");break;
            case "laboratory_tea2" :mv.addObject("condition_dataTable","上课实验室二");break;
            case "laboratory_tea3" :mv.addObject("condition_dataTable","上课实验室三");break;
            case "laboratory_tea4" :mv.addObject("condition_dataTable","上课实验室四");break;
            case "laboratory_tea5" :mv.addObject("condition_dataTable","上课实验室五");break;
        }

        if(condition.getId()==0){
            mv.addObject("condition_id","未选择");
        }else{
            mv.addObject("condition_id",condition.getId());
        }

        if(condition.getAppoint_date()==null){
            mv.addObject("condition_appointDate","未选择");
        }else {
            String condition_formatDate = format.format(condition.getAppoint_date());
            mv.addObject("condition_appointDate",condition_formatDate);
        }

        List<TeaAppointment> teaAppointmentList = teaAppointmentService.findByCondition_Tea(condition, page, size);

        for (TeaAppointment teaAppointment : teaAppointmentList) {
            System.out.println(teaAppointment);
            //设置格式化日期
            String formatDate = format.format(teaAppointment.getAppoint_date());
            teaAppointment.setFormatDate(formatDate);

        }

        PageInfo pageInfo = new PageInfo(teaAppointmentList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("teacherappointment");
        return mv;

    }

    @RequestMapping("/resetStudentPassword")
    public ModelAndView resetStudentPassword(@RequestParam(name="id",required = true,defaultValue = "0") int id){
        ModelAndView mv = new ModelAndView();
        int i = studentService.ResetStuPassword(id);
        if(i==0){
            mv.addObject("msg","输入学生学号不存在");
        }else {
            mv.addObject("msg","重置成功");
        }
        mv.setViewName("resetstudentpassword");
        return mv;
    }

    @RequestMapping("/adminLogout")
    public String adminLogout(HttpSession session){
        session.invalidate();

        return "adminlogin";
    }
}

