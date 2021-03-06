package lythuyet.tuan1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NguyenVanPhat_19483821_50_ComboBoxDemo extends JFrame implements ActionListener{
	private Font fSerif;
	private JComboBox cbFont;
	private JLabel lblTieuDe;
	public NguyenVanPhat_19483821_50_ComboBoxDemo() {
		this.setTitle("Demo combobox sương sương");
		this.setSize(500,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// tạo panel ở center nè
		JPanel pCen = new JPanel();
		lblTieuDe = new JLabel("Đừng thấy sóng cả mà ngã tay chèo");
		pCen.add(lblTieuDe);
		fSerif = new Font("Serif", Font.PLAIN, 24);
		lblTieuDe.setFont(fSerif);
		
		cbFont = new JComboBox();
		cbFont.addItem("Serif");
		cbFont.addItem("SansSerif");
		cbFont.addItem("Monospaced");
		cbFont.setPreferredSize(new Dimension(1,24));
		
		// add vao màn hình chính nè
		this.add(pCen, BorderLayout.CENTER);
		this.add(cbFont, BorderLayout.SOUTH);
		
		// đăng kí bộ lắng nghe
		cbFont.addActionListener(this);
	}
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_ComboBoxDemo().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String fontName = (String)cbFont.getSelectedItem();
		lblTieuDe.setFont(new Font(fontName, lblTieuDe.getFont().getStyle(), lblTieuDe.getFont().getSize()));
	}
}
