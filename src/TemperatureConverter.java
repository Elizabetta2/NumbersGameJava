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
        jB2 = new JButton();
        jB3 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Конвертер температуры");

        jP1.setBackground(new Color(51, 51,51));

        jL1.setBackground(new Color(255,255,255));
        jL1.setFont(new Font("Segoe Ui", 1, 24));
        jL1.setForeground(new Color(255,255,255));

        GroupLayout jPLayout = new GroupLayout(jP1);
        jP1.setLayout(jPLayout);
        jPLayout.setHorizontalGroup(jPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPLayout.createSequentialGroup()
                        .addGap(19, 19,19)
                        .addComponent(jL1)
                        .addContainerGap(23, Short.MAX_VALUE)));
        jComBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Цельсии", "Фаренгейт"}));
        jComBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Цельсии", "Фаренгейт"}));

        jTF2.setEditable(false);

        jB1.setFont(new Font("Segoe UI", 3, 14));
        jB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   jB1ActionPerformed(e);
            }
        });
    }


}
