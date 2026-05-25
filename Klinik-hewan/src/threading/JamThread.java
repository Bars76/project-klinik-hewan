/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threading;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class JamThread extends Thread {

    JLabel label;

    public JamThread(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                label.setText(sdf.format(date));

                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
