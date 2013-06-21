package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private ArrayList<MotionRange> mMotionRanges = new ArrayList<MotionRange>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.872 -0400", hash_original_method = "2C37C35B619B46784669EFC9CA5E5179", hash_generated_method = "93E63FA312CE70DEEBBCD18536A99918")
    @DSModeled(DSC.SAFE)
    private InputDevice() {
        // ---------- Original Method ----------
    }

    
        public static InputDevice getDevice(int id) {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDevice(id);
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device information from Window Manager.", ex);
        }
    }

    
        public static int[] getDeviceIds() {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDeviceIds();
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device ids from Window Manager.", ex);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.872 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "8621FE03FADC0A3000742A4E8AF6A961")
    @DSModeled(DSC.SAFE)
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.873 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1698AF415E3250D582962C1A88D4A564")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.873 -0400", hash_original_method = "3BD5CDD2AD0F6E345998577876EA9513", hash_generated_method = "946147FC9FF7A2DEA2279EBD84CE4357")
    @DSModeled(DSC.SAFE)
    public int getSources() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.873 -0400", hash_original_method = "3E019E9C92E6EAD3726AE49F913F1619", hash_generated_method = "97D12F62C8C5FEAA90D70073D69B5C61")
    @DSModeled(DSC.SAFE)
    public int getKeyboardType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mKeyboardType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.873 -0400", hash_original_method = "88E280A067EB975F01B9806455B5FBF9", hash_generated_method = "18FF492093C5A4F03A72FFA88BD0172B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyCharacterMap getKeyCharacterMap() {
        KeyCharacterMap varD0C8BEBE8298D1050ADD57E653FEA7F7_1821787386 = (KeyCharacterMap.load(mId));
        return (KeyCharacterMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return KeyCharacterMap.load(mId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.873 -0400", hash_original_method = "6E63969CFD2DFD594C82531499F7DA54", hash_generated_method = "B0A1DF8D812214F291E301570E7F7824")
    @DSModeled(DSC.SAFE)
     String getKeyCharacterMapFile() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mKeyCharacterMapFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.873 -0400", hash_original_method = "496E5C96705FE1519429C9151F8650BC", hash_generated_method = "526AA0ACA3D756A3C9BE6940928EF809")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MotionRange getMotionRange(int axis) {
        dsTaint.addTaint(axis);
        int numRanges;
        numRanges = mMotionRanges.size();
        {
            int i;
            i = 0;
            {
                MotionRange range;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.874 -0400", hash_original_method = "2F158E6F6F2CA810A33FC3C995F22831", hash_generated_method = "42A6F4CC196FF8A16A84D2CA31C556C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MotionRange getMotionRange(int axis, int source) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(source);
        int numRanges;
        numRanges = mMotionRanges.size();
        {
            int i;
            i = 0;
            {
                MotionRange range;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.874 -0400", hash_original_method = "8F0147E430687E8511683E1D47819832", hash_generated_method = "C411D0DA82F21B6160F2D4376C8E7396")
    @DSModeled(DSC.SAFE)
    public List<MotionRange> getMotionRanges() {
        return (List<MotionRange>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMotionRanges;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.874 -0400", hash_original_method = "F938DEDD59851FE8B4D63705E085118B", hash_generated_method = "7FC54A946F1AF5B40B3B47FD4E6D3873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addMotionRange(int axis, int source,
            float min, float max, float flat, float fuzz) {
        dsTaint.addTaint(min);
        dsTaint.addTaint(axis);
        dsTaint.addTaint(max);
        dsTaint.addTaint(fuzz);
        dsTaint.addTaint(source);
        dsTaint.addTaint(flat);
        mMotionRanges.add(new MotionRange(axis, source, min, max, flat, fuzz));
        // ---------- Original Method ----------
        //mMotionRanges.add(new MotionRange(axis, source, min, max, flat, fuzz));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.874 -0400", hash_original_method = "66E89B3285A9850971D96BAD9F2BB44F", hash_generated_method = "169793D156E6A1217995F8278D49C08D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.875 -0400", hash_original_method = "91853B6BABA9CBC4F027C3C314DDF153", hash_generated_method = "99346C9ED3CCC41ACDD4AECB1A2349A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(mId);
        out.writeString(mName);
        out.writeInt(mSources);
        out.writeInt(mKeyboardType);
        out.writeString(mKeyCharacterMapFile);
        int numRanges;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.875 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.875 -0400", hash_original_method = "9F735BD3745C12E449D13E0D45FB54C8", hash_generated_method = "6D8EB772F70F9CD0398DC29E09B4F0FB")
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
        int numAxes;
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
        String var47AB61F4AE2D1BCE8AB035E9AD40ED77_1529027977 = (description.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.876 -0400", hash_original_method = "C8D7AE07A3174BF8CEBA0E0E2EC288B0", hash_generated_method = "8312981854F926AFBAC3D28C37E400A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendSourceDescriptionIfApplicable(StringBuilder description, int source,
            String sourceName) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(sourceName);
        dsTaint.addTaint(description.dsTaint);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.876 -0400", hash_original_method = "003C115B43ED25425A82F4C0BC4BFB2D", hash_generated_method = "66D15268AC2F40B76B8ED5FCF8355757")
        @DSModeled(DSC.SAFE)
        private MotionRange(int axis, int source, float min, float max, float flat, float fuzz) {
            dsTaint.addTaint(min);
            dsTaint.addTaint(axis);
            dsTaint.addTaint(max);
            dsTaint.addTaint(fuzz);
            dsTaint.addTaint(source);
            dsTaint.addTaint(flat);
            // ---------- Original Method ----------
            //mAxis = axis;
            //mSource = source;
            //mMin = min;
            //mMax = max;
            //mFlat = flat;
            //mFuzz = fuzz;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.876 -0400", hash_original_method = "7AA123496C72318A01ADA9E2FDF13D66", hash_generated_method = "1162A1597C8EB728DF14161998A87D73")
        @DSModeled(DSC.SAFE)
        public int getAxis() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mAxis;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.876 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "8FD499AAA821400A88B8E3496E29C961")
        @DSModeled(DSC.SAFE)
        public int getSource() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mSource;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.876 -0400", hash_original_method = "5BD2FEA7B11B9283C78F11EA439073DF", hash_generated_method = "C3A4CFAE36D22C309133B966471FDD8F")
        @DSModeled(DSC.SAFE)
        public float getMin() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mMin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.877 -0400", hash_original_method = "CDE9D2624870C8EBE80058272C14174B", hash_generated_method = "E527FB5D01BC1ABE035FC8240A65B950")
        @DSModeled(DSC.SAFE)
        public float getMax() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mMax;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.877 -0400", hash_original_method = "FCC48134B6B008CC9CD869CCEF03FE5F", hash_generated_method = "97499D0F86EB29AE8885A7E0A9665019")
        @DSModeled(DSC.SAFE)
        public float getRange() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mMax - mMin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.877 -0400", hash_original_method = "6E70447A0F19559DDEE9B218BFC4E0A9", hash_generated_method = "9546254B6917FD90C3E8427346C8DAF1")
        @DSModeled(DSC.SAFE)
        public float getFlat() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mFlat;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.877 -0400", hash_original_method = "6C32BE9CB35AEE464A215A2BDA6324A6", hash_generated_method = "FC604389F118E74290B4CC69CE814189")
        @DSModeled(DSC.SAFE)
        public float getFuzz() {
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            //return mFuzz;
        }

        
    }


    
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
    @Deprecated public static final int MOTION_RANGE_X = MotionEvent.AXIS_X;
    @Deprecated public static final int MOTION_RANGE_Y = MotionEvent.AXIS_Y;
    @Deprecated public static final int MOTION_RANGE_PRESSURE = MotionEvent.AXIS_PRESSURE;
    @Deprecated public static final int MOTION_RANGE_SIZE = MotionEvent.AXIS_SIZE;
    @Deprecated public static final int MOTION_RANGE_TOUCH_MAJOR = MotionEvent.AXIS_TOUCH_MAJOR;
    @Deprecated public static final int MOTION_RANGE_TOUCH_MINOR = MotionEvent.AXIS_TOUCH_MINOR;
    @Deprecated public static final int MOTION_RANGE_TOOL_MAJOR = MotionEvent.AXIS_TOOL_MAJOR;
    @Deprecated public static final int MOTION_RANGE_TOOL_MINOR = MotionEvent.AXIS_TOOL_MINOR;
    @Deprecated public static final int MOTION_RANGE_ORIENTATION = MotionEvent.AXIS_ORIENTATION;
    public static final int KEYBOARD_TYPE_NONE = 0;
    public static final int KEYBOARD_TYPE_NON_ALPHABETIC = 1;
    public static final int KEYBOARD_TYPE_ALPHABETIC = 2;
    public static final Parcelable.Creator<InputDevice> CREATOR = new Parcelable.Creator<InputDevice>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.877 -0400", hash_original_method = "A4482F32448D2C09B30B76D771E4FD04", hash_generated_method = "FAD73F4C144CBBA896DBF83F73639A35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.877 -0400", hash_original_method = "2D0218425C4C471D120CA5746FC5C4BA", hash_generated_method = "4D5DF5E1CCF2E088F7DDBC0A6F5324DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputDevice[] newArray(int size) {
            dsTaint.addTaint(size);
            InputDevice[] var38B4E00AE20CA68A96734A275D1E810C_991770406 = (new InputDevice[size]);
            return (InputDevice[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputDevice[size];
        }

        
}; //Transformed anonymous class
}

