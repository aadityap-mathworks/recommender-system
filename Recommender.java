

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.model.DataModel;


public class Recommender extends dm_project {

	
	public static void model(String cinput) throws IOException, TasteException
	{
		//creating data model
		File inputFile = new File(cinput);
		DataModel dataModel = new FileDataModel(inputFile);
	
		//using ALSWRFactorizer for matrix factorization
		//Using 20 features, regularizing factor 0.085 and 15 iterarations to compute the factorization
		ALSWRFactorizer factorizer = new ALSWRFactorizer(dataModel, 20, 0.085, 15);

		//Using Singular Value decomposition recommender
		//The datamodel and factorized matrix is passed to it
		SVDRecommender svd = new SVDRecommender(dataModel, factorizer);
	 
		//LongPrimitiveIterator to get the itmes and users
	    	LongPrimitiveIterator items = dataModel.getItemIDs();
		LongPrimitiveIterator users = dataModel.getUserIDs();
		
		//Using arraylist to store itmes
		ArrayList<Long> iList = new ArrayList<>();
		while (items.hasNext())
		{
			iList.add(items.next());
		}
		
		//Using arraylist to store users
		ArrayList<Long> uList = new ArrayList<>();
		while (users.hasNext())
		{
			uList.add(users.next());
		}
		
		//sorting the lists
		Collections.sort(iList);
		Collections.sort(uList);

		
		for (int i = 0; i < 943; i++) 
		{
			for (int j = 0; j < 1682; j++) 
			{
				//getting the rating estimates for the 'i'th user and 'j'th itme
				checkValue(i + 1, j + 1, svd.estimatePreference(uList.get(i), iList.get(j)));
			}
				
		}
	
	}

	//function to insert predicted rating into the matrix
	//round off the floating point 
	private static void checkValue(int i, int j, float value) 
	{
		//check if the rating was already given
		//if not, insert the predicted rating into the result matrix
		if(matrix[i][j]==0)
		{
		
			int val;
			if(value <= 1.0)
			{
				val=1;
				matrix[i][j] = val;
			}
			else if(value>=5)
			{
				val=5;
				matrix[i][j] = val;
			}
			else
			{
				//rounding off the float
				int val1=Math.round(value);
				if(val1==0)
				{
					val=1;
					matrix[i][j] = val;
				}
				else
				{	
					matrix[i][j] = val1;
				}
			}
			
		}
	}
	
}

