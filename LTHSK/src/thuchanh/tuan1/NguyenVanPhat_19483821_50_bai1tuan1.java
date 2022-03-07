package thuchanh.tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NguyenVanPhat_19483821_50_bai1tuan1 extends JFrame implements ActionListener{
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField tfSoA;
	private JTextField tfSoC;
	private JTextField tfSoB;
	private JTextField tfKQ;

	public NguyenVanPhat_19483821_50_bai1tuan1() {
		this.setTitle("Bài 1 sương sương");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Tạo cái panel trên north ghi tiêu đề nè
		JPanel pNor = new JPanel();
		pNor.setBackground(Color.CYAN);
		JLabel lblTieuDe = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2");
		Font fTieude = new Font("Serif",Font.BOLD,24);
		lblTieuDe.setFont(fTieude);
		this.add(pNor, BorderLayout.NORTH);
		pNor.add(lblTieuDe);
		
		// tạo cái panel ở dưới south nè
		JPanel pSou = new JPanel();
		this.add(pSou, BorderLayout.SOUTH);
		pSou.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		btnGiai = new JButton("Giải");
		btnXoa = new JButton("Xoá rỗng");
		btnThoat = new JButton("Thoát");
		pSou.add(btnGiai);
		pSou.add(btnXoa);
		pSou.add(btnThoat);
		
		// tạo cái panel ở center nè
		JPanel pCen = new JPanel();
		this.add(pCen);
		JLabel lblNhapA = new JLabel("Nhập a:");
		JLabel lblNhapB = new JLabel("Nhập b:");
		JLabel lblNhapC = new JLabel("Nhập c:");
		JLabel lblKQ = new JLabel("Kết quả:");
		tfSoA = new JTextField();
		tfSoB = new JTextField();
		tfSoC = new JTextField();
		tfKQ = new JTextField();
		
		lblNhapA.setBounds(20, 40, 50, 26);
		lblNhapB.setBounds(20, 100, 50, 26);
		lblNhapC.setBounds(20, 160, 50, 26);
		lblKQ.setBounds(20, 220, 50, 26);
		tfSoA.setBounds(80, 40, 360, 26);
		tfSoB.setBounds(80, 100, 360, 26);
		tfSoC.setBounds(80, 160, 360, 26);
		tfKQ.setBounds(80, 220, 360, 26);
		tfKQ.setEditable(false);
		
		pCen.setLayout(null);
		pCen.add(tfSoA);
		pCen.add(tfSoB);
		pCen.add(tfSoC);
		pCen.add(tfKQ);
		pCen.add(lblNhapA);
		pCen.add(lblNhapB);
		pCen.add(lblNhapC);
		pCen.add(lblKQ);
		
		// lắng nghe sương sương
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_bai1tuan1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source.equals(btnThoat)) {
			int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát không", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
			if(input==0) {
				System.exit(0);
			}
		}
		if(source.equals(btnXoa)) {
			tfSoA.setText("");
			tfSoB.setText("");
			tfSoC.setText("");
			tfKQ.setText("");
			tfSoA.requestFocus();
		}
		if(source.equals(btnGiai)) {
			Double a = Double.parseDouble(tfSoA.getText());
			Double b = Double.parseDouble(tfSoB.getText());
			Double c = Double.parseDouble(tfSoC.getText());
			Double delta = 0.0;
			delta = b*b - 4*a*c;
			if(delta<0) {
				tfKQ.setText("Phương trình vô no");
			}else if(delta==0) {
				Double no = -b/(2*a);
				tfKQ.setText("Phương trình có no kép ~~~ x1 = x2 = "+no);
			}else {
				delta = Math.sqrt(delta);
				Double no1 = (-b+delta)/(2*a);
				Double no2 = (-b-delta)/(2*a);
				tfKQ.setText("Phương trình có 2 no phân biệt ~~~ x1 = "+no1+" và x2 = "+no2);
			}
		}
	}
}
