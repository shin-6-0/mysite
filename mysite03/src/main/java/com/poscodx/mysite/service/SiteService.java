package com.poscodx.mysite.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.SiteRepository;
import com.poscodx.mysite.vo.SiteVo;

@Service
public class SiteService {
	
	@Autowired
	private SiteRepository siteRepository;

	public SiteVo find() {
		return siteRepository.find();
	}
	
	public boolean UpdateSite(SiteVo vo) {
		return siteRepository.update(vo);
	}

} 