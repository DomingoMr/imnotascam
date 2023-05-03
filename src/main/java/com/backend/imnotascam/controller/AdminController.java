package com.backend.imnotascam.controller;

import com.backend.imnotascam.dto.Response;
import com.backend.imnotascam.dto.UrlBody;
import com.backend.imnotascam.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService scamService) {
        this.adminService = scamService;
    }

    @PostMapping(value = "/addUrlToBlackList")
    public Response addUrlToBlackList(@RequestBody UrlBody url) {
       return adminService.addToBlackList(url.getUrl());
    }

    @PostMapping(value = "/addUrlToWhiteList")
    public Response addUrlToWhiteList(@RequestBody UrlBody url) {
        return adminService.addToWhiteList(url.getUrl());
    }
}
