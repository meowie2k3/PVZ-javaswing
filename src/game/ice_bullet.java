package game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/*ʵ�ֱ����ķ��к���ʧ������12.30
 */
public class ice_bullet {
	int x;
	int y;
	int state;//1fly 2disappear
	
	public ice_bullet() {
	}
	public ice_bullet(int x,int y) {
		this.x=x;this.y=y;
		fly();
	}
	private void fly() {
		state=1;
	}
	
	/*
	 * a�Ǽ���Ƿ�������ʬ
	 * ����������ʬ����ֵ����,ͬʱ�ڵ�������ʧ״̬
	 */
	private boolean a(zombie zb) {
	
		if(new Rectangle(x, y, 30, 30).intersects(zb.getx(), zb.gety(), 80, 100)) {
			SoundAndMusic a=new SoundAndMusic("music/peng.wav");
			a.playSound("music/peng.wav");
			return true;}
		return false;
	}
	
	private void flyimage(Graphics g) {
		Image tu = (new ImageIcon("Image/bullet/icebullet.png")).getImage();
		g.drawImage(tu, x+58, y+80, null);//����ͼƬAPI
	}
	
	private void flyaction(ArrayList<zombie> zbList) {
		x+=5;
		for(int x=0;x<zbList.size();x++) {
			if(a(zbList.get(x))) {
				zbList.get(x).sethealth(5);
				zbList.get(x).ice();
				clear();
				
			}
		}
		if (x>=800) {
			clear();
		}
	}
	private void clear() {
		state=2;
	}
	public void Action(ArrayList<zombie> zbList) {
		if(state==1) flyaction(zbList);
	}
	public void image(Graphics g){
		if(state==1) flyimage(g);
	}
}
