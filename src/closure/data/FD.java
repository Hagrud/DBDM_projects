package closure.data;

public class FD implements Comparable<FD>{
	
	AttributeSet left;
	AttributeSet right;
	public FD(AttributeSet left, AttributeSet right){
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int compareTo(FD other) {
		int res = left.compareTo(other.left);
		if(res != 0)
			return res;
		return right.compareTo(other.right);
	}
	
	public String toString(){
		return left.toString() + "-> " + right.toString();
	}

}
