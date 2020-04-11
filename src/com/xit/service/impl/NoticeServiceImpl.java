package com.xit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xit.dao.NoticeDao;
import com.xit.pojo.Notice;
@Service(value="noticeService")
public class NoticeServiceImpl implements com.xit.service.NoticeService {
	@Resource(name="noticeDao")
	private NoticeDao noticeDao;
	@Override
	public List<Notice> findNotice() {
		// TODO Auto-generated method stub
		return noticeDao.selectNotice();
	}
	@Override
	public List<Notice> findNoticeByCondition(Integer id, String title, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Integer page = (pageNo-1)*pageSize;
		return noticeDao.selectNoticeByCondition(id, title, page, pageSize);
	}
	@Override
	public int findNoticeCountByCondition(Integer id, String title) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeCountByCondition(id, title);
	}
	@Override
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.insertNotice(notice);
	}
	@Override
	public int removeNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return noticeDao.deleteNoticeById(id);
	}
	@Override
	public int modifyNoticle(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.updateNoticle(notice);
	}
	@Override
	public Notice findNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeById(id);
	}

}
