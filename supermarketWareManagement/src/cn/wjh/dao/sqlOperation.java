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
	 * @return 注册是否成功
	 */
	//注册用户名
	public boolean sqlOperationAdd(String YH,String MM,String YZM,String IntYzm) {
		String s=null;
		String sql1="insert into UserIM(用户名,密码) values(?,?)";
		try(Connection conn=dbcs.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql1);
				PreparedStatement pstmt2=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt2.executeQuery();
    		while(rs.next()) {
    			s=rs.getString(1);
    			if(s.equals(YH)) {
    				JOptionPane.showMessageDialog(null, "用户名已存在");
    				return false;
    			}
    		}
    		if(YH.length()==0) {
    			JOptionPane.showMessageDialog(null, "用户名不能是空");
    		}else if(MM.length()==0) {
    			JOptionPane.showMessageDialog(null, "密码不能是空");
    		}else if(!IntYzm.equals(YZM)) {
    			JOptionPane.showMessageDialog(null, "验证码错误");
    		}else {
    			pstmt.setString(1, YH);
    			pstmt.setString(2, MM);
    			pstmt.executeUpdate();
    			JOptionPane.showMessageDialog(null, "注册成功");
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return false;
	}
	//登录
	/**
	 * 检验登录
	 * @param textFieldYHM
	 * @param passwordFieldMM
	 * @param lblNewLabelCY
	 * @return 登录是否成功
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
    			lblNewLabelCY.setText("用户名或密码错误");
				return false;
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//添加订货单
	public void sqlOperationAdd(JTextField textFieldGYS,JTextField textFieldAddress,JTextField textFieldTel,JTextField textFieldKind,JTextField textFieldGood,JTextField textFieldNum) {
		String sql="insert into Stock(供应商,供应商地址,供应商电话,供货种类,商品,供应数量,进货时间) values(?,?,?,?,?,?,?)";
		Stock st=new Stock();
		try(Connection conn=dbcs.getConnection();
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){
				if(textFieldGYS.getText().length()==0||textFieldAddress.getText().length()==0||textFieldTel.getText().length()==0||textFieldKind.getText().length()==0||textFieldGood.getText().length()==0||textFieldNum.getText().length()==0)
					JOptionPane.showMessageDialog(null, "请勿填空数据");
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
	//读取所有订单行数据
	public  Vector<Vector> getSelectAll(){
		String sql="select * from Stock";
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt.executeQuery();
    		int i=1;
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(i);
    			row.add(rs.getString(1));
    			row.add(rs.getString(2));
    			row.add(rs.getString(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			row.add(rs.getInt(6));
    			row.add(rs.getString(7));
    			rows.add(row);//将行数据添加到记录集合中
    			i++;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
    }
	//修改订货单数据
	public void sqlOperationChange(JTextField textFieldGYS,JTextField textFieldAddress,JTextField textFieldTel,JTextField textFieldKind,JTextField textFieldGood,JTextField textFieldNum) {
		String sql2="insert into Stock(供应商,供应商地址,供应商电话,供货种类,商品,供应数量,进货时间) values(?,?,?,?,?,?,?)";
		Connection conn=dbcs.getConnection();
		Stock st=new Stock();
		String sql="select *from Stock";
		String sql3="delete from Stock where 供应商=?";
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
					JOptionPane.showMessageDialog(null, "修改成功");
				}
			}
			if(i==0) {
				JOptionPane.showMessageDialog(null, "该参数不存在");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//清空订货单数据
	public void StockDelete() {
		String sql="delete from Stock";
		Connection conn=dbcs.getConnection();
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除订货单数据按商品名
	public void salOperationDelete(JTextField textField) {
		String sql="delete from Stock where 商品=?";
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
					JOptionPane.showMessageDialog(null, "删除成功");
					i=1;
				}
				
			}
			if(i==0) {
				JOptionPane.showMessageDialog(null, "该参数不存在");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//加入仓库数据
	public  void getAll(){
		String sql="select * from Stock";
		String sql2="insert into Goods(商品种类,商品名,供货商,库存数,库存时间) values(?,?,?,?,?)";
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);
    			PreparedStatement pstmt2=conn.prepareStatement(sql2);){
    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()) {//遍历数据集
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
	//读取仓库行数据
	public Vector<Vector> WareAll(){
		String sql="select * from Goods";
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt.executeQuery();
    		int i=1;
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(i);
    			row.add(rs.getString(1));
    			row.add(rs.getString(2));
    			row.add(rs.getInt(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			rows.add(row);//将行数据添加到记录集合中
    			i++;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
    }
	//查询仓库数据
	public Vector<Vector> WareQuery(JTextField textFieldKind,JTextField textFieldTime) {
		String sql="select * from  Goods";
		Connection conn=dbcs.getConnection();
		int i=1;
		String s=null;
		String s2=null;
		Vector<Vector> rows=new Vector<>();
		if(textFieldKind.getText().length()==0) {
			s="难";
		}else {
			s=textFieldKind.getText();
		}
		if(textFieldTime.getText().length()==0) {
			s2="难";
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
			s="难";
		}else {
			s=textFieldKind.getText();
		}
		if(textFieldTime.getText().length()==0) {
			s2="难";
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
	//消费者购物并添加至购物单
	public void Shopping(JTextField textFieldKind,JTextField textFieldGood,JTextField textFieldNum,JTextField textFieldGHS,JTextField textFieldDate) {
		Goods g=new Goods();
		String sql2="select * from Goods";
		int i=0;
		String sql3="insert into shoplist(商品种类,商品名,数量,购买时间,供货商) values(?,?,?,?,?)";
		String sql="update Goods set 库存数=? where 商品种类='"+textFieldKind.getText()+"' and 商品名= '"+textFieldGood.getText()+ "'and 供货商='"+textFieldGHS.getText()+"'";
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
						JOptionPane.showMessageDialog(null, "购买成功");
					}else {
						textFieldNum.setText("");
						JOptionPane.showMessageDialog(null, "数量不足，请重新输入");
					}
					i=1;
				}
			}
			if(i==0) {
				JOptionPane.showMessageDialog(null, "商品不存在,重新输入");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//读取订货单数据
	public Vector<Vector> ShopAll(){
		String sql="select * from Shoplist";
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	try(Connection conn=dbcs.getConnection();
	    	PreparedStatement pstmt=conn.prepareStatement(sql);){
    		ResultSet rs=pstmt.executeQuery();
    		int i=1;
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(i);
    			row.add(rs.getString(1));
    			row.add(rs.getString(2));
    			row.add(rs.getString(3));
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			rows.add(row);//将行数据添加到记录集合中
    			i++;
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
    }
	//表格修改操作数据
	public void update(JTable model) {
			DatabaseConnection dbcs=new DatabaseConnection();
			String sql="update Stock set 供应商地址=?,供应商电话=?,供货种类=?,商品=?,供应数量=? where 供应商=?";
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
	//随机添加一万条数据
	public void add() {
		Stochastic st=new Stochastic();
		String sql="insert into Goods(商品种类,商品名,供货商,库存数,库存时间) values(?,?,?,?,?)";
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
	//把仓库数据写到excel表格
	public void qurey() throws IOException  {
		String sql="select * from Goods";
		Connection conn=dbcs.getConnection();
		int i=1;
		String excelFile="d:/ware.xlsx";
		Workbook wb=new XSSFWorkbook();
		Sheet sheet=wb.createSheet("仓库");
		FileOutputStream fileout=new FileOutputStream(excelFile);
				
		Row row=sheet.createRow(0);
		Cell c=row.createCell(0);
		c.setCellValue("商品种类");
		row.createCell(1).setCellValue("商品名");
		row.createCell(2).setCellValue("库存");
		row.createCell(3).setCellValue("库存时间");
		row.createCell(4).setCellValue("供货商");
		
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
	//随机添加一万条订货数据
	public void addStock() {
		Stochastic st=new Stochastic();
		String sql="insert into Stock(供应商,供应商地址,供应商电话,供货种类,商品,供应数量,进货时间) values(?,?,?,?,?,?,?)";
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
