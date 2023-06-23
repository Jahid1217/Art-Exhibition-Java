package DONATION;

import javax.swing.JFrame;
import javax.swing.JTable;
import LANDINGPAGE.LANDING;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class DonateAmount extends JFrame implements ActionListener {
    private JTable j;
    private JButton profileBtn, confirm, back;
    private JLabel label;
    private Font myFont;
    JPanel jp;
    JLabel cp, np;
    JTextField tfcp, tfnp;
    JButton con, bak;
    Font font;

    public DonateAmount() {
        this.setTitle("PassWord recovery form");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // this.setLayout(null);

        font = new Font("SansSerit", font.BOLD, 30);

        jp = new JPanel();
        jp.setBounds(0, 0, 600, 400);
        jp.setLayout(null);

        label = new JLabel("PLEASE ENTER YOUR DONATION AMOUNT");
        label.setBounds(60, 50, 250, 40);
        jp.add(label);

        tfcp = new JTextField();
        tfcp.setBounds(130, 90, 90, 60);
        tfcp.setFont(font);
        tfcp.setHorizontalAlignment(tfcp.CENTER);
        jp.add(tfcp);

        back = new JButton("BACK");
        back.setBounds(100, 160, 80, 30);
        back.setBackground(new Color(63, 161, 251));
        back.addActionListener(this);
        jp.add(back);

        confirm = new JButton("CONFIRM");
        confirm.setBounds(185, 160, 90, 30);
        confirm.setBackground(new Color(63, 161, 251));
        confirm.addActionListener(this);
        jp.add(confirm);

        this.add(jp);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            LANDING l = new LANDING();
            l.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource() == confirm && tfcp.getText().isEmpty() == false) {
            String str = tfcp.getText();
            Donation d = new Donation(this);
            d.amount(str);
            d.setVisible(true);
            this.setVisible(false);
        }

    }

}
