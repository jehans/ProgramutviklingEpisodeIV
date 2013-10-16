package com.theforce.programutviklingsepisodeIV;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class Toolbar {
	public Toolbar(JFrame frame) {
		// Create toolbar
		JToolBar toolbar = new JToolBar();
		
		// Item definition
		JButton button;
		
		// New
        button = new JButton(new ImageIcon("images/NEW.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // New
            }
        });
        toolbar.add(button);
		
		// Load
        button = new JButton(new ImageIcon("images/OPENDOC.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Load
            }
        });
        toolbar.add(button);
		
		// Save
        button = new JButton(new ImageIcon("images/SAVE.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Save
            }
        });
        toolbar.add(button);
		
		// Separator
        toolbar.addSeparator();
		
		// Preview
        button = new JButton(new ImageIcon("images/ExecuteProject.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Preview
            }
        });
        toolbar.add(button);
		
		// Export
        button = new JButton(new ImageIcon("images/SAVEJAVA.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Preview
            }
        });
        toolbar.add(button);
		
		// Separator
        toolbar.addSeparator();
		
		// New row
        button = new JButton(new ImageIcon("images/NEWROW.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // New row
            }
        });
        toolbar.add(button);
		
		// Row up
        button = new JButton(new ImageIcon("images/MoveRowUp.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Move row up
            }
        });
        toolbar.add(button);
		
		// Row down
        button = new JButton(new ImageIcon("images/MoveRowDown.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Move row down
            }
        });
        toolbar.add(button);
		
		// Separator
        toolbar.addSeparator();
		
		// Help
        button = new JButton(new ImageIcon("images/HELP.GIF"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Help
            }
        });
        toolbar.add(button);
		
		frame.add(toolbar, BorderLayout.NORTH);
	}
}