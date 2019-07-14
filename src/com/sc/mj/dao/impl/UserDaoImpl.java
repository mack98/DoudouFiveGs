package com.sc.mj.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sc.mj.dao.UserDao;
import com.sc.mj.mapper.MobileMapper;
import com.sc.mj.pojo.MobileCard;
import com.sc.mj.pojo.Record;





public class UserDaoImpl implements UserDao{
	InputStream is;
	//�û�ע��
	public int userRegDao(MobileCard mc) {
	
		
		try {
			is = Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession(true);
			MobileCard m=mc;
			int index=session.insert("a.b.insM",m);
			if(index>0) {
				System.out.println("�����ɹ�");
			}else {
				System.out.println("ʧ��");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
//�û���¼У��
	@Override
	public MobileCard userLoginDao(String uname, String pwd) {
		// TODO Auto-generated method stub
		MobileCard mm=null;
		try {
			is=Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new  SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession(true);
			List<MobileCard> list=session.selectList("a.b.sell");
//			List<ServicePackage> list=session.selectList("a.package.selP");
//			for(ServicePackage sp:list) {
//				System.out.println(sp);
//			}
			
			
			for(MobileCard mc:list) {
				if(mc.getCardNumber().equals(uname)&&mc.getPassWord().equals(pwd)) {
					System.out.println("��¼�ɹ�");
					mm=mc;
				}
				else if(mc.getUserName().equals(uname)&&mc.getPassWord().equals(pwd)) {
					System.out.println("��¼�ɹ�");
					mm=mc;
				}else {
					System.out.println("��¼ʧ��");
					
				}
				
			}
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mm);
		return mm;
	}
	
	//��Ǯ
	@Override
	public int upChargeDao(String num, double money,Record r) {
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		
		
		// ��������
		int index=-1;
		try {
			is=Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new  SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession(true);
			session.insert("a.b.addR", r);
			
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/doudou", "root", "password");
			System.out.println("========================================"+num+money);
			//����sql����
			String sql="UPDATE mobile set money=money+? where cardNumber=? ";
			//����sql�������
			ps=conn.prepareStatement(sql);	
			//��ռλ����ֵ
			ps.setDouble(1,money);
			ps.setString(2, num);
			index=ps.executeUpdate();
			System.out.println(index);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
	}
	
	//������ѵ�
	@Override
	public int addRecordDao(Record r, MobileCard mc) {
		// TODO Auto-generated method stub
		InputStream is;
		try {
			is = Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession(true);
			System.out.println(r);
			System.out.println(mc);
			int index=session.insert("a.b.addR",r);
			int y=session.update("a.b.upm",mc);
			System.out.println(index+"======================"+y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//��ȡ��Record��Ϣ
	@Override
	public List<Record> getInfoRecordDao(MobileCard mc) {
		// TODO Auto-generated method stub
		InputStream is;
		List<Record> list = null;
		try {
			is = Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession(true);
			System.out.println(mc);
			list=session.selectList("a.b.selR", mc);
			for(Record r:list) {
				System.out.println(r);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//�����ײ�ʣ���ѯ
	@Override
	public MobileCard getShowDao(MobileCard mc) {
		// TODO Auto-generated method stub
		MobileCard mccs = null;
		try {
			is=Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new  SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession(true);
			List<MobileCard> list=session.selectList("a.b.sell");
			
			for(MobileCard mcc:list) {
				if(mc.getCardNumber().equals(mcc.getCardNumber())) {
					mccs=mcc;
				}else {
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mccs;
	}
	
	//����ײ�
	@Override
	public int changeDao(MobileCard mc,Record r) {
		// TODO Auto-generated method stub
		int index = 0;
		try {
			is=Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new  SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession(true);
			index=session.update("a.b.upt",mc);
			addRecordDao(r,mc);
			System.out.println(index);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return index;
	}
	
	//����
	@Override
	public int quitDao(MobileCard mc) {
		// TODO Auto-generated method stub
		
		try {
			is=Resources.getResourceAsStream("mybaits.xml");
			SqlSessionFactory factory=new  SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession();
			System.out.println(mc);
			MobileMapper d=session.getMapper(MobileMapper.class);
			String card=mc.getCardNumber();
			d.delm(card);
			d.delr(card);
			session.commit();
			session.close();
			//int a=session.delete("a.b.delm");
			//int b=session.delete("a.b.delr");
			//System.out.println(a+"============="+b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return 0;
	}


}
