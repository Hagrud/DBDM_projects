package closure.algorithms;

import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class ImprovedAlgorithm implements Algorithm{
	
	private SortedSet<FD> Sigma;
	private AttributeSet Atts;
	
	boolean valid = false;
	
	public ImprovedAlgorithm(SortedSet<FD> Sigma, AttributeSet Atts){
		this.Sigma = Sigma;
		this.Atts = Atts;
	}

	public void run() {
		HashMap<FD, Integer> count = new HashMap<FD, Integer>();
		HashMap<String, Set<FD>> list = new HashMap<String, Set<FD>>();
		
		// construction of indices
		for(FD fd : Sigma){
			count.put(fd, fd.getLeft().size());
			for(String A : fd.getLeft().getSet()){
				if(!list.containsKey(A))
					list.put(A, new TreeSet<FD>());
				list.get(A).add(fd);
			}
		}
		
		AttributeSet closure = Atts.copy();
		AttributeSet update = Atts.copy();
				
		while(!update.isEmpty()){			
			String A = update.pop();
			
			if(!list.containsKey(A))
				continue;
			
			for(FD fd : list.get(A)){
				count.put(fd, count.get(fd) - 1);
				if(count.get(fd) == 0){
					update.addAttributes(fd.getRight().without(closure));
					closure.addAttributes(fd.getRight());
				}
			}
		}
		
		this.Atts = closure;
	}

	public boolean isValid() {
		return this.valid;
	}
	
	public String toString(){
		return Atts.toString();
	}

	public void setAtts(AttributeSet atts) {
		this.Atts = atts;
	}

	public AttributeSet getSet() {
		return this.Atts;
	}

}
