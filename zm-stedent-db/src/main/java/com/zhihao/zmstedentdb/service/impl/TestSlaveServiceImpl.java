package com.zhihao.zmstedentdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhihao.zmstedentdb.entity.TestSlave;
import com.zhihao.zmstedentdb.mapper.TestSlaveMapper;
import com.zhihao.zmstedentdb.service.ITestSlaveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangzhihao
 * @since 2020-11-16
 */
@Service
public class TestSlaveServiceImpl extends ServiceImpl<TestSlaveMapper, TestSlave> implements ITestSlaveService {

    @Override
    @DS("slave_1")
    public List<TestSlave> selectAll() {
        return baseMapper.findAll();
    }

    @Override
    public TestSlave saveOne(String name) {
        TestSlave testSlave = new TestSlave();
        testSlave.setName(name);
        this.save(testSlave);
        return testSlave;
    }
}
