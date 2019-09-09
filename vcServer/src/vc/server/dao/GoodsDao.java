package vc.server.dao;

import java.util.List;


import vc.list.common.Goods;

public interface GoodsDao {

	Goods QueryName(Goods gd);//通过商品名称查询
	Goods QueryID(Goods gd);//通过商品货号查询
	
	List<Goods> getAllGoods();//返回所有商品
	
	boolean InsertGoods(Goods goods);//添加商品
	boolean DeleteGoods(Goods goods);//删除商品
	boolean UpdateGoodes(Goods goods);//修改价格
	boolean UpdateRepertory(Goods goods);
}
