package com.sdust.dao;

import java.util.List;
import java.util.Map;

import com.sdust.base.IBaseDao;
import com.sdust.entity.Book;

public interface IBookDao extends IBaseDao<Book>{
	
	//���з�ҳ��ѯ��������������¼
	//public List<Book> findByIndex(Integer index, Integer size);
	List<Book> findByIndex(Map<String, Object> pageInfo);           //��ʾ����ͼ��
	List<Book> findByIndex_front(Map<String, Object> pageInfo);     //ֻ��ʾδɾ����ͼ��
	
	// ������ص��鼮id���в�ѯ
	List<Book> findByIds(List<String> ids);
	
	//����id��ѯ���
	Integer findStockById(Integer id);

	//��һ����
	Book findById(Integer id);

	//����ͼ��id���Ҷ�������
	int countOrderByBookId(Integer id);

	//�ָ�ɾ��
	void restore(Book book);

	//����������
    List<Book> findByName(String bookName);

}
