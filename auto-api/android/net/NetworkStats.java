package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import static com.android.internal.util.Preconditions.checkNotNull;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import com.android.internal.util.Objects;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class NetworkStats implements Parcelable {
    private static final String TAG = "NetworkStats";
    public static final String IFACE_ALL = null;
    public static final int UID_ALL = -1;
    public static final int SET_ALL = -1;
    public static final int SET_DEFAULT = 0;
    public static final int SET_FOREGROUND = 1;
    public static final int TAG_NONE = 0;
    private final long elapsedRealtime;
    private int size;
    private String[] iface;
    private int[] uid;
    private int[] set;
    private int[] tag;
    private long[] rxBytes;
    private long[] rxPackets;
    private long[] txBytes;
    private long[] txPackets;
    private long[] operations;
    public static final Creator<NetworkStats> CREATOR = new Creator<NetworkStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.236 -0400", hash_original_method = "76D9386453B9839BC68D96B3471291B7", hash_generated_method = "787C1D430E777E703AA32AB7611F9230")
        @DSModeled(DSC.SAFE)
        public NetworkStats createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (NetworkStats)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkStats(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.236 -0400", hash_original_method = "6BCBF9A9B4039336956D31ACA3A9B0D4", hash_generated_method = "68DCF5C343C73FBF3F519F0EA9371457")
        @DSModeled(DSC.SAFE)
        public NetworkStats[] newArray(int size) {
            dsTaint.addTaint(size);
            return (NetworkStats[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkStats[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.237 -0400", hash_original_method = "2A398CA499F31285985E41F8490B2A34", hash_generated_method = "A1F7EC6951659EE1EED4D2AD45C582DB")
    @DSModeled(DSC.SAFE)
    public NetworkStats(long elapsedRealtime, int initialSize) {
        dsTaint.addTaint(elapsedRealtime);
        dsTaint.addTaint(initialSize);
        this.size = 0;
        this.iface = new String[initialSize];
        this.uid = new int[initialSize];
        this.set = new int[initialSize];
        this.tag = new int[initialSize];
        this.rxBytes = new long[initialSize];
        this.rxPackets = new long[initialSize];
        this.txBytes = new long[initialSize];
        this.txPackets = new long[initialSize];
        this.operations = new long[initialSize];
        // ---------- Original Method ----------
        //this.elapsedRealtime = elapsedRealtime;
        //this.size = 0;
        //this.iface = new String[initialSize];
        //this.uid = new int[initialSize];
        //this.set = new int[initialSize];
        //this.tag = new int[initialSize];
        //this.rxBytes = new long[initialSize];
        //this.rxPackets = new long[initialSize];
        //this.txBytes = new long[initialSize];
        //this.txPackets = new long[initialSize];
        //this.operations = new long[initialSize];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.237 -0400", hash_original_method = "D90F7AB3E4E138FF177FEBA052B61E8A", hash_generated_method = "CE9463B74535BA747A289624372BD3DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        elapsedRealtime = parcel.readLong();
        size = parcel.readInt();
        iface = parcel.createStringArray();
        uid = parcel.createIntArray();
        set = parcel.createIntArray();
        tag = parcel.createIntArray();
        rxBytes = parcel.createLongArray();
        rxPackets = parcel.createLongArray();
        txBytes = parcel.createLongArray();
        txPackets = parcel.createLongArray();
        operations = parcel.createLongArray();
        // ---------- Original Method ----------
        //elapsedRealtime = parcel.readLong();
        //size = parcel.readInt();
        //iface = parcel.createStringArray();
        //uid = parcel.createIntArray();
        //set = parcel.createIntArray();
        //tag = parcel.createIntArray();
        //rxBytes = parcel.createLongArray();
        //rxPackets = parcel.createLongArray();
        //txBytes = parcel.createLongArray();
        //txPackets = parcel.createLongArray();
        //operations = parcel.createLongArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.237 -0400", hash_original_method = "747F845D1C1DAB9F1E978429A723A0B0", hash_generated_method = "B57F7BE8D0E4F0887314ACCDA514E96F")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeLong(elapsedRealtime);
        dest.writeInt(size);
        dest.writeStringArray(iface);
        dest.writeIntArray(uid);
        dest.writeIntArray(set);
        dest.writeIntArray(tag);
        dest.writeLongArray(rxBytes);
        dest.writeLongArray(rxPackets);
        dest.writeLongArray(txBytes);
        dest.writeLongArray(txPackets);
        dest.writeLongArray(operations);
        // ---------- Original Method ----------
        //dest.writeLong(elapsedRealtime);
        //dest.writeInt(size);
        //dest.writeStringArray(iface);
        //dest.writeIntArray(uid);
        //dest.writeIntArray(set);
        //dest.writeIntArray(tag);
        //dest.writeLongArray(rxBytes);
        //dest.writeLongArray(rxPackets);
        //dest.writeLongArray(txBytes);
        //dest.writeLongArray(txPackets);
        //dest.writeLongArray(operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.237 -0400", hash_original_method = "2B258B3B735A82A55EB3270F9E3A7FB6", hash_generated_method = "F6352B5F7F36A30207BEF872483E94EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public NetworkStats clone() {
        final NetworkStats clone;
        clone = new NetworkStats(elapsedRealtime, size);
        NetworkStats.Entry entry;
        entry = null;
        {
            int i;
            i = 0;
            {
                entry = getValues(i, entry);
                clone.addValues(entry);
            } //End block
        } //End collapsed parenthetic
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final NetworkStats clone = new NetworkStats(elapsedRealtime, size);
        //NetworkStats.Entry entry = null;
        //for (int i = 0; i < size; i++) {
            //entry = getValues(i, entry);
            //clone.addValues(entry);
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.237 -0400", hash_original_method = "C4F6601144FE185F7636CD51AD058501", hash_generated_method = "D0929B1FDB1C6F07EF96EE733879765F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats addIfaceValues(
            String iface, long rxBytes, long rxPackets, long txBytes, long txPackets) {
        dsTaint.addTaint(iface);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats var3EFD197D64464EFFDBF459517CAEC880_1043034943 = (addValues(
                iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addValues(
                //iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.237 -0400", hash_original_method = "F572451A01AB0326B364A96213456AFC", hash_generated_method = "9702470D4358401973908EF1A398F6A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats addValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(set);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats varBE9F1EB301E86200CA8DFDB3D9682593_1956223551 = (addValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations)));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.238 -0400", hash_original_method = "BA5E7818DCBE1852CDC81090E5B13339", hash_generated_method = "720CA39698B4523A025CC29E14BB5297")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats addValues(Entry entry) {
        dsTaint.addTaint(entry.dsTaint);
        {
            final int newLength;
            newLength = Math.max(iface.length, 10) * 3 / 2;
            iface = Arrays.copyOf(iface, newLength);
            uid = Arrays.copyOf(uid, newLength);
            set = Arrays.copyOf(set, newLength);
            tag = Arrays.copyOf(tag, newLength);
            rxBytes = Arrays.copyOf(rxBytes, newLength);
            rxPackets = Arrays.copyOf(rxPackets, newLength);
            txBytes = Arrays.copyOf(txBytes, newLength);
            txPackets = Arrays.copyOf(txPackets, newLength);
            operations = Arrays.copyOf(operations, newLength);
        } //End block
        iface[size] = entry.iface;
        uid[size] = entry.uid;
        set[size] = entry.set;
        tag[size] = entry.tag;
        rxBytes[size] = entry.rxBytes;
        rxPackets[size] = entry.rxPackets;
        txBytes[size] = entry.txBytes;
        txPackets[size] = entry.txPackets;
        operations[size] = entry.operations;
        size++;
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.238 -0400", hash_original_method = "784A932AD4193748EF13A1422BBA3C89", hash_generated_method = "F15ECF12CFDB6A4CF7EF5C9C4005876D")
    @DSModeled(DSC.SAFE)
    public Entry getValues(int i, Entry recycle) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(i);
        final Entry entry;
        entry = recycle;
        entry = new Entry();
        entry.iface = iface[i];
        entry.uid = uid[i];
        entry.set = set[i];
        entry.tag = tag[i];
        entry.rxBytes = rxBytes[i];
        entry.rxPackets = rxPackets[i];
        entry.txBytes = txBytes[i];
        entry.txPackets = txPackets[i];
        entry.operations = operations[i];
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Entry entry = recycle != null ? recycle : new Entry();
        //entry.iface = iface[i];
        //entry.uid = uid[i];
        //entry.set = set[i];
        //entry.tag = tag[i];
        //entry.rxBytes = rxBytes[i];
        //entry.rxPackets = rxPackets[i];
        //entry.txBytes = txBytes[i];
        //entry.txPackets = txPackets[i];
        //entry.operations = operations[i];
        //return entry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.238 -0400", hash_original_method = "F3360ADB8E6D37C5AD6714A1DBEA3C2C", hash_generated_method = "D92AEDA1274C6E81C4E22C84E14B5FD4")
    @DSModeled(DSC.SAFE)
    public long getElapsedRealtime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.238 -0400", hash_original_method = "A28F8D44EDD8B5977D1B4B03F62008BC", hash_generated_method = "76194B86405F69428822BFE9E18FF3E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getElapsedRealtimeAge() {
        long var31F8EE92B793C7898ABD2D03A99BDBC1_194024701 = (SystemClock.elapsedRealtime() - elapsedRealtime);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.238 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "6E93BC927377E643FCF9C1E2F7D3D815")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.238 -0400", hash_original_method = "2B99B673BBD8E75B3053CAA25E99CAA5", hash_generated_method = "3B50C8F0F0326874BA3C0D7FF7824D45")
    @DSModeled(DSC.SAFE)
    public int internalSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return iface.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.239 -0400", hash_original_method = "60A49D4C2C28DC0F7F89BE32E32B8D66", hash_generated_method = "8AF5DCC43822CCA29C8B070E76900AB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public NetworkStats combineValues(String iface, int uid, int tag, long rxBytes, long rxPackets,
            long txBytes, long txPackets, long operations) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats varBEA10BEF18A033D3228BAC770D43D7F2_551767550 = (combineValues(
                iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return combineValues(
                //iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.239 -0400", hash_original_method = "F71B507E3E7A764789F38FD5530E9585", hash_generated_method = "FDA2D46165649BBBFE3B60069B60005F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats combineValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(set);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats var7E056802138AE06EBD194965821DF97B_1566777596 = (combineValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations)));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return combineValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.239 -0400", hash_original_method = "49582C07F79A6507E237CBEC2438E36C", hash_generated_method = "86C12293BA9901130A86ED284ABEF3D6")
    @DSModeled(DSC.SAFE)
    public NetworkStats combineValues(Entry entry) {
        dsTaint.addTaint(entry.dsTaint);
        final int i;
        i = findIndex(entry.iface, entry.uid, entry.set, entry.tag);
        {
            addValues(entry);
        } //End block
        {
            rxBytes[i] += entry.rxBytes;
            rxPackets[i] += entry.rxPackets;
            txBytes[i] += entry.txBytes;
            txPackets[i] += entry.txPackets;
            operations[i] += entry.operations;
        } //End block
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int i = findIndex(entry.iface, entry.uid, entry.set, entry.tag);
        //if (i == -1) {
            //addValues(entry);
        //} else {
            //rxBytes[i] += entry.rxBytes;
            //rxPackets[i] += entry.rxPackets;
            //txBytes[i] += entry.txBytes;
            //txPackets[i] += entry.txPackets;
            //operations[i] += entry.operations;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.239 -0400", hash_original_method = "0A31FFFE210F2775172111CD7E8C7EC0", hash_generated_method = "3854C84D2CCD3C9466D83FFE24D6258A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void combineAllValues(NetworkStats another) {
        dsTaint.addTaint(another.dsTaint);
        NetworkStats.Entry entry;
        entry = null;
        {
            int i;
            i = 0;
            {
                entry = another.getValues(i, entry);
                combineValues(entry);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //NetworkStats.Entry entry = null;
        //for (int i = 0; i < another.size; i++) {
            //entry = another.getValues(i, entry);
            //combineValues(entry);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.240 -0400", hash_original_method = "FEC91070502C1195B6460B4D97DFCE73", hash_generated_method = "A5A8EAF86B0C1B7C625FDD2D1F0D1649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findIndex(String iface, int uid, int set, int tag) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(set);
        dsTaint.addTaint(tag);
        {
            int i;
            i = 0;
            {
                {
                    boolean var7F51CCC0D3B646294AFFFFFDFF3BBE72_1272986889 = (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (int i = 0; i < size; i++) {
            //if (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    //&& Objects.equal(iface, this.iface[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.240 -0400", hash_original_method = "09F077C80C4F986B6C39E3E7ABC587EB", hash_generated_method = "B8946989BC1E3151D2821381309DCAC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findIndexHinted(String iface, int uid, int set, int tag, int hintIndex) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(hintIndex);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(set);
        dsTaint.addTaint(tag);
        {
            int offset;
            offset = 0;
            {
                final int halfOffset;
                halfOffset = offset / 2;
                final int i;
                {
                    i = (hintIndex + halfOffset) % size;
                } //End block
                {
                    i = (size + hintIndex - halfOffset - 1) % size;
                } //End block
                {
                    boolean var7F51CCC0D3B646294AFFFFFDFF3BBE72_272558124 = (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (int offset = 0; offset < size; offset++) {
            //final int halfOffset = offset / 2;
            //final int i;
            //if (offset % 2 == 0) {
                //i = (hintIndex + halfOffset) % size;
            //} else {
                //i = (size + hintIndex - halfOffset - 1) % size;
            //}
            //if (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    //&& Objects.equal(iface, this.iface[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.240 -0400", hash_original_method = "6E339B821B6FB4996B911B569AAD524F", hash_generated_method = "12D1CB0006331A1463598F68E63EED61")
    @DSModeled(DSC.SAFE)
    public void spliceOperationsFrom(NetworkStats stats) {
        dsTaint.addTaint(stats.dsTaint);
        {
            int i;
            i = 0;
            {
                final int j;
                j = stats.findIndex(IFACE_ALL, uid[i], set[i], tag[i]);
                {
                    operations[i] = 0;
                } //End block
                {
                    operations[i] = stats.operations[j];
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < size; i++) {
            //final int j = stats.findIndex(IFACE_ALL, uid[i], set[i], tag[i]);
            //if (j == -1) {
                //operations[i] = 0;
            //} else {
                //operations[i] = stats.operations[j];
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.240 -0400", hash_original_method = "2B2C9B0B02A7A72C63A74815DF58D4A4", hash_generated_method = "EFF1ADED8D6D64FA712DFD767940E59C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getUniqueIfaces() {
        final HashSet<String> ifaces;
        ifaces = new HashSet<String>();
        {
            Iterator<String> seatecAstronomy42 = this.iface.iterator();
            seatecAstronomy42.hasNext();
            String iface = seatecAstronomy42.next();
            {
                {
                    ifaces.add(iface);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String[] var81656A977762B8BECBF38C8836EEE497_85506687 = (ifaces.toArray(new String[ifaces.size()]));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //final HashSet<String> ifaces = new HashSet<String>();
        //for (String iface : this.iface) {
            //if (iface != IFACE_ALL) {
                //ifaces.add(iface);
            //}
        //}
        //return ifaces.toArray(new String[ifaces.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.240 -0400", hash_original_method = "C948A3950E5BB6DBF87B62BBDA0B02C8", hash_generated_method = "DAC549274321D90A4DC09CF3C311A586")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getUniqueUids() {
        final SparseBooleanArray uids;
        uids = new SparseBooleanArray();
        {
            Iterator<int> seatecAstronomy42 = this.uid.iterator();
            seatecAstronomy42.hasNext();
            int uid = seatecAstronomy42.next();
            {
                uids.put(uid, true);
            } //End block
        } //End collapsed parenthetic
        final int size;
        size = uids.size();
        final int[] result;
        result = new int[size];
        {
            int i;
            i = 0;
            {
                result[i] = uids.keyAt(i);
            } //End block
        } //End collapsed parenthetic
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //final SparseBooleanArray uids = new SparseBooleanArray();
        //for (int uid : this.uid) {
            //uids.put(uid, true);
        //}
        //final int size = uids.size();
        //final int[] result = new int[size];
        //for (int i = 0; i < size; i++) {
            //result[i] = uids.keyAt(i);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.241 -0400", hash_original_method = "277B11F09A23B8E4B361A93BBF3584B2", hash_generated_method = "8022FE83CCF67675286836A785816D3C")
    @DSModeled(DSC.SAFE)
    public long getTotalBytes() {
        final Entry entry;
        entry = getTotal(null);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //final Entry entry = getTotal(null);
        //return entry.rxBytes + entry.txBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.241 -0400", hash_original_method = "4A2B09728CEDE32F9C68EF92F6D5889E", hash_generated_method = "706ED19E5E25D8A4008D1E4C701AAD6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getTotal(Entry recycle) {
        dsTaint.addTaint(recycle.dsTaint);
        Entry var29CC8E7070732766F57BADC5354BA482_1601636148 = (getTotal(recycle, null, UID_ALL));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTotal(recycle, null, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.241 -0400", hash_original_method = "D5D19E4CD939B7A0BD1C3BDE2A399415", hash_generated_method = "1EC8F7E5F47F21D09026CC3E054192AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getTotal(Entry recycle, int limitUid) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(limitUid);
        Entry var75C6295DC4159218CFFE3D014C083D57_321812790 = (getTotal(recycle, null, limitUid));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTotal(recycle, null, limitUid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.241 -0400", hash_original_method = "A8C67127F98A8F27D6DD2D10C54926B1", hash_generated_method = "A30E3057CB9F46181FF8B9367FEFD3DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getTotal(Entry recycle, HashSet<String> limitIface) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(limitIface.dsTaint);
        Entry var479BBAB7AEAFDE16463794E65A7E49B9_1740236580 = (getTotal(recycle, limitIface, UID_ALL));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTotal(recycle, limitIface, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.241 -0400", hash_original_method = "7B779B0B251D8F12031ECAB7F83EFE1D", hash_generated_method = "A958D6799ABCF67CD101A970BECF86D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Entry getTotal(Entry recycle, HashSet<String> limitIface, int limitUid) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(limitIface.dsTaint);
        dsTaint.addTaint(limitUid);
        final Entry entry;
        entry = recycle;
        entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.uid = limitUid;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;
        entry.rxBytes = 0;
        entry.rxPackets = 0;
        entry.txBytes = 0;
        entry.txPackets = 0;
        entry.operations = 0;
        {
            int i;
            i = 0;
            {
                final boolean matchesUid;
                matchesUid = (limitUid == UID_ALL) || (limitUid == uid[i]);
                final boolean matchesIface;
                matchesIface = (limitIface == null) || (limitIface.contains(iface[i]));
                {
                    entry.rxBytes += rxBytes[i];
                    entry.rxPackets += rxPackets[i];
                    entry.txBytes += txBytes[i];
                    entry.txPackets += txPackets[i];
                    entry.operations += operations[i];
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.241 -0400", hash_original_method = "0B77BD3659EBAD0CA6247F62089B29FF", hash_generated_method = "AB5FAED3694038CDB73B88407E3502A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats subtract(NetworkStats value) throws NonMonotonicException {
        dsTaint.addTaint(value.dsTaint);
        NetworkStats varF1DD39D1F0E3162E5DD65714BB79F833_2021885089 = (subtract(value, false));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return subtract(value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.242 -0400", hash_original_method = "04678C1B7F1434E233D6434823B40504", hash_generated_method = "8A7D2A7750C548B2630430F0DE1B201C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats subtract(NetworkStats value, boolean clampNonMonotonic) throws NonMonotonicException {
        dsTaint.addTaint(clampNonMonotonic);
        dsTaint.addTaint(value.dsTaint);
        final long deltaRealtime;
        deltaRealtime = this.elapsedRealtime - value.elapsedRealtime;
        {
            throw new NonMonotonicException(this, value);
        } //End block
        final Entry entry;
        entry = new Entry();
        final NetworkStats result;
        result = new NetworkStats(deltaRealtime, size);
        {
            int i;
            i = 0;
            {
                entry.iface = iface[i];
                entry.uid = uid[i];
                entry.set = set[i];
                entry.tag = tag[i];
                final int j;
                j = value.findIndexHinted(entry.iface, entry.uid, entry.set, entry.tag, i);
                {
                    entry.rxBytes = rxBytes[i];
                    entry.rxPackets = rxPackets[i];
                    entry.txBytes = txBytes[i];
                    entry.txPackets = txPackets[i];
                    entry.operations = operations[i];
                } //End block
                {
                    entry.rxBytes = rxBytes[i] - value.rxBytes[j];
                    entry.rxPackets = rxPackets[i] - value.rxPackets[j];
                    entry.txBytes = txBytes[i] - value.txBytes[j];
                    entry.txPackets = txPackets[i] - value.txPackets[j];
                    entry.operations = operations[i] - value.operations[j];
                    {
                        {
                            entry.rxBytes = Math.max(entry.rxBytes, 0);
                            entry.rxPackets = Math.max(entry.rxPackets, 0);
                            entry.txBytes = Math.max(entry.txBytes, 0);
                            entry.txPackets = Math.max(entry.txPackets, 0);
                            entry.operations = Math.max(entry.operations, 0);
                        } //End block
                        {
                            throw new NonMonotonicException(this, i, value, j);
                        } //End block
                    } //End block
                } //End block
                result.addValues(entry);
            } //End block
        } //End collapsed parenthetic
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.242 -0400", hash_original_method = "AB3FDA05B945C3AC93E7C4BBCBA41D8F", hash_generated_method = "704039C7B70DC44C55A5A022840D8868")
    @DSModeled(DSC.SAFE)
    public NetworkStats groupedByIface() {
        final NetworkStats stats;
        stats = new NetworkStats(elapsedRealtime, 10);
        final Entry entry;
        entry = new Entry();
        entry.uid = UID_ALL;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;
        entry.operations = 0L;
        {
            int i;
            i = 0;
            {
                entry.iface = iface[i];
                entry.rxBytes = rxBytes[i];
                entry.rxPackets = rxPackets[i];
                entry.txBytes = txBytes[i];
                entry.txPackets = txPackets[i];
                stats.combineValues(entry);
            } //End block
        } //End collapsed parenthetic
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);
        //final Entry entry = new Entry();
        //entry.uid = UID_ALL;
        //entry.set = SET_ALL;
        //entry.tag = TAG_NONE;
        //entry.operations = 0L;
        //for (int i = 0; i < size; i++) {
            //if (tag[i] != TAG_NONE) continue;
            //entry.iface = iface[i];
            //entry.rxBytes = rxBytes[i];
            //entry.rxPackets = rxPackets[i];
            //entry.txBytes = txBytes[i];
            //entry.txPackets = txPackets[i];
            //stats.combineValues(entry);
        //}
        //return stats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.243 -0400", hash_original_method = "F7B5ADC030AABE070FE0AF3D1DEEC4FF", hash_generated_method = "E9EBE6E16EA509E01B7F4DD665347F12")
    @DSModeled(DSC.SAFE)
    public NetworkStats groupedByUid() {
        final NetworkStats stats;
        stats = new NetworkStats(elapsedRealtime, 10);
        final Entry entry;
        entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;
        {
            int i;
            i = 0;
            {
                entry.uid = uid[i];
                entry.rxBytes = rxBytes[i];
                entry.rxPackets = rxPackets[i];
                entry.txBytes = txBytes[i];
                entry.txPackets = txPackets[i];
                entry.operations = operations[i];
                stats.combineValues(entry);
            } //End block
        } //End collapsed parenthetic
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);
        //final Entry entry = new Entry();
        //entry.iface = IFACE_ALL;
        //entry.set = SET_ALL;
        //entry.tag = TAG_NONE;
        //for (int i = 0; i < size; i++) {
            //if (tag[i] != TAG_NONE) continue;
            //entry.uid = uid[i];
            //entry.rxBytes = rxBytes[i];
            //entry.rxPackets = rxPackets[i];
            //entry.txBytes = txBytes[i];
            //entry.txPackets = txPackets[i];
            //entry.operations = operations[i];
            //stats.combineValues(entry);
        //}
        //return stats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.243 -0400", hash_original_method = "9245ED01B44F4BC6EDE26C84298E681C", hash_generated_method = "E556665570AFD660DBEFA2D593C8EE95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats withoutUid(int uid) {
        dsTaint.addTaint(uid);
        final NetworkStats stats;
        stats = new NetworkStats(elapsedRealtime, 10);
        Entry entry;
        entry = new Entry();
        {
            int i;
            i = 0;
            {
                entry = getValues(i, entry);
                {
                    stats.addValues(entry);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);
        //Entry entry = new Entry();
        //for (int i = 0; i < size; i++) {
            //entry = getValues(i, entry);
            //if (entry.uid != uid) {
                //stats.addValues(entry);
            //}
        //}
        //return stats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.243 -0400", hash_original_method = "130412F853181F3DE6D8909F69FBB580", hash_generated_method = "85CC86048FBD442CEEABDED6B99ABD9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(String prefix, PrintWriter pw) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        pw.print(prefix);
        pw.print("NetworkStats: elapsedRealtime=");
        pw.println(elapsedRealtime);
        {
            int i;
            i = 0;
            {
                pw.print(prefix);
                pw.print("  [");
                pw.print(i);
                pw.print("]");
                pw.print(" iface=");
                pw.print(iface[i]);
                pw.print(" uid=");
                pw.print(uid[i]);
                pw.print(" set=");
                pw.print(setToString(set[i]));
                pw.print(" tag=");
                pw.print(tagToString(tag[i]));
                pw.print(" rxBytes=");
                pw.print(rxBytes[i]);
                pw.print(" rxPackets=");
                pw.print(rxPackets[i]);
                pw.print(" txBytes=");
                pw.print(txBytes[i]);
                pw.print(" txPackets=");
                pw.print(txPackets[i]);
                pw.print(" operations=");
                pw.println(operations[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //pw.print(prefix);
        //pw.print("NetworkStats: elapsedRealtime=");
        //pw.println(elapsedRealtime);
        //for (int i = 0; i < size; i++) {
            //pw.print(prefix);
            //pw.print("  ["); pw.print(i); pw.print("]");
            //pw.print(" iface="); pw.print(iface[i]);
            //pw.print(" uid="); pw.print(uid[i]);
            //pw.print(" set="); pw.print(setToString(set[i]));
            //pw.print(" tag="); pw.print(tagToString(tag[i]));
            //pw.print(" rxBytes="); pw.print(rxBytes[i]);
            //pw.print(" rxPackets="); pw.print(rxPackets[i]);
            //pw.print(" txBytes="); pw.print(txBytes[i]);
            //pw.print(" txPackets="); pw.print(txPackets[i]);
            //pw.print(" operations="); pw.println(operations[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.243 -0400", hash_original_method = "B2A79BC64162852AEFB2830FF939E603", hash_generated_method = "908C849D83A79606917F659C7F78B7EE")
    public static String setToString(int set) {
        switch (set) {
            case SET_ALL:
                return "ALL";
            case SET_DEFAULT:
                return "DEFAULT";
            case SET_FOREGROUND:
                return "FOREGROUND";
            default:
                return "UNKNOWN";
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.243 -0400", hash_original_method = "DC4BF8E8A8AEC1891BB1B278A71C59F9", hash_generated_method = "6354A0C3623620729DF5D191D7AF20FC")
    public static String tagToString(int tag) {
        return "0x" + Integer.toHexString(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.244 -0400", hash_original_method = "C185C780AB6AF420802BBBCB2A0DA03E", hash_generated_method = "218DA0C0468B64A8CE61B017CACFE59F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        final CharArrayWriter writer;
        writer = new CharArrayWriter();
        dump("", new PrintWriter(writer));
        String var06A4604668A7B483F2A3D13B0FB7EF06_1534910134 = (writer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final CharArrayWriter writer = new CharArrayWriter();
        //dump("", new PrintWriter(writer));
        //return writer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.244 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Entry {
        public String iface;
        public int uid;
        public int set;
        public int tag;
        public long rxBytes;
        public long rxPackets;
        public long txBytes;
        public long txPackets;
        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.244 -0400", hash_original_method = "CF147DC846E9FA9CFBACF54E998579AF", hash_generated_method = "23F8B432FD91591A3950E94CD85ED0F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry() {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.244 -0400", hash_original_method = "E97E61BD38788E206E16E3AF28EF9986", hash_generated_method = "B41742851E3AB3B14BBC7B5C0FA590FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(long rxBytes, long rxPackets, long txBytes, long txPackets, long operations) {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets,
                    operations);
            dsTaint.addTaint(txPackets);
            dsTaint.addTaint(txBytes);
            dsTaint.addTaint(operations);
            dsTaint.addTaint(rxBytes);
            dsTaint.addTaint(rxPackets);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.244 -0400", hash_original_method = "08CED58FDA8ADE41E7B2EE03A16F55F8", hash_generated_method = "3C6C6202A0777B6E1E068D8AA301AF77")
        @DSModeled(DSC.SAFE)
        public Entry(String iface, int uid, int set, int tag, long rxBytes, long rxPackets,
                long txBytes, long txPackets, long operations) {
            dsTaint.addTaint(uid);
            dsTaint.addTaint(iface);
            dsTaint.addTaint(set);
            dsTaint.addTaint(tag);
            dsTaint.addTaint(txPackets);
            dsTaint.addTaint(txBytes);
            dsTaint.addTaint(operations);
            dsTaint.addTaint(rxBytes);
            dsTaint.addTaint(rxPackets);
            // ---------- Original Method ----------
            //this.iface = iface;
            //this.uid = uid;
            //this.set = set;
            //this.tag = tag;
            //this.rxBytes = rxBytes;
            //this.rxPackets = rxPackets;
            //this.txBytes = txBytes;
            //this.txPackets = txPackets;
            //this.operations = operations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.244 -0400", hash_original_method = "8BA58A1912534045F7A50ACBC1B00F2F", hash_generated_method = "709FE4C42832BF0D1538C86F14129774")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            final StringBuilder builder;
            builder = new StringBuilder();
            builder.append("iface=").append(iface);
            builder.append(" uid=").append(uid);
            builder.append(" set=").append(setToString(set));
            builder.append(" tag=").append(tagToString(tag));
            builder.append(" rxBytes=").append(rxBytes);
            builder.append(" rxPackets=").append(rxPackets);
            builder.append(" txBytes=").append(txBytes);
            builder.append(" txPackets=").append(txPackets);
            builder.append(" operations=").append(operations);
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_912067979 = (builder.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //final StringBuilder builder = new StringBuilder();
            //builder.append("iface=").append(iface);
            //builder.append(" uid=").append(uid);
            //builder.append(" set=").append(setToString(set));
            //builder.append(" tag=").append(tagToString(tag));
            //builder.append(" rxBytes=").append(rxBytes);
            //builder.append(" rxPackets=").append(rxPackets);
            //builder.append(" txBytes=").append(txBytes);
            //builder.append(" txPackets=").append(txPackets);
            //builder.append(" operations=").append(operations);
            //return builder.toString();
        }

        
    }


    
    public static class NonMonotonicException extends Exception {
        public final NetworkStats left;
        public final NetworkStats right;
        public final int leftIndex;
        public final int rightIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.244 -0400", hash_original_method = "0F470ECE148C3E2C73ACB1D4F54D342F", hash_generated_method = "907FB554576052C68A69A637A1F8AA76")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NonMonotonicException(NetworkStats left, NetworkStats right) {
            this(left, -1, right, -1);
            dsTaint.addTaint(left.dsTaint);
            dsTaint.addTaint(right.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.245 -0400", hash_original_method = "F441B58E88456542B2E0F8A35978B48D", hash_generated_method = "A3C477721651FB6AA7E481EEFB5A61F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NonMonotonicException(
                NetworkStats left, int leftIndex, NetworkStats right, int rightIndex) {
            dsTaint.addTaint(leftIndex);
            dsTaint.addTaint(left.dsTaint);
            dsTaint.addTaint(rightIndex);
            dsTaint.addTaint(right.dsTaint);
            this.left = checkNotNull(left, "missing left");
            this.right = checkNotNull(right, "missing right");
            // ---------- Original Method ----------
            //this.left = checkNotNull(left, "missing left");
            //this.right = checkNotNull(right, "missing right");
            //this.leftIndex = leftIndex;
            //this.rightIndex = rightIndex;
        }

        
    }


    
}


