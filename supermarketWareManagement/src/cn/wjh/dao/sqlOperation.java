package cn.wjh.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.wjh.dbc.DatabaseConnection;
import cn.wjh.vo.Goods;
import cn.wjh.vo.Stochastic;
import cn.wjh.vo.Stock;
public class sqlOperation {
	String sql="select * from UserIM";
	DatabaseConnection dbcs=new DatabaseConnection();
	/**
	 * 
	 * @param YH
	 * @param MM
	 * @param YZM
	 * @param IntYzm
	 * @return ע���Ƿ�ɹ�
	 */
	//ע���û���
	public boolean sqlOperationAdd(String YH,String MM,String YZM,String IntYzm) {
		String s=null;
		String sql1="insert into UserIM(�û���,����) values(?,?)";
		try(Connection conn=dbcs.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql1);
				PreparedStatement pstmt2=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt2.executeQuery();
    		while(rs.next()) {
    			s=rs.getString(1);
    			if(s.equals(YH)) {
    				JOptionPane.showMessageDialog(null, "�û����Ѵ���");
    				return false;
    			}
    		}
    		if(YH.length()==0) {
    			JOptionPane.showMessageDialog(null, "�û��������ǿ�");
    		}else if(MM.length()==0) {
    			JOptionPane.showMessageDialog(null, "���벻���ǿ�");
    		}else if(!IntYzm.equals(YZM)) {
    			JOptionPane.showMessageDialog(null, "��֤�����");
    		}else {
    			pstmt.setString(1, YH);
    			pstmt.setString(2, MM);
    			pstmt.executeUpdate();
    			JOptionPane.showMessageDialog(null, "ע��ɹ�");
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return false;
	}
	//��¼
	/**
	 * �����¼
	 * @param textFieldYHM
	 * @param passwordFieldMM
	 * @param lblNewLabelCY
	 * @return ��¼�Ƿ�ɹ�
	 */
	public boolean sqlOperationLoad(JTextField textFieldYHM,JPasswordField passwordFieldMM,JLabel lblNewLabelCY) {
		Connection conn=dbcs.getConnection();
		try (PreparedStatement pstmt=conn.prepareStatement(sql);){
			ResultSet rs=pstmt.executeQuery();
			int flag=0;
    		while(rs.next()) {
    			if(rs.getString(1).equals(textFieldYHM.getText())&&rs.getString(2).equals(passwordFieldMM.getText())) {
    				flag=1;
    				return true;
    			}
    		}
    		if(flag==0) {
    			lblNewLabelCY.setText("�û������������");
				return false;
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//��Ӷ�����
	public void sqlOperationAdd(JTextField textFieldGYS,JTextField textFieldAddress,JTextField textFieldTel,JTextField textFieldKind,JTextField textFieldGood,JTextField textFieldNum) {
		String sql="insert into Stock(��Ӧ��,��Ӧ�̵�ַ,��Ӧ�̵绰,��������,��Ʒ,��Ӧ����,����ʱ��) values(?,?,?,?,?,?,?)";
		Stock st=new Stock();
		try(Connection conn=dbcs.getConnection();
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){
				if(textFieldGYS.getText().length()==0||textFieldAddress.getText().length()==0||textFieldTel.getText().length()==0||textFieldKind.getText().length()==0||textFieldGood.getText().length()==0||textFieldNum.getText().length()==0)
					JOptionPane.showMessageDialog(null, "�����������");
				else {
	    		pstmt.setString(1, textFieldGYS.getText());
				pstmt.setString(2, textFieldAddress.getText());
				pstmt.setString(3, textFieldTel.getText());
				pstmt.setString(4, textFieldKind.getText());
				pstmt.setString(5, textFieldGood.getText());
				pstmt.setString(6, textFieldNum.getText());
				pstmt.setString(7, st.getTime());
				pstmt.executeUpdate();
				textFieldGYS.setText("");
				textFieldAddress.setText("");
				textFieldTel.setText("");
				textFieldKind.setText("");
				textFieldGood.setText("");
				textFieldNum.setText("");
				}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
		
	}
	//��ȡ���ж���������
	public  Vector<Vector> getSelectAll(){
		String sql="select * from Stock";
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt.executeQuery();
    		int i=1;
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(i);
    			row.add(rs.getString(1));
    			row.add(rs.getString(2));
    			row.add(rs.getString(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			row.add(rs.getInt(6));
    			row.add(rs.getString(7));
    			rows.add(row);//����������ӵ���¼������
    			i++;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
	//�޸Ķ���������
	public void sqlOperationChange(JTextField textFieldGYS,JTextField textFieldAddress,JTextField textFieldTel,JTextField textFieldKind,JTextField textFieldGood,JTextField textFieldNum) {
		String sql2="insert into Stock(��Ӧ��,��Ӧ�̵�ַ,��Ӧ�̵绰,��������,��Ʒ,��Ӧ����,����ʱ��) values(?,?,?,?,?,?,?)";
		Connection conn=dbcs.getConnection();
		Stock st=new Stock();
		String sql="select *from Stock";
		String sql3="delete from Stock where ��Ӧ��=?";
		int i=0;
    	try{PreparedStatement pstmt=conn.prepareStatement(sql2);
    			PreparedStatement pstmt2=conn.prepareStatement(sql);
    			PreparedStatement pstmt3=conn.prepareStatement(sql3);
			ResultSet rs=pstmt2.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(textFieldGYS.getText())) {
					pstmt3.setString(1, textFieldGYS.getText());
					pstmt3.executeUpdate();
					pstmt.setString(1, textFieldGYS.getText());
					pstmt.setString(2, textFieldAddress.getText());
					pstmt.setString(3, textFieldTel.getText());
					pstmt.setString(4, textFieldKind.getText());
					pstmt.setString(5, textFieldGood.getText());
					pstmt.setString(6, textFieldNum.getText());
					pstmt.setString(7, st.getTime());
					pstmt.executeUpdate();
					i=1;
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				}
			}
			if(i==0) {
				JOptionPane.showMessageDialog(null, "�ò���������");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//��ն���������
	public void StockDelete() {
		String sql="delete from Stock";
		Connection conn=dbcs.getConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//ɾ�����������ݰ���Ʒ��
	public void salOperationDelete(JTextField textField) {
		String sql="delete from Stock where ��Ʒ=?";
		String sql2="select * from Stock";
		int i=0;
		Connection conn=dbcs.getConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(sql);
				PreparedStatement pstmt2=conn.prepareStatement(sql2);
				ResultSet rs=pstmt2.executeQuery()) {
			while(rs.next()) {
				if(rs.getString(5).equals(textField.getText())) {
					pstmt.setString(1, textField.getText());
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					i=1;
				}
				
			}
			if(i==0) {
				JOptionPane.showMessageDialog(null, "�ò���������");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//����ֿ�����
	public  void getAll(){
		String sql="select * from Stock";
		String sql2="insert into Goods(��Ʒ����,��Ʒ��,������,�����,���ʱ��) values(?,?,?,?,?)";
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);
    			PreparedStatement pstmt2=conn.prepareStatement(sql2);){
    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()) {//�������ݼ�
    			pstmt2.setString(1, rs.getString(4));
    			pstmt2.setString(2, rs.getString(5));
    			pstmt2.setString(3, rs.getString(1));
    			pstmt2.setString(4, rs.getString(6));
    			pstmt2.setString(5, rs.getString(7));
    			pstmt2.executeUpdate();
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	//��ȡ�ֿ�������
	public Vector<Vector> WareAll(){
		String sql="select * from Goods";
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt.executeQuery();
    		int i=1;
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(i);
    			row.add(rs.getString(1));
    			row.add(rs.getString(2));
    			row.add(rs.getInt(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			rows.add(row);//����������ӵ���¼������
    			i++;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
	//��ѯ�ֿ�����
	public Vector<Vector> WareQuery(JTextField textFieldKind,JTextField textFieldTime) {
		String sql="select * from  Goods";
		Connection conn=dbcs.getConnection();
		int i=1;
		String s=null;
		String s2=null;
		Vector<Vector> rows=new Vector<>();
		if(textFieldKind.getText().length()==0) {
			s="��";
		}else {
			s=textFieldKind.getText();
		}
		if(textFieldTime.getText().length()==0) {
			s2="��";
		}else {
			s2=textFieldTime.getText();
		}
		try (PreparedStatement pstmt=conn.prepareStatement(sql);){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).contains(s)||rs.getString(4).contains(s2)) {
					Vector row=new Vector();
					row.add(i);
					row.add(rs.getString(1));
					row.add(rs.getString(2));
					row.add(rs.getString(3));
					row.add(rs.getString(4));
					row.add(rs.getString(5));
					rows.add(row);
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	public Vector<Vector> WareQuery2(JTextField textFieldKind,JTextField textFieldTime) {
		String sql="select * from  Goods";
		Connection conn=dbcs.getConnection();
		int i=1;
		String s=null;
		String s2=null;
		Vector<Vector> rows=new Vector<>();
		if(textFieldKind.getText().length()==0) {
			s="��";
		}else {
			s=textFieldKind.getText();
		}
		if(textFieldTime.getText().length()==0) {
			s2="��";
		}else {
			s2=textFieldTime.getText();
		}
		try (PreparedStatement pstmt=conn.prepareStatement(sql);){
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).contains(s)&&rs.getString(4).contains(s2)) {
					Vector row=new Vector();
					row.add(i);
					row.add(rs.getString(1));
					row.add(rs.getString(2));
					row.add(rs.getString(3));
					row.add(rs.getString(4));
					row.add(rs.getString(5));
					rows.add(row);
					i++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	//�����߹��ﲢ��������ﵥ
	public void Shopping(JTextField textFieldKind,JTextField textFieldGood,JTextField textFieldNum,JTextField textFieldGHS,JTextField textFieldDate) {
		Goods g=new Goods();
		String sql2="select * from Goods";
		int i=0;
		String sql3="insert into shoplist(��Ʒ����,��Ʒ��,����,����ʱ��,������) values(?,?,?,?,?)";
		String sql="update Goods set �����=? where ��Ʒ����='"+textFieldKind.getText()+"' and ��Ʒ��= '"+textFieldGood.getText()+ "'and ������='"+textFieldGHS.getText()+"'";
		Connection conn=dbcs.getConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(sql);
				PreparedStatement pstmt2=conn.prepareStatement(sql2);
				PreparedStatement pstmt3=conn.prepareStatement(sql3);
				ResultSet rs=pstmt2.executeQuery();) {
			while(rs.next()) {
				if((rs.getString(1).equals(textFieldKind.getText()))&&(rs.getString(2).equals(textFieldGood.getText()))&&(rs.getString(5).equals(textFieldGHS.getText()))&&(rs.getString(4).equals(textFieldDate.getText()))) {
					if(rs.getInt(3)-Integer.parseInt(textFieldNum.getText())>=0) {
						pstmt.setInt(1, rs.getInt(3)-Integer.parseInt(textFieldNum.getText()));
						pstmt.executeUpdate();
						pstmt3.setString(1, textFieldKind.getText());
						pstmt3.setString(2, textFieldGood.getText());
						pstmt3.setString(3, textFieldNum.getText());
						pstmt3.setString(4,g.getTime());
						pstmt3.setString(5, textFieldGHS.getText());
						pstmt3.executeUpdate();
						textFieldGHS.setText("");
						textFieldGood.setText("");
						textFieldKind.setText("");
						textFieldNum.setText("");
						JOptionPane.showMessageDialog(null, "����ɹ�");
					}else {
						textFieldNum.setText("");
						JOptionPane.showMessageDialog(null, "�������㣬����������");
					}
					i=1;
				}
			}
			if(i==0) {
				JOptionPane.showMessageDialog(null, "��Ʒ������,��������");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//��ȡ����������
	public Vector<Vector> ShopAll(){
		String sql="select * from Shoplist";
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt.executeQuery();
    		int i=1;
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(i);
    			row.add(rs.getString(1));
    			row.add(rs.getString(2));
    			row.add(rs.getString(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			rows.add(row);//����������ӵ���¼������
    			i++;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
	//����޸Ĳ�������
	public void update(JTable model) {
			DatabaseConnection dbcs=new DatabaseConnection();
			String sql="update Stock set ��Ӧ�̵�ַ=?,��Ӧ�̵绰=?,��������=?,��Ʒ=?,��Ӧ����=? where ��Ӧ��=?";
			try(Connection conn=dbcs.getConnection();
					PreparedStatement pstmt=conn.prepareStatement(sql);) {
				for(int i=0;i<model.getRowCount();i++) {
					pstmt.setString(1,  model.getValueAt(i, 2).toString());
					pstmt.setString(2,  model.getValueAt(i, 3).toString());
					pstmt.setString(3, model.getValueAt(i, 4).toString());
					pstmt.setInt(4,  Integer.parseInt(model.getValueAt(i, 5).toString()));
					pstmt.setString(5,  model.getValueAt(i, 6).toString());
					pstmt.setString(6,  model.getValueAt(i, 1).toString());
					pstmt.executeUpdate();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	//������һ��������
	public void add() {
		Stochastic st=new Stochastic();
		String sql="insert into Goods(��Ʒ����,��Ʒ��,������,�����,���ʱ��) values(?,?,?,?,?)";
		Connection conn=dbcs.getConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			for(int i=0;i<10000;i++) {
				String s[]=st.getGoods().split(" ");
				pstmt.setString(1, s[2]);
				pstmt.setString(2, s[1]);
				pstmt.setString(3, s[0]);
				pstmt.setInt(4, st.getNum(0, 1000));
				pstmt.setString(5, st.getTime());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//�Ѳֿ�����д��excel���
	public void qurey() throws IOException  {
		String sql="select * from Goods";
		Connection conn=dbcs.getConnection();
		int i=1;
		String excelFile="d:/ware.xlsx";
		Workbook wb=new XSSFWorkbook();
		Sheet sheet=wb.createSheet("�ֿ�");
		FileOutputStream fileout=new FileOutputStream(excelFile);
				
		Row row=sheet.createRow(0);
		Cell c=row.createCell(0);
		c.setCellValue("��Ʒ����");
		row.createCell(1).setCellValue("��Ʒ��");
		row.createCell(2).setCellValue("���");
		row.createCell(3).setCellValue("���ʱ��");
		row.createCell(4).setCellValue("������");
		
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(i);
				Row row2=sheet.createRow(i);
				row2.createCell(0).setCellValue(rs.getString(1));
				row2.createCell(1).setCellValue(rs.getString(2));
				row2.createCell(2).setCellValue(rs.getString(3));
				row2.createCell(3).setCellValue(rs.getString(4));
				row2.createCell(4).setCellValue(rs.getString(5));
				i++;
				
				
			}
			wb.write(fileout);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//������һ������������
	public void addStock() {
		Stochastic st=new Stochastic();
		String sql="insert into Stock(��Ӧ��,��Ӧ�̵�ַ,��Ӧ�̵绰,��������,��Ʒ,��Ӧ����,����ʱ��) values(?,?,?,?,?,?,?)";
		Connection conn=dbcs.getConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			for(int i=0;i<10000;i++) {
				String s[]=st.getGoods().split(" ");
				pstmt.setString(1, s[0]);			
				pstmt.setString(2, st.getAddress());
				pstmt.setString(3, st.getTel());
				pstmt.setString(4, s[2]);
				pstmt.setString(5, s[1]);
				pstmt.setInt(6, st.getNum(0, 1000));
				pstmt.setString(7, st.getTime());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
