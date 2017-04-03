package closure.algorithms;

import java.util.ArrayList;

import closure.data.AttributeSet;
import closure.data.FD;

public class GenerateAlgorithm implements Algorithm{

	ArrayList<FD> fds = new ArrayList<FD>();
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
			
			this.fds.add(new FD(left, right));
		}
		
		this.finish = true;
	}

	public boolean isValid() {
		return this.finish;
	}
	
	public String toString(){
		String ret = "";
		
		for(FD fd: this.fds){
			ret = ret + fd.toString() + "\n";
		}
		
		return ret;
	}

	public void setAtts(AttributeSet atts) {
		//Nothing to do.
	}

	public AttributeSet getSet() {
		return null;
	}

}
