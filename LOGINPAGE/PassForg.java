package LOGINPAGE;

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

public class PassForg extends JFrame implements ActionListener {
    private JTable j;
    private JButton profileBtn, confirm, back;
    private JLabel label;
    private Font myFont;
    private DefaultTableModel model;
    // Room1 r;
    JTable table;
    JPanel jp;
    JLabel cp, np;
    JTextField tfcp, tfnp;
    JButton con, bak;

    PassForg() {
        this.setTitle("PassWord recovery form");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // this.setLayout(null);

        jp = new JPanel();
        jp.setBounds(0, 0, 600, 400);
        jp.setBackground(new Color(87, 173, 251));
        jp.setLayout(null);

        JPanel jp2 = new JPanel();
        jp2.setBounds(100, 0, 400, 400);
        // jp2.setBackground(Color.gray);
        jp2.setLayout(null);
        jp.add(jp2);

        label = new JLabel();
        label.setText("RECOVER YOUR PASSWORD");
        label.setFont(myFont);
        label.setFont(new Font("Rockwell Nova Light", Font.BOLD, 16));
        label.setBounds(100, 10, 300, 80);
        // label.setForeground(Color.BLACK);
        jp2.add(label);

        cp = new JLabel("ENTER YOUR NAME :");
        cp.setBounds(50, 90, 120, 50);
        jp2.add(cp);

        np = new JLabel(" YOUR PASSWORD :");
        np.setBounds(50, 130, 120, 50);
        jp2.add(np);

        tfcp = new JTextField();
        tfcp.setBounds(180, 100, 120, 30);
        jp2.add(tfcp);

        tfnp = new JTextField();
        tfnp.setBounds(180, 140, 120, 30);
        tfnp.setEditable(false);
        jp2.add(tfnp);

        con = new JButton("CONFIRM");
        con.setBounds(80, 180, 90, 30);
        con.addActionListener(this);
        jp2.add(con);

        bak = new JButton("BACK");
        bak.setBounds(180, 180, 90, 30);
        bak.addActionListener(this);
        jp2.add(bak);

        Image icon = Toolkit.getDefaultToolkit().getImage("hostel-sign-.jpg");
        setIconImage(icon);
        myFont = new Font("Cambria", Font.PLAIN, 25);

        validate();
        this.add(jp);
        this.setVisible(true);
    }

    public void Read() {
        String line;
        BufferedReader reader;
        try {
            File file = new File("TXT FILES\\Login.txt");
            FileReader read = new FileReader(file);
            reader = new BufferedReader(read);

            Object[] lines = reader.lines().toArray();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split("\n");
                model.addRow(row);
            }
            reader.close();
        } catch (IOException ae) {
            ae.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == con && tfcp.getText().isEmpty() == false) {
            try {
                File f1 = new File("Login.txt");
                FileReader fr = new FileReader(f1);
                BufferedReader br = new BufferedReader(fr);
                String[] words = null;
                String s;
                String s2;
                String s1 = tfcp.getText();
                int count = 0;
                while ((s = br.readLine()) != null) {
                    words = s.split(" ");
                    for (String word : words) {
                        if (word.equals(s1)) {
                            count++;
                        }
                    }
                }

                String s4 = count + "";
                tfnp.setText(s4);

                if (count != 0) {
                    JOptionPane.showMessageDialog(null, "This is a valid Name");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Name");
                }

                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        else if (e.getSource() == con && tfcp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter name");
        } else if (e.getSource() == bak) {
            Login a = new Login();
            this.dispose();
            a.setVisible(true);
        }

    }
}
