package lythuyet.tuan2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class NguyenVanPhat_19483821_50_JTableDemo extends JFrame implements ActionListener, MouseListener{
	private JTextField tfHo;
	private JTextField tfTen;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnThoat;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnSua;

	public NguyenVanPhat_19483821_50_JTableDemo() {
		this.setTitle("Edit Table");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pCen = new JPanel();
		
		JLabel lblHo = new JLabel("Họ:");
		JLabel lblTen = new JLabel("Tên:");
		
		tfHo = new JTextField(14);
		tfTen = new JTextField(14);
		
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xoá");
		btnSua = new JButton("Sửa");
		btnThoat = new JButton("Thoát");
		
		lblHo.setBounds(70,12,30,20);
		tfHo.setBounds(100,12,230,20);
		lblTen.setBounds(70,42,30,20);
		tfTen.setBounds(100,42,230,20);
		btnThem.setBounds(70,72,80,28);
		btnXoa.setBounds(160,72,80,28);
		btnSua.setBounds(250,72,80,28);
		btnThoat.setBounds(70,112,80,28);
		
		// add các panel vào pCen
		pCen.setLayout(null);
		
		pCen.add(lblHo);
		pCen.add(tfHo);
		pCen.add(lblTen);
		pCen.add(tfTen);
		pCen.add(btnThem);
		pCen.add(btnXoa);
		pCen.add(btnSua);
		pCen.add(btnThoat);
		
		// tạo jTable
		String[] header = {"Họ", "Tên"};
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		JScrollPane scTable = new JScrollPane(table);
		scTable.setBounds(0,160,385,180);
		pCen.add(scTable);
		table.setRowHeight(30);
		
		// add panel vào tổng thể
		this.add(pCen);
		
		// đăng kí lắng nghe nè
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		btnSua.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_JTableDemo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(tfHo.getText().equals("") || tfTen.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ họ và tên");
			}
			else {
				String[] row = {tfHo.getText(), tfTen.getText()};
				tableModel.addRow(row);
				tfHo.setText("");
				tfTen.setText("");
				tfHo.requestFocus();
			}
		}
		if(o.equals(btnXoa)) {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá!");
			}
			else {
				if(JOptionPane.showConfirmDialog(this, "Bạn chắc xoá chưa",
						"Cảnh báo", JOptionPane.YES_NO_OPTION) == 1);
				tableModel.removeRow(table.getSelectedRow());
			}
		}
		if(o.equals(btnSua)) {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa!");
			}
			else {
				int row = table.getSelectedRow();
				tableModel.setValueAt(tfHo.getText(), row, 0);
				tableModel.setValueAt(tfTen.getText(), row, 1);
			}
		}
		if(o.equals(btnThoat)) {
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		tfHo.setText(table.getValueAt(row, 0).toString());
		tfTen.setText(table.getValueAt(row, 1).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
