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
        JMenu file = new JMenu(Messages.getString("Menu.filetitle")); //$NON-NLS-1$
        file.setMnemonic(KeyEvent.VK_F);

        // New
        item = new JMenuItem(Messages.getString("Menu.file.new"), new ImageIcon("images/NEW.GIF")); //$NON-NLS-1$ //$NON-NLS-2$
        item.setMnemonic(KeyEvent.VK_N);
        item.setToolTipText(Messages.getString("Menu.file.new_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Call new method
            }
        });
        file.add(item);        

        // Load
        item = new JMenuItem(Messages.getString("Menu.file.load"), new ImageIcon("images/OPENDOC.GIF")); //$NON-NLS-1$ //$NON-NLS-2$
        item.setMnemonic(KeyEvent.VK_L);
        item.setToolTipText(Messages.getString("Menu.file.load_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Load file
            }
        });
        file.add(item);

        // Save
        item = new JMenuItem(Messages.getString("Menu.file.save"), new ImageIcon("images/SAVE.GIF")); //$NON-NLS-1$ //$NON-NLS-2$
        item.setMnemonic(KeyEvent.VK_S);
        item.setToolTipText(Messages.getString("Menu.file.save_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Save to file
            }
        });
        file.add(item);

        // Save as
        item = new JMenuItem(Messages.getString("Menu.file.saveas"), new ImageIcon("images/SAVE.GIF")); //$NON-NLS-1$ //$NON-NLS-2$
        item.setMnemonic(KeyEvent.VK_A);
        item.setToolTipText(Messages.getString("Menu.file.saveas_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Save as to file
            }
        });
        file.add(item);
        
        // Separator
        file.addSeparator();

        // Preview
        item = new JMenuItem(Messages.getString("Menu.file.preview"), null); //$NON-NLS-1$
        item.setMnemonic(KeyEvent.VK_P);
        item.setToolTipText(Messages.getString("Menu.file.preview_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Preview
            }
        });
        file.add(item);
        
        // Export
        item = new JMenuItem(Messages.getString("Menu.file.export"), new ImageIcon("images/SAVEJAVA.GIF")); //$NON-NLS-1$ //$NON-NLS-2$
        item.setMnemonic(KeyEvent.VK_J);
        item.setToolTipText(Messages.getString("Menu.file.export_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Export to file
            }
        });
        file.add(item);
        
        // Separator
        file.addSeparator();
        
        // Exit
        item = new JMenuItem(Messages.getString("Menu.file.exit"), null); //$NON-NLS-1$
        item.setMnemonic(KeyEvent.VK_E);
        item.setToolTipText(Messages.getString("Menu.file.exit_tooltip")); //$NON-NLS-1$
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
        JMenu edit = new JMenu(Messages.getString("Menu.edittitle")); //$NON-NLS-1$
        edit.setMnemonic(KeyEvent.VK_E);

        // New
        item = new JMenuItem(Messages.getString("Menu.edit.newrow"), new ImageIcon("images/NEWROW.GIF")); //$NON-NLS-1$ //$NON-NLS-2$
        item.setMnemonic(KeyEvent.VK_N);
        item.setToolTipText(Messages.getString("Menu.edit.newrow_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Call new row method
            }
        });
        edit.add(item);
        
        // Separator
        edit.addSeparator();

        // Preview
        item = new JMenuItem(Messages.getString("Menu.edit.preferences"), null); //$NON-NLS-1$
        item.setMnemonic(KeyEvent.VK_P);
        item.setToolTipText(Messages.getString("Menu.edit.preferences_tooltip")); //$NON-NLS-1$
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
        JMenu help = new JMenu(Messages.getString("Menu.helptitle")); //$NON-NLS-1$
        help.setMnemonic(KeyEvent.VK_E);

        // New
        item = new JMenuItem(Messages.getString("Menu.help.help"), new ImageIcon("images/HELP.GIF")); //$NON-NLS-1$ //$NON-NLS-2$
        item.setMnemonic(KeyEvent.VK_H);
        item.setToolTipText(Messages.getString("Menu.help.help_tooltip")); //$NON-NLS-1$
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Show help frame
            }
        });
        help.add(item);
        
        // Separator
        help.addSeparator();

        // Preview
        item = new JMenuItem(Messages.getString("Menu.help.about"), null); //$NON-NLS-1$
        item.setMnemonic(KeyEvent.VK_A);
        item.setToolTipText(Messages.getString("Menu.help.about_tooltip")); //$NON-NLS-1$
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
