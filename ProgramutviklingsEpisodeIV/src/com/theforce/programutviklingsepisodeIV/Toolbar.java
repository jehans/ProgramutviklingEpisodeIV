package com.theforce.programutviklingsepisodeIV;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * A singleton class to add toolbar to main.
 * The various buttons and so forth are predefined and unmutable
 * 
 * @author John Hoegh-Omdal
 * @author Jehans Storvik
 * @author Hans Martin Bragen
 * @version 1.0
 */
public abstract class Toolbar {
	/**
	* Creates toolbar with buttons on it.
	* The buttons and their configurations are predefined and unmutable
	* Automatically attaches to frame
	* 
	* @return Returns the created toolbar
	*/
	public static JToolBar createToolbar() {
		// Create toolbar
		JToolBar toolbar = new JToolBar();
		
		// Item definition
		JButton button;
		
		// New
        button = new JButton(new ImageIcon("images/NEW.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Menu.file.new_tooltip")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // New
            	Launcher.getTableManager().clear();
            }
        });
        toolbar.add(button);
		
		// Load
        button = new JButton(new ImageIcon("images/OPENDOC.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Menu.file.load_tooltip")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Load
            	Launcher.getTableManager().load();
            }
        });
        toolbar.add(button);
		
		// Save
        button = new JButton(new ImageIcon("images/SAVE.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Menu.file.save_tooltip")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Save
            	Launcher.getTableManager().save();
            }
        });
        toolbar.add(button);
		
		// Separator
        toolbar.addSeparator();
		
		// Preview
        button = new JButton(new ImageIcon("images/ExecuteProject.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Menu.file.preview_tooltip")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Preview
            	Launcher.getTableManager().preview();
            }
        });
        toolbar.add(button);
		
		// Export
        button = new JButton(new ImageIcon("images/SAVEJAVA.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Menu.file.export_tooltip")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Export
            	Launcher.getTableManager().export();
            }
        });
        toolbar.add(button);
		
		// Separator
        toolbar.addSeparator();
		
		// New row
        button = new JButton(new ImageIcon("images/NEWROW.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Menu.edit.newrow_tooltip")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Launcher.getTableManager().insertRow();
            }
        });
        toolbar.add(button);
		
		// Row up
        button = new JButton(new ImageIcon("images/MoveRowUp.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Toolbar.move.row.up")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Move row up
            	Launcher.getTableManager().moveRowUp();
            }
        });
        toolbar.add(button);
		
		// Row down
        button = new JButton(new ImageIcon("images/MoveRowDown.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Toolbar.move.row.down")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Move row down
            	Launcher.getTableManager().moveRowDown();
            }
        });
        toolbar.add(button);
		
		// Separator
        toolbar.addSeparator();
		
		// Help
        button = new JButton(new ImageIcon("images/HELP.GIF")); //$NON-NLS-1$
        button.setToolTipText(Messages.getString("Menu.help.help_tooltip")); //$NON-NLS-1$
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Help
            }
        });
        toolbar.add(button);
		
		Launcher.getFrame().add(toolbar, BorderLayout.NORTH);
		
		return toolbar;
	}
}