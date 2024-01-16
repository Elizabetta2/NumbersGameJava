import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class NumbersGame {
    public static void main(String[] args) {
        new Play();
    }
}

class Play  implements ActionListener  {
    JButton button = new JButton("Новая игра");
    JButton[] btn = new JButton[25];
    JLabel label;
    Random rnd = new Random();
    int[] arr = new int[25];
    int seconds = 0;
    JLabel endLabel;
    Timer timer;
    int counter  = 1;
    int miss = 0;

    Play() {
        JFrame jf = new JFrame();
        Container con = jf.getContentPane();

        jf.setSize(550, 550);
        jf.setTitle("Числа по порядку");
        jf.setLocation(150, 100);
        jf.setResizable(false);
        ImageIcon img = new ImageIcon("src/nums.ico");
        jf.setIconImage(img.getImage());
        jf.setVisible(true);

        JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        jp1.setPreferredSize(new Dimension(550, 100));

        button.setPreferredSize(new Dimension( 200, 50));
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.addActionListener(this);
        jp1.add(button);


        label = new JLabel("Время: ");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setPreferredSize(new Dimension( 200, 50));
        jp1.add(label);

        JPanel jp2 = new JPanel();
        JPanel main = new JPanel(new FlowLayout());
        jp2.add(main);
        main.setLayout(new GridLayout(5,5));
        main.setPreferredSize(new Dimension(300, 300));

        for (int i = 0; i < 25; i++) {

                btn[i] = new JButton();
                btn[i].setPreferredSize( new Dimension(60, 60));
                btn[i].setBackground(Color.white);
                btn[i].setFont(new Font("Arial", Font.BOLD, 20));
                btn[i].setEnabled(false);
                btn[i].setFocusPainted(false);
                btn[i].addActionListener(this);
                main.add(btn[i]);

        }

        endLabel = new JLabel("<html>Цель игры: Как можно быстрее нажимать <br/>на числа по порядку</html>");
        endLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        con.add(jp1, BorderLayout.NORTH);
        con.add(jp2, BorderLayout.CENTER);
        con.add(endLabel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void TimeSec(){
        seconds = 0;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                label.setText("Время: "  + seconds + " сек.");
                seconds++;

            }
        }, 0, 1000);
    }


    public void actionPerformed(ActionEvent ae) {
        String comStr = ae.getActionCommand();

        if (comStr.equals(String.valueOf(counter)) ) {
             JButton jbt = (JButton) ae.getSource();
             jbt.setBackground(Color.green);
             jbt.setEnabled(false);
             counter++;

        } else if (!comStr.equals("Новая игра")){
            JButton jbt = (JButton) ae.getSource();
            jbt.setBackground(Color.red);
            miss++;
        }

        if (counter == 26) {
            timer.cancel();
            endLabel.setText("Ваше время: " + (seconds - 1) + " секунд.\n Количество ошибок - " + miss);

        }


        if(comStr.equals("Новая игра")) {
            if (timer !=null) {
                timer.cancel();
            }

            timer = new Timer();
            TimeSec();
            counter = 1;
            miss = 0;
            endLabel.setText("");

            for (int i = 0; i < 25; i++) {
                arr[i] = i + 1;
            }

            for (int i = arr.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }

            for (int j = 0; j < 25; j++) {
                btn[j].setText(String.valueOf(arr[j]));
                btn[j].setEnabled(true);
                btn[j].setBackground(Color.white);
            }



        }

    }
}




