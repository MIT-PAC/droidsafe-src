package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class IntRangeManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.876 -0400", hash_original_field = "2B355984BC5EB38E49D845FCB0D77019", hash_generated_field = "E43FB0C78759432184E49407A51B5267")

    private ArrayList<IntRange> mRanges = new ArrayList<IntRange>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.876 -0400", hash_original_method = "362FA502CCB486C4D0A9F66987CBC492", hash_generated_method = "22D07BAE17359B60391CE9F4DA674915")
    protected  IntRangeManager() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.880 -0400", hash_original_method = "6ED59671D51F9C9BA7262BED5BB50C74", hash_generated_method = "53F6F9712BDD31CFDF86446426F881C1")
    public synchronized boolean enableRange(int startId, int endId, String client) {
        addTaint(client.getTaint());
        addTaint(endId);
        addTaint(startId);
        int len = mRanges.size();
    if(len == 0)        
        {
    if(tryAddSingleRange(startId, endId, true))            
            {
                mRanges.add(new IntRange(startId, endId, client));
                boolean varB326B5062B2F0E69046810717534CB09_1341311134 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678621476 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_678621476;
            } 
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1286627584 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044124934 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044124934;
            } 
        } 
for(int startIndex = 0;startIndex < len;startIndex++)
        {
            IntRange range = mRanges.get(startIndex);
    if(startId < range.startId)            
            {
    if((endId + 1) < range.startId)                
                {
    if(tryAddSingleRange(startId, endId, true))                    
                    {
                        mRanges.add(startIndex, new IntRange(startId, endId, client));
                        boolean varB326B5062B2F0E69046810717534CB09_1826379292 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647351967 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647351967;
                    } 
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_450817259 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579064691 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579064691;
                    } 
                } 
                else
    if(endId <= range.endId)                
                {
    if(tryAddSingleRange(startId, range.startId - 1, true))                    
                    {
                        range.startId = startId;
                        range.clients.add(0, new ClientRange(startId, endId, client));
                        boolean varB326B5062B2F0E69046810717534CB09_92902718 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411305575 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_411305575;
                    } 
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1891205371 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648691772 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648691772;
                    } 
                } 
                else
                {
for(int endIndex = startIndex+1;endIndex < len;endIndex++)
                    {
                        IntRange endRange = mRanges.get(endIndex);
    if((endId + 1) < endRange.startId)                        
                        {
    if(tryAddSingleRange(startId, endId, true))                            
                            {
                                range.startId = startId;
                                range.endId = endId;
                                range.clients.add(0, new ClientRange(startId, endId, client));
                                int joinIndex = startIndex + 1;
for(int i = joinIndex;i < endIndex;i++)
                                {
                                    IntRange joinRange = mRanges.get(joinIndex);
                                    range.clients.addAll(joinRange.clients);
                                    mRanges.remove(joinRange);
                                } 
                                boolean varB326B5062B2F0E69046810717534CB09_198388575 = (true);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016309142 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016309142;
                            } 
                            else
                            {
                                boolean var68934A3E9455FA72420237EB05902327_169284039 = (false);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_880645399 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_880645399;
                            } 
                        } 
                        else
    if(endId <= endRange.endId)                        
                        {
    if(tryAddSingleRange(startId, endRange.startId - 1, true))                            
                            {
                                range.startId = startId;
                                range.endId = endRange.endId;
                                range.clients.add(0, new ClientRange(startId, endId, client));
                                int joinIndex = startIndex + 1;
for(int i = joinIndex;i <= endIndex;i++)
                                {
                                    IntRange joinRange = mRanges.get(joinIndex);
                                    range.clients.addAll(joinRange.clients);
                                    mRanges.remove(joinRange);
                                } 
                                boolean varB326B5062B2F0E69046810717534CB09_1105584859 = (true);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243987637 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_243987637;
                            } 
                            else
                            {
                                boolean var68934A3E9455FA72420237EB05902327_265965423 = (false);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1066790580 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1066790580;
                            } 
                        } 
                    } 
    if(tryAddSingleRange(startId, endId, true))                    
                    {
                        range.startId = startId;
                        range.endId = endId;
                        range.clients.add(0, new ClientRange(startId, endId, client));
                        int joinIndex = startIndex + 1;
for(int i = joinIndex;i < len;i++)
                        {
                            IntRange joinRange = mRanges.get(joinIndex);
                            range.clients.addAll(joinRange.clients);
                            mRanges.remove(joinRange);
                        } 
                        boolean varB326B5062B2F0E69046810717534CB09_1006251487 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666081910 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666081910;
                    } 
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_838944086 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922523841 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922523841;
                    } 
                } 
            } 
            else
    if((startId + 1) <= range.endId)            
            {
    if(endId <= range.endId)                
                {
                    range.insert(new ClientRange(startId, endId, client));
                    boolean varB326B5062B2F0E69046810717534CB09_1988168179 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1957528350 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1957528350;
                } 
                else
                {
                    int endIndex = startIndex;
for(int testIndex = startIndex+1;testIndex < len;testIndex++)
                    {
                        IntRange testRange = mRanges.get(testIndex);
    if((endId + 1) < testRange.startId)                        
                        {
                            break;
                        } 
                        else
                        {
                            endIndex = testIndex;
                        } 
                    } 
    if(endIndex == startIndex)                    
                    {
    if(tryAddSingleRange(range.endId + 1, endId, true))                        
                        {
                            range.endId = endId;
                            range.insert(new ClientRange(startId, endId, client));
                            boolean varB326B5062B2F0E69046810717534CB09_1180567800 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1957280574 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1957280574;
                        } 
                        else
                        {
                            boolean var68934A3E9455FA72420237EB05902327_695098606 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105675790 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105675790;
                        } 
                    } 
                    IntRange endRange = mRanges.get(endIndex);
                    int newRangeEndId = (endId <= endRange.endId) ? endRange.startId - 1 : endId;
    if(tryAddSingleRange(range.endId + 1, newRangeEndId, true))                    
                    {
                        range.endId = endId;
                        range.insert(new ClientRange(startId, endId, client));
                        int joinIndex = startIndex + 1;
for(int i = joinIndex;i < endIndex;i++)
                        {
                            IntRange joinRange = mRanges.get(joinIndex);
                            range.clients.addAll(joinRange.clients);
                            mRanges.remove(joinRange);
                        } 
                        boolean varB326B5062B2F0E69046810717534CB09_900235969 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514550876 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_514550876;
                    } 
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1016696008 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734730209 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734730209;
                    } 
                } 
            } 
        } 
    if(tryAddSingleRange(startId, endId, true))        
        {
            mRanges.add(new IntRange(startId, endId, client));
            boolean varB326B5062B2F0E69046810717534CB09_499483722 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490803396 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_490803396;
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1731355318 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465475512 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465475512;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.890 -0400", hash_original_method = "3E9B5A2BDD46323741EF7C361F65FFEC", hash_generated_method = "D71F54CF448D0D69B8D98797C8F81B11")
    public synchronized boolean disableRange(int startId, int endId, String client) {
        addTaint(client.getTaint());
        addTaint(endId);
        addTaint(startId);
        int len = mRanges.size();
for(int i=0;i < len;i++)
        {
            IntRange range = mRanges.get(i);
    if(startId < range.startId)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1273699804 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464402460 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464402460;
            } 
            else
    if(endId <= range.endId)            
            {
                ArrayList<ClientRange> clients = range.clients;
                int crLength = clients.size();
    if(crLength == 1)                
                {
                    ClientRange cr = clients.get(0);
    if(cr.startId == startId && cr.endId == endId && cr.client.equals(client))                    
                    {
    if(tryAddSingleRange(startId, endId, false))                        
                        {
                            mRanges.remove(i);
                            boolean varB326B5062B2F0E69046810717534CB09_888893645 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79712346 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_79712346;
                        } 
                        else
                        {
                            boolean var68934A3E9455FA72420237EB05902327_789635241 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535488786 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_535488786;
                        } 
                    } 
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_2073775258 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997666411 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997666411;
                    } 
                } 
                int largestEndId = Integer.MIN_VALUE;
                boolean updateStarted = false;
for(int crIndex=0;crIndex < crLength;crIndex++)
                {
                    ClientRange cr = clients.get(crIndex);
    if(cr.startId == startId && cr.endId == endId && cr.client.equals(client))                    
                    {
    if(crIndex == crLength - 1)                        
                        {
    if(range.endId == largestEndId)                            
                            {
                                clients.remove(crIndex);
                                boolean varB326B5062B2F0E69046810717534CB09_1563120473 = (true);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232268569 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232268569;
                            } 
                            else
                            {
    if(tryAddSingleRange(largestEndId + 1, range.endId, false))                                
                                {
                                    clients.remove(crIndex);
                                    range.endId = largestEndId;
                                    boolean varB326B5062B2F0E69046810717534CB09_251692851 = (true);
                                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071119311 = getTaintBoolean();
                                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071119311;
                                } 
                                else
                                {
                                    boolean var68934A3E9455FA72420237EB05902327_169903215 = (false);
                                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041056427 = getTaintBoolean();
                                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041056427;
                                } 
                            } 
                        } 
                        IntRange rangeCopy = new IntRange(range, crIndex);
    if(crIndex == 0)                        
                        {
                            int nextStartId = clients.get(1).startId;
    if(nextStartId != range.startId)                            
                            {
                                startUpdate();
                                updateStarted = true;
                                addRange(range.startId, nextStartId - 1, false);
                                rangeCopy.startId = nextStartId;
                            } 
                            largestEndId = clients.get(1).endId;
                        } 
                        ArrayList<IntRange> newRanges = new ArrayList<IntRange>();
                        IntRange currentRange = rangeCopy;
for(int nextIndex = crIndex + 1;nextIndex < crLength;nextIndex++)
                        {
                            ClientRange nextCr = clients.get(nextIndex);
    if(nextCr.startId > largestEndId + 1)                            
                            {
    if(!updateStarted)                                
                                {
                                    startUpdate();
                                    updateStarted = true;
                                } 
                                addRange(largestEndId + 1, nextCr.startId - 1, false);
                                currentRange.endId = largestEndId;
                                newRanges.add(currentRange);
                                currentRange = new IntRange(nextCr);
                            } 
                            else
                            {
                                currentRange.clients.add(nextCr);
                            } 
    if(nextCr.endId > largestEndId)                            
                            {
                                largestEndId = nextCr.endId;
                            } 
                        } 
    if(largestEndId < endId)                        
                        {
    if(!updateStarted)                            
                            {
                                startUpdate();
                                updateStarted = true;
                            } 
                            addRange(largestEndId + 1, endId, false);
                            currentRange.endId = largestEndId;
                        } 
                        newRanges.add(currentRange);
    if(updateStarted && !finishUpdate())                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_1407177725 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92006248 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_92006248;
                        } 
                        mRanges.remove(i);
                        mRanges.addAll(i, newRanges);
                        boolean varB326B5062B2F0E69046810717534CB09_1169924303 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527473822 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_527473822;
                    } 
                    else
                    {
    if(cr.endId > largestEndId)                        
                        {
                            largestEndId = cr.endId;
                        } 
                    } 
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_476655555 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662978078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662978078;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.893 -0400", hash_original_method = "6D2ABBA8943E817B6A7F4354584C0478", hash_generated_method = "88C51EBDD06639A07A0FC92247C9B4FA")
    public boolean updateRanges() {
        startUpdate();
        Iterator<IntRange> iterator = mRanges.iterator();
    if(iterator.hasNext())        
        {
            IntRange range = iterator.next();
            int start = range.startId;
            int end = range.endId;
            while
(iterator.hasNext())            
            {
                IntRange nextNode = iterator.next();
    if(nextNode.startId <= (end + 1))                
                {
    if(nextNode.endId > end)                    
                    {
                        end = nextNode.endId;
                    } 
                } 
                else
                {
                    addRange(start, end, true);
                    start = nextNode.startId;
                    end = nextNode.endId;
                } 
            } 
            addRange(start, end, true);
        } 
        boolean var4C3605E2FED9FB10BADCCCDB35A8BC62_264727433 = (finishUpdate());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965178355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965178355;
        
        
        
        
            
            
            
            
                
                
                    
                        
                    
                
                    
                    
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.893 -0400", hash_original_method = "66D9B78BD0A6572F2D23304F41F243DE", hash_generated_method = "254A82BFD062CC254F2325B156EC0BC7")
    private boolean tryAddSingleRange(int startId, int endId, boolean selected) {
        addTaint(selected);
        addTaint(endId);
        addTaint(startId);
        startUpdate();
        addRange(startId, endId, selected);
        boolean var4C3605E2FED9FB10BADCCCDB35A8BC62_1403463620 = (finishUpdate());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293162675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_293162675;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.894 -0400", hash_original_method = "3535E42AC2A5B7497897BAD158CB88AF", hash_generated_method = "2311B614E913E74C86D58E4521BB0198")
    public boolean isEmpty() {
        boolean var4A182B3170A47CB458F8C45AB3739898_655847125 = (mRanges.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837689875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837689875;
        
        
    }

    
    protected abstract void startUpdate();

    
    protected abstract void addRange(int startId, int endId, boolean selected);

    
    protected abstract boolean finishUpdate();

    
    private class IntRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.895 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.895 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.895 -0400", hash_original_field = "FAC04CA68A48AF91F0290001604A2463", hash_generated_field = "DD30F90F1DFDA1050591F66AD1E9CE7F")

        ArrayList<ClientRange> clients;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.895 -0400", hash_original_method = "F07B82A28B52231FBB76629ABCB97069", hash_generated_method = "FD85D7559ED4C2DA87E049FBBEC805FE")
          IntRange(int startId, int endId, String client) {
            addTaint(client.getTaint());
            this.startId = startId;
            this.endId = endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(new ClientRange(startId, endId, client));
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.896 -0400", hash_original_method = "BA7832996744AA8092A9A5E21086E160", hash_generated_method = "7BA355DFC1B6681CD4E3AA92366DAC86")
          IntRange(ClientRange clientRange) {
            startId = clientRange.startId;
            endId = clientRange.endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(clientRange);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.897 -0400", hash_original_method = "A2EC39EA4DD73652B403D173FB1236C3", hash_generated_method = "44C32759AE6D6E3731B44420940816D3")
          IntRange(IntRange intRange, int numElements) {
            addTaint(numElements);
            this.startId = intRange.startId;
            this.endId = intRange.endId;
            this.clients = new ArrayList<ClientRange>(intRange.clients.size());
for(int i=0;i < numElements;i++)
            {
                this.clients.add(intRange.clients.get(i));
            } 
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.897 -0400", hash_original_method = "5E2FBB55D30010C4D5AE540EBBAC773C", hash_generated_method = "FCC2076617B797DAE19D182A91CC8E0E")
         void insert(ClientRange range) {
            addTaint(range.getTaint());
            int len = clients.size();
for(int i=0;i < len;i++)
            {
                ClientRange nextRange = clients.get(i);
    if(range.startId <= nextRange.startId)                
                {
    if(!range.equals(nextRange))                    
                    {
                        clients.add(i, range);
                    } 
                    return;
                } 
            } 
            clients.add(range);
            
            
            
                
                
                    
                        
                    
                    
                
            
            
        }

        
    }


    
    private class ClientRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.898 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.898 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.898 -0400", hash_original_field = "62608E08ADC29A8D6DBC9754E659F125", hash_generated_field = "B53CFB15BD6573E83D2588E535C40087")

        String client;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.898 -0400", hash_original_method = "0233CEEC110E7548B64806A81A8747BD", hash_generated_method = "8A9C28D210140B4512C21C49AFDD4E38")
          ClientRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            this.client = client;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.899 -0400", hash_original_method = "1032526D9DAEE515FA8C17531DBF15E9", hash_generated_method = "BAC0C8A79A3A09B3B2CEE765A8613313")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
    if(o != null && o instanceof ClientRange)            
            {
                ClientRange other = (ClientRange) o;
                boolean varAD32CB64BCB0205319B7E8E441350216_890617040 = (startId == other.startId &&
                        endId == other.endId &&
                        client.equals(other.client));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275866829 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_275866829;
            } 
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_982989317 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009481562 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009481562;
            } 
            
            
                
                
                        
                        
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.899 -0400", hash_original_method = "0C827ECC35335C49789EB5A12C0D3470", hash_generated_method = "5636465A27ADF63A6AA74957D48A1333")
        @Override
        public int hashCode() {
            int var4844D2584D9A8987A29943F2F0DD954C_921702960 = ((startId * 31 + endId) * 31 + client.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479972 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479972;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.899 -0400", hash_original_field = "34FA81EDAFCA80AF9B9CF345E4A5F242", hash_generated_field = "755EBFB204022DB38615C127DE53EE61")

    private static final int INITIAL_CLIENTS_ARRAY_SIZE = 4;
}

