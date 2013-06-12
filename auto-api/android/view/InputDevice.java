package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class InputDevice implements Parcelable {
    private int mId;
    private String mName;
    private int mSources;
    private int mKeyboardType;
    private String mKeyCharacterMapFile;
    private final ArrayList<MotionRange> mMotionRanges = new ArrayList<MotionRange>();
    public static final int SOURCE_CLASS_MASK = 0x000000ff;
    public static final int SOURCE_CLASS_BUTTON = 0x00000001;
    public static final int SOURCE_CLASS_POINTER = 0x00000002;
    public static final int SOURCE_CLASS_TRACKBALL = 0x00000004;
    public static final int SOURCE_CLASS_POSITION = 0x00000008;
    public static final int SOURCE_CLASS_JOYSTICK = 0x00000010;
    public static final int SOURCE_UNKNOWN = 0x00000000;
    public static final int SOURCE_KEYBOARD = 0x00000100 | SOURCE_CLASS_BUTTON;
    public static final int SOURCE_DPAD = 0x00000200 | SOURCE_CLASS_BUTTON;
    public static final int SOURCE_GAMEPAD = 0x00000400 | SOURCE_CLASS_BUTTON;
    public static final int SOURCE_TOUCHSCREEN = 0x00001000 | SOURCE_CLASS_POINTER;
    public static final int SOURCE_MOUSE = 0x00002000 | SOURCE_CLASS_POINTER;
    public static final int SOURCE_STYLUS = 0x00004000 | SOURCE_CLASS_POINTER;
    public static final int SOURCE_TRACKBALL = 0x00010000 | SOURCE_CLASS_TRACKBALL;
    public static final int SOURCE_TOUCHPAD = 0x00100000 | SOURCE_CLASS_POSITION;
    public static final int SOURCE_JOYSTICK = 0x01000000 | SOURCE_CLASS_JOYSTICK;
    public static final int SOURCE_ANY = 0xffffff00;
    @Deprecated
    public static final int MOTION_RANGE_X = MotionEvent.AXIS_X;
    @Deprecated
    public static final int MOTION_RANGE_Y = MotionEvent.AXIS_Y;
    @Deprecated
    public static final int MOTION_RANGE_PRESSURE = MotionEvent.AXIS_PRESSURE;
    @Deprecated
    public static final int MOTION_RANGE_SIZE = MotionEvent.AXIS_SIZE;
    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MAJOR = MotionEvent.AXIS_TOUCH_MAJOR;
    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MINOR = MotionEvent.AXIS_TOUCH_MINOR;
    @Deprecated
    public static final int MOTION_RANGE_TOOL_MAJOR = MotionEvent.AXIS_TOOL_MAJOR;
    @Deprecated
    public static final int MOTION_RANGE_TOOL_MINOR = MotionEvent.AXIS_TOOL_MINOR;
    @Deprecated
    public static final int MOTION_RANGE_ORIENTATION = MotionEvent.AXIS_ORIENTATION;
    public static final int KEYBOARD_TYPE_NONE = 0;
    public static final int KEYBOARD_TYPE_NON_ALPHABETIC = 1;
    public static final int KEYBOARD_TYPE_ALPHABETIC = 2;
    public static final Parcelable.Creator<InputDevice> CREATOR = new Parcelable.Creator<InputDevice>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.022 -0400", hash_original_method = "A4482F32448D2C09B30B76D771E4FD04", hash_generated_method = "61E8F643EBCA1A070F1573B0D36EB4F6")
        @DSModeled(DSC.SAFE)
        public InputDevice createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            InputDevice result;
            result = new InputDevice();
            result.readFromParcel(in);
            return (InputDevice)dsTaint.getTaint();
            // ---------- Original Method ----------
            //InputDevice result = new InputDevice();
            //result.readFromParcel(in);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.022 -0400", hash_original_method = "2D0218425C4C471D120CA5746FC5C4BA", hash_generated_method = "3F714B14F751D643D2740CC2F96387B3")
        @DSModeled(DSC.SAFE)
        public InputDevice[] newArray(int size) {
            dsTaint.addTaint(size);
            return (InputDevice[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputDevice[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.022 -0400", hash_original_method = "2C37C35B619B46784669EFC9CA5E5179", hash_generated_method = "F675A7A9720415FDB82309D01C899489")
    @DSModeled(DSC.SAFE)
    private InputDevice() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.022 -0400", hash_original_method = "617D080CD74F90AAB540B4EFDECA9911", hash_generated_method = "7BC6C5EBD73EE06C676013B0BD6BF4AD")
    public static InputDevice getDevice(int id) {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDevice(id);
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device information from Window Manager.", ex);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.022 -0400", hash_original_method = "716B8A04ACA0E57FD1299C1099CDE32D", hash_generated_method = "33B8A268DD6909CE1CFA3F327E40702A")
    public static int[] getDeviceIds() {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDeviceIds();
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device ids from Window Manager.", ex);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.022 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "BD5201533D12EB9AC626344A2998C6BC")
    @DSModeled(DSC.SAFE)
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "5B64F8F5AC7FE997D96CC003BA212E34")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "3BD5CDD2AD0F6E345998577876EA9513", hash_generated_method = "AB588A3E7A9E3A300AFE3F30F78472E0")
    @DSModeled(DSC.SAFE)
    public int getSources() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "3E019E9C92E6EAD3726AE49F913F1619", hash_generated_method = "6A12FC02CCE74CDA7744C8361F600D1F")
    @DSModeled(DSC.SAFE)
    public int getKeyboardType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mKeyboardType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "88E280A067EB975F01B9806455B5FBF9", hash_generated_method = "8725204C3F31D44AF245ADF5B81593DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyCharacterMap getKeyCharacterMap() {
        KeyCharacterMap varD0C8BEBE8298D1050ADD57E653FEA7F7_803662933 = (KeyCharacterMap.load(mId));
        return (KeyCharacterMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return KeyCharacterMap.load(mId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "6E63969CFD2DFD594C82531499F7DA54", hash_generated_method = "B6EDCA414D168D89C97E6EF191592AF0")
    @DSModeled(DSC.SAFE)
     String getKeyCharacterMapFile() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mKeyCharacterMapFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "496E5C96705FE1519429C9151F8650BC", hash_generated_method = "11A79B8D6AE6AF8F687F7E5E59418EAE")
    @DSModeled(DSC.SAFE)
    public MotionRange getMotionRange(int axis) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(axis);
        final int numRanges;
        numRanges = mMotionRanges.size();
        {
            int i;
            i = 0;
            {
                final MotionRange range;
                range = mMotionRanges.get(i);
            } //End block
        } //End collapsed parenthetic
        return (MotionRange)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int numRanges = mMotionRanges.size();
        //for (int i = 0; i < numRanges; i++) {
            //final MotionRange range = mMotionRanges.get(i);
            //if (range.mAxis == axis) {
                //return range;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "2F158E6F6F2CA810A33FC3C995F22831", hash_generated_method = "57FD6E5D37E87A41594F2D6C42CB5A38")
    @DSModeled(DSC.SAFE)
    public MotionRange getMotionRange(int axis, int source) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(axis);
        dsTaint.addTaint(source);
        final int numRanges;
        numRanges = mMotionRanges.size();
        {
            int i;
            i = 0;
            {
                final MotionRange range;
                range = mMotionRanges.get(i);
            } //End block
        } //End collapsed parenthetic
        return (MotionRange)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final int numRanges = mMotionRanges.size();
        //for (int i = 0; i < numRanges; i++) {
            //final MotionRange range = mMotionRanges.get(i);
            //if (range.mAxis == axis && range.mSource == source) {
                //return range;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "8F0147E430687E8511683E1D47819832", hash_generated_method = "A021131BF8D8971D4C23A528EACAD898")
    @DSModeled(DSC.SAFE)
    public List<MotionRange> getMotionRanges() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (List<MotionRange>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMotionRanges;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "F938DEDD59851FE8B4D63705E085118B", hash_generated_method = "8F47A8CFFBDFF29EAE860E91E0C75996")
    @DSModeled(DSC.SAFE)
    private void addMotionRange(int axis, int source,
            float min, float max, float flat, float fuzz) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(min);
        dsTaint.addTaint(max);
        dsTaint.addTaint(source);
        dsTaint.addTaint(fuzz);
        dsTaint.addTaint(flat);
        mMotionRanges.add(new MotionRange(axis, source, min, max, flat, fuzz));
        // ---------- Original Method ----------
        //mMotionRanges.add(new MotionRange(axis, source, min, max, flat, fuzz));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.023 -0400", hash_original_method = "66E89B3285A9850971D96BAD9F2BB44F", hash_generated_method = "6099C81C313ED64B986068490EE5E593")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mId = in.readInt();
        mName = in.readString();
        mSources = in.readInt();
        mKeyboardType = in.readInt();
        mKeyCharacterMapFile = in.readString();
        {
            int axis;
            axis = in.readInt();
            addMotionRange(axis, in.readInt(),
                    in.readFloat(), in.readFloat(), in.readFloat(), in.readFloat());
        } //End block
        // ---------- Original Method ----------
        //mId = in.readInt();
        //mName = in.readString();
        //mSources = in.readInt();
        //mKeyboardType = in.readInt();
        //mKeyCharacterMapFile = in.readString();
        //for (;;) {
            //int axis = in.readInt();
            //if (axis < 0) {
                //break;
            //}
            //addMotionRange(axis, in.readInt(),
                    //in.readFloat(), in.readFloat(), in.readFloat(), in.readFloat());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.024 -0400", hash_original_method = "91853B6BABA9CBC4F027C3C314DDF153", hash_generated_method = "215DA29991BA1A3B6448CACEFC12F74F")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(mId);
        out.writeString(mName);
        out.writeInt(mSources);
        out.writeInt(mKeyboardType);
        out.writeString(mKeyCharacterMapFile);
        final int numRanges;
        numRanges = mMotionRanges.size();
        {
            int i;
            i = 0;
            {
                MotionRange range;
                range = mMotionRanges.get(i);
                out.writeInt(range.mAxis);
                out.writeInt(range.mSource);
                out.writeFloat(range.mMin);
                out.writeFloat(range.mMax);
                out.writeFloat(range.mFlat);
                out.writeFloat(range.mFuzz);
            } //End block
        } //End collapsed parenthetic
        out.writeInt(-1);
        // ---------- Original Method ----------
        //out.writeInt(mId);
        //out.writeString(mName);
        //out.writeInt(mSources);
        //out.writeInt(mKeyboardType);
        //out.writeString(mKeyCharacterMapFile);
        //final int numRanges = mMotionRanges.size();
        //for (int i = 0; i < numRanges; i++) {
            //MotionRange range = mMotionRanges.get(i);
            //out.writeInt(range.mAxis);
            //out.writeInt(range.mSource);
            //out.writeFloat(range.mMin);
            //out.writeFloat(range.mMax);
            //out.writeFloat(range.mFlat);
            //out.writeFloat(range.mFuzz);
        //}
        //out.writeInt(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.024 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.024 -0400", hash_original_method = "9F735BD3745C12E449D13E0D45FB54C8", hash_generated_method = "B2FF35374C0C9DF8B2AC4EC90085A764")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder description;
        description = new StringBuilder();
        description.append("Input Device ").append(mId).append(": ").append(mName).append("\n");
        description.append("  Keyboard Type: ");
        //Begin case KEYBOARD_TYPE_NONE 
        description.append("none");
        //End case KEYBOARD_TYPE_NONE 
        //Begin case KEYBOARD_TYPE_NON_ALPHABETIC 
        description.append("non-alphabetic");
        //End case KEYBOARD_TYPE_NON_ALPHABETIC 
        //Begin case KEYBOARD_TYPE_ALPHABETIC 
        description.append("alphabetic");
        //End case KEYBOARD_TYPE_ALPHABETIC 
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
        final int numAxes;
        numAxes = mMotionRanges.size();
        {
            int i;
            i = 0;
            {
                MotionRange range;
                range = mMotionRanges.get(i);
                description.append("    ").append(MotionEvent.axisToString(range.mAxis));
                description.append(": source=0x").append(Integer.toHexString(range.mSource));
                description.append(" min=").append(range.mMin);
                description.append(" max=").append(range.mMax);
                description.append(" flat=").append(range.mFlat);
                description.append(" fuzz=").append(range.mFuzz);
                description.append("\n");
            } //End block
        } //End collapsed parenthetic
        String var47AB61F4AE2D1BCE8AB035E9AD40ED77_306832960 = (description.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.024 -0400", hash_original_method = "C8D7AE07A3174BF8CEBA0E0E2EC288B0", hash_generated_method = "851E6326E45F4222794EF61D6ADB3A97")
    @DSModeled(DSC.SAFE)
    private void appendSourceDescriptionIfApplicable(StringBuilder description, int source,
            String sourceName) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(description.dsTaint);
        dsTaint.addTaint(sourceName);
        {
            description.append(" ");
            description.append(sourceName);
        } //End block
        // ---------- Original Method ----------
        //if ((mSources & source) == source) {
            //description.append(" ");
            //description.append(sourceName);
        //}
    }

    
    public static final class MotionRange {
        private int mAxis;
        private int mSource;
        private float mMin;
        private float mMax;
        private float mFlat;
        private float mFuzz;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "003C115B43ED25425A82F4C0BC4BFB2D", hash_generated_method = "0E1B1A480EEAF1D5AE67DF70866D3622")
        @DSModeled(DSC.SAFE)
        private MotionRange(int axis, int source, float min, float max, float flat, float fuzz) {
            dsTaint.addTaint(axis);
            dsTaint.addTaint(min);
            dsTaint.addTaint(max);
            dsTaint.addTaint(source);
            dsTaint.addTaint(fuzz);
            dsTaint.addTaint(flat);
            // ---------- Original Method ----------
            //mAxis = axis;
            //mSource = source;
            //mMin = min;
            //mMax = max;
            //mFlat = flat;
            //mFuzz = fuzz;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "7AA123496C72318A01ADA9E2FDF13D66", hash_generated_method = "1418AD6777B1AF7B344DAC5A5E3CF2EA")
        @DSModeled(DSC.SAFE)
        public int getAxis() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mAxis;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "2639512206DBA63ABB21D41097C640E3")
        @DSModeled(DSC.SAFE)
        public int getSource() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSource;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "5BD2FEA7B11B9283C78F11EA439073DF", hash_generated_method = "0490FC7696B63A69514955FF6DB01D64")
        @DSModeled(DSC.SAFE)
        public float getMin() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mMin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "CDE9D2624870C8EBE80058272C14174B", hash_generated_method = "B270C7A23FEC9DAF39B81CE291B243DE")
        @DSModeled(DSC.SAFE)
        public float getMax() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mMax;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "FCC48134B6B008CC9CD869CCEF03FE5F", hash_generated_method = "E576E71DE4C576C273A17B685B1A3C6B")
        @DSModeled(DSC.SAFE)
        public float getRange() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mMax - mMin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "6E70447A0F19559DDEE9B218BFC4E0A9", hash_generated_method = "7169FD9A3A579C77AD6427F8708255EE")
        @DSModeled(DSC.SAFE)
        public float getFlat() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mFlat;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.025 -0400", hash_original_method = "6C32BE9CB35AEE464A215A2BDA6324A6", hash_generated_method = "F49E25522B35ABE80FEB322695CB3D8C")
        @DSModeled(DSC.SAFE)
        public float getFuzz() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mFuzz;
        }

        
    }


    
}


