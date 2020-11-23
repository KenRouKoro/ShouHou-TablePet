package indi.koro.shouhou.main;

import indi.koro.shouhou.starup.Starup;
import indi.korostudio.ksge.data.Data;

public class Main {
    public static void main(String arg0[]) {
        Data.resClass = Main.class;
        Data.resize(600, 600);
        Data.fps = 60;
        Starup starup = new Starup();
        starup.load();

    }
}
