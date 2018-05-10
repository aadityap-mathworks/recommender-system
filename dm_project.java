import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;

public class dm_project {

	//declare matrix
	protected static int matrix[][]= new int[944][1683];
	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws TasteException
	 */
	public static void main(String[] args) throws IOException, TasteException
	{
		//file paths
		String finput = "train_all_txt.txt";
		String cinput= "train.csv";
		String out="output.txt";
		
		//initialize matrix
		for(int i=0;i<=943;i++)
		{
			for(int j = 0; j<=1682;j++)
			{
				matrix[i][j]=0;
			}
		}
		
		//convert file into preferred format
		ReadFile.Change(finput, cinput);
		
		//data model
		Recommender.model(cinput);
		
		
		//printing result to console
//		for(int i=1;i<=943;i++)
//		{
//			for(int j = 1; j<=1682;j++)
//			{
//				System.out.println(i+" "+j+" "+matrix[i][j]);
//			}
//		}
//		
		//output file
		ExpFile.export(out);
		System.out.println("output file is generated. \nName : "+out);

	}

}
