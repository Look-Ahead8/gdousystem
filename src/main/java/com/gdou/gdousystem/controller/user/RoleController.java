package com.gdou.gdousystem.controller.user;

import com.gdou.gdousystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Meng
 * @date 2019/12/23
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",maxAge = 3600)
@ResponseBody
public class RoleController {
    @Autowired
    private RoleService roleService;
}
