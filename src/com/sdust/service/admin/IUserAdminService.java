package com.sdust.service.admin;

import com.sdust.entity.User;

import java.util.List;

public interface IUserAdminService {
    //ɾ���û�
    void delete(String name);

    //��ѯ�û�
    User findByName(String name);

    //�û�����
    void unlock(User user);

    //���������û�
    List<User> findAll();
}
