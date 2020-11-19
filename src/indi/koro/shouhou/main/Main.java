package indi.koro.shouhou.main;

import indi.koro.shouhou.starup.Starup;
import indi.korostudio.ksge.data.Data;

public class Main {
    public static void main(String arg0[]) {
        System.out.println("Hello World !");
        Data.resize(800, 800);
        Starup starup = new Starup();
        starup.load();

    }
}
