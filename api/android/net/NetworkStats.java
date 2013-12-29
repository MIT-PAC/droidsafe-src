package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.util.Preconditions.checkNotNull;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseBooleanArray;

import com.android.internal.util.Objects;






public class NetworkStats implements Parcelable {

    /**
     * Return text description of {@link #set} value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.538 -0500", hash_original_method = "B2A79BC64162852AEFB2830FF939E603", hash_generated_method = "908C849D83A79606917F659C7F78B7EE")
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

    /**
     * Return text description of {@link #tag} value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.539 -0500", hash_original_method = "DC4BF8E8A8AEC1891BB1B278A71C59F9", hash_generated_method = "6354A0C3623620729DF5D191D7AF20FC")
    public static String tagToString(int tag) {
        return "0x" + Integer.toHexString(tag);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.483 -0500", hash_original_field = "2AC73C7EAF071C54F2A23739B52E87F1", hash_generated_field = "9745DE468315B8EBA198D1500BBA5367")

    private static final String TAG = "NetworkStats";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.484 -0500", hash_original_field = "404639DC173A09A7FBED2433749F7C2E", hash_generated_field = "4B5E58BD186965CA0BD1A5ED0A9A7F54")

    public static final String IFACE_ALL = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.485 -0500", hash_original_field = "0D0F163E3491D0BC683EDC4C6516235F", hash_generated_field = "FC1870BB9E6A348A548B826696AEFBDA")

    public static final int UID_ALL = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.486 -0500", hash_original_field = "22E5FD306DDF161E2350F8D3DF555C73", hash_generated_field = "FB67A78888DCA694CC62A7659E04AD25")

    public static final int SET_ALL = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.487 -0500", hash_original_field = "689C550717A0C4670522DB95C78C302D", hash_generated_field = "095B691962D2E94BB7EAA2D948D7C96E")

    public static final int SET_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.488 -0500", hash_original_field = "B6C6605044BAE6C78385E0C0A72C50F6", hash_generated_field = "31A399D29DE8B7B547B04EAE8CD8FC9F")

    public static final int SET_FOREGROUND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.489 -0500", hash_original_field = "BBE76D7BD086455B567E510957A4C953", hash_generated_field = "07CC6589E9BD2DFCEE5DD80A37C03CC4")

    public static final int TAG_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.747 -0400", hash_original_field = "3469CD7C405D7C574C3592A9EE21FD10", hash_generated_field = "C59D2B9A15468765CA55EEA88C603BE5")

    public static final Creator<NetworkStats> CREATOR = new Creator<NetworkStats>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.542 -0500", hash_original_method = "76D9386453B9839BC68D96B3471291B7", hash_generated_method = "D3DCBA29DA323F34F5817304F63B47E7")
        public NetworkStats createFromParcel(Parcel in) {
            return new NetworkStats(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.543 -0500", hash_original_method = "6BCBF9A9B4039336956D31ACA3A9B0D4", hash_generated_method = "67FC0E227A2E3CE9DE815B59499C4E46")
        public NetworkStats[] newArray(int size) {
            return new NetworkStats[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:36:29.656 -0500", hash_original_field = "5B0A3D652BDC2FD591B15386E0FCB7E2", hash_generated_field = "56C3E2E054463240176F9B0485425365")


    /**
     * {@link SystemClock#elapsedRealtime()} timestamp when this data was
     * generated.
     */
    private  long elapsedRealtime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.490 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.491 -0500", hash_original_field = "D337F6044260646D054FCD50E1BC8B52", hash_generated_field = "AEC0BBDA5208AC6967DEC78EF15071F3")

    private String[] iface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.491 -0500", hash_original_field = "1A7B23FFB014ECA016AE18CFFF46E432", hash_generated_field = "A8AC2BB90C17959AB4283F941009C346")

    private int[] uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.492 -0500", hash_original_field = "DB26D285FC91EEE2D0E6BFED54D75316", hash_generated_field = "A4E4C55D8B662E9B726E86B8916906DE")

    private int[] set;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.493 -0500", hash_original_field = "5A35962A62491A4607DA805ECACD3373", hash_generated_field = "2F0D3812A3BBA96458EDF1EF87423C61")

    private int[] tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.494 -0500", hash_original_field = "9893AE5B5011F4C111FF1E1121D1EE1A", hash_generated_field = "835A90EA79ED43E63CD1F8551E1170AC")

    private long[] rxBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.494 -0500", hash_original_field = "1EEAC5F67B0C0397B12BAA122D9CE375", hash_generated_field = "3C8EA21CAE3964AFEC5D5287345DF52F")

    private long[] rxPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.495 -0500", hash_original_field = "7EB3547101C7AE6FD35B1A5788B55AAA", hash_generated_field = "5D0307CD93ADE4DF2FD18B8CD5214177")

    private long[] txBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.496 -0500", hash_original_field = "DCB918F8ED4E0C4902349C83FFA4A730", hash_generated_field = "EF80B3F02FF3FE9875FC49D478831ABF")

    private long[] txPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.496 -0500", hash_original_field = "8AF963FC77FD634807CAA8B9D5879BA6", hash_generated_field = "D54D9A650B72A41B61249C2CA8E210FC")

    private long[] operations;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.510 -0500", hash_original_method = "2A398CA499F31285985E41F8490B2A34", hash_generated_method = "73CE94A06FF194C4FE2A02043AF811F3")
    public NetworkStats(long elapsedRealtime, int initialSize) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.511 -0500", hash_original_method = "D90F7AB3E4E138FF177FEBA052B61E8A", hash_generated_method = "6E69FA019B8FDD524B10B8F9FA95CC5C")
    public NetworkStats(Parcel parcel) {
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
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.512 -0500", hash_original_method = "747F845D1C1DAB9F1E978429A723A0B0", hash_generated_method = "09EE94B25AC37EE8B17E216A515CC6C1")
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.513 -0500", hash_original_method = "2B258B3B735A82A55EB3270F9E3A7FB6", hash_generated_method = "6B7196F18D140F6BED0A7B5FA9A51B46")
    @Override
public NetworkStats clone() {
        final NetworkStats clone = new NetworkStats(elapsedRealtime, size);
        NetworkStats.Entry entry = null;
        for (int i = 0; i < size; i++) {
            entry = getValues(i, entry);
            clone.addValues(entry);
        }
        return clone;
    }

    // @VisibleForTesting
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.514 -0500", hash_original_method = "C4F6601144FE185F7636CD51AD058501", hash_generated_method = "006106D40D2D5BD3457A1C733B84924F")
    public NetworkStats addIfaceValues(
            String iface, long rxBytes, long rxPackets, long txBytes, long txPackets) {
        return addValues(
                iface, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets, 0L);
    }

    // @VisibleForTesting
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.515 -0500", hash_original_method = "F572451A01AB0326B364A96213456AFC", hash_generated_method = "F6AF731AD01E970F191996A75572B537")
    public NetworkStats addValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        return addValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    /**
     * Add new stats entry, copying from given {@link Entry}. The {@link Entry}
     * object can be recycled across multiple calls.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.516 -0500", hash_original_method = "BA5E7818DCBE1852CDC81090E5B13339", hash_generated_method = "288B55B6BB516F0F91EAFDAFC22F6918")
    public NetworkStats addValues(Entry entry) {
        if (size >= this.iface.length) {
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
        }

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

        return this;
    }

    /**
     * Return specific stats entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.517 -0500", hash_original_method = "784A932AD4193748EF13A1422BBA3C89", hash_generated_method = "AF69D13EC57FDF1B0CF9EFD100296310")
    public Entry getValues(int i, Entry recycle) {
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
        return entry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.518 -0500", hash_original_method = "F3360ADB8E6D37C5AD6714A1DBEA3C2C", hash_generated_method = "F44F4A0B4A98B76DEA0CDE08EBFF4E23")
    public long getElapsedRealtime() {
        return elapsedRealtime;
    }

    /**
     * Return age of this {@link NetworkStats} object with respect to
     * {@link SystemClock#elapsedRealtime()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.518 -0500", hash_original_method = "A28F8D44EDD8B5977D1B4B03F62008BC", hash_generated_method = "B48C6C0687A68BA9FECD7017E68393C1")
    public long getElapsedRealtimeAge() {
        return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.519 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "409DC5F4E827A6799350876AEA63C2E8")
    public int size() {
        return size;
    }

    // @VisibleForTesting
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.520 -0500", hash_original_method = "2B99B673BBD8E75B3053CAA25E99CAA5", hash_generated_method = "44689AD8D164C89B477C67ED7C7C8C9D")
    public int internalSize() {
        return iface.length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.521 -0500", hash_original_method = "60A49D4C2C28DC0F7F89BE32E32B8D66", hash_generated_method = "472803DF910ED63C050746826E2A3338")
    @Deprecated
public NetworkStats combineValues(String iface, int uid, int tag, long rxBytes, long rxPackets,
            long txBytes, long txPackets, long operations) {
        return combineValues(
                iface, uid, SET_DEFAULT, tag, rxBytes, rxPackets, txBytes, txPackets, operations);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.522 -0500", hash_original_method = "F71B507E3E7A764789F38FD5530E9585", hash_generated_method = "CBA5754F06937382DD7D6CE8BD458E5B")
    public NetworkStats combineValues(String iface, int uid, int set, int tag, long rxBytes,
            long rxPackets, long txBytes, long txPackets, long operations) {
        return combineValues(new Entry(
                iface, uid, set, tag, rxBytes, rxPackets, txBytes, txPackets, operations));
    }

    /**
     * Combine given values with an existing row, or create a new row if
     * {@link #findIndex(String, int, int, int)} is unable to find match. Can
     * also be used to subtract values from existing rows.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.522 -0500", hash_original_method = "49582C07F79A6507E237CBEC2438E36C", hash_generated_method = "884FF01485F6364F75622D6E41ECA0D7")
    public NetworkStats combineValues(Entry entry) {
        final int i = findIndex(entry.iface, entry.uid, entry.set, entry.tag);
        if (i == -1) {
            // only create new entry when positive contribution
            addValues(entry);
        } else {
            rxBytes[i] += entry.rxBytes;
            rxPackets[i] += entry.rxPackets;
            txBytes[i] += entry.txBytes;
            txPackets[i] += entry.txPackets;
            operations[i] += entry.operations;
        }
        return this;
    }

    /**
     * Combine all values from another {@link NetworkStats} into this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.523 -0500", hash_original_method = "0A31FFFE210F2775172111CD7E8C7EC0", hash_generated_method = "7A85C84CFEB4DBE6B43C85979CB6FDC6")
    public void combineAllValues(NetworkStats another) {
        NetworkStats.Entry entry = null;
        for (int i = 0; i < another.size; i++) {
            entry = another.getValues(i, entry);
            combineValues(entry);
        }
    }

    /**
     * Find first stats index that matches the requested parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.524 -0500", hash_original_method = "FEC91070502C1195B6460B4D97DFCE73", hash_generated_method = "3A5DAD87284B4DF46B7E9C6D018B6896")
    public int findIndex(String iface, int uid, int set, int tag) {
        for (int i = 0; i < size; i++) {
            if (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find first stats index that matches the requested parameters, starting
     * search around the hinted index as an optimization.
     */
    // @VisibleForTesting
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.525 -0500", hash_original_method = "09F077C80C4F986B6C39E3E7ABC587EB", hash_generated_method = "03B9FE54B5BE01FBC71903D5E97ADE9C")
    public int findIndexHinted(String iface, int uid, int set, int tag, int hintIndex) {
        for (int offset = 0; offset < size; offset++) {
            final int halfOffset = offset / 2;

            // search outwards from hint index, alternating forward and backward
            final int i;
            if (offset % 2 == 0) {
                i = (hintIndex + halfOffset) % size;
            } else {
                i = (size + hintIndex - halfOffset - 1) % size;
            }

            if (uid == this.uid[i] && set == this.set[i] && tag == this.tag[i]
                    && Objects.equal(iface, this.iface[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Splice in {@link #operations} from the given {@link NetworkStats} based
     * on matching {@link #uid} and {@link #tag} rows. Ignores {@link #iface},
     * since operation counts are at data layer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.526 -0500", hash_original_method = "6E339B821B6FB4996B911B569AAD524F", hash_generated_method = "7ABADB16EDA0116423A78ECE932E1BB1")
    public void spliceOperationsFrom(NetworkStats stats) {
        for (int i = 0; i < size; i++) {
            final int j = stats.findIndex(IFACE_ALL, uid[i], set[i], tag[i]);
            if (j == -1) {
                operations[i] = 0;
            } else {
                operations[i] = stats.operations[j];
            }
        }
    }

    /**
     * Return list of unique interfaces known by this data structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.527 -0500", hash_original_method = "2B2C9B0B02A7A72C63A74815DF58D4A4", hash_generated_method = "D0A684448F4A184041D52DC630E31C37")
    public String[] getUniqueIfaces() {
        final HashSet<String> ifaces = new HashSet<String>();
        for (String iface : this.iface) {
            if (iface != IFACE_ALL) {
                ifaces.add(iface);
            }
        }
        return ifaces.toArray(new String[ifaces.size()]);
    }

    /**
     * Return list of unique UIDs known by this data structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.528 -0500", hash_original_method = "C948A3950E5BB6DBF87B62BBDA0B02C8", hash_generated_method = "289700DCF7DEB1D4337A3D8DA5CF897C")
    public int[] getUniqueUids() {
        final SparseBooleanArray uids = new SparseBooleanArray();
        for (int uid : this.uid) {
            uids.put(uid, true);
        }

        final int size = uids.size();
        final int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = uids.keyAt(i);
        }
        return result;
    }

    /**
     * Return total bytes represented by this snapshot object, usually used when
     * checking if a {@link #subtract(NetworkStats)} delta passes a threshold.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.528 -0500", hash_original_method = "277B11F09A23B8E4B361A93BBF3584B2", hash_generated_method = "EA48C6FAC9BD27129C25513C89F6565F")
    public long getTotalBytes() {
        final Entry entry = getTotal(null);
        return entry.rxBytes + entry.txBytes;
    }

    /**
     * Return total of all fields represented by this snapshot object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.529 -0500", hash_original_method = "4A2B09728CEDE32F9C68EF92F6D5889E", hash_generated_method = "869DB3EF9E35C7E9920840E0A8019642")
    public Entry getTotal(Entry recycle) {
        return getTotal(recycle, null, UID_ALL);
    }

    /**
     * Return total of all fields represented by this snapshot object matching
     * the requested {@link #uid}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.530 -0500", hash_original_method = "D5D19E4CD939B7A0BD1C3BDE2A399415", hash_generated_method = "D2B349F25FBFFE363A895C46C2B10521")
    public Entry getTotal(Entry recycle, int limitUid) {
        return getTotal(recycle, null, limitUid);
    }

    /**
     * Return total of all fields represented by this snapshot object matching
     * the requested {@link #iface}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.531 -0500", hash_original_method = "A8C67127F98A8F27D6DD2D10C54926B1", hash_generated_method = "5D55F14A816767BCEEA20A6C69F7339A")
    public Entry getTotal(Entry recycle, HashSet<String> limitIface) {
        return getTotal(recycle, limitIface, UID_ALL);
    }

    /**
     * Return total of all fields represented by this snapshot object matching
     * the requested {@link #iface} and {@link #uid}.
     *
     * @param limitIface Set of {@link #iface} to include in total; or {@code
     *            null} to include all ifaces.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.532 -0500", hash_original_method = "7B779B0B251D8F12031ECAB7F83EFE1D", hash_generated_method = "CF5EB1AA36C15AA9BB5B4A92291FD389")
    private Entry getTotal(Entry recycle, HashSet<String> limitIface, int limitUid) {
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

        for (int i = 0; i < size; i++) {
            final boolean matchesUid = (limitUid == UID_ALL) || (limitUid == uid[i]);
            final boolean matchesIface = (limitIface == null) || (limitIface.contains(iface[i]));

            if (matchesUid && matchesIface) {
                // skip specific tags, since already counted in TAG_NONE
                if (tag[i] != TAG_NONE) continue;

                entry.rxBytes += rxBytes[i];
                entry.rxPackets += rxPackets[i];
                entry.txBytes += txBytes[i];
                entry.txPackets += txPackets[i];
                entry.operations += operations[i];
            }
        }
        return entry;
    }

    
    public static class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.497 -0500", hash_original_field = "11FA7C89AB1E83290F062B1282182D77", hash_generated_field = "C6A1018CA8BDAC723763D450E0753839")

        public String iface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.498 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.499 -0500", hash_original_field = "35E298206B7C0A7172A32BC4B4623F7A", hash_generated_field = "76DD25E4462280D67562778690A1B8EC")

        public int set;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.500 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

        public int tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.501 -0500", hash_original_field = "0FE6358F1845E42C870F13AC5727E9DD", hash_generated_field = "9910EB628EC91FE06D2639B0F3810F0E")

        public long rxBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.502 -0500", hash_original_field = "F72ADC0C0607345341AED54F6FFD3699", hash_generated_field = "6ADCDCD12FD7D35118980BC0BB165142")

        public long rxPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.503 -0500", hash_original_field = "B02473B759798FA29B9E9D9F49A5D2FE", hash_generated_field = "676F2C3D88E440A0E185A42A7F55CF74")

        public long txBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.503 -0500", hash_original_field = "FA1836C734A10730B1232303907726EB", hash_generated_field = "B93ED690B1DA86F6CE26308A7104AEFF")

        public long txPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.504 -0500", hash_original_field = "D1F578FEB79614CB0A74DF2645E202BD", hash_generated_field = "49E564B98B6E0E4454081C4D76AD6B00")

        public long operations;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.505 -0500", hash_original_method = "CF147DC846E9FA9CFBACF54E998579AF", hash_generated_method = "7208B80C70B07CF607BBACB029288870")
        public Entry() {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.506 -0500", hash_original_method = "E97E61BD38788E206E16E3AF28EF9986", hash_generated_method = "6609C49488AB1D463CBE2BD898E89A49")
        public Entry(long rxBytes, long rxPackets, long txBytes, long txPackets, long operations) {
            this(IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, rxPackets, txBytes, txPackets,
                    operations);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.507 -0500", hash_original_method = "08CED58FDA8ADE41E7B2EE03A16F55F8", hash_generated_method = "B4D51CD6F78786F1988F34C796FE8DA2")
        public Entry(String iface, int uid, int set, int tag, long rxBytes, long rxPackets,
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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.508 -0500", hash_original_method = "8BA58A1912534045F7A50ACBC1B00F2F", hash_generated_method = "4A0F978F85DA003FDC43F22A89581064")
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
            return builder.toString();
        }

        
    }


    
    public static class NonMonotonicException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.545 -0500", hash_original_field = "50C65BE719A65A1E61AB0B7C9118AB7E", hash_generated_field = "181F8009619333E411770D3E70DC8370")

        public  NetworkStats left;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.546 -0500", hash_original_field = "8D98CE52E026348617EC97BD4B597F87", hash_generated_field = "B505F3F155C5E8A912533BF2967190B7")

        public  NetworkStats right;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.547 -0500", hash_original_field = "6FAA0ABB7DB442E245EFAC3AA04C6A2B", hash_generated_field = "217C8C9F8012EB7818E9531FC30FEF27")

        public  int leftIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.548 -0500", hash_original_field = "14C95884D37CE629324A00F26C53AB91", hash_generated_field = "4A28DC3C7ADE86B25DA19F4A8CD04779")

        public  int rightIndex;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.549 -0500", hash_original_method = "0F470ECE148C3E2C73ACB1D4F54D342F", hash_generated_method = "46D768C21087B576DF001D1A7CB8E63F")
        public NonMonotonicException(NetworkStats left, NetworkStats right) {
            this(left, -1, right, -1);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.550 -0500", hash_original_method = "F441B58E88456542B2E0F8A35978B48D", hash_generated_method = "1E9B7A9E9578F8A1C831504531F6D99B")
        public NonMonotonicException(
                NetworkStats left, int leftIndex, NetworkStats right, int rightIndex) {
            this.left = checkNotNull(left, "missing left");
            this.right = checkNotNull(right, "missing right");
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

        
    }

    /**
     * Subtract the given {@link NetworkStats}, effectively leaving the delta
     * between two snapshots in time. Assumes that statistics rows collect over
     * time, and that none of them have disappeared.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.533 -0500", hash_original_method = "0B77BD3659EBAD0CA6247F62089B29FF", hash_generated_method = "C54110293A12C256D77E45C5DDF41E9D")
    public NetworkStats subtract(NetworkStats value) throws NonMonotonicException {
        return subtract(value, false);
    }

    /**
     * Subtract the given {@link NetworkStats}, effectively leaving the delta
     * between two snapshots in time. Assumes that statistics rows collect over
     * time, and that none of them have disappeared.
     *
     * @param clampNonMonotonic When non-monotonic stats are found, just clamp
     *            to 0 instead of throwing {@link NonMonotonicException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.534 -0500", hash_original_method = "04678C1B7F1434E233D6434823B40504", hash_generated_method = "9D6CE58D9A81667415CF4306BBF11873")
    public NetworkStats subtract(NetworkStats value, boolean clampNonMonotonic)
            throws NonMonotonicException {
        final long deltaRealtime = this.elapsedRealtime - value.elapsedRealtime;
        if (deltaRealtime < 0) {
            throw new NonMonotonicException(this, value);
        }

        // result will have our rows, and elapsed time between snapshots
        final Entry entry = new Entry();
        final NetworkStats result = new NetworkStats(deltaRealtime, size);
        for (int i = 0; i < size; i++) {
            entry.iface = iface[i];
            entry.uid = uid[i];
            entry.set = set[i];
            entry.tag = tag[i];

            // find remote row that matches, and subtract
            final int j = value.findIndexHinted(entry.iface, entry.uid, entry.set, entry.tag, i);
            if (j == -1) {
                // newly appearing row, return entire value
                entry.rxBytes = rxBytes[i];
                entry.rxPackets = rxPackets[i];
                entry.txBytes = txBytes[i];
                entry.txPackets = txPackets[i];
                entry.operations = operations[i];
            } else {
                // existing row, subtract remote value
                entry.rxBytes = rxBytes[i] - value.rxBytes[j];
                entry.rxPackets = rxPackets[i] - value.rxPackets[j];
                entry.txBytes = txBytes[i] - value.txBytes[j];
                entry.txPackets = txPackets[i] - value.txPackets[j];
                entry.operations = operations[i] - value.operations[j];

                if (entry.rxBytes < 0 || entry.rxPackets < 0 || entry.txBytes < 0
                        || entry.txPackets < 0 || entry.operations < 0) {
                    if (clampNonMonotonic) {
                        entry.rxBytes = Math.max(entry.rxBytes, 0);
                        entry.rxPackets = Math.max(entry.rxPackets, 0);
                        entry.txBytes = Math.max(entry.txBytes, 0);
                        entry.txPackets = Math.max(entry.txPackets, 0);
                        entry.operations = Math.max(entry.operations, 0);
                    } else {
                        throw new NonMonotonicException(this, i, value, j);
                    }
                }
            }

            result.addValues(entry);
        }

        return result;
    }

    /**
     * Return total statistics grouped by {@link #iface}; doesn't mutate the
     * original structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.535 -0500", hash_original_method = "AB3FDA05B945C3AC93E7C4BBCBA41D8F", hash_generated_method = "38932D9B404E6843812E95AFDA7D0B8C")
    public NetworkStats groupedByIface() {
        final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);

        final Entry entry = new Entry();
        entry.uid = UID_ALL;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;
        entry.operations = 0L;

        for (int i = 0; i < size; i++) {
            // skip specific tags, since already counted in TAG_NONE
            if (tag[i] != TAG_NONE) continue;

            entry.iface = iface[i];
            entry.rxBytes = rxBytes[i];
            entry.rxPackets = rxPackets[i];
            entry.txBytes = txBytes[i];
            entry.txPackets = txPackets[i];
            stats.combineValues(entry);
        }

        return stats;
    }

    /**
     * Return total statistics grouped by {@link #uid}; doesn't mutate the
     * original structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.536 -0500", hash_original_method = "F7B5ADC030AABE070FE0AF3D1DEEC4FF", hash_generated_method = "231635FEA52A114B2F36E979E22F0BBA")
    public NetworkStats groupedByUid() {
        final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);

        final Entry entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.set = SET_ALL;
        entry.tag = TAG_NONE;

        for (int i = 0; i < size; i++) {
            // skip specific tags, since already counted in TAG_NONE
            if (tag[i] != TAG_NONE) continue;

            entry.uid = uid[i];
            entry.rxBytes = rxBytes[i];
            entry.rxPackets = rxPackets[i];
            entry.txBytes = txBytes[i];
            entry.txPackets = txPackets[i];
            entry.operations = operations[i];
            stats.combineValues(entry);
        }

        return stats;
    }

    /**
     * Return all rows except those attributed to the requested UID; doesn't
     * mutate the original structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.537 -0500", hash_original_method = "9245ED01B44F4BC6EDE26C84298E681C", hash_generated_method = "E8C3546FD55A7FDD98EBEFFA18A3BDEF")
    public NetworkStats withoutUid(int uid) {
        final NetworkStats stats = new NetworkStats(elapsedRealtime, 10);

        Entry entry = new Entry();
        for (int i = 0; i < size; i++) {
            entry = getValues(i, entry);
            if (entry.uid != uid) {
                stats.addValues(entry);
            }
        }

        return stats;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.538 -0500", hash_original_method = "130412F853181F3DE6D8909F69FBB580", hash_generated_method = "CCA31CBF5ECA009EBA40D50E8332B6EC")
    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("NetworkStats: elapsedRealtime="); pw.println(elapsedRealtime);
        for (int i = 0; i < size; i++) {
            pw.print(prefix);
            pw.print("  ["); pw.print(i); pw.print("]");
            pw.print(" iface="); pw.print(iface[i]);
            pw.print(" uid="); pw.print(uid[i]);
            pw.print(" set="); pw.print(setToString(set[i]));
            pw.print(" tag="); pw.print(tagToString(tag[i]));
            pw.print(" rxBytes="); pw.print(rxBytes[i]);
            pw.print(" rxPackets="); pw.print(rxPackets[i]);
            pw.print(" txBytes="); pw.print(txBytes[i]);
            pw.print(" txPackets="); pw.print(txPackets[i]);
            pw.print(" operations="); pw.println(operations[i]);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.540 -0500", hash_original_method = "C185C780AB6AF420802BBBCB2A0DA03E", hash_generated_method = "765A956DC5B32778BE486346E3964079")
    @Override
public String toString() {
        final CharArrayWriter writer = new CharArrayWriter();
        dump("", new PrintWriter(writer));
        return writer.toString();
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:38.541 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public NetworkStats createFromParcel(Parcel in) {
            return new NetworkStats(in);
        }
    
    // orphaned legacy method
    public NetworkStats[] newArray(int size) {
            return new NetworkStats[size];
        }
    
}

