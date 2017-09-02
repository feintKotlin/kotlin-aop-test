package com.feint.kotlinaoptest.aop

import com.feint.kotlinaoptest.pojo.UserHost
import eu.bitwalker.useragentutils.UserAgent
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.reflect.MethodSignature
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest


@Aspect
@Component
class HostAspect {
    private val logger = LoggerFactory.getLogger(HostAspect::class.java)
    /**
     * 使用AspectJ表达式
     */
//    @Pointcut("execution(* com.feint.kotlinaoptest.controller..* (..)) &&" +
//            " @annotation(org.springframework.web.bind.annotation.RequestMapping)")

//    @Pointcut("args(javax.servlet.http.HttpServletRequest,..)&&@annotation(org.springframework.web.bind.annotation.RequestMapping)")

//    @Pointcut("within(com.feint.kotlinaoptest.controller..*)")

//    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")

//    @Pointcut("target(com.feint.kotlinaoptest.controller.MyController)")

//    @Pointcut("this(com.feint.kotlinaoptest.controller.MyController)")

    @Pointcut("within(com.feint.kotlinaoptest.controller..*)&&@target(org.springframework.web.bind.annotation.RestController)")
    fun requestPointCut() {}

    @Around(value = "requestPointCut()")
    @Throws(Throwable::class)
    fun interceptor(joinPoint: ProceedingJoinPoint): Any? {

        logger.info("this: ${joinPoint.`this`::class.simpleName}")
        logger.info("target: ${joinPoint.target::class.simpleName}")

        val methodSignature = joinPoint.signature as MethodSignature
        val method = methodSignature.method

        val request = joinPoint.args[0] as HttpServletRequest

        val userAgentString=request.getHeader("User-Agent")
        val userAgent=UserAgent.parseUserAgentString(userAgentString)

        val userHost=UserHost(request.remoteAddr,request.remoteHost,userAgent.operatingSystem.name,userAgent.browser.name)

        logger.info(userHost.toString())

        return joinPoint.proceed()
    }


}