package com.softisland.api.business.mostViewed;

import com.softisland.api.common.model.MostViewed;

public interface MostViewedService {
	
	public boolean update(MostViewed dao);
	
	public MostViewed findFirst(MostViewed dao);
}
