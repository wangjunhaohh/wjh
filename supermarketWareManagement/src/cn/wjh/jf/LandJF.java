package cn.wjh.jf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import cn.wjh.dao.ioOperation;
import cn.wjh.dao.sqlOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LandJF {

	private JFrame frame;
	private JTextField textFieldYHM;
	private JPasswordField passwordFieldMM;
	private JLabel lblNewLabelCY;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandJF window = new LandJF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 */
	public LandJF() {
		initialize();
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\6.jpg"));
		frame.setResizable(false);
		frame.setTitle("\u7528\u6237\u767B\u5F55");
		frame.setBounds(100, 100, 456, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		textFieldYHM = new JTextField();
		textFieldYHM.setBounds(132, 98, 193, 21);
		frame.getContentPane().add(textFieldYHM);
		textFieldYHM.setColumns(10);
		
		JLabel lblNewLabelYHM = new JLabel("\u7528\u6237\u540D");
		lblNewLabelYHM.setBounds(53, 101, 82, 15);
		frame.getContentPane().add(lblNewLabelYHM);
		
		JLabel lblNewLabelMM = new JLabel("\u5BC6\u7801");
		lblNewLabelMM.setBounds(53, 141, 82, 15);
		frame.getContentPane().add(lblNewLabelMM);
		
		passwordFieldMM = new JPasswordField();
		passwordFieldMM.setBounds(132, 138, 193, 21);
		frame.getContentPane().add(passwordFieldMM);
		
		JButton btnNewButtonDL = new JButton("\u767B\u5F55");
		btnNewButtonDL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ioOperation io=new ioOperation();
				sqlOperation so=new sqlOperation();
				if(so.sqlOperationLoad(textFieldYHM, passwordFieldMM,lblNewLabelCY)&&io.checkYH(textFieldYHM, lblNewLabelCY, passwordFieldMM)) {
					menuJF cijf=new menuJF();
					cijf.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnNewButtonDL.setBounds(129, 189, 159, 23);
		frame.getContentPane().add(btnNewButtonDL);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 442, 91);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse-committers-2020-09-R-win32-x86_64 (1)\\supermarketWareManagement\\lib\\3.jpg"));
		lblNewLabel.setBounds(0, 0, 446, 91);
		panel.add(lblNewLabel);
		
		JButton btnNewButtonZC = new JButton("\u6CE8\u518C\u7528\u6237");
		btnNewButtonZC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterJF rjf=new RegisterJF();
				rjf.setVisible(true);
			}
		});
		btnNewButtonZC.setBounds(339, 230, 97, 23);
		frame.getContentPane().add(btnNewButtonZC);
		
		lblNewLabelCY = new JLabel("");
		lblNewLabelCY.setBounds(335, 141, 101, 15);
		frame.getContentPane().add(lblNewLabelCY);
		
		JButton btnNewButton = new JButton("\u6E38\u5BA2\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserJF ujf=new UserJF();
				ujf.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(298, 189, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u968F\u673A\u4EA7\u751F\u6570\u636E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ioOperation io=new ioOperation();
				io.add();
				JOptionPane.showMessageDialog(null, "添加一万条随机数据成功");
			}
		});
		btnNewButton_1.setBounds(29, 189, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
	}	
}
