package ch.eiafr.gl.simulife.waterworld.world;

import java.awt.Color;

import javax.swing.ImageIcon;

import ch.eiafr.gl.simulife.waterworld.creature.Ice;
import ch.eiafr.gl.simulife.waterworld.creature.MyCreatureA;
import ch.eiafr.gl.simulife.waterworld.creature.MyCreatureB;
import ch.eiafr.gl.simulife.model.AWorld;
import ch.eiafr.gl.simulife.model.ICreature;

public class MyWorld extends AWorld {

	private int nbCols = 6;
	private int nbRows = 6;

	private ICreature[][] game;

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
		if (creature instanceof MyCreatureA)
			return "A";
		if (creature instanceof MyCreatureB)
			return "B";

		return "_";
	}

	@Override
	public ImageIcon getIconeFor(ICreature creature) {

		String path = "empty.gif";

		if (creature instanceof MyCreatureA)
			path = "a.gif";
		if (creature instanceof MyCreatureB)
			path = "b.gif";

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
		if (creature instanceof MyCreatureA)
			return Color.BLUE;
		if (creature instanceof MyCreatureB)
			return Color.RED;
		
		return Color.WHITE;
	}

    public int[] calcMove(ICreature creature) {
        // TODO Auto-generated method stub
        return null;
    }

    public int[] addIce(Ice ice) {
        // TODO Auto-generated method stub
        return null;
    }

    public int[] removeIce(Ice ice) {
        // TODO Auto-generated method stub
        return null;
    }

}
