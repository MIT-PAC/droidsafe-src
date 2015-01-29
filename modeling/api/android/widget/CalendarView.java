package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.880 -0500", hash_original_field = "5F136E3C34A69A50E2AE284AED194731", hash_generated_field = "8CE15FF28B44090045106C853EF2EE4B")

    private static final String LOG_TAG = CalendarView.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.882 -0500", hash_original_field = "5BD171322F90A62C6A7389DACF6A11E0", hash_generated_field = "646039AB554A3815E0298F000A3686C8")

    private static final boolean DEFAULT_SHOW_WEEK_NUMBER = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.885 -0500", hash_original_field = "E6D7F67D39F0CB55E79495D9914EBF4C", hash_generated_field = "0F74C92E99DEC02D7782C264F33AE8FB")

    private static final long MILLIS_IN_DAY = 86400000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.887 -0500", hash_original_field = "CE3E10BC008E9606E9FED7C8B649E2CB", hash_generated_field = "5885B11EDA0655E178ED35E9A995148D")

    private static final int DAYS_PER_WEEK = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.890 -0500", hash_original_field = "DABB65FDBDD65D122A9345DB4CF26654", hash_generated_field = "165EEE05425CB47749F5037764F4A7D3")

    private static final long MILLIS_IN_WEEK = DAYS_PER_WEEK * MILLIS_IN_DAY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.893 -0500", hash_original_field = "DDF7F3AE697826E33220807D1C5438DE", hash_generated_field = "2AA8DB968B5A86A728DD2A86DD1E7E93")

    private static final int SCROLL_HYST_WEEKS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.895 -0500", hash_original_field = "C81B4187925C70C0A17F828DE6FF2028", hash_generated_field = "6C834AEF89871A669CC43830D67C8C03")

    private static final int GOTO_SCROLL_DURATION = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.898 -0500", hash_original_field = "9135A4BB86ADD8566FF9167B5296887C", hash_generated_field = "A674A9C559D7D2AC10E9248FA01CEAFA")

    private static final int ADJUSTMENT_SCROLL_DURATION = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.900 -0500", hash_original_field = "52E2B0A54E2C6AC9B1FB1B5FFDFD64A1", hash_generated_field = "E9D815F505FCC787C9BD6CEF978C9ACB")

    private static final int SCROLL_CHANGE_DELAY = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.902 -0500", hash_original_field = "4A21EFC12B8A7D00AD012663E0282367", hash_generated_field = "92A4E472511D5AB0B2A3BE852088B3B7")

    private static final String DATE_FORMAT = "MM/dd/yyyy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.905 -0500", hash_original_field = "543CF1E6A7EEA9EDF21B56345AADD014", hash_generated_field = "A084D00EDEE1C51E7E64232271A08EA5")

    private static final String DEFAULT_MIN_DATE = "01/01/1900";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.907 -0500", hash_original_field = "13CCD677C53A3D60CEA8B7933B9E5B27", hash_generated_field = "F4B9230A9D1D80341565F8E78206D2EC")

    private static final String DEFAULT_MAX_DATE = "01/01/2100";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.909 -0500", hash_original_field = "7D404E91DF51B0B164B74EEF8EE01547", hash_generated_field = "4C736D69B6814393DDDF5CDEECB06D46")

    private static final int DEFAULT_SHOWN_WEEK_COUNT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.911 -0500", hash_original_field = "3E5F362BD4592B949DA8BE02866E2B8D", hash_generated_field = "496326F4CDD77EAC73CDD5295D2BE7A2")

    private static final int DEFAULT_DATE_TEXT_SIZE = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.914 -0500", hash_original_field = "DBFCCFE2AEBC41E24A5FBB0E4D0E7352", hash_generated_field = "3A418335293EF12B3DA3F4FDB05879C9")

    private static final int UNSCALED_SELECTED_DATE_VERTICAL_BAR_WIDTH = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.916 -0500", hash_original_field = "CC19208AE76845899CEEF986579809DB", hash_generated_field = "E66AB956C44089E58FD61F5676B647D8")

    private static final int UNSCALED_WEEK_MIN_VISIBLE_HEIGHT = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.919 -0500", hash_original_field = "647BEC428C05E13CE0A2E0FF8BEC8985", hash_generated_field = "1FBE9A9D01B5A713E1CD35B977F46262")

    private static final int UNSCALED_LIST_SCROLL_TOP_OFFSET = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.921 -0500", hash_original_field = "27D31B4C9B0F0B410093CDDE914C76E3", hash_generated_field = "98241598EE1C58C44C51B6E4E37BFA7A")

    private static final int UNSCALED_BOTTOM_BUFFER = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.924 -0500", hash_original_field = "2B6586B166801FCCCA6707777E82440A", hash_generated_field = "2E33FBCAB992F6A4FCF51C7E08C43011")

    private static final int UNSCALED_WEEK_SEPARATOR_LINE_WIDTH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.926 -0500", hash_original_field = "B2AA03855A96812C25C970417D5F83B5", hash_generated_field = "F0ACF1E44F55CCE1B401D0863B7C0AC8")

    private static final int DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.928 -0500", hash_original_field = "7F368DA5079641767B57AFB4C5C5E6EC", hash_generated_field = "8B23991BED629DDCFDA8E1DD88120AF5")

    private  int mWeekSeperatorLineWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.931 -0500", hash_original_field = "B5937C1D70C0C1CA339A5169E91A4E68", hash_generated_field = "3897E934AACB2D4B5C6B0C16CCB429A0")

    private  int mDateTextSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.933 -0500", hash_original_field = "7E1F915EE5D517F9A5F697F3B54BF4A9", hash_generated_field = "A59A89A5D83C758D66546FEAE58F54D4")

    private  Drawable mSelectedDateVerticalBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.935 -0500", hash_original_field = "9F0A2C050440FADBEA0D94BF069801E4", hash_generated_field = "2C1B7E5AE5693E0A43249D97A45D63E8")

    private  int mSelectedDateVerticalBarWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.937 -0500", hash_original_field = "7FF554901F47BA5D94A53115E895738A", hash_generated_field = "74B6E0C11198E97BD97CA4756AB27759")

    private  int mSelectedWeekBackgroundColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.941 -0500", hash_original_field = "D2F0733E9CD59EF7BE50B934F7A5131A", hash_generated_field = "A9584354BACE2D8F069618758B081B06")

    private  int mFocusedMonthDateColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.943 -0500", hash_original_field = "EEF9F5EE66744844988286DFC6F60F54", hash_generated_field = "7D2BE4C5D269E856747B17281912BE9C")

    private  int mUnfocusedMonthDateColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.946 -0500", hash_original_field = "86BF37BC7BCF670871E8DE76450BE493", hash_generated_field = "8DDBF4CBD718C3948A0F42D2C1DB5D99")

    private  int mWeekSeparatorLineColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.949 -0500", hash_original_field = "71DB8044101EA8BD2D4A5F10155B3BE9", hash_generated_field = "6A25546F44B6068A62792DA64248742A")

    private  int mWeekNumberColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.951 -0500", hash_original_field = "F47218C170AA21D704104F97067F4CD3", hash_generated_field = "5665B7B8CC3DF642A1DAF00F3DE77EFA")

    private int mListScrollTopOffset = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.953 -0500", hash_original_field = "4E0A25921A028E9B40ABFF13921C0183", hash_generated_field = "D65BAA41D805492896870D587D162209")

    private int mWeekMinVisibleHeight = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.955 -0500", hash_original_field = "427C6C58F4CE497B6C552537439B4FF1", hash_generated_field = "5FC459B021EAF2699021DD8B9B1D6C2B")

    private int mBottomBuffer = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.957 -0500", hash_original_field = "22683A3B664CC0D7B59EC4719249018C", hash_generated_field = "6CB09EC87311D40CB9B77369F5C620A1")

    private int mShownWeekCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.959 -0500", hash_original_field = "9DE37C7706A8AD21BAD61B5361C9AE58", hash_generated_field = "0A0881CE0345FE41D9B257D56D8D82CA")

    private boolean mShowWeekNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.961 -0500", hash_original_field = "372463B20CA4908B539BAA366DBA6E11", hash_generated_field = "0792CCA61E447A5A7FB7126E5ABF29EC")

    private int mDaysPerWeek = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.963 -0500", hash_original_field = "3849CAADAA85CA2279F9C45E2440F55A", hash_generated_field = "78A6141C2BBA378820D9128DA7F22F8D")

    private float mFriction = .05f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.966 -0500", hash_original_field = "6A5AFC16EC5F92222C089B5C3CDE53F8", hash_generated_field = "E3AADF3834C4F3228039B1ED679BE2BE")

    private float mVelocityScale = 0.333f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.968 -0500", hash_original_field = "FB770D56B9E0F1EB37F9B7745DB59C31", hash_generated_field = "C5ED7BC1BF12E15BC029B4E0815E71E3")

    private WeeksAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.970 -0500", hash_original_field = "564994122F8B404810DDCD714146F030", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.972 -0500", hash_original_field = "097CCFF08894D0F42297A25AFB590EAF", hash_generated_field = "3BCC597FF6F62DFD9F809924D1A9B7CC")

    private TextView mMonthName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.974 -0500", hash_original_field = "5EE5E878725E0992F5784A273EFDB90A", hash_generated_field = "E95A3921B8AB382181ED602DFBF5F267")

    private ViewGroup mDayNamesHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.976 -0500", hash_original_field = "5548D14828675ACCF43A9D0B99EBC6F6", hash_generated_field = "59E44C9DFCE7DBB845766E4E65180588")

    private String[] mDayLabels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.978 -0500", hash_original_field = "4D423895C8AD92745DD85C75D5AE7F1E", hash_generated_field = "30452844013892C49D8827DAE1E459DE")

    private int mFirstDayOfWeek;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.981 -0500", hash_original_field = "864C6DE2608C2D9B803D3DA55BC5B006", hash_generated_field = "41289D9BED76260F340EB785FCC2056A")

    private int mCurrentMonthDisplayed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.983 -0500", hash_original_field = "77F426D888DDCA713E97C8121A094556", hash_generated_field = "A32E25FFB7BC22A215A1EAB2F45C9CD4")

    private long mPreviousScrollPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.985 -0500", hash_original_field = "95A2BD81B991645829368DE83301E532", hash_generated_field = "5B9F7E9646034BCC8F83298FA039B637")

    private boolean mIsScrollingUp = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.988 -0500", hash_original_field = "C1547261DFA2D3DD06106C2329741A83", hash_generated_field = "F3024B0C881FFDC3012F965272357A8A")

    private int mPreviousScrollState = OnScrollListener.SCROLL_STATE_IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.990 -0500", hash_original_field = "8B2A34A6237EAA1FB690F76F3B158C20", hash_generated_field = "328AD7D92706C021C1C22127BE75612C")

    private int mCurrentScrollState = OnScrollListener.SCROLL_STATE_IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.992 -0500", hash_original_field = "09EFFE80971DFB8BE4C5512F92399439", hash_generated_field = "05EE47F5BF2CAC4310C2BEEFD3D65AE0")

    private OnDateChangeListener mOnDateChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.995 -0500", hash_original_field = "18D447DB1A18457CC08D447B5635FE7F", hash_generated_field = "2729908D3AF534B2F645E718D75BC4E8")

    private ScrollStateRunnable mScrollStateChangedRunnable = new ScrollStateRunnable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.997 -0500", hash_original_field = "83B9DD6E7508BD94D813D2BBAE835A2C", hash_generated_field = "915400C77BD703DACB8E97CD72BFFD5E")

    private Calendar mTempDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:41.999 -0500", hash_original_field = "48B33391F4500730B6E5C3D6E7E6DBD8", hash_generated_field = "D29AF2C549B988F84E81471C8F4DFA25")

    private Calendar mFirstDayOfMonth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.001 -0500", hash_original_field = "3DB37928D9BCCB809A9FC162964B0E42", hash_generated_field = "681C6D172B5A021A54543F6E6ED5BD03")

    private Calendar mMinDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.003 -0500", hash_original_field = "E3F10F4404115CF847283246E14AF324", hash_generated_field = "4C58BCC5BEA466149D70675257F2009F")

    private Calendar mMaxDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.006 -0500", hash_original_field = "14347A98AF9CE70FD1B6F60D5AA3ADC1", hash_generated_field = "B406C1F86E2B5C90127E71BBD6EC950B")

    private final java.text.DateFormat mDateFormat = new SimpleDateFormat(DATE_FORMAT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.008 -0500", hash_original_field = "0400C5C553DC4CBF37271C21855854A7", hash_generated_field = "88175FFB524B6CC60F82A34D8C4EC643")

    private Locale mCurrentLocale;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.013 -0500", hash_original_method = "52384FB40509E71BA2451D4915E5D413", hash_generated_method = "D92C0D13DD14AA039D389307D686CE10")
    
public CalendarView(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.016 -0500", hash_original_method = "79D5762FBD0B1A46CF2745AED4E3FAD9", hash_generated_method = "DEB888F78800DDEBF0847FD965B6D45B")
    
public CalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.021 -0500", hash_original_method = "B881CA40E8482968634BC9086836F338", hash_generated_method = "D2E54F84E88D0B00B462C87EBAFB569E")
    
public CalendarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, 0);

        // initialization based on locale
        setCurrentLocale(Locale.getDefault());

        TypedArray attributesArray = context.obtainStyledAttributes(attrs, R.styleable.CalendarView,
                R.attr.calendarViewStyle, 0);
        mShowWeekNumber = attributesArray.getBoolean(R.styleable.CalendarView_showWeekNumber,
                DEFAULT_SHOW_WEEK_NUMBER);
        mFirstDayOfWeek = attributesArray.getInt(R.styleable.CalendarView_firstDayOfWeek,
                LocaleData.get(Locale.getDefault()).firstDayOfWeek);
        String minDate = attributesArray.getString(R.styleable.CalendarView_minDate);
        if (TextUtils.isEmpty(minDate) || !parseDate(minDate, mMinDate)) {
            parseDate(DEFAULT_MIN_DATE, mMinDate);
        }
        String maxDate = attributesArray.getString(R.styleable.CalendarView_maxDate);
        if (TextUtils.isEmpty(maxDate) || !parseDate(maxDate, mMaxDate)) {
            parseDate(DEFAULT_MAX_DATE, mMaxDate);
        }
        if (mMaxDate.before(mMinDate)) {
            throw new IllegalArgumentException("Max date cannot be before min date.");
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

        int dateTextAppearanceResId= attributesArray.getResourceId(
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

        // go to today or whichever is close to today min or max date
        mTempDate.setTimeInMillis(System.currentTimeMillis());
        if (mTempDate.before(mMinDate)) {
            goTo(mMinDate, false, true, true);
        } else if (mMaxDate.before(mTempDate)) {
            goTo(mMaxDate, false, true, true);
        } else {
            goTo(mTempDate, false, true, true);
        }

        invalidate();
    }

    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.024 -0500", hash_original_method = "1D9E2CC40134FA188645AC8C7A8FADC7", hash_generated_method = "61E305833BB432899A9B803A8835CCD1")
    
@Override
    public void setEnabled(boolean enabled) {
        mListView.setEnabled(enabled);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.026 -0500", hash_original_method = "93B4809DF8FBD1AECB02AFF6547691F9", hash_generated_method = "E3F8EC8548C465830E0A8D0A5727ECFD")
    
@Override
    public boolean isEnabled() {
        return mListView.isEnabled();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.028 -0500", hash_original_method = "C452430AEDBDDD78DF8F4D12B9175E89", hash_generated_method = "6328851CBC85DA1645204E969B0A309A")
    
@Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
    }

    /**
     * Gets the minimal date supported by this {@link CalendarView} in milliseconds
     * since January 1, 1970 00:00:00 in {@link TimeZone#getDefault()} time
     * zone.
     * <p>
     * Note: The default minimal date is 01/01/1900.
     * <p>
     *
     * @return The minimal supported date.
     */
    @DSSource({DSSourceKind.CALENDAR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.030 -0500", hash_original_method = "967B291ED0BCED68F7E3E5A0CEF03695", hash_generated_method = "6734926BF8983D647D6BC30605DCDB84")
    
public long getMinDate() {
        return mMinDate.getTimeInMillis();
    }

    /**
     * Sets the minimal date supported by this {@link CalendarView} in milliseconds
     * since January 1, 1970 00:00:00 in {@link TimeZone#getDefault()} time
     * zone.
     *
     * @param minDate The minimal supported date.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.033 -0500", hash_original_method = "FF5386D03D60B1076A84367A6FF3DA28", hash_generated_method = "0CA393BF01715101B3C44C1134F1E962")
    
public void setMinDate(long minDate) {
        mTempDate.setTimeInMillis(minDate);
        if (isSameDate(mTempDate, mMinDate)) {
            return;
        }
        mMinDate.setTimeInMillis(minDate);
        // make sure the current date is not earlier than
        // the new min date since the latter is used for
        // calculating the indices in the adapter thus
        // avoiding out of bounds error
        Calendar date = mAdapter.mSelectedDate;
        if (date.before(mMinDate)) {
            mAdapter.setSelectedDay(mMinDate);
        }
        // reinitialize the adapter since its range depends on min date
        mAdapter.init();
        if (date.before(mMinDate)) {
            setDate(mTempDate.getTimeInMillis());
        } else {
            // we go to the current date to force the ListView to query its
            // adapter for the shown views since we have changed the adapter
            // range and the base from which the later calculates item indices
            // note that calling setDate will not work since the date is the same
            goTo(date, false, true, false);
        }
    }

    /**
     * Gets the maximal date supported by this {@link CalendarView} in milliseconds
     * since January 1, 1970 00:00:00 in {@link TimeZone#getDefault()} time
     * zone.
     * <p>
     * Note: The default maximal date is 01/01/2100.
     * <p>
     *
     * @return The maximal supported date.
     */
    @DSSource({DSSourceKind.CALENDAR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.035 -0500", hash_original_method = "4B53E128D2B815FDD1432B3F6B079B5B", hash_generated_method = "E5060BEB16EBF1E8166F59AFB57105AB")
    
public long getMaxDate() {
        return mMaxDate.getTimeInMillis();
    }

    /**
     * Sets the maximal date supported by this {@link CalendarView} in milliseconds
     * since January 1, 1970 00:00:00 in {@link TimeZone#getDefault()} time
     * zone.
     *
     * @param maxDate The maximal supported date.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.037 -0500", hash_original_method = "A06814E3E9CB43249648A0F0C1DE0D5D", hash_generated_method = "55697005F4FEDCBCBFEF47B83D2827A6")
    
public void setMaxDate(long maxDate) {
        mTempDate.setTimeInMillis(maxDate);
        if (isSameDate(mTempDate, mMaxDate)) {
            return;
        }
        mMaxDate.setTimeInMillis(maxDate);
        // reinitialize the adapter since its range depends on max date
        mAdapter.init();
        Calendar date = mAdapter.mSelectedDate;
        if (date.after(mMaxDate)) {
            setDate(mMaxDate.getTimeInMillis());
        } else {
            // we go to the current date to force the ListView to query its
            // adapter for the shown views since we have changed the adapter
            // range and the base from which the later calculates item indices
            // note that calling setDate will not work since the date is the same
            goTo(date, false, true, false);
        }
    }
    
    private class ScrollStateRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.097 -0500", hash_original_field = "84D89183D5AC0191C04346FAAB7912B5", hash_generated_field = "1F3C2B019CE351B6A3F4C6C3616C5C0E")

        private AbsListView mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.099 -0500", hash_original_field = "7B41F7FE3ADEB3E998739116B4C5C65E", hash_generated_field = "B54F7897F242D86283E88CF300719E2B")

        private int mNewState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.910 -0400", hash_original_method = "F2F7D55B897550D0A526C19F647B806C", hash_generated_method = "F2F7D55B897550D0A526C19F647B806C")
        public ScrollStateRunnable ()
        {
            //Synthesized constructor
        }

        /**
         * Sets up the runnable with a short delay in case the scroll state
         * immediately changes again.
         *
         * @param view The list view that changed state
         * @param scrollState The new state it changed to
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.101 -0500", hash_original_method = "69E5B9D1AE0F98719D28BA5FB866EF08", hash_generated_method = "A719CB1DAF61DB1A4B554C51FA3707D4")
        
public void doScrollStateChange(AbsListView view, int scrollState) {
            mView = view;
            mNewState = scrollState;
            removeCallbacks(this);
            postDelayed(this, SCROLL_CHANGE_DELAY);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.105 -0500", hash_original_method = "62729E70BB0456A375600477CC5D2643", hash_generated_method = "9A5A45E1160235FD96591591BD17E761")
        
public void run() {
            mCurrentScrollState = mNewState;
            // Fix the position after a scroll or a fling ends
            if (mNewState == OnScrollListener.SCROLL_STATE_IDLE
                    && mPreviousScrollState != OnScrollListener.SCROLL_STATE_IDLE) {
                View child = mView.getChildAt(0);
                if (child == null) {
                    // The view is no longer visible, just return
                    return;
                }
                int dist = child.getBottom() - mListScrollTopOffset;
                if (dist > mListScrollTopOffset) {
                    if (mIsScrollingUp) {
                        mView.smoothScrollBy(dist - child.getHeight(), ADJUSTMENT_SCROLL_DURATION);
                    } else {
                        mView.smoothScrollBy(dist, ADJUSTMENT_SCROLL_DURATION);
                    }
                }
            }
            mPreviousScrollState = mNewState;
        }
        
    }
    
    private class WeeksAdapter extends BaseAdapter implements OnTouchListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.110 -0500", hash_original_field = "CC90443A38FE9DAA92F3BB4526322226", hash_generated_field = "5BF9B16DA16CA4B8867BE9E962493092")

        private int mSelectedWeek;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.112 -0500", hash_original_field = "AB20CE05616A647AECFCD053AA0A7A3C", hash_generated_field = "DA7C2146C29AB67A18FA4519D8BF6725")

        private GestureDetector mGestureDetector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.114 -0500", hash_original_field = "71D139026965143191C2B81C039091B4", hash_generated_field = "F72CF38F2566D6E733620DFADA8D38C7")

        private int mFocusedMonth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.116 -0500", hash_original_field = "0553D2F948679AE9A630CAADF59A790E", hash_generated_field = "95E30C29B97433E1CA9F533BA1A954C1")

        private final Calendar mSelectedDate = Calendar.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.118 -0500", hash_original_field = "0F859F8FABE2D4FD9A195DE85620F709", hash_generated_field = "740B29A5145E76BF427504A23D8A9471")

        private int mTotalWeekCount;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.121 -0500", hash_original_method = "A5340406393612546D90AF6654589F05", hash_generated_method = "8E410B1DD2634DD382F6F3FDBBAE9A6E")
        
public WeeksAdapter(Context context) {
            mContext = context;
            mGestureDetector = new GestureDetector(mContext, new CalendarGestureListener());
            init();
        }

        /**
         * Set up the gesture detector and selected time
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.123 -0500", hash_original_method = "155544AF4C95F51C95BCC140A715A96B", hash_generated_method = "EB8CB92FD797AFD7C2388D23B5D2A7C9")
        
private void init() {
            mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            mTotalWeekCount = getWeeksSinceMinDate(mMaxDate);
            if (mMinDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek
                || mMaxDate.get(Calendar.DAY_OF_WEEK) != mFirstDayOfWeek) {
                mTotalWeekCount++;
            }
        }

        /**
         * Updates the selected day and related parameters.
         *
         * @param selectedDay The time to highlight
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.126 -0500", hash_original_method = "D3DE83E2185E4ADE498D767CEB2FBE21", hash_generated_method = "EF998B721EE3434670F30C438825BA9D")
        
public void setSelectedDay(Calendar selectedDay) {
            if (selectedDay.get(Calendar.DAY_OF_YEAR) == mSelectedDate.get(Calendar.DAY_OF_YEAR)
                    && selectedDay.get(Calendar.YEAR) == mSelectedDate.get(Calendar.YEAR)) {
                return;
            }
            mSelectedDate.setTimeInMillis(selectedDay.getTimeInMillis());
            mSelectedWeek = getWeeksSinceMinDate(mSelectedDate);
            mFocusedMonth = mSelectedDate.get(Calendar.MONTH);
            notifyDataSetChanged();
        }

        /**
         * @return The selected day of month.
         */
        @DSSource({DSSourceKind.CALENDAR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.128 -0500", hash_original_method = "B5E95894B654555C190BA20C07877305", hash_generated_method = "739A34B9EED51934F039D48AA8C8863E")
        
public Calendar getSelectedDay() {
            return mSelectedDate;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.130 -0500", hash_original_method = "F04F5B9FBE7B2AAA41BE9F0558597E2D", hash_generated_method = "438C76CA078274D90EF9AA238DA13862")
        
@Override
        public int getCount() {
            return mTotalWeekCount;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.132 -0500", hash_original_method = "AE0D3BF5CEF608E0D2B9C47624E8B8EC", hash_generated_method = "5E5284BEBB44E47AB169D2002D85C125")
        
@Override
        public Object getItem(int position) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.135 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "82702E9A3501EE6841B2C5A334199C16")
        
@Override
        public long getItemId(int position) {
            return position;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.137 -0500", hash_original_method = "381E4A6A7165FC308D77C676467DC158", hash_generated_method = "93B5972012CD113CFA78BF5FC05A9452")
        
@Override
        public View getView(int position, View convertView, ViewGroup parent) {
            WeekView weekView = null;
            if (convertView != null) {
                weekView = (WeekView) convertView;
            } else {
                weekView = new WeekView(mContext);
                android.widget.AbsListView.LayoutParams params =
                    new android.widget.AbsListView.LayoutParams(LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);
                weekView.setLayoutParams(params);
                weekView.setClickable(true);
                weekView.setOnTouchListener(this);
            }

            int selectedWeekDay = (mSelectedWeek == position) ? mSelectedDate.get(
                    Calendar.DAY_OF_WEEK) : -1;
            weekView.init(position, selectedWeekDay, mFocusedMonth);

            return weekView;
        }

        /**
         * Changes which month is in focus and updates the view.
         *
         * @param month The month to show as in focus [0-11]
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.140 -0500", hash_original_method = "3E18205C8C59D0D94EAE40666647C4EA", hash_generated_method = "2C6E9DCF85A0C3C8ADAFE29C31A712D6")
        
public void setFocusMonth(int month) {
            if (mFocusedMonth == month) {
                return;
            }
            mFocusedMonth = month;
            notifyDataSetChanged();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.143 -0500", hash_original_method = "0A87811DE71587238059DB215F3C12EA", hash_generated_method = "E8135CD26A17A4FB994E046AF9B96372")
        
@Override
        public boolean onTouch(View v, MotionEvent event) {
            if (mListView.isEnabled() && mGestureDetector.onTouchEvent(event)) {
                WeekView weekView = (WeekView) v;
                // if we cannot find a day for the given location we are done
                if (!weekView.getDayFromLocation(event.getX(), mTempDate)) {
                    return true;
                }
                // it is possible that the touched day is outside the valid range
                // we draw whole weeks but range end can fall not on the week end
                if (mTempDate.before(mMinDate) || mTempDate.after(mMaxDate)) {
                    return true;
                }
                onDateTapped(mTempDate);
                return true;
            }
            return false;
        }

        /**
         * Maintains the same hour/min/sec but moves the day to the tapped day.
         *
         * @param day The day that was tapped
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.146 -0500", hash_original_method = "DDBBBC0FCC832A9812721416C01B8F28", hash_generated_method = "B97A0F074113796E0086F9E5E02A465D")
        
private void onDateTapped(Calendar day) {
            setSelectedDay(day);
            setMonthDisplayed(day);
        }
        
        class CalendarGestureListener extends GestureDetector.SimpleOnGestureListener {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.915 -0400", hash_original_method = "CB9AB034B294CB4BEC33AF8713B8812C", hash_generated_method = "CB9AB034B294CB4BEC33AF8713B8812C")
            public CalendarGestureListener ()
            {
                //Synthesized constructor
            }
            @DSSafe(DSCat.ANDROID_CALLBACK)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.149 -0500", hash_original_method = "685EB340645172BC9B4FCDA0078720CA", hash_generated_method = "416B77B32FB67A3E1CDBED860A7F24C6")
            
@Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
            
        }
        
    }
    
    private class WeekView extends View {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.156 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

        private final Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.158 -0500", hash_original_field = "946375A5AA83EE2844C7EFB7C4794B4B", hash_generated_field = "338ED8DD33B33701CE23F0F875140BFA")

        private final Paint mDrawPaint = new Paint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.160 -0500", hash_original_field = "A12D6927DB7AAA725129CCFA06DF3EAA", hash_generated_field = "B72452912A34FBA0455C9A4A9A3B5617")

        private final Paint mMonthNumDrawPaint = new Paint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.163 -0500", hash_original_field = "640385D602848CBAF46EE8EDEBE9CD34", hash_generated_field = "78D1BFA8C5AB20E3FA796AF37BFF531E")

        private String[] mDayNumbers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.165 -0500", hash_original_field = "D13BD92AB28E131D260EA86B44411C20", hash_generated_field = "952CF69DC05C27C042F9A535F18EABAA")

        private boolean[] mFocusDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.167 -0500", hash_original_field = "9BC3DFC09E9F2E7DF183CB2C479005CC", hash_generated_field = "BA0F23DA4A4FAB8F0FD3B66F58517BD2")

        private Calendar mFirstDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.171 -0500", hash_original_field = "60B9FE474956812E273546BEB943156F", hash_generated_field = "FB82DB14926CC1AA0BF7C4500B4879E0")

        private int mMonthOfFirstWeekDay = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.173 -0500", hash_original_field = "00F7597BBB0AD96B8B51051595D85EA2", hash_generated_field = "2E4EA70A3DFCC5BD9972525121790DF9")

        private int mLastWeekDayMonth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.175 -0500", hash_original_field = "9E0CE4701DE3D148048765CD38153D64", hash_generated_field = "93438C9E098AE9C8DA6FC890AF828C5D")

        // 1st, 1900
        private int mWeek = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.177 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.179 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.181 -0500", hash_original_field = "7E88A538F52505FF1F7813CA98F76717", hash_generated_field = "F079C68689F59A1F17CEAEF7A0E64F7E")

        private boolean mHasSelectedDay = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.183 -0500", hash_original_field = "C3ED3B7986BEED72537B443F86E7F7E4", hash_generated_field = "473DF409EEE7296C165945C249CB7F25")

        private int mSelectedDay = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.186 -0500", hash_original_field = "79C8D6D4E14A27CF01143E0376ED503E", hash_generated_field = "84AEAB75604C7FBC0916DC2DDFA2924F")

        private int mNumCells;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.188 -0500", hash_original_field = "D073B0B95FE9E3DD004776FF9CE0B9A5", hash_generated_field = "4298CFE393B84E2395510D4EDDD01514")

        private int mSelectedLeft = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.190 -0500", hash_original_field = "9E2035519D3C3A673A1C827CE381CCD2", hash_generated_field = "47DB8CDE061685EA777E17F9CDE00FAF")

        private int mSelectedRight = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.193 -0500", hash_original_method = "FA7001D4C667668E5D1235594C9A8E32", hash_generated_method = "FA3DAB0DC7FDBBCD01CF85C43FA733AC")
        
public WeekView(Context context) {
            super(context);

            mHeight = (mListView.getHeight() - mListView.getPaddingTop() - mListView
                    .getPaddingBottom()) / mShownWeekCount;

            // Sets up any standard paints that will be used
            setPaintProperties();
        }

        /**
         * Initializes this week view.
         *
         * @param weekNumber The number of the week this view represents. The
         *            week number is a zero based index of the weeks since
         *            {@link CalendarView#getMinDate()}.
         * @param selectedWeekDay The selected day of the week from 0 to 6, -1 if no
         *            selected day.
         * @param focusedMonth The month that is currently in focus i.e.
         *            highlighted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.196 -0500", hash_original_method = "27089ACBC4590C27BA2DDE1963872C77", hash_generated_method = "AB625640DE972AB98FA0B01D383A66F4")
        
public void init(int weekNumber, int selectedWeekDay, int focusedMonth) {
            mSelectedDay = selectedWeekDay;
            mHasSelectedDay = mSelectedDay != -1;
            mNumCells = mShowWeekNumber ? mDaysPerWeek + 1 : mDaysPerWeek;
            mWeek = weekNumber;
            mTempDate.setTimeInMillis(mMinDate.getTimeInMillis());

            mTempDate.add(Calendar.WEEK_OF_YEAR, mWeek);
            mTempDate.setFirstDayOfWeek(mFirstDayOfWeek);

            // Allocate space for caching the day numbers and focus values
            mDayNumbers = new String[mNumCells];
            mFocusDay = new boolean[mNumCells];

            // If we're showing the week number calculate it based on Monday
            int i = 0;
            if (mShowWeekNumber) {
                mDayNumbers[0] = Integer.toString(mTempDate.get(Calendar.WEEK_OF_YEAR));
                i++;
            }

            // Now adjust our starting day based on the start day of the week
            int diff = mFirstDayOfWeek - mTempDate.get(Calendar.DAY_OF_WEEK);
            mTempDate.add(Calendar.DAY_OF_MONTH, diff);

            mFirstDay = (Calendar) mTempDate.clone();
            mMonthOfFirstWeekDay = mTempDate.get(Calendar.MONTH);

            for (; i < mNumCells; i++) {
                mFocusDay[i] = (mTempDate.get(Calendar.MONTH) == focusedMonth);
                // do not draw dates outside the valid range to avoid user confusion
                if (mTempDate.before(mMinDate) || mTempDate.after(mMaxDate)) {
                    mDayNumbers[i] = "";
                } else {
                    mDayNumbers[i] = Integer.toString(mTempDate.get(Calendar.DAY_OF_MONTH));
                }
                mTempDate.add(Calendar.DAY_OF_MONTH, 1);
            }
            // We do one extra add at the end of the loop, if that pushed us to
            // new month undo it
            if (mTempDate.get(Calendar.DAY_OF_MONTH) == 1) {
                mTempDate.add(Calendar.DAY_OF_MONTH, -1);
            }
            mLastWeekDayMonth = mTempDate.get(Calendar.MONTH);

            updateSelectionPositions();
        }

        /**
         * Sets up the text and style properties for painting.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.199 -0500", hash_original_method = "FEF07EDEB83DCD7D850BA0B7A04A7856", hash_generated_method = "BDECB2CFACEA72F6C9EBD6D8ED457C75")
        
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

        /**
         * Returns the month of the first day in this week.
         *
         * @return The month the first day of this view is in.
         */
        @DSSource({DSSourceKind.CALENDAR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.201 -0500", hash_original_method = "132ACA3161A5E95F30BDE89FA7E699D9", hash_generated_method = "7B6C4B1ADFDF2C8DF8618B843E0B8BA4")
        
public int getMonthOfFirstWeekDay() {
            return mMonthOfFirstWeekDay;
        }

        /**
         * Returns the month of the last day in this week
         *
         * @return The month the last day of this view is in
         */
        @DSSource({DSSourceKind.CALENDAR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.203 -0500", hash_original_method = "CD3B8D9B4D0AF03A28010706DE17FBAB", hash_generated_method = "120C57C35D375E7A4AD5875E48287763")
        
public int getMonthOfLastWeekDay() {
            return mLastWeekDayMonth;
        }

        /**
         * Returns the first day in this view.
         *
         * @return The first day in the view.
         */
        @DSSource({DSSourceKind.CALENDAR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.205 -0500", hash_original_method = "58CF666CFDF77BB5B426C92097C0AA79", hash_generated_method = "8AEDB2B9678B564C11FA5D3B9011E488")
        
public Calendar getFirstDay() {
            return mFirstDay;
        }

        /**
         * Calculates the day that the given x position is in, accounting for
         * week number.
         *
         * @param x The x position of the touch event.
         * @return True if a day was found for the given location.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.209 -0500", hash_original_method = "967438ECCB56B80859C1A92A3366B466", hash_generated_method = "563C00D7FA3D53A79EB9C8A010CE0578")
        
public boolean getDayFromLocation(float x, Calendar outCalendar) {
            int dayStart = mShowWeekNumber ? mWidth / mNumCells : 0;
            if (x < dayStart || x > mWidth) {
                outCalendar.clear();
                return false;
            }
            // Selection is (x - start) / (pixels/day) == (x -s) * day / pixels
            int dayPosition = (int) ((x - dayStart) * mDaysPerWeek
                    / (mWidth - dayStart));
            outCalendar.setTimeInMillis(mFirstDay.getTimeInMillis());
            outCalendar.add(Calendar.DAY_OF_MONTH, dayPosition);
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.211 -0500", hash_original_method = "2CF8C160EAF6EF1682AC691B4F4CBC56", hash_generated_method = "4481A9629F2534BDE4C02B481494B78B")
        
@Override
        protected void onDraw(Canvas canvas) {
            drawBackground(canvas);
            drawWeekNumbers(canvas);
            drawWeekSeparators(canvas);
            drawSelectedDateVerticalBars(canvas);
        }

        /**
         * This draws the selection highlight if a day is selected in this week.
         *
         * @param canvas The canvas to draw on
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.214 -0500", hash_original_method = "86B2559C98404D7EBD9D2D1A57D5B7B9", hash_generated_method = "CB706EE37E1BF2169A5E7713F9657926")
        
private void drawBackground(Canvas canvas) {
            if (!mHasSelectedDay) {
                return;
            }
            mDrawPaint.setColor(mSelectedWeekBackgroundColor);

/*            mTempRect.top = mWeekSeperatorLineWidth;
            mTempRect.bottom = mHeight;
            mTempRect.left = mShowWeekNumber ? mWidth / mNumCells : 0;
            mTempRect.right = mSelectedLeft - 2;
            canvas.drawRect(mTempRect, mDrawPaint);

            mTempRect.left = mSelectedRight + 3;
            mTempRect.right = mWidth;
            canvas.drawRect(mTempRect, mDrawPaint);
*/
            canvas.addTaint(getTaintInt() + mDrawPaint.getTaintInt());
        }

        /**
         * Draws the week and month day numbers for this week.
         *
         * @param canvas The canvas to draw on
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.217 -0500", hash_original_method = "D3ED4C16A7F0A5B2E5F9E818EC82B4AE", hash_generated_method = "3EB1FEFC27F535A334632D3161FFF648")
        
private void drawWeekNumbers(Canvas canvas) {
            float textHeight = mDrawPaint.getTextSize();
            int y = (int) ((mHeight + textHeight) / 2) - mWeekSeperatorLineWidth;
            int nDays = mNumCells;

            mDrawPaint.setTextAlign(Align.CENTER);
            int i = 0;
            int divisor = 2 * nDays;
            if (mShowWeekNumber) {
                mDrawPaint.setColor(mWeekNumberColor);
                int x = mWidth / divisor;
                canvas.drawText(mDayNumbers[0], x, y, mDrawPaint);
                i++;
            }
            for (; i < nDays; i++) {
                mMonthNumDrawPaint.setColor(mFocusDay[i] ? mFocusedMonthDateColor
                        : mUnfocusedMonthDateColor);
                int x = (2 * i + 1) * mWidth / divisor;
                canvas.drawText(mDayNumbers[i], x, y, mMonthNumDrawPaint);
            }
        }

        /**
         * Draws a horizontal line for separating the weeks.
         *
         * @param canvas The canvas to draw on.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.219 -0500", hash_original_method = "D028062BEA4F3ED75274534BCA9F109C", hash_generated_method = "EECBD29BD1D9261E869A3233378493CE")
        
private void drawWeekSeparators(Canvas canvas) {
            // If it is the topmost fully visible child do not draw separator line
            int firstFullyVisiblePosition = mListView.getFirstVisiblePosition();
            if (mListView.getChildAt(0).getTop() < 0) {
                firstFullyVisiblePosition++;
            }
            if (firstFullyVisiblePosition == mWeek) {
                return;
            }
            mDrawPaint.setColor(mWeekSeparatorLineColor);
            mDrawPaint.setStrokeWidth(mWeekSeperatorLineWidth);
            float x = mShowWeekNumber ? mWidth / mNumCells : 0;
            canvas.drawLine(x, 0, mWidth, 0, mDrawPaint);
        }

        /**
         * Draws the selected date bars if this week has a selected day.
         *
         * @param canvas The canvas to draw on
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.221 -0500", hash_original_method = "A1C98C2320B89AC1B0E9DE7623F0F5E4", hash_generated_method = "3222F0813A737281DE33567DE387E01D")
        
private void drawSelectedDateVerticalBars(Canvas canvas) {
            if (!mHasSelectedDay) {
                return;
            }
            mSelectedDateVerticalBar.setBounds(mSelectedLeft - mSelectedDateVerticalBarWidth / 2,
                    mWeekSeperatorLineWidth,
                    mSelectedLeft + mSelectedDateVerticalBarWidth / 2, mHeight);
            mSelectedDateVerticalBar.draw(canvas);
            mSelectedDateVerticalBar.setBounds(mSelectedRight - mSelectedDateVerticalBarWidth / 2,
                    mWeekSeperatorLineWidth,
                    mSelectedRight + mSelectedDateVerticalBarWidth / 2, mHeight);
            mSelectedDateVerticalBar.draw(canvas);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.223 -0500", hash_original_method = "07B6C7DD90A0E1B5FAECCFBA1208B086", hash_generated_method = "8F83DBE840FA326FA5534D182C083B2B")
        
@Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mWidth = w;
            updateSelectionPositions();
        }

        /**
         * This calculates the positions for the selected day lines.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.226 -0500", hash_original_method = "F4AE55BB3F9C613E7E5A646F02C33791", hash_generated_method = "91BACA51039F1D751961763F63B04D92")
        
private void updateSelectionPositions() {
            if (mHasSelectedDay) {
                int selectedPosition = mSelectedDay - mFirstDayOfWeek;
                if (selectedPosition < 0) {
                    selectedPosition += 7;
                }
                if (mShowWeekNumber) {
                    selectedPosition++;
                }
                mSelectedLeft = selectedPosition * mWidth / mNumCells;
                mSelectedRight = (selectedPosition + 1) * mWidth / mNumCells;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.228 -0500", hash_original_method = "F89A4F4FAB6DC416DC0DD7077DC69E1C", hash_generated_method = "B7FBE230E6DFD7E8F20050D2649F118B")
        
@Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mHeight);
        }
        
    }
    
    public interface OnDateChangeListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth);
    }

    /**
     * Sets whether to show the week number.
     *
     * @param showWeekNumber True to show the week number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.039 -0500", hash_original_method = "F2BDD8F6BF1030E3F09A2B5F73B0EF93", hash_generated_method = "3471F6A5807D7593B5D9F5A88B909E5B")
    
public void setShowWeekNumber(boolean showWeekNumber) {
        if (mShowWeekNumber == showWeekNumber) {
            return;
        }
        mShowWeekNumber = showWeekNumber;
        mAdapter.notifyDataSetChanged();
        setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
    }

    /**
     * Gets whether to show the week number.
     *
     * @return True if showing the week number.
     */
    @DSSource({DSSourceKind.CALENDAR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.041 -0500", hash_original_method = "466B93651CABC20F69979D67C7EC6971", hash_generated_method = "DEBCA43DE40AE5AA3E93CB98D5FCCA55")
    
public boolean getShowWeekNumber() {
        return mShowWeekNumber;
    }

    /**
     * Gets the first day of week.
     *
     * @return The first day of the week conforming to the {@link CalendarView}
     *         APIs.
     * @see Calendar#MONDAY
     * @see Calendar#TUESDAY
     * @see Calendar#WEDNESDAY
     * @see Calendar#THURSDAY
     * @see Calendar#FRIDAY
     * @see Calendar#SATURDAY
     * @see Calendar#SUNDAY
     */
    @DSSource({DSSourceKind.CALENDAR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.043 -0500", hash_original_method = "13AE9B7D254FD4442860EE49493A72AE", hash_generated_method = "09B80B36285D088C093DCBE570293DA9")
    
public int getFirstDayOfWeek() {
        return mFirstDayOfWeek;
    }

    /**
     * Sets the first day of week.
     *
     * @param firstDayOfWeek The first day of the week conforming to the
     *            {@link CalendarView} APIs.
     * @see Calendar#MONDAY
     * @see Calendar#TUESDAY
     * @see Calendar#WEDNESDAY
     * @see Calendar#THURSDAY
     * @see Calendar#FRIDAY
     * @see Calendar#SATURDAY
     * @see Calendar#SUNDAY
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.045 -0500", hash_original_method = "631B1F3A15EE6F7D95BE757EDF5B5B91", hash_generated_method = "ED5779E3F3CB5CB181FB93B66FAC38A8")
    
public void setFirstDayOfWeek(int firstDayOfWeek) {
        if (mFirstDayOfWeek == firstDayOfWeek) {
            return;
        }
        mFirstDayOfWeek = firstDayOfWeek;
        mAdapter.init();
        mAdapter.notifyDataSetChanged();
        setUpHeader(DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID);
    }

    /**
     * Sets the listener to be notified upon selected date change.
     *
     * @param listener The listener to be notified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.047 -0500", hash_original_method = "2EC5480533B2BF54D56B2049BA7CA5D7", hash_generated_method = "760AF8D4280E51921BA03F1DD37302CA")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnDateChangeListener(OnDateChangeListener listener) {
        mOnDateChangeListener = listener;
        if (listener != null) {
            listener.onSelectedDayChange(this, DSUtils.FAKE_INT,
                    DSUtils.FAKE_INT, DSUtils.FAKE_INT);
        }
    }

    /**
     * Gets the selected date in milliseconds since January 1, 1970 00:00:00 in
     * {@link TimeZone#getDefault()} time zone.
     *
     * @return The selected date.
     */
    @DSComment("just calendar view")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.CALENDAR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.050 -0500", hash_original_method = "1C8908BABBBBE904441B712A0F71BAD8", hash_generated_method = "79AEBEC017161384AB6FF18EC851F2B0")
    
public long getDate() {
        return mAdapter.mSelectedDate.getTimeInMillis();
    }

    /**
     * Sets the selected date in milliseconds since January 1, 1970 00:00:00 in
     * {@link TimeZone#getDefault()} time zone.
     *
     * @param date The selected date.
     *
     * @throws IllegalArgumentException of the provided date is before the
     *        minimal or after the maximal date.
     *
     * @see #setDate(long, boolean, boolean)
     * @see #setMinDate(long)
     * @see #setMaxDate(long)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.052 -0500", hash_original_method = "D6F29E7F63D0C42CAD60620E4D2FC504", hash_generated_method = "67F63F051C489D8BDFA248BF789E172F")
    
public void setDate(long date) {
        setDate(date, false, false);
    }

    /**
     * Sets the selected date in milliseconds since January 1, 1970 00:00:00 in
     * {@link TimeZone#getDefault()} time zone.
     *
     * @param date The date.
     * @param animate Whether to animate the scroll to the current date.
     * @param center Whether to center the current date even if it is already visible.
     *
     * @throws IllegalArgumentException of the provided date is before the
     *        minimal or after the maximal date.
     *
     * @see #setMinDate(long)
     * @see #setMaxDate(long)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.054 -0500", hash_original_method = "7D056A885692AA64348F6515B99D8688", hash_generated_method = "E6D9A5BB464122C30397F13FAB60F0E4")
    
public void setDate(long date, boolean animate, boolean center) {
        mTempDate.setTimeInMillis(date);
        if (isSameDate(mTempDate, mAdapter.mSelectedDate)) {
            return;
        }
        goTo(mTempDate, animate, true, center);
    }

    /**
     * Sets the current locale.
     *
     * @param locale The current locale.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.057 -0500", hash_original_method = "4AE549580BCF2D6667C808ED8CCBDCDC", hash_generated_method = "9735E05A9064E240975103C93C06F8C6")
    
private void setCurrentLocale(Locale locale) {
        if (locale.equals(mCurrentLocale)) {
            return;
        }

        mCurrentLocale = locale;

        mTempDate = getCalendarForLocale(mTempDate, locale);
        mFirstDayOfMonth = getCalendarForLocale(mFirstDayOfMonth, locale);
        mMinDate = getCalendarForLocale(mMinDate, locale);
        mMaxDate = getCalendarForLocale(mMaxDate, locale);
    }

    /**
     * Gets a calendar for locale bootstrapped with the value of a given calendar.
     *
     * @param oldCalendar The old calendar.
     * @param locale The locale.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.059 -0500", hash_original_method = "FA738DF80665124C3A5E01ADC04827D9", hash_generated_method = "FF2C9EE6088D5A80898CD22EED43D339")
    
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
     * @return True if the <code>firstDate</code> is the same as the <code>
     * secondDate</code>.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.061 -0500", hash_original_method = "70DC9A9889795E848236506BBC0A481B", hash_generated_method = "E7F9F398761CDCEB482A29A969EB0716")
    
private boolean isSameDate(Calendar firstDate, Calendar secondDate) {
        return (firstDate.get(Calendar.DAY_OF_YEAR) == secondDate.get(Calendar.DAY_OF_YEAR)
                && firstDate.get(Calendar.YEAR) == secondDate.get(Calendar.YEAR));
    }

    /**
     * Creates a new adapter if necessary and sets up its parameters.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.067 -0500", hash_original_method = "513863F202D0E7C406F959CC7EBC2D43", hash_generated_method = "6EAA8B10AA012389EDFB6D2EB92E7CB7")
    
private void setUpAdapter() {
        if (mAdapter == null) {
            mAdapter = new WeeksAdapter(getContext());
            mAdapter.registerDataSetObserver(new DataSetObserver() {
                @DSSafe(DSCat.ANDROID_CALLBACK)
        @Override
                public void onChanged() {
                    if (mOnDateChangeListener != null) {
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

        // refresh the view with the new parameters
        mAdapter.notifyDataSetChanged();
    }

    /**
     * Sets up the strings to be used by the header.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.070 -0500", hash_original_method = "2BEB208CF4EFB41463E1218ACA7650C9", hash_generated_method = "381190A899EE4B402200707598F9B96C")
    
private void setUpHeader(int weekDayTextAppearanceResId) {
        mDayLabels = new String[mDaysPerWeek];
        for (int i = mFirstDayOfWeek, count = mFirstDayOfWeek + mDaysPerWeek; i < count; i++) {
            int calendarDay = (i > Calendar.SATURDAY) ? i - Calendar.SATURDAY : i;
            mDayLabels[i - mFirstDayOfWeek] = DateUtils.getDayOfWeekString(calendarDay,
                    DateUtils.LENGTH_SHORTEST);
        }

        TextView label = (TextView) mDayNamesHeader.getChildAt(0);
        if (mShowWeekNumber) {
            label.setVisibility(View.VISIBLE);
        } else {
            label.setVisibility(View.GONE);
        }
        for (int i = 1, count = mDayNamesHeader.getChildCount(); i < count; i++) {
            label = (TextView) mDayNamesHeader.getChildAt(i);
            if (weekDayTextAppearanceResId > -1) {
                label.setTextAppearance(mContext, weekDayTextAppearanceResId);
            }
            if (i < mDaysPerWeek + 1) {
                label.setText(mDayLabels[i - 1]);
                label.setVisibility(View.VISIBLE);
            } else {
                label.setVisibility(View.GONE);
            }
        }
        mDayNamesHeader.invalidate();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.900 -0400", hash_original_method = "CFADBCF95F8E177F25E22F1FC2115F77", hash_generated_method = "A7212EABDEC78C4670A7D51B166BE4DD")
    private void setUpListView() {
        mListView.setDivider(null);
        mListView.setItemsCanFocus(true);
        mListView.setVerticalScrollBarEnabled(false);
        mListView.setOnScrollListener(new OnScrollListener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.074 -0500", hash_original_method = "00F32D753053A861AE7DBFD213079352", hash_generated_method = "09B9E0EE9959A555DB418AB23BCF25F4")
            
public void onScrollStateChanged(AbsListView view, int scrollState) {
                CalendarView.this.onScrollStateChanged(view, scrollState);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.076 -0500", hash_original_method = "E68786505B378D9C994B2BFCAEDF7B06", hash_generated_method = "E47F08E2B49B8EE38D547025E80E3CC1")
            
public void onScroll(
                    AbsListView view, int firstVisibleItem, int visibleItemCount,
                    int totalItemCount) {
                CalendarView.this.onScroll(view, firstVisibleItem, visibleItemCount,
                        totalItemCount);
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

    /**
     * This moves to the specified time in the view. If the time is not already
     * in range it will move the list so that the first of the month containing
     * the time is at the top of the view. If the new time is already in view
     * the list will not be scrolled unless forceScroll is true. This time may
     * optionally be highlighted as selected as well.
     *
     * @param date The time to move to.
     * @param animate Whether to scroll to the given time or just redraw at the
     *            new location.
     * @param setSelected Whether to set the given time as selected.
     * @param forceScroll Whether to recenter even if the time is already
     *            visible.
     *
     * @throws IllegalArgumentException of the provided date is before the
     *        range start of after the range end.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.081 -0500", hash_original_method = "9885B6A6E0E890A0EF52CBA474F609AF", hash_generated_method = "3502152145688A5D12E1A22A9194D0A2")
    
private void goTo(Calendar date, boolean animate, boolean setSelected, boolean forceScroll) {
        if (date.before(mMinDate) || date.after(mMaxDate)) {
            throw new IllegalArgumentException("Time not between " + mMinDate.getTime()
                    + " and " + mMaxDate.getTime());
        }
        // Find the first and last entirely visible weeks
        int firstFullyVisiblePosition = mListView.getFirstVisiblePosition();
        View firstChild = mListView.getChildAt(0);
        if (firstChild != null && firstChild.getTop() < 0) {
            firstFullyVisiblePosition++;
        }
        int lastFullyVisiblePosition = firstFullyVisiblePosition + mShownWeekCount - 1;
        if (firstChild != null && firstChild.getTop() > mBottomBuffer) {
            lastFullyVisiblePosition--;
        }
        if (setSelected) {
            mAdapter.setSelectedDay(date);
        }
        // Get the week we're going to
        int position = getWeeksSinceMinDate(date);

        // Check if the selected day is now outside of our visible range
        // and if so scroll to the month that contains it
        if (position < firstFullyVisiblePosition || position > lastFullyVisiblePosition
                || forceScroll) {
            mFirstDayOfMonth.setTimeInMillis(date.getTimeInMillis());
            mFirstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);

            setMonthDisplayed(mFirstDayOfMonth);

            // the earliest time we can scroll to is the min date
            if (mFirstDayOfMonth.before(mMinDate)) {
                position = 0;
            } else {
                position = getWeeksSinceMinDate(mFirstDayOfMonth);
            }

            mPreviousScrollState = OnScrollListener.SCROLL_STATE_FLING;
            if (animate) {
                mListView.smoothScrollToPositionFromTop(position, mListScrollTopOffset,
                        GOTO_SCROLL_DURATION);
            } else {
                mListView.setSelectionFromTop(position, mListScrollTopOffset);
                // Perform any after scroll operations that are needed
                onScrollStateChanged(mListView, OnScrollListener.SCROLL_STATE_IDLE);
            }
        } else if (setSelected) {
            // Otherwise just set the selection
            setMonthDisplayed(date);
        }
    }

    /**
     * Parses the given <code>date</code> and in case of success sets
     * the result to the <code>outDate</code>.
     *
     * @return True if the date was parsed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.084 -0500", hash_original_method = "4EF37BB5E8B6D289AE6D0021CE0D4FEB", hash_generated_method = "A8F56004CD8FCB6686C74FEBB9164E0E")
    
private boolean parseDate(String date, Calendar outDate) {
        try {
            outDate.setTime(mDateFormat.parse(date));
            return true;
        } catch (ParseException e) {
            Log.w(LOG_TAG, "Date: " + date + " not in format: " + DATE_FORMAT);
            return false;
        }
    }

    /**
     * Called when a <code>view</code> transitions to a new <code>scrollState
     * </code>.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.086 -0500", hash_original_method = "F153BBCA7962990A30E79BE6D90D9C30", hash_generated_method = "B4B4D8FE55139118C518ABC9FDD69D79")
    
private void onScrollStateChanged(AbsListView view, int scrollState) {
        mScrollStateChangedRunnable.doScrollStateChange(view, scrollState);
    }

    /**
     * Updates the title and selected month if the <code>view</code> has moved to a new
     * month.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.089 -0500", hash_original_method = "FE6404A8901B8111BDEFCBB086ABC460", hash_generated_method = "5A0105A9E88297E8B07404A58CFC02C3")
    
private void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        WeekView child = (WeekView) view.getChildAt(0);
        if (child == null) {
            return;
        }

        // Figure out where we are
        long currScroll = view.getFirstVisiblePosition() * child.getHeight() - child.getBottom();

        // If we have moved since our last call update the direction
        if (currScroll < mPreviousScrollPosition) {
            mIsScrollingUp = true;
        } else if (currScroll > mPreviousScrollPosition) {
            mIsScrollingUp = false;
        } else {
            return;
        }

        // Use some hysteresis for checking which month to highlight. This
        // causes the month to transition when two full weeks of a month are
        // visible when scrolling up, and when the first day in a month reaches
        // the top of the screen when scrolling down.
        int offset = child.getBottom() < mWeekMinVisibleHeight ? 1 : 0;
        if (mIsScrollingUp) {
            child = (WeekView) view.getChildAt(SCROLL_HYST_WEEKS + offset);
        } else if (offset != 0) {
            child = (WeekView) view.getChildAt(offset);
        }

        // Find out which month we're moving into
        int month;
        if (mIsScrollingUp) {
            month = child.getMonthOfFirstWeekDay();
        } else {
            month = child.getMonthOfLastWeekDay();
        }

        // And how it relates to our current highlighted month
        int monthDiff;
        if (mCurrentMonthDisplayed == 11 && month == 0) {
            monthDiff = 1;
        } else if (mCurrentMonthDisplayed == 0 && month == 11) {
            monthDiff = -1;
        } else {
            monthDiff = month - mCurrentMonthDisplayed;
        }

        // Only switch months if we're scrolling away from the currently
        // selected month
        if ((!mIsScrollingUp && monthDiff > 0) || (mIsScrollingUp && monthDiff < 0)) {
            Calendar firstDay = child.getFirstDay();
            if (mIsScrollingUp) {
                firstDay.add(Calendar.DAY_OF_MONTH, -DAYS_PER_WEEK);
            } else {
                firstDay.add(Calendar.DAY_OF_MONTH, DAYS_PER_WEEK);
            }
            setMonthDisplayed(firstDay);
        }
        mPreviousScrollPosition = currScroll;
        mPreviousScrollState = mCurrentScrollState;
    }

    /**
     * Sets the month displayed at the top of this view based on time. Override
     * to add custom events when the title is changed.
     *
     * @param calendar A day in the new focus month.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.091 -0500", hash_original_method = "2D87D8A121385B44A48D783AA9D15CB4", hash_generated_method = "93195447087440355F33B4D4CB0EA1D0")
    
private void setMonthDisplayed(Calendar calendar) {
        final int newMonthDisplayed = calendar.get(Calendar.MONTH);
        if (mCurrentMonthDisplayed != newMonthDisplayed) {
            mCurrentMonthDisplayed = newMonthDisplayed;
            mAdapter.setFocusMonth(mCurrentMonthDisplayed);
            final int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NO_MONTH_DAY
                    | DateUtils.FORMAT_SHOW_YEAR;
            final long millis = calendar.getTimeInMillis();
            String newMonthName = DateUtils.formatDateRange(mContext, millis, millis, flags);
            mMonthName.setText(newMonthName);
            mMonthName.invalidate();
        }
    }

    /**
     * @return Returns the number of weeks between the current <code>date</code>
     *         and the <code>mMinDate</code>.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:42.093 -0500", hash_original_method = "025B6CEC43A90DA392B09F9FACE78FF5", hash_generated_method = "A96011E69D8E2DC230550BE27027A1DA")
    
private int getWeeksSinceMinDate(Calendar date) {
        if (date.before(mMinDate)) {
            throw new IllegalArgumentException("fromDate: " + mMinDate.getTime()
                    + " does not precede toDate: " + date.getTime());
        }
        long endTimeMillis = date.getTimeInMillis()
                + date.getTimeZone().getOffset(date.getTimeInMillis());
        long startTimeMillis = mMinDate.getTimeInMillis()
                + mMinDate.getTimeZone().getOffset(mMinDate.getTimeInMillis());
        long dayOffsetMillis = (mMinDate.get(Calendar.DAY_OF_WEEK) - mFirstDayOfWeek)
                * MILLIS_IN_DAY;
        return (int) ((endTimeMillis - startTimeMillis + dayOffsetMillis) / MILLIS_IN_WEEK);
    }
}

