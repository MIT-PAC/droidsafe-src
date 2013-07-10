package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class InputDevice implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.978 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.978 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.978 -0400", hash_original_field = "DB16CA429360673C225135A6E95335E5", hash_generated_field = "93F8C3686E416465BD516F0456984FB5")

    private int mSources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.978 -0400", hash_original_field = "4F373ED5F3CABA41929A1177EB3FB926", hash_generated_field = "A34912FA2700058D6266925EFA16F418")

    private int mKeyboardType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.978 -0400", hash_original_field = "AB30725F38523A03DBBFE4BBA5B3B40D", hash_generated_field = "70C3EC525DB53326DF319F2822B78445")

    private String mKeyCharacterMapFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.978 -0400", hash_original_field = "7CF9875B144A6D9731314267623BF1A5", hash_generated_field = "3D9ACF5B843900F5B90A6C764A13538C")

    private final ArrayList<MotionRange> mMotionRanges = new ArrayList<MotionRange>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.978 -0400", hash_original_method = "2C37C35B619B46784669EFC9CA5E5179", hash_generated_method = "93E63FA312CE70DEEBBCD18536A99918")
    private  InputDevice() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static InputDevice getDevice(int id) {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDevice(id);
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device information from Window Manager.", ex);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int[] getDeviceIds() {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDeviceIds();
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device ids from Window Manager.", ex);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.979 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "17FDE6A83EF905AD4F29430034F4F149")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102397920 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102397920;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.979 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "0E67F56F311741BE1CB7BDC5392DB12B")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_956773543 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_956773543 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_956773543.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_956773543;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.980 -0400", hash_original_method = "3BD5CDD2AD0F6E345998577876EA9513", hash_generated_method = "EA3879840288CF1786AA50CC9830F932")
    public int getSources() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779586383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779586383;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.980 -0400", hash_original_method = "3E019E9C92E6EAD3726AE49F913F1619", hash_generated_method = "153A881C83718468FB28345994CD0C18")
    public int getKeyboardType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47587733 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47587733;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.980 -0400", hash_original_method = "88E280A067EB975F01B9806455B5FBF9", hash_generated_method = "6ADCFF795F615B374EB4043BFF6F70E7")
    public KeyCharacterMap getKeyCharacterMap() {
        KeyCharacterMap varB4EAC82CA7396A68D541C85D26508E83_2103783872 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2103783872 = KeyCharacterMap.load(mId);
        varB4EAC82CA7396A68D541C85D26508E83_2103783872.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2103783872;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.981 -0400", hash_original_method = "6E63969CFD2DFD594C82531499F7DA54", hash_generated_method = "C2BADEC57E99293C4440D995E5895D73")
     String getKeyCharacterMapFile() {
        String varB4EAC82CA7396A68D541C85D26508E83_1801815941 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1801815941 = mKeyCharacterMapFile;
        varB4EAC82CA7396A68D541C85D26508E83_1801815941.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1801815941;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.982 -0400", hash_original_method = "496E5C96705FE1519429C9151F8650BC", hash_generated_method = "BF0508C891C629E9F1EB47E3CB30BEF0")
    public MotionRange getMotionRange(int axis) {
        MotionRange varB4EAC82CA7396A68D541C85D26508E83_277562572 = null; 
        MotionRange varB4EAC82CA7396A68D541C85D26508E83_1361047582 = null; 
        final int numRanges = mMotionRanges.size();
        {
            int i = 0;
            {
                final MotionRange range = mMotionRanges.get(i);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_277562572 = range;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1361047582 = null;
        addTaint(axis);
        MotionRange varA7E53CE21691AB073D9660D615818899_2128450923; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2128450923 = varB4EAC82CA7396A68D541C85D26508E83_277562572;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2128450923 = varB4EAC82CA7396A68D541C85D26508E83_1361047582;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2128450923.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2128450923;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.983 -0400", hash_original_method = "2F158E6F6F2CA810A33FC3C995F22831", hash_generated_method = "F2C59B25158D1FE282BEBEC0E102828A")
    public MotionRange getMotionRange(int axis, int source) {
        MotionRange varB4EAC82CA7396A68D541C85D26508E83_2055495367 = null; 
        MotionRange varB4EAC82CA7396A68D541C85D26508E83_1415159400 = null; 
        final int numRanges = mMotionRanges.size();
        {
            int i = 0;
            {
                final MotionRange range = mMotionRanges.get(i);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2055495367 = range;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1415159400 = null;
        addTaint(axis);
        addTaint(source);
        MotionRange varA7E53CE21691AB073D9660D615818899_708767507; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_708767507 = varB4EAC82CA7396A68D541C85D26508E83_2055495367;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_708767507 = varB4EAC82CA7396A68D541C85D26508E83_1415159400;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_708767507.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_708767507;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.984 -0400", hash_original_method = "8F0147E430687E8511683E1D47819832", hash_generated_method = "ABE157A0A0C040481F9B93433F99511F")
    public List<MotionRange> getMotionRanges() {
        List<MotionRange> varB4EAC82CA7396A68D541C85D26508E83_1113030647 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1113030647 = mMotionRanges;
        varB4EAC82CA7396A68D541C85D26508E83_1113030647.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1113030647;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.985 -0400", hash_original_method = "F938DEDD59851FE8B4D63705E085118B", hash_generated_method = "A7B1006F6BA450A99A55035280FEF73A")
    private void addMotionRange(int axis, int source,
            float min, float max, float flat, float fuzz) {
        mMotionRanges.add(new MotionRange(axis, source, min, max, flat, fuzz));
        addTaint(axis);
        addTaint(source);
        addTaint(min);
        addTaint(max);
        addTaint(flat);
        addTaint(fuzz);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.985 -0400", hash_original_method = "66E89B3285A9850971D96BAD9F2BB44F", hash_generated_method = "849DD616D15F71B3CC3FC372AAB4987F")
    private void readFromParcel(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mSources = in.readInt();
        mKeyboardType = in.readInt();
        mKeyCharacterMapFile = in.readString();
        {
            int axis = in.readInt();
            addMotionRange(axis, in.readInt(),
                    in.readFloat(), in.readFloat(), in.readFloat(), in.readFloat());
        } 
        
        
        
        
        
        
        
            
            
                
            
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.986 -0400", hash_original_method = "91853B6BABA9CBC4F027C3C314DDF153", hash_generated_method = "E28A43D39569CE697EB76284BD97E828")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mId);
        out.writeString(mName);
        out.writeInt(mSources);
        out.writeInt(mKeyboardType);
        out.writeString(mKeyCharacterMapFile);
        final int numRanges = mMotionRanges.size();
        {
            int i = 0;
            {
                MotionRange range = mMotionRanges.get(i);
                out.writeInt(range.mAxis);
                out.writeInt(range.mSource);
                out.writeFloat(range.mMin);
                out.writeFloat(range.mMax);
                out.writeFloat(range.mFlat);
                out.writeFloat(range.mFuzz);
            } 
        } 
        out.writeInt(-1);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
            
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.987 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8F740CB5F788344ADDDEA2C29EB8F9DE")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527735453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527735453;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.988 -0400", hash_original_method = "9F735BD3745C12E449D13E0D45FB54C8", hash_generated_method = "3B0B2B46AF2D28B7D73F0E4EBF28B741")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_33638546 = null; 
        StringBuilder description = new StringBuilder();
        description.append("Input Device ").append(mId).append(": ").append(mName).append("\n");
        description.append("  Keyboard Type: ");
        
        description.append("none");
        
        
        description.append("non-alphabetic");
        
        
        description.append("alphabetic");
        
        description.append("\n");
        description.append("  Key Character Map: ").append(mKeyCharacterMapFile).append("\n");
        description.append("  Sources: 0x").append(Integer.toHexString(mSources)).append(" (");
        appendSourceDescriptionIfApplicable(description, SOURCE_KEYBOARD, "keyboard");
        appendSourceDescriptionIfApplicable(description, SOURCE_DPAD, "dpad");
        appendSourceDescriptionIfApplicable(description, SOURCE_TOUCHSCREEN, "touchscreen");
        appendSourceDescriptionIfApplicable(description, SOURCE_MOUSE, "mouse");
        appendSourceDescriptionIfApplicable(description, SOURCE_STYLUS, "stylus");
        appendSourceDescriptionIfApplicable(description, SOURCE_TRACKBALL, "trackball");
        appendSourceDescriptionIfApplicable(description, SOURCE_TOUCHPAD, "touchpad");
        appendSourceDescriptionIfApplicable(description, SOURCE_JOYSTICK, "joystick");
        appendSourceDescriptionIfApplicable(description, SOURCE_GAMEPAD, "gamepad");
        description.append(" )\n");
        final int numAxes = mMotionRanges.size();
        {
            int i = 0;
            {
                MotionRange range = mMotionRanges.get(i);
                description.append("    ").append(MotionEvent.axisToString(range.mAxis));
                description.append(": source=0x").append(Integer.toHexString(range.mSource));
                description.append(" min=").append(range.mMin);
                description.append(" max=").append(range.mMax);
                description.append(" flat=").append(range.mFlat);
                description.append(" fuzz=").append(range.mFuzz);
                description.append("\n");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_33638546 = description.toString();
        varB4EAC82CA7396A68D541C85D26508E83_33638546.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_33638546;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_method = "C8D7AE07A3174BF8CEBA0E0E2EC288B0", hash_generated_method = "969A62E89D565AE9E26E67CB0D71270B")
    private void appendSourceDescriptionIfApplicable(StringBuilder description, int source,
            String sourceName) {
        {
            description.append(" ");
            description.append(sourceName);
        } 
        addTaint(description.getTaint());
        addTaint(source);
        addTaint(sourceName.getTaint());
        
        
            
            
        
    }

    
    public static final class MotionRange {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_field = "DDDC097689F9367A976032A7CB2D356F", hash_generated_field = "291186BF7CD64560031686367E49FDA6")

        private int mAxis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "D564CAA4C2DB0DC0AAAD32F1767ED66A")

        private int mSource;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "C65C1A7B3549B2CAE727CE60B163A9D5")

        private float mMin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_field = "C886C6FF92A43B3F6833B7BAFD354FBA", hash_generated_field = "61EBA81EE8DC22B1F5E764B863E5361B")

        private float mMax;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_field = "C5775080456E320FD2BA8673FDF85440", hash_generated_field = "EE76E1A2F0CC7EE13DBD206CE7906C7D")

        private float mFlat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_field = "A0A8D80651D8BE9B0B3FA9DF5C043C6F", hash_generated_field = "88080FE0B3D7FAD3C1754E24E4008D99")

        private float mFuzz;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.989 -0400", hash_original_method = "003C115B43ED25425A82F4C0BC4BFB2D", hash_generated_method = "F4F973ACE14B026CE8F881C426E10F2D")
        private  MotionRange(int axis, int source, float min, float max, float flat, float fuzz) {
            mAxis = axis;
            mSource = source;
            mMin = min;
            mMax = max;
            mFlat = flat;
            mFuzz = fuzz;
            
            
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.990 -0400", hash_original_method = "7AA123496C72318A01ADA9E2FDF13D66", hash_generated_method = "ABC7FD38CFEAD9943E176F6AB9531E2F")
        public int getAxis() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757226971 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_757226971;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.990 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "F9AD0CE897AFA30A8C89D3C182F007EF")
        public int getSource() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726154920 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726154920;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.991 -0400", hash_original_method = "5BD2FEA7B11B9283C78F11EA439073DF", hash_generated_method = "CC3C4A5AE14C18ACEEAE1CA267B9ADA6")
        public float getMin() {
            float var546ADE640B6EDFBC8A086EF31347E768_176742219 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_176742219;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.991 -0400", hash_original_method = "CDE9D2624870C8EBE80058272C14174B", hash_generated_method = "7F70340B67CEF84EB99D22453E6FD97F")
        public float getMax() {
            float var546ADE640B6EDFBC8A086EF31347E768_1290210832 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1290210832;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.991 -0400", hash_original_method = "FCC48134B6B008CC9CD869CCEF03FE5F", hash_generated_method = "49E5A5598BE1EF0E07A6CA7DB6A09061")
        public float getRange() {
            float var546ADE640B6EDFBC8A086EF31347E768_1706931582 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1706931582;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.992 -0400", hash_original_method = "6E70447A0F19559DDEE9B218BFC4E0A9", hash_generated_method = "7DF59A49414A2005DAC3D3F6CE8E9049")
        public float getFlat() {
            float var546ADE640B6EDFBC8A086EF31347E768_570128515 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_570128515;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_method = "6C32BE9CB35AEE464A215A2BDA6324A6", hash_generated_method = "6F6226D8FAD330FB626E54B8E4A8103C")
        public float getFuzz() {
            float var546ADE640B6EDFBC8A086EF31347E768_2034964047 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2034964047;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "CE278AAAC0EEDF0668BB29E5EFF55401", hash_generated_field = "79DB10EEA8A684684DB29410B9A96FA0")

    public static final int SOURCE_CLASS_MASK = 0x000000ff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "417AF9EE29AAC27F93BD8A31462A6CD4", hash_generated_field = "E552F6201060CE6A7B2CE06101B73E27")

    public static final int SOURCE_CLASS_BUTTON = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "9555DAB3EC96ACC4F728A7F10BB14481", hash_generated_field = "18DBBE7D23B1AA4FDF7D48FAFD16B7D1")

    public static final int SOURCE_CLASS_POINTER = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "E433ACEBED4290DEA3D11D2D04462355", hash_generated_field = "37A91856BE5B43482A6CC532660B322F")

    public static final int SOURCE_CLASS_TRACKBALL = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "D73C7E3D38AE7B6140145CEC65264C58", hash_generated_field = "0503278EA3937695357A92063C04A747")

    public static final int SOURCE_CLASS_POSITION = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "33AE5DEDE5E9128ED4B35A28864E36B4", hash_generated_field = "AF06B443A783729C3E25A4612CDC3B0D")

    public static final int SOURCE_CLASS_JOYSTICK = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "7A00188CF4A876FEC5734A8B07AE4AEC", hash_generated_field = "F6F380DD90283AD8ED2E8942E2CBEDE2")

    public static final int SOURCE_UNKNOWN = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "D9AA0255E5CEBB40AE6691A4D0B57CC6", hash_generated_field = "441DB42929C199D0380A266A0DB14AA5")

    public static final int SOURCE_KEYBOARD = 0x00000100 | SOURCE_CLASS_BUTTON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "FBD3811E34C4A016BD1048D4E3FF77BA", hash_generated_field = "6EDC9B58D615427A3172FD2132FF7676")

    public static final int SOURCE_DPAD = 0x00000200 | SOURCE_CLASS_BUTTON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "306606F9C139C95841EE0A1DDBFE77E1", hash_generated_field = "7E0C514E09049DD5397963B1A29C34C4")

    public static final int SOURCE_GAMEPAD = 0x00000400 | SOURCE_CLASS_BUTTON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "C2770E63F6DE49117109C6C86D0582C6", hash_generated_field = "515BC29AF997D9AB3CC8C7F1589F726B")

    public static final int SOURCE_TOUCHSCREEN = 0x00001000 | SOURCE_CLASS_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "905E4411A356CA2F1749B2E6D938893F", hash_generated_field = "4CC18EC988EC3A098925B2A857E3567F")

    public static final int SOURCE_MOUSE = 0x00002000 | SOURCE_CLASS_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.993 -0400", hash_original_field = "CC3EB4E32B3305159BA96EA999D33E2A", hash_generated_field = "92EEB77027297EE4EFF782F8EF1FF0F7")

    public static final int SOURCE_STYLUS = 0x00004000 | SOURCE_CLASS_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "49B5C818013877148A116E0FCAA21BD2", hash_generated_field = "9E9C6DB0CFC4958D3637F63294124775")

    public static final int SOURCE_TRACKBALL = 0x00010000 | SOURCE_CLASS_TRACKBALL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "B6A9B0231C193A980A8AE0717FD0EC96", hash_generated_field = "C53F1BB8BA42E382D162BEB6C06A5DA6")

    public static final int SOURCE_TOUCHPAD = 0x00100000 | SOURCE_CLASS_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "4C26E6726FB7CAFA588649FBFBB3E698", hash_generated_field = "2611C3DA236978609FE6ADB1CA63EA73")

    public static final int SOURCE_JOYSTICK = 0x01000000 | SOURCE_CLASS_JOYSTICK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "91B65E67AD0BCE504F7F9A190785F0B0", hash_generated_field = "E9DD51F79C072DFDE77333973F1DFBB8")

    public static final int SOURCE_ANY = 0xffffff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "CEE30D0EDF1C9DF608B6C89AA4B8D09C", hash_generated_field = "7B2FEF95F8CA0D6FBF240CB6110B772A")

    @Deprecated
    public static final int MOTION_RANGE_X = MotionEvent.AXIS_X;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "FA30E93BDDE6E4DF2B43399E4A187E66", hash_generated_field = "18F61B4D7D5E46C987CB6812F2F23765")

    @Deprecated
    public static final int MOTION_RANGE_Y = MotionEvent.AXIS_Y;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "FE1C53E61FDBC13AC4362D813A01CA8D", hash_generated_field = "78402228454C81DFEE033C1B1A06C2D9")

    @Deprecated
    public static final int MOTION_RANGE_PRESSURE = MotionEvent.AXIS_PRESSURE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "368412F9365F9E92B4F5A84291E8C794", hash_generated_field = "D70BF0ADE61441527074BAD011B363EF")

    @Deprecated
    public static final int MOTION_RANGE_SIZE = MotionEvent.AXIS_SIZE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "DB2BBF09F3B04F01AF6C6D133B5BE518", hash_generated_field = "CA1F1E21E04D0900660382D6C6FB2288")

    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MAJOR = MotionEvent.AXIS_TOUCH_MAJOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "5F03D1C8DB410D3AAC45B85F5DE1B84D", hash_generated_field = "D4E5B4D1F104C8CA42C6BF23E778DEB1")

    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MINOR = MotionEvent.AXIS_TOUCH_MINOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "41CC4BCD0AAFCEA34F21E781DDC3BFDE", hash_generated_field = "AD49F028075332D31893082B82F68E04")

    @Deprecated
    public static final int MOTION_RANGE_TOOL_MAJOR = MotionEvent.AXIS_TOOL_MAJOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "BAAE71D6D53DB3FDDB22E7336E3FB7F4", hash_generated_field = "511D721009CA62BDE2CC36BB8E606383")

    @Deprecated
    public static final int MOTION_RANGE_TOOL_MINOR = MotionEvent.AXIS_TOOL_MINOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "40E5DEEB843FB6AE9C1751F78DCF4C7D", hash_generated_field = "563E0FE22373B2EDB536DD2ED09C2EC5")

    @Deprecated
    public static final int MOTION_RANGE_ORIENTATION = MotionEvent.AXIS_ORIENTATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "6D932CBCC6B9EDD8C267B047D9A6A627", hash_generated_field = "507B4AF09182B5A80D31534C6DAEFF45")

    public static final int KEYBOARD_TYPE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "21EDB24132D7DB1EB8CCA6AB24B125BE", hash_generated_field = "145C88DB25C6C4CA9096B45DFE955870")

    public static final int KEYBOARD_TYPE_NON_ALPHABETIC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "9D712DCC960D74DECA08AA4F811EA526", hash_generated_field = "99F61A684F6C37D75D47C8B4FBE3DDA3")

    public static final int KEYBOARD_TYPE_ALPHABETIC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:53.994 -0400", hash_original_field = "0D395022D7ACD5A6443859D3E67FCA44", hash_generated_field = "21D35EEA2F1A31C6EEE3B233C84334EE")

    public static final Parcelable.Creator<InputDevice> CREATOR
            = new Parcelable.Creator<InputDevice>() {
        public InputDevice createFromParcel(Parcel in) {
            InputDevice result = new InputDevice();
            result.readFromParcel(in);
            return result;
        }
        
        public InputDevice[] newArray(int size) {
            return new InputDevice[size];
        }
    };
    
    public InputDevice createFromParcel(Parcel in) {
            InputDevice result = new InputDevice();
            result.readFromParcel(in);
            return result;
        }
    
    
    public InputDevice[] newArray(int size) {
            return new InputDevice[size];
        }
    
}

