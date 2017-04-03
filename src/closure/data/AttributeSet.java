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
		if(attribute.equals(""))
			return;
		this.set.add(attribute);
	}
	
	public void addAttributes(AttributeSet AttSet){
		for(String attribute : AttSet.set){
			this.addAttribute(attribute);
		}
	}
	
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
			if(compar > 0){
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
	
	public SortedSet<String> getSet(){
		return this.set;
	}
	
	public AttributeSet copy(){
		AttributeSet newSet = new AttributeSet();
		newSet.addAttributes(this);
		return newSet;
	}
	
	public void remove(String attribute){
		this.set.remove(attribute);
	}
	
	public String pop(){
		String first = this.set.first();
		this.set.remove(first);
		return first;
	}

	public boolean isEmpty() {
		return this.set.isEmpty();
	}

	public int size() {
		return this.set.size();
	}
	
	public AttributeSet without(String att){
		AttributeSet temp = new AttributeSet();
		temp.addAttribute(att);
		return this.without(temp);
	}

	public AttributeSet without(AttributeSet other) {
		AttributeSet newSet = new AttributeSet();
		newSet.set = new TreeSet<String>(this.set);
		newSet.remove(other.set);
		return newSet;
	}
	
	protected void remove(SortedSet<String> toRemove){
		this.set.removeAll(toRemove);
	}
}
