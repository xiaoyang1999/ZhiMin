package com.zhihao.zmstedentdb.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: CodeGenerator
 * @Description MP 代码生成工具 ，具体配置可以根据需求更改。
 */
public class CodeGeneratorForYzh {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "E:\\dm";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("yangzhihao");
        gc.setOpen(false);
        gc.setActiveRecord(true);//不需要ActiveRecord特性的请改为false
        gc.setIdType(IdType.UUID);//主键的ID类型
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setDateType(DateType.ONLY_DATE);//设置Date 类型
        mpg.setGlobalConfig(gc);


       { //mysql
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://127.0.0.1:3306/zm_student_db");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("root");
            dsc.setDbType(DbType.MYSQL);
            mpg.setDataSource(dsc);
        }

        /*{ //sqlserver
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:sqlserver://121.40.42.149:1433;DatabaseName=bto2");
            dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dsc.setUsername("sa");
            dsc.setPassword("data%1000");
            dsc.setDbType(DbType.SQL_SERVER);

            mpg.setDataSource(dsc);
        }*/



        // 包配置
        PackageConfig pc = new PackageConfig();
        /*String modleName = scanner("模块名");
        pc.setModuleName(modleName);*/
        pc.setParent("com.utoper.bto.storeimpl");
        pc.setEntity("domain.entity");
        pc.setMapper("mapper"); //设置mapper包名
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/mapping/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // templateConfig.setEntity();
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setLogicDeleteFieldName("is_deleted");

        strategy.setTablePrefix("")          //表名前缀
                .setEntityBooleanColumnRemoveIsPrefix(true);//Boolean类型字段是否移除is前缀（默认 false）;

        strategy.setInclude(scanner("表名(如果多个以英文逗号,隔开)").split(","));

        strategy.setControllerMappingHyphenStyle(false);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}

