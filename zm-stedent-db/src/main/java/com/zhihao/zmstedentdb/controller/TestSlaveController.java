package com.zhihao.zmstedentdb.controller;

import com.zhihao.zmstedentdb.entity.TestSlave;
import com.zhihao.zmstedentdb.service.ITestSlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangzhihao
 * @since 2020-11-16
 */
@RestController
@RequestMapping("/testSlave")
public class TestSlaveController {

    @Autowired
    private ITestSlaveService iTestSlaveService;

    @GetMapping("list")
    public List<TestSlave> list(){
        return iTestSlaveService.selectAll();
    }

    @PostMapping("/testSlave")
    public TestSlave testSlave(@PathParam("name") String name){
        return iTestSlaveService.saveOne(name);
    }
}
