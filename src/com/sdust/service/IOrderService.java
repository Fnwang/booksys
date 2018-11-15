package com.sdust.service;

import com.sdust.entity.Order;
import com.sdust.entity.OrderItem;
import com.sdust.vo.PageBean;

import javax.servlet.http.HttpSession;

public interface IOrderService {
	//��Ӷ�����Ϣ
    Order addOrderInfo(String[] ids, String[] nums, Double price, String name);
	//��Ӷ�����ϸ
    void addOrderItems(String[] ids, String[] nums, Order order);
	//����ҳ���ѯ������ϸ(���������ݷ�ҳ)
    PageBean<OrderItem> findItemByIndex(String name, int page);
	//�ı䶩��״̬
	void changeState(Order order);
}
