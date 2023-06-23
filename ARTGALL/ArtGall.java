package ARTGALL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LANDINGPAGE.*;

public class ArtGall extends JFrame implements ActionListener {
    JPanel panel;
    JButton art1, art2, art3, art4, confirm, reset, back;
    JTextField tfbill;
    JLabel l1, l2, l3, l4;
    ImageIcon icon1, icon2, icon3, icon4;
    JCheckBox r1, r2, r3, r4;
    JLabel lbill;
    Font font, font1;

    public ArtGall() {
        super("ART & PARCHASE");
        this.setSize(846, 544);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        icon1 = new ImageIcon("PICTURES\\ART11.png");
        icon2 = new ImageIcon("PICTURES\\ART22.jpg");
        icon3 = new ImageIcon("PICTURES\\ART3.jpeg");
        icon4 = new ImageIcon("PICTURES\\ART44.jpg");

        panel = new JPanel();
        panel.setBounds(0, 0, 846, 544);
        panel.setLayout(null);

        art1 = new JButton(icon1);
        art1.setBounds(50, 50, 163, 161);
        panel.add(art1);

        l1 = new JLabel("500 TAKA");
        l1.setBounds(100, 220, 71, 23);
        panel.add(l1);

        r1 = new JCheckBox();
        r1.setBounds(10, 105, 40, 40);
        r1.addActionListener(this);
        panel.add(r1);

        art2 = new JButton(icon2);
        art2.setBounds(263, 50, 163, 161);
        panel.add(art2);

        l2 = new JLabel("1000 TAKA");
        l2.setBounds(281, 220, 71, 23);
        panel.add(l2);

        r2 = new JCheckBox();
        r2.setBounds(223, 105, 40, 40);
        r2.addActionListener(this);
        panel.add(r2);

        art3 = new JButton(icon3);
        art3.setBounds(50, 261, 163, 161);
        panel.add(art3);

        l3 = new JLabel("2000 TAKA");
        l3.setBounds(100, 432, 71, 23);
        panel.add(l3);

        r3 = new JCheckBox();
        r3.setBounds(10, 341, 40, 40);
        r3.addActionListener(this);
        panel.add(r3);

        art4 = new JButton(icon4);
        art4.setBounds(263, 261, 163, 161);
        panel.add(art4);

        l4 = new JLabel("3000 TAKA");
        l4.setBounds(281, 432, 71, 23);
        panel.add(l4);

        r4 = new JCheckBox();
        r4.setBounds(223, 341, 40, 40);
        r4.addActionListener(this);
        panel.add(r4);

        font = new Font("SansSerit", font.BOLD, 40);
        font1 = new Font("SansSerit", font.BOLD, 30);

        lbill = new JLabel("YOUR BILL");
        lbill.setBounds(600, 50, 200, 30);
        lbill.setFont(font1);
        panel.add(lbill);

        tfbill = new JTextField();
        tfbill.setBounds(610, 100, 130, 70);
        tfbill.setFont(font);
        tfbill.setEditable(false);
        tfbill.setHorizontalAlignment(tfbill.CENTER);
        panel.add(tfbill);

        confirm = new JButton("CONFIRM");
        confirm.setBounds(580, 200, 90, 30);
        confirm.setBackground(new Color(63, 161, 251));
        confirm.addActionListener(this);
        panel.add(confirm);

        reset = new JButton("RESET");
        reset.setBounds(680, 200, 80, 30);
        reset.setBackground(new Color(63, 161, 251));
        reset.addActionListener(this);
        panel.add(reset);

        back = new JButton("BACK");
        back.setBounds(710, 450, 80, 30);
        back.setBackground(new Color(63, 161, 251));
        back.addActionListener(this);
        panel.add(back);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (r1.isSelected() == true) {
            tfbill.setText("500");
        }
        if (r2.isSelected() == true) {
            tfbill.setText("1000");
        }
        if (r1.isSelected() == true && r2.isSelected() == true) {
            tfbill.setText("1500");
        }

        if (r3.isSelected() == true) {
            tfbill.setText("2000");
        }

        if (r4.isSelected() == true) {
            tfbill.setText("3000");
        }

        if (r1.isSelected() == true && r3.isSelected() == true) {
            tfbill.setText("2500");
        }

        if (r1.isSelected() == true && r4.isSelected() == true) {
            tfbill.setText("3500");
        }
        if (r2.isSelected() == true && r3.isSelected() == true) {
            tfbill.setText("3000");
        }
        if (r2.isSelected() == true && r4.isSelected() == true) {
            tfbill.setText("4000");
        }
        if (r3.isSelected() == true && r4.isSelected() == true) {
            tfbill.setText("5000");
        }
        if (r1.isSelected() == true && r2.isSelected() == true && r3.isSelected() == true && r4.isSelected() == true) {
            tfbill.setText("6500");
        }
        if (r1.isSelected() == true && r2.isSelected() == true && r3.isSelected() == true) {
            tfbill.setText("3500");
        }
        if (r1.isSelected() == true && r2.isSelected() == true && r4.isSelected() == true) {
            tfbill.setText("4500");
        }
        if (r1.isSelected() == true && r3.isSelected() == true && r4.isSelected() == true) {
            tfbill.setText("5500");
        }
        if (r2.isSelected() == true && r3.isSelected() == true && r4.isSelected() == true) {
            tfbill.setText("6000");
        }
        if (e.getSource() == confirm) {
            ArtPayment aaa = new ArtPayment(this);
            String bill = tfbill.getText();
            aaa.amount(bill);
            aaa.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == reset) {
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(false);
            r4.setSelected(false);
            tfbill.setText(null);
        }
        if (e.getSource() == back) {
            LANDING l = new LANDING();
            l.setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        ArtGall ab = new ArtGall();
    }
}
