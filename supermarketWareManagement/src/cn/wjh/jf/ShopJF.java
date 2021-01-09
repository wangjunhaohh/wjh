package cn.wjh.jf;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.wjh.dao.sqlOperation;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShopJF extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Vector row=null;
	
	public ShopJF() {
		setTitle("\u51FA\u8D27\u8BB0\u5F55");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 507, 310);
		contentPane.add(scrollPane);
		sqlOperation so=new sqlOperation();
		row=so.ShopAll();
		Vector<String> row2=new Vector<>();
		Collections.addAll(row2, "序号","供货种类","商品","销售数量","购物时间","供应商");
		DefaultTableModel Model=new DefaultTableModel(row,row2);
		table = new JTable(Model);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
	}
}
