package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class BluetoothHealthAppConfiguration implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.468 -0400", hash_original_field = "2BE8692C9178D30C9DCDD9CC7988AB07", hash_generated_field = "046D0AF0A47A6EB4E988F771AFCCFD7B")

    public static final Parcelable.Creator<BluetoothHealthAppConfiguration> CREATOR =
        new Parcelable.Creator<BluetoothHealthAppConfiguration>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.822 -0500", hash_original_method = "ADCA440083271F3F65207F00968B56D8", hash_generated_method = "228AF7FE5372E4BC793301AF8C2B8183")
        
@Override
        public BluetoothHealthAppConfiguration createFromParcel(Parcel in) {
            String name = in.readString();
            int type = in.readInt();
            int role = in.readInt();
            int channelType = in.readInt();
            return new BluetoothHealthAppConfiguration(name, type, role,
                channelType);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.824 -0500", hash_original_method = "62C00B5B2E85385EA27DD4608BAECC02", hash_generated_method = "AEAAEF47E4370C22149EE38C16283029")
        
@Override
        public BluetoothHealthAppConfiguration[] newArray(int size) {
            return new BluetoothHealthAppConfiguration[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.788 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private  String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.791 -0500", hash_original_field = "7639663EC25545F2FFCF60D29FE58A1B", hash_generated_field = "E83A1926F8E9DAE3DFEBEBE7A127AA3F")

    private  int mDataType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.793 -0500", hash_original_field = "D5084B79E2B08CD2E52A79F8CE55A4EF", hash_generated_field = "76F9775A9ADE67BEADFA0C6A215C040C")

    private  int mRole;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.795 -0500", hash_original_field = "3A7FAF62E480070929FCE7B0E4F80966", hash_generated_field = "CDCB414FA5AEE4053EF196EB830D6626")

    private  int mChannelType;

    /**
     * Constructor to register the SINK role
     *
     * @param name Friendly name associated with the application configuration
     * @param dataType Data Type of the remote Bluetooth Health device
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.797 -0500", hash_original_method = "F1CCBE170029B3726B6812F4B24EEA34", hash_generated_method = "F1CCBE170029B3726B6812F4B24EEA34")
    
BluetoothHealthAppConfiguration(String name, int dataType) {
        mName = name;
        mDataType = dataType;
        mRole = BluetoothHealth.SINK_ROLE;
        mChannelType = BluetoothHealth.CHANNEL_TYPE_ANY;
    }

    /**
     * Constructor to register the application configuration.
     *
     * @param name Friendly name associated with the application configuration
     * @param dataType Data Type of the remote Bluetooth Health device
     * @param role {@link BluetoothHealth#SOURCE_ROLE} or
     *                     {@link BluetoothHealth#SINK_ROLE}
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.800 -0500", hash_original_method = "C6E2AF4F2B152BF94119581EC8280111", hash_generated_method = "C6E2AF4F2B152BF94119581EC8280111")
    
BluetoothHealthAppConfiguration(String name, int dataType, int role, int
        channelType) {
        mName = name;
        mDataType = dataType;
        mRole = role;
        mChannelType = channelType;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.802 -0500", hash_original_method = "EA455C93C36CD9B5DA0D1424A19781EC", hash_generated_method = "D9D436DEBBCBECC2C90C142493672C84")
    
@Override
    public boolean equals(Object o) {
        if (o instanceof BluetoothHealthAppConfiguration) {
            BluetoothHealthAppConfiguration config = (BluetoothHealthAppConfiguration) o;

            return 1 == (getTaintInt() + o.getTaintInt() + config.getName().getTaintInt() +
                              config.getDataType() + config.getRole() +
                              mDataType + mRole + mChannelType + config.getChannelType());
            /*
            // config.getName() can never be NULL
            return mName.equals(config.getName()) &&
                    mDataType == config.getDataType() &&
                    mRole == config.getRole() &&
                    mChannelType == config.getChannelType();
            */
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.804 -0500", hash_original_method = "720B1AB7A0141F5EC236EB862E5820DB", hash_generated_method = "A58CE241B6A244D1BE503119A6EEFE1E")
    
@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + mDataType;
        result = 31 * result + mRole;
        result = 31 * result + mChannelType;
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.806 -0500", hash_original_method = "6A657EF2E4E3E8DD6C55372C14375784", hash_generated_method = "448A14710FB5227DC8D9C4B9A7E86DD8")
    
@Override
    public String toString() {
        return "BluetoothHealthAppConfiguration [mName = " + mName +
            ",mDataType = " + mDataType + ", mRole = " + mRole + ",mChannelType = " +
            mChannelType + "]";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.809 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Return the data type associated with this application configuration.
     *
     * @return dataType
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.811 -0500", hash_original_method = "238D6A24727CDBAF0BB96C458473CE4A", hash_generated_method = "A376AFBE00C80EC13EC53892DF8520C5")
    
public int getDataType() {
        return mDataType;
    }

    /**
     * Return the name of the application configuration.
     *
     * @return String name
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.813 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    /**
     * Return the role associated with this application configuration.
     *
     * @return One of {@link BluetoothHealth#SOURCE_ROLE} or
     *                         {@link BluetoothHealth#SINK_ROLE}
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.815 -0500", hash_original_method = "5596828740BFEA579FE112D16B3097DF", hash_generated_method = "B22B7AD6CD5EA9BCC6DF90A98D2B00E4")
    
public int getRole() {
        return mRole;
    }

    /**
     * Return the channel type associated with this application configuration.
     *
     * @return One of {@link BluetoothHealth#CHANNEL_TYPE_RELIABLE} or
     *                         {@link BluetoothHealth#CHANNEL_TYPE_STREAMING} or
     *                         {@link BluetoothHealth#CHANNEL_TYPE_ANY}.
     * @hide
     */
    @DSSource({DSSourceKind.BLUETOOTH_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.817 -0500", hash_original_method = "1B2362EE05FDF056E4EF857CCB8AB5A5", hash_generated_method = "BF9035B14ADAE37045CC372D93A6D079")
    
public int getChannelType() {
        return mChannelType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:32.829 -0500", hash_original_method = "9CE655BCEC17B8485B2E11BEA7FBDBD1", hash_generated_method = "CA4ACFB2DA548AF4E56B69C514365B15")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName);
        out.writeInt(mDataType);
        out.writeInt(mRole);
        out.writeInt(mChannelType);
    }
}

