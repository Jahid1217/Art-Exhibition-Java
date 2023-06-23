package LANDINGPAGE;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import LOGINPAGE.*;
import DATAFILLUP.*;
import EXHIBITION.*;
import DONATION.*;
import ARTGALL.ArtGall;

public class LANDING extends JFrame implements ActionListener {

    JLabel h, l2;
    private JToggleButton button;
    private JButton b1, b5, b3, b2, b4, b6;

    public LANDING() {
        super("WELCOME TO CHOBI GOLPO");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        h = new JLabel("CHOBI GOLPO");
        h.setBounds(50, 15, 400, 100);
        h.setFont(new Font("Irish Grover", Font.BOLD, 30));
        add(h);

        b1 = new JButton("TAKE PART");
        b1.setBounds(300, 200, 220, 50);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("EXHIBITION");
        b2.setBounds(300, 280, 220, 50);
        b2.addActionListener(this);

        b3 = new JButton("ART GALLARY");
        b3.setBounds(300, 360, 220, 50);
        b3.addActionListener(this);

        b4 = new JButton("DONATE");
        b4.setBounds(300, 440, 220, 50);
        b4.addActionListener(this);

        b5 = new JButton("Logout");
        b5.setBounds(640, 70, 120, 40);
        b5.addActionListener(this);

        add(b2);
        add(b3);
        add(b4);
        add(b5);

        this.setSize(800, 700);
        h = new JLabel(new ImageIcon("istockphoto-1203878857-612x612(1).jpg"));
        h.setBounds(00, 00, 800, 700);
        this.add(h);
        Image icon = Toolkit.getDefaultToolkit().getImage("hostel-sign-.jpg");
        this.setIconImage(icon);

        l2 = new JLabel();
        l2.setIcon(new ImageIcon("PICTURES\\LANDING.Jpeg"));
        Dimension size = l2.getPreferredSize();
        l2.setBounds(50, 30, size.width, size.height);
        add(l2);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            EXHIBITION e = new EXHIBITION();
            e.setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b5) {

            Login l1 = new Login();
            l1.setVisible(true);
            this.setVisible(false);
            this.dispose();

        }

        if (ae.getSource() == b3) {
            ArtGall a = new ArtGall();
            a.setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == b1) {
            DATAFILLUP df = new DATAFILLUP();
            // df.Read();
            df.setVisible(true);
            this.setVisible(false);
        }
        if (ae.getSource() == b4) {
            DonateAmount d = new DonateAmount();
            d.setVisible(true);
            this.setVisible(false);
        }

    }

}
