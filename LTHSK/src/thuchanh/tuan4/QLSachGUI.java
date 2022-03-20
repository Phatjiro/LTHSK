package thuchanh.tuan4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class QLSachGUI extends JFrame implements ActionListener{
	private JTextField tfMaSach;
	private JTextField tfTuaSach;
	private JTextField tfNamXuatBan;
	private JTextField tfSoTrang;
	private JTextField tfISBN;
	private JTextField tfTacGia;
	private JTextField tfNXB;
	private JTextField tfDonGia;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private DefaultTableModel tableModel;
	private JTable table;
	private SachCollection dsSach;

	public QLSachGUI() {
		this.setTitle("Quản lí sách");
		this.setSize(1200,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Panel Cen
		JPanel pCen = new JPanel(null);
		pCen.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		
		JLabel lblMaSach = new JLabel("Mã Sách:");
		JLabel lblTuaSach= new JLabel("Tựa Sách:");
		JLabel lblNamXuatBan = new JLabel("Năm Xuất Bản:");
		JLabel lblSoTrang = new JLabel("Số Trang:");
		JLabel lblISBN = new JLabel("International Standard Book Number (ISBN):");
		JLabel lblTacGia = new JLabel("Tác Giả:");
		JLabel lblNXB = new JLabel("Nhà Xuất Bản:");
		JLabel lblDonGia = new JLabel("Đơn Giá:");
		
		lblMaSach.setBounds		(10,30,90,20);
		lblTuaSach.setBounds	(10,70,90,20);
		lblNamXuatBan.setBounds	(10,110,90,20);
		lblSoTrang.setBounds	(10,150,90,20);
		lblISBN.setBounds		(10,190,250,20);
		lblTacGia.setBounds		(650,70,80,20);
		lblNXB.setBounds		(650,110,80,20);
		lblDonGia.setBounds		(650,150,80,20);
		
		tfMaSach = new JTextField();
		tfTuaSach = new JTextField();
		tfNamXuatBan = new JTextField();
		tfSoTrang = new JTextField();
		tfISBN = new JTextField();
		tfTacGia = new JTextField();
		tfNXB = new JTextField();
		tfDonGia = new JTextField();
		
		tfMaSach.setBounds		(100,30,300,20);
		tfTuaSach.setBounds		(100,70,460,20);
		tfNamXuatBan.setBounds	(100,110,460,20);
		tfSoTrang.setBounds		(100,150,460,20);
		tfISBN.setBounds		(260,190,300,20);
		tfTacGia.setBounds		(740,70,400,20);
		tfNXB.setBounds			(740,110,400,20);
		tfDonGia.setBounds		(740,150,400,20);
		
		btnThem = new JButton("Thêm");
		btnXoaRong = new JButton("Xoá Rỗng");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xoá");
		JLabel lblTim = new JLabel("Tìm Theo Mã Sách");
		lblTim.setFont(new Font(lblTim.getFont().getName(), Font.BOLD, 14));
		JComboBox cbbMaSach = new JComboBox();
		cbbMaSach.addItem("A001");
		cbbMaSach.addItem("J002");
		cbbMaSach.addItem("H003");
		cbbMaSach.setFont(new Font(cbbMaSach.getFont().getName(), Font.BOLD, 14));
		
		btnThem.setBounds		(10,260,100,30);
		btnXoaRong.setBounds	(120,260,100,30);
		btnSua.setBounds		(230,260,100,30);
		btnXoa.setBounds		(340,260,100,30);
		lblTim.setBounds		(650,264,130,20);
		cbbMaSach.setBounds		(790,264,140,20);
		
		pCen.add(lblMaSach);
		pCen.add(lblTuaSach);
		pCen.add(lblNamXuatBan);
		pCen.add(lblSoTrang);
		pCen.add(lblISBN);
		pCen.add(lblTacGia);
		pCen.add(lblNXB);
		pCen.add(lblDonGia);
		
		pCen.add(tfMaSach);
		pCen.add(tfTuaSach);
		pCen.add(tfNamXuatBan);
		pCen.add(tfSoTrang);
		pCen.add(tfISBN);
		pCen.add(tfTacGia);
		pCen.add(tfNXB);
		pCen.add(tfDonGia);
		
		pCen.add(btnThem);
		pCen.add(btnXoaRong);
		pCen.add(btnSua);
		pCen.add(btnXoa);
		pCen.add(lblTim);
		pCen.add(cbbMaSach);
		// Panel South
		JPanel pSou = new JPanel(new GridLayout());
		pSou.setBorder(BorderFactory.createTitledBorder("Danh Sách Các Cuốn Sách"));
		String[] header = {"Mã Sách", "Tựa Sách", "Tác Giả", "Năm Xuất Bản", "Nhà Xuất Bản", "Số Trang", "Đơn Giá", "ISBN"};
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		JScrollPane scTable = new JScrollPane(table);
		
		pSou.add(scTable);
		// Add panel
		this.add(pCen, BorderLayout.CENTER);
		this.add(pSou, BorderLayout.SOUTH);
		// Array list
		dsSach = new SachCollection();
		LuuFile l = new LuuFile();
		try {
			dsSach = (SachCollection) l.docFile2("src\\thuchanh\\tuan4\\DanhMucSach.txt");
			System.out.println();
			System.out.println("Đọc dữ liệu từ file txt thành công!!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println();
			System.out.println("Đọc dữ liệu từ file txt thất bại!!!");
			e.printStackTrace();
		}
		
		arrToModel();
		
		// Đăng kí lắng nghe
		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new QLSachGUI().setVisible(true);
	}
	
	public void arrToModel() {
		for (int i=0; i<dsSach.getSize(); i++) {
			Sach sach = dsSach.getElement(i);
			tableModel.addRow(new Object[] {sach.getMaSach(),sach.getTuaSach(),sach.getNamXuatBan(),
					sach.getSoTrang(),sach.getISBN(),sach.getTacGia(),sach.getNXB(),sach.getDonGia()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			String ma = tfMaSach.getText();
			String tua = tfTuaSach.getText();
			int nam = Integer.parseInt(tfNamXuatBan.getText());
			int trang = Integer.parseInt(tfSoTrang.getText());
			String isbn = tfISBN.getText();
			String tacgia = tfTacGia.getText();
			String nxb = tfNXB.getText();
			Double dongia = Double.parseDouble(tfDonGia.getText());
			
			Sach sach = new Sach(ma, tua, nam, trang, isbn, tacgia, nxb, dongia);
			dsSach.themSach(sach);
			tableModel.addRow(new Object[] {sach.getMaSach(),sach.getTuaSach(),sach.getTacGia(),
					sach.getNamXuatBan(),sach.getNXB(),sach.getSoTrang(),sach.getDonGia(),sach.getISBN()});
		}
		
		if (o.equals(btnXoaRong)) {
			tfMaSach.setText("");
			tfTuaSach.setText("");
			tfNamXuatBan.setText("");
			tfSoTrang.setText("");
			tfISBN.setText("");
			tfTacGia.setText("");
			tfNXB.setText("");
			tfDonGia.setText("");
			tfMaSach.requestFocus();
		}
	}
}
