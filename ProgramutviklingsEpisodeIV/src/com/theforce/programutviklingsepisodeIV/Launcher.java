package com.theforce.programutviklingsepisodeIV;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Launcher {
	private static JFrame mFrame;
	private static Menu mMenuBar;
	private static Toolbar mToolBar;
	private static RowEditor mRowEditor;
	public static void main(String[] args) {
		// Create frame
		Launcher.mFrame = new JFrame("GUI generator");
		Launcher.mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Launcher.mFrame.setMinimumSize (new Dimension (800, 800));
		Launcher.mFrame.setLocationRelativeTo(null);
		
		// Menubar
		Launcher.mMenuBar = new Menu(Launcher.mFrame);
		
		// Toolbar
		Launcher.mToolBar = new Toolbar(Launcher.mFrame);
		
		// Frame contents (table)
		Launcher.mRowEditor = new RowEditor();
		
		// Update and make visible
		Launcher.mFrame.setVisible(true);
	}
	
	public static JFrame getFrame() {
		return Launcher.mFrame;
	}
}
