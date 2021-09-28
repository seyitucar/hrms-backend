package com.seyitucar.hrmsSpring.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seyitucar.hrmsSpring.business.abstracts.SocialMediaService;
import com.seyitucar.hrmsSpring.core.utilities.results.DataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.Result;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessDataResult;
import com.seyitucar.hrmsSpring.core.utilities.results.SuccessResult;
import com.seyitucar.hrmsSpring.dataAccess.abstracts.SocialMediaDao;
import com.seyitucar.hrmsSpring.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("Sosyal Medya Alanı Eklendi");
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findAll());
	}

	@Override
	public Result update(SocialMedia socialMedia) {
		
		SocialMedia updSocialMedia = this.socialMediaDao.getById(socialMedia.getId());
		
		updSocialMedia.setSocialMediaName(socialMedia.getSocialMediaName());
		this.socialMediaDao.save(updSocialMedia);
		return new SuccessResult("Sosyal medya ismi güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.socialMediaDao.deleteById(id);
		return new SuccessResult("Sosyal medya bilgisi silindi");
	}

	@Override
	public DataResult<SocialMedia> getById(int id) {
		return new SuccessDataResult<SocialMedia>(this.socialMediaDao.findById(id).orElse(null));
	}

}
