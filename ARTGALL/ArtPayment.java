package ARTGALL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class ArtPayment extends JFrame implements ActionListener {

    JButton visa, mastercard, express, bkash, nagad, rocket, city, asia, confirm, reset, back;
    JLabel card, mbank, ibank, bkashl, rocketl, nagadl, phone, pass, amount;
    JTextField phonef, passf, amountf;
    JPanel panel;
    Icon iconb, iconr, iconn, iconv, iconm, iconae, iconcity, iconasia, icon1, icon2, icon3;
    ArtGall aaa;
    Font font;

    public ArtPayment(ArtGall aaa) {
        super("Payment gataway");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.aaa = aaa;

        panel = new JPanel();
        panel.setBounds(0, 0, 700, 600);
        panel.setLayout(null);
        this.add(panel);

        iconb = new ImageIcon("PICTURES\\BKASH2.png");
        iconr = new ImageIcon("PICTURES\\ROCKET2.png");
        iconn = new ImageIcon("PICTURES\\NAGAD2.png");
        iconv = new ImageIcon("PICTURES\\VISA2.png");
        iconm = new ImageIcon("PICTURES\\MASTERCARD2.png");
        iconae = new ImageIcon("PICTURES\\EXPRESS2.png");
        iconcity = new ImageIcon("PICTURES\\CITY.png");
        iconasia = new ImageIcon("PICTURES\\BANKASIA.png");

        bkashl = new JLabel(iconb);
        bkashl.setBounds(70, 70, 100, 90);
        bkashl.setVisible(false);
        panel.add(bkashl);

        rocketl = new JLabel(iconr);
        rocketl.setBounds(70, 70, 100, 90);
        rocketl.setVisible(false);
        panel.add(rocketl);

        nagadl = new JLabel(iconn);
        nagadl.setBounds(70, 70, 100, 90);
        nagadl.setVisible(false);
        panel.add(nagadl);

        phone = new JLabel("PHONE NO");
        phone.setBounds(10, 180, 80, 40);
        phone.setVisible(false);
        panel.add(phone);

        phonef = new JTextField();
        phonef.setBounds(95, 180, 120, 40);
        phonef.setVisible(false);
        panel.add(phonef);

        pass = new JLabel("PASSWORD");
        pass.setBounds(10, 230, 80, 40);
        pass.setVisible(false);
        panel.add(pass);

        passf = new JTextField();
        passf.setBounds(95, 230, 120, 40);
        passf.setVisible(false);
        panel.add(passf);

        card = new JLabel("CARDS");
        card.setBounds(300, 70, 60, 30);
        panel.add(card);

        mbank = new JLabel("MOBILE BANGKING");
        mbank.setBounds(300, 175, 120, 30);
        panel.add(mbank);

        ibank = new JLabel("INTERNET BANGKING");
        ibank.setBounds(300, 280, 120, 30);
        panel.add(ibank);

        visa = new JButton(iconv);
        visa.setBounds(300, 100, 89, 75);
        visa.addActionListener(this);
        panel.add(visa);

        mastercard = new JButton(iconm);
        mastercard.setBounds(395, 100, 89, 75);
        mastercard.addActionListener(this);
        panel.add(mastercard);

        express = new JButton(iconae);
        express.setBounds(490, 100, 89, 75);
        express.addActionListener(this);
        panel.add(express);

        bkash = new JButton(iconb);
        bkash.setBounds(300, 205, 89, 75);
        bkash.addActionListener(this);
        panel.add(bkash);

        rocket = new JButton(iconr);
        rocket.setBounds(395, 205, 89, 75);
        rocket.addActionListener(this);
        panel.add(rocket);

        nagad = new JButton(iconn);
        nagad.setBounds(490, 205, 89, 75);
        nagad.addActionListener(this);
        panel.add(nagad);

        city = new JButton(iconcity);
        city.setBounds(300, 310, 89, 75);
        city.addActionListener(this);
        panel.add(city);

        asia = new JButton(iconasia);
        asia.setBounds(395, 310, 89, 75);
        asia.addActionListener(this);
        panel.add(asia);

        amount = new JLabel("YOUR AMOUNT");
        amount.setBounds(110, 370, 100, 30);
        panel.add(amount);

        font = new Font("SansSerit", font.BOLD, 60);

        amountf = new JTextField();
        amountf.setBounds(65, 410, 180, 90);
        amountf.setFont(font);
        amountf.setEditable(false);
        amountf.setHorizontalAlignment(amountf.CENTER);
        panel.add(amountf);

        confirm = new JButton("CONFIRM");
        confirm.setBounds(30, 280, 90, 30);
        confirm.setBackground(new Color(63, 161, 251));
        confirm.addActionListener(this);
        confirm.setVisible(false);
        panel.add(confirm);

        reset = new JButton("RESET");
        reset.setBounds(140, 280, 80, 30);
        reset.setBackground(new Color(63, 161, 251));
        reset.addActionListener(this);
        reset.setVisible(false);
        panel.add(reset);

        back = new JButton("BACK");
        back.setBounds(100, 320, 80, 30);
        back.setBackground(new Color(63, 161, 251));
        back.addActionListener(this);
        panel.add(back);

        this.setVisible(true);

    }

    void amount(String str) {
        amountf.setText(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == bkash) {
            bkashl.setVisible(true);
            rocketl.setVisible(false);
            nagadl.setVisible(false);
            phone.setVisible(true);
            phonef.setVisible(true);
            pass.setVisible(true);
            passf.setVisible(true);
            confirm.setVisible(true);
            reset.setVisible(true);
        }
        if (e.getSource() == rocket) {
            rocketl.setVisible(true);
            nagadl.setVisible(false);
            bkashl.setVisible(false);
            phone.setVisible(true);
            phonef.setVisible(true);
            pass.setVisible(true);
            passf.setVisible(true);
            confirm.setVisible(true);
            reset.setVisible(true);

        }
        if (e.getSource() == nagad) {
            nagadl.setVisible(true);
            bkashl.setVisible(false);
            rocketl.setVisible(false);
            phone.setVisible(true);
            phonef.setVisible(true);
            pass.setVisible(true);
            passf.setVisible(true);
            confirm.setVisible(true);
            reset.setVisible(true);
        }
        if (e.getSource() == reset) {
            phonef.setText(" ");
            passf.setText(" ");
        }

        if (e.getSource() == confirm) {
            JOptionPane.showMessageDialog(null, "Payment Complete");
        }

        if (e.getSource() == back) {
            aaa.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }

    }
}
