package cn.gc.hib;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
	
	
	
	//更新数据
		@Test
		public void testUpdate() throws Exception {

			Employee emp = new Employee();
			
			//将id为1的empName更新为张三（data为null）
			//emp.setEmpId(1);
			emp.setEmpName("张三");
			//emp.setWorkDate(new Date());
			
			
			//创建session（代表一个会话，与数据库连接的会话）
			Session session = sf.openSession();
			//开启事务
			Transaction tx = session.beginTransaction();
			
		
			/*
			 * //查询主键为1的数据
			//load支持懒加载：Employee employee = (Employee) session.load(Employee.class, 1);
			//用get会比较多
			Employee employee = (Employee) session.get(Employee.class, 1);
			
			*/
			
			
			//HQL查询，查询全部(有数据库基础)（开发用的最多）
			//Query q = session.createQuery("from Employee");
			//Query q = session.createQuery("from Employee where id=1 or id=9");
			//Query q = session.createQuery("from Employee where empId=1 or empId=9");
			
			Query q = session.createQuery("from Employee where empName=?");
			q.setParameter(0, "张三");

			List<Employee> list = q.list();
			System.out.println(list);
			
			
			/*//QBC查询，完全面向对象查询
			
			Criteria cr=session.createCriteria(Employee.class);
			//添加查询条件(empId为1的数据)
			cr.add(Restrictions.eq("empId", 1));
			List<Employee> list = cr.list();
			System.out.println(list);
			*/
			
			
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
