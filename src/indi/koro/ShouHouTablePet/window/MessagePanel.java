package indi.koro.ShouHouTablePet.window;

import indi.koro.ShouHouTablePet.data.Data;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
    JPanel messagePanel;
    JLabel text;
    Font font = new Font("黑体", Font.BOLD, 15);
    Thread thread;

    public class AutoRun implements Runnable {
        public boolean stop = false;

        @Override
        public void run() {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (!stop)
                    messagePanel.setVisible(false);
            }

        }
    }

    public MessagePanel() {
        messagePanel = this;
        this.setVisible(false);
        this.setBackground(new Color(0, 0, 0, 0.4f));
        text = new JLabel();
        text.setForeground(Color.white);
        text.setFont(font);
        this.setLayout(null);
        this.add(text);
        resize();
    }

    public void resize() {
        this.setBounds(10, Data.initialH - 150, Data.initialW - 20, 100);
        text.setBounds(10, 10, this.getWidth() - 20, this.getHeight() - 20);
        System.out.println(this.getWidth() - 10);
    }

    public void paintMessage(String message) {
        text.setText("<html>" + message + "</html>");
        if (thread != null) thread.stop();
        thread = new Thread(new AutoRun());
        thread.start();
        this.setVisible(true);
        repaint();
    }
}
