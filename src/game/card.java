package game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
/*
 * ������ʾ�̵���Ŀ�Ƭ��12.30���壬·����δ����
 */
public class card {
	int canbuyornot;//0can 1can't
	int cardnumber;
	String cardname;
	
	public card(int number,String name) {
		this.cardname=name;
		this.cardnumber=number;
		canbuyornot=0;
	}
	
	/*
	 * ��һ��������ʾ���Թ���Ŀ�Ƭ���ڶ���������ʾ���ܹ���Ŀ�Ƭ
	 */
	public void showinshop_canbuy(Graphics g) {
		Image canbuy_card=(new ImageIcon("Image/card/"+cardname+"0.png")).getImage();

		g.drawImage(canbuy_card,95+54*cardnumber,8,null);
	}
	
	
	public void showinshop_cannotbuy(Graphics g) {
		Image canbuy_card=(new ImageIcon("Image/card/"+cardname+"1.png")).getImage();

		g.drawImage(canbuy_card,95+54*cardnumber,8,null);
		
	
	}
	
	public boolean if_pressed(int mbx,int mby) {
		if (new Rectangle(95+54*cardnumber,8,50,70).contains(mbx,mby)) {
			return true;
		}
		return false;
	}

}
