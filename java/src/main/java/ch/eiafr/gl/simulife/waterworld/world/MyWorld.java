package ch.eiafr.gl.simulife.waterworld.world;

import java.awt.Color;

import javax.swing.ImageIcon;

import ch.eiafr.gl.simulife.waterworld.creature.HammerheadShark;
import ch.eiafr.gl.simulife.waterworld.creature.Ice;
import ch.eiafr.gl.simulife.waterworld.creature.Orca;
import ch.eiafr.gl.simulife.waterworld.creature.Penguin;
import ch.eiafr.gl.simulife.waterworld.creature.WhiteShark;
import ch.eiafr.gl.simulife.model.AWorld;
import ch.eiafr.gl.simulife.model.ICreature;

public class MyWorld extends AWorld {

    private int nbCols = 6;
    private int nbRows = 6;

    private ch.eiafr.gl.simulife.model.ICreature[][] game;

    public MyWorld(int nbCols, int nbRows) {
        this.nbCols = nbCols;
        this.nbRows = nbRows;
        this.game = new ICreature[nbCols][nbRows];
    }

    @Override
    public int getNbCols() {
        return nbCols;
    }

    @Override
    public int getNbRows() {
        return nbRows;
    }

    @Override
    public ICreature getCreatureAt(int col, int row) {
        return game[col][row];
    }

    @Override
    public String getStringFor(ICreature creature) {
        if (creature instanceof Orca)
            return "O";
        if (creature instanceof Penguin)
            return "P";
        if (creature instanceof WhiteShark)
            return "W";
        if (creature instanceof HammerheadShark)
            return "H";
        if (creature instanceof Ice)
            return "I";

        return "_";
    }

    @Override
    public ImageIcon getIconeFor(ICreature creature) {

        String path = "empty.gif";
        if (creature instanceof Orca)
            path = "orca.gif";
        if (creature instanceof Penguin)
            path = "pingouin.gif";
        if (creature instanceof WhiteShark)
            path = "shark.gif";
        if (creature instanceof HammerheadShark)
            path = "sharkHammer.gif";
        if (creature instanceof Ice)
            path = "ice.gif";

        return new ImageIcon(ClassLoader.getSystemResource(path));
    }

    public void moveCreature(ICreature creature, int newCol, int newRow) {
        for (int col = 0; col < getNbCols(); col++) {
            for (int row = 0; row < getNbRows(); row++) {
                if (game[col][row] == creature)
                    game[col][row] = null;
            }
        }

        game[newCol][newRow] = creature;
    }

    @Override
    public Color getColorFor(ICreature creature) {
        if (creature instanceof Ice)
            return Color.BLUE;
        if (creature instanceof WhiteShark || creature instanceof HammerheadShark)
            return Color.RED;
        if (creature instanceof Orca)
            return Color.GREEN;
        if (creature instanceof Penguin)
            return Color.YELLOW;

        return Color.WHITE;
    }

    public int[] calcMove(ICreature creature) {

        int[] move = new int[2];
        if (creature instanceof Orca) {
            Orca orc = (Orca) creature;
            move = orc.calcMove(game);
        }
        if (creature instanceof Penguin) {
            Penguin p = (Penguin) creature;
            move = p.calcMove(game);
        }
        if (creature instanceof WhiteShark) {
            WhiteShark w = (WhiteShark) creature;
            move = w.calcMove(game);
        }
        if (creature instanceof HammerheadShark) {
            HammerheadShark h = (HammerheadShark) creature;
            move = h.calcMove(game);
        }

        return move;
    }

    public int[] addIce(Ice ice) {
        int[] iceChange = ice.addIce(game);
        return iceChange;
    }

    public int[] removeIce(Ice ice) {
        int[] iceChange = ice.removeIce(game);
        return iceChange;
    }

}
