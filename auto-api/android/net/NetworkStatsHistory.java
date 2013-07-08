package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import static android.net.NetworkStats.IFACE_ALL;
import static android.net.NetworkStats.SET_DEFAULT;
import static android.net.NetworkStats.TAG_NONE;
import static android.net.NetworkStats.UID_ALL;
import static android.net.NetworkStatsHistory.DataStreamUtils.readFullLongArray;
import static android.net.NetworkStatsHistory.DataStreamUtils.readVarLongArray;
import static android.net.NetworkStatsHistory.DataStreamUtils.writeVarLongArray;
import static android.net.NetworkStatsHistory.Entry.UNKNOWN;
import static android.net.NetworkStatsHistory.ParcelUtils.readLongArray;
import static android.net.NetworkStatsHistory.ParcelUtils.writeLongArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.MathUtils;
import java.io.CharArrayWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ProtocolException;
import java.util.Arrays;
import java.util.Random;

public class NetworkStatsHistory implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "12D6496AFB9546FF78CE1A9D7D8F4BFC", hash_generated_field = "2DC5FC41152B76B2AF9AC6BB55A20FB5")

    private long bucketDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "3ED54E5E8C85283782F9EFF085B93E51", hash_generated_field = "5619EFB8F87F05852AF87EFEA39E4229")

    private int bucketCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "FB4A06AB2BFDF0DA1206B27E9ECBA4D5", hash_generated_field = "139AA0E6051DEFC8EEA60ED1156E8150")

    private long[] bucketStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "69A1B59160AD46B165263D22FA543821", hash_generated_field = "20E796E1CD2BA4BBB5978B0DA9E59A40")

    private long[] activeTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "835A90EA79ED43E63CD1F8551E1170AC")

    private long[] rxBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "3C8EA21CAE3964AFEC5D5287345DF52F")

    private long[] rxPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "5D0307CD93ADE4DF2FD18B8CD5214177")

    private long[] txBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "EF80B3F02FF3FE9875FC49D478831ABF")

    private long[] txPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "D54D9A650B72A41B61249C2CA8E210FC")

    private long[] operations;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_method = "87FB06C16EBBFAA433DCDABD0A1A2DD9", hash_generated_method = "9BC80FF72FB768FAAFDEE19442FA2D5A")
    public  NetworkStatsHistory(long bucketDuration) {
        this(bucketDuration, 10, FIELD_ALL);
        addTaint(bucketDuration);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.757 -0400", hash_original_method = "EAC8ED507C3789501B6488454258F44A", hash_generated_method = "A67D79E9C66AB2407692B9DF79741068")
    public  NetworkStatsHistory(long bucketDuration, int initialSize) {
        this(bucketDuration, initialSize, FIELD_ALL);
        addTaint(bucketDuration);
        addTaint(initialSize);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.758 -0400", hash_original_method = "91F33DD6289F13A1041AE60DDEFCB3A5", hash_generated_method = "0DE2B61557A6950932C07BEC89B00A00")
    public  NetworkStatsHistory(long bucketDuration, int initialSize, int fields) {
        this.bucketDuration = bucketDuration;
        bucketStart = new long[initialSize];
        activeTime = new long[initialSize];
        rxBytes = new long[initialSize];
        rxPackets = new long[initialSize];
        txBytes = new long[initialSize];
        txPackets = new long[initialSize];
        operations = new long[initialSize];
        bucketCount = 0;
        addTaint(fields);
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.758 -0400", hash_original_method = "C5C154CF2AF179AC7D0E69C633C9B809", hash_generated_method = "16B280BFDD21585CB02BBFEF20047B68")
    public  NetworkStatsHistory(Parcel in) {
        bucketDuration = in.readLong();
        bucketStart = readLongArray(in);
        activeTime = readLongArray(in);
        rxBytes = readLongArray(in);
        rxPackets = readLongArray(in);
        txBytes = readLongArray(in);
        txPackets = readLongArray(in);
        operations = readLongArray(in);
        bucketCount = bucketStart.length;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.759 -0400", hash_original_method = "EDC1A57CB9EE8B46632E6D4E4377F32F", hash_generated_method = "B9334DBAC7A00A65E299AB0D876FB6CC")
    public  NetworkStatsHistory(DataInputStream in) throws IOException {
        final int version = in.readInt();
        
        {
            bucketDuration = in.readLong();
            bucketStart = readFullLongArray(in);
            rxBytes = readFullLongArray(in);
            rxPackets = new long[bucketStart.length];
            txBytes = readFullLongArray(in);
            txPackets = new long[bucketStart.length];
            operations = new long[bucketStart.length];
            bucketCount = bucketStart.length;
        } 
        
        
        {
            bucketDuration = in.readLong();
            bucketStart = readVarLongArray(in);
            activeTime = (version >= VERSION_ADD_ACTIVE) ? readVarLongArray(in)
                        : new long[bucketStart.length];
            rxBytes = readVarLongArray(in);
            rxPackets = readVarLongArray(in);
            txBytes = readVarLongArray(in);
            txPackets = readVarLongArray(in);
            operations = readVarLongArray(in);
            bucketCount = bucketStart.length;
        } 
        
        
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("unexpected version: " + version);
        } 
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.760 -0400", hash_original_method = "7FCED8E87AE3E02DFD52BA28011A12D7", hash_generated_method = "D3413475BB64E6DF8E5F89A3FDA24F42")
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(bucketDuration);
        writeLongArray(out, bucketStart, bucketCount);
        writeLongArray(out, activeTime, bucketCount);
        writeLongArray(out, rxBytes, bucketCount);
        writeLongArray(out, rxPackets, bucketCount);
        writeLongArray(out, txBytes, bucketCount);
        writeLongArray(out, txPackets, bucketCount);
        writeLongArray(out, operations, bucketCount);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.761 -0400", hash_original_method = "F25B937341175CC0273E2E92554C8F17", hash_generated_method = "564F0212121CB09CACF818855DC74EC1")
    public void writeToStream(DataOutputStream out) throws IOException {
        out.writeInt(VERSION_ADD_ACTIVE);
        out.writeLong(bucketDuration);
        writeVarLongArray(out, bucketStart, bucketCount);
        writeVarLongArray(out, activeTime, bucketCount);
        writeVarLongArray(out, rxBytes, bucketCount);
        writeVarLongArray(out, rxPackets, bucketCount);
        writeVarLongArray(out, txBytes, bucketCount);
        writeVarLongArray(out, txPackets, bucketCount);
        writeVarLongArray(out, operations, bucketCount);
        addTaint(out.getTaint());
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.761 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DB18EF0C38B070BD88F75007D725918C")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211742541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211742541;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.761 -0400", hash_original_method = "3E2D8D04EF3E8C4BDF56D4CFDD864A04", hash_generated_method = "70260FD60BD503066D1930F14E5DDAE0")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942335836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942335836;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.762 -0400", hash_original_method = "D0E743773F77C0F20C1DE2E3BE48F30B", hash_generated_method = "D7983E14F2E37D5FA0F3E3DFED006923")
    public long getBucketDuration() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_215514627 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_215514627;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.762 -0400", hash_original_method = "0DA78BB7B3F99E1543E4DC9DFD2BD9F4", hash_generated_method = "D7E93D14E53FC0B8059BC61E8EA3D7F1")
    public long getStart() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_983319023 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_983319023;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.762 -0400", hash_original_method = "D4476AE88A84FACA51BF4BF1E3EE2F8D", hash_generated_method = "5B51035569D56C6B454FC4D5D8B61E94")
    public long getEnd() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_969773309 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_969773309;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.763 -0400", hash_original_method = "44CA8F6D269FC47862A9173C06F73618", hash_generated_method = "4EDBC0382ED39CE6090EDC8DF3A01BC2")
    public int getIndexBefore(long time) {
        int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        {
            index = (~index) - 1;
        } 
        {
            index -= 1;
        } 
        int var9BF4435ACED8AF26C4B672EFA1D4FDD8_1714312691 = (MathUtils.constrain(index, 0, bucketCount - 1));
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743110128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743110128;
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.763 -0400", hash_original_method = "44680AD61A9756C7015B14278BDED4D1", hash_generated_method = "870BCFEFE0777AF88FF3C8C85E1B7E43")
    public int getIndexAfter(long time) {
        int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        {
            index = ~index;
        } 
        {
            index += 1;
        } 
        int var9BF4435ACED8AF26C4B672EFA1D4FDD8_1672033776 = (MathUtils.constrain(index, 0, bucketCount - 1));
        addTaint(time);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278514939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278514939;
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.764 -0400", hash_original_method = "75531F5194A56E3573F283D646BEE902", hash_generated_method = "67F50AE07433EC56060BB0AACE6EDC06")
    public Entry getValues(int i, Entry recycle) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_1208541224 = null; 
        Entry entry;
        entry = recycle;
        entry = new Entry();
        entry.bucketStart = bucketStart[i];
        entry.bucketDuration = bucketDuration;
        entry.activeTime = getLong(activeTime, i, UNKNOWN);
        entry.rxBytes = getLong(rxBytes, i, UNKNOWN);
        entry.rxPackets = getLong(rxPackets, i, UNKNOWN);
        entry.txBytes = getLong(txBytes, i, UNKNOWN);
        entry.txPackets = getLong(txPackets, i, UNKNOWN);
        entry.operations = getLong(operations, i, UNKNOWN);
        varB4EAC82CA7396A68D541C85D26508E83_1208541224 = entry;
        addTaint(recycle.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1208541224.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1208541224;
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.765 -0400", hash_original_method = "74712D26283E9B32FCB8C3574DCFFFFA", hash_generated_method = "5155DA0E3013F5124BA261315CAF4897")
    @Deprecated
    public void recordData(long start, long end, long rxBytes, long txBytes) {
        recordData(start, end, new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, 0L, txBytes, 0L, 0L));
        addTaint(start);
        addTaint(end);
        addTaint(rxBytes);
        addTaint(txBytes);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.765 -0400", hash_original_method = "3FF3F0D6B4FEA69386DC61191DDF3D5F", hash_generated_method = "792CB765DE1F8A7211577EC99B3F1F64")
    public void recordData(long start, long end, NetworkStats.Entry entry) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("tried recording negative data");
        } 
        ensureBuckets(start, end);
        long duration = end - start;
        final int startIndex = getIndexAfter(end);
        {
            int i = startIndex;
            {
                final long curStart = bucketStart[i];
                final long curEnd = curStart + bucketDuration;
                final long overlap = Math.min(curEnd, end) - Math.max(curStart, start);
                final long fracRxBytes = entry.rxBytes * overlap / duration;
                final long fracRxPackets = entry.rxPackets * overlap / duration;
                final long fracTxBytes = entry.txBytes * overlap / duration;
                final long fracTxPackets = entry.txPackets * overlap / duration;
                final long fracOperations = entry.operations * overlap / duration;
                addLong(activeTime, i, overlap);
                addLong(rxBytes, i, fracRxBytes);
                entry.rxBytes -= fracRxBytes;
                addLong(rxPackets, i, fracRxPackets);
                entry.rxPackets -= fracRxPackets;
                addLong(txBytes, i, fracTxBytes);
                entry.txBytes -= fracTxBytes;
                addLong(txPackets, i, fracTxPackets);
                entry.txPackets -= fracTxPackets;
                addLong(operations, i, fracOperations);
                entry.operations -= fracOperations;
                duration -= overlap;
            } 
        } 
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.766 -0400", hash_original_method = "3DDEBC644DC519B4D2C820693B031478", hash_generated_method = "433B7123A7D6965C5C1AB0471CF55061")
    public void recordEntireHistory(NetworkStatsHistory input) {
        final NetworkStats.Entry entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        {
            int i = 0;
            {
                final long start = input.bucketStart[i];
                final long end = start + input.bucketDuration;
                entry.rxBytes = getLong(input.rxBytes, i, 0L);
                entry.rxPackets = getLong(input.rxPackets, i, 0L);
                entry.txBytes = getLong(input.txBytes, i, 0L);
                entry.txPackets = getLong(input.txPackets, i, 0L);
                entry.operations = getLong(input.operations, i, 0L);
                recordData(start, end, entry);
            } 
        } 
        
        
                
        
            
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.767 -0400", hash_original_method = "B927CFA0CEDE41C1E5D84D22AEB0E325", hash_generated_method = "2D8985A126B1CD5616DE82480A3C4FCD")
    private void ensureBuckets(long start, long end) {
        start -= start % bucketDuration;
        end += (bucketDuration - (end % bucketDuration)) % bucketDuration;
        {
            long now = start;
            now += bucketDuration;
            {
                final int index = Arrays.binarySearch(bucketStart, 0, bucketCount, now);
                {
                    insertBucket(~index, now);
                } 
            } 
        } 
        addTaint(start);
        addTaint(end);
        
        
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.767 -0400", hash_original_method = "B3108244F274B858A2EC662DDA9927CD", hash_generated_method = "0C1004BEAFE33D159D7F3144901F8D4A")
    private void insertBucket(int index, long start) {
        {
            final int newLength = Math.max(bucketStart.length, 10) * 3 / 2;
            bucketStart = Arrays.copyOf(bucketStart, newLength);
            activeTime = Arrays.copyOf(activeTime, newLength);
            rxBytes = Arrays.copyOf(rxBytes, newLength);
            rxPackets = Arrays.copyOf(rxPackets, newLength);
            txBytes = Arrays.copyOf(txBytes, newLength);
            txPackets = Arrays.copyOf(txPackets, newLength);
            operations = Arrays.copyOf(operations, newLength);
        } 
        {
            final int dstPos = index + 1;
            final int length = bucketCount - index;
            System.arraycopy(bucketStart, index, bucketStart, dstPos, length);
            System.arraycopy(activeTime, index, activeTime, dstPos, length);
            System.arraycopy(rxBytes, index, rxBytes, dstPos, length);
            System.arraycopy(rxPackets, index, rxPackets, dstPos, length);
            System.arraycopy(txBytes, index, txBytes, dstPos, length);
            System.arraycopy(txPackets, index, txPackets, dstPos, length);
            System.arraycopy(operations, index, operations, dstPos, length);
        } 
        bucketStart[index] = start;
        setLong(activeTime, index, 0L);
        setLong(rxBytes, index, 0L);
        setLong(rxPackets, index, 0L);
        setLong(txBytes, index, 0L);
        setLong(txPackets, index, 0L);
        setLong(operations, index, 0L);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.768 -0400", hash_original_method = "D42FFE9A180911A657FA083FF5768836", hash_generated_method = "E00D3F70EF2D7A29A20E19289489F99F")
    public void removeBucketsBefore(long cutoff) {
        int i;
        {
            i = 0;
            {
                final long curStart = bucketStart[i];
                final long curEnd = curStart + bucketDuration;
            } 
        } 
        {
            final int length = bucketStart.length;
            bucketStart = Arrays.copyOfRange(bucketStart, i, length);
            activeTime = Arrays.copyOfRange(activeTime, i, length);
            rxBytes = Arrays.copyOfRange(rxBytes, i, length);
            rxPackets = Arrays.copyOfRange(rxPackets, i, length);
            txBytes = Arrays.copyOfRange(txBytes, i, length);
            txPackets = Arrays.copyOfRange(txPackets, i, length);
            operations = Arrays.copyOfRange(operations, i, length);
            bucketCount -= i;
        } 
        addTaint(cutoff);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.769 -0400", hash_original_method = "846F78477F792FCCB9A623410DF90C52", hash_generated_method = "310A40CC17852830F359E26B2B2E1864")
    public Entry getValues(long start, long end, Entry recycle) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_676732783 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_676732783 = getValues(start, end, Long.MAX_VALUE, recycle);
        addTaint(start);
        addTaint(end);
        addTaint(recycle.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_676732783.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_676732783;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.771 -0400", hash_original_method = "FB71475C239CC1C7BD0FFCD80328C5DA", hash_generated_method = "791C931C4D81786937D35AC7D77D6CFB")
    public Entry getValues(long start, long end, long now, Entry recycle) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_1386519990 = null; 
        Entry entry;
        entry = recycle;
        entry = new Entry();
        entry.bucketDuration = end - start;
        entry.bucketStart = start;
        entry.activeTime = activeTime != null ? 0 : UNKNOWN;
        entry.rxBytes = rxBytes != null ? 0 : UNKNOWN;
        entry.rxPackets = rxPackets != null ? 0 : UNKNOWN;
        entry.txBytes = txBytes != null ? 0 : UNKNOWN;
        entry.txPackets = txPackets != null ? 0 : UNKNOWN;
        entry.operations = operations != null ? 0 : UNKNOWN;
        final int startIndex = getIndexAfter(end);
        {
            int i = startIndex;
            {
                final long curStart = bucketStart[i];
                final long curEnd = curStart + bucketDuration;
                final boolean activeBucket = curStart < now && curEnd > now;
                long overlap;
                {
                    overlap = bucketDuration;
                } 
                {
                    long overlapEnd;
                    overlapEnd = curEnd;
                    overlapEnd = end;
                    long overlapStart;
                    overlapStart = curStart;
                    overlapStart = start;
                    overlap = overlapEnd - overlapStart;
                } 
                entry.activeTime += activeTime[i] * overlap / bucketDuration;
                entry.rxBytes += rxBytes[i] * overlap / bucketDuration;
                entry.rxPackets += rxPackets[i] * overlap / bucketDuration;
                entry.txBytes += txBytes[i] * overlap / bucketDuration;
                entry.txPackets += txPackets[i] * overlap / bucketDuration;
                entry.operations += operations[i] * overlap / bucketDuration;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1386519990 = entry;
        addTaint(now);
        addTaint(recycle.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1386519990.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1386519990;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.773 -0400", hash_original_method = "AB86ED9AABA220FE0A64D0BEB0ADF734", hash_generated_method = "89F060343F8ED45AFDCB7C613C06FF91")
    @Deprecated
    public void generateRandom(long start, long end, long bytes) {
        final Random r = new Random();
        final float fractionRx = r.nextFloat();
        final long rxBytes = (long) (bytes * fractionRx);
        final long txBytes = (long) (bytes * (1 - fractionRx));
        final long rxPackets = rxBytes / 1024;
        final long txPackets = txBytes / 1024;
        final long operations = rxBytes / 2048;
        generateRandom(start, end, rxBytes, rxPackets, txBytes, txPackets, operations, r);
        addTaint(start);
        addTaint(end);
        addTaint(bytes);
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.774 -0400", hash_original_method = "2B4929E4FB42F9E11DEF8BA8131121D5", hash_generated_method = "F1B00EC9D07EDA31062A22CBBD23422E")
    @Deprecated
    public void generateRandom(long start, long end, long rxBytes, long rxPackets, long txBytes,
            long txPackets, long operations, Random r) {
        ensureBuckets(start, end);
        final NetworkStats.Entry entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        {
            final long curStart = randomLong(r, start, end);
            final long curEnd = curStart + randomLong(r, 0, (end - curStart) / 2);
            entry.rxBytes = randomLong(r, 0, rxBytes);
            entry.rxPackets = randomLong(r, 0, rxPackets);
            entry.txBytes = randomLong(r, 0, txBytes);
            entry.txPackets = randomLong(r, 0, txPackets);
            entry.operations = randomLong(r, 0, operations);
            rxBytes -= entry.rxBytes;
            rxPackets -= entry.rxPackets;
            txBytes -= entry.txBytes;
            txPackets -= entry.txPackets;
            operations -= entry.operations;
            recordData(curStart, curEnd, entry);
        } 
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static long randomLong(Random r, long start, long end) {
        return (long) (start + (r.nextFloat() * (end - start)));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.775 -0400", hash_original_method = "9A3509822F71494F86F9AA38F61F7118", hash_generated_method = "77DA6E157426E18705D5B326E09343AF")
    public void dump(String prefix, PrintWriter pw, boolean fullHistory) {
        pw.print(prefix);
        pw.print("NetworkStatsHistory: bucketDuration=");
        pw.println(bucketDuration);
        int start;
        start = 0;
        start = Math.max(0, bucketCount - 32);
        {
            pw.print(prefix);
            pw.print("  (omitting ");
            pw.print(start);
            pw.println(" buckets)");
        } 
        {
            int i = start;
            {
                pw.print(prefix);
                pw.print("  bucketStart=");
                pw.print(bucketStart[i]);
                {
                    pw.print(" activeTime=");
                    pw.print(activeTime[i]);
                } 
                {
                    pw.print(" rxBytes=");
                    pw.print(rxBytes[i]);
                } 
                {
                    pw.print(" rxPackets=");
                    pw.print(rxPackets[i]);
                } 
                {
                    pw.print(" txBytes=");
                    pw.print(txBytes[i]);
                } 
                {
                    pw.print(" txPackets=");
                    pw.print(txPackets[i]);
                } 
                {
                    pw.print(" operations=");
                    pw.print(operations[i]);
                } 
                pw.println();
            } 
        } 
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        addTaint(fullHistory);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_method = "BC70BAB3B88F6C51172FD25602AB6B1A", hash_generated_method = "26548943D11CC3444E0C3FCBFD273389")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_350935382 = null; 
        final CharArrayWriter writer = new CharArrayWriter();
        dump("", new PrintWriter(writer), false);
        varB4EAC82CA7396A68D541C85D26508E83_350935382 = writer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_350935382.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_350935382;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static long getLong(long[] array, int i, long value) {
        return array != null ? array[i] : value;
    }

    
    @DSModeled(DSC.SAFE)
    private static void setLong(long[] array, int i, long value) {
        if (array != null) array[i] = value;
    }

    
    @DSModeled(DSC.SAFE)
    private static void addLong(long[] array, int i, long value) {
        if (array != null) array[i] += value;
    }

    
    public static class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "12D6496AFB9546FF78CE1A9D7D8F4BFC", hash_generated_field = "7C1BAD4742A4B22366B6D0FF5D8B7450")

        public long bucketDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "FB4A06AB2BFDF0DA1206B27E9ECBA4D5", hash_generated_field = "1F3D020C44602964FFF2B3A5FE620FA4")

        public long bucketStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "69A1B59160AD46B165263D22FA543821", hash_generated_field = "711F26C2ABCF9DB9AF8FD37E3598B0DD")

        public long activeTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "9910EB628EC91FE06D2639B0F3810F0E")

        public long rxBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "6ADCDCD12FD7D35118980BC0BB165142")

        public long rxPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "676F2C3D88E440A0E185A42A7F55CF74")

        public long txBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "B93ED690B1DA86F6CE26308A7104AEFF")

        public long txPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "49E564B98B6E0E4454081C4D76AD6B00")

        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
        public Entry ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.776 -0400", hash_original_field = "C6CA91666EC9B9D3DC554BA247E19FAD", hash_generated_field = "83092BBB72C91C04DD841B95A4680A5D")

        public static final long UNKNOWN = -1;
    }


    
    public static class DataStreamUtils {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.777 -0400", hash_original_method = "19FEB3F8DC1B5C5DFE6BAC6ABFB6225F", hash_generated_method = "19FEB3F8DC1B5C5DFE6BAC6ABFB6225F")
        public DataStreamUtils ()
        {
            
        }


        @Deprecated
        public static long[] readFullLongArray(DataInputStream in) throws IOException {
            final int size = in.readInt();
            final long[] values = new long[size];
            for (int i = 0; i < values.length; i++) {
                values[i] = in.readLong();
            }
            return values;
        }

        
        public static long readVarLong(DataInputStream in) throws IOException {
            int shift = 0;
            long result = 0;
            while (shift < 64) {
                byte b = in.readByte();
                result |= (long) (b & 0x7F) << shift;
                if ((b & 0x80) == 0)
                    return result;
                shift += 7;
            }
            throw new ProtocolException("malformed long");
        }

        
        public static void writeVarLong(DataOutputStream out, long value) throws IOException {
            while (true) {
                if ((value & ~0x7FL) == 0) {
                    out.writeByte((int) value);
                    return;
                } else {
                    out.writeByte(((int) value & 0x7F) | 0x80);
                    value >>>= 7;
                }
            }
        }

        
        public static long[] readVarLongArray(DataInputStream in) throws IOException {
            final int size = in.readInt();
            if (size == -1) return null;
            final long[] values = new long[size];
            for (int i = 0; i < values.length; i++) {
                values[i] = readVarLong(in);
            }
            return values;
        }

        
        public static void writeVarLongArray(DataOutputStream out, long[] values, int size) throws IOException {
            if (values == null) {
                out.writeInt(-1);
                return;
            }
            if (size > values.length) {
                throw new IllegalArgumentException("size larger than length");
            }
            out.writeInt(size);
            for (int i = 0; i < size; i++) {
                writeVarLong(out, values[i]);
            }
        }

        
    }


    
    public static class ParcelUtils {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.778 -0400", hash_original_method = "B81D28E36C3A9E7E89F9825844B173D9", hash_generated_method = "B81D28E36C3A9E7E89F9825844B173D9")
        public ParcelUtils ()
        {
            
        }


        public static long[] readLongArray(Parcel in) {
            final int size = in.readInt();
            if (size == -1) return null;
            final long[] values = new long[size];
            for (int i = 0; i < values.length; i++) {
                values[i] = in.readLong();
            }
            return values;
        }

        
        public static void writeLongArray(Parcel out, long[] values, int size) {
            if (values == null) {
                out.writeInt(-1);
                return;
            }
            if (size > values.length) {
                throw new IllegalArgumentException("size larger than length");
            }
            out.writeInt(size);
            for (int i = 0; i < size; i++) {
                out.writeLong(values[i]);
            }
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.778 -0400", hash_original_field = "71DB0559A739A1F04A9BB9065E47841B", hash_generated_field = "1ECA6D6E7F9A26B50E8896C3111CB80C")

    private static final int VERSION_INIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.778 -0400", hash_original_field = "A8ED1BC0994298CA574C5ED20A331C07", hash_generated_field = "3CEE91C167DFC5FDE739B07D71FE2144")

    private static final int VERSION_ADD_PACKETS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "4A2BB6F6CC4997DA38BD29BD37660C06", hash_generated_field = "480EA4EDB42382D1BD31224733D0AC9F")

    private static final int VERSION_ADD_ACTIVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "E5C2F68D026E99EE8A4A5E78F4EFD96E", hash_generated_field = "B30C161561419447A145BC3806950DF6")

    public static final int FIELD_ACTIVE_TIME = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "B93DD3A7D76961E415CB63BB9E0016BD", hash_generated_field = "B83AA8C9CBADCF8323FE156C6521F4F8")

    public static final int FIELD_RX_BYTES = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "0656261A0A68FD17919E646766D43CB3", hash_generated_field = "B1A30D37D59A5939979CC4F381D13A2A")

    public static final int FIELD_RX_PACKETS = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "AA288ABEEBB96463DCB4D393D8EA43CC", hash_generated_field = "7307AE6481C1A7B49CCC878109302487")

    public static final int FIELD_TX_BYTES = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "8CD57B3A93D6B68853351D8BD3D06107", hash_generated_field = "8C11DB6B6D297F056A0D084A3E40A14A")

    public static final int FIELD_TX_PACKETS = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "E74E1D4EA23759F62C0E2D43FDA689DB", hash_generated_field = "9A1CC8FBB50D3CE2F1BB1A44BFD95E80")

    public static final int FIELD_OPERATIONS = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "0D4C44C436AF0A0B5BA65EB9D7761285", hash_generated_field = "CD0D0EE4410996E4C6C61BD9919399D7")

    public static final int FIELD_ALL = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.779 -0400", hash_original_field = "048BF4BBB96644622132F9F51E1DB96F", hash_generated_field = "D81F6106977C71918B1EF6EAB4131577")

    public static final Creator<NetworkStatsHistory> CREATOR = new Creator<NetworkStatsHistory>() {
        public NetworkStatsHistory createFromParcel(Parcel in) {
            return new NetworkStatsHistory(in);
        }

        public NetworkStatsHistory[] newArray(int size) {
            return new NetworkStatsHistory[size];
        }
    };
    
    public NetworkStatsHistory createFromParcel(Parcel in) {
            return new NetworkStatsHistory(in);
        }
    
    
    public NetworkStatsHistory[] newArray(int size) {
            return new NetworkStatsHistory[size];
        }
    
}

