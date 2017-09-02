package com.feint.kotlinaoptest.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class HostWithoutMyController{
    @RequestMapping("/host/info/2")
    fun hostInfo(request: HttpServletRequest){}
}