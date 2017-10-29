package ch.eiafr.gl.simulife.waterworld.creature;

import java.util.Random;

import ch.eiafr.gl.simulife.model.ICreature;

public class Orca implements ICreature {

    boolean firstMove = true;
    private Random rd;
    private int row;
    private int col;

    public int[] calcMove(ICreature[][] game) {
        int[] move = new int[2];
        if (firstMove) {
            rd = new Random();
            row = rd.nextInt(game.length);
            col = rd.nextInt(game.length);
            move[0] = row;
            move[1] = col;
            firstMove = false;
        }

        // TODO Auto-generated method stub
        return move;
    }

}
