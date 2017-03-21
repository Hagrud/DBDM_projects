package closure.data;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class AttributeSet implements Comparable<AttributeSet> {

	SortedSet<String> set;
	public AttributeSet(){
		this.set = new TreeSet<String>();
	}
	
	public AttributeSet(SortedSet<String> set){
		this.set = set;
	}
	
	public void addAttribute(String attribute){
		this.set.add(attribute);
	}
	
	public void addAttributes(AttributeSet AttSet){
		for(String attribute : AttSet.set){
			this.addAttribute(attribute);
		}
	}
	
	@Override
	public int compareTo(AttributeSet other) {
		Iterator<String> a = this.set.iterator();
		Iterator<String> b = other.set.iterator();
		
		while(a.hasNext() && b.hasNext()){
			int res = a.next().compareTo(b.next());
			if(res != 0)
				return res;
		}
		
		if(a.hasNext())
			return 1;
		if(b.hasNext())
			return -1;
	
		return 0;
	}
	
	public boolean include(AttributeSet other){
		Iterator<String> a = this.set.iterator();
		Iterator<String> b = other.set.iterator();
		
		if(!b.hasNext())
			return true;
		
		String valOther = b.next();
		
		while(a.hasNext()){			
			String valThis = a.next();
			int compar = valThis.compareTo(valOther);
			if(compar == -1){
				return false;
			}
			else if(compar == 0){
				if(!b.hasNext())
					return true;
				
				valOther = b.next();	
			}
		}
		
		return false;
	}
	
	public String toString(){
		String out = "";
		Iterator<String> a = set.iterator();
		
		while(a.hasNext()){
			out = out + a.next() + " ";
		}
		
		
		return out;
	}
}
