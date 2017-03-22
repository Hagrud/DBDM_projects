package closure.algorithms;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class ImprovedAlgorithm implements Algorithm{
	
	SortedSet<FD> Sigma;
	AttributeSet Atts;
	
	boolean valid = false;
	
	public ImprovedAlgorithm(SortedSet<FD> Sigma, AttributeSet Atts){
		this.Sigma = Sigma;
		this.Atts = Atts;
	}

	@Override
	public void run() {
		HashMap<FD, Integer> count = new HashMap<FD, Integer>();
		HashMap<String, Set<FD>> list = new HashMap<String, Set<FD>>();
		
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
			for(FD fd : list.get(A)){
				count.put(fd, count.get(fd) - 1);
				if(count.get(fd) == 0){
					update.addAttributes(fd.getRight().without(closure));
					closure.addAttributes(fd.getRight());
				}
			}
		}
	}

	@Override
	public boolean isValid() {
		return this.valid;
	}
	
	public String toString(){
		return Atts.toString();
	}

}