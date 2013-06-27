package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class IntRangeManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.441 -0400", hash_original_field = "2B355984BC5EB38E49D845FCB0D77019", hash_generated_field = "E43FB0C78759432184E49407A51B5267")

    private ArrayList<IntRange> mRanges = new ArrayList<IntRange>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.441 -0400", hash_original_method = "362FA502CCB486C4D0A9F66987CBC492", hash_generated_method = "22D07BAE17359B60391CE9F4DA674915")
    protected  IntRangeManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.447 -0400", hash_original_method = "6ED59671D51F9C9BA7262BED5BB50C74", hash_generated_method = "848B69DAE87764090F226C7D9BF99F2D")
    public synchronized boolean enableRange(int startId, int endId, String client) {
        int len;
        len = mRanges.size();
        {
            {
                boolean varCA8B39A0AD4712FA5C0E11AC9C9BFF31_890489020 = (tryAddSingleRange(startId, endId, true));
                {
                    mRanges.add(new IntRange(startId, endId, client));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int startIndex;
            startIndex = 0;
            {
                IntRange range;
                range = mRanges.get(startIndex);
                {
                    {
                        {
                            boolean var8E94678DA21F04C61925B48C83058E58_1783549893 = (tryAddSingleRange(startId, endId, true));
                            {
                                mRanges.add(startIndex, new IntRange(startId, endId, client));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varBF2A1832BAA79F846F092983AA325B4A_127000207 = (tryAddSingleRange(startId, range.startId - 1, true));
                            {
                                range.startId = startId;
                                range.clients.add(0, new ClientRange(startId, endId, client));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            int endIndex;
                            endIndex = startIndex+1;
                            {
                                IntRange endRange;
                                endRange = mRanges.get(endIndex);
                                {
                                    {
                                        boolean var30E07179439B9F755ABB8CC1647E698D_59624489 = (tryAddSingleRange(startId, endId, true));
                                        {
                                            range.startId = startId;
                                            range.endId = endId;
                                            range.clients.add(0, new ClientRange(startId, endId, client));
                                            int joinIndex;
                                            joinIndex = startIndex + 1;
                                            {
                                                int i;
                                                i = joinIndex;
                                                {
                                                    IntRange joinRange;
                                                    joinRange = mRanges.get(joinIndex);
                                                    range.clients.addAll(joinRange.clients);
                                                    mRanges.remove(joinRange);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    {
                                        boolean var2703782EF85398FCA8EA7E54ABD0E6AB_1972257693 = (tryAddSingleRange(startId, endRange.startId - 1, true));
                                        {
                                            range.startId = startId;
                                            range.endId = endRange.endId;
                                            range.clients.add(0, new ClientRange(startId, endId, client));
                                            int joinIndex;
                                            joinIndex = startIndex + 1;
                                            {
                                                int i;
                                                i = joinIndex;
                                                {
                                                    IntRange joinRange;
                                                    joinRange = mRanges.get(joinIndex);
                                                    range.clients.addAll(joinRange.clients);
                                                    mRanges.remove(joinRange);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var8E94678DA21F04C61925B48C83058E58_1138632763 = (tryAddSingleRange(startId, endId, true));
                            {
                                range.startId = startId;
                                range.endId = endId;
                                range.clients.add(0, new ClientRange(startId, endId, client));
                                int joinIndex;
                                joinIndex = startIndex + 1;
                                {
                                    int i;
                                    i = joinIndex;
                                    {
                                        IntRange joinRange;
                                        joinRange = mRanges.get(joinIndex);
                                        range.clients.addAll(joinRange.clients);
                                        mRanges.remove(joinRange);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                {
                    {
                        range.insert(new ClientRange(startId, endId, client));
                    } //End block
                    {
                        int endIndex;
                        endIndex = startIndex;
                        {
                            int testIndex;
                            testIndex = startIndex+1;
                            {
                                IntRange testRange;
                                testRange = mRanges.get(testIndex);
                                {
                                    endIndex = testIndex;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            {
                                boolean varE5B7E0DF24796C7A791AC0241097AB26_299049222 = (tryAddSingleRange(range.endId + 1, endId, true));
                                {
                                    range.endId = endId;
                                    range.insert(new ClientRange(startId, endId, client));
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        IntRange endRange;
                        endRange = mRanges.get(endIndex);
                        int newRangeEndId;
                        newRangeEndId = endRange.startId - 1;
                        newRangeEndId = endId;
                        {
                            boolean var71FE50F92D32071C53F5C8473B0BA52C_1281603433 = (tryAddSingleRange(range.endId + 1, newRangeEndId, true));
                            {
                                range.endId = endId;
                                range.insert(new ClientRange(startId, endId, client));
                                int joinIndex;
                                joinIndex = startIndex + 1;
                                {
                                    int i;
                                    i = joinIndex;
                                    {
                                        IntRange joinRange;
                                        joinRange = mRanges.get(joinIndex);
                                        range.clients.addAll(joinRange.clients);
                                        mRanges.remove(joinRange);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6C371F433CAC84463755488381DCC195_1240155860 = (tryAddSingleRange(startId, endId, true));
            {
                mRanges.add(new IntRange(startId, endId, client));
            } //End block
        } //End collapsed parenthetic
        addTaint(startId);
        addTaint(endId);
        addTaint(client.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012431804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012431804;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.455 -0400", hash_original_method = "3E9B5A2BDD46323741EF7C361F65FFEC", hash_generated_method = "3C1C21EB1AE7E5CD01CED907D103F7FD")
    public synchronized boolean disableRange(int startId, int endId, String client) {
        int len;
        len = mRanges.size();
        {
            int i;
            i = 0;
            {
                IntRange range;
                range = mRanges.get(i);
                {
                    ArrayList<ClientRange> clients;
                    clients = range.clients;
                    int crLength;
                    crLength = clients.size();
                    {
                        ClientRange cr;
                        cr = clients.get(0);
                        {
                            boolean var9096A881CC606E4B6007B84895F02B97_1035193397 = (cr.startId == startId && cr.endId == endId && cr.client.equals(client));
                            {
                                {
                                    boolean varDECC80005966A3FF127C459C40D08F5A_327971868 = (tryAddSingleRange(startId, endId, false));
                                    {
                                        mRanges.remove(i);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    int largestEndId;
                    largestEndId = Integer.MIN_VALUE;
                    boolean updateStarted;
                    updateStarted = false;
                    {
                        int crIndex;
                        crIndex = 0;
                        {
                            ClientRange cr;
                            cr = clients.get(crIndex);
                            {
                                boolean var02A73763551A4A848A017E704B77DD79_643748817 = (cr.startId == startId && cr.endId == endId && cr.client.equals(client));
                                {
                                    {
                                        {
                                            clients.remove(crIndex);
                                        } //End block
                                        {
                                            {
                                                boolean var80C77B773576938BF301F47C024A2EAE_1048896471 = (tryAddSingleRange(largestEndId + 1, range.endId, false));
                                                {
                                                    clients.remove(crIndex);
                                                    range.endId = largestEndId;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End block
                                    IntRange rangeCopy;
                                    rangeCopy = new IntRange(range, crIndex);
                                    {
                                        int nextStartId;
                                        nextStartId = clients.get(1).startId;
                                        {
                                            startUpdate();
                                            updateStarted = true;
                                            addRange(range.startId, nextStartId - 1, false);
                                            rangeCopy.startId = nextStartId;
                                        } //End block
                                        largestEndId = clients.get(1).endId;
                                    } //End block
                                    ArrayList<IntRange> newRanges;
                                    newRanges = new ArrayList<IntRange>();
                                    IntRange currentRange;
                                    currentRange = rangeCopy;
                                    {
                                        int nextIndex;
                                        nextIndex = crIndex + 1;
                                        {
                                            ClientRange nextCr;
                                            nextCr = clients.get(nextIndex);
                                            {
                                                {
                                                    startUpdate();
                                                    updateStarted = true;
                                                } //End block
                                                addRange(largestEndId + 1, nextCr.startId - 1, false);
                                                currentRange.endId = largestEndId;
                                                newRanges.add(currentRange);
                                                currentRange = new IntRange(nextCr);
                                            } //End block
                                            {
                                                currentRange.clients.add(nextCr);
                                            } //End block
                                            {
                                                largestEndId = nextCr.endId;
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        {
                                            startUpdate();
                                            updateStarted = true;
                                        } //End block
                                        addRange(largestEndId + 1, endId, false);
                                        currentRange.endId = largestEndId;
                                    } //End block
                                    newRanges.add(currentRange);
                                    {
                                        boolean var66529555AC208E32BDDED3ADC3FD2C1B_1513115639 = (updateStarted && !finishUpdate());
                                    } //End collapsed parenthetic
                                    mRanges.remove(i);
                                    mRanges.addAll(i, newRanges);
                                } //End block
                                {
                                    {
                                        largestEndId = cr.endId;
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(startId);
        addTaint(endId);
        addTaint(client.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564696194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_564696194;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.456 -0400", hash_original_method = "6D2ABBA8943E817B6A7F4354584C0478", hash_generated_method = "6D329DA951A7689AF8371D109A59E2B6")
    public boolean updateRanges() {
        startUpdate();
        Iterator<IntRange> iterator;
        iterator = mRanges.iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_122047326 = (iterator.hasNext());
            {
                IntRange range;
                range = iterator.next();
                int start;
                start = range.startId;
                int end;
                end = range.endId;
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_2039525923 = (iterator.hasNext());
                    {
                        IntRange nextNode;
                        nextNode = iterator.next();
                        {
                            {
                                end = nextNode.endId;
                            } //End block
                        } //End block
                        {
                            addRange(start, end, true);
                            start = nextNode.startId;
                            end = nextNode.endId;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                addRange(start, end, true);
            } //End block
        } //End collapsed parenthetic
        boolean var5A9A2BBF0403922273ADE4623662297B_583236933 = (finishUpdate());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737462110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737462110;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.457 -0400", hash_original_method = "66D9B78BD0A6572F2D23304F41F243DE", hash_generated_method = "0C46196BBE3F77022F18CAA4E76B4295")
    private boolean tryAddSingleRange(int startId, int endId, boolean selected) {
        startUpdate();
        addRange(startId, endId, selected);
        boolean var5A9A2BBF0403922273ADE4623662297B_693934677 = (finishUpdate());
        addTaint(startId);
        addTaint(endId);
        addTaint(selected);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573742941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_573742941;
        // ---------- Original Method ----------
        //startUpdate();
        //addRange(startId, endId, selected);
        //return finishUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.457 -0400", hash_original_method = "3535E42AC2A5B7497897BAD158CB88AF", hash_generated_method = "AE80A4CE3273B55D5930C0405277CBC2")
    public boolean isEmpty() {
        boolean varE51DE8210CC866E42ADD3FBAA8AE58BF_625430026 = (mRanges.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252008394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252008394;
        // ---------- Original Method ----------
        //return mRanges.isEmpty();
    }

    
    protected abstract void startUpdate();

    
    protected abstract void addRange(int startId, int endId, boolean selected);

    
    protected abstract boolean finishUpdate();

    
    private class IntRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.468 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.469 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.469 -0400", hash_original_field = "FAC04CA68A48AF91F0290001604A2463", hash_generated_field = "DD30F90F1DFDA1050591F66AD1E9CE7F")

        ArrayList<ClientRange> clients;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.471 -0400", hash_original_method = "F07B82A28B52231FBB76629ABCB97069", hash_generated_method = "9460E9F15B3DD5EE1279A65369C68DFA")
          IntRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(new ClientRange(startId, endId, client));
            addTaint(client.getTaint());
            // ---------- Original Method ----------
            //this.startId = startId;
            //this.endId = endId;
            //clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            //clients.add(new ClientRange(startId, endId, client));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.481 -0400", hash_original_method = "BA7832996744AA8092A9A5E21086E160", hash_generated_method = "7BA355DFC1B6681CD4E3AA92366DAC86")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.493 -0400", hash_original_method = "A2EC39EA4DD73652B403D173FB1236C3", hash_generated_method = "01DB82FCB64E95B57D374A267AC7506C")
          IntRange(IntRange intRange, int numElements) {
            this.startId = intRange.startId;
            this.endId = intRange.endId;
            this.clients = new ArrayList<ClientRange>(intRange.clients.size());
            {
                int i;
                i = 0;
                {
                    this.clients.add(intRange.clients.get(i));
                } //End block
            } //End collapsed parenthetic
            addTaint(numElements);
            // ---------- Original Method ----------
            //this.startId = intRange.startId;
            //this.endId = intRange.endId;
            //this.clients = new ArrayList<ClientRange>(intRange.clients.size());
            //for (int i=0; i < numElements; i++) {
                //this.clients.add(intRange.clients.get(i));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.493 -0400", hash_original_method = "5E2FBB55D30010C4D5AE540EBBAC773C", hash_generated_method = "6B36256F33E4E2D36D4D727EADB9EAA2")
         void insert(ClientRange range) {
            int len;
            len = clients.size();
            {
                int i;
                i = 0;
                {
                    ClientRange nextRange;
                    nextRange = clients.get(i);
                    {
                        {
                            boolean var0589E74B889CA6CB22A18F03DFF9F170_1988375428 = (!range.equals(nextRange));
                            {
                                clients.add(i, range);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            clients.add(range);
            addTaint(range.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.494 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.494 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.494 -0400", hash_original_field = "62608E08ADC29A8D6DBC9754E659F125", hash_generated_field = "B53CFB15BD6573E83D2588E535C40087")

        String client;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.494 -0400", hash_original_method = "0233CEEC110E7548B64806A81A8747BD", hash_generated_method = "8A9C28D210140B4512C21C49AFDD4E38")
          ClientRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            this.client = client;
            // ---------- Original Method ----------
            //this.startId = startId;
            //this.endId = endId;
            //this.client = client;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.495 -0400", hash_original_method = "1032526D9DAEE515FA8C17531DBF15E9", hash_generated_method = "418F790C194F7C609C7208D34E4CB209")
        @Override
        public boolean equals(Object o) {
            {
                ClientRange other;
                other = (ClientRange) o;
                boolean varA5C47D347F5156B3305DA5846936CDAE_873513480 = (startId == other.startId &&
                        endId == other.endId &&
                        client.equals(other.client));
            } //End block
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007336165 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007336165;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.496 -0400", hash_original_method = "0C827ECC35335C49789EB5A12C0D3470", hash_generated_method = "47D5189CAEB45B29430B3DE61814C692")
        @Override
        public int hashCode() {
            int var4D306EDBD856C6F2424CEC8B3C043F9D_1862340154 = ((startId * 31 + endId) * 31 + client.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296759497 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296759497;
            // ---------- Original Method ----------
            //return (startId * 31 + endId) * 31 + client.hashCode();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.496 -0400", hash_original_field = "34FA81EDAFCA80AF9B9CF345E4A5F242", hash_generated_field = "524145F6AC51D0216A5F830BBD9EF1CA")

    private static int INITIAL_CLIENTS_ARRAY_SIZE = 4;
}

