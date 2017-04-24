package cn.gc.hib2;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.junit.Test;



public class App3{
	
	private static SessionFactory sf;
	
	static{
		
		/*//获取加载配置文件的管理类对象			
		Configuration config = new Configuration();
		config.configure();//默认加载src/hibenrate.cfg.xml
		//创建session的工厂对象
		sf = config.buildSessionFactory();*/
		
		sf=new Configuration().configure().buildSessionFactory();
	}
	
	
	
	//保存数据
		@Test
		public void testSave() throws Exception {

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			CompositeKeys keys = new CompositeKeys();
			keys.setAddress("西安2");
			keys.setUserName("尼采2");
			
			User user = new User();
			user.setAge(22);
			user.setKeys(keys);
			
			session.save(user);
			
			//提交事务
			tx.commit();
			//关闭
			session.close();
			sf.close();
		}
	
	
		

}
