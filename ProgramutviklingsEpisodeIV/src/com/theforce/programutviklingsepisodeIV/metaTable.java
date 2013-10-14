package com.theforce.programutviklingsepisodeIV;

import javax.swing.JButton;
import javax.swing.JFrame;

public class metaTable extends JFrame {

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
		JFrame metTableFrame = new JFrame();	
		JButton jb = new JButton();
		metTableFrame.add(jb);
		jb.setVisible(true);
		System.out.println("Lager metaTable");
		
	}

}


