package game.ourmaze;




import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;
import android.text.format.Time;

public class Init {

	
	/*--------------------------------paint------------------------------------------*/
	public static void paint_maze(int a,int b){/*
		
		int i,j,ii,jj;
		if(Data.place_y<Data.up_y) j=(Data.up_y-Data.place_y)/Data.unit_l+1;
		else j=1;
		j=0;
		if(Data.place_x+Data.maze_l>Data.area_x) ii=(Data.area_x-Data.place_x)/Data.unit_l;
		else ii=2*a+1;
		if(Data.place_y+Data.maze_h>Data.area_y) jj=(Data.area_y-Data.place_y)/Data.unit_l;
		else jj=2*b+1;
		for(;j<=jj+Data.scr_height/30;j++){
			if(Data.place_x<Data.left_x) i=(Data.left_x-Data.place_x)/Data.unit_l+1;
		    else i=1;
			i=0;
			for(;i<=ii+Data.scr_width/30;i++){
				// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
				if(Data.fog[i][j]==0){ Data.paint.setColor(Color.WHITE);bar(Data.unit_l*(i-1)+Data.place_x+Data.move_x,Data.unit_l*(j-1)+Data.place_y,Data.unit_l*i+Data.place_x+Data.move_x,Data.unit_l*j+Data.place_y);}
				// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
				// 锟斤拷
				if(Data.fog[i][j]==1 && Data.maze[i][j]==0) {Data.paint.setColor(Color.RED);bar(Data.unit_l*(i-1)+Data.place_x+Data.move_x,Data.unit_l*(j-1)+Data.place_y,Data.unit_l*i+Data.place_x+Data.move_x,Data.unit_l*j+Data.place_y);}
				// 锟斤拷
				if(Data.fog[i][j]==1 && Data.maze[i][j]==1) {Data.paint.setColor(Color.GREEN);bar(Data.unit_l*(i-1)+Data.place_x+Data.move_x,Data.unit_l*(j-1)+Data.place_y,Data.unit_l*i+Data.place_x+Data.move_x,Data.unit_l*j+Data.place_y);}
				//if(vst[i][j]) setfillstyle(GREEN),bar(unit_l*(i-1)+place_x,unit_l*(j-1)+place_y,unit_l*i+place_x,unit_l*j+place_y);
				// 锟斤拷锟斤拷
				if(Data.fog[i][j]==1 && Data.maze[i][j]==3) {Data.paint.setColor(Color.LTGRAY);bar(Data.unit_l*(i-1)+Data.place_x+Data.move_x,Data.unit_l*(j-1)+Data.place_y,Data.unit_l*i+Data.place_x+Data.move_x,Data.unit_l*j+Data.place_y);}
				// 锟斤拷锟斤拷
				if(Data.fog[i][j]==1 && Data.maze[i][j]==4) {Data.paint.setColor(Color.BLUE);bar(Data.unit_l*(i-1)+Data.place_x+Data.move_x,Data.unit_l*(j-1)+Data.place_y,Data.unit_l*i+Data.place_x+Data.move_x,Data.unit_l*j+Data.place_y);}
				// 锟斤拷锟斤拷
				//if(fog[i][j]==1 && mon[i][j]>=0){paint.setColor(Color.WHITE);bar(unit_l*(i-1)+place_x,unit_l*(j-1)+place_y,unit_l*i+place_x,unit_l*j+place_y);}
			}
		}
	*/}
	// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	public static int paint_man(int _direct,boolean _motion){   // 锟斤拷锟斤拷
		// draw man
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷yellow锟斤拷
		Data.paint.setColor(Color.YELLOW);
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		RectF rf2 = new RectF(Data.unit_l*(ManClass.man.x-1)+Data.place_x, Data.unit_l*(ManClass.man.y-1)+Data.place_y,Data.unit_l*(ManClass.man.x)+Data.place_x,Data.unit_l*(ManClass.man.y)+Data.place_y);
		//锟斤拷锟斤拷
		Data.drawcanvas.drawOval(rf2, Data.paint);
		if(_motion){
			switch (_direct){}
		}else{
		    switch (_direct){}
		}
	//	Data.paint.setColor(Color.BLACK);
	//	bar(0,0,Data.move_x,Data.scr_height);
		return 1;
	}
/*	public static void repaint(int _maze_x,int _maze_y,int _direct,boolean _motion){
		// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		while((Data.place_x+Data.unit_l*(ManClass.man.x+1))>Data.area_x){
			if(((Data.place_x+Data.unit_l*(ManClass.man.x+1))-Data.area_x)>=100) Data.place_x-=100;
			else Data.place_x-=(Data.place_x+Data.unit_l*(ManClass.man.x+1))-Data.area_x;
		}
		// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		while((Data.place_y+Data.unit_l*(ManClass.man.y+1))>Data.area_y){
			if(((Data.place_y+Data.unit_l*(ManClass.man.y+1))-Data.area_y)>=100) Data.place_y-=100;
			else Data.place_y-=(Data.place_y+Data.unit_l*(ManClass.man.y+1))-Data.area_y;
		}
		// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		while(Data.place_x+Data.unit_l*(ManClass.man.x-2)<Data.left_x) Data.place_x+=Data.unit_l;
		if(Data.place_x>Data.left_x) Data.place_x=Data.left_x;
		// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		while(Data.place_y+Data.unit_l*(ManClass.man.y-2)<Data.up_y) Data.place_y+=Data.unit_l;
		if(Data.place_y>Data.up_y) Data.place_y=Data.up_y;
		// 锟斤拷锟斤拷锟斤拷
		//paint_back();
		// 锟斤拷锟斤拷锟斤拷
		//paint_menu();
		// 锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷
		paint_maze(_maze_x,_maze_y); 
		paint_man(_direct,_motion);
		// 锟斤拷锟斤拷锟斤拷
		//paint_property();  // after paint_menu
		// 锟斤拷锟斤拷锟斤拷
		//paint_init_tools();
		//锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷
		//if(man.x==maze_start[man.level][0] && man.y==maze_start[man.level][1]) putimage(maze_side*(man.x-1)+place_x,maze_side*(man.y-1)+place_y,&start,SRCAND);
	    //if(man.x==maze_end[man.level][0] && man.y==maze_end[man.level][1]) putimage(maze_side*(man.x-1)+place_x,maze_side*(man.y-1)+place_y,&door,SRCAND);
		// 锟斤拷锟斤拷锟斤拷
		//paint_shop();
		
	}	*/
	/*---------------------- plugin-------------------------*/
	public static void bar(int _left,int _top,int _right,int _bottom){
		Data.paint.setAlpha(150); 
		Data.drawcanvas.drawRect(_left,_top,_right,_bottom, Data.paint);
		/*Data.paint.setAlpha(1); 
		for(int y=_top;y<_bottom;y++)
		for(int x=_left;x<_right;x++)
		Data.drawcanvas.drawPoint(x, y, Data.paint);*/
	}
	
	public static void bar(int _left,int _top,int _right,int _bottom,int deep){
		Data.paint.setAlpha(deep); 
		Data.drawcanvas.drawRect(_left,_top,_right,_bottom, Data.paint);
		/*Data.paint.setAlpha(1); 
		for(int y=_top;y<_bottom;y++)
		for(int x=_left;x<_right;x++)
		Data.drawcanvas.drawPoint(x, y, Data.paint);*/
	}
	public static int max(int _a,int _b){
	    if(_a>_b) return _a;
	    return _b;
	}
	public static int aa=0;
	public static Random random = new Random(System.currentTimeMillis());
	public static int createRandom(int min, int max) {
		
		aa++;
		return random.nextInt(max-min+1)+ min;
		
	}
	public static void disfog(int x,int y,int view){
		int half_view=view/2;
		for(int j=y-half_view;j<=y+half_view;j++)
			for(int i=x-half_view;i<=x+half_view;i++)
				if(i>=0 && j>=0 && x<=2*Data.maze_a+1 && y<=2*Data.maze_b+1)
					Data.fog[i][j]=1;
	}
	
	
	
	
	// 放置小怪算法
		public static void putmon(int nmon){    //*
			for(int i=0;i<Data.maxmaze;i++){
				for(int j=0;j<Data.maxmaze;j++){
					Data.mon[i][j]=-1;
				}
			} 
			
			for(int i=0;i<nmon;){
				int x=createRandom(1,Data.maze_a),y=createRandom(1,Data.maze_b);
				if(Data.mon[x][y]==-1 && Data.maze[x][y]==1&&(x!=ManClass.man.x&&y!=ManClass.man.y)){
					Data.mon[x][y]=i; 
					
					MonsterClass.Monster mon_t=new MonsterClass.Monster(x,y,i);
					MonsterClass.monster[i]=mon_t;
					i++;
				}
			}
			/*for(int i=0;i<nmon;){
				int x=createRandom(1,Data.maze_a),y=createRandom(1,Data.maze_b);
				if(Data.mon[x][y]==-1 && Data.maze[2*x][2*y]==1){
					Data.mon[2*x][2*y]=i+nmon; 
					Monster mon_t2=new Monster(2*x,2*y,i+nmon);
					MonsterClass.monster[i+nmon]=mon_t2;
					i++;
				}
			}*/
		}
	/*----------------------------------maze------------------------------------*/
	// _maze:save the maze data a:leight of maze scale b:height of maze scale
	// return锟斤拷_maze锟斤拷锟斤拷锟斤拷(2*a+1,2*b+1)锟斤拷锟斤拷锟斤拷锟斤拷surrounded by wall
	// define锟斤拷 WALL锟斤拷0  ROAD锟斤拷1
	// 锟斤拷锟斤拷 (锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷)
	public static void dfs(int [][] _maze,int x,int y){
		int px=2*x,py=2*y; int turn;
		int tran=createRandom(0,1);
		_maze[px][py]=1;  
		if(tran==1) turn=1; else turn=3;
		for(int i=0,dfs_next=createRandom(0,3);i<4;i++,dfs_next=(dfs_next+turn)%4){
			if(_maze[px+2*Data.drct[dfs_next][0]][py+2*Data.drct[dfs_next][1]]==0){
				_maze[px+Data.drct[dfs_next][0]][py+Data.drct[dfs_next][1]]=1;
				dfs(_maze,x+Data.drct[dfs_next][0],y+Data.drct[dfs_next][1]);
			}
		}
	}
	public static void make_maze(int [][] _maze,int a,int b){
		_maze[0][0]=0;
		for(int i=0;i<=2*a+2;i++) _maze[i][0]=_maze[i][2*b+2]=1;
		for(int i=0;i<=2*b+2;i++) _maze[0][i]=_maze[2*a+2][i]=1;
		for(int j=1;j<=2*b+1;j++)
			for(int i=1;i<=2*a+1;i++)
				_maze[i][j]=0;
		//srand((unsigned)time(NULL));
		dfs(_maze,createRandom(1,a),createRandom(1,b));
	}
	/*--------------------------------init---------------------------------------*/
	public static  void init_data(){
		
		Data.maze_a=Data.maze_size[ManClass.man.level][0];
		Data.maze_b=Data.maze_size[ManClass.man.level][1];
		Data.maze_l=Data.maze_a*Data.unit_l;
		Data.maze_h=Data.maze_b*Data.unit_l;
		ManClass.man.x=Data.maze_start[ManClass.man.level][0];
		ManClass.man.y=Data.maze_start[ManClass.man.level][1];
		
		
		make_maze(Data.maze,Data.maze_a/2,Data.maze_b/2);
		
		// 
		Data.unit_l=Data.area_y/max(Data.maze_a,Data.maze_b);
		//
		for(int i=0;i<=Data.maze_a+1;i++){
			for(int j=0;j<=Data.maze_b+1;j++){
				Data.vst[i][j]=0;
				
			}
		}    // 1 is visited
		// 
		for(int i=0;i<=Data.maze_a+1;i++){
			for(int j=0;j<=Data.maze_b+1;j++){
				Data.fog[i][j]=0;
			}
		}    // 0 is fog
		// 放置小怪
		putmon(Data.monst_num[ManClass.man.level]);
		// 鍒濆鍖栫瓟妗堣矾
		//self_search_road(maze_start[man.level][0],maze_start[man.level][1],maze_end[man.level][0],maze_end[man.level][1]);
		// 鍒濆鍖栫帺瀹跺潗鏍�
		
		// 鍒濆鍖栬捣鐐圭粓鐐�
		Data.maze[Data.maze_start[ManClass.man.level][0]][Data.maze_start[ManClass.man.level][1]]=3;
		Data.maze[Data.maze_end[ManClass.man.level][0]][Data.maze_end[ManClass.man.level][1]]=4;
		
	
		// 椹遍浘
		disfog(Data.maze_start[ManClass.man.level][0],Data.maze_start[ManClass.man.level][1],ManClass.man.view);
	}
/*	public static void init_view(){
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	//	Data.drawcanvas.drawColor(Color.BLACK);
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		Data.paint.setColor(Color.RED);
		//锟斤拷锟斤拷锟斤拷锟斤拷
		for(int i=0;i<=maze_a+1;i++){
			for(int j=0;j<=maze_b+1;j++){
				if(maze[i][j]==1)
					drawcanvas.drawRect(unit_l*(i+1), unit_l*(j+1),unit_l*(i+2),unit_l*(j+2), paint);
			}
		}
	//	repaint(Data.maze_a,Data.maze_b,1,false);
		
		//drawBitmap(Data.floor, Data.unit_l*2, 0, Data.paint);
	}
	*/
	public static  boolean move(int _direct){ 
		if(Data.maze[ ManClass.man.x+Data.drct[_direct][0] ][ ManClass.man.y+Data.drct[_direct][1] ]!=0){		
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}

