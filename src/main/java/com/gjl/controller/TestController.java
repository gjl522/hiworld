package com.gjl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
@Api(value = "TestController|这是测试swagger的控制器")
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户的编号获取用户姓名",notes = "test:仅有1和2   有正确返回")
    @ApiImplicitParam(paramType = "query",name = "userNumber",value = "用户编号",required = true,dataType = "Integer")
    public String getUserName(@RequestParam Integer userNumber){

        if (userNumber == 1){
            return "穆罕穆德·真古龙·波海姚";
        }else if(userNumber == 2){
            return "穆罕穆德·真古龙·波海姚是傻逼";
        }else {
            return "鬼";
        }
    }
}
