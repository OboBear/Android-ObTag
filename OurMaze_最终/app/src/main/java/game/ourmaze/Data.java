package game.ourmaze;

import game.ourmaze.ManClass.Man;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Data {

	/* #define */
	public final static int maxmaze=100;  // the max size of maze ( bar )
	public final static int area_y=350,area_x=350,left_x=30,up_y=30; // the boundry of maze possible ( pixel )
	public final static int back_x=900,back_y=545;  // the boudary size of view
	public final static int msg_x=130,msg_y=200;  // the size of msgbox ( pixel )
	public final static int maze_size[][]={{13,15},{15,13},{15,15},{15,19},{19,23},{23,21},{23,23},{25,25},{27,25},{27,27}}; // the maze_x and maze_y of each level
	public final static char tools[]={'k','m','j','f','r','p','t','a','g','d'}; // the tool of each idx
	public final static int ques_ans[]={0,0,0,0,0}; // the answer of each idx
	public  static int Blood=200,Beat=200,Defence=200,Wisedom=20000; // the max value of wisedom/blood/defence/beat
	public final static int blood_t=20,beat_t=3,defence_t=2,wisedom_t=30; // the original wisedom/blood/defence/beat of man
	public final static int mon_pro[][]={{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5},{0,50,1,5}};   // the original wisedom/blood/defence/beat of each monster
	/* direct */
	public final static int man_right=0;
	public final static int man_front=1;
	public final static int man_left=2;
	public final static int man_back=3;
	
	public static int place_x=30,place_y=30; // the coordination of maze ( pixel )
	public static int maze_a=maze_size[0][0],maze_b=maze_size[0][1]; // the size of maze ( bar )
	public static int unit_l=30; // the size of bar ( pixel )
	public static int maze_l=maze_a*unit_l,maze_h=maze_b*unit_l;   // the size of maze ( pixel )
	public int bottom,right_x; // the actual area of maze in the interface ( pixel )
	public static int[][] maze=new int[maxmaze][maxmaze]; // maze 1 is road
	public static int[][] fog=new int[maxmaze][maxmaze]; // fog 0 is fog
	public static int vst[][]=new int[maxmaze][maxmaze];    // 1 is the answer road
	public static int mon[][]=new int[maxmaze][maxmaze];    // bigger than 0 is the index of monster
	public static int drct[][]={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}}; // 8 directions
	public static Paint paint = new Paint();
	public static Canvas drawcanvas;
	
	public final static int tools_l=30; // the size of each tool in menu ( pixel )
	public  static int l_tool[]={550-530,612-530,675-530,737-530,801-530,550-530,612-530,675-530,737-530,801-530,550-530,612-530,675-530,737-530,801-530}; // the x of each tool in menu ( pixel )
	public  static int h_tool[]={330-50,330-50,330-50,330-50,330-50,370-50,370-50,370-50,370-50,370-50,410-50,410-50,410-50,410-50,410-50}; // the y of each tool in menu ( pixel )
	public final static int l_shop[]={-30,30,100,180,250,30,100,180,250,30,100,180,250,30,100}; // the x of each tool in shop ( pixel )
	public final static int h_shop[]={-30,150,150,150,150,250,250,250,250,350,350,350}; // the x of each tool in shop ( pixel )
	public final static int price[]={10,10,10,10,60,20,10,20,50,50,10,10,10,10,10}; // the price of each tool in menu
	public  static int pro_l=220,pro_h=15;                      // the whole length and height of property line 
	public  static int text_x=550,bar_x=30;                    // the x of property text and line
	public final static int choi_l[]={127,206,292,378},choi_r[]={187,266,352,438},choi_t[]={300,300,300,300},choi_b[]={330,330,330,330};   // the boundary coordination of each choice button in msgbox ( pixel )
	public final static int ques_l=85,ques_r=475,ques_t=130,ques_b=380; // the boundary coordination of each quesbox ( pixel )
	public final static int dial_l=85,dial_r=475,dial_t=130,dial_b=380; // the boundary coordination of each dialbox ( pixel )
	public final static int buy_l=800,buy_r=830,buy_t=10,buy_b=30; // the boundary coordination of each buybox  ( pixel )
	public final static int shop_l=0,shop_r=300,shop_t=50,shop_b=480; // the boundary coordination of shop ( pixel )
	public final static int menu_l=510,menu_r=890,menu_t=50,menu_b=480; // the boundary coordination of each menu ( pixel )
	public static int shop_x=-shop_r+20; // the x of shop ( pixel )
	
	/////////////////////////////////////
	public static int flag=1; 
	public static int num=0; 
	public static int choose_num=0; 
	public static int scr_height; // screen height
	public static int scr_width; //screen width
	
	public static Canvas canvas;
	//pictures
	public static Bitmap bitmap;
	public static Bitmap floor;
	public static Bitmap door;
	public static Bitmap wall;
	public static Bitmap start;
	public static Bitmap monst1;
	public static Bitmap monst2;
	public static Bitmap toolbox;
	public static Bitmap button;
	public static Bitmap circle;
	public static Bitmap death;
	public static Bitmap tool0[]=new Bitmap[10];
	public static Bitmap tool1[]=new Bitmap[10];
	public static Bitmap forw[]=new Bitmap[5];
	public static Bitmap up[]=new Bitmap[5];
	public static Bitmap left[]=new Bitmap[5];
	public static Bitmap right[]=new Bitmap[5];
	public static int width;
	public static int height;
    public static int y_toolset=0;
	public static int x_circlepoint;
	public static int y_circlepoint;
	public static int x_button;
	public static int y_button;
	public static int r_button;
	public static  float scaleWidth;
	public static  float scaleHeight;
	public static int direct=3;
	
	public static int stop_time=400;//stop time 
	public static int x_man_move_time_state;  //man move animation
	public static int y_man_move_time_state;
	public static boolean button_man_move=true;
	public static boolean start_move_or_not=false;  // BeginView  && GameView
	public static boolean us_tool_or_not=true;   //
	////matrix
	public static Matrix matrix = new Matrix();
	////text 
	public static String tool_name[] = {"钥匙","地图","照妖镜","驱雾扇","复活","生命药","未知","未知","攻击卡","防御卡"} ;  
	
	///
	public static final int maze_start[][]={{2,2},{4,4},{2,8},{2,8},{2,2},{12,12},{14,14},{2,16},{20,20},{2,8},{22,22}};
	public static final int maze_end[][]={{8,8},{12,12},{12,14},{14,14},{2,8},{2,4},{14,14},{2,18},{26,16},{2,4}};
	public static final double a_cost[]={1,1,1,1,1.4,1.4,1.4,1.4};  // 鑷姩瀵昏矾绉诲姩娑堣�
	public static final int monst_num[]={5,6,7,8,9,10,11,12,13,14};
	public static final int MaxBlood[]={40,60,80,100,120,140,160,180,190,200};
	
	/////////////////////
	public static boolean stop_event=true;  //stop event
	public static boolean using_tool=false;   // tool flag choose or not 
	public static boolean pass=false;        //pass 
	public static char tool_choose;        //choosed tool's name 
	public static boolean death_flag=false;
	
	/////////////////monster move flag
	public static int monster_move=0;  
	
	////////////////////
	//deepth out word
	public static int deep_word=20;
	//是否到达终点
	public static boolean flag_arrive=false;
	//
	public static boolean AK=false;
	
	
	
	public static void  init()
	{
		stop_event=true;
		using_tool=false;
		
		ManClass.man=new Man(2,2);
		num=0;
		choose_num=0;
		direct=3;
	  
		
	}
}
