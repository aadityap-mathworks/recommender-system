

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadFile extends dm_project{
	
	//function to read the input file and covert it to csv
	public static void Change(String infileName, String cfileName )  
	{
		
		try
		{
			//using file reader and writer
			File infile = new File(infileName);	
			FileReader infileReader = new FileReader(infile);
			File cfile = new File(cfileName);	
			FileWriter cfilewriter = new FileWriter(cfile);
			
			BufferedReader bufferedReader = new BufferedReader(infileReader);
			BufferedWriter bufferwriter = new BufferedWriter(cfilewriter);
		
			//array to check if item is rated by any user
			int array[]= new int[1683];
			for(int a =1; a<=1682;a++)
			{
				array[a]=777;
			}
			
			
			String currentline;
			while ((currentline = bufferedReader.readLine()) != null) 
				{
					//splitting the input file with spaces
					String part[] = currentline.split("[ ,]+");
					int user= Integer.parseInt(part[0]);
					int item= Integer.parseInt(part[1]);
					int rating = Integer.parseInt(part[2]);
					matrix[user][item]=rating;
					
					//writing to csv file
					bufferwriter.write(part[0]+","+part[1]+","+part[2]+"\n");
					
					//if item is already rated
					array[item]=0;
				}
			
			//if item is not rated by any user
			for(int a =1; a<=1682;a++)
			{
				if(array[a]!=0)
				{
					bufferwriter.write("1,"+a+",1\n");
				}
			}
			
			//close buffered reader and writer
			bufferedReader.close();
			bufferwriter.close();
		
		}		
		
		//catch block
		catch (FileNotFoundException ex)
	        {
	            System.out.println("Cannot find the file '" + infileName + "'");
	        } 
		catch (IOException ex)
	        {
	            System.out.println("Error occureed while reading the file '" + infileName + "'");
	
	        }
	}


}
