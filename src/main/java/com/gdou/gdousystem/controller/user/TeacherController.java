package com.gdou.gdousystem.controller.user;

import com.gdou.gdousystem.bean.Teacher;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.RoleService;
import com.gdou.gdousystem.service.TeacherService;
import com.gdou.gdousystem.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/21
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@ResponseBody
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public Message login(@RequestParam("teacherId") String teacherId, @RequestParam("password") String password,HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(teacherId, MD5Util.md5(password));
        try {
            subject.login(token);
            Teacher teacher = (Teacher) SecurityUtils.getSubject().getSession().getAttribute("teacher");
            return Message.success().add("teacher", teacher);
        } catch (UnknownAccountException e) {
            map.put("message", "登录失败，请检查用户名和账户");
            return Message.fail().add("error", map);
        } catch (IncorrectCredentialsException e) {
            map.put("message", "登录失败，请检查用户名和账户");
            return Message.fail().add("error", map);
        }
    }

    @GetMapping("/user/teachers")
    public Message findAllTeachersSelective(@RequestParam(value = "pn", defaultValue = "1") Integer pn,@RequestParam(value = "username",defaultValue = "") String username,@RequestParam(value = "roleId",defaultValue = "0")Integer roleId) {
        PageHelper.startPage(pn, 10);
        List<Teacher> teachers = teacherService.findAllTeachersSelective(username,roleId);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers, 5);
        return Message.success().add("pageInfo", pageInfo);
    }

    @GetMapping("/user/teacher/{teacherId}")
    public Message findTeacherByTeacherId(@PathVariable("teacherId")String teacherId){
        Teacher teacher=teacherService.findTeacherByTeacherId(teacherId);
        return Message.success().add("teacher",teacher);
    }

    @PutMapping("/updatepassword")
    public Message updatePasswordByTeacherId(@RequestParam("password") String password, @RequestParam("ensurePassword") String ensurePassword, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        int flag = teacherService.updatePasswordByTeacherId(password, ensurePassword, teacher.getTeacherId());
        if (flag == 1) {
            return Message.fail().add("error", "请输入正确的密码");
        } else if (flag == 2) {
            return Message.fail().add("error", "确认密码与密码不一致");
        } else {
            return Message.success();
        }
    }

    @DeleteMapping("/user/teacher/{teacherId}")
    public Message deleteTeacherByTeacherId(@PathVariable("teacherId") String teacherId) {
        boolean flag = teacherService.deleteTeacherByTeacherId(teacherId);
        if (flag) return Message.success();
        else return Message.fail();
    }

    @GetMapping("/user/loginteacher")
    public Message getLoginTeacher(HttpServletRequest request){
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        return Message.success().add("teacher",teacher);
    }

    @PutMapping("/user/role")
    public Message updateRoleByTeacherId(@RequestParam("teacherId") String teacherId,@RequestParam("role")Integer[] roles){
        boolean flag=teacherService.updateRoleByTeacherId(teacherId,roles);
        if(flag) return Message.success();
        else return Message.fail();
    }

    @PutMapping("/user/status")
    public Message updateStatusByTeacherId(@RequestParam("teacherId")String teacherId){
        boolean flag=teacherService.updateStatusByTeacherId(teacherId);
        if(flag) return Message.success();
        else return Message.fail();
    }
}
