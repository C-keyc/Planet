package vc.server.dao;

import java.util.List;


import vc.list.common.Goods;

public interface GoodsDao {

	Goods QueryName(Goods gd);//ͨ����Ʒ���Ʋ�ѯ
	Goods QueryID(Goods gd);//ͨ����Ʒ���Ų�ѯ
	
	List<Goods> getAllGoods();//����������Ʒ
	
	boolean InsertGoods(Goods goods);//�����Ʒ
	boolean DeleteGoods(Goods goods);//ɾ����Ʒ
	boolean UpdateGoodes(Goods goods);//�޸ļ۸�
	boolean UpdateRepertory(Goods goods);
}
