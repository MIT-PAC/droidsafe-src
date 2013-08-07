package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import libcore.icu.LocaleData;
import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;

import com.android.internal.R;






public class CalendarView extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "ED78BABF354FEF8D61EC60FB59A2000B", hash_generated_field = "8B23991BED629DDCFDA8E1DD88120AF5")

    private int mWeekSeperatorLineWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "1D34B47E8775BB2ECA8D8931C9929E4C", hash_generated_field = "3897E934AACB2D4B5C6B0C16CCB429A0")

    private int mDateTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "FB12A71334A6D7EE07106F45B00108F2", hash_generated_field = "A59A89A5D83C758D66546FEAE58F54D4")

    private Drawable mSelectedDateVerticalBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "C73B64367500D418F6D9EE65E112239B", hash_generated_field = "2C1B7E5AE5693E0A43249D97A45D63E8")

    private int mSelectedDateVerticalBarWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "8392E587DA00F5D5D7236C5119EC162F", hash_generated_field = "74B6E0C11198E97BD97CA4756AB27759")

    private int mSelectedWeekBackgroundColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "DF5E3F482A39E59C0A6FD713E1F7B79D", hash_generated_field = "A9584354BACE2D8F069618758B081B06")

    private int mFocusedMonthDateColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "27BBE21312EE1580A61F6D3E69496189", hash_generated_field = "7D2BE4C5D269E856747B17281912BE9C")

    private int mUnfocusedMonthDateColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "BE2F3C75D7D9AC89B14EF2F89598BB24", hash_generated_field = "8DDBF4CBD718C3948A0F42D2C1DB5D99")

    private int mWeekSeparatorLineColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "746B0FA1EB20C3937304705FE5C23493", hash_generated_field = "6A25546F44B6068A62792DA64248742A")

    private int mWeekNumberColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "8AD37204774915335DFF4E89A8110A64", hash_generated_field = "5665B7B8CC3DF642A1DAF00F3DE77EFA")

    private int mListScrollTopOffset = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.881 -0400", hash_original_field = "58F9877B31CDB53B0DEBB1000C39DD90", hash_generated_field = "D65BAA41D805492896870D587D162209")

    private int mWeekMinVisibleHeight = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "F651E579DA04CEFE11049FBAA43D493E", hash_generated_field = "5FC459B021EAF2699021DD8B9B1D6C2B")

    private int mBottomBuffer = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "D0CCED79166044E967E93767AAFDB4D2", hash_generated_field = "6CB09EC87311D40CB9B77369F5C620A1")

    private int mShownWeekCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "53E3E568843E4B190CE603DFFAC9D53E", hash_generated_field = "0A0881CE0345FE41D9B257D56D8D82CA")

    private boolean mShowWeekNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "005222EB6C4F0D144BE8F9C50ECD901D", hash_generated_field = "0792CCA61E447A5A7FB7126E5ABF29EC")

    private int mDaysPerWeek = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "0212E969626F0F0D1636343F1309E195", hash_generated_field = "78A6141C2BBA378820D9128DA7F22F8D")

    private float mFriction = .05f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "53A4ECF35C3EFF748C559F23D0631904", hash_generated_field = "E3AADF3834C4F3228039B1ED679BE2BE")

    private float mVelocityScale = 0.333f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "C5ED7BC1BF12E15BC029B4E0815E71E3")

    private WeeksAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "18448757CD3C825FD4B679B03ECA4680", hash_generated_field = "3BCC597FF6F62DFD9F809924D1A9B7CC")

    private TextView mMonthName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "12D57B519396B84F36E1C5CCCE7BEFD7", hash_generated_field = "E95A3921B8AB382181ED602DFBF5F267")

    private ViewGroup mDayNamesHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "6EF4E151400CEC15A8876C51787B7E10", hash_generated_field = "59E44C9DFCE7DBB845766E4E65180588")

    private String[] mDayLabels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "FD868BD5C2AC35186323583DC33DC09D", hash_generated_field = "30452844013892C49D8827DAE1E459DE")

    private int mFirstDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "2FC11E055DD064417E49C7C20C8CD874", hash_generated_field = "41289D9BED76260F340EB785FCC2056A")

    private int mCurrentMonthDisplayed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "FE81B8EDAAB742D1A97D166BED21F370", hash_generated_field = "A32E25FFB7BC22A215A1EAB2F45C9CD4")

    private long mPreviousScrollPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.882 -0400", hash_original_field = "11AB8A4F6569B0496A3B3BFA0E1C3F20", hash_generated_field = "5B9F7E9646034BCC8F83298FA039B637")

    private boolean mIsScrollingUp = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "A67CBF76ED54FBC5D55CD0E77A575947", hash_generated_field = "F3024B0C881FFDC3012F965272357A8A")

    private int mPreviousScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "81988B32590D1655D65A6770ED17DCEF", hash_generated_field = "328AD7D92706C021C1C22127BE75612C")

    private int mCurrentScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "811A2D8EF3A390BABF52F43FDF0E05DE", hash_generated_field = "05EE47F5BF2CAC4310C2BEEFD3D65AE0")

    private OnDateChangeListener mOnDateChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "02096E197DDBCC617385B7820770714F", hash_generated_field = "2729908D3AF534B2F645E718D75BC4E8")

    private ScrollStateRunnable mScrollStateChangedRunnable = new ScrollStateRunnable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "2CD58DB7365E32A740CCEDC539E005B5", hash_generated_field = "915400C77BD703DACB8E97CD72BFFD5E")

    private Calendar mTempDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "9B3201C38EFD7F45CCD545D51C752709", hash_generated_field = "D29AF2C549B988F84E81471C8F4DFA25")

    private Calendar mFirstDayOfMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "E65E4BB5B38AD013B1E2F00B4ED9DF18", hash_generated_field = "681C6D172B5A021A54543F6E6ED5BD03")

    private Calendar mMinDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "022B7F9BF85FB96A21762C2F3C1B66E0", hash_generated_field = "4C58BCC5BEA466149D70675257F2009F")

    private Calendar mMaxDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "D09E60E802BCF776E697BC72D82FD915", hash_generated_field = "B406C1F86E2B5C90127E71BBD6EC950B")

    private final java.text.DateFormat mDateFormat = new SimpleDateFormat(DATE_FORMAT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.883 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.884 -0400", hash_original_method = "52384FB40509E71BA2451D4915E5D413", hash_generated_method = "E8B74CDF68DAAB62882F628129916D13")
    public  CalendarView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.884 -0400", hash_original_method = "79D5762FBD0B1A46CF2745AED4E3FAD9", hash_generated_method = "60F65E3110532BDC2D82F7F957D67003")
    public  CalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.888 -0400", hash_original_method = "B881CA40E8482968634BC9086836F338", hash_generated_method = "5D7D9F5CD4D509999CA404A51549BAAD")
    public  CalendarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, 0);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setCurrentLocale(Locale.getDefault());
        TypedArray attributesArray = context.obtainStyledAttributes(attrs, R.styleable.CalendarView,
                R.attr.calendarViewStyle, 0);
        mShowWeekNumber = attributesArray.getBoolean(R.styleable.CalendarView_showWeekNumber,
                DEFAULT_SHOW_WEEK_NUMBER);
        mFirstDayOfWeek = attributesArray.getInt(R.styleable.CalendarView_firstDayOfWeek,
                LocaleData.get(Locale.getDefault()).firstDayOfWeek);
        String minDate = attributesArray.getString(R.styleable.CalendarView_minDate);
        if(TextUtils.isEmpty(minDate) || !parseDate(minDate, mMinDate))        
        {
            parseDate(DEFAULT_MIN_DATE, mMinDate);
        } //End block
        String maxDate = attributesArray.getString(R.styleable.CalendarView_maxDate);
        if(TextUtils.isEmpty(maxDate) || !parseDate(maxDate, mMaxDate))        
        {
            parseDate(DEFAULT_MAX_DATE, mMaxDate);
        } //End block
        if(mMaxDate.before(mMinDate))        
        {
            IllegalArgumentException var14CDB5E7C3258B66C8840AC918CDCB12_1836583404 = new IllegalArgumentException("Max date cannot be before min date.");
            var14CDB5E7C3258B66C8840AC918CDCB12_1836583404.addTaint(taint);
            throw var14CDB5E7C3258B66C8840AC918CDCB12_1836583404;
        } //End block
        mShownWeekCount = attributesArray.getInt(R.styleable.CalendarView_shownWeekCount,
                DEFAULT_SHOWN_WEEK_COUNT);
        mSelectedWeekBackgroundColor = attributesArray.getColor(
                R.styleable.CalendarView_selectedWeekBackgroundColor, 0);
        mFocusedMonthDateColor = attributesArray.getColor(
                R.styleable.CalendarView_focusedMonthDateColor, 0);
        mUnfocusedMonthDateColor = attributesArray.getColor(
                R.styleable.CalendarView_unfocusedMonthDateColor, 0);
        mWeekSeparatorLineColor = attributesArray.getColor(
                R.styleable.CalendarView_weekSeparatorLineColor, 0);
        mWeekNumberColor = attributesArray.getColor(R.styleable.CalendarView_weekNumberColor, 0);
        mSelectedDateVerticalBar = attributesArray.getDrawable(
                R.styleable.CalendarView_selectedDateVerticalBar);
        int dateTextAppearanceResId = attributesArray.getResourceId(
                R.styleable.CalendarView_dateTextAppearance, R.style.TextAppearance_Small);
        TypedArray dateTextAppearance = context.obtainStyledAttributes(dateTextAppearanceResId,
                com.android.internal.R.styleable.TextAppearance);
        mDateTextSize = dateTextAppearance.getDimensionPixelSize(
                R.styleable.TextAppearance_textSize, DEFAULT_DATE_TEXT_SIZE);
        dateTextAppearance.recycle();
        int weekDayTextAppearanceResId = attributesArray.getResourceId(
                R.styleable.CalendarView_weekDayTextAppearance,
                DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
        attributesArray.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mWeekMinVisibleHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                UNSCALED_WEEK_MIN_VISIBLE_HEIGHT, displayMetrics);
        mListScrollTopOffset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                UNSCALED_LIST_SCROLL_TOP_OFFSET, displayMetrics);
        mBottomBuffer = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                UNSCALED_BOTTOM_BUFFER, displayMetrics);
        mSelectedDateVerticalBarWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                UNSCALED_SELECTED_DATE_VERTICAL_BAR_WIDTH, displayMetrics);
        mWeekSeperatorLineWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                UNSCALED_WEEK_SEPARATOR_LINE_WIDTH, displayMetrics);
        LayoutInflater layoutInflater = (LayoutInflater) mContext
                .getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        View content = layoutInflater.inflate(R.layout.calendar_view, null, false);
        addView(content);
        mListView = (ListView) findViewById(R.id.list);
        mDayNamesHeader = (ViewGroup) content.findViewById(com.android.internal.R.id.day_names);
        mMonthName = (TextView) content.findViewById(com.android.internal.R.id.month_name);
        setUpHeader(weekDayTextAppearanceResId);
        setUpListView();
        setUpAdapter();
        mTempDate.setTimeInMillis(System.currentTimeMillis());
        if(mTempDate.before(mMinDate))        
        {
            goTo(mMinDate, false, true, true);
        } //End block
        else
        if(mMaxDate.before(mTempDate))        
        {
            goTo(mMaxDate, false, true, true);
        } //End block
        else
        {
            goTo(mTempDate, false, true, true);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.888 -0400", hash_original_method = "1D9E2CC40134FA188645AC8C7A8FADC7", hash_generated_method = "08234A420BC0502C4F41D872F81FCF95")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        mListView.setEnabled(enabled);
        // ---------- Original Method ----------
        //mListView.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.888 -0400", hash_original_method = "93B4809DF8FBD1AECB02AFF6547691F9", hash_generated_method = "0857BDD37383F2364F645D1DDA6EC5ED")
    @Override
    public boolean isEnabled() {
        boolean var1581D2B2F998C851BEDD4E1FCDAC1978_171815373 = (mListView.isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107003355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107003355;
        // ---------- Original Method ----------
        //return mListView.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.889 -0400", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "127AACDA90D8DF77911A68D85F6663CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.889 -0400", hash_original_method = "967B291ED0BCED68F7E3E5A0CEF03695", hash_generated_method = "11C0CF79FAF08162DA99CD04722A0EF0")
    public long getMinDate() {
        long varDB922D5EACDDD5A41DF0C4136C6A31B4_1947796276 = (mMinDate.getTimeInMillis());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1444151307 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1444151307;
        // ---------- Original Method ----------
        //return mMinDate.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.889 -0400", hash_original_method = "FF5386D03D60B1076A84367A6FF3DA28", hash_generated_method = "F2DA49769345612BEA1CABCFA1D8A601")
    public void setMinDate(long minDate) {
        addTaint(minDate);
        mTempDate.setTimeInMillis(minDate);
        if(isSameDate(mTempDate, mMinDate))        
        {
            return;
        } //End block
        mMinDate.setTimeInMillis(minDate);
        Calendar date = mAdapter.mSelectedDate;
        if(date.before(mMinDate))        
        {
            mAdapter.setSelectedDay(mMinDate);
        } //End block
        mAdapter.init();
        if(date.before(mMinDate))        
        {
            setDate(mTempDate.getTimeInMillis());
        } //End block
        else
        {
            goTo(date, false, true, false);
        } //End block
        // ---------- Original Method ----------
        //mTempDate.setTimeInMillis(minDate);
        //if (isSameDate(mTempDate, mMinDate)) {
            //return;
        //}
        //mMinDate.setTimeInMillis(minDate);
        //Calendar date = mAdapter.mSelectedDate;
        //if (date.before(mMinDate)) {
            //mAdapter.setSelectedDay(mMinDate);
        //}
        //mAdapter.init();
        //if (date.before(mMinDate)) {
            //setDate(mTempDate.getTimeInMillis());
        //} else {
            //goTo(date, false, true, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.890 -0400", hash_original_method = "4B53E128D2B815FDD1432B3F6B079B5B", hash_generated_method = "B3C1F04C5FC69DA3D618B345659D0DE8")
    public long getMaxDate() {
        long var2C1AD49ED8979D40B3D966725C64AA26_289091190 = (mMaxDate.getTimeInMillis());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_359430345 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_359430345;
        // ---------- Original Method ----------
        //return mMaxDate.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.890 -0400", hash_original_method = "A06814E3E9CB43249648A0F0C1DE0D5D", hash_generated_method = "6C6648E2E315DF09255037352158710E")
    public void setMaxDate(long maxDate) {
        addTaint(maxDate);
        mTempDate.setTimeInMillis(maxDate);
        if(isSameDate(mTempDate, mMaxDate))        
        {
            return;
        } //End block
        mMaxDate.setTimeInMillis(maxDate);
        mAdapter.init();
        Calendar date = mAdapter.mSelectedDate;
        if(date.after(mMaxDate))        
        {
            setDate(mMaxDate.getTimeInMillis());
        } //End block
        else
        {
            goTo(date, false, true, false);
        } //End block
        // ---------- Original Method ----------
        //mTempDate.setTimeInMillis(maxDate);
        //if (isSameDate(mTempDate, mMaxDate)) {
            //return;
        //}
        //mMaxDate.setTimeInMillis(maxDate);
        //mAdapter.init();
        //Calendar date = mAdapter.mSelectedDate;
        //if (date.after(mMaxDate)) {
            //setDate(mMaxDate.getTimeInMillis());
        //} else {
            //goTo(date, false, true, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.891 -0400", hash_original_method = "F2BDD8F6BF1030E3F09A2B5F73B0EF93", hash_generated_method = "BA5E2125F2D3DF9FC3B90ABE132CFB96")
    public void setShowWeekNumber(boolean showWeekNumber) {
        if(mShowWeekNumber == showWeekNumber)        
        {
            return;
        } //End block
        mShowWeekNumber = showWeekNumber;
        mAdapter.notifyDataSetChanged();
        setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
        // ---------- Original Method ----------
        //if (mShowWeekNumber == showWeekNumber) {
            //return;
        //}
        //mShowWeekNumber = showWeekNumber;
        //mAdapter.notifyDataSetChanged();
        //setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.891 -0400", hash_original_method = "466B93651CABC20F69979D67C7EC6971", hash_generated_method = "2C7F384083ADB0E75A267ABD814E7619")
    public boolean getShowWeekNumber() {
        boolean var53E3E568843E4B190CE603DFFAC9D53E_293311570 = (mShowWeekNumber);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1962596675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1962596675;
        // ---------- Original Method ----------
        //return mShowWeekNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.891 -0400", hash_original_method = "13AE9B7D254FD4442860EE49493A72AE", hash_generated_method = "4E20E406A01A677B08FA334E3602F494")
    public int getFirstDayOfWeek() {
        int varFD868BD5C2AC35186323583DC33DC09D_2007142335 = (mFirstDayOfWeek);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970848958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970848958;
        // ---------- Original Method ----------
        //return mFirstDayOfWeek;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.892 -0400", hash_original_method = "631B1F3A15EE6F7D95BE757EDF5B5B91", hash_generated_method = "FE92CE4CB96EE0659D1B3060D22C3003")
    public void setFirstDayOfWeek(int firstDayOfWeek) {
        if(mFirstDayOfWeek == firstDayOfWeek)        
        {
            return;
        } //End block
        mFirstDayOfWeek = firstDayOfWeek;
        mAdapter.init();
        mAdapter.notifyDataSetChanged();
        setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
        // ---------- Original Method ----------
        //if (mFirstDayOfWeek == firstDayOfWeek) {
            //return;
        //}
        //mFirstDayOfWeek = firstDayOfWeek;
        //mAdapter.init();
        //mAdapter.notifyDataSetChanged();
        //setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.892 -0400", hash_original_method = "2EC5480533B2BF54D56B2049BA7CA5D7", hash_generated_method = "40E23822C44A26C2CDF30A58488DCCDD")
    public void setOnDateChangeListener(OnDateChangeListener listener) {
        mOnDateChangeListener = listener;
        // ---------- Original Method ----------
        //mOnDateChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.892 -0400", hash_original_method = "1C8908BABBBBE904441B712A0F71BAD8", hash_generated_method = "60DAF0EE977FA45F117678C5C924A4C2")
    public long getDate() {
        long var9B24A80C783EA270EB834849736AADFD_1516913155 = (mAdapter.mSelectedDate.getTimeInMillis());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1501396220 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1501396220;
        // ---------- Original Method ----------
        //return mAdapter.mSelectedDate.getTimeInMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.892 -0400", hash_original_method = "D6F29E7F63D0C42CAD60620E4D2FC504", hash_generated_method = "7B2ACCDE02FB3E843DA07B47D2CC9169")
    public void setDate(long date) {
        addTaint(date);
        setDate(date, false, false);
        // ---------- Original Method ----------
        //setDate(date, false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.893 -0400", hash_original_method = "7D056A885692AA64348F6515B99D8688", hash_generated_method = "7F85587609D8DB80AED45F9327B1BC2F")
    public void setDate(long date, boolean animate, boolean center) {
        addTaint(center);
        addTaint(animate);
        addTaint(date);
        mTempDate.setTimeInMillis(date);
        if(isSameDate(mTempDate, mAdapter.mSelectedDate))        
        {
            return;
        } //End block
        goTo(mTempDate, animate, true, center);
        // ---------- Original Method ----------
        //mTempDate.setTimeInMillis(date);
        //if (isSameDate(mTempDate, mAdapter.mSelectedDate)) {
            //return;
        //}
        //goTo(mTempDate, animate, true, center);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.894 -0400", hash_original_method = "4AE549580BCF2D6667C808ED8CCBDCDC", hash_generated_method = "FF6C538F4D348A34958D776E53AA09E7")
    private void setCurrentLocale(Locale locale) {
        if(locale.equals(mCurrentLocale))        
        {
            return;
        } //End block
        mCurrentLocale = locale;
        mTempDate = getCalendarForLocale(mTempDate, locale);
        mFirstDayOfMonth = getCalendarForLocale(mFirstDayOfMonth, locale);
        mMinDate = getCalendarForLocale(mMinDate, locale);
        mMaxDate = getCalendarForLocale(mMaxDate, locale);
        // ---------- Original Method ----------
        //if (locale.equals(mCurrentLocale)) {
            //return;
        //}
        //mCurrentLocale = locale;
        //mTempDate = getCalendarForLocale(mTempDate, locale);
        //mFirstDayOfMonth = getCalendarForLocale(mFirstDayOfMonth, locale);
        //mMinDate = getCalendarForLocale(mMinDate, locale);
        //mMaxDate = getCalendarForLocale(mMaxDate, locale);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.894 -0400", hash_original_method = "FA738DF80665124C3A5E01ADC04827D9", hash_generated_method = "61EC0164C81C8794AD5D2908AB5B807F")
    private Calendar getCalendarForLocale(Calendar oldCalendar, Locale locale) {
        addTaint(locale.getTaint());
        addTaint(oldCalendar.getTaint());
        if(oldCalendar == null)        
        {
Calendar varAF9F889F6AAD514FC782043E6832D0EC_1035701799 =             Calendar.getInstance(locale);
            varAF9F889F6AAD514FC782043E6832D0EC_1035701799.addTaint(taint);
            return varAF9F889F6AAD514FC782043E6832D0EC_1035701799;
        } //End block
        else
        {
            final long currentTimeMillis = oldCalendar.getTimeInMillis();
            Calendar newCalendar = Calendar.getInstance(locale);
            newCalendar.setTimeInMillis(currentTimeMillis);
Calendar var7F1C6FE82B6466987740139940995C7D_1897776491 =             newCalendar;
            var7F1C6FE82B6466987740139940995C7D_1897776491.addTaint(taint);
            return var7F1C6FE82B6466987740139940995C7D_1897776491;
        } //End block
        // ---------- Original Method ----------
        //if (oldCalendar == null) {
            //return Calendar.getInstance(locale);
        //} else {
            //final long currentTimeMillis = oldCalendar.getTimeInMillis();
            //Calendar newCalendar = Calendar.getInstance(locale);
            //newCalendar.setTimeInMillis(currentTimeMillis);
            //return newCalendar;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.895 -0400", hash_original_method = "70DC9A9889795E848236506BBC0A481B", hash_generated_method = "BB45D795A21538ABCCACE356B9748C7F")
    private boolean isSameDate(Calendar firstDate, Calendar secondDate) {
        addTaint(secondDate.getTaint());
        addTaint(firstDate.getTaint());
        boolean var1F6E933E45CCEF6B30F84AB157330405_2011529886 = ((firstDate.get(Calendar.DAY_OF_YEAR) == secondDate.get(Calendar.DAY_OF_YEAR)
                && firstDate.get(Calendar.YEAR) == secondDate.get(Calendar.YEAR)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055609218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055609218;
        // ---------- Original Method ----------
        //return (firstDate.get(Calendar.DAY_OF_YEAR) == secondDate.get(Calendar.DAY_OF_YEAR)
                //&& firstDate.get(Calendar.YEAR) == secondDate.get(Calendar.YEAR));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.896 -0400", hash_original_method = "513863F202D0E7C406F959CC7EBC2D43", hash_generated_method = "734305B550B77B191D23D565503D8840")
    private void setUpAdapter() {
        if(mAdapter == null)        
        {
            mAdapter = new WeeksAdapter(getContext());
            mAdapter.registerDataSetObserver(new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.896 -0400", hash_original_method = "CEA948C87231173C338757A31D25F841", hash_generated_method = "F10558104D9F2578C3A8F9986C99FF8F")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if(mOnDateChangeListener != null)            
            {
                Calendar selectedDay = mAdapter.getSelectedDay();
                mOnDateChangeListener.onSelectedDayChange(CalendarView.this,
                                selectedDay.get(Calendar.YEAR),
                                selectedDay.get(Calendar.MONTH),
                                selectedDay.get(Calendar.DAY_OF_MONTH));
            } //End block
            // ---------- Original Method ----------
            //if (mOnDateChangeListener != null) {
                        //Calendar selectedDay = mAdapter.getSelectedDay();
                        //mOnDateChangeListener.onSelectedDayChange(CalendarView.this,
                                //selectedDay.get(Calendar.YEAR),
                                //selectedDay.get(Calendar.MONTH),
                                //selectedDay.get(Calendar.DAY_OF_MONTH));
                    //}
        }
});
            mListView.setAdapter(mAdapter);
        } //End block
        mAdapter.notifyDataSetChanged();
        // ---------- Original Method ----------
        //if (mAdapter == null) {
            //mAdapter = new WeeksAdapter(getContext());
            //mAdapter.registerDataSetObserver(new DataSetObserver() {
                //@Override
                //public void onChanged() {
                    //if (mOnDateChangeListener != null) {
                        //Calendar selectedDay = mAdapter.getSelectedDay();
                        //mOnDateChangeListener.onSelectedDayChange(CalendarView.this,
                                //selectedDay.get(Calendar.YEAR),
                                //selectedDay.get(Calendar.MONTH),
                                //selectedDay.get(Calendar.DAY_OF_MONTH));
                    //}
                //}
            //});
            //mListView.setAdapter(mAdapter);
        //}
        //mAdapter.notifyDataSetChanged();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.899 -0400", hash_original_method = "2BEB208CF4EFB41463E1218ACA7650C9", hash_generated_method = "5DDE8C5F9883688C18A3EAFC6440BD72")
    private void setUpHeader(int weekDayTextAppearanceResId) {
        addTaint(weekDayTextAppearanceResId);
        mDayLabels = new String[mDaysPerWeek];
for(int i = mFirstDayOfWeek, count = mFirstDayOfWeek + mDaysPerWeek;i < count;i++)
        {
            int calendarDay = (i > Calendar.SATURDAY) ? i - Calendar.SATURDAY : i;
            mDayLabels[i - mFirstDayOfWeek] = DateUtils.getDayOfWeekString(calendarDay,
                    DateUtils.LENGTH_SHORTEST);
        } //End block
        TextView label = (TextView) mDayNamesHeader.getChildAt(0);
        if(mShowWeekNumber)        
        {
            label.setVisibility(View.VISIBLE);
        } //End block
        else
        {
            label.setVisibility(View.GONE);
        } //End block
for(int i = 1, count = mDayNamesHeader.getChildCount();i < count;i++)
        {
            label = (TextView) mDayNamesHeader.getChildAt(i);
            if(weekDayTextAppearanceResId > -1)            
            {
                label.setTextAppearance(mContext, weekDayTextAppearanceResId);
            } //End block
            if(i < mDaysPerWeek + 1)            
            {
                label.setText(mDayLabels[i - 1]);
                label.setVisibility(View.VISIBLE);
            } //End block
            else
            {
                label.setVisibility(View.GONE);
            } //End block
        } //End block
        mDayNamesHeader.invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.900 -0400", hash_original_method = "CFADBCF95F8E177F25E22F1FC2115F77", hash_generated_method = "A7212EABDEC78C4670A7D51B166BE4DD")
    private void setUpListView() {
        mListView.setDivider(null);
        mListView.setItemsCanFocus(true);
        mListView.setVerticalScrollBarEnabled(false);
        mListView.setOnScrollListener(new OnScrollListener() {        
        @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.900 -0400", hash_original_method = "00F32D753053A861AE7DBFD213079352", hash_generated_method = "C3F9DF9B73485268F5BFEBE41DDBD9B4")
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(scrollState);
            addTaint(view.getTaint());
            CalendarView.this.onScrollStateChanged(view, scrollState);
            // ---------- Original Method ----------
            //CalendarView.this.onScrollStateChanged(view, scrollState);
        }
        @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.900 -0400", hash_original_method = "E68786505B378D9C994B2BFCAEDF7B06", hash_generated_method = "EA02612E2594E7F67FC321ABFC227955")
        public void onScroll(
                    AbsListView view, int firstVisibleItem, int visibleItemCount,
                    int totalItemCount) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(totalItemCount);
            addTaint(visibleItemCount);
            addTaint(firstVisibleItem);
            addTaint(view.getTaint());
            CalendarView.this.onScroll(view, firstVisibleItem, visibleItemCount,
                        totalItemCount);
            // ---------- Original Method ----------
            //CalendarView.this.onScroll(view, firstVisibleItem, visibleItemCount,
                        //totalItemCount);
        }
});
        mListView.setFriction(mFriction);
        mListView.setVelocityScale(mVelocityScale);
        // ---------- Original Method ----------
        //mListView.setDivider(null);
        //mListView.setItemsCanFocus(true);
        //mListView.setVerticalScrollBarEnabled(false);
        //mListView.setOnScrollListener(new OnScrollListener() {
            //public void onScrollStateChanged(AbsListView view, int scrollState) {
                //CalendarView.this.onScrollStateChanged(view, scrollState);
            //}
            //public void onScroll(
                    //AbsListView view, int firstVisibleItem, int visibleItemCount,
                    //int totalItemCount) {
                //CalendarView.this.onScroll(view, firstVisibleItem, visibleItemCount,
                        //totalItemCount);
            //}
        //});
        //mListView.setFriction(mFriction);
        //mListView.setVelocityScale(mVelocityScale);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.902 -0400", hash_original_method = "9885B6A6E0E890A0EF52CBA474F609AF", hash_generated_method = "0E844A6F35E4422F5C6DD9C0F3DB681E")
    private void goTo(Calendar date, boolean animate, boolean setSelected, boolean forceScroll) {
        addTaint(forceScroll);
        addTaint(setSelected);
        addTaint(animate);
        addTaint(date.getTaint());
        if(date.before(mMinDate) || date.after(mMaxDate))        
        {
            IllegalArgumentException var6202B4671A514DFD5395D79F517A40A0_1749228016 = new IllegalArgumentException("Time not between " + mMinDate.getTime()
                    + " and " + mMaxDate.getTime());
            var6202B4671A514DFD5395D79F517A40A0_1749228016.addTaint(taint);
            throw var6202B4671A514DFD5395D79F517A40A0_1749228016;
        } //End block
        int firstFullyVisiblePosition = mListView.getFirstVisiblePosition();
        View firstChild = mListView.getChildAt(0);
        if(firstChild != null && firstChild.getTop() < 0)        
        {
            firstFullyVisiblePosition++;
        } //End block
        int lastFullyVisiblePosition = firstFullyVisiblePosition + mShownWeekCount - 1;
        if(firstChild != null && firstChild.getTop() > mBottomBuffer)        
        {
            lastFullyVisiblePosition--;
        } //End block
        if(setSelected)        
        {
            mAdapter.setSelectedDay(date);
        } //End block
        int position = getWeeksSinceMinDate(date);
        if(position < firstFullyVisiblePosition || position > lastFullyVisiblePosition
                || forceScroll)        
        {
            mFirstDayOfMonth.setTimeInMillis(date.getTimeInMillis());
            mFirstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
            setMonthDisplayed(mFirstDayOfMonth);
            if(mFirstDayOfMonth.before(mMinDate))            
            {
                position = 0;
            } //End block
            else
            {
                position = getWeeksSinceMinDate(mFirstDayOfMonth);
            } //End block
            mPreviousScrollState = OnScrollListener.SCROLL_STATE_FLING;
            if(animate)            
            {
                mListView.smoothScrollToPositionFromTop(position, mListScrollTopOffset,
                        GOTO_SCROLL_DURATION);
            } //End block
            else
            {
                mListView.setSelectionFromTop(position, mListScrollTopOffset);
                onScrollStateChanged(mListView, OnScrollListener.SCROLL_STATE_IDLE);
            } //End block
        } //End block
        else
        if(setSelected)        
        {
            setMonthDisplayed(date);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.904 -0400", hash_original_method = "4EF37BB5E8B6D289AE6D0021CE0D4FEB", hash_generated_method = "87C94761FD67F9EFE62354DFFB1181B8")
    private boolean parseDate(String date, Calendar outDate) {
        addTaint(outDate.getTaint());
        addTaint(date.getTaint());
        try 
        {
            outDate.setTime(mDateFormat.parse(date));
            boolean varB326B5062B2F0E69046810717534CB09_1352447736 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99533428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_99533428;
        } //End block
        catch (ParseException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_220784106 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1387949157 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1387949157;
        } //End block
        // ---------- Original Method ----------
        //try {
            //outDate.setTime(mDateFormat.parse(date));
            //return true;
        //} catch (ParseException e) {
            //Log.w(LOG_TAG, "Date: " + date + " not in format: " + DATE_FORMAT);
            //return false;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.905 -0400", hash_original_method = "F153BBCA7962990A30E79BE6D90D9C30", hash_generated_method = "68C75E90DECCCD3630FC8AB86410853C")
    private void onScrollStateChanged(AbsListView view, int scrollState) {
        addTaint(scrollState);
        addTaint(view.getTaint());
        mScrollStateChangedRunnable.doScrollStateChange(view, scrollState);
        // ---------- Original Method ----------
        //mScrollStateChangedRunnable.doScrollStateChange(view, scrollState);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.907 -0400", hash_original_method = "FE6404A8901B8111BDEFCBB086ABC460", hash_generated_method = "9531FF84C9494AAA25C42FC0BF66910B")
    private void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        addTaint(totalItemCount);
        addTaint(visibleItemCount);
        addTaint(firstVisibleItem);
        addTaint(view.getTaint());
        WeekView child = (WeekView) view.getChildAt(0);
        if(child == null)        
        {
            return;
        } //End block
        long currScroll = view.getFirstVisiblePosition() * child.getHeight() - child.getBottom();
        if(currScroll < mPreviousScrollPosition)        
        {
            mIsScrollingUp = true;
        } //End block
        else
        if(currScroll > mPreviousScrollPosition)        
        {
            mIsScrollingUp = false;
        } //End block
        else
        {
            return;
        } //End block
        int offset = child.getBottom() < mWeekMinVisibleHeight ? 1 : 0;
        if(mIsScrollingUp)        
        {
            child = (WeekView) view.getChildAt(SCROLL_HYST_WEEKS + offset);
        } //End block
        else
        if(offset != 0)        
        {
            child = (WeekView) view.getChildAt(offset);
        } //End block
        int month;
        if(mIsScrollingUp)        
        {
            month = child.getMonthOfFirstWeekDay();
        } //End block
        else
        {
            month = child.getMonthOfLastWeekDay();
        } //End block
        int monthDiff;
        if(mCurrentMonthDisplayed == 11 && month == 0)        
        {
            monthDiff = 1;
        } //End block
        else
        if(mCurrentMonthDisplayed == 0 && month == 11)        
        {
            monthDiff = -1;
        } //End block
        else
        {
            monthDiff = month - mCurrentMonthDisplayed;
        } //End block
        if((!mIsScrollingUp && monthDiff > 0) || (mIsScrollingUp && monthDiff < 0))        
        {
            Calendar firstDay = child.getFirstDay();
            if(mIsScrollingUp)            
            {
                firstDay.add(Calendar.DAY_OF_MONTH, -DAYS_PER_WEEK);
            } //End block
            else
            {
                firstDay.add(Calendar.DAY_OF_MONTH, DAYS_PER_WEEK);
            } //End block
            setMonthDisplayed(firstDay);
        } //End block
        mPreviousScrollPosition = currScroll;
        mPreviousScrollState = mCurrentScrollState;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.909 -0400", hash_original_method = "2D87D8A121385B44A48D783AA9D15CB4", hash_generated_method = "0635C722637CB28F0CD60C0234980BBE")
    private void setMonthDisplayed(Calendar calendar) {
        addTaint(calendar.getTaint());
        final int newMonthDisplayed = calendar.get(Calendar.MONTH);
        if(mCurrentMonthDisplayed != newMonthDisplayed)        
        {
            mCurrentMonthDisplayed = newMonthDisplayed;
            mAdapter.setFocusMonth(mCurrentMonthDisplayed);
            final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NO_MONTH_DAY
                    | DateUtils.FORMAT_SHOW_YEAR;
            final long millis = calendar.getTimeInMillis();
            String newMonthName = DateUtils.formatDateRange(mContext, millis, millis, flags);
            mMonthName.setText(newMonthName);
            mMonthName.invalidate();
        } //End block
        // ---------- Original Method ----------
        //final int newMonthDisplayed = calendar.get(Calendar.MONTH);
        //if (mCurrentMonthDisplayed != newMonthDisplayed) {
            //mCurrentMonthDisplayed = newMonthDisplayed;
            //mAdapter.setFocusMonth(mCurrentMonthDisplayed);
            //final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NO_MONTH_DAY
                    //| DateUtils.FORMAT_SHOW_YEAR;
            //final long millis = calendar.getTimeInMillis();
            //String newMonthName = DateUtils.formatDateRange(mContext, millis, millis, flags);
            //mMonthName.setText(newMonthName);
            //mMonthName.invalidate();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.909 -0400", hash_original_method = "025B6CEC43A90DA392B09F9FACE78FF5", hash_generated_method = "B9C56989667227EB22A023503E41B63E")
    private int getWeeksSinceMinDate(Calendar date) {
        addTaint(date.getTaint());
        if(date.before(mMinDate))        
        {
            IllegalArgumentException var73BEA5090EC8C42F107B2170DD092BDA_937112323 = new IllegalArgumentException("fromDate: " + mMinDate.getTime()
                    + " does not precede toDate: " + date.getTime());
            var73BEA5090EC8C42F107B2170DD092BDA_937112323.addTaint(taint);
            throw var73BEA5090EC8C42F107B2170DD092BDA_937112323;
        } //End block
        long endTimeMillis = date.getTimeInMillis()
                + date.getTimeZone().getOffset(date.getTimeInMillis());
        long startTimeMillis = mMinDate.getTimeInMillis()
                + mMinDate.getTimeZone().getOffset(mMinDate.getTimeInMillis());
        long dayOffsetMillis = (mMinDate.get(Calendar.DAY_OF_WEEK) - mFirstDayOfWeek)
                * MILLIS_IN_DAY;
        int varC20351856A9B59B737BEDCDB35040EF5_1622045348 = ((int) ((endTimeMillis - startTimeMillis + dayOffsetMillis) / MILLIS_IN_WEEK));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705481514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705481514;
        // ---------- Original Method ----------
        //if (date.before(mMinDate)) {
            //throw new IllegalArgumentException("fromDate: " + mMinDate.getTime()
                    //+ " does not precede toDate: " + date.getTime());
        //}
        //long endTimeMillis = date.getTimeInMillis()
                //+ date.getTimeZone().getOffset(date.getTimeInMillis());
        //long startTimeMillis = mMinDate.getTimeInMillis()
                //+ mMinDate.getTimeZone().getOffset(mMinDate.getTimeInMillis());
        //long dayOffsetMillis = (mMinDate.get(Calendar.DAY_OF_WEEK) - mFirstDayOfWeek)
                //* MILLIS_IN_DAY;
        //return (int) ((endTimeMillis - startTimeMillis + dayOffsetMillis) / MILLIS_IN_WEEK);
    }

    
    private class ScrollStateRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.910 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "1F3C2B019CE351B6A3F4C6C3616C5C0E")

        private AbsListView mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.910 -0400", hash_original_field = "175471B610D1F5C8823729FE892FAC81", hash_generated_field = "B54F7897F242D86283E88CF300719E2B")

        private int mNewState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.910 -0400", hash_original_method = "F2F7D55B897550D0A526C19F647B806C", hash_generated_method = "F2F7D55B897550D0A526C19F647B806C")
        public ScrollStateRunnable ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.910 -0400", hash_original_method = "69E5B9D1AE0F98719D28BA5FB866EF08", hash_generated_method = "AD254F241E34912551E41EEB0E981169")
        public void doScrollStateChange(AbsListView view, int scrollState) {
            mView = view;
            mNewState = scrollState;
            removeCallbacks(this);
            postDelayed(this, SCROLL_CHANGE_DELAY);
            // ---------- Original Method ----------
            //mView = view;
            //mNewState = scrollState;
            //removeCallbacks(this);
            //postDelayed(this, SCROLL_CHANGE_DELAY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.911 -0400", hash_original_method = "62729E70BB0456A375600477CC5D2643", hash_generated_method = "9FA816C53C279B41F0AE3E829629E7BA")
        public void run() {
            mCurrentScrollState = mNewState;
            if(mNewState == OnScrollListener.SCROLL_STATE_IDLE
                    && mPreviousScrollState != OnScrollListener.SCROLL_STATE_IDLE)            
            {
                View child = mView.getChildAt(0);
                if(child == null)                
                {
                    return;
                } //End block
                int dist = child.getBottom() - mListScrollTopOffset;
                if(dist > mListScrollTopOffset)                
                {
                    if(mIsScrollingUp)                    
                    {
                        mView.smoothScrollBy(dist - child.getHeight(), ADJUSTMENT_SCROLL_DURATION);
                    } //End block
                    else
                    {
                        mView.smoothScrollBy(dist, ADJUSTMENT_SCROLL_DURATION);
                    } //End block
                } //End block
            } //End block
            mPreviousScrollState = mNewState;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class WeeksAdapter extends BaseAdapter implements OnTouchListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.911 -0400", hash_original_field = "87C5B793293EF336BDD19BF5E63E4DA8", hash_generated_field = "5BF9B16DA16CA4B8867BE9E962493092")

        private int mSelectedWeek;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.911 -0400", hash_original_field = "EBDAC0BE41D965D60A46156878A6BB30", hash_generated_field = "DA7C2146C29AB67A18FA4519D8BF6725")

        private GestureDetector mGestureDetector;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.911 -0400", hash_original_field = "5E580E0FCD6C56A118A33AEB961A4EFC", hash_generated_field = "F72CF38F2566D6E733620DFADA8D38C7")

        private int mFocusedMonth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.911 -0400", hash_original_field = "680C00076DF77E826310D3524A5D9353", hash_generated_field = "95E30C29B97433E1CA9F533BA1A954C1")

        private final Calendar mSelectedDate = Calendar.getInstance();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.911 -0400", hash_original_field = "106D976A13769982F741242E3234CDEC", hash_generated_field = "740B29A5145E76BF427504A23D8A9471")

        private int mTotalWeekCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.912 -0400", hash_original_method = "A5340406393612546D90AF6654589F05", hash_generated_method = "6D9B8A07AB7C359DB0F8F25D244EF777")
        public  WeeksAdapter(Context context) {
            addTaint(context.getTaint());
            mContext = context;
            mGestureDetector = new GestureDetector(mContext, new CalendarGestureListener());
            init();
            // ---------- Original Method ----------
            //mContext = context;
            //mGestureDetector = new GestureDetector(mContext, new CalendarGestureListener());
            //init();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.912 -0400", hash_original_method = "155544AF4C95F51C95BCC140A715A96B", hash_generated_method = "41311F926BFCC998EB366019D8CBD762")
        private void init() {
            mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            mTotalWeekCount = getWeeksSinceMinDate(mMaxDate);
            if(mMinDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek
                || mMaxDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek)            
            {
                mTotalWeekCount++;
            } //End block
            // ---------- Original Method ----------
            //mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            //mTotalWeekCount = getWeeksSinceMinDate(mMaxDate);
            //if (mMinDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek
                //|| mMaxDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek) {
                //mTotalWeekCount++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.912 -0400", hash_original_method = "D3DE83E2185E4ADE498D767CEB2FBE21", hash_generated_method = "79D08EB8671BC8E20C77DA53C6FA71CA")
        public void setSelectedDay(Calendar selectedDay) {
            addTaint(selectedDay.getTaint());
            if(selectedDay.get(Calendar.DAY_OF_YEAR) == mSelectedDate.get(Calendar.DAY_OF_YEAR)
                    && selectedDay.get(Calendar.YEAR) == mSelectedDate.get(Calendar.YEAR))            
            {
                return;
            } //End block
            mSelectedDate.setTimeInMillis(selectedDay.getTimeInMillis());
            mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            mFocusedMonth = mSelectedDate.get(Calendar.MONTH);
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //if (selectedDay.get(Calendar.DAY_OF_YEAR) == mSelectedDate.get(Calendar.DAY_OF_YEAR)
                    //&& selectedDay.get(Calendar.YEAR) == mSelectedDate.get(Calendar.YEAR)) {
                //return;
            //}
            //mSelectedDate.setTimeInMillis(selectedDay.getTimeInMillis());
            //mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            //mFocusedMonth = mSelectedDate.get(Calendar.MONTH);
            //notifyDataSetChanged();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.913 -0400", hash_original_method = "B5E95894B654555C190BA20C07877305", hash_generated_method = "6AC375C7EEA1437A9D7122347E74D21C")
        public Calendar getSelectedDay() {
Calendar var0A52F701728BCB2179FFB504BA6EC2B2_209113946 =             mSelectedDate;
            var0A52F701728BCB2179FFB504BA6EC2B2_209113946.addTaint(taint);
            return var0A52F701728BCB2179FFB504BA6EC2B2_209113946;
            // ---------- Original Method ----------
            //return mSelectedDate;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.913 -0400", hash_original_method = "F04F5B9FBE7B2AAA41BE9F0558597E2D", hash_generated_method = "BCCCC23DFE8FD9C0589FC80D466541FA")
        @Override
        public int getCount() {
            int var106D976A13769982F741242E3234CDEC_535466372 = (mTotalWeekCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669353146 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669353146;
            // ---------- Original Method ----------
            //return mTotalWeekCount;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.913 -0400", hash_original_method = "AE0D3BF5CEF608E0D2B9C47624E8B8EC", hash_generated_method = "7FBB390E1AC31D51DA8027DB98C6C1E6")
        @Override
        public Object getItem(int position) {
            addTaint(position);
Object var540C13E9E156B687226421B24F2DF178_1398052437 =             null;
            var540C13E9E156B687226421B24F2DF178_1398052437.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1398052437;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.914 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "521795348DA56490920D1CBDC3C3E43D")
        @Override
        public long getItemId(int position) {
            addTaint(position);
            long var4757FE07FD492A8BE0EA6A760D683D6E_880018548 = (position);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1349272303 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1349272303;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.914 -0400", hash_original_method = "381E4A6A7165FC308D77C676467DC158", hash_generated_method = "FB0942068A13FF496402CFB4064EF2BE")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            WeekView weekView = null;
            if(convertView != null)            
            {
                weekView = (WeekView) convertView;
            } //End block
            else
            {
                weekView = new WeekView(mContext);
                android.widget.AbsListView.LayoutParams params = new android.widget.AbsListView.LayoutParams(LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);
                weekView.setLayoutParams(params);
                weekView.setClickable(true);
                weekView.setOnTouchListener(this);
            } //End block
            int selectedWeekDay = (mSelectedWeek == position) ? mSelectedDate.get(
                    Calendar.DAY_OF_WEEK) : -1;
            weekView.init(position, selectedWeekDay, mFocusedMonth);
View var4B3D7F76B00CE0C2FF9DC309BE93B973_1271152330 =             weekView;
            var4B3D7F76B00CE0C2FF9DC309BE93B973_1271152330.addTaint(taint);
            return var4B3D7F76B00CE0C2FF9DC309BE93B973_1271152330;
            // ---------- Original Method ----------
            //WeekView weekView = null;
            //if (convertView != null) {
                //weekView = (WeekView) convertView;
            //} else {
                //weekView = new WeekView(mContext);
                //android.widget.AbsListView.LayoutParams params =
                    //new android.widget.AbsListView.LayoutParams(LayoutParams.WRAP_CONTENT,
                            //LayoutParams.WRAP_CONTENT);
                //weekView.setLayoutParams(params);
                //weekView.setClickable(true);
                //weekView.setOnTouchListener(this);
            //}
            //int selectedWeekDay = (mSelectedWeek == position) ? mSelectedDate.get(
                    //Calendar.DAY_OF_WEEK) : -1;
            //weekView.init(position, selectedWeekDay, mFocusedMonth);
            //return weekView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.915 -0400", hash_original_method = "3E18205C8C59D0D94EAE40666647C4EA", hash_generated_method = "209551BA2FAF07CA3FEEC0410B172901")
        public void setFocusMonth(int month) {
            if(mFocusedMonth == month)            
            {
                return;
            } //End block
            mFocusedMonth = month;
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //if (mFocusedMonth == month) {
                //return;
            //}
            //mFocusedMonth = month;
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.915 -0400", hash_original_method = "0A87811DE71587238059DB215F3C12EA", hash_generated_method = "8EF05A2F9A4DDDA43A7AD706065B0DFD")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(v.getTaint());
            if(mListView.isEnabled() && mGestureDetector.onTouchEvent(event))            
            {
                WeekView weekView = (WeekView) v;
                if(!weekView.getDayFromLocation(event.getX(), mTempDate))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_176060846 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100796530 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100796530;
                } //End block
                if(mTempDate.before(mMinDate) || mTempDate.after(mMaxDate))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1500193945 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602244926 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_602244926;
                } //End block
                onDateTapped(mTempDate);
                boolean varB326B5062B2F0E69046810717534CB09_1083377082 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1083067210 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1083067210;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1352771310 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549068673 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_549068673;
            // ---------- Original Method ----------
            //if (mListView.isEnabled() && mGestureDetector.onTouchEvent(event)) {
                //WeekView weekView = (WeekView) v;
                //if (!weekView.getDayFromLocation(event.getX(), mTempDate)) {
                    //return true;
                //}
                //if (mTempDate.before(mMinDate) || mTempDate.after(mMaxDate)) {
                    //return true;
                //}
                //onDateTapped(mTempDate);
                //return true;
            //}
            //return false;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.915 -0400", hash_original_method = "DDBBBC0FCC832A9812721416C01B8F28", hash_generated_method = "5BFCD1D5FB51F91F9B872F6076CD5CC8")
        private void onDateTapped(Calendar day) {
            addTaint(day.getTaint());
            setSelectedDay(day);
            setMonthDisplayed(day);
            // ---------- Original Method ----------
            //setSelectedDay(day);
            //setMonthDisplayed(day);
        }

        
        class CalendarGestureListener extends GestureDetector.SimpleOnGestureListener {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.915 -0400", hash_original_method = "CB9AB034B294CB4BEC33AF8713B8812C", hash_generated_method = "CB9AB034B294CB4BEC33AF8713B8812C")
            public CalendarGestureListener ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_method = "685EB340645172BC9B4FCDA0078720CA", hash_generated_method = "46295EC8E011103D4E04B028DF7EFD38")
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(e.getTaint());
                boolean varB326B5062B2F0E69046810717534CB09_1120252734 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873220120 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_873220120;
                // ---------- Original Method ----------
                //return true;
            }

            
        }


        
    }


    
    private class WeekView extends View {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

        private final Rect mTempRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "394BE8F49DD1F8686145CEDF6D7D200A", hash_generated_field = "338ED8DD33B33701CE23F0F875140BFA")

        private final Paint mDrawPaint = new Paint();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "4A4ADF952F5968BAED427F046CBF37FE", hash_generated_field = "B72452912A34FBA0455C9A4A9A3B5617")

        private final Paint mMonthNumDrawPaint = new Paint();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "22DBF63C8E4F821B54530537F76A52B6", hash_generated_field = "78D1BFA8C5AB20E3FA796AF37BFF531E")

        private String[] mDayNumbers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "18DE4256C2B0C53BE2F29B6D186CFFFF", hash_generated_field = "952CF69DC05C27C042F9A535F18EABAA")

        private boolean[] mFocusDay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "87F6D1BA22A6EC13E132AB98FEAFF205", hash_generated_field = "BA0F23DA4A4FAB8F0FD3B66F58517BD2")

        private Calendar mFirstDay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "AB7C22B117CDEEA55E65036752634736", hash_generated_field = "FB82DB14926CC1AA0BF7C4500B4879E0")

        private int mMonthOfFirstWeekDay = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "C86E3487156BCCE50E31F5EEA81618EF", hash_generated_field = "2E4EA70A3DFCC5BD9972525121790DF9")

        private int mLastWeekDayMonth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "C307A3447C42A7BC6C7C6B5030BB815C", hash_generated_field = "90778EE1CDF324DB4B5F442558960D7A")

        private int mWeek = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "90BDD061BFE910EE6291BC190F64210C", hash_generated_field = "F079C68689F59A1F17CEAEF7A0E64F7E")

        private boolean mHasSelectedDay = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "9287FCC60987F8DA299E360E30656177", hash_generated_field = "473DF409EEE7296C165945C249CB7F25")

        private int mSelectedDay = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "58EED62B2D852E87C04DA2E6A0365DCE", hash_generated_field = "84AEAB75604C7FBC0916DC2DDFA2924F")

        private int mNumCells;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "AA5E13FFEAC37665A0A31B62B2F782FE", hash_generated_field = "4298CFE393B84E2395510D4EDDD01514")

        private int mSelectedLeft = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_field = "1D3EADA04AEB61A86356B94F32DC8646", hash_generated_field = "47DB8CDE061685EA777E17F9CDE00FAF")

        private int mSelectedRight = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.916 -0400", hash_original_method = "FA7001D4C667668E5D1235594C9A8E32", hash_generated_method = "91FEFBE2802D2D5EBD523D108DA52FD2")
        public  WeekView(Context context) {
            super(context);
            addTaint(context.getTaint());
            mHeight = (mListView.getHeight() - mListView.getPaddingTop() - mListView
                    .getPaddingBottom()) / mShownWeekCount;
            setPaintProperties();
            // ---------- Original Method ----------
            //mHeight = (mListView.getHeight() - mListView.getPaddingTop() - mListView
                    //.getPaddingBottom()) / mShownWeekCount;
            //setPaintProperties();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.917 -0400", hash_original_method = "27089ACBC4590C27BA2DDE1963872C77", hash_generated_method = "2F7AFC17E380A030AA867E09B1A27210")
        public void init(int weekNumber, int selectedWeekDay, int focusedMonth) {
            mSelectedDay = selectedWeekDay;
            mHasSelectedDay = mSelectedDay != -1;
            mNumCells = mShowWeekNumber ? mDaysPerWeek + 1 : mDaysPerWeek;
            mWeek = weekNumber;
            mTempDate.setTimeInMillis(mMinDate.getTimeInMillis());
            mTempDate.add(Calendar.WEEK_OF_YEAR, mWeek);
            mTempDate.setFirstDayOfWeek(mFirstDayOfWeek);
            mDayNumbers = new String[mNumCells];
            mFocusDay = new boolean[mNumCells];
            int i = 0;
            if(mShowWeekNumber)            
            {
                mDayNumbers[0] = Integer.toString(mTempDate.get(Calendar.WEEK_OF_YEAR));
                i++;
            } //End block
            int diff = mFirstDayOfWeek - mTempDate.get(Calendar.DAY_OF_WEEK);
            mTempDate.add(Calendar.DAY_OF_MONTH, diff);
            mFirstDay = (Calendar) mTempDate.clone();
            mMonthOfFirstWeekDay = mTempDate.get(Calendar.MONTH);
for(;i < mNumCells;i++)
            {
                mFocusDay[i] = (mTempDate.get(Calendar.MONTH) == focusedMonth);
                if(mTempDate.before(mMinDate) || mTempDate.after(mMaxDate))                
                {
                    mDayNumbers[i] = "";
                } //End block
                else
                {
                    mDayNumbers[i] = Integer.toString(mTempDate.get(Calendar.DAY_OF_MONTH));
                } //End block
                mTempDate.add(Calendar.DAY_OF_MONTH, 1);
            } //End block
            if(mTempDate.get(Calendar.DAY_OF_MONTH) == 1)            
            {
                mTempDate.add(Calendar.DAY_OF_MONTH, -1);
            } //End block
            mLastWeekDayMonth = mTempDate.get(Calendar.MONTH);
            updateSelectionPositions();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.917 -0400", hash_original_method = "FEF07EDEB83DCD7D850BA0B7A04A7856", hash_generated_method = "0EDF79AFD422A561AEFB941B8564204D")
        private void setPaintProperties() {
            mDrawPaint.setFakeBoldText(false);
            mDrawPaint.setAntiAlias(true);
            mDrawPaint.setTextSize(mDateTextSize);
            mDrawPaint.setStyle(Style.FILL);
            mMonthNumDrawPaint.setFakeBoldText(true);
            mMonthNumDrawPaint.setAntiAlias(true);
            mMonthNumDrawPaint.setTextSize(mDateTextSize);
            mMonthNumDrawPaint.setColor(mFocusedMonthDateColor);
            mMonthNumDrawPaint.setStyle(Style.FILL);
            mMonthNumDrawPaint.setTextAlign(Align.CENTER);
            // ---------- Original Method ----------
            //mDrawPaint.setFakeBoldText(false);
            //mDrawPaint.setAntiAlias(true);
            //mDrawPaint.setTextSize(mDateTextSize);
            //mDrawPaint.setStyle(Style.FILL);
            //mMonthNumDrawPaint.setFakeBoldText(true);
            //mMonthNumDrawPaint.setAntiAlias(true);
            //mMonthNumDrawPaint.setTextSize(mDateTextSize);
            //mMonthNumDrawPaint.setColor(mFocusedMonthDateColor);
            //mMonthNumDrawPaint.setStyle(Style.FILL);
            //mMonthNumDrawPaint.setTextAlign(Align.CENTER);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.917 -0400", hash_original_method = "132ACA3161A5E95F30BDE89FA7E699D9", hash_generated_method = "FED1CFA519B96626D97F4F0B8E9ECDDB")
        public int getMonthOfFirstWeekDay() {
            int var6CD19E346791C18197AD7EF90BB2B5BC_2091899082 = (mMonthOfFirstWeekDay);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798089633 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798089633;
            // ---------- Original Method ----------
            //return mMonthOfFirstWeekDay;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.917 -0400", hash_original_method = "CD3B8D9B4D0AF03A28010706DE17FBAB", hash_generated_method = "78316ABC4FAF55D1D52B0CBA4EFA9AA5")
        public int getMonthOfLastWeekDay() {
            int var4C5CE45FAFF7E4CAA32AD4D878ED3E93_719744595 = (mLastWeekDayMonth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991547994 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991547994;
            // ---------- Original Method ----------
            //return mLastWeekDayMonth;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.917 -0400", hash_original_method = "58CF666CFDF77BB5B426C92097C0AA79", hash_generated_method = "13ECE14B5994DF090DFC5B8BA921E1A4")
        public Calendar getFirstDay() {
Calendar var6B7DB0E14A75815A70795AEE528E21DF_1950891506 =             mFirstDay;
            var6B7DB0E14A75815A70795AEE528E21DF_1950891506.addTaint(taint);
            return var6B7DB0E14A75815A70795AEE528E21DF_1950891506;
            // ---------- Original Method ----------
            //return mFirstDay;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.918 -0400", hash_original_method = "967438ECCB56B80859C1A92A3366B466", hash_generated_method = "6B819ADF1AB6EA206FD21620CA8C550F")
        public boolean getDayFromLocation(float x, Calendar outCalendar) {
            addTaint(outCalendar.getTaint());
            addTaint(x);
            int dayStart = mShowWeekNumber ? mWidth / mNumCells : 0;
            if(x < dayStart || x > mWidth)            
            {
                outCalendar.clear();
                boolean var68934A3E9455FA72420237EB05902327_172408176 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895605008 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895605008;
            } //End block
            int dayPosition = (int) ((x - dayStart) * mDaysPerWeek
                    / (mWidth - dayStart));
            outCalendar.setTimeInMillis(mFirstDay.getTimeInMillis());
            outCalendar.add(Calendar.DAY_OF_MONTH, dayPosition);
            boolean varB326B5062B2F0E69046810717534CB09_216189321 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100146903 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100146903;
            // ---------- Original Method ----------
            //int dayStart = mShowWeekNumber ? mWidth / mNumCells : 0;
            //if (x < dayStart || x > mWidth) {
                //outCalendar.clear();
                //return false;
            //}
            //int dayPosition = (int) ((x - dayStart) * mDaysPerWeek
                    /// (mWidth - dayStart));
            //outCalendar.setTimeInMillis(mFirstDay.getTimeInMillis());
            //outCalendar.add(Calendar.DAY_OF_MONTH, dayPosition);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.918 -0400", hash_original_method = "2CF8C160EAF6EF1682AC691B4F4CBC56", hash_generated_method = "6D9102B33C37C7D0B76285563AE95F9D")
        @Override
        protected void onDraw(Canvas canvas) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(canvas.getTaint());
            drawBackground(canvas);
            drawWeekNumbers(canvas);
            drawWeekSeparators(canvas);
            drawSelectedDateVerticalBars(canvas);
            // ---------- Original Method ----------
            //drawBackground(canvas);
            //drawWeekNumbers(canvas);
            //drawWeekSeparators(canvas);
            //drawSelectedDateVerticalBars(canvas);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.918 -0400", hash_original_method = "86B2559C98404D7EBD9D2D1A57D5B7B9", hash_generated_method = "9CE1D0EEB5FBABB56A1FB81388A93520")
        private void drawBackground(Canvas canvas) {
            addTaint(canvas.getTaint());
            if(!mHasSelectedDay)            
            {
                return;
            } //End block
            mDrawPaint.setColor(mSelectedWeekBackgroundColor);
            mTempRect.top = mWeekSeperatorLineWidth;
            mTempRect.bottom = mHeight;
            mTempRect.left = mShowWeekNumber ? mWidth / mNumCells : 0;
            mTempRect.right = mSelectedLeft - 2;
            canvas.drawRect(mTempRect, mDrawPaint);
            mTempRect.left = mSelectedRight + 3;
            mTempRect.right = mWidth;
            canvas.drawRect(mTempRect, mDrawPaint);
            // ---------- Original Method ----------
            //if (!mHasSelectedDay) {
                //return;
            //}
            //mDrawPaint.setColor(mSelectedWeekBackgroundColor);
            //mTempRect.top = mWeekSeperatorLineWidth;
            //mTempRect.bottom = mHeight;
            //mTempRect.left = mShowWeekNumber ? mWidth / mNumCells : 0;
            //mTempRect.right = mSelectedLeft - 2;
            //canvas.drawRect(mTempRect, mDrawPaint);
            //mTempRect.left = mSelectedRight + 3;
            //mTempRect.right = mWidth;
            //canvas.drawRect(mTempRect, mDrawPaint);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.918 -0400", hash_original_method = "D3ED4C16A7F0A5B2E5F9E818EC82B4AE", hash_generated_method = "948A5BC8AA557E781C3A675A0B95A405")
        private void drawWeekNumbers(Canvas canvas) {
            addTaint(canvas.getTaint());
            float textHeight = mDrawPaint.getTextSize();
            int y = (int) ((mHeight + textHeight) / 2) - mWeekSeperatorLineWidth;
            int nDays = mNumCells;
            mDrawPaint.setTextAlign(Align.CENTER);
            int i = 0;
            int divisor = 2 * nDays;
            if(mShowWeekNumber)            
            {
                mDrawPaint.setColor(mWeekNumberColor);
                int x = mWidth / divisor;
                canvas.drawText(mDayNumbers[0], x, y, mDrawPaint);
                i++;
            } //End block
for(;i < nDays;i++)
            {
                mMonthNumDrawPaint.setColor(mFocusDay[i] ? mFocusedMonthDateColor
                        : mUnfocusedMonthDateColor);
                int x = (2 * i + 1) * mWidth / divisor;
                canvas.drawText(mDayNumbers[i], x, y, mMonthNumDrawPaint);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.918 -0400", hash_original_method = "D028062BEA4F3ED75274534BCA9F109C", hash_generated_method = "E709529DEA0DED460AEF4E47DC993918")
        private void drawWeekSeparators(Canvas canvas) {
            addTaint(canvas.getTaint());
            int firstFullyVisiblePosition = mListView.getFirstVisiblePosition();
            if(mListView.getChildAt(0).getTop() < 0)            
            {
                firstFullyVisiblePosition++;
            } //End block
            if(firstFullyVisiblePosition == mWeek)            
            {
                return;
            } //End block
            mDrawPaint.setColor(mWeekSeparatorLineColor);
            mDrawPaint.setStrokeWidth(mWeekSeperatorLineWidth);
            float x = mShowWeekNumber ? mWidth / mNumCells : 0;
            canvas.drawLine(x, 0, mWidth, 0, mDrawPaint);
            // ---------- Original Method ----------
            //int firstFullyVisiblePosition = mListView.getFirstVisiblePosition();
            //if (mListView.getChildAt(0).getTop() < 0) {
                //firstFullyVisiblePosition++;
            //}
            //if (firstFullyVisiblePosition == mWeek) {
                //return;
            //}
            //mDrawPaint.setColor(mWeekSeparatorLineColor);
            //mDrawPaint.setStrokeWidth(mWeekSeperatorLineWidth);
            //float x = mShowWeekNumber ? mWidth / mNumCells : 0;
            //canvas.drawLine(x, 0, mWidth, 0, mDrawPaint);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_method = "A1C98C2320B89AC1B0E9DE7623F0F5E4", hash_generated_method = "63C139C941A30F1F9FC6B4DFBF8CF742")
        private void drawSelectedDateVerticalBars(Canvas canvas) {
            addTaint(canvas.getTaint());
            if(!mHasSelectedDay)            
            {
                return;
            } //End block
            mSelectedDateVerticalBar.setBounds(mSelectedLeft - mSelectedDateVerticalBarWidth / 2,
                    mWeekSeperatorLineWidth,
                    mSelectedLeft + mSelectedDateVerticalBarWidth / 2, mHeight);
            mSelectedDateVerticalBar.draw(canvas);
            mSelectedDateVerticalBar.setBounds(mSelectedRight - mSelectedDateVerticalBarWidth / 2,
                    mWeekSeperatorLineWidth,
                    mSelectedRight + mSelectedDateVerticalBarWidth / 2, mHeight);
            mSelectedDateVerticalBar.draw(canvas);
            // ---------- Original Method ----------
            //if (!mHasSelectedDay) {
                //return;
            //}
            //mSelectedDateVerticalBar.setBounds(mSelectedLeft - mSelectedDateVerticalBarWidth / 2,
                    //mWeekSeperatorLineWidth,
                    //mSelectedLeft + mSelectedDateVerticalBarWidth / 2, mHeight);
            //mSelectedDateVerticalBar.draw(canvas);
            //mSelectedDateVerticalBar.setBounds(mSelectedRight - mSelectedDateVerticalBarWidth / 2,
                    //mWeekSeperatorLineWidth,
                    //mSelectedRight + mSelectedDateVerticalBarWidth / 2, mHeight);
            //mSelectedDateVerticalBar.draw(canvas);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_method = "07B6C7DD90A0E1B5FAECCFBA1208B086", hash_generated_method = "BF6614470838B915A7C6A26764522E8D")
        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(oldh);
            addTaint(oldw);
            addTaint(h);
            mWidth = w;
            updateSelectionPositions();
            // ---------- Original Method ----------
            //mWidth = w;
            //updateSelectionPositions();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_method = "F4AE55BB3F9C613E7E5A646F02C33791", hash_generated_method = "BC87DAAA961292A6002771AFECC7BFCB")
        private void updateSelectionPositions() {
            if(mHasSelectedDay)            
            {
                int selectedPosition = mSelectedDay - mFirstDayOfWeek;
                if(selectedPosition < 0)                
                {
                    selectedPosition += 7;
                } //End block
                if(mShowWeekNumber)                
                {
                    selectedPosition++;
                } //End block
                mSelectedLeft = selectedPosition * mWidth / mNumCells;
                mSelectedRight = (selectedPosition + 1) * mWidth / mNumCells;
            } //End block
            // ---------- Original Method ----------
            //if (mHasSelectedDay) {
                //int selectedPosition = mSelectedDay - mFirstDayOfWeek;
                //if (selectedPosition < 0) {
                    //selectedPosition += 7;
                //}
                //if (mShowWeekNumber) {
                    //selectedPosition++;
                //}
                //mSelectedLeft = selectedPosition * mWidth / mNumCells;
                //mSelectedRight = (selectedPosition + 1) * mWidth / mNumCells;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_method = "F89A4F4FAB6DC416DC0DD7077DC69E1C", hash_generated_method = "6EB98793EDFC763198F103C4D44B70B2")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(heightMeasureSpec);
            addTaint(widthMeasureSpec);
            setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mHeight);
            // ---------- Original Method ----------
            //setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mHeight);
        }

        
    }


    
    public interface OnDateChangeListener {

        
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_field = "9D3BCF7D4519E93E9628DBE4424A7368", hash_generated_field = "8CE15FF28B44090045106C853EF2EE4B")

    private static final String LOG_TAG = CalendarView.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_field = "AFDA9FAB15D7C033010EBA67D4668032", hash_generated_field = "646039AB554A3815E0298F000A3686C8")

    private static final boolean DEFAULT_SHOW_WEEK_NUMBER = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_field = "75B2168E67F32942A7660EE332C31135", hash_generated_field = "0F74C92E99DEC02D7782C264F33AE8FB")

    private static final long MILLIS_IN_DAY = 86400000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_field = "E73E3F6BACE835190EB51D4284D4F12F", hash_generated_field = "5885B11EDA0655E178ED35E9A995148D")

    private static final int DAYS_PER_WEEK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_field = "3E4652C159428BF86522F98B26713746", hash_generated_field = "165EEE05425CB47749F5037764F4A7D3")

    private static final long MILLIS_IN_WEEK = DAYS_PER_WEEK * MILLIS_IN_DAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.919 -0400", hash_original_field = "4B2AC5C58D3448E41283380DF77299BB", hash_generated_field = "2AA8DB968B5A86A728DD2A86DD1E7E93")

    private static final int SCROLL_HYST_WEEKS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "D8263D549687B4628B92BAE2BB05D39D", hash_generated_field = "6C834AEF89871A669CC43830D67C8C03")

    private static final int GOTO_SCROLL_DURATION = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "65291FF078235139EB25043B4C411CA6", hash_generated_field = "A674A9C559D7D2AC10E9248FA01CEAFA")

    private static final int ADJUSTMENT_SCROLL_DURATION = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "9126C0F569F8BFC4BBF915A9A40A38A4", hash_generated_field = "E9D815F505FCC787C9BD6CEF978C9ACB")

    private static final int SCROLL_CHANGE_DELAY = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "7D0AA228503FFF788A6CED655322E089", hash_generated_field = "92A4E472511D5AB0B2A3BE852088B3B7")

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "4F04DCD0A895B76C4E10897110A5FF1F", hash_generated_field = "A084D00EDEE1C51E7E64232271A08EA5")

    private static final String DEFAULT_MIN_DATE = "01/01/1900";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "74FBF6AD55305F912C4747F0851D9160", hash_generated_field = "F4B9230A9D1D80341565F8E78206D2EC")

    private static final String DEFAULT_MAX_DATE = "01/01/2100";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "DC5440C1DB9B69DE0E7FBAEBBF35CE8A", hash_generated_field = "4C736D69B6814393DDDF5CDEECB06D46")

    private static final int DEFAULT_SHOWN_WEEK_COUNT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "08F8397780669F0148C5F4E72CD58D16", hash_generated_field = "496326F4CDD77EAC73CDD5295D2BE7A2")

    private static final int DEFAULT_DATE_TEXT_SIZE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "181CB101E5C05308B5D55B88B0936114", hash_generated_field = "3A418335293EF12B3DA3F4FDB05879C9")

    private static final int UNSCALED_SELECTED_DATE_VERTICAL_BAR_WIDTH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "E2F5CCF7BD4DCAA6357FE33CE58250D9", hash_generated_field = "E66AB956C44089E58FD61F5676B647D8")

    private static final int UNSCALED_WEEK_MIN_VISIBLE_HEIGHT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "1D6B554C3C6BCE4E3706D02C1803AE0D", hash_generated_field = "1FBE9A9D01B5A713E1CD35B977F46262")

    private static final int UNSCALED_LIST_SCROLL_TOP_OFFSET = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "D78F4B563158048112FA3DDCAA2E7A0A", hash_generated_field = "98241598EE1C58C44C51B6E4E37BFA7A")

    private static final int UNSCALED_BOTTOM_BUFFER = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "DB767308D105578E5E82E56B7F0DC432", hash_generated_field = "2E33FBCAB992F6A4FCF51C7E08C43011")

    private static final int UNSCALED_WEEK_SEPARATOR_LINE_WIDTH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.920 -0400", hash_original_field = "D5F646191AC5848A917A9A89EEED7A43", hash_generated_field = "F0ACF1E44F55CCE1B401D0863B7C0AC8")

    private static final int DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID = -1;
}

