package LOGINPAGE;

import javax.swing.JFrame;
import ADMIN.Admin;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import LANDINGPAGE.*;

public class Login extends JFrame implements ActionListener {

    JPanel panel1, panel2;
    JLabel l1, l2, l3, l4, l5;
    JButton b1, b2, b3, adminlog, exitbtn;
    Font font, font2;
    JTextField f1;
    JPasswordField f2;
    Color c;
    Image icon;

    public Login() {
        super("Loging page of ART EXHIBITION");
        this.setSize(886, 554);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        font = new Font("Lexend Deca", Font.PLAIN, 74);
        c = new Color(34, 73, 83);

        panel1 = new JPanel();
        panel1.setBackground(Color.lightGray);
        panel1.setBounds(0, 0, 886, 554);
        panel1.setLayout(null);

        l1 = new JLabel("Sign in");
        l1.setBounds(330, 10, 312, 80);
        l1.setForeground(Color.WHITE);
        l1.setFont(font);
        panel1.add(l1);

        l2 = new JLabel("Sign in and start enjoying our art exhibition hall!");
        l2.setBounds(280, 100, 287, 20);
        l2.setFont(new Font("Serif", Font.PLAIN, 16));
        l2.setForeground(Color.WHITE);
        panel1.add(l2);

        f1 = new JTextField();
        f1.setFont(new Font("Roboto Mono", Font.PLAIN, 13));
        f1.setBounds(320, 150, 200, 45);
        f1.setBackground(c);
        f1.setForeground(Color.WHITE);
        f1.setVisible(true);
        panel1.add(f1);

        b1 = new JButton("REGISTER");
        b1.setHorizontalTextPosition(JButton.CENTER);
        b1.setVerticalTextPosition(JButton.CENTER);
        b1.setBounds(230, 290, 100, 40);
        b1.setBackground(new Color(63, 161, 251));
        b1.addActionListener(this);
        panel1.add(b1);

        b2 = new JButton("LOGIN");
        b2.setHorizontalTextPosition(JButton.CENTER);
        b2.setVerticalTextPosition(JButton.CENTER);
        b2.setBounds(340, 290, 100, 40);
        b2.setBackground(new Color(63, 161, 251));
        b2.addActionListener(this);
        panel1.add(b2);

        b3 = new JButton("FORGOT PASSWORD?");
        b3.setHorizontalTextPosition(JButton.CENTER);
        b3.setVerticalTextPosition(JButton.CENTER);
        b3.setBounds(450, 290, 170, 40);
        b3.setBackground(new Color(63, 161, 251));
        b3.addActionListener(this);
        panel1.add(b3);

        adminlog = new JButton("LOGIN AS ADMIN");
        adminlog.setHorizontalTextPosition(JButton.CENTER);
        adminlog.setVerticalTextPosition(JButton.CENTER);
        adminlog.setBounds(287, 350, 270, 40);
        adminlog.setBackground(new Color(63, 161, 251));
        adminlog.addActionListener(this);
        panel1.add(adminlog);

        exitbtn = new JButton("EXIT");
        exitbtn.setHorizontalTextPosition(JButton.CENTER);
        exitbtn.setVerticalTextPosition(JButton.CENTER);
        exitbtn.setBounds(760, 480, 90, 30);
        exitbtn.setBackground(new Color(63, 161, 251));
        exitbtn.addActionListener(this);
        panel1.add(exitbtn);

        f2 = new JPasswordField();
        f2.setFont(new Font("Roboto Mono", Font.PLAIN, 13));
        f2.setBounds(320, 210, 200, 45);
        f2.setBackground(c);
        f2.setVisible(true);
        f2.setForeground(Color.WHITE);
        panel1.add(f2);

        l4 = new JLabel("USERNAME");
        l4.setBounds(240, 150, 150, 40);
        l4.setForeground(Color.WHITE);
        panel1.add(l4);

        l5 = new JLabel("PASSWORD");
        l5.setBounds(240, 210, 150, 40);
        l5.setForeground(Color.WHITE);
        panel1.add(l5);

        icon = Toolkit.getDefaultToolkit().getImage("PICTURES\\ART.Jpeg");
        Container c = this.getContentPane();
        l1 = new JLabel();
        l1.setIcon(new ImageIcon("PICTURES\\ART.Jpeg"));
        Dimension size = l1.getPreferredSize();
        l1.setBounds(0, 0, size.width, size.height);
        panel1.add(l1);

        this.add(panel1);
        this.setIconImage(icon);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b2 && f1.getText().isEmpty() == false
                && f2.getText().isEmpty() == false) {
            Boolean matched = false;
            String user = f1.getText().toString();
            String pass = f2.getText().toString(); // this will not keep pass in the string pool
            try {
                FileReader fr = new FileReader(
                        "TXT FILES\\Login.txt");
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

                new LANDING();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username and password! Try Again");

            }
        }
        if (ae.getSource() == b2 && f1.getText().isEmpty() == true
                && f2.getText().isEmpty() == false) {
            JOptionPane.showMessageDialog(null, "Please input Username");
        }
        if (ae.getSource() == b2 && f1.getText().isEmpty() == false
                && f2.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Please input Password");
        }
        if (ae.getSource() == b2 && f1.getText().isEmpty() == true
                && f2.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Please input Username and Password");
        }

        if (ae.getSource() == b3) {

            PassForg p = new PassForg();
            p.setVisible(true);
            this.setVisible(false);
            this.dispose();

        }

        if (ae.getSource() == b1) {

            Registration r = new Registration();
            r.setVisible(true);
            this.setVisible(false);
            this.dispose();

        }
        if (ae.getSource() == adminlog) {
            Admin a = new Admin();
            a.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }

        if (ae.getSource() == exitbtn) {
            this.dispose();

        }

    }
}
