package com.naseeha.filereading;
import java.io.*;
import java.util.ArrayList;

public class FileReadWrite {
    
	public static void main(String [] args) {
        String fileName = "news.txt";
        String OutputfileName = "news2.txt";
        String line = null;
        FileWriter filewriter = null;
        PrintWriter printwriter = null;
        FileReading bufferedReader = null;
        FileReader fileReader = null;

        try {
             fileReader = new FileReader(fileName);
             bufferedReader = new FileReading(fileReader);
             filewriter = new FileWriter(OutputfileName);
             printwriter = new PrintWriter(filewriter);
            
           
            while((line = bufferedReader.readLine()) != null) {
               // System.out.println(line);
                printwriter.write(line);
            }   
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'"); 
          //  ex.printStackTrace();
        }finally{
        	if(filewriter != null){
        		try {
					filewriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(printwriter != null){
        		printwriter.close();
        	}

            try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 

        }
    }
}
