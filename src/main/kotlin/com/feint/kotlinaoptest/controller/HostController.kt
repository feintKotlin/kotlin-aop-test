package com.feint.kotlinaoptest.controller



import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class HostController:MyController{
    @RequestMapping("/host/info")
    fun hostInfo(request: HttpServletRequest){}

}