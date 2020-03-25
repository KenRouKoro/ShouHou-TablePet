package indi.koro.ShouHouTablePet.window;

import indi.koro.ShouHouTablePet.data.Data;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
    public MessagePanel() {
        this.setBounds(0, Data.initialH - 150, Data.initialW, 100);
        this.setBackground(new Color(0, 0, 0, 0.2f));
    }
}
