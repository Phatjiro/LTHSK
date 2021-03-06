package lythuyet.tuan1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NguyenVanPhat_19483821_50_JlistDemo extends JFrame implements ListSelectionListener{
	private JList lstEntry;
	private JTextField tfSelection;
	public NguyenVanPhat_19483821_50_JlistDemo() {
		this.setTitle("Jlist Demo cái thứ nhất");
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// tạo 1 String list chút xài
		String[] Entries = {"Entry 1", "Entry 2", "Entry 3", "Entry 4", "Entry 5", "Entry 6"};
		// tạo panel ở giữa nè
		JPanel pCen = new JPanel();
		pCen.setBorder(BorderFactory.createTitledBorder("Simple JList"));
		
		lstEntry = new JList(Entries);
		lstEntry.setFont(new Font(lstEntry.getFont().getName(),lstEntry.getFont().getStyle(),18));
		lstEntry.setVisibleRowCount(4);
		JScrollPane listEntry = new JScrollPane(lstEntry);
		pCen.add(listEntry);
		
		// tạo panel ở dưới nè
		JPanel pSou = new JPanel();
		pSou.setBorder(BorderFactory.createTitledBorder("List selection"));
		
		JLabel lblSelection = new JLabel("Last selection:");
		lblSelection.setFont(new Font(lstEntry.getFont().getName(),lstEntry.getFont().getStyle(),18));
		tfSelection = new JTextField(8);
		tfSelection.setFont(new Font(lstEntry.getFont().getName(),lstEntry.getFont().getStyle(),18));
		pSou.add(lblSelection);
		pSou.add(tfSelection);
		
		//đăng kí bộ lắng nghe
		lstEntry.addListSelectionListener(this);
		
		// add panel vô khung chính nè
		this.add(pCen);
		this.add(pSou, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_JlistDemo().setVisible(true);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		tfSelection.setText(lstEntry.getSelectedValue()+"");
	}
}
