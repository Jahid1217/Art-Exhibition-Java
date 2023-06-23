package EXHIBITION;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import LANDINGPAGE.*;
import PAYMENT.*;

public class EXHIBITION extends JFrame implements ActionListener {

    JLabel idLabel, fnameLabel, lnameLabel, phonelabel, emaillabel, grouplabel, piclabel, addresslabel, genderlabel,
            label, label1, label3, picTF, vanuelab;
    JTextField idTF, fnameTF, lnameTF, phoneTF, emailTF, groupTF, addressTF, vanuetf;

    JButton browseBtn, deleteBtn, editBtn, addBtn, showBtn, reset;
    JComboBox combo;
    JPanel panel;
    Color myColor;
    Font myFont;
    JRadioButton r1, r2, r3;
    ButtonGroup bg1;
    JComboBox combo1;
    String s5;

    public EXHIBITION() {
        super("DATAFILLUP FOR PARTICIPION IN EXHIBITION");
        this.setSize(800, 600);
        Image icon = Toolkit.getDefaultToolkit().getImage("hostel-sign-.jpg");
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        myColor = new Color(245, 255, 250);
        myFont = new Font("Arial", Font.PLAIN, 28);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor);

        label = new JLabel();
        label.setText("PLEASE FILL ALL THE INFORMATION");
        label.setFont(new Font("Rockwell Nova Light", Font.BOLD, 25));
        label.setBounds(150, 0, 600, 50);
        panel.add(label);

        label1 = new JLabel();
        label1.setIcon(new ImageIcon("Hostel.jpg"));
        label1.setBounds(300, 10, 450, 120);
        panel.add(label1);
        fnameLabel = new JLabel("First Name : ");
        fnameLabel.setBounds(10, 80, 160, 30);
        fnameTF = new JTextField();
        fnameTF.setBounds(110, 80, 160, 30);
        panel.add(fnameTF);
        panel.add(fnameLabel);

        lnameLabel = new JLabel("Last Name : ");
        lnameLabel.setBounds(10, 140, 160, 30);
        lnameTF = new JTextField();
        lnameTF.setBounds(110, 140, 160, 30);
        panel.add(lnameTF);
        panel.add(lnameLabel);

        vanuelab = new JLabel("Vanue: ");
        vanuelab.setBounds(10, 200, 160, 30);
        String items[] = { "MIRPUR", "AGARGAO", "MALIBAG", "KHILKHET", "MOHAKHALI" };
        combo1 = new JComboBox<>(items);
        combo1.setBounds(110, 200, 160, 30);
        panel.add(vanuelab);
        panel.add(combo1);

        phonelabel = new JLabel("PHONE NO:");
        phonelabel.setBounds(10, 260, 160, 30);
        phoneTF = new JTextField();
        phoneTF.setBounds(110, 260, 160, 30);
        panel.add(phoneTF);
        panel.add(phonelabel);

        emaillabel = new JLabel("EMAIL: ");
        emaillabel.setBounds(10, 380, 160, 30);
        emailTF = new JTextField();
        emailTF.setBounds(110, 380, 160, 30);
        panel.add(emailTF);
        panel.add(emaillabel);

        genderlabel = new JLabel("Gender: ");
        genderlabel.setBounds(10, 435, 160, 30);
        panel.add(genderlabel);

        r1 = new JRadioButton("Male");
        r1.setBounds(80, 440, 60, 20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(150, 440, 70, 20);
        panel.add(r2);

        r3 = new JRadioButton("Others");
        r3.setBounds(220, 440, 65, 20);
        panel.add(r3);

        bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);

        piclabel = new JLabel("Upload your Profile Picture: ");
        piclabel.setBounds(410, 80, 160, 30);
        picTF = new JLabel();
        picTF.setBounds(400, 120, 200, 210);
        panel.add(picTF);
        panel.add(piclabel);

        browseBtn = new JButton("Browse");
        browseBtn.setBounds(445, 340, 90, 30);
        browseBtn.setBackground(new Color(63, 161, 251));
        browseBtn.addActionListener(this);
        panel.add(browseBtn);

        addresslabel = new JLabel("Address: ");
        addresslabel.setBounds(10, 320, 160, 30);
        addressTF = new JTextField();
        addressTF.setBounds(110, 320, 160, 30);
        panel.add(addressTF);
        panel.add(addresslabel);

        reset = new JButton("RESET");
        reset.setBounds(40, 500, 75, 30);
        reset.setBackground(new Color(63, 161, 251));
        reset.addActionListener(this);
        panel.add(reset);

        deleteBtn = new JButton("BACK");
        deleteBtn.setBounds(140, 500, 75, 30);
        deleteBtn.setBackground(new Color(63, 161, 251));
        deleteBtn.addActionListener(this);
        panel.add(deleteBtn);

        editBtn = new JButton("HOME");
        editBtn.setBounds(240, 500, 75, 30);
        editBtn.setBackground(new Color(63, 161, 251));
        editBtn.addActionListener(this);
        panel.add(editBtn);

        addBtn = new JButton("BUY TICKET");
        addBtn.setBounds(340, 500, 280, 30);
        addBtn.setBackground(new Color(63, 161, 251));
        addBtn.addActionListener(this);
        panel.add(addBtn);

        this.add(panel);
        this.setVisible(true);
    }

    public void getinfo() {
        label3.setVisible(true);
        label.setVisible(false);
    }

    String Gender() {
        if (r1.isSelected()) {
            System.out.println("Male");
        }
        if (r2.isSelected()) {
            System.out.println("Female");
        }
        if (r3.isSelected()) {
            System.out.println("Other");
        }
        return null;
    }

    public ImageIcon resize(String imgPath) {
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(picTF.getWidth(), picTF.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reset) {
            fnameTF.setText(" ");
            lnameTF.setText(" ");
            phoneTF.setText(" ");
            emailTF.setText(" ");
            addressTF.setText(" ");
        }

        if (ae.getSource() == addBtn) {

            if (fnameTF.getText().isEmpty() == true || lnameTF.getText().isEmpty() == true ||
                    phoneTF.getText().isEmpty() == true || emailTF.getText().isEmpty() == true
                    || addressTF.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Please enter all data before buying a ticket!");
            } else {
                Payment p = new Payment();
                p.setVisible(true);
                this.setVisible(false);

                if (ae.getSource() == addBtn) {
                    String s3 = "";
                    if (r1.isSelected()) {
                        s3 = r1.getText();
                    } else if (r2.isSelected()) {
                        s3 = r2.getText();
                    } else if (r3.isSelected()) {
                        s3 = r3.getText();
                    }

                    try {
                        FileWriter fw = new FileWriter(
                                "TXT FILES\\ExhibitionData.txt",
                                true);

                        fw.write(fnameTF.getText() + " " + combo1.getSelectedItem().toString() + " " + phoneTF.getText()
                                + " "
                                + addressTF.getText() + " " + emailTF.getText() + "\r\n");
                        fw.close();

                        lnameTF.setText("");
                        phoneTF.setText("");
                        fnameTF.setText("");
                        emailTF.setText("");
                        addressTF.setText("");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        if (ae.getSource() == deleteBtn) {
            LANDING l = new LANDING();
            l.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }

        else if (ae.getSource() == browseBtn) {

            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            // filtering files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
            file.addChoosableFileFilter(filter);
            int res = file.showSaveDialog(null);
            // if the user clicks on save in Jfilechooser
            if (res == JFileChooser.APPROVE_OPTION) {
                File selFile = file.getSelectedFile();
                String path = selFile.getAbsolutePath();
                picTF.setIcon(resize(path));
            }
        } else if (ae.getSource() == deleteBtn) {

        }
    }
}
