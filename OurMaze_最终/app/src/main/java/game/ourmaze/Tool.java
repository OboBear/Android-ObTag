package game.ourmaze;

import android.app.AlertDialog;
import android.graphics.Color;

public class Tool {
	// 寰楀埌閬撳叿 閬撳叿搴忓彿,閬撳叿缂栧彿
	 public static void get_tool(int tool_id){	
		 ManClass.man.man_tool[tool_id]++;
		//paint_tools(tool_id);
		//paint_num(l_tool[tool_id]+31,h_tool[tool_id]+10,man.man_tool[tool_id],false);
		//paint_tools_msg(tool_id);
	}
	// 澶卞幓閬撳叿 閬撳叿缂栧彿
	public static void sub_tool(int tool_id){
		//music(music_sd);//鎾斁澶卞幓閬撳叿鐨勯煶鏁�		ManClass.man.man_tool[tool_id]--;
		//clear_tool(tool_id);
		//paint_num(l_tool[tool_id]+31,h_tool[tool_id]+10,man.man_tool[tool_id],false);
	}
	// 鏄惁浣跨敤閬撳叿 閬撳叿缂栧彿
	

	public static boolean use_tool(int tool_id){
		
		switch(Data.tools[tool_id]){
			case 'k': if(ManClass.man.x!=Data.maze_end[ManClass.man.level][0] || ManClass.man.y!=Data.maze_end[ManClass.man.level][1])
		                	{  
				             //   GameActive.text.setText(""+ManClass.man.x+"   "+ManClass.man.y+"     "+Data.maze_end[ManClass.man.level][0]+"    "+Data.maze_end[ManClass.man.level][1]);
		                   		return false; 
		                     }
					  else{
						  /*ManClass.man.level++;
						  Init.init_data();
						  Data.num=0;
							Data.choose_num=0;		
							Data.unit_l=(int) (Data.scr_width/10); // the size of bar ( pixel )
							Data.maze_l=Data.maze_a*Data.unit_l;
							Data.maze_h=Data.maze_b*Data.unit_l;   // the size of maze ( pixel )	
*/							Data.pass=true;
						  ManClass.man.man_tool[tool_id]--;
					      return false;
					     } 
				
			case 'm': 
				     // paint_map(Data.maze_size[ManClass.man.level][0],Data.maze_size[ManClass.man.level][1]); 
				     //Init.bar(0, 0, 100,100);
				     if(Data.using_tool) Data.using_tool =false;
				     else Data.using_tool =true;
				      Data.tool_choose='m';
				      
				
				  
				      
				      
				      break;
			case 'j': return mirror(); 
			case 'f': { 
				       ManClass.man.man_tool[tool_id]--;
				       return dis_fog();
		               }
			case 'r': if(ManClass.man.blood>0){ return false;  }
					  else{ 
						  while(ManClass.man.blood<Data.blood_t && ManClass.man.blood<Data.Blood)
						  { 
							  ManClass.man.blood+=10;
						  }
						  ManClass.man.man_tool[tool_id]--;
						  } break;
			case 'p': if(ManClass.man.blood==Data.Blood){ return false;  }
					  else{ 
						  int t=ManClass.man.blood+20; while(ManClass.man.blood<t && ManClass.man.blood<Data.Blood)
						  { 
							  ManClass.man.blood++;  
						  }
						  ManClass.man.man_tool[tool_id]--;
						  }
				       break;
			case 't': escape(); 
		              ManClass.man.man_tool[tool_id]--;
			          break;
			case 'a': paint_road(Data.maze_size[ManClass.man.level][0],Data.maze_size[ManClass.man.level][1]);
				       break;
			case 'g': if(ManClass.man.beat==Data.Beat){ return false;  }
					  else{ 
						  int t=ManClass.man.beat+3;
						  while(ManClass.man.beat<t && ManClass.man.beat<Data.Beat)
						  { 
							  ManClass.man.beat++; 
						  }
						  ManClass.man.man_tool[tool_id]--;
						  }
				       break;
		    case 'd': if(ManClass.man.defence==Data.Defence){ return false;  }
					  else{ int t=ManClass.man.defence+2; 
					  while(ManClass.man.defence<t && ManClass.man.defence<Data.Defence)
					  { 
						  ManClass.man.defence++;
					  }
					  ManClass.man.man_tool[tool_id]--;
					  } 
		    	      break;
		   	default: return true;
		}
	//	GameActive.text.setText(""+Data.tools[tool_id]);
		return true;
	}
	public static void paint_map()
	{
		
		int size=Data.scr_height/35;
		int place_y=(Data.scr_height-size*Data.maze_b)/2;
		int place_x=(Data.scr_width-size*Data.maze_a)/2;

		
		int i,j,ii,jj;
		/*if(Data.place_y<Data.up_y) j=(Data.up_y-Data.place_y)/Data.unit_l+1;
		else j=1;*/
		j=1;
		//if(Data.place_x+Data.maze_l>Data.area_x) ii=(Data.area_x-Data.place_x)/size;
	//	else 
			ii=2*Data.maze_a+1;
		//if(Data.place_y+Data.maze_h>Data.area_y) jj=(Data.area_y-Data.place_y)/size;
	//	else
			jj=2*Data.maze_b+1;
		for(;j<=Data.maze_b;j++){
			/*if(Data.place_x<Data.left_x) i=(Data.left_x-Data.place_x)/Data.unit_l+1;
		    else i=1;*/
			i=1;
			for(;i<=Data.maze_a;i++){
				// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
			
				if(Data.maze[i][j]==0) Data.paint.setColor(Color.GRAY);
				                        
				// 锟斤拷
				if(Data.maze[i][j]==1) Data.paint.setColor(Color.WHITE);
				//if(vst[i][j]) setfillstyle(GREEN),bar(unit_l*(i-1)+place_x,unit_l*(j-1)+place_y,unit_l*i+place_x,unit_l*j+place_y);
				// 锟斤拷锟斤拷
				if(Data.fog[i][j]==1 && Data.maze[i][j]==3) Data.paint.setColor(Color.LTGRAY);
				// 锟斤拷锟斤拷
				if(Data.fog[i][j]==1 && Data.maze[i][j]==4) Data.paint.setColor(Color.BLUE);
				// 锟斤拷锟斤拷
				//if(fog[i][j]==1 && mon[i][j]>=0){paint.setColor(Color.WHITE);bar(unit_l*(i-1)+place_x,unit_l*(j-1)+place_y,unit_l*i+place_x,unit_l*j+place_y);}
			    if(Data.maze_start[ManClass.man.level][0]==i&&Data.maze_start[ManClass.man.level][1]==j) Data.paint.setColor(Color.RED);
			    if(Data.maze_end[ManClass.man.level][0]==i&&Data.maze_end[ManClass.man.level][1]==j) Data.paint.setColor(Color.BLACK);
			         	Init.bar(place_x+size*(i-1),
                		place_y+size*(j-1),
                        place_x+size*i,
                        place_y+size*j);
			}
		}
	
	}
	// 鐓у闀�	
	public static boolean mirror(){
		/*while(true){
			if(_kbhit()) return false;
			if(MouseHit()){
				MOUSEMSG Mouse;
		        Mouse=GetMouseMsg();
		        switch(Mouse.uMsg){
			        case WM_LBUTTONDOWN:
						for(int i=0;i<=5;i++){
							int tl=(monster[i].x-1)*unit_l+place_x,tr=monster[i].x*unit_l+place_x,tu=(monster[i].y-1)*unit_l+place_y,td=monster[i].y*unit_l+place_y;
							if(Mouse.x>=tl && Mouse.x<=tr && Mouse.y>=tu && Mouse.y<=td && mon[monster[i].x][monster[i].y]!=-1 && fog[monster[i].x][monster[i].y]){
								paint_monpro(i);
								return true;
							}
						}
						for(int i=0;i<10;i++){
							// 濡傛灉鐐瑰嚮浜嗙i涓亾鍏�							if(Mouse.x>=l_tool[i] && Mouse.x<=l_tool[i]+tools_l && Mouse.y>=h_tool[i] && Mouse.y<=h_tool[i]+tools_l && man.man_tool[i] && Mouse.x>=left_x && Mouse.x<=right_x && Mouse.y<=bottom && Mouse.y>=up_y){
								// 濡傛灉璇ラ亾鍏峰彲浠ョ敤
								if(i!=2 && use_tool(i)){
									sub_tool(i);
									return false;
								}
							}
						}
				}
			}
		}*/
		return false;
	}
	// 椹遍浘鎵�	
	public static boolean dis_fog(){
		for(int i=0;i<Data.maxmaze;i++)
			for(int j=0;j<Data.maxmaze;j++)
				Data.fog[i][j]=1;
		return true;
	}
	// 缁濆湴閫冪
	public static void escape(){
		while(true){
			int x=Init.createRandom(1, Data.maze_a); int y=Init.createRandom(1, Data.maze_b);
			if(Data.mon[x][y]==-1 && Data.maze[x][y]==1 && ManClass.man.x!=x && ManClass.man.y!=y){
				ManClass.man.x=x; ManClass.man.y=y;
				Init.disfog(x,y,ManClass.man.view);
				return;
			}
		}
	}
	// 地图绘制算法
	public static void paint_map(int map_size_x,int map_size_y){
		int unit_t=10;
		for(int j=1;j<=(map_size_y+1);j++){
			for(int i=1;i<=(map_size_x+1);i++){
				if(Data.maze[i][j]==0 && Data.fog[i][j]==1){ Data.paint.setColor(Color.BLUE);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); }
				if(Data.maze[i][j]==1 && Data.fog[i][j]==1){ Data.paint.setColor(Color.DKGRAY);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); }
				if(Data.maze[i][j]==3 && Data.fog[i][j]==1){ Data.paint.setColor(Color.RED);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); }
				if(Data.maze[i][j]==4 && Data.fog[i][j]==1){ Data.paint.setColor(Color.YELLOW);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); } 
				if(ManClass.man.x==i && ManClass.man.y==j){ Data.paint.setColor(Color.CYAN);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); }
			}
		}
	}
	// 答案路绘制算法
		public static void paint_road(int map_size_x,int map_size_y){
			int unit_t=10;
			for(int j=1;j<=(map_size_y+1);j++){
				for(int i=1;i<=(map_size_x+1);i++){
					if(Data.vst[i][j]==1){ Data.paint.setColor(Color.BLUE);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); }
					if(Data.maze[i][j]==3){ Data.paint.setColor(Color.RED);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); }
					if(Data.maze[i][j]==4){ Data.paint.setColor(Color.YELLOW);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); } 
					if(ManClass.man.x==i && ManClass.man.y==j){ Data.paint.setColor(Color.CYAN);Init.bar(unit_t*(i-1),unit_t*(j-1),unit_t*i,unit_t*j); }
				}
			}
		}
}


/*class tool_tim extends Thread
	{
		private int sleep_time;
		
		public tool_time(int st){sleep_time=st;}
		public void run()
		{
				
				try {
					sleep(sleep_time/2);
					Data.using_tool=false;
					GameActive.gameView.postInvalidate();
					sleep(sleep_time/8);
					Data.using_tool=true;
					GameActive.gameView.postInvalidate();
					sleep(sleep_time/4);
					Data.using_tool=false;
					GameActive.gameView.postInvalidate();
					sleep(sleep_time/6);
					Data.using_tool=true;
					GameActive.gameView.postInvalidate();
					sleep(sleep_time/6);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		    	}	
				Data.using_tool=false;
			    Data.stop_event=true;
			    GameActive.gameView.postInvalidate();
			
		}
	}*/