package com.theforce.programutviklingsepisodeIV;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Launcher {
	private static JFrame mFrame;
	public static void main(String[] args) {
		Launcher.mFrame = new JFrame("GUI generator");
		mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Launcher.mFrame.setMinimumSize (new Dimension (800, 800));
		RowEditor rowEditor = new RowEditor();
		Launcher.mFrame.setVisible(true);
	}
	
	public static JFrame getFrame() {
		return Launcher.mFrame;
	}
}
