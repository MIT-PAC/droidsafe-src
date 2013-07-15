package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "12D6496AFB9546FF78CE1A9D7D8F4BFC", hash_generated_field = "2DC5FC41152B76B2AF9AC6BB55A20FB5")

    private long bucketDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "3ED54E5E8C85283782F9EFF085B93E51", hash_generated_field = "5619EFB8F87F05852AF87EFEA39E4229")

    private int bucketCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "FB4A06AB2BFDF0DA1206B27E9ECBA4D5", hash_generated_field = "139AA0E6051DEFC8EEA60ED1156E8150")

    private long[] bucketStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "69A1B59160AD46B165263D22FA543821", hash_generated_field = "20E796E1CD2BA4BBB5978B0DA9E59A40")

    private long[] activeTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "835A90EA79ED43E63CD1F8551E1170AC")

    private long[] rxBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "3C8EA21CAE3964AFEC5D5287345DF52F")

    private long[] rxPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "5D0307CD93ADE4DF2FD18B8CD5214177")

    private long[] txBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "EF80B3F02FF3FE9875FC49D478831ABF")

    private long[] txPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "D54D9A650B72A41B61249C2CA8E210FC")

    private long[] operations;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.192 -0400", hash_original_method = "87FB06C16EBBFAA433DCDABD0A1A2DD9", hash_generated_method = "9BC80FF72FB768FAAFDEE19442FA2D5A")
    public  NetworkStatsHistory(long bucketDuration) {
        this(bucketDuration, 10, FIELD_ALL);
        addTaint(bucketDuration);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.193 -0400", hash_original_method = "EAC8ED507C3789501B6488454258F44A", hash_generated_method = "04CA3603F7E84D9EC51BF15D997481D4")
    public  NetworkStatsHistory(long bucketDuration, int initialSize) {
        this(bucketDuration, initialSize, FIELD_ALL);
        addTaint(initialSize);
        addTaint(bucketDuration);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.194 -0400", hash_original_method = "91F33DD6289F13A1041AE60DDEFCB3A5", hash_generated_method = "6D1F6B934D4FF55C0E9178B6DAFE7524")
    public  NetworkStatsHistory(long bucketDuration, int initialSize, int fields) {
        addTaint(fields);
        this.bucketDuration = bucketDuration;
        bucketStart = new long[initialSize];
    if((fields & FIELD_ACTIVE_TIME) != 0)        
        activeTime = new long[initialSize];
    if((fields & FIELD_RX_BYTES) != 0)        
        rxBytes = new long[initialSize];
    if((fields & FIELD_RX_PACKETS) != 0)        
        rxPackets = new long[initialSize];
    if((fields & FIELD_TX_BYTES) != 0)        
        txBytes = new long[initialSize];
    if((fields & FIELD_TX_PACKETS) != 0)        
        txPackets = new long[initialSize];
    if((fields & FIELD_OPERATIONS) != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.195 -0400", hash_original_method = "C5C154CF2AF179AC7D0E69C633C9B809", hash_generated_method = "16B280BFDD21585CB02BBFEF20047B68")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.198 -0400", hash_original_method = "EDC1A57CB9EE8B46632E6D4E4377F32F", hash_generated_method = "A4500129B855603CBD25B576EEEACAB5")
    public  NetworkStatsHistory(DataInputStream in) throws IOException {
        final int version = in.readInt();
switch(version){
        case VERSION_INIT:
        {
            bucketDuration = in.readLong();
            bucketStart = readFullLongArray(in);
            rxBytes = readFullLongArray(in);
            rxPackets = new long[bucketStart.length];
            txBytes = readFullLongArray(in);
            txPackets = new long[bucketStart.length];
            operations = new long[bucketStart.length];
            bucketCount = bucketStart.length;
            break;
        } //End block
        case VERSION_ADD_PACKETS:
        case VERSION_ADD_ACTIVE:
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
            break;
        } //End block
        default:
        {
            ProtocolException varFF51C94CF6B40EBCA9506CC5E444F13D_272956359 = new ProtocolException("unexpected version: " + version);
            varFF51C94CF6B40EBCA9506CC5E444F13D_272956359.addTaint(taint);
            throw varFF51C94CF6B40EBCA9506CC5E444F13D_272956359;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.198 -0400", hash_original_method = "7FCED8E87AE3E02DFD52BA28011A12D7", hash_generated_method = "5BCDAF5927C74D242506BDEB6E6A63C6")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.198 -0400", hash_original_method = "F25B937341175CC0273E2E92554C8F17", hash_generated_method = "15B0EAA0BFBDDE1927BD2E4EDA65B8BA")
    public void writeToStream(DataOutputStream out) throws IOException {
        addTaint(out.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.199 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0D744969D616078E42F6ADD139CE9DD7")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1628472853 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578942832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578942832;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.199 -0400", hash_original_method = "3E2D8D04EF3E8C4BDF56D4CFDD864A04", hash_generated_method = "F10DD82FDA70911B61AA20015A0CA0D3")
    public int size() {
        int var3ED54E5E8C85283782F9EFF085B93E51_9862181 = (bucketCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266027684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266027684;
        // ---------- Original Method ----------
        //return bucketCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.199 -0400", hash_original_method = "D0E743773F77C0F20C1DE2E3BE48F30B", hash_generated_method = "5A263F4B294B345CEBC0A8887561903A")
    public long getBucketDuration() {
        long var12D6496AFB9546FF78CE1A9D7D8F4BFC_1273294319 = (bucketDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1586692687 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1586692687;
        // ---------- Original Method ----------
        //return bucketDuration;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.199 -0400", hash_original_method = "0DA78BB7B3F99E1543E4DC9DFD2BD9F4", hash_generated_method = "2B94A79BEC39FA5AD2E3485B3566B130")
    public long getStart() {
    if(bucketCount > 0)        
        {
            long varBEBB54E1E5B7CDFF42B1F53B88CBEB77_295626707 = (bucketStart[0]);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_160830908 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_160830908;
        } //End block
        else
        {
            long var85712C72209F40438E81734FCEEB0717_1705058542 = (Long.MAX_VALUE);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1622793855 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1622793855;
        } //End block
        // ---------- Original Method ----------
        //if (bucketCount > 0) {
            //return bucketStart[0];
        //} else {
            //return Long.MAX_VALUE;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.200 -0400", hash_original_method = "D4476AE88A84FACA51BF4BF1E3EE2F8D", hash_generated_method = "0016A7958693FBC2603528606C849C57")
    public long getEnd() {
    if(bucketCount > 0)        
        {
            long var7FE60DA6D8934AF20B992FBB0E8381BA_520692325 = (bucketStart[bucketCount - 1] + bucketDuration);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_248711923 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_248711923;
        } //End block
        else
        {
            long var3C8E60A5FA3722D6B0A8842B383A1743_2012936202 = (Long.MIN_VALUE);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_622580483 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_622580483;
        } //End block
        // ---------- Original Method ----------
        //if (bucketCount > 0) {
            //return bucketStart[bucketCount - 1] + bucketDuration;
        //} else {
            //return Long.MIN_VALUE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.200 -0400", hash_original_method = "44CA8F6D269FC47862A9173C06F73618", hash_generated_method = "7AEBE52FAB2D99F64AE369F2955A420F")
    public int getIndexBefore(long time) {
        addTaint(time);
        int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
    if(index < 0)        
        {
            index = (~index) - 1;
        } //End block
        else
        {
            index -= 1;
        } //End block
        int var55A07FD4FB3AE34C1752A9F53745E123_392824321 = (MathUtils.constrain(index, 0, bucketCount - 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145147610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145147610;
        // ---------- Original Method ----------
        //int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        //if (index < 0) {
            //index = (~index) - 1;
        //} else {
            //index -= 1;
        //}
        //return MathUtils.constrain(index, 0, bucketCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.201 -0400", hash_original_method = "44680AD61A9756C7015B14278BDED4D1", hash_generated_method = "C6CD043CBAB9DD3619FF596887426158")
    public int getIndexAfter(long time) {
        addTaint(time);
        int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
    if(index < 0)        
        {
            index = ~index;
        } //End block
        else
        {
            index += 1;
        } //End block
        int var55A07FD4FB3AE34C1752A9F53745E123_1213018686 = (MathUtils.constrain(index, 0, bucketCount - 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006523155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006523155;
        // ---------- Original Method ----------
        //int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        //if (index < 0) {
            //index = ~index;
        //} else {
            //index += 1;
        //}
        //return MathUtils.constrain(index, 0, bucketCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.202 -0400", hash_original_method = "75531F5194A56E3573F283D646BEE902", hash_generated_method = "32EE5E64C633DF217C713A5565A9B68E")
    public Entry getValues(int i, Entry recycle) {
        addTaint(recycle.getTaint());
        final Entry entry = recycle != null ? recycle : new Entry();
        entry.bucketStart = bucketStart[i];
        entry.bucketDuration = bucketDuration;
        entry.activeTime = getLong(activeTime, i, UNKNOWN);
        entry.rxBytes = getLong(rxBytes, i, UNKNOWN);
        entry.rxPackets = getLong(rxPackets, i, UNKNOWN);
        entry.txBytes = getLong(txBytes, i, UNKNOWN);
        entry.txPackets = getLong(txPackets, i, UNKNOWN);
        entry.operations = getLong(operations, i, UNKNOWN);
Entry varF26DBE38545460D6F6AE1D948FF53869_1585244177 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_1585244177.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_1585244177;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.202 -0400", hash_original_method = "74712D26283E9B32FCB8C3574DCFFFFA", hash_generated_method = "9E994FDE3F7E0637E7C55BF2E6F779B4")
    @Deprecated
    public void recordData(long start, long end, long rxBytes, long txBytes) {
        addTaint(txBytes);
        addTaint(rxBytes);
        addTaint(end);
        addTaint(start);
        recordData(start, end, new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, 0L, txBytes, 0L, 0L));
        // ---------- Original Method ----------
        //recordData(start, end, new NetworkStats.Entry(
                //IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, 0L, txBytes, 0L, 0L));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.204 -0400", hash_original_method = "3FF3F0D6B4FEA69386DC61191DDF3D5F", hash_generated_method = "61AE3C90237246FD036A0EC8A477B187")
    public void recordData(long start, long end, NetworkStats.Entry entry) {
        addTaint(end);
        addTaint(start);
    if(entry.rxBytes < 0 || entry.rxPackets < 0 || entry.txBytes < 0 || entry.txPackets < 0
                || entry.operations < 0)        
        {
            IllegalArgumentException var767165DF19C4A354431816EBCFE68C5C_1124509455 = new IllegalArgumentException("tried recording negative data");
            var767165DF19C4A354431816EBCFE68C5C_1124509455.addTaint(taint);
            throw var767165DF19C4A354431816EBCFE68C5C_1124509455;
        } //End block
    if(entry.rxBytes == 0 && entry.rxPackets == 0 && entry.txBytes == 0 && entry.txPackets == 0
                && entry.operations == 0)        
        {
            return;
        } //End block
        ensureBuckets(start, end);
        long duration = end - start;
        final int startIndex = getIndexAfter(end);
for(int i = startIndex;i >= 0;i--)
        {
            final long curStart = bucketStart[i];
            final long curEnd = curStart + bucketDuration;
    if(curEnd < start)            
            break;
    if(curStart > end)            
            continue;
            final long overlap = Math.min(curEnd, end) - Math.max(curStart, start);
    if(overlap <= 0)            
            continue;
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.205 -0400", hash_original_method = "3DDEBC644DC519B4D2C820693B031478", hash_generated_method = "606C5A0C6741D778F6D152E14A3DB511")
    public void recordEntireHistory(NetworkStatsHistory input) {
        final NetworkStats.Entry entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
for(int i = 0;i < input.bucketCount;i++)
        {
            final long start = input.bucketStart[i];
            final long end = start + input.bucketDuration;
            entry.rxBytes = getLong(input.rxBytes, i, 0L);
            entry.rxPackets = getLong(input.rxPackets, i, 0L);
            entry.txBytes = getLong(input.txBytes, i, 0L);
            entry.txPackets = getLong(input.txPackets, i, 0L);
            entry.operations = getLong(input.operations, i, 0L);
            recordData(start, end, entry);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.205 -0400", hash_original_method = "B927CFA0CEDE41C1E5D84D22AEB0E325", hash_generated_method = "65A5593762A57F8716C24A61F19B3913")
    private void ensureBuckets(long start, long end) {
        addTaint(end);
        addTaint(start);
        start -= start % bucketDuration;
        end += (bucketDuration - (end % bucketDuration)) % bucketDuration;
for(long now = start;now < end;now += bucketDuration)
        {
            final int index = Arrays.binarySearch(bucketStart, 0, bucketCount, now);
    if(index < 0)            
            {
                insertBucket(~index, now);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.206 -0400", hash_original_method = "B3108244F274B858A2EC662DDA9927CD", hash_generated_method = "B15E73E3E16803BCB6648DF260BBEBAA")
    private void insertBucket(int index, long start) {
    if(bucketCount >= bucketStart.length)        
        {
            final int newLength = Math.max(bucketStart.length, 10) * 3 / 2;
            bucketStart = Arrays.copyOf(bucketStart, newLength);
    if(activeTime != null)            
            activeTime = Arrays.copyOf(activeTime, newLength);
    if(rxBytes != null)            
            rxBytes = Arrays.copyOf(rxBytes, newLength);
    if(rxPackets != null)            
            rxPackets = Arrays.copyOf(rxPackets, newLength);
    if(txBytes != null)            
            txBytes = Arrays.copyOf(txBytes, newLength);
    if(txPackets != null)            
            txPackets = Arrays.copyOf(txPackets, newLength);
    if(operations != null)            
            operations = Arrays.copyOf(operations, newLength);
        } //End block
    if(index < bucketCount)        
        {
            final int dstPos = index + 1;
            final int length = bucketCount - index;
            System.arraycopy(bucketStart, index, bucketStart, dstPos, length);
    if(activeTime != null)            
            System.arraycopy(activeTime, index, activeTime, dstPos, length);
    if(rxBytes != null)            
            System.arraycopy(rxBytes, index, rxBytes, dstPos, length);
    if(rxPackets != null)            
            System.arraycopy(rxPackets, index, rxPackets, dstPos, length);
    if(txBytes != null)            
            System.arraycopy(txBytes, index, txBytes, dstPos, length);
    if(txPackets != null)            
            System.arraycopy(txPackets, index, txPackets, dstPos, length);
    if(operations != null)            
            System.arraycopy(operations, index, operations, dstPos, length);
        } //End block
        bucketStart[index] = start;
        setLong(activeTime, index, 0L);
        setLong(rxBytes, index, 0L);
        setLong(rxPackets, index, 0L);
        setLong(txBytes, index, 0L);
        setLong(txPackets, index, 0L);
        setLong(operations, index, 0L);
        bucketCount++;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.207 -0400", hash_original_method = "D42FFE9A180911A657FA083FF5768836", hash_generated_method = "84FB4758067C1C8B7012336D5A30E02D")
    public void removeBucketsBefore(long cutoff) {
        addTaint(cutoff);
        int i;
for(i = 0;i < bucketCount;i++)
        {
            final long curStart = bucketStart[i];
            final long curEnd = curStart + bucketDuration;
    if(curEnd > cutoff)            
            break;
        } //End block
    if(i > 0)        
        {
            final int length = bucketStart.length;
            bucketStart = Arrays.copyOfRange(bucketStart, i, length);
    if(activeTime != null)            
            activeTime = Arrays.copyOfRange(activeTime, i, length);
    if(rxBytes != null)            
            rxBytes = Arrays.copyOfRange(rxBytes, i, length);
    if(rxPackets != null)            
            rxPackets = Arrays.copyOfRange(rxPackets, i, length);
    if(txBytes != null)            
            txBytes = Arrays.copyOfRange(txBytes, i, length);
    if(txPackets != null)            
            txPackets = Arrays.copyOfRange(txPackets, i, length);
    if(operations != null)            
            operations = Arrays.copyOfRange(operations, i, length);
            bucketCount -= i;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.209 -0400", hash_original_method = "846F78477F792FCCB9A623410DF90C52", hash_generated_method = "7ABA18D5E8ED738E00737F39363BAD92")
    public Entry getValues(long start, long end, Entry recycle) {
        addTaint(recycle.getTaint());
        addTaint(end);
        addTaint(start);
Entry var97A7A04E7119C9643CC72A9B8A7C83C4_170277126 =         getValues(start, end, Long.MAX_VALUE, recycle);
        var97A7A04E7119C9643CC72A9B8A7C83C4_170277126.addTaint(taint);
        return var97A7A04E7119C9643CC72A9B8A7C83C4_170277126;
        // ---------- Original Method ----------
        //return getValues(start, end, Long.MAX_VALUE, recycle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.211 -0400", hash_original_method = "FB71475C239CC1C7BD0FFCD80328C5DA", hash_generated_method = "8FCD02C38BE6C34B353B47AD12D9E341")
    public Entry getValues(long start, long end, long now, Entry recycle) {
        addTaint(recycle.getTaint());
        addTaint(now);
        final Entry entry = recycle != null ? recycle : new Entry();
        entry.bucketDuration = end - start;
        entry.bucketStart = start;
        entry.activeTime = activeTime != null ? 0 : UNKNOWN;
        entry.rxBytes = rxBytes != null ? 0 : UNKNOWN;
        entry.rxPackets = rxPackets != null ? 0 : UNKNOWN;
        entry.txBytes = txBytes != null ? 0 : UNKNOWN;
        entry.txPackets = txPackets != null ? 0 : UNKNOWN;
        entry.operations = operations != null ? 0 : UNKNOWN;
        final int startIndex = getIndexAfter(end);
for(int i = startIndex;i >= 0;i--)
        {
            final long curStart = bucketStart[i];
            final long curEnd = curStart + bucketDuration;
    if(curEnd <= start)            
            break;
    if(curStart >= end)            
            continue;
            final boolean activeBucket = curStart < now && curEnd > now;
            long overlap;
    if(activeBucket)            
            {
                overlap = bucketDuration;
            } //End block
            else
            {
                final long overlapEnd = curEnd < end ? curEnd : end;
                final long overlapStart = curStart > start ? curStart : start;
                overlap = overlapEnd - overlapStart;
            } //End block
    if(overlap <= 0)            
            continue;
    if(activeTime != null)            
            entry.activeTime += activeTime[i] * overlap / bucketDuration;
    if(rxBytes != null)            
            entry.rxBytes += rxBytes[i] * overlap / bucketDuration;
    if(rxPackets != null)            
            entry.rxPackets += rxPackets[i] * overlap / bucketDuration;
    if(txBytes != null)            
            entry.txBytes += txBytes[i] * overlap / bucketDuration;
    if(txPackets != null)            
            entry.txPackets += txPackets[i] * overlap / bucketDuration;
    if(operations != null)            
            entry.operations += operations[i] * overlap / bucketDuration;
        } //End block
Entry varF26DBE38545460D6F6AE1D948FF53869_1861057595 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_1861057595.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_1861057595;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.211 -0400", hash_original_method = "AB86ED9AABA220FE0A64D0BEB0ADF734", hash_generated_method = "C759CF4F5C81EF216482A70435F845D6")
    @Deprecated
    public void generateRandom(long start, long end, long bytes) {
        addTaint(bytes);
        addTaint(end);
        addTaint(start);
        final Random r = new Random();
        final float fractionRx = r.nextFloat();
        final long rxBytes = (long) (bytes * fractionRx);
        final long txBytes = (long) (bytes * (1 - fractionRx));
        final long rxPackets = rxBytes / 1024;
        final long txPackets = txBytes / 1024;
        final long operations = rxBytes / 2048;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.212 -0400", hash_original_method = "2B4929E4FB42F9E11DEF8BA8131121D5", hash_generated_method = "BF2AA8D0235DAA532C10D8D84DEDBF18")
    @Deprecated
    public void generateRandom(long start, long end, long rxBytes, long rxPackets, long txBytes,
            long txPackets, long operations, Random r) {
        addTaint(end);
        addTaint(start);
        ensureBuckets(start, end);
        final NetworkStats.Entry entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        while
(rxBytes > 1024 || rxPackets > 128 || txBytes > 1024 || txPackets > 128
                || operations > 32)        
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static long randomLong(Random r, long start, long end) {
        return (long) (start + (r.nextFloat() * (end - start)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.212 -0400", hash_original_method = "9A3509822F71494F86F9AA38F61F7118", hash_generated_method = "11B50048BE383ACACC538454FA7654A3")
    public void dump(String prefix, PrintWriter pw, boolean fullHistory) {
        addTaint(fullHistory);
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        pw.print(prefix);
        pw.print("NetworkStatsHistory: bucketDuration=");
        pw.println(bucketDuration);
        final int start = fullHistory ? 0 : Math.max(0, bucketCount - 32);
    if(start > 0)        
        {
            pw.print(prefix);
            pw.print("  (omitting ");
            pw.print(start);
            pw.println(" buckets)");
        } //End block
for(int i = start;i < bucketCount;i++)
        {
            pw.print(prefix);
            pw.print("  bucketStart=");
            pw.print(bucketStart[i]);
    if(activeTime != null)            
            {
                pw.print(" activeTime=");
                pw.print(activeTime[i]);
            } //End block
    if(rxBytes != null)            
            {
                pw.print(" rxBytes=");
                pw.print(rxBytes[i]);
            } //End block
    if(rxPackets != null)            
            {
                pw.print(" rxPackets=");
                pw.print(rxPackets[i]);
            } //End block
    if(txBytes != null)            
            {
                pw.print(" txBytes=");
                pw.print(txBytes[i]);
            } //End block
    if(txPackets != null)            
            {
                pw.print(" txPackets=");
                pw.print(txPackets[i]);
            } //End block
    if(operations != null)            
            {
                pw.print(" operations=");
                pw.print(operations[i]);
            } //End block
            pw.println();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_method = "BC70BAB3B88F6C51172FD25602AB6B1A", hash_generated_method = "C3ADC5B56CAD220CBF9382871C785643")
    @Override
    public String toString() {
        final CharArrayWriter writer = new CharArrayWriter();
        dump("", new PrintWriter(writer), false);
String varEF986DCEFABA18330D92CD8C42EF636E_1564160533 =         writer.toString();
        varEF986DCEFABA18330D92CD8C42EF636E_1564160533.addTaint(taint);
        return varEF986DCEFABA18330D92CD8C42EF636E_1564160533;
        // ---------- Original Method ----------
        //final CharArrayWriter writer = new CharArrayWriter();
        //dump("", new PrintWriter(writer), false);
        //return writer.toString();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_field = "12D6496AFB9546FF78CE1A9D7D8F4BFC", hash_generated_field = "7C1BAD4742A4B22366B6D0FF5D8B7450")

        public long bucketDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_field = "FB4A06AB2BFDF0DA1206B27E9ECBA4D5", hash_generated_field = "1F3D020C44602964FFF2B3A5FE620FA4")

        public long bucketStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_field = "69A1B59160AD46B165263D22FA543821", hash_generated_field = "711F26C2ABCF9DB9AF8FD37E3598B0DD")

        public long activeTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "9910EB628EC91FE06D2639B0F3810F0E")

        public long rxBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "6ADCDCD12FD7D35118980BC0BB165142")

        public long rxPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "676F2C3D88E440A0E185A42A7F55CF74")

        public long txBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.213 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "B93ED690B1DA86F6CE26308A7104AEFF")

        public long txPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.214 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "49E564B98B6E0E4454081C4D76AD6B00")

        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.214 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
        public Entry ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.214 -0400", hash_original_field = "C6CA91666EC9B9D3DC554BA247E19FAD", hash_generated_field = "83092BBB72C91C04DD841B95A4680A5D")

        public static final long UNKNOWN = -1;
    }


    
    public static class DataStreamUtils {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.214 -0400", hash_original_method = "19FEB3F8DC1B5C5DFE6BAC6ABFB6225F", hash_generated_method = "19FEB3F8DC1B5C5DFE6BAC6ABFB6225F")
        public DataStreamUtils ()
        {
            //Synthesized constructor
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_method = "B81D28E36C3A9E7E89F9825844B173D9", hash_generated_method = "B81D28E36C3A9E7E89F9825844B173D9")
        public ParcelUtils ()
        {
            //Synthesized constructor
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_field = "71DB0559A739A1F04A9BB9065E47841B", hash_generated_field = "1ECA6D6E7F9A26B50E8896C3111CB80C")

    private static final int VERSION_INIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_field = "A8ED1BC0994298CA574C5ED20A331C07", hash_generated_field = "3CEE91C167DFC5FDE739B07D71FE2144")

    private static final int VERSION_ADD_PACKETS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_field = "4A2BB6F6CC4997DA38BD29BD37660C06", hash_generated_field = "480EA4EDB42382D1BD31224733D0AC9F")

    private static final int VERSION_ADD_ACTIVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_field = "E5C2F68D026E99EE8A4A5E78F4EFD96E", hash_generated_field = "B30C161561419447A145BC3806950DF6")

    public static final int FIELD_ACTIVE_TIME = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_field = "B93DD3A7D76961E415CB63BB9E0016BD", hash_generated_field = "B83AA8C9CBADCF8323FE156C6521F4F8")

    public static final int FIELD_RX_BYTES = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_field = "0656261A0A68FD17919E646766D43CB3", hash_generated_field = "B1A30D37D59A5939979CC4F381D13A2A")

    public static final int FIELD_RX_PACKETS = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.216 -0400", hash_original_field = "AA288ABEEBB96463DCB4D393D8EA43CC", hash_generated_field = "7307AE6481C1A7B49CCC878109302487")

    public static final int FIELD_TX_BYTES = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.217 -0400", hash_original_field = "8CD57B3A93D6B68853351D8BD3D06107", hash_generated_field = "8C11DB6B6D297F056A0D084A3E40A14A")

    public static final int FIELD_TX_PACKETS = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.217 -0400", hash_original_field = "E74E1D4EA23759F62C0E2D43FDA689DB", hash_generated_field = "9A1CC8FBB50D3CE2F1BB1A44BFD95E80")

    public static final int FIELD_OPERATIONS = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.217 -0400", hash_original_field = "0D4C44C436AF0A0B5BA65EB9D7761285", hash_generated_field = "CD0D0EE4410996E4C6C61BD9919399D7")

    public static final int FIELD_ALL = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.217 -0400", hash_original_field = "048BF4BBB96644622132F9F51E1DB96F", hash_generated_field = "D81F6106977C71918B1EF6EAB4131577")

    public static final Creator<NetworkStatsHistory> CREATOR = new Creator<NetworkStatsHistory>() {
        public NetworkStatsHistory createFromParcel(Parcel in) {
            return new NetworkStatsHistory(in);
        }

        public NetworkStatsHistory[] newArray(int size) {
            return new NetworkStatsHistory[size];
        }
    };
    // orphaned legacy method
    public NetworkStatsHistory createFromParcel(Parcel in) {
            return new NetworkStatsHistory(in);
        }
    
    // orphaned legacy method
    public NetworkStatsHistory[] newArray(int size) {
            return new NetworkStatsHistory[size];
        }
    
}

