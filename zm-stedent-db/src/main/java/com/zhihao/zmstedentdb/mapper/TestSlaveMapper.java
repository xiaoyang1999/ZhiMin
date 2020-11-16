package com.zhihao.zmstedentdb.mapper;

import com.zhihao.zmstedentdb.entity.TestSlave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.aspectj.weaver.ast.Test;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangzhihao
 * @since 2020-11-16
 */
public interface TestSlaveMapper extends BaseMapper<TestSlave> {

    List<TestSlave> findAll();
}
