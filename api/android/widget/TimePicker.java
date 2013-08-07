package android.widget;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.890 -0400", hash_original_field = "AB9371C54D62E21B7C9B3A0218F3CF8E", hash_generated_field = "35FD601AE81D55F188A5E5435A238E5F")

    private boolean mIs24HourView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.890 -0400", hash_original_field = "08C1C0D1B318F7D691C9A50DB6073615", hash_generated_field = "277A014682EEB4651FD9CCF1C4C7A9DA")

    private boolean mIsAm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.890 -0400", hash_original_field = "112FAE7786E1837400A25EDC32E6BAA9", hash_generated_field = "F42DCA1FAFC6800847A12B5E4A4BC187")

    private NumberPicker mHourSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.890 -0400", hash_original_field = "09B03D4C69B668EC5EAC6459524CA437", hash_generated_field = "66959F7A51392B97FA2D1A99294B74C4")

    private NumberPicker mMinuteSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.890 -0400", hash_original_field = "F3D3F46E713A8370B627E5F348E8F6D2", hash_generated_field = "4D70AE5EB70BA99339D4FD1599F1FEA3")

    private NumberPicker mAmPmSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "E744F3850553FCA943282B8444936010", hash_generated_field = "57B061730C612FA07DDC7E51258E7DA2")

    private EditText mHourSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "5D9DA6546E42E5F3F97B7B4910CBBFB3", hash_generated_field = "B7278DCBB472B1B2F3539E5E1708DD32")

    private EditText mMinuteSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "E343F2337C5FF365E0FA6FF11E40A0D2", hash_generated_field = "FECBCFA86C0EF4E63B91247A25A449D7")

    private EditText mAmPmSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "F12C6C5933E99F70D882693BF3937072")

    private TextView mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "F9FD6AF8CBD99CF98AFC0E531ED08A41", hash_generated_field = "EF3E200E173FD044F8E6084FD0E1491E")

    private Button mAmPmButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "AF87A0964167C5B6A1C3DBC28724FB1E", hash_generated_field = "B1B72D4D154F4798F88DEE511FC04CC0")

    private String[] mAmPmStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "9F4735C7D2833FBB144CCBE86DA0A2AE", hash_generated_field = "0D83C9894006124680A4C4A755D8D1E4")

    private boolean mIsEnabled = DEFAULT_ENABLED_STATE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "90586EBFA5B21544462ED06A9AD45FEB", hash_generated_field = "24067A0BB0CBA588BA40566793730956")

    private OnTimeChangedListener mOnTimeChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "E1D842D489EEA7BD2AB1A49AC19E3D59", hash_generated_field = "BF728D47404D52B2BA92F11A215AFB65")

    private Calendar mTempCalendar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.891 -0400", hash_original_method = "DB39C8F7A833003C7D32A896903A886B", hash_generated_method = "E09AB0341F9AAF764C085418E7D375E4")
    public  TimePicker(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.892 -0400", hash_original_method = "13212DBF3C0B0551DB88CC2A61A0591D", hash_generated_method = "4277BFEE01C4C3AF91348BCDB2C35AD8")
    public  TimePicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.timePickerStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.898 -0400", hash_original_method = "01E52F88810C7560B77A694B8CE593AF", hash_generated_method = "10FB6C2A3F13CA07AFC48E645E49187C")
    public  TimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setCurrentLocale(Locale.getDefault());
        TypedArray attributesArray = context.obtainStyledAttributes(
                attrs, R.styleable.TimePicker, defStyle, 0);
        int layoutResourceId = attributesArray.getResourceId(
                R.styleable.TimePicker_layout, R.layout.time_picker);
        attributesArray.recycle();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(layoutResourceId, this, true);
        mHourSpinner = (NumberPicker) findViewById(R.id.hour);
        mHourSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.893 -0400", hash_original_method = "61CC50AE993360994364CE07AEAADDC8", hash_generated_method = "E4F23F2B5F60659C1A82C6BEA8536179")
        public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newVal);
            addTaint(oldVal);
            addTaint(spinner.getTaint());
            updateInputState();
            if(!is24HourView())            
            {
                if((oldVal == HOURS_IN_HALF_DAY - 1 && newVal == HOURS_IN_HALF_DAY)
                            || (oldVal == HOURS_IN_HALF_DAY && newVal == HOURS_IN_HALF_DAY - 1))                
                {
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                } //End block
            } //End block
            onTimeChanged();
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
        if(mDivider != null)        
        {
            mDivider.setText(R.string.time_picker_separator);
        } //End block
        mMinuteSpinner = (NumberPicker) findViewById(R.id.minute);
        mMinuteSpinner.setMinValue(0);
        mMinuteSpinner.setMaxValue(59);
        mMinuteSpinner.setOnLongPressUpdateInterval(100);
        mMinuteSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mMinuteSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.895 -0400", hash_original_method = "E7D4D1EDA413A979BF45D3C545C3EF66", hash_generated_method = "5B8E87772CD9EF40F0971D590917FA49")
        public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newVal);
            addTaint(oldVal);
            addTaint(spinner.getTaint());
            updateInputState();
            int minValue = mMinuteSpinner.getMinValue();
            int maxValue = mMinuteSpinner.getMaxValue();
            if(oldVal == maxValue && newVal == minValue)            
            {
                int newHour = mHourSpinner.getValue() + 1;
                if(!is24HourView() && newHour == HOURS_IN_HALF_DAY)                
                {
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                } //End block
                mHourSpinner.setValue(newHour);
            } //End block
            else
            if(oldVal == minValue && newVal == maxValue)            
            {
                int newHour = mHourSpinner.getValue() - 1;
                if(!is24HourView() && newHour == HOURS_IN_HALF_DAY - 1)                
                {
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                } //End block
                mHourSpinner.setValue(newHour);
            } //End block
            onTimeChanged();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
});
        mMinuteSpinnerInput = (EditText) mMinuteSpinner.findViewById(R.id.numberpicker_input);
        mMinuteSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        mAmPmStrings = new DateFormatSymbols().getAmPmStrings();
        View amPmView = findViewById(R.id.amPm);
        if(amPmView instanceof Button)        
        {
            mAmPmSpinner = null;
            mAmPmSpinnerInput = null;
            mAmPmButton = (Button) amPmView;
            mAmPmButton.setOnClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.897 -0400", hash_original_method = "4F5D6F91E7DB94922D5610C609DBC6AC", hash_generated_method = "AB37F5CCBE7DBC5CABDD7A9EB6EEFC93")
        public void onClick(View button) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(button.getTaint());
            button.requestFocus();
            mIsAm = !mIsAm;
            updateAmPmControl();
            // ---------- Original Method ----------
            //button.requestFocus();
            //mIsAm = !mIsAm;
            //updateAmPmControl();
        }
});
        } //End block
        else
        {
            mAmPmButton = null;
            mAmPmSpinner = (NumberPicker) amPmView;
            mAmPmSpinner.setMinValue(0);
            mAmPmSpinner.setMaxValue(1);
            mAmPmSpinner.setDisplayedValues(mAmPmStrings);
            mAmPmSpinner.setOnValueChangedListener(new OnValueChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.898 -0400", hash_original_method = "C8C0A93031AC50530CF196FDB67DBB38", hash_generated_method = "63E26DCBC2C8462A2D5042683F8D6DEF")
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newVal);
            addTaint(oldVal);
            addTaint(picker.getTaint());
            updateInputState();
            picker.requestFocus();
            mIsAm = !mIsAm;
            updateAmPmControl();
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
        if(!isEnabled())        
        {
            setEnabled(false);
        } //End block
        setContentDescriptions();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.900 -0400", hash_original_method = "8DB20A38842785B537F33F867250F197", hash_generated_method = "56FB56D13A2E6716ABD2C6BBF97EDFCB")
    @Override
    public void setEnabled(boolean enabled) {
        if(mIsEnabled == enabled)        
        {
            return;
        } //End block
        super.setEnabled(enabled);
        mMinuteSpinner.setEnabled(enabled);
        if(mDivider != null)        
        {
            mDivider.setEnabled(enabled);
        } //End block
        mHourSpinner.setEnabled(enabled);
        if(mAmPmSpinner != null)        
        {
            mAmPmSpinner.setEnabled(enabled);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.902 -0400", hash_original_method = "FE60B57F2ECB259E877433DACC7AAC95", hash_generated_method = "DF5FBBB7DBD3C6523D832C395B5F7C0C")
    @Override
    public boolean isEnabled() {
        boolean var1D09076915F0C1B535F8F7A6899A12CD_1121638976 = (mIsEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963484616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_963484616;
        // ---------- Original Method ----------
        //return mIsEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.903 -0400", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "127AACDA90D8DF77911A68D85F6663CF")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //setCurrentLocale(newConfig.locale);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.904 -0400", hash_original_method = "980D3FE8BB317B8359A795201150D40B", hash_generated_method = "F1D9F8801B54CF397ED9522D73C73ED7")
    private void setCurrentLocale(Locale locale) {
        if(locale.equals(mCurrentLocale))        
        {
            return;
        } //End block
        mCurrentLocale = locale;
        mTempCalendar = Calendar.getInstance(locale);
        // ---------- Original Method ----------
        //if (locale.equals(mCurrentLocale)) {
            //return;
        //}
        //mCurrentLocale = locale;
        //mTempCalendar = Calendar.getInstance(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.904 -0400", hash_original_method = "72123348A3F05C8EE46260DED41E8111", hash_generated_method = "5982EB60B9602EB44F8C45AB568D799F")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
Parcelable var767A4A9C9E0294E50933F15CC8E01356_229148436 =         new SavedState(superState, getCurrentHour(), getCurrentMinute());
        var767A4A9C9E0294E50933F15CC8E01356_229148436.addTaint(taint);
        return var767A4A9C9E0294E50933F15CC8E01356_229148436;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState, getCurrentHour(), getCurrentMinute());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.905 -0400", hash_original_method = "B2A487C66396B9A569DF07FC1780728C", hash_generated_method = "AF6E274B09128926B218F1642E138CD3")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCurrentHour(ss.getHour());
        setCurrentMinute(ss.getMinute());
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setCurrentHour(ss.getHour());
        //setCurrentMinute(ss.getMinute());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.905 -0400", hash_original_method = "6B3D4A5E94F1256617D4C5854135F89F", hash_generated_method = "06C44235EEE3C2E117DCBAA9E871B4B2")
    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        mOnTimeChangedListener = onTimeChangedListener;
        // ---------- Original Method ----------
        //mOnTimeChangedListener = onTimeChangedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.906 -0400", hash_original_method = "AE73BE8706F17DAEE1FF393F333C1E75", hash_generated_method = "6DCEA689FD7A27AD1407BC657800674E")
    public Integer getCurrentHour() {
        int currentHour = mHourSpinner.getValue();
        if(is24HourView())        
        {
Integer varB3BA8478472191AAD02A5F162D7D507B_2043896200 =             currentHour;
            varB3BA8478472191AAD02A5F162D7D507B_2043896200.addTaint(taint);
            return varB3BA8478472191AAD02A5F162D7D507B_2043896200;
        } //End block
        else
        if(mIsAm)        
        {
Integer var6B8A843D225ADA71199350E846127043_1946057577 =             currentHour % HOURS_IN_HALF_DAY;
            var6B8A843D225ADA71199350E846127043_1946057577.addTaint(taint);
            return var6B8A843D225ADA71199350E846127043_1946057577;
        } //End block
        else
        {
Integer var06A635A0AB15E903331F9B812F778501_585790521 =             (currentHour % HOURS_IN_HALF_DAY) + HOURS_IN_HALF_DAY;
            var06A635A0AB15E903331F9B812F778501_585790521.addTaint(taint);
            return var06A635A0AB15E903331F9B812F778501_585790521;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.907 -0400", hash_original_method = "51BF76EB890889B8164A1C36DDF3660C", hash_generated_method = "7E11EEFD0E83ABD14E0E499494C62934")
    public void setCurrentHour(Integer currentHour) {
        addTaint(currentHour.getTaint());
        if(currentHour == null || currentHour == getCurrentHour())        
        {
            return;
        } //End block
        if(!is24HourView())        
        {
            if(currentHour >= HOURS_IN_HALF_DAY)            
            {
                mIsAm = false;
                if(currentHour > HOURS_IN_HALF_DAY)                
                {
                    currentHour = currentHour - HOURS_IN_HALF_DAY;
                } //End block
            } //End block
            else
            {
                mIsAm = true;
                if(currentHour == 0)                
                {
                    currentHour = HOURS_IN_HALF_DAY;
                } //End block
            } //End block
            updateAmPmControl();
        } //End block
        mHourSpinner.setValue(currentHour);
        onTimeChanged();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.908 -0400", hash_original_method = "241FCC8F6454A30E36E3EC76C851E3F2", hash_generated_method = "1823C04E6E3AD09C4461FBDDDFAC77EA")
    public void setIs24HourView(Boolean is24HourView) {
        if(mIs24HourView == is24HourView)        
        {
            return;
        } //End block
        mIs24HourView = is24HourView;
        int currentHour = getCurrentHour();
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.908 -0400", hash_original_method = "4F4BA9CD8FF557544935EB979BB43706", hash_generated_method = "8478C4AFC1706E2FE489C1C308F7976B")
    public boolean is24HourView() {
        boolean varAB9371C54D62E21B7C9B3A0218F3CF8E_1750945167 = (mIs24HourView);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_113428708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_113428708;
        // ---------- Original Method ----------
        //return mIs24HourView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.908 -0400", hash_original_method = "A85A8F7AA6E48BE779272D70D71211B4", hash_generated_method = "BD76EBBEE4BCA787B47264BC492AB23A")
    public Integer getCurrentMinute() {
Integer varD6B53F95DB47F8A2CC8B4CFD55982D2A_1307523606 =         mMinuteSpinner.getValue();
        varD6B53F95DB47F8A2CC8B4CFD55982D2A_1307523606.addTaint(taint);
        return varD6B53F95DB47F8A2CC8B4CFD55982D2A_1307523606;
        // ---------- Original Method ----------
        //return mMinuteSpinner.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.909 -0400", hash_original_method = "E5914CBE4C3F7152CD4D96804AFB4FF4", hash_generated_method = "991977E29AEB6FF1BF45E39D1C807AFD")
    public void setCurrentMinute(Integer currentMinute) {
        addTaint(currentMinute.getTaint());
        if(currentMinute == getCurrentMinute())        
        {
            return;
        } //End block
        mMinuteSpinner.setValue(currentMinute);
        onTimeChanged();
        // ---------- Original Method ----------
        //if (currentMinute == getCurrentMinute()) {
            //return;
        //}
        //mMinuteSpinner.setValue(currentMinute);
        //onTimeChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.909 -0400", hash_original_method = "6E8B0AA5C49A67CA109B25D465668749", hash_generated_method = "FBBA9CFE6F048DDF2613D75C4076ACB5")
    @Override
    public int getBaseline() {
        int varDDE8F22489C60771D7CFE5BAFFE30D1D_611917725 = (mHourSpinner.getBaseline());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715725547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715725547;
        // ---------- Original Method ----------
        //return mHourSpinner.getBaseline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.909 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "F83CE440B46FDCD86890C9C355A29E8B")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        onPopulateAccessibilityEvent(event);
        boolean varB326B5062B2F0E69046810717534CB09_1180454753 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251185194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_251185194;
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.910 -0400", hash_original_method = "F102F8EE122BA2E1A10F758465ADC0EB", hash_generated_method = "9505325E9F63A680F8D4092BE9CFF2A2")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        int flags = DateUtils.FORMAT_SHOW_TIME;
        if(mIs24HourView)        
        {
            flags |= DateUtils.FORMAT_24HOUR;
        } //End block
        else
        {
            flags |= DateUtils.FORMAT_12HOUR;
        } //End block
        mTempCalendar.set(Calendar.HOUR_OF_DAY, getCurrentHour());
        mTempCalendar.set(Calendar.MINUTE, getCurrentMinute());
        String selectedDateUtterance = DateUtils.formatDateTime(mContext,
                mTempCalendar.getTimeInMillis(), flags);
        event.getText().add(selectedDateUtterance);
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.910 -0400", hash_original_method = "D50D8E33466194F955FDB4E6708A42AD", hash_generated_method = "13196BACB44422C23C50D8C48E0ADF42")
    private void updateHourControl() {
        if(is24HourView())        
        {
            mHourSpinner.setMinValue(0);
            mHourSpinner.setMaxValue(23);
            mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        } //End block
        else
        {
            mHourSpinner.setMinValue(1);
            mHourSpinner.setMaxValue(12);
            mHourSpinner.setFormatter(null);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.911 -0400", hash_original_method = "C352743C674140A19902F99B280928CF", hash_generated_method = "AAD61B065493103C368265D0998F72A7")
    private void updateAmPmControl() {
        if(is24HourView())        
        {
            if(mAmPmSpinner != null)            
            {
                mAmPmSpinner.setVisibility(View.GONE);
            } //End block
            else
            {
                mAmPmButton.setVisibility(View.GONE);
            } //End block
        } //End block
        else
        {
            int index = mIsAm ? Calendar.AM : Calendar.PM;
            if(mAmPmSpinner != null)            
            {
                mAmPmSpinner.setValue(index);
                mAmPmSpinner.setVisibility(View.VISIBLE);
            } //End block
            else
            {
                mAmPmButton.setText(mAmPmStrings[index]);
                mAmPmButton.setVisibility(View.VISIBLE);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.911 -0400", hash_original_method = "8A252D715D292AC897EF9505006002CC", hash_generated_method = "97E3ACCB50D717165DBE447150590099")
    private void onTimeChanged() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        if(mOnTimeChangedListener != null)        
        {
            mOnTimeChangedListener.onTimeChanged(this, getCurrentHour(), getCurrentMinute());
        } //End block
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //if (mOnTimeChangedListener != null) {
            //mOnTimeChangedListener.onTimeChanged(this, getCurrentHour(), getCurrentMinute());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.912 -0400", hash_original_method = "4C27F718F6DC2C1B1670607286108308", hash_generated_method = "BAFB29E04A992B4A355A2267C2780E13")
    private void setContentDescriptions() {
        String text = mContext.getString(R.string.time_picker_increment_minute_button);
        mMinuteSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_decrement_minute_button);
        mMinuteSpinner.findViewById(R.id.decrement).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_increment_hour_button);
        mHourSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.time_picker_decrement_hour_button);
        mHourSpinner.findViewById(R.id.decrement).setContentDescription(text);
        if(mAmPmSpinner != null)        
        {
            text = mContext.getString(R.string.time_picker_increment_set_pm_button);
            mAmPmSpinner.findViewById(R.id.increment).setContentDescription(text);
            text = mContext.getString(R.string.time_picker_decrement_set_am_button);
            mAmPmSpinner.findViewById(R.id.decrement).setContentDescription(text);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.913 -0400", hash_original_method = "EA3F98147485CBE1A2219199F92431C8", hash_generated_method = "F45E3DBD9372DA394CDC8A2F5ADB9F15")
    private void updateInputState() {
        InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
        if(inputMethodManager != null)        
        {
            if(inputMethodManager.isActive(mHourSpinnerInput))            
            {
                mHourSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } //End block
            else
            if(inputMethodManager.isActive(mMinuteSpinnerInput))            
            {
                mMinuteSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } //End block
            else
            if(inputMethodManager.isActive(mAmPmSpinnerInput))            
            {
                mAmPmSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.913 -0400", hash_original_field = "48AB0AEFD71C009ADE848499A027A428", hash_generated_field = "24E9A2D605497A939CE1099C8C82784A")

        private int mHour;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.913 -0400", hash_original_field = "1D72A8B90C8FB2B549FC5D5E49C93263", hash_generated_field = "30D2971B3212A2F1CF29388B2CF79F78")

        private int mMinute;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.913 -0400", hash_original_method = "F395FF1FB7466B722BA2E9FD639B6FEC", hash_generated_method = "F8A955477404115369E61A054894052B")
        private  SavedState(Parcelable superState, int hour, int minute) {
            super(superState);
            addTaint(superState.getTaint());
            mHour = hour;
            mMinute = minute;
            // ---------- Original Method ----------
            //mHour = hour;
            //mMinute = minute;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.914 -0400", hash_original_method = "E55ECE0F217E584D660F2F1E2BD9AF6D", hash_generated_method = "5CC81B14D3F46C2076B5C2B2E083007B")
        private  SavedState(Parcel in) {
            super(in);
            mHour = in.readInt();
            mMinute = in.readInt();
            // ---------- Original Method ----------
            //mHour = in.readInt();
            //mMinute = in.readInt();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.914 -0400", hash_original_method = "E8F47E3750239DF4EC2B02FDC3043C0E", hash_generated_method = "B33014483B52C2796E20F848928895F1")
        public int getHour() {
            int var48AB0AEFD71C009ADE848499A027A428_141453368 = (mHour);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771727450 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771727450;
            // ---------- Original Method ----------
            //return mHour;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.914 -0400", hash_original_method = "3E9A445CD5F3D9118D6AF471987F3B8F", hash_generated_method = "7C09419847C6D4BAF471DC3F84CEB4C7")
        public int getMinute() {
            int var1D72A8B90C8FB2B549FC5D5E49C93263_951015439 = (mMinute);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153844992 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153844992;
            // ---------- Original Method ----------
            //return mMinute;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.915 -0400", hash_original_method = "3D8FA0B7CDDD47E4194304B24B1FFDDB", hash_generated_method = "E4B5479990B8D5EF47EF57790377D5AA")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            super.writeToParcel(dest, flags);
            dest.writeInt(mHour);
            dest.writeInt(mMinute);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeInt(mHour);
            //dest.writeInt(mMinute);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.915 -0400", hash_original_field = "D1498A1D28CCBBEB217C9EC7E28F9C3B", hash_generated_field = "D3B74B573149A6A2FC399064332A0A51")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.915 -0400", hash_original_field = "341D07F1E4A62FB066D5A2BBC1DD2D1E", hash_generated_field = "C8A8F0463DBF19CC5664F198B037CB59")

    private static final boolean DEFAULT_ENABLED_STATE = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.915 -0400", hash_original_field = "1E26C97037BCBE16DC67E6DFD376FAD7", hash_generated_field = "65EDE4F9048CF09D46EC35F5340020DF")

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
}

