package baitap.bai1;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class demoChk_VanPhat_50 extends JFrame implements ItemListener{
	private JTextField tfNhapText;
	private JCheckBox chkBold;
	private JCheckBox chkItalic;
	public demoChk_VanPhat_50() {
		this.setTitle("Demo chk box sương sương");
		this.setSize(160,160);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pCen = new JPanel();
		this.add(pCen);
		tfNhapText = new JTextField("Xem chữ thay đổi nè");
		pCen.add(tfNhapText);
		chkBold = new JCheckBox("BOLD");
		chkItalic = new JCheckBox("ITALIC");
		pCen.add(chkBold);
		pCen.add(chkItalic);
		// đăng kí sương sương
		chkBold.addItemListener(this);
		chkItalic.addItemListener(this);
		//Font f = tfNhapText.getFont();
		//tfNhapText.setFont(new Font(f.getName(), f.getStyle() ^ Font.BOLD, f.getSize()));
	}
	public static void main(String[] args) {
		new demoChk_VanPhat_50().setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Font f = tfNhapText.getFont();
		if(e.getItem()==chkBold) {
			tfNhapText.setFont(new Font(f.getName(), f.getStyle() ^ Font.BOLD, f.getSize()));
		}
		if(e.getItem()==chkItalic) {
			tfNhapText.setFont(new Font(f.getName(), f.getStyle() ^ Font.ITALIC, f.getSize()));
		}
	}
}
