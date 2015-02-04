
/**
 * Write a description of class FlowerGarden here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlowerGarden
{
    // instance variables - replace the example below with your own
    int nextOrder[],nextOrderBloom[],nextOrderWilt[];
    public int [] getOrdering (int height[], int bloom[], int wilt[])
    {
        int order[] = new int [height.length];
        nextOrder = new int[height.length];
        nextOrderBloom = new int[height.length];
        nextOrderWilt = new int[height.length];
        int orderBloom[] = new int [height.length];
        int orderWilt[] = new int [height.length];
        for (int loopCount=0;loopCount<order.length;++loopCount)
            { order[loopCount] = 0; orderBloom[loopCount]=0; orderWilt[loopCount]=0;}
        order[0] = height[0];
        orderBloom[0] = bloom[0];
        orderWilt[0] = wilt[0];
       System.out.println("First Line");
        for(int loopCount = 1;loopCount <height.length;++loopCount)
        {
            for (int iLoopCount =0; iLoopCount<loopCount;++iLoopCount)
            {
                if(height[loopCount]>order[iLoopCount])
                {
                   
                    if ((bloom[loopCount]>orderWilt[iLoopCount]) || (wilt[loopCount]<orderBloom[iLoopCount])) 
                       { System.out.println("Height is: "+height[loopCount]+" Order Height is: "+order[iLoopCount]+"\nBloom is: "+bloom[loopCount]+" Order Bloom is: "+orderBloom[iLoopCount]+"\nWilt is: "+wilt[loopCount]+" Order Wilt is: "+orderWilt[iLoopCount]);
                           createNewOrder(order,orderBloom,orderWilt,iLoopCount,"before",height[loopCount],bloom[loopCount],wilt[loopCount],loopCount); }
                    else if ((bloom[loopCount]<orderWilt[iLoopCount]) || (wilt[loopCount]>=orderBloom[iLoopCount]))    
                        {System.out.println("Height is: "+height[loopCount]+" Order Height is: "+order[iLoopCount]+"\nBloom is: "+bloom[loopCount]+" Order Bloom is: "+orderBloom[iLoopCount]+"\nWilt is: "+wilt[loopCount]+" Order Wilt is: "+orderWilt[iLoopCount]);createNewOrder(order,orderBloom,orderWilt,iLoopCount,"after",height[loopCount],bloom[loopCount],wilt[loopCount],loopCount); }
                }
                else if(height[loopCount]<order[iLoopCount])
                {
                    
                 if ( orderBloom[iLoopCount]> wilt[loopCount] || orderWilt[iLoopCount] < bloom [loopCount])
                        {
                            System.out.println("Height is: "+height[loopCount]+" Order Height is: "+order[iLoopCount]+"\nBloom is: "+bloom[loopCount]+" Order Bloom is: "+orderBloom[iLoopCount]+"\nWilt is: "+wilt[loopCount]+" Order Wilt is: "+orderWilt[iLoopCount]);
                            createNewOrder(order,orderBloom,orderWilt,iLoopCount,"after",height[loopCount],bloom[loopCount],wilt[loopCount],loopCount); }
                  else if ((orderBloom[iLoopCount] <wilt[loopCount]) || (orderWilt[iLoopCount] >= bloom[loopCount]))    
                        {System.out.println("Height is: "+height[loopCount]+" Order Height is: "+order[iLoopCount]+"\nBloom is: "+bloom[loopCount]+" Order Bloom is: "+orderBloom[iLoopCount]+"\nWilt is: "+wilt[loopCount]+" Order Wilt is: "+orderWilt[iLoopCount]);
                            createNewOrder(order,orderBloom,orderWilt,iLoopCount,"before",height[loopCount],bloom[loopCount],wilt[loopCount],loopCount); }
                    
                    
                }
            }
        System.arraycopy(nextOrder,0,order,0,order.length);
        System.arraycopy(nextOrderBloom,0,orderBloom,0,order.length);
        System.arraycopy(nextOrderWilt,0,orderWilt,0,order.length);
        /*System.out.println();
        for(int iLoopCount=0;iLoopCount<order.length;++iLoopCount)
            System.out.print(order[iLoopCount]+" ");*/
        }
        return order;
    }
    
    private void createNewOrder(int order[],int orderBloom[],int orderWilt[],int pos, String where, int ele,int eleB,int eleW,int orderLength)
    {
        int orderCounter = 0; int flag=-1;
        for (int loopCount = 0; loopCount <nextOrder.length;++loopCount)
          if(nextOrder[loopCount]== ele) flag =loopCount;
        
          
       
            
        if((flag <=pos && where.equals("after")) || (flag >= pos && where.equals("before")) || flag==-1)
            {
                 for (int loopCount = 0; loopCount <nextOrder.length;++loopCount)
            nextOrder[loopCount] = 0;
        for(int loopCount = 0; loopCount < (orderLength+1);++ loopCount)
        {
            if(loopCount == pos && where.equals("before"))
            {
                nextOrder[loopCount] = ele;
                nextOrderBloom[loopCount] = eleB;
                nextOrderWilt[loopCount] = eleW;
                nextOrder[++loopCount] = order[pos];
                nextOrderBloom[loopCount] = orderBloom[pos];
                nextOrderWilt[loopCount] = orderWilt[pos];
                orderCounter +=1;
            }
            else if(loopCount == pos && where.equals("after") )
            {
                System.out.println("After executed");
                nextOrder[loopCount] = order[pos];
                nextOrderBloom[loopCount] = orderBloom[pos];
                nextOrderWilt[loopCount] = orderWilt[pos];
                nextOrder[++loopCount] = ele;
                 nextOrderBloom[loopCount] = eleB;
                nextOrderWilt[loopCount] = eleW;
                orderCounter +=1;
            }
            else 
            {
                nextOrderBloom[loopCount] = orderBloom[orderCounter];
                nextOrderWilt[loopCount] = orderWilt[orderCounter];
                nextOrder[loopCount] = order[orderCounter++];
            }
           
            }
        }
    }
        
        
    }
    
    

