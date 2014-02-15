package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

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

public class TimePicker extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.017 -0500", hash_original_field = "898BA2CFB8E606FE0E662F55EA307C06", hash_generated_field = "C8A8F0463DBF19CC5664F198B037CB59")

    private static final boolean DEFAULT_ENABLED_STATE = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.019 -0500", hash_original_field = "A102152C3DBBB0ED26E24AC8687BFA18", hash_generated_field = "65EDE4F9048CF09D46EC35F5340020DF")

    private static final int HOURS_IN_HALF_DAY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.166 -0400", hash_original_field = "1CD9D27FDE7FAAADFEB2B802DEB63CB0", hash_generated_field = "B0CF16601ED0546FD3ADD3537BFCA4D8")

    private static final OnTimeChangedListener NO_OP_CHANGE_LISTENER = new OnTimeChangedListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.166 -0400", hash_original_method = "B77065AD2AD822CAFFDDD570BBD12E98", hash_generated_method = "DB3F503D27EF949DABDC7544AC6AFEC7")
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            
            addTaint(view.getTaint());
            addTaint(hourOfDay);
            addTaint(minute);
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.027 -0500", hash_original_field = "1BD5FED04D35AC29B74011298319A7F8", hash_generated_field = "35FD601AE81D55F188A5E5435A238E5F")

    private boolean mIs24HourView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.029 -0500", hash_original_field = "1B79D3BE8F5D99F13BC97499CA7CE611", hash_generated_field = "277A014682EEB4651FD9CCF1C4C7A9DA")

    private boolean mIsAm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.031 -0500", hash_original_field = "39F9B6C45E1E2C810E76551E44B44C25", hash_generated_field = "F42DCA1FAFC6800847A12B5E4A4BC187")

    private  NumberPicker mHourSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.033 -0500", hash_original_field = "926A3D4497DB08D89A3E5E1D83657D23", hash_generated_field = "66959F7A51392B97FA2D1A99294B74C4")

    private  NumberPicker mMinuteSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.035 -0500", hash_original_field = "C1A7489F4948BACEA60D3800EB230D04", hash_generated_field = "4D70AE5EB70BA99339D4FD1599F1FEA3")

    private  NumberPicker mAmPmSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.037 -0500", hash_original_field = "AE0A5E28ECBADE4B2E62EAEA9CEE9A3C", hash_generated_field = "57B061730C612FA07DDC7E51258E7DA2")

    private  EditText mHourSpinnerInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.040 -0500", hash_original_field = "0FD19F4AA32A8FAC3C5FDDC7B3BB7F0A", hash_generated_field = "B7278DCBB472B1B2F3539E5E1708DD32")

    private  EditText mMinuteSpinnerInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.042 -0500", hash_original_field = "5DBD6868AFE924E33678CEBAB6611928", hash_generated_field = "FECBCFA86C0EF4E63B91247A25A449D7")

    private  EditText mAmPmSpinnerInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.045 -0500", hash_original_field = "EE9EE4D1F4838E781C34CBBD005DDFFA", hash_generated_field = "F12C6C5933E99F70D882693BF3937072")

    private  TextView mDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.047 -0500", hash_original_field = "2A4FEAD27CDA4EB68BE6F0CF829EEEB8", hash_generated_field = "97AF47CC74DFA7A454BABC1F1A356BFB")

    // using a button for toggling between AM/PM while the new
    // version uses a NumberPicker spinner. Therefore the code
    // accommodates these two cases to be backwards compatible.
    private  Button mAmPmButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.049 -0500", hash_original_field = "F04BBB05AA6B86332BF9BCA0567979EC", hash_generated_field = "B1B72D4D154F4798F88DEE511FC04CC0")

    private  String[] mAmPmStrings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.051 -0500", hash_original_field = "D4A6DCF8382D9EC800648673F5DFADA3", hash_generated_field = "0D83C9894006124680A4C4A755D8D1E4")

    private boolean mIsEnabled = DEFAULT_ENABLED_STATE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.053 -0500", hash_original_field = "ED6CDDD1774814F81E4D2D10B62FDB09", hash_generated_field = "24067A0BB0CBA588BA40566793730956")

    private OnTimeChangedListener mOnTimeChangedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.055 -0500", hash_original_field = "44FA62115EFD78AD1A83722B5DBE2057", hash_generated_field = "BF728D47404D52B2BA92F11A215AFB65")

    private Calendar mTempCalendar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.057 -0500", hash_original_field = "0400C5C553DC4CBF37271C21855854A7", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.062 -0500", hash_original_method = "DB39C8F7A833003C7D32A896903A886B", hash_generated_method = "D68D0ED22B31427BC1C546F2BA4B2ACD")
    
public TimePicker(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.065 -0500", hash_original_method = "13212DBF3C0B0551DB88CC2A61A0591D", hash_generated_method = "12CEED4892E7AE7C9EE5E80462EBC2AD")
    
public TimePicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.timePickerStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.081 -0500", hash_original_method = "01E52F88810C7560B77A694B8CE593AF", hash_generated_method = "A88833ABD457298F1DD4A4B4997EC1C6")
    
public TimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // initialization based on locale
        setCurrentLocale(Locale.getDefault());

        // process style attributes
        TypedArray attributesArray = context.obtainStyledAttributes(
                attrs, R.styleable.TimePicker, defStyle, 0);
        int layoutResourceId = attributesArray.getResourceId(
                R.styleable.TimePicker_layout, R.layout.time_picker);
        attributesArray.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(layoutResourceId, this, true);

        // hour
        mHourSpinner = (NumberPicker) findViewById(R.id.hour);
        mHourSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
                updateInputState();
                if (!is24HourView()) {
                    if ((oldVal == HOURS_IN_HALF_DAY - 1 && newVal == HOURS_IN_HALF_DAY)
                            || (oldVal == HOURS_IN_HALF_DAY && newVal == HOURS_IN_HALF_DAY - 1)) {
                        mIsAm = !mIsAm;
                        updateAmPmControl();
                    }
                }
                onTimeChanged();
            }
        });
        mHourSpinnerInput = (EditText) mHourSpinner.findViewById(R.id.numberpicker_input);
        mHourSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);

        // divider (only for the new widget style)
        mDivider = (TextView) findViewById(R.id.divider);
        if (mDivider != null) {
            mDivider.setText(R.string.time_picker_separator);
        }

        // minute
        mMinuteSpinner = (NumberPicker) findViewById(R.id.minute);
        mMinuteSpinner.setMinValue(0);
        mMinuteSpinner.setMaxValue(59);
        mMinuteSpinner.setOnLongPressUpdateInterval(100);
        mMinuteSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mMinuteSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
                updateInputState();
                int minValue = mMinuteSpinner.getMinValue();
                int maxValue = mMinuteSpinner.getMaxValue();
                if (oldVal == maxValue && newVal == minValue) {
                    int newHour = mHourSpinner.getValue() + 1;
                    if (!is24HourView() && newHour == HOURS_IN_HALF_DAY) {
                        mIsAm = !mIsAm;
                        updateAmPmControl();
                    }
                    mHourSpinner.setValue(newHour);
                } else if (oldVal == minValue && newVal == maxValue) {
                    int newHour = mHourSpinner.getValue() - 1;
                    if (!is24HourView() && newHour == HOURS_IN_HALF_DAY - 1) {
                        mIsAm = !mIsAm;
                        updateAmPmControl();
                    }
                    mHourSpinner.setValue(newHour);
                }
                onTimeChanged();
            }
        });
        mMinuteSpinnerInput = (EditText) mMinuteSpinner.findViewById(R.id.numberpicker_input);
        mMinuteSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);

        /* Get the localized am/pm strings and use them in the spinner */
        mAmPmStrings = new DateFormatSymbols().getAmPmStrings();

        // am/pm
        View amPmView = findViewById(R.id.amPm);
        if (amPmView instanceof Button) {
            mAmPmSpinner = null;
            mAmPmSpinnerInput = null;
            mAmPmButton = (Button) amPmView;
            mAmPmButton.setOnClickListener(new OnClickListener() {
                public void onClick(View button) {
                    button.requestFocus();
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                }
            });
        } else {
            mAmPmButton = null;
            mAmPmSpinner = (NumberPicker) amPmView;
            mAmPmSpinner.setMinValue(0);
            mAmPmSpinner.setMaxValue(1);
            mAmPmSpinner.setDisplayedValues(mAmPmStrings);
            mAmPmSpinner.setOnValueChangedListener(new OnValueChangeListener() {
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    updateInputState();
                    picker.requestFocus();
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                }
            });
            mAmPmSpinnerInput = (EditText) mAmPmSpinner.findViewById(R.id.numberpicker_input);
            mAmPmSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_DONE);
        }

        // update controls to initial state
        updateHourControl();
        updateAmPmControl();

        setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);

        // set to current time
        setCurrentHour(mTempCalendar.get(Calendar.HOUR_OF_DAY));
        setCurrentMinute(mTempCalendar.get(Calendar.MINUTE));

        if (!isEnabled()) {
            setEnabled(false);
        }

        // set the content descriptions
        setContentDescriptions();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.083 -0500", hash_original_method = "8DB20A38842785B537F33F867250F197", hash_generated_method = "6BEF8DF95D76AC7917B83C3A1BB0FB68")
    
@Override
    public void setEnabled(boolean enabled) {
        if (mIsEnabled == enabled) {
            return;
        }
        super.setEnabled(enabled);
        mMinuteSpinner.setEnabled(enabled);
        if (mDivider != null) {
            mDivider.setEnabled(enabled);
        }
        mHourSpinner.setEnabled(enabled);
        if (mAmPmSpinner != null) {
            mAmPmSpinner.setEnabled(enabled);
        } else {
            mAmPmButton.setEnabled(enabled);
        }
        mIsEnabled = enabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.086 -0500", hash_original_method = "FE60B57F2ECB259E877433DACC7AAC95", hash_generated_method = "E052E34E14B49938085DD6DF12A76E29")
    
@Override
    public boolean isEnabled() {
        return mIsEnabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.088 -0500", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "6328851CBC85DA1645204E969B0A309A")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
    }

    /**
     * Sets the current locale.
     *
     * @param locale The current locale.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.091 -0500", hash_original_method = "980D3FE8BB317B8359A795201150D40B", hash_generated_method = "5D5069291485E60BE304298AD119403E")
    
private void setCurrentLocale(Locale locale) {
        if (locale.equals(mCurrentLocale)) {
            return;
        }
        mCurrentLocale = locale;
        mTempCalendar = Calendar.getInstance(locale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.120 -0500", hash_original_method = "72123348A3F05C8EE46260DED41E8111", hash_generated_method = "A4A6445FED32D2BB5D65957330EAE4E5")
    
@Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new SavedState(superState, getCurrentHour(), getCurrentMinute());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.123 -0500", hash_original_method = "B2A487C66396B9A569DF07FC1780728C", hash_generated_method = "BEDE5230168F82A049FAE7CCB16735DB")
    
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCurrentHour(ss.getHour());
        setCurrentMinute(ss.getMinute());
    }

    /**
     * Set the callback that indicates the time has been adjusted by the user.
     *
     * @param onTimeChangedListener the callback, should not be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.125 -0500", hash_original_method = "6B3D4A5E94F1256617D4C5854135F89F", hash_generated_method = "6D13FFE088285C8C5D84E67519FC065F")
    @DSVerified
    @DSSafe(DSCat.GUI) 
public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        mOnTimeChangedListener = onTimeChangedListener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged(this,  DSUtils.FAKE_INT, DSUtils.FAKE_INT);
        }
    }

    /**
     * @return The current hour in the range (0-23).
     */
    @DSComment("TimePicker, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.128 -0500", hash_original_method = "AE73BE8706F17DAEE1FF393F333C1E75", hash_generated_method = "F008939409E801B970BC0D0D87C95588")
    
public Integer getCurrentHour() {
        int currentHour = mHourSpinner.getValue();
        if (is24HourView()) {
            return currentHour;
        } else if (mIsAm) {
            return currentHour % HOURS_IN_HALF_DAY;
        } else {
            return (currentHour % HOURS_IN_HALF_DAY) + HOURS_IN_HALF_DAY;
        }
    }

    /**
     * Set the current hour.
     */
    @DSComment("TimePicker, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.130 -0500", hash_original_method = "51BF76EB890889B8164A1C36DDF3660C", hash_generated_method = "5FFDEA0FFFFD2EE3195E1B4F83E97B5C")
    
public void setCurrentHour(Integer currentHour) {
        // why was Integer used in the first place?
        if (currentHour == null || currentHour == getCurrentHour()) {
            return;
        }
        if (!is24HourView()) {
            // convert [0,23] ordinal to wall clock display
            if (currentHour >= HOURS_IN_HALF_DAY) {
                mIsAm = false;
                if (currentHour > HOURS_IN_HALF_DAY) {
                    currentHour = currentHour - HOURS_IN_HALF_DAY;
                }
            } else {
                mIsAm = true;
                if (currentHour == 0) {
                    currentHour = HOURS_IN_HALF_DAY;
                }
            }
            updateAmPmControl();
        }
        mHourSpinner.setValue(currentHour);
        onTimeChanged();
    }

    /**
     * Set whether in 24 hour or AM/PM mode.
     *
     * @param is24HourView True = 24 hour mode. False = AM/PM.
     */
    @DSComment("TimePicker, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.132 -0500", hash_original_method = "241FCC8F6454A30E36E3EC76C851E3F2", hash_generated_method = "D9D0439E1B3E4FCC3AD3D9DB109E9B54")
    
public void setIs24HourView(Boolean is24HourView) {
        if (mIs24HourView == is24HourView) {
            return;
        }
        mIs24HourView = is24HourView;
        // cache the current hour since spinner range changes
        int currentHour = getCurrentHour();
        updateHourControl();
        // set value after spinner range is updated
        setCurrentHour(currentHour);
        updateAmPmControl();
    }

    /**
     * @return true if this is in 24 hour view else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.134 -0500", hash_original_method = "4F4BA9CD8FF557544935EB979BB43706", hash_generated_method = "6B9E658426DA583E4399B78B63C41B46")
    
public boolean is24HourView() {
        return mIs24HourView;
    }

    /**
     * @return The current minute.
     */
    @DSComment("TimePicker, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.136 -0500", hash_original_method = "A85A8F7AA6E48BE779272D70D71211B4", hash_generated_method = "F0211D9F8029EFFFC8877A7E3437CBF0")
    
public Integer getCurrentMinute() {
        return mMinuteSpinner.getValue();
    }

    /**
     * Set the current minute (0-59).
     */
    @DSComment("TimePicker, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.139 -0500", hash_original_method = "E5914CBE4C3F7152CD4D96804AFB4FF4", hash_generated_method = "379BEE9B0E1DBD75619021B07302B3DA")
    
public void setCurrentMinute(Integer currentMinute) {
        if (currentMinute == getCurrentMinute()) {
            return;
        }
        mMinuteSpinner.setValue(currentMinute);
        onTimeChanged();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.141 -0500", hash_original_method = "6E8B0AA5C49A67CA109B25D465668749", hash_generated_method = "00EAD357991374866B7CA67A42364C44")
    
@Override
    public int getBaseline() {
        return mHourSpinner.getBaseline();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.143 -0500", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "B2DB9880D1A02B35D29BED9E1EE131DA")
    
@Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.145 -0500", hash_original_method = "F102F8EE122BA2E1A10F758465ADC0EB", hash_generated_method = "A629257543AF43015858438429DD52BD")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);

        int flags = DateUtils.FORMAT_SHOW_TIME;
        if (mIs24HourView) {
            flags |= DateUtils.FORMAT_24HOUR;
        } else {
            flags |= DateUtils.FORMAT_12HOUR;
        }
        mTempCalendar.set(Calendar.HOUR_OF_DAY, getCurrentHour());
        mTempCalendar.set(Calendar.MINUTE, getCurrentMinute());
        String selectedDateUtterance = DateUtils.formatDateTime(mContext,
                mTempCalendar.getTimeInMillis(), flags);
        event.getText().add(selectedDateUtterance);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.149 -0500", hash_original_method = "D50D8E33466194F955FDB4E6708A42AD", hash_generated_method = "26658E222AA0825A7BE05F15AA023F52")
    
private void updateHourControl() {
        if (is24HourView()) {
            mHourSpinner.setMinValue(0);
            mHourSpinner.setMaxValue(23);
            mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        } else {
            mHourSpinner.setMinValue(1);
            mHourSpinner.setMaxValue(12);
            mHourSpinner.setFormatter(null);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.151 -0500", hash_original_method = "C352743C674140A19902F99B280928CF", hash_generated_method = "6686FD7D41DAE1EA3B9C0805F97EE002")
    
private void updateAmPmControl() {
        if (is24HourView()) {
            if (mAmPmSpinner != null) {
                mAmPmSpinner.setVisibility(View.GONE);
            } else {
                mAmPmButton.setVisibility(View.GONE);
            }
        } else {
            int index = mIsAm ? Calendar.AM : Calendar.PM;
            if (mAmPmSpinner != null) {
                mAmPmSpinner.setValue(index);
                mAmPmSpinner.setVisibility(View.VISIBLE);
            } else {
                mAmPmButton.setText(mAmPmStrings[index]);
                mAmPmButton.setVisibility(View.VISIBLE);
            }
        }
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
    }
    
    private static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.117 -0500", hash_original_field = "D724CFA73A53A978E951AE6569BF2FF0", hash_generated_field = "D3B74B573149A6A2FC399064332A0A51")

        @SuppressWarnings({"unused", "hiding"})
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.094 -0500", hash_original_field = "B2C1F15E3866C39B2AD64516DDC3A92C", hash_generated_field = "24E9A2D605497A939CE1099C8C82784A")

        private  int mHour;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.097 -0500", hash_original_field = "93289DEB1B98B1E0E5D8F8C24F2AC3F1", hash_generated_field = "30D2971B3212A2F1CF29388B2CF79F78")

        private  int mMinute;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.099 -0500", hash_original_method = "F395FF1FB7466B722BA2E9FD639B6FEC", hash_generated_method = "FD35EC9140699FD0CF83E49224C7091E")
        
private SavedState(Parcelable superState, int hour, int minute) {
            super(superState);
            mHour = hour;
            mMinute = minute;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.102 -0500", hash_original_method = "E55ECE0F217E584D660F2F1E2BD9AF6D", hash_generated_method = "4886905855BC68C8B409DFE28B1C77A5")
        
private SavedState(Parcel in) {
            super(in);
            mHour = in.readInt();
            mMinute = in.readInt();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.104 -0500", hash_original_method = "E8F47E3750239DF4EC2B02FDC3043C0E", hash_generated_method = "8C0112869DB37B91D479B99A1CB77744")
        
public int getHour() {
            return mHour;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.106 -0500", hash_original_method = "3E9A445CD5F3D9118D6AF471987F3B8F", hash_generated_method = "E33585B4E5B55B12E02D8CE1BC4EDD12")
        
public int getMinute() {
            return mMinute;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.108 -0500", hash_original_method = "3D8FA0B7CDDD47E4194304B24B1FFDDB", hash_generated_method = "8C1022A79C10BEED0E8CD0093ACAE570")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(mHour);
            dest.writeInt(mMinute);
        }
    }
    
    public interface OnTimeChangedListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onTimeChanged(TimePicker view, int hourOfDay, int minute);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.153 -0500", hash_original_method = "8A252D715D292AC897EF9505006002CC", hash_generated_method = "74FECF8DCE77638E066573B9D52FC7C6")
    
private void onTimeChanged() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        if (mOnTimeChangedListener != null) {
            mOnTimeChangedListener.onTimeChanged(this, getCurrentHour(), getCurrentMinute());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.156 -0500", hash_original_method = "4C27F718F6DC2C1B1670607286108308", hash_generated_method = "74BE37ADA7BEBCF9A6485907A1FE231E")
    
private void setContentDescriptions() {
        // Minute
        String text = mContext.getString(R.string.time_picker_increment_minute_button);
        mMinuteSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_decrement_minute_button);
        mMinuteSpinner.findViewById(R.id.decrement).setContentDescription(text);
        // Hour
        text = mContext.getString(R.string.time_picker_increment_hour_button);
        mHourSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_decrement_hour_button);
        mHourSpinner.findViewById(R.id.decrement).setContentDescription(text);
        // AM/PM
        if (mAmPmSpinner != null) {
            text = mContext.getString(R.string.time_picker_increment_set_pm_button);
            mAmPmSpinner.findViewById(R.id.increment).setContentDescription(text);
            text = mContext.getString(R.string.time_picker_decrement_set_am_button);
            mAmPmSpinner.findViewById(R.id.decrement).setContentDescription(text);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:40.158 -0500", hash_original_method = "EA3F98147485CBE1A2219199F92431C8", hash_generated_method = "09E6F398A78323F256D8702185427578")
    
private void updateInputState() {
        // Make sure that if the user changes the value and the IME is active
        // for one of the inputs if this widget, the IME is closed. If the user
        // changed the value via the IME and there is a next input the IME will
        // be shown, otherwise the user chose another means of changing the
        // value and having the IME up makes no sense.
        InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(mHourSpinnerInput)) {
                mHourSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(mMinuteSpinnerInput)) {
                mMinuteSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(mAmPmSpinnerInput)) {
                mAmPmSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }
}

