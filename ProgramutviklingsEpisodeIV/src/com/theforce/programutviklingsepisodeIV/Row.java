package com.theforce.programutviklingsepisodeIV;

public class Row implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5964224382846289594L;
	private String type;
	private static String[] types = {"JButton", "JLabel", "JTextfield", "JTextArea"};
	
	private String name;
	private String text;
	private int row;
	private int column;
	private int rows;
	private int columns;
	private String filler;
	private static String[] fillers = {"NONE", "HORIZONTAL", "VERTICAL", "BOTH"};
	private String anchor;
	private static String[] anchors = {"CENTER", "NORTH", "WEST", "EAST", "SOUTH", "NORTHEAST", "NORTHWEST", "SOUTHEAST", "SOUTHWEST"};
	
	public static String[] getTypes() {
		return types;
	}
	
	public static String[] getFillers() {
		return fillers;
	}
	
	public static String[] getAnchors() {
		return anchors;
	}
	
	public Row(String type, String name, String text, int row, int column, int rows, int columns, String filler, String anchor) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.name = name;
		this.text = text;
		this.row = row;
		this.column = column;
		this.rows = rows;
		this.columns = columns;
		this.filler = filler;
		this.anchor = anchor;
	}
	
	Object getColumn(int column) {
		switch(column) {
		case 0: return this.type;
		case 1: return this.name;
		case 2: return this.text;
		case 3: return this.row;
		case 4: return this.column;
		case 5: return this.rows;
		case 6: return this.columns;
		case 7: return this.filler;
		case 8: return this.anchor;
		default: return this.type;
		}
	}
	
	void setColumn(int column, Object value) {
		switch(column) {
		case 0: this.type = (String) value; return;
		case 1: this.name = (String) value; return;
		case 2: this.text = (String) value; return;
		case 3: this.row = (Integer) value; return;
		case 4: this.column = (Integer) value; return;
		case 5: this.rows = (Integer) value; return;
		case 6: this.columns = (Integer) value; return;
		case 7: this.filler = (String) value; return;
		case 8: this.anchor = (String) value; return;
		default: return;
		}
	}
	
	public String getType(){
		return this.type;
	}
	
	String getName(){
		return this.name;
	}
	
	String getText(){
		return this.text;
	}
	
	int getRow(){
		return this.row;
	}
	
	int getColumn() {
		return this.column;
	}
	
	int getRows() {
		return this.rows;
	}
	
	int getColumns() {
		return this.columns;
	}
	
	public String getFiller() {
		return this.filler;
	}
	
	public String getAnchor() {
		return this.anchor;
	}
}
