package com.dexingworld.hanfu.web.controller;

import com.dexingworld.hanfu.biz.MenuBizService;
import com.dexingworld.hanfu.common.parameter.AddMenu;
import com.dexingworld.hanfu.common.response.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by wangpeng on 2016/11/4.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuBizService menuBizService;

    @ExceptionHandler
    @RequestMapping("/add")
    private ResultResponse add(@Valid AddMenu addMenu,BindingResult bindingResult){
        ResultResponse resultResponse = new ResultResponse();
        if(bindingResult != null && bindingResult.hasErrors()){
            return resultResponse.makeFailure(bindingResult.getFieldError().getDefaultMessage());
        }
        return menuBizService.add(addMenu);
    }

}
