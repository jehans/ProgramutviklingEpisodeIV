package com.theforce.programutviklingsepisodeIV;

import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
* Generates javacode and writes it to file
* <p>
* Takes a Vector with Row objects and transform them into javacode and wirtes it to a class file
*
* @author Hans Martin Bragen
* @author John Hoegh-Omdal
* @author Jehans Sotrvik
*/

public abstract class FileExport {
	private static PrintWriter writer;
	private static LinkedList<FillData> queue;
	private static String cName;
	
	private static class FillData {
		String out;
		// Save the row, column, rows and column number for later use.
		FillData(Row row) {
			out = "\t\tgbc.gridx = " + row.getColumn() + ";\r\n"
				+ "\t\tgbc.gridy = " + row.getRow() + ";\r\n"
				+ "\t\tgbc.gridwidth = " + row.getColumns() + ";\r\n"
				+ "\t\tgbc.gridheight = " + row.getRows() + ";\r\n"
				+ "\t\tgbc.anchor = java.awt.GridBagConstraints." + row.getAnchor() + ";\r\n"
				+ "\t\tgbc.fill = java.awt.GridBagConstraints." + row.getFiller() + ";\r\n";
			
			if(row.getType().equals("JLabel") || row.getType().equals("JButton") || row.getType().equals("JTextField")) {
				out += "\t\tlayout.setConstraints (" + row.getName() + ", gbc);\r\n"
					+ "\t\tthis.add(" + row.getName() + ");\r\n";
			}

			else if(row.getType().equals("JTextArea")) {
				out += "\t\tJScrollPane " + row.getName() + "ScrollPane = new JScrollPane (" + row.getName() + ");\r\n"
					+ "\t\tthis.add (" + row.getName() + "ScrollPane, gbc);\r\n"						
					+ "\t\tlayout.setConstraints (" + row.getName() + "ScrollPane, gbc);\r\n"
					+ "\t\tthis.add("+ row.getName() + "ScrollPane);\r\n"
					+ "\t\t" + row.getName() + ".setLineWrap(true);\r\n"
					+ "\t\t" + row.getName() + ".setWrapStyleWord(true);\r\n";
			}
		}
		
		public void filldata(PrintWriter writer) {
			writer.print(out);
		}
	}
	/**
	 * Exports data to file
	 */
	public static void ExportToFile(Vector<Row> data) {
		writer = null;
		queue = new LinkedList<FillData>();
		String path = null;

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                String fName = f.getName().toLowerCase();
                if (fName.endsWith(".java") || f.isDirectory()) {
                    return true;
                } else {
                    return false;   
                }
            }

            public String getDescription() {
                return "Java file (*.java)";
            }
		});
		  
		int userSelection = fileChooser.showOpenDialog(null);
		  
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToLoad = fileChooser.getSelectedFile();
		    path = fileToLoad.getAbsolutePath();
		}
		
		if (path != null) {
			cName = path; 
		}
		
		else {
			return;
		}
		
		try {
			writer = new PrintWriter(path + ".java", "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(writer != null) {
			// Gathering the start of a file into one String for easier printing
			String out = "import javax.swing.*;\r\n"
				+ "import java.awt.*;\r\n"
				+ "\r\n"
				+ "/**\r\n"
				+ " @author SkyNet\r\n"
				+ " */\r\n"
				+ "public class " + path + " extends JPanel \r\n{\r\n";
			writer.print(out);
		}
		
		for(int i = 0; i < data.size(); i++) {
			write(data.get(i));
		}
		closeFile();
	}
	/**
	 * Only for internal use :)
	 * <p>
	 * Used to sett component parameters using the earlyer created stack
	 * @return if file was open and got closed returns true; if not false
	 */

	private static boolean closeFile() {
		if(writer == null) {
			return false;
		}
		String out = null;
		out = "\tpublic " + cName + "()\r\n"
			+ "\t{\r\n"
			+ "\t\tGridBagLayout layout = new GridBagLayout ();\r\n"
			+ "\t\tGridBagConstraints gbc = new GridBagConstraints();\r\n"
			+ "\t\tsetLayout (layout);\r\n";
		writer.print(out);
		FillData buffer = null;
		
		while(!(queue.isEmpty())) {
			buffer = queue.removeFirst();
			buffer.filldata(writer);
		}
		
		out = "\t\t}\r\n"
			+ "\tpublic static void main(String[] args)\r\n"
			+ "\t{\r\n"
			+ "\t\tJFrame frame = new JFrame(\"" + cName + "\");\r\n"
			+ "\t\tframe.add(new " + cName + "());\r\n"
			+ "\t\tframe.setSize(800, 600);\r\n"
			+ "\t\tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\r\n"
			+ "\t\tframe.setVisible(true);\r\n"
			+ "\t}\r\n"
			+ "}";
		writer.print(out);

		writer.close();
		return true;
	}
	/**
	 * @param row Takes a Row element and writes it's declaration to file and then adds 
	 * it's parameters to the stack so they can be set when all declarations are done.
	 */
	private static void write(Row row) {
		FillData buffer = null;
		buffer = new FillData(row);
		String out = null;
		out = "\t" + row.getType() + " " + row.getName() + " = new " + row.getType() + "(\"" + row.getText() +"\");\r\n";
		writer.print(out);
		queue.add(buffer);
	}

}