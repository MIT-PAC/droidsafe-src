package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private long bucketDuration;
    private int bucketCount;
    private long[] bucketStart;
    private long[] activeTime;
    private long[] rxBytes;
    private long[] rxPackets;
    private long[] txBytes;
    private long[] txPackets;
    private long[] operations;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.298 -0400", hash_original_method = "87FB06C16EBBFAA433DCDABD0A1A2DD9", hash_generated_method = "F47A55D3DC58853BCFD853EAE1BF18C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStatsHistory(long bucketDuration) {
        this(bucketDuration, 10, FIELD_ALL);
        dsTaint.addTaint(bucketDuration);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.298 -0400", hash_original_method = "EAC8ED507C3789501B6488454258F44A", hash_generated_method = "82CFBC349154BA782C5DC2E44476D583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStatsHistory(long bucketDuration, int initialSize) {
        this(bucketDuration, initialSize, FIELD_ALL);
        dsTaint.addTaint(bucketDuration);
        dsTaint.addTaint(initialSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.299 -0400", hash_original_method = "91F33DD6289F13A1041AE60DDEFCB3A5", hash_generated_method = "AC858E54141DEDB40B4E58359AAD536D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStatsHistory(long bucketDuration, int initialSize, int fields) {
        dsTaint.addTaint(bucketDuration);
        dsTaint.addTaint(initialSize);
        dsTaint.addTaint(fields);
        bucketStart = new long[initialSize];
        activeTime = new long[initialSize];
        rxBytes = new long[initialSize];
        rxPackets = new long[initialSize];
        txBytes = new long[initialSize];
        txPackets = new long[initialSize];
        operations = new long[initialSize];
        bucketCount = 0;
        // ---------- Original Method ----------
        //this.bucketDuration = bucketDuration;
        //bucketStart = new long[initialSize];
        //if ((fields & FIELD_ACTIVE_TIME) != 0) activeTime = new long[initialSize];
        //if ((fields & FIELD_RX_BYTES) != 0) rxBytes = new long[initialSize];
        //if ((fields & FIELD_RX_PACKETS) != 0) rxPackets = new long[initialSize];
        //if ((fields & FIELD_TX_BYTES) != 0) txBytes = new long[initialSize];
        //if ((fields & FIELD_TX_PACKETS) != 0) txPackets = new long[initialSize];
        //if ((fields & FIELD_OPERATIONS) != 0) operations = new long[initialSize];
        //bucketCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.299 -0400", hash_original_method = "C5C154CF2AF179AC7D0E69C633C9B809", hash_generated_method = "DE597B1274C27A0FF9C6F9D1EB96BDF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStatsHistory(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        bucketDuration = in.readLong();
        bucketStart = readLongArray(in);
        activeTime = readLongArray(in);
        rxBytes = readLongArray(in);
        rxPackets = readLongArray(in);
        txBytes = readLongArray(in);
        txPackets = readLongArray(in);
        operations = readLongArray(in);
        bucketCount = bucketStart.length;
        // ---------- Original Method ----------
        //bucketDuration = in.readLong();
        //bucketStart = readLongArray(in);
        //activeTime = readLongArray(in);
        //rxBytes = readLongArray(in);
        //rxPackets = readLongArray(in);
        //txBytes = readLongArray(in);
        //txPackets = readLongArray(in);
        //operations = readLongArray(in);
        //bucketCount = bucketStart.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.300 -0400", hash_original_method = "EDC1A57CB9EE8B46632E6D4E4377F32F", hash_generated_method = "F0B92246A6AEC4B420E78B3561113DBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStatsHistory(DataInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        int version;
        version = in.readInt();
        //Begin case VERSION_INIT 
        {
            bucketDuration = in.readLong();
            bucketStart = readFullLongArray(in);
            rxBytes = readFullLongArray(in);
            rxPackets = new long[bucketStart.length];
            txBytes = readFullLongArray(in);
            txPackets = new long[bucketStart.length];
            operations = new long[bucketStart.length];
            bucketCount = bucketStart.length;
        } //End block
        //End case VERSION_INIT 
        //Begin case VERSION_ADD_PACKETS VERSION_ADD_ACTIVE 
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
        } //End block
        //End case VERSION_ADD_PACKETS VERSION_ADD_ACTIVE 
        //Begin case default 
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("unexpected version: " + version);
        } //End block
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.300 -0400", hash_original_method = "7FCED8E87AE3E02DFD52BA28011A12D7", hash_generated_method = "1D270C40707D585F5EDA8ADB62690913")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeLong(bucketDuration);
        writeLongArray(out, bucketStart, bucketCount);
        writeLongArray(out, activeTime, bucketCount);
        writeLongArray(out, rxBytes, bucketCount);
        writeLongArray(out, rxPackets, bucketCount);
        writeLongArray(out, txBytes, bucketCount);
        writeLongArray(out, txPackets, bucketCount);
        writeLongArray(out, operations, bucketCount);
        // ---------- Original Method ----------
        //out.writeLong(bucketDuration);
        //writeLongArray(out, bucketStart, bucketCount);
        //writeLongArray(out, activeTime, bucketCount);
        //writeLongArray(out, rxBytes, bucketCount);
        //writeLongArray(out, rxPackets, bucketCount);
        //writeLongArray(out, txBytes, bucketCount);
        //writeLongArray(out, txPackets, bucketCount);
        //writeLongArray(out, operations, bucketCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.300 -0400", hash_original_method = "F25B937341175CC0273E2E92554C8F17", hash_generated_method = "2D1C7B16BA30CF327DEAFABADC81FFFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToStream(DataOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(VERSION_ADD_ACTIVE);
        out.writeLong(bucketDuration);
        writeVarLongArray(out, bucketStart, bucketCount);
        writeVarLongArray(out, activeTime, bucketCount);
        writeVarLongArray(out, rxBytes, bucketCount);
        writeVarLongArray(out, rxPackets, bucketCount);
        writeVarLongArray(out, txBytes, bucketCount);
        writeVarLongArray(out, txPackets, bucketCount);
        writeVarLongArray(out, operations, bucketCount);
        // ---------- Original Method ----------
        //out.writeInt(VERSION_ADD_ACTIVE);
        //out.writeLong(bucketDuration);
        //writeVarLongArray(out, bucketStart, bucketCount);
        //writeVarLongArray(out, activeTime, bucketCount);
        //writeVarLongArray(out, rxBytes, bucketCount);
        //writeVarLongArray(out, rxPackets, bucketCount);
        //writeVarLongArray(out, txBytes, bucketCount);
        //writeVarLongArray(out, txPackets, bucketCount);
        //writeVarLongArray(out, operations, bucketCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.304 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.304 -0400", hash_original_method = "3E2D8D04EF3E8C4BDF56D4CFDD864A04", hash_generated_method = "ADD848A324E0995150D2E0D75D6CB22B")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return bucketCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.305 -0400", hash_original_method = "D0E743773F77C0F20C1DE2E3BE48F30B", hash_generated_method = "0CC0A31C0A2C898D465B2A2DA841875F")
    @DSModeled(DSC.SAFE)
    public long getBucketDuration() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return bucketDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.305 -0400", hash_original_method = "0DA78BB7B3F99E1543E4DC9DFD2BD9F4", hash_generated_method = "A98CB0BCF03A2A3F2EAE22220E4EE79A")
    @DSModeled(DSC.SAFE)
    public long getStart() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (bucketCount > 0) {
            //return bucketStart[0];
        //} else {
            //return Long.MAX_VALUE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.305 -0400", hash_original_method = "D4476AE88A84FACA51BF4BF1E3EE2F8D", hash_generated_method = "7A1E066F0786D5476CC5F5A2E01DE9F1")
    @DSModeled(DSC.SAFE)
    public long getEnd() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (bucketCount > 0) {
            //return bucketStart[bucketCount - 1] + bucketDuration;
        //} else {
            //return Long.MIN_VALUE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.305 -0400", hash_original_method = "44CA8F6D269FC47862A9173C06F73618", hash_generated_method = "699561F84EF1728C4849F30CCF427A31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIndexBefore(long time) {
        dsTaint.addTaint(time);
        int index;
        index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        {
            index = (~index) - 1;
        } //End block
        {
            index -= 1;
        } //End block
        int var9BF4435ACED8AF26C4B672EFA1D4FDD8_429399243 = (MathUtils.constrain(index, 0, bucketCount - 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        //if (index < 0) {
            //index = (~index) - 1;
        //} else {
            //index -= 1;
        //}
        //return MathUtils.constrain(index, 0, bucketCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.306 -0400", hash_original_method = "44680AD61A9756C7015B14278BDED4D1", hash_generated_method = "A6393FA4CBBDAA7E00490B09F0316E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIndexAfter(long time) {
        dsTaint.addTaint(time);
        int index;
        index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        {
            index = ~index;
        } //End block
        {
            index += 1;
        } //End block
        int var9BF4435ACED8AF26C4B672EFA1D4FDD8_434257596 = (MathUtils.constrain(index, 0, bucketCount - 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        //if (index < 0) {
            //index = ~index;
        //} else {
            //index += 1;
        //}
        //return MathUtils.constrain(index, 0, bucketCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.306 -0400", hash_original_method = "75531F5194A56E3573F283D646BEE902", hash_generated_method = "183631C7C29B0ADCE03D79A2E4C01D7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getValues(int i, Entry recycle) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(i);
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
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Entry entry = recycle != null ? recycle : new Entry();
        //entry.bucketStart = bucketStart[i];
        //entry.bucketDuration = bucketDuration;
        //entry.activeTime = getLong(activeTime, i, UNKNOWN);
        //entry.rxBytes = getLong(rxBytes, i, UNKNOWN);
        //entry.rxPackets = getLong(rxPackets, i, UNKNOWN);
        //entry.txBytes = getLong(txBytes, i, UNKNOWN);
        //entry.txPackets = getLong(txPackets, i, UNKNOWN);
        //entry.operations = getLong(operations, i, UNKNOWN);
        //return entry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.307 -0400", hash_original_method = "74712D26283E9B32FCB8C3574DCFFFFA", hash_generated_method = "D8B226F04089745149440244142DB164")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void recordData(long start, long end, long rxBytes, long txBytes) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(end);
        recordData(start, end, new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, 0L, txBytes, 0L, 0L));
        // ---------- Original Method ----------
        //recordData(start, end, new NetworkStats.Entry(
                //IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, 0L, txBytes, 0L, 0L));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.307 -0400", hash_original_method = "3FF3F0D6B4FEA69386DC61191DDF3D5F", hash_generated_method = "FC4FC6F2BDF39513018FBABCE512911E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recordData(long start, long end, NetworkStats.Entry entry) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(entry.dsTaint);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("tried recording negative data");
        } //End block
        ensureBuckets(start, end);
        long duration;
        duration = end - start;
        int startIndex;
        startIndex = getIndexAfter(end);
        {
            int i;
            i = startIndex;
            {
                long curStart;
                curStart = bucketStart[i];
                long curEnd;
                curEnd = curStart + bucketDuration;
                long overlap;
                overlap = Math.min(curEnd, end) - Math.max(curStart, start);
                long fracRxBytes;
                fracRxBytes = entry.rxBytes * overlap / duration;
                long fracRxPackets;
                fracRxPackets = entry.rxPackets * overlap / duration;
                long fracTxBytes;
                fracTxBytes = entry.txBytes * overlap / duration;
                long fracTxPackets;
                fracTxPackets = entry.txPackets * overlap / duration;
                long fracOperations;
                fracOperations = entry.operations * overlap / duration;
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
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.308 -0400", hash_original_method = "3DDEBC644DC519B4D2C820693B031478", hash_generated_method = "8775BB14FDD4DC2B5065F8E21E36E1FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recordEntireHistory(NetworkStatsHistory input) {
        dsTaint.addTaint(input.dsTaint);
        NetworkStats.Entry entry;
        entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        {
            int i;
            i = 0;
            {
                long start;
                start = input.bucketStart[i];
                long end;
                end = start + input.bucketDuration;
                entry.rxBytes = getLong(input.rxBytes, i, 0L);
                entry.rxPackets = getLong(input.rxPackets, i, 0L);
                entry.txBytes = getLong(input.txBytes, i, 0L);
                entry.txPackets = getLong(input.txPackets, i, 0L);
                entry.operations = getLong(input.operations, i, 0L);
                recordData(start, end, entry);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final NetworkStats.Entry entry = new NetworkStats.Entry(
                //IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        //for (int i = 0; i < input.bucketCount; i++) {
            //final long start = input.bucketStart[i];
            //final long end = start + input.bucketDuration;
            //entry.rxBytes = getLong(input.rxBytes, i, 0L);
            //entry.rxPackets = getLong(input.rxPackets, i, 0L);
            //entry.txBytes = getLong(input.txBytes, i, 0L);
            //entry.txPackets = getLong(input.txPackets, i, 0L);
            //entry.operations = getLong(input.operations, i, 0L);
            //recordData(start, end, entry);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.308 -0400", hash_original_method = "B927CFA0CEDE41C1E5D84D22AEB0E325", hash_generated_method = "B3F5E85FC3F76600C4E32DC534791106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureBuckets(long start, long end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        start -= start % bucketDuration;
        end += (bucketDuration - (end % bucketDuration)) % bucketDuration;
        {
            long now;
            now = start;
            now += bucketDuration;
            {
                int index;
                index = Arrays.binarySearch(bucketStart, 0, bucketCount, now);
                {
                    insertBucket(~index, now);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //start -= start % bucketDuration;
        //end += (bucketDuration - (end % bucketDuration)) % bucketDuration;
        //for (long now = start; now < end; now += bucketDuration) {
            //final int index = Arrays.binarySearch(bucketStart, 0, bucketCount, now);
            //if (index < 0) {
                //insertBucket(~index, now);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.309 -0400", hash_original_method = "B3108244F274B858A2EC662DDA9927CD", hash_generated_method = "5C3EEB8A3646FDE7C10A417FDF51700E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void insertBucket(int index, long start) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        {
            int newLength;
            newLength = Math.max(bucketStart.length, 10) * 3 / 2;
            bucketStart = Arrays.copyOf(bucketStart, newLength);
            activeTime = Arrays.copyOf(activeTime, newLength);
            rxBytes = Arrays.copyOf(rxBytes, newLength);
            rxPackets = Arrays.copyOf(rxPackets, newLength);
            txBytes = Arrays.copyOf(txBytes, newLength);
            txPackets = Arrays.copyOf(txPackets, newLength);
            operations = Arrays.copyOf(operations, newLength);
        } //End block
        {
            int dstPos;
            dstPos = index + 1;
            int length;
            length = bucketCount - index;
            System.arraycopy(bucketStart, index, bucketStart, dstPos, length);
            System.arraycopy(activeTime, index, activeTime, dstPos, length);
            System.arraycopy(rxBytes, index, rxBytes, dstPos, length);
            System.arraycopy(rxPackets, index, rxPackets, dstPos, length);
            System.arraycopy(txBytes, index, txBytes, dstPos, length);
            System.arraycopy(txPackets, index, txPackets, dstPos, length);
            System.arraycopy(operations, index, operations, dstPos, length);
        } //End block
        bucketStart[index] = start;
        setLong(activeTime, index, 0L);
        setLong(rxBytes, index, 0L);
        setLong(rxPackets, index, 0L);
        setLong(txBytes, index, 0L);
        setLong(txPackets, index, 0L);
        setLong(operations, index, 0L);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.310 -0400", hash_original_method = "D42FFE9A180911A657FA083FF5768836", hash_generated_method = "336A66544F9A77849AB230D8F3B0B370")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeBucketsBefore(long cutoff) {
        dsTaint.addTaint(cutoff);
        int i;
        {
            i = 0;
            {
                long curStart;
                curStart = bucketStart[i];
                long curEnd;
                curEnd = curStart + bucketDuration;
            } //End block
        } //End collapsed parenthetic
        {
            int length;
            length = bucketStart.length;
            bucketStart = Arrays.copyOfRange(bucketStart, i, length);
            activeTime = Arrays.copyOfRange(activeTime, i, length);
            rxBytes = Arrays.copyOfRange(rxBytes, i, length);
            rxPackets = Arrays.copyOfRange(rxPackets, i, length);
            txBytes = Arrays.copyOfRange(txBytes, i, length);
            txPackets = Arrays.copyOfRange(txPackets, i, length);
            operations = Arrays.copyOfRange(operations, i, length);
            bucketCount -= i;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.310 -0400", hash_original_method = "846F78477F792FCCB9A623410DF90C52", hash_generated_method = "54414625FFDA686591129978953AB406")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getValues(long start, long end, Entry recycle) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        Entry varB3909EBE5F25036FE509D60872718F3E_140827908 = (getValues(start, end, Long.MAX_VALUE, recycle));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getValues(start, end, Long.MAX_VALUE, recycle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.311 -0400", hash_original_method = "FB71475C239CC1C7BD0FFCD80328C5DA", hash_generated_method = "A94E7682D86E1FA614411C61BF5E190D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getValues(long start, long end, long now, Entry recycle) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(now);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
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
        int startIndex;
        startIndex = getIndexAfter(end);
        {
            int i;
            i = startIndex;
            {
                long curStart;
                curStart = bucketStart[i];
                long curEnd;
                curEnd = curStart + bucketDuration;
                boolean activeBucket;
                activeBucket = curStart < now && curEnd > now;
                long overlap;
                {
                    overlap = bucketDuration;
                } //End block
                {
                    long overlapEnd;
                    overlapEnd = curEnd;
                    overlapEnd = end;
                    long overlapStart;
                    overlapStart = curStart;
                    overlapStart = start;
                    overlap = overlapEnd - overlapStart;
                } //End block
                entry.activeTime += activeTime[i] * overlap / bucketDuration;
                entry.rxBytes += rxBytes[i] * overlap / bucketDuration;
                entry.rxPackets += rxPackets[i] * overlap / bucketDuration;
                entry.txBytes += txBytes[i] * overlap / bucketDuration;
                entry.txPackets += txPackets[i] * overlap / bucketDuration;
                entry.operations += operations[i] * overlap / bucketDuration;
            } //End block
        } //End collapsed parenthetic
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.311 -0400", hash_original_method = "AB86ED9AABA220FE0A64D0BEB0ADF734", hash_generated_method = "1D1B3708C24EAB44894D1B957E4A06F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void generateRandom(long start, long end, long bytes) {
        dsTaint.addTaint(bytes);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        Random r;
        r = new Random();
        float fractionRx;
        fractionRx = r.nextFloat();
        long rxBytes;
        rxBytes = (long) (bytes * fractionRx);
        long txBytes;
        txBytes = (long) (bytes * (1 - fractionRx));
        long rxPackets;
        rxPackets = rxBytes / 1024;
        long txPackets;
        txPackets = txBytes / 1024;
        long operations;
        operations = rxBytes / 2048;
        generateRandom(start, end, rxBytes, rxPackets, txBytes, txPackets, operations, r);
        // ---------- Original Method ----------
        //final Random r = new Random();
        //final float fractionRx = r.nextFloat();
        //final long rxBytes = (long) (bytes * fractionRx);
        //final long txBytes = (long) (bytes * (1 - fractionRx));
        //final long rxPackets = rxBytes / 1024;
        //final long txPackets = txBytes / 1024;
        //final long operations = rxBytes / 2048;
        //generateRandom(start, end, rxBytes, rxPackets, txBytes, txPackets, operations, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.312 -0400", hash_original_method = "2B4929E4FB42F9E11DEF8BA8131121D5", hash_generated_method = "308E0B89D19CE1BE63CF928697BB401D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void generateRandom(long start, long end, long rxBytes, long rxPackets, long txBytes,
            long txPackets, long operations, Random r) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(end);
        dsTaint.addTaint(rxPackets);
        ensureBuckets(start, end);
        NetworkStats.Entry entry;
        entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        {
            long curStart;
            curStart = randomLong(r, start, end);
            long curEnd;
            curEnd = curStart + randomLong(r, 0, (end - curStart) / 2);
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static long randomLong(Random r, long start, long end) {
        return (long) (start + (r.nextFloat() * (end - start)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.313 -0400", hash_original_method = "9A3509822F71494F86F9AA38F61F7118", hash_generated_method = "BE88930C2B5FFFFC6092F6A07A1D4153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(String prefix, PrintWriter pw, boolean fullHistory) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(fullHistory);
        dsTaint.addTaint(pw.dsTaint);
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
        } //End block
        {
            int i;
            i = start;
            {
                pw.print(prefix);
                pw.print("  bucketStart=");
                pw.print(bucketStart[i]);
                {
                    pw.print(" activeTime=");
                    pw.print(activeTime[i]);
                } //End block
                {
                    pw.print(" rxBytes=");
                    pw.print(rxBytes[i]);
                } //End block
                {
                    pw.print(" rxPackets=");
                    pw.print(rxPackets[i]);
                } //End block
                {
                    pw.print(" txBytes=");
                    pw.print(txBytes[i]);
                } //End block
                {
                    pw.print(" txPackets=");
                    pw.print(txPackets[i]);
                } //End block
                {
                    pw.print(" operations=");
                    pw.print(operations[i]);
                } //End block
                pw.println();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.313 -0400", hash_original_method = "BC70BAB3B88F6C51172FD25602AB6B1A", hash_generated_method = "65F5DADAC3854E3AACDC00EFCC083106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        CharArrayWriter writer;
        writer = new CharArrayWriter();
        dump("", new PrintWriter(writer), false);
        String var06A4604668A7B483F2A3D13B0FB7EF06_1422169169 = (writer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final CharArrayWriter writer = new CharArrayWriter();
        //dump("", new PrintWriter(writer), false);
        //return writer.toString();
    }

    
        private static long getLong(long[] array, int i, long value) {
        return array != null ? array[i] : value;
    }

    
        private static void setLong(long[] array, int i, long value) {
        if (array != null) array[i] = value;
    }

    
        private static void addLong(long[] array, int i, long value) {
        if (array != null) array[i] += value;
    }

    
    public static class Entry {
        public long bucketDuration;
        public long bucketStart;
        public long activeTime;
        public long rxBytes;
        public long rxPackets;
        public long txBytes;
        public long txPackets;
        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.317 -0400", hash_original_method = "353831000CECA5D9D5B60D3D4A47F9C3", hash_generated_method = "353831000CECA5D9D5B60D3D4A47F9C3")
                public Entry ()
        {
        }


        public static final long UNKNOWN = -1;
    }


    
    public static class DataStreamUtils {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.317 -0400", hash_original_method = "DDA94E8BFF3758F627B5B9036BFF5834", hash_generated_method = "DDA94E8BFF3758F627B5B9036BFF5834")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.319 -0400", hash_original_method = "4052CA857FDE0505755DAA83CBE61BE2", hash_generated_method = "4052CA857FDE0505755DAA83CBE61BE2")
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


    
    private static final int VERSION_INIT = 1;
    private static final int VERSION_ADD_PACKETS = 2;
    private static final int VERSION_ADD_ACTIVE = 3;
    public static final int FIELD_ACTIVE_TIME = 0x01;
    public static final int FIELD_RX_BYTES = 0x02;
    public static final int FIELD_RX_PACKETS = 0x04;
    public static final int FIELD_TX_BYTES = 0x08;
    public static final int FIELD_TX_PACKETS = 0x10;
    public static final int FIELD_OPERATIONS = 0x20;
    public static final int FIELD_ALL = 0xFFFFFFFF;
    public static final Creator<NetworkStatsHistory> CREATOR = new Creator<NetworkStatsHistory>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.320 -0400", hash_original_method = "83C291D635CD9A2169A9EB499CBBB9B0", hash_generated_method = "16ECA7A335CE92E340C33CF81250DADE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkStatsHistory createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            NetworkStatsHistory var01C6CE16D827162A3736D7F69007DCEF_1811484557 = (new NetworkStatsHistory(in));
            return (NetworkStatsHistory)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkStatsHistory(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.320 -0400", hash_original_method = "8FC12375FE889D52751FCC71E935D0E4", hash_generated_method = "A23DA0202EED758247F00EA5403EFB06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkStatsHistory[] newArray(int size) {
            dsTaint.addTaint(size);
            NetworkStatsHistory[] varAD8E34E6E440D14671CE058F1B78BC2E_972617783 = (new NetworkStatsHistory[size]);
            return (NetworkStatsHistory[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkStatsHistory[size];
        }

        
}; //Transformed anonymous class
}

