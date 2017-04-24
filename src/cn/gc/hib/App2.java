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
		
		/*//��ȡ���������ļ��Ĺ��������			
		Configuration config = new Configuration();
		config.configure();//Ĭ�ϼ���src/hibenrate.cfg.xml
		//����session�Ĺ�������
		sf = config.buildSessionFactory();*/
		
		sf=new Configuration().configure().buildSessionFactory();
	}
	
	//��������
	@Test
	public void testInster() throws Exception {

		Employee emp = new Employee();
		
		emp.setEmpName("����");
		emp.setWorkDate(new Date());
		
		
		//����session������һ���Ự�������ݿ����ӵĻỰ��
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		//�������ݿ�
		session.save(emp);
		//�ύ����
		tx.commit();
		//�ر�
		session.close();
		sf.close();
	}
	
	
	//��������
		@Test
		public void testUpdate() throws Exception {

			Employee emp = new Employee();
			
			//��idΪ1��empName����Ϊ������dataΪnull��
			emp.setEmpId(1);
			emp.setEmpName("����");
			//emp.setWorkDate(new Date());
			
			
			//����session������һ���Ự�������ݿ����ӵĻỰ��
			Session session = sf.openSession();
			//��������
			Transaction tx = session.beginTransaction();
			
			/*//�������ݣ�����Ҫ��������������Ҫ�ģ�����Ϊnull�����Ը���ǰ�Ȳ�ѯ��
			session.update(emp);
			
			*/
			
			//û������������ִ�б��棻������������ִ�и��²���������������������ڱ���
			session.saveOrUpdate(emp);
			
			
			//��ѯ����Ϊ1������
			//load֧�������أ�Employee employee = (Employee) session.load(Employee.class, 1);
			//��get��Ƚ϶�
			Employee employee = (Employee) session.get(Employee.class, 1);
			
			System.out.println(employee);
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
