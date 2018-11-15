package com.sdust.service.admin;

import com.sdust.entity.OrderItem;
import com.sdust.vo.PageBean;

import java.util.List;

public interface IOrderAdminService {
    //��ѯ������ϸ
    PageBean<OrderItem> findItemByIndex(String name, int page, int state);

    //�������Ų�ѯ������ϸ��������
    List<OrderItem> findByNum(String orderNum);

    //��������ɾ���������漰������������á�
    void deleteByNum(String orderNum);
}
