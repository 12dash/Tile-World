package Helper;
import java.io.*;

import java.util.*;

import Environment.*;


public class SaveCSV {
	
	//Used for appending at the end of the utility values FOR csv files.
	private static final char DEFAULT_SEPARATOR = ',';
	
		
	public static void writeLine(Writer w, List<String> values, Maze m , int i ) throws IOException 
	{
		writeLine(w, values, DEFAULT_SEPARATOR, ' ', m , i);
		
	}
	
	public static void writeLine(Writer w, List<String> values, char separators, char customQuote, Maze m, int iter) throws IOException 
	{
		boolean first = true;//to identify the first word in each row.

        if (separators == ' ') 
        {
        	//Separator for the utility values.
            separators = DEFAULT_SEPARATOR;
        }

       
        for(int j = 0;j<iter;j++) {
        	
        	StringBuilder sb = new StringBuilder();
        	
        	for(int i = 0;i<m.m*m.n+1;i++)
			{
	            if (!first) 
	            {
	                sb.append(separators);
	            }
	            
	            sb.append(values.get((m.m*m.n+1)*j+i));
	            
	            first = false;         
        	}
        	first = true;        
        	
        	sb.append("\n");//to mark the new line
            w.append(sb.toString());	//writing it to the file.

        }

    }
	
	
	public static void save_csv(List<String> s, Maze m , int i, String file_name) throws IOException
	{
		//Main entry point for the class
		String csvFile = file_name;
        FileWriter writer = new FileWriter(csvFile);
        writeLine(writer, s, m , i);
	}
	
	public static void save_list(Maze m, List<String> s, int iteration)
	{
		//Used to store the utilites of the maze after each iteration.
		String array[] = get_array(m,iteration);
		
		for(int i =0;i<array.length;i++)
		{
			s.add(array[i]);
		}			
				
	}
	
	private static String[] get_array(Maze m, int n_i)
	{
		//Get the utility of each state and store it in an array
		String s[]= new String[m.m*m.n+1];
		s[0] = String.valueOf(n_i);
		
		int k = 1;
		
		for(int i = 0;i<m.m;i++)
		{
			for(int j =0 ;j<m.n;j++)
			{
				s[k++] = String.valueOf(m.maze[i][j].get_utility());
			}
				
		}
		
		return s;
	}
	
	
	public static void print_list(Maze m, List<String> s, double iteration) {
		//Method to print the list storing the iteration and the values of each state
		for(int j = 0;j<iteration;j++) {
			//System.out.println(j);

			for(int i = 0;i<m.m*m.n+1;i++)
			{
				System.out.print(s.get((m.m*m.n+1)*j+i)+",");
			}
			System.out.println("");
		}	
	}
}
