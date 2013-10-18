package com.theforce.programutviklingsepisodeIV;

/**
 * <p>
 * Container class for components
 * <p>
 * Has functions to read and write row objects from binary files
 * 
 * @author Hans Martin Bragen
 * @author John Hoegh-Omdal
 * @author Jehans Jr Storvik
 */
public class Row implements java.io.Serializable {
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
	
	/**
	* @return Returns the various types of UI components available. Used to create combobox 
	*/
	public static String[] getTypes() {
		return types;
	}
	
	/**
	* @return Returns the various types of UI fillers available. Used to create combobox 
	*/
	public static String[] getFillers() {
		return fillers;
	}
	
	/**
	* @return Returns the various types of UI anchors available. Used to create combobox 
	*/
	public static String[] getAnchors() {
		return anchors;
	}
	
	/**
	 * Constructs a Row object to store the parameters of a component
	 * @param type Type of ui component
	 * @param name variable name
	 * @param text contents
	 * @param row Which row it should be placed at
	 * @param column Which column it should be placed at
	 * @param rows How many rows it should span across
	 * @param columns How many columns it should span across
	 * @param filler What type of filler to use
	 * @param anchor How to anchor the component
	 */
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
	
	/**
	 * Fetch column value by index
	 * 
	 * @param column Index of column to fetch
	 * @return column value
	 */
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
	
	/**
	 * Set column value by index
	 * 
	 * @param column Index of column to change
	 * @param value Value to change column to
	 */
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
	
	/**
	 * @return Component type
	 */
	public String getType(){
		return this.type;
	}
	
	/**
	 * @return Variable name
	 */
	String getName(){
		return this.name;
	}
	
	/**
	 * @return Component value/text
	 */
	String getText(){
		return this.text;
	}
	
	/**
	 * @return Component row position
	 */
	int getRow(){
		return this.row;
	}

	/**
	 * @return Component column position
	 */
	int getColumn() {
		return this.column;
	}
	
	/**
	 * @return Component rows span
	 */
	int getRows() {
		return this.rows;
	}
	
	/**
	 * @return Component columns span
	 */
	int getColumns() {
		return this.columns;
	}
	
	/**
	 * @return Component filler type
	 */
	public String getFiller() {
		return this.filler;
	}
	
	/**
	 * @return Component anchor type
	 */
	public String getAnchor() {
		return this.anchor;
	}
}