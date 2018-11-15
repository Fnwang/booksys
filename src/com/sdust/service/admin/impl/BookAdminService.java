package com.sdust.service.admin.impl;

import com.sdust.dao.IBookDao;
import com.sdust.entity.Book;
import com.sdust.service.admin.IBookAdminService;
import com.sdust.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAdminService implements IBookAdminService{
    @Autowired
    private IBookDao bookDao;

    @Override
    public void add(Book book) {
        // TODO Auto-generated method stub
        if(book==null)
            throw new RuntimeException("ͼ����Ϣ����Ϊ��");
        if(book.getStock()<1)
            throw new RuntimeException("��������ȷ�Ŀ��");
        if(book.getPrice()<0)
            throw new RuntimeException("��������ȷ�ļ۸�");
        try {
            bookDao.add(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(Book book){
        if(book==null)
            throw new RuntimeException("ͼ����Ϣ����Ϊ��");
        if(StringUtil.isNullOrEmpty(book.getBookName()))
            throw new RuntimeException("��������Ϊ��");
        if(book.getPrice()<0)
            throw new RuntimeException("��������ȷ�ļ۸�");
        if(book.getStock()<1)
            throw new RuntimeException("��������ȷ�Ŀ��");
        if(StringUtil.isNullOrEmpty(book.getImg())||book.getImg()=="image/")
            throw new RuntimeException("�ļ��ϴ�����");
        try {
            bookDao.update(book);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Book findById(Integer id) {
        if(id<1)
            throw new RuntimeException("ͼ��id����");
        try {
            return bookDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(Integer id, boolean flag) {
        //�ж�ͼ���Ƿ����
        Book book;
        try {
            book=this.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        if(book==null)
            throw new RuntimeException("������idΪ"+id+"��ͼ��");

        if(flag){   //ɾ��ͼ��

            //�ж��Ƿ���ɾ��
            if(book.getIsDeleted()!=0)
                throw new RuntimeException("ͼ����ɾ��");


            //��ѯ������Ϣ
            int count=0;
            try {
                count=bookDao.countOrderByBookId(id);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }

            //�ж��Ƿ��й�����Ϣ��û����ɾ��
            if(count==0){
                try {
                    bookDao.delete(book);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            }else{
                throw new RuntimeException("�������й�����Ϣ������ɾ����Ӧ�������ٽ��в���");
            }

        }else{      //�ָ�ͼ��
            //�ж��Ƿ�δɾ��
            if(book.getIsDeleted()==0)
                throw new RuntimeException("ͼ��δɾ��");

            try {
                bookDao.restore(book);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }

    }

    @Override
    public List<Book> findByName(String name) {
        if(StringUtil.isNullOrEmpty(name))
            throw new RuntimeException("����������");
        List<Book> books;
        try {
            books=bookDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return books;
    }
}
