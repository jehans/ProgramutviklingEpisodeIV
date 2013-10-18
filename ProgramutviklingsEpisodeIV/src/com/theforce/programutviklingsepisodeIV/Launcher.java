package com.theforce.programutviklingsepisodeIV;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

public class Launcher {
	private static JFrame mFrame;
	private static JMenuBar mMenuBar;
	private static JToolBar mToolBar;
	private static TableManager mRowEditor;
	public static void main(String[] args) {
		// Create frame
		Launcher.mFrame = new JFrame(Messages.getString("Launcher.frametitle")); //$NON-NLS-1$
		Launcher.mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Launcher.mFrame.setMinimumSize (new Dimension (750, 300));
		Launcher.mFrame.setLocationRelativeTo(null);
		
		// Set theme
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Windows".equals(info.getName())) { //$NON-NLS-1$
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		// Menubar
		Launcher.mMenuBar = Menu.createMenu();
		
		// Toolbar
		Launcher.mToolBar = Toolbar.createToolbar();
		
		// Frame contents (table)
		Launcher.mRowEditor = new TableManager();
		
		// Update and make visible
		Launcher.mFrame.setVisible(true);
	}
	
	public static JFrame getFrame() {
		return Launcher.mFrame;
	}
	
	public static TableManager getRowEditor() {
		return Launcher.mRowEditor;
	}
}
