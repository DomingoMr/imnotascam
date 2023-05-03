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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BLACK LIST//////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(value = "/addUrlToBlackList")
    public Response addUrlToBlackList(@RequestBody UrlBody url) {
       return adminService.addToBlackList(url.getUrl());
    }

    @DeleteMapping(value = "/deleteBlackListUrl")
    public Response deleteBlackListUrl(@RequestBody UrlBody url) {return adminService.deleteBlackListUrl(url.getUrl());}

    @GetMapping(value = "/getBlackList")
    public Response getBlackList() {return adminService.getBlackList();}


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////WHITE LIST//////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(value = "/addUrlToWhiteList")
    public Response addUrlToWhiteList(@RequestBody UrlBody url) {
        return adminService.addToWhiteList(url.getUrl());
    }

    @DeleteMapping(value = "/deleteWhiteListUrl")
    public Response deleteWhiteListUrl(@RequestBody UrlBody url) {return adminService.deleteWhiteListUrl(url.getUrl());}

    @GetMapping(value = "/getWhiteList")
    public Response getWhiteList() {return adminService.getWhiteList();}


}
