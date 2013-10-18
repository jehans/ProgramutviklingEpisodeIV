package com.theforce.programutviklingsepisodeIV;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

public class Launcher {
	private static JFrame mFrame;
	private static JPanel mPanel;
	private static Menu mMenuBar;
	private static Toolbar mToolBar;
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
		    //
		}
		
		// Menubar
		Launcher.mMenuBar = new Menu(Launcher.mFrame);
		
		// Toolbar
		Launcher.mToolBar = new Toolbar(Launcher.mPanel);
		
		// Frame contents (table)
		Launcher.mRowEditor = new TableManager();
		
		// Update and make visible
		Launcher.mFrame.setVisible(true);
	}
	
	public static JFrame getFrame() {
		return Launcher.mFrame;
	}
	
	public static JPanel getPanel() {
		return Launcher.mPanel;
	}
	
	public static TableManager getRowEditor() {
		return Launcher.mRowEditor;
	}
}
