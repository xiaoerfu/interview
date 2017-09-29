package diamondInheritance13;

interface CanDo {
	void doIt();
}

interface CanDoMore extends CanDo {
	void doMore();
}

interface CanDoFaster extends CanDo {
	void doFaster();
}

interface CanDoMost extends CanDoMore, CanDoFaster {

	void doMost();
}

class Doer implements CanDoMost {
	public void doIt() {System.out.println("doIt");}
	public void doMore() {System.out.println("doMore");}
	public void doFaster() {System.out.println("doFaster");}
	public void doMost() {System.out.println("doMost");}
}
public class DiamondInheritance13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doer cd2 = new Doer();		//接口向上转型
		CanDoMost cd = (CanDoMost)cd2;
		cd.doIt();
		cd.doMore();
		cd.doFaster();
		cd.doMost();
		
//		接口向下转型
//		Doer d = new Doer();
//		((CanDoMore)d).doMore();
//		((CanDoFaster)d).doFaster();
//		((CanDo)d).doIt();	
		Doer d = new Doer();
		CanDo d1 = (CanDo)d;
		d1.doIt();	
		CanDoMore m = (CanDoMore)d;
		m.doMore();
		CanDoFaster f = (CanDoFaster)d;
		f.doFaster();
		CanDoMost cdm = (CanDoMost)d;
		cdm.doMost();
	}

}
