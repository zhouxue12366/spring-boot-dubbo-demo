package com.softisland.demo.common.jfinal.filter;

public class UrlSkipHandler extends com.jfinal.ext.handler.UrlSkipHandler {

	public UrlSkipHandler(String skipedUrlRegx, boolean isCaseSensitive) {
		super("*", isCaseSensitive);
	}

}
