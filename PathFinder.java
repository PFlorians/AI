package kon;
import java.util.*;
import java.util.concurrent.*;

public class PathFinder {
	private Stack stk;
	private ArrayList<Policko> cesta;
	private List<Integer> list=new ArrayList<Integer>();
	
	/*
	 * inicializacia a konstruktor
	 */
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
	/*
	 * operatory pohybu su definovane ako metody mv0...mv7
	 * pre kazdy mozny sposob pohybu, poradie v akom sa operatory 
	 * spustaju je permutacia definovana v kode metody next()
	 */
	private void mv0(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy+2>=0 && sy+2<=my) && (sx+1>=0 && sx+1<=mx))
		{
		//	System.out.println("kontrola: " + (sy+2) + " " + (sx+1) + " my/mx " + my + " " +mx);
			if((chessboard[sy+2][sx+1].getFound()==99999 || chessboard[sy+2][sx+1].getFound()==-1))
			{
				chessboard[sy+2][sx+1].setX(sx+1);
				chessboard[sy+2][sx+1].setY(sy+2);
				susedia.push(chessboard[sy+2][sx+1]);
				/*
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
				}*/
				if(chessboard[sy+2][sx+1].getFound()>0)
				{
					chessboard[sy+2][sx+1].setFound(-1);
				}
			}
		}
	}
	private void mv1(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy+2>=0 && sy+2<=my) && (sx-1>=0 && sx-1<=mx))
		{
		//	System.out.println("kontrola: " + (sy+2) + " " + (sx-1) + " my/mx " + my + " " +mx);
			if(chessboard[sy+2][sx-1].getFound()==99999 || chessboard[sy+2][sx-1].getFound()==-1)
			{
				chessboard[sy+2][sx-1].setX(sx-1);
				chessboard[sy+2][sx-1].setY(sy+2);
				susedia.push(chessboard[sy+2][sx-1]);
				/*
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
				}*/
				if(chessboard[sy+2][sx-1].getFound()>0)
				{
					chessboard[sy+2][sx-1].setFound(-1);
				}
			}
		}
	}
	private void mv2(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy+1>=0 && sy+1<=my) && (sx+2>=0 && sx+2<=mx))
		{
		//	System.out.println("kontrola: " + (sy+1) + " " + (sx+2) + " my/mx " + my + " " +mx);
			if(chessboard[sy+1][sx+2].getFound()==99999 || chessboard[sy+1][sx+2].getFound()==-1)
			{
				chessboard[sy+1][sx+2].setX(sx+2);
				chessboard[sy+1][sx+2].setY(sy+1);
				susedia.push(chessboard[sy+1][sx+2]);
				/*
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
				}*/
				if(chessboard[sy+1][sx+2].getFound()>0)
				{
					chessboard[sy+1][sx+2].setFound(-1);
				}
			}
		}
	}
	private void mv3(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy+1>=0 && sy+1<=my) && (sx-2>=0 && sx-2<=mx))
		{
		//	System.out.println("kontrola: " + (sy+1) + " " + (sx-2) + " my/mx " + my + " " +mx);
			if(chessboard[sy+1][sx-2].getFound()==99999 || chessboard[sy+1][sx-2].getFound()==-1)
			{
				chessboard[sy+1][sx-2].setX(sx-2);
				chessboard[sy+1][sx-2].setY(sy+1);
				susedia.push(chessboard[sy+1][sx-2]);
				/*if((sy+1<my/2 || sx-2<mx/2 ) && (sy+1<this.uzolminy || sx-2<this.uzolminx))
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
				}*/
				if(chessboard[sy+1][sx-2].getFound()>0)
				{
					chessboard[sy+1][sx-2].setFound(-1);
				}
			}
		}
	}
	private void mv4(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy-1>=0 && sy-1<=my) && (sx+2>=0 && sx+2<=mx))
		{
			//System.out.println("kontrola: " + (sy-1) + " " + (sx+2) + " my/mx " + my + " " +mx);
			if(chessboard[sy-1][sx+2].getFound()==99999 || chessboard[sy-1][sx+2].getFound()==-1)
			{
				chessboard[sy-1][sx+2].setX(sx+2);
				chessboard[sy-1][sx+2].setY(sy-1);
				susedia.push(chessboard[sy-1][sx+2]);
				/*if((sy-1<my/2 || sx+2<mx/2 ) && (sy-1<this.uzolminy || sx+2<this.uzolminx))
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
				}*/
				if(chessboard[sy-1][sx+2].getFound()>0)
				{
					chessboard[sy-1][sx+2].setFound(-1);
				}
			}
		}
	}
	private void mv5(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy-1>=0 && sy-1<=my) && (sx-2>=0 && sx-2<=mx))
		{
			//System.out.println("kontrola: " + (sy-1) + " " + (sx-2) + " my/mx " + my + " " +mx);
			if(chessboard[sy-1][sx-2].getFound()==99999 || chessboard[sy-1][sx-2].getFound()==-1)
			{
				chessboard[sy-1][sx-2].setX(sx-2);
				chessboard[sy-1][sx-2].setY(sy-1);
				susedia.push(chessboard[sy-1][sx-2]);
				/*if((sy-1>my/2 || sx-2<mx/2 ) && (sy-1<this.uzolminy || sx-2<this.uzolminx))
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
				}*/
				if(chessboard[sy-1][sx-2].getFound()>0)
				{
					chessboard[sy-1][sx-2].setFound(-1);
				}
			}
		}
	}
	private void mv6(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy-2>=0 && sy-2<=my) && (sx+1>=0 && sx+1<=mx))
		{
		//	System.out.println("kontrola: " + (sy-2) + " " + (sx+1) + " my/mx " + my + " " +mx);
			if(chessboard[sy-2][sx+1].getFound()==99999 || chessboard[sy-2][sx+1].getFound()==-1)
			{
				chessboard[sy-2][sx+1].setX(sx+1);
				chessboard[sy-2][sx+1].setY(sy-2);
				susedia.push(chessboard[sy-2][sx+1]);
				/*if((sy-2<my/2 || sx+1<mx/2 ) && (sy-2<this.uzolminy || sx+1<this.uzolminx))
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
				}*/
				if(chessboard[sy-2][sx+1].getFound()>0)
				{
					chessboard[sy-2][sx+1].setFound(-1);
				}
			}
		}
	}
	private void mv7(int sx, int sy, int mx, int my, Policko chessboard[][], Stack susedia)
	{
		if((sy-2>=0 && sy-2<=my) && (sx-1>=0 && sx-1<=mx))
		{
		//	System.out.println("kontrola: " + (sy-2) + " " + (sx-1) + " my/mx " + my + " " +mx);
			if(chessboard[sy-2][sx-1].getFound()==99999 || chessboard[sy-2][sx-1].getFound()==-1)
			{
				chessboard[sy-2][sx-1].setX(sx-1);
				chessboard[sy-2][sx-1].setY(sy-2);
				susedia.push(chessboard[sy-2][sx-1]);
				/*
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
				}*/
				if(chessboard[sy-2][sx-1].getFound()>0)
				{
					chessboard[sy-2][sx-1].setFound(-1);
				}
			}
		}
	}
	public boolean next(int sx, int sy, int mx, int my, Policko chessboard[][]) throws Exception
	{
		Stack susedia=new Stack();
		//ladenie
		//System.out.println("idem z: " + sx + " " + sy);
		int i;
		//inicializacia susedov a ich danie do lokalneho zasobnika
		//najdenie susedov
		for(i=0;i<this.list.size();i++)//prebehne 8 krat kazdy z operatorov je v permutacii
		{
			if(this.list.get(i)==0)
			{
				mv0(sx, sy, mx, my, chessboard, susedia);
			}
			else if(this.list.get(i)==1)
			{
				mv1(sx, sy, mx, my, chessboard, susedia);
			}
			else if(this.list.get(i)==2)
			{
				mv2(sx, sy, mx, my, chessboard, susedia);
			}
			else if(this.list.get(i)==3)
			{
				mv3(sx, sy, mx, my, chessboard, susedia);
			}
			else if(this.list.get(i)==4)
			{
				mv4(sx, sy, mx, my, chessboard, susedia);
			}
			else if(this.list.get(i)==5)
			{
				mv5(sx, sy, mx, my, chessboard, susedia);
			}
			else if(this.list.get(i)==6)
			{
				mv6(sx, sy, mx, my, chessboard, susedia);
			}
			else if(this.list.get(i)==7)
			{
				mv7(sx, sy, mx, my, chessboard, susedia);
			}
			else
			{
				System.out.println("error");
				break;
			}
		}
		/*
		 * ladiaci vypis o stave susedov
		 */
		//System.out.println("susedia: " + susedia.getSize());
		while(susedia.isEmpty()==false)
		{
			/*
			 * orientacny ladiaci vypis, preukazujuci aktivitu programu
			 */
			
			//System.out.println("presun na: " + susedia.getTop().getX() + " " + 
			//					susedia.getTop().getY());
			
			susedia.getTop().setFound(0);
			this.cesta.add(susedia.getTop());
			
			if(next(susedia.getTop().getX(), susedia.getTop().getY(), mx, my, chessboard)==false)
			{
				//backtrack
				susedia.getTop().setFound(99999);//-1 su tie ktore chcem navstivit
				susedia.pop();//odstran ako suseda z ktoreho by isla cesta
				this.cesta.remove(this.cesta.size()-1);
			}
			else//to znamena ze cesta sa nasla
			{
				return true;
			}
		}
		//ak susedia su prazdny 2 moznosti - alebo mam cestu, alebo deadlock
		if(this.cesta.size()>((mx+1)*(my+1))-1)
		{
			System.out.println("Mozna cesta: " );
			printCesta();
			return true;
		}
		else//to znamena ze deadlock dalej sa neda hybat
		{
			return false;
		}
	}
	/*
	 * utilitna metoda na vytlacenie vysledku
	 */
	public void printCesta()
	{
		int i;
		/*
		 * Format vystupu:
		 * index, suradnica Y, suradnica X
		 * index - aby bolo vidno, ze vystup splna pocet policok
		 * 			t.j. sachovnica 5x5 ma 25 policok, posledny
		 * 			index musi byt 24 (indexuje sa od 0)
		 * suradnice (Y,X) pretoze ohnisko je lavy horny roh
		 * pola v 2D matici
		 */
		for(i=0;i<this.cesta.size();i++)
		{
			System.out.println("i: " + i +" Y:" + this.cesta.get(i).getY() + " X: " +
								this.cesta.get(i).getX());
		}
	}
	//max x suradnica a max y musia byt rovnake je to stvorec
	/*
	 * argumenty sx, sy su startovacia pozicia max je velkost strany stvorca,
	 * ktora urcuje hranice pre podmienky pohybu
	 */
	public void init(int sx, int sy, int max)
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
		chessboard[sy][sx].setFound(0);
		chessboard[sy][sx].setX(sx);
		chessboard[sy][sx].setY(sy);
		this.stk.push(chessboard[sy][sx]);
		this.cesta.add(chessboard[sy][sx]);
		max--;
		try
		{
			while(this.cesta.size()<((max+1)*(max+1)-1))
			{
				//rozhoduje o tom ktorym smerom sa pohnut prv
				/*
				 * tu sa definuje permutacia postupnosti operatorov
				 * celkovych moznosti je pritom 8!
				 */
				Collections.shuffle(this.list);
				next(sx, sy, max, max, chessboard);
				//ak ide zopakovat cyklus
				if(this.cesta.size()<((max+1)*(max+1)-1))
				{
					this.stk=new Stack();
					this.cesta=new ArrayList<Policko>();
					chessboard[sy][sx].setFound(0);
					chessboard[sy][sx].setX(sx);
					chessboard[sy][sx].setY(sy);
					this.stk.push(chessboard[sy][sx]);
					this.cesta.add(chessboard[sy][sx]);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.exit(0);
	}
	/*
	 * argumenty a uloha metody catalyst:
	 * sx, sy - startovacia pozicia, zadava sa ako (x,y)
	 * 			lenze vystup je prevrateny, koli praktickejsej
	 * 			praci s polom ako 2D maticou resp. stvorcom
	 * max - velkost sachovnice
	 * time - hranicna podmienka -> doba po ktorej uplynuti program zastavi
	 */
	public void catalyst(int sx, int sy, int max, int time)
	{
		Spark s=new Spark(sx, sy, max, time);
		/*
		 * hlavne vlakno pusti paralelne vlakno na ktorom ide hladanie
		 * a hlavne vlakno caka stanovenu dobu
		 */
		try
		{
			s.start();
			Thread.sleep(time);
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		try
		{
			/*
			 * ked uz hlavne vlakno prestalo cakat tak pride volanie
			 * na ukoncenie chodu progrmau
			 */
			s.die();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	/*
	 * technicky sa instancia na druhom vlakne inicializuje tu
	 */
	class Spark implements Runnable
	{
		private volatile boolean isRunning=true;
		private int sx; 
		private int sy;
		private int max; 
		private int time;
		Thread vector;
		Spark(int sx, int sy, int max, int time)
		{
			this.sx=sx;
			this.sy=sy;
			this.max=max;
			this.time=time;
			this.vector=new Thread(this, "instancia 1");
		}
        @Override
        public void run()
        {
       		init(sx, sy, max);
        }
        public void start()
        {
        	vector.start();
        }
        public void die()
        {
        	try
        	{
        		/*
        		 * vyuziva sa systemove volanie, volatile premenna, alebo join
        		 * volatile a join, ale neukoncia vlakno okamzite
        		 * volanie Thread.stop() vyhadzuje vynimku ThreadDied
        		 */
        		//isRunning=false;
        		System.out.println("Cas hladania cesty prekrocil stanoveny limit.");
        		System.exit(0);
        	//	vector.join(this.time);
        	}
        	catch(Exception e)
        	{
        		System.out.println(e);
        		e.printStackTrace();
        	}
        }
	}
}
