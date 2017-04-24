package cn.gc.hib;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class App_ddl {

	@Test
	public void testCreate() throws Exception{
		// 创建配置管理类对象
		Configuration config = new Configuration();
		//加载主配置文件
		config.configure();
		
		//创建工具类对象
		SchemaExport export = new SchemaExport(config);
		//建表(第一个true是在控制台显示sql脚本，第二个true是执行sql脚本)
		export.create(true, true);
	}
}
