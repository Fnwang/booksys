package com.sdust.dao;

import com.sdust.base.IBaseDao;
import com.sdust.entity.User;

public interface IUserDao extends IBaseDao<User>{
	
	//�����û�����ѯ�û���Ϣ
    User findByName(String name);

	//�����ͽ���
	void changeLockState(User user);

	//�����û������Ҷ�������
    int countOrderByName(String name);
}
