package data.structures.unionfind;

public class FastUnionFind {

	private int[] uf;
	private int[] repSizes;
	public void createSet(int n){
		uf = new int[n+1];
		repSizes = new int[n+1];
		for(int i=1;i<=n;i++){
			uf[i]=i;
			repSizes[i]=1;
		}
	}
	public int find(int a){
		if(uf[a]==a){
			return a;
		}
		return find(uf[a]);
		
	}
	/**
	 * merge by union rank, ie make smaller rep point to large rep
	 * @param a
	 * @param b
	 */
	public void mergeSet(int a,int b){
		int aRep = find(a);
		int bRep = find(b);
		if(aRep != bRep){
			if(repSizes[aRep] <= repSizes[bRep]){
				uf[aRep] = uf[bRep];
				repSizes[bRep] += repSizes[aRep];
				repSizes[aRep] = 0;
			}
			else{
				uf[bRep] = uf[aRep];
				repSizes[aRep] += repSizes[bRep];
				repSizes[bRep] = 0;
			}
		}
		
		
	}
}
