package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private long elapsedRealtime;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.206 -0400", hash_original_method = "2A398CA499F31285985E41F8490B2A34", hash_generated_method = "FECE079066817EB596A37F771289809E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.207 -0400", hash_original_method = "D90F7AB3E4E138FF177FEBA052B61E8A", hash_generated_method = "E4525CF947EF52A2EE4179A1852F9B4A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.207 -0400", hash_original_method = "747F845D1C1DAB9F1E978429A723A0B0", hash_generated_method = "C1D9A2A428F14C90C94E3ECD4FC8F5EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.207 -0400", hash_original_method = "2B258B3B735A82A55EB3270F9E3A7FB6", hash_generated_method = "E247FA5E250EEABEB6E72CFA358E3C59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public NetworkStats clone() {
        NetworkStats clone;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.208 -0400", hash_original_method = "C4F6601144FE185F7636CD51AD058501", hash_generated_method = "3E6F321543D849478C65CB69B0D699CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats addIfaceValues(
            String iface, long rxBytes, long rxPackets, long txBytes, long txPackets) {
        dsTaint.addTaint(iface);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats var3EFD197D64464EFFDBF459517CAEC880_1695084568 = (addValues(
                iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addValues(
                //iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.208 -0400", hash_original_method = "F572451A01AB0326B364A96213456AFC", hash_generated_method = "3132853076C87B908F1544D1745AF2BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats addValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(set);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats varBE9F1EB301E86200CA8DFDB3D9682593_1678774789 = (addValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations)));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return addValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.208 -0400", hash_original_method = "BA5E7818DCBE1852CDC81090E5B13339", hash_generated_method = "45A82692F3E3B48B60A01E8E8F1617DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats addValues(Entry entry) {
        dsTaint.addTaint(entry.dsTaint);
        {
            int newLength;
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
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.209 -0400", hash_original_method = "784A932AD4193748EF13A1422BBA3C89", hash_generated_method = "24C3E0CAF3F9CCD4C6BA13F2F97C3F20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getValues(int i, Entry recycle) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(i);
        Entry entry;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.209 -0400", hash_original_method = "F3360ADB8E6D37C5AD6714A1DBEA3C2C", hash_generated_method = "E5479F5CB8387EFCB1476F328C13B7E8")
    @DSModeled(DSC.SAFE)
    public long getElapsedRealtime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.209 -0400", hash_original_method = "A28F8D44EDD8B5977D1B4B03F62008BC", hash_generated_method = "F957EBF8D35D8701BCB41A6677C00DCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getElapsedRealtimeAge() {
        long var31F8EE92B793C7898ABD2D03A99BDBC1_1915932048 = (SystemClock.elapsedRealtime() - elapsedRealtime);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.210 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.210 -0400", hash_original_method = "2B99B673BBD8E75B3053CAA25E99CAA5", hash_generated_method = "962AC026DC0E12FF6A2922D19D6D26ED")
    @DSModeled(DSC.SAFE)
    public int internalSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return iface.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.210 -0400", hash_original_method = "60A49D4C2C28DC0F7F89BE32E32B8D66", hash_generated_method = "92E0E82A8E60077CEBBA3F342DBC4AB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public NetworkStats combineValues(String iface, int uid, int tag, long rxBytes, long rxPackets,
            long txBytes, long txPackets, long operations) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats varBEA10BEF18A033D3228BAC770D43D7F2_696690526 = (combineValues(
                iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return combineValues(
                //iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.211 -0400", hash_original_method = "F71B507E3E7A764789F38FD5530E9585", hash_generated_method = "BDD5C4CD2D1A6CC82BA6059872820BBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats combineValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(set);
        dsTaint.addTaint(txPackets);
        dsTaint.addTaint(operations);
        dsTaint.addTaint(txBytes);
        dsTaint.addTaint(rxBytes);
        dsTaint.addTaint(rxPackets);
        NetworkStats var7E056802138AE06EBD194965821DF97B_990133032 = (combineValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations)));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return combineValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.211 -0400", hash_original_method = "49582C07F79A6507E237CBEC2438E36C", hash_generated_method = "E07DC8EEE3B0BD719D5FC7A9F8A1AC32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats combineValues(Entry entry) {
        dsTaint.addTaint(entry.dsTaint);
        int i;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.211 -0400", hash_original_method = "0A31FFFE210F2775172111CD7E8C7EC0", hash_generated_method = "3D47E761BEE9E58E4CE1D01F8F4650C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.212 -0400", hash_original_method = "FEC91070502C1195B6460B4D97DFCE73", hash_generated_method = "2FF356FF546EE11FE3C41DD9215D94CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findIndex(String iface, int uid, int set, int tag) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(set);
        {
            int i;
            i = 0;
            {
                {
                    boolean var7F51CCC0D3B646294AFFFFFDFF3BBE72_1145098732 = (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.212 -0400", hash_original_method = "09F077C80C4F986B6C39E3E7ABC587EB", hash_generated_method = "A8F8368173818821FDEEFEE747FC18EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int findIndexHinted(String iface, int uid, int set, int tag, int hintIndex) {
        dsTaint.addTaint(hintIndex);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(iface);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(set);
        {
            int offset;
            offset = 0;
            {
                int halfOffset;
                halfOffset = offset / 2;
                int i;
                {
                    i = (hintIndex + halfOffset) % size;
                } //End block
                {
                    i = (size + hintIndex - halfOffset - 1) % size;
                } //End block
                {
                    boolean var7F51CCC0D3B646294AFFFFFDFF3BBE72_1034853515 = (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.212 -0400", hash_original_method = "6E339B821B6FB4996B911B569AAD524F", hash_generated_method = "A85E4033757BD6DEE5CB64AF11CBADA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void spliceOperationsFrom(NetworkStats stats) {
        dsTaint.addTaint(stats.dsTaint);
        {
            int i;
            i = 0;
            {
                int j;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.219 -0400", hash_original_method = "2B2C9B0B02A7A72C63A74815DF58D4A4", hash_generated_method = "A61C2801BFE0380B3875AA206CA0684E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getUniqueIfaces() {
        HashSet<String> ifaces;
        ifaces = new HashSet<String>();
        {
            String iface = this.iface[0];
            {
                {
                    ifaces.add(iface);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String[] var81656A977762B8BECBF38C8836EEE497_1425625342 = (ifaces.toArray(new String[ifaces.size()]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.226 -0400", hash_original_method = "C948A3950E5BB6DBF87B62BBDA0B02C8", hash_generated_method = "AE7DD1A1FD4F15E7E84374C773BF5CA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getUniqueUids() {
        SparseBooleanArray uids;
        uids = new SparseBooleanArray();
        {
            int uid = this.uid[0];
            {
                uids.put(uid, true);
            } //End block
        } //End collapsed parenthetic
        int size;
        size = uids.size();
        int[] result;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.227 -0400", hash_original_method = "277B11F09A23B8E4B361A93BBF3584B2", hash_generated_method = "779F5D4E0706C549872693504D4E39D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTotalBytes() {
        Entry entry;
        entry = getTotal(null);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //final Entry entry = getTotal(null);
        //return entry.rxBytes + entry.txBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.227 -0400", hash_original_method = "4A2B09728CEDE32F9C68EF92F6D5889E", hash_generated_method = "C942894C73BF89F717420D9794A55544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getTotal(Entry recycle) {
        dsTaint.addTaint(recycle.dsTaint);
        Entry var29CC8E7070732766F57BADC5354BA482_1530675114 = (getTotal(recycle, null, UID_ALL));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTotal(recycle, null, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.227 -0400", hash_original_method = "D5D19E4CD939B7A0BD1C3BDE2A399415", hash_generated_method = "E413519C74F30354345577674822C20E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getTotal(Entry recycle, int limitUid) {
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(limitUid);
        Entry var75C6295DC4159218CFFE3D014C083D57_353135797 = (getTotal(recycle, null, limitUid));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTotal(recycle, null, limitUid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.227 -0400", hash_original_method = "A8C67127F98A8F27D6DD2D10C54926B1", hash_generated_method = "DFE67ACF865C0F593850913B2AAA6D9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entry getTotal(Entry recycle, HashSet<String> limitIface) {
        dsTaint.addTaint(limitIface.dsTaint);
        dsTaint.addTaint(recycle.dsTaint);
        Entry var479BBAB7AEAFDE16463794E65A7E49B9_524940545 = (getTotal(recycle, limitIface, UID_ALL));
        return (Entry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTotal(recycle, limitIface, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.228 -0400", hash_original_method = "7B779B0B251D8F12031ECAB7F83EFE1D", hash_generated_method = "559B5D689911E1F951975106D9354921")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Entry getTotal(Entry recycle, HashSet<String> limitIface, int limitUid) {
        dsTaint.addTaint(limitIface.dsTaint);
        dsTaint.addTaint(recycle.dsTaint);
        dsTaint.addTaint(limitUid);
        Entry entry;
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
                boolean matchesUid;
                matchesUid = (limitUid == UID_ALL) || (limitUid == uid[i]);
                boolean matchesIface;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.228 -0400", hash_original_method = "0B77BD3659EBAD0CA6247F62089B29FF", hash_generated_method = "A80125DB491CC7CCDE2881FB6E85C5FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats subtract(NetworkStats value) throws NonMonotonicException {
        dsTaint.addTaint(value.dsTaint);
        NetworkStats varF1DD39D1F0E3162E5DD65714BB79F833_260460771 = (subtract(value, false));
        return (NetworkStats)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return subtract(value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.229 -0400", hash_original_method = "04678C1B7F1434E233D6434823B40504", hash_generated_method = "4EA1DE1C360BA1556136A7D0C4AD4358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats subtract(NetworkStats value, boolean clampNonMonotonic) throws NonMonotonicException {
        dsTaint.addTaint(clampNonMonotonic);
        dsTaint.addTaint(value.dsTaint);
        long deltaRealtime;
        deltaRealtime = this.elapsedRealtime - value.elapsedRealtime;
        {
            if (DroidSafeAndroidRuntime.control) throw new NonMonotonicException(this, value);
        } //End block
        Entry entry;
        entry = new Entry();
        NetworkStats result;
        result = new NetworkStats(deltaRealtime, size);
        {
            int i;
            i = 0;
            {
                entry.iface = iface[i];
                entry.uid = uid[i];
                entry.set = set[i];
                entry.tag = tag[i];
                int j;
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
                            if (DroidSafeAndroidRuntime.control) throw new NonMonotonicException(this, i, value, j);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.230 -0400", hash_original_method = "AB3FDA05B945C3AC93E7C4BBCBA41D8F", hash_generated_method = "8B7889FDC9B847FC9EE73286FD3D0FDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats groupedByIface() {
        NetworkStats stats;
        stats = new NetworkStats(elapsedRealtime, 10);
        Entry entry;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.231 -0400", hash_original_method = "F7B5ADC030AABE070FE0AF3D1DEEC4FF", hash_generated_method = "8EBFE1BBCDB1392169B424E608384DDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats groupedByUid() {
        NetworkStats stats;
        stats = new NetworkStats(elapsedRealtime, 10);
        Entry entry;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.231 -0400", hash_original_method = "9245ED01B44F4BC6EDE26C84298E681C", hash_generated_method = "B22A4934BC68C1F7A5E94709716B3528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkStats withoutUid(int uid) {
        dsTaint.addTaint(uid);
        NetworkStats stats;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.232 -0400", hash_original_method = "130412F853181F3DE6D8909F69FBB580", hash_generated_method = "03F5AEE9F19158EE304BA2B23DC95421")
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

    
        public static String tagToString(int tag) {
        return "0x" + Integer.toHexString(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.232 -0400", hash_original_method = "C185C780AB6AF420802BBBCB2A0DA03E", hash_generated_method = "6166709F08BC2495859F049D42821549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        CharArrayWriter writer;
        writer = new CharArrayWriter();
        dump("", new PrintWriter(writer));
        String var06A4604668A7B483F2A3D13B0FB7EF06_483364645 = (writer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final CharArrayWriter writer = new CharArrayWriter();
        //dump("", new PrintWriter(writer));
        //return writer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.234 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.234 -0400", hash_original_method = "CF147DC846E9FA9CFBACF54E998579AF", hash_generated_method = "F7D90DFA18CB5A7447228376F168D3F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry() {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.234 -0400", hash_original_method = "E97E61BD38788E206E16E3AF28EF9986", hash_generated_method = "97384010DB7787278A466CE012DE6F95")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Entry(long rxBytes, long rxPackets, long txBytes, long txPackets, long operations) {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets,
                    operations);
            dsTaint.addTaint(txPackets);
            dsTaint.addTaint(operations);
            dsTaint.addTaint(txBytes);
            dsTaint.addTaint(rxBytes);
            dsTaint.addTaint(rxPackets);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.234 -0400", hash_original_method = "08CED58FDA8ADE41E7B2EE03A16F55F8", hash_generated_method = "D15344C0127FE256AA20F6C9D0D5BB4A")
        @DSModeled(DSC.SAFE)
        public Entry(String iface, int uid, int set, int tag, long rxBytes, long rxPackets,
                long txBytes, long txPackets, long operations) {
            dsTaint.addTaint(uid);
            dsTaint.addTaint(iface);
            dsTaint.addTaint(tag);
            dsTaint.addTaint(set);
            dsTaint.addTaint(txPackets);
            dsTaint.addTaint(operations);
            dsTaint.addTaint(txBytes);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.235 -0400", hash_original_method = "8BA58A1912534045F7A50ACBC1B00F2F", hash_generated_method = "CFC36076E74D9813DA1A676023D8B16F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder builder;
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
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_2000252605 = (builder.toString());
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
        public NetworkStats left;
        public NetworkStats right;
        public int leftIndex;
        public int rightIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.235 -0400", hash_original_method = "0F470ECE148C3E2C73ACB1D4F54D342F", hash_generated_method = "B4E8BFA879523FE97A722B51620FFA0A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NonMonotonicException(NetworkStats left, NetworkStats right) {
            this(left, -1, right, -1);
            dsTaint.addTaint(left.dsTaint);
            dsTaint.addTaint(right.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.235 -0400", hash_original_method = "F441B58E88456542B2E0F8A35978B48D", hash_generated_method = "A2E4DE281A516F676AEBF9B42F0BA5DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NonMonotonicException(
                NetworkStats left, int leftIndex, NetworkStats right, int rightIndex) {
            dsTaint.addTaint(leftIndex);
            dsTaint.addTaint(rightIndex);
            dsTaint.addTaint(left.dsTaint);
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


    
    private static final String TAG = "NetworkStats";
    public static final String IFACE_ALL = null;
    public static final int UID_ALL = -1;
    public static final int SET_ALL = -1;
    public static final int SET_DEFAULT = 0;
    public static final int SET_FOREGROUND = 1;
    public static final int TAG_NONE = 0;
    public static final Creator<NetworkStats> CREATOR = new Creator<NetworkStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.236 -0400", hash_original_method = "76D9386453B9839BC68D96B3471291B7", hash_generated_method = "71C9090314B58195D69AD4039D5C04D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkStats createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            NetworkStats var4C6AA10D7D146D95ECFFAFCBB14EAF8D_1136813132 = (new NetworkStats(in));
            return (NetworkStats)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkStats(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.236 -0400", hash_original_method = "6BCBF9A9B4039336956D31ACA3A9B0D4", hash_generated_method = "8E5B442CDC70949FA7808CEB0F8E6E02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkStats[] newArray(int size) {
            dsTaint.addTaint(size);
            NetworkStats[] varF295FF2DD1641B4AEB73AA3623A37E46_1580621006 = (new NetworkStats[size]);
            return (NetworkStats[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkStats[size];
        }

        
}; //Transformed anonymous class
}

