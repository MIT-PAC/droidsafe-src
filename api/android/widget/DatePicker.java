package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.annotation.Widget;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.NumberPicker.OnValueChangeListener;
import com.android.internal.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class DatePicker extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "8ED95193CF2BD359A1F40C120860D6B8", hash_generated_field = "57FC055B6C9771133CE6C857A7DABDD2")

    private LinearLayout mSpinners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "5A9A969CFB8D8086B1FE2DD0169FE3B6", hash_generated_field = "E9AD14BD1E7C73448246017F61A6910F")

    private NumberPicker mDaySpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "A52E01A57F27B740721F7C122B89AA94", hash_generated_field = "936D6FFF762C4ACBFCB2790E745CF627")

    private NumberPicker mMonthSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "1C92E397E6FF879517C64E647CABBF20", hash_generated_field = "0D7C6882B7118BD566A5477609D98248")

    private NumberPicker mYearSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "B8D2C6DF64E89393BFC4853CF107941C", hash_generated_field = "78DBE8E04B70C89A720FD198AB154490")

    private EditText mDaySpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "353E1901B27F26C47CCF10C8B1C9D852", hash_generated_field = "714D9147EB1533807E28758F3821E7DC")

    private EditText mMonthSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "4A401C6EEE207DC69829661302C397C2", hash_generated_field = "2F520BDB0A7FFE00F22D9FBE511FE790")

    private EditText mYearSpinnerInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "06B125B857EEE352CA593584AE56A22D", hash_generated_field = "C49C583656EEC355FE817D0FB30D86B9")

    private CalendarView mCalendarView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "01C16DE86C0D9E7618B5DC9FBE3D0F18", hash_generated_field = "62B8B5E7AE7E284B45C195AD700263A4")

    private OnDateChangedListener mOnDateChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "F8FA2D68BD3FAD10196FC3A202F1FE7B", hash_generated_field = "7C0E3CE4CDD41145783D01A374740E69")

    private String[] mShortMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.023 -0400", hash_original_field = "D09E60E802BCF776E697BC72D82FD915", hash_generated_field = "B406C1F86E2B5C90127E71BBD6EC950B")

    private final java.text.DateFormat mDateFormat = new SimpleDateFormat(DATE_FORMAT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_field = "55A152A1E331FEA518A7D8F50D68C2BE", hash_generated_field = "FC72141C7BE09CB007FDA2A11DEAADED")

    private int mNumberOfMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_field = "2CD58DB7365E32A740CCEDC539E005B5", hash_generated_field = "915400C77BD703DACB8E97CD72BFFD5E")

    private Calendar mTempDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_field = "E65E4BB5B38AD013B1E2F00B4ED9DF18", hash_generated_field = "681C6D172B5A021A54543F6E6ED5BD03")

    private Calendar mMinDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_field = "022B7F9BF85FB96A21762C2F3C1B66E0", hash_generated_field = "4C58BCC5BEA466149D70675257F2009F")

    private Calendar mMaxDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_field = "1B181112D1184C4C6442EEEED71CB9CD", hash_generated_field = "B33BB7B8B2F898A7B6FA7A6FCFAB9ED0")

    private Calendar mCurrentDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_field = "9F4735C7D2833FBB144CCBE86DA0A2AE", hash_generated_field = "0D83C9894006124680A4C4A755D8D1E4")

    private boolean mIsEnabled = DEFAULT_ENABLED_STATE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_method = "50BCEA2D1017959FF4E69EAB1E77D8E2", hash_generated_method = "A03F272C99CFB63521217D746D3029B2")
    public  DatePicker(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.024 -0400", hash_original_method = "4453FDB9501009C031AB3C09BDDF68BA", hash_generated_method = "3814AE2F6FB0853F5A2800A3640EC62F")
    public  DatePicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.datePickerStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.030 -0400", hash_original_method = "4E1923F4C9EC7B5B71246649E14A6878", hash_generated_method = "58E7A41E75EC5AB1A458253A7DA09EB5")
    public  DatePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setCurrentLocale(Locale.getDefault());
        TypedArray attributesArray = context.obtainStyledAttributes(attrs, R.styleable.DatePicker,
                defStyle, 0);
        boolean spinnersShown = attributesArray.getBoolean(R.styleable.DatePicker_spinnersShown,
                DEFAULT_SPINNERS_SHOWN);
        boolean calendarViewShown = attributesArray.getBoolean(
                R.styleable.DatePicker_calendarViewShown, DEFAULT_CALENDAR_VIEW_SHOWN);
        int startYear = attributesArray.getInt(R.styleable.DatePicker_startYear,
                DEFAULT_START_YEAR);
        int endYear = attributesArray.getInt(R.styleable.DatePicker_endYear, DEFAULT_END_YEAR);
        String minDate = attributesArray.getString(R.styleable.DatePicker_minDate);
        String maxDate = attributesArray.getString(R.styleable.DatePicker_maxDate);
        int layoutResourceId = attributesArray.getResourceId(R.styleable.DatePicker_layout,
                R.layout.date_picker);
        attributesArray.recycle();
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(layoutResourceId, this, true);
        OnValueChangeListener onChangeListener = new OnValueChangeListener() {
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                updateInputState();
                mTempDate.setTimeInMillis(mCurrentDate.getTimeInMillis());
                if (picker == mDaySpinner) {
                    int maxDayOfMonth = mTempDate.getActualMaximum(Calendar.DAY_OF_MONTH);
                    if (oldVal == maxDayOfMonth && newVal == 1) {
                        mTempDate.add(Calendar.DAY_OF_MONTH, 1);
                    } else if (oldVal == 1 && newVal == maxDayOfMonth) {
                        mTempDate.add(Calendar.DAY_OF_MONTH, -1);
                    } else {
                        mTempDate.add(Calendar.DAY_OF_MONTH, newVal - oldVal);
                    }
                } else if (picker == mMonthSpinner) {
                    if (oldVal == 11 && newVal == 0) {
                        mTempDate.add(Calendar.MONTH, 1);
                    } else if (oldVal == 0 && newVal == 11) {
                        mTempDate.add(Calendar.MONTH, -1);
                    } else {
                        mTempDate.add(Calendar.MONTH, newVal - oldVal);
                    }
                } else if (picker == mYearSpinner) {
                    mTempDate.set(Calendar.YEAR, newVal);
                } else {
                    throw new IllegalArgumentException();
                }
                setDate(mTempDate.get(Calendar.YEAR), mTempDate.get(Calendar.MONTH),
                        mTempDate.get(Calendar.DAY_OF_MONTH));
                updateSpinners();
                updateCalendarView();
                notifyDateChanged();
            }
        };
        mSpinners = (LinearLayout) findViewById(R.id.pickers);
        mCalendarView = (CalendarView) findViewById(R.id.calendar_view);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.026 -0400", hash_original_method = "8EC92A24243B88F9F674F29B26D1EE2F", hash_generated_method = "73ADFB7B2A0BEADBD73A1C6D29AC64D4")
        public void onSelectedDayChange(CalendarView view, int year, int month, int monthDay) {
            
            addTaint(monthDay);
            addTaint(month);
            addTaint(year);
            addTaint(view.getTaint());
            setDate(year, month, monthDay);
            updateSpinners();
            notifyDateChanged();
            
            
            
            
        }
});
        mDaySpinner = (NumberPicker) findViewById(R.id.day);
        mDaySpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mDaySpinner.setOnLongPressUpdateInterval(100);
        mDaySpinner.setOnValueChangedListener(onChangeListener);
        mDaySpinnerInput = (EditText) mDaySpinner.findViewById(R.id.numberpicker_input);
        mMonthSpinner = (NumberPicker) findViewById(R.id.month);
        mMonthSpinner.setMinValue(0);
        mMonthSpinner.setMaxValue(mNumberOfMonths - 1);
        mMonthSpinner.setDisplayedValues(mShortMonths);
        mMonthSpinner.setOnLongPressUpdateInterval(200);
        mMonthSpinner.setOnValueChangedListener(onChangeListener);
        mMonthSpinnerInput = (EditText) mMonthSpinner.findViewById(R.id.numberpicker_input);
        mYearSpinner = (NumberPicker) findViewById(R.id.year);
        mYearSpinner.setOnLongPressUpdateInterval(100);
        mYearSpinner.setOnValueChangedListener(onChangeListener);
        mYearSpinnerInput = (EditText) mYearSpinner.findViewById(R.id.numberpicker_input);
    if(!spinnersShown && !calendarViewShown)        
        {
            setSpinnersShown(true);
        } 
        else
        {
            setSpinnersShown(spinnersShown);
            setCalendarViewShown(calendarViewShown);
        } 
        mTempDate.clear();
    if(!TextUtils.isEmpty(minDate))        
        {
    if(!parseDate(minDate, mTempDate))            
            {
                mTempDate.set(startYear, 0, 1);
            } 
        } 
        else
        {
            mTempDate.set(startYear, 0, 1);
        } 
        setMinDate(mTempDate.getTimeInMillis());
        mTempDate.clear();
    if(!TextUtils.isEmpty(maxDate))        
        {
    if(!parseDate(maxDate, mTempDate))            
            {
                mTempDate.set(endYear, 11, 31);
            } 
        } 
        else
        {
            mTempDate.set(endYear, 11, 31);
        } 
        setMaxDate(mTempDate.getTimeInMillis());
        mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        init(mCurrentDate.get(Calendar.YEAR), mCurrentDate.get(Calendar.MONTH), mCurrentDate
                .get(Calendar.DAY_OF_MONTH), null);
        reorderSpinners();
    if(AccessibilityManager.getInstance(mContext).isEnabled())        
        {
            setContentDescriptions();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.031 -0400", hash_original_method = "B0CBF7B6208A95C236DA6913EAA0D341", hash_generated_method = "83BAB3D56AC1D62CA1701E6D179FB0B1")
    public long getMinDate() {
        long varBEC14540AC9FDEE199DA8EE34E55F5D3_1626258098 = (mCalendarView.getMinDate());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_763019251 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_763019251;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.032 -0400", hash_original_method = "E09B6ABF429EE8C7F43BA1D2176E3476", hash_generated_method = "E61550C1F5D2592522577257E1788897")
    public void setMinDate(long minDate) {
        addTaint(minDate);
        mTempDate.setTimeInMillis(minDate);
    if(mTempDate.get(Calendar.YEAR) == mMinDate.get(Calendar.YEAR)
                && mTempDate.get(Calendar.DAY_OF_YEAR) != mMinDate.get(Calendar.DAY_OF_YEAR))        
        {
            return;
        } 
        mMinDate.setTimeInMillis(minDate);
        mCalendarView.setMinDate(minDate);
    if(mCurrentDate.before(mMinDate))        
        {
            mCurrentDate.setTimeInMillis(mMinDate.getTimeInMillis());
            updateCalendarView();
        } 
        updateSpinners();
        
        
        
                
            
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.032 -0400", hash_original_method = "DB8F47FF49EF5F4454748F1EF70370BC", hash_generated_method = "C282A19D1841A7F643DB29C370D3E294")
    public long getMaxDate() {
        long varCF64B4B8F0B88C3BB8692AD803285BA0_1082199328 = (mCalendarView.getMaxDate());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_461876151 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_461876151;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.032 -0400", hash_original_method = "2F38894A8B9E3D925CDD9D98E5823853", hash_generated_method = "861058C3EA525DA2B9A4D62894D5F5E8")
    public void setMaxDate(long maxDate) {
        addTaint(maxDate);
        mTempDate.setTimeInMillis(maxDate);
    if(mTempDate.get(Calendar.YEAR) == mMaxDate.get(Calendar.YEAR)
                && mTempDate.get(Calendar.DAY_OF_YEAR) != mMaxDate.get(Calendar.DAY_OF_YEAR))        
        {
            return;
        } 
        mMaxDate.setTimeInMillis(maxDate);
        mCalendarView.setMaxDate(maxDate);
    if(mCurrentDate.after(mMaxDate))        
        {
            mCurrentDate.setTimeInMillis(mMaxDate.getTimeInMillis());
            updateCalendarView();
        } 
        updateSpinners();
        
        
        
                
            
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.033 -0400", hash_original_method = "515C7BC224A54DF2006916B644FD1165", hash_generated_method = "2D17F7CDECD8456545F53FF8255F46B1")
    @Override
    public void setEnabled(boolean enabled) {
    if(mIsEnabled == enabled)        
        {
            return;
        } 
        super.setEnabled(enabled);
        mDaySpinner.setEnabled(enabled);
        mMonthSpinner.setEnabled(enabled);
        mYearSpinner.setEnabled(enabled);
        mCalendarView.setEnabled(enabled);
        mIsEnabled = enabled;
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.033 -0400", hash_original_method = "FE60B57F2ECB259E877433DACC7AAC95", hash_generated_method = "56A148A33360E996D8641CCF5F084BF7")
    @Override
    public boolean isEnabled() {
        boolean var1D09076915F0C1B535F8F7A6899A12CD_1669073861 = (mIsEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517476700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517476700;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.033 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "37E3AA39CC0A2CC138268DF827A98A05")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        onPopulateAccessibilityEvent(event);
        boolean varB326B5062B2F0E69046810717534CB09_1460341727 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303150273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303150273;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.034 -0400", hash_original_method = "C41A760D3D0D618DC4D1C9DC2EF8ACD9", hash_generated_method = "C8A148DCA8E161687C4799AA7B348C61")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR;
        String selectedDateUtterance = DateUtils.formatDateTime(mContext,
                mCurrentDate.getTimeInMillis(), flags);
        event.getText().add(selectedDateUtterance);
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.034 -0400", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "127AACDA90D8DF77911A68D85F6663CF")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.034 -0400", hash_original_method = "F626AAF3D88CF2708A3C00197CF02609", hash_generated_method = "90705EE3534AC60672DEC9F0D59466B4")
    public boolean getCalendarViewShown() {
        boolean varF0BBC98082A69B1C2E662B1900398359_1703243570 = (mCalendarView.isShown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233121661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_233121661;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.034 -0400", hash_original_method = "E5E91372452D81D0FC87710458852870", hash_generated_method = "322E83A93BAC67867D6091CF6097204B")
    public CalendarView getCalendarView() {
CalendarView varC46E21775E2EA6ACA4FD7340AD5EC654_895597547 =         mCalendarView;
        varC46E21775E2EA6ACA4FD7340AD5EC654_895597547.addTaint(taint);
        return varC46E21775E2EA6ACA4FD7340AD5EC654_895597547;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.035 -0400", hash_original_method = "A6F7D559BB2BFC23B5A4662DCD0F1C14", hash_generated_method = "089D1A57AC4C19EA6DD77C6F66414EFF")
    public void setCalendarViewShown(boolean shown) {
        addTaint(shown);
        mCalendarView.setVisibility(shown ? VISIBLE : GONE);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.035 -0400", hash_original_method = "B5CFDF56FD0FFF53C840D3DAC615D008", hash_generated_method = "4EAA17C1EF999ABF5ABF8368DE08855F")
    public boolean getSpinnersShown() {
        boolean var08417A54551B1E0BF25ECE2FE2E6B82F_950676927 = (mSpinners.isShown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912430783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912430783;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.035 -0400", hash_original_method = "754F8D4BE212034B7CC0AFCD20BC9A92", hash_generated_method = "E7391B4E632B3B94B8ED2E2AAD63DF2C")
    public void setSpinnersShown(boolean shown) {
        addTaint(shown);
        mSpinners.setVisibility(shown ? VISIBLE : GONE);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.037 -0400", hash_original_method = "A700AEEDD57B848576647AE119590A45", hash_generated_method = "91427AE78830B364CC5D9449BD929F02")
    private void setCurrentLocale(Locale locale) {
    if(locale.equals(mCurrentLocale))        
        {
            return;
        } 
        mCurrentLocale = locale;
        mTempDate = getCalendarForLocale(mTempDate, locale);
        mMinDate = getCalendarForLocale(mMinDate, locale);
        mMaxDate = getCalendarForLocale(mMaxDate, locale);
        mCurrentDate = getCalendarForLocale(mCurrentDate, locale);
        mNumberOfMonths = mTempDate.getActualMaximum(Calendar.MONTH) + 1;
        mShortMonths = new String[mNumberOfMonths];
for(int i = 0;i < mNumberOfMonths;i++)
        {
            mShortMonths[i] = DateUtils.getMonthString(Calendar.JANUARY + i,
                    DateUtils.LENGTH_MEDIUM);
        } 
        
        
            
        
        
        
        
        
        
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.037 -0400", hash_original_method = "FA738DF80665124C3A5E01ADC04827D9", hash_generated_method = "9B47EE2AD7633C9EB1329AA31DE3354C")
    private Calendar getCalendarForLocale(Calendar oldCalendar, Locale locale) {
        addTaint(locale.getTaint());
        addTaint(oldCalendar.getTaint());
    if(oldCalendar == null)        
        {
Calendar varAF9F889F6AAD514FC782043E6832D0EC_2132299205 =             Calendar.getInstance(locale);
            varAF9F889F6AAD514FC782043E6832D0EC_2132299205.addTaint(taint);
            return varAF9F889F6AAD514FC782043E6832D0EC_2132299205;
        } 
        else
        {
            final long currentTimeMillis = oldCalendar.getTimeInMillis();
            Calendar newCalendar = Calendar.getInstance(locale);
            newCalendar.setTimeInMillis(currentTimeMillis);
Calendar var7F1C6FE82B6466987740139940995C7D_264686163 =             newCalendar;
            var7F1C6FE82B6466987740139940995C7D_264686163.addTaint(taint);
            return var7F1C6FE82B6466987740139940995C7D_264686163;
        } 
        
        
            
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.038 -0400", hash_original_method = "EC825478EA562937FD242C7F7D2C8CF4", hash_generated_method = "D66C072D069E6B94A1F23A66A74AEC46")
    private void reorderSpinners() {
        mSpinners.removeAllViews();
        char[] order = DateFormat.getDateFormatOrder(getContext());
        final int spinnerCount = order.length;
for(int i = 0;i < spinnerCount;i++)
        {
switch(order[i]){
            case DateFormat.DATE:
            mSpinners.addView(mDaySpinner);
            setImeOptions(mDaySpinner, spinnerCount, i);
            break;
            case DateFormat.MONTH:
            mSpinners.addView(mMonthSpinner);
            setImeOptions(mMonthSpinner, spinnerCount, i);
            break;
            case DateFormat.YEAR:
            mSpinners.addView(mYearSpinner);
            setImeOptions(mYearSpinner, spinnerCount, i);
            break;
            default:
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_26927036 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_26927036.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_26927036;
}
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.038 -0400", hash_original_method = "4C1492E37715D23031DBB004E3447195", hash_generated_method = "87AA37D3CA3C262F4D3F044EBC4D647B")
    public void updateDate(int year, int month, int dayOfMonth) {
        addTaint(dayOfMonth);
        addTaint(month);
        addTaint(year);
    if(!isNewDate(year, month, dayOfMonth))        
        {
            return;
        } 
        setDate(year, month, dayOfMonth);
        updateSpinners();
        updateCalendarView();
        notifyDateChanged();
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.039 -0400", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "049C55C9929D94261AAC15AFD146322A")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        dispatchThawSelfOnly(container);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.039 -0400", hash_original_method = "5DB0198ABA6176C6419BBD5D6E2C0EE9", hash_generated_method = "27242F993117A56CB3C8B3AF75907756")
    @Override
    protected Parcelable onSaveInstanceState() {
        
        Parcelable superState = super.onSaveInstanceState();
Parcelable var0D586CC5BD129F440CEF1D4046358DB7_1098452272 =         new SavedState(superState, getYear(), getMonth(), getDayOfMonth());
        var0D586CC5BD129F440CEF1D4046358DB7_1098452272.addTaint(taint);
        return var0D586CC5BD129F440CEF1D4046358DB7_1098452272;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.039 -0400", hash_original_method = "7BB26B54419EB3FE0435D4F561876035", hash_generated_method = "C82D16D9C1A79E7CC585ADB82C108C72")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setDate(ss.mYear, ss.mMonth, ss.mDay);
        updateSpinners();
        updateCalendarView();
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.040 -0400", hash_original_method = "D658CCE01B7A83A418EB2AC2C82BF7D5", hash_generated_method = "BB9CF5D3C2CDDCEED10EB2EE4F0641CB")
    public void init(int year, int monthOfYear, int dayOfMonth,
            OnDateChangedListener onDateChangedListener) {
        addTaint(dayOfMonth);
        addTaint(monthOfYear);
        addTaint(year);
        setDate(year, monthOfYear, dayOfMonth);
        updateSpinners();
        updateCalendarView();
        mOnDateChangedListener = onDateChangedListener;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.040 -0400", hash_original_method = "4EF37BB5E8B6D289AE6D0021CE0D4FEB", hash_generated_method = "A357717148B7CFDAF84CD4EF26C0A7EA")
    private boolean parseDate(String date, Calendar outDate) {
        addTaint(outDate.getTaint());
        addTaint(date.getTaint());
        try 
        {
            outDate.setTime(mDateFormat.parse(date));
            boolean varB326B5062B2F0E69046810717534CB09_1470785049 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772211124 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_772211124;
        } 
        catch (ParseException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1921675668 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1890506154 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1890506154;
        } 
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.041 -0400", hash_original_method = "7DA7F7B10A47108B3DBE60145E22A8FC", hash_generated_method = "61245212FC9DB242AB5666F9DB45E54D")
    private boolean isNewDate(int year, int month, int dayOfMonth) {
        addTaint(dayOfMonth);
        addTaint(month);
        addTaint(year);
        boolean var37D1E9EC03E951EC9E99033ECE8DF76D_1642926864 = ((mCurrentDate.get(Calendar.YEAR) != year
                || mCurrentDate.get(Calendar.MONTH) != dayOfMonth
                || mCurrentDate.get(Calendar.DAY_OF_MONTH) != month));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_477458078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_477458078;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.041 -0400", hash_original_method = "421AA01E04B51628D97359BDD118BF23", hash_generated_method = "DEE3B41D776703A0B4CC6AA3CE42340A")
    private void setDate(int year, int month, int dayOfMonth) {
        addTaint(dayOfMonth);
        addTaint(month);
        addTaint(year);
        mCurrentDate.set(year, month, dayOfMonth);
    if(mCurrentDate.before(mMinDate))        
        {
            mCurrentDate.setTimeInMillis(mMinDate.getTimeInMillis());
        } 
        else
    if(mCurrentDate.after(mMaxDate))        
        {
            mCurrentDate.setTimeInMillis(mMaxDate.getTimeInMillis());
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.042 -0400", hash_original_method = "CC0C6797D7B0307D38215BFED9C815FE", hash_generated_method = "D029609BFFE75683162806ED86F12468")
    private void updateSpinners() {
    if(mCurrentDate.equals(mMinDate))        
        {
            mDaySpinner.setMinValue(mCurrentDate.get(Calendar.DAY_OF_MONTH));
            mDaySpinner.setMaxValue(mCurrentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
            mDaySpinner.setWrapSelectorWheel(false);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(mCurrentDate.get(Calendar.MONTH));
            mMonthSpinner.setMaxValue(mCurrentDate.getActualMaximum(Calendar.MONTH));
            mMonthSpinner.setWrapSelectorWheel(false);
        } 
        else
    if(mCurrentDate.equals(mMaxDate))        
        {
            mDaySpinner.setMinValue(mCurrentDate.getActualMinimum(Calendar.DAY_OF_MONTH));
            mDaySpinner.setMaxValue(mCurrentDate.get(Calendar.DAY_OF_MONTH));
            mDaySpinner.setWrapSelectorWheel(false);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(mCurrentDate.getActualMinimum(Calendar.MONTH));
            mMonthSpinner.setMaxValue(mCurrentDate.get(Calendar.MONTH));
            mMonthSpinner.setWrapSelectorWheel(false);
        } 
        else
        {
            mDaySpinner.setMinValue(1);
            mDaySpinner.setMaxValue(mCurrentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
            mDaySpinner.setWrapSelectorWheel(true);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(0);
            mMonthSpinner.setMaxValue(11);
            mMonthSpinner.setWrapSelectorWheel(true);
        } 
        String[] displayedValues = Arrays.copyOfRange(mShortMonths,
                mMonthSpinner.getMinValue(), mMonthSpinner.getMaxValue() + 1);
        mMonthSpinner.setDisplayedValues(displayedValues);
        mYearSpinner.setMinValue(mMinDate.get(Calendar.YEAR));
        mYearSpinner.setMaxValue(mMaxDate.get(Calendar.YEAR));
        mYearSpinner.setWrapSelectorWheel(false);
        mYearSpinner.setValue(mCurrentDate.get(Calendar.YEAR));
        mMonthSpinner.setValue(mCurrentDate.get(Calendar.MONTH));
        mDaySpinner.setValue(mCurrentDate.get(Calendar.DAY_OF_MONTH));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.042 -0400", hash_original_method = "FCBFFA03953049B21025A6ECF65DCE7B", hash_generated_method = "1374E2CB7A57CFB36E9738E5446FFEF5")
    private void updateCalendarView() {
        mCalendarView.setDate(mCurrentDate.getTimeInMillis(), false, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.042 -0400", hash_original_method = "3B3D6844E7A836293DFA1A3CC86782AF", hash_generated_method = "632531FAA1C2A557908B56F414A89EDD")
    public int getYear() {
        int varB351B299D55CF645E77E341D083AD08E_1086421447 = (mCurrentDate.get(Calendar.YEAR));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35424548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35424548;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.043 -0400", hash_original_method = "38D3E39BF141F42FF09C6079CAB15EDC", hash_generated_method = "E05359123AF61BC7CA4DB51FD3D36853")
    public int getMonth() {
        int varAFBFC70C4685CAC22170677B852626C4_170363359 = (mCurrentDate.get(Calendar.MONTH));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016109687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016109687;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.043 -0400", hash_original_method = "8FBF5DD56EFFBE6D332AE82BD8F4BBB9", hash_generated_method = "AEE3F5E8C34E0E20CAFE67DAC57B6A28")
    public int getDayOfMonth() {
        int var047F4BAAB24777018B0F7C120930514E_1029950064 = (mCurrentDate.get(Calendar.DAY_OF_MONTH));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300695828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300695828;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.043 -0400", hash_original_method = "B58D4A1A16597327E1564790BB46799A", hash_generated_method = "C13E2D20D4C44B6D819874FA50654C0F")
    private void notifyDateChanged() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
    if(mOnDateChangedListener != null)        
        {
            mOnDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.044 -0400", hash_original_method = "70CD174A23393C16E923952AAD4C91D4", hash_generated_method = "4D3B23B87856C132784ABFBF928AA1F6")
    private void setImeOptions(NumberPicker spinner, int spinnerCount, int spinnerIndex) {
        addTaint(spinnerIndex);
        addTaint(spinnerCount);
        addTaint(spinner.getTaint());
        int imeOptions;
    if(spinnerIndex < spinnerCount - 1)        
        {
            imeOptions = EditorInfo.IME_ACTION_NEXT;
        } 
        else
        {
            imeOptions = EditorInfo.IME_ACTION_DONE;
        } 
        TextView input = (TextView) spinner.findViewById(R.id.numberpicker_input);
        input.setImeOptions(imeOptions);
        
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.045 -0400", hash_original_method = "DB545D481E75722C0C153D7F54EF544D", hash_generated_method = "A9A247ABA3DD44339D21CC3829DDDBC6")
    private void setContentDescriptions() {
        String text = mContext.getString(R.string.date_picker_increment_day_button);
        mDaySpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_decrement_day_button);
        mDaySpinner.findViewById(R.id.decrement).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_increment_month_button);
        mMonthSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_decrement_month_button);
        mMonthSpinner.findViewById(R.id.decrement).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_increment_year_button);
        mYearSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_decrement_year_button);
        mYearSpinner.findViewById(R.id.decrement).setContentDescription(text);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.045 -0400", hash_original_method = "CDABFADCA81181A0329F14F43A5F5848", hash_generated_method = "DC66B97B0B1BB902918C584526236453")
    private void updateInputState() {
        InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
    if(inputMethodManager != null)        
        {
    if(inputMethodManager.isActive(mYearSpinnerInput))            
            {
                mYearSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } 
            else
    if(inputMethodManager.isActive(mMonthSpinnerInput))            
            {
                mMonthSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } 
            else
    if(inputMethodManager.isActive(mDaySpinnerInput))            
            {
                mDaySpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } 
        } 
        
        
        
            
                
                
            
                
                
            
                
                
            
        
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.045 -0400", hash_original_field = "11D990E1A246B4FE4069EE207D869D9B", hash_generated_field = "0FB397B5159C15D66CFFB31661F31030")

        private int mYear;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.045 -0400", hash_original_field = "17AC63C47F9382CDD83D410CF577C33A", hash_generated_field = "B60DEE2EFD4F8FC07E416B8343AFCB00")

        private int mMonth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.045 -0400", hash_original_field = "A94ED4F55B6AE30F93C2C2635CEB056B", hash_generated_field = "084BEC9B9077623100292A9AB444BB6A")

        private int mDay;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.046 -0400", hash_original_method = "A02F651556C80A285B651552B4D99E55", hash_generated_method = "D8AB391D75CA1C9FD251EFD34F7687CF")
        private  SavedState(Parcelable superState, int year, int month, int day) {
            super(superState);
            addTaint(superState.getTaint());
            mYear = year;
            mMonth = month;
            mDay = day;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.046 -0400", hash_original_method = "CA21CAD6F1AA58ABF5FA7E877A966564", hash_generated_method = "529258F22E562DCA4D2F461195E4F6E4")
        private  SavedState(Parcel in) {
            super(in);
            mYear = in.readInt();
            mMonth = in.readInt();
            mDay = in.readInt();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_method = "AFDD7CDA63529FFA8C3C3C99BF58C7E4", hash_generated_method = "7B0AF314ED281EB74E22CEE9647E6B07")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            super.writeToParcel(dest, flags);
            dest.writeInt(mYear);
            dest.writeInt(mMonth);
            dest.writeInt(mDay);
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "D1498A1D28CCBBEB217C9EC7E28F9C3B", hash_generated_field = "FDAFF8F4064E6C5834BC3B23DD26F968")

        @SuppressWarnings("all")
        
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    public interface OnDateChangedListener {

        
        void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "ACAE6EBC3CF48E844ECDEC6F258057CD", hash_generated_field = "9AEACC319D08BF18BF3DF5EC9A62E42B")

    private static final String LOG_TAG = DatePicker.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "7D0AA228503FFF788A6CED655322E089", hash_generated_field = "92A4E472511D5AB0B2A3BE852088B3B7")

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "F3F8F2E983FBDE4D0CFA413545412A88", hash_generated_field = "3D715F707E83C4D5095B646047A5B1CE")

    private static final int DEFAULT_START_YEAR = 1900;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "24226D6FB985CB71B2100819FF444D08", hash_generated_field = "9BC7705443E7BEBF66658C145A361562")

    private static final int DEFAULT_END_YEAR = 2100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "C1544E16BAB1221A60D8907F2F983D83", hash_generated_field = "7B3A1EBBF4899FDB67AECAC357D65551")

    private static final boolean DEFAULT_CALENDAR_VIEW_SHOWN = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "943AEB93A0ADA1D13513A4CF976BD26F", hash_generated_field = "42113FF0020FE8EE0346E7E82FAD2CC1")

    private static final boolean DEFAULT_SPINNERS_SHOWN = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:05.047 -0400", hash_original_field = "341D07F1E4A62FB066D5A2BBC1DD2D1E", hash_generated_field = "C8A8F0463DBF19CC5664F198B037CB59")

    private static final boolean DEFAULT_ENABLED_STATE = true;
}

