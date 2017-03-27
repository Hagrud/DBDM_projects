package closure.algorithms;

import closure.data.AttributeSet;

public interface Algorithm {
	
	public void setAtts(AttributeSet atts);
	
	public AttributeSet getSet();
	
	public void run();
		
	public boolean isValid();

}
