package com.theforce.programutviklingsepisodeIV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
* Main entry point
* Creates the frame, and its components, and serves as a hub throughout the application for
* all the important references
*
* @author John Hoegh-Omdal
* @author Jehans Storvik
* @author Hans Martin Bragen
* @version 1.0
*/
public class TableManager {
	JTable table;
	RowModel data;
	int incrementValue = 0;
	
	JScrollPane scrollPane;
	
	/**
	* Constructor class that creates the table manager and its contents
	* 
	*/
	@SuppressWarnings("unchecked")
	public TableManager() {
		System.out.println("Creating metatable"); //$NON-NLS-1$
		
		// Create table
		this.data = new RowModel();
		this.table = new JTable(this.data);
		this.scrollPane = new JScrollPane(table);
		
		// Add table to frame
		Launcher.getFrame().add(scrollPane);
		table.setDragEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// Modify first column - variable type
		JComboBox<Object> comboVariableTypes = new JComboBox<Object>(Row.getTypes());
		
		TableColumn typeColumn = table.getColumnModel().getColumn(0);
		typeColumn.setCellEditor(new DefaultCellEditor(comboVariableTypes));
		typeColumn.setPreferredWidth(100);
		
		// Modify second column - variable type
		TableColumn nameColumn = table.getColumnModel().getColumn(1);
		nameColumn.setPreferredWidth(100);
		
		// Modify fourth column - row
		TableColumn rowColumn = table.getColumnModel().getColumn(3);
		rowColumn.setPreferredWidth(50);
		
		// Modify fifth column - row
		TableColumn columnColumn = table.getColumnModel().getColumn(4);
		columnColumn.setPreferredWidth(50);
		
		// Modify sixth column - row
		TableColumn rowsColumn = table.getColumnModel().getColumn(5);
		rowsColumn.setPreferredWidth(50);
		
		// Modify seventh column - columns
		TableColumn columnsColumn = table.getColumnModel().getColumn(6);
		columnsColumn.setPreferredWidth(50);
		
		// Modify eight column - Fill
		JComboBox<Object> comboFill = new JComboBox<Object>(Row.getFillers());
		comboFill.setRenderer(new ComboBoxImageDropdownRenderer("fill")); //$NON-NLS-1$
		
		TableColumn fillColumn = table.getColumnModel().getColumn(7);
		fillColumn.setCellEditor(new DefaultCellEditor(comboFill));
		fillColumn.setCellRenderer(new ComboBoxImageCellRenderer("fill")); //$NON-NLS-1$
		fillColumn.setPreferredWidth(100);
		
		// Modify nine column - Anchor
		JComboBox<Object> comboAnchor = new JComboBox<Object>(Row.getAnchors());
		comboAnchor.setRenderer(new ComboBoxImageDropdownRenderer("anchor")); //$NON-NLS-1$
		
		TableColumn anchorColumn = table.getColumnModel().getColumn(8);
		anchorColumn.setCellEditor(new DefaultCellEditor(comboAnchor));
		anchorColumn.setCellRenderer(new ComboBoxImageCellRenderer("anchor")); //$NON-NLS-1$
		anchorColumn.setPreferredWidth(125);
		
		// Set height
		this.table.setRowHeight(20);
		
		// Add right click menu
		this.table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
		        int r = table.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < table.getRowCount()) {
		            table.setRowSelectionInterval(r, r);
		        } else {
		            table.clearSelection();
		        }
		        
		        int rowindex = table.getSelectedRow();
		        if (rowindex < 0) {
		            return;
		        }
		        
				if (e.isPopupTrigger()) {
					JPopupMenu popup = new JPopupMenu();
					// Move row up
					JMenuItem moverowup = new JMenuItem(Messages.getString("TableActions.rowmoveup")); //$NON-NLS-1$
					moverowup.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent event) {
			            	System.out.println("Move row " + table.getSelectedRow() + " up"); //$NON-NLS-1$ //$NON-NLS-2$
			            	data.moveRowUp(table.getSelectedRow());
			            }
			        });
					popup.add(moverowup);
					// Move row down
					JMenuItem moverowdown = new JMenuItem(Messages.getString("TableActions.rowmovedown")); //$NON-NLS-1$
					moverowdown.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent event) {
			            	System.out.println("Move row " + table.getSelectedRow() + " down"); //$NON-NLS-1$ //$NON-NLS-2$
			            	data.moveRowDown(table.getSelectedRow());
			            }
			        });
					popup.add(moverowdown);
					// Delete row
					JMenuItem removerow = new JMenuItem(Messages.getString("TableActions.rowremove")); //$NON-NLS-1$
					removerow.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent event) {
			                // Delete the row
			            	System.out.println("Delete row " + table.getSelectedRow()); //$NON-NLS-1$
			            	data.removeRow(table.getSelectedRow());
			            }
			        });
					popup.add(removerow);
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}
	
	/**
	* Proxy function to create new row
	*/
	public void insertRow() {
		this.data.insertRow(new Row("JButton", Messages.getString("TableActions.rownew_initname") + this.incrementValue++, "", 1, 1, 1, 1, "NONE", "CENTER")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}
	
	/**
	* Proxy function to move a row down
	*/
	public void moveRowDown() {
		int selectedRow = this.table.getSelectedRow();
		if (selectedRow != -1) {
			if (this.data.moveRowDown(selectedRow)) {
				this.table.setRowSelectionInterval(selectedRow+1, selectedRow+1);
			}
		}
	}
	
	/**
	* Proxy function to move a row up
	*/
	public void moveRowUp() {
		int selectedRow = this.table.getSelectedRow();
		if (selectedRow != -1) {
			if (this.data.moveRowUp(selectedRow)) {
				this.table.setRowSelectionInterval(selectedRow-1, selectedRow-1);
			}
		}		
	}
	
	/**
	* Proxy function to clear the table
	*/
	public void clear() {
		this.data.clear();
	}
	
	/**
	* Proxy function to save the table
	*/
	public void save() {
		this.data.save(false);
	}
	
	/**
	* Proxy function to save the table, requiring custom path
	*/
	public void saveAs() {
		this.data.save(true);
	}
	
	/**
	* Proxy function to load a table
	*/	
	public void load() {
		this.data.load();
	}
	
	/**
	* Proxy function to preview an exported component table
	*/
	public void preview() {
		this.data.preview();
	}
	
	/**
	* Proxy function to save-export the table to a .java file
	*/
	public void export() {
		this.data.export();
	}
}