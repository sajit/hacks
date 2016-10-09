package data.structures.unionfind;

import java.util.*;

public class UnionFind {
	
	/*
	 * 
    CREATE-SET(x) – creates a new set with one element {x}.
    MERGE-SETS(x, y) – merge into one set the set that contains element x and the set that contains
     element y (x and y are in different sets). The original sets will be destroyed.
	FIND-SET(x) – returns the representative or a pointer to the representative of the set that contains element x.

	 */
	private Map<Integer,UFNode> nodes = new HashMap<>();
	public void createSet(int n){
		for(int i=1;i<=n;i++){
			UFNode node = new UFNode(i);
			nodes.put(i,node);
		}
	}
	
	public UFNode mergeSet(int a,int b){
		UFNode aNodeRep = find(a);
		UFNode bNodeRep = find(b);
		if(aNodeRep.size <= bNodeRep.size){
			aNodeRep.next = bNodeRep;
			bNodeRep.size += aNodeRep.size;
			aNodeRep.size = 1;
			return bNodeRep;
		}
		else{
			bNodeRep.next = aNodeRep;
			aNodeRep.size += bNodeRep.size;
			bNodeRep.size = 1;
			return aNodeRep;
		}
		
		
	}
	
	public UFNode find(int a){
		UFNode curr = nodes.get(a);
		while(curr.next!=null){
			curr = curr.next;
		}
		return curr;
	}

}
