package thuchanh.tuan1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NguyenVanPhat_19483821_50_bai2tuan1 extends JFrame implements ActionListener{
	private JTextField tfNhapSo;
	private JButton btnPhat;
	private JTextArea taSoNT;
	private JScrollPane scrollPane;
	public NguyenVanPhat_19483821_50_bai2tuan1() {
		this.setTitle("Prime sương sương");
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// tạo panel ở north chơi
		JPanel pNor = new JPanel();
		tfNhapSo = new JTextField(14);
		btnPhat = new JButton("Phát ra");
		this.add(pNor, BorderLayout.NORTH);
		pNor.add(tfNhapSo);
		pNor.add(btnPhat);
		// tạo panel ở center nè
		JPanel pCen = new JPanel();
		this.add(pCen, BorderLayout.CENTER);
		taSoNT = new JTextArea(12,22);
		taSoNT.setEditable(false);
		scrollPane = new JScrollPane(taSoNT);
		pCen.add(scrollPane);
		// đăng kí lắng nghe sương sương
		btnPhat.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_bai2tuan1().setVisible(true);
	}
	
	public static boolean checkPrime(int n) {
		for (int i=2; i<n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source.equals(btnPhat)) {
			int nSo = Integer.parseInt(tfNhapSo.getText());
			int soNT = 2;
			while(nSo>0) {
				if(checkPrime(soNT)==true) {
					nSo--;
					if(nSo>0) {
						taSoNT.setText(taSoNT.getText()+soNT+"\n");
					}
					else {
						taSoNT.setText(taSoNT.getText()+soNT);
					}
				}
				soNT++;
			}
		}
	}
}
