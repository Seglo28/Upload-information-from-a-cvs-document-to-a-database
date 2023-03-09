package com.practice.cvsmethods;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.practice.entities.Student_information;

public class CvsPrincipalValidations {
	
	CvsInternalValidations csvInternal = new CvsInternalValidations();
	
	public List<Student_information> fromCvsFileToSqlTable (MultipartFile document) throws IOException {
		String line = "";
		File file = new File ("c:/upload_java/"+document.getOriginalFilename());
		List<Student_information> student = new ArrayList<Student_information>();
		
		
		if(csvInternal.validatingCsvFile(document)) {
		}
		
		try(BufferedReader reader = new BufferedReader (new FileReader(file.getAbsolutePath()))){
		while((line = reader.readLine()) != null) {
			String[] row = line.split(";");
			int limit = (row.length);
			for(int i = 0; i<row.length; i=limit) {
				Student_information stud = newStudent(row);
				student.add(stud);					
			}	
		}
		reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		} 
		return student;
	}
	//--------------------------------------------------------------------------------------------
	
	//Getting an student information
	private static Student_information newStudent(String[] rowData) {
		String firts_name = rowData[0];
		String last_name = rowData[1];
		String email = rowData[2];
		String telephone = rowData[3];
		
		return new Student_information(0, firts_name, last_name, email, telephone);
	}
}
