package kon;
import java.util.*;
//poprehadzovat podmienky na ovladace, aby sa skusali viacere cesty ako zacat
public class PathFinder {
	private Policko current;
	private Stack stk;
	private ArrayList<Policko> cesta;
	private int uzolminx=99999, uzolminy=99999;
	public PathFinder()
	{
		this.cesta=new ArrayList<Policko>();
	}
	private void mv1(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		
	}
	public boolean next(int sx, int sy, int mx, int my, Policko chessboard[][]) throws Exception
	{
		this.uzolminx=99999;
		this.uzolminy=99999;//nijako nesuvisi s found
		System.out.println("idem z: " + sy + " " + sx);
		
		if((sy+2>=0 && sy+2<=my) && (sx+1>=0 && sx+1<=mx))
		{
		//	System.out.println("kontrola: " + (sy+2) + " " + (sx+1) + " my/mx " + my + " " +mx);
			if((chessboard[sy+2][sx+1].getFound()==99999 || chessboard[sy+2][sx+1].getFound()==-1))
			{
				if(sx+1<uzolminx || sy+2<uzolminy)
				{
					uzolminy=sy+2;
					uzolminx=sx+1;
		//			System.out.println("kontrola2.0: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy+2][sx+1].getFound()>0)
				{
					chessboard[sy+2][sx+1].setFound(-1);
				}
			}
		}
		if((sy+2>=0 && sy+2<=my) && (sx-1>=0 && sx-1<=mx))
		{
		//	System.out.println("kontrola: " + (sy+2) + " " + (sx-1) + " my/mx " + my + " " +mx);
			if(chessboard[sy+2][sx-1].getFound()==99999 || chessboard[sy+2][sx-1].getFound()==-1)
			{
				if(sx-1<uzolminx || sy+2<uzolminy)
				{
					uzolminy=sy+2;
					uzolminx=sx-1;
		//			System.out.println("kontrola2.1: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy+2][sx-1].getFound()>0)
				{
					chessboard[sy+2][sx-1].setFound(-1);
				}
			}
		}
		if((sy+1>=0 && sy+1<=my) && (sx+2>=0 && sx+2<=mx))
		{
		//	System.out.println("kontrola: " + (sy+1) + " " + (sx+2) + " my/mx " + my + " " +mx);
			if(chessboard[sy+1][sx+2].getFound()==99999 || chessboard[sy+1][sx+2].getFound()==-1)
			{
				if(sx+2<uzolminx || sy+1<uzolminy)
				{
					uzolminy=sy+1;
					uzolminx=sx+2;
			//		System.out.println("kontrola2.2: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy+1][sx+2].getFound()>0)
				{
					chessboard[sy+1][sx+2].setFound(-1);
				}
			}
		}
		if((sy+1>=0 && sy+1<=my) && (sx-2>=0 && sx-2<=mx))
		{
		//	System.out.println("kontrola: " + (sy+1) + " " + (sx-2) + " my/mx " + my + " " +mx);
			if(chessboard[sy+1][sx-2].getFound()==99999 || chessboard[sy+1][sx-2].getFound()==-1)
			{
				if(sx-2<uzolminx || sy+1<uzolminy)
				{
					uzolminy=sy+1;
					uzolminx=sx-2;
			//		System.out.println("kontrola2.3: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy+1][sx-2].getFound()>0)
				{
					chessboard[sy+1][sx-2].setFound(-1);
				}
			}
		}
		if((sy-1>=0 && sy-1<=my) && (sx+2>=0 && sx+2<=mx))
		{
			//System.out.println("kontrola: " + (sy-1) + " " + (sx+2) + " my/mx " + my + " " +mx);
			if(chessboard[sy-1][sx+2].getFound()==99999 || chessboard[sy-1][sx+2].getFound()==-1)
			{
				if(sx+2<uzolminx || sy-1<uzolminy)
				{
					uzolminy=sy-1;
					uzolminx=sx+2;
				//	System.out.println("kontrola2.4: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy-1][sx+2].getFound()>0)
				{
					chessboard[sy-1][sx+2].setFound(-1);
				}
			}
		}
		if((sy-1>=0 && sy-1<=my) && (sx-2>=0 && sx-2<=mx))
		{
			//System.out.println("kontrola: " + (sy-1) + " " + (sx-2) + " my/mx " + my + " " +mx);
			if(chessboard[sy-1][sx-2].getFound()==99999 || chessboard[sy-1][sx-2].getFound()==-1)
			{
				if(sx-2<uzolminx || sy-1<uzolminy)
				{
					uzolminy=sy-1;
					uzolminx=sx-2;
					//System.out.println("kontrola2.5: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy-1][sx-2].getFound()>0)
				{
					chessboard[sy-1][sx-2].setFound(-1);
				}
			}
		}
		if((sy-2>=0 && sy-2<=my) && (sx+1>=0 && sx+1<=mx))
		{
		//	System.out.println("kontrola: " + (sy-2) + " " + (sx+1) + " my/mx " + my + " " +mx);
			if(chessboard[sy-2][sx+1].getFound()==99999 || chessboard[sy-2][sx+1].getFound()==-1)
			{
				if(sx+1<uzolminx || sy-2<uzolminy)
				{
					uzolminy=sy-2;
					uzolminx=sx+1;
		//			System.out.println("kontrola2.6: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy-2][sx+1].getFound()>0)
				{
					chessboard[sy-2][sx+1].setFound(-1);
				}
			}
		}
		if((sy-2>=0 && sy-2<=my) && (sx-1>=0 && sx-1<=mx))
		{
		//	System.out.println("kontrola: " + (sy-2) + " " + (sx-1) + " my/mx " + my + " " +mx);
			if(chessboard[sy-2][sx-1].getFound()==99999 || chessboard[sy-2][sx-1].getFound()==-1)
			{
				if(sx-1<uzolminx || sy-2<uzolminy)
				{
					uzolminy=sy-2;
					uzolminx=sx-1;
		//			System.out.println("kontrola2.7: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				if(chessboard[sy-2][sx-1].getFound()>0)
				{
					chessboard[sy-2][sx-1].setFound(-1);
				}
			}
		}
		if(uzolminy!=99999 && uzolminx!=99999)
		{
			System.out.println("kam idem: " + uzolminy + " " + uzolminx);
			chessboard[uzolminy][uzolminx].setFound(0);
			
			chessboard[uzolminy][uzolminx].setX(uzolminx);
			chessboard[uzolminy][uzolminx].setY(uzolminy);
			this.cesta.add(chessboard[uzolminy][uzolminx]);
			
			this.stk=this.stk.push(chessboard[uzolminy][uzolminx]);
			if(next(uzolminx, uzolminy, mx, my, chessboard)==false)
			{
				this.cesta.remove(this.cesta.size()-1);
				this.stk.dump();
				this.stk=this.stk.pop();
				uzolminx=this.stk.getTop().getX();
				uzolminy=this.stk.getTop().getY();
				//vyber dalsieho, pretoze podmienky hovoria len ak ==99999 alebo ==-1
				next(uzolminx, uzolminy, mx, my, chessboard);
				chessboard[uzolminy][uzolminx].setFound(-1);//mozem prist odinakial
			}
			return true;
		}
		else
		{
			
			return false;
		}
	}
	public void printCesta()
	{
		int i;
		for(i=0;i<this.cesta.size();i++)
		{
			System.out.println("i: " + i +" Y:" + this.cesta.get(i).getY() + " X: " +
								this.cesta.get(i).getX());
		}
	}
	//max x suradnica a max y musia byt rovnake je to stvorec
	public void init(int max, int time)
	{
		int i, j;
		this.stk=new Stack();
		Policko chessboard[][]=new Policko[max][max];
		for(i=0;i<max;i++)
		{
			for(j=0;j<max;j++)
			{
				chessboard[i][j]=new Policko();
			}
		}
		chessboard[0][0].setFound(0);
		chessboard[0][0].setX(0);
		chessboard[0][0].setX(0);
		this.stk.push(chessboard[0][0]);
		max--;
		try
		{
			next(0, 0, max, max, chessboard);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		printCesta();
	}
}
