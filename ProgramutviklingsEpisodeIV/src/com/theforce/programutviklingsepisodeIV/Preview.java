package com.theforce.programutviklingsepisodeIV;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

/**
 * Generates a window with row components
 * <p>
 * Takes a vector with row components, and generates a new 
 * window with the row components translatet into javacode
 * 
 * @author Hans Martin Bragen
 * @author John Hoegh-Omdal
 * @author Jehans Storvik
 * @version 1.0
 */


public abstract class Preview {
	/**
	 * A class to generate preview
	 */
	public static class Generate extends JPanel{
		private static final long serialVersionUID = 8462459154264088745L;
		/**
		 * @param data tablemanager data
		 */
		public Generate(Vector<Row> data) {

			JLabel label = null;
			JButton button = null;
			JTextField textField = null;
			JTextArea textArea = null;
			
			GridBagLayout layout = new GridBagLayout ();
			GridBagConstraints gbc = new GridBagConstraints();
			this.setLayout(layout);
			
			for(int i = 0; i < data.size(); i++) {
				gbc.gridx = data.get(i).getColumn();
				gbc.gridy = data.get(i).getRow();
				gbc.gridwidth = data.get(i).getColumns();
				gbc.gridheight = data.get(i).getRows();

				// Fill
				if(data.get(i).getFiller().equals("NONE")) { //$NON-NLS-1$
					gbc.fill = java.awt.GridBagConstraints.NONE;
				}
				
				else if(data.get(i).getFiller().equals("HORIZONTAL")) { //$NON-NLS-1$
					gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
				}
				
				else if(data.get(i).getFiller().equals("VERTICAL")) { //$NON-NLS-1$
					gbc.fill = java.awt.GridBagConstraints.VERTICAL;
				}
				
				else if(data.get(i).getFiller().equals("BOTH")) { //$NON-NLS-1$
					gbc.fill = java.awt.GridBagConstraints.BOTH;
				}
				
				if(data.get(i).getType().equals("JLabel")) { //$NON-NLS-1$
					label = new JLabel(data.get(i).getText());
					layout.setConstraints (label, gbc);
					this.add(label);
				}
				
				else if(data.get(i).getType().equals("JButton")) { //$NON-NLS-1$
					button = new JButton(data.get(i).getText());
					layout.setConstraints (button, gbc);
					this.add(button);
				}
				
				else if(data.get(i).getType().equals("JTextField")) { //$NON-NLS-1$
					textField = new JTextField(data.get(i).getText());
					layout.setConstraints (textField, gbc);
					this.add(textField);
				}
				
				else if(data.get(i).getType().equals("JTextArea")) { //$NON-NLS-1$
					textArea = new JTextArea(data.get(i).getText(), data.get(i).getRows(), data.get(i).getColumns());
					
					JScrollPane buffer = new JScrollPane(textArea);
					layout.setConstraints (buffer, gbc);
					this.add(buffer);
				}
				
				// Anchor
				if(data.get(i).getAnchor().equals("CENTER")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.CENTER;
				}
				
				else if(data.get(i).getAnchor().equals("NORTH")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.NORTH;
				}
				
				else if(data.get(i).getAnchor().equals("WEST")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.WEST;
				}
				
				else if(data.get(i).getAnchor().equals("EAST")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.EAST;
				}
				
				else if(data.get(i).getAnchor().equals("SOUTHEAST")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.SOUTHEAST;
				}
				
				else if(data.get(i).getAnchor().equals("SOUTHWEST")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
				}
				
				else if(data.get(i).getAnchor().equals("SOUTH")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.SOUTH;
				}
				
				else if(data.get(i).getAnchor().equals("NORTHEAST")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.NORTHEAST;
				}
				
				else if(data.get(i).getAnchor().equals("NORTHWEST")) { //$NON-NLS-1$
					gbc.anchor = java.awt.GridBagConstraints.NORTHWEST;
				}
			}
		}
	}
	
	/**
	 * Generates a frame with the UI components from the tablemanager, and displays this preview to the user
	 */
	public static void PreviewExport(Vector<Row> data) {
		JFrame prev = new JFrame(Messages.getString("Preview.previewtitle")); //$NON-NLS-1$
		prev.add(new Generate(data));
		prev.setSize(500,200);
		prev.setVisible(true);	
	}
}