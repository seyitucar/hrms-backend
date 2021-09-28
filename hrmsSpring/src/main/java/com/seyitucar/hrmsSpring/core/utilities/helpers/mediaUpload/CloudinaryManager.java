package com.seyitucar.hrmsSpring.core.utilities.helpers.mediaUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.ErrorDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {
	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<?> upload(MultipartFile file) {
		try {		
			Map<?,?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<>(uploadResult);

		} catch (IOException e) {
			e.printStackTrace();
		}	
		return new ErrorDataResult<>();
	}
	
	@Override
	public DataResult<?> delete(String publicIdOfImage) {
		
		List<String> publicIdsOfImages = new ArrayList<String>();
		publicIdsOfImages.add(publicIdOfImage);
		
		try {			
			Map<?, ?> deleteResult = cloudinary.api().deleteResources(publicIdsOfImages, ObjectUtils.emptyMap());
			return new SuccessDataResult<>(deleteResult);
		} catch (Throwable e) {
			e.printStackTrace();
			return new ErrorDataResult<>();
		}
	}
	
}
