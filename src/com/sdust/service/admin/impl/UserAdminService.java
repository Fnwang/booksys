package com.sdust.service.admin.impl;

import com.sdust.dao.IUserDao;
import com.sdust.entity.User;
import com.sdust.service.admin.IUserAdminService;
import com.sdust.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdminService implements IUserAdminService {
    @Autowired
    private IUserDao userDao;

    @Override
    public void delete(String name) {
        //�����û��Ƿ����
        User user;
        try {
            user=this.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        //��ѯ������Ϣ
        int count=0;
        try {
            count=userDao.countOrderByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        //ɾ���û�
        if(count==0){
            try {
                userDao.delete(user);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }else {
            throw new RuntimeException("����ɾ�����û��µĶ�����Ϣ�ٽ��в���");
        }


    }

    @Override
    public User findByName(String name) {
        if(StringUtil.isNullOrEmpty(name))
            throw new RuntimeException("�û���Ϊ��");
        User user;
        try {
            user=userDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        if(user==null)
            throw new RuntimeException("�û�������");
        return user;
    }

    @Override
    public void unlock(User user) {
        if(user.getIsLocked()==1)
            user.setIsLocked(0);
        else
            throw new RuntimeException("�û�״̬����");

        try {
            userDao.changeLockState(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users;
        try {
            users=userDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return users;
    }
}
