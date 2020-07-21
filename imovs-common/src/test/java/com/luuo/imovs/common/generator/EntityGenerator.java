package com.luuo.imovs.common.generator;


import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.luuo.imovs.common.ImovsCommonApplicationTests;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

/*
    数据层内容生成
 */

public class EntityGenerator extends ImovsCommonApplicationTests {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    // 生成输出目录，定位到工程的java目录下
    private String outputDir = System.getProperty("user.dir");
    // 生成类的作者
    private String author = "luuo";

    // DAO的包路径
    private final String parentPackage = "com.luuo.imovs.common";
    // 待生成的表名，注意是覆盖更新
    private static String[] tableNames;

    static {
        tableNames = new String[]{
                "t_user_wxma"
        };
    }


    @Test
    public void entityGenerator() {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new BeetlTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir + "/src/main/java");
        gc.setFileOverride(true);
        //gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        gc.setAuthor(author);
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dataSourceProperties.getUrl());
        dsc.setDriverName(dataSourceProperties.getDriverClassName());
        dsc.setUsername(dataSourceProperties.getUsername());
        dsc.setPassword(dataSourceProperties.getPassword());
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setSuperEntityColumns("id");
        strategy.setTablePrefix("t_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tableNames);
        strategy.setEntitySerialVersionUID(false);
        //生成的字段 是否添加注解，默认false
        strategy.setEntityTableFieldAnnotationEnable(true);
        //是否启用 Lombok
        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage);
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        cfg.setFileOutConfigList(Lists.newArrayList(new FileOutConfig("/templates/mapper.xml.btl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义mapper xml输出目录
                return outputDir + "/src/main/resources/mapper/" + tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        }));

        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        //控制 不生成 controller
        templateConfig.setController("");
        //控制 不生成 service
        templateConfig.setService("");
        //控制 不生成 serviceImpl
        templateConfig.setServiceImpl("");
        //控制 不生成 mapper.xml,因为上面设置生成了
        templateConfig.setXml("");
        mpg.setTemplate(templateConfig);
        // 执行生成
        mpg.execute();

        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
