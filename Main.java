package kon;
/*
 * Author: Patrik Florians
 * Description:
 * Hlavna trieda, vsetky testy a spustenia vykonavat tu.
 * 
 */
public class Main {
	
	public static void main(String[] args){
		PathFinder pf=new PathFinder();
		
		//testy
		/*
		 * testy spustane cez metodu catalyst bezia na separatnom vlakne
		 * vytvorenie dvoch vlakien umoznuje programu bezat v stanovenom case
		 * cas sa stanovuje v milisekundach
		 * pre argumenty metod catalyst a init vid triedu PtahFinder.java
		 */
		pf.catalyst(0, 0, 5, 60000);
		//pf.init(0, 4, 5);
		//pf.init(0, 0, 5);
		//pf.init(2, 2, 5);
		//pf.init(4, 4, 5);
		//pf.init(3, 2, 5);
		
		//pf.catalyst(0, 0, 6, 60000);
		//pf.init(0, 5, 6);
		//pf.init(4, 1, 6);
		//pf.init(0, 5, 6);
		//pf.init(2, 3, 6);
		//pf.init(5, 5, 6);
	}

}
