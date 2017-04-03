package closure.algorithms;

import java.util.SortedSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class NaiveClosure implements Algorithm{

	SortedSet<FD> Sigma;
	AttributeSet Atts;
	
	boolean valid = false;
	
	public NaiveClosure(SortedSet<FD> Sigma, AttributeSet Atts){
		this.Sigma = Sigma;
		this.Atts = Atts;
	}
	
	public void run() {
		while(!this.valid){
			this.valid = true;
			for(FD  fd: Sigma){
				if(Atts.include(fd.getLeft()) && !Atts.include(fd.getRight())){
					Atts.addAttributes(fd.getRight());
					this.valid = false;
				}
			}
		}
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
