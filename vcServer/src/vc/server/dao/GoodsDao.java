package vc.server.dao;

import java.util.List;


import vc.list.common.Goods;

public interface GoodsDao {

	Goods QueryName(String str);//ͨ����Ʒ���Ʋ�ѯ
	Goods QueryID(String str);//ͨ����Ʒ���Ų�ѯ
	
	List<Goods> getAllGoods();//����������Ʒ
	
	boolean InsertGoods(Goods goods);//�����Ʒ
	boolean DeleteGoods(Goods goods);//ɾ����Ʒ
	boolean UpdateGoodes(Goods goods);//�޸ļ۸�
}
