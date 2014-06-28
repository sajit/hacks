package regex;

/**
 * Created by skunnumkal on 6/27/14.
 *
 * Known limitations
 * doesnt match assertThat(RegexMatcher.isMatch("aa","a*b*a")).isTrue();
 *
 */
public class RegexMatcher {

    public static boolean isMatch(String target,String regex){
        if(target.isEmpty()){
           if(regex.isEmpty()) {
               return true;
           }
           else{ //regex not empty
               try{
                   char c = regex.charAt(1);
                   if(c == '*'){
                       return isMatch(target,regex.substring(2));
                   }
                   else return false;
               }catch (IndexOutOfBoundsException ioe){
                   return false;
               }
           }
        }
        else{ //target is not empty
              if(regex.isEmpty()){
                  return false;
              }
              else{ //regex && target not empty
                  char next = '\0',cur = regex.charAt(0);
                  try{
                      next = regex.charAt(1);

                  }catch (IndexOutOfBoundsException ioe){
                      //nothing to do
                  }
                  if(next == '*'){
                      int tIdx=0;
                      if(cur=='.'){
                         while(tIdx<target.length()){
                             tIdx++;
                         }
                          int j=2;
                          while(j<tIdx+2 && j < regex.length())
                              j++;
                         return isMatch("",regex.substring(j));
                      }
                      else{
                          while(tIdx < target.length() && target.charAt(tIdx)==cur ){
                              tIdx++;
                          }
                          int j=2;
                          while(j<tIdx+2 && j < regex.length() && regex.charAt(j) == cur)
                              j++;
                          return isMatch(target.substring(tIdx),regex.substring(j));
                      }

                  }
                  else{
                      if(cur == '.'){
                          return isMatch(target.substring(1),regex.substring(1));
                      }
                      else{
                          if(target.charAt(0)==cur) {return isMatch(target.substring(1),regex.substring(1));}
                          else
                            return false;
                      }
                  }
              }
        }


    }
}
