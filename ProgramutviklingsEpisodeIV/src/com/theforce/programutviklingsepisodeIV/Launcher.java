package com.theforce.programutviklingsepisodeIV;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Launcher {
	private static JFrame mFrame;
	public static void main(String[] args) {
		Launcher.mFrame = new JFrame("GUI generator");
		Launcher.mFrame.setMinimumSize (new Dimension (400, 400));
		Launcher.mFrame.setVisible(true);
	}
	
	public static JFrame getFrame() {
		return Launcher.mFrame;
	}
}
