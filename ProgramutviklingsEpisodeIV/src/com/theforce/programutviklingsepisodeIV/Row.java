package com.theforce.programutviklingsepisodeIV;

public class Row {
	String Type;
	String name;
	String text;
	int row;
	int colon;
	int rows;
	int colons;
	String filler;
	String anchor;
	
	void setType(String t){
		Type = t;
	}
	void setName(String n){
		name = n;
	}
	void setText(String t){
		text = t;
	}
	void setRow(int r){
		row = r;
	}
	void setColon(int c){
		colon = c;
	}
	void setRows(int r){
		rows = r;
	}
	void setColons(int c){
		colons = c;
	}
	void setFiller(String f){
		filler = f;
	}
	void setAnchor(String a){
		anchor = a;
	}
	
	String getType(){
		return Type;
	}
	String getName(){
		return name;
	}
	String getText(){
		return text;
	}
	int getRow(){
		return row;
	}
	int getColon(){
		return colon;
	}
	int getRows(){
		return rows;
	}
	int getColons(){
		return colons;
	}
	String getFiller(){
		return filler;
	}
	String getAnchor(){
		return anchor;
	}
	
	public Row() {
		// TODO Auto-generated constructor stub
	}

}
