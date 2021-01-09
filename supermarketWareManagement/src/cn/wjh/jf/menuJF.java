package cn.wjh.jf;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import java.awt.event.InputEvent;
import javax.swing.JLabel;

public class menuJF extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			menuJF dialog = new menuJF();
			dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public menuJF() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\1.jpg"));
		setTitle("\u8D85\u5E02\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 984, 545);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {
				ImageIcon icon=new ImageIcon("d:\\8.jpg");
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(),this.getHeight() ,this);
			}
		};
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u83DC\u5355");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8BA2\u8D27");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockJF stjf=new StockJF();
				desktopPane.add(stjf);
				stjf.setVisible(true);
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4ED3\u5E93");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsJF gjf=new GoodsJF();
				gjf.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u8D2D\u7269\u8BB0\u5F55");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopJF sjf=new ShopJF();
				sjf.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 50);
		desktopPane.add(toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockJF stjf=new StockJF();
				desktopPane.add(stjf);
				stjf.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\13.jpg"));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsJF gjf=new GoodsJF();
				gjf.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\12.jpg"));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopJF sjf=new ShopJF();
				sjf.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\14.jpg"));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\15.jpg"));
		toolBar.add(btnNewButton_3);
	}
}
