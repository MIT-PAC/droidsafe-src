package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.annotation.Widget;
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
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import com.android.internal.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import libcore.icu.LocaleData;

public class CalendarView extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "ED78BABF354FEF8D61EC60FB59A2000B", hash_generated_field = "8B23991BED629DDCFDA8E1DD88120AF5")

    private int mWeekSeperatorLineWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "1D34B47E8775BB2ECA8D8931C9929E4C", hash_generated_field = "3897E934AACB2D4B5C6B0C16CCB429A0")

    private int mDateTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "FB12A71334A6D7EE07106F45B00108F2", hash_generated_field = "A59A89A5D83C758D66546FEAE58F54D4")

    private Drawable mSelectedDateVerticalBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "C73B64367500D418F6D9EE65E112239B", hash_generated_field = "2C1B7E5AE5693E0A43249D97A45D63E8")

    private int mSelectedDateVerticalBarWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "8392E587DA00F5D5D7236C5119EC162F", hash_generated_field = "74B6E0C11198E97BD97CA4756AB27759")

    private int mSelectedWeekBackgroundColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "DF5E3F482A39E59C0A6FD713E1F7B79D", hash_generated_field = "A9584354BACE2D8F069618758B081B06")

    private int mFocusedMonthDateColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "27BBE21312EE1580A61F6D3E69496189", hash_generated_field = "7D2BE4C5D269E856747B17281912BE9C")

    private int mUnfocusedMonthDateColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "BE2F3C75D7D9AC89B14EF2F89598BB24", hash_generated_field = "8DDBF4CBD718C3948A0F42D2C1DB5D99")

    private int mWeekSeparatorLineColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "746B0FA1EB20C3937304705FE5C23493", hash_generated_field = "6A25546F44B6068A62792DA64248742A")

    private int mWeekNumberColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.146 -0400", hash_original_field = "8AD37204774915335DFF4E89A8110A64", hash_generated_field = "5665B7B8CC3DF642A1DAF00F3DE77EFA")

    private int mListScrollTopOffset = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "58F9877B31CDB53B0DEBB1000C39DD90", hash_generated_field = "D65BAA41D805492896870D587D162209")

    private int mWeekMinVisibleHeight = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "F651E579DA04CEFE11049FBAA43D493E", hash_generated_field = "5FC459B021EAF2699021DD8B9B1D6C2B")

    private int mBottomBuffer = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "D0CCED79166044E967E93767AAFDB4D2", hash_generated_field = "6CB09EC87311D40CB9B77369F5C620A1")

    private int mShownWeekCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "53E3E568843E4B190CE603DFFAC9D53E", hash_generated_field = "0A0881CE0345FE41D9B257D56D8D82CA")

    private boolean mShowWeekNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "005222EB6C4F0D144BE8F9C50ECD901D", hash_generated_field = "0792CCA61E447A5A7FB7126E5ABF29EC")

    private int mDaysPerWeek = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "0212E969626F0F0D1636343F1309E195", hash_generated_field = "78A6141C2BBA378820D9128DA7F22F8D")

    private float mFriction = .05f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "53A4ECF35C3EFF748C559F23D0631904", hash_generated_field = "E3AADF3834C4F3228039B1ED679BE2BE")

    private float mVelocityScale = 0.333f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "C5ED7BC1BF12E15BC029B4E0815E71E3")

    private WeeksAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "18448757CD3C825FD4B679B03ECA4680", hash_generated_field = "3BCC597FF6F62DFD9F809924D1A9B7CC")

    private TextView mMonthName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "12D57B519396B84F36E1C5CCCE7BEFD7", hash_generated_field = "E95A3921B8AB382181ED602DFBF5F267")

    private ViewGroup mDayNamesHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "6EF4E151400CEC15A8876C51787B7E10", hash_generated_field = "59E44C9DFCE7DBB845766E4E65180588")

    private String[] mDayLabels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "FD868BD5C2AC35186323583DC33DC09D", hash_generated_field = "30452844013892C49D8827DAE1E459DE")

    private int mFirstDayOfWeek;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "2FC11E055DD064417E49C7C20C8CD874", hash_generated_field = "41289D9BED76260F340EB785FCC2056A")

    private int mCurrentMonthDisplayed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "FE81B8EDAAB742D1A97D166BED21F370", hash_generated_field = "A32E25FFB7BC22A215A1EAB2F45C9CD4")

    private long mPreviousScrollPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "11AB8A4F6569B0496A3B3BFA0E1C3F20", hash_generated_field = "5B9F7E9646034BCC8F83298FA039B637")

    private boolean mIsScrollingUp = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "A67CBF76ED54FBC5D55CD0E77A575947", hash_generated_field = "F3024B0C881FFDC3012F965272357A8A")

    private int mPreviousScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "81988B32590D1655D65A6770ED17DCEF", hash_generated_field = "328AD7D92706C021C1C22127BE75612C")

    private int mCurrentScrollState = OnScrollListener.SCROLL_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "811A2D8EF3A390BABF52F43FDF0E05DE", hash_generated_field = "05EE47F5BF2CAC4310C2BEEFD3D65AE0")

    private OnDateChangeListener mOnDateChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "02096E197DDBCC617385B7820770714F", hash_generated_field = "2729908D3AF534B2F645E718D75BC4E8")

    private ScrollStateRunnable mScrollStateChangedRunnable = new ScrollStateRunnable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "2CD58DB7365E32A740CCEDC539E005B5", hash_generated_field = "915400C77BD703DACB8E97CD72BFFD5E")

    private Calendar mTempDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "9B3201C38EFD7F45CCD545D51C752709", hash_generated_field = "D29AF2C549B988F84E81471C8F4DFA25")

    private Calendar mFirstDayOfMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "E65E4BB5B38AD013B1E2F00B4ED9DF18", hash_generated_field = "681C6D172B5A021A54543F6E6ED5BD03")

    private Calendar mMinDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "022B7F9BF85FB96A21762C2F3C1B66E0", hash_generated_field = "4C58BCC5BEA466149D70675257F2009F")

    private Calendar mMaxDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "D09E60E802BCF776E697BC72D82FD915", hash_generated_field = "B406C1F86E2B5C90127E71BBD6EC950B")

    private final java.text.DateFormat mDateFormat = new SimpleDateFormat(DATE_FORMAT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_field = "A21C83444D8B0E7E33D76B52140C960A", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.147 -0400", hash_original_method = "52384FB40509E71BA2451D4915E5D413", hash_generated_method = "E8B74CDF68DAAB62882F628129916D13")
    public  CalendarView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.148 -0400", hash_original_method = "79D5762FBD0B1A46CF2745AED4E3FAD9", hash_generated_method = "03C2BAB24513DB995CE8568B55BDED26")
    public  CalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.149 -0400", hash_original_method = "B881CA40E8482968634BC9086836F338", hash_generated_method = "17C4AC8E3BA5221CF24956B2B9277F2A")
    public  CalendarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, 0);
        setCurrentLocale(Locale.getDefault());
        TypedArray attributesArray = context.obtainStyledAttributes(attrs, R.styleable.CalendarView,
                R.attr.calendarViewStyle, 0);
        mShowWeekNumber = attributesArray.getBoolean(R.styleable.CalendarView_showWeekNumber,
                DEFAULT_SHOW_WEEK_NUMBER);
        mFirstDayOfWeek = attributesArray.getInt(R.styleable.CalendarView_firstDayOfWeek,
                LocaleData.get(Locale.getDefault()).firstDayOfWeek);
        String minDate = attributesArray.getString(R.styleable.CalendarView_minDate);
        {
            boolean var90AD151C49446DC9B6504DDCC69BA991_1477973289 = (TextUtils.isEmpty(minDate) || !parseDate(minDate, mMinDate));
            {
                parseDate(DEFAULT_MIN_DATE, mMinDate);
            } 
        } 
        String maxDate = attributesArray.getString(R.styleable.CalendarView_maxDate);
        {
            boolean varE3F62D79DFB1CE6472EF517746A3B9BD_436829353 = (TextUtils.isEmpty(maxDate) || !parseDate(maxDate, mMaxDate));
            {
                parseDate(DEFAULT_MAX_DATE, mMaxDate);
            } 
        } 
        {
            boolean var3EF097584A45D1A3246AC332EAF623F3_417588822 = (mMaxDate.before(mMinDate));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Max date cannot be before min date.");
            } 
        } 
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
        {
            boolean var723089A440AF4CB7CC64C5EEF62BE8A3_530504309 = (mTempDate.before(mMinDate));
            {
                goTo(mMinDate, false, true, true);
            } 
            {
                boolean var3CD27D6CFCFE61CCC254254F95A4E4B6_683011334 = (mMaxDate.before(mTempDate));
                {
                    goTo(mMaxDate, false, true, true);
                } 
                {
                    goTo(mTempDate, false, true, true);
                } 
            } 
        } 
        invalidate();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.150 -0400", hash_original_method = "1D9E2CC40134FA188645AC8C7A8FADC7", hash_generated_method = "FF7DBA35B8768F9E6F6F7DD42CFB060E")
    @Override
    public void setEnabled(boolean enabled) {
        mListView.setEnabled(enabled);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.150 -0400", hash_original_method = "93B4809DF8FBD1AECB02AFF6547691F9", hash_generated_method = "746363DB5F7949139045FD1596C35591")
    @Override
    public boolean isEnabled() {
        boolean var3EFC8F76722ABBAE67832DDF2F2F242C_1692374697 = (mListView.isEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572803375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572803375;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.151 -0400", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "FB0A11FC0C47EF7B377125BF2E9C2DD7")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
        addTaint(newConfig.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.151 -0400", hash_original_method = "967B291ED0BCED68F7E3E5A0CEF03695", hash_generated_method = "F80FB4500E16AAC325103C2C70459F5F")
    public long getMinDate() {
        long varE9182735C4E0F8DB15688CAB80ADDB8E_1647610672 = (mMinDate.getTimeInMillis());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_172821006 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_172821006;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.151 -0400", hash_original_method = "FF5386D03D60B1076A84367A6FF3DA28", hash_generated_method = "B3BB0F4F87DE867619C018F12EDA3A6B")
    public void setMinDate(long minDate) {
        mTempDate.setTimeInMillis(minDate);
        {
            boolean varBA6899CBD1B589E9C9339139EE86931B_1601106127 = (isSameDate(mTempDate, mMinDate));
        } 
        mMinDate.setTimeInMillis(minDate);
        Calendar date = mAdapter.mSelectedDate;
        {
            boolean varC241E660552FCC0CC300BD358680B846_852870142 = (date.before(mMinDate));
            {
                mAdapter.setSelectedDay(mMinDate);
            } 
        } 
        mAdapter.init();
        {
            boolean varC241E660552FCC0CC300BD358680B846_576077336 = (date.before(mMinDate));
            {
                setDate(mTempDate.getTimeInMillis());
            } 
            {
                goTo(date, false, true, false);
            } 
        } 
        addTaint(minDate);
        
        
        
            
        
        
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.152 -0400", hash_original_method = "4B53E128D2B815FDD1432B3F6B079B5B", hash_generated_method = "748A60328E1DDA21709EB4306902E16C")
    public long getMaxDate() {
        long var7E289ED2E917AFBA91EF20B25A644C8B_838744376 = (mMaxDate.getTimeInMillis());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1404703453 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1404703453;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.152 -0400", hash_original_method = "A06814E3E9CB43249648A0F0C1DE0D5D", hash_generated_method = "C4D6E065C20270C1EA9574F1B9DE8672")
    public void setMaxDate(long maxDate) {
        mTempDate.setTimeInMillis(maxDate);
        {
            boolean var47D8C586FDF6BA5C53CDC73D89D4E5F7_1152636522 = (isSameDate(mTempDate, mMaxDate));
        } 
        mMaxDate.setTimeInMillis(maxDate);
        mAdapter.init();
        Calendar date = mAdapter.mSelectedDate;
        {
            boolean var41089FD40A46564D975094B1E25CAEC5_1868819658 = (date.after(mMaxDate));
            {
                setDate(mMaxDate.getTimeInMillis());
            } 
            {
                goTo(date, false, true, false);
            } 
        } 
        addTaint(maxDate);
        
        
        
            
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.153 -0400", hash_original_method = "F2BDD8F6BF1030E3F09A2B5F73B0EF93", hash_generated_method = "4F02A578BC90711A7E9BF40197332F4B")
    public void setShowWeekNumber(boolean showWeekNumber) {
        mShowWeekNumber = showWeekNumber;
        mAdapter.notifyDataSetChanged();
        setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.153 -0400", hash_original_method = "466B93651CABC20F69979D67C7EC6971", hash_generated_method = "2C94ED3F430DB780A1DF03F15A2D0C85")
    public boolean getShowWeekNumber() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034490609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034490609;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.153 -0400", hash_original_method = "13AE9B7D254FD4442860EE49493A72AE", hash_generated_method = "EEDBECA7B013F8ADE0DEB44AD55BA618")
    public int getFirstDayOfWeek() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25471466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25471466;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.154 -0400", hash_original_method = "631B1F3A15EE6F7D95BE757EDF5B5B91", hash_generated_method = "1ED779547D6FB4666ED6D4C1ECE6F18D")
    public void setFirstDayOfWeek(int firstDayOfWeek) {
        mFirstDayOfWeek = firstDayOfWeek;
        mAdapter.init();
        mAdapter.notifyDataSetChanged();
        setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.154 -0400", hash_original_method = "2EC5480533B2BF54D56B2049BA7CA5D7", hash_generated_method = "40E23822C44A26C2CDF30A58488DCCDD")
    public void setOnDateChangeListener(OnDateChangeListener listener) {
        mOnDateChangeListener = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.154 -0400", hash_original_method = "1C8908BABBBBE904441B712A0F71BAD8", hash_generated_method = "B0B378215B80DBE22FA101680E2745BC")
    public long getDate() {
        long var0F1B39E7345B9CDA182064903BF8E5F0_1723836198 = (mAdapter.mSelectedDate.getTimeInMillis());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2002489964 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2002489964;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.154 -0400", hash_original_method = "D6F29E7F63D0C42CAD60620E4D2FC504", hash_generated_method = "186913A4358C1D2AE1647BFD444D9924")
    public void setDate(long date) {
        setDate(date, false, false);
        addTaint(date);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.155 -0400", hash_original_method = "7D056A885692AA64348F6515B99D8688", hash_generated_method = "28DD157F8307EA38AE8B793882439FAC")
    public void setDate(long date, boolean animate, boolean center) {
        mTempDate.setTimeInMillis(date);
        {
            boolean var33AC8D86F9EF69ABC5D4276E04DCBF36_1114654642 = (isSameDate(mTempDate, mAdapter.mSelectedDate));
        } 
        goTo(mTempDate, animate, true, center);
        addTaint(date);
        addTaint(animate);
        addTaint(center);
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.155 -0400", hash_original_method = "4AE549580BCF2D6667C808ED8CCBDCDC", hash_generated_method = "08A492E9D94919663D8CA54B36D7D048")
    private void setCurrentLocale(Locale locale) {
        {
            boolean varD1CF46D36E6B1C6187CE68AE2BC3F432_1615634747 = (locale.equals(mCurrentLocale));
        } 
        mCurrentLocale = locale;
        mTempDate = getCalendarForLocale(mTempDate, locale);
        mFirstDayOfMonth = getCalendarForLocale(mFirstDayOfMonth, locale);
        mMinDate = getCalendarForLocale(mMinDate, locale);
        mMaxDate = getCalendarForLocale(mMaxDate, locale);
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.156 -0400", hash_original_method = "FA738DF80665124C3A5E01ADC04827D9", hash_generated_method = "8351B257E984CE033D23F4F313882046")
    private Calendar getCalendarForLocale(Calendar oldCalendar, Locale locale) {
        Calendar varB4EAC82CA7396A68D541C85D26508E83_468218175 = null; 
        Calendar varB4EAC82CA7396A68D541C85D26508E83_2051087816 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_468218175 = Calendar.getInstance(locale);
        } 
        {
            final long currentTimeMillis = oldCalendar.getTimeInMillis();
            Calendar newCalendar = Calendar.getInstance(locale);
            newCalendar.setTimeInMillis(currentTimeMillis);
            varB4EAC82CA7396A68D541C85D26508E83_2051087816 = newCalendar;
        } 
        addTaint(oldCalendar.getTaint());
        addTaint(locale.getTaint());
        Calendar varA7E53CE21691AB073D9660D615818899_1655802645; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1655802645 = varB4EAC82CA7396A68D541C85D26508E83_468218175;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1655802645 = varB4EAC82CA7396A68D541C85D26508E83_2051087816;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1655802645.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1655802645;
        
        
            
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.156 -0400", hash_original_method = "70DC9A9889795E848236506BBC0A481B", hash_generated_method = "150AED5F36F8C8677D792DB4EA9453F7")
    private boolean isSameDate(Calendar firstDate, Calendar secondDate) {
        boolean varE5DDF39B5D0EB5D777CDF593735BA5B3_1258468000 = ((firstDate.get(Calendar.DAY_OF_YEAR) == secondDate.get(Calendar.DAY_OF_YEAR)
                && firstDate.get(Calendar.YEAR) == secondDate.get(Calendar.YEAR)));
        addTaint(firstDate.getTaint());
        addTaint(secondDate.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568167833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568167833;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.157 -0400", hash_original_method = "513863F202D0E7C406F959CC7EBC2D43", hash_generated_method = "4B8277EB10AD80E596301A3AA86FC7C5")
    private void setUpAdapter() {
        {
            mAdapter = new WeeksAdapter(getContext());
            mAdapter.registerDataSetObserver(new DataSetObserver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.157 -0400", hash_original_method = "CEA948C87231173C338757A31D25F841", hash_generated_method = "C92C69778624C61CA35BB0BB8B9501CC")
                @Override
                public void onChanged() {
                    
                    {
                        Calendar selectedDay = mAdapter.getSelectedDay();
                        mOnDateChangeListener.onSelectedDayChange(CalendarView.this,
                                selectedDay.get(Calendar.YEAR),
                                selectedDay.get(Calendar.MONTH),
                                selectedDay.get(Calendar.DAY_OF_MONTH));
                    } 
                    
                    
                        
                        
                                
                                
                                
                    
                }
});
            mListView.setAdapter(mAdapter);
        } 
        mAdapter.notifyDataSetChanged();
        
        
            
            
                
                
                    
                        
                        
                                
                                
                                
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.158 -0400", hash_original_method = "2BEB208CF4EFB41463E1218ACA7650C9", hash_generated_method = "020ED4A1CA978F780BDFA6EBB9D1590B")
    private void setUpHeader(int weekDayTextAppearanceResId) {
        mDayLabels = new String[mDaysPerWeek];
        {
            int i = mFirstDayOfWeek;
            int count = mFirstDayOfWeek + mDaysPerWeek;
            {
                int calendarDay;
                calendarDay = i - Calendar.SATURDAY;
                calendarDay = i;
                mDayLabels[i - mFirstDayOfWeek] = DateUtils.getDayOfWeekString(calendarDay,
                    DateUtils.LENGTH_SHORTEST);
            } 
        } 
        TextView label = (TextView) mDayNamesHeader.getChildAt(0);
        {
            label.setVisibility(View.VISIBLE);
        } 
        {
            label.setVisibility(View.GONE);
        } 
        {
            int i = 1;
            int count = mDayNamesHeader.getChildCount();
            {
                label = (TextView) mDayNamesHeader.getChildAt(i);
                {
                    label.setTextAppearance(mContext, weekDayTextAppearanceResId);
                } 
                {
                    label.setText(mDayLabels[i - 1]);
                    label.setVisibility(View.VISIBLE);
                } 
                {
                    label.setVisibility(View.GONE);
                } 
            } 
        } 
        mDayNamesHeader.invalidate();
        addTaint(weekDayTextAppearanceResId);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.159 -0400", hash_original_method = "CFADBCF95F8E177F25E22F1FC2115F77", hash_generated_method = "B099A35CABD3AC64DBC2D1203A139AEB")
    private void setUpListView() {
        mListView.setDivider(null);
        mListView.setItemsCanFocus(true);
        mListView.setVerticalScrollBarEnabled(false);
        mListView.setOnScrollListener(new OnScrollListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.158 -0400", hash_original_method = "00F32D753053A861AE7DBFD213079352", hash_generated_method = "1440D062D8FF2F2BBCAFE414F0534FCE")
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                
                CalendarView.this.onScrollStateChanged(view, scrollState);
                addTaint(view.getTaint());
                addTaint(scrollState);
                
                
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.158 -0400", hash_original_method = "E68786505B378D9C994B2BFCAEDF7B06", hash_generated_method = "802A3891201685653DD4F3AA6DFC549A")
            public void onScroll(
                    AbsListView view, int firstVisibleItem, int visibleItemCount,
                    int totalItemCount) {
                
                CalendarView.this.onScroll(view, firstVisibleItem, visibleItemCount,
                        totalItemCount);
                addTaint(view.getTaint());
                addTaint(firstVisibleItem);
                addTaint(visibleItemCount);
                addTaint(totalItemCount);
                
                
                        
            }
});
        mListView.setFriction(mFriction);
        mListView.setVelocityScale(mVelocityScale);
        
        
        
        
        
            
                
            
            
                    
                    
                
                        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.160 -0400", hash_original_method = "9885B6A6E0E890A0EF52CBA474F609AF", hash_generated_method = "9753A337632257AF0956089896BBB3AC")
    private void goTo(Calendar date, boolean animate, boolean setSelected, boolean forceScroll) {
        {
            boolean var56349B8CA12AF843B6D9A651DBD6DD45_59191166 = (date.before(mMinDate) || date.after(mMaxDate));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Time not between " + mMinDate.getTime()
                    + " and " + mMaxDate.getTime());
            } 
        } 
        int firstFullyVisiblePosition = mListView.getFirstVisiblePosition();
        View firstChild = mListView.getChildAt(0);
        {
            boolean varB1D20EF5A4B647F4D83F0C989C37AB89_236554571 = (firstChild != null && firstChild.getTop() < 0);
        } 
        int lastFullyVisiblePosition = firstFullyVisiblePosition + mShownWeekCount - 1;
        {
            boolean var487141D1BA9B101D21ABAA229C5620F7_1307502306 = (firstChild != null && firstChild.getTop() > mBottomBuffer);
        } 
        {
            mAdapter.setSelectedDay(date);
        } 
        int position = getWeeksSinceMinDate(date);
        {
            mFirstDayOfMonth.setTimeInMillis(date.getTimeInMillis());
            mFirstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
            setMonthDisplayed(mFirstDayOfMonth);
            {
                boolean varA5F71149318293426D0DC11EF1E3EDB8_1022575565 = (mFirstDayOfMonth.before(mMinDate));
                {
                    position = 0;
                } 
                {
                    position = getWeeksSinceMinDate(mFirstDayOfMonth);
                } 
            } 
            mPreviousScrollState = OnScrollListener.SCROLL_STATE_FLING;
            {
                mListView.smoothScrollToPositionFromTop(position, mListScrollTopOffset,
                        GOTO_SCROLL_DURATION);
            } 
            {
                mListView.setSelectionFromTop(position, mListScrollTopOffset);
                onScrollStateChanged(mListView, OnScrollListener.SCROLL_STATE_IDLE);
            } 
        } 
        {
            setMonthDisplayed(date);
        } 
        addTaint(date.getTaint());
        addTaint(animate);
        addTaint(setSelected);
        addTaint(forceScroll);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.160 -0400", hash_original_method = "4EF37BB5E8B6D289AE6D0021CE0D4FEB", hash_generated_method = "AE968AB2EB965C307971ACAEA65503D6")
    private boolean parseDate(String date, Calendar outDate) {
        try 
        {
            outDate.setTime(mDateFormat.parse(date));
        } 
        catch (ParseException e)
        { }
        addTaint(date.getTaint());
        addTaint(outDate.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192205233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192205233;
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.161 -0400", hash_original_method = "F153BBCA7962990A30E79BE6D90D9C30", hash_generated_method = "D3775CDF8671BE04CD9A2671C1247838")
    private void onScrollStateChanged(AbsListView view, int scrollState) {
        mScrollStateChangedRunnable.doScrollStateChange(view, scrollState);
        addTaint(view.getTaint());
        addTaint(scrollState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.162 -0400", hash_original_method = "FE6404A8901B8111BDEFCBB086ABC460", hash_generated_method = "3FD67323344091B81A44089C85779417")
    private void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        WeekView child = (WeekView) view.getChildAt(0);
        long currScroll = view.getFirstVisiblePosition() * child.getHeight() - child.getBottom();
        {
            mIsScrollingUp = true;
        } 
        {
            mIsScrollingUp = false;
        } 
        int offset;
        boolean varB8609941F58CE0559139A9EC21B0733F_1634601547 = (child.getBottom() < mWeekMinVisibleHeight);
        offset = 1;
        offset = 0;
        {
            child = (WeekView) view.getChildAt(SCROLL_HYST_WEEKS + offset);
        } 
        {
            child = (WeekView) view.getChildAt(offset);
        } 
        int month;
        {
            month = child.getMonthOfFirstWeekDay();
        } 
        {
            month = child.getMonthOfLastWeekDay();
        } 
        int monthDiff;
        {
            monthDiff = 1;
        } 
        {
            monthDiff = -1;
        } 
        {
            monthDiff = month - mCurrentMonthDisplayed;
        } 
        {
            Calendar firstDay = child.getFirstDay();
            {
                firstDay.add(Calendar.DAY_OF_MONTH, -DAYS_PER_WEEK);
            } 
            {
                firstDay.add(Calendar.DAY_OF_MONTH, DAYS_PER_WEEK);
            } 
            setMonthDisplayed(firstDay);
        } 
        mPreviousScrollPosition = currScroll;
        mPreviousScrollState = mCurrentScrollState;
        addTaint(view.getTaint());
        addTaint(firstVisibleItem);
        addTaint(visibleItemCount);
        addTaint(totalItemCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.163 -0400", hash_original_method = "2D87D8A121385B44A48D783AA9D15CB4", hash_generated_method = "F309B80ADA50299E1C38827173FCD223")
    private void setMonthDisplayed(Calendar calendar) {
        final int newMonthDisplayed = calendar.get(Calendar.MONTH);
        {
            mCurrentMonthDisplayed = newMonthDisplayed;
            mAdapter.setFocusMonth(mCurrentMonthDisplayed);
            final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NO_MONTH_DAY
                    | DateUtils.FORMAT_SHOW_YEAR;
            final long millis = calendar.getTimeInMillis();
            String newMonthName = DateUtils.formatDateRange(mContext, millis, millis, flags);
            mMonthName.setText(newMonthName);
            mMonthName.invalidate();
        } 
        addTaint(calendar.getTaint());
        
        
        
            
            
            
                    
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.163 -0400", hash_original_method = "025B6CEC43A90DA392B09F9FACE78FF5", hash_generated_method = "8BD771B773080F9DE5E8762E67196162")
    private int getWeeksSinceMinDate(Calendar date) {
        {
            boolean varC241E660552FCC0CC300BD358680B846_1514686925 = (date.before(mMinDate));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("fromDate: " + mMinDate.getTime()
                    + " does not precede toDate: " + date.getTime());
            } 
        } 
        long endTimeMillis = date.getTimeInMillis()
                + date.getTimeZone().getOffset(date.getTimeInMillis());
        long startTimeMillis = mMinDate.getTimeInMillis()
                + mMinDate.getTimeZone().getOffset(mMinDate.getTimeInMillis());
        long dayOffsetMillis = (mMinDate.get(Calendar.DAY_OF_WEEK) - mFirstDayOfWeek)
                * MILLIS_IN_DAY;
        addTaint(date.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589043896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589043896;
        
        
            
                    
        
        
                
        
                
        
                
        
    }

    
    private class ScrollStateRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.164 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "1F3C2B019CE351B6A3F4C6C3616C5C0E")

        private AbsListView mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.164 -0400", hash_original_field = "175471B610D1F5C8823729FE892FAC81", hash_generated_field = "B54F7897F242D86283E88CF300719E2B")

        private int mNewState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.164 -0400", hash_original_method = "F2F7D55B897550D0A526C19F647B806C", hash_generated_method = "F2F7D55B897550D0A526C19F647B806C")
        public ScrollStateRunnable ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.164 -0400", hash_original_method = "69E5B9D1AE0F98719D28BA5FB866EF08", hash_generated_method = "AD254F241E34912551E41EEB0E981169")
        public void doScrollStateChange(AbsListView view, int scrollState) {
            mView = view;
            mNewState = scrollState;
            removeCallbacks(this);
            postDelayed(this, SCROLL_CHANGE_DELAY);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.164 -0400", hash_original_method = "62729E70BB0456A375600477CC5D2643", hash_generated_method = "B0E924386A97C613F86E5F2FD8EBDC4D")
        public void run() {
            mCurrentScrollState = mNewState;
            {
                View child = mView.getChildAt(0);
                int dist = child.getBottom() - mListScrollTopOffset;
                {
                    {
                        mView.smoothScrollBy(dist - child.getHeight(), ADJUSTMENT_SCROLL_DURATION);
                    } 
                    {
                        mView.smoothScrollBy(dist, ADJUSTMENT_SCROLL_DURATION);
                    } 
                } 
            } 
            mPreviousScrollState = mNewState;
            
            
        }

        
    }


    
    private class WeeksAdapter extends BaseAdapter implements OnTouchListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.165 -0400", hash_original_field = "87C5B793293EF336BDD19BF5E63E4DA8", hash_generated_field = "5BF9B16DA16CA4B8867BE9E962493092")

        private int mSelectedWeek;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.165 -0400", hash_original_field = "EBDAC0BE41D965D60A46156878A6BB30", hash_generated_field = "DA7C2146C29AB67A18FA4519D8BF6725")

        private GestureDetector mGestureDetector;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.165 -0400", hash_original_field = "5E580E0FCD6C56A118A33AEB961A4EFC", hash_generated_field = "F72CF38F2566D6E733620DFADA8D38C7")

        private int mFocusedMonth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.165 -0400", hash_original_field = "680C00076DF77E826310D3524A5D9353", hash_generated_field = "95E30C29B97433E1CA9F533BA1A954C1")

        private final Calendar mSelectedDate = Calendar.getInstance();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.165 -0400", hash_original_field = "106D976A13769982F741242E3234CDEC", hash_generated_field = "740B29A5145E76BF427504A23D8A9471")

        private int mTotalWeekCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.165 -0400", hash_original_method = "A5340406393612546D90AF6654589F05", hash_generated_method = "03E63CB5027271FD7D9FD5A1CCD21357")
        public  WeeksAdapter(Context context) {
            mContext = context;
            mGestureDetector = new GestureDetector(mContext, new CalendarGestureListener());
            init();
            addTaint(context.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.165 -0400", hash_original_method = "155544AF4C95F51C95BCC140A715A96B", hash_generated_method = "CA10C61293E5E757AFD2C97488CED102")
        private void init() {
            mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            mTotalWeekCount = getWeeksSinceMinDate(mMaxDate);
            {
                boolean varDAA403C0FA949103F0ECF6EFDF5EE393_723293905 = (mMinDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek
                || mMaxDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek);
            } 
            
            
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.166 -0400", hash_original_method = "D3DE83E2185E4ADE498D767CEB2FBE21", hash_generated_method = "D00C42E73B1437F0668D2E4211A02240")
        public void setSelectedDay(Calendar selectedDay) {
            {
                boolean varCD7956ABABC4DE892AEFB296DF0E8383_974491122 = (selectedDay.get(Calendar.DAY_OF_YEAR) == mSelectedDate.get(Calendar.DAY_OF_YEAR)
                    && selectedDay.get(Calendar.YEAR) == mSelectedDate.get(Calendar.YEAR));
            } 
            mSelectedDate.setTimeInMillis(selectedDay.getTimeInMillis());
            mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            mFocusedMonth = mSelectedDate.get(Calendar.MONTH);
            notifyDataSetChanged();
            addTaint(selectedDay.getTaint());
            
            
                    
                
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.166 -0400", hash_original_method = "B5E95894B654555C190BA20C07877305", hash_generated_method = "36957FC0FE727D9A4DBBEF2723CCAF85")
        public Calendar getSelectedDay() {
            Calendar varB4EAC82CA7396A68D541C85D26508E83_644077315 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_644077315 = mSelectedDate;
            varB4EAC82CA7396A68D541C85D26508E83_644077315.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_644077315;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.166 -0400", hash_original_method = "F04F5B9FBE7B2AAA41BE9F0558597E2D", hash_generated_method = "7F06AC2E4E46A6532E8B425B5A337C22")
        @Override
        public int getCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658931847 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658931847;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.167 -0400", hash_original_method = "AE0D3BF5CEF608E0D2B9C47624E8B8EC", hash_generated_method = "E49CED1F354DA8167F387B5B0A04F5D7")
        @Override
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_2146193909 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2146193909 = null;
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_2146193909.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2146193909;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.167 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "7C1B7359DA36A28C281A3872F58DB714")
        @Override
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_453670788 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_453670788;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.168 -0400", hash_original_method = "381E4A6A7165FC308D77C676467DC158", hash_generated_method = "716A17C7C1105BE24378010F3A7B9F71")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_257417650 = null; 
            WeekView weekView = null;
            {
                weekView = (WeekView) convertView;
            } 
            {
                weekView = new WeekView(mContext);
                android.widget.AbsListView.LayoutParams params = new android.widget.AbsListView.LayoutParams(LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);
                weekView.setLayoutParams(params);
                weekView.setClickable(true);
                weekView.setOnTouchListener(this);
            } 
            int selectedWeekDay;
            selectedWeekDay = mSelectedDate.get(
                    Calendar.DAY_OF_WEEK);
            selectedWeekDay = -1;
            weekView.init(position, selectedWeekDay, mFocusedMonth);
            varB4EAC82CA7396A68D541C85D26508E83_257417650 = weekView;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_257417650.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_257417650;
            
            
            
                
            
                
                
                    
                            
                
                
                
            
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.168 -0400", hash_original_method = "3E18205C8C59D0D94EAE40666647C4EA", hash_generated_method = "434605172BF3E3A0F138AD8D83F03EA5")
        public void setFocusMonth(int month) {
            mFocusedMonth = month;
            notifyDataSetChanged();
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.168 -0400", hash_original_method = "0A87811DE71587238059DB215F3C12EA", hash_generated_method = "CF0887948C48874165AB08BF427908D0")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            
            {
                boolean var277EB5C98A687F20CD30DB195A6907DC_1918507589 = (mListView.isEnabled() && mGestureDetector.onTouchEvent(event));
                {
                    WeekView weekView = (WeekView) v;
                    {
                        boolean varE873966111B65757788D695912C81706_457410508 = (!weekView.getDayFromLocation(event.getX(), mTempDate));
                    } 
                    {
                        boolean var06D364B3EF750849619343EA8C49C6D6_710061377 = (mTempDate.before(mMinDate) || mTempDate.after(mMaxDate));
                    } 
                    onDateTapped(mTempDate);
                } 
            } 
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471790350 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471790350;
            
            
                
                
                    
                
                
                    
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_method = "DDBBBC0FCC832A9812721416C01B8F28", hash_generated_method = "AFCD6817757B5FE70C709BF8CB234C0B")
        private void onDateTapped(Calendar day) {
            setSelectedDay(day);
            setMonthDisplayed(day);
            addTaint(day.getTaint());
            
            
            
        }

        
        class CalendarGestureListener extends GestureDetector.SimpleOnGestureListener {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_method = "CB9AB034B294CB4BEC33AF8713B8812C", hash_generated_method = "CB9AB034B294CB4BEC33AF8713B8812C")
            public CalendarGestureListener ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_method = "685EB340645172BC9B4FCDA0078720CA", hash_generated_method = "33FB9BADFDF20552B58F84A90B2CF7EC")
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                
                addTaint(e.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359386805 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359386805;
                
                
            }

            
        }


        
    }


    
    private class WeekView extends View {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

        private final Rect mTempRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "394BE8F49DD1F8686145CEDF6D7D200A", hash_generated_field = "338ED8DD33B33701CE23F0F875140BFA")

        private final Paint mDrawPaint = new Paint();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "4A4ADF952F5968BAED427F046CBF37FE", hash_generated_field = "B72452912A34FBA0455C9A4A9A3B5617")

        private final Paint mMonthNumDrawPaint = new Paint();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "22DBF63C8E4F821B54530537F76A52B6", hash_generated_field = "78D1BFA8C5AB20E3FA796AF37BFF531E")

        private String[] mDayNumbers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "18DE4256C2B0C53BE2F29B6D186CFFFF", hash_generated_field = "952CF69DC05C27C042F9A535F18EABAA")

        private boolean[] mFocusDay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "87F6D1BA22A6EC13E132AB98FEAFF205", hash_generated_field = "BA0F23DA4A4FAB8F0FD3B66F58517BD2")

        private Calendar mFirstDay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "AB7C22B117CDEEA55E65036752634736", hash_generated_field = "FB82DB14926CC1AA0BF7C4500B4879E0")

        private int mMonthOfFirstWeekDay = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.169 -0400", hash_original_field = "C86E3487156BCCE50E31F5EEA81618EF", hash_generated_field = "2E4EA70A3DFCC5BD9972525121790DF9")

        private int mLastWeekDayMonth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "C307A3447C42A7BC6C7C6B5030BB815C", hash_generated_field = "90778EE1CDF324DB4B5F442558960D7A")

        private int mWeek = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "90BDD061BFE910EE6291BC190F64210C", hash_generated_field = "F079C68689F59A1F17CEAEF7A0E64F7E")

        private boolean mHasSelectedDay = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "9287FCC60987F8DA299E360E30656177", hash_generated_field = "473DF409EEE7296C165945C249CB7F25")

        private int mSelectedDay = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "58EED62B2D852E87C04DA2E6A0365DCE", hash_generated_field = "84AEAB75604C7FBC0916DC2DDFA2924F")

        private int mNumCells;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "AA5E13FFEAC37665A0A31B62B2F782FE", hash_generated_field = "4298CFE393B84E2395510D4EDDD01514")

        private int mSelectedLeft = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_field = "1D3EADA04AEB61A86356B94F32DC8646", hash_generated_field = "47DB8CDE061685EA777E17F9CDE00FAF")

        private int mSelectedRight = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.170 -0400", hash_original_method = "FA7001D4C667668E5D1235594C9A8E32", hash_generated_method = "DC92DD162E494359C77A1EA2B4FA82D5")
        public  WeekView(Context context) {
            super(context);
            mHeight = (mListView.getHeight() - mListView.getPaddingTop() - mListView
                    .getPaddingBottom()) / mShownWeekCount;
            setPaintProperties();
            addTaint(context.getTaint());
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.172 -0400", hash_original_method = "27089ACBC4590C27BA2DDE1963872C77", hash_generated_method = "2252B02239E39C33B388E1F5702DAD2C")
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
            {
                mDayNumbers[0] = Integer.toString(mTempDate.get(Calendar.WEEK_OF_YEAR));
            } 
            int diff = mFirstDayOfWeek - mTempDate.get(Calendar.DAY_OF_WEEK);
            mTempDate.add(Calendar.DAY_OF_MONTH, diff);
            mFirstDay = (Calendar) mTempDate.clone();
            mMonthOfFirstWeekDay = mTempDate.get(Calendar.MONTH);
            {
                mFocusDay[i] = (mTempDate.get(Calendar.MONTH) == focusedMonth);
                {
                    boolean varA4C78B059CEDEB9FC682C10660E5AFEC_563448149 = (mTempDate.before(mMinDate) || mTempDate.after(mMaxDate));
                    {
                        mDayNumbers[i] = "";
                    } 
                    {
                        mDayNumbers[i] = Integer.toString(mTempDate.get(Calendar.DAY_OF_MONTH));
                    } 
                } 
                mTempDate.add(Calendar.DAY_OF_MONTH, 1);
            } 
            {
                boolean varB636F6DD6694AE5DF7206E7A350EAAF0_292059637 = (mTempDate.get(Calendar.DAY_OF_MONTH) == 1);
                {
                    mTempDate.add(Calendar.DAY_OF_MONTH, -1);
                } 
            } 
            mLastWeekDayMonth = mTempDate.get(Calendar.MONTH);
            updateSelectionPositions();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.173 -0400", hash_original_method = "FEF07EDEB83DCD7D850BA0B7A04A7856", hash_generated_method = "0EDF79AFD422A561AEFB941B8564204D")
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
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.173 -0400", hash_original_method = "132ACA3161A5E95F30BDE89FA7E699D9", hash_generated_method = "A89873444003FC6DBEAE117DFCBB2D9C")
        public int getMonthOfFirstWeekDay() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647800946 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647800946;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.174 -0400", hash_original_method = "CD3B8D9B4D0AF03A28010706DE17FBAB", hash_generated_method = "39FA7200C2D3B3DB139831884BEC9A65")
        public int getMonthOfLastWeekDay() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592512097 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592512097;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.174 -0400", hash_original_method = "58CF666CFDF77BB5B426C92097C0AA79", hash_generated_method = "3BD23AE45796CBB8051A9DD15B8F2B52")
        public Calendar getFirstDay() {
            Calendar varB4EAC82CA7396A68D541C85D26508E83_1591849630 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1591849630 = mFirstDay;
            varB4EAC82CA7396A68D541C85D26508E83_1591849630.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1591849630;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.174 -0400", hash_original_method = "967438ECCB56B80859C1A92A3366B466", hash_generated_method = "F75FD2123AFA3E7E43494A515898431F")
        public boolean getDayFromLocation(float x, Calendar outCalendar) {
            int dayStart;
            dayStart = mWidth / mNumCells;
            dayStart = 0;
            {
                outCalendar.clear();
            } 
            int dayPosition = (int) ((x - dayStart) * mDaysPerWeek
                    / (mWidth - dayStart));
            outCalendar.setTimeInMillis(mFirstDay.getTimeInMillis());
            outCalendar.add(Calendar.DAY_OF_MONTH, dayPosition);
            addTaint(x);
            addTaint(outCalendar.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101191509 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101191509;
            
            
            
                
                
            
            
                    
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.175 -0400", hash_original_method = "2CF8C160EAF6EF1682AC691B4F4CBC56", hash_generated_method = "43DD5C7F82CC8E31B77ADF7E1E8655F4")
        @Override
        protected void onDraw(Canvas canvas) {
            
            drawBackground(canvas);
            drawWeekNumbers(canvas);
            drawWeekSeparators(canvas);
            drawSelectedDateVerticalBars(canvas);
            addTaint(canvas.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.175 -0400", hash_original_method = "86B2559C98404D7EBD9D2D1A57D5B7B9", hash_generated_method = "EC9EE7FC0B6B1427101D53071CB4FDAE")
        private void drawBackground(Canvas canvas) {
            mDrawPaint.setColor(mSelectedWeekBackgroundColor);
            mTempRect.top = mWeekSeperatorLineWidth;
            mTempRect.bottom = mHeight;
            mTempRect.left = mShowWeekNumber ? mWidth / mNumCells : 0;
            mTempRect.right = mSelectedLeft - 2;
            canvas.drawRect(mTempRect, mDrawPaint);
            mTempRect.left = mSelectedRight + 3;
            mTempRect.right = mWidth;
            canvas.drawRect(mTempRect, mDrawPaint);
            addTaint(canvas.getTaint());
            
            
                
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.176 -0400", hash_original_method = "D3ED4C16A7F0A5B2E5F9E818EC82B4AE", hash_generated_method = "3FF9A645E87BEB2C527C5A7210526B9A")
        private void drawWeekNumbers(Canvas canvas) {
            float textHeight = mDrawPaint.getTextSize();
            int y = (int) ((mHeight + textHeight) / 2) - mWeekSeperatorLineWidth;
            int nDays = mNumCells;
            mDrawPaint.setTextAlign(Align.CENTER);
            int i = 0;
            int divisor = 2 * nDays;
            {
                mDrawPaint.setColor(mWeekNumberColor);
                int x = mWidth / divisor;
                canvas.drawText(mDayNumbers[0], x, y, mDrawPaint);
            } 
            {
                mMonthNumDrawPaint.setColor(mFocusDay[i] ? mFocusedMonthDateColor
                        : mUnfocusedMonthDateColor);
                int x = (2 * i + 1) * mWidth / divisor;
                canvas.drawText(mDayNumbers[i], x, y, mMonthNumDrawPaint);
            } 
            addTaint(canvas.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.176 -0400", hash_original_method = "D028062BEA4F3ED75274534BCA9F109C", hash_generated_method = "B05C6AF9799A019630DAF44D04571FF5")
        private void drawWeekSeparators(Canvas canvas) {
            int firstFullyVisiblePosition = mListView.getFirstVisiblePosition();
            {
                boolean varBD978972D5D723FA8E099F9CC95E4825_1469725820 = (mListView.getChildAt(0).getTop() < 0);
            } 
            mDrawPaint.setColor(mWeekSeparatorLineColor);
            mDrawPaint.setStrokeWidth(mWeekSeperatorLineWidth);
            float x;
            x = mWidth / mNumCells;
            x = 0;
            canvas.drawLine(x, 0, mWidth, 0, mDrawPaint);
            addTaint(canvas.getTaint());
            
            
            
                
            
            
                
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.177 -0400", hash_original_method = "A1C98C2320B89AC1B0E9DE7623F0F5E4", hash_generated_method = "D36D39D991EC6874FB1179ABEB60CC32")
        private void drawSelectedDateVerticalBars(Canvas canvas) {
            mSelectedDateVerticalBar.setBounds(mSelectedLeft - mSelectedDateVerticalBarWidth / 2,
                    mWeekSeperatorLineWidth,
                    mSelectedLeft + mSelectedDateVerticalBarWidth / 2, mHeight);
            mSelectedDateVerticalBar.draw(canvas);
            mSelectedDateVerticalBar.setBounds(mSelectedRight - mSelectedDateVerticalBarWidth / 2,
                    mWeekSeperatorLineWidth,
                    mSelectedRight + mSelectedDateVerticalBarWidth / 2, mHeight);
            mSelectedDateVerticalBar.draw(canvas);
            addTaint(canvas.getTaint());
            
            
                
            
            
                    
                    
            
            
                    
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.177 -0400", hash_original_method = "07B6C7DD90A0E1B5FAECCFBA1208B086", hash_generated_method = "1972DAE3BCDF252B5E7725991B95831C")
        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            
            mWidth = w;
            updateSelectionPositions();
            addTaint(h);
            addTaint(oldw);
            addTaint(oldh);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.177 -0400", hash_original_method = "F4AE55BB3F9C613E7E5A646F02C33791", hash_generated_method = "D3AB0753C553EA5BEB2FF5D730785532")
        private void updateSelectionPositions() {
            {
                int selectedPosition = mSelectedDay - mFirstDayOfWeek;
                {
                    selectedPosition += 7;
                } 
                mSelectedLeft = selectedPosition * mWidth / mNumCells;
                mSelectedRight = (selectedPosition + 1) * mWidth / mNumCells;
            } 
            
            
                
                
                    
                
                
                    
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_method = "F89A4F4FAB6DC416DC0DD7077DC69E1C", hash_generated_method = "B106B2333717447AF45A115BEFE82AB6")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            
            setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mHeight);
            addTaint(widthMeasureSpec);
            addTaint(heightMeasureSpec);
            
            
        }

        
    }


    
    public interface OnDateChangeListener {

        
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "9D3BCF7D4519E93E9628DBE4424A7368", hash_generated_field = "8CE15FF28B44090045106C853EF2EE4B")

    private static final String LOG_TAG = CalendarView.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "AFDA9FAB15D7C033010EBA67D4668032", hash_generated_field = "646039AB554A3815E0298F000A3686C8")

    private static final boolean DEFAULT_SHOW_WEEK_NUMBER = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "75B2168E67F32942A7660EE332C31135", hash_generated_field = "0F74C92E99DEC02D7782C264F33AE8FB")

    private static final long MILLIS_IN_DAY = 86400000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "E73E3F6BACE835190EB51D4284D4F12F", hash_generated_field = "5885B11EDA0655E178ED35E9A995148D")

    private static final int DAYS_PER_WEEK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "3E4652C159428BF86522F98B26713746", hash_generated_field = "165EEE05425CB47749F5037764F4A7D3")

    private static final long MILLIS_IN_WEEK = DAYS_PER_WEEK * MILLIS_IN_DAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "4B2AC5C58D3448E41283380DF77299BB", hash_generated_field = "2AA8DB968B5A86A728DD2A86DD1E7E93")

    private static final int SCROLL_HYST_WEEKS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "D8263D549687B4628B92BAE2BB05D39D", hash_generated_field = "6C834AEF89871A669CC43830D67C8C03")

    private static final int GOTO_SCROLL_DURATION = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "65291FF078235139EB25043B4C411CA6", hash_generated_field = "A674A9C559D7D2AC10E9248FA01CEAFA")

    private static final int ADJUSTMENT_SCROLL_DURATION = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "9126C0F569F8BFC4BBF915A9A40A38A4", hash_generated_field = "E9D815F505FCC787C9BD6CEF978C9ACB")

    private static final int SCROLL_CHANGE_DELAY = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "7D0AA228503FFF788A6CED655322E089", hash_generated_field = "92A4E472511D5AB0B2A3BE852088B3B7")

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "4F04DCD0A895B76C4E10897110A5FF1F", hash_generated_field = "A084D00EDEE1C51E7E64232271A08EA5")

    private static final String DEFAULT_MIN_DATE = "01/01/1900";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "74FBF6AD55305F912C4747F0851D9160", hash_generated_field = "F4B9230A9D1D80341565F8E78206D2EC")

    private static final String DEFAULT_MAX_DATE = "01/01/2100";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "DC5440C1DB9B69DE0E7FBAEBBF35CE8A", hash_generated_field = "4C736D69B6814393DDDF5CDEECB06D46")

    private static final int DEFAULT_SHOWN_WEEK_COUNT = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "08F8397780669F0148C5F4E72CD58D16", hash_generated_field = "496326F4CDD77EAC73CDD5295D2BE7A2")

    private static final int DEFAULT_DATE_TEXT_SIZE = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "181CB101E5C05308B5D55B88B0936114", hash_generated_field = "3A418335293EF12B3DA3F4FDB05879C9")

    private static final int UNSCALED_SELECTED_DATE_VERTICAL_BAR_WIDTH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "E2F5CCF7BD4DCAA6357FE33CE58250D9", hash_generated_field = "E66AB956C44089E58FD61F5676B647D8")

    private static final int UNSCALED_WEEK_MIN_VISIBLE_HEIGHT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "1D6B554C3C6BCE4E3706D02C1803AE0D", hash_generated_field = "1FBE9A9D01B5A713E1CD35B977F46262")

    private static final int UNSCALED_LIST_SCROLL_TOP_OFFSET = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "D78F4B563158048112FA3DDCAA2E7A0A", hash_generated_field = "98241598EE1C58C44C51B6E4E37BFA7A")

    private static final int UNSCALED_BOTTOM_BUFFER = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "DB767308D105578E5E82E56B7F0DC432", hash_generated_field = "2E33FBCAB992F6A4FCF51C7E08C43011")

    private static final int UNSCALED_WEEK_SEPARATOR_LINE_WIDTH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.178 -0400", hash_original_field = "D5F646191AC5848A917A9A89EEED7A43", hash_generated_field = "F0ACF1E44F55CCE1B401D0863B7C0AC8")

    private static final int DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID = -1;
}

