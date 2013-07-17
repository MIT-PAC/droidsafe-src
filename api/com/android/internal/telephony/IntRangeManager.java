package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class IntRangeManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.466 -0400", hash_original_field = "2B355984BC5EB38E49D845FCB0D77019", hash_generated_field = "E43FB0C78759432184E49407A51B5267")

    private ArrayList<IntRange> mRanges = new ArrayList<IntRange>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.466 -0400", hash_original_method = "362FA502CCB486C4D0A9F66987CBC492", hash_generated_method = "22D07BAE17359B60391CE9F4DA674915")
    protected  IntRangeManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.470 -0400", hash_original_method = "6ED59671D51F9C9BA7262BED5BB50C74", hash_generated_method = "F64EC28FF5201D94D5E25E08911CDDFE")
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
                boolean varB326B5062B2F0E69046810717534CB09_185292284 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063431088 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063431088;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1590031140 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593856435 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593856435;
            } //End block
        } //End block
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
                        boolean varB326B5062B2F0E69046810717534CB09_687668985 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_543685802 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_543685802;
                    } //End block
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_693908639 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944244457 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944244457;
                    } //End block
                } //End block
                else
                if(endId <= range.endId)                
                {
                    if(tryAddSingleRange(startId, range.startId - 1, true))                    
                    {
                        range.startId = startId;
                        range.clients.add(0, new ClientRange(startId, endId, client));
                        boolean varB326B5062B2F0E69046810717534CB09_1987752964 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856678942 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856678942;
                    } //End block
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1302057666 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826695178 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_826695178;
                    } //End block
                } //End block
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
                                } //End block
                                boolean varB326B5062B2F0E69046810717534CB09_162956706 = (true);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967708512 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967708512;
                            } //End block
                            else
                            {
                                boolean var68934A3E9455FA72420237EB05902327_1641957013 = (false);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1909268811 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1909268811;
                            } //End block
                        } //End block
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
                                } //End block
                                boolean varB326B5062B2F0E69046810717534CB09_796638251 = (true);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_31021066 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_31021066;
                            } //End block
                            else
                            {
                                boolean var68934A3E9455FA72420237EB05902327_733385272 = (false);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742205771 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_742205771;
                            } //End block
                        } //End block
                    } //End block
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
                        } //End block
                        boolean varB326B5062B2F0E69046810717534CB09_1014359717 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243570592 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_243570592;
                    } //End block
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_92196551 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283261222 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_283261222;
                    } //End block
                } //End block
            } //End block
            else
            if((startId + 1) <= range.endId)            
            {
                if(endId <= range.endId)                
                {
                    range.insert(new ClientRange(startId, endId, client));
                    boolean varB326B5062B2F0E69046810717534CB09_273040430 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679327333 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679327333;
                } //End block
                else
                {
                    int endIndex = startIndex;
for(int testIndex = startIndex+1;testIndex < len;testIndex++)
                    {
                        IntRange testRange = mRanges.get(testIndex);
                        if((endId + 1) < testRange.startId)                        
                        {
                            break;
                        } //End block
                        else
                        {
                            endIndex = testIndex;
                        } //End block
                    } //End block
                    if(endIndex == startIndex)                    
                    {
                        if(tryAddSingleRange(range.endId + 1, endId, true))                        
                        {
                            range.endId = endId;
                            range.insert(new ClientRange(startId, endId, client));
                            boolean varB326B5062B2F0E69046810717534CB09_1871854117 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421350246 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421350246;
                        } //End block
                        else
                        {
                            boolean var68934A3E9455FA72420237EB05902327_1080652058 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484328455 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_484328455;
                        } //End block
                    } //End block
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
                        } //End block
                        boolean varB326B5062B2F0E69046810717534CB09_2032895329 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790362797 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790362797;
                    } //End block
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_210755394 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997380039 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997380039;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(tryAddSingleRange(startId, endId, true))        
        {
            mRanges.add(new IntRange(startId, endId, client));
            boolean varB326B5062B2F0E69046810717534CB09_1917981382 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231436139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231436139;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1861548518 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757488469 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_757488469;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.475 -0400", hash_original_method = "3E9B5A2BDD46323741EF7C361F65FFEC", hash_generated_method = "B7785574D488F25318E6F263EFE2ED47")
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
                boolean var68934A3E9455FA72420237EB05902327_806746937 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_877332213 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_877332213;
            } //End block
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
                            boolean varB326B5062B2F0E69046810717534CB09_2041933825 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2054630447 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2054630447;
                        } //End block
                        else
                        {
                            boolean var68934A3E9455FA72420237EB05902327_687499588 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413106904 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_413106904;
                        } //End block
                    } //End block
                    else
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1963439812 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359817144 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_359817144;
                    } //End block
                } //End block
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
                                boolean varB326B5062B2F0E69046810717534CB09_1449031487 = (true);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084866455 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084866455;
                            } //End block
                            else
                            {
                                if(tryAddSingleRange(largestEndId + 1, range.endId, false))                                
                                {
                                    clients.remove(crIndex);
                                    range.endId = largestEndId;
                                    boolean varB326B5062B2F0E69046810717534CB09_1351775241 = (true);
                                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794497525 = getTaintBoolean();
                                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_794497525;
                                } //End block
                                else
                                {
                                    boolean var68934A3E9455FA72420237EB05902327_1923279109 = (false);
                                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949758328 = getTaintBoolean();
                                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_949758328;
                                } //End block
                            } //End block
                        } //End block
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
                            } //End block
                            largestEndId = clients.get(1).endId;
                        } //End block
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
                                } //End block
                                addRange(largestEndId + 1, nextCr.startId - 1, false);
                                currentRange.endId = largestEndId;
                                newRanges.add(currentRange);
                                currentRange = new IntRange(nextCr);
                            } //End block
                            else
                            {
                                currentRange.clients.add(nextCr);
                            } //End block
                            if(nextCr.endId > largestEndId)                            
                            {
                                largestEndId = nextCr.endId;
                            } //End block
                        } //End block
                        if(largestEndId < endId)                        
                        {
                            if(!updateStarted)                            
                            {
                                startUpdate();
                                updateStarted = true;
                            } //End block
                            addRange(largestEndId + 1, endId, false);
                            currentRange.endId = largestEndId;
                        } //End block
                        newRanges.add(currentRange);
                        if(updateStarted && !finishUpdate())                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_1248180248 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929236806 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929236806;
                        } //End block
                        mRanges.remove(i);
                        mRanges.addAll(i, newRanges);
                        boolean varB326B5062B2F0E69046810717534CB09_1198114893 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676466259 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676466259;
                    } //End block
                    else
                    {
                        if(cr.endId > largestEndId)                        
                        {
                            largestEndId = cr.endId;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_452812138 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578416084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578416084;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.477 -0400", hash_original_method = "6D2ABBA8943E817B6A7F4354584C0478", hash_generated_method = "BB2AFD05EF20B51EE006D7C0CDDE52BF")
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
                    } //End block
                } //End block
                else
                {
                    addRange(start, end, true);
                    start = nextNode.startId;
                    end = nextNode.endId;
                } //End block
            } //End block
            addRange(start, end, true);
        } //End block
        boolean var4C3605E2FED9FB10BADCCCDB35A8BC62_538989566 = (finishUpdate());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276732279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276732279;
        // ---------- Original Method ----------
        //startUpdate();
        //Iterator<IntRange> iterator = mRanges.iterator();
        //if (iterator.hasNext()) {
            //IntRange range = iterator.next();
            //int start = range.startId;
            //int end = range.endId;
            //while (iterator.hasNext()) {
                //IntRange nextNode = iterator.next();
                //if (nextNode.startId <= (end + 1)) {
                    //if (nextNode.endId > end) {
                        //end = nextNode.endId;
                    //}
                //} else {
                    //addRange(start, end, true);
                    //start = nextNode.startId;
                    //end = nextNode.endId;
                //}
            //}
            //addRange(start, end, true);
        //}
        //return finishUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.478 -0400", hash_original_method = "66D9B78BD0A6572F2D23304F41F243DE", hash_generated_method = "8577E280E3F439E9EE1DFE04987B3778")
    private boolean tryAddSingleRange(int startId, int endId, boolean selected) {
        addTaint(selected);
        addTaint(endId);
        addTaint(startId);
        startUpdate();
        addRange(startId, endId, selected);
        boolean var4C3605E2FED9FB10BADCCCDB35A8BC62_503382589 = (finishUpdate());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070868092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070868092;
        // ---------- Original Method ----------
        //startUpdate();
        //addRange(startId, endId, selected);
        //return finishUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.478 -0400", hash_original_method = "3535E42AC2A5B7497897BAD158CB88AF", hash_generated_method = "AB450A5AE37EB5595FC3FD76B5423B4F")
    public boolean isEmpty() {
        boolean var4A182B3170A47CB458F8C45AB3739898_2117226749 = (mRanges.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573242658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_573242658;
        // ---------- Original Method ----------
        //return mRanges.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void startUpdate();

    
    @DSModeled(DSC.SAFE)
    protected abstract void addRange(int startId, int endId, boolean selected);

    
    @DSModeled(DSC.SAFE)
    protected abstract boolean finishUpdate();

    
    private class IntRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.479 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.479 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.479 -0400", hash_original_field = "FAC04CA68A48AF91F0290001604A2463", hash_generated_field = "DD30F90F1DFDA1050591F66AD1E9CE7F")

        ArrayList<ClientRange> clients;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.479 -0400", hash_original_method = "F07B82A28B52231FBB76629ABCB97069", hash_generated_method = "FD85D7559ED4C2DA87E049FBBEC805FE")
          IntRange(int startId, int endId, String client) {
            addTaint(client.getTaint());
            this.startId = startId;
            this.endId = endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(new ClientRange(startId, endId, client));
            // ---------- Original Method ----------
            //this.startId = startId;
            //this.endId = endId;
            //clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            //clients.add(new ClientRange(startId, endId, client));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.480 -0400", hash_original_method = "BA7832996744AA8092A9A5E21086E160", hash_generated_method = "7BA355DFC1B6681CD4E3AA92366DAC86")
          IntRange(ClientRange clientRange) {
            startId = clientRange.startId;
            endId = clientRange.endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(clientRange);
            // ---------- Original Method ----------
            //startId = clientRange.startId;
            //endId = clientRange.endId;
            //clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            //clients.add(clientRange);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.480 -0400", hash_original_method = "A2EC39EA4DD73652B403D173FB1236C3", hash_generated_method = "44C32759AE6D6E3731B44420940816D3")
          IntRange(IntRange intRange, int numElements) {
            addTaint(numElements);
            this.startId = intRange.startId;
            this.endId = intRange.endId;
            this.clients = new ArrayList<ClientRange>(intRange.clients.size());
for(int i=0;i < numElements;i++)
            {
                this.clients.add(intRange.clients.get(i));
            } //End block
            // ---------- Original Method ----------
            //this.startId = intRange.startId;
            //this.endId = intRange.endId;
            //this.clients = new ArrayList<ClientRange>(intRange.clients.size());
            //for (int i=0; i < numElements; i++) {
                //this.clients.add(intRange.clients.get(i));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.481 -0400", hash_original_method = "5E2FBB55D30010C4D5AE540EBBAC773C", hash_generated_method = "FCC2076617B797DAE19D182A91CC8E0E")
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
                    } //End block
                    return;
                } //End block
            } //End block
            clients.add(range);
            // ---------- Original Method ----------
            //int len = clients.size();
            //for (int i=0; i < len; i++) {
                //ClientRange nextRange = clients.get(i);
                //if (range.startId <= nextRange.startId) {
                    //if (!range.equals(nextRange)) {
                        //clients.add(i, range);
                    //}
                    //return;
                //}
            //}
            //clients.add(range);
        }

        
    }


    
    private class ClientRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.481 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.481 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.481 -0400", hash_original_field = "62608E08ADC29A8D6DBC9754E659F125", hash_generated_field = "B53CFB15BD6573E83D2588E535C40087")

        String client;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.481 -0400", hash_original_method = "0233CEEC110E7548B64806A81A8747BD", hash_generated_method = "8A9C28D210140B4512C21C49AFDD4E38")
          ClientRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            this.client = client;
            // ---------- Original Method ----------
            //this.startId = startId;
            //this.endId = endId;
            //this.client = client;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.481 -0400", hash_original_method = "1032526D9DAEE515FA8C17531DBF15E9", hash_generated_method = "D28323F08164C1046E14F8271E492993")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            if(o != null && o instanceof ClientRange)            
            {
                ClientRange other = (ClientRange) o;
                boolean varAD32CB64BCB0205319B7E8E441350216_982686301 = (startId == other.startId &&
                        endId == other.endId &&
                        client.equals(other.client));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1254641423 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1254641423;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_936158282 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787880347 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_787880347;
            } //End block
            // ---------- Original Method ----------
            //if (o != null && o instanceof ClientRange) {
                //ClientRange other = (ClientRange) o;
                //return startId == other.startId &&
                        //endId == other.endId &&
                        //client.equals(other.client);
            //} else {
                //return false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.482 -0400", hash_original_method = "0C827ECC35335C49789EB5A12C0D3470", hash_generated_method = "6623FA6D786FE85C76A7E9EF1204D982")
        @Override
        public int hashCode() {
            int var4844D2584D9A8987A29943F2F0DD954C_2144218452 = ((startId * 31 + endId) * 31 + client.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_609825716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_609825716;
            // ---------- Original Method ----------
            //return (startId * 31 + endId) * 31 + client.hashCode();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.482 -0400", hash_original_field = "34FA81EDAFCA80AF9B9CF345E4A5F242", hash_generated_field = "755EBFB204022DB38615C127DE53EE61")

    private static final int INITIAL_CLIENTS_ARRAY_SIZE = 4;
}

