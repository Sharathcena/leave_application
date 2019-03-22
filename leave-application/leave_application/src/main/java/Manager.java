

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

public class Manager {

	static ClassLoader classLoader = new Manager().getClass().getClassLoader();
	
	static File file = new File(classLoader.getResource("file.csv").getFile());
    
    static CSVReader csvReader;
    static CSVWriter csvWriter;
    
    static LeaveRequest leaveRequest;
    
    public static boolean validateEmp(int empNo) throws IOException
    {
    	csvReader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build();
    	
    	List<String[]> allData = csvReader.readAll(); 
    	
    	for (String[] row : allData) { 
            for (String cell : row) { 
                if(cell.contains(String.valueOf(empNo)))
                	return true;
                else 
                	return false;
            } 
            System.out.println(); 
        } 
    	
    	return false;
    }
	
	public static String checkLeaves(int empNo) throws FileNotFoundException
	{
    	csvReader = new CSVReader(new FileReader(file)); 
    	
		return "";
	}
	
	
	public static void update() throws IOException
	{
        try {
			FileWriter fileWriter = new FileWriter(file,true);
			
			leaveRequest = new LeaveRequest();
  
			fileWriter.append(String.valueOf(leaveRequest.getRequestId()));
			fileWriter.append(",");
			fileWriter.append(leaveRequest.getReason());
			fileWriter.append("\n");
			System.out.println("Leave applied");
			
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
