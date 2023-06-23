package LOGINPAGE;

import javax.swing.*;
import java.awt.Color;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame implements ActionListener {
	ImageIcon img;
	JLabel userLabel, passLabel, imgLabel;
	JLabel h1;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, back, cancel;
	JButton regBtn;
	JRadioButton r1, r2, r3;
	JCheckBox c1, c2, c3;
	ButtonGroup bg1;
	JComboBox combo;
	JPanel panel;
	String s;

	public Registration() {
		super("Premium Alcazaba Hostel");
		this.setSize(700, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Image ico = Toolkit.getDefaultToolkit().getImage("hostel-sign-.jpg");
		this.setIconImage(ico);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		panel = new JPanel();
		panel.setLayout(null);
		panel.add(new JLabel(new ImageIcon("images.png")));
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

		userLabel = new JLabel("User Name : ");
		userLabel.setBounds(150, 115, 100, 30);
		panel.add(userLabel);

		userTF = new JTextField();
		userTF.setBounds(280, 115, 200, 30);
		panel.add(userTF);

		passLabel = new JLabel("Password : ");
		passLabel.setBounds(150, 165, 200, 30);
		panel.add(passLabel);

		passPF = new JPasswordField();
		passPF.setBounds(280, 165, 200, 30);
		panel.add(passPF);

		regBtn = new JButton("REGISTER");
		regBtn.setBackground(new Color(63, 161, 251));
		regBtn.setBounds(210, 225, 110, 30);
		regBtn.addActionListener(this);
		panel.add(regBtn);

		exitBtn = new JButton("EXIT");
		exitBtn.setBackground(new Color(63, 161, 251));
		exitBtn.setBounds(480, 290, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);

		back = new JButton("BACK");
		back.setBounds(390, 290, 80, 30);
		back.setBackground(new Color(63, 161, 251));
		back.addActionListener(this);
		panel.add(back);

		cancel = new JButton("CANCEL");
		cancel.setBounds(330, 225, 90, 30);
		cancel.setBackground(new Color(63, 161, 251));
		cancel.addActionListener(this);
		panel.add(cancel);

		bg1 = new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		bg1.add(r3);

		String items[] = { "PARTICIPANT", "ADMIN" };
		combo = new JComboBox(items);
		((JLabel) combo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		combo.setBounds(150, 50, 330, 30);
		combo.setBackground(new Color(63, 161, 251));
		panel.add(combo);

		this.add(panel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == regBtn && userTF.getText().isEmpty() == false && passPF.getText().isEmpty() == false) {
			s = combo.getSelectedItem().toString();
			if (s == "PARTICIPANT") {
				try {
					FileWriter fw = new FileWriter(
							"TXT FILES\\Login.txt", true);

					fw.write(userTF.getText() + " " + passPF.getText() + "\r\n");
					fw.close();
					JOptionPane.showMessageDialog(null, "Registration Completed ");

					dispose();
					Login l = new Login();
					l.setVisible(true);

				} catch (Exception ea) {
					ea.printStackTrace();
				}
			} else if (s == "ADMIN") {
				try {
					FileWriter fw = new FileWriter(
							"TXT FILES\\AdminLogin.txt", true);

					fw.write(userTF.getText() + " " + passPF.getText() + "\r\n");
					fw.close();
					JOptionPane.showMessageDialog(null, "Registration Completed ");
					dispose();
					Login l = new Login();
					l.setVisible(true);

				} catch (Exception ea) {
					ea.printStackTrace();
				}
			}
		}
		if (e.getSource() == exitBtn) {
			dispose();

		}
		if (e.getSource() == back) {
			Login l = new Login();
			l.setVisible(true);
			dispose();

		}
		if (e.getSource() == regBtn && userTF.getText().isEmpty() == true && passPF.getText().isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Please Set a USERNAME & PASSWORD");
		}
		if (e.getSource() == regBtn && userTF.getText().isEmpty() == true && passPF.getText().isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Please Set a USERNAME ");
		}
		if (e.getSource() == regBtn && userTF.getText().isEmpty() == false && passPF.getText().isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Please Set a  PASSWORD");
		}
		if (e.getSource() == cancel) {
			userTF.setText("");
			passPF.setText("");
		}
	}
}
