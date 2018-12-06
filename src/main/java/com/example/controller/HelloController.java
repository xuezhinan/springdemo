package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.mapper.UserMapper;
import com.example.pojo.Student;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/user")
public class HelloController {
    @Autowired
    private Student student;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(required = false) String userName){
        String n = "{'name':'gaisi'}";

        String name = JSON.toJSONString(n);
        System.out.println(userName);
        System.out.println(student.getName()+"*********"+student.getPassword());
        return name;
    }
    //可以在此处添加produces = {"application/json;charset=UTF-8"} 解决中文乱码的问题
    @RequestMapping(value = "/getUserList",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    //该方法进行事务处理的注解
    @Transactional
    public String getUserList(){
        /*List<User> list = userService.getUserList();
        for(User user:list){
            System.out.println(user.getUserName());
        }*/
        return "chenggong";
    }

    @RequestMapping(value = "/getAgentList")
    @ResponseBody
    public PageInfo  getAgentLists(HttpServletRequest request,
                              @RequestParam(name = "pageNum",required = false,defaultValue = "1")String pageNum,
                              @RequestParam(name = "pageSize",required = false)String pageSize){
        System.out.println(pageNum+"**********"+pageSize);
        PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize),true);
        List<User> list = userMapper.getUserList();
        for (User user:list){
            System.out.println(user.getUserName());
        }
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo.getPageNum()+"**********"+pageInfo.getPageSize());
        return pageInfo;
    }
}
