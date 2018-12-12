package com.geneimpl.controller;


import com.geneimpl.model.Student;
import com.geneimpl.model.User;
import com.geneimpl.service.StudentService;
import com.geneimpl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class mainController {
    @Resource(name="UserService")
    private UserService userService;
    @Resource(name="StudentService")
    private StudentService studentService;
    Integer stuid;

    public StudentService getStudentService() { return studentService; }
    public void setStudentService(StudentService studentService) { this.studentService = studentService; }

    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "indexdo")
    public String indexP (HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入indexPost方法");
      String username=request.getParameter("username");
      String userpsw=request.getParameter("userpsw");
        System.out.println(username);
        System.out.println(userpsw);
      User u=userService.getUserByNameAndPsw(username,userpsw);
        System.out.println(u.toString());
      if (u!=null){
            return "login";
        }else return "redirect:indexdo";
    }

    @GetMapping(value = "indexdo")
    public String  indexG (HttpServletRequest request){
        System.out.println("进入indexget方法");
        return "index";
    }

    @PostMapping(value = "logindo")
    @ResponseBody
    public List<Student> loginP (@RequestBody Student student){
        System.out.println("进入loginPost方法");
        stuid=student.getStuid();
        return studentService.getStuByName(student.getStuname());
    }

    @GetMapping(value = "logindo")
    public String  loginG (HttpServletRequest request){
        System.out.println("进入loginGet方法");
        return "login";
    }

    @RequestMapping(value = "updateStu",method =RequestMethod.GET)
    public String updateG(HttpServletRequest request){
        return "updateStu";
    }

    @RequestMapping(value = "updateStu",method =RequestMethod.POST)
    @ResponseBody
    public int updateP(@RequestBody Student stu) {
        System.out.println("进入更新页面POST+++++++++++++++++++++++++++");
        stu.setStuid(stuid);
        int check=studentService.updateByPrimaryKeySelective(stu);
        System.out.println(check);
        return check;
    }

    @RequestMapping(value = "getStuId",method =RequestMethod.POST)
    @ResponseBody
    public Student getStu( HttpServletRequest request) {
        return studentService.selectByPrimaryKey(stuid);
    }

    @PostMapping(value = "zhucedo")
    public String zhuceP ( User user){
        System.out.println("进入zhucePost方法");
        if(userService.addUser(user)==1){
            return "redirect:indexdo";
        }else return "zhuce";
    }

    @GetMapping(value = "zhucedo")
    public String  zhuceG (HttpServletRequest request){
        System.out.println("进入zhuceGet方法");
        return "zhuce";
    }

    @RequestMapping(value = "addStudo",method = RequestMethod.GET)
    public String addStuG(HttpServletRequest request){
        return "addStu";
    }

    @RequestMapping(value = "addstudo",method = RequestMethod.POST)
    public String addStuP(HttpServletRequest request,Student stu){
        int check =studentService.insertSelective(stu);
        System.out.println(check);
        if(check==1)
        {
            return "redirect:logindo";
        }
        else
        {
            return "addStu";
        }
    }
}
