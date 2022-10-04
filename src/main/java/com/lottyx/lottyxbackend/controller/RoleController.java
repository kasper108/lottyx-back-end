package com.lottyx.lottyxbackend.controller;

import com.lottyx.lottyxbackend.model.Role;
import com.lottyx.lottyxbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin( allowedHeaders = "*", origins = "*")
@RequestMapping("api/v1/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/addNewRole")
    public Role addNewRole( @RequestBody Role role ){
        return roleService.postNewRole(role);
    }

}
