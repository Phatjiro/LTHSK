package lythuyet.tuan1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class NguyenVanPhat_19483821_50_RadioDemo extends JFrame implements ActionListener, ItemListener{
	private JCheckBox chkItalic;
	private JRadioButton rbtnLeft;
	private JRadioButton rbtnRigth;
	private JLabel lblHello;
	public NguyenVanPhat_19483821_50_RadioDemo() {
		this.setTitle("Demo RadioButton sương sương");
		this.setSize(400,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// tạo panel trên top sương sương
		JPanel pNor = new JPanel();
		chkItalic = new JCheckBox("Ttalic");
		rbtnLeft = new JRadioButton("Left");
		rbtnRigth = new JRadioButton("Right");
		pNor.add(chkItalic);
		pNor.add(rbtnLeft);
		pNor.add(rbtnRigth);
		// add vô cái group cho dễ quản lí
		ButtonGroup btnGr = new ButtonGroup();
		btnGr.add(rbtnLeft);
		btnGr.add(rbtnRigth);
		// tạo dòng chữ để di chuyển đê
		lblHello = new JLabel("Hello World");
		this.add(lblHello);
		// Đăng kí bộ lắng nghe cho mấy cái nút nè
		chkItalic.addItemListener(this);
		rbtnLeft.addActionListener(this);
		rbtnRigth.addActionListener(this);
		// add mấy panel trong giao diện chính sương sương nè
		this.add(pNor, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_RadioDemo().setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Font f = lblHello.getFont();
		if(e.getItem() == chkItalic) {
			lblHello.setFont(new Font(f.getName(), f.getStyle() ^ Font.ITALIC, f.getSize()));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source.equals(rbtnLeft)) {
			lblHello.setHorizontalAlignment(SwingConstants.LEFT);
		}
		if(source.equals(rbtnRigth)) {
			lblHello.setHorizontalAlignment(SwingConstants.RIGHT);
		}
	}
}
