
/**
 * Write a description of class BadNeighbours here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadNeighbours
{
    // instance variables - replace the example below with your own
    int args[];
    int maxD=0,temp=0;
    public int maxDonations (int arg[])
    {
        args = new int[arg.length];
        for (int loopCount =0;loopCount<arg.length;++loopCount)
        {
            System.arraycopy(arg,0,args,0,arg.length);
            int localMaxD = args[loopCount]; 
          
            args[loopCount]=-1;
            if(loopCount==0) 
                args[args.length-1]=-1;
            else args[loopCount-1]=-1;
            if (loopCount == args.length-1)
                args[0] = -1;
            else args[loopCount+1]=-1;
           
            while((temp = max())!=0)
            localMaxD += temp;
         
            if(maxD<localMaxD) maxD = localMaxD;
            
        }
        return maxD;
    
    }
    
    private int max()
    {
        int maxIndex = 0, maxValue =0;
        
        for (int loopCount =0;loopCount < args.length; ++loopCount)
            if(args[loopCount]>maxValue)
            {
                maxValue = args[loopCount];
                maxIndex = loopCount;
            }
          
            if (maxValue==0) return 0;
            else{
                    int pMaxIndex = 0, nMaxIndex =0, temp=0;
                   
                    pMaxIndex = getPrevIndex(maxIndex);
                    nMaxIndex = getNextIndex(maxIndex);
                    if((temp = args[pMaxIndex]+args[nMaxIndex])>args[maxIndex])
                       {
                           args[maxIndex]=-1;
                           args[pMaxIndex]=-1;
                           args[nMaxIndex]=-1;
                           args[getPrevIndex(pMaxIndex)] = -1;
                           args[getNextIndex(nMaxIndex)] = -1;
                          
                          
                           return temp;
                        }
                     else
                     {
                         args[maxIndex] = -1;
                         args[pMaxIndex]= -1;
                         args[nMaxIndex]=-1;
                         
                         return maxValue;   
                     }   
                
                }
            }
            private int getPrevIndex(int index)
            {
                if(index==0) 
                        return args.length -1;
                    else return index -1;
            } 
            
            private int getNextIndex(int index)
            {
                if (index == args.length-1)
                            return 0;
                        else return index +1; 
            } 
}
