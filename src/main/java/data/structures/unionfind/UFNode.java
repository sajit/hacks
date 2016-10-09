package data.structures.unionfind;

public class UFNode {
	
	public final int value;
	public UFNode next;
	public int size;
	
	public UFNode(int val){
		this.value = val;
		this.next = null;
		size  = 1;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof UFNode)){
			return false;
		}
		UFNode that = (UFNode)o;
		return that.value == value;
	}
	
	@Override
	public int hashCode(){
		return value;
	}
	
	public boolean isRep(){
		return next == null;
	}

}
