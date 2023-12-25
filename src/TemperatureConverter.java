import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame{
    private JButton jB1, jB2, jB3;
    private JCheckBox jChBox1;
    private JComboBox<String> jComBox1, jComBox2;
    private JLabel jL1;
    private JPanel jP1;
    private JSpinner jSp1;
    private JTextField jTF1, jTF2;

    public  TemperatureConverter(){
        initComponents();
    }

    private void initComponents(){
        jChBox1 = new JCheckBox("jCheckBox");
        jSp1 = new JSpinner();
        jP1 = new JPanel();
        jL1 = new JLabel("Конвертер температуры");
        jComBox1 = new JComboBox<>();
        jComBox2 = new JComboBox<>();
        jTF1 = new JTextField();
        jTF2 = new JTextField();
        jB1 = new JButton("Конвертировать");
        jB2 = new JButton("Очистить");
        jB3 = new JButton("Выход");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Конвертер температуры");

        jP1.setBackground(new Color(51, 51,51));

        jL1.setBackground(new Color(255,255,255));
        jL1.setFont(new Font("Segoe Ui", 1, 24));
        jL1.setForeground(new Color(255,255,255));

        GroupLayout jPLayout = new GroupLayout(jP1);
        jP1.setLayout(jPLayout);
        jPLayout.setAutoCreateGaps(true);
        jPLayout.setAutoCreateContainerGaps(true);


        jComBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Цельсии", "Фаренгейт"}));
        jComBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Цельсии", "Фаренгейт"}));

        jTF2.setEditable(false);

        jPLayout.setHorizontalGroup(jPLayout.createSequentialGroup()
                .addComponent(jTF1)
                .addComponent(jTF2)
                .addGroup(jPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jL1)
                        .addComponent(jB1))
        );

        jPLayout.setVerticalGroup(jPLayout.createSequentialGroup()
                .addGroup(jPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTF1)
                        .addComponent(jTF2)
                        .addComponent(jL1))
                        .addComponent(jB1));



        jB1.setFont(new Font("Segoe UI", 3, 14));
        jB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jB1ActionPerformed(e);
            }
        });

        jB2.setFont(new Font("Segoe UI", 3, 14));
        jB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   jB2ActionPerformed(e);
            }
        });

        jB3.setFont(new Font("Segoe UI", 3, 14));
        jB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   jB3ActionPerformed(e);
            }
        });

       getContentPane().add(jP1);


        pack();

    }

    private void jB3ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jB2ActionPerformed(ActionEvent evt) {
        jTF1.setText("");
        jTF2.setText("");
    }

    private void jB1ActionPerformed(ActionEvent evt){
        String val1 = (String) jComBox1.getSelectedItem();
        String val2 = (String) jComBox2.getSelectedItem();

        if (val1.equals("Цельсия") && val2.equals("Фаренгейт")) {
            double cel = Double.parseDouble(jTF1.getText());
            double fah = (double) ((9.0/5.0)*cel + 32);

            jTF2.setText(String.valueOf(fah));
        } else if (val1.equals("Цельсия") && val2.equals("Цельсия")) {
            double c = Double.parseDouble(jTF1.getText());
            jTF2.setText(String.valueOf(c));
        }

        if (val1.equals("Фаренгейт") && val2.equals("Цельсия")) {
            double f = Double.parseDouble(jTF1.getText());
            double c = (double) ((f - 32) *(5.0/9.0));

            jTF2.setText(String.valueOf(Math.round(c)));
        } else if (val1.equals("Фаренгейт") && val2.equals("Фаренгейт")) {
            double f = Double.parseDouble(jTF1.getText());
            jTF2.setText(String.valueOf(Math.round(f)));
        }
    }


    public static void main(String[] args) {
        new TemperatureConverter().setVisible(true);
    }

}
