package com.zhihao.zmstedentdb.service;

import com.zhihao.zmstedentdb.entity.TestSlave;
import com.baomidou.mybatisplus.extension.service.IService;
import org.aspectj.weaver.ast.Test;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangzhihao
 * @since 2020-11-16
 */
public interface ITestSlaveService extends IService<TestSlave> {

    List<TestSlave> selectAll();

    TestSlave saveOne(String name);
}
