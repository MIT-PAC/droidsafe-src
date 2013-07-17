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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "90F9860F2ACD6C63E4929F387936CB9F", hash_generated_field = "538680F69DE637447E0D8142F5C87404")

    private long elapsedRealtime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "7E57670F7C5530F50680411F8B75B179", hash_generated_field = "AEC0BBDA5208AC6967DEC78EF15071F3")

    private String[] iface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "A8AC2BB90C17959AB4283F941009C346")

    private int[] uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "A4E4C55D8B662E9B726E86B8916906DE")

    private int[] set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "2F0D3812A3BBA96458EDF1EF87423C61")

    private int[] tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "835A90EA79ED43E63CD1F8551E1170AC")

    private long[] rxBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "3C8EA21CAE3964AFEC5D5287345DF52F")

    private long[] rxPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "5D0307CD93ADE4DF2FD18B8CD5214177")

    private long[] txBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "EF80B3F02FF3FE9875FC49D478831ABF")

    private long[] txPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.700 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "D54D9A650B72A41B61249C2CA8E210FC")

    private long[] operations;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.702 -0400", hash_original_method = "2A398CA499F31285985E41F8490B2A34", hash_generated_method = "380CA970FE12D5BD2BAF01BBA1D2FCB2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.704 -0400", hash_original_method = "D90F7AB3E4E138FF177FEBA052B61E8A", hash_generated_method = "C3D36E03FA24329D94C1862F8554454A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.706 -0400", hash_original_method = "747F845D1C1DAB9F1E978429A723A0B0", hash_generated_method = "A402F8627E2C7B31849F6C38B965C4E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.706 -0400", hash_original_method = "2B258B3B735A82A55EB3270F9E3A7FB6", hash_generated_method = "4949FFB7A0DEFEE95CCF0AD007E1BE95")
    @Override
    public NetworkStats clone() {
        final NetworkStats clone = new NetworkStats(elapsedRealtime, size);
        NetworkStats.Entry entry = null;
for(int i = 0;i < size;i++)
        {
            entry = getValues(i, entry);
            clone.addValues(entry);
        } //End block
NetworkStats var3DE52045BFD3C1BF3742F994ED6139AD_803734219 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_803734219.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_803734219;
        // ---------- Original Method ----------
        //final NetworkStats clone = new NetworkStats(elapsedRealtime, size);
        //NetworkStats.Entry entry = null;
        //for (int i = 0; i < size; i++) {
            //entry = getValues(i, entry);
            //clone.addValues(entry);
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.707 -0400", hash_original_method = "C4F6601144FE185F7636CD51AD058501", hash_generated_method = "377C3EDA0A2C94B8D28837A276949FFD")
    public NetworkStats addIfaceValues(
            String iface, long rxBytes, long rxPackets, long txBytes, long txPackets) {
        addTaint(txPackets);
        addTaint(txBytes);
        addTaint(rxPackets);
        addTaint(rxBytes);
        addTaint(iface.getTaint());
NetworkStats var86716A891B4A6F25225A31F54112BF7D_328091976 =         addValues(
                iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
        var86716A891B4A6F25225A31F54112BF7D_328091976.addTaint(taint);
        return var86716A891B4A6F25225A31F54112BF7D_328091976;
        // ---------- Original Method ----------
        //return addValues(
                //iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.707 -0400", hash_original_method = "F572451A01AB0326B364A96213456AFC", hash_generated_method = "7B3698BB6007BEA8CE8EAD10274D3D90")
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
NetworkStats var662C1D98BE745A1EE251224845A23CE8_447905269 =         addValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        var662C1D98BE745A1EE251224845A23CE8_447905269.addTaint(taint);
        return var662C1D98BE745A1EE251224845A23CE8_447905269;
        // ---------- Original Method ----------
        //return addValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.710 -0400", hash_original_method = "BA5E7818DCBE1852CDC81090E5B13339", hash_generated_method = "710D38006A763791F614D8958D96C796")
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
NetworkStats var72A74007B2BE62B849F475C7BDA4658B_1158010876 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1158010876.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1158010876;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.711 -0400", hash_original_method = "784A932AD4193748EF13A1422BBA3C89", hash_generated_method = "A75A95E29DF8A6B2EEF7C8EC01C4CD80")
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
Entry varF26DBE38545460D6F6AE1D948FF53869_2086145025 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_2086145025.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_2086145025;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.712 -0400", hash_original_method = "F3360ADB8E6D37C5AD6714A1DBEA3C2C", hash_generated_method = "DD4ABC6CCE309F9E4A983AE80A416815")
    public long getElapsedRealtime() {
        long var90F9860F2ACD6C63E4929F387936CB9F_1409923905 = (elapsedRealtime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1635475533 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1635475533;
        // ---------- Original Method ----------
        //return elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.712 -0400", hash_original_method = "A28F8D44EDD8B5977D1B4B03F62008BC", hash_generated_method = "C3C906E4806DB9149772EA2C11A97C14")
    public long getElapsedRealtimeAge() {
        long varCB1FD886D9702AB53E7C279360FCB78B_1291085004 = (SystemClock.elapsedRealtime() - elapsedRealtime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1978435822 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1978435822;
        // ---------- Original Method ----------
        //return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.713 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "90DF8A80C2449C041D9493498FCB5483")
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_612686210 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620750946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620750946;
        // ---------- Original Method ----------
        //return size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.713 -0400", hash_original_method = "2B99B673BBD8E75B3053CAA25E99CAA5", hash_generated_method = "67D053BEA725AE5763C33EAC344015FC")
    public int internalSize() {
        int var1D14402A536292FB0E5BFD7749295FCE_28751265 = (iface.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880644183 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880644183;
        // ---------- Original Method ----------
        //return iface.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.728 -0400", hash_original_method = "60A49D4C2C28DC0F7F89BE32E32B8D66", hash_generated_method = "1B1CDC42CB131A8B465D881A396A8311")
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
NetworkStats var18E15851772FB364BFC5DC07AEFDA62C_1844800311 =         combineValues(
                iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
        var18E15851772FB364BFC5DC07AEFDA62C_1844800311.addTaint(taint);
        return var18E15851772FB364BFC5DC07AEFDA62C_1844800311;
        // ---------- Original Method ----------
        //return combineValues(
                //iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.728 -0400", hash_original_method = "F71B507E3E7A764789F38FD5530E9585", hash_generated_method = "24BF45D9FE6B5F050AE82ECF6CCD1D4D")
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
NetworkStats var533B44CC114A8A103B52DBF2DBB164D7_1038125667 =         combineValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        var533B44CC114A8A103B52DBF2DBB164D7_1038125667.addTaint(taint);
        return var533B44CC114A8A103B52DBF2DBB164D7_1038125667;
        // ---------- Original Method ----------
        //return combineValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.729 -0400", hash_original_method = "49582C07F79A6507E237CBEC2438E36C", hash_generated_method = "D5588C08890231C728489B04F18CD9D7")
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
NetworkStats var72A74007B2BE62B849F475C7BDA4658B_1894347100 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1894347100.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1894347100;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.729 -0400", hash_original_method = "0A31FFFE210F2775172111CD7E8C7EC0", hash_generated_method = "CA914106693C93F1EA4772B05A41D8F8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.729 -0400", hash_original_method = "FEC91070502C1195B6460B4D97DFCE73", hash_generated_method = "10A313A7324FBBAB7ED51243359191BA")
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
                int var865C0C0B4AB0E063E5CAA3387C1A8741_688310447 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188532639 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188532639;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1479332928 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599964176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599964176;
        // ---------- Original Method ----------
        //for (int i = 0; i < size; i++) {
            //if (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    //&& Objects.equal(iface, this.iface[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.730 -0400", hash_original_method = "09F077C80C4F986B6C39E3E7ABC587EB", hash_generated_method = "D803652BAEB1AF5D879E0DCADE6AF824")
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
                int var865C0C0B4AB0E063E5CAA3387C1A8741_495487700 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516486239 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516486239;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2072575622 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798370302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798370302;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.730 -0400", hash_original_method = "6E339B821B6FB4996B911B569AAD524F", hash_generated_method = "1144D413663F4975517160407EC0D260")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.730 -0400", hash_original_method = "2B2C9B0B02A7A72C63A74815DF58D4A4", hash_generated_method = "3B68661F1EC8CFF27AF8E6B43B6A3C74")
    public String[] getUniqueIfaces() {
        final HashSet<String> ifaces = new HashSet<String>();
for(String iface : this.iface)
        {
            if(iface != IFACE_ALL)            
            {
                ifaces.add(iface);
            } //End block
        } //End block
String[] var484DB913905DBB36FE22333D6D2ECB57_215058226 =         ifaces.toArray(new String[ifaces.size()]);
        var484DB913905DBB36FE22333D6D2ECB57_215058226.addTaint(taint);
        return var484DB913905DBB36FE22333D6D2ECB57_215058226;
        // ---------- Original Method ----------
        //final HashSet<String> ifaces = new HashSet<String>();
        //for (String iface : this.iface) {
            //if (iface != IFACE_ALL) {
                //ifaces.add(iface);
            //}
        //}
        //return ifaces.toArray(new String[ifaces.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.731 -0400", hash_original_method = "C948A3950E5BB6DBF87B62BBDA0B02C8", hash_generated_method = "D9A4F868D43D5A7ACA7ED623C900064E")
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
        int[] varB4A88417B3D0170D754C647C30B7216A_1577701381 = (result);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2131975255 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2131975255;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.731 -0400", hash_original_method = "277B11F09A23B8E4B361A93BBF3584B2", hash_generated_method = "7D5BA26906828F60A5647FFD67D17B74")
    public long getTotalBytes() {
        final Entry entry = getTotal(null);
        long var5F00EEE8FA7A451FA9CFD5EB43AD8755_375569865 = (entry.rxBytes + entry.txBytes);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_474012289 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_474012289;
        // ---------- Original Method ----------
        //final Entry entry = getTotal(null);
        //return entry.rxBytes + entry.txBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.731 -0400", hash_original_method = "4A2B09728CEDE32F9C68EF92F6D5889E", hash_generated_method = "C44D62F1D9EFBCA20E3242767F625C66")
    public Entry getTotal(Entry recycle) {
        addTaint(recycle.getTaint());
Entry var493E61FE716DA417C48A4E79249E8995_1798714078 =         getTotal(recycle, null, UID_ALL);
        var493E61FE716DA417C48A4E79249E8995_1798714078.addTaint(taint);
        return var493E61FE716DA417C48A4E79249E8995_1798714078;
        // ---------- Original Method ----------
        //return getTotal(recycle, null, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.731 -0400", hash_original_method = "D5D19E4CD939B7A0BD1C3BDE2A399415", hash_generated_method = "CB946A84E99512970757F6C5029C39F2")
    public Entry getTotal(Entry recycle, int limitUid) {
        addTaint(limitUid);
        addTaint(recycle.getTaint());
Entry varD401B5235C2DDA22F88678CB02EE769D_1638227540 =         getTotal(recycle, null, limitUid);
        varD401B5235C2DDA22F88678CB02EE769D_1638227540.addTaint(taint);
        return varD401B5235C2DDA22F88678CB02EE769D_1638227540;
        // ---------- Original Method ----------
        //return getTotal(recycle, null, limitUid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.731 -0400", hash_original_method = "A8C67127F98A8F27D6DD2D10C54926B1", hash_generated_method = "85A502D33C0BDD1E37B2984081008B63")
    public Entry getTotal(Entry recycle, HashSet<String> limitIface) {
        addTaint(limitIface.getTaint());
        addTaint(recycle.getTaint());
Entry varDBE85A58A348CABDD8A8D13467B29A3C_1592539253 =         getTotal(recycle, limitIface, UID_ALL);
        varDBE85A58A348CABDD8A8D13467B29A3C_1592539253.addTaint(taint);
        return varDBE85A58A348CABDD8A8D13467B29A3C_1592539253;
        // ---------- Original Method ----------
        //return getTotal(recycle, limitIface, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.732 -0400", hash_original_method = "7B779B0B251D8F12031ECAB7F83EFE1D", hash_generated_method = "1C2C5B14F72F87EE7CDB7CCD880FEC19")
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
Entry varF26DBE38545460D6F6AE1D948FF53869_344623135 =         entry;
        varF26DBE38545460D6F6AE1D948FF53869_344623135.addTaint(taint);
        return varF26DBE38545460D6F6AE1D948FF53869_344623135;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.732 -0400", hash_original_method = "0B77BD3659EBAD0CA6247F62089B29FF", hash_generated_method = "F7DAF40F668B216D0986C77A448917E2")
    public NetworkStats subtract(NetworkStats value) throws NonMonotonicException {
        addTaint(value.getTaint());
NetworkStats var0C2F4E324A8788B9E3A075272F2B5127_1992840547 =         subtract(value, false);
        var0C2F4E324A8788B9E3A075272F2B5127_1992840547.addTaint(taint);
        return var0C2F4E324A8788B9E3A075272F2B5127_1992840547;
        // ---------- Original Method ----------
        //return subtract(value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.734 -0400", hash_original_method = "04678C1B7F1434E233D6434823B40504", hash_generated_method = "A8F80CC86E8ADF8692E0BD20831E7489")
    public NetworkStats subtract(NetworkStats value, boolean clampNonMonotonic) throws NonMonotonicException {
        addTaint(clampNonMonotonic);
        final long deltaRealtime = this.elapsedRealtime - value.elapsedRealtime;
        if(deltaRealtime < 0)        
        {
            NonMonotonicException varD5AC2DE5227BC8E2D6AEAB31174541EB_1849230116 = new NonMonotonicException(this, value);
            varD5AC2DE5227BC8E2D6AEAB31174541EB_1849230116.addTaint(taint);
            throw varD5AC2DE5227BC8E2D6AEAB31174541EB_1849230116;
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
                        NonMonotonicException var5309FB994A6EB96BD7E067C5C85ECF05_1703051624 = new NonMonotonicException(this, i, value, j);
                        var5309FB994A6EB96BD7E067C5C85ECF05_1703051624.addTaint(taint);
                        throw var5309FB994A6EB96BD7E067C5C85ECF05_1703051624;
                    } //End block
                } //End block
            } //End block
            result.addValues(entry);
        } //End block
NetworkStats varDC838461EE2FA0CA4C9BBB70A15456B0_197590020 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_197590020.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_197590020;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.735 -0400", hash_original_method = "AB3FDA05B945C3AC93E7C4BBCBA41D8F", hash_generated_method = "4195756E96CC17FAF133ED6ABF3B27C8")
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
NetworkStats var6199C0EAA905687345ED5A344094841F_733985830 =         stats;
        var6199C0EAA905687345ED5A344094841F_733985830.addTaint(taint);
        return var6199C0EAA905687345ED5A344094841F_733985830;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.735 -0400", hash_original_method = "F7B5ADC030AABE070FE0AF3D1DEEC4FF", hash_generated_method = "F5A6BDA450A83C3C478BFE2A734AF4EF")
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
NetworkStats var6199C0EAA905687345ED5A344094841F_2134559357 =         stats;
        var6199C0EAA905687345ED5A344094841F_2134559357.addTaint(taint);
        return var6199C0EAA905687345ED5A344094841F_2134559357;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.736 -0400", hash_original_method = "9245ED01B44F4BC6EDE26C84298E681C", hash_generated_method = "91A799CE87094862D6D1D135C516EA12")
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
NetworkStats var6199C0EAA905687345ED5A344094841F_588085470 =         stats;
        var6199C0EAA905687345ED5A344094841F_588085470.addTaint(taint);
        return var6199C0EAA905687345ED5A344094841F_588085470;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.736 -0400", hash_original_method = "130412F853181F3DE6D8909F69FBB580", hash_generated_method = "AE1D0777D9E9FC3AFE4E7C66343A4282")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.736 -0400", hash_original_method = "C185C780AB6AF420802BBBCB2A0DA03E", hash_generated_method = "5C4716C8E6F915D3C78C48CD86433CD0")
    @Override
    public String toString() {
        final CharArrayWriter writer = new CharArrayWriter();
        dump("", new PrintWriter(writer));
String varEF986DCEFABA18330D92CD8C42EF636E_1806157433 =         writer.toString();
        varEF986DCEFABA18330D92CD8C42EF636E_1806157433.addTaint(taint);
        return varEF986DCEFABA18330D92CD8C42EF636E_1806157433;
        // ---------- Original Method ----------
        //final CharArrayWriter writer = new CharArrayWriter();
        //dump("", new PrintWriter(writer));
        //return writer.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.737 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E275360E32AD0728C1628AE58AE991AD")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_380340396 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414005391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414005391;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "7E57670F7C5530F50680411F8B75B179", hash_generated_field = "C6A1018CA8BDAC723763D450E0753839")

        public String iface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "76DD25E4462280D67562778690A1B8EC")

        public int set;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "9910EB628EC91FE06D2639B0F3810F0E")

        public long rxBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "6ADCDCD12FD7D35118980BC0BB165142")

        public long rxPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "676F2C3D88E440A0E185A42A7F55CF74")

        public long txBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "B93ED690B1DA86F6CE26308A7104AEFF")

        public long txPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "49E564B98B6E0E4454081C4D76AD6B00")

        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.744 -0400", hash_original_method = "CF147DC846E9FA9CFBACF54E998579AF", hash_generated_method = "F7D90DFA18CB5A7447228376F168D3F6")
        public  Entry() {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.745 -0400", hash_original_method = "E97E61BD38788E206E16E3AF28EF9986", hash_generated_method = "B08DA8B165AB7B27AB5B1782BDE7ACB8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.745 -0400", hash_original_method = "08CED58FDA8ADE41E7B2EE03A16F55F8", hash_generated_method = "CB3E6C63FCCA7D2DBA6EB60EBBF0511C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.745 -0400", hash_original_method = "8BA58A1912534045F7A50ACBC1B00F2F", hash_generated_method = "67509452FC6D26B8B15ED2F4DB122895")
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
String varF4CF030572656354ACFDF83FEE21D7A6_2085410194 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_2085410194.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_2085410194;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.746 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "181F8009619333E411770D3E70DC8370")

        public NetworkStats left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.746 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "B505F3F155C5E8A912533BF2967190B7")

        public NetworkStats right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.746 -0400", hash_original_field = "EDC10311D3D1494F1306BBAB7BF69CB3", hash_generated_field = "217C8C9F8012EB7818E9531FC30FEF27")

        public int leftIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.746 -0400", hash_original_field = "415E97ED95AF01CA0C988761665551CF", hash_generated_field = "4A28DC3C7ADE86B25DA19F4A8CD04779")

        public int rightIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.746 -0400", hash_original_method = "0F470ECE148C3E2C73ACB1D4F54D342F", hash_generated_method = "9FE4896904204EFF85AFE87A9F696C67")
        public  NonMonotonicException(NetworkStats left, NetworkStats right) {
            this(left, -1, right, -1);
            addTaint(right.getTaint());
            addTaint(left.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.746 -0400", hash_original_method = "F441B58E88456542B2E0F8A35978B48D", hash_generated_method = "B509B564F3FB6D5E27CAC23B156AB149")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "0639DD17ED95F786B1E5DE96AA9666BE", hash_generated_field = "9745DE468315B8EBA198D1500BBA5367")

    private static final String TAG = "NetworkStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "25C863106C3C42528AA01F74D73EE92C", hash_generated_field = "4B5E58BD186965CA0BD1A5ED0A9A7F54")

    public static final String IFACE_ALL = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "F9E949847731C6743751DD9799931E92", hash_generated_field = "FC1870BB9E6A348A548B826696AEFBDA")

    public static final int UID_ALL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "0737CE9FB392DCEABDB96A70642A9F24", hash_generated_field = "FB67A78888DCA694CC62A7659E04AD25")

    public static final int SET_ALL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "C4E5DCEC3CBDD6E317570BE4FB03D395", hash_generated_field = "095B691962D2E94BB7EAA2D948D7C96E")

    public static final int SET_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "02F04EDD54119AF3CF408766007CDBDB", hash_generated_field = "31A399D29DE8B7B547B04EAE8CD8FC9F")

    public static final int SET_FOREGROUND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "82356421805D7AEB1E16F8592C5B892F", hash_generated_field = "07CC6589E9BD2DFCEE5DD80A37C03CC4")

    public static final int TAG_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "3469CD7C405D7C574C3592A9EE21FD10", hash_generated_field = "C59D2B9A15468765CA55EEA88C603BE5")

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

