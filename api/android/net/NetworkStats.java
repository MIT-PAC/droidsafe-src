package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "90F9860F2ACD6C63E4929F387936CB9F", hash_generated_field = "538680F69DE637447E0D8142F5C87404")

    private long elapsedRealtime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "7E57670F7C5530F50680411F8B75B179", hash_generated_field = "AEC0BBDA5208AC6967DEC78EF15071F3")

    private String[] iface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "A8AC2BB90C17959AB4283F941009C346")

    private int[] uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "A4E4C55D8B662E9B726E86B8916906DE")

    private int[] set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "2F0D3812A3BBA96458EDF1EF87423C61")

    private int[] tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "835A90EA79ED43E63CD1F8551E1170AC")

    private long[] rxBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "3C8EA21CAE3964AFEC5D5287345DF52F")

    private long[] rxPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.011 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "5D0307CD93ADE4DF2FD18B8CD5214177")

    private long[] txBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.012 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "EF80B3F02FF3FE9875FC49D478831ABF")

    private long[] txPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.012 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "D54D9A650B72A41B61249C2CA8E210FC")

    private long[] operations;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.014 -0400", hash_original_method = "2A398CA499F31285985E41F8490B2A34", hash_generated_method = "380CA970FE12D5BD2BAF01BBA1D2FCB2")
    public  NetworkStats(long elapsedRealtime, int initialSize) {
        this.elapsedRealtime = elapsedRealtime;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.016 -0400", hash_original_method = "D90F7AB3E4E138FF177FEBA052B61E8A", hash_generated_method = "C3D36E03FA24329D94C1862F8554454A")
    public  NetworkStats(Parcel parcel) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.016 -0400", hash_original_method = "747F845D1C1DAB9F1E978429A723A0B0", hash_generated_method = "A402F8627E2C7B31849F6C38B965C4E6")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.017 -0400", hash_original_method = "2B258B3B735A82A55EB3270F9E3A7FB6", hash_generated_method = "FE510CB10B75A14FF993C3029711C86D")
    @Override
    public NetworkStats clone() {
        final NetworkStats clone = new NetworkStats(elapsedRealtime, size);
        NetworkStats.Entry entry = null;
for(int i = 0;i < size;i++)
        {
            entry = getValues(i, entry);
            clone.addValues(entry);
        } //End block
NetworkStats var3DE52045BFD3C1BF3742F994ED6139AD_1131839105 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1131839105.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1131839105;
        // ---------- Original Method ----------
        //final NetworkStats clone = new NetworkStats(elapsedRealtime, size);
        //NetworkStats.Entry entry = null;
        //for (int i = 0; i < size; i++) {
            //entry = getValues(i, entry);
            //clone.addValues(entry);
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.017 -0400", hash_original_method = "C4F6601144FE185F7636CD51AD058501", hash_generated_method = "10AEC01FE1895BEFEA92344956FD2707")
    public NetworkStats addIfaceValues(
            String iface, long rxBytes, long rxPackets, long txBytes, long txPackets) {
        addTaint(txPackets);
        addTaint(txBytes);
        addTaint(rxPackets);
        addTaint(rxBytes);
        addTaint(iface.getTaint());
NetworkStats var86716A891B4A6F25225A31F54112BF7D_888896967 =         addValues(
                iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
        var86716A891B4A6F25225A31F54112BF7D_888896967.addTaint(taint);
        return var86716A891B4A6F25225A31F54112BF7D_888896967;
        // ---------- Original Method ----------
        //return addValues(
                //iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.018 -0400", hash_original_method = "F572451A01AB0326B364A96213456AFC", hash_generated_method = "28A7FFEF21E4EED8E71EB3DBE9A93C7B")
    public NetworkStats addValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        addTaint(operations);
        addTaint(txPackets);
        addTaint(txBytes);
        addTaint(rxPackets);
        addTaint(rxBytes);
        addTaint(tag);
        addTaint(set);
        addTaint(uid);
        addTaint(iface.getTaint());
NetworkStats var662C1D98BE745A1EE251224845A23CE8_694638907 =         addValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        var662C1D98BE745A1EE251224845A23CE8_694638907.addTaint(taint);
        return var662C1D98BE745A1EE251224845A23CE8_694638907;
        // ---------- Original Method ----------
        //return addValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.020 -0400", hash_original_method = "BA5E7818DCBE1852CDC81090E5B13339", hash_generated_method = "3C8624380D72AFEB90BD0008F1872ADA")
    public NetworkStats addValues(Entry entry) {
    if(size >= this.iface.length)        
        {
            final int newLength = Math.max(iface.length, 10) * 3 / 2;
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
NetworkStats var72A74007B2BE62B849F475C7BDA4658B_1075861094 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1075861094.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1075861094;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.021 -0400", hash_original_method = "784A932AD4193748EF13A1422BBA3C89", hash_generated_method = "42E7D0F56ECEAF94DD95C9A993E288CB")
    public Entry getValues(int i, Entry recycle) {
        addTaint(recycle.getTaint());
        final Entry entry = recycle != null ? recycle : new Entry();
        entry.iface = iface[i];
        entry.uid = uid[i];
        entry.set = set[i];
        entry.tag = tag[i];
        entry.rxBytes = rxBytes[i];
        entry.rxPackets = rxPackets[i];
        entry.txBytes = txBytes[i];
        entry.txPackets = txPackets[i];
        entry.operations = operations[i];
Entry varF26DBE38545460D6F6AE1D948FF53869_1475191791 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_1475191791.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_1475191791;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.022 -0400", hash_original_method = "F3360ADB8E6D37C5AD6714A1DBEA3C2C", hash_generated_method = "4A3448193A9B66EDE6066762709038F7")
    public long getElapsedRealtime() {
        long var90F9860F2ACD6C63E4929F387936CB9F_717273817 = (elapsedRealtime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1531900050 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1531900050;
        // ---------- Original Method ----------
        //return elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.022 -0400", hash_original_method = "A28F8D44EDD8B5977D1B4B03F62008BC", hash_generated_method = "E3DD82B9F251105A0604B926B0F20CA2")
    public long getElapsedRealtimeAge() {
        long varCB1FD886D9702AB53E7C279360FCB78B_1853083898 = (SystemClock.elapsedRealtime() - elapsedRealtime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_764193691 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_764193691;
        // ---------- Original Method ----------
        //return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.022 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "A32E5F1817783ECFDEF47A6C49C6B615")
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_59223002 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069146550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069146550;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.023 -0400", hash_original_method = "2B99B673BBD8E75B3053CAA25E99CAA5", hash_generated_method = "E1C670952EC6781CECB8A039FB9B0BC4")
    public int internalSize() {
        int var1D14402A536292FB0E5BFD7749295FCE_1498153163 = (iface.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763385849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763385849;
        // ---------- Original Method ----------
        //return iface.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.023 -0400", hash_original_method = "60A49D4C2C28DC0F7F89BE32E32B8D66", hash_generated_method = "C22D61A1D159D314F32383A008168720")
    @Deprecated
    public NetworkStats combineValues(String iface, int uid, int tag, long rxBytes, long rxPackets,
            long txBytes, long txPackets, long operations) {
        addTaint(operations);
        addTaint(txPackets);
        addTaint(txBytes);
        addTaint(rxPackets);
        addTaint(rxBytes);
        addTaint(tag);
        addTaint(uid);
        addTaint(iface.getTaint());
NetworkStats var18E15851772FB364BFC5DC07AEFDA62C_668821606 =         combineValues(
                iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
        var18E15851772FB364BFC5DC07AEFDA62C_668821606.addTaint(taint);
        return var18E15851772FB364BFC5DC07AEFDA62C_668821606;
        // ---------- Original Method ----------
        //return combineValues(
                //iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.024 -0400", hash_original_method = "F71B507E3E7A764789F38FD5530E9585", hash_generated_method = "AEF4F4963E80BB108BBFF2211E978E9A")
    public NetworkStats combineValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        addTaint(operations);
        addTaint(txPackets);
        addTaint(txBytes);
        addTaint(rxPackets);
        addTaint(rxBytes);
        addTaint(tag);
        addTaint(set);
        addTaint(uid);
        addTaint(iface.getTaint());
NetworkStats var533B44CC114A8A103B52DBF2DBB164D7_1093765283 =         combineValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        var533B44CC114A8A103B52DBF2DBB164D7_1093765283.addTaint(taint);
        return var533B44CC114A8A103B52DBF2DBB164D7_1093765283;
        // ---------- Original Method ----------
        //return combineValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.025 -0400", hash_original_method = "49582C07F79A6507E237CBEC2438E36C", hash_generated_method = "E8528CF0C6CADAA5D4DBD6302796E0DB")
    public NetworkStats combineValues(Entry entry) {
        final int i = findIndex(entry.iface, entry.uid, entry.set, entry.tag);
    if(i == -1)        
        {
            addValues(entry);
        } //End block
        else
        {
            rxBytes[i] += entry.rxBytes;
            rxPackets[i] += entry.rxPackets;
            txBytes[i] += entry.txBytes;
            txPackets[i] += entry.txPackets;
            operations[i] += entry.operations;
        } //End block
NetworkStats var72A74007B2BE62B849F475C7BDA4658B_320939140 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_320939140.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_320939140;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.026 -0400", hash_original_method = "0A31FFFE210F2775172111CD7E8C7EC0", hash_generated_method = "CA914106693C93F1EA4772B05A41D8F8")
    public void combineAllValues(NetworkStats another) {
        addTaint(another.getTaint());
        NetworkStats.Entry entry = null;
for(int i = 0;i < another.size;i++)
        {
            entry = another.getValues(i, entry);
            combineValues(entry);
        } //End block
        // ---------- Original Method ----------
        //NetworkStats.Entry entry = null;
        //for (int i = 0; i < another.size; i++) {
            //entry = another.getValues(i, entry);
            //combineValues(entry);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.027 -0400", hash_original_method = "FEC91070502C1195B6460B4D97DFCE73", hash_generated_method = "8EAEA0F6B5B85F48F923463E6243D756")
    public int findIndex(String iface, int uid, int set, int tag) {
        addTaint(tag);
        addTaint(set);
        addTaint(uid);
        addTaint(iface.getTaint());
for(int i = 0;i < size;i++)
        {
    if(uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i]))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1733808927 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554714640 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554714640;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_280374769 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154997149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154997149;
        // ---------- Original Method ----------
        //for (int i = 0; i < size; i++) {
            //if (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    //&& Objects.equal(iface, this.iface[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.028 -0400", hash_original_method = "09F077C80C4F986B6C39E3E7ABC587EB", hash_generated_method = "742B7D81FC2C5B565BAE78E98FED5171")
    public int findIndexHinted(String iface, int uid, int set, int tag, int hintIndex) {
        addTaint(hintIndex);
        addTaint(tag);
        addTaint(set);
        addTaint(uid);
        addTaint(iface.getTaint());
for(int offset = 0;offset < size;offset++)
        {
            final int halfOffset = offset / 2;
            int i;
    if(offset % 2 == 0)            
            {
                i = (hintIndex + halfOffset) % size;
            } //End block
            else
            {
                i = (size + hintIndex - halfOffset - 1) % size;
            } //End block
    if(uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i]))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_693749697 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11179259 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11179259;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1601680183 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352815861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352815861;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.029 -0400", hash_original_method = "6E339B821B6FB4996B911B569AAD524F", hash_generated_method = "1144D413663F4975517160407EC0D260")
    public void spliceOperationsFrom(NetworkStats stats) {
for(int i = 0;i < size;i++)
        {
            final int j = stats.findIndex(IFACE_ALL, uid[i], set[i], tag[i]);
    if(j == -1)            
            {
                operations[i] = 0;
            } //End block
            else
            {
                operations[i] = stats.operations[j];
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.029 -0400", hash_original_method = "2B2C9B0B02A7A72C63A74815DF58D4A4", hash_generated_method = "E6C70811064E31A8CE04C8533A833A89")
    public String[] getUniqueIfaces() {
        final HashSet<String> ifaces = new HashSet<String>();
for(String iface : this.iface)
        {
    if(iface != IFACE_ALL)            
            {
                ifaces.add(iface);
            } //End block
        } //End block
String[] var484DB913905DBB36FE22333D6D2ECB57_605130437 =         ifaces.toArray(new String[ifaces.size()]);
        var484DB913905DBB36FE22333D6D2ECB57_605130437.addTaint(taint);
        return var484DB913905DBB36FE22333D6D2ECB57_605130437;
        // ---------- Original Method ----------
        //final HashSet<String> ifaces = new HashSet<String>();
        //for (String iface : this.iface) {
            //if (iface != IFACE_ALL) {
                //ifaces.add(iface);
            //}
        //}
        //return ifaces.toArray(new String[ifaces.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.030 -0400", hash_original_method = "C948A3950E5BB6DBF87B62BBDA0B02C8", hash_generated_method = "9F482F25402D2E8CDA4137B81FF53A81")
    public int[] getUniqueUids() {
        final SparseBooleanArray uids = new SparseBooleanArray();
for(int uid : this.uid)
        {
            uids.put(uid, true);
        } //End block
        final int size = uids.size();
        final int[] result = new int[size];
for(int i = 0;i < size;i++)
        {
            result[i] = uids.keyAt(i);
        } //End block
        int[] varB4A88417B3D0170D754C647C30B7216A_1716095087 = (result);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1617742847 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1617742847;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.030 -0400", hash_original_method = "277B11F09A23B8E4B361A93BBF3584B2", hash_generated_method = "F9B62001FC983C9BA36B8D5FC98FB8D1")
    public long getTotalBytes() {
        final Entry entry = getTotal(null);
        long var5F00EEE8FA7A451FA9CFD5EB43AD8755_1424194154 = (entry.rxBytes + entry.txBytes);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1106639210 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1106639210;
        // ---------- Original Method ----------
        //final Entry entry = getTotal(null);
        //return entry.rxBytes + entry.txBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.030 -0400", hash_original_method = "4A2B09728CEDE32F9C68EF92F6D5889E", hash_generated_method = "7DBB449A4D677DB72E2792223468A6C2")
    public Entry getTotal(Entry recycle) {
        addTaint(recycle.getTaint());
Entry var493E61FE716DA417C48A4E79249E8995_254661920 =         getTotal(recycle, null, UID_ALL);
        var493E61FE716DA417C48A4E79249E8995_254661920.addTaint(taint);
        return var493E61FE716DA417C48A4E79249E8995_254661920;
        // ---------- Original Method ----------
        //return getTotal(recycle, null, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.031 -0400", hash_original_method = "D5D19E4CD939B7A0BD1C3BDE2A399415", hash_generated_method = "28C31FFE1496FA90BCBF1D0EE7AFD6F6")
    public Entry getTotal(Entry recycle, int limitUid) {
        addTaint(limitUid);
        addTaint(recycle.getTaint());
Entry varD401B5235C2DDA22F88678CB02EE769D_517660912 =         getTotal(recycle, null, limitUid);
        varD401B5235C2DDA22F88678CB02EE769D_517660912.addTaint(taint);
        return varD401B5235C2DDA22F88678CB02EE769D_517660912;
        // ---------- Original Method ----------
        //return getTotal(recycle, null, limitUid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.033 -0400", hash_original_method = "A8C67127F98A8F27D6DD2D10C54926B1", hash_generated_method = "B094A61FC6EA2842C59FCB3848E75B9D")
    public Entry getTotal(Entry recycle, HashSet<String> limitIface) {
        addTaint(limitIface.getTaint());
        addTaint(recycle.getTaint());
Entry varDBE85A58A348CABDD8A8D13467B29A3C_1313839589 =         getTotal(recycle, limitIface, UID_ALL);
        varDBE85A58A348CABDD8A8D13467B29A3C_1313839589.addTaint(taint);
        return varDBE85A58A348CABDD8A8D13467B29A3C_1313839589;
        // ---------- Original Method ----------
        //return getTotal(recycle, limitIface, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.036 -0400", hash_original_method = "7B779B0B251D8F12031ECAB7F83EFE1D", hash_generated_method = "2A385E943C87E40BBE61EBAB4C6FD7FC")
    private Entry getTotal(Entry recycle, HashSet<String> limitIface, int limitUid) {
        addTaint(limitIface.getTaint());
        addTaint(recycle.getTaint());
        final Entry entry = recycle != null ? recycle : new Entry();
        entry.iface = IFACE_ALL;
        entry.uid = limitUid;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;
        entry.rxBytes = 0;
        entry.rxPackets = 0;
        entry.txBytes = 0;
        entry.txPackets = 0;
        entry.operations = 0;
for(int i = 0;i < size;i++)
        {
            final boolean matchesUid = (limitUid == UID_ALL) || (limitUid == uid[i]);
            final boolean matchesIface = (limitIface == null) || (limitIface.contains(iface[i]));
    if(matchesUid && matchesIface)            
            {
    if(tag[i] != TAG_NONE)                
                continue;
                entry.rxBytes += rxBytes[i];
                entry.rxPackets += rxPackets[i];
                entry.txBytes += txBytes[i];
                entry.txPackets += txPackets[i];
                entry.operations += operations[i];
            } //End block
        } //End block
Entry varF26DBE38545460D6F6AE1D948FF53869_455021003 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_455021003.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_455021003;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.036 -0400", hash_original_method = "0B77BD3659EBAD0CA6247F62089B29FF", hash_generated_method = "BB73E4DB45CF74585E97A3BBB2B57643")
    public NetworkStats subtract(NetworkStats value) throws NonMonotonicException {
        addTaint(value.getTaint());
NetworkStats var0C2F4E324A8788B9E3A075272F2B5127_280792256 =         subtract(value, false);
        var0C2F4E324A8788B9E3A075272F2B5127_280792256.addTaint(taint);
        return var0C2F4E324A8788B9E3A075272F2B5127_280792256;
        // ---------- Original Method ----------
        //return subtract(value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.043 -0400", hash_original_method = "04678C1B7F1434E233D6434823B40504", hash_generated_method = "E57C88A046BACA268558AED6D976B3D5")
    public NetworkStats subtract(NetworkStats value, boolean clampNonMonotonic) throws NonMonotonicException {
        addTaint(clampNonMonotonic);
        final long deltaRealtime = this.elapsedRealtime - value.elapsedRealtime;
    if(deltaRealtime < 0)        
        {
            NonMonotonicException varD5AC2DE5227BC8E2D6AEAB31174541EB_441009014 = new NonMonotonicException(this, value);
            varD5AC2DE5227BC8E2D6AEAB31174541EB_441009014.addTaint(taint);
            throw varD5AC2DE5227BC8E2D6AEAB31174541EB_441009014;
        } //End block
        final Entry entry = new Entry();
        final NetworkStats result = new NetworkStats(deltaRealtime, size);
for(int i = 0;i < size;i++)
        {
            entry.iface = iface[i];
            entry.uid = uid[i];
            entry.set = set[i];
            entry.tag = tag[i];
            final int j = value.findIndexHinted(entry.iface, entry.uid, entry.set, entry.tag, i);
    if(j == -1)            
            {
                entry.rxBytes = rxBytes[i];
                entry.rxPackets = rxPackets[i];
                entry.txBytes = txBytes[i];
                entry.txPackets = txPackets[i];
                entry.operations = operations[i];
            } //End block
            else
            {
                entry.rxBytes = rxBytes[i] - value.rxBytes[j];
                entry.rxPackets = rxPackets[i] - value.rxPackets[j];
                entry.txBytes = txBytes[i] - value.txBytes[j];
                entry.txPackets = txPackets[i] - value.txPackets[j];
                entry.operations = operations[i] - value.operations[j];
    if(entry.rxBytes < 0 || entry.rxPackets < 0 || entry.txBytes < 0
                        || entry.txPackets < 0 || entry.operations < 0)                
                {
    if(clampNonMonotonic)                    
                    {
                        entry.rxBytes = Math.max(entry.rxBytes, 0);
                        entry.rxPackets = Math.max(entry.rxPackets, 0);
                        entry.txBytes = Math.max(entry.txBytes, 0);
                        entry.txPackets = Math.max(entry.txPackets, 0);
                        entry.operations = Math.max(entry.operations, 0);
                    } //End block
                    else
                    {
                        NonMonotonicException var5309FB994A6EB96BD7E067C5C85ECF05_1796134250 = new NonMonotonicException(this, i, value, j);
                        var5309FB994A6EB96BD7E067C5C85ECF05_1796134250.addTaint(taint);
                        throw var5309FB994A6EB96BD7E067C5C85ECF05_1796134250;
                    } //End block
                } //End block
            } //End block
            result.addValues(entry);
        } //End block
NetworkStats varDC838461EE2FA0CA4C9BBB70A15456B0_326173025 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_326173025.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_326173025;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.045 -0400", hash_original_method = "AB3FDA05B945C3AC93E7C4BBCBA41D8F", hash_generated_method = "94FC5EC895CADA5B3258F3921DE67A21")
    public NetworkStats groupedByIface() {
        final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);
        final Entry entry = new Entry();
        entry.uid = UID_ALL;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;
        entry.operations = 0L;
for(int i = 0;i < size;i++)
        {
    if(tag[i] != TAG_NONE)            
            continue;
            entry.iface = iface[i];
            entry.rxBytes = rxBytes[i];
            entry.rxPackets = rxPackets[i];
            entry.txBytes = txBytes[i];
            entry.txPackets = txPackets[i];
            stats.combineValues(entry);
        } //End block
NetworkStats var6199C0EAA905687345ED5A344094841F_1757776218 =         stats;
        var6199C0EAA905687345ED5A344094841F_1757776218.addTaint(taint);
        return var6199C0EAA905687345ED5A344094841F_1757776218;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.047 -0400", hash_original_method = "F7B5ADC030AABE070FE0AF3D1DEEC4FF", hash_generated_method = "522ABB4D7E17B52C81DB4B7767094A7D")
    public NetworkStats groupedByUid() {
        final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);
        final Entry entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;
for(int i = 0;i < size;i++)
        {
    if(tag[i] != TAG_NONE)            
            continue;
            entry.uid = uid[i];
            entry.rxBytes = rxBytes[i];
            entry.rxPackets = rxPackets[i];
            entry.txBytes = txBytes[i];
            entry.txPackets = txPackets[i];
            entry.operations = operations[i];
            stats.combineValues(entry);
        } //End block
NetworkStats var6199C0EAA905687345ED5A344094841F_1249972828 =         stats;
        var6199C0EAA905687345ED5A344094841F_1249972828.addTaint(taint);
        return var6199C0EAA905687345ED5A344094841F_1249972828;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.048 -0400", hash_original_method = "9245ED01B44F4BC6EDE26C84298E681C", hash_generated_method = "4A02F12459FD4A4ACB68646CB359475F")
    public NetworkStats withoutUid(int uid) {
        addTaint(uid);
        final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);
        Entry entry = new Entry();
for(int i = 0;i < size;i++)
        {
            entry = getValues(i, entry);
    if(entry.uid != uid)            
            {
                stats.addValues(entry);
            } //End block
        } //End block
NetworkStats var6199C0EAA905687345ED5A344094841F_161169833 =         stats;
        var6199C0EAA905687345ED5A344094841F_161169833.addTaint(taint);
        return var6199C0EAA905687345ED5A344094841F_161169833;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.049 -0400", hash_original_method = "130412F853181F3DE6D8909F69FBB580", hash_generated_method = "AE1D0777D9E9FC3AFE4E7C66343A4282")
    public void dump(String prefix, PrintWriter pw) {
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        pw.print(prefix);
        pw.print("NetworkStats: elapsedRealtime=");
        pw.println(elapsedRealtime);
for(int i = 0;i < size;i++)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.050 -0400", hash_original_method = "C185C780AB6AF420802BBBCB2A0DA03E", hash_generated_method = "E0665009E37D475B1A4F08709A6E0BA4")
    @Override
    public String toString() {
        final CharArrayWriter writer = new CharArrayWriter();
        dump("", new PrintWriter(writer));
String varEF986DCEFABA18330D92CD8C42EF636E_724773760 =         writer.toString();
        varEF986DCEFABA18330D92CD8C42EF636E_724773760.addTaint(taint);
        return varEF986DCEFABA18330D92CD8C42EF636E_724773760;
        // ---------- Original Method ----------
        //final CharArrayWriter writer = new CharArrayWriter();
        //dump("", new PrintWriter(writer));
        //return writer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.050 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D8C5B9116D310B762891758459BCC9F4")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_469844400 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836111118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836111118;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.050 -0400", hash_original_field = "7E57670F7C5530F50680411F8B75B179", hash_generated_field = "C6A1018CA8BDAC723763D450E0753839")

        public String iface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.050 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.050 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "76DD25E4462280D67562778690A1B8EC")

        public int set;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "9910EB628EC91FE06D2639B0F3810F0E")

        public long rxBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "6ADCDCD12FD7D35118980BC0BB165142")

        public long rxPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "676F2C3D88E440A0E185A42A7F55CF74")

        public long txBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "B93ED690B1DA86F6CE26308A7104AEFF")

        public long txPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "49E564B98B6E0E4454081C4D76AD6B00")

        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_method = "CF147DC846E9FA9CFBACF54E998579AF", hash_generated_method = "F7D90DFA18CB5A7447228376F168D3F6")
        public  Entry() {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.051 -0400", hash_original_method = "E97E61BD38788E206E16E3AF28EF9986", hash_generated_method = "B08DA8B165AB7B27AB5B1782BDE7ACB8")
        public  Entry(long rxBytes, long rxPackets, long txBytes, long txPackets, long operations) {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets,
                    operations);
            addTaint(operations);
            addTaint(txPackets);
            addTaint(txBytes);
            addTaint(rxPackets);
            addTaint(rxBytes);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.053 -0400", hash_original_method = "08CED58FDA8ADE41E7B2EE03A16F55F8", hash_generated_method = "CB3E6C63FCCA7D2DBA6EB60EBBF0511C")
        public  Entry(String iface, int uid, int set, int tag, long rxBytes, long rxPackets,
                long txBytes, long txPackets, long operations) {
            this.iface = iface;
            this.uid = uid;
            this.set = set;
            this.tag = tag;
            this.rxBytes = rxBytes;
            this.rxPackets = rxPackets;
            this.txBytes = txBytes;
            this.txPackets = txPackets;
            this.operations = operations;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.054 -0400", hash_original_method = "8BA58A1912534045F7A50ACBC1B00F2F", hash_generated_method = "F91AFAA6C5786201BA0D60219311B01E")
        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder();
            builder.append("iface=").append(iface);
            builder.append(" uid=").append(uid);
            builder.append(" set=").append(setToString(set));
            builder.append(" tag=").append(tagToString(tag));
            builder.append(" rxBytes=").append(rxBytes);
            builder.append(" rxPackets=").append(rxPackets);
            builder.append(" txBytes=").append(txBytes);
            builder.append(" txPackets=").append(txPackets);
            builder.append(" operations=").append(operations);
String varF4CF030572656354ACFDF83FEE21D7A6_831315938 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_831315938.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_831315938;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.054 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "181F8009619333E411770D3E70DC8370")

        public NetworkStats left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.054 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "B505F3F155C5E8A912533BF2967190B7")

        public NetworkStats right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.054 -0400", hash_original_field = "EDC10311D3D1494F1306BBAB7BF69CB3", hash_generated_field = "217C8C9F8012EB7818E9531FC30FEF27")

        public int leftIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.054 -0400", hash_original_field = "415E97ED95AF01CA0C988761665551CF", hash_generated_field = "4A28DC3C7ADE86B25DA19F4A8CD04779")

        public int rightIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.054 -0400", hash_original_method = "0F470ECE148C3E2C73ACB1D4F54D342F", hash_generated_method = "9FE4896904204EFF85AFE87A9F696C67")
        public  NonMonotonicException(NetworkStats left, NetworkStats right) {
            this(left, -1, right, -1);
            addTaint(right.getTaint());
            addTaint(left.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.055 -0400", hash_original_method = "F441B58E88456542B2E0F8A35978B48D", hash_generated_method = "B509B564F3FB6D5E27CAC23B156AB149")
        public  NonMonotonicException(
                NetworkStats left, int leftIndex, NetworkStats right, int rightIndex) {
            this.left = checkNotNull(left, "missing left");
            this.right = checkNotNull(right, "missing right");
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            // ---------- Original Method ----------
            //this.left = checkNotNull(left, "missing left");
            //this.right = checkNotNull(right, "missing right");
            //this.leftIndex = leftIndex;
            //this.rightIndex = rightIndex;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.055 -0400", hash_original_field = "0639DD17ED95F786B1E5DE96AA9666BE", hash_generated_field = "9745DE468315B8EBA198D1500BBA5367")

    private static final String TAG = "NetworkStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.055 -0400", hash_original_field = "25C863106C3C42528AA01F74D73EE92C", hash_generated_field = "4B5E58BD186965CA0BD1A5ED0A9A7F54")

    public static final String IFACE_ALL = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.056 -0400", hash_original_field = "F9E949847731C6743751DD9799931E92", hash_generated_field = "FC1870BB9E6A348A548B826696AEFBDA")

    public static final int UID_ALL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.056 -0400", hash_original_field = "0737CE9FB392DCEABDB96A70642A9F24", hash_generated_field = "FB67A78888DCA694CC62A7659E04AD25")

    public static final int SET_ALL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.056 -0400", hash_original_field = "C4E5DCEC3CBDD6E317570BE4FB03D395", hash_generated_field = "095B691962D2E94BB7EAA2D948D7C96E")

    public static final int SET_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.056 -0400", hash_original_field = "02F04EDD54119AF3CF408766007CDBDB", hash_generated_field = "31A399D29DE8B7B547B04EAE8CD8FC9F")

    public static final int SET_FOREGROUND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.056 -0400", hash_original_field = "82356421805D7AEB1E16F8592C5B892F", hash_generated_field = "07CC6589E9BD2DFCEE5DD80A37C03CC4")

    public static final int TAG_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.056 -0400", hash_original_field = "3469CD7C405D7C574C3592A9EE21FD10", hash_generated_field = "C59D2B9A15468765CA55EEA88C603BE5")

    public static final Creator<NetworkStats> CREATOR = new Creator<NetworkStats>() {
        public NetworkStats createFromParcel(Parcel in) {
            return new NetworkStats(in);
        }

        public NetworkStats[] newArray(int size) {
            return new NetworkStats[size];
        }
    };
    // orphaned legacy method
    public NetworkStats createFromParcel(Parcel in) {
            return new NetworkStats(in);
        }
    
    // orphaned legacy method
    public NetworkStats[] newArray(int size) {
            return new NetworkStats[size];
        }
    
}

