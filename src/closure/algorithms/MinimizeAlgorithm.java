package closure.algorithms;

import java.util.SortedSet;
import java.util.TreeSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class MinimizeAlgorithm implements Algorithm{

	boolean isValid = false;
	SortedSet<FD> fds;
	SortedSet<FD> G = new TreeSet<FD>();
	
	public MinimizeAlgorithm(SortedSet<FD> fdSet){
		this.fds = fdSet;
	}
	
	public void setAtts(AttributeSet atts){}
	
	public AttributeSet getSet(){
		return null;
	}
	
	public SortedSet<FD> getFdSet(){
		return G;
	}
	
	public void run(){
		ImprovedAlgorithm closure = new ImprovedAlgorithm(fds, null);
		
		for(FD fd : fds){
			closure.setAtts(fd.getLeft());
			closure.run();
			G.add(new FD(fd.getLeft(), closure.getSet()));
		}
		
		for(FD fd : G){
			G.remove(fd);
			closure = new ImprovedAlgorithm(G, fd.getLeft());
			closure.run();
			
			if(!closure.getSet().include(fd.getRight())){
				G.add(fd);
			}
		}
	}
		
	public boolean isValid(){
		return this.isValid();
	}
	
}
