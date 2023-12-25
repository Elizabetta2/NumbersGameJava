import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class TemperatureConverter extends JFrame{
    private JComboBox<String> jComBox1, jComBox2;
    private JTextField jTF1, jTF2;

    public  TemperatureConverter(){
        initComponents();
    }

    private void initComponents(){


        JPanel jP1 = new JPanel();
        JLabel jL1 = new JLabel("Конвертер температуры");
        jComBox1 = new JComboBox<>();
        jComBox2 = new JComboBox<>();
        jTF1 = new JTextField();
        jTF2 = new JTextField();
        JButton jB1 = new JButton("Конвертировать");
        JButton jB2 = new JButton("Очистить");
        JButton jB3 = new JButton("Выход");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Конвертер температуры");

        jP1.setBackground(new Color(51, 51,51));

        jL1.setBackground(new Color(255,255,255));
        jL1.setFont(new Font("Segoe Ui", Font.BOLD, 24));
        jL1.setForeground(new Color(255,255,255));

        GroupLayout jPLayout = new GroupLayout(jP1);
        jP1.setLayout(jPLayout);
        jPLayout.setAutoCreateGaps(true);
        jPLayout.setAutoCreateContainerGaps(true);


        jComBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Цельсия", "Фаренгейт"}));
        jComBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Цельсия", "Фаренгейт"}));

        jTF2.setEditable(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComBox1)
                                .addComponent(jComBox2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTF1)
                        .addComponent(jTF2)))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jB1)
                                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jB3)
                                        .addComponent(jB2)))
                                .addComponent(jP1)
        );

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jP1)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jComBox1)
                .addComponent(jTF1))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jB1)
                .addComponent(jB2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jComBox2)
                        .addComponent(jTF2))
                .addComponent(jB3))

                );



        jB1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        jB1.addActionListener(this::jB1ActionPerformed);

        jB2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        jB2.addActionListener(this::jB2ActionPerformed);

        jB3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        jB3.addActionListener(this::jB3ActionPerformed);

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
