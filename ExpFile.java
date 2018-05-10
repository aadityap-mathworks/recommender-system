

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExpFile extends dm_project
{
	public static void export(String outfile) throws IOException
	{
		//using String builder
		File outputFile = new File(outfile);
		BufferedWriter buff = new BufferedWriter(new FileWriter(outputFile));
		StringBuilder lineBuffer = new StringBuilder();
		
		//appending ratings to output file buffer
		for (int userID = 1; userID < matrix.length; userID++) {
			for (int itemID = 1; itemID < matrix[userID].length; itemID++) {
				lineBuffer.append(userID + " " + itemID + " " + matrix[userID][itemID] + "\n");
			}
		}
		//writing to output file
		buff.write(lineBuffer.toString());
		buff.close();
	}
	
}
