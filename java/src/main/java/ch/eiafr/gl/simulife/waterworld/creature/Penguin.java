package ch.eiafr.gl.simulife.waterworld.creature;

import java.awt.Color;
import java.util.Random;

import ch.eiafr.gl.simulife.model.ICreature;

public class Penguin implements ICreature {

    boolean firstMove = true;
    private Random rd;
    private int row;
    private int col;
    private int rowShark;
    private int colShark;
    public String icon="pingouin.gif";
    public String id="P";
    public Color color=Color.YELLOW;

    public int[] calcMove(ICreature[][] game) {
        int[] move = new int[2];
//        if (firstMove) {
            rd = new Random();
            do {
                row = rd.nextInt(game.length);
                col = rd.nextInt(game.length);
            } while (game[row][col] != null);
            move[0] = row;
            move[1] = col;

            firstMove = false;

//        } else {
//            if (isSharkSee(game)) {
//                moveRdn(game);
//            } else {
//
//            }
//
//        }

        // TODO Auto-generated method stub
        return move;
    }

    private boolean isSharkSee(ICreature[][] game) {
        int tmpRow, tmpCol;
        tmpRow = row;
        tmpCol = col;
        if (row == 0 && col == 0) {
            //5 case in coin
            ICreature crea = game[tmpRow][tmpCol];
            if (crea instanceof WhiteShark || crea instanceof HammerheadShark) {
                rowShark = tmpRow;
                colShark = tmpCol;
                return true;
            }
        } else if (row == 0 && col == game.length - 1) {

        } else if (row == game.length - 1 && col==0) {

        } else if (row == game.length - 1 && col==game.length-1) {

        } else if (col == game.length - 1) {
            //8 case

        } else if (row == game.length - 1) {
           

        } else if (row == 0) {

        } else if (col == 0) {

        }else {
            //12

        }
        // TODO Auto-generated method stub
        return false;
    }

    private void moveRdn(ICreature[][] game) {
        int pos = rd.nextInt(8);
        switch (pos) {
        case 0:
            row--;
            col--;
            break;
        case 1:
            row--;
            break;
        case 2:
            row--;
            col++;
            break;
        case 3:
            col--;
            break;
        case 4:
            col++;
            break;
        case 5:
            row++;
            col--;
            break;
        case 6:
            row++;

            break;
        case 7:
            row++;
            col++;
            break;

        default:
            break;
        }

        if (game.length < row || game.length < col)
            moveRdn(game);

    }

}
