package com.theforce.programutviklingsepisodeIV;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RowEditor {

	//Internasjonalisering yo
	String Type = "Type";
	String variableName = "ny";
	String text = "Tekst";
	String row = "Rad";
	String colon = "Kolonne";
	String rows ="Rader";
	String colons ="Kolonner";
	String filler = "Utfylling";
	String anchor = "Forankring";
	int y = 0;
	
	final JTable table = new JTable(new Editor());
	JScrollPane scrollPane = new JScrollPane(table);
	JFrame metaTableFrame = Launcher.getFrame();

	GridBagConstraints gbc;
	
	
	Border blackline;
	
	public RowEditor() {
		System.out.println("Lager metaTable");
		
		metaTableFrame = Launcher.getFrame();	//Gets main window
		metaTableFrame.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		metaTableFrame.	add(scrollPane);
		blackline = BorderFactory.createLineBorder(Color.black);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel jt = new JLabel(Type);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 40;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(variableName);
		gbc.gridx = 1;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(text);
		gbc.gridx = 2;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(row);
		gbc.gridx = 3;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(colon);
		gbc.gridx = 4;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(rows);
		gbc.gridx = 5;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(colons);
		gbc.gridx = 6;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(filler);
		gbc.gridx = 7;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		
		jt = new JLabel(anchor);
		gbc.gridx = 8;
		jt.setBorder(blackline);
		metaTableFrame.add(jt, gbc);
		makeRow();
	}
	public void insertRow() 
	{
		
	}
	public void makeRow() 
	{
		/*
		 * Midlertidig kode for adding av rader.
		 * Fungerer ikke bra, og legges ikke til i en Vector
		 */
		y++;
		gbc.ipady = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		String[] choices = {"JButton", "JLabel", "JTextfield", "JTextArea"};
		JComboBox varType = new JComboBox(choices);
		gbc.gridx = 0;
		gbc.gridy = y;
		varType.setBorder(blackline);
		metaTableFrame.add(varType, gbc);

		gbc.ipady = 13;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varName = new JTextField(variableName);	//Skal endres til ny0 og ny1
		gbc.gridx = 1;
		gbc.gridy = y;
		varName.setBorder(blackline);
		metaTableFrame.add(varName, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varText = new JTextField();	//Skal endres til ny0 og ny1
		gbc.gridx = 2;
		gbc.gridy = y;
		varText.setBorder(blackline);
		metaTableFrame.add(varText, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varRow = new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 3;
		gbc.gridy = y;
		varRow.setBorder(blackline);
		metaTableFrame.add(varRow, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varColon = new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 4;
		gbc.gridy = y;
		varColon.setBorder(blackline);
		metaTableFrame.add(varColon, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varRows = new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 5;
		gbc.gridy = y;
		varRows.setBorder(blackline);
		metaTableFrame.add(varRows, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		JTextField varColons= new JTextField("1");	//Skal endres til ny0 og ny1
		gbc.gridx = 6;
		gbc.gridy = y;
		varColons.setBorder(blackline);
		metaTableFrame.add(varColons, gbc);

		gbc.ipady = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		ImageIcon[] choicesFill = {
				new ImageIcon("images/skaler_begge.png"),
						new ImageIcon("images/skaler_horisontalt.png"),
						new ImageIcon("images/skaler_ingen.png"),
						new ImageIcon("images/skaler_vertikalt.png")
						};
		JComboBox varFill = new JComboBox(choicesFill);
		gbc.gridx = 7;
		gbc.gridy = y;
		varFill.setBorder(blackline);
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
		gbc.gridy = y;
		varAnchor.setBorder(blackline);
		metaTableFrame.add(varAnchor, gbc);

	}
	
	public void moveRowUpOrDown() 
	{
		//if(downButtonPressed)
		
		//else if(upButtonPressed)
		
	}
}


