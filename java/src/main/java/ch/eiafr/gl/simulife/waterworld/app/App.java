package ch.eiafr.gl.simulife.waterworld.app;

import ch.eiafr.gl.simulife.waterworld.world.MyWorld;
import ch.eiafr.gl.simulife.waterworld.creature.HammerheadShark;
import ch.eiafr.gl.simulife.waterworld.creature.Ice;
import ch.eiafr.gl.simulife.waterworld.creature.Orca;
import ch.eiafr.gl.simulife.waterworld.creature.Penguin;
import ch.eiafr.gl.simulife.waterworld.creature.WhiteShark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import ch.eiafr.gl.simulife.gui.UserInterface;
import ch.eiafr.gl.simulife.gui.game.GameGraphicView;
import ch.eiafr.gl.simulife.gui.game.GameMatrixView;
import ch.eiafr.gl.simulife.gui.game.GameTextView;
import ch.eiafr.gl.simulife.model.ICreature;

public class App {

	private static final int NumberOfIce = 10;
	private static Orca orca;
	private static WhiteShark[] whiteSharks;
	private static HammerheadShark[] hammerheadSharks;
	private static Penguin[] penguins;
	private static ArrayList<Ice> iceList;
	private static boolean game_not_finished;
	private static int loop_id;
	private static Random random;
	private static MyWorld myWorld;

	public static void main(String[] args) {

		myWorld = new MyWorld(6, 6);

		UserInterface userGraphiqueInterface = new UserInterface(
				new GameGraphicView(myWorld.getNbCols(), myWorld.getNbRows()));
		myWorld.addObserver(userGraphiqueInterface);

		UserInterface userGameMatrixView = new UserInterface(
				new GameMatrixView(myWorld.getNbCols(), myWorld.getNbRows()));
		myWorld.addObserver(userGameMatrixView);

		UserInterface userTextInterface = new UserInterface(new GameTextView());
		myWorld.addObserver(userTextInterface);

		init();
		myWorld.updateView();
		while (game_not_finished) {

			int[] moveOrca = myWorld.calcMove(orca);
			myWorld.moveCreature(orca, moveOrca[0], moveOrca[1]);
			myWorld.updateView();
			waitUpdate();
			/*for (int i = 0; i < whiteSharks.length; i++) {
				int[] move_whiteShark = myWorld.calcMove(whiteSharks[i]);
				myWorld.moveCreature(whiteSharks[i], move_whiteShark[0], move_whiteShark[1]);

			}*/
//			myWorld.updateView();
//			waitUpdate();
//			for (int i = 0; i < hammerheadSharks.length; i++) {
//				int[] move_hammerheadShark = myWorld.calcMove(hammerheadSharks[i]);
//				myWorld.moveCreature(hammerheadSharks[i], move_hammerheadShark[0], move_hammerheadShark[1]);
//
//			}
//			myWorld.updateView();
//			waitUpdate();
//			if (loop_id++ % 2 == 0) {
//				for (int i = 0; i < penguins.length; i++) {
//					int[] move_penguin = myWorld.calcMove(penguins[i]);
//					myWorld.moveCreature(penguins[i], move_penguin[0], move_penguin[1]);
//
//				}
//				myWorld.updateView();
//				waitUpdate();
//			}
			for (int i = 0; i < iceList.size(); i++) {
				int[] move_ice = new int[2];
				if (random.nextBoolean()) {
					move_ice = myWorld.addIce(iceList.get(i));
				} else {
					move_ice = myWorld.removeIce(iceList.get(i));
					if(move_ice==null)
						iceList.remove(i);
										
				}
				
				myWorld.moveCreature(iceList.get(i), move_ice[0], move_ice[1]);
				myWorld.updateView();
				waitUpdate();

			}

		}

	}

	private static void waitUpdate() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void init() {
		LinkedList<ICreature> list=new LinkedList<>();
		orca=Orca.getInstance();
		list.add(orca);
//		whiteSharks = new WhiteShark[5];
//		for (int i = 0; i < whiteSharks.length; i++) {
//			whiteSharks[i] = new WhiteShark();
//			list.add(whiteSharks[i]);
//		}
//		
//		hammerheadSharks = new HammerheadShark[5];
//		for (int i = 0; i < hammerheadSharks.length; i++) {
//			hammerheadSharks[i] = new HammerheadShark();
//			list.add(hammerheadSharks[i]);
//		}
//		penguins = new Penguin[5];
//		for (int i = 0; i < penguins.length; i++) {
//			penguins[i] = new Penguin();
//			list.add(penguins[i]);
//
//		}
		iceList=new ArrayList<>();
		for (int i = 0; i < NumberOfIce; i++) {
			Ice ice=new Ice();
			iceList.add( ice);		

		}
		list.addAll(iceList);
		game_not_finished = true;
		loop_id = 0;
		random = new Random();
		myWorld.summonCreature(list);
	}
}
