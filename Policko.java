package kon;
/*
 * policko found==99999 ak neobjaveny
 * found==-1 ak idem navstivit
 * found==0 ak navstiveny
 */
public class Policko {
	private int x;
	private int y;
	private int found=99999;
	
	public Policko()
	{
		
	}
	public Policko(int x, int y)
	{
		this.x=x;
	    this.y=y;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public int getX()
	{
		return this.x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	public int getY()
	{
		return this.y;
	}
	public int getFound()
	{
		return this.found;
	}
	public void setFound(int f)
	{
		this.found=f;
	}
}
