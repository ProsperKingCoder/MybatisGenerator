package com.zengyikeji.utils;

import java.util.HashMap;
import java.util.Map;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成 注意：不生成service接口 注意：不生成service接口 注意：不生成service接口
 * 
 * @author ShenHuaJie
 */
public class Generator {
	/**
	 * 测试 run 执行 注意：不生成service接口 注意：不生成service接口 注意：不生成service接口
	 * <p>
	 * 配置方法查看 {@link ConfigGenerator}
	 * </p>
	 */
	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("E://test//");
		gc.setFileOverride(true);
		gc.setActiveRecord(false);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setOpen(false);
		gc.setAuthor("ProsperKing");

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		// gc.setMapperName("%sDao");
		// gc.setXmlName("%sDao");
		gc.setServiceName("%sService");
		// gc.setServiceImplName("%sServiceDiy");
		// gc.setControllerName("%sAction");
		mpg.setGlobalConfig(gc);
		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
//		dsc.setDbType(DbType.ORACLE);//oracle数据库
		dsc.setDbType(DbType.MYSQL);//mysql数据库
		
		/** oracle数据库连接 start **/
//		dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
//		dsc.setUsername("root");
//		dsc.setPassword("123456");
//		dsc.setUrl("jdbc:oracle:thin:@192.168.1.7:1521:XE");
		/** oracle数据库连接 end **/
		
		/** mysql数据库连接 start **/
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("root");
		dsc.setUrl("jdbc:mysql://localhost:3306/pinche?useUnicode=true&amp;characterEncoding=UTF-8");
		/** mysql数据库连接 end **/
		mpg.setDataSource(dsc);
		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀

		strategy.setNaming(NamingStrategy.remove_prefix_and_camel);// 表名生成策略,去掉前缀并驼峰命名
		
		strategy.setInclude(new String[] { "T_TRAVEL_INFO"});
		// 字段名生成策略
		strategy.setFieldNaming(NamingStrategy.underline_to_camel);

		mpg.setStrategy(strategy);
		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.zengyikeji.pinche");
		pc.setEntity("entities");
		pc.setMapper("dao");
		pc.setXml("dao.mapper");
		pc.setServiceImpl("service.impl");
		pc.setService("service");
		pc.setController("controller");
		mpg.setPackageInfo(pc);
		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig cfg = new InjectionConfig() {
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("providerClass", "ISysProvider");
				this.setMap(map);
			}
		};
		mpg.setCfg(cfg);
		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
		// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		TemplateConfig tc = new TemplateConfig();
		tc.setEntity("template/entity.java.vm");
		tc.setMapper("template/mapper.java.vm");
		tc.setXml("template/mapper.xml.vm");
		tc.setService("template/service.java.vm");
		tc.setController("template/controller.java.vm");
		mpg.setTemplate(tc);
		// 执行生成
		mpg.execute();
	}
}
