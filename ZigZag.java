
/**
 * Write a description of class ZigZag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZigZag
{
   public static void main (String arg[])
   {
       
       if(arg.length>50)System.out.println("Number of elements exceed the limit");
       else
       {
           boolean withinLimit = true;
           int inputElements [] = new int[arg.length];
           for (int loopCount=0;loopCount<arg.length;++loopCount)
           {
               inputElements [loopCount] = Integer.parseInt(arg[loopCount]);
               if(inputElements [loopCount]>1000 || inputElements [loopCount]<0)
               {
                   System.out.println(inputElements [loopCount] + " is beyond allowed range");
                   withinLimit = false;
                   break;
               }
           }
           
           if(withinLimit) System.out.println("Maximum Length: "+new ZigZag().longestZigZag(inputElements));
           }
       
       
   }
   
   public int longestZigZag(int arg[])
   {
       int currentLength = 1, previousIndicator = 0, tempPrev = 0, greatestLength =1;
       
       tempPrev = arg[0];
               for(int loopCount=1;loopCount<arg.length;++loopCount)
               {
                   int tempCurr = arg[loopCount]; 
                   if(loopCount<arg.length && currentLength==1)
                       {
                       currentLength +=1;
                       if(currentLength>greatestLength) greatestLength = currentLength;
                       }
                       else
                       {
                           if(((tempCurr - tempPrev) > 0 && previousIndicator < 0) || 
                                ((tempCurr - tempPrev) < 0 && previousIndicator > 0))
                                  {
                                      currentLength +=1;
                                      if(currentLength > greatestLength)
                                        greatestLength = currentLength;
                                  }
                           
                                
                       }
                       if ((tempCurr - tempPrev)>0) previousIndicator = 1;
                           else if ((tempCurr - tempPrev)<0) previousIndicator = -1;
                           tempPrev = tempCurr;    
               }
   
    return greatestLength;
            }
}
