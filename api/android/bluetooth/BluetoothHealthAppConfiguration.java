package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class BluetoothHealthAppConfiguration implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.183 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.183 -0400", hash_original_field = "907A03EF868C95D9758028C546F47838", hash_generated_field = "E83A1926F8E9DAE3DFEBEBE7A127AA3F")

    private int mDataType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.183 -0400", hash_original_field = "6F68F3585D2AEBC6A43B8C630A289FED", hash_generated_field = "76F9775A9ADE67BEADFA0C6A215C040C")

    private int mRole;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.183 -0400", hash_original_field = "C29796028A7F353A6C6E1CD0E951F8F0", hash_generated_field = "CDCB414FA5AEE4053EF196EB830D6626")

    private int mChannelType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.184 -0400", hash_original_method = "F1CCBE170029B3726B6812F4B24EEA34", hash_generated_method = "7ED2F71D8DDFD78BA3AB5CB6DEB14173")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.186 -0400", hash_original_method = "C6E2AF4F2B152BF94119581EC8280111", hash_generated_method = "A230CD7368896174A0FF070C5F95D18A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.187 -0400", hash_original_method = "EA455C93C36CD9B5DA0D1424A19781EC", hash_generated_method = "A2B865B964A8BC583FE3F3333ECC5E81")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o instanceof BluetoothHealthAppConfiguration)        
        {
            BluetoothHealthAppConfiguration config = (BluetoothHealthAppConfiguration) o;
            boolean varD43F952EECC8C2F60B0D1754D7368EC2_585238101 = (mName.equals(config.getName()) &&
                    mDataType == config.getDataType() &&
                    mRole == config.getRole() &&
                    mChannelType == config.getChannelType());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1977993856 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1977993856;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_745888170 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978439883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978439883;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.189 -0400", hash_original_method = "720B1AB7A0141F5EC236EB862E5820DB", hash_generated_method = "64A18514E23D1B706674735F295916B9")
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + mDataType;
        result = 31 * result + mRole;
        result = 31 * result + mChannelType;
        int varB4A88417B3D0170D754C647C30B7216A_1208506305 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909253113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909253113;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + (mName != null ? mName.hashCode() : 0);
        //result = 31 * result + mDataType;
        //result = 31 * result + mRole;
        //result = 31 * result + mChannelType;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.190 -0400", hash_original_method = "6A657EF2E4E3E8DD6C55372C14375784", hash_generated_method = "2B5E814E0B718A2C6C0E53F5FA2B0990")
    @Override
    public String toString() {
String varBC25A683492661AD32E0D02950883082_1644072259 =         "BluetoothHealthAppConfiguration [mName = " + mName +
            ",mDataType = " + mDataType + ", mRole = " + mRole + ",mChannelType = " +
            mChannelType + "]";
        varBC25A683492661AD32E0D02950883082_1644072259.addTaint(taint);
        return varBC25A683492661AD32E0D02950883082_1644072259;
        // ---------- Original Method ----------
        //return "BluetoothHealthAppConfiguration [mName = " + mName +
            //",mDataType = " + mDataType + ", mRole = " + mRole + ",mChannelType = " +
            //mChannelType + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.190 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BCCEA2C25606ED862B2ADCA4213B964E")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_516708681 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011645123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011645123;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.191 -0400", hash_original_method = "238D6A24727CDBAF0BB96C458473CE4A", hash_generated_method = "68CDC6630FA8DAB7D982D4504010A728")
    public int getDataType() {
        int var907A03EF868C95D9758028C546F47838_898272885 = (mDataType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47751252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47751252;
        // ---------- Original Method ----------
        //return mDataType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.192 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AC177E9C5F646B3CBAD3E66AB6A9EF57")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_424711843 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_424711843.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_424711843;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.192 -0400", hash_original_method = "5596828740BFEA579FE112D16B3097DF", hash_generated_method = "BBB7FC670E01D68E58FF0341BE449B54")
    public int getRole() {
        int var6F68F3585D2AEBC6A43B8C630A289FED_1527095124 = (mRole);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571858312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571858312;
        // ---------- Original Method ----------
        //return mRole;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.193 -0400", hash_original_method = "1B2362EE05FDF056E4EF857CCB8AB5A5", hash_generated_method = "582409DE19398F8CF94BD70894C9AAFE")
    public int getChannelType() {
        int varC29796028A7F353A6C6E1CD0E951F8F0_1122002585 = (mChannelType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92018195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92018195;
        // ---------- Original Method ----------
        //return mChannelType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.193 -0400", hash_original_method = "9CE655BCEC17B8485B2E11BEA7FBDBD1", hash_generated_method = "B6FA31BA5A13E07C5CC46FB1E7774637")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.194 -0400", hash_original_field = "2BE8692C9178D30C9DCDD9CC7988AB07", hash_generated_field = "046D0AF0A47A6EB4E988F771AFCCFD7B")

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

