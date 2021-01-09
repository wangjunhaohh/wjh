package cn.wjh.jf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wjh.dao.sqlOperation;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockDeleteJF extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public StockDeleteJF() {
		setTitle("\u5220\u9664");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5220\u9664\u5546\u54C1");
		lblNewLabel.setBounds(83, 80, 96, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(178, 80, 135, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				so.salOperationDelete(textField);
				dispose();
			}
		});
		btnNewButton.setBounds(126, 161, 113, 39);
		contentPane.add(btnNewButton);
	}
}
