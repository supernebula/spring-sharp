package com.evol.utils;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.apache.ibatis.util.MapUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyGenerator {
    private static final String projectPath = System.getProperty("user.dir");
    private static final String url = "jdbc:mysql://127.0.0.1:3306/coach_user?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&useSSL=false&allowPublicKeyRetrieval=true";//这里改为自己数据库名字
    private static final String username = "root";//数据库用户名和密码
    private static final String password = "123456789";
    private static final String parentPackageName = "com.evol";//生成的mapper等文件夹放在哪个包下
    private static final String writer = "evol";//自己的名字
    private static final String outPath = projectPath + "\\src\\main\\java\\";

    private static final String modelPath = projectPath + "\\src\\main\\java\\com\\evol\\domain\\model\\";//实体类文件位置
    private static final String mapperPath = projectPath + "\\src\\main\\resources\\mapper\\";//mapper.xml文件放的位置

    public static void main(String[] args) {
        String[] tableNames = {"user"};//数据库表名
        MyGenerator.execute(tableNames);
    }

    public static void execute(String[] tableNames) {
        Map<OutputFile, String> pathInfo = new HashMap<>();
        pathInfo.put(OutputFile.xml, mapperPath);
        pathInfo.put(OutputFile.entity, modelPath);

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(writer)
                            .enableSwagger()
                            .outputDir(outPath)
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackageName)
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperPath));
                })


//                .packageConfig(builder -> {
//                    builder.parent(parentPackageName)
//                            .pathInfo(pathInfo);
//                })

                .strategyConfig(builder -> {
                    builder.addInclude(tableNames)
                            .addTablePrefix("t_")
                            //Service 层生成设置
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            //Entity
                            .entityBuilder()
                            .entityBuilder().fileOverride()//表示再次生成会覆盖，建议entity和mapper层覆盖
                            .enableChainModel()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .logicDeleteColumnName("deleted")
                            .logicDeletePropertyName("deleted")
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .addTableFills(new Column("create_Time", FieldFill.INSERT))
                            .addTableFills(new Column("update_Time", FieldFill.INSERT_UPDATE))
                            //controller
                            .controllerBuilder()
                            .enableRestStyle()//生成的controller自带@RestController注解
                            //mapper
                            .mapperBuilder()
                            .mapperBuilder().fileOverride();
                })
                .templateEngine(new FreemarkerTemplateEngine()) //使用freemaker模板引擎
                .execute();
    }
}
