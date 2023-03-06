package com.practice.cvsmethods;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class CvsPrincipalValidations {
	
	CvsInternalValidations csvInternal = new CvsInternalValidations();
	
	public void validatingCsvFile(MultipartFile document) throws IOException{	
		if(csvInternal.validatingPosibleCvsDocument(document)) {
			if(csvInternal.removeBOM(document)){
			}
		}
	}
}
