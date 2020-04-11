package com.xit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xit.pojo.Notice;

public interface NoticeDao {
	public List<Notice> selectNotice();
	public List<Notice> selectNoticeByCondition(@Param("id")Integer id,@Param("title")String title,@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
	public int selectNoticeCountByCondition(@Param("id")Integer id,@Param("title")String title);
	public int insertNotice(Notice notice);
	public int deleteNoticeById(@Param("id")Integer id);
	public int updateNoticle(Notice notice);
	public Notice selectNoticeById(@Param("id")Integer id);
}
