package hhu.edu.cn.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import hhu.edu.cn.domain.*;
import hhu.edu.cn.service.StuAppointmentService;
import hhu.edu.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StuAppointmentService stuAppointmentService;

    @RequestMapping(value = "/studentLogin", method = RequestMethod.POST)
    public String studentLogin(int id, String stu_password, String verifycode, HttpServletRequest request, HttpSession session) {
        Student loginStudent = new Student();
        loginStudent.setId(id);
        loginStudent.setStu_password(stu_password);
        Student student = studentService.studentLogin(loginStudent);
        String code = (String) session.getAttribute("code");
        if (student != null && code.equalsIgnoreCase(verifycode)) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String lastLoginTime = sf.format(new Date());
            session.setAttribute("lastLoginTime", lastLoginTime);
            session.setAttribute("student", student);
            return "studentmain";
        } else if (!code.equalsIgnoreCase(verifycode)) {
            request.setAttribute("msg", "验证码错误");
            return "studentlogin";
        } else {
            request.setAttribute("msg", "学号或密码错误");
            return "studentlogin";
        }
    }


    @RequestMapping("/ajaxTestAppointment")
    public @ResponseBody
    AjaxResponse ajaxTestAppointment(@RequestBody StuAjaxCondition stuAjaxCondition) throws ParseException {
        AjaxResponse ajaxResponse = new AjaxResponse();
        //默认设置为true,0,false
        ajaxResponse.setRightDate(true);
        ajaxResponse.setCount(0);
        ajaxResponse.setAlreadyAppoint(false);
        System.out.println(stuAjaxCondition);
        //判断预约日期是否正确
        //如果没选择日期
        if (stuAjaxCondition.getAppoint_date().equals("") || stuAjaxCondition.getAppoint_date() == null) {
            ajaxResponse.setRightDate(false);
            System.out.println(ajaxResponse);
            return ajaxResponse;
        } else {//选择了日期
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            //如果日期不正确
            if (sf.parse(stuAjaxCondition.getAppoint_date()).getTime() < new Date().getTime()) {
                ajaxResponse.setRightDate(false);
                System.out.println(ajaxResponse);
                return ajaxResponse;

            } else { //如果日期正确
                //没有选择了时间段
                if (stuAjaxCondition.getAppoint_time().equals("noSelect")) {
                    System.out.println(ajaxResponse);
                    return ajaxResponse;
                }else {
                    for(int i=1;i<=5;i++){
                        //查询每个表的预约信息
                        List<StuAppointment> list = stuAppointmentService.findCountByDateAndTime("laboratory_stu"+i, stuAjaxCondition.getAppoint_date(), stuAjaxCondition.getAppoint_time());
                        //存入已预约人数
                        ajaxResponse.setCount(list.size());
                        //如果人数不为0,判断是否预约
                        if (list.size() != 0) {
                            for (StuAppointment stuAppointment : list) {
                                System.out.println(stuAppointment);
                                if (stuAppointment.getStu_id() == stuAjaxCondition.getStu_id()) {
                                    ajaxResponse.setAlreadyAppoint(true);
                                }
                            }
                        }
                    }
                    System.out.println(ajaxResponse);
                    return ajaxResponse;
                }
            }
        }
    }

    /**
     * 新增预约
     * @param stu_id
     * @param dataTable
     * @param appoint_date
     * @param appoint_time
     * @return
     */
    @RequestMapping("/addNewStudentAppointment")
    public ModelAndView addNewStudentAppointment(int stu_id,String dataTable,String appoint_date,String appoint_time){
        ModelAndView mv = new ModelAndView();
        stuAppointmentService.addNewStuAppointment(dataTable,stu_id,appoint_date,appoint_time);
        mv.addObject("msg","预约成功");
        mv.setViewName("addnewstudentappointment");
        return mv;

    }

    @RequestMapping("/findByCondition_My")
    public ModelAndView findByCondition_My(@RequestParam(name="page",required = true,defaultValue = "1") int page,
                                           @RequestParam(name = "size",defaultValue = "5") int size,
                                           @RequestParam(name = "dataTable",defaultValue = "laboratory_stu1") String dataTable,
                                           @RequestParam(name = "id",required = true) int id,
                                           @RequestParam(name = "appoint_date",required = false) String appoint_date) {

        ModelAndView mv = new ModelAndView();

        //封装查询条件
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Condition condition = new Condition();
        condition.setDataTable(dataTable);
        condition.setId(id);
        if(appoint_date==null||appoint_date.equals("")){
            condition.setAppoint_date(null);
        }else{
            try {
                condition.setAppoint_date(format.parse(appoint_date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        mv.addObject("condition",condition);
        switch (condition.getDataTable()){
            case "laboratory_stu1" :mv.addObject("condition_dataTable","学生实验室一");break;
            case "laboratory_stu2" :mv.addObject("condition_dataTable","学生实验室二");break;
            case "laboratory_stu3" :mv.addObject("condition_dataTable","学生实验室三");break;
            case "laboratory_stu4" :mv.addObject("condition_dataTable","学生实验室四");break;
            case "laboratory_stu5" :mv.addObject("condition_dataTable","学生实验室五");break;
        }
        if(condition.getAppoint_date()==null){
            mv.addObject("condition_appointDate","未选择");
        }else {
            String condition_formatDate = format.format(condition.getAppoint_date());
            mv.addObject("condition_appointDate",condition_formatDate);
        }

        //获取查询结果
        List<StuAppointment> myAppointmentList = stuAppointmentService.findByCondition_Stu(condition, page, size);

        for (StuAppointment myAppointment : myAppointmentList) {
            System.out.println(myAppointment);
            //设置格式化日期
            String formatDate = format.format(myAppointment.getAppoint_date());
            myAppointment.setFormatDate(formatDate);

            //如果超时且状态不为以上报,修改状态为未上报
            if((myAppointment.getAppoint_date().getTime()+86400000)<new Date().getTime()&&!myAppointment.getStatus().equals("已上报"))
            {
                System.out.println(dataTable);
                stuAppointmentService.setStatusNotReport(dataTable,myAppointment.getId());
                myAppointment.setStatus("未上报");
            }
        }

        //将分页后结果存入request域
        PageInfo pageInfo = new PageInfo(myAppointmentList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("myappointment");

        return mv;
    }

    /**
     * 取消预约
     * @param dataTable
     * @param aid
     * @param appoint_date
     * @param session
     * @return
     */
    @RequestMapping("/cancelAppointment")
    public ModelAndView cancelAppointment(@RequestParam String dataTable,@RequestParam int aid,@RequestParam String appoint_date,HttpSession session){
        Student student = (Student) session.getAttribute("student");
        int id = student.getId();
        stuAppointmentService.cancelAppointment(dataTable,aid);
        System.out.println("已删除");
        if(appoint_date.equals("")){
            ModelAndView mv = findByCondition_My(1,5,dataTable,id,appoint_date);
            return mv;
        }else {
            Date date = new Date(appoint_date);
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String formatDate = sf.format(date);
            System.out.println(formatDate);
            ModelAndView mv = findByCondition_My(1, 5, dataTable, id, formatDate);
            return mv;
        }
    }

    @RequestMapping("/toStudentReport")
    public ModelAndView toStudentReport(@RequestParam String dataTable,@RequestParam String aid,@RequestParam String appoint_date,@RequestParam String appoint_time){
        ModelAndView mv = new ModelAndView();
        switch (dataTable){
            case "学生实验室一":mv.addObject("realDataTable","laboratory_stu1");break;
            case "学生实验室二":mv.addObject("realDataTable","laboratory_stu2");break;
            case "学生实验室三":mv.addObject("realDataTable","laboratory_stu3");break;
            case "学生实验室四":mv.addObject("realDataTable","laboratory_stu4");break;
            case "学生实验室五":mv.addObject("realDataTable","laboratory_stu5");break;
        }
        mv.addObject("dataTable",dataTable);
        mv.addObject("aid",aid);
        mv.addObject("appoint_date",appoint_date);
        mv.addObject("appoint_time",appoint_time);
        mv.setViewName("studentreport");
        return mv;
    }

    @RequestMapping("/setStatusReported")
    public String setStatusReported(HttpServletRequest request, String dataTable, int aid, MultipartFile upload) throws IOException {
        //修改数据库状态
        stuAppointmentService.setStatusReported(dataTable,aid);

        //保存图片
        SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd");
        String formatDate = sf.format(new Date());
        String path = request.getSession().getServletContext().getRealPath("/上报记录/"+formatDate+"/");
        File uploadFiles = new File(path);
        if(!uploadFiles.exists()){
            uploadFiles.mkdirs();
        }
        String fileName = upload.getOriginalFilename();
        fileName = dataTable+"-"+aid+"-"+fileName;

        upload.transferTo(new File(path,fileName));

        return "studentmain";
    }

    @RequestMapping("/changePassword")
    public ModelAndView changPassword(String originPassword,String newPassword,HttpSession session){
        ModelAndView mv = new ModelAndView();
        Student student = (Student) session.getAttribute("student");
        int id = student.getId();
        String password = studentService.findStudentById(id).getStu_password();
        System.out.println(password);
        if(password.equals(originPassword)){
            studentService.changePasswordById(id,newPassword);
            mv.addObject("msg","修改成功");
        }else {
            mv.addObject("msg","原密码输入错误!");
        }

        mv.setViewName("studentchangepassword");
        return mv;
    }

    @RequestMapping("/studentLogout")
    public String studentLogout(HttpSession session){
        session.invalidate();
        return "studentlogin";
    }
}