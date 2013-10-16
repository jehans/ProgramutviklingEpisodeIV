package com.theforce.programutviklingsepisodeIV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {
	public Menu(JFrame frame) {
        JMenuBar menubar = new JMenuBar();

        // Item definition
        JMenuItem item;
        
        /*
         *  Column File
         */
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        // New
        item = new JMenuItem("New", new ImageIcon("images/NEW.GIF"));
        item.setMnemonic(KeyEvent.VK_N);
        item.setToolTipText("Create new file, remove existing data");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Call new method
            }
        });
        file.add(item);        

        // Load
        item = new JMenuItem("Load", new ImageIcon("images/OPENDOC.GIF"));
        item.setMnemonic(KeyEvent.VK_L);
        item.setToolTipText("Load a previously saved file");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Load file
            }
        });
        file.add(item);

        // Save
        item = new JMenuItem("Save", new ImageIcon("images/SAVE.GIF"));
        item.setMnemonic(KeyEvent.VK_S);
        item.setToolTipText("Save this layout to a file");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Save to file
            }
        });
        file.add(item);

        // Save as
        item = new JMenuItem("Save As", new ImageIcon("images/SAVE.GIF"));
        item.setMnemonic(KeyEvent.VK_A);
        item.setToolTipText("Save this layout to a file other than the active one");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Save as to file
            }
        });
        file.add(item);
        
        // Separator
        file.addSeparator();

        // Preview
        item = new JMenuItem("Preview", null);
        item.setMnemonic(KeyEvent.VK_P);
        item.setToolTipText("Show this layout in a preview window");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Preview
            }
        });
        file.add(item);
        
        // Export
        item = new JMenuItem("Generate java code", new ImageIcon("images/SAVEJAVA.GIF"));
        item.setMnemonic(KeyEvent.VK_J);
        item.setToolTipText("Write java code for this layout to file");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Export to file
            }
        });
        file.add(item);
        
        // Separator
        file.addSeparator();
        
        // Exit
        item = new JMenuItem("Exit", null);
        item.setMnemonic(KeyEvent.VK_E);
        item.setToolTipText("Terminate the program");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Exit
            	System.exit(0);
            }
        });
        file.add(item);      
        
        // Add File column to menubar
        menubar.add(file);
        
        /*
         *  Edit
         */
        JMenu edit = new JMenu("Edit");
        edit.setMnemonic(KeyEvent.VK_E);

        // New
        item = new JMenuItem("New row", new ImageIcon("images/NEWROW.GIF"));
        item.setMnemonic(KeyEvent.VK_N);
        item.setToolTipText("Add a new row/component to the layout");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Call new row method
            }
        });
        edit.add(item);
        
        // Separator
        edit.addSeparator();

        // Preview
        item = new JMenuItem("Preferences", null);
        item.setMnemonic(KeyEvent.VK_P);
        item.setToolTipText("Edit personal preferences");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Preferences window
            }
        });
        edit.add(item);
        
        // Add Edit column to menubar
        menubar.add(edit);
        
        /*
         *  Help
         */
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_E);

        // New
        item = new JMenuItem("Help", new ImageIcon("images/HELP.GIF"));
        item.setMnemonic(KeyEvent.VK_H);
        item.setToolTipText("Overview of how the program works");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Show help frame
            }
        });
        help.add(item);
        
        // Separator
        help.addSeparator();

        // Preview
        item = new JMenuItem("About", null);
        item.setMnemonic(KeyEvent.VK_A);
        item.setToolTipText("Show information about the program");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Create About window
            }
        });
        help.add(item);
        
        // Add Edit column to menubar
        menubar.add(help);

        frame.setJMenuBar(menubar);
	}
}
