package com.xit.service;

import java.util.List;

import com.xit.pojo.Notice;

public interface NoticeService {
	public List<Notice> findNotice();
	public List<Notice> findNoticeByCondition(Integer id,String title,Integer pageNo,Integer pageSize);
	public int findNoticeCountByCondition(Integer id,String title);
	public int addNotice(Notice notice);
	public int removeNoticeById(Integer id);
	public int modifyNoticle(Notice notice);
	public Notice findNoticeById(Integer id);
}
