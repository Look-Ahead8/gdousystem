package com.gdou.gdousystem.controller.user;

import com.gdou.gdousystem.bean.Permission;
import com.gdou.gdousystem.message.Message;
import com.gdou.gdousystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Meng
 * @date 2019/12/23
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",maxAge = 3600)
@ResponseBody
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("permission")
    public Message findPermissionByRoleId(@RequestParam("roleId")Integer roleId){
        List<Permission> list=permissionService.findPermissionByRoleId(roleId);
        return Message.success().add("permission",list);
    }
}
