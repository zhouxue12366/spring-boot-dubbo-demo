package com.softisland.api.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseMostViewed<M extends BaseMostViewed<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setOldId(java.lang.String oldId) {
		set("old_id", oldId);
		return (M)this;
	}
	
	public java.lang.String getOldId() {
		return getStr("old_id");
	}

	public M setName(java.lang.String name) {
		set("name", name);
		return (M)this;
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public M setImgSrc(java.lang.String imgSrc) {
		set("img_src", imgSrc);
		return (M)this;
	}
	
	public java.lang.String getImgSrc() {
		return getStr("img_src");
	}

	public M setHtmlUrl(java.lang.String htmlUrl) {
		set("html_url", htmlUrl);
		return (M)this;
	}
	
	public java.lang.String getHtmlUrl() {
		return getStr("html_url");
	}

	public M setPlayImgSrc(java.lang.String playImgSrc) {
		set("play_img_src", playImgSrc);
		return (M)this;
	}
	
	public java.lang.String getPlayImgSrc() {
		return getStr("play_img_src");
	}

	public M setPlayUrl(java.lang.String playUrl) {
		set("play_url", playUrl);
		return (M)this;
	}
	
	public java.lang.String getPlayUrl() {
		return getStr("play_url");
	}

	public M setTagImg(java.lang.String tagImg) {
		set("tag_img", tagImg);
		return (M)this;
	}
	
	public java.lang.String getTagImg() {
		return getStr("tag_img");
	}

	public M setTagVideo(java.lang.String tagVideo) {
		set("tag_video", tagVideo);
		return (M)this;
	}
	
	public java.lang.String getTagVideo() {
		return getStr("tag_video");
	}

}
