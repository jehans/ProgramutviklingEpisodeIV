package com.theforce.programutviklingsepisodeIV;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

/**
* Main entry point
* Creates the frame, and its components, and serves as a hub throughout the application for
* all the important references
*
* @author John Hoegh-Omdal
* @author Jehans Storvik
* @author Hans Martin Bragen
* @version 1.0
*/
public abstract class Launcher {
	private static JFrame mFrame;
	private static JMenuBar mMenuBar;
	private static JToolBar mToolBar;
	private static TableManager mRowEditor;
	
	/**
	* Main entry point. Acts as the application's constructor.
	* Creates the frame, and its components
	*/
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
	
	/**
	* Simple get function that can be used globally everywhere to get the application's main frame
	* 
	* @return Returns the frame
	*/
	public static JFrame getFrame() {
		return Launcher.mFrame;
	}
	
	/**
	* Simple get function that can be used globally everywhere to get the application's table manager
	* 
	* @return Returns the tablemanager
	*/
	public static TableManager getTableManager() {
		return Launcher.mRowEditor;
	}
}
