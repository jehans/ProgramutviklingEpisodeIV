package com.theforce.programutviklingsepisodeIV;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;


/**
* @author Hans Martin Bragen 
*/

public class FileEksport {
	
	
	public class FillData
	{
		String out;
		// Save the row, column, rows and column number for later use.
		FillData(String type, String varName, int row, int column, int rows, 
				int columns, String anchor, String fill)
		{
			out = "\t\tgbc.gridx = " + row + ";\r\n"
					+ "\t\tgbc.gridy = " + column + ";\r\n"
					+ "\t\tgbc.gridwidth = " + rows + ";\r\n"
					+ "\t\tgbc.gridheight = " + columns + ";\r\n"
					+ "\t\tgbc.anchor = java.awt.GridBagConstraints." + anchor + ";\r\n"
					+ "\t\tgbc.fill = java.awt.GridBagConstraints." + fill + ";\r\n";
			
			if(type == "JLabel" || type == "JButton" || type == "JTextField" || type == "JTextArea")
					out += "\t\tlayout.setConstraints (" + varName + ", gbc);\r\n"
							+ "\t\tadd(" + varName + ");\r\n";
			else if(type == "JScrollPane")
			{
				out += "\tJscrollPane = " + varName + "ScrollPane = new JScrollpane (" + varName + ");\r\n"
						+ "\t\tlayout.setConstraints (" + varName + "ScrollPane, gbc);\r\n"
						+ "\t\tadd (" + varName + "ScrollPane, gbc);\r\n"
						+ "add("+ varName + "ScrollPane);\r\n"
						+ "\t\t" + varName + ".setLineWrap(true);\r\n"
						+ "\t\t" + varName + ".setWrapStyleWord (true)\r\n";
			}
			
		}
		void filldata(PrintWriter writer)
		{
			writer.print(out);
		}
	}
	PrintWriter writer;
	LinkedList<FillData> queue;
	String cName;		// The name of the class that is being generated
	
	/**
	* @param className Name of the class that is being generated.
	*/
	FileEksport(String className)
	{
		writer = null;
		queue = new LinkedList<FillData>();
		try {
			writer = new PrintWriter("the-file-name.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(writer != null)
		{
			cName = className;
			// Gathering the start of a file into one String for easier printing
			String out = "import javax.swing.*;\r\n"
					+ "import java.awt.*;\r\n"
					+ "\r\n"
					+ "/**\r\n"
					+ " @author SkyNet\r\n"
					+ " */\r\n"
					+ "public class " + className + " extends JPanel \r\n{\r\n";
			writer.print(out);
		}
	}
	
	
	// Checks to make sure the file is open before using it.
	public boolean fileOpen()
	{
		return (writer != null) ? true : false;
	}
	// Closes the file after use.
	public boolean closeFile()
	{
		if(writer == null)
			return false;
		String out = null;
		out = "\tpublic " + cName + "()\r\n"
				+ "\t{\r\n"
				+ "\t\tGridBagLayout layout = new GridBagLayout ();\r\n"
				+ "\t\tGridBagConstraints gbc = new GridBagConstraints();\r\n"
				+ "\t\tsetLayout (layout);\r\n";
		writer.print(out);
		FillData buffer = null;
		while(!(queue.isEmpty()))
		{
			buffer = queue.removeFirst();
			buffer.filldata(writer);
		}
		
		
		/* Adds the generating of main to the output file*/
		//*	
		
		out = "\t\t}\r\n"
				+ "\tpublic static void main(String[] args)\r\n"
				+ "\t{\r\n"
				+ "\t\tJFrame f = new JFrame(\"" + cName + "\");\r\n"
				+ "\t\tf.add(new testklasse());\r\n"
				+ "\t\tf.setSize(800, 600);\r\n"
				+ "\t\tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\r\n"
				+ "\t\tf.setVisible(true);\r\n"
				+ "\t}\r\n"
				+ "}";
		writer.print(out);
		
		/*/
		out = "\t}\r\n}";
		writer.print(out);
		//*/
		writer.close();
		return true;
	}
	
	public void write(String type, String varName,String varText, int row, int column, int rows,
			int columns, String fill, String anchor)
	{
		FillData buffer = null;
		buffer = new FillData(type, varName, row, column, rows, columns, fill, anchor);
		String out = null;
		out = "\t" + type + " " + varName + " = new " + type + "(\"" + varText +"\");\r\n";
		writer.print(out);
		queue.add(buffer);
		
		// type, varName, varText, row, column, row, columns, rows, fill, anchor
		
	}

}