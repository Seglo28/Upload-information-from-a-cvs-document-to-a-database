package com.practice.cvsmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Hex;
import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

public class CvsInternalValidations {

	private boolean validatingPosibleCvsDocument(MultipartFile document) {
		
		System.out.println("estoy en el metodo POSIBLE");
		boolean isOk = false;
		File file = new File ("c:/upload_java/"+document.getOriginalFilename());
		Tika tika = new Tika();
		
		try {
			String mimeType = tika.detect(document.getOriginalFilename());
			isOk = ("text/csv".equals(mimeType));
				FileOutputStream convert = new FileOutputStream(file);
				file.createNewFile();
				convert.write(document.getBytes());
				convert.close();
			}catch (IOException e) {
	            e.printStackTrace(); 
	            isOk = false;
	            }
			return isOk;
			}
	
	 private boolean isBoom(File file) {
		 boolean isOk = false;
		 if(!file.exists()) {
			 System.out.println("METODO IS BOOM? " + "El archivo no existe");
			 return false;
		 }
		 
		 byte[] BOM = new byte[3];
		 
		 try (FileInputStream input = new FileInputStream(file)) {
			 input.read(BOM);
			 input.close();
			 
			 
			 String content = new String(Hex.encodeHex(BOM));
			 System.out.println(file.getName()+ " hex "+content);
	          if ("efbbbf".equalsIgnoreCase(content)) {
	              isOk = true;
	          } else {
	        	  isOk = false;
	          }
	          System.out.println("METODO IS BOOM? " +"isOK "+ isOk);
			 System.out.println("METODO IS BOOM? " +"el valor de bom es: " + BOM.toString());
			 
			 
		 } catch (Exception e) {
			 System.out.println("METODO IS BOOM? " +"a ocurrido un error " + BOM);
			 isOk = false;
		}
		 return isOk;
	 }
	 
	 private static final String UTF8_BOM = "\uFEFF";
	 private boolean BOMinside(MultipartFile document) throws IOException {
			
		 boolean isOk = false;
		 File inputFile = new File ("c:/upload_java/"+document.getOriginalFilename());
		 
		 this.isBoom(inputFile);
				return this.isBoom(inputFile);
	    }
	 
	 private boolean removeBOM (MultipartFile document) throws IOException {
		 Path path = Paths.get("c:/upload_java/"+document.getOriginalFilename());
		 
		 if(this.BOMinside(document)) {
			 byte[] bytes = Files.readAllBytes(path);
			 
			 ByteBuffer bb = ByteBuffer.wrap(bytes);
			 
			 byte[] bom = new byte[3];
			 
			 bb.get(bom, 0, bom.length);
			 
			 byte[] contentAfterFirst3Bytes = new byte[bytes.length - 3];
	          bb.get(contentAfterFirst3Bytes, 0, contentAfterFirst3Bytes.length);
	          
	          //Write is a static method
	          Files.write(path, contentAfterFirst3Bytes);
		 }
		return false;
	 }
	 
	 
	 public boolean validatingCsvFile(MultipartFile document) throws IOException{	
			if(this.validatingPosibleCvsDocument(document)) {
				if(this.removeBOM(document)){
				}
			}
			return false;
		}
}
