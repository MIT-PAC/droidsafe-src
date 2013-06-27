package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.Widget;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.NumberPicker.OnValueChangeListener;
import com.android.internal.R;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class TimePicker extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.766 -0400", hash_original_field = "AB9371C54D62E21B7C9B3A0218F3CF8E", hash_generated_field = "35FD601AE81D55F188A5E5435A238E5F")

    private boolean mIs24HourView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.766 -0400", hash_original_field = "08C1C0D1B318F7D691C9A50DB6073615", hash_generated_field = "277A014682EEB4651FD9CCF1C4C7A9DA")

    private boolean mIsAm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.766 -0400", hash_original_field = "112FAE7786E1837400A25EDC32E6BAA9", hash_generated_field = "F42DCA1FAFC6800847A12B5E4A4BC187")

    private NumberPicker mHourSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.766 -0400", hash_original_field = "09B03D4C69B668EC5EAC6459524CA437", hash_generated_field = "66959F7A51392B97FA2D1A99294B74C4")

    private NumberPicker mMinuteSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "F3D3F46E713A8370B627E5F348E8F6D2", hash_generated_field = "4D70AE5EB70BA99339D4FD1599F1FEA3")

    private NumberPicker mAmPmSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "E744F3850553FCA943282B8444936010", hash_generated_field = "57B061730C612FA07DDC7E51258E7DA2")

    private EditText mHourSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "5D9DA6546E42E5F3F97B7B4910CBBFB3", hash_generated_field = "B7278DCBB472B1B2F3539E5E1708DD32")

    private EditText mMinuteSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "E343F2337C5FF365E0FA6FF11E40A0D2", hash_generated_field = "FECBCFA86C0EF4E63B91247A25A449D7")

    private EditText mAmPmSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "F12C6C5933E99F70D882693BF3937072")

    private TextView mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "F9FD6AF8CBD99CF98AFC0E531ED08A41", hash_generated_field = "EF3E200E173FD044F8E6084FD0E1491E")

    private Button mAmPmButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "AF87A0964167C5B6A1C3DBC28724FB1E", hash_generated_field = "B1B72D4D154F4798F88DEE511FC04CC0")

    private String[] mAmPmStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "9F4735C7D2833FBB144CCBE86DA0A2AE", hash_generated_field = "0D83C9894006124680A4C4A755D8D1E4")

    private boolean mIsEnabled = DEFAULT_ENABLED_STATE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "90586EBFA5B21544462ED06A9AD45FEB", hash_generated_field = "24067A0BB0CBA588BA40566793730956")

    private OnTimeChangedListener mOnTimeChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "E1D842D489EEA7BD2AB1A49AC19E3D59", hash_generated_field = "BF728D47404D52B2BA92F11A215AFB65")

    private Calendar mTempCalendar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_method = "DB39C8F7A833003C7D32A896903A886B", hash_generated_method = "E09AB0341F9AAF764C085418E7D375E4")
    public  TimePicker(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.767 -0400", hash_original_method = "13212DBF3C0B0551DB88CC2A61A0591D", hash_generated_method = "6911B8C06254E691C71A6E595CCDBF7C")
    public  TimePicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.timePickerStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.787 -0400", hash_original_method = "01E52F88810C7560B77A694B8CE593AF", hash_generated_method = "701157BA2B3A8C4F39B0A55AE6E818BD")
    public  TimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCurrentLocale(Locale.getDefault());
        TypedArray attributesArray;
        attributesArray = context.obtainStyledAttributes(
                attrs, R.styleable.TimePicker, defStyle, 0);
        int layoutResourceId;
        layoutResourceId = attributesArray.getResourceId(
                R.styleable.TimePicker_layout, R.layout.time_picker);
        attributesArray.recycle();
        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(layoutResourceId, this, true);
        mHourSpinner = (NumberPicker) findViewById(R.id.hour);
        mHourSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.776 -0400", hash_original_method = "61CC50AE993360994364CE07AEAADDC8", hash_generated_method = "B29B91024907385FA5D14D83598A2EF4")
            public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                updateInputState();
                {
                    boolean var8A32C210C8A473980EFFE441CCA946A8_1428358799 = (!is24HourView());
                    {
                        {
                            mIsAm = !mIsAm;
                            updateAmPmControl();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                onTimeChanged();
                addTaint(spinner.getTaint());
                addTaint(oldVal);
                addTaint(newVal);
                // ---------- Original Method ----------
                //updateInputState();
                //if (!is24HourView()) {
                    //if ((oldVal == HOURS_IN_HALF_DAY - 1 && newVal == HOURS_IN_HALF_DAY)
                            //|| (oldVal == HOURS_IN_HALF_DAY && newVal == HOURS_IN_HALF_DAY - 1)) {
                        //mIsAm = !mIsAm;
                        //updateAmPmControl();
                    //}
                //}
                //onTimeChanged();
            }
});
        mHourSpinnerInput = (EditText) mHourSpinner.findViewById(R.id.numberpicker_input);
        mHourSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        mDivider = (TextView) findViewById(R.id.divider);
        {
            mDivider.setText(R.string.time_picker_separator);
        } //End block
        mMinuteSpinner = (NumberPicker) findViewById(R.id.minute);
        mMinuteSpinner.setMinValue(0);
        mMinuteSpinner.setMaxValue(59);
        mMinuteSpinner.setOnLongPressUpdateInterval(100);
        mMinuteSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mMinuteSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.778 -0400", hash_original_method = "E7D4D1EDA413A979BF45D3C545C3EF66", hash_generated_method = "36A0B506953A4DD235965A3283A8B16E")
            public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                updateInputState();
                int minValue;
                minValue = mMinuteSpinner.getMinValue();
                int maxValue;
                maxValue = mMinuteSpinner.getMaxValue();
                {
                    int newHour;
                    newHour = mHourSpinner.getValue() + 1;
                    {
                        boolean var3E070F8E4244822177D1F49C27C8E72F_1099339555 = (!is24HourView() && newHour == HOURS_IN_HALF_DAY);
                        {
                            mIsAm = !mIsAm;
                            updateAmPmControl();
                        } //End block
                    } //End collapsed parenthetic
                    mHourSpinner.setValue(newHour);
                } //End block
                {
                    int newHour;
                    newHour = mHourSpinner.getValue() - 1;
                    {
                        boolean varCDEE84F94FD391316B445FBB0BA8F4A8_857914693 = (!is24HourView() && newHour == HOURS_IN_HALF_DAY - 1);
                        {
                            mIsAm = !mIsAm;
                            updateAmPmControl();
                        } //End block
                    } //End collapsed parenthetic
                    mHourSpinner.setValue(newHour);
                } //End block
                onTimeChanged();
                addTaint(spinner.getTaint());
                addTaint(oldVal);
                addTaint(newVal);
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
});
        mMinuteSpinnerInput = (EditText) mMinuteSpinner.findViewById(R.id.numberpicker_input);
        mMinuteSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        mAmPmStrings = new DateFormatSymbols().getAmPmStrings();
        View amPmView;
        amPmView = findViewById(R.id.amPm);
        {
            mAmPmSpinner = null;
            mAmPmSpinnerInput = null;
            mAmPmButton = (Button) amPmView;
            mAmPmButton.setOnClickListener(new OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.786 -0400", hash_original_method = "4F5D6F91E7DB94922D5610C609DBC6AC", hash_generated_method = "62A414B3345481D7A699DD4E23941BEE")
                public void onClick(View button) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    button.requestFocus();
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                    addTaint(button.getTaint());
                    // ---------- Original Method ----------
                    //button.requestFocus();
                    //mIsAm = !mIsAm;
                    //updateAmPmControl();
                }
});
        } //End block
        {
            mAmPmButton = null;
            mAmPmSpinner = (NumberPicker) amPmView;
            mAmPmSpinner.setMinValue(0);
            mAmPmSpinner.setMaxValue(1);
            mAmPmSpinner.setDisplayedValues(mAmPmStrings);
            mAmPmSpinner.setOnValueChangedListener(new OnValueChangeListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.786 -0400", hash_original_method = "C8C0A93031AC50530CF196FDB67DBB38", hash_generated_method = "295283F6481F75840DE041CD929C4536")
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    updateInputState();
                    picker.requestFocus();
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                    addTaint(picker.getTaint());
                    addTaint(oldVal);
                    addTaint(newVal);
                    // ---------- Original Method ----------
                    //updateInputState();
                    //picker.requestFocus();
                    //mIsAm = !mIsAm;
                    //updateAmPmControl();
                }
});
            mAmPmSpinnerInput = (EditText) mAmPmSpinner.findViewById(R.id.numberpicker_input);
            mAmPmSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_DONE);
        } //End block
        updateHourControl();
        updateAmPmControl();
        setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);
        setCurrentHour(mTempCalendar.get(Calendar.HOUR_OF_DAY));
        setCurrentMinute(mTempCalendar.get(Calendar.MINUTE));
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1459002089 = (!isEnabled());
            {
                setEnabled(false);
            } //End block
        } //End collapsed parenthetic
        setContentDescriptions();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.789 -0400", hash_original_method = "8DB20A38842785B537F33F867250F197", hash_generated_method = "ADFA802F64A75E67903EAD558B553060")
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mMinuteSpinner.setEnabled(enabled);
        {
            mDivider.setEnabled(enabled);
        } //End block
        mHourSpinner.setEnabled(enabled);
        {
            mAmPmSpinner.setEnabled(enabled);
        } //End block
        {
            mAmPmButton.setEnabled(enabled);
        } //End block
        mIsEnabled = enabled;
        // ---------- Original Method ----------
        //if (mIsEnabled == enabled) {
            //return;
        //}
        //super.setEnabled(enabled);
        //mMinuteSpinner.setEnabled(enabled);
        //if (mDivider != null) {
            //mDivider.setEnabled(enabled);
        //}
        //mHourSpinner.setEnabled(enabled);
        //if (mAmPmSpinner != null) {
            //mAmPmSpinner.setEnabled(enabled);
        //} else {
            //mAmPmButton.setEnabled(enabled);
        //}
        //mIsEnabled = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.789 -0400", hash_original_method = "FE60B57F2ECB259E877433DACC7AAC95", hash_generated_method = "6628CEEA23C3E2D99E881A3969B17E24")
    @Override
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182908763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182908763;
        // ---------- Original Method ----------
        //return mIsEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.800 -0400", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "FB0A11FC0C47EF7B377125BF2E9C2DD7")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //setCurrentLocale(newConfig.locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.804 -0400", hash_original_method = "980D3FE8BB317B8359A795201150D40B", hash_generated_method = "2BEA2E9604BA0B69BEFCE7F4D9A12C3D")
    private void setCurrentLocale(Locale locale) {
        {
            boolean varD1CF46D36E6B1C6187CE68AE2BC3F432_655316251 = (locale.equals(mCurrentLocale));
        } //End collapsed parenthetic
        mCurrentLocale = locale;
        mTempCalendar = Calendar.getInstance(locale);
        // ---------- Original Method ----------
        //if (locale.equals(mCurrentLocale)) {
            //return;
        //}
        //mCurrentLocale = locale;
        //mTempCalendar = Calendar.getInstance(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.812 -0400", hash_original_method = "72123348A3F05C8EE46260DED41E8111", hash_generated_method = "5E7C2F4F8F4BE5F9FC3644EBEC8EE0F5")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1730999752 = null; //Variable for return #1
        Parcelable superState;
        superState = super.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_1730999752 = new SavedState(superState, getCurrentHour(), getCurrentMinute());
        varB4EAC82CA7396A68D541C85D26508E83_1730999752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1730999752;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState, getCurrentHour(), getCurrentMinute());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.822 -0400", hash_original_method = "B2A487C66396B9A569DF07FC1780728C", hash_generated_method = "3FAF26F13C0E86BC05DCEA862A867E62")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SavedState ss;
        ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCurrentHour(ss.getHour());
        setCurrentMinute(ss.getMinute());
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setCurrentHour(ss.getHour());
        //setCurrentMinute(ss.getMinute());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.822 -0400", hash_original_method = "6B3D4A5E94F1256617D4C5854135F89F", hash_generated_method = "06C44235EEE3C2E117DCBAA9E871B4B2")
    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        mOnTimeChangedListener = onTimeChangedListener;
        // ---------- Original Method ----------
        //mOnTimeChangedListener = onTimeChangedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.823 -0400", hash_original_method = "AE73BE8706F17DAEE1FF393F333C1E75", hash_generated_method = "4801545BBB834B65315F367C325BB021")
    public Integer getCurrentHour() {
        Integer varB4EAC82CA7396A68D541C85D26508E83_773758757 = null; //Variable for return #1
        Integer varB4EAC82CA7396A68D541C85D26508E83_102059373 = null; //Variable for return #2
        Integer varB4EAC82CA7396A68D541C85D26508E83_1581193905 = null; //Variable for return #3
        int currentHour;
        currentHour = mHourSpinner.getValue();
        {
            boolean varFAB15A4F58C6E1453A4D6F7A530C8BA5_374789691 = (is24HourView());
            {
                varB4EAC82CA7396A68D541C85D26508E83_773758757 = currentHour;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_102059373 = currentHour % HOURS_IN_HALF_DAY;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1581193905 = (currentHour % HOURS_IN_HALF_DAY) + HOURS_IN_HALF_DAY;
            } //End block
        } //End collapsed parenthetic
        Integer varA7E53CE21691AB073D9660D615818899_1263467012; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1263467012 = varB4EAC82CA7396A68D541C85D26508E83_773758757;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1263467012 = varB4EAC82CA7396A68D541C85D26508E83_102059373;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1263467012 = varB4EAC82CA7396A68D541C85D26508E83_1581193905;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1263467012.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1263467012;
        // ---------- Original Method ----------
        //int currentHour = mHourSpinner.getValue();
        //if (is24HourView()) {
            //return currentHour;
        //} else if (mIsAm) {
            //return currentHour % HOURS_IN_HALF_DAY;
        //} else {
            //return (currentHour % HOURS_IN_HALF_DAY) + HOURS_IN_HALF_DAY;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.824 -0400", hash_original_method = "51BF76EB890889B8164A1C36DDF3660C", hash_generated_method = "6D194507C24DB12B7BE636A45F361412")
    public void setCurrentHour(Integer currentHour) {
        {
            boolean varEBC734B5A295F39B75E246AB2FD25248_1449424483 = (currentHour == null || currentHour == getCurrentHour());
        } //End collapsed parenthetic
        {
            boolean var19272B72BDCEABDB9528250CA63FAD1F_493082232 = (!is24HourView());
            {
                {
                    mIsAm = false;
                    {
                        currentHour = currentHour - HOURS_IN_HALF_DAY;
                    } //End block
                } //End block
                {
                    mIsAm = true;
                    {
                        currentHour = HOURS_IN_HALF_DAY;
                    } //End block
                } //End block
                updateAmPmControl();
            } //End block
        } //End collapsed parenthetic
        mHourSpinner.setValue(currentHour);
        onTimeChanged();
        addTaint(currentHour.getTaint());
        // ---------- Original Method ----------
        //if (currentHour == null || currentHour == getCurrentHour()) {
            //return;
        //}
        //if (!is24HourView()) {
            //if (currentHour >= HOURS_IN_HALF_DAY) {
                //mIsAm = false;
                //if (currentHour > HOURS_IN_HALF_DAY) {
                    //currentHour = currentHour - HOURS_IN_HALF_DAY;
                //}
            //} else {
                //mIsAm = true;
                //if (currentHour == 0) {
                    //currentHour = HOURS_IN_HALF_DAY;
                //}
            //}
            //updateAmPmControl();
        //}
        //mHourSpinner.setValue(currentHour);
        //onTimeChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.824 -0400", hash_original_method = "241FCC8F6454A30E36E3EC76C851E3F2", hash_generated_method = "F89B7392134BE472852136A7CC86487B")
    public void setIs24HourView(Boolean is24HourView) {
        mIs24HourView = is24HourView;
        int currentHour;
        currentHour = getCurrentHour();
        updateHourControl();
        setCurrentHour(currentHour);
        updateAmPmControl();
        // ---------- Original Method ----------
        //if (mIs24HourView == is24HourView) {
            //return;
        //}
        //mIs24HourView = is24HourView;
        //int currentHour = getCurrentHour();
        //updateHourControl();
        //setCurrentHour(currentHour);
        //updateAmPmControl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.828 -0400", hash_original_method = "4F4BA9CD8FF557544935EB979BB43706", hash_generated_method = "1D85DAFE69FDFDBDA6A36A1BDD1CDDE1")
    public boolean is24HourView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166836240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166836240;
        // ---------- Original Method ----------
        //return mIs24HourView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.828 -0400", hash_original_method = "A85A8F7AA6E48BE779272D70D71211B4", hash_generated_method = "73EEFF6C3FD02E11D63A5B5DE87C2063")
    public Integer getCurrentMinute() {
        Integer varB4EAC82CA7396A68D541C85D26508E83_767665224 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_767665224 = mMinuteSpinner.getValue();
        varB4EAC82CA7396A68D541C85D26508E83_767665224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767665224;
        // ---------- Original Method ----------
        //return mMinuteSpinner.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.829 -0400", hash_original_method = "E5914CBE4C3F7152CD4D96804AFB4FF4", hash_generated_method = "8A6FB4A967FA4DAE1B1494C56E810011")
    public void setCurrentMinute(Integer currentMinute) {
        {
            boolean varDBDB0EB4C2EE8ED59504861D9D7B85AB_1807528661 = (currentMinute == getCurrentMinute());
        } //End collapsed parenthetic
        mMinuteSpinner.setValue(currentMinute);
        onTimeChanged();
        addTaint(currentMinute.getTaint());
        // ---------- Original Method ----------
        //if (currentMinute == getCurrentMinute()) {
            //return;
        //}
        //mMinuteSpinner.setValue(currentMinute);
        //onTimeChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.829 -0400", hash_original_method = "6E8B0AA5C49A67CA109B25D465668749", hash_generated_method = "A9ACF654CE4EAB591C7592D4C305904E")
    @Override
    public int getBaseline() {
        int varFB188FCA7F7E3E5600610236D50C9EFF_914703899 = (mHourSpinner.getBaseline());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036163174 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036163174;
        // ---------- Original Method ----------
        //return mHourSpinner.getBaseline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.829 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "D1C0F5C937217D3E608920163090682C")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981155896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_981155896;
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.842 -0400", hash_original_method = "F102F8EE122BA2E1A10F758465ADC0EB", hash_generated_method = "56E69401379CC7E1A56817929D9F1804")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPopulateAccessibilityEvent(event);
        int flags;
        flags = DateUtils.FORMAT_SHOW_TIME;
        {
            flags |= DateUtils.FORMAT_24HOUR;
        } //End block
        {
            flags |= DateUtils.FORMAT_12HOUR;
        } //End block
        mTempCalendar.set(Calendar.HOUR_OF_DAY, getCurrentHour());
        mTempCalendar.set(Calendar.MINUTE, getCurrentMinute());
        String selectedDateUtterance;
        selectedDateUtterance = DateUtils.formatDateTime(mContext,
                mTempCalendar.getTimeInMillis(), flags);
        event.getText().add(selectedDateUtterance);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //int flags = DateUtils.FORMAT_SHOW_TIME;
        //if (mIs24HourView) {
            //flags |= DateUtils.FORMAT_24HOUR;
        //} else {
            //flags |= DateUtils.FORMAT_12HOUR;
        //}
        //mTempCalendar.set(Calendar.HOUR_OF_DAY, getCurrentHour());
        //mTempCalendar.set(Calendar.MINUTE, getCurrentMinute());
        //String selectedDateUtterance = DateUtils.formatDateTime(mContext,
                //mTempCalendar.getTimeInMillis(), flags);
        //event.getText().add(selectedDateUtterance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.842 -0400", hash_original_method = "D50D8E33466194F955FDB4E6708A42AD", hash_generated_method = "4CD16537D73CD714B4CBBA7B22114BAF")
    private void updateHourControl() {
        {
            boolean varFAB15A4F58C6E1453A4D6F7A530C8BA5_1834654187 = (is24HourView());
            {
                mHourSpinner.setMinValue(0);
                mHourSpinner.setMaxValue(23);
                mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
            } //End block
            {
                mHourSpinner.setMinValue(1);
                mHourSpinner.setMaxValue(12);
                mHourSpinner.setFormatter(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (is24HourView()) {
            //mHourSpinner.setMinValue(0);
            //mHourSpinner.setMaxValue(23);
            //mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        //} else {
            //mHourSpinner.setMinValue(1);
            //mHourSpinner.setMaxValue(12);
            //mHourSpinner.setFormatter(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.843 -0400", hash_original_method = "C352743C674140A19902F99B280928CF", hash_generated_method = "584170054E508893E61AFD5348CE1425")
    private void updateAmPmControl() {
        {
            boolean varFAB15A4F58C6E1453A4D6F7A530C8BA5_365988167 = (is24HourView());
            {
                {
                    mAmPmSpinner.setVisibility(View.GONE);
                } //End block
                {
                    mAmPmButton.setVisibility(View.GONE);
                } //End block
            } //End block
            {
                int index;
                index = Calendar.AM;
                index = Calendar.PM;
                {
                    mAmPmSpinner.setValue(index);
                    mAmPmSpinner.setVisibility(View.VISIBLE);
                } //End block
                {
                    mAmPmButton.setText(mAmPmStrings[index]);
                    mAmPmButton.setVisibility(View.VISIBLE);
                } //End block
            } //End block
        } //End collapsed parenthetic
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        // ---------- Original Method ----------
        //if (is24HourView()) {
            //if (mAmPmSpinner != null) {
                //mAmPmSpinner.setVisibility(View.GONE);
            //} else {
                //mAmPmButton.setVisibility(View.GONE);
            //}
        //} else {
            //int index = mIsAm ? Calendar.AM : Calendar.PM;
            //if (mAmPmSpinner != null) {
                //mAmPmSpinner.setValue(index);
                //mAmPmSpinner.setVisibility(View.VISIBLE);
            //} else {
                //mAmPmButton.setText(mAmPmStrings[index]);
                //mAmPmButton.setVisibility(View.VISIBLE);
            //}
        //}
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.843 -0400", hash_original_method = "8A252D715D292AC897EF9505006002CC", hash_generated_method = "B7298096452F78D8F117C9C037FBB437")
    private void onTimeChanged() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        {
            mOnTimeChangedListener.onTimeChanged(this, getCurrentHour(), getCurrentMinute());
        } //End block
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //if (mOnTimeChangedListener != null) {
            //mOnTimeChangedListener.onTimeChanged(this, getCurrentHour(), getCurrentMinute());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.849 -0400", hash_original_method = "4C27F718F6DC2C1B1670607286108308", hash_generated_method = "F116F473F83E599BBD39EC096E09027E")
    private void setContentDescriptions() {
        String text;
        text = mContext.getString(R.string.time_picker_increment_minute_button);
        mMinuteSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_decrement_minute_button);
        mMinuteSpinner.findViewById(R.id.decrement).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_increment_hour_button);
        mHourSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_decrement_hour_button);
        mHourSpinner.findViewById(R.id.decrement).setContentDescription(text);
        {
            text = mContext.getString(R.string.time_picker_increment_set_pm_button);
            mAmPmSpinner.findViewById(R.id.increment).setContentDescription(text);
            text = mContext.getString(R.string.time_picker_decrement_set_am_button);
            mAmPmSpinner.findViewById(R.id.decrement).setContentDescription(text);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.854 -0400", hash_original_method = "EA3F98147485CBE1A2219199F92431C8", hash_generated_method = "A3A628CEFAC8F235DA040E1ADF9A475B")
    private void updateInputState() {
        InputMethodManager inputMethodManager;
        inputMethodManager = InputMethodManager.peekInstance();
        {
            {
                boolean var4598CF849CA66E5FED61C393E4D1489E_1693492431 = (inputMethodManager.isActive(mHourSpinnerInput));
                {
                    mHourSpinnerInput.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                } //End block
                {
                    boolean var8E6415DD3D919E519BF844CF4369EAC9_1461741381 = (inputMethodManager.isActive(mMinuteSpinnerInput));
                    {
                        mMinuteSpinnerInput.clearFocus();
                        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    } //End block
                    {
                        boolean varDAB46DD19150B7BCB89C5605BC3BC354_1385297315 = (inputMethodManager.isActive(mAmPmSpinnerInput));
                        {
                            mAmPmSpinnerInput.clearFocus();
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
        //if (inputMethodManager != null) {
            //if (inputMethodManager.isActive(mHourSpinnerInput)) {
                //mHourSpinnerInput.clearFocus();
                //inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            //} else if (inputMethodManager.isActive(mMinuteSpinnerInput)) {
                //mMinuteSpinnerInput.clearFocus();
                //inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            //} else if (inputMethodManager.isActive(mAmPmSpinnerInput)) {
                //mAmPmSpinnerInput.clearFocus();
                //inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            //}
        //}
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.857 -0400", hash_original_field = "48AB0AEFD71C009ADE848499A027A428", hash_generated_field = "24E9A2D605497A939CE1099C8C82784A")

        private int mHour;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.858 -0400", hash_original_field = "1D72A8B90C8FB2B549FC5D5E49C93263", hash_generated_field = "30D2971B3212A2F1CF29388B2CF79F78")

        private int mMinute;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.869 -0400", hash_original_method = "F395FF1FB7466B722BA2E9FD639B6FEC", hash_generated_method = "C86B6E4306B51C308B5AA7319DD2D11A")
        private  SavedState(Parcelable superState, int hour, int minute) {
            super(superState);
            mHour = hour;
            mMinute = minute;
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
            //mHour = hour;
            //mMinute = minute;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.870 -0400", hash_original_method = "E55ECE0F217E584D660F2F1E2BD9AF6D", hash_generated_method = "5CC81B14D3F46C2076B5C2B2E083007B")
        private  SavedState(Parcel in) {
            super(in);
            mHour = in.readInt();
            mMinute = in.readInt();
            // ---------- Original Method ----------
            //mHour = in.readInt();
            //mMinute = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.870 -0400", hash_original_method = "E8F47E3750239DF4EC2B02FDC3043C0E", hash_generated_method = "592AEA6A598C39A7E79ECCAAF0D81039")
        public int getHour() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461456126 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461456126;
            // ---------- Original Method ----------
            //return mHour;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.870 -0400", hash_original_method = "3E9A445CD5F3D9118D6AF471987F3B8F", hash_generated_method = "0629D0C62E05605D876FE3B5EE32C341")
        public int getMinute() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074601309 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074601309;
            // ---------- Original Method ----------
            //return mMinute;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.871 -0400", hash_original_method = "3D8FA0B7CDDD47E4194304B24B1FFDDB", hash_generated_method = "26B83AB4BAF455FD2086B69E69601E46")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(mHour);
            dest.writeInt(mMinute);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeInt(mHour);
            //dest.writeInt(mMinute);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.871 -0400", hash_original_field = "D1498A1D28CCBBEB217C9EC7E28F9C3B", hash_generated_field = "D3B74B573149A6A2FC399064332A0A51")

        @SuppressWarnings({"unused", "hiding"})
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    public interface OnTimeChangedListener {

        
        void onTimeChanged(TimePicker view, int hourOfDay, int minute);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.871 -0400", hash_original_field = "341D07F1E4A62FB066D5A2BBC1DD2D1E", hash_generated_field = "2055CC51361317ABAF24A6861F626B8D")

    private static boolean DEFAULT_ENABLED_STATE = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.871 -0400", hash_original_field = "1E26C97037BCBE16DC67E6DFD376FAD7", hash_generated_field = "C8A4F40AFE42226EB3D3089DCDBD07E9")

    private static int HOURS_IN_HALF_DAY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.871 -0400", hash_original_field = "1CD9D27FDE7FAAADFEB2B802DEB63CB0", hash_generated_field = "DCAB73FEFB92990E0C0DD51892FA1C1B")

    private static OnTimeChangedListener NO_OP_CHANGE_LISTENER = new OnTimeChangedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.871 -0400", hash_original_method = "B77065AD2AD822CAFFDDD570BBD12E98", hash_generated_method = "DB3F503D27EF949DABDC7544AC6AFEC7")
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            addTaint(hourOfDay);
            addTaint(minute);
            // ---------- Original Method ----------
        }

        
};
}

