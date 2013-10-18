package com.theforce.programutviklingsepisodeIV;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.*;

/**
 * A custom renderer for the table cell of a combobox showing an image
 * This only applies when the cell is unclicked. When the combobox has focus, 
 * ComboBoxImageDropDownRenderer applies instead
 * 
 * @author John Hoegh-Omdal
 * @version 1.0
 */
public class ComboBoxImageCellRenderer extends JLabel implements TableCellRenderer {
	private String type;
	private static final long serialVersionUID = -6764260733521600688L;

	/**
	 * Constructor that initializes the renderer
	 * 
	 * @param type Used to differentiate between fill and anchor combobox, in order to display right image(s)
	 */
	public ComboBoxImageCellRenderer(String type) {
		this.type = type;
		this.setOpaque(true);
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
	}
	
	/**
	 * @param table Parent table for component cell
	 * @param value Component value
	 * @param isSelected Whether or not the cell is selected
	 * @param hasFocus Whether or not the cell has focus
	 * @param row which row the cell is in
	 * @param column which column the cell is in
	 * @return Returns the component for the cell
	 */
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			this.setBackground (table.getSelectionBackground ());
		} else {
			this.setBackground (table.getBackground ());
		}

		this.setText ("");
		if (this.type == "fill") {
			@SuppressWarnings("serial")
			Map<String, String> iconpaths = new HashMap<String, String>() {{
				put("NONE", "skaler_ingen.png");
				put("HORIZONTAL", "skaler_horisontalt.png");
				put("VERTICAL", "skaler_vertikalt.png");
				put("BOTH", "skaler_begge.png");
			}};
			this.setIcon(new ImageIcon("images/" + iconpaths.get(value)));
		}
		
		else if (this.type == "anchor") {
			@SuppressWarnings("serial")
			Map<String, String> iconpaths = new HashMap<String, String>() {{
				put("CENTER", "anchor_center.png");
				put("NORTH", "anchor_north.png");
				put("WEST", "anchor_west.png");
				put("EAST", "anchor_east.png");
				put("SOUTH", "anchor_south.png");
				put("NORTHEAST", "anchor_northeast.png");
				put("NORTHWEST", "anchor_northwest.png");
				put("SOUTHEAST", "anchor_southeast.png");
				put("SOUTHWEST", "anchor_southwest.png");
			}};
			this.setIcon(new ImageIcon("images/" + iconpaths.get(value)));
		}
		return this;
	}
}