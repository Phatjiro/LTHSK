package thuchanh.tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

public class NguyenVanPhat_19483821_50_bai2tuan2  extends JFrame implements ActionListener{

	private JButton btnToChan;
	private JButton btnToLe;
	private JButton btnToSoNT;
	private JButton btnBoTo;
	private JButton btnXoa;
	private JButton btnTong;
	private JButton btnThoat;
	private JButton btnNhap;
	private JTextField tfNhapSo;
	private JCheckBox chkSoAm;
	private JButton btnTaoSoNN;
	private DefaultListModel<Integer> dfmodelSoNguyen;
	private JList<Integer> listSoNguyen;
	private JTextField tfSoNN;
	private JLabel lblTong;
	private JButton btnTongTo;

	public NguyenVanPhat_19483821_50_bai2tuan2() {
		// TODO Auto-generated constructor stub
		this.setTitle("Thao tác trên JList");
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// tao panel o north
		JPanel pNor = new JPanel();
		
		JLabel lblTieuDe = new JLabel("Thao tác trên JList - CheckBox");
		lblTieuDe.setFont(new Font(("SansSerif"),Font.BOLD,24));
		lblTieuDe.setForeground(Color.BLUE);
		
		pNor.add(lblTieuDe);
		
		// tao panel o west
		JPanel pWes = new JPanel();
		pWes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Chọn tác vụ"));
		pWes.setLayout(new GridLayout(8, 1));
		
		btnToChan = new JButton("Tô đen số chẵn");
		btnToLe = new JButton("Tô đen số lẻ");
		btnToSoNT = new JButton("Tô đen số nguyên tố");
		btnBoTo = new JButton("Bỏ tô đen");
		btnXoa = new JButton("Xóa các giá trị đang tô đen");
		btnTong = new JButton("Tổng giá trị trong JList");
		btnTongTo = new JButton("Tổng giá trị tô trong đen Jlist");
		lblTong = new JLabel();
		lblTong.setFont(new Font(lblTong.getFont().getName(), Font.PLAIN, 24));
		
		pWes.add(btnToChan);
		pWes.add(btnToLe);
		pWes.add(btnToSoNT);
		pWes.add(btnBoTo);
		pWes.add(btnXoa);
		pWes.add(btnTong);
		pWes.add(btnTongTo);
		pWes.add(lblTong);
		
		// tao panel o center
		JPanel pCen = new JPanel();
		pCen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Nhập thông tin"));
		pCen.setLayout(new BorderLayout());
		
			// tao pCenNor
		JPanel pCenNor = new JPanel();
		
		btnNhap = new JButton("Nhập");
		tfNhapSo = new JTextField(10);
		chkSoAm = new JCheckBox("Cho nhập số âm");
		
		pCenNor.add(btnNhap);
		pCenNor.add(tfNhapSo);
		pCenNor.add(chkSoAm);
		
			// tao pCenSou
		JPanel pCenSou = new JPanel();
		
		btnTaoSoNN = new JButton("Tạo số ngẫu nhiên");
		tfSoNN = new JTextField(3);
		
		pCenSou.add(btnTaoSoNN);
		pCenSou.add(tfSoNN);
		
		// tao JList
		dfmodelSoNguyen = new DefaultListModel<Integer>();
		listSoNguyen = new JList<Integer>(dfmodelSoNguyen);
		JScrollPane scSoNguyen = new JScrollPane(listSoNguyen, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
//		listSoNguyen.setVisibleRowCount(15);
//		listSoNguyen.setFixedCellWidth(200);
		
			// add cac pCen phu vao pCen
		pCen.add(pCenNor, BorderLayout.NORTH);
		pCen.add(pCenSou, BorderLayout.SOUTH);
		pCen.add(scSoNguyen,BorderLayout.CENTER);
		
		// tao panel o south
		JPanel pSou = new JPanel();
		pSou.setBackground(Color.LIGHT_GRAY);
		pSou.setPreferredSize(new Dimension(0,40));
		
		btnThoat = new JButton("Đóng chương trình");
		
		pSou.add(btnThoat);
		
		// add panel vao bai
		this.add(pNor, BorderLayout.NORTH);
		this.add(pCen, BorderLayout.CENTER);
		this.add(pWes, BorderLayout.WEST);
		this.add(pSou, BorderLayout.SOUTH);
		
		// dang ki su kien cho cac nut
		btnNhap.addActionListener(this);
		btnTaoSoNN.addActionListener(this);
		
		btnToChan.addActionListener(this);
		btnToLe.addActionListener(this);
		btnToSoNT.addActionListener(this);
		btnBoTo.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTong.addActionListener(this);
		btnTongTo.addActionListener(this);
	}

	private void nhapSo() {
		int so;
		try {
			so = Integer.parseInt(tfNhapSo.getText());
			if(!chkSoAm.isSelected() && so>0) {
				dfmodelSoNguyen.addElement(so);
			}else if(chkSoAm.isSelected()) {
				dfmodelSoNguyen.addElement(so);
			}else {
				JOptionPane.showMessageDialog(null, "Không được nhập số âm đâu à nha!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Nhập số đi nè!");
			tfNhapSo.requestFocus();
			tfNhapSo.setText("");
			return;
		}
	}
	
	private void taoSoNN(int n) {
		for(int i=0; i<n; i++) {
			if(chkSoAm.isSelected()) {
				dfmodelSoNguyen.addElement(new Random().nextInt(201)-100);
			}else {
				dfmodelSoNguyen.addElement(new Random().nextInt(100));
			}
		}
	}
	
	private boolean checkPrime(int n) {
		if(n<2) {
			return false;
		}
		for(int i=2; i<n-1; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NguyenVanPhat_19483821_50_bai2tuan2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnNhap)) {
			nhapSo();
			tfNhapSo.setText("");
		}
		if(o.equals(btnTaoSoNN)) {
			if(tfSoNN.getText().equals("")) {
				taoSoNN(20);
			}else {
				taoSoNN(Integer.parseInt(tfSoNN.getText()));
			}
		}
		if(o.equals(btnToChan)) {
			listSoNguyen.clearSelection();
			for(int i=0; i<dfmodelSoNguyen.size(); i++) {
				if(dfmodelSoNguyen.getElementAt(i)%2==0) {
					listSoNguyen.addSelectionInterval(i, i);
				}
			}
		}
		if(o.equals(btnToLe)) {
			listSoNguyen.clearSelection();
			for(int i=0; i<dfmodelSoNguyen.getSize(); i++) {
				if(dfmodelSoNguyen.getElementAt(i)%2==1) {
					listSoNguyen.addSelectionInterval(i, i);
				}
			}
		}
		if(o.equals(btnToSoNT)) {
			listSoNguyen.clearSelection();
			for(int i=0; i<dfmodelSoNguyen.getSize(); i++) {
				if(checkPrime(dfmodelSoNguyen.getElementAt(i))) {
					listSoNguyen.addSelectionInterval(i, i);
				}
			}
		}
		if(o.equals(btnBoTo)) {
			listSoNguyen.clearSelection();
		}
		if(o.equals(btnXoa)) {
			int countSelectedIndex = listSoNguyen.getSelectedIndices().length;
			int index;
			for(int i=0; i<countSelectedIndex; i++) {
				index = listSoNguyen.getSelectedIndex();
				dfmodelSoNguyen.remove(index);
			}
		}
		if(o.equals(btnTong)) {
			int tong=0;
			for(int i=0; i<dfmodelSoNguyen.getSize(); i++) {
				tong = tong + dfmodelSoNguyen.getElementAt(i);
			}
			lblTong.setText("Tổng: "+tong);
		}
		if(o.equals(btnTongTo)) {
			List<Integer> value = listSoNguyen.getSelectedValuesList();
			int tong=0;
			for(int i=0; i<value.size(); i++) {
				tong = tong + value.get(i);
			}
			lblTong.setText("Tổng tô:"+tong);
		}
	}

}
