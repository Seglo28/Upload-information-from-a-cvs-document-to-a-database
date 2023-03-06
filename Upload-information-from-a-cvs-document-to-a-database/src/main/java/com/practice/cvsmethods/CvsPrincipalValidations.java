package com.practice.cvsmethods;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class CvsPrincipalValidations {
	
	CvsInternalValidations csvInternal = new CvsInternalValidations();
	
	public String validatingCsvFile(MultipartFile document) throws IOException{
		String result = "";
		//File file = new File("C:/upload_java/"+document.getOriginalFilename());
		System.out.println("estoy en el metodo Validating CVS file");
		if(csvInternal.validatingPosibleCvsDocument(document)) {
		}
			System.out.println("Estoy validando un posible cvs document ");
			if(csvInternal.removeBOM(document)){ //I added throws
				System.out.print("el documento se libero");
				result = "paso al metodo de eliminar";
			}else {
				System.out.print("No funciono.-");
				result = "no funciono el metodo eliminar";
			}
			return result;
		}
	
	public String imprimiendoAlgo (String palabra) {
		String salida = palabra;
		
		return salida;
	}
		
	}
