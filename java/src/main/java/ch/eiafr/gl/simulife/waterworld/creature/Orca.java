package ch.eiafr.gl.simulife.waterworld.creature;

import java.awt.Color;
import java.util.Random;

import ch.eiafr.gl.simulife.model.ICreature;

public class Orca implements ICreature {

    boolean firstMove = true;
    private Random rd;
    private int row;
    private int col;
    public String icon="orca.gif";
    public String id="O";
    public Color color=Color.GREEN;

    public int[] calcMove(ICreature[][] game) {
        int[] move = new int[2];
        if (firstMove) {
            rd = new Random();
            row = rd.nextInt(game.length);
            col = rd.nextInt(game.length);
           
            firstMove = false;
        }else {
            do {
                row = rd.nextInt(game.length);
                col = rd.nextInt(game.length);
            } while (game[row][col] != null);
        }
        move[0] = row;
        move[1] = col;
        return move;
    }

 

}
