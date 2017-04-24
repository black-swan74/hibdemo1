package cn.gc.hib;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;



public class App2{
	
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
	public void testInster() throws Exception {

		Employee emp = new Employee();
		
		emp.setEmpName("张三");
		emp.setWorkDate(new Date());
		
		
		//创建session（代表一个会话，与数据库连接的会话）
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		//保存数据库
		session.save(emp);
		//提交事务
		tx.commit();
		//关闭
		session.close();
		sf.close();
	}
	
	
	//更新数据
		@Test
		public void testUpdate() throws Exception {

			Employee emp = new Employee();
			
			//将id为1的empName更新为张三（data为null）
			emp.setEmpId(1);
			emp.setEmpName("张三");
			//emp.setWorkDate(new Date());
			
			
			//创建session（代表一个会话，与数据库连接的会话）
			Session session = sf.openSession();
			//开启事务
			Transaction tx = session.beginTransaction();
			
			/*//更新数据（必须要主键，非主键都要改，否则为null，所以更新前先查询）
			session.update(emp);
			
			*/
			
			//没有设置主键，执行保存；有设置主键，执行更新操作；如果设置主键不存在报错
			session.saveOrUpdate(emp);
			
			
			//查询主键为1的数据
			//load支持懒加载：Employee employee = (Employee) session.load(Employee.class, 1);
			//用get会比较多
			Employee employee = (Employee) session.get(Employee.class, 1);
			
			System.out.println(employee);
			//提交事务
			tx.commit();
			//关闭
			session.close();
			sf.close();
		}
	
	//删除数据
		
		@Test
		public void testDelete() throws Exception {

			
			//创建session（代表一个会话，与数据库连接的会话）
			Session session = sf.openSession();
			//开启事务
			Transaction tx = session.beginTransaction();
			
			Object obj=session.get(Employee.class, 1);
			//删除数据
			if(obj != null){
			
				session.delete(obj);
			}
			//提交事务
			tx.commit();
			//关闭
			session.close();
			sf.close();
		}

}
