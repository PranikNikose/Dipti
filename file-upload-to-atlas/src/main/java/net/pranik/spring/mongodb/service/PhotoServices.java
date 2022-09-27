package net.pranik.spring.mongodb.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.pranik.spring.mongodb.modelss.PhotoModel;
import net.pranik.spring.mongodb.repositoires.PhotoRepositirys;

@Service
public class PhotoServices {

	@Autowired
	private PhotoRepositirys photoRepo;

	public String addPhoto(MultipartFile file) throws IOException {
		PhotoModel photo = new PhotoModel(file.getOriginalFilename());
		photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		photo = photoRepo.insert(photo);
		return photo.getId();
	}

	public PhotoModel getPhoto(String id) {
		return photoRepo.findById(id).get();
	}

}
