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
		
		/*//��ȡ���������ļ��Ĺ��������			
		Configuration config = new Configuration();
		config.configure();//Ĭ�ϼ���src/hibenrate.cfg.xml
		//����session�Ĺ�������
		sf = config.buildSessionFactory();*/
		
		sf=new Configuration().configure().buildSessionFactory();
	}
	
	
	
	//��������
		@Test
		public void testUpdate() throws Exception {

			Employee emp = new Employee();
			
			//��idΪ1��empName����Ϊ������dataΪnull��
			//emp.setEmpId(1);
			emp.setEmpName("����");
			//emp.setWorkDate(new Date());
			
			
			//����session������һ���Ự�������ݿ����ӵĻỰ��
			Session session = sf.openSession();
			//��������
			Transaction tx = session.beginTransaction();
			
		
			/*
			 * //��ѯ����Ϊ1������
			//load֧�������أ�Employee employee = (Employee) session.load(Employee.class, 1);
			//��get��Ƚ϶�
			Employee employee = (Employee) session.get(Employee.class, 1);
			
			*/
			
			
			//HQL��ѯ����ѯȫ��(�����ݿ����)�������õ���ࣩ
			//Query q = session.createQuery("from Employee");
			//Query q = session.createQuery("from Employee where id=1 or id=9");
			//Query q = session.createQuery("from Employee where empId=1 or empId=9");
			
			Query q = session.createQuery("from Employee where empName=?");
			q.setParameter(0, "����");

			List<Employee> list = q.list();
			System.out.println(list);
			
			
			/*//QBC��ѯ����ȫ��������ѯ
			
			Criteria cr=session.createCriteria(Employee.class);
			//��Ӳ�ѯ����(empIdΪ1������)
			cr.add(Restrictions.eq("empId", 1));
			List<Employee> list = cr.list();
			System.out.println(list);
			*/
			
			
			//�ύ����
			tx.commit();
			//�ر�
			session.close();
			sf.close();
		}
	
	
		//ɾ������
		
				@Test
				public void testDelete() throws Exception {

					
					//����session������һ���Ự�������ݿ����ӵĻỰ��
					Session session = sf.openSession();
					//��������
					Transaction tx = session.beginTransaction();
					
					Object obj=session.get(Employee.class, 1);
					//ɾ������
					if(obj != null){
					
						session.delete(obj);
					}
					//�ύ����
					tx.commit();
					//�ر�
					session.close();
					sf.close();
				}

}
