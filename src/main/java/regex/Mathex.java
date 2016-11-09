package regex;

public class Mathex {
	
	
	public static void main(String[] args){
		
		String str = "2**2**3**1*2",reduced="";
		Mathex mathex = new Mathex();
		try{
			
			while(!reduced.equals(str)){
				
				reduced = mathex.reduce(str);
				System.out.println("Reduced Expr = " + reduced);
				str = reduced;
				
			}
		}catch (Exception e){
			System.out.println(e.getMessage() + "SYNTAX ERROR");
		}
		
		
	}
	
	public String reduce(String str){
		int startIdx = str.indexOf("**");
		if(startIdx == -1){
			return str;
		}
		String prefix = str.substring(0, startIdx);
		int lastStrInPrefixIdx = prefix.lastIndexOf("*");
		int a = Integer.valueOf(prefix.substring(lastStrInPrefixIdx+1));
		int b = Character.getNumericValue(str.charAt(startIdx+2));
		System.out.println(a+","+b);
		String prefixPiece = "";
		if(lastStrInPrefixIdx != -1){
			prefixPiece = prefix.substring(0, lastStrInPrefixIdx);
		}
		String suffixPiece = "";
		if(startIdx+3 < str.length()){
			suffixPiece = str.substring(startIdx+3);
		}
		System.out.print(prefixPiece+","+suffixPiece);
		String reducedExpr = prefixPiece + (int)Math.pow(a, b) + suffixPiece;
		return reducedExpr;
		
	}
	

}
