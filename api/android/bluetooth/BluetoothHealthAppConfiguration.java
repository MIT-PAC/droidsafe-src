package android.bluetooth;

// Droidsafe Imports
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class BluetoothHealthAppConfiguration implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.456 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.456 -0400", hash_original_field = "907A03EF868C95D9758028C546F47838", hash_generated_field = "E83A1926F8E9DAE3DFEBEBE7A127AA3F")

    private int mDataType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.456 -0400", hash_original_field = "6F68F3585D2AEBC6A43B8C630A289FED", hash_generated_field = "76F9775A9ADE67BEADFA0C6A215C040C")

    private int mRole;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.456 -0400", hash_original_field = "C29796028A7F353A6C6E1CD0E951F8F0", hash_generated_field = "CDCB414FA5AEE4053EF196EB830D6626")

    private int mChannelType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.457 -0400", hash_original_method = "F1CCBE170029B3726B6812F4B24EEA34", hash_generated_method = "7ED2F71D8DDFD78BA3AB5CB6DEB14173")
      BluetoothHealthAppConfiguration(String name, int dataType) {
        mName = name;
        mDataType = dataType;
        mRole = BluetoothHealth.SINK_ROLE;
        mChannelType = BluetoothHealth.CHANNEL_TYPE_ANY;
        // ---------- Original Method ----------
        //mName = name;
        //mDataType = dataType;
        //mRole = BluetoothHealth.SINK_ROLE;
        //mChannelType = BluetoothHealth.CHANNEL_TYPE_ANY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.459 -0400", hash_original_method = "C6E2AF4F2B152BF94119581EC8280111", hash_generated_method = "A230CD7368896174A0FF070C5F95D18A")
      BluetoothHealthAppConfiguration(String name, int dataType, int role, int
        channelType) {
        mName = name;
        mDataType = dataType;
        mRole = role;
        mChannelType = channelType;
        // ---------- Original Method ----------
        //mName = name;
        //mDataType = dataType;
        //mRole = role;
        //mChannelType = channelType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.461 -0400", hash_original_method = "EA455C93C36CD9B5DA0D1424A19781EC", hash_generated_method = "9A3AE7EBB8CD34581C3EA65D8364E104")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o instanceof BluetoothHealthAppConfiguration)        
        {
            BluetoothHealthAppConfiguration config = (BluetoothHealthAppConfiguration) o;
            boolean varD43F952EECC8C2F60B0D1754D7368EC2_793293795 = (mName.equals(config.getName()) &&
                    mDataType == config.getDataType() &&
                    mRole == config.getRole() &&
                    mChannelType == config.getChannelType());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325115450 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325115450;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1153984450 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962017638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962017638;
        // ---------- Original Method ----------
        //if (o instanceof BluetoothHealthAppConfiguration) {
            //BluetoothHealthAppConfiguration config = (BluetoothHealthAppConfiguration) o;
            //return mName.equals(config.getName()) &&
                    //mDataType == config.getDataType() &&
                    //mRole == config.getRole() &&
                    //mChannelType == config.getChannelType();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.462 -0400", hash_original_method = "720B1AB7A0141F5EC236EB862E5820DB", hash_generated_method = "3A325E09A469607F86D63637D21A66B4")
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + mDataType;
        result = 31 * result + mRole;
        result = 31 * result + mChannelType;
        int varB4A88417B3D0170D754C647C30B7216A_630462303 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782511373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782511373;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + (mName != null ? mName.hashCode() : 0);
        //result = 31 * result + mDataType;
        //result = 31 * result + mRole;
        //result = 31 * result + mChannelType;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.463 -0400", hash_original_method = "6A657EF2E4E3E8DD6C55372C14375784", hash_generated_method = "5432E66F6172F840065B41BDB9E68098")
    @Override
    public String toString() {
String varBC25A683492661AD32E0D02950883082_895924764 =         "BluetoothHealthAppConfiguration [mName = " + mName +
            ",mDataType = " + mDataType + ", mRole = " + mRole + ",mChannelType = " +
            mChannelType + "]";
        varBC25A683492661AD32E0D02950883082_895924764.addTaint(taint);
        return varBC25A683492661AD32E0D02950883082_895924764;
        // ---------- Original Method ----------
        //return "BluetoothHealthAppConfiguration [mName = " + mName +
            //",mDataType = " + mDataType + ", mRole = " + mRole + ",mChannelType = " +
            //mChannelType + "]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.464 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DE5453E1E5E38C3D94239D71B3E46F2F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_151152760 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022569613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1022569613;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.464 -0400", hash_original_method = "238D6A24727CDBAF0BB96C458473CE4A", hash_generated_method = "BFFD5606C80451378D8290720D192081")
    public int getDataType() {
        int var907A03EF868C95D9758028C546F47838_1166245339 = (mDataType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258977461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258977461;
        // ---------- Original Method ----------
        //return mDataType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.465 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "6E28341771E48073FA8D7D53D5CEED4C")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_2024313670 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_2024313670.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_2024313670;
        // ---------- Original Method ----------
        //return mName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.466 -0400", hash_original_method = "5596828740BFEA579FE112D16B3097DF", hash_generated_method = "DA6850017B073F01B7E292E3E86532DF")
    public int getRole() {
        int var6F68F3585D2AEBC6A43B8C630A289FED_266210529 = (mRole);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394780015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394780015;
        // ---------- Original Method ----------
        //return mRole;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.467 -0400", hash_original_method = "1B2362EE05FDF056E4EF857CCB8AB5A5", hash_generated_method = "FA2201EDAC566C64A2508248AEE78163")
    public int getChannelType() {
        int varC29796028A7F353A6C6E1CD0E951F8F0_1077038123 = (mChannelType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906731291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906731291;
        // ---------- Original Method ----------
        //return mChannelType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.468 -0400", hash_original_method = "9CE655BCEC17B8485B2E11BEA7FBDBD1", hash_generated_method = "B6FA31BA5A13E07C5CC46FB1E7774637")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(mName);
        out.writeInt(mDataType);
        out.writeInt(mRole);
        out.writeInt(mChannelType);
        // ---------- Original Method ----------
        //out.writeString(mName);
        //out.writeInt(mDataType);
        //out.writeInt(mRole);
        //out.writeInt(mChannelType);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.468 -0400", hash_original_field = "2BE8692C9178D30C9DCDD9CC7988AB07", hash_generated_field = "046D0AF0A47A6EB4E988F771AFCCFD7B")

    public static final Parcelable.Creator<BluetoothHealthAppConfiguration> CREATOR =
        new Parcelable.Creator<BluetoothHealthAppConfiguration>() {
        @Override
        public BluetoothHealthAppConfiguration createFromParcel(Parcel in) {
            String name = in.readString();
            int type = in.readInt();
            int role = in.readInt();
            int channelType = in.readInt();
            return new BluetoothHealthAppConfiguration(name, type, role,
                channelType);
        }

        @Override
        public BluetoothHealthAppConfiguration[] newArray(int size) {
            return new BluetoothHealthAppConfiguration[size];
        }
    };
}

