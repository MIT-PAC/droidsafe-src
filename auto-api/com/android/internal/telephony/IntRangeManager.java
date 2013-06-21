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
    private ArrayList<IntRange> mRanges = new ArrayList<IntRange>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.500 -0400", hash_original_method = "362FA502CCB486C4D0A9F66987CBC492", hash_generated_method = "22D07BAE17359B60391CE9F4DA674915")
    @DSModeled(DSC.SAFE)
    protected IntRangeManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.501 -0400", hash_original_method = "6ED59671D51F9C9BA7262BED5BB50C74", hash_generated_method = "649BAF59444D216DDE87BF79AA8F0BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean enableRange(int startId, int endId, String client) {
        dsTaint.addTaint(endId);
        dsTaint.addTaint(startId);
        dsTaint.addTaint(client);
        int len;
        len = mRanges.size();
        {
            {
                boolean varCA8B39A0AD4712FA5C0E11AC9C9BFF31_340354164 = (tryAddSingleRange(startId, endId, true));
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
                            boolean var8E94678DA21F04C61925B48C83058E58_1395403539 = (tryAddSingleRange(startId, endId, true));
                            {
                                mRanges.add(startIndex, new IntRange(startId, endId, client));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varBF2A1832BAA79F846F092983AA325B4A_1959738957 = (tryAddSingleRange(startId, range.startId - 1, true));
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
                                        boolean var30E07179439B9F755ABB8CC1647E698D_645272501 = (tryAddSingleRange(startId, endId, true));
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
                                        boolean var2703782EF85398FCA8EA7E54ABD0E6AB_660701569 = (tryAddSingleRange(startId, endRange.startId - 1, true));
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
                            boolean var8E94678DA21F04C61925B48C83058E58_1292598152 = (tryAddSingleRange(startId, endId, true));
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
                                boolean varE5B7E0DF24796C7A791AC0241097AB26_1191942710 = (tryAddSingleRange(range.endId + 1, endId, true));
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
                            boolean var71FE50F92D32071C53F5C8473B0BA52C_1378670995 = (tryAddSingleRange(range.endId + 1, newRangeEndId, true));
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
            boolean var6C371F433CAC84463755488381DCC195_1323948422 = (tryAddSingleRange(startId, endId, true));
            {
                mRanges.add(new IntRange(startId, endId, client));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.503 -0400", hash_original_method = "3E9B5A2BDD46323741EF7C361F65FFEC", hash_generated_method = "F058EE817E03895D9F2692F0C3A7A05D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean disableRange(int startId, int endId, String client) {
        dsTaint.addTaint(endId);
        dsTaint.addTaint(startId);
        dsTaint.addTaint(client);
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
                            boolean var9096A881CC606E4B6007B84895F02B97_997971455 = (cr.startId == startId && cr.endId == endId && cr.client.equals(client));
                            {
                                {
                                    boolean varDECC80005966A3FF127C459C40D08F5A_1559174344 = (tryAddSingleRange(startId, endId, false));
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
                                boolean var02A73763551A4A848A017E704B77DD79_1075708734 = (cr.startId == startId && cr.endId == endId && cr.client.equals(client));
                                {
                                    {
                                        {
                                            clients.remove(crIndex);
                                        } //End block
                                        {
                                            {
                                                boolean var80C77B773576938BF301F47C024A2EAE_1611127930 = (tryAddSingleRange(largestEndId + 1, range.endId, false));
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
                                        boolean var66529555AC208E32BDDED3ADC3FD2C1B_86896662 = (updateStarted && !finishUpdate());
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.503 -0400", hash_original_method = "6D2ABBA8943E817B6A7F4354584C0478", hash_generated_method = "E0CF0D5E59364C12B7DD50510B59E284")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateRanges() {
        startUpdate();
        Iterator<IntRange> iterator;
        iterator = mRanges.iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_1329132712 = (iterator.hasNext());
            {
                IntRange range;
                range = iterator.next();
                int start;
                start = range.startId;
                int end;
                end = range.endId;
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_1366722861 = (iterator.hasNext());
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
        boolean var5A9A2BBF0403922273ADE4623662297B_1867023096 = (finishUpdate());
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.503 -0400", hash_original_method = "66D9B78BD0A6572F2D23304F41F243DE", hash_generated_method = "B484E8A07978E278BC465B2E2419F6CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean tryAddSingleRange(int startId, int endId, boolean selected) {
        dsTaint.addTaint(selected);
        dsTaint.addTaint(endId);
        dsTaint.addTaint(startId);
        startUpdate();
        addRange(startId, endId, selected);
        boolean var5A9A2BBF0403922273ADE4623662297B_268556736 = (finishUpdate());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //startUpdate();
        //addRange(startId, endId, selected);
        //return finishUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.503 -0400", hash_original_method = "3535E42AC2A5B7497897BAD158CB88AF", hash_generated_method = "5534535BF86F1B9A8A35B7F7A560605A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean varE51DE8210CC866E42ADD3FBAA8AE58BF_390465378 = (mRanges.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRanges.isEmpty();
    }

    
    protected abstract void startUpdate();

    
    protected abstract void addRange(int startId, int endId, boolean selected);

    
    protected abstract boolean finishUpdate();

    
    private class IntRange {
        int startId;
        int endId;
        ArrayList<ClientRange> clients;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.504 -0400", hash_original_method = "F07B82A28B52231FBB76629ABCB97069", hash_generated_method = "C6E3915926EA0D6AEBE92B6FF9A17F9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         IntRange(int startId, int endId, String client) {
            dsTaint.addTaint(endId);
            dsTaint.addTaint(startId);
            dsTaint.addTaint(client);
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(new ClientRange(startId, endId, client));
            // ---------- Original Method ----------
            //this.startId = startId;
            //this.endId = endId;
            //clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            //clients.add(new ClientRange(startId, endId, client));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.504 -0400", hash_original_method = "BA7832996744AA8092A9A5E21086E160", hash_generated_method = "09DA1337C686A239CED1D27AADE8B61C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         IntRange(ClientRange clientRange) {
            dsTaint.addTaint(clientRange.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.505 -0400", hash_original_method = "A2EC39EA4DD73652B403D173FB1236C3", hash_generated_method = "8E9C0E90C7FA6891F202200DD746D090")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         IntRange(IntRange intRange, int numElements) {
            dsTaint.addTaint(intRange.dsTaint);
            dsTaint.addTaint(numElements);
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
            // ---------- Original Method ----------
            //this.startId = intRange.startId;
            //this.endId = intRange.endId;
            //this.clients = new ArrayList<ClientRange>(intRange.clients.size());
            //for (int i=0; i < numElements; i++) {
                //this.clients.add(intRange.clients.get(i));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.505 -0400", hash_original_method = "5E2FBB55D30010C4D5AE540EBBAC773C", hash_generated_method = "0D578C7792D913C34C1BB6216C2907D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void insert(ClientRange range) {
            dsTaint.addTaint(range.dsTaint);
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
                            boolean var0589E74B889CA6CB22A18F03DFF9F170_1986130513 = (!range.equals(nextRange));
                            {
                                clients.add(i, range);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
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
        int startId;
        int endId;
        String client;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.505 -0400", hash_original_method = "0233CEEC110E7548B64806A81A8747BD", hash_generated_method = "F3076D49457FBDA606171A0610ECF07A")
        @DSModeled(DSC.SAFE)
         ClientRange(int startId, int endId, String client) {
            dsTaint.addTaint(endId);
            dsTaint.addTaint(startId);
            dsTaint.addTaint(client);
            // ---------- Original Method ----------
            //this.startId = startId;
            //this.endId = endId;
            //this.client = client;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.505 -0400", hash_original_method = "1032526D9DAEE515FA8C17531DBF15E9", hash_generated_method = "575F025CD32D6DD69D72DD6BE916CFEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            {
                ClientRange other;
                other = (ClientRange) o;
                boolean varA5C47D347F5156B3305DA5846936CDAE_1130920605 = (startId == other.startId &&
                        endId == other.endId &&
                        client.equals(other.client));
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.505 -0400", hash_original_method = "0C827ECC35335C49789EB5A12C0D3470", hash_generated_method = "FECAE5C4C0642A174421B82D9DAA6445")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var4D306EDBD856C6F2424CEC8B3C043F9D_47988694 = ((startId * 31 + endId) * 31 + client.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (startId * 31 + endId) * 31 + client.hashCode();
        }

        
    }


    
    private static final int INITIAL_CLIENTS_ARRAY_SIZE = 4;
}

