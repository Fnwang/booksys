package com.sdust.service;

import com.sdust.entity.Book;
import com.sdust.vo.PageBean;

public interface IBookService {
	//����ҳ����з�ҳ��ѯ���ж�������Դǰ̨or��̨
	public PageBean<Book> findByPage(Integer page, String judge);
}
