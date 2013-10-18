package com.theforce.programutviklingsepisodeIV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.AbstractTableModel;

public class RowModel extends AbstractTableModel {
	private static final long serialVersionUID = -4052506375066105893L;
	private Vector<Row> data = new Vector<Row>();
	private String[] columnNames = {Messages.getString("RowModel.tableheader.type"), Messages.getString("RowModel.tableheader.variable_name"), Messages.getString("RowModel.tableheader.text"), Messages.getString("RowModel.tableheader.row"), Messages.getString("RowModel.tableheader.column"), Messages.getString("RowModel.tableheader.rows"), Messages.getString("RowModel.tableheader.columns"), Messages.getString("RowModel.tableheader.fill"), Messages.getString("RowModel.tableheader.anchor")}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
	private String path;
	
	// Add and remove rows
	public void insertRow(Row row) {
		System.out.println("insertRow"); //$NON-NLS-1$
		data.add(row);
		this.fireTableRowsInserted(data.size()-1, data.size()-1);
	}
	
	public void removeRow(int row) {
		System.out.println("removeRow"); //$NON-NLS-1$
		data.remove(row);
		this.fireTableDataChanged();
	}
	
	public Boolean moveRowDown(int rowindex) {
		if (this.data.size()-1 == rowindex) { return false; }
		Row row = this.data.remove(rowindex);
		this.data.add(rowindex + 1, row);
		this.fireTableDataChanged();
		return true;
	}
	
	public Boolean moveRowUp(int rowindex) {
		if (rowindex == 0) { return false; }
		Row row = this.data.remove(rowindex);
		this.data.add(rowindex - 1, row);
		this.fireTableDataChanged();
		return true;
	}
	
	// Column info
	public String getColumnName(int col) {
		System.out.println("getColumnName"); //$NON-NLS-1$
		return columnNames[col];
	}
	
	@Override
	public int getColumnCount() {
		System.out.println("getColumnCount"); //$NON-NLS-1$
		return columnNames.length;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int column) {
		return this.getValueAt(0, column).getClass();
	}

	@Override
	public int getRowCount() {
		System.out.println("getRowCount"); //$NON-NLS-1$
		// TODO Auto-generated method stub
		return data.size();
	}
	 
	public void setValueAt(Object value, int row, int column){
		System.out.println("setValueAt"); //$NON-NLS-1$
		Row rowdata = (Row)(this.data.get(row));
		rowdata.setColumn(column, value);
		fireTableCellUpdated(row, column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Row rowdata = (Row)(this.data.get(row));
		return rowdata.getColumn(column);
	}
	
	public boolean isCellEditable(int row, int col) {
		return true;
	}
	
	public void load() {
		String path = null;

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //$NON-NLS-1$
		fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String fName = file.getName().toLowerCase();
                if (fName.endsWith(".r2d2") || file.isDirectory()) { //$NON-NLS-1$
                    return true;
                } else {
                    return false;   
                }
            }

            public String getDescription() {
                return "R2D2 (*.r2d2)"; //$NON-NLS-1$
            }
		});
		  
		int userSelection = fileChooser.showOpenDialog(null);
		  
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToLoad = fileChooser.getSelectedFile();
		    path = fileToLoad.getAbsolutePath();
		    this.path = path;
		}
		
		if (path != null) { 
			this.data.clear();
			Row buffer = null;
			try	{
				FileInputStream fileIn = new FileInputStream(path); //$NON-NLS-1$
				ObjectInputStream in = new ObjectInputStream(fileIn);
				do {
					buffer = (Row)in.readObject();
					if(buffer != null) {
						this.data.add(buffer);
					}
				} while(buffer != null);
				in.close();
				fileIn.close();
				this.fireTableDataChanged();
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Boolean showSaveDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //$NON-NLS-1$
		fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String fName = file.getName().toLowerCase();
                if (fName.endsWith(".r2d2") || file.isDirectory()) { //$NON-NLS-1$
                    return true;
                } else {
                    return false;   
                }
            }

            public String getDescription() {
                return "R2D2 (*.r2d2)"; //$NON-NLS-1$
            }
		});
		  
		int userSelection = fileChooser.showSaveDialog(null);
		  
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    this.path = fileToSave.getAbsolutePath();
			if (!path.toLowerCase().endsWith(".r2d2")) { //$NON-NLS-1$
				this.path += ".r2d2"; //$NON-NLS-1$
			}
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void save(Boolean showDialog) {
		if (showDialog == null) { showDialog = false; }
		try {
			Boolean canSave = this.path != null;
			if (!canSave || showDialog) { 
				this.showSaveDialog();
			}
			if (canSave && this.path != null) { 
				FileOutputStream fileOut = new FileOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				for(int i = 0; i < this.data.size(); i++) {
					out.writeObject(this.data.get(i));
				}
				out.writeObject(null);
				out.close();
				fileOut.close();
				this.fireTableDataChanged();
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void preview() {
		Preview.PreviewExport(this.data);
	}

	public void export() {
		FileExport.ExportToFile(this.data);
	}

	public void clear() {
		this.data.clear();
		this.path = null;
		this.fireTableDataChanged();
	}
}
