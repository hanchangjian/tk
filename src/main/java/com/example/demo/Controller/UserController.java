package com.example.demo.Controller;

import com.example.demo.Pojo.Page;
import com.example.demo.Pojo.User;
import com.example.demo.Service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api("用户登录列表")
@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录接口", notes = "输入登录信息")
    @PostMapping(value = "/login")
    @ResponseBody//body传参
    public String login(@RequestBody User user) {

        User u = userService.findOneUser(user);
        if (u != null) {
            return "登录成功";
        }
        return "用户名密码错误或未注册";
    }

    @ApiOperation(value = "注册接口", notes = "输出注册信息")
    @PostMapping(value = "/regis")
    public String regis(@RequestBody User user) {

        User u = userService.findOneUser(user);

        if (u != null) {
            return "用户已注册";
        }
        int aa = userService.addUser(user);
        if (aa != 0) {
            return "注册成功";
        }
        return "注册失败";
    }


    @ApiOperation(value = "删除接口", notes = "输入user")
    @PostMapping("/delete")
    public String delete(@RequestBody User user) {
        user = userService.findOneUser(user);
        if (user == null) {
            return "没有该用户";
        }
        int i = userService.deleteUser(user);
        if (i != 0) {
            return "删除成功";
        }
        return "删除失败";
    }


    @ApiOperation(value = "分页查询", notes = "输入pageNum,pageSize")
    @PostMapping("/selectByRowBounds")
    public PageInfo <User> all(@RequestBody Page page) {

        PageHelper.startPage(page);
        List <User> all = userService.selectAll();
        PageInfo <User> info = new PageInfo(all);
        return info;


    }
}
