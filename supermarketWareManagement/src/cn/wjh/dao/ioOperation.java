package cn.wjh.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.wjh.vo.Stochastic;

public class ioOperation {
	File f=new File("d:/���вֿ��û�����ϵͳ.text");
	public ioOperation() {}
	//ע���û���
	public boolean checkYHM(JTextField textFieldYHM,JLabel lblYHM,JPasswordField passwordFieldMM,JLabel lblMM,JTextField textFieldYZM,String s2,JTextField textFieldMail) {
		try(FileReader fr=new FileReader(f);
			BufferedReader bf=new BufferedReader(fr);) {
			String s=null;
			while((s=bf.readLine())!=null) {
				s.split("\t");
				String st[]=s.split("\t");	
				if(st[0].equals(textFieldYHM.getText())) {
					lblYHM.setText("�û����Ѵ���");
					return false;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(textFieldYHM.getText().length()==0) {
			lblYHM.setText("�û��������ǿ�");
			return false;
		}else if( passwordFieldMM.getText().length()==0){
			lblMM.setText("���벻���ǿ�");
			return false;
		}else if(!textFieldYZM.getText().equals(s2)) {
			textFieldYZM.setText("");
			JOptionPane.showMessageDialog(null, "��֤�����");
			return false;
		}
		else {
			try (FileWriter fr=new FileWriter(f,true);){
				fr.write(textFieldYHM.getText()+"\t"+passwordFieldMM.getText()+"\r\n");
				textFieldYHM.setText("");
				passwordFieldMM.setText("");
				textFieldYZM.setText("");
				textFieldMail.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			lblYHM.setText("");
			lblMM.setText("");
			JOptionPane.showMessageDialog(null, "ע��ɹ�");
			return true;
		}	
	}
	//��¼
	public boolean checkYH(JTextField textFieldYHM,JLabel lblNewLabelCY,JPasswordField passwordFieldMM) {
		try(FileReader fr=new FileReader(f);
				BufferedReader bf=new BufferedReader(fr);) {
				String s=null;
				int flag=0;
				while((s=bf.readLine())!=null) {
					s.split("\t");
					String st[]=s.split("\t");	
					if(st[0].equals(textFieldYHM.getText())&&st[1].equals(passwordFieldMM.getText())) {
						flag=1;
						textFieldYHM.setText("");
						passwordFieldMM.setText("");
						lblNewLabelCY.setText("");
						return true;
					}
				}
				if(flag==0) {
					lblNewLabelCY.setText("�û������������");
					return false;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		return false;
	}
	//������һ��������
	public void add() {
		Stochastic st=new Stochastic();
		try(BufferedWriter fw=new BufferedWriter(new FileWriter(f,true));) {
			for(int i=0;i<10000;i++)
			fw.write(st.getChineseName()+"\t"+st.getPassword()+"\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
