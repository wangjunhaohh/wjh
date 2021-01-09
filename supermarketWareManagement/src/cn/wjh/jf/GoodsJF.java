package cn.wjh.jf;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.wjh.dao.Page;
import cn.wjh.dao.sqlOperation;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class GoodsJF extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldKind;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField textFieldTime;
	Vector<Vector> rows=null;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	public GoodsJF() {
		setTitle("\u4ED3\u5E93");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 134, 638, 267);
		contentPane.add(scrollPane);
		Vector<String> row2=new Vector<>();
		Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
		sqlOperation so=new sqlOperation();
		Vector row=so.WareAll();
		DefaultTableModel Model3=new DefaultTableModel(row,row2);
		table = new JTable(Model3);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		textFieldKind = new JTextField();
		textFieldKind.setBounds(119, 70, 111, 28);
		contentPane.add(textFieldKind);
		textFieldKind.setColumns(10);
		
		lblNewLabel = new JLabel("\u79CD\u7C7B");
		lblNewLabel.setBounds(56, 69, 69, 28);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				rows=so.WareQuery(textFieldKind, textFieldTime);
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
				DefaultTableModel Model=new DefaultTableModel(rows,row2);
				table = new JTable(Model);
				table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton.setBounds(425, 69, 87, 28);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("\u8FDB\u8D27\u65F6\u95F4");
		lblNewLabel_1.setBounds(240, 69, 61, 28);
		contentPane.add(lblNewLabel_1);
		
		textFieldTime = new JTextField();
		textFieldTime.setBounds(304, 70, 111, 28);
		contentPane.add(textFieldTime);
		textFieldTime.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\10.jpg"));
		lblNewLabel_2.setBounds(64, 10, 549, 56);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("\u7CBE\u786E\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				rows=so.WareQuery2(textFieldKind, textFieldTime);
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
				DefaultTableModel Model=new DefaultTableModel(rows,row2);
				table = new JTable(Model);
				table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(516, 69, 97, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u968F\u673A\u4EA7\u751F\u6570\u636E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so1=new sqlOperation();
				so1.add();
				
			}
		});
		btnNewButton_2.setBounds(35, 96, 74, 28);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				rows=so.WareAll();
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
				DefaultTableModel Model=new DefaultTableModel(rows,row2) {
					public Class getColumnClass(int co) {
						return getValueAt(0, co).getClass();
						
					}
				};
				table = new JTable(Model);
				table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_3.setBounds(627, 63, 39, 35);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
				DefaultTableModel model=new DefaultTableModel(new Page().nextPage(),row2);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnNewButton_4.setBounds(215, 99, 97, 23);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("\u4E0A\u4E00\u9875");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=new DefaultTableModel(new Page().prePage(),row2);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnNewButton_5.setBounds(119, 99, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20,100,200,1000});
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
				Page pcl=new Page();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
				DefaultTableModel model=new DefaultTableModel(pcl.getPaegData(),row2);//设置数据模型
				table.setModel(model);//设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(5);//设置下拉框默认值
		comboBox.setBounds(314, 99, 61, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton_6 = new JButton("\u52A0\u5165\u5230excel\u8868\u683C");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				try {
					so.qurey();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(380, 99, 132, 25);
		contentPane.add(btnNewButton_6);
		
	}
}
