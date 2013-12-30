package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.NumberPicker.OnValueChangeListener;

import com.android.internal.R;






public class DatePicker extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.252 -0500", hash_original_field = "DB5F358B7F4754051F12CE812D849E52", hash_generated_field = "9AEACC319D08BF18BF3DF5EC9A62E42B")


    private static final String LOG_TAG = DatePicker.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.255 -0500", hash_original_field = "4A21EFC12B8A7D00AD012663E0282367", hash_generated_field = "92A4E472511D5AB0B2A3BE852088B3B7")


    private static final String DATE_FORMAT = "MM/dd/yyyy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.257 -0500", hash_original_field = "E4CBC45686354E459FE7052D14166371", hash_generated_field = "3D715F707E83C4D5095B646047A5B1CE")


    private static final int DEFAULT_START_YEAR = 1900;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.259 -0500", hash_original_field = "49393752A631FB46ABBE7A334B482664", hash_generated_field = "9BC7705443E7BEBF66658C145A361562")


    private static final int DEFAULT_END_YEAR = 2100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.261 -0500", hash_original_field = "51CFCD28C1044BC7D7DB0D32DD5C788F", hash_generated_field = "7B3A1EBBF4899FDB67AECAC357D65551")


    private static final boolean DEFAULT_CALENDAR_VIEW_SHOWN = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.264 -0500", hash_original_field = "258C59A405D8D93C11B1B8284E5247BD", hash_generated_field = "42113FF0020FE8EE0346E7E82FAD2CC1")


    private static final boolean DEFAULT_SPINNERS_SHOWN = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.266 -0500", hash_original_field = "898BA2CFB8E606FE0E662F55EA307C06", hash_generated_field = "C8A8F0463DBF19CC5664F198B037CB59")


    private static final boolean DEFAULT_ENABLED_STATE = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.268 -0500", hash_original_field = "F7D3783360870E5ADC7E3C95446CAB72", hash_generated_field = "57FC055B6C9771133CE6C857A7DABDD2")


    private  LinearLayout mSpinners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.271 -0500", hash_original_field = "2787E2D8252B04673FC0F959DE7D3E60", hash_generated_field = "E9AD14BD1E7C73448246017F61A6910F")


    private  NumberPicker mDaySpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.273 -0500", hash_original_field = "67D3C0D8C44FB19EB3B5DC42BB019D9E", hash_generated_field = "936D6FFF762C4ACBFCB2790E745CF627")


    private  NumberPicker mMonthSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.275 -0500", hash_original_field = "B556D34CCAECD56310F9101F5A71D934", hash_generated_field = "0D7C6882B7118BD566A5477609D98248")


    private  NumberPicker mYearSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.277 -0500", hash_original_field = "1C31E9FE7637575499D36341EC2352A0", hash_generated_field = "78DBE8E04B70C89A720FD198AB154490")


    private  EditText mDaySpinnerInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.280 -0500", hash_original_field = "70900D4A1BA58F6BC104684B69530718", hash_generated_field = "714D9147EB1533807E28758F3821E7DC")


    private  EditText mMonthSpinnerInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.282 -0500", hash_original_field = "2CB5CEA19E6932650FEA9AC1A93B81BC", hash_generated_field = "2F520BDB0A7FFE00F22D9FBE511FE790")


    private  EditText mYearSpinnerInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.284 -0500", hash_original_field = "1B0EE231C37DFD1440974793432E7287", hash_generated_field = "C49C583656EEC355FE817D0FB30D86B9")


    private  CalendarView mCalendarView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.286 -0500", hash_original_field = "0400C5C553DC4CBF37271C21855854A7", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")


    private Locale mCurrentLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.288 -0500", hash_original_field = "72C84DF3DA4BA4A970D606A9E6CEFE1D", hash_generated_field = "62B8B5E7AE7E284B45C195AD700263A4")


    private OnDateChangedListener mOnDateChangedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.291 -0500", hash_original_field = "796E8CED1101DF2EF5A5164772240BBA", hash_generated_field = "7C0E3CE4CDD41145783D01A374740E69")


    private String[] mShortMonths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.293 -0500", hash_original_field = "14347A98AF9CE70FD1B6F60D5AA3ADC1", hash_generated_field = "B406C1F86E2B5C90127E71BBD6EC950B")


    private final java.text.DateFormat mDateFormat = new SimpleDateFormat(DATE_FORMAT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.295 -0500", hash_original_field = "DEB2F8CBCD9DA8EF1D6F144BAF9623D4", hash_generated_field = "FC72141C7BE09CB007FDA2A11DEAADED")


    private int mNumberOfMonths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.297 -0500", hash_original_field = "83B9DD6E7508BD94D813D2BBAE835A2C", hash_generated_field = "915400C77BD703DACB8E97CD72BFFD5E")


    private Calendar mTempDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.299 -0500", hash_original_field = "3DB37928D9BCCB809A9FC162964B0E42", hash_generated_field = "681C6D172B5A021A54543F6E6ED5BD03")


    private Calendar mMinDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.301 -0500", hash_original_field = "E3F10F4404115CF847283246E14AF324", hash_generated_field = "4C58BCC5BEA466149D70675257F2009F")


    private Calendar mMaxDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.303 -0500", hash_original_field = "9358DBF3EFD1E42380289ED1C04ECC53", hash_generated_field = "B33BB7B8B2F898A7B6FA7A6FCFAB9ED0")


    private Calendar mCurrentDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.305 -0500", hash_original_field = "D4A6DCF8382D9EC800648673F5DFADA3", hash_generated_field = "0D83C9894006124680A4C4A755D8D1E4")


    private boolean mIsEnabled = DEFAULT_ENABLED_STATE;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.310 -0500", hash_original_method = "50BCEA2D1017959FF4E69EAB1E77D8E2", hash_generated_method = "6F2E61B89CEFB62CF4F71B0972CC40F3")
    
public DatePicker(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.312 -0500", hash_original_method = "4453FDB9501009C031AB3C09BDDF68BA", hash_generated_method = "8F0012AAAA74FA4B21AE1994580BD446")
    
public DatePicker(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.datePickerStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.325 -0500", hash_original_method = "4E1923F4C9EC7B5B71246649E14A6878", hash_generated_method = "2C7BE98DEBB79A55EAFF791620D55AF4")
    
public DatePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // initialization based on locale
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
                // take care of wrapping of days and months to update greater fields
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
                // now set the date to the adjusted one
                setDate(mTempDate.get(Calendar.YEAR), mTempDate.get(Calendar.MONTH),
                        mTempDate.get(Calendar.DAY_OF_MONTH));
                updateSpinners();
                updateCalendarView();
                notifyDateChanged();
            }
        };

        mSpinners = (LinearLayout) findViewById(R.id.pickers);

        // calendar view day-picker
        mCalendarView = (CalendarView) findViewById(R.id.calendar_view);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int monthDay) {
                setDate(year, month, monthDay);
                updateSpinners();
                notifyDateChanged();
            }
        });

        // day
        mDaySpinner = (NumberPicker) findViewById(R.id.day);
        mDaySpinner.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mDaySpinner.setOnLongPressUpdateInterval(100);
        mDaySpinner.setOnValueChangedListener(onChangeListener);
        mDaySpinnerInput = (EditText) mDaySpinner.findViewById(R.id.numberpicker_input);

        // month
        mMonthSpinner = (NumberPicker) findViewById(R.id.month);
        mMonthSpinner.setMinValue(0);
        mMonthSpinner.setMaxValue(mNumberOfMonths - 1);
        mMonthSpinner.setDisplayedValues(mShortMonths);
        mMonthSpinner.setOnLongPressUpdateInterval(200);
        mMonthSpinner.setOnValueChangedListener(onChangeListener);
        mMonthSpinnerInput = (EditText) mMonthSpinner.findViewById(R.id.numberpicker_input);

        // year
        mYearSpinner = (NumberPicker) findViewById(R.id.year);
        mYearSpinner.setOnLongPressUpdateInterval(100);
        mYearSpinner.setOnValueChangedListener(onChangeListener);
        mYearSpinnerInput = (EditText) mYearSpinner.findViewById(R.id.numberpicker_input);

        // show only what the user required but make sure we
        // show something and the spinners have higher priority
        if (!spinnersShown && !calendarViewShown) {
            setSpinnersShown(true);
        } else {
            setSpinnersShown(spinnersShown);
            setCalendarViewShown(calendarViewShown);
        }

        // set the min date giving priority of the minDate over startYear
        mTempDate.clear();
        if (!TextUtils.isEmpty(minDate)) {
            if (!parseDate(minDate, mTempDate)) {
                mTempDate.set(startYear, 0, 1);
            }
        } else {
            mTempDate.set(startYear, 0, 1);
        }
        setMinDate(mTempDate.getTimeInMillis());

        // set the max date giving priority of the maxDate over endYear
        mTempDate.clear();
        if (!TextUtils.isEmpty(maxDate)) {
            if (!parseDate(maxDate, mTempDate)) {
                mTempDate.set(endYear, 11, 31);
            }
        } else {
            mTempDate.set(endYear, 11, 31);
        }
        setMaxDate(mTempDate.getTimeInMillis());

        // initialize to current date
        mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        init(mCurrentDate.get(Calendar.YEAR), mCurrentDate.get(Calendar.MONTH), mCurrentDate
                .get(Calendar.DAY_OF_MONTH), null);

        // re-order the number spinners to match the current date format
        reorderSpinners();

        // set content descriptions
        if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            setContentDescriptions();
        }
    }

    /**
     * Gets the minimal date supported by this {@link DatePicker} in
     * milliseconds since January 1, 1970 00:00:00 in
     * {@link TimeZone#getDefault()} time zone.
     * <p>
     * Note: The default minimal date is 01/01/1900.
     * <p>
     *
     * @return The minimal supported date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.327 -0500", hash_original_method = "B0CBF7B6208A95C236DA6913EAA0D341", hash_generated_method = "E6EDB6BEB6A737AFEA6A6EB9689DB7C4")
    
public long getMinDate() {
        return mCalendarView.getMinDate();
    }

    /**
     * Sets the minimal date supported by this {@link NumberPicker} in
     * milliseconds since January 1, 1970 00:00:00 in
     * {@link TimeZone#getDefault()} time zone.
     *
     * @param minDate The minimal supported date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.329 -0500", hash_original_method = "E09B6ABF429EE8C7F43BA1D2176E3476", hash_generated_method = "A5E0C3CAF077EE78809E6F9EE5AB6BC6")
    
public void setMinDate(long minDate) {
        mTempDate.setTimeInMillis(minDate);
        if (mTempDate.get(Calendar.YEAR) == mMinDate.get(Calendar.YEAR)
                && mTempDate.get(Calendar.DAY_OF_YEAR) != mMinDate.get(Calendar.DAY_OF_YEAR)) {
            return;
        }
        mMinDate.setTimeInMillis(minDate);
        mCalendarView.setMinDate(minDate);
        if (mCurrentDate.before(mMinDate)) {
            mCurrentDate.setTimeInMillis(mMinDate.getTimeInMillis());
            updateCalendarView();
        }
        updateSpinners();
    }

    /**
     * Gets the maximal date supported by this {@link DatePicker} in
     * milliseconds since January 1, 1970 00:00:00 in
     * {@link TimeZone#getDefault()} time zone.
     * <p>
     * Note: The default maximal date is 12/31/2100.
     * <p>
     *
     * @return The maximal supported date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.331 -0500", hash_original_method = "DB8F47FF49EF5F4454748F1EF70370BC", hash_generated_method = "2B68E56D35161B8E854F850DC6340800")
    
public long getMaxDate() {
        return mCalendarView.getMaxDate();
    }

    /**
     * Sets the maximal date supported by this {@link DatePicker} in
     * milliseconds since January 1, 1970 00:00:00 in
     * {@link TimeZone#getDefault()} time zone.
     *
     * @param maxDate The maximal supported date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.334 -0500", hash_original_method = "2F38894A8B9E3D925CDD9D98E5823853", hash_generated_method = "962D5C7AB3F1FBE5665262D118A0BDA7")
    
public void setMaxDate(long maxDate) {
        mTempDate.setTimeInMillis(maxDate);
        if (mTempDate.get(Calendar.YEAR) == mMaxDate.get(Calendar.YEAR)
                && mTempDate.get(Calendar.DAY_OF_YEAR) != mMaxDate.get(Calendar.DAY_OF_YEAR)) {
            return;
        }
        mMaxDate.setTimeInMillis(maxDate);
        mCalendarView.setMaxDate(maxDate);
        if (mCurrentDate.after(mMaxDate)) {
            mCurrentDate.setTimeInMillis(mMaxDate.getTimeInMillis());
            updateCalendarView();
        }
        updateSpinners();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.336 -0500", hash_original_method = "515C7BC224A54DF2006916B644FD1165", hash_generated_method = "A2D4769858836534498A79D70ADC4A25")
    
@Override
    public void setEnabled(boolean enabled) {
        if (mIsEnabled == enabled) {
            return;
        }
        super.setEnabled(enabled);
        mDaySpinner.setEnabled(enabled);
        mMonthSpinner.setEnabled(enabled);
        mYearSpinner.setEnabled(enabled);
        mCalendarView.setEnabled(enabled);
        mIsEnabled = enabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.338 -0500", hash_original_method = "FE60B57F2ECB259E877433DACC7AAC95", hash_generated_method = "E052E34E14B49938085DD6DF12A76E29")
    
@Override
    public boolean isEnabled() {
        return mIsEnabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.341 -0500", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "B2DB9880D1A02B35D29BED9E1EE131DA")
    
@Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.344 -0500", hash_original_method = "C41A760D3D0D618DC4D1C9DC2EF8ACD9", hash_generated_method = "2A0A19A48961F1A5116B8B0203269EE0")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);

        final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR;
        String selectedDateUtterance = DateUtils.formatDateTime(mContext,
                mCurrentDate.getTimeInMillis(), flags);
        event.getText().add(selectedDateUtterance);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.346 -0500", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "6328851CBC85DA1645204E969B0A309A")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
    }

    /**
     * Gets whether the {@link CalendarView} is shown.
     *
     * @return True if the calendar view is shown.
     * @see #getCalendarView()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.348 -0500", hash_original_method = "F626AAF3D88CF2708A3C00197CF02609", hash_generated_method = "83E5520CA1E3B082E0D21B26E73B6F1E")
    
public boolean getCalendarViewShown() {
        return mCalendarView.isShown();
    }

    /**
     * Gets the {@link CalendarView}.
     *
     * @return The calendar view.
     * @see #getCalendarViewShown()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.350 -0500", hash_original_method = "E5E91372452D81D0FC87710458852870", hash_generated_method = "4205A74B1C6BF3BD814050DEB01BD423")
    
public CalendarView getCalendarView () {
        return mCalendarView;
    }

    /**
     * Sets whether the {@link CalendarView} is shown.
     *
     * @param shown True if the calendar view is to be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.352 -0500", hash_original_method = "A6F7D559BB2BFC23B5A4662DCD0F1C14", hash_generated_method = "6C31E4096210697EF421BEBE5F364620")
    
public void setCalendarViewShown(boolean shown) {
        mCalendarView.setVisibility(shown ? VISIBLE : GONE);
    }

    /**
     * Gets whether the spinners are shown.
     *
     * @return True if the spinners are shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.354 -0500", hash_original_method = "B5CFDF56FD0FFF53C840D3DAC615D008", hash_generated_method = "E9A20BB0225E814041A100B970631119")
    
public boolean getSpinnersShown() {
        return mSpinners.isShown();
    }

    /**
     * Sets whether the spinners are shown.
     *
     * @param shown True if the spinners are to be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.356 -0500", hash_original_method = "754F8D4BE212034B7CC0AFCD20BC9A92", hash_generated_method = "B23BC79C99E594F98A0EBC6F1119D81F")
    
public void setSpinnersShown(boolean shown) {
        mSpinners.setVisibility(shown ? VISIBLE : GONE);
    }

    /**
     * Sets the current locale.
     *
     * @param locale The current locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.359 -0500", hash_original_method = "A700AEEDD57B848576647AE119590A45", hash_generated_method = "8A65553EE1D07E51B6829B4DD1184241")
    
private void setCurrentLocale(Locale locale) {
        if (locale.equals(mCurrentLocale)) {
            return;
        }

        mCurrentLocale = locale;

        mTempDate = getCalendarForLocale(mTempDate, locale);
        mMinDate = getCalendarForLocale(mMinDate, locale);
        mMaxDate = getCalendarForLocale(mMaxDate, locale);
        mCurrentDate = getCalendarForLocale(mCurrentDate, locale);

        mNumberOfMonths = mTempDate.getActualMaximum(Calendar.MONTH) + 1;
        mShortMonths = new String[mNumberOfMonths];
        for (int i = 0; i < mNumberOfMonths; i++) {
            mShortMonths[i] = DateUtils.getMonthString(Calendar.JANUARY + i,
                    DateUtils.LENGTH_MEDIUM);
        }
    }

    /**
     * Gets a calendar for locale bootstrapped with the value of a given calendar.
     *
     * @param oldCalendar The old calendar.
     * @param locale The locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.361 -0500", hash_original_method = "FA738DF80665124C3A5E01ADC04827D9", hash_generated_method = "FF2C9EE6088D5A80898CD22EED43D339")
    
private Calendar getCalendarForLocale(Calendar oldCalendar, Locale locale) {
        if (oldCalendar == null) {
            return Calendar.getInstance(locale);
        } else {
            final long currentTimeMillis = oldCalendar.getTimeInMillis();
            Calendar newCalendar = Calendar.getInstance(locale);
            newCalendar.setTimeInMillis(currentTimeMillis);
            return newCalendar;
        }
    }

    /**
     * Reorders the spinners according to the date format that is
     * explicitly set by the user and if no such is set fall back
     * to the current locale's default format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.363 -0500", hash_original_method = "EC825478EA562937FD242C7F7D2C8CF4", hash_generated_method = "3AB674C783C75714C7B9E143901FB9C5")
    
private void reorderSpinners() {
        mSpinners.removeAllViews();
        char[] order = DateFormat.getDateFormatOrder(getContext());
        final int spinnerCount = order.length;
        for (int i = 0; i < spinnerCount; i++) {
            switch (order[i]) {
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
                    throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Updates the current date.
     *
     * @param year The year.
     * @param month The month which is <strong>starting from zero</strong>.
     * @param dayOfMonth The day of the month.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.366 -0500", hash_original_method = "4C1492E37715D23031DBB004E3447195", hash_generated_method = "1AF5CC187F6B38A39E57E1A57802103F")
    
public void updateDate(int year, int month, int dayOfMonth) {
        if (!isNewDate(year, month, dayOfMonth)) {
            return;
        }
        setDate(year, month, dayOfMonth);
        updateSpinners();
        updateCalendarView();
        notifyDateChanged();
    }

    // Override so we are in complete control of save / restore for this widget.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.368 -0500", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "C22EB0BEA05DE70A2CBD1DE4B70D044B")
    
@Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.371 -0500", hash_original_method = "5DB0198ABA6176C6419BBD5D6E2C0EE9", hash_generated_method = "B665ACF49AE54575723CB897CAF8113E")
    
@Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new SavedState(superState, getYear(), getMonth(), getDayOfMonth());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.373 -0500", hash_original_method = "7BB26B54419EB3FE0435D4F561876035", hash_generated_method = "C7BBBEC0B2DBA5005BB6406C41C973D2")
    
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setDate(ss.mYear, ss.mMonth, ss.mDay);
        updateSpinners();
        updateCalendarView();
    }

    /**
     * Initialize the state. If the provided values designate an inconsistent
     * date the values are normalized before updating the spinners.
     *
     * @param year The initial year.
     * @param monthOfYear The initial month <strong>starting from zero</strong>.
     * @param dayOfMonth The initial day of the month.
     * @param onDateChangedListener How user is notified date is changed by
     *            user, can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.375 -0500", hash_original_method = "D658CCE01B7A83A418EB2AC2C82BF7D5", hash_generated_method = "90D58BB6DCA89B9CDC860B83114D68E2")
    
public void init(int year, int monthOfYear, int dayOfMonth,
            OnDateChangedListener onDateChangedListener) {
        setDate(year, monthOfYear, dayOfMonth);
        updateSpinners();
        updateCalendarView();
        mOnDateChangedListener = onDateChangedListener;
    }

    /**
     * Parses the given <code>date</code> and in case of success sets the result
     * to the <code>outDate</code>.
     *
     * @return True if the date was parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.377 -0500", hash_original_method = "4EF37BB5E8B6D289AE6D0021CE0D4FEB", hash_generated_method = "A8F56004CD8FCB6686C74FEBB9164E0E")
    
private boolean parseDate(String date, Calendar outDate) {
        try {
            outDate.setTime(mDateFormat.parse(date));
            return true;
        } catch (ParseException e) {
            Log.w(LOG_TAG, "Date: " + date + " not in format: " + DATE_FORMAT);
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.380 -0500", hash_original_method = "7DA7F7B10A47108B3DBE60145E22A8FC", hash_generated_method = "A89355DF0F2E75407062019D9D3D4F83")
    
private boolean isNewDate(int year, int month, int dayOfMonth) {
        return (mCurrentDate.get(Calendar.YEAR) != year
                || mCurrentDate.get(Calendar.MONTH) != dayOfMonth
                || mCurrentDate.get(Calendar.DAY_OF_MONTH) != month);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.382 -0500", hash_original_method = "421AA01E04B51628D97359BDD118BF23", hash_generated_method = "BD411F1DEDF77E82FC4ED40D48C62D27")
    
private void setDate(int year, int month, int dayOfMonth) {
        mCurrentDate.set(year, month, dayOfMonth);
        if (mCurrentDate.before(mMinDate)) {
            mCurrentDate.setTimeInMillis(mMinDate.getTimeInMillis());
        } else if (mCurrentDate.after(mMaxDate)) {
            mCurrentDate.setTimeInMillis(mMaxDate.getTimeInMillis());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.385 -0500", hash_original_method = "CC0C6797D7B0307D38215BFED9C815FE", hash_generated_method = "8DCB514D78F201355D993F551474228A")
    
private void updateSpinners() {
        // set the spinner ranges respecting the min and max dates
        if (mCurrentDate.equals(mMinDate)) {
            mDaySpinner.setMinValue(mCurrentDate.get(Calendar.DAY_OF_MONTH));
            mDaySpinner.setMaxValue(mCurrentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
            mDaySpinner.setWrapSelectorWheel(false);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(mCurrentDate.get(Calendar.MONTH));
            mMonthSpinner.setMaxValue(mCurrentDate.getActualMaximum(Calendar.MONTH));
            mMonthSpinner.setWrapSelectorWheel(false);
        } else if (mCurrentDate.equals(mMaxDate)) {
            mDaySpinner.setMinValue(mCurrentDate.getActualMinimum(Calendar.DAY_OF_MONTH));
            mDaySpinner.setMaxValue(mCurrentDate.get(Calendar.DAY_OF_MONTH));
            mDaySpinner.setWrapSelectorWheel(false);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(mCurrentDate.getActualMinimum(Calendar.MONTH));
            mMonthSpinner.setMaxValue(mCurrentDate.get(Calendar.MONTH));
            mMonthSpinner.setWrapSelectorWheel(false);
        } else {
            mDaySpinner.setMinValue(1);
            mDaySpinner.setMaxValue(mCurrentDate.getActualMaximum(Calendar.DAY_OF_MONTH));
            mDaySpinner.setWrapSelectorWheel(true);
            mMonthSpinner.setDisplayedValues(null);
            mMonthSpinner.setMinValue(0);
            mMonthSpinner.setMaxValue(11);
            mMonthSpinner.setWrapSelectorWheel(true);
        }

        // make sure the month names are a zero based array
        // with the months in the month spinner
        String[] displayedValues = Arrays.copyOfRange(mShortMonths,
                mMonthSpinner.getMinValue(), mMonthSpinner.getMaxValue() + 1);
        mMonthSpinner.setDisplayedValues(displayedValues);

        // year spinner range does not change based on the current date
        mYearSpinner.setMinValue(mMinDate.get(Calendar.YEAR));
        mYearSpinner.setMaxValue(mMaxDate.get(Calendar.YEAR));
        mYearSpinner.setWrapSelectorWheel(false);

        // set the spinner values
        mYearSpinner.setValue(mCurrentDate.get(Calendar.YEAR));
        mMonthSpinner.setValue(mCurrentDate.get(Calendar.MONTH));
        mDaySpinner.setValue(mCurrentDate.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Updates the calendar view with the current date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.388 -0500", hash_original_method = "FCBFFA03953049B21025A6ECF65DCE7B", hash_generated_method = "13AECF5EEEDB27529423D561C4796E14")
    
private void updateCalendarView() {
         mCalendarView.setDate(mCurrentDate.getTimeInMillis(), false, false);
    }

    
    private static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.428 -0500", hash_original_field = "D724CFA73A53A978E951AE6569BF2FF0", hash_generated_field = "E9DCCAD55CAF4E4BE430D6B8D40B045B")


        @SuppressWarnings("all")
        // suppress unused and hiding
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator<SavedState>() {

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.407 -0500", hash_original_field = "5823940FC0F93D8457936B751136F711", hash_generated_field = "0FB397B5159C15D66CFFB31661F31030")


        private  int mYear;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.409 -0500", hash_original_field = "C8A7514A4847C04CDF3D704147F35825", hash_generated_field = "B60DEE2EFD4F8FC07E416B8343AFCB00")


        private  int mMonth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.412 -0500", hash_original_field = "D90999CE70AC00E5087855F56B6B00E2", hash_generated_field = "084BEC9B9077623100292A9AB444BB6A")


        private  int mDay;

        /**
         * Constructor called from {@link DatePicker#onSaveInstanceState()}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.414 -0500", hash_original_method = "A02F651556C80A285B651552B4D99E55", hash_generated_method = "BF3DABFD07A346AFF8F19570F7A85F71")
        
private SavedState(Parcelable superState, int year, int month, int day) {
            super(superState);
            mYear = year;
            mMonth = month;
            mDay = day;
        }

        /**
         * Constructor called from {@link #CREATOR}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.417 -0500", hash_original_method = "CA21CAD6F1AA58ABF5FA7E877A966564", hash_generated_method = "70E3C9EB0A9626F4201021989D517362")
        
private SavedState(Parcel in) {
            super(in);
            mYear = in.readInt();
            mMonth = in.readInt();
            mDay = in.readInt();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.420 -0500", hash_original_method = "AFDD7CDA63529FFA8C3C3C99BF58C7E4", hash_generated_method = "4BF429ADDEA05A36328475A0268C9ED7")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(mYear);
            dest.writeInt(mMonth);
            dest.writeInt(mDay);
        }
    }


    
    public interface OnDateChangedListener {

        
        void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }

    /**
     * @return The selected year.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.390 -0500", hash_original_method = "3B3D6844E7A836293DFA1A3CC86782AF", hash_generated_method = "DD341252CD551E4373C2459CBB155055")
    
public int getYear() {
        return mCurrentDate.get(Calendar.YEAR);
    }

    /**
     * @return The selected month.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.392 -0500", hash_original_method = "38D3E39BF141F42FF09C6079CAB15EDC", hash_generated_method = "BCC5269CEB2B4BEF16D7C70CB3E9CE5C")
    
public int getMonth() {
        return mCurrentDate.get(Calendar.MONTH);
    }

    /**
     * @return The selected day of month.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.394 -0500", hash_original_method = "8FBF5DD56EFFBE6D332AE82BD8F4BBB9", hash_generated_method = "36944E655057A73626616DEC6406B85E")
    
public int getDayOfMonth() {
        return mCurrentDate.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Notifies the listener, if such, for a change in the selected date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.397 -0500", hash_original_method = "B58D4A1A16597327E1564790BB46799A", hash_generated_method = "56D8B8D2A2EFB759664769080F262F54")
    
private void notifyDateChanged() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        if (mOnDateChangedListener != null) {
            mOnDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    /**
     * Sets the IME options for a spinner based on its ordering.
     *
     * @param spinner The spinner.
     * @param spinnerCount The total spinner count.
     * @param spinnerIndex The index of the given spinner.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.399 -0500", hash_original_method = "70CD174A23393C16E923952AAD4C91D4", hash_generated_method = "8C3AE77DCBCFB84D7C67B30C275A8F7A")
    
private void setImeOptions(NumberPicker spinner, int spinnerCount, int spinnerIndex) {
        final int imeOptions;
        if (spinnerIndex < spinnerCount - 1) {
            imeOptions = EditorInfo.IME_ACTION_NEXT;
        } else {
            imeOptions = EditorInfo.IME_ACTION_DONE;
        }
        TextView input = (TextView) spinner.findViewById(R.id.numberpicker_input);
        input.setImeOptions(imeOptions);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.402 -0500", hash_original_method = "DB545D481E75722C0C153D7F54EF544D", hash_generated_method = "0D34B5E8096703DA29B61327E36E2233")
    
private void setContentDescriptions() {
        // Day
        String text = mContext.getString(R.string.date_picker_increment_day_button);
        mDaySpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_decrement_day_button);
        mDaySpinner.findViewById(R.id.decrement).setContentDescription(text);
        // Month
        text = mContext.getString(R.string.date_picker_increment_month_button);
        mMonthSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_decrement_month_button);
        mMonthSpinner.findViewById(R.id.decrement).setContentDescription(text);
        // Year
        text = mContext.getString(R.string.date_picker_increment_year_button);
        mYearSpinner.findViewById(R.id.increment).setContentDescription(text);
        text = mContext.getString(R.string.date_picker_decrement_year_button);
        mYearSpinner.findViewById(R.id.decrement).setContentDescription(text);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:45.404 -0500", hash_original_method = "CDABFADCA81181A0329F14F43A5F5848", hash_generated_method = "0A889B8415B4291F1B54165F0E9A6E1A")
    
private void updateInputState() {
        // Make sure that if the user changes the value and the IME is active
        // for one of the inputs if this widget, the IME is closed. If the user
        // changed the value via the IME and there is a next input the IME will
        // be shown, otherwise the user chose another means of changing the
        // value and having the IME up makes no sense.
        InputMethodManager inputMethodManager = InputMethodManager.peekInstance();
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(mYearSpinnerInput)) {
                mYearSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(mMonthSpinnerInput)) {
                mMonthSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(mDaySpinnerInput)) {
                mDaySpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }
}

