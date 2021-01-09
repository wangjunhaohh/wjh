package cn.wjh.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
public class Stock {
	private String Num;
	private String name;
	private int count;
	private String time;
	private String tel;
	private String kind;
	private String GoodName;
	Vector<Vector> rows=new Vector<>();
	public String getNum() {
		return Num;
	}
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public String getTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//格式化时间
		Date date = new Date();
		time= simpleDateFormat.format(date);
		return time;
	}
	public String getTel() {
		return tel;
	}
	public String getKind() {
		return kind;
	}	
	public String getGoodName() {
		return GoodName;
	}
//	public Vector<Vector> add(JTextField textFieldGYS,JTextField textFieldAddress,JTextField textFieldTel,JTextField textFieldKind,JTextField textFieldGood,JTextField textFieldNum){
//		
//		Vector row=new Vector();
//		row.add(textFieldGYS.getText());
//		row.add(textFieldAddress.getText());
//		row.add(textFieldTel.getText());
//		row.add(textFieldKind.getText());
//		row.add(textFieldGood.getText());
//		row.add(textFieldNum.getText());
//		row.add(getTime());
//		rows.add(row);
//		
//		return rows;
//		
//	}
	
}
