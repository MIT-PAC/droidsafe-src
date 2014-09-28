package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class InputDevice implements Parcelable {

    /**
     * Gets information about the input device with the specified id.
     * @param id The device id.
     * @return The input device or null if not found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.367 -0500", hash_original_method = "617D080CD74F90AAB540B4EFDECA9911", hash_generated_method = "7BC6C5EBD73EE06C676013B0BD6BF4AD")
    
public static InputDevice getDevice(int id) {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDevice(id);
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device information from Window Manager.", ex);
        }
    }
    
    /**
     * Gets the ids of all input devices in the system.
     * @return The input device ids.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.369 -0500", hash_original_method = "716B8A04ACA0E57FD1299C1099CDE32D", hash_generated_method = "33B8A268DD6909CE1CFA3F327E40702A")
    
public static int[] getDeviceIds() {
        IWindowManager wm = Display.getWindowManager();
        try {
            return wm.getInputDeviceIds();
        } catch (RemoteException ex) {
            throw new RuntimeException(
                    "Could not get input device ids from Window Manager.", ex);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.286 -0500", hash_original_field = "66AF631211387FE10BB685CD53D152A2", hash_generated_field = "79DB10EEA8A684684DB29410B9A96FA0")

    public static final int SOURCE_CLASS_MASK = 0x000000ff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.289 -0500", hash_original_field = "B44703407145C7F1C3B2E35764248DA8", hash_generated_field = "E552F6201060CE6A7B2CE06101B73E27")

    public static final int SOURCE_CLASS_BUTTON = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.292 -0500", hash_original_field = "894917D4BB3234FC5836BAE57D837B1E", hash_generated_field = "18DBBE7D23B1AA4FDF7D48FAFD16B7D1")

    public static final int SOURCE_CLASS_POINTER = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.294 -0500", hash_original_field = "675113C60F1AAE5F88A0148C2CAAD6D9", hash_generated_field = "37A91856BE5B43482A6CC532660B322F")

    public static final int SOURCE_CLASS_TRACKBALL = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.297 -0500", hash_original_field = "9419BEE30ED1A6676503BC1597F01842", hash_generated_field = "0503278EA3937695357A92063C04A747")

    public static final int SOURCE_CLASS_POSITION = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.300 -0500", hash_original_field = "DB3F6E8216648F093BA4454A48E6CC27", hash_generated_field = "AF06B443A783729C3E25A4612CDC3B0D")

    public static final int SOURCE_CLASS_JOYSTICK = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.302 -0500", hash_original_field = "8F090BF47B3CB3F3253C4C369BC83C51", hash_generated_field = "F6F380DD90283AD8ED2E8942E2CBEDE2")

    public static final int SOURCE_UNKNOWN = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.305 -0500", hash_original_field = "585321483703A36FEDA7B7D5C2C2B1D2", hash_generated_field = "441DB42929C199D0380A266A0DB14AA5")

    public static final int SOURCE_KEYBOARD = 0x00000100 | SOURCE_CLASS_BUTTON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.308 -0500", hash_original_field = "03E304A6EA5FAB71C8515B65C042250A", hash_generated_field = "6EDC9B58D615427A3172FD2132FF7676")

    public static final int SOURCE_DPAD = 0x00000200 | SOURCE_CLASS_BUTTON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.310 -0500", hash_original_field = "12C5CF326C50B29BBB87A68F11A2B21D", hash_generated_field = "7E0C514E09049DD5397963B1A29C34C4")

    public static final int SOURCE_GAMEPAD = 0x00000400 | SOURCE_CLASS_BUTTON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.313 -0500", hash_original_field = "DB6916444F3BAFCE56CDD3B1D481CACF", hash_generated_field = "515BC29AF997D9AB3CC8C7F1589F726B")

    public static final int SOURCE_TOUCHSCREEN = 0x00001000 | SOURCE_CLASS_POINTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.315 -0500", hash_original_field = "E2A0260F7C78825047CD8FD81EFD7A8E", hash_generated_field = "4CC18EC988EC3A098925B2A857E3567F")

    public static final int SOURCE_MOUSE = 0x00002000 | SOURCE_CLASS_POINTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.318 -0500", hash_original_field = "F3A3A565FD358535B6C8F82123F3464E", hash_generated_field = "92EEB77027297EE4EFF782F8EF1FF0F7")

    public static final int SOURCE_STYLUS = 0x00004000 | SOURCE_CLASS_POINTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.320 -0500", hash_original_field = "CCB48329DA4DF717A72DA9CE89F104FE", hash_generated_field = "9E9C6DB0CFC4958D3637F63294124775")

    public static final int SOURCE_TRACKBALL = 0x00010000 | SOURCE_CLASS_TRACKBALL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.322 -0500", hash_original_field = "5F2AB898B4C55720B6E736E31AC483FC", hash_generated_field = "C53F1BB8BA42E382D162BEB6C06A5DA6")

    public static final int SOURCE_TOUCHPAD = 0x00100000 | SOURCE_CLASS_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.325 -0500", hash_original_field = "69CC7ECB954F7506BC8F125D19970273", hash_generated_field = "2611C3DA236978609FE6ADB1CA63EA73")

    public static final int SOURCE_JOYSTICK = 0x01000000 | SOURCE_CLASS_JOYSTICK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.327 -0500", hash_original_field = "82D7FF719BDAABE7A1FAA1E0E6EAB836", hash_generated_field = "E9DD51F79C072DFDE77333973F1DFBB8")

    public static final int SOURCE_ANY = 0xffffff00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.330 -0500", hash_original_field = "CDC0645332BD7352C5366E357F9B6359", hash_generated_field = "7B2FEF95F8CA0D6FBF240CB6110B772A")

    @Deprecated
    public static final int MOTION_RANGE_X = MotionEvent.AXIS_X;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.333 -0500", hash_original_field = "CFA6F86A33811B2088F712DB91A7650E", hash_generated_field = "18F61B4D7D5E46C987CB6812F2F23765")

    @Deprecated
    public static final int MOTION_RANGE_Y = MotionEvent.AXIS_Y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.335 -0500", hash_original_field = "A9771BE3806894ED7544CF3BDF0C0E9F", hash_generated_field = "78402228454C81DFEE033C1B1A06C2D9")

    @Deprecated
    public static final int MOTION_RANGE_PRESSURE = MotionEvent.AXIS_PRESSURE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.338 -0500", hash_original_field = "0020335378A514247BC8661BE83BFC61", hash_generated_field = "D70BF0ADE61441527074BAD011B363EF")

    @Deprecated
    public static final int MOTION_RANGE_SIZE = MotionEvent.AXIS_SIZE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.340 -0500", hash_original_field = "9A6022A43E677B18127AF819AF131A23", hash_generated_field = "CA1F1E21E04D0900660382D6C6FB2288")

    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MAJOR = MotionEvent.AXIS_TOUCH_MAJOR;
    
    public static final class MotionRange {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.397 -0500", hash_original_field = "DE6B5F8A8E01B01D6955CFF5AC6A1196", hash_generated_field = "291186BF7CD64560031686367E49FDA6")

        private int mAxis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.399 -0500", hash_original_field = "11DA1CE39E46044FC7D0DA0865E06F43", hash_generated_field = "D564CAA4C2DB0DC0AAAD32F1767ED66A")

        private int mSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.401 -0500", hash_original_field = "178EA862ED0376AE8765C7120C2B0D2C", hash_generated_field = "C65C1A7B3549B2CAE727CE60B163A9D5")

        private float mMin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.404 -0500", hash_original_field = "49586E9819437ED10960A2451558B838", hash_generated_field = "61EBA81EE8DC22B1F5E764B863E5361B")

        private float mMax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.406 -0500", hash_original_field = "EFC66A5463B7690527BF444F55B9761E", hash_generated_field = "EE76E1A2F0CC7EE13DBD206CE7906C7D")

        private float mFlat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.408 -0500", hash_original_field = "67B0051A4EB3458680212EDE61F8D8C8", hash_generated_field = "88080FE0B3D7FAD3C1754E24E4008D99")

        private float mFuzz;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.411 -0500", hash_original_method = "003C115B43ED25425A82F4C0BC4BFB2D", hash_generated_method = "D463009C9EB0E2425D401CE128054BB0")
        
private MotionRange(int axis, int source, float min, float max, float flat, float fuzz) {
            mAxis = axis;
            mSource = source;
            mMin = min;
            mMax = max;
            mFlat = flat;
            mFuzz = fuzz;
        }

        /**
         * Gets the axis id.
         * @return The axis id.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.413 -0500", hash_original_method = "7AA123496C72318A01ADA9E2FDF13D66", hash_generated_method = "119033B1332952A1AB2AB0A3BDCBA63F")
        
public int getAxis() {
            return mAxis;
        }

        /**
         * Gets the source for which the axis is defined.
         * @return The source.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.416 -0500", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "37E408648F09142C829775B047DEE782")
        
public int getSource() {
            return mSource;
        }

        /**
         * Gets the inclusive minimum value for the axis.
         * @return The inclusive minimum value.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.418 -0500", hash_original_method = "5BD2FEA7B11B9283C78F11EA439073DF", hash_generated_method = "BB3E176470B5D4510F6AC0C42EBA7AC2")
        
public float getMin() {
            return mMin;
        }

        /**
         * Gets the inclusive maximum value for the axis.
         * @return The inclusive maximum value.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.421 -0500", hash_original_method = "CDE9D2624870C8EBE80058272C14174B", hash_generated_method = "344FD9D59085229F8DB479FE996BF4B7")
        
public float getMax() {
            return mMax;
        }

        /**
         * Gets the range of the axis (difference between maximum and minimum).
         * @return The range of values.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.423 -0500", hash_original_method = "FCC48134B6B008CC9CD869CCEF03FE5F", hash_generated_method = "E6A895AA8F92AA489C5ADBB451AE25A9")
        
public float getRange() {
            return mMax - mMin;
        }

        /**
         * Gets the extent of the center flat position with respect to this axis.
         * <p>
         * For example, a flat value of 8 means that the center position is between -8 and +8.
         * This value is mainly useful for calibrating self-centering devices.
         * </p>
         * @return The extent of the center flat position.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.426 -0500", hash_original_method = "6E70447A0F19559DDEE9B218BFC4E0A9", hash_generated_method = "D8AF144CC29FD5DA02EAA9D5412C0267")
        
public float getFlat() {
            return mFlat;
        }

        /**
         * Gets the error tolerance for input device measurements with respect to this axis.
         * <p>
         * For example, a value of 2 indicates that the measured value may be up to +/- 2 units
         * away from the actual value due to noise and device sensitivity limitations.
         * </p>
         * @return The error tolerance.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.428 -0500", hash_original_method = "6C32BE9CB35AEE464A215A2BDA6324A6", hash_generated_method = "E9B070ECFE6804903E47CE7EACE19667")
        
public float getFuzz() {
            return mFuzz;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.343 -0500", hash_original_field = "7182ADA3CE1BFB2D7797DE987827A330", hash_generated_field = "D4E5B4D1F104C8CA42C6BF23E778DEB1")

    @Deprecated
    public static final int MOTION_RANGE_TOUCH_MINOR = MotionEvent.AXIS_TOUCH_MINOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.347 -0500", hash_original_field = "7D5BA5A1DA4CA1633626329354D82079", hash_generated_field = "AD49F028075332D31893082B82F68E04")

    @Deprecated
    public static final int MOTION_RANGE_TOOL_MAJOR = MotionEvent.AXIS_TOOL_MAJOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.350 -0500", hash_original_field = "E5BB17C42AB1C31B865EFBB54780CD37", hash_generated_field = "511D721009CA62BDE2CC36BB8E606383")

    @Deprecated
    public static final int MOTION_RANGE_TOOL_MINOR = MotionEvent.AXIS_TOOL_MINOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.353 -0500", hash_original_field = "D41729EBCD99C4FBC0BA47CCD7ECA1B5", hash_generated_field = "563E0FE22373B2EDB536DD2ED09C2EC5")

    @Deprecated
    public static final int MOTION_RANGE_ORIENTATION = MotionEvent.AXIS_ORIENTATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.355 -0500", hash_original_field = "1210ABDB780C36FE5AF44FF969894AD7", hash_generated_field = "507B4AF09182B5A80D31534C6DAEFF45")

    public static final int KEYBOARD_TYPE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.358 -0500", hash_original_field = "B98C630BD586F9E0E2C13269B9F71E2C", hash_generated_field = "145C88DB25C6C4CA9096B45DFE955870")

    public static final int KEYBOARD_TYPE_NON_ALPHABETIC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.361 -0500", hash_original_field = "566F79DA4B4A42E1088DA6B617F0B9E5", hash_generated_field = "99F61A684F6C37D75D47C8B4FBE3DDA3")

    public static final int KEYBOARD_TYPE_ALPHABETIC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.005 -0400", hash_original_field = "0D395022D7ACD5A6443859D3E67FCA44", hash_generated_field = "21D35EEA2F1A31C6EEE3B233C84334EE")

    public static final Parcelable.Creator<InputDevice> CREATOR
            = new Parcelable.Creator<InputDevice>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.433 -0500", hash_original_method = "A4482F32448D2C09B30B76D771E4FD04", hash_generated_method = "1C9A7A7AE65CEF2F049CE5ABFC1416CA")
        
public InputDevice createFromParcel(Parcel in) {
            InputDevice result = new InputDevice();
            result.readFromParcel(in);
            return result;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.436 -0500", hash_original_method = "2D0218425C4C471D120CA5746FC5C4BA", hash_generated_method = "A9B1F2B40E35A805575F94F8C9AECFC5")
        
public InputDevice[] newArray(int size) {
            return new InputDevice[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.272 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.275 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.277 -0500", hash_original_field = "E153425512B0D84B466F8ACA2E1AEC36", hash_generated_field = "93F8C3686E416465BD516F0456984FB5")

    private int mSources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.279 -0500", hash_original_field = "560FE554C43355D543AB5334B0A3737F", hash_generated_field = "A34912FA2700058D6266925EFA16F418")

    private int mKeyboardType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.281 -0500", hash_original_field = "8C462514055DA1BF3C67CAD41F740EFC", hash_generated_field = "70C3EC525DB53326DF319F2822B78445")

    private String mKeyCharacterMapFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.283 -0500", hash_original_field = "2F49349C025260EF41839D257CCFC6D8", hash_generated_field = "3D9ACF5B843900F5B90A6C764A13538C")

    private final ArrayList<MotionRange> mMotionRanges = new ArrayList<MotionRange>();

    // Called by native code.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.364 -0500", hash_original_method = "2C37C35B619B46784669EFC9CA5E5179", hash_generated_method = "EF21FEBD1D8CB31B9833DDCC077F3763")
    
private InputDevice() {
    }
    
    /**
     * Gets the input device id.
     * @return The input device id.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.371 -0500", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "11DEA77066B2A20ED28C130805C2B9DE")
    
public int getId() {
        return mId;
    }
    
    /**
     * Gets the name of this input device.
     * @return The input device name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.373 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }
    
    /**
     * Gets the input sources supported by this input device as a combined bitfield.
     * @return The supported input sources.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.376 -0500", hash_original_method = "3BD5CDD2AD0F6E345998577876EA9513", hash_generated_method = "4CB920375ED755DF3F38DFDF5E3AB986")
    
public int getSources() {
        return mSources;
    }
    
    /**
     * Gets the keyboard type.
     * @return The keyboard type.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.379 -0500", hash_original_method = "3E019E9C92E6EAD3726AE49F913F1619", hash_generated_method = "AB4393F0105E67E42064EBE153D95003")
    
public int getKeyboardType() {
        return mKeyboardType;
    }
    
    /**
     * Gets the key character map associated with this input device.
     * @return The key character map.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.381 -0500", hash_original_method = "88E280A067EB975F01B9806455B5FBF9", hash_generated_method = "611B2D839650BD7D423E37BCD24B6D45")
    
public KeyCharacterMap getKeyCharacterMap() {
        return KeyCharacterMap.load(mId);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.383 -0500", hash_original_method = "6E63969CFD2DFD594C82531499F7DA54", hash_generated_method = "6E63969CFD2DFD594C82531499F7DA54")
    
String getKeyCharacterMapFile() {
        return mKeyCharacterMapFile;
    }

    /**
     * Gets information about the range of values for a particular {@link MotionEvent} axis.
     * If the device supports multiple sources, the same axis may have different meanings
     * for each source.  Returns information about the first axis found for any source.
     * To obtain information about the axis for a specific source, use
     * {@link #getMotionRange(int, int)}.
     *
     * @param axis The axis constant.
     * @return The range of values, or null if the requested axis is not
     * supported by the device.
     *
     * @see MotionEvent#AXIS_X
     * @see MotionEvent#AXIS_Y
     * @see #getSupportedAxes()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.385 -0500", hash_original_method = "496E5C96705FE1519429C9151F8650BC", hash_generated_method = "6379AEBBE4764AE05828F0A0DC74305A")
    
public MotionRange getMotionRange(int axis) {
        final int numRanges = mMotionRanges.size();
        for (int i = 0; i < numRanges; i++) {
            final MotionRange range = mMotionRanges.get(i);
            if (range.mAxis == axis) {
                return range;
            }
        }
        return null;
    }

    /**
     * Gets information about the range of values for a particular {@link MotionEvent} axis
     * used by a particular source on the device.
     * If the device supports multiple sources, the same axis may have different meanings
     * for each source.
     *
     * @param axis The axis constant.
     * @param source The source for which to return information.
     * @return The range of values, or null if the requested axis is not
     * supported by the device.
     *
     * @see MotionEvent#AXIS_X
     * @see MotionEvent#AXIS_Y
     * @see #getSupportedAxes()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.388 -0500", hash_original_method = "2F158E6F6F2CA810A33FC3C995F22831", hash_generated_method = "A58B2C171FBEE7CB533E8276E61812AC")
    
public MotionRange getMotionRange(int axis, int source) {
        final int numRanges = mMotionRanges.size();
        for (int i = 0; i < numRanges; i++) {
            final MotionRange range = mMotionRanges.get(i);
            if (range.mAxis == axis && range.mSource == source) {
                return range;
            }
        }
        return null;
    }

    /**
     * Gets the ranges for all axes supported by the device.
     * @return The motion ranges for the device.
     *
     * @see #getMotionRange(int, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.390 -0500", hash_original_method = "8F0147E430687E8511683E1D47819832", hash_generated_method = "4D77AE38450C3F67B77C0E16C81B1C69")
    
public List<MotionRange> getMotionRanges() {
        return mMotionRanges;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.393 -0500", hash_original_method = "F938DEDD59851FE8B4D63705E085118B", hash_generated_method = "0F3603C011A2194091D5E6406DF7D606")
    
private void addMotionRange(int axis, int source,
            float min, float max, float flat, float fuzz) {
        mMotionRanges.add(new MotionRange(axis, source, min, max, flat, fuzz));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.441 -0500", hash_original_method = "66E89B3285A9850971D96BAD9F2BB44F", hash_generated_method = "8E5476A5D8910D0832C1DB2A7C8C4C82")
    
private void readFromParcel(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mSources = in.readInt();
        mKeyboardType = in.readInt();
        mKeyCharacterMapFile = in.readString();

        for (;;) {
            int axis = in.readInt();
            if (axis < 0) {
                break;
            }
            addMotionRange(axis, in.readInt(),
                    in.readFloat(), in.readFloat(), in.readFloat(), in.readFloat());
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.444 -0500", hash_original_method = "91853B6BABA9CBC4F027C3C314DDF153", hash_generated_method = "44644FE9A20EECDBA3A08DD54B874281")
    
@Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mId);
        out.writeString(mName);
        out.writeInt(mSources);
        out.writeInt(mKeyboardType);
        out.writeString(mKeyCharacterMapFile);

        final int numRanges = mMotionRanges.size();
        for (int i = 0; i < numRanges; i++) {
            MotionRange range = mMotionRanges.get(i);
            out.writeInt(range.mAxis);
            out.writeInt(range.mSource);
            out.writeFloat(range.mMin);
            out.writeFloat(range.mMax);
            out.writeFloat(range.mFlat);
            out.writeFloat(range.mFuzz);
        }
        out.writeInt(-1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.446 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.450 -0500", hash_original_method = "9F735BD3745C12E449D13E0D45FB54C8", hash_generated_method = "10DE9F01AF1E7DA174A411543A6854B6")
    
@Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("Input Device ").append(mId).append(": ").append(mName).append("\n");
        
        description.append("  Keyboard Type: ");
        switch (mKeyboardType) {
            case KEYBOARD_TYPE_NONE:
                description.append("none");
                break;
            case KEYBOARD_TYPE_NON_ALPHABETIC:
                description.append("non-alphabetic");
                break;
            case KEYBOARD_TYPE_ALPHABETIC:
                description.append("alphabetic");
                break;
        }
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
        for (int i = 0; i < numAxes; i++) {
            MotionRange range = mMotionRanges.get(i);
            description.append("    ").append(MotionEvent.axisToString(range.mAxis));
            description.append(": source=0x").append(Integer.toHexString(range.mSource));
            description.append(" min=").append(range.mMin);
            description.append(" max=").append(range.mMax);
            description.append(" flat=").append(range.mFlat);
            description.append(" fuzz=").append(range.mFuzz);
            description.append("\n");
        }
        return description.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.453 -0500", hash_original_method = "C8D7AE07A3174BF8CEBA0E0E2EC288B0", hash_generated_method = "5BA1D53736C98B494EE8755DBC246A47")
    
private void appendSourceDescriptionIfApplicable(StringBuilder description, int source,
            String sourceName) {
        if ((mSources & source) == source) {
            description.append(" ");
            description.append(sourceName);
        }
    }
    // orphaned legacy method
    public InputDevice createFromParcel(Parcel in) {
            InputDevice result = new InputDevice();
            result.readFromParcel(in);
            return result;
        }
    
    // orphaned legacy method
    public InputDevice[] newArray(int size) {
            return new InputDevice[size];
        }
    
}

