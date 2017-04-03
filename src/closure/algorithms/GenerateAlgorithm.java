package closure.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class GenerateAlgorithm implements Algorithm{

	
	SortedSet<FD> fds = new TreeSet<FD>();
	
	/*
	 * As we used SortedSet in the algorithm we need to use a non sorted type
	 * to create a shuffle output.
	 */
	ArrayList<FD> fds_shuffle = new ArrayList<FD>();
	
	int n = 0;
	boolean finish = false;
	
	public GenerateAlgorithm(int n){
		this.n = n;
	}
	
	public void run() {
		
		for(int i = 0; i < n; i++){
			AttributeSet left = new AttributeSet();
			left.addAttribute(Integer.toString(i));
			
			AttributeSet right = new AttributeSet();
			right.addAttribute(Integer.toString(i+1));
			
			FD fd = new FD(left, right);
			this.fds.add(fd);
			this.fds_shuffle.add(fd);
		}
		
		Collections.shuffle(this.fds_shuffle);
		this.finish = true;
	}

	public boolean isValid() {
		return this.finish;
	}
	
	public String toString(){
		String ret = "";
		
		for(FD fd: this.fds_shuffle){
			ret = ret + fd.toString() + "\n";
		}
		
		return ret;
	}
	
	public SortedSet<FD> getFDs(){
		return this.fds;
	}

	public void setAtts(AttributeSet atts) {
		//Nothing to do.
	}

	public AttributeSet getSet() {
		return null;
	}

}
