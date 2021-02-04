package com.boot.anilg.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	/**
	 * Static absolute path / constant path
	 * */
	//private final static String UPLOAD_DIR ="F:\\workspace\\springboot_DURGESH\\imageOrfile-uploading\\src\\main\\resources\\static\\images";
	
	/**
	 * Relative path/ Dynamic path it will take anywhere when project switches to other system
	 * */
	private final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
	}
	
	public boolean saveFile(MultipartFile file) {
		boolean isValid = false;
		
		try {
			System.out.println("File Original name : "+file.getOriginalFilename()+" \n file size : "+file.getSize()+" \n file type : "+file.getContentType());
/*			
			// read file 
			InputStream fileReader = file.getInputStream();
			// store into byte array with specified size and read it
			byte[] buffer = new byte[fileReader.available()];
			fileReader.read();
			
			// write file into target folder (relative path)
			OutputStream outStream = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
					outStream.write(buffer);
					outStream.flush();
					outStream.close();
					isValid = true;
*/
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			isValid = true;
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isValid;
	}

}
