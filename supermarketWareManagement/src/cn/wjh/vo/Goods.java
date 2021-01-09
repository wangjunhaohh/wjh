package cn.wjh.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {
	private String Kind;
	private String name;
	private int count;
	private String time;
	private String StockName;
	public String getKind() {
		return Kind;
	}
	public void setNum(String Kind) {
		this.Kind = Kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
	public String getTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");//格式化时间
		Date date = new Date();
		time= simpleDateFormat.format(date);
		return time;
	}
	
}
