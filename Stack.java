package kon;
import java.util.*;
/*
 * pomocna datova struktura, ako sucast algoritmu 
 * prehladavania do hlbky
 */
public class Stack {
	private ArrayList<Policko> stk;
	
	public Stack()
	{
		this.stk=new ArrayList<Policko>();
	}
	public Stack push(Policko p)
	{
		this.stk.add(p);
		return this;
	}
	public Stack pop()
	{
		int tmp=this.stk.size()-1;
		//System.out.println("popping: " + this.stk.get(tmp).getY() + " " + this.stk.get(tmp).getX());
		this.stk.remove(tmp);
		return this;
	}
	public void top()
	{
		System.out.println(this.stk.get(this.stk.size()));
	}
	public void dump()
	{
		int i=0;
		for(i=0;i<this.stk.size();i++)
		{
			System.out.println(this.stk.get(i).getY() + " " +this.stk.get(i).getX());
		}
	}
	public Policko getTop()
	{
		return this.stk.get(this.stk.size()-1);
	}
	public ArrayList<Policko> getData()
	{
		return this.stk;
	}
	public boolean isEmpty()
	{
		return this.stk.isEmpty();
	}
	public int getSize()
	{
		return this.stk.size();
	}
}
