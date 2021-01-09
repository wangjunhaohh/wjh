package cn.wjh.jf;


import java.util.Collections;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import cn.wjh.dao.sqlOperation;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Color;

public class StockJF extends JInternalFrame {
	private JTable table;
	private JTextField textFieldGYS;
	private JTextField textFieldAddress;
	private JTextField textFieldNum;
	private JTextField textFieldTel;
	private JTextField textFieldGood;
	private JTextField textFieldKind;
	Vector<Vector> row=null;
	String []titles= {"序号","供应商","供应商地址","供应商电话","供货种类","商品","供应数量","进货时间"};
	DefaultTableModel Model=new DefaultTableModel(titles,0);
	DefaultTableModel Model3;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public StockJF() {
		setRootPaneCheckingEnabled(false);
		setBorder(null);
		setFrameIcon(new ImageIcon("D:\\1.jpg"));
		setEnabled(true);
		setClosable(true);
		setBounds(100, 100, 798, 527);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\7.jpeg"));
		lblNewLabel.setBounds(0, 0, 917, 158);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 156, 799, 118);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabelGYS = new JLabel("\u4F9B\u5E94\u5546");
		lblNewLabelGYS.setBounds(35, 285, 96, 28);
		getContentPane().add(lblNewLabelGYS);
		
		textFieldGYS = new JTextField();
		textFieldGYS.setBounds(141, 284, 155, 31);
		getContentPane().add(textFieldGYS);
		textFieldGYS.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(141, 322, 155, 31);
		getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JLabel lblNewLabelAddress = new JLabel("\u4F9B\u8D27\u5546\u5730\u5740");
		lblNewLabelAddress.setBounds(35, 322, 96, 31);
		getContentPane().add(lblNewLabelAddress);
		
		JLabel lblNewLabelNum = new JLabel("\u4F9B\u8D27\u6570\u91CF");
		lblNewLabelNum.setBounds(358, 370, 105, 31);
		getContentPane().add(lblNewLabelNum);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(473, 372, 171, 28);
		getContentPane().add(textFieldNum);
		textFieldNum.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(141, 370, 155, 31);
		getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldGood = new JTextField();
		textFieldGood.setBounds(473, 327, 171, 26);
		getContentPane().add(textFieldGood);
		textFieldGood.setColumns(10);
		
		JLabel lblNewLabelGood = new JLabel("\u5546\u54C1");
		lblNewLabelGood.setBounds(358, 330, 105, 23);
		getContentPane().add(lblNewLabelGood);
		
		JLabel lblNewLabelTel = new JLabel("\u4F9B\u8D27\u5546\u7535\u8BDD");
		lblNewLabelTel.setBounds(35, 363, 96, 38);
		getContentPane().add(lblNewLabelTel);
		
		JLabel lblNewLabelKind = new JLabel("\u4F9B\u8D27\u79CD\u7C7B");
		lblNewLabelKind.setBounds(358, 284, 96, 28);
		getContentPane().add(lblNewLabelKind);
		
		textFieldKind = new JTextField();
		textFieldKind.setBounds(473, 284, 171, 28);
		getContentPane().add(textFieldKind);
		textFieldKind.setColumns(10);
		JButton btnNewButtonGWD = new JButton("\u6DFB\u52A0\u81F3\u8D2D\u7269\u5355");
		btnNewButtonGWD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so1=new sqlOperation();
				so1.sqlOperationAdd(textFieldGYS, textFieldAddress, textFieldTel, textFieldKind, textFieldGood, textFieldNum);
				sqlOperation so=new sqlOperation();
				row=so.getSelectAll();
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","供应商","供应商地址","供应商电话","供货种类","商品","供应数量","进货时间");
				Model3=new DefaultTableModel(row,row2);
				table = new JTable(Model3);
				table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
				
			}
		});
		btnNewButtonGWD.setBounds(188, 433, 149, 38);
		getContentPane().add(btnNewButtonGWD);
		
		JButton btnNewButtonDH = new JButton("\u8BA2\u8D27");
		btnNewButtonDH.setForeground(Color.RED);
		btnNewButtonDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				so.getAll();
				sqlOperation so1=new sqlOperation();
				so1.StockDelete();
				dispose();
				JOptionPane.showMessageDialog(null, "订货成功");
			}
		});
		btnNewButtonDH.setBounds(625, 433, 163, 38);
		getContentPane().add(btnNewButtonDH);
		table = new JTable(Model);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(35, 433, 143, 38);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ChangeJF cjf=new ChangeJF();
//				cjf.setVisible(true);
				sqlOperation so=new sqlOperation();
				row=so.getSelectAll();
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","供应商","供应商地址","供应商电话","供货种类","商品","供应数量","进货时间");
				so.update(table);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(347, 433, 135, 38);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockDeleteJF stjf=new StockDeleteJF();
				stjf.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(492, 433, 123, 38);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u8BA2\u8D27\u5355");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				row=so.getSelectAll();
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","供应商","供应商地址","供应商电话","供货种类","商品","供应数量","进货时间");
				Model3=new DefaultTableModel(row,row2) {
					public Class getColumnClass(int co) {
						return getValueAt(0, co).getClass();
						
					}
				};
				table = new JTable(Model3);
				table.setAutoCreateRowSorter(true);
				scrollPane.setViewportView(table);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\9.jpg"));
		btnNewButton_3.setBounds(688, 331, 74, 70);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u968F\u673A\u6DFB\u52A0\u6570\u636E");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				so.addStock();
			}
		});
		btnNewButton_4.setBounds(665, 288, 97, 23);
		getContentPane().add(btnNewButton_4);
	}
}
