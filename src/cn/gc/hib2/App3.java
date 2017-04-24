package cn.gc.hib2;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		public void testSave() throws Exception {

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			CompositeKeys keys = new CompositeKeys();
			keys.setAddress("����2");
			keys.setUserName("���2");
			
			User user = new User();
			user.setAge(22);
			user.setKeys(keys);
			
			session.save(user);
			
			//�ύ����
			tx.commit();
			//�ر�
			session.close();
			sf.close();
		}
	
	
		

}
