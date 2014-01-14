package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import java.io.CharArrayWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ProtocolException;
import java.util.Arrays;
import java.util.Random;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.MathUtils;

public class NetworkStatsHistory implements Parcelable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.528 -0500", hash_original_method = "9D3FB9EB48DBC5BD1109352D63C4227B", hash_generated_method = "AEA336FF9624B152F85480E0DA267088")
    
public static long randomLong(Random r, long start, long end) {
        return (long) (start + (r.nextFloat() * (end - start)));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.544 -0500", hash_original_method = "487E304B6AB9C8CF5BD693DAEBDF29C6", hash_generated_method = "9CFB00EDA3F0500A33DA1CE5E7E2DC74")
    
private static long getLong(long[] array, int i, long value) {
        return array != null ? array[i] : value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.546 -0500", hash_original_method = "D85045C76D29B281747DCD22D98FFBDB", hash_generated_method = "CC30DD7C084D89323E39367DACB6B621")
    
private static void setLong(long[] array, int i, long value) {
        if (array != null) array[i] = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.548 -0500", hash_original_method = "61DF4ED7ED1863BCC96DE4FB2685A3AA", hash_generated_method = "7952539C07DC1E3E63A22A95333C3AF4")
    
private static void addLong(long[] array, int i, long value) {
        if (array != null) array[i] += value;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.396 -0500", hash_original_field = "FDD74CC7B93D0ED802033488C6FE9EEA", hash_generated_field = "1ECA6D6E7F9A26B50E8896C3111CB80C")

    private static final int VERSION_INIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.398 -0500", hash_original_field = "44188C896CEE8A7E40021C73ACDCA7B8", hash_generated_field = "3CEE91C167DFC5FDE739B07D71FE2144")

    private static final int VERSION_ADD_PACKETS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.401 -0500", hash_original_field = "93B58E512A0C3E0F48C9D2E3D1EC7F2D", hash_generated_field = "480EA4EDB42382D1BD31224733D0AC9F")

    private static final int VERSION_ADD_ACTIVE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.403 -0500", hash_original_field = "E012E67C2FC9D7CFACF8A95744C49098", hash_generated_field = "B30C161561419447A145BC3806950DF6")

    public static final int FIELD_ACTIVE_TIME = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.406 -0500", hash_original_field = "94B8FCF6096BA87915BE3F1E0B6B6901", hash_generated_field = "B83AA8C9CBADCF8323FE156C6521F4F8")

    public static final int FIELD_RX_BYTES = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.408 -0500", hash_original_field = "073F2A031ACEEDC84C1EFF438412E6DB", hash_generated_field = "B1A30D37D59A5939979CC4F381D13A2A")

    public static final int FIELD_RX_PACKETS = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.410 -0500", hash_original_field = "D6B1C1DC6C4AB2E6DE706ADDD90ADC87", hash_generated_field = "7307AE6481C1A7B49CCC878109302487")

    public static final int FIELD_TX_BYTES = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.412 -0500", hash_original_field = "D09C046A558CDE34694ABA903BFFEBCE", hash_generated_field = "8C11DB6B6D297F056A0D084A3E40A14A")

    public static final int FIELD_TX_PACKETS = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.415 -0500", hash_original_field = "0D81FB9C99E2039C27ACF0A2921EB761", hash_generated_field = "9A1CC8FBB50D3CE2F1BB1A44BFD95E80")

    public static final int FIELD_OPERATIONS = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.417 -0500", hash_original_field = "FBA9C13DCF7D32564A3FB752FC162B27", hash_generated_field = "CD0D0EE4410996E4C6C61BD9919399D7")

    public static final int FIELD_ALL = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.939 -0400", hash_original_field = "048BF4BBB96644622132F9F51E1DB96F", hash_generated_field = "D81F6106977C71918B1EF6EAB4131577")

    public static final Creator<NetworkStatsHistory> CREATOR = new Creator<NetworkStatsHistory>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.536 -0500", hash_original_method = "83C291D635CD9A2169A9EB499CBBB9B0", hash_generated_method = "77FD148705EC1EB19A1A8739535985EF")
        
public NetworkStatsHistory createFromParcel(Parcel in) {
            return new NetworkStatsHistory(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.539 -0500", hash_original_method = "8FC12375FE889D52751FCC71E935D0E4", hash_generated_method = "BC7FC852BC6F1895E33EC08C0E0F594F")
        
public NetworkStatsHistory[] newArray(int size) {
            return new NetworkStatsHistory[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.419 -0500", hash_original_field = "530E2C7BC09F16E8D3F66FBAF94998AB", hash_generated_field = "2DC5FC41152B76B2AF9AC6BB55A20FB5")

    private long bucketDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.421 -0500", hash_original_field = "DE608DB5B2D21322C45919EB3B134CBB", hash_generated_field = "5619EFB8F87F05852AF87EFEA39E4229")

    private int bucketCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.424 -0500", hash_original_field = "427C6659B58FD0AE9C592470A8D00EBB", hash_generated_field = "139AA0E6051DEFC8EEA60ED1156E8150")

    private long[] bucketStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.426 -0500", hash_original_field = "7C33F0A732EC7FC1459E7E33A22E387F", hash_generated_field = "20E796E1CD2BA4BBB5978B0DA9E59A40")

    private long[] activeTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.428 -0500", hash_original_field = "9893AE5B5011F4C111FF1E1121D1EE1A", hash_generated_field = "835A90EA79ED43E63CD1F8551E1170AC")

    private long[] rxBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.430 -0500", hash_original_field = "1EEAC5F67B0C0397B12BAA122D9CE375", hash_generated_field = "3C8EA21CAE3964AFEC5D5287345DF52F")

    private long[] rxPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.432 -0500", hash_original_field = "7EB3547101C7AE6FD35B1A5788B55AAA", hash_generated_field = "5D0307CD93ADE4DF2FD18B8CD5214177")

    private long[] txBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.434 -0500", hash_original_field = "DCB918F8ED4E0C4902349C83FFA4A730", hash_generated_field = "EF80B3F02FF3FE9875FC49D478831ABF")

    private long[] txPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.436 -0500", hash_original_field = "8AF963FC77FD634807CAA8B9D5879BA6", hash_generated_field = "D54D9A650B72A41B61249C2CA8E210FC")

    private long[] operations;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.463 -0500", hash_original_method = "87FB06C16EBBFAA433DCDABD0A1A2DD9", hash_generated_method = "2AECF05CE52F2F0E3D13D9594DF3A81D")
    
public NetworkStatsHistory(long bucketDuration) {
        this(bucketDuration, 10, FIELD_ALL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.465 -0500", hash_original_method = "EAC8ED507C3789501B6488454258F44A", hash_generated_method = "6A70285E437DCFCF012F24C2A04780C5")
    
public NetworkStatsHistory(long bucketDuration, int initialSize) {
        this(bucketDuration, initialSize, FIELD_ALL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.468 -0500", hash_original_method = "91F33DD6289F13A1041AE60DDEFCB3A5", hash_generated_method = "9FF2B91B3196E08B0CD37C0B34811A84")
    
public NetworkStatsHistory(long bucketDuration, int initialSize, int fields) {
        this.bucketDuration = bucketDuration;
        bucketStart = new long[initialSize];
        if ((fields & FIELD_ACTIVE_TIME) != 0) activeTime = new long[initialSize];
        if ((fields & FIELD_RX_BYTES) != 0) rxBytes = new long[initialSize];
        if ((fields & FIELD_RX_PACKETS) != 0) rxPackets = new long[initialSize];
        if ((fields & FIELD_TX_BYTES) != 0) txBytes = new long[initialSize];
        if ((fields & FIELD_TX_PACKETS) != 0) txPackets = new long[initialSize];
        if ((fields & FIELD_OPERATIONS) != 0) operations = new long[initialSize];
        bucketCount = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.471 -0500", hash_original_method = "C5C154CF2AF179AC7D0E69C633C9B809", hash_generated_method = "6CC60867734CA1A18CDF6C8C611E3020")
    
public NetworkStatsHistory(Parcel in) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.476 -0500", hash_original_method = "EDC1A57CB9EE8B46632E6D4E4377F32F", hash_generated_method = "5606FD5961978FD70065B3EEB057106F")
    
public NetworkStatsHistory(DataInputStream in) throws IOException {
        final int version = in.readInt();
        switch (version) {
            case VERSION_INIT: {
                bucketDuration = in.readLong();
                bucketStart = readFullLongArray(in);
                rxBytes = readFullLongArray(in);
                rxPackets = new long[bucketStart.length];
                txBytes = readFullLongArray(in);
                txPackets = new long[bucketStart.length];
                operations = new long[bucketStart.length];
                bucketCount = bucketStart.length;
                break;
            }
            case VERSION_ADD_PACKETS:
            case VERSION_ADD_ACTIVE: {
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
            }
            default: {
                throw new ProtocolException("unexpected version: " + version);
            }
        }
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.473 -0500", hash_original_method = "7FCED8E87AE3E02DFD52BA28011A12D7", hash_generated_method = "95BEE8CA5EABE247F4D27569B5F10808")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeLong(bucketDuration);
        writeLongArray(out, bucketStart, bucketCount);
        writeLongArray(out, activeTime, bucketCount);
        writeLongArray(out, rxBytes, bucketCount);
        writeLongArray(out, rxPackets, bucketCount);
        writeLongArray(out, txBytes, bucketCount);
        writeLongArray(out, txPackets, bucketCount);
        writeLongArray(out, operations, bucketCount);
    }

    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.479 -0500", hash_original_method = "F25B937341175CC0273E2E92554C8F17", hash_generated_method = "4830B9EF3147F362C79C4724D028A819")
    
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
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.481 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.483 -0500", hash_original_method = "3E2D8D04EF3E8C4BDF56D4CFDD864A04", hash_generated_method = "B38745C6BAB0CE40B11D12EFE1B12F8E")
    
public int size() {
        return bucketCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.485 -0500", hash_original_method = "D0E743773F77C0F20C1DE2E3BE48F30B", hash_generated_method = "F4EF50E64ED121D5FB37AC5426615CCE")
    
public long getBucketDuration() {
        return bucketDuration;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.487 -0500", hash_original_method = "0DA78BB7B3F99E1543E4DC9DFD2BD9F4", hash_generated_method = "D81F7F9D960A997742FEAD9FBF254858")
    
public long getStart() {
        if (bucketCount > 0) {
            return bucketStart[0];
        } else {
            return Long.MAX_VALUE;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.489 -0500", hash_original_method = "D4476AE88A84FACA51BF4BF1E3EE2F8D", hash_generated_method = "647A0BEB8A762AF3AE998B23B95B98F6")
    
public long getEnd() {
        if (bucketCount > 0) {
            return bucketStart[bucketCount - 1] + bucketDuration;
        } else {
            return Long.MIN_VALUE;
        }
    }

    /**
     * Return index of bucket that contains or is immediately before the
     * requested time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.492 -0500", hash_original_method = "44CA8F6D269FC47862A9173C06F73618", hash_generated_method = "9775442B5D2C0BFF5F821524E90E04DE")
    
public int getIndexBefore(long time) {
        int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        if (index < 0) {
            index = (~index) - 1;
        } else {
            index -= 1;
        }
        return MathUtils.constrain(index, 0, bucketCount - 1);
    }

    /**
     * Return index of bucket that contains or is immediately after the
     * requested time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.494 -0500", hash_original_method = "44680AD61A9756C7015B14278BDED4D1", hash_generated_method = "E571632BDC27D70F8B4B5FBF02D40351")
    
public int getIndexAfter(long time) {
        int index = Arrays.binarySearch(bucketStart, 0, bucketCount, time);
        if (index < 0) {
            index = ~index;
        } else {
            index += 1;
        }
        return MathUtils.constrain(index, 0, bucketCount - 1);
    }

    /**
     * Return specific stats entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.497 -0500", hash_original_method = "75531F5194A56E3573F283D646BEE902", hash_generated_method = "3A63E3C6E13FC42B16B161EA0D0418AE")
    
public Entry getValues(int i, Entry recycle) {
        final Entry entry = recycle != null ? recycle : new Entry();
        entry.bucketStart = bucketStart[i];
        entry.bucketDuration = bucketDuration;
        entry.activeTime = getLong(activeTime, i, UNKNOWN);
        entry.rxBytes = getLong(rxBytes, i, UNKNOWN);
        entry.rxPackets = getLong(rxPackets, i, UNKNOWN);
        entry.txBytes = getLong(txBytes, i, UNKNOWN);
        entry.txPackets = getLong(txPackets, i, UNKNOWN);
        entry.operations = getLong(operations, i, UNKNOWN);
        return entry;
    }

    /**
     * Record that data traffic occurred in the given time range. Will
     * distribute across internal buckets, creating new buckets as needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.500 -0500", hash_original_method = "74712D26283E9B32FCB8C3574DCFFFFA", hash_generated_method = "0FF67A1B76011C53F57B50091A1AA816")
    
@Deprecated
    public void recordData(long start, long end, long rxBytes, long txBytes) {
        recordData(start, end, new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, rxBytes, 0L, txBytes, 0L, 0L));
    }
    
    public static class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.439 -0500", hash_original_field = "33C1007F023A4F6791A549B7B280BC05", hash_generated_field = "83092BBB72C91C04DD841B95A4680A5D")

        public static final long UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.441 -0500", hash_original_field = "530E2C7BC09F16E8D3F66FBAF94998AB", hash_generated_field = "7C1BAD4742A4B22366B6D0FF5D8B7450")

        public long bucketDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.444 -0500", hash_original_field = "97C28F6C4399C625D057E5EF69B6AB41", hash_generated_field = "1F3D020C44602964FFF2B3A5FE620FA4")

        public long bucketStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.447 -0500", hash_original_field = "A7C21FE100C9C1218A1D861957457D75", hash_generated_field = "711F26C2ABCF9DB9AF8FD37E3598B0DD")

        public long activeTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.449 -0500", hash_original_field = "0FE6358F1845E42C870F13AC5727E9DD", hash_generated_field = "9910EB628EC91FE06D2639B0F3810F0E")

        public long rxBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.452 -0500", hash_original_field = "F72ADC0C0607345341AED54F6FFD3699", hash_generated_field = "6ADCDCD12FD7D35118980BC0BB165142")

        public long rxPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.454 -0500", hash_original_field = "B02473B759798FA29B9E9D9F49A5D2FE", hash_generated_field = "676F2C3D88E440A0E185A42A7F55CF74")

        public long txBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.456 -0500", hash_original_field = "FA1836C734A10730B1232303907726EB", hash_generated_field = "B93ED690B1DA86F6CE26308A7104AEFF")

        public long txPackets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.458 -0500", hash_original_field = "D1F578FEB79614CB0A74DF2645E202BD", hash_generated_field = "49E564B98B6E0E4454081C4D76AD6B00")

        public long operations;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.936 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
        public Entry ()
        {
            //Synthesized constructor
        }
    }
    
    public static class DataStreamUtils {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.552 -0500", hash_original_method = "8C117ACB817B8757CE01A7CFCFC529A6", hash_generated_method = "7784A9CE40E05EDB6515986A2F63040F")
        
@Deprecated
        public static long[] readFullLongArray(DataInputStream in) throws IOException {
            final int size = in.readInt();
            final long[] values = new long[size];
            for (int i = 0; i < values.length; i++) {
                values[i] = in.readLong();
            }
            return values;
        }

        /**
         * Read variable-length {@link Long} using protobuf-style approach.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.555 -0500", hash_original_method = "B0D4512C7FC97CC62F635619CA7F6A05", hash_generated_method = "6B67D7F851ED42C97ECFB606463ACE36")
        
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

        /**
         * Write variable-length {@link Long} using protobuf-style approach.
         */
        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.558 -0500", hash_original_method = "D431E6C77070347A300599FD921BF72A", hash_generated_method = "810D0574BDF2521C29AD9FCAC804DB84")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.560 -0500", hash_original_method = "50569F6A99703754AB53D7324ABF21A8", hash_generated_method = "16136D3FD72DB1878E4A4FFE1697D70D")
        
public static long[] readVarLongArray(DataInputStream in) throws IOException {
            final int size = in.readInt();
            if (size == -1) return null;
            final long[] values = new long[size];
            for (int i = 0; i < values.length; i++) {
                values[i] = readVarLong(in);
            }
            return values;
        }

        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.563 -0500", hash_original_method = "F69E44CFFE25D3AAA6FC01B2A5398C20", hash_generated_method = "719A0D5F3BFC15F28AA7CD3F36E0942A")
        
public static void writeVarLongArray(DataOutputStream out, long[] values, int size)
                throws IOException {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.937 -0400", hash_original_method = "19FEB3F8DC1B5C5DFE6BAC6ABFB6225F", hash_generated_method = "19FEB3F8DC1B5C5DFE6BAC6ABFB6225F")
        public DataStreamUtils ()
        {
            //Synthesized constructor
        }
        
    }
    
    public static class ParcelUtils {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.568 -0500", hash_original_method = "E8E8FFBE49221B18A2D2D8EEA4DEF645", hash_generated_method = "B375935F19AF35E91FDBEE687E6629C0")
        
public static long[] readLongArray(Parcel in) {
            final int size = in.readInt();
            if (size == -1) return null;
            final long[] values = new long[size];
            for (int i = 0; i < values.length; i++) {
                values[i] = in.readLong();
            }
            return values;
        }

        @DSSink({DSSinkKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.572 -0500", hash_original_method = "B0F535676A3746562290C16E304FB2DC", hash_generated_method = "5A0BC5C7CB64443FD2F4DEB78C0C29A7")
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.938 -0400", hash_original_method = "B81D28E36C3A9E7E89F9825844B173D9", hash_generated_method = "B81D28E36C3A9E7E89F9825844B173D9")
        public ParcelUtils ()
        {
            //Synthesized constructor
        }
        
    }

    /**
     * Record that data traffic occurred in the given time range. Will
     * distribute across internal buckets, creating new buckets as needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.503 -0500", hash_original_method = "3FF3F0D6B4FEA69386DC61191DDF3D5F", hash_generated_method = "1D24F1133F093A6851F8D3448F35CAA7")
    
public void recordData(long start, long end, NetworkStats.Entry entry) {
        if (entry.rxBytes < 0 || entry.rxPackets < 0 || entry.txBytes < 0 || entry.txPackets < 0
                || entry.operations < 0) {
            throw new IllegalArgumentException("tried recording negative data");
        }
        if (entry.rxBytes == 0 && entry.rxPackets == 0 && entry.txBytes == 0 && entry.txPackets == 0
                && entry.operations == 0) {
            // nothing to record; skip
            return;
        }

        // create any buckets needed by this range
        ensureBuckets(start, end);

        // distribute data usage into buckets
        long duration = end - start;
        final int startIndex = getIndexAfter(end);
        for (int i = startIndex; i >= 0; i--) {
            final long curStart = bucketStart[i];
            final long curEnd = curStart + bucketDuration;

            // bucket is older than record; we're finished
            if (curEnd < start) break;
            // bucket is newer than record; keep looking
            if (curStart > end) continue;

            final long overlap = Math.min(curEnd, end) - Math.max(curStart, start);
            if (overlap <= 0) continue;

            // integer math each time is faster than floating point
            final long fracRxBytes = entry.rxBytes * overlap / duration;
            final long fracRxPackets = entry.rxPackets * overlap / duration;
            final long fracTxBytes = entry.txBytes * overlap / duration;
            final long fracTxPackets = entry.txPackets * overlap / duration;
            final long fracOperations = entry.operations * overlap / duration;

            addLong(activeTime, i, overlap);
            addLong(rxBytes, i, fracRxBytes); entry.rxBytes -= fracRxBytes;
            addLong(rxPackets, i, fracRxPackets); entry.rxPackets -= fracRxPackets;
            addLong(txBytes, i, fracTxBytes); entry.txBytes -= fracTxBytes;
            addLong(txPackets, i, fracTxPackets); entry.txPackets -= fracTxPackets;
            addLong(operations, i, fracOperations); entry.operations -= fracOperations;

            duration -= overlap;
        }
    }

    /**
     * Record an entire {@link NetworkStatsHistory} into this history. Usually
     * for combining together stats for external reporting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.505 -0500", hash_original_method = "3DDEBC644DC519B4D2C820693B031478", hash_generated_method = "E8C94D410AD1C0AED714F0F91DC2ACAF")
    
public void recordEntireHistory(NetworkStatsHistory input) {
        final NetworkStats.Entry entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        for (int i = 0; i < input.bucketCount; i++) {
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

    /**
     * Ensure that buckets exist for given time range, creating as needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.508 -0500", hash_original_method = "B927CFA0CEDE41C1E5D84D22AEB0E325", hash_generated_method = "C2BEED7A0A6543BD3478EEFCD606EE2E")
    
private void ensureBuckets(long start, long end) {
        // normalize incoming range to bucket boundaries
        start -= start % bucketDuration;
        end += (bucketDuration - (end % bucketDuration)) % bucketDuration;

        for (long now = start; now < end; now += bucketDuration) {
            // try finding existing bucket
            final int index = Arrays.binarySearch(bucketStart, 0, bucketCount, now);
            if (index < 0) {
                // bucket missing, create and insert
                insertBucket(~index, now);
            }
        }
    }

    /**
     * Insert new bucket at requested index and starting time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.511 -0500", hash_original_method = "B3108244F274B858A2EC662DDA9927CD", hash_generated_method = "ECC9EF8F4D049CE8B9750D07CE63020C")
    
private void insertBucket(int index, long start) {
        // create more buckets when needed
        if (bucketCount >= bucketStart.length) {
            final int newLength = Math.max(bucketStart.length, 10) * 3 / 2;
            bucketStart = Arrays.copyOf(bucketStart, newLength);
            if (activeTime != null) activeTime = Arrays.copyOf(activeTime, newLength);
            if (rxBytes != null) rxBytes = Arrays.copyOf(rxBytes, newLength);
            if (rxPackets != null) rxPackets = Arrays.copyOf(rxPackets, newLength);
            if (txBytes != null) txBytes = Arrays.copyOf(txBytes, newLength);
            if (txPackets != null) txPackets = Arrays.copyOf(txPackets, newLength);
            if (operations != null) operations = Arrays.copyOf(operations, newLength);
        }

        // create gap when inserting bucket in middle
        if (index < bucketCount) {
            final int dstPos = index + 1;
            final int length = bucketCount - index;

            System.arraycopy(bucketStart, index, bucketStart, dstPos, length);
            if (activeTime != null) System.arraycopy(activeTime, index, activeTime, dstPos, length);
            if (rxBytes != null) System.arraycopy(rxBytes, index, rxBytes, dstPos, length);
            if (rxPackets != null) System.arraycopy(rxPackets, index, rxPackets, dstPos, length);
            if (txBytes != null) System.arraycopy(txBytes, index, txBytes, dstPos, length);
            if (txPackets != null) System.arraycopy(txPackets, index, txPackets, dstPos, length);
            if (operations != null) System.arraycopy(operations, index, operations, dstPos, length);
        }

        bucketStart[index] = start;
        setLong(activeTime, index, 0L);
        setLong(rxBytes, index, 0L);
        setLong(rxPackets, index, 0L);
        setLong(txBytes, index, 0L);
        setLong(txPackets, index, 0L);
        setLong(operations, index, 0L);
        bucketCount++;
    }

    /**
     * Remove buckets older than requested cutoff.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.514 -0500", hash_original_method = "D42FFE9A180911A657FA083FF5768836", hash_generated_method = "DC82A7FD8AE3DDC88C0AA180AC17C292")
    
public void removeBucketsBefore(long cutoff) {
        int i;
        for (i = 0; i < bucketCount; i++) {
            final long curStart = bucketStart[i];
            final long curEnd = curStart + bucketDuration;

            // cutoff happens before or during this bucket; everything before
            // this bucket should be removed.
            if (curEnd > cutoff) break;
        }

        if (i > 0) {
            final int length = bucketStart.length;
            bucketStart = Arrays.copyOfRange(bucketStart, i, length);
            if (activeTime != null) activeTime = Arrays.copyOfRange(activeTime, i, length);
            if (rxBytes != null) rxBytes = Arrays.copyOfRange(rxBytes, i, length);
            if (rxPackets != null) rxPackets = Arrays.copyOfRange(rxPackets, i, length);
            if (txBytes != null) txBytes = Arrays.copyOfRange(txBytes, i, length);
            if (txPackets != null) txPackets = Arrays.copyOfRange(txPackets, i, length);
            if (operations != null) operations = Arrays.copyOfRange(operations, i, length);
            bucketCount -= i;
        }
    }

    /**
     * Return interpolated data usage across the requested range. Interpolates
     * across buckets, so values may be rounded slightly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.516 -0500", hash_original_method = "846F78477F792FCCB9A623410DF90C52", hash_generated_method = "9BDB8B9495C3428B3B4B91144D702C44")
    
public Entry getValues(long start, long end, Entry recycle) {
        return getValues(start, end, Long.MAX_VALUE, recycle);
    }

    /**
     * Return interpolated data usage across the requested range. Interpolates
     * across buckets, so values may be rounded slightly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.520 -0500", hash_original_method = "FB71475C239CC1C7BD0FFCD80328C5DA", hash_generated_method = "8DB766F72698AB9D6E0A08A459ACB705")
    
public Entry getValues(long start, long end, long now, Entry recycle) {
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
        for (int i = startIndex; i >= 0; i--) {
            final long curStart = bucketStart[i];
            final long curEnd = curStart + bucketDuration;

            // bucket is older than request; we're finished
            if (curEnd <= start) break;
            // bucket is newer than request; keep looking
            if (curStart >= end) continue;

            // include full value for active buckets, otherwise only fractional
            final boolean activeBucket = curStart < now && curEnd > now;
            final long overlap;
            if (activeBucket) {
                overlap = bucketDuration;
            } else {
                final long overlapEnd = curEnd < end ? curEnd : end;
                final long overlapStart = curStart > start ? curStart : start;
                overlap = overlapEnd - overlapStart;
            }
            if (overlap <= 0) continue;

            // integer math each time is faster than floating point
            if (activeTime != null) entry.activeTime += activeTime[i] * overlap / bucketDuration;
            if (rxBytes != null) entry.rxBytes += rxBytes[i] * overlap / bucketDuration;
            if (rxPackets != null) entry.rxPackets += rxPackets[i] * overlap / bucketDuration;
            if (txBytes != null) entry.txBytes += txBytes[i] * overlap / bucketDuration;
            if (txPackets != null) entry.txPackets += txPackets[i] * overlap / bucketDuration;
            if (operations != null) entry.operations += operations[i] * overlap / bucketDuration;
        }
        return entry;
    }

    /**
     * @deprecated only for temporary testing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.523 -0500", hash_original_method = "AB86ED9AABA220FE0A64D0BEB0ADF734", hash_generated_method = "D8FB932D20790663B6B72DF0B328F477")
    
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
    }

    /**
     * @deprecated only for temporary testing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.526 -0500", hash_original_method = "2B4929E4FB42F9E11DEF8BA8131121D5", hash_generated_method = "E818842A56EDB6C0AFC0A5B613FF51E8")
    
@Deprecated
    public void generateRandom(long start, long end, long rxBytes, long rxPackets, long txBytes,
            long txPackets, long operations, Random r) {
        ensureBuckets(start, end);

        final NetworkStats.Entry entry = new NetworkStats.Entry(
                IFACE_ALL, UID_ALL, SET_DEFAULT, TAG_NONE, 0L, 0L, 0L, 0L, 0L);
        while (rxBytes > 1024 || rxPackets > 128 || txBytes > 1024 || txPackets > 128
                || operations > 32) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.531 -0500", hash_original_method = "9A3509822F71494F86F9AA38F61F7118", hash_generated_method = "C2010758F38FAA2B8CB4D4EB404165AA")
    
public void dump(String prefix, PrintWriter pw, boolean fullHistory) {
        pw.print(prefix);
        pw.print("NetworkStatsHistory: bucketDuration="); pw.println(bucketDuration);

        final int start = fullHistory ? 0 : Math.max(0, bucketCount - 32);
        if (start > 0) {
            pw.print(prefix);
            pw.print("  (omitting "); pw.print(start); pw.println(" buckets)");
        }

        for (int i = start; i < bucketCount; i++) {
            pw.print(prefix);
            pw.print("  bucketStart="); pw.print(bucketStart[i]);
            if (activeTime != null) { pw.print(" activeTime="); pw.print(activeTime[i]); }
            if (rxBytes != null) { pw.print(" rxBytes="); pw.print(rxBytes[i]); }
            if (rxPackets != null) { pw.print(" rxPackets="); pw.print(rxPackets[i]); }
            if (txBytes != null) { pw.print(" txBytes="); pw.print(txBytes[i]); }
            if (txPackets != null) { pw.print(" txPackets="); pw.print(txPackets[i]); }
            if (operations != null) { pw.print(" operations="); pw.print(operations[i]); }
            pw.println();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:59.533 -0500", hash_original_method = "BC70BAB3B88F6C51172FD25602AB6B1A", hash_generated_method = "DE5751B3CBE5E1E394ABD172AFFC0463")
    
@Override
    public String toString() {
        final CharArrayWriter writer = new CharArrayWriter();
        dump("", new PrintWriter(writer), false);
        return writer.toString();
    }
    // orphaned legacy method
    public NetworkStatsHistory createFromParcel(Parcel in) {
            return new NetworkStatsHistory(in);
        }
    
    // orphaned legacy method
    public NetworkStatsHistory[] newArray(int size) {
            return new NetworkStatsHistory[size];
        }
    
}

