package kon;
import java.util.*;
//poprehadzovat podmienky na ovladace, aby sa skusali viacere cesty ako zacat
public class PathFinder {
	private Policko current;
	private Stack stk;
	private ArrayList<Policko> cesta;
	private int uzolminx=99999, uzolminy=99999;
	private List<Integer> list=new ArrayList<Integer>();
	
	public PathFinder()
	{
		this.cesta=new ArrayList<Policko>();
		this.list.add(0);
		this.list.add(1);
		this.list.add(2);
		this.list.add(3);
		this.list.add(4);
		this.list.add(5);
		this.list.add(6);
		this.list.add(7);
	}
	private void mv0(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy+2>=0 && sy+2<=my) && (sx+1>=0 && sx+1<=mx))
		{
		//	System.out.println("kontrola: " + (sy+2) + " " + (sx+1) + " my/mx " + my + " " +mx);
			if((chessboard[sy+2][sx+1].getFound()==99999 || chessboard[sy+2][sx+1].getFound()==-1))
			{
				if((sy+2<my/2 || sx+1<mx/2) && (sy+2<this.uzolminy || sx+1<this.uzolminx))
				{
					this.uzolminy=sy+2;
					this.uzolminx=sx+1;
		//			System.out.println("kontrola2.0: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else if((sy+2>my/2 || sx+1>mx/2) && (sy+2>this.uzolminy || sx+1>this.uzolminx))
				{
					this.uzolminy=sy+2;
					this.uzolminx=sx+1;
				}
				else if((sy+2==my/2 || sx+1==mx/2) &&
						((sy+2<this.uzolminy || sx+1<this.uzolminx) || (sy+2>this.uzolminy || sx+1>this.uzolminx)))
				{
					this.uzolminy=sy+2;
					this.uzolminx=sx+1;
				}
				if(chessboard[sy+2][sx+1].getFound()>0)
				{
					chessboard[sy+2][sx+1].setFound(-1);
				}
			}
		}
	}
	private void mv1(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy+2>=0 && sy+2<=my) && (sx-1>=0 && sx-1<=mx))
		{
		//	System.out.println("kontrola: " + (sy+2) + " " + (sx-1) + " my/mx " + my + " " +mx);
			if(chessboard[sy+2][sx-1].getFound()==99999 || chessboard[sy+2][sx-1].getFound()==-1)
			{
				if((sy+2>my/2 || sx-1>mx/2 ) && (sy+2<this.uzolminy || sx-1<this.uzolminx))
				{
					this.uzolminy=sy+2;
					this.uzolminx=sx-1;
		//			System.out.println("kontrola2.1: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else if((sy+2>my/2 || sx-1>mx/2 ) && (sy+2>this.uzolminy || sx-1>this.uzolminx))
				{
					this.uzolminy=sy+2;
					this.uzolminx=sx-1;
				}
				else if((sy+2==my/2 || sx-1==mx/2 ) && 
					((sy+2<this.uzolminy || sx-1<this.uzolminx) || (sy+2>this.uzolminy || sx-1>this.uzolminx)))
				{
					this.uzolminy=sy+2;
					this.uzolminx=sx-1;
				}
				if(chessboard[sy+2][sx-1].getFound()>0)
				{
					chessboard[sy+2][sx-1].setFound(-1);
				}
			}
		}
	}
	private void mv2(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy+1>=0 && sy+1<=my) && (sx+2>=0 && sx+2<=mx))
		{
		//	System.out.println("kontrola: " + (sy+1) + " " + (sx+2) + " my/mx " + my + " " +mx);
			if(chessboard[sy+1][sx+2].getFound()==99999 || chessboard[sy+1][sx+2].getFound()==-1)
			{
				if((sy+1<my/2 || sx+2<mx/2 ) && (sy+1<this.uzolminy || sx+2<this.uzolminx))
				{
					this.uzolminy=sy+1;
					this.uzolminx=sx+2;
			//		System.out.println("kontrola2.2: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else if((sy+1>my/2 || sx+2>mx/2 ) && (sy+1>this.uzolminy || sx+2>this.uzolminx))
				{
					this.uzolminy=sy+1;
					this.uzolminx=sx+2;
				}
				else if((sy+1==my/2 || sx+2==mx/2 ) &&
					((sy+1<this.uzolminy || sx+2<this.uzolminx) || (sy+1>this.uzolminy || sx+2>this.uzolminx)))
				{
					this.uzolminy=sy+1;
					this.uzolminx=sx+2;
				}
				if(chessboard[sy+1][sx+2].getFound()>0)
				{
					chessboard[sy+1][sx+2].setFound(-1);
				}
			}
		}
	}
	private void mv3(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy+1>=0 && sy+1<=my) && (sx-2>=0 && sx-2<=mx))
		{
		//	System.out.println("kontrola: " + (sy+1) + " " + (sx-2) + " my/mx " + my + " " +mx);
			if(chessboard[sy+1][sx-2].getFound()==99999 || chessboard[sy+1][sx-2].getFound()==-1)
			{
				if((sy+1<my/2 || sx-2<mx/2 ) && (sy+1<this.uzolminy || sx-2<this.uzolminx))
				{
					this.uzolminy=sy+1;
					this.uzolminx=sx-2;
			//		System.out.println("kontrola2.3: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else if((sy+1>my/2 || sx-2>mx/2 ) && (sy+1>this.uzolminy || sx-2>this.uzolminx))
				{
					this.uzolminy=sy+1;
					this.uzolminx=sx-2;
				}
				else if((sy+1==my/2 || sx-2==mx/2 ) &&
					((sy+1<this.uzolminy || sx-2<this.uzolminx) || (sy+1>this.uzolminy || sx-2>this.uzolminx)))
				{
					this.uzolminy=sy+1;
					this.uzolminx=sx-2;
				}
				if(chessboard[sy+1][sx-2].getFound()>0)
				{
					chessboard[sy+1][sx-2].setFound(-1);
				}
			}
		}
	}
	private void mv4(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy-1>=0 && sy-1<=my) && (sx+2>=0 && sx+2<=mx))
		{
			//System.out.println("kontrola: " + (sy-1) + " " + (sx+2) + " my/mx " + my + " " +mx);
			if(chessboard[sy-1][sx+2].getFound()==99999 || chessboard[sy-1][sx+2].getFound()==-1)
			{
				if((sy-1<my/2 || sx+2<mx/2 ) && (sy-1<this.uzolminy || sx+2<this.uzolminx))
				{
					this.uzolminy=sy-1;
					this.uzolminx=sx+2;
				//	System.out.println("kontrola2.4: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else if((sy-1>my/2 || sx+2>mx/2 ) && (sy-1>this.uzolminy || sx+2>this.uzolminx))
				{
					this.uzolminy=sy-1;
					this.uzolminx=sx+2;
				}
				else if((sy-1==my/2 || sx+2==mx/2 ) && 
					((sy-1<this.uzolminy || sx+2<this.uzolminx) || (sy-1>this.uzolminy || sx+2>this.uzolminx)))
				{
					this.uzolminy=sy-1;
					this.uzolminx=sx+2;
				}
				if(chessboard[sy-1][sx+2].getFound()>0)
				{
					chessboard[sy-1][sx+2].setFound(-1);
				}
			}
		}
	}
	private void mv5(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy-1>=0 && sy-1<=my) && (sx-2>=0 && sx-2<=mx))
		{
			//System.out.println("kontrola: " + (sy-1) + " " + (sx-2) + " my/mx " + my + " " +mx);
			if(chessboard[sy-1][sx-2].getFound()==99999 || chessboard[sy-1][sx-2].getFound()==-1)
			{
				if((sy-1>my/2 || sx-2<mx/2 ) && (sy-1<this.uzolminy || sx-2<this.uzolminx))
				{
					this.uzolminy=sy-1;
					this.uzolminx=sx-2;
					//System.out.println("kontrola2.5: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else if((sy-1>my/2 || sx-2>mx/2 ) && (sy-1<this.uzolminy || sx-2<this.uzolminx))
				{
					this.uzolminy=sy-1;
					this.uzolminx=sx-2;
				}
				else if((sy-1==my/2 || sx-2==mx/2 ) &&
					((sy-1<this.uzolminy || sx-2<this.uzolminx) || (sy-1<this.uzolminy || sx-2<this.uzolminx)))
				{
					this.uzolminy=sy-1;
					this.uzolminx=sx-2;
				}
				if(chessboard[sy-1][sx-2].getFound()>0)
				{
					chessboard[sy-1][sx-2].setFound(-1);
				}
			}
		}
	}
	private void mv6(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy-2>=0 && sy-2<=my) && (sx+1>=0 && sx+1<=mx))
		{
		//	System.out.println("kontrola: " + (sy-2) + " " + (sx+1) + " my/mx " + my + " " +mx);
			if(chessboard[sy-2][sx+1].getFound()==99999 || chessboard[sy-2][sx+1].getFound()==-1)
			{
				if((sy-2<my/2 || sx+1<mx/2 ) && (sy-2<this.uzolminy || sx+1<this.uzolminx))
				{
					this.uzolminy=sy-2;
					this.uzolminx=sx+1;
		//			System.out.println("kontrola2.6: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else if((sy-2>my/2 || sx+1>mx/2 ) && (sy-2<this.uzolminy || sx+1<this.uzolminx))
				{
					this.uzolminy=sy-2;
					this.uzolminx=sx+1;
				}
				else if((sy-2==my/2 || sx+1==mx/2 ) && 
					((sy-2<this.uzolminy || sx+1<this.uzolminx) || (sy-2<this.uzolminy || sx+1<this.uzolminx)))
				{
					this.uzolminy=sy-2;
					this.uzolminx=sx+1;
				}
				if(chessboard[sy-2][sx+1].getFound()>0)
				{
					chessboard[sy-2][sx+1].setFound(-1);
				}
			}
		}
	}
	private void mv7(int sx, int sy, int mx, int my, Policko chessboard[][])
	{
		if((sy-2>=0 && sy-2<=my) && (sx-1>=0 && sx-1<=mx))
		{
		//	System.out.println("kontrola: " + (sy-2) + " " + (sx-1) + " my/mx " + my + " " +mx);
			if(chessboard[sy-2][sx-1].getFound()==99999 || chessboard[sy-2][sx-1].getFound()==-1)
			{
				if((sy-2<my/2 || sx-1<mx/2 ) && (sy-2<this.uzolminy || sx-1<this.uzolminx))
				{
					this.uzolminy=sy-2;
					this.uzolminx=sx-1;
		//			System.out.println("kontrola2.7: " + uzolminy + " " + uzolminx + " my/mx " + my + " " +mx);
				}
				else  if((sy-2>my/2 || sx-1>mx/2 ) && (sy-2<this.uzolminy || sx-1<this.uzolminx))
				{
					this.uzolminy=sy-2;
					this.uzolminx=sx-1;
				}
				else if((sy-2==my/2 || sx-1==mx/2 ) && 
					((sy-2<this.uzolminy || sx-1<this.uzolminx) || (sy-2<this.uzolminy || sx-1<this.uzolminx)))
				{
					this.uzolminy=sy-2;
					this.uzolminx=sx-1;
				}
				if(chessboard[sy-2][sx-1].getFound()>0)
				{
					chessboard[sy-2][sx-1].setFound(-1);
				}
			}
		}
	}
	public boolean next(int sx, int sy, int mx, int my, Policko chessboard[][]) throws Exception
	{
		this.uzolminx=99999;
		this.uzolminy=99999;//nijako nesuvisi s found
		System.out.println("idem z: " + sy + " " + sx);
		int i;
		for(i=0;i<this.list.size();i++)
		{
			if(this.list.get(i)==0)
			{
				mv0(sx, sy, mx, my, chessboard);
			}
			else if(this.list.get(i)==1)
			{
				mv1(sx, sy, mx, my, chessboard);
			}
			else if(this.list.get(i)==2)
			{
				mv2(sx, sy, mx, my, chessboard);
			}
			else if(this.list.get(i)==3)
			{
				mv3(sx, sy, mx, my, chessboard);
			}
			else if(this.list.get(i)==4)
			{
				mv4(sx, sy, mx, my, chessboard);
			}
			else if(this.list.get(i)==5)
			{
				mv5(sx, sy, mx, my, chessboard);
			}
			else if(this.list.get(i)==6)
			{
				mv6(sx, sy, mx, my, chessboard);
			}
			else if(this.list.get(i)==7)
			{
				mv7(sx, sy, mx, my, chessboard);
			}
			else
			{
				System.out.println("error");
				break;
			}
		}
		if(this.uzolminy!=99999 && this.uzolminx!=99999)
		{
			System.out.println("kam idem: " + this.uzolminy + " " + this.uzolminx);
			chessboard[this.uzolminy][this.uzolminx].setFound(0);
			
			chessboard[this.uzolminy][this.uzolminx].setX(this.uzolminx);
			chessboard[this.uzolminy][this.uzolminx].setY(this.uzolminy);
			this.cesta.add(chessboard[this.uzolminy][this.uzolminx]);
			
			this.stk=this.stk.push(chessboard[this.uzolminy][this.uzolminx]);
			while(next(this.uzolminx, this.uzolminy, mx, my, chessboard)==false 
					&& this.cesta.size()>0)
			{
				this.cesta.remove(this.cesta.size()-1);
				this.stk.dump();
				this.stk=this.stk.pop();
				this.uzolminx=this.stk.getTop().getX();
				this.uzolminy=this.stk.getTop().getY();
				//vyber dalsieho, pretoze podmienky hovoria len ak ==99999 alebo ==-1
				next(this.uzolminx, this.uzolminy, mx, my, chessboard);
				chessboard[this.uzolminy][this.uzolminx].setFound(-1);//mozem prist odinakial
			}
			return true;
		}
		else
		{
			this.uzolminx=this.stk.getTop().getX();
			this.uzolminy=this.stk.getTop().getY();
			System.out.println("vraciam false: " + this.uzolminy + " " + this.uzolminx);
			Collections.shuffle(this.list);
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
			//while(this.cesta.size()<25)
			//{
				Collections.shuffle(this.list);
				next(0, 0, max, max, chessboard);
				if(this.cesta.size()<25)
				{
					System.out.println("path not found");
				}
			//}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		printCesta();
	}
}
