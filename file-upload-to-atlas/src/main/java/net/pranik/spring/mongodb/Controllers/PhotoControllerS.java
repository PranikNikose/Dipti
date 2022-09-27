package net.pranik.spring.mongodb.Controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.pranik.spring.mongodb.modelss.PhotoModel;
import net.pranik.spring.mongodb.service.PhotoServices;

@RestController
public class PhotoControllerS {
	@Autowired
	public PhotoServices photoServ;

	@PostMapping("/AddPhoto")
	public String AddPhotoToDB(@RequestParam("image") MultipartFile image) throws IOException {
		String id = photoServ.addPhoto(image);
		System.out.println("Called AddPhotoToDB: " + id);
		return "/GetPhoto/" + id; // HTML

	}

	@GetMapping("/GetPhoto/{id}")
	public byte [] GetPhotoFromDB(@PathVariable String id, Model model) throws IOException {
		System.out.println("Called GetPhotoFromDB");
		
		PhotoModel photo = photoServ.getPhoto(id);
		model.addAttribute("title", photo.getTitle());
		model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
		
		String EncodedStringData = Base64.getEncoder().encodeToString(photo.getImage().getData());
		FileOutputStream stream = new FileOutputStream(new File("output.png"));
		stream.write(Base64.getDecoder().decode(EncodedStringData));
		byte [] arrimage = Base64.getDecoder().decode(EncodedStringData);
		return arrimage; // HTML
	}

}
