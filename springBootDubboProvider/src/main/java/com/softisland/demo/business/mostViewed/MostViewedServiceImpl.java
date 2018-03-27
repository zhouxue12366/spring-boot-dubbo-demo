package com.softisland.demo.business.mostViewed;

import com.alibaba.dubbo.config.annotation.Service;
import com.softisland.api.business.mostViewed.MostViewedService;
import com.softisland.api.common.model.MostViewed;

@Service
public class MostViewedServiceImpl implements MostViewedService{

	@Override
	public boolean update(MostViewed dao) {
		return dao.update();
//		Record record =new Record();
//		record.set("play_img_src", dao.getPlayImgSrc());
//		record.set("play_url", dao.getPlayUrl());
//		record.set("id", dao.getId());
//		return Db.update("most_viewed", record);
	}
	
	@Override
	public MostViewed findFirst(MostViewed dao){
		dao = dao.findFirst(" select * from most_viewed where old_id = ?",dao.getOldId());
//		Record record = Db.findFirst(" select * from most_viewed where old_id = ?",dao.getOldId());
//		int id = record.get("id");
//		dao.setId(id);
		return dao;
	}

}
