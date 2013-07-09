package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "AB9371C54D62E21B7C9B3A0218F3CF8E", hash_generated_field = "35FD601AE81D55F188A5E5435A238E5F")

    private boolean mIs24HourView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "08C1C0D1B318F7D691C9A50DB6073615", hash_generated_field = "277A014682EEB4651FD9CCF1C4C7A9DA")

    private boolean mIsAm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "112FAE7786E1837400A25EDC32E6BAA9", hash_generated_field = "F42DCA1FAFC6800847A12B5E4A4BC187")

    private NumberPicker mHourSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "09B03D4C69B668EC5EAC6459524CA437", hash_generated_field = "66959F7A51392B97FA2D1A99294B74C4")

    private NumberPicker mMinuteSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "F3D3F46E713A8370B627E5F348E8F6D2", hash_generated_field = "4D70AE5EB70BA99339D4FD1599F1FEA3")

    private NumberPicker mAmPmSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "E744F3850553FCA943282B8444936010", hash_generated_field = "57B061730C612FA07DDC7E51258E7DA2")

    private EditText mHourSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "5D9DA6546E42E5F3F97B7B4910CBBFB3", hash_generated_field = "B7278DCBB472B1B2F3539E5E1708DD32")

    private EditText mMinuteSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "E343F2337C5FF365E0FA6FF11E40A0D2", hash_generated_field = "FECBCFA86C0EF4E63B91247A25A449D7")

    private EditText mAmPmSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "F2EB92D46BFACFA75ABCA33DC6179915", hash_generated_field = "F12C6C5933E99F70D882693BF3937072")

    private TextView mDivider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "F9FD6AF8CBD99CF98AFC0E531ED08A41", hash_generated_field = "EF3E200E173FD044F8E6084FD0E1491E")

    private Button mAmPmButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "AF87A0964167C5B6A1C3DBC28724FB1E", hash_generated_field = "B1B72D4D154F4798F88DEE511FC04CC0")

    private String[] mAmPmStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "9F4735C7D2833FBB144CCBE86DA0A2AE", hash_generated_field = "0D83C9894006124680A4C4A755D8D1E4")

    private boolean mIsEnabled = DEFAULT_ENABLED_STATE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "90586EBFA5B21544462ED06A9AD45FEB", hash_generated_field = "24067A0BB0CBA588BA40566793730956")

    private OnTimeChangedListener mOnTimeChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "E1D842D489EEA7BD2AB1A49AC19E3D59", hash_generated_field = "BF728D47404D52B2BA92F11A215AFB65")

    private Calendar mTempCalendar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_method = "DB39C8F7A833003C7D32A896903A886B", hash_generated_method = "E09AB0341F9AAF764C085418E7D375E4")
    public  TimePicker(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.150 -0400", hash_original_method = "13212DBF3C0B0551DB88CC2A61A0591D", hash_generated_method = "6911B8C06254E691C71A6E595CCDBF7C")
    public  TimePicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.timePickerStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.154 -0400", hash_original_method = "01E52F88810C7560B77A694B8CE593AF", hash_generated_method = "2C5A37FCED1DEBDE9F6D6904CEFA9797")
    public  TimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.151 -0400", hash_original_method = "61CC50AE993360994364CE07AEAADDC8", hash_generated_method = "90C7B96171AC65CAAF2FDF058AAE2C17")
            public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
                
                updateInputState();
                {
                    boolean var8A32C210C8A473980EFFE441CCA946A8_2039963552 = (!is24HourView());
                    {
                        {
                            mIsAm = !mIsAm;
                            updateAmPmControl();
                        } 
                    } 
                } 
                onTimeChanged();
                addTaint(spinner.getTaint());
                addTaint(oldVal);
                addTaint(newVal);
                
                
                
                    
                            
                        
                        
                    
                
                
            }
});
        mHourSpinnerInput = (EditText) mHourSpinner.findViewById(R.id.numberpicker_input);
        mHourSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        mDivider = (TextView) findViewById(R.id.divider);
        {
            mDivider.setText(R.string.time_picker_separator);
        } 
        mMinuteSpinner = (NumberPicker) findViewById(R.id.minute);
        mMinuteSpinner.setMinValue(0);
        mMinuteSpinner.setMaxValue(59);
        mMinuteSpinner.setOnLongPressUpdateInterval(100);
        mMinuteSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mMinuteSpinner.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.152 -0400", hash_original_method = "E7D4D1EDA413A979BF45D3C545C3EF66", hash_generated_method = "3C62BCDA07328E93EC25BDDE5010488D")
            public void onValueChange(NumberPicker spinner, int oldVal, int newVal) {
                
                updateInputState();
                int minValue = mMinuteSpinner.getMinValue();
                int maxValue = mMinuteSpinner.getMaxValue();
                {
                    int newHour = mHourSpinner.getValue() + 1;
                    {
                        boolean var3E070F8E4244822177D1F49C27C8E72F_447196948 = (!is24HourView() && newHour == HOURS_IN_HALF_DAY);
                        {
                            mIsAm = !mIsAm;
                            updateAmPmControl();
                        } 
                    } 
                    mHourSpinner.setValue(newHour);
                } 
                {
                    int newHour = mHourSpinner.getValue() - 1;
                    {
                        boolean varCDEE84F94FD391316B445FBB0BA8F4A8_1323314071 = (!is24HourView() && newHour == HOURS_IN_HALF_DAY - 1);
                        {
                            mIsAm = !mIsAm;
                            updateAmPmControl();
                        } 
                    } 
                    mHourSpinner.setValue(newHour);
                } 
                onTimeChanged();
                addTaint(spinner.getTaint());
                addTaint(oldVal);
                addTaint(newVal);
                
                
            }
});
        mMinuteSpinnerInput = (EditText) mMinuteSpinner.findViewById(R.id.numberpicker_input);
        mMinuteSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        mAmPmStrings = new DateFormatSymbols().getAmPmStrings();
        View amPmView = findViewById(R.id.amPm);
        {
            mAmPmSpinner = null;
            mAmPmSpinnerInput = null;
            mAmPmButton = (Button) amPmView;
            mAmPmButton.setOnClickListener(new OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.153 -0400", hash_original_method = "4F5D6F91E7DB94922D5610C609DBC6AC", hash_generated_method = "62A414B3345481D7A699DD4E23941BEE")
                public void onClick(View button) {
                    
                    button.requestFocus();
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                    addTaint(button.getTaint());
                    
                    
                    
                    
                }
});
        } 
        {
            mAmPmButton = null;
            mAmPmSpinner = (NumberPicker) amPmView;
            mAmPmSpinner.setMinValue(0);
            mAmPmSpinner.setMaxValue(1);
            mAmPmSpinner.setDisplayedValues(mAmPmStrings);
            mAmPmSpinner.setOnValueChangedListener(new OnValueChangeListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.153 -0400", hash_original_method = "C8C0A93031AC50530CF196FDB67DBB38", hash_generated_method = "295283F6481F75840DE041CD929C4536")
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    
                    updateInputState();
                    picker.requestFocus();
                    mIsAm = !mIsAm;
                    updateAmPmControl();
                    addTaint(picker.getTaint());
                    addTaint(oldVal);
                    addTaint(newVal);
                    
                    
                    
                    
                    
                }
});
            mAmPmSpinnerInput = (EditText) mAmPmSpinner.findViewById(R.id.numberpicker_input);
            mAmPmSpinnerInput.setImeOptions(EditorInfo.IME_ACTION_DONE);
        } 
        updateHourControl();
        updateAmPmControl();
        setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);
        setCurrentHour(mTempCalendar.get(Calendar.HOUR_OF_DAY));
        setCurrentMinute(mTempCalendar.get(Calendar.MINUTE));
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1365947066 = (!isEnabled());
            {
                setEnabled(false);
            } 
        } 
        setContentDescriptions();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.154 -0400", hash_original_method = "8DB20A38842785B537F33F867250F197", hash_generated_method = "ADFA802F64A75E67903EAD558B553060")
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mMinuteSpinner.setEnabled(enabled);
        {
            mDivider.setEnabled(enabled);
        } 
        mHourSpinner.setEnabled(enabled);
        {
            mAmPmSpinner.setEnabled(enabled);
        } 
        {
            mAmPmButton.setEnabled(enabled);
        } 
        mIsEnabled = enabled;
        
        
            
        
        
        
        
            
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.155 -0400", hash_original_method = "FE60B57F2ECB259E877433DACC7AAC95", hash_generated_method = "94430C0B335831B8F840720DDA8A29AC")
    @Override
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442303839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442303839;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.155 -0400", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "FB0A11FC0C47EF7B377125BF2E9C2DD7")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
        addTaint(newConfig.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.155 -0400", hash_original_method = "980D3FE8BB317B8359A795201150D40B", hash_generated_method = "9F4895E7094BD86FF9D0C03F259E7B02")
    private void setCurrentLocale(Locale locale) {
        {
            boolean varD1CF46D36E6B1C6187CE68AE2BC3F432_794903373 = (locale.equals(mCurrentLocale));
        } 
        mCurrentLocale = locale;
        mTempCalendar = Calendar.getInstance(locale);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.156 -0400", hash_original_method = "72123348A3F05C8EE46260DED41E8111", hash_generated_method = "4A27676AA6A750323A2AC33370142C3B")
    @Override
    protected Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1872438509 = null; 
        Parcelable superState = super.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_1872438509 = new SavedState(superState, getCurrentHour(), getCurrentMinute());
        varB4EAC82CA7396A68D541C85D26508E83_1872438509.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1872438509;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.156 -0400", hash_original_method = "B2A487C66396B9A569DF07FC1780728C", hash_generated_method = "D0CC5545E32C978C55D8230E25CC0299")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCurrentHour(ss.getHour());
        setCurrentMinute(ss.getMinute());
        addTaint(state.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.156 -0400", hash_original_method = "6B3D4A5E94F1256617D4C5854135F89F", hash_generated_method = "06C44235EEE3C2E117DCBAA9E871B4B2")
    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener) {
        mOnTimeChangedListener = onTimeChangedListener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.157 -0400", hash_original_method = "AE73BE8706F17DAEE1FF393F333C1E75", hash_generated_method = "7937FCAF2C0B8E7935C788C347FCE07D")
    public Integer getCurrentHour() {
        Integer varB4EAC82CA7396A68D541C85D26508E83_1814043942 = null; 
        Integer varB4EAC82CA7396A68D541C85D26508E83_1673275080 = null; 
        Integer varB4EAC82CA7396A68D541C85D26508E83_87423770 = null; 
        int currentHour = mHourSpinner.getValue();
        {
            boolean varFAB15A4F58C6E1453A4D6F7A530C8BA5_1026195460 = (is24HourView());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1814043942 = currentHour;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1673275080 = currentHour % HOURS_IN_HALF_DAY;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_87423770 = (currentHour % HOURS_IN_HALF_DAY) + HOURS_IN_HALF_DAY;
            } 
        } 
        Integer varA7E53CE21691AB073D9660D615818899_697620623; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_697620623 = varB4EAC82CA7396A68D541C85D26508E83_1814043942;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_697620623 = varB4EAC82CA7396A68D541C85D26508E83_1673275080;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_697620623 = varB4EAC82CA7396A68D541C85D26508E83_87423770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_697620623.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_697620623;
        
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.157 -0400", hash_original_method = "51BF76EB890889B8164A1C36DDF3660C", hash_generated_method = "EA6C2F4EC00921E2BFCE43607213A366")
    public void setCurrentHour(Integer currentHour) {
        {
            boolean varEBC734B5A295F39B75E246AB2FD25248_1704597398 = (currentHour == null || currentHour == getCurrentHour());
        } 
        {
            boolean var19272B72BDCEABDB9528250CA63FAD1F_1094017729 = (!is24HourView());
            {
                {
                    mIsAm = false;
                    {
                        currentHour = currentHour - HOURS_IN_HALF_DAY;
                    } 
                } 
                {
                    mIsAm = true;
                    {
                        currentHour = HOURS_IN_HALF_DAY;
                    } 
                } 
                updateAmPmControl();
            } 
        } 
        mHourSpinner.setValue(currentHour);
        onTimeChanged();
        addTaint(currentHour.getTaint());
        
        
            
        
        
            
                
                
                    
                
            
                
                
                    
                
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.158 -0400", hash_original_method = "241FCC8F6454A30E36E3EC76C851E3F2", hash_generated_method = "4E460082F3047128E37B1387EB8341AC")
    public void setIs24HourView(Boolean is24HourView) {
        mIs24HourView = is24HourView;
        int currentHour = getCurrentHour();
        updateHourControl();
        setCurrentHour(currentHour);
        updateAmPmControl();
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.158 -0400", hash_original_method = "4F4BA9CD8FF557544935EB979BB43706", hash_generated_method = "968CCF9BCDF65861A59577D973C26A13")
    public boolean is24HourView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416345219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416345219;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.158 -0400", hash_original_method = "A85A8F7AA6E48BE779272D70D71211B4", hash_generated_method = "BECD916044EC5C34A7B2AF4E75317EA9")
    public Integer getCurrentMinute() {
        Integer varB4EAC82CA7396A68D541C85D26508E83_365435033 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_365435033 = mMinuteSpinner.getValue();
        varB4EAC82CA7396A68D541C85D26508E83_365435033.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_365435033;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.159 -0400", hash_original_method = "E5914CBE4C3F7152CD4D96804AFB4FF4", hash_generated_method = "A94F46F21A3DFF55916976AEDE740056")
    public void setCurrentMinute(Integer currentMinute) {
        {
            boolean varDBDB0EB4C2EE8ED59504861D9D7B85AB_597729220 = (currentMinute == getCurrentMinute());
        } 
        mMinuteSpinner.setValue(currentMinute);
        onTimeChanged();
        addTaint(currentMinute.getTaint());
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.159 -0400", hash_original_method = "6E8B0AA5C49A67CA109B25D465668749", hash_generated_method = "5F51B422C3E14A2B0FE9A1E4173DDFDE")
    @Override
    public int getBaseline() {
        int varFB188FCA7F7E3E5600610236D50C9EFF_157818174 = (mHourSpinner.getBaseline());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117469659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117469659;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.159 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "DF3FB3E50F1A510EB0C6C50E6C29A278")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720698011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720698011;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.160 -0400", hash_original_method = "F102F8EE122BA2E1A10F758465ADC0EB", hash_generated_method = "6069B1C0EF5729A30D8131F1D7DDFCC1")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        
        super.onPopulateAccessibilityEvent(event);
        int flags = DateUtils.FORMAT_SHOW_TIME;
        {
            flags |= DateUtils.FORMAT_24HOUR;
        } 
        {
            flags |= DateUtils.FORMAT_12HOUR;
        } 
        mTempCalendar.set(Calendar.HOUR_OF_DAY, getCurrentHour());
        mTempCalendar.set(Calendar.MINUTE, getCurrentMinute());
        String selectedDateUtterance = DateUtils.formatDateTime(mContext,
                mTempCalendar.getTimeInMillis(), flags);
        event.getText().add(selectedDateUtterance);
        addTaint(event.getTaint());
        
        
        
        
            
        
            
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.160 -0400", hash_original_method = "D50D8E33466194F955FDB4E6708A42AD", hash_generated_method = "E4DCE5D2568E27EB9EDDA42C06D583AF")
    private void updateHourControl() {
        {
            boolean varFAB15A4F58C6E1453A4D6F7A530C8BA5_1413393322 = (is24HourView());
            {
                mHourSpinner.setMinValue(0);
                mHourSpinner.setMaxValue(23);
                mHourSpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
            } 
            {
                mHourSpinner.setMinValue(1);
                mHourSpinner.setMaxValue(12);
                mHourSpinner.setFormatter(null);
            } 
        } 
        
        
            
            
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.160 -0400", hash_original_method = "C352743C674140A19902F99B280928CF", hash_generated_method = "8BBF1782065F24C562F7FCE4EE1D7CFA")
    private void updateAmPmControl() {
        {
            boolean varFAB15A4F58C6E1453A4D6F7A530C8BA5_1251521095 = (is24HourView());
            {
                {
                    mAmPmSpinner.setVisibility(View.GONE);
                } 
                {
                    mAmPmButton.setVisibility(View.GONE);
                } 
            } 
            {
                int index;
                index = Calendar.AM;
                index = Calendar.PM;
                {
                    mAmPmSpinner.setValue(index);
                    mAmPmSpinner.setVisibility(View.VISIBLE);
                } 
                {
                    mAmPmButton.setText(mAmPmStrings[index]);
                    mAmPmButton.setVisibility(View.VISIBLE);
                } 
            } 
        } 
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        
        
            
                
            
                
            
        
            
            
                
                
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.161 -0400", hash_original_method = "8A252D715D292AC897EF9505006002CC", hash_generated_method = "B7298096452F78D8F117C9C037FBB437")
    private void onTimeChanged() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        {
            mOnTimeChangedListener.onTimeChanged(this, getCurrentHour(), getCurrentMinute());
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.161 -0400", hash_original_method = "4C27F718F6DC2C1B1670607286108308", hash_generated_method = "BFF05A6A7C004A8C9CF50E4A3F19B29D")
    private void setContentDescriptions() {
        String text = mContext.getString(R.string.time_picker_increment_minute_button);
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
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.162 -0400", hash_original_method = "EA3F98147485CBE1A2219199F92431C8", hash_generated_method = "9738D46991BFC94F8A8440499D5D43DE")
    private void updateInputState() {
        InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
        {
            {
                boolean var4598CF849CA66E5FED61C393E4D1489E_151287970 = (inputMethodManager.isActive(mHourSpinnerInput));
                {
                    mHourSpinnerInput.clearFocus();
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                } 
                {
                    boolean var8E6415DD3D919E519BF844CF4369EAC9_1061077405 = (inputMethodManager.isActive(mMinuteSpinnerInput));
                    {
                        mMinuteSpinnerInput.clearFocus();
                        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    } 
                    {
                        boolean varDAB46DD19150B7BCB89C5605BC3BC354_2115114148 = (inputMethodManager.isActive(mAmPmSpinnerInput));
                        {
                            mAmPmSpinnerInput.clearFocus();
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        } 
                    } 
                } 
            } 
        } 
        
        
        
            
                
                
            
                
                
            
                
                
            
        
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.162 -0400", hash_original_field = "48AB0AEFD71C009ADE848499A027A428", hash_generated_field = "24E9A2D605497A939CE1099C8C82784A")

        private int mHour;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.162 -0400", hash_original_field = "1D72A8B90C8FB2B549FC5D5E49C93263", hash_generated_field = "30D2971B3212A2F1CF29388B2CF79F78")

        private int mMinute;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.163 -0400", hash_original_method = "F395FF1FB7466B722BA2E9FD639B6FEC", hash_generated_method = "C86B6E4306B51C308B5AA7319DD2D11A")
        private  SavedState(Parcelable superState, int hour, int minute) {
            super(superState);
            mHour = hour;
            mMinute = minute;
            addTaint(superState.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.163 -0400", hash_original_method = "E55ECE0F217E584D660F2F1E2BD9AF6D", hash_generated_method = "5CC81B14D3F46C2076B5C2B2E083007B")
        private  SavedState(Parcel in) {
            super(in);
            mHour = in.readInt();
            mMinute = in.readInt();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.164 -0400", hash_original_method = "E8F47E3750239DF4EC2B02FDC3043C0E", hash_generated_method = "012C6C1D29FA5C299056176C149896B8")
        public int getHour() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945282188 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945282188;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.165 -0400", hash_original_method = "3E9A445CD5F3D9118D6AF471987F3B8F", hash_generated_method = "7BE87CCA4A7CFEE0EBCEC90F5061E5CA")
        public int getMinute() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781680770 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781680770;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.165 -0400", hash_original_method = "3D8FA0B7CDDD47E4194304B24B1FFDDB", hash_generated_method = "26B83AB4BAF455FD2086B69E69601E46")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(mHour);
            dest.writeInt(mMinute);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.165 -0400", hash_original_field = "D1498A1D28CCBBEB217C9EC7E28F9C3B", hash_generated_field = "D3B74B573149A6A2FC399064332A0A51")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.165 -0400", hash_original_field = "341D07F1E4A62FB066D5A2BBC1DD2D1E", hash_generated_field = "C8A8F0463DBF19CC5664F198B037CB59")

    private static final boolean DEFAULT_ENABLED_STATE = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.165 -0400", hash_original_field = "1E26C97037BCBE16DC67E6DFD376FAD7", hash_generated_field = "65EDE4F9048CF09D46EC35F5340020DF")

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

