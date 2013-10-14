package com.theforce.programutviklingsepisodeIV;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class metaTable {

	//Internasjonalisering yo
	String Type = "Type";
	String variableName = "Variabelnavn";
	String text = "Tekst";
	String row = "Rad";
	String colon = "Kolonne";
	String rows ="Rader";
	String colons ="Kolonner";
	String filler = "Utfylling";
	String anchor = "Forankring";
	
	public metaTable() {
		// TODO Auto-generated constructor stub
		System.out.println("Lager metaTable");
		JFrame metaTableFrame = Launcher.getFrame();	//Gets main window
		metaTableFrame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel jt = new JLabel(Type);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 40;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(variableName);
		gbc.gridx = 1;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(text);
		gbc.gridx = 2;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(row);
		gbc.gridx = 3;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(colon);
		gbc.gridx = 4;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(rows);
		gbc.gridx = 5;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(colons);
		gbc.gridx = 6;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(filler);
		gbc.gridx = 7;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jt = new JLabel(anchor);
		gbc.gridx = 8;
		gbc.gridy = 0;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		String[] choices = {"JButton", "JLabel", "JTextfield", "JTextArea"};
		JComboBox varType = new JComboBox(choices);
		gbc.gridx = 0;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varType, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varName = new JTextField(variableName);	//Skal endres til ny0 og ny1
		gbc.gridx = 1;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varName, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varText = new JTextField();	//Skal endres til ny0 og ny1
		gbc.gridx = 2;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varText, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varRow = new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 3;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varRow, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varColon = new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 4;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varColon, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varRows = new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 5;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varRows, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varColons= new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 6;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varColons, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		ImageIcon[] choicesFill = {
				new ImageIcon("images/skaler_begge.png"),
						new ImageIcon("images/skaler_horisontalt.png"),
						new ImageIcon("images/skaler_ingen.png"),
						new ImageIcon("images/skaler_vertikalt.png")
						};
		JComboBox varFill = new JComboBox(choicesFill);
		gbc.gridx = 7;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varFill, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		ImageIcon[] choicesAnchor = {
				new ImageIcon("images/anchor_center.png"), 
				new ImageIcon("images/anchor_north.png"),
				new ImageIcon("images/anchor_east.png"),
				new ImageIcon("images/anchor_west.png"),
				new ImageIcon("images/anchor_south.png"),
				new ImageIcon("images/anchor_northwest.png"),
				new ImageIcon("images/anchor_southwest.png"),
				new ImageIcon("images/anchor_northeast.png"),
				new ImageIcon("images/anchor_southeast.png"),
				};
		JComboBox varAnchor = new JComboBox(choicesAnchor);
		gbc.gridx = 8;
		gbc.gridy = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(varAnchor, gbc);
		
		
	}

}


