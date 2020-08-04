package com.example.icsecurity.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.*;

/**
 * @ClassName: MybatisPlusGeneratorConfig
 * @Description: Mybatis-pius-generator代码生成
 * @Author: yongchen
 * @Date: 2020/7/30 17:42
 **/
public class MybatisPlusGeneratorConfig {

    public static void main(String[] args) {
        //需要生成得表
        final String[] tableName = {"t_user"};

        //包路径
        final String packagePath = "com.example.icsecurity";

        //要生成的类(请注掉不要的) controller service serviceImpl entity xml mapper
        Set<String> needClass = new HashSet<>();
        needClass.add("controller");
        needClass.add("service");
        needClass.add("serviceImpl");
        needClass.add("entity");
        needClass.add("xml");
        needClass.add("mapper");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/ic-security/src/main/java");
        gc.setAuthor("yongchen");
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // XML生成ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        // 文件覆盖
        gc.setFileOverride(true);
        // 开启 activeRecord 模式
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://112.74.161.0:3306/ic_database?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 包路径
        pc.setParent(packagePath);
        // 表前缀
//        pc.setModuleName("t");
        //文件包名
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setService("service");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                /*Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                String dateStr = sdf.format(date);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("poname",toCamel(tableName));
                map.put("package",packagePath);
                map.put("date",dateStr);
                this.setMap(map);*/
            }
        };

        // 如果模板引擎是 freemarker
        String templatePathController = "/templates/controller.java.ftl";
        String templatePathEntity = "/templates/entity.java.ftl";
        String templatePathService = "/templates/service.java.ftl";
        String templatePathServiceImpl = "templates/serviceImpl.java.ftl";
        String templatePathMapper = "/templates/mapper.java.ftl";
        String templatePathXml = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        if (needClass.contains("controller")){
            focList.add(new FileOutConfig(templatePathController) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return "./ic-security/src/main/java/com/example/icsecurity/controller"
                            + "/" + tableInfo.getControllerName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (needClass.contains("entity")){
            focList.add(new FileOutConfig(templatePathEntity) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return "./ic-security/src/main/java/com/example/icsecurity/entity"
                            + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (needClass.contains("service")){
            focList.add(new FileOutConfig(templatePathService) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return "./ic-security/src/main/java/com/example/icsecurity/service"
                            + "/" + tableInfo.getServiceName() + StringPool.DOT_JAVA;
                }
            });
        }
        if(needClass.contains("serviceImpl")){
            focList.add(new FileOutConfig(templatePathServiceImpl) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return "./ic-security/src/main/java/com/example/icsecurity/service/impl"
                            + "/" + tableInfo.getServiceImplName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (needClass.contains("mapper")){
            focList.add(new FileOutConfig(templatePathMapper) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return "./ic-security/src/main/java/com/example/icsecurity/mapper"
                            + "/" + tableInfo.getMapperName() + StringPool.DOT_JAVA;
                }
            });
        }
        if (needClass.contains("xml")){
            focList.add(new FileOutConfig(templatePathXml) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return "./ic-security/src/main/resources/mappers/"
                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        }

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 你自己的父类实体,没有就不用设置!
        // strategy.setSuperEntityClass();
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类 你自己的父类控制器,没有就不用设置!
        // strategy.setSuperControllerClass();
        // 写于父类中的公共字段
        // strategy.setSuperEntityColumns("id");
        // 需要生成的表
        strategy.setInclude(tableName);
        strategy.setControllerMappingHyphenStyle(true);
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix("t_");
//        strategy.setTableFillList()
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * @Author: yongchen
     * @Description: 下划线转换为驼峰式
     * @Date: 17:09 2020/7/31
     * @Param: [tableName]
     * @return: java.lang.String
     **/
    private static String toCamel(String tableName){
        StringBuilder propName = new StringBuilder();
        //aa_bb_cc  AaBbCc
        String[] split = tableName.toLowerCase().split("_");
        for (String s:split) {
            propName.append(upperFirstLetter(s));
        }
        return propName.toString();
    }

    /**
     * @Author: yongchen
     * @Description: 首字母大写
     * @Date: 17:10 2020/7/31
     * @Param: [filed]
     * @return: java.lang.String
     **/
    private static String upperFirstLetter(String filed){
        String firstLetter = filed.substring(0, 1).toUpperCase();
        String otherLetter = filed.substring(1);
        return firstLetter+otherLetter;
    }
}
