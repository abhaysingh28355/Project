package Blog_App_API.Service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Blog_App_API.Service.FileService;
@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadimage(String path, MultipartFile file) throws IOException {
		
		//File Name
		String File = file.getOriginalFilename();
		//abc.png
		
		
		//Randam name generate file
		String randomID = UUID.randomUUID().toString();
		String concat = randomID.concat(File.substring(File.lastIndexOf(".")));
		String fullPath=path + File.isEmpty() +concat;
		File f = new File(path);
		if(!f.exists()) {
		f.mkdir();
		}
	
		//Files Copy
		Files.copy(file.getInputStream(), Paths.get(fullPath));
		return concat;
	}

	@SuppressWarnings("resource")
	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath=path + File.separator +fileName;
		InputStream Is=new FileInputStream(fullPath);
		return Is;
	}

}
