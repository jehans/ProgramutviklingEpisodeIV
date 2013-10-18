package com.theforce.programutviklingsepisodeIV;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * A custom renderer for the table cell of a combobox showing an image
 * This only applies when the cell is clicked. When the combobox doesn't have focus, 
 * ComboBoxImageCellRenderer applies instead
 * 
 * @author John Hoegh-Omdal
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class ComboBoxImageDropdownRenderer extends JLabel implements ListCellRenderer {
	private String type;
	private static final long serialVersionUID = -8355081420106832030L;

	/**
	 * Constructor that initializes the renderer
	 * 
	 * @param type Used to differentiate between fill and anchor combobox, in order to display right image(s)
	 */
	public ComboBoxImageDropdownRenderer(String type) {
		this.type = type;
		this.setOpaque(true); 
		this.setHorizontalAlignment(CENTER);	
		this.setVerticalAlignment(CENTER);
	}

	/**
	 * @param list List containing the dropdown components
	 * @param value Component value
	 * @param index
	 * @param isSelected whether or not the cell is selected
	 * @param cellHasFocus whether or not the cell has focus
	 * @return Returns the component for the cell
	 */
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} 
		
		else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		setText ("");
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