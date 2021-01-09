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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UserJF extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textFieldKind;
	private JLabel lblNewLabel_1;
	private JTextField textFieldNum;
	private JLabel lblNewLabel_2;
	private JTextField textFieldGood;
	private JTextField textFieldGHS;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JTextField textFieldDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserJF frame = new UserJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserJF() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\11.jpg"));
		setTitle("\u8D2D\u7269");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 10, 607, 176);
		contentPane.add(scrollPane);
		
		Vector<String> row2=new Vector<>();
		Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
		sqlOperation so=new sqlOperation();
		Vector row=so.WareAll();
		DefaultTableModel Model=new DefaultTableModel(row,row2);
		table = new JTable(Model);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("\u5546\u54C1\u79CD\u7C7B");
		lblNewLabel.setBounds(52, 215, 69, 24);
		contentPane.add(lblNewLabel);
		
		textFieldKind = new JTextField();
		textFieldKind.setBounds(131, 217, 136, 21);
		contentPane.add(textFieldKind);
		textFieldKind.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u6570\u91CF");
		lblNewLabel_1.setBounds(51, 263, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(131, 260, 136, 21);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\u5546\u54C1\u540D");
		lblNewLabel_2.setBounds(312, 220, 69, 15);
		contentPane.add(lblNewLabel_2);
		
		textFieldGood = new JTextField();
		textFieldGood.setBounds(391, 217, 142, 21);
		contentPane.add(textFieldGood);
		textFieldGood.setColumns(10);
		
		textFieldGHS = new JTextField();
		textFieldGHS.setBounds(391, 260, 142, 21);
		contentPane.add(textFieldGHS);
		textFieldGHS.setColumns(10);
		
		lblNewLabel_3 = new JLabel("\u4F9B\u8D27\u5546");
		lblNewLabel_3.setBounds(312, 263, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				so.Shopping(textFieldKind, textFieldGood, textFieldNum, textFieldGHS,textFieldDate);
				Vector<String> row2=new Vector<>();
				Collections.addAll(row2, "序号","商品种类","商品名","供应数量","进货时间","供应商");
				Vector row=so.WareAll();
				DefaultTableModel Model=new DefaultTableModel(row,row2);
				table = new JTable(Model);
				scrollPane.setViewportView(table);
				
			}
		});
		btnNewButton.setBounds(540, 339, 97, 23);
		contentPane.add(btnNewButton);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(131, 305, 136, 21);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u65E5\u671F");
		lblNewLabel_4.setBounds(51, 308, 58, 15);
		contentPane.add(lblNewLabel_4);
	}
}
