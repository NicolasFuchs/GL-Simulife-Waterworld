package game;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Orca orca = new Orca();
        WhiteShark[] whiteSharks = new WhiteShark[5];
        HammerheadShark[] hammerheadSharks = new HammerheadShark[5];
        Penguin[] penguins = new Penguin[5];
        Ice[] ice = new Ice[10];
        boolean game_not_finished = true;
        int loop_id = 0;
        Random random = new Random();
        init();
        launch();
        while(game_not_finished) {
            int[] move_orca = calcMove(orca);
            execMove(move_orca);
            for (int i = 0; i < whiteSharks.length; i++) {
                int[] move_whiteShark = calcMove(whiteSharks[i]);
                execMove(move_whiteShark);
            }
            for (int i = 0; i < whiteSharks.length; i++) {
                int[] move_hammerheadShark = calcMove(hammerheadSharks[i]);
                execMove(move_hammerheadShark);
            }
            if (loop_id++ % 2 == 0) {
                for (int i = 0; i < penguins.length; i++) {
                    int[] move_penguin = calcMove(penguins[i]);
                    execMove(move_penguin);
                }
            }
            if (random.nextBoolean()) {
                addIce();
            } else {
                removeIce();
            }
        }
        
    }
    
    public static void  init() {}
    public static void  launch() {}
    public static int[] calcMove(Object Animal) { return new int[3]; }
    public static void  execMove(int[] decision) {}
    public static void addIce() {}
    public static void removeIce() {}

}
