package vc.list.common;

public class Goods implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 295381941618981977L;
	
	private String GoodsID;//key ���ţ������»���ʱ���Զ���������
	private String GoodsName;//��������
	private double GoodsPrice;//����۸�
	
	
	


	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(String goodsID, String goodsName, double goodsPrice) {
		super();
		GoodsID = goodsID;
		GoodsName = goodsName;
		GoodsPrice = goodsPrice;
	}

	public String getGoodsID() {
		return GoodsID;
	}
	
	public void setGoodsID(String goodsID) {
		GoodsID = goodsID;
	}
	
	public String getGoodsName() {
		return GoodsName;
	}
	
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	
	public double getGoodsPrice() {
		return GoodsPrice;
	}
	
	public void setGoodsPrice(double goodsPrice) {
		GoodsPrice = goodsPrice;
	}

	@Override
	public String toString() {
		return "Goods [GoodsID=" + GoodsID + ", GoodsName=" + GoodsName + ", GoodsPrice=" + GoodsPrice + "]";
	}
	
	
}
