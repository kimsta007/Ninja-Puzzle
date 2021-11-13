/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ninjase.model;


/**
 *
 * @author proak
 */
public class Ninja {
    	int x;
	int y;
        int w;
        int h;
        String imgUrl = getClass().getResource("/ninjase/ninja.png").getPath().substring(6);
        
	public Ninja(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
                this.w = w;
                this.h = h;
                System.out.println(imgUrl);
        }
        
        public int[] values(){
            int[] ninjaData = {this.x, this.y, this.w, this.h};
            return ninjaData;
        }
        
        public String getNinjaUrl(){
            return this.imgUrl;
        }
        
        public void setPos(int x, int y, int w, int h){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }        
}
