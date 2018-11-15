package com.sdust.dao;

import java.util.List;
import java.util.Map;

import com.sdust.base.IBaseDao;
import com.sdust.entity.OrderItem;

public interface IOrderItemDao extends IBaseDao<OrderItem> {
	//��������ѯ������ϸ�������
    List<OrderItem> findByIndex(Map<String, Object> info);
    List<OrderItem> findByIndex0(Map<String, Object> info);
    List<OrderItem> findByIndex1(Map<String, Object> info);
    List<OrderItem> findByIndex2(Map<String, Object> info);
    List<OrderItem> findByIndex3(Map<String, Object> info);
    List<OrderItem> findByIndex4(Map<String, Object> info);

    //�������Ų�ѯ������ϸ��������
    List<OrderItem> findByName(String orderNum);
}
