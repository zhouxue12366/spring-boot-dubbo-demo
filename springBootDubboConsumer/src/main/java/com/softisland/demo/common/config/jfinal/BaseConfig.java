//package com.softisland.demo.common.config.jfinal;
//
//
//import com.jfinal.config.Constants;
//import com.jfinal.config.Handlers;
//import com.jfinal.config.Interceptors;
//import com.jfinal.config.JFinalConfig;
//import com.jfinal.config.Plugins;
//import com.jfinal.config.Routes;
//import com.jfinal.ext.handler.ContextPathHandler;
//import com.jfinal.ext.interceptor.SessionInViewInterceptor;
//import com.jfinal.template.Engine;
//import com.softisland.demo.main.controller.MainController;
//
///**
// * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法 详见 JFinal 俱乐部:
// * http://jfinal.com/club
// * 
// * API引导式配置
// */
//public class BaseConfig extends JFinalConfig {
//
//	/**
//	 * 配置常量
//	 */
//	public void configConstant(Constants me) {
//		// 加载少量必要配置，随后可用PropKit.get(...)获取值
////		PropKit.use("config.txt");
////		PropKit.use("quartz_job.properties");
//		// 设置默认上传,下载路径
//	}
//
//	/**
//	 * 配置路由
//	 */
//	public void configRoute(Routes me) {
////		me.setBaseViewPath("/views");
////		me.add("main", MainController.class);
//	}
//
//	public void configEngine(Engine me) {// 定义通用的模板
////		me.addSharedFunction("/views/common/_paginate.html");
////		me.addSharedFunction("/views/common/_layout.html");
//		//图片显示地址页面直接用jfinal的标签取值,比如#(images_host)就OK了
////		me.addSharedObject("images_host", PropKit.get("images_src"));
//	}
//
////	public static DruidPlugin createDruidPlugin() {
////		DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
////		return dp;
////	}
//
//	/**
//	 * 配置插件
//	 */
//	public void configPlugin(Plugins me) {
//		// 配置C3p0数据库连接池插件
////		DruidPlugin druidPlugin = createDruidPlugin();
////		me.add(druidPlugin);
//		
//		//配置Redis插件
////		RedisPlugin iggamerRedis = new RedisPlugin(Constant.REDIS_IGGAMER, PropKit.get("redis_host"));
////		me.add(iggamerRedis);
//
//		// 配置ActiveRecord插件
////		ActiveRecordPlugin arp = new ActiveRecordPlugin();
//		// 所有映射在 MappingKit 中自动化搞定
////		_MappingKit.mapping(arp);
////		arp.setShowSql(true);// 控制台显示sql
////		me.add(arp);
//		
//		//定时任务插件,cron4j不支持以秒为单位的,所以换成了QuartzPlugin
////		QuartzPlugin quartzPlugin = new QuartzPlugin();
////        me.add(quartzPlugin);
//
//	}
//
//	/**
//	 * 配置全局拦截器
//	 */
//	public void configInterceptor(Interceptors me) {
//		me.add(new SessionInViewInterceptor());
//
//		// 事务控制器
////		me.add(new TxByActionKeyRegex("(.*save.*|.*update.*|.*del.*|.*add.*)", true));
////		me.add(new TxByMethodRegex("(.*save.*|.*update.*)"));
////		me.add(new TxByMethods("save", "update"));
////		me.add(new TxByActionKeys("/tx/save", "/tx/update"));
//	}
//
//	/**
//	 * 配置处理器
//	 */
//	public void configHandler(Handlers me) {
//		me.add(new ContextPathHandler("contextPath"));
//	}
//}
