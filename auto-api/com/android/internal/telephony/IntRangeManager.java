package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class IntRangeManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.233 -0400", hash_original_field = "2B355984BC5EB38E49D845FCB0D77019", hash_generated_field = "E43FB0C78759432184E49407A51B5267")

    private ArrayList<IntRange> mRanges = new ArrayList<IntRange>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.233 -0400", hash_original_method = "362FA502CCB486C4D0A9F66987CBC492", hash_generated_method = "22D07BAE17359B60391CE9F4DA674915")
    protected  IntRangeManager() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.235 -0400", hash_original_method = "6ED59671D51F9C9BA7262BED5BB50C74", hash_generated_method = "03CFE4C350800B4D60A7A77153355261")
    public synchronized boolean enableRange(int startId, int endId, String client) {
        int len = mRanges.size();
        {
            {
                boolean varCA8B39A0AD4712FA5C0E11AC9C9BFF31_307139750 = (tryAddSingleRange(startId, endId, true));
                {
                    mRanges.add(new IntRange(startId, endId, client));
                } 
            } 
        } 
        {
            int startIndex = 0;
            {
                IntRange range = mRanges.get(startIndex);
                {
                    {
                        {
                            boolean var8E94678DA21F04C61925B48C83058E58_553348881 = (tryAddSingleRange(startId, endId, true));
                            {
                                mRanges.add(startIndex, new IntRange(startId, endId, client));
                            } 
                        } 
                    } 
                    {
                        {
                            boolean varBF2A1832BAA79F846F092983AA325B4A_1301855287 = (tryAddSingleRange(startId, range.startId - 1, true));
                            {
                                range.startId = startId;
                                range.clients.add(0, new ClientRange(startId, endId, client));
                            } 
                        } 
                    } 
                    {
                        {
                            int endIndex = startIndex+1;
                            {
                                IntRange endRange = mRanges.get(endIndex);
                                {
                                    {
                                        boolean var30E07179439B9F755ABB8CC1647E698D_1407951973 = (tryAddSingleRange(startId, endId, true));
                                        {
                                            range.startId = startId;
                                            range.endId = endId;
                                            range.clients.add(0, new ClientRange(startId, endId, client));
                                            int joinIndex = startIndex + 1;
                                            {
                                                int i = joinIndex;
                                                {
                                                    IntRange joinRange = mRanges.get(joinIndex);
                                                    range.clients.addAll(joinRange.clients);
                                                    mRanges.remove(joinRange);
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                                {
                                    {
                                        boolean var2703782EF85398FCA8EA7E54ABD0E6AB_619307299 = (tryAddSingleRange(startId, endRange.startId - 1, true));
                                        {
                                            range.startId = startId;
                                            range.endId = endRange.endId;
                                            range.clients.add(0, new ClientRange(startId, endId, client));
                                            int joinIndex = startIndex + 1;
                                            {
                                                int i = joinIndex;
                                                {
                                                    IntRange joinRange = mRanges.get(joinIndex);
                                                    range.clients.addAll(joinRange.clients);
                                                    mRanges.remove(joinRange);
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            boolean var8E94678DA21F04C61925B48C83058E58_1362337823 = (tryAddSingleRange(startId, endId, true));
                            {
                                range.startId = startId;
                                range.endId = endId;
                                range.clients.add(0, new ClientRange(startId, endId, client));
                                int joinIndex = startIndex + 1;
                                {
                                    int i = joinIndex;
                                    {
                                        IntRange joinRange = mRanges.get(joinIndex);
                                        range.clients.addAll(joinRange.clients);
                                        mRanges.remove(joinRange);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    {
                        range.insert(new ClientRange(startId, endId, client));
                    } 
                    {
                        int endIndex = startIndex;
                        {
                            int testIndex = startIndex+1;
                            {
                                IntRange testRange = mRanges.get(testIndex);
                                {
                                    endIndex = testIndex;
                                } 
                            } 
                        } 
                        {
                            {
                                boolean varE5B7E0DF24796C7A791AC0241097AB26_774113581 = (tryAddSingleRange(range.endId + 1, endId, true));
                                {
                                    range.endId = endId;
                                    range.insert(new ClientRange(startId, endId, client));
                                } 
                            } 
                        } 
                        IntRange endRange = mRanges.get(endIndex);
                        int newRangeEndId;
                        newRangeEndId = endRange.startId - 1;
                        newRangeEndId = endId;
                        {
                            boolean var71FE50F92D32071C53F5C8473B0BA52C_2020559491 = (tryAddSingleRange(range.endId + 1, newRangeEndId, true));
                            {
                                range.endId = endId;
                                range.insert(new ClientRange(startId, endId, client));
                                int joinIndex = startIndex + 1;
                                {
                                    int i = joinIndex;
                                    {
                                        IntRange joinRange = mRanges.get(joinIndex);
                                        range.clients.addAll(joinRange.clients);
                                        mRanges.remove(joinRange);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean var6C371F433CAC84463755488381DCC195_444921819 = (tryAddSingleRange(startId, endId, true));
            {
                mRanges.add(new IntRange(startId, endId, client));
            } 
        } 
        addTaint(startId);
        addTaint(endId);
        addTaint(client.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149666605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149666605;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.237 -0400", hash_original_method = "3E9B5A2BDD46323741EF7C361F65FFEC", hash_generated_method = "F4C3E507E9016CE64EA27FE1A6CA75F9")
    public synchronized boolean disableRange(int startId, int endId, String client) {
        int len = mRanges.size();
        {
            int i = 0;
            {
                IntRange range = mRanges.get(i);
                {
                    ArrayList<ClientRange> clients = range.clients;
                    int crLength = clients.size();
                    {
                        ClientRange cr = clients.get(0);
                        {
                            boolean var9096A881CC606E4B6007B84895F02B97_2058999312 = (cr.startId == startId && cr.endId == endId && cr.client.equals(client));
                            {
                                {
                                    boolean varDECC80005966A3FF127C459C40D08F5A_1738640158 = (tryAddSingleRange(startId, endId, false));
                                    {
                                        mRanges.remove(i);
                                    } 
                                } 
                            } 
                        } 
                    } 
                    int largestEndId = Integer.MIN_VALUE;
                    boolean updateStarted = false;
                    {
                        int crIndex = 0;
                        {
                            ClientRange cr = clients.get(crIndex);
                            {
                                boolean var02A73763551A4A848A017E704B77DD79_185045388 = (cr.startId == startId && cr.endId == endId && cr.client.equals(client));
                                {
                                    {
                                        {
                                            clients.remove(crIndex);
                                        } 
                                        {
                                            {
                                                boolean var80C77B773576938BF301F47C024A2EAE_977106712 = (tryAddSingleRange(largestEndId + 1, range.endId, false));
                                                {
                                                    clients.remove(crIndex);
                                                    range.endId = largestEndId;
                                                } 
                                            } 
                                        } 
                                    } 
                                    IntRange rangeCopy = new IntRange(range, crIndex);
                                    {
                                        int nextStartId = clients.get(1).startId;
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
                                    {
                                        int nextIndex = crIndex + 1;
                                        {
                                            ClientRange nextCr = clients.get(nextIndex);
                                            {
                                                {
                                                    startUpdate();
                                                    updateStarted = true;
                                                } 
                                                addRange(largestEndId + 1, nextCr.startId - 1, false);
                                                currentRange.endId = largestEndId;
                                                newRanges.add(currentRange);
                                                currentRange = new IntRange(nextCr);
                                            } 
                                            {
                                                currentRange.clients.add(nextCr);
                                            } 
                                            {
                                                largestEndId = nextCr.endId;
                                            } 
                                        } 
                                    } 
                                    {
                                        {
                                            startUpdate();
                                            updateStarted = true;
                                        } 
                                        addRange(largestEndId + 1, endId, false);
                                        currentRange.endId = largestEndId;
                                    } 
                                    newRanges.add(currentRange);
                                    {
                                        boolean var66529555AC208E32BDDED3ADC3FD2C1B_292022846 = (updateStarted && !finishUpdate());
                                    } 
                                    mRanges.remove(i);
                                    mRanges.addAll(i, newRanges);
                                } 
                                {
                                    {
                                        largestEndId = cr.endId;
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(startId);
        addTaint(endId);
        addTaint(client.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258154084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258154084;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.238 -0400", hash_original_method = "6D2ABBA8943E817B6A7F4354584C0478", hash_generated_method = "5389BAA820D4F5AF7BD4BDCC128D4DEB")
    public boolean updateRanges() {
        startUpdate();
        Iterator<IntRange> iterator = mRanges.iterator();
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_1081281868 = (iterator.hasNext());
            {
                IntRange range = iterator.next();
                int start = range.startId;
                int end = range.endId;
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_22615425 = (iterator.hasNext());
                    {
                        IntRange nextNode = iterator.next();
                        {
                            {
                                end = nextNode.endId;
                            } 
                        } 
                        {
                            addRange(start, end, true);
                            start = nextNode.startId;
                            end = nextNode.endId;
                        } 
                    } 
                } 
                addRange(start, end, true);
            } 
        } 
        boolean var5A9A2BBF0403922273ADE4623662297B_1962318096 = (finishUpdate());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512392976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512392976;
        
        
        
        
            
            
            
            
                
                
                    
                        
                    
                
                    
                    
                    
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.238 -0400", hash_original_method = "66D9B78BD0A6572F2D23304F41F243DE", hash_generated_method = "A50C08BC6610223258C723BED84A2D9F")
    private boolean tryAddSingleRange(int startId, int endId, boolean selected) {
        startUpdate();
        addRange(startId, endId, selected);
        boolean var5A9A2BBF0403922273ADE4623662297B_397669836 = (finishUpdate());
        addTaint(startId);
        addTaint(endId);
        addTaint(selected);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762872571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762872571;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.239 -0400", hash_original_method = "3535E42AC2A5B7497897BAD158CB88AF", hash_generated_method = "C2A9F810D4E1291500CCEBEFE41FBAF5")
    public boolean isEmpty() {
        boolean varE51DE8210CC866E42ADD3FBAA8AE58BF_454397390 = (mRanges.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_887409108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_887409108;
        
        
    }

    
    protected abstract void startUpdate();

    
    protected abstract void addRange(int startId, int endId, boolean selected);

    
    protected abstract boolean finishUpdate();

    
    private class IntRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.239 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.239 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.240 -0400", hash_original_field = "FAC04CA68A48AF91F0290001604A2463", hash_generated_field = "DD30F90F1DFDA1050591F66AD1E9CE7F")

        ArrayList<ClientRange> clients;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.241 -0400", hash_original_method = "F07B82A28B52231FBB76629ABCB97069", hash_generated_method = "9460E9F15B3DD5EE1279A65369C68DFA")
          IntRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(new ClientRange(startId, endId, client));
            addTaint(client.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.241 -0400", hash_original_method = "BA7832996744AA8092A9A5E21086E160", hash_generated_method = "7BA355DFC1B6681CD4E3AA92366DAC86")
          IntRange(ClientRange clientRange) {
            startId = clientRange.startId;
            endId = clientRange.endId;
            clients = new ArrayList<ClientRange>(INITIAL_CLIENTS_ARRAY_SIZE);
            clients.add(clientRange);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.242 -0400", hash_original_method = "A2EC39EA4DD73652B403D173FB1236C3", hash_generated_method = "DC7D589E21CC4F6AA8FC7F06CF7C51F8")
          IntRange(IntRange intRange, int numElements) {
            this.startId = intRange.startId;
            this.endId = intRange.endId;
            this.clients = new ArrayList<ClientRange>(intRange.clients.size());
            {
                int i = 0;
                {
                    this.clients.add(intRange.clients.get(i));
                } 
            } 
            addTaint(numElements);
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.242 -0400", hash_original_method = "5E2FBB55D30010C4D5AE540EBBAC773C", hash_generated_method = "35D0AB29B4A4AE1FCE7414540A111E30")
         void insert(ClientRange range) {
            int len = clients.size();
            {
                int i = 0;
                {
                    ClientRange nextRange = clients.get(i);
                    {
                        {
                            boolean var0589E74B889CA6CB22A18F03DFF9F170_504925222 = (!range.equals(nextRange));
                            {
                                clients.add(i, range);
                            } 
                        } 
                    } 
                } 
            } 
            clients.add(range);
            addTaint(range.getTaint());
            
            
            
                
                
                    
                        
                    
                    
                
            
            
        }

        
    }


    
    private class ClientRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.242 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.242 -0400", hash_original_field = "30E5A8439BA3B2DD50160927AB87D03D", hash_generated_field = "D469E1326C7C274FD4D56F815E4A1D73")

        int endId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.242 -0400", hash_original_field = "62608E08ADC29A8D6DBC9754E659F125", hash_generated_field = "B53CFB15BD6573E83D2588E535C40087")

        String client;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.243 -0400", hash_original_method = "0233CEEC110E7548B64806A81A8747BD", hash_generated_method = "8A9C28D210140B4512C21C49AFDD4E38")
          ClientRange(int startId, int endId, String client) {
            this.startId = startId;
            this.endId = endId;
            this.client = client;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.243 -0400", hash_original_method = "1032526D9DAEE515FA8C17531DBF15E9", hash_generated_method = "1AEFD2BE0A4E5A3E65A081F95275F4EB")
        @Override
        public boolean equals(Object o) {
            {
                ClientRange other = (ClientRange) o;
                boolean varA5C47D347F5156B3305DA5846936CDAE_2094346106 = (startId == other.startId &&
                        endId == other.endId &&
                        client.equals(other.client));
            } 
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446605482 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446605482;
            
            
                
                
                        
                        
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.244 -0400", hash_original_method = "0C827ECC35335C49789EB5A12C0D3470", hash_generated_method = "8B563BAF81AAE1A47B4E21AF3EC5D1BE")
        @Override
        public int hashCode() {
            int var4D306EDBD856C6F2424CEC8B3C043F9D_847669522 = ((startId * 31 + endId) * 31 + client.hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865978266 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865978266;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.244 -0400", hash_original_field = "34FA81EDAFCA80AF9B9CF345E4A5F242", hash_generated_field = "755EBFB204022DB38615C127DE53EE61")

    private static final int INITIAL_CLIENTS_ARRAY_SIZE = 4;
}

