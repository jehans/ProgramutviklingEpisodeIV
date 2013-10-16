package com.theforce.programutviklingsepisodeIV;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

		public class Editor extends AbstractTableModel {

			Vector data = new Vector();
			public Editor()
			{
				
			}
			@Override
			public int getColumnCount() {
				System.out.println("getColumnCount");
				return 9;
			}

			@Override
			public int getRowCount() {
				System.out.println("getRowCount");
				// TODO Auto-generated method stub
				return data.size();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				System.out.println("getValueAt");
				return ((Vector) data.get(rowIndex)).get(columnIndex);
			}
			 
			 public void setValueAt(Object value, int row, int col){
					System.out.println("setValueAt");
				 ((Vector) data.get(row)).setElementAt(value, col);
				 fireTableCellUpdated(row,col);
				 }
			 
			 public void removeRow(int row){
				 data.removeElementAt(row);
				 fireTableDataChanged();
				 }
			 
			 public void insertData(Object[] values){
				 data.add(new Vector());
				 for(int i =0; i<values.length; i++){
				 ((Vector) data.get(data.size()-1)).add(values[i]);
				 }
				 fireTableDataChanged();
				}
		}
