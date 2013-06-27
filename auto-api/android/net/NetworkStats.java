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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.067 -0400", hash_original_field = "90F9860F2ACD6C63E4929F387936CB9F", hash_generated_field = "538680F69DE637447E0D8142F5C87404")

    private long elapsedRealtime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "7E57670F7C5530F50680411F8B75B179", hash_generated_field = "AEC0BBDA5208AC6967DEC78EF15071F3")

    private String[] iface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "A8AC2BB90C17959AB4283F941009C346")

    private int[] uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "A4E4C55D8B662E9B726E86B8916906DE")

    private int[] set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "2F0D3812A3BBA96458EDF1EF87423C61")

    private int[] tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "835A90EA79ED43E63CD1F8551E1170AC")

    private long[] rxBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "3C8EA21CAE3964AFEC5D5287345DF52F")

    private long[] rxPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.076 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "5D0307CD93ADE4DF2FD18B8CD5214177")

    private long[] txBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.077 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "EF80B3F02FF3FE9875FC49D478831ABF")

    private long[] txPackets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.077 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "D54D9A650B72A41B61249C2CA8E210FC")

    private long[] operations;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.098 -0400", hash_original_method = "2A398CA499F31285985E41F8490B2A34", hash_generated_method = "380CA970FE12D5BD2BAF01BBA1D2FCB2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.111 -0400", hash_original_method = "D90F7AB3E4E138FF177FEBA052B61E8A", hash_generated_method = "C3D36E03FA24329D94C1862F8554454A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.126 -0400", hash_original_method = "747F845D1C1DAB9F1E978429A723A0B0", hash_generated_method = "47F8FC7BB28866F7EAA7D2E17BF43E8D")
    public void writeToParcel(Parcel dest, int flags) {
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
        addTaint(dest.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.127 -0400", hash_original_method = "2B258B3B735A82A55EB3270F9E3A7FB6", hash_generated_method = "3813E3628BBB65986713A479461A45F7")
    @Override
    public NetworkStats clone() {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_1965067734 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1965067734 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1965067734.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1965067734;
        // ---------- Original Method ----------
        //final NetworkStats clone = new NetworkStats(elapsedRealtime, size);
        //NetworkStats.Entry entry = null;
        //for (int i = 0; i < size; i++) {
            //entry = getValues(i, entry);
            //clone.addValues(entry);
        //}
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.139 -0400", hash_original_method = "C4F6601144FE185F7636CD51AD058501", hash_generated_method = "6070F42F48E747AC7ADDDCCA9DA2B583")
    public NetworkStats addIfaceValues(
            String iface, long rxBytes, long rxPackets, long txBytes, long txPackets) {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_1757137558 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1757137558 = addValues(
                iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
        addTaint(iface.getTaint());
        addTaint(rxBytes);
        addTaint(rxPackets);
        addTaint(txBytes);
        addTaint(txPackets);
        varB4EAC82CA7396A68D541C85D26508E83_1757137558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757137558;
        // ---------- Original Method ----------
        //return addValues(
                //iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.140 -0400", hash_original_method = "F572451A01AB0326B364A96213456AFC", hash_generated_method = "EA3BB345095A1A5B04C491EAF892877D")
    public NetworkStats addValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_2138111438 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2138111438 = addValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        addTaint(iface.getTaint());
        addTaint(uid);
        addTaint(set);
        addTaint(tag);
        addTaint(rxBytes);
        addTaint(rxPackets);
        addTaint(txBytes);
        addTaint(txPackets);
        addTaint(operations);
        varB4EAC82CA7396A68D541C85D26508E83_2138111438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2138111438;
        // ---------- Original Method ----------
        //return addValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.167 -0400", hash_original_method = "BA5E7818DCBE1852CDC81090E5B13339", hash_generated_method = "E005AE0A30DA327CBFC105E0397F3D92")
    public NetworkStats addValues(Entry entry) {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_329288953 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_329288953 = this;
        varB4EAC82CA7396A68D541C85D26508E83_329288953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_329288953;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.197 -0400", hash_original_method = "784A932AD4193748EF13A1422BBA3C89", hash_generated_method = "89BB778DBFD1A016CC5829263F119392")
    public Entry getValues(int i, Entry recycle) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_443071301 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_443071301 = entry;
        addTaint(recycle.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_443071301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443071301;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.198 -0400", hash_original_method = "F3360ADB8E6D37C5AD6714A1DBEA3C2C", hash_generated_method = "CAE6D5CEEF0002EF0DF2D45F8BE2C808")
    public long getElapsedRealtime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1755624424 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1755624424;
        // ---------- Original Method ----------
        //return elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.198 -0400", hash_original_method = "A28F8D44EDD8B5977D1B4B03F62008BC", hash_generated_method = "B11860A0CB113244B158A0B88C66E192")
    public long getElapsedRealtimeAge() {
        long var31F8EE92B793C7898ABD2D03A99BDBC1_1535666591 = (SystemClock.elapsedRealtime() - elapsedRealtime);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1510956217 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1510956217;
        // ---------- Original Method ----------
        //return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.199 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "F8C89B4DE6B518A73DD0C98E75329CBF")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512651656 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512651656;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.201 -0400", hash_original_method = "2B99B673BBD8E75B3053CAA25E99CAA5", hash_generated_method = "828D027857DE5B5AB91E22CB91CC8E3A")
    public int internalSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344324941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344324941;
        // ---------- Original Method ----------
        //return iface.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.219 -0400", hash_original_method = "60A49D4C2C28DC0F7F89BE32E32B8D66", hash_generated_method = "518570929A861C099E4465A1FE2DCF0D")
    @Deprecated
    public NetworkStats combineValues(String iface, int uid, int tag, long rxBytes, long rxPackets,
            long txBytes, long txPackets, long operations) {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_597362324 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_597362324 = combineValues(
                iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
        addTaint(iface.getTaint());
        addTaint(uid);
        addTaint(tag);
        addTaint(rxBytes);
        addTaint(rxPackets);
        addTaint(txBytes);
        addTaint(txPackets);
        addTaint(operations);
        varB4EAC82CA7396A68D541C85D26508E83_597362324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_597362324;
        // ---------- Original Method ----------
        //return combineValues(
                //iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.221 -0400", hash_original_method = "F71B507E3E7A764789F38FD5530E9585", hash_generated_method = "EE4D916AEB41C8AC23DC4272203895A6")
    public NetworkStats combineValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_277424524 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_277424524 = combineValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
        addTaint(iface.getTaint());
        addTaint(uid);
        addTaint(set);
        addTaint(tag);
        addTaint(rxBytes);
        addTaint(rxPackets);
        addTaint(txBytes);
        addTaint(txPackets);
        addTaint(operations);
        varB4EAC82CA7396A68D541C85D26508E83_277424524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_277424524;
        // ---------- Original Method ----------
        //return combineValues(new Entry(
                //iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.230 -0400", hash_original_method = "49582C07F79A6507E237CBEC2438E36C", hash_generated_method = "516BDEE0EF04E5B32289AD00426D4D01")
    public NetworkStats combineValues(Entry entry) {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_882881281 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_882881281 = this;
        varB4EAC82CA7396A68D541C85D26508E83_882881281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_882881281;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.235 -0400", hash_original_method = "0A31FFFE210F2775172111CD7E8C7EC0", hash_generated_method = "3112DD2EA208F3FBD0D56BA3A60CBD17")
    public void combineAllValues(NetworkStats another) {
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
        addTaint(another.getTaint());
        // ---------- Original Method ----------
        //NetworkStats.Entry entry = null;
        //for (int i = 0; i < another.size; i++) {
            //entry = another.getValues(i, entry);
            //combineValues(entry);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.238 -0400", hash_original_method = "FEC91070502C1195B6460B4D97DFCE73", hash_generated_method = "1BEB609D9CF31B5F11689661707D45C9")
    public int findIndex(String iface, int uid, int set, int tag) {
        {
            int i;
            i = 0;
            {
                {
                    boolean var7F51CCC0D3B646294AFFFFFDFF3BBE72_717721512 = (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(iface.getTaint());
        addTaint(uid);
        addTaint(set);
        addTaint(tag);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534242146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534242146;
        // ---------- Original Method ----------
        //for (int i = 0; i < size; i++) {
            //if (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    //&& Objects.equal(iface, this.iface[i])) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.250 -0400", hash_original_method = "09F077C80C4F986B6C39E3E7ABC587EB", hash_generated_method = "86A50070A94B9A2C643E1575ECEE2175")
    public int findIndexHinted(String iface, int uid, int set, int tag, int hintIndex) {
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
                    boolean var7F51CCC0D3B646294AFFFFFDFF3BBE72_1898339193 = (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(iface.getTaint());
        addTaint(uid);
        addTaint(set);
        addTaint(tag);
        addTaint(hintIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_812853119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_812853119;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.261 -0400", hash_original_method = "6E339B821B6FB4996B911B569AAD524F", hash_generated_method = "038A9681AEB7891471EF1151232780EC")
    public void spliceOperationsFrom(NetworkStats stats) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.351 -0400", hash_original_method = "2B2C9B0B02A7A72C63A74815DF58D4A4", hash_generated_method = "32BED2510B475FC4FF8EA340296CF875")
    public String[] getUniqueIfaces() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1550269811 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1550269811 = ifaces.toArray(new String[ifaces.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1550269811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1550269811;
        // ---------- Original Method ----------
        //final HashSet<String> ifaces = new HashSet<String>();
        //for (String iface : this.iface) {
            //if (iface != IFACE_ALL) {
                //ifaces.add(iface);
            //}
        //}
        //return ifaces.toArray(new String[ifaces.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.417 -0400", hash_original_method = "C948A3950E5BB6DBF87B62BBDA0B02C8", hash_generated_method = "DE76713D1DBDAB69487793DAFA1D88D7")
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
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1959398012 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1959398012;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.424 -0400", hash_original_method = "277B11F09A23B8E4B361A93BBF3584B2", hash_generated_method = "032CB31C15B056EDA00F68457CADB566")
    public long getTotalBytes() {
        Entry entry;
        entry = getTotal(null);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_691508824 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_691508824;
        // ---------- Original Method ----------
        //final Entry entry = getTotal(null);
        //return entry.rxBytes + entry.txBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.425 -0400", hash_original_method = "4A2B09728CEDE32F9C68EF92F6D5889E", hash_generated_method = "81E2C24AFDF1D97CCE983D772248FB18")
    public Entry getTotal(Entry recycle) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_156793345 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_156793345 = getTotal(recycle, null, UID_ALL);
        addTaint(recycle.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_156793345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_156793345;
        // ---------- Original Method ----------
        //return getTotal(recycle, null, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.426 -0400", hash_original_method = "D5D19E4CD939B7A0BD1C3BDE2A399415", hash_generated_method = "652B595E5B8481DE1ACA63223FCCE7B6")
    public Entry getTotal(Entry recycle, int limitUid) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_136711211 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_136711211 = getTotal(recycle, null, limitUid);
        addTaint(recycle.getTaint());
        addTaint(limitUid);
        varB4EAC82CA7396A68D541C85D26508E83_136711211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_136711211;
        // ---------- Original Method ----------
        //return getTotal(recycle, null, limitUid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.438 -0400", hash_original_method = "A8C67127F98A8F27D6DD2D10C54926B1", hash_generated_method = "ED4A13918ADBDAD3EE5807C42913EAC4")
    public Entry getTotal(Entry recycle, HashSet<String> limitIface) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_1125898213 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1125898213 = getTotal(recycle, limitIface, UID_ALL);
        addTaint(recycle.getTaint());
        addTaint(limitIface.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1125898213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1125898213;
        // ---------- Original Method ----------
        //return getTotal(recycle, limitIface, UID_ALL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.463 -0400", hash_original_method = "7B779B0B251D8F12031ECAB7F83EFE1D", hash_generated_method = "FABF8C248D0507F615114BCFAAEAD371")
    private Entry getTotal(Entry recycle, HashSet<String> limitIface, int limitUid) {
        Entry varB4EAC82CA7396A68D541C85D26508E83_367334795 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_367334795 = entry;
        addTaint(recycle.getTaint());
        addTaint(limitIface.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_367334795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_367334795;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.464 -0400", hash_original_method = "0B77BD3659EBAD0CA6247F62089B29FF", hash_generated_method = "F012C7720E0524D0CE6E4CFCCFF82199")
    public NetworkStats subtract(NetworkStats value) throws NonMonotonicException {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_1921314995 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1921314995 = subtract(value, false);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1921314995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1921314995;
        // ---------- Original Method ----------
        //return subtract(value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.509 -0400", hash_original_method = "04678C1B7F1434E233D6434823B40504", hash_generated_method = "F44790E582D53ACF22D5E6986D329D49")
    public NetworkStats subtract(NetworkStats value, boolean clampNonMonotonic) throws NonMonotonicException {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_1304232649 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1304232649 = result;
        addTaint(clampNonMonotonic);
        varB4EAC82CA7396A68D541C85D26508E83_1304232649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1304232649;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.524 -0400", hash_original_method = "AB3FDA05B945C3AC93E7C4BBCBA41D8F", hash_generated_method = "B079CADD79959AA2B3476889250C4C07")
    public NetworkStats groupedByIface() {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_1513083764 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1513083764 = stats;
        varB4EAC82CA7396A68D541C85D26508E83_1513083764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513083764;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.528 -0400", hash_original_method = "F7B5ADC030AABE070FE0AF3D1DEEC4FF", hash_generated_method = "28C702633C256654DC7FF8E812F74708")
    public NetworkStats groupedByUid() {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_605308168 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_605308168 = stats;
        varB4EAC82CA7396A68D541C85D26508E83_605308168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605308168;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.551 -0400", hash_original_method = "9245ED01B44F4BC6EDE26C84298E681C", hash_generated_method = "E0AFAB4662EC900549F95149273F243D")
    public NetworkStats withoutUid(int uid) {
        NetworkStats varB4EAC82CA7396A68D541C85D26508E83_1184544151 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1184544151 = stats;
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_1184544151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1184544151;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.587 -0400", hash_original_method = "130412F853181F3DE6D8909F69FBB580", hash_generated_method = "52B99245D5EA75600EEAEE844F5BABB9")
    public void dump(String prefix, PrintWriter pw) {
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
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.591 -0400", hash_original_method = "C185C780AB6AF420802BBBCB2A0DA03E", hash_generated_method = "65FA3D4AAE5AE55203FCAED1B3AE6857")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_514212439 = null; //Variable for return #1
        CharArrayWriter writer;
        writer = new CharArrayWriter();
        dump("", new PrintWriter(writer));
        varB4EAC82CA7396A68D541C85D26508E83_514212439 = writer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_514212439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514212439;
        // ---------- Original Method ----------
        //final CharArrayWriter writer = new CharArrayWriter();
        //dump("", new PrintWriter(writer));
        //return writer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D11781F33E93BEF7C3ECC416584338A2")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635125707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635125707;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "7E57670F7C5530F50680411F8B75B179", hash_generated_field = "C6A1018CA8BDAC723763D450E0753839")

        public String iface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "CDAEEEBA9B4A4C5EBF042C0215A7BB0E", hash_generated_field = "76DD25E4462280D67562778690A1B8EC")

        public int set;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "B6C66C301D9A41BFFA09DE8416AC0EB7", hash_generated_field = "9910EB628EC91FE06D2639B0F3810F0E")

        public long rxBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "F1876308DC8F8BD4B1FE1A653E15797D", hash_generated_field = "6ADCDCD12FD7D35118980BC0BB165142")

        public long rxPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "AFC5149AF5D00A08837312CCE47928A6", hash_generated_field = "676F2C3D88E440A0E185A42A7F55CF74")

        public long txBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "E68FE7817AEE0AB2E8FE969D1D244A2E", hash_generated_field = "B93ED690B1DA86F6CE26308A7104AEFF")

        public long txPackets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.592 -0400", hash_original_field = "BA19A09A68A66F8AD972EF8A5FBA6F0D", hash_generated_field = "49E564B98B6E0E4454081C4D76AD6B00")

        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.593 -0400", hash_original_method = "CF147DC846E9FA9CFBACF54E998579AF", hash_generated_method = "F7D90DFA18CB5A7447228376F168D3F6")
        public  Entry() {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.594 -0400", hash_original_method = "E97E61BD38788E206E16E3AF28EF9986", hash_generated_method = "14B782EAEEB44BE2CD32F668CE8856E8")
        public  Entry(long rxBytes, long rxPackets, long txBytes, long txPackets, long operations) {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets,
                    operations);
            addTaint(rxBytes);
            addTaint(rxPackets);
            addTaint(txBytes);
            addTaint(txPackets);
            addTaint(operations);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.596 -0400", hash_original_method = "08CED58FDA8ADE41E7B2EE03A16F55F8", hash_generated_method = "CB3E6C63FCCA7D2DBA6EB60EBBF0511C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.620 -0400", hash_original_method = "8BA58A1912534045F7A50ACBC1B00F2F", hash_generated_method = "E006892FBC3BA193C9C93B518A2918F9")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1071842113 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1071842113 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1071842113.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1071842113;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.621 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "181F8009619333E411770D3E70DC8370")

        public NetworkStats left;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.621 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "B505F3F155C5E8A912533BF2967190B7")

        public NetworkStats right;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.621 -0400", hash_original_field = "EDC10311D3D1494F1306BBAB7BF69CB3", hash_generated_field = "217C8C9F8012EB7818E9531FC30FEF27")

        public int leftIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.621 -0400", hash_original_field = "415E97ED95AF01CA0C988761665551CF", hash_generated_field = "4A28DC3C7ADE86B25DA19F4A8CD04779")

        public int rightIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.622 -0400", hash_original_method = "0F470ECE148C3E2C73ACB1D4F54D342F", hash_generated_method = "915A2A476B8047E8908F46F1F5899201")
        public  NonMonotonicException(NetworkStats left, NetworkStats right) {
            this(left, -1, right, -1);
            addTaint(left.getTaint());
            addTaint(right.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.641 -0400", hash_original_method = "F441B58E88456542B2E0F8A35978B48D", hash_generated_method = "B509B564F3FB6D5E27CAC23B156AB149")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.641 -0400", hash_original_field = "0639DD17ED95F786B1E5DE96AA9666BE", hash_generated_field = "42ADC32975F752C4B243FA2D3145C5EB")

    private static String TAG = "NetworkStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.641 -0400", hash_original_field = "25C863106C3C42528AA01F74D73EE92C", hash_generated_field = "4B5E58BD186965CA0BD1A5ED0A9A7F54")

    public static final String IFACE_ALL = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.641 -0400", hash_original_field = "F9E949847731C6743751DD9799931E92", hash_generated_field = "FC1870BB9E6A348A548B826696AEFBDA")

    public static final int UID_ALL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.641 -0400", hash_original_field = "0737CE9FB392DCEABDB96A70642A9F24", hash_generated_field = "FB67A78888DCA694CC62A7659E04AD25")

    public static final int SET_ALL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.642 -0400", hash_original_field = "C4E5DCEC3CBDD6E317570BE4FB03D395", hash_generated_field = "095B691962D2E94BB7EAA2D948D7C96E")

    public static final int SET_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.642 -0400", hash_original_field = "02F04EDD54119AF3CF408766007CDBDB", hash_generated_field = "31A399D29DE8B7B547B04EAE8CD8FC9F")

    public static final int SET_FOREGROUND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.642 -0400", hash_original_field = "82356421805D7AEB1E16F8592C5B892F", hash_generated_field = "07CC6589E9BD2DFCEE5DD80A37C03CC4")

    public static final int TAG_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.642 -0400", hash_original_field = "3469CD7C405D7C574C3592A9EE21FD10", hash_generated_field = "C59D2B9A15468765CA55EEA88C603BE5")

    public static final Creator<NetworkStats> CREATOR = new Creator<NetworkStats>() {
        public NetworkStats createFromParcel(Parcel in) {
            return new NetworkStats(in);
        }

        public NetworkStats[] newArray(int size) {
            return new NetworkStats[size];
        }
    };
}

