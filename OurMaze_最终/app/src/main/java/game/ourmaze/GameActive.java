package game.ourmaze;

import game.ourmaze.ManClass.Man;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class GameActive extends Activity {
	/////////////////////////
	//全局变量
	public static int direction;
	public static GameView gameView=null;
//////////////////////////////
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		HiddenMenu(); 
		Data.maze_a=Data.maze_size[0][0];
		Data.maze_b=Data.maze_size[0][1];
		Init.init_data();
		init();
		setContentView(R.layout.gameactive);
		//new Thread(new gameThread()).start();//开启一个线程。
	//	buttontime bt=new buttontime(1000);
	//	bt.start();
		findViews();
		new monster_move(1000).start();
		new Invalidate(5).start();
		
	}
	////
	//隐藏下滑菜单
	private void HiddenMenu()
	{
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
	
	////
	//方向按键
	/*private ImageButton up_button;
	private ImageButton left_button;
	private ImageButton down_button;
	private ImageButton right_button;*/
	///////
	//public static  EditText text=null;
	
	private void findViews()
	{

		gameView=(GameView)findViewById(R.id.gameview);
	//	text=(EditText)findViewById(R.id.test);
	//	text.setText(""+Data.num);
		
	}
	
	
	
	
	
	
	
	//菜单
	private final int MENU_SHOP=Menu.FIRST;
	private final int MENU_SAVE=Menu.FIRST+1;
	private final int MENU_RETURN=Menu.FIRST+2;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0,MENU_SHOP,0,R.string.shop_menu);
		menu.add(0,MENU_SAVE,0,R.string.save_menu);
		menu.add(0,MENU_RETURN,0,R.string.return_menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		AlertDialog.Builder builder=new AlertDialog.Builder(GameActive.this);
		switch(item.getItemId())
		{
		case MENU_SHOP:	
			builder.setTitle("提示！").setMessage("功能尚未开放，敬请期待").setPositiveButton("确认", null).show();
			break;
		case MENU_SAVE:
			builder.setTitle("提示！").setMessage("功能尚未开放，敬请期待").setPositiveButton("确认", null).show();
			break;
		case MENU_RETURN:
			
			 new AlertDialog.Builder(this).setTitle("").setMessage("你确定要退出游戏？").setPositiveButton("确认", new DialogInterface.OnClickListener() { 
			        public void onClick(DialogInterface dialog, int whichButton) { 
			            setResult(RESULT_OK);//确定按钮事件 
			            Data.init();
						ManClass.man.level=0;
						 ManClass.man=new Man(Data.maze_start[ManClass.man.level][0],Data.maze_start[ManClass.man.level][1]);
						 Data.deep_word=20;
			            GameActive.this.finish(); 
			            } 
			            }).setNegativeButton("取消",null).show();
		break; 
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	///////返回键
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 如果是返回键,直接返回到桌面
		if(keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME){
			
		    new AlertDialog.Builder(this).setTitle("").setMessage("你确定要退出游戏？").setPositiveButton("确认", new DialogInterface.OnClickListener() { 
		        public void onClick(DialogInterface dialog, int whichButton) { 
		            setResult(RESULT_OK);//确定按钮事件 
		            Data.init();
					ManClass.man.level=0;
					 ManClass.man=new Man(Data.maze_start[ManClass.man.level][0],Data.maze_start[ManClass.man.level][1]);
					 Data.deep_word=20;
		            GameActive.this.finish(); 
		            } 
		            }).setNegativeButton("取消",null).show();
	    //	GameActive.this.finish();
		}
		return super.onKeyDown(keyCode, event);
		}
	
	
	
	//////////////线程
	 class  gameThread implements Runnable
	 {
	  @Override
	  public void run() {
	   // TODO Auto-generated method stub
	//当前线程在运行的时候，就设置为每隔0.1秒在再线程队列中添加下一个线程。
	   while(!Thread.currentThread().interrupted())
	   {
	    gameView.postInvalidate();//每当执行线程时就刷新一下GameView画布界面。
	    try {
	     Thread.sleep(100);
	    } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     Thread.currentThread().interrupt();
	    }
	   }
	  }
	 }
	
	////////
	 private void init()//数据重置
	 {
		  
		     //   Init.init_data();
			   
				Data.num=0;
				Data.choose_num=0;		
				Data.unit_l=(int) (Data.scr_width/10); // the size of bar ( pixel )
				Data.maze_l=Data.maze_a*Data.unit_l;
				Data.maze_h=Data.maze_b*Data.unit_l;   // the size of maze ( pixel )	
				
				
			
	 }
	 
	
	 
		 
	 class buttontime extends Thread
		{
			private int sleep_time;
			public buttontime(int st){sleep_time=st;}
			public void run()
			{
				while(true)
				{
					
					try {
						sleep(sleep_time);
						Data.button_man_move=true;
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				
			}
		}
	 
	 class monster_move extends Thread
		{
			private int sleep_time;
			public monster_move(int st){sleep_time=st;}
			public void run()
			{
				while(true)
				{
					
					
					try {
					sleep(sleep_time/6);
					Data.monster_move=0;
				//	gameView.postInvalidate();
					sleep(sleep_time/6);
					Data.monster_move=1;
				//	gameView.postInvalidate();
					sleep(sleep_time/6);
					Data.monster_move=0;
					sleep(sleep_time/6);
				//	gameView.postInvalidate();
					sleep(sleep_time);
					Data.monster_move=1;
				//	gameView.postInvalidate();
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				
			}
		}
	 
	 class Invalidate extends Thread  //自动刷新界面
		{
			private int sleep_time;
			public Invalidate(int st){sleep_time=st;}
			public void run()
			{
				int a=0;
				while(true)
				{
					
					
					try {
						
						if(a==0&&Data.pass){
							a++;
							Function.pass();
						}
						if(Data.pass==false)a=0;
					//	if()
						if(ManClass.man.blood==0)  //人物血量为0
						{
							if(ManClass.man.man_tool[4]==0)
							{
							Data.death_flag=true;
							Data.stop_event=false;
							
							sleep(4000);
							Data.death_flag=false;
							Data.stop_event=true;
							Data.init();
							ManClass.man.level=0;
							Data.stop_event=true;
							GameActive.this.finish();
							
							}
							else
							{ 
								while(ManClass.man.blood<=20)
								{
									sleep(10);
									gameView.postInvalidate();
							    	ManClass.man.blood+=1;
							    	
								}
								ManClass.man.man_tool[4]--;
								if(ManClass.man.man_tool[4]<=0)ManClass.man.man_tool[4]=0;
							}
						}
						
						
						
						if(ManClass.man.level==10)  //人物血量为0
						{
							
							Data.AK=true;
							Data.stop_event=false;
							sleep(4000);
							Data.AK=false;
							Data.stop_event=true;
							Data.init();
							ManClass.man.level=0;
							Data.stop_event=true;
							GameActive.this.finish();
							
						}
						
						if(Data.maze[ManClass.man.x][ManClass.man.y]==4&&ManClass.man.man_tool[0]>0)
							Data.flag_arrive=true;
						else Data.flag_arrive=false;
						sleep(sleep_time); //刷新周期
						gameView.postInvalidate(); 
				
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				
			}
		}
	 
	 

	 
	


}
