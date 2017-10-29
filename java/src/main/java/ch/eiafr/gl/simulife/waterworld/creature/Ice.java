package ch.eiafr.gl.simulife.waterworld.creature;

import java.awt.Color;
import java.util.Random;

import ch.eiafr.gl.simulife.model.ICreature;

public class Ice implements ICreature {

    private Random rd;
    private int row;
    private int col;
    public String icon="ice.gif";
    public String id="I";
    public Color color=Color.BLUE;

    public int[] addIce(ICreature[][] game) {
        int[] move = new int[2];
//      if (firstMove) {
          rd = new Random();
          do {
              row = rd.nextInt(game.length);
              col = rd.nextInt(game.length);
          } while (game[row][col] != null);
          move[0] = row;
          move[1] = col;
        return move;
    }

    public int[] removeIce(ICreature[][] game) {
        int[] move = new int[2];
//      if (firstMove) {
          rd = new Random();
          do {
              row = rd.nextInt(game.length);
              col = rd.nextInt(game.length);
          } while (game[row][col] != null);
          move[0] = row;
          move[1] = col;
        return move;
    }

}
