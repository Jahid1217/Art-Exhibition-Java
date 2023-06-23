package ADMIN;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
import LOGINPAGE.*;

public class Admin extends JFrame implements ActionListener {
    private JTable j;
    private JButton profileBtn, confirm, back, adminreg;
    private JLabel label;
    private Font myFont;
    private DefaultTableModel model;
    JTable table;
    JPanel jp;
    JLabel cp, np;
    JTextField uf, pf;
    JButton con, bak;

    public Admin() {
        this.setTitle("LOGIN AS ADMIN");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        jp = new JPanel();
        jp.setBounds(0, 0, 600, 400);
        jp.setBackground(new Color(87, 173, 251));
        jp.setLayout(null);

        JPanel jp2 = new JPanel();
        jp2.setBounds(100, 0, 400, 400);
        jp2.setLayout(null);
        jp.add(jp2);

        label = new JLabel();
        label.setText("LOGIN AS ADMINSTRATION");
        label.setFont(myFont);
        label.setFont(new Font("Rockwell Nova Light", Font.BOLD, 16));
        label.setBounds(100, 10, 300, 80);
        jp2.add(label);

        cp = new JLabel("USERNAME :");
        cp.setBounds(50, 90, 120, 50);
        jp2.add(cp);

        np = new JLabel("PASSWORD :");
        np.setBounds(50, 130, 120, 50);
        jp2.add(np);

        uf = new JTextField();
        uf.setBounds(180, 100, 120, 30);
        jp2.add(uf);

        pf = new JTextField();
        pf.setBounds(180, 140, 120, 30);
        jp2.add(pf);

        con = new JButton("LOGIN");
        con.setBounds(50, 180, 90, 30);
        con.setBackground(new Color(63, 161, 251));
        con.addActionListener(this);
        jp2.add(con);

        adminreg = new JButton("ADMIN REGISTRATION");
        adminreg.setBounds(150, 180, 190, 30);
        adminreg.setBackground(new Color(63, 161, 251));
        adminreg.addActionListener(this);
        jp2.add(adminreg);

        bak = new JButton("BACK");
        bak.setBounds(290, 280, 90, 30);
        bak.setBackground(new Color(63, 161, 251));
        bak.addActionListener(this);
        jp2.add(bak);

        Image icon = Toolkit.getDefaultToolkit().getImage("hostel-sign-.jpg");
        setIconImage(icon);
        myFont = new Font("Cambria", Font.PLAIN, 25);

        validate();

        this.add(jp);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == con && uf.getText().isEmpty() == false && pf.getText().isEmpty() == false) {
            if (e.getSource() == con && uf.getText().isEmpty() == false
                    && pf.getText().isEmpty() == false) {
                Boolean matched = false;
                String user = uf.getText().toString();
                String pass = pf.getText().toString(); // this will not keep pass in the string pool
                try {
                    FileReader fr = new FileReader("AdminLogin.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.equals(user + " " + pass)) {
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                } catch (Exception a) {
                }
                if (matched) {

                    this.setVisible(false);

                    new AdminLanding();
                } else {
                    showMessageDialog(null, "Invalid Username and password! Try Again");

                }
            }
            if (e.getSource() == con && uf.getText().isEmpty() == true
                    && pf.getText().isEmpty() == false) {
                JOptionPane.showMessageDialog(null, "Please input Username");
            }
            if (e.getSource() == con && uf.getText().isEmpty() == false
                    && pf.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Please input Password");
            }
            if (e.getSource() == con && uf.getText().isEmpty() == true
                    && pf.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Please input Username and Password");
            }
        }
        if (e.getSource() == bak) {
            Login a = new Login();
            a.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
        if (e.getSource() == adminreg) {
            Registration r = new Registration();
            r.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }

    }
}