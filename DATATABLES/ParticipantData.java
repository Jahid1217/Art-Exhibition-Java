package DATATABLES;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import ADMIN.*;
import javax.swing.JLabel;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ParticipantData extends JFrame implements ActionListener {
    private JTable j;
    private JButton profileBtn, proAddBtn, proDleBtn;
    private JLabel label;
    private Font myFont;
    private DefaultTableModel model;
    // Room1 r;
    JTable table;
    JTextField txtFilter;
    TableRowSorter sorter;

    public ParticipantData() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Participants Data");
        getContentPane().setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("hostel-sign-.jpg");
        setIconImage(icon);
        myFont = new Font("Cambria", Font.PLAIN, 25);

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        label = new JLabel();
        label.setText(getTitle());
        label.setFont(myFont);
        label.setBounds(10, 0, 300, 50);
        add(label);
        String col[] = { "Id", "Name", "Phone Number", "Email", "Gender", "Address", "Venue" };

        String[][] data = null;
        model = new DefaultTableModel(data, col);
        sorter = new TableRowSorter<>(model);
        j = new JTable(model) {
            public Component prepareRenderer(TableCellRenderer renderer,
                    int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                Color color1 = new Color(165, 165, 165);
                Color color2 = Color.WHITE;
                if (!c.getBackground().equals(getSelectionBackground())) {
                    Color coleur = (row % 2 == 0 ? color1 : color2);
                    c.setBackground(coleur);
                    coleur = null;
                }
                return c;
            }
        };
        j.setRowSorter(sorter);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) j.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTableHeader th = j.getTableHeader();
        th.setBackground(Color.DARK_GRAY);
        th.setForeground(Color.WHITE);
        JScrollPane jsp = new JScrollPane(j);
        jsp.setViewportView(j);
        jsp.setBounds(50, 100, 700, 400);
        add(jsp);

        add(new JScrollPane(table));
        validate();

        JLabel lblFilter = new JLabel("Filter :");
        lblFilter.setBounds(510, 50, 72, 20);
        getContentPane().add(lblFilter);

        txtFilter = new JTextField();
        txtFilter.setBounds(550, 50, 150, 20);
        getContentPane().add(txtFilter);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtFilter.getText();
            }
        });

        btnOK.setBounds(710, 50, 60, 20);
        getContentPane().add(btnOK);

        profileBtn = new JButton("Back");
        profileBtn.setBounds(600, 510, 100, 30);
        profileBtn.setBackground(new Color(63, 161, 251));
        profileBtn.addActionListener(this);
        add(profileBtn);

        proAddBtn = new JButton("ADD");
        proAddBtn.setBounds(90, 510, 100, 30);
        proAddBtn.setBackground(new Color(63, 161, 251));
        proAddBtn.addActionListener(this);
        add(proAddBtn);

        txtFilter.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(txtFilter.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(txtFilter.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(txtFilter.getText());
            }

            public void search(String str) {
                if (str.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });

        proDleBtn = new JButton("Delete");
        proDleBtn.setBounds(350, 510, 100, 30);
        proDleBtn.setBackground(new Color(63, 161, 251));
        proDleBtn.addActionListener(this);
        add(proDleBtn);
    }

    public void Read() {
        String line;
        BufferedReader reader;
        try {
            File file = new File(
                    "TXT FILES\\ParticipitionData.txt");
            FileReader read = new FileReader(file);
            reader = new BufferedReader(read);

            Object[] lines = reader.lines().toArray();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split(" ");
                model.addRow(row);
            }
            reader.close();
        } catch (IOException ae) {
            ae.printStackTrace();
        }
    }

    public void write() {
        try {
            File file = new File(
                    "TXT FILES\\ParticipitionData.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < model.getRowCount(); i++) {

                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i, j) + " ");
                }

                bw.write("\r\n");
            }
            bw.close();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileBtn) {
            AdminLanding a = new AdminLanding();
            a.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }

        else if (e.getSource() == proAddBtn) {
            AdminFill d = new AdminFill();
            d.setVisible(true);
            this.setVisible(false);
            this.dispose();
        } else if (e.getSource() == proDleBtn) {
            if (j.getSelectedRow() != -1) {
                model.removeRow(j.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Selected row deleted");
                this.write();
            }
        }

    }

}
