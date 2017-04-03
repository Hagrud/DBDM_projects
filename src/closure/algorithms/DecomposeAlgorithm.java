package closure.algorithms;

import java.util.SortedSet;
import java.util.TreeSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class DecomposeAlgorithm implements Algorithm{
	
	SortedSet<FD> fds;
	SortedSet<AttributeSet> R = new TreeSet<AttributeSet>();
	AttributeSet U;
	boolean isValid = false;
	
	public DecomposeAlgorithm(SortedSet<FD> sigma, AttributeSet schema){
		this.fds = sigma;
		this.U = schema;
		this.R.add(schema);
	}

	public void setAtts(AttributeSet atts) {		
	}

	public AttributeSet getSet() {
		return null;
	}
	
	public SortedSet<AttributeSet> getSets(){
		return this.R;
	}
	
	private AttributeSet getR(){
		for(AttributeSet set : R){
			if(Tools.BCNF(fds, set))
				return set;
		}
		return null;
	}

	public void run() {
		SortedSet<FD> F = Tools.normalize(fds);
		ImprovedAlgorithm algo = new ImprovedAlgorithm(F, null);
		AttributeSet set = getR();
		
		while(set != null){
			FD fd = Tools.getNonTrivialKey(F, U);
			
			R.remove(set);
			algo.setAtts(fd.getLeft());
			algo.run();
			R.add(algo.getSet());
			set = set.without(algo.getSet());
			set.addAttributes(fd.getLeft());
			R.add(set);
			
			set = getR();
		}
		
		this.isValid = true;
	}

	public boolean isValid() {
		return this.isValid;
	}

}
