package thuchanh.tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NguyenVanPhat_19483821_50_bai3tuan1 extends JFrame implements ActionListener{
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField tfNhapA;
	private JTextField tfNhapB;
	private JTextField tfKQ;
	private JRadioButton rbtnTru;
	private JRadioButton rbtnCong;
	private JRadioButton rbtnNhan;
	private JRadioButton rbtnChia;


	public NguyenVanPhat_19483821_50_bai3tuan1() {
		this.setTitle("Bài 3 sương sương");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// tạo panel tiêu đề ở trên nè
		JPanel pNor = new JPanel();
		this.add(pNor, BorderLayout.NORTH);
		JLabel lblTieuDe = new JLabel("Cộng - Trừ - Nhân - Chia");
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe.setFont(new Font("Serif",Font.BOLD,24));
		pNor.add(lblTieuDe);
		
		// tạo panel bên trái sương sương
		JPanel pWes = new JPanel();
		pWes.setPreferredSize(new Dimension(100,0));
		pWes.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		this.add(pWes, BorderLayout.WEST);
		btnGiai = new JButton("Giải");
		btnXoa = new JButton("Xoá");
		btnThoat = new JButton("Thoát");
		
		btnGiai.setBounds(5, 20, 80, 28);
		btnXoa.setBounds(5, 60, 80, 28);
		btnThoat.setBounds(5, 100, 80, 28);
		pWes.setLayout(null);
		pWes.add(btnGiai);
		pWes.add(btnXoa);
		pWes.add(btnThoat);
		pWes.setBackground(Color.LIGHT_GRAY);
		
		// tạo panel ở giữa nè
		JPanel pCen = new JPanel();
		pCen.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		this.add(pCen, BorderLayout.CENTER);
		JLabel lblNhapA = new JLabel("Nhập a:");
		JLabel lblNhapB = new JLabel("Nhập b:");
		JLabel lblKQ = new JLabel("Kết quả:");
		tfNhapA = new JTextField();
		tfNhapB = new JTextField();
		tfKQ = new JTextField();
		lblNhapA.setBounds(50, 30, 44, 24);
		lblNhapB.setBounds(50, 70, 44, 24);
		lblKQ.setBounds(50, 230, 54, 24);
		tfNhapA.setBounds(100, 30, 180, 24);
		tfNhapB.setBounds(100, 70, 180, 24);
		tfKQ.setBounds(100, 230, 180, 24);
		tfKQ.setEditable(false);
		
		// panel ở trong panel center
		JPanel pToan = new JPanel();
		pToan.setBounds(100, 100, 180, 120);
		pToan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		pCen.add(pToan);
		pToan.setLayout(null);
		rbtnCong = new JRadioButton("Cộng");
		rbtnTru = new JRadioButton("Trừ");
		rbtnNhan = new JRadioButton("Nhân");
		rbtnChia = new JRadioButton("Chia");
		rbtnCong.setBounds(10,30,60,20);
		rbtnTru.setBounds(100,30,60,20);
		rbtnNhan.setBounds(10,90,60,20);
		rbtnChia.setBounds(100,90,60,20);
		pToan.add(rbtnCong);
		pToan.add(rbtnTru);
		pToan.add(rbtnNhan);
		pToan.add(rbtnChia);
		
		pCen.setLayout(null);
		pCen.add(lblNhapA);
		pCen.add(lblNhapB);
		pCen.add(lblKQ);
		pCen.add(tfNhapA);
		pCen.add(tfNhapB);
		pCen.add(tfKQ);

		
		// tạo panel ở dưới cho đẹp
		JPanel pSou = new JPanel();
		pSou.setPreferredSize(new Dimension(0,30));
		JPanel pXanh = new JPanel();
		pXanh.setBackground(Color.BLUE);
		pSou.add(pXanh);
		JPanel pDo = new JPanel();
		pDo.setBackground(Color.RED);
		pSou.add(pDo);
		JPanel pVang = new JPanel();
		pVang.setBackground(Color.YELLOW);
		pSou.add(pVang);
		pSou.setBackground(Color.PINK);
		this.add(pSou, BorderLayout.SOUTH);
		
		// cuối cùng cũng được đăng kí lắng nghe rồi nè
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		rbtnCong.addActionListener(this);
		rbtnTru.addActionListener(this);
		rbtnNhan.addActionListener(this);
		rbtnChia.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_bai3tuan1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source.equals(btnThoat)) {
			int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát không", 
					"Nhắc nhở", JOptionPane.YES_NO_OPTION);
			if(input==0) {
				System.exit(0);
			}
		}
		if(source.equals(btnXoa)) {
			tfNhapA.setText("");
			tfNhapB.setText("");
			tfKQ.setText("");
			tfNhapA.requestFocus();
		}
		if(source.equals(btnGiai)) {
			Double a = Double.parseDouble(tfNhapA.getText());
			Double b = Double.parseDouble(tfNhapB.getText());
			Double KQ = 0.0;
			if(rbtnCong.isSelected()) {
				KQ = a+b;
				tfKQ.setText(""+KQ);
			}
			if(rbtnTru.isSelected()) {
				KQ = a-b;
				tfKQ.setText(""+KQ);
			}
			if(rbtnNhan.isSelected()) {
				KQ = a*b;
				tfKQ.setText(""+KQ);
			}
			if(rbtnChia.isSelected()) {
				KQ = a/b;
				tfKQ.setText(""+KQ);
			}
		}
		if(source.equals(rbtnCong)) {
			if(rbtnCong.isSelected()) {
				rbtnTru.setSelected(false);
				rbtnNhan.setSelected(false);
				rbtnChia.setSelected(false);
			}
		}
		if(source.equals(rbtnTru)) {
			if(rbtnTru.isSelected()) {
				rbtnCong.setSelected(false);
				rbtnNhan.setSelected(false);
				rbtnChia.setSelected(false);
			}
		}
		if(source.equals(rbtnNhan)) {
			if(rbtnNhan.isSelected()) {
				rbtnCong.setSelected(false);
				rbtnTru.setSelected(false);
				rbtnChia.setSelected(false);
			}
		}
		if(source.equals(rbtnChia)) {
			if(rbtnChia.isSelected()) {
				rbtnCong.setSelected(false);
				rbtnTru.setSelected(false);
				rbtnNhan.setSelected(false);
			}
		}
	}
}
