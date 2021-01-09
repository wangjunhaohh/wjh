package cn.wjh.jf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wjh.dao.sqlOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeJF extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGYS;
	private JTextField textFieldKind;
	private JTextField textFieldAddress;
	private JTextField textFieldGood;
	private JTextField textFieldTel;
	private JTextField textFieldNum;

	/**
	 * Create the frame.
	 */
	public ChangeJF() {
		setTitle("\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 349);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelGYS = new JLabel("\u4F9B\u5E94\u5546");
		lblNewLabelGYS.setBounds(17, 66, 85, 33);
		contentPane.add(lblNewLabelGYS);
		
		textFieldGYS = new JTextField();
		textFieldGYS.setBounds(113, 66, 123, 34);
		contentPane.add(textFieldGYS);
		textFieldGYS.setColumns(10);
		
		JLabel lblNewLabelKind = new JLabel("\u4F9B\u8D27\u79CD\u7C7B");
		lblNewLabelKind.setBounds(301, 70, 85, 31);
		contentPane.add(lblNewLabelKind);
		
		textFieldKind = new JTextField();
		textFieldKind.setBounds(417, 68, 121, 34);
		contentPane.add(textFieldKind);
		textFieldKind.setColumns(10);
		
		JLabel lblNewLabelAddress = new JLabel("\u4F9B\u8D27\u5546\u5730\u5740");
		lblNewLabelAddress.setBounds(13, 124, 71, 37);
		contentPane.add(lblNewLabelAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(113, 127, 124, 35);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JLabel lblNewLabelGood = new JLabel("\u5546\u54C1");
		lblNewLabelGood.setBounds(301, 124, 88, 36);
		contentPane.add(lblNewLabelGood);
		
		textFieldGood = new JTextField();
		textFieldGood.setBounds(417, 126, 121, 35);
		contentPane.add(textFieldGood);
		textFieldGood.setColumns(10);
		
		JLabel lblNewLabelTel = new JLabel("\u4F9B\u8D27\u5546\u7535\u8BDD");
		lblNewLabelTel.setBounds(12, 186, 76, 36);
		contentPane.add(lblNewLabelTel);
		
		JLabel lblNewLabelNum = new JLabel("\u6570\u91CF");
		lblNewLabelNum.setBounds(301, 187, 86, 34);
		contentPane.add(lblNewLabelNum);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(113, 186, 123, 35);
		contentPane.add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(417, 186, 121, 36);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlOperation so=new sqlOperation();
				so.sqlOperationChange(textFieldGYS, textFieldAddress, textFieldTel, textFieldKind, textFieldGood, textFieldNum);
				dispose();
				
			}
		});
		btnNewButton.setBounds(193, 249, 164, 37);
		contentPane.add(btnNewButton);
	}
}
