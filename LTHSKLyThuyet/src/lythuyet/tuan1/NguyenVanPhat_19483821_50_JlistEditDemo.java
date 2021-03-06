package lythuyet.tuan1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NguyenVanPhat_19483821_50_JlistEditDemo extends JFrame implements ActionListener{
	private JTextField tfName;
	private JButton btnAdd;
	private JButton btnRemove;
	private DefaultListModel listmodelName;
	private JList listName;
	private JButton btnEdit;
	public NguyenVanPhat_19483821_50_JlistEditDemo() {
		this.setTitle("Jlist Editable phải thành công");
		this.setSize(500,320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// tạo panel ở center nè
		JPanel pCen = new JPanel();
		this.add(pCen);
		JLabel lblName = new JLabel("Input Name");
		tfName = new JTextField();
		btnAdd = new JButton("Add Item");
		btnRemove = new JButton("Remove Item");
		btnEdit = new JButton("Edit Item");
		
		lblName.setBounds(10,0,70,20);
		tfName.setBounds(80,0,140,20);
		btnAdd.setBounds(10,30,90,20);
		btnRemove.setBounds(110,30,110,20);
		btnEdit.setBounds(10,60, 90, 20);
		
		pCen.add(lblName);
		pCen.add(tfName);
		pCen.add(btnAdd);
		pCen.add(btnRemove);
		pCen.add(btnEdit);
		pCen.setLayout(null);
		
		// tạo list bên trái nè
		listmodelName = new DefaultListModel();
		listName = new JList(listmodelName);
		JScrollPane scName = new JScrollPane(listName);
		this.add(scName, BorderLayout.WEST);
		
		//đăng kí lắng nghe
		tfName.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnEdit.addActionListener(this);
	}
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_JlistEditDemo().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source.equals(btnAdd)) {
			String name = tfName.getText().trim();
			if(name.equals("")) {
				JOptionPane.showMessageDialog(this, "Hãy nhập tên vào!");
			}
			else {
				listmodelName.addElement(name);
				tfName.setText("");
			}
		}
		if(source.equals(btnRemove)) {
			if(listName.getSelectedValue()==null) {
				JOptionPane.showMessageDialog(this, "Hãy chọn tên muốn xoá");
			}
			else {
				listmodelName.removeElement(listName.getSelectedValue());
			}
		}
		if(source.equals(btnEdit)) {
			if(listName.getSelectedValue()==null || tfName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Hãy chọn và nhập tên muốn sửa");
			}
			else {
				listmodelName.setElementAt(tfName.getText(), listName.getSelectedIndex());
			}
		}
	}
}
