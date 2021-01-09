package cn.wjh.jf;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import cn.wjh.dao.ioOperation;
import cn.wjh.dao.sqlOperation;
import cn.wjh.dbc.*;
import cn.wjh.vo.Mail;
import cn.wjh.vo.Stochastic;

import javax.swing.JRadioButton;
public class RegisterJF extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldYHM;
	private JPasswordField passwordFieldMM;
	private JLabel lblYHM ;
	private JLabel lblMM;
	File f=new File("d:/超市仓库用户管理系统.text");
	private JTextField textFieldYZM;
	private JTextField textFieldMail;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public RegisterJF() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse-committers-2020-09-R-win32-x86_64 (1)\\supermarketWareManagement\\lib\\3.jpg"));
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelYHM = new JLabel("\u7528\u6237\u540D");
		lblNewLabelYHM.setBounds(131, 71, 58, 15);
		contentPane.add(lblNewLabelYHM);
		
		JLabel lblNewLabelMM = new JLabel("\u5BC6\u7801");
		lblNewLabelMM.setBounds(131, 112, 58, 15);
		contentPane.add(lblNewLabelMM);
		
		Stochastic st=new Stochastic();
		String s=st.achieveCode();
		
		JButton btnNewButtonZC = new JButton("\u7ACB\u5373\u6CE8\u518C");
		btnNewButtonZC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				sqlOperation so=new sqlOperation();
				so.sqlOperationAdd(textFieldYHM.getText(),passwordFieldMM.getText(),s,textFieldYZM.getText());
				ioOperation io=new ioOperation();
				if(io.checkYHM(textFieldYHM, lblYHM, passwordFieldMM,lblMM,textFieldYZM,s,textFieldMail))
					dispose();
			}
		});
		btnNewButtonZC.setBounds(158, 219, 156, 23);
		contentPane.add(btnNewButtonZC);
		
		textFieldYHM = new JTextField();
		textFieldYHM.setBounds(199, 68, 184, 21);
		contentPane.add(textFieldYHM);
		textFieldYHM.setColumns(10);
		
		passwordFieldMM = new JPasswordField();
		passwordFieldMM.setBounds(199, 109, 184, 21);
		contentPane.add(passwordFieldMM);
		
		JPanel panel = new JPanel();
		panel.setBounds(131, 0, 305, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse-committers-2020-09-R-win32-x86_64 (1)\\supermarketWareManagement\\lib\\4.jpg"));
		lblNewLabel.setBounds(0, 0, 307, 66);
		panel.add(lblNewLabel);
		
		lblYHM = new JLabel("");
		lblYHM.setBounds(393, 71, 99, 15);
		contentPane.add(lblYHM);
		
		lblMM = new JLabel("");
		lblMM.setBounds(388, 126, 104, 15);
		contentPane.add(lblMM);
		
		JLabel lblNewLabelYZM = new JLabel("\u9A8C\u8BC1\u7801");
		lblNewLabelYZM.setBounds(131, 176, 58, 23);
		contentPane.add(lblNewLabelYZM);
		
		textFieldYZM = new JTextField();
		textFieldYZM.setBounds(199, 177, 76, 22);
		contentPane.add(textFieldYZM);
		textFieldYZM.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\u70B9\u51FB\u53D1\u9001");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mail m=new Mail(textFieldMail.getText(), "用户:", "如果这封邮件不是你操作的，请忽略。登入验证码:"+s);
				m.start();
				
			}
		});
		btnNewButton.setBounds(286, 176, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("QQ\u90AE\u7BB1");
		lblNewLabel_1.setBounds(131, 150, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(199, 147, 184, 21);
		contentPane.add(textFieldMail);
		textFieldMail.setColumns(10);
	}
}
