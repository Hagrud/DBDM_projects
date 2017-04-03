package closure.algorithms;

import java.util.SortedSet;
import java.util.TreeSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class ReduceAlgorithm implements Algorithm{
	
	SortedSet<FD> fds;
	SortedSet<FD> Min;
	SortedSet<FD> G;
	
	public ReduceAlgorithm(SortedSet<FD> fds){
		this.fds = fds;	
		this.Min = new TreeSet<FD>(fds);
	}

	public void setAtts(AttributeSet atts) {
		
	}

	public AttributeSet getSet() {
		return null;
	}
	
	public SortedSet<FD> getFdSet(){
		return Min;
	}

	public void run() {
		for(FD fd : fds){
			AttributeSet W = fd.getRight();
			// issue here in case of !TreeSet
			G = new TreeSet<FD>(Min);
			G.remove(fd);
			for(String A : fd.getRight().getSet()){
				AttributeSet Wcp = W.without(A);
				G.add(new FD(fd.getLeft(), Wcp));
				
				ImprovedAlgorithm algo = new ImprovedAlgorithm(G, null);
				if(Tools.SigmaProve(fd, algo)){
					W = Wcp;
				}
			}
			
			Min.remove(fd);
			Min.add(new FD(fd.getLeft(), W));
		}
	}

	public boolean isValid() {
		return false;
	}

}
