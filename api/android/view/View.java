package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

import android.app.ContextImpl;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.Property;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AdapterView;
import android.widget.ScrollBarDrawable;

import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.android.internal.view.InputConnectionWrapper;

public class View implements Drawable.Callback, Drawable.Callback2, KeyEvent.Callback, AccessibilityEventSource {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nonzero(float value){
		// Original method
		/*
		{
        return (value < -NONZERO_EPSILON || value > NONZERO_EPSILON);
    }
		*/
		return false;
	}
    
    protected static boolean isLayoutDirectionRtl(Locale locale){
		// Original method
		/*
		{
        return (LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE ==
                LocaleUtil.getLayoutDirectionFromLocale(locale));
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String printFlags(int flags){
		// Original method
		/*
		{
        String output = "";
        int numFlags = 0;
        if ((flags & FOCUSABLE_MASK) == FOCUSABLE) {
            output += "TAKES_FOCUS";
            numFlags++;
        }
        switch (flags & VISIBILITY_MASK) {
        case INVISIBLE:
            if (numFlags > 0) {
                output += " ";
            }
            output += "INVISIBLE";
            break;
        case GONE:
            if (numFlags > 0) {
                output += " ";
            }
            output += "GONE";
            break;
        default:
            break;
        }
        return output;
    }
		*/
		return "";
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String printPrivateFlags(int privateFlags){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return "";
	}
    
    protected static int[] mergeDrawableStates(int[] baseState, int[] additionalState){
		// Original method
		/*
		{
        final int N = baseState.length;
        int i = N - 1;
        while (i >= 0 && baseState[i] == 0) {
            i--;
        }
        System.arraycopy(additionalState, 0, baseState, i + 1, additionalState.length);
        return baseState;
    }
		*/
		return new int[1];
	}
    
    protected static String debugIndent(int depth){
		// Original method
		/*
		{
        StringBuilder spaces = new StringBuilder((depth * 2 + 3) * 2);
        for (int i = 0; i < (depth * 2) + 3; i++) {
            spaces.append(' ').append(' ');
        }
        return spaces.toString();
    }
		*/
		return "";
	}
    
    public static int combineMeasuredStates(int curState, int newState){
		// Original method
		/*
		{
        return curState | newState;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public static int resolveSize(int size, int measureSpec){
		// Original method
		/*
		{
        return resolveSizeAndState(size, measureSpec, 0) & MEASURED_SIZE_MASK;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState){
		// Original method
		/*
		{
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize =  MeasureSpec.getSize(measureSpec);
        switch (specMode) {
        case MeasureSpec.UNSPECIFIED:
            result = size;
            break;
        case MeasureSpec.AT_MOST:
            if (specSize < size) {
                result = specSize | MEASURED_STATE_TOO_SMALL;
            } else {
                result = size;
            }
            break;
        case MeasureSpec.EXACTLY:
            result = specSize;
            break;
        }
        return result | (childMeasuredState&MEASURED_STATE_MASK);
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public static int getDefaultSize(int size, int measureSpec){
		// Original method
		/*
		{
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
        case MeasureSpec.UNSPECIFIED:
            result = size;
            break;
        case MeasureSpec.AT_MOST:
        case MeasureSpec.EXACTLY:
            result = specSize;
            break;
        }
        return result;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public static View inflate(Context context, int resource, ViewGroup root){
		// Original method
		/*
		{
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, root);
    }
		*/
		return null;
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.965 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.968 -0500", hash_original_field = "3EBA19C0A98F44EF7C6E61736B047E6E", hash_generated_field = "728AEBF400875BC43623925282C27543")

    protected static final String VIEW_LOG_TAG = "View";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.971 -0500", hash_original_field = "BEB3544BF456B23E5F1F5575F3E93334", hash_generated_field = "181E1190C48C3A15B723E1972525FFE6")

    public static final int NO_ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.973 -0500", hash_original_field = "F4A6F0433709B0533DB2E3D65F37A5B3", hash_generated_field = "01F44804D4B2E5BAA321A3D08FADF1E0")

    private static final int NOT_FOCUSABLE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.976 -0500", hash_original_field = "EC4918FB1577CD2AFC6A33F97227A81F", hash_generated_field = "B60F2F3FD613AE8F66EF43CAEDBD3D6A")

    private static final int FOCUSABLE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.978 -0500", hash_original_field = "FA11EF15452B5B91A65E54DA2DC8D6BE", hash_generated_field = "4A7BFB7B79B1D1A27F3C6D27933C451E")

    private static final int FOCUSABLE_MASK = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.981 -0500", hash_original_field = "319D6171E3585301EB51FA2721F7E7E3", hash_generated_field = "BF038E8C825175307230C582E611F852")

    private static final int FITS_SYSTEM_WINDOWS = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.983 -0500", hash_original_field = "0420087B6DE488BA43B6656E5C28FF4F", hash_generated_field = "829F05479D332281B757C73E71A7184A")

    public static final int VISIBLE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.985 -0500", hash_original_field = "974CA52993298557F7B63BDAC941A1AE", hash_generated_field = "24C25C40295AD2D0D5F7C693CBE8FFEE")

    public static final int INVISIBLE = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.988 -0500", hash_original_field = "237EA1FBB994D23A7A8CF3E4FC9F6DF4", hash_generated_field = "DADE7E47CBB0DBC6ACF868046DED7DE3")

    public static final int GONE = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.990 -0500", hash_original_field = "2F9BD0624E6D69BBAA467F72D059361A", hash_generated_field = "46DC4CB49B4B1C753E9EF0933116882A")

    static final int VISIBILITY_MASK = 0x0000000C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.992 -0500", hash_original_field = "253E36D6BFF9E8195F2E4244334C951D", hash_generated_field = "F0ED5F92DDC8DA6B5C7B1F0EC92787C9")

    private static final int[] VISIBILITY_FLAGS = {VISIBLE, INVISIBLE, GONE};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.996 -0500", hash_original_field = "E8C4C9B1374C81E042BE35F01015D6C9", hash_generated_field = "E946149DFEA69D0B6E9AC928D5226811")

    static final int ENABLED = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:36.998 -0500", hash_original_field = "A08182A68CD345CFC7CEBCE85B736D47", hash_generated_field = "5038EB1B1BDDC780ECAFF35A7312B00D")

    static final int DISABLED = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.000 -0500", hash_original_field = "8ECA3E29A3AB17AA87ED1EA7C80E33BB", hash_generated_field = "FF7AB53A5D2F6D9583260DBE04CE70E5")

    static final int ENABLED_MASK = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.003 -0500", hash_original_field = "4B0A79831FF8ACF8D2E016A52DBF783F", hash_generated_field = "D9E91EE0E33950072C99789F48286A11")

    static final int WILL_NOT_DRAW = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.005 -0500", hash_original_field = "A2BF9CC38B9FADC64BFD36074A4102A8", hash_generated_field = "8224E5760520AD61AA5C786E772EE5EC")

    static final int DRAW_MASK = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.008 -0500", hash_original_field = "33A33548F264CA65CF9B2DF032C4F54D", hash_generated_field = "269F3C1F1CB4BA6EE4598627F04279FD")

    static final int SCROLLBARS_NONE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.010 -0500", hash_original_field = "CA25EC112DDB63B384D1FC19E3D7C7EF", hash_generated_field = "84D26661F3B38DB7E15F3E6C3E59DCB6")

    static final int SCROLLBARS_HORIZONTAL = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.012 -0500", hash_original_field = "1AA8C9C013224CAC2EBAE7C75FF92C34", hash_generated_field = "0CF016AFAC1CE3FE718CD07BD8D5C506")

    static final int SCROLLBARS_VERTICAL = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.015 -0500", hash_original_field = "1C141AD8065458D3FD4C9160AC33C3DA", hash_generated_field = "C7EB856B5222623AEFC3E1FE97CAEEFC")

    static final int SCROLLBARS_MASK = 0x00000300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.017 -0500", hash_original_field = "81FF375D30944D68A3112F449DFC06C1", hash_generated_field = "5BD75921BC796BD559A68AD91D052366")

    static final int FILTER_TOUCHES_WHEN_OBSCURED = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.019 -0500", hash_original_field = "745243E63F4A71F9DEB837F29978CF95", hash_generated_field = "83E2CC60E5E17AA0C9847D542255DC42")

    /**
     * <p>This view doesn't show fading edges.</p>
     * {@hide}
     */
    static final int FADING_EDGE_NONE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.022 -0500", hash_original_field = "1F4E2CB3FED592D8666338F48A1DAD29", hash_generated_field = "8AB4B1AA261BDC35537908CB321B1983")

    static final int FADING_EDGE_HORIZONTAL = 0x00001000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.024 -0500", hash_original_field = "AFB7F6BD8B77CA7E218CDFFA768A7A87", hash_generated_field = "D9D649DC317847AAD19E64C3E113BBC4")

    static final int FADING_EDGE_VERTICAL = 0x00002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.027 -0500", hash_original_field = "FA32B5BB9260651179E4D8953074C323", hash_generated_field = "B35A040391A4C00443C19C2995B90AB0")

    static final int FADING_EDGE_MASK = 0x00003000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.029 -0500", hash_original_field = "AFA561C6C8F78584FEE682BC68795AE3", hash_generated_field = "8E82BA9946E5FC8217E2D093C0DEE86F")

    static final int CLICKABLE = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.031 -0500", hash_original_field = "F0462D70E75ACD58CF12613E30309FD9", hash_generated_field = "D5C8DBBB19A01A4ADC1CFC3DF56604DE")

    static final int DRAWING_CACHE_ENABLED = 0x00008000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.033 -0500", hash_original_field = "FD657F6F81DC66D8C43A6EEB800F2E67", hash_generated_field = "58220690B3964939EFD247679F6DBB16")

    static final int SAVE_DISABLED = 0x000010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.035 -0500", hash_original_field = "42A242E42451F641676B070323C4A8D0", hash_generated_field = "1AF7B603B206D36BAFEFE71A2856456F")

    static final int SAVE_DISABLED_MASK = 0x000010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.037 -0500", hash_original_field = "7A21BF70A138F134229C4C74E3441ABC", hash_generated_field = "51995E9C673CBAC6019B76C649BEC0DE")

    static final int WILL_NOT_CACHE_DRAWING = 0x000020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.041 -0500", hash_original_field = "A26D93C551F67AC8B950FA6401A023F9", hash_generated_field = "469110FE5469C37A921A47B3637A87F0")

    static final int FOCUSABLE_IN_TOUCH_MODE = 0x00040000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.043 -0500", hash_original_field = "BD45042949BEAE260230043E2B17830B", hash_generated_field = "00C745D591E053E355D9F95CAA502483")

    public static final int DRAWING_CACHE_QUALITY_LOW = 0x00080000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.046 -0500", hash_original_field = "99262085511C861F844BAA7340F6E31C", hash_generated_field = "5C1456CB937D24EC2357B82160B57D70")

    public static final int DRAWING_CACHE_QUALITY_HIGH = 0x00100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.048 -0500", hash_original_field = "9B7449EB7F94336810870FAA4E5AA0D8", hash_generated_field = "1F818F030504ADAB1788120175C0B1E5")

    public static final int DRAWING_CACHE_QUALITY_AUTO = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.051 -0500", hash_original_field = "7FDDA609A3BB70F2B1FB9A56426FBCE8", hash_generated_field = "7060269E37AC69A7EAA5771D16F0390B")

    private static final int[] DRAWING_CACHE_QUALITY_FLAGS = {
            DRAWING_CACHE_QUALITY_AUTO, DRAWING_CACHE_QUALITY_LOW, DRAWING_CACHE_QUALITY_HIGH
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.053 -0500", hash_original_field = "16EAD5D69224887B1DF23F0646D1A8F1", hash_generated_field = "CDA2F575CC8014BF1E2BB36F24BF1F1A")

    static final int DRAWING_CACHE_QUALITY_MASK = 0x00180000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.056 -0500", hash_original_field = "FAD5A3EDD37812A1F84BDDD575BDFB38", hash_generated_field = "22F50F883FF6C25DC52493F220C9ABB8")

    static final int LONG_CLICKABLE = 0x00200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.058 -0500", hash_original_field = "8FBEBE0B4B1730EA5DB9FB43B703F2C6", hash_generated_field = "B27AFB8C724A77CC01C8FE3AAC770306")

    static final int DUPLICATE_PARENT_STATE = 0x00400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.060 -0500", hash_original_field = "C74E259E8D6955B142E8D95C46C20AB4", hash_generated_field = "3942DDD065BFB4D5847FE6C074D13B8C")

    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.063 -0500", hash_original_field = "E407F417C37DB68FF9AEF94397EA55AE", hash_generated_field = "99D8798FCB61EE70472EB6CEB2B1D2BD")

    public static final int SCROLLBARS_INSIDE_INSET = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.065 -0500", hash_original_field = "6D02469FF8D9EA484B317328C4202588", hash_generated_field = "26082E7DF00E5D63F0836B2C3593B9A1")

    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 0x02000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.068 -0500", hash_original_field = "5CD440874FBC3EDBEFEA271FA5EBC407", hash_generated_field = "8D486D5878BEE68EEDFC2466A5593564")

    public static final int SCROLLBARS_OUTSIDE_INSET = 0x03000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.071 -0500", hash_original_field = "A45B9A47BC8A361250BE556F55FE5884", hash_generated_field = "8A31E0CDC781D04365F399522A814CD5")

    static final int SCROLLBARS_INSET_MASK = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.073 -0500", hash_original_field = "A66491D16804136E2863AEA9A7E6178B", hash_generated_field = "70944B9F44919B5C2B302411CDD199D0")

    static final int SCROLLBARS_OUTSIDE_MASK = 0x02000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.076 -0500", hash_original_field = "86D2ACA845671CFEC0FFA59B1F5A40F4", hash_generated_field = "129B7C59D8FDD7BACE6ECE8C3BBCA0AB")

    static final int SCROLLBARS_STYLE_MASK = 0x03000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.078 -0500", hash_original_field = "A45BBF18AB48EE8DCB5F5FCCE539B58C", hash_generated_field = "026A7CCCB8A871DB74312537DD84B5CB")

    public static final int KEEP_SCREEN_ON = 0x04000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.080 -0500", hash_original_field = "15088AA25927FCFC3AA51B720974C474", hash_generated_field = "65C2782715263C009044AB84624A4EB2")

    public static final int SOUND_EFFECTS_ENABLED = 0x08000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.082 -0500", hash_original_field = "FF69DDA221002CBE322A3458B621F05C", hash_generated_field = "104909D35DACCE7A451CA8A4158F790C")

    public static final int HAPTIC_FEEDBACK_ENABLED = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.085 -0500", hash_original_field = "B175948B078A5AB3E675B6D50590934E", hash_generated_field = "571D760F29262F82EDAAA90E822EBAF8")

    static final int PARENT_SAVE_DISABLED = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.088 -0500", hash_original_field = "BCBE108429F3B545EA884E1A5D5EFA8D", hash_generated_field = "D47B48591230EE766F208E58DC2093F4")

    static final int PARENT_SAVE_DISABLED_MASK = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.090 -0500", hash_original_field = "F04774A310B3A78732E1759B8808A3FB", hash_generated_field = "A688099F9FE53C57D5410ECB0B78ECF6")

    public static final int LAYOUT_DIRECTION_LTR = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.092 -0500", hash_original_field = "FDC90F3D619889F3495BE5D41F5D935E", hash_generated_field = "1E680499F28E2DB403E520F9B378996F")

    public static final int LAYOUT_DIRECTION_RTL = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.095 -0500", hash_original_field = "AAC88B3FDFF63D7A019F2B4787C16C47", hash_generated_field = "3C8F75DD79F0631A6C45E4E961B35BE6")

    public static final int LAYOUT_DIRECTION_INHERIT = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.097 -0500", hash_original_field = "755DD58A08A5F29950EF84ABC9AA1539", hash_generated_field = "309700780AC169B61849F35A862B3E65")

    public static final int LAYOUT_DIRECTION_LOCALE = 0xC0000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.100 -0500", hash_original_field = "BCA2ED79755FE10650FC5AA72EB72C02", hash_generated_field = "6FE5303D659D6470BE6AE1DC66925B88")

    static final int LAYOUT_DIRECTION_MASK = 0xC0000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.103 -0500", hash_original_field = "C5AFD6A6C9366D33798D144A8078E6B3", hash_generated_field = "2B195F9D5574504A59136591EF21764E")

    private static final int[] LAYOUT_DIRECTION_FLAGS = {LAYOUT_DIRECTION_LTR,
        LAYOUT_DIRECTION_RTL, LAYOUT_DIRECTION_INHERIT, LAYOUT_DIRECTION_LOCALE};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.105 -0500", hash_original_field = "2FF3B4B954872B8A2CAC234A1183B4EA", hash_generated_field = "0FF5069567EECE1EABD2593046037335")

    private static final int LAYOUT_DIRECTION_DEFAULT = LAYOUT_DIRECTION_INHERIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.107 -0500", hash_original_field = "7F3BDB64A61717B04C7D240EBBFB58CA", hash_generated_field = "4E5D1049C9EF75861592546EF88DBF53")

    public static final int FOCUSABLES_ALL = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.109 -0500", hash_original_field = "D6C0ED560C96E9FABF5A3BABD9F2B22B", hash_generated_field = "FDC3A4AE8FBDEDEDFB25081E70F0EAFA")

    public static final int FOCUSABLES_TOUCH_MODE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.112 -0500", hash_original_field = "0D68B37095907D57021CFCBB507D87EE", hash_generated_field = "169DA3FC15889071D72206CA09A960FA")

    public static final int FOCUS_BACKWARD = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.116 -0500", hash_original_field = "D96B5288D75FE47268429FB74307103C", hash_generated_field = "4B7B29E11785A4D3C7319284FE29BB61")

    public static final int FOCUS_FORWARD = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.119 -0500", hash_original_field = "27F24DE21F1C2EF5DEB284D6B5E6542F", hash_generated_field = "936F919E08FC8B9F1C931D6E632F8DE0")

    public static final int FOCUS_LEFT = 0x00000011;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.121 -0500", hash_original_field = "F13CE536DB0CF8E9353742E9568F6AD7", hash_generated_field = "E877EF3790B7F3E0F15FFC2846DA5A4A")

    public static final int FOCUS_UP = 0x00000021;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.124 -0500", hash_original_field = "F5D103A08E316CC1A03FA27749B8BBAE", hash_generated_field = "8A54B461A03C16A38D0974EA5435F806")

    public static final int FOCUS_RIGHT = 0x00000042;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.126 -0500", hash_original_field = "1AB50CDE7E870EFA71C507ED9D0D58E4", hash_generated_field = "32373BABA82126482CBABBE76E9F36D3")

    public static final int FOCUS_DOWN = 0x00000082;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.128 -0500", hash_original_field = "A41AFB14561C756088DE88EA294BDF02", hash_generated_field = "3584CE2038396D56F00CBCE4E0AF47E7")

    public static final int MEASURED_SIZE_MASK = 0x00ffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.131 -0500", hash_original_field = "230A433CB35000100586A63BAB0A109F", hash_generated_field = "874FE93B404AA4B2617E7E2F47B091CC")

    public static final int MEASURED_STATE_MASK = 0xff000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.133 -0500", hash_original_field = "8C0B03FFB0098DA8DAB9230B3C51EB0D", hash_generated_field = "859653BE0AACCFF2DA07F4D6CA30948B")

    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.136 -0500", hash_original_field = "22A909B4958BA8440BEDEF503B97A322", hash_generated_field = "499640E6C451DA0A8A056EE1F14203E6")

    public static final int MEASURED_STATE_TOO_SMALL = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.138 -0500", hash_original_field = "B70F7033BCE11B9600B10DF3ED5E5B5A", hash_generated_field = "A087AEB4FFAB6EC87B7754D368468D7C")

    // Singles
    /**
     * Indicates the view has no states set. States are used with
     * {@link android.graphics.drawable.Drawable} to change the drawing of the
     * view depending on its state.
     *
     * @see android.graphics.drawable.Drawable
     * @see #getDrawableState()
     */
    protected static  int[] EMPTY_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.141 -0500", hash_original_field = "02D92ED4113C3A27CBBFC3288400FF05", hash_generated_field = "99443560A8BB02795565A31C7E7FF7B1")

    protected static  int[] ENABLED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.143 -0500", hash_original_field = "847132BD62078D09521C4FA0BF86C678", hash_generated_field = "11C8381528C7451EAC51D425793F56C2")

    protected static  int[] FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.146 -0500", hash_original_field = "3AECFB9A32392B0D153E01953A278F0A", hash_generated_field = "3A452259C52C53C1EFB914A335939407")

    protected static  int[] SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.148 -0500", hash_original_field = "C7C143B07C89459937A74CF3EFBB5D5C", hash_generated_field = "1150481E1245BD4252FBDD6D8BF7F65F")

    protected static  int[] PRESSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.151 -0500", hash_original_field = "91D51F0B5484DB4A5214B325B91F5605", hash_generated_field = "8E5DAB90AC5DCA5817D14D9B6C547303")

    protected static  int[] WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.153 -0500", hash_original_field = "082A14B50CC4CBA7FC1BD49EF9585738", hash_generated_field = "2F6168E24166507E3033EFBABBD353BB")

    /**
     * Indicates the view is enabled and has the focus.
     *
     * @see #ENABLED_STATE_SET
     * @see #FOCUSED_STATE_SET
     */
    protected static  int[] ENABLED_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.155 -0500", hash_original_field = "7F715949C2E45FEF53672F0261998FE9", hash_generated_field = "26F780CD73153C56C935B863B7CA60FA")

    protected static  int[] ENABLED_SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.158 -0500", hash_original_field = "C1D171EC5D47BA809E9C6A2ED9AD5D61", hash_generated_field = "4E4EEFF45753D32998559D55A6EF44B8")

    protected static  int[] ENABLED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.161 -0500", hash_original_field = "695546956E702F517C42D532297F870D", hash_generated_field = "E4F27C2333C782D6E4D173DE3B06BF18")

    protected static  int[] FOCUSED_SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.164 -0500", hash_original_field = "94AA9FB9613EEE1D04AAAEE7FBFE0CCF", hash_generated_field = "89F4391F6DDF155A225E114339942430")

    protected static  int[] FOCUSED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.166 -0500", hash_original_field = "DB82BF7E6EA4B26479942455C63EF0CD", hash_generated_field = "94022B56BE402F58E4270EB350792883")

    protected static  int[] SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.169 -0500", hash_original_field = "08DAB88773A55E3172EC449B82B903E7", hash_generated_field = "415CFCDD2DAB36C74082A74219120223")

    /**
     * Indicates the view is enabled, focused and selected.
     *
     * @see #ENABLED_STATE_SET
     * @see #FOCUSED_STATE_SET
     * @see #SELECTED_STATE_SET
     */
    protected static  int[] ENABLED_FOCUSED_SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.171 -0500", hash_original_field = "00EE084C09E2938240591F2EAC2AF55F", hash_generated_field = "FDA0C2E170F0F36949DABE497139E672")

    protected static  int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.174 -0500", hash_original_field = "2EA7A45B5D95532768A00FBBF963C317", hash_generated_field = "7B5D9A889C2FFA9A561E0EA4250EBE37")

    protected static  int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.176 -0500", hash_original_field = "C7F97B6896359E799868132E4F580163", hash_generated_field = "C7506CCBA97AA185D5649A7B40AB28D9")

    protected static  int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.179 -0500", hash_original_field = "98B5588647BF38CBF251E6DD216E9840", hash_generated_field = "21701468D299EEF2E6314D17CDA4A09B")

    protected static  int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.181 -0500", hash_original_field = "EE5B4C1DF24A6CA812F92526A47DBCBD", hash_generated_field = "F8383F641270D614B30774F08FA72D27")

    protected static  int[] PRESSED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.184 -0500", hash_original_field = "8F122B8B26715E0E2BE50C00EF59E3EC", hash_generated_field = "D26868EDEAAF82B3EF5953C4049C5BF8")

    protected static  int[] PRESSED_SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.186 -0500", hash_original_field = "B22A828937875703AE341A3AC985684D", hash_generated_field = "DB8F785F4FD804A28291B083216F3C9E")

    protected static  int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.189 -0500", hash_original_field = "291F165E9CF8056074CF05D7595CD572", hash_generated_field = "FF997AEB254DFD2B8E8AF4DC32EF1D31")

    protected static  int[] PRESSED_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.192 -0500", hash_original_field = "85A79247B051BCC0540A400DE66617CF", hash_generated_field = "B219816DBAFB4C4AE58A96AEE6F32010")

    protected static  int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.194 -0500", hash_original_field = "4F334AEE4D760477184FB3D374487F36", hash_generated_field = "EB888E73506F6FA9D225D7A6FC4285F7")

    protected static  int[] PRESSED_FOCUSED_SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.196 -0500", hash_original_field = "B4C099D8670DBB6B3E29F5A11879BB6B", hash_generated_field = "DA91E046B143C9258573479BFD455473")

    protected static  int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.199 -0500", hash_original_field = "422AA646FDB14447504A3EE5A49C2A86", hash_generated_field = "47A198E35052CA7F982234E83E6AE0B5")

    protected static  int[] PRESSED_ENABLED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.201 -0500", hash_original_field = "A8FC41CF945714C0827C548A1F951050", hash_generated_field = "1241C342AD96CD3177F39E12E55B08A1")

    protected static  int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.203 -0500", hash_original_field = "5744CA6789E0CD1F8A10C5AA4182A28E", hash_generated_field = "B8447E4F384C40AC956314579E0EC168")

    protected static  int[] PRESSED_ENABLED_SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.206 -0500", hash_original_field = "C58BAF14BC6206EEFD54EFD9BC30B9B2", hash_generated_field = "F3A6207F343FCB93F7AD3D66BE9819DE")

    protected static  int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.209 -0500", hash_original_field = "E126549DD20F70BD20AFB711DBE7AED9", hash_generated_field = "92A36B4EAE93002927F999631B9F3F0B")

    protected static  int[] PRESSED_ENABLED_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.212 -0500", hash_original_field = "EC8636D83FACAF05294A96C7AC0A6763", hash_generated_field = "95A751D33F39D2426A2D5C87AED66425")

    protected static  int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.215 -0500", hash_original_field = "CE13B3F4F801E889DB68D67023A1EEB4", hash_generated_field = "7FA35EC1F5140E40D7F86CA44E6DBA3D")

    protected static  int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.217 -0500", hash_original_field = "9A10F58594D5D0F2BC1ACB29A201F8AD", hash_generated_field = "74D8BB51BDEF099D4EDB19D4AB388E56")

    protected static  int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.219 -0500", hash_original_field = "973BA471F834DAD181B4A77F2368911D", hash_generated_field = "07E5728FFC69B34D451F1FFD96A500DE")

    private static  int[][] VIEW_STATE_SETS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.222 -0500", hash_original_field = "27C203EC67B54B86E4D1C76D73BC3A8A", hash_generated_field = "14A9EEAFA20652E17C004627513442D3")

    static final int VIEW_STATE_WINDOW_FOCUSED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.224 -0500", hash_original_field = "74F65D930BC8545D8694F9A4FA8D0BD7", hash_generated_field = "8F5DACC3E931BB6D45970C3D4F236044")

    static final int VIEW_STATE_SELECTED = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.226 -0500", hash_original_field = "4D139E17DCE281B990B5B5C6B77CBCA1", hash_generated_field = "3BDE49CD992A557C6BC150E37203E374")

    static final int VIEW_STATE_FOCUSED = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.228 -0500", hash_original_field = "40A9AB675176C1D2EA5474E4E01161D8", hash_generated_field = "FF062786656E19CBE9DF873C32B837B4")

    static final int VIEW_STATE_ENABLED = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.231 -0500", hash_original_field = "D30B1D23F7930E5AB300A0696E2FF643", hash_generated_field = "42D0A243D87878B393907AB494DF9D6F")

    static final int VIEW_STATE_PRESSED = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.233 -0500", hash_original_field = "C0EC43DD8828A54ED6CC17E48504393F", hash_generated_field = "6C91EA09E2C90C1DF3101479368CB380")

    static final int VIEW_STATE_ACTIVATED = 1 << 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.236 -0500", hash_original_field = "4F50EF1EB4D36BFDF787880154AAC329", hash_generated_field = "9EC9B10B5927E85F8F05CFFD3E1BCB7D")

    static final int VIEW_STATE_ACCELERATED = 1 << 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.238 -0500", hash_original_field = "60B19DC224AA1B4965BC02C5FACEF7BC", hash_generated_field = "E89AF08FD103519565D8ACE924E0CCDE")

    static final int VIEW_STATE_HOVERED = 1 << 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.240 -0500", hash_original_field = "2A837E1EE89502A11BC6DCA4BBC67266", hash_generated_field = "1D4DC52F9C46700D3A32C0B94E81EC4A")

    static final int VIEW_STATE_DRAG_CAN_ACCEPT = 1 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.243 -0500", hash_original_field = "E5BB86C08A4D130AB8446BB74330516E", hash_generated_field = "622438F15831E9532B4F4DDFC41CF098")

    static final int VIEW_STATE_DRAG_HOVERED = 1 << 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.246 -0500", hash_original_field = "563F8D740CB49E979B5B723F27DF9043", hash_generated_field = "AAC5495A62AC6D4ACFA4E56618BD582F")

    static final int[] VIEW_STATE_IDS = new int[] {
        R.attr.state_window_focused,    VIEW_STATE_WINDOW_FOCUSED,
        R.attr.state_selected,          VIEW_STATE_SELECTED,
        R.attr.state_focused,           VIEW_STATE_FOCUSED,
        R.attr.state_enabled,           VIEW_STATE_ENABLED,
        R.attr.state_pressed,           VIEW_STATE_PRESSED,
        R.attr.state_activated,         VIEW_STATE_ACTIVATED,
        R.attr.state_accelerated,       VIEW_STATE_ACCELERATED,
        R.attr.state_hovered,           VIEW_STATE_HOVERED,
        R.attr.state_drag_can_accept,   VIEW_STATE_DRAG_CAN_ACCEPT,
        R.attr.state_drag_hovered,      VIEW_STATE_DRAG_HOVERED,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.249 -0500", hash_original_field = "DF4583259D9D883E840253E6EA438707", hash_generated_field = "09FD46ADE03A21840451EFC738B1A7A7")

    private static final int POPULATING_ACCESSIBILITY_EVENT_TYPES =
            AccessibilityEvent.TYPE_VIEW_CLICKED
            | AccessibilityEvent.TYPE_VIEW_LONG_CLICKED
            | AccessibilityEvent.TYPE_VIEW_SELECTED
            | AccessibilityEvent.TYPE_VIEW_FOCUSED
            | AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            | AccessibilityEvent.TYPE_VIEW_HOVER_ENTER
            | AccessibilityEvent.TYPE_VIEW_HOVER_EXIT
            | AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
            | AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.252 -0500", hash_original_field = "2D9F96080D99A7C35E01171E9A2716AC", hash_generated_field = "684181D325E3591F0B7AAD06CC900A68")

    static final ThreadLocal<Rect> sThreadLocal = new ThreadLocal<Rect>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.257 -0500", hash_original_field = "2B5438980B7DEF8610B18F5EC57A5AA9", hash_generated_field = "7D4D749E981D95615D6EBF2D704DB8B6")

    private static int sNextAccessibilityViewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.274 -0500", hash_original_field = "D870516C13AA423769F84F836A60A68A", hash_generated_field = "7019E4EA356A3D3D27339B8479C0887D")

    /** {@hide} */
    static final int WANTS_FOCUS                    = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.277 -0500", hash_original_field = "8A5953649CC9B7325B8EFD6AE24634F5", hash_generated_field = "76144A0AFA07456ADF5BD6C61EFDD82A")

    static final int FOCUSED                        = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.279 -0500", hash_original_field = "364C1AD5B51B204930FC8AC47EBF8A62", hash_generated_field = "B8FCBDDA4AC19831AC8F95B5E299A019")

    static final int SELECTED                       = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.281 -0500", hash_original_field = "3F69BC98561F5FA774B41486B34670F6", hash_generated_field = "40E315525D7E3F79CE6749FA5486016E")

    static final int IS_ROOT_NAMESPACE              = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.284 -0500", hash_original_field = "1F043541A2BBF527E55BE8AA067C2A42", hash_generated_field = "A57A7453C08B33D43AA0903652335D6B")

    static final int HAS_BOUNDS                     = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.287 -0500", hash_original_field = "7E4479A95873AD08552C7E311BD04D27", hash_generated_field = "9EF7FA33897722D87B0F3A6B600D5E81")

    static final int DRAWN                          = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.289 -0500", hash_original_field = "F6DD373AEAF5163ABEF7B4C2F4ED5CE9", hash_generated_field = "9DE5C056A7D09D1D07F14977B6558968")

    static final int DRAW_ANIMATION                 = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.291 -0500", hash_original_field = "6EE33091AF8E0862EC503B6618C9330D", hash_generated_field = "60FF926409B2F5933B181900B19AAC45")

    static final int SKIP_DRAW                      = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.293 -0500", hash_original_field = "7BDF3676E0124F2957CCF268402D9176", hash_generated_field = "42E39DC4A1F2A24AE76342261ED67462")

    static final int ONLY_DRAWS_BACKGROUND          = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.296 -0500", hash_original_field = "205709D4BBEF151FA88E65D031EB16F8", hash_generated_field = "6FDF9B9C295413E46CD84B530D99A3CC")

    static final int REQUEST_TRANSPARENT_REGIONS    = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.298 -0500", hash_original_field = "22493BDAC215822524E0C58D9CCB85CB", hash_generated_field = "23439B38EE9E7C6C702D63C4F1ED384A")

    static final int DRAWABLE_STATE_DIRTY           = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.301 -0500", hash_original_field = "A4F517B46849330F5BA36D04FA06DC61", hash_generated_field = "02DFB1F097A0748DE08336A975D45816")

    static final int MEASURED_DIMENSION_SET         = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.303 -0500", hash_original_field = "18E373E316FAD3F162777BB7C7854CFA", hash_generated_field = "945693F86F0A771A9EC4BD547C7EA2C6")

    static final int FORCE_LAYOUT                   = 0x00001000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.305 -0500", hash_original_field = "4178B0D2F0555AC602FF6531FB95108D", hash_generated_field = "138A2DA084E8C20D234F0FD286F24C09")

    static final int LAYOUT_REQUIRED                = 0x00002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.308 -0500", hash_original_field = "346B2381241B436E49E252304ACCA3AA", hash_generated_field = "A32BF712F0570B663C9C802C05CF1890")

    private static final int PRESSED                = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.310 -0500", hash_original_field = "01BD01FC469C0A2F014C48E9C313907D", hash_generated_field = "6A22DCE014F56DCE137CB587120D93F9")

    static final int DRAWING_CACHE_VALID            = 0x00008000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.312 -0500", hash_original_field = "2E34992DF56EBCE90A1958B7722CCAA2", hash_generated_field = "042862CB0ADBC6B3E35B81806CA38E37")

    static final int ANIMATION_STARTED              = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.315 -0500", hash_original_field = "5CB5BF1387AEBE86ED822725ACF39FB0", hash_generated_field = "BA4D09564EB1E0038BBEC9BC2D384011")

    private static final int SAVE_STATE_CALLED      = 0x00020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.317 -0500", hash_original_field = "09CB0093D454A5A3ADE1FE7C18909A07", hash_generated_field = "2ADF228F56CBDA6B09A2A154F6926EFA")

    static final int ALPHA_SET                      = 0x00040000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.320 -0500", hash_original_field = "B9A5AB92615F0A7D8FED4FBA8C8F23A6", hash_generated_field = "44E3C961B99F63E3A07CB003A0CA4B9B")

    static final int SCROLL_CONTAINER               = 0x00080000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.322 -0500", hash_original_field = "08117FF4251CC08EE1CB5E5C69285454", hash_generated_field = "FBC3A0FBB44FEC222F3F4C8C1E04A345")

    static final int SCROLL_CONTAINER_ADDED         = 0x00100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.325 -0500", hash_original_field = "A70E2D447BA1A192D5422A38019B9FF5", hash_generated_field = "96ADCAB4A37B8BB124ECD80E384642EA")

    static final int DIRTY                          = 0x00200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.327 -0500", hash_original_field = "BE8257FF2F3FDF9CB2D2C4E94B5955A2", hash_generated_field = "96FBB855B8A08D7EDC96EFCEC1705F07")

    static final int DIRTY_OPAQUE                   = 0x00400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.329 -0500", hash_original_field = "2B3D4940D35BF6E82B2883FE9C7F16D7", hash_generated_field = "E59459A965FA6E2D0EE74CC520B7969C")

    static final int DIRTY_MASK                     = 0x00600000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.331 -0500", hash_original_field = "C763AA3F241CBD327CDCE9B78389DF7F", hash_generated_field = "B74861256F94749BBD076F0EE1BB6697")

    static final int OPAQUE_BACKGROUND              = 0x00800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.334 -0500", hash_original_field = "3C4E9208D0A124E709293DBB6DB4DB62", hash_generated_field = "CB076E5ABDBD6D2DB2CAA68F9BBF25B9")

    static final int OPAQUE_SCROLLBARS              = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.336 -0500", hash_original_field = "E98133C2270F36AFD5AD1113E304D697", hash_generated_field = "26BE9A5B6506A9A205564B56496E86A7")

    static final int OPAQUE_MASK                    = 0x01800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.338 -0500", hash_original_field = "18F720214A41A4DA4DBBF70DDB11F81B", hash_generated_field = "9B3764730F327DBBF2A2D3CD5D565A0E")

    private static final int PREPRESSED             = 0x02000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.341 -0500", hash_original_field = "7353EB42ADF91AC74F887C15F774D93B", hash_generated_field = "9B73CB25776C9F2B49E35CE827A563CB")

    static final int CANCEL_NEXT_UP_EVENT = 0x04000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.344 -0500", hash_original_field = "9D398BC44A285D283EDBC28051B7672D", hash_generated_field = "8A59740EC03CDB8433058BC75E6CC2DF")

    private static final int AWAKEN_SCROLL_BARS_ON_ATTACH = 0x08000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.346 -0500", hash_original_field = "0E64294C1AEECDEC8EFFE94D09F87EC0", hash_generated_field = "5A4D1B7B954FE6E9DB7211EC1037FB16")

    private static final int HOVERED              = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.348 -0500", hash_original_field = "5351674F40B179F7FB90190ED656FCB4", hash_generated_field = "B9DEE496A6C9D6738C4CCD97A0FFC329")

    private static final int PIVOT_EXPLICITLY_SET = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.352 -0500", hash_original_field = "06C9819C517C02A86A337EC9C069ECC3", hash_generated_field = "E7C6D1F67DF39F2566312582F97AA88E")

    static final int ACTIVATED                    = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.354 -0500", hash_original_field = "6A909A10AEB6799CB627481A61ED8841", hash_generated_field = "0A4C84F7E1053F2B7F2C1216C1B89639")

    static final int INVALIDATED                  = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.356 -0500", hash_original_field = "E8684AE66C81C33569DB0D4A5EEC8AE2", hash_generated_field = "AD649D2CDFE089C036698E2EF80732EA")

    /**
     * Indicates that this view has reported that it can accept the current drag's content.
     * Cleared when the drag operation concludes.
     * @hide
     */
    static final int DRAG_CAN_ACCEPT              = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.359 -0500", hash_original_field = "CF586A6F388542172BCB46D7FD3A47E6", hash_generated_field = "0A71D3250F076CE3F2CA33F0AFEA1360")

    static final int DRAG_HOVERED                 = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.361 -0500", hash_original_field = "583F0B5DF4B2FEB24B5871C5AD991BC6", hash_generated_field = "533431F61C3E776BF1DC4F0C19BFFFBE")

    static final int LAYOUT_DIRECTION_RESOLVED_RTL = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.363 -0500", hash_original_field = "8F286E58A4B97C169675E703F844CE1C", hash_generated_field = "EB582E7E7DEA8F1CBFEE72038956E0BA")

    static final int LAYOUT_DIRECTION_RESOLVED = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.366 -0500", hash_original_field = "943FE7F9DCFB25F34976BF339A22FE44", hash_generated_field = "DE17281667B863CA7CEAE6DA8567A548")

    static final int DRAG_MASK = DRAG_CAN_ACCEPT | DRAG_HOVERED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.368 -0500", hash_original_field = "361BC31D07AD9559F194AE7DCEA363BD", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.371 -0500", hash_original_field = "CC647B45C45ACE646CE989AEBDB00745", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.374 -0500", hash_original_field = "F3053BB78DC68F981F29ECFBD3977D87", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.376 -0500", hash_original_field = "5116DEC50BE6DA4452A11807D9B662F5", hash_generated_field = "125903A773621693E8ED9CD79E76CEE2")

    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.378 -0500", hash_original_field = "2C8F755224A4850D9323A6EBFD03847D", hash_generated_field = "D22EB113F7E463630AC5C1BF53857810")

    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.381 -0500", hash_original_field = "C6C14DD51FD7A5AD9F945FFF8CD5AB6E", hash_generated_field = "C08307181AE930BB4EB97AF7E4BA99C2")

    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.383 -0500", hash_original_field = "8A4FB6920FE33E3906CC8D90228ECBFF", hash_generated_field = "E2BDD60871070DE88B6211D48982B8C2")

    public static final int STATUS_BAR_HIDDEN = SYSTEM_UI_FLAG_LOW_PROFILE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.386 -0500", hash_original_field = "8DB1DB179359F99028858B004DDD8E03", hash_generated_field = "8B75629E21794DD2B63C2EBB0F5C5651")

    public static final int STATUS_BAR_VISIBLE = SYSTEM_UI_FLAG_VISIBLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.389 -0500", hash_original_field = "DE796206A1A7CAA151762AF1FB824A26", hash_generated_field = "B2C2F68118A98B0D9DC29F6548450BB1")

    public static final int STATUS_BAR_DISABLE_EXPAND = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.391 -0500", hash_original_field = "2ED0D314F1AE342C3FC0BA3A196FD475", hash_generated_field = "F15A9A270E6E94C57BE4C34A504CA2E4")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ICONS = 0x00020000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.394 -0500", hash_original_field = "41F8374FD8C7449A5EB4FD33548887BC", hash_generated_field = "A29040D2CCE82CD2248FC7CE5DD6F34C")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ALERTS = 0x00040000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.396 -0500", hash_original_field = "CBC9DA5859CC41E1A45FF9ECFF3E3879", hash_generated_field = "16D9107672695454170019843C771E6E")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_TICKER = 0x00080000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.399 -0500", hash_original_field = "EC3855392993027D3E5482B19A204C83", hash_generated_field = "F95F66DC605FC858FD4E71DFA5C0F9BD")

    public static final int STATUS_BAR_DISABLE_SYSTEM_INFO = 0x00100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.401 -0500", hash_original_field = "86C00375A8DEE5C038998307962ACDE0", hash_generated_field = "AAFD5A01803D7358E81163F32EB064CC")

    public static final int STATUS_BAR_DISABLE_HOME = 0x00200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.404 -0500", hash_original_field = "AF77C04065F881908BF8FD96A62FB411", hash_generated_field = "E23FAA42E397EEA07B1B79A8F58007E0")

    public static final int STATUS_BAR_DISABLE_BACK = 0x00400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.406 -0500", hash_original_field = "4DCCD6F8D96EAA9A82F008831DC70BFA", hash_generated_field = "DCC7B8B91738A06DD4F62CA9D5735F60")

    public static final int STATUS_BAR_DISABLE_CLOCK = 0x00800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.409 -0500", hash_original_field = "91700AD3D7BE5B4BFE8C263BA4670FC9", hash_generated_field = "CCF974A2E5C1C62EC6B351C6AF50C578")

    public static final int STATUS_BAR_DISABLE_RECENT = 0x01000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.411 -0500", hash_original_field = "D33A80DD50D17BA1F29033B02B1D8498", hash_generated_field = "0C7A3AEFD08471993D7A4F0326BFA356")

    @Deprecated
    public static final int STATUS_BAR_DISABLE_NAVIGATION = 
            STATUS_BAR_DISABLE_HOME | STATUS_BAR_DISABLE_RECENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.414 -0500", hash_original_field = "C2158026C1D4B695205942AF6400784C", hash_generated_field = "C93A2BBD1CA42547C4B5B418761D706E")

    public static final int PUBLIC_STATUS_BAR_VISIBILITY_MASK = 0x0000FFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.417 -0500", hash_original_field = "ECF3D7F60F28EC006AD8D1FD5F1577E4", hash_generated_field = "9B73CC22DA15165280173F1866272945")

    public static final int SYSTEM_UI_CLEARABLE_FLAGS =
            SYSTEM_UI_FLAG_LOW_PROFILE | SYSTEM_UI_FLAG_HIDE_NAVIGATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.419 -0500", hash_original_field = "8F9050C247F1C4572DDE6A3C6F760F21", hash_generated_field = "7B20A663B4D3B5566CC5C719038AA2BA")

    public static final int FIND_VIEWS_WITH_TEXT = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.421 -0500", hash_original_field = "EB9011D71C46157BF758C5AE3F239188", hash_generated_field = "DC0F2D99F610668CF27C5B6686754038")

    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.497 -0500", hash_original_field = "99C1C6DADEFA531ED7A01C58AF55D869", hash_generated_field = "861292948F794A707C7A0C135A7073D2")

    private static final float NONZERO_EPSILON = .001f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.645 -0500", hash_original_field = "E654550DF53A9A9AD05A21460EB00CA5", hash_generated_field = "C08C16CB7F1DD117251F7E01BD2A9C0A")

    public static final int DRAG_FLAG_GLOBAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.652 -0500", hash_original_field = "84C9CEC0877095004F1AA5A0513C0688", hash_generated_field = "A5FF12741D477D00096166439C6E6A47")

    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.655 -0500", hash_original_field = "E599E3FB99284CDD2309F13CD5822178", hash_generated_field = "DC33B736EF2AA325AA97A5FCD399D9D8")

    public static final int SCROLLBAR_POSITION_LEFT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.657 -0500", hash_original_field = "B4DB4B0E346B31C83DB837C99563505C", hash_generated_field = "3F9EAAC738BDA10511E9A3B6436EF6E3")

    public static final int SCROLLBAR_POSITION_RIGHT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.660 -0500", hash_original_field = "A7FC7A142388B7E68C811E9F0DE82AAB", hash_generated_field = "4B71A3CAAC0983C5CC19785C41F5E14C")

    public static final int LAYER_TYPE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.663 -0500", hash_original_field = "10F1EBB3EA286BF40E15A7DC5A5C77B1", hash_generated_field = "9362C41130448D1BEC071BA7F3927A19")

    public static final int LAYER_TYPE_SOFTWARE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.665 -0500", hash_original_field = "A83617A3813259E5F20A2BA621D5CBC5", hash_generated_field = "339CEE307F54C01A3C41187443B4553A")

    public static final int LAYER_TYPE_HARDWARE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.678 -0500", hash_original_field = "BF11ED69AF537CB7884A7719322DF883", hash_generated_field = "8B7A964E0E3D6E1CA183DED21E99796E")

    public static final int TEXT_DIRECTION_INHERIT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.681 -0500", hash_original_field = "28CD55C771DE31D369884754CCA69521", hash_generated_field = "A11F693FD1415D67D865FDE1AE59FAC8")

    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.683 -0500", hash_original_field = "8BD3C42AC141B79AB8DA2E30601C4AC0", hash_generated_field = "FE7C3FEA62FE2BEB4EAF36B5581E7BE1")

    public static final int TEXT_DIRECTION_ANY_RTL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.686 -0500", hash_original_field = "00F37067338E104CE700AEDCFFFEF206", hash_generated_field = "7D98B23250113084506842828EB2DF5B")

    public static final int TEXT_DIRECTION_LTR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.688 -0500", hash_original_field = "5735A42564EDCE6EE5EC24461F6D61AE", hash_generated_field = "9D4940C20853BDAD0B50AED80FB5511C")

    public static final int TEXT_DIRECTION_RTL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.691 -0500", hash_original_field = "3ED4ADF37762615108B9768A0C6B3F6B", hash_generated_field = "08FC45D9BA58A3E9219785E4F9BE4255")

    protected static int DEFAULT_TEXT_DIRECTION = TEXT_DIRECTION_INHERIT;

    public static Property<View, Float> ALPHA = new MyFloatPropertyView("alpha");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.675 -0400", hash_original_field = "2463A82C1B3B068FBED45F14B07DEA60", hash_generated_field = "2E88A25ECF88D0581B11F01DDC5B788E")

    public static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.031 -0500", hash_original_method = "71D30789CC0083AAA14E647D4066A62B", hash_generated_method = "72DD6548D424A88841CA38FA3FE10B2F")
        
@Override
        public void setValue(View object, float value) {
            object.setTranslationX(value);
        }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.033 -0500", hash_original_method = "AE4ED8B1A0B86A64F67E6D55304484F8", hash_generated_method = "EFF9E8266292138CD603D8433D00689E")
        
@Override
        public Float get(View object) {
            return object.getTranslationX();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.676 -0400", hash_original_field = "7372D8389B757BEF40F84E15ACD0B19E", hash_generated_field = "3514365D38BDAF2F2F1CD4EFBC59F1B9")

    public static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.040 -0500", hash_original_method = "35EB991A21102AE6A66798A0E05F4EB7", hash_generated_method = "808C958DA5B1D05413F268ED98614E2C")
        
@Override
        public void setValue(View object, float value) {
            object.setTranslationY(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.042 -0500", hash_original_method = "602B4C29E3FDDB39DD10FBFA4C1D4EAD", hash_generated_method = "41C75672EFCF3D31F73F93ECBEFE887A")
        
@Override
        public Float get(View object) {
            return object.getTranslationY();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.677 -0400", hash_original_field = "7ABCFD2CD0D4C099DC453E558FE85F44", hash_generated_field = "9AE8BCB9ADF5964753832A0E9C82085F")

    public static Property<View, Float> X = new FloatProperty<View>("x") {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.049 -0500", hash_original_method = "942D12A2907E436F9DD2D5A3BB599D1C", hash_generated_method = "58EEA29A52AB55FD0A319AC1A4981BB0")
        
@Override
        public void setValue(View object, float value) {
            object.setX(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.051 -0500", hash_original_method = "87F550DC0E1D4FED879AF17D796C775D", hash_generated_method = "CC5F27E651D8D85DF203A8E291B0FE64")
        
@Override
        public Float get(View object) {
            return object.getX();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.678 -0400", hash_original_field = "CFD3CAFD4126436BCB87BFC085957E57", hash_generated_field = "D23D2D01DF692E441C62FAF9235D2C1B")

    public static Property<View, Float> Y = new FloatProperty<View>("y") {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.057 -0500", hash_original_method = "F66C6BF603238C3B745DBF80CCB68E15", hash_generated_method = "30D52918494E5F6F3D18D98456F775F0")
        
@Override
        public void setValue(View object, float value) {
            object.setY(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.060 -0500", hash_original_method = "107F13AA20F45AE0A7AF10B2A89B1B3D", hash_generated_method = "6B0CA533A4B3168E6438833115FB9833")
        
@Override
        public Float get(View object) {
            return object.getY();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.679 -0400", hash_original_field = "E56D0E5046417B3F74FFC7B03E80BE5C", hash_generated_field = "FB557AFE67B470E71F7C64EE24F6E3BE")

    public static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.066 -0500", hash_original_method = "E4DD5C8F5E4B6A35D65B3372F3D8BFBA", hash_generated_method = "AE4BA9E4AFBBC3C25A5FEC6E2FF542B1")
        
@Override
        public void setValue(View object, float value) {
            object.setRotation(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.068 -0500", hash_original_method = "6F0DC1763312BEA34F1272E5458BA30D", hash_generated_method = "1ACC8967364DDC504B207A6BA26EF694")
        
@Override
        public Float get(View object) {
            return object.getRotation();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.679 -0400", hash_original_field = "E6B3F0C9E4238E32ABB7463CE9AD008B", hash_generated_field = "325BD964137AF15B5513B111B09E57AF")

    public static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.073 -0500", hash_original_method = "D8E97A391BF9703940D7A06280ABBB3F", hash_generated_method = "9FA0E5C33CB78B8A32D5F8047ADBF5BE")
        
@Override
        public void setValue(View object, float value) {
            object.setRotationX(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.076 -0500", hash_original_method = "3FE8B70962F32AF948528D0D6E8ED1AF", hash_generated_method = "D7522A7BAE1DE61CCA109BA33510C46D")
        
@Override
        public Float get(View object) {
            return object.getRotationX();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.681 -0400", hash_original_field = "E871DD5638C4B35E145FF614A448D053", hash_generated_field = "BA1634E8F9B2BA862DD6DB1E36053562")

    public static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.082 -0500", hash_original_method = "CDE80AB2A44D5B173DB76AD6CA4559A4", hash_generated_method = "E3DBBF196E297FCB88541F466BEF0EAF")
        
@Override
        public void setValue(View object, float value) {
            object.setRotationY(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.085 -0500", hash_original_method = "EE835584282672E99083546AE5304355", hash_generated_method = "844029013D17CDEA19ACEC18E4B2EC04")
        
@Override
        public Float get(View object) {
            return object.getRotationY();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.682 -0400", hash_original_field = "D10E65978F70513DFF3F1897F968D4D2", hash_generated_field = "5F4C99EEC421BEF559C61A599C6B6AA3")

    public static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.090 -0500", hash_original_method = "1B653DA1FDE36CFBF0835E42B933826F", hash_generated_method = "2AD70CF60BA8806F442FC59EDA433D46")
        
@Override
        public void setValue(View object, float value) {
            object.setScaleX(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.094 -0500", hash_original_method = "A2F336BAC519262505475338F6D5EC55", hash_generated_method = "1ADAC9D833516FDBFBC819CD2E997FCD")
        
@Override
        public Float get(View object) {
            return object.getScaleX();
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.690 -0400", hash_original_field = "5ABACA635607E234A6DDA7D7BAA57212", hash_generated_field = "F34310CAD52C1DF136CCDA6F7447C004")

    public static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.100 -0500", hash_original_method = "1D5FE7CAB5F43F92B9050D214C28178E", hash_generated_method = "6084E431D1414DCAABED371757EA914A")
        
@Override
        public void setValue(View object, float value) {
            object.setScaleY(value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.102 -0500", hash_original_method = "CDBF0205ED6FCB3C37D74DE97C039D1E", hash_generated_method = "AB5B2563CA606F92A17C97B8DF63BCBF")
        
@Override
        public Float get(View object) {
            return object.getScaleY();
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.255 -0500", hash_original_field = "D32DFF0B0DA4DB861D2B456FABF7A87B", hash_generated_field = "DD721D19F83A9531A571F53535845605")

    private SparseArray<Object> mKeyedTags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.259 -0500", hash_original_field = "DC909998A8596EA3C041A95E099FACA5", hash_generated_field = "1A75C99521C9A69968375361930C982C")

    protected Animation mCurrentAnimation = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.261 -0500", hash_original_field = "FBB9A3AE754134BC68B4DEECC8B8B680", hash_generated_field = "8AF08A92D2F66E40D67BD95DF20644CE")

    @ViewDebug.ExportedProperty(category = "measurement")
    int mMeasuredWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.263 -0500", hash_original_field = "37BAC234CA25DC79A22FDF95F5FE48E8", hash_generated_field = "92147C8788B6F0CA2DABA1FB3B19E8BF")

    @ViewDebug.ExportedProperty(category = "measurement")
    int mMeasuredHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.265 -0500", hash_original_field = "2D6D8008671A06EF61654718BEF765EB", hash_generated_field = "2D6D8008671A06EF61654718BEF765EB")

    boolean mRecreateDisplayList = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.268 -0500", hash_original_field = "7D9A9C01380EE3DF94249AA9EB3852B7", hash_generated_field = "AFA40CB29D8B77AA456CB799510E6286")

    @ViewDebug.ExportedProperty(resolveId = true)
    int mID = NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.270 -0500", hash_original_field = "CDDE4755ADE2BC204930CA88B5DBB470", hash_generated_field = "CDDE4755ADE2BC204930CA88B5DBB470")

    int mAccessibilityViewId = NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.272 -0500", hash_original_field = "87CC02BABEBC2A0BC6D4C7D0ADFF58E9", hash_generated_field = "91C972E269A3F4396E01E84D6E3CCC58")

    protected Object mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.423 -0500", hash_original_field = "C1B626405D887C389D9B720228461084", hash_generated_field = "7014A987CDECAA2300639BF21EC914DD")

    private int mOverScrollMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.425 -0500", hash_original_field = "5FDFF3475279625469C43AE9A0EDC8F1", hash_generated_field = "E798458702129E681480C3268D9EB850")

    protected ViewParent mParent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.428 -0500", hash_original_field = "7DACD6A85AA040B3D0EFA6ECFB8BF661", hash_generated_field = "7DACD6A85AA040B3D0EFA6ECFB8BF661")

    AttachInfo mAttachInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.431 -0500", hash_original_field = "F064260D53B54A571CA2DF8EFAEA3FFC", hash_generated_field = "4B9A7C2E7189666FEFF6FEA48770F96F")

    @ViewDebug.ExportedProperty(flagMapping = {
        @ViewDebug.FlagToString(mask = FORCE_LAYOUT, equals = FORCE_LAYOUT,
                name = "FORCE_LAYOUT"),
        @ViewDebug.FlagToString(mask = LAYOUT_REQUIRED, equals = LAYOUT_REQUIRED,
                name = "LAYOUT_REQUIRED"),
        @ViewDebug.FlagToString(mask = DRAWING_CACHE_VALID, equals = DRAWING_CACHE_VALID,
            name = "DRAWING_CACHE_INVALID", outputIf = false),
        @ViewDebug.FlagToString(mask = DRAWN, equals = DRAWN, name = "DRAWN", outputIf = true),
        @ViewDebug.FlagToString(mask = DRAWN, equals = DRAWN, name = "NOT_DRAWN", outputIf = false),
        @ViewDebug.FlagToString(mask = DIRTY_MASK, equals = DIRTY_OPAQUE, name = "DIRTY_OPAQUE"),
        @ViewDebug.FlagToString(mask = DIRTY_MASK, equals = DIRTY, name = "DIRTY")
    })
    int mPrivateFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.433 -0500", hash_original_field = "A70874573E565834837AE3AE1A44105E", hash_generated_field = "A70874573E565834837AE3AE1A44105E")

    int mPrivateFlags2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.435 -0500", hash_original_field = "BA594DC97B7780A916BA2DC51EC8AB28", hash_generated_field = "18478E9808210D74729295E4C33E2EEB")

    @ViewDebug.ExportedProperty(flagMapping = {
        @ViewDebug.FlagToString(mask = SYSTEM_UI_FLAG_LOW_PROFILE,
                                equals = SYSTEM_UI_FLAG_LOW_PROFILE,
                                name = "SYSTEM_UI_FLAG_LOW_PROFILE", outputIf = true),
        @ViewDebug.FlagToString(mask = SYSTEM_UI_FLAG_HIDE_NAVIGATION,
                                equals = SYSTEM_UI_FLAG_HIDE_NAVIGATION,
                                name = "SYSTEM_UI_FLAG_HIDE_NAVIGATION", outputIf = true),
        @ViewDebug.FlagToString(mask = PUBLIC_STATUS_BAR_VISIBILITY_MASK,
                                equals = SYSTEM_UI_FLAG_VISIBLE,
                                name = "SYSTEM_UI_FLAG_VISIBLE", outputIf = true)
    })
    int mSystemUiVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.437 -0500", hash_original_field = "AA3BA123C58FF5925198746B8B561359", hash_generated_field = "AA3BA123C58FF5925198746B8B561359")

    int mWindowAttachCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.440 -0500", hash_original_field = "F33EE352D598D00C07401D56E38E63E5", hash_generated_field = "AC04A604736B65491405D9541E300EF7")

    protected ViewGroup.LayoutParams mLayoutParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.442 -0500", hash_original_field = "AFB1E4C21C23303156B6C7C1DF32B89D", hash_generated_field = "D35E3C6B5D57FAA3D36920801FB7F998")

    @ViewDebug.ExportedProperty
    int mViewFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.492 -0500", hash_original_field = "814413531F598274EEECF8BE645FBF8D", hash_generated_field = "814413531F598274EEECF8BE645FBF8D")

    TransformationInfo mTransformationInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.494 -0500", hash_original_field = "6984E5F9EA6C46A4DE1DC2016BB38A0F", hash_generated_field = "62AEC70730E07CC33ABF33611E56E0C9")

    private boolean mLastIsOpaque;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.500 -0500", hash_original_field = "9CA1F6E0E5F07E62C54326FC8CE74F9B", hash_generated_field = "B0CFD8B13BD2121822E87395D9B5EB0A")

    @ViewDebug.ExportedProperty(category = "layout")
    protected int mLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.502 -0500", hash_original_field = "1142E2B2A4D06CFA9D8AC20A732F51BC", hash_generated_field = "51E02A5FF8AC135FCB771EE787BDB4C9")

    @ViewDebug.ExportedProperty(category = "layout")
    protected int mRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.505 -0500", hash_original_field = "A99CCC9E9A86D41F2B4D997ACBCFA99E", hash_generated_field = "496CBAA35C1D669530329F97A9C74114")

    @ViewDebug.ExportedProperty(category = "layout")
    protected int mTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.507 -0500", hash_original_field = "E3BE43E8597DE7EA48FEB065FD52A21A", hash_generated_field = "6F474ED228AC76685E91ED773CB73395")

    @ViewDebug.ExportedProperty(category = "layout")
    protected int mBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.509 -0500", hash_original_field = "E9A45ED540F0B589A497E7AFE99EBA3D", hash_generated_field = "1ACB7D4E721E5C41E8206F696A6DB2DB")

    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mScrollX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.512 -0500", hash_original_field = "EC6AD52CC705AA3985B25CDB13E68426", hash_generated_field = "3AE77EDF3F10D09CA5B3A9FC1C16B667")

    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mScrollY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.514 -0500", hash_original_field = "326069A740AFBF5612357DF58C737CA9", hash_generated_field = "0D018CC517023EE199B2A8DAA6ECB500")

    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.516 -0500", hash_original_field = "2C7F59811BB1389CABBA5E23A30ED558", hash_generated_field = "AEE809A9BA21DCA8517E2AD9D955D3B7")

    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.519 -0500", hash_original_field = "5587861E8E0DC5B536AD5267EDD36BA6", hash_generated_field = "12E040F5B926130031C2D0EA1ECAF1B8")

    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.522 -0500", hash_original_field = "5C33D3B454ED2C410EF31BCC552CD18D", hash_generated_field = "AB005070934C3278D46BFF088EA941B9")

    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.524 -0500", hash_original_field = "1D344C00C8D6A0BCC2A3B840B08C53BD", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.526 -0500", hash_original_field = "8527BF2BC0A9B123C2A72D09B48ECE06", hash_generated_field = "24275D1D330A85C524C74A0B09414AAB")

    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.529 -0500", hash_original_field = "65F4D07BE5AD879450E569FE04E04480", hash_generated_field = "0C4869EF67BF3E50F8F10A68C2F9D716")

    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.531 -0500", hash_original_field = "07B7D1BFF7147AB234612ED35E7E777C", hash_generated_field = "1BE3737E54325E6415262D1A90E67453")

    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.533 -0500", hash_original_field = "CEF8E1CF9387D00B0AAAD46881C0FEEA", hash_generated_field = "B3EF2958202B8FBC0F390975B72C0AB1")

    @ViewDebug.ExportedProperty(category = "padding")
    boolean mUserPaddingRelative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.535 -0500", hash_original_field = "9AF276E5897790D0CBFB8D2C4372C68B", hash_generated_field = "BFF4356AD8CC83E6872ED1781251B206")

    @ViewDebug.ExportedProperty(category = "padding")
    int mUserPaddingStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.538 -0500", hash_original_field = "2691A17E93076E6D2A0E2DF820C3457F", hash_generated_field = "C099602A54FEC808EF713AD0C3E426B1")

    @ViewDebug.ExportedProperty(category = "padding")
    int mUserPaddingEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.540 -0500", hash_original_field = "3BFE3DAC86E051A37E15269C1EBC8E4B", hash_generated_field = "3BFE3DAC86E051A37E15269C1EBC8E4B")

    int mOldWidthMeasureSpec = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.542 -0500", hash_original_field = "1C3D2A3A966DD51630301EB9B47C35E5", hash_generated_field = "1C3D2A3A966DD51630301EB9B47C35E5")

    int mOldHeightMeasureSpec = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.544 -0500", hash_original_field = "8DED670160BA0D0B412E0C192514A02D", hash_generated_field = "CD7692461BCF8CBA84620403F5E57E2E")

    private Drawable mBGDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.546 -0500", hash_original_field = "6AA99B95E451CC8F1A14306CBE838377", hash_generated_field = "EFFE71B257E8A8B334669D80482775BC")

    private int mBackgroundResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.548 -0500", hash_original_field = "1ED9015A29951D3930175999BDFEA77E", hash_generated_field = "308B2769E6A04DC50D717155A3FFF7C8")

    private boolean mBackgroundSizeChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.582 -0500", hash_original_field = "29D621A32636521FA6951DD85766CC20", hash_generated_field = "29D621A32636521FA6951DD85766CC20")

    ListenerInfo mListenerInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.584 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.587 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private  Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.589 -0500", hash_original_field = "4655D599215A99523DBA250F42E3AB03", hash_generated_field = "8ED80A3CDB45EFD1EC966904F18B0C41")

    private ScrollabilityCache mScrollCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.591 -0500", hash_original_field = "9FF022EC5A7D2C60D86BA4E6F0A4A115", hash_generated_field = "51C006923E88A244E6B4A81FAACDA6EF")

    private int[] mDrawableState = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.593 -0500", hash_original_field = "F305B07E5F44E36052F40F18E067A1D7", hash_generated_field = "8763FD238D26A060847D5BFD5F110B02")

    public boolean mCachingFailed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.596 -0500", hash_original_field = "4F91632C79F1BD6583CC66F5C52D3093", hash_generated_field = "3DD824BE1FD179F4F5718F6A857553E0")

    private Bitmap mDrawingCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.598 -0500", hash_original_field = "9B81A96752663FEDBF3E6DCFB64E02B1", hash_generated_field = "03126783BB83E37A27CE046D8A79B1C7")

    private Bitmap mUnscaledDrawingCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.600 -0500", hash_original_field = "03D545441F180AFAC72B88F62AC6BBCC", hash_generated_field = "CE60F7E3CE3B2722E2B23845AC923EB1")

    private HardwareLayer mHardwareLayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.602 -0500", hash_original_field = "4FBA01527B47AF659DF19EA16E769B16", hash_generated_field = "4FBA01527B47AF659DF19EA16E769B16")

    DisplayList mDisplayList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.604 -0500", hash_original_field = "7B2B69D603B5F474CE6FDBAB884E686E", hash_generated_field = "45B02C2955F0D136C014E9DC60FE3184")

    private int mNextFocusLeftId = View.NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.606 -0500", hash_original_field = "42A60EDFE4D5AFF27719E8557EFB56D5", hash_generated_field = "DF84F09C311C486A086B9C7EA2243503")

    private int mNextFocusRightId = View.NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.609 -0500", hash_original_field = "235BEA16E14779B69B3D13F7BCEE83D7", hash_generated_field = "9F4730280C31C2719C1F46BE8E8450BA")

    private int mNextFocusUpId = View.NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.612 -0500", hash_original_field = "D3D9F31795AFC6FA0E4C5924511AB768", hash_generated_field = "319D75290A4647F72AD3D5A42A864E5C")

    private int mNextFocusDownId = View.NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.614 -0500", hash_original_field = "218707A9C3C12F8433C4FECF627C213D", hash_generated_field = "218707A9C3C12F8433C4FECF627C213D")

    int mNextFocusForwardId = View.NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.616 -0500", hash_original_field = "39A3A6C60445CD08D83FC3B94CFC91FD", hash_generated_field = "AAAA968A40447481F73888524A1890C6")

    private CheckForLongPress mPendingCheckForLongPress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.618 -0500", hash_original_field = "FC6D4B791784AFA9C1F0E5FD65A3BFD0", hash_generated_field = "B8AF3727C0596C63ED7DB54BAD71671F")

    private CheckForTap mPendingCheckForTap = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.620 -0500", hash_original_field = "3853D7701070BE7EA3CAD588426AEF3E", hash_generated_field = "99E4AAED357F9D1925CADBAC4D6015A4")

    private PerformClick mPerformClick;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.623 -0500", hash_original_field = "CF4F38BD3F2976A6CF553D0ED4767DAB", hash_generated_field = "4EE5120DCD6EBA553548CD3C570A5967")

    private SendViewScrolledAccessibilityEvent mSendViewScrolledAccessibilityEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.625 -0500", hash_original_field = "B2618BEA938596EE541434BC5F385EE0", hash_generated_field = "CDF30A3821A23955C4124811C1CA0AEA")

    private UnsetPressedState mUnsetPressedState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.627 -0500", hash_original_field = "B3D1C0F5B2BD7B4A1A5A1B69F45F3629", hash_generated_field = "751618E4ED7D5DBDA5B68F37D9865720")

    private boolean mHasPerformedLongPress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.629 -0500", hash_original_field = "0DD4F81D09F8349C333039CCE34B2CF7", hash_generated_field = "F1A8CDC4E26D8D5C7DE32B2AF25C8740")

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mMinHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.631 -0500", hash_original_field = "B5D566AA92521F570066E8773A24B0C0", hash_generated_field = "4FCEB583348C4614E548F5AFAEC98A67")

    @ViewDebug.ExportedProperty(category = "measurement")
    private int mMinWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.634 -0500", hash_original_field = "B47D8F983141BDD6DE23721E2C8953EC", hash_generated_field = "E569734BF8D6E083A22CF46961923ECB")

    private TouchDelegate mTouchDelegate = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.636 -0500", hash_original_field = "7104BF44EAFC90B4BB03FA6058DD1F90", hash_generated_field = "D92790A9877C98F11E8F179FB043C786")

    private int mDrawingCacheBackgroundColor = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.638 -0500", hash_original_field = "3E06290B5DEF9E06AC578D93D42C765D", hash_generated_field = "A0D36EEAADCE4EE07A5AC99F73C584E9")

    private ViewTreeObserver mFloatingTreeObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.641 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.643 -0500", hash_original_field = "4C48F561518A000E8B16980E4BAE7396", hash_generated_field = "031DB2A7C2250D8B7DE4F6272C82D45E")

    private ViewPropertyAnimator mAnimator = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.647 -0500", hash_original_field = "337286FBC16FB01EBDC401FE1B5704CE", hash_generated_field = "2607C5FC6CCACC3F7D721707ADA72671")

    private float mVerticalScrollFactor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.650 -0500", hash_original_field = "13469CC6FA3BEBB2A9BF70A4D43D1327", hash_generated_field = "4F21705D0823B901E43594B264DCB237")

    private int mVerticalScrollbarPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.668 -0500", hash_original_field = "E5A07826446E84312680E03AD4CB174D", hash_generated_field = "76D9A2089F38CDD618BD49C87D710C3C")

    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
            @ViewDebug.IntToString(from = LAYER_TYPE_NONE, to = "NONE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_SOFTWARE, to = "SOFTWARE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_HARDWARE, to = "HARDWARE")
    })
    int mLayerType = LAYER_TYPE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.670 -0500", hash_original_field = "DF81DF3E7FE84B1D663D7E8ECAF0C794", hash_generated_field = "DF81DF3E7FE84B1D663D7E8ECAF0C794")

    Paint mLayerPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.672 -0500", hash_original_field = "5423282DE76FBF7AAAD365160A805585", hash_generated_field = "5423282DE76FBF7AAAD365160A805585")

    Rect mLocalDirtyRect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.674 -0500", hash_original_field = "B4380681A3C04B2FC9E12D5B683FDE21", hash_generated_field = "D73DE13E5337A6B5E189A73C651B0933")

    private boolean mSendingHoverAccessibilityEvents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.676 -0500", hash_original_field = "ACE9AD3D63F4A66B9F893798ED18776A", hash_generated_field = "ACE9AD3D63F4A66B9F893798ED18776A")

    AccessibilityDelegate mAccessibilityDelegate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.693 -0500", hash_original_field = "8BD51FA0940422294A95B1E8805CB98D", hash_generated_field = "B72A5C45BF32E84602E6733FBFEC7DAD")

    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    })
    private int mTextDirection = DEFAULT_TEXT_DIRECTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.696 -0500", hash_original_field = "565CE8DC793380101632225435F58070", hash_generated_field = "318F54594F0F5ED162811E42E0595AEA")

    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    })
    private int mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.698 -0500", hash_original_field = "91D8782EBDEF9C65BF9D8D5A67EE9546", hash_generated_field = "FBF46F0211B74BEC9C47C5EFFAF36A72")

    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
                    @DSVerified
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public View(Context context){
		mContext = context;
		onSizeChanged(0,0,0,0);
        onDraw(new Canvas());
        mResources = context.getResources();
        mKeyedTags = new SparseArray<Object>();
        
        droidsafeCallbackHook();
        droidsafeOverridingMethodHook();
        
        //initialize listenerinfo
        getListenerInfo();
        
		/*
		mContext = context;
		mResources = context != null ? context.getResources() : null;
		mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED | LAYOUT_DIRECTION_INHERIT;
		mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
		setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
		mUserPaddingStart = -1;
		mUserPaddingEnd = -1;
		mUserPaddingRelative = false;
		*/
	}

    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     *
     * <p>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *        access the current theme, resources, etc.
     * @param attrs The attributes of the XML tag that is inflating the view.
     * @see #View(Context, AttributeSet, int)
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.705 -0500", hash_original_method = "7A0AD99F840E8369EC476A6B56BA8ADA", hash_generated_method = "A09B7F6F117B98E786ADFB55C19B5992")
    @DSVerified
public View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSVerified
    public View(Context context, AttributeSet attrs, int defStyle){
		this(context);
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSVerified
    View(){
		this(new ContextImpl());
		droidsafeCallbackHook();
        droidsafeOverridingMethodHook();
		/*
		mResources = null;
		*/
	}
	
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSVerified
    public View(droidsafe.helpers.DSOnlyType dontcare) {
       this(); 
    }
    
    protected void initializeFadingEdge(TypedArray a){
		// Original method
		/*
		{
        initScrollCache();
        mScrollCache.fadingEdgeLength = a.getDimensionPixelSize(
                R.styleable.View_fadingEdgeLength,
                ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
    }
		*/
		//Return nothing
	}
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeCallbackHook(){
        onCheckIsTextEditor();
        onCloseSystemDialogs(new String());
        onCreateInputConnection(new EditorInfo());

        onWindowFocusChanged(getTaintBoolean());
        onDragEvent(DragEvent.obtain());
        onFilterTouchEventForSecurity(new MotionEvent());

        onHoverChanged(getTaintBoolean());
        onHoverEvent(new MotionEvent());
        onTouchEvent(new MotionEvent());
        onTrackballEvent(new MotionEvent());
        onGenericMotionEvent(new MotionEvent());

        onInitializeAccessibilityEvent(new AccessibilityEvent(DSUtils.FAKE_INT));
        onInitializeAccessibilityNodeInfo(new AccessibilityNodeInfo(DSOnlyType.NOT_USED));

        onKeyDown(getTaintInt(), new KeyEvent()); 
        onKeyUp(getTaintInt(), new KeyEvent());
        onKeyLongPress(getTaintInt(), new KeyEvent());
        onKeyShortcut(getTaintInt(), new KeyEvent());
        onKeyPreIme(getTaintInt(), new KeyEvent());
        onKeyMultiple(getTaintInt(), getTaintInt(), new KeyEvent());

        onPopulateAccessibilityEvent(new AccessibilityEvent(DSUtils.FAKE_INT));
        onStartTemporaryDetach();
        onMeasure(getTaintInt(),  getTaintInt());

        onAnimationStart();
        onAnimationEnd();
        
        onConfigurationChanged(new Configuration());
        
        Parcelable state = onSaveInstanceState();
        if (state != null)
            onRestoreInstanceState(state);
        
        onVisibilityChanged(this, DSUtils.FAKE_INT);
        
    }
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeOverridingMethodHook() {
        computeHorizontalScrollExtent();
        computeHorizontalScrollOffset();
        computeHorizontalScrollRange();
        computeOpaqueFlags();

        computeVerticalScrollExtent();
        computeVerticalScrollOffset();
        computeVerticalScrollRange();
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getVerticalFadingEdgeLength(){
		// Original method
		/*
		{
        if (isVerticalFadingEdgeEnabled()) {
            ScrollabilityCache cache = mScrollCache;
            if (cache != null) {
                return cache.fadingEdgeLength;
            }
        }
        return 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setFadingEdgeLength(int length){
		// Original method
		/*
		{
        initScrollCache();
        mScrollCache.fadingEdgeLength = length;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getHorizontalFadingEdgeLength(){
		// Original method
		/*
		{
        if (isHorizontalFadingEdgeEnabled()) {
            ScrollabilityCache cache = mScrollCache;
            if (cache != null) {
                return cache.fadingEdgeLength;
            }
        }
        return 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getVerticalScrollbarWidth(){
		// Original method
		/*
		{
        ScrollabilityCache cache = mScrollCache;
        if (cache != null) {
            ScrollBarDrawable scrollBar = cache.scrollBar;
            if (scrollBar != null) {
                int size = scrollBar.getSize(true);
                if (size <= 0) {
                    size = cache.scrollBarSize;
                }
                return size;
            }
            return 0;
        }
        return 0;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected int getHorizontalScrollbarHeight(){
		// Original method
		/*
		{
        ScrollabilityCache cache = mScrollCache;
        if (cache != null) {
            ScrollBarDrawable scrollBar = cache.scrollBar;
            if (scrollBar != null) {
                int size = scrollBar.getSize(false);
                if (size <= 0) {
                    size = cache.scrollBarSize;
                }
                return size;
            }
            return 0;
        }
        return 0;
    }
		*/
		return 0;
	}
    
    protected void initializeScrollbars(TypedArray a){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void initScrollCache(){
		// Original method
		/*
		{
        if (mScrollCache == null) {
            mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setVerticalScrollbarPosition(int position){
		// Original method
		/*
		{
        if (mVerticalScrollbarPosition != position) {
            mVerticalScrollbarPosition = position;
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getVerticalScrollbarPosition(){
		return getTaintInt();
		// Original method
		/*
		{
        return mVerticalScrollbarPosition;
    }
		*/
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.751 -0500", hash_original_method = "3F6307E0FF2B24CF42D639D72702E7A3", hash_generated_method = "3F6307E0FF2B24CF42D639D72702E7A3")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    ListenerInfo getListenerInfo() {
        if (mListenerInfo != null) {
            return mListenerInfo;
        }
        mListenerInfo = new ListenerInfo();
        return mListenerInfo;
    }

    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setOnFocusChangeListener(OnFocusChangeListener l){
		// Original method
        getListenerInfo().mOnFocusChangeListener = l;
        if (l != null) {
            l.onFocusChange(this, DSUtils.UNKNOWN_BOOLEAN);
        }
		//Return nothing
	}
    
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener){
		// Original method
        ListenerInfo li = getListenerInfo();
        if (li.mOnLayoutChangeListeners == null) {
            li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        }
        if (!li.mOnLayoutChangeListeners.contains(listener)) {
            li.mOnLayoutChangeListeners.add(listener);
        }
		//Return nothing
	}
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li == null || li.mOnLayoutChangeListeners == null) {
            return;
        }
        li.mOnLayoutChangeListeners.remove(listener);
    }
		*/
		//Return nothing
	}
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK) 
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener){
		// Original method
        ListenerInfo li = getListenerInfo();
        if (li.mOnAttachStateChangeListeners == null) {
            li.mOnAttachStateChangeListeners
                    = new CopyOnWriteArrayList<OnAttachStateChangeListener>();
        }
        li.mOnAttachStateChangeListeners.add(listener);
        if (listener != null) {
            listener.onViewAttachedToWindow(this);
            listener.onViewDetachedFromWindow(this);
        }
	}
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li == null || li.mOnAttachStateChangeListeners == null) {
            return;
        }
        li.mOnAttachStateChangeListeners.remove(listener);
    }
		*/
		//Return nothing
	}
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
    public OnFocusChangeListener getOnFocusChangeListener(){
		// Original method
        ListenerInfo li = mListenerInfo;
        return li != null ? li.mOnFocusChangeListener : null;
	}
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
	public void setOnClickListener(OnClickListener l){
		l.onClick(this);
        getListenerInfo().mOnClickListener = l;
		// Original method
		/*
		{
        if (!isClickable()) {
            setClickable(true);
        }
    }
		*/
		//Return nothing
	}
	
    @DSVerified
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean hasOnClickListeners(){
		// Original method
        ListenerInfo li = mListenerInfo;
        return (li != null && li.mOnClickListener != null);
	}
    
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)	
	public void setOnLongClickListener(OnLongClickListener l){
		// Original method
		/*
		{
        if (!isLongClickable()) {
            setLongClickable(true);
        }
    }
		*/
		//Return nothing
        getListenerInfo().mOnLongClickListener = l;
		l.onLongClick(this);
	}
	 
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK) 
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l){
		// Original method
		/*
		{
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        getListenerInfo().mOnCreateContextMenuListener = l;
    }
		*/
		//Return nothing
        getListenerInfo().mOnCreateContextMenuListener = l;
        if (l != null) {
            l.onCreateContextMenu(new ContextMenu.DroidSafeContextMenu(), 
                    this, new AdapterView.AdapterContextMenuInfo(this, 
                            DSUtils.FAKE_INT, DSUtils.FAKE_INT));
        }
    
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean performClick(){
		// Original method
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnClickListener != null) {
            playSoundEffect(SoundEffectConstants.CLICK);
            li.mOnClickListener.onClick(this);
            return true;
        }
        return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean callOnClick(){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnClickListener != null) {
            li.mOnClickListener.onClick(this);
            return true;
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean performLongClick(){
		// Original method
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED);
        boolean handled = false;
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnLongClickListener != null) {
            handled = li.mOnLongClickListener.onLongClick(View.this);
        }
        if (!handled) {
            handled = showContextMenu();
        }
        if (handled) {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        }
        return handled;
	}
    
    protected boolean performButtonActionOnTouchDown(MotionEvent event){
		// Original method
		/*
		{
        if ((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0) {
            if (showContextMenu(event.getX(), event.getY(), event.getMetaState())) {
                return true;
            }
        }
        return false;
    }
		*/
		return false;
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean showContextMenu(){
		// Original method
		/*
		{
        return getParent().showContextMenuForChild(this);
    }
		*/
		return false;
	}
    
    public boolean showContextMenu(float x, float y, int metaState){
		// Original method
		/*
		{
        return showContextMenu();
    }
		*/
		return false;
	}
    
    public ActionMode startActionMode(ActionMode.Callback callback){
		// Original method
		/*
		{
        return getParent().startActionModeForChild(this, callback);
    }
		*/
        if (callback != null) {
            ActionMode am = new ActionMode.SimpleActionMode();
            return am;
        }
        
		return null;
	}

    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setOnKeyListener(OnKeyListener l){
		// Original method
		/*
		*/
		//Return nothing
        getListenerInfo().mOnKeyListener = l;
        if (l != null) {
            l.onKey(this,  DSUtils.FAKE_INT, new KeyEvent());
        }
	}
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setOnTouchListener(OnTouchListener l){
        if (l != null) {
            l.onTouch(this, new MotionEvent());
        }
        getListenerInfo().mOnTouchListener = l;
		//Return nothing
	}
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setOnGenericMotionListener(OnGenericMotionListener l){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
        if (l != null) {
            l.onGenericMotion(this, new MotionEvent());
        }
        getListenerInfo().mOnGenericMotionListener = l;
	}
    
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setOnHoverListener(OnHoverListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnHoverListener = l;
    }
		*/
		//Return nothing
        if (l != null) {
            l.onHover(this, new MotionEvent());
        }
	}
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void setOnDragListener(OnDragListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnDragListener = l;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void handleFocusGainInternal(int direction, Rect previouslyFocusedRect){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " requestFocus()");
        }
        if ((mPrivateFlags & FOCUSED) == 0) {
            mPrivateFlags |= FOCUSED;
            if (mParent != null) {
                mParent.requestChildFocus(this, this);
            }
            onFocusChanged(true, direction, previouslyFocusedRect);
            refreshDrawableState();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean requestRectangleOnScreen(Rect rectangle){
		// Original method
		/*
		{
        return requestRectangleOnScreen(rectangle, false);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate){
		// Original method
		/*
		{
        View child = this;
        ViewParent parent = mParent;
        boolean scrolled = false;
        while (parent != null) {
            scrolled |= parent.requestChildRectangleOnScreen(child,
                    rectangle, immediate);
            rectangle.offset(child.getLeft(), child.getTop());
            rectangle.offset(-child.getScrollX(), -child.getScrollY());
            if (!(parent instanceof View)) {
                break;
            }
            child = (View) parent;
            parent = child.getParent();
        }
        return scrolled;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSVerified
    public void clearFocus(){
        if ((mPrivateFlags & FOCUSED) != 0) {
            mPrivateFlags &= ~FOCUSED;
            if (mParent != null) {
                mParent.clearChildFocus(this);
            }
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        }
	}
    
    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void clearFocusForRemoval(){
		// Original method
        if ((mPrivateFlags & FOCUSED) != 0) {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        }
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void unFocus(){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " unFocus()");
        }
		*/
        if ((mPrivateFlags & FOCUSED) != 0) {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        }
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="focus") public boolean hasFocus(){
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean hasFocusable(){
		// Original method
		/*
		{
        return (mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable();
    }
		*/
		return false;
	}
    
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void sendAccessibilityEvent(int eventType){
		// Original method
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.sendAccessibilityEvent(this, eventType);
        } else {
            sendAccessibilityEventInternal(eventType);
        }
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSVerified
    void sendAccessibilityEventInternal(int eventType){
		// Original method
        if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
        }
		//Return nothing
	}
    
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSVerified
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event){
		// Original method
        if (mAccessibilityDelegate != null) {
           mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, event);
        } else {
            sendAccessibilityEventUncheckedInternal(event);
        }
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void sendAccessibilityEventUncheckedInternal(AccessibilityEvent event){
		// Original method
        if (!isShown()) {
            return;
        }
        onInitializeAccessibilityEvent(event);
        if ((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0) {
            dispatchPopulateAccessibilityEvent(event);
        }
        getParent().requestSendAccessibilityEvent(this, event);
		//Return nothing
	}
    
    @DSVerified
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event){
		// Original method
        if (mAccessibilityDelegate != null) {
            return mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event);
        } else {
            return dispatchPopulateAccessibilityEventInternal(event);
        }
	}
    
    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event){
		// Original method
        onPopulateAccessibilityEvent(event);
        return false;
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onPopulateAccessibilityEvent(AccessibilityEvent event){
		// Original method
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.onPopulateAccessibilityEvent(this, event);
        } else {
            onPopulateAccessibilityEventInternal(event);
        }
		//Return nothing
	}

    /**
     * @see #onPopulateAccessibilityEvent(AccessibilityEvent)
     *
     * Note: Called from the default {@link AccessibilityDelegate}.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.845 -0500", hash_original_method = "CF40AA9C4C55BD5A22FC0E76716C7875", hash_generated_method = "CF40AA9C4C55BD5A22FC0E76716C7875")
    
void onPopulateAccessibilityEventInternal(AccessibilityEvent event) {

    }
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onInitializeAccessibilityEvent(AccessibilityEvent event){
		// Original method
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.onInitializeAccessibilityEvent(this, event);
        } else {
            onInitializeAccessibilityEventInternal(event);
        }
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void onInitializeAccessibilityEventInternal(AccessibilityEvent event){
		// Original method
		/*
		{
        event.setSource(this);
        event.setClassName(getClass().getName());
        event.setPackageName(getContext().getPackageName());
        event.setEnabled(isEnabled());
        event.setContentDescription(mContentDescription);
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null) {
            ArrayList<View> focusablesTempList = mAttachInfo.mFocusablesTempList;
            getRootView().addFocusables(focusablesTempList, View.FOCUS_FORWARD,
                    FOCUSABLES_ALL);
            event.setItemCount(focusablesTempList.size());
            event.setCurrentItemIndex(focusablesTempList.indexOf(this));
            focusablesTempList.clear();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public AccessibilityNodeInfo createAccessibilityNodeInfo(){
		// Original method
		/*
		{
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(this);
        onInitializeAccessibilityNodeInfo(info);
        return info;
    }
		*/
		return null;
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info){
		// Original method
        if (mAccessibilityDelegate != null) {
            mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, info);
        } else {
            onInitializeAccessibilityNodeInfoInternal(info);
        }
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Sets a delegate for implementing accessibility support via compositon as
     * opposed to inheritance. The delegate's primary use is for implementing
     * backwards compatible widgets. For more details see {@link AccessibilityDelegate}.
     *
     * @param delegate The delegate instance.
     *
     * @see AccessibilityDelegate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.860 -0500", hash_original_method = "32F138BD45B7179C5519FF8B12AC5296", hash_generated_method = "A12D9A93F2041EE5B4A76AE71737ABA4")
    
public void setAccessibilityDelegate(AccessibilityDelegate delegate) {
        mAccessibilityDelegate = delegate;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getAccessibilityViewId(){
		return getTaintInt();
		// Original method
		/*
		{
        if (mAccessibilityViewId == NO_ID) {
            mAccessibilityViewId = sNextAccessibilityViewId++;
        }
        return mAccessibilityViewId;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getAccessibilityWindowId(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mAccessibilityWindowId : NO_ID;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CharSequence getContentDescription(){
		return (CharSequence)getTaint();
		// Original method
		/*
		{
        return mContentDescription;
    }
		*/
	}

    /**
     * Sets the {@link View} description. It briefly describes the view and is
     * primarily used for accessibility support. Set this property to enable
     * better accessibility support for your application. This is especially
     * true for views that do not have textual representation (For example,
     * ImageButton).
     *
     * @param contentDescription The content description.
     *
     * @attr ref android.R.styleable#View_contentDescription
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.869 -0500", hash_original_method = "1087954D5CDD3C4C18E361D3DD728844", hash_generated_method = "E7506C565B70EA60CE75091BFC1B17BA")
    
@RemotableViewMethod
    public void setContentDescription(CharSequence contentDescription) {
        mContentDescription = contentDescription;
    }
    
    protected void onFocusLost(){
		// Original method
		/*
		{
        resetPressedState();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void resetPressedState(){
		// Original method
		/*
		{
        if ((mViewFlags & ENABLED_MASK) == DISABLED) {
            return;
        }
        if (isPressed()) {
            setPressed(false);
            if (!mHasPerformedLongPress) {
                removeLongPressCallback();
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="focus") public boolean isFocused(){
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public View findFocus(){
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0 ? this : null;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setScrollContainer(boolean isScrollContainer){
		// Original method
		/*
		{
        if (isScrollContainer) {
            if (mAttachInfo != null && (mPrivateFlags&SCROLL_CONTAINER_ADDED) == 0) {
                mAttachInfo.mScrollContainers.add(this);
                mPrivateFlags |= SCROLL_CONTAINER_ADDED;
            }
            mPrivateFlags |= SCROLL_CONTAINER;
        } else {
            if ((mPrivateFlags&SCROLL_CONTAINER_ADDED) != 0) {
                mAttachInfo.mScrollContainers.remove(this);
            }
            mPrivateFlags &= ~(SCROLL_CONTAINER|SCROLL_CONTAINER_ADDED);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDrawingCacheQuality(){
		// Original method
		/*
		{
        return mViewFlags & DRAWING_CACHE_QUALITY_MASK;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setDrawingCacheQuality(int quality){
		// Original method
		/*
		{
        setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean getKeepScreenOn(){
		// Original method
		/*
		{
        return (mViewFlags & KEEP_SCREEN_ON) != 0;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setKeepScreenOn(boolean keepScreenOn){
		// Original method
		/*
		{
        setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getNextFocusLeftId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusLeftId;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setNextFocusLeftId(int nextFocusLeftId){
		addTaint(nextFocusLeftId);
		// Original method
		/*
		{
        mNextFocusLeftId = nextFocusLeftId;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getNextFocusRightId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusRightId;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setNextFocusRightId(int nextFocusRightId){
		addTaint(nextFocusRightId);
		// Original method
		/*
		{
        mNextFocusRightId = nextFocusRightId;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getNextFocusUpId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusUpId;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setNextFocusUpId(int nextFocusUpId){
		addTaint(nextFocusUpId);
		// Original method
		/*
		{
        mNextFocusUpId = nextFocusUpId;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getNextFocusDownId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusDownId;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setNextFocusDownId(int nextFocusDownId){
		addTaint(nextFocusDownId);
		// Original method
		/*
		{
        mNextFocusDownId = nextFocusDownId;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getNextFocusForwardId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mNextFocusForwardId;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setNextFocusForwardId(int nextFocusForwardId){
		addTaint(nextFocusForwardId);
		// Original method
		/*
		{
        mNextFocusForwardId = nextFocusForwardId;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isShown(){
		// Original method
		/*
		{
        View current = this;
        do {
            if ((current.mViewFlags & VISIBILITY_MASK) != VISIBLE) {
                return false;
            }
            ViewParent parent = current.mParent;
            if (parent == null) {
                return false; 
            }
            if (!(parent instanceof View)) {
                return true;
            }
            current = (View) parent;
        } while (current != null);
        return false;
    }
		*/
		return false;
	}
    
    protected boolean fitSystemWindows(Rect insets){
		// Original method
		/*
		{
        if ((mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS) {
            mPaddingLeft = insets.left;
            mPaddingTop = insets.top;
            mPaddingRight = insets.right;
            mPaddingBottom = insets.bottom;
            requestLayout();
            return true;
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setFitsSystemWindows(boolean fitSystemWindows){
		// Original method
		/*
		{
        setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean fitsSystemWindows(){
		// Original method
		/*
		{
        return (mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS;
    }
		*/
		return false;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(mapping={@ViewDebug.IntToString(from=VISIBLE,to="VISIBLE"),@ViewDebug.IntToString(from=INVISIBLE,to="INVISIBLE"),@ViewDebug.IntToString(from=GONE,to="GONE")}) 
	public int getVisibility(){
		// Original method
		/*
		{
        return mViewFlags & VISIBILITY_MASK;
    }
		*/
		return 0;
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @RemotableViewMethod 
	public void setVisibility(int visibility){
		addTaint(visibility);
		// Original method
		/*
		{
        setFlags(visibility, VISIBILITY_MASK);
        if (mBGDrawable != null) mBGDrawable.setVisible(visibility == VISIBLE, false);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public boolean isEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & ENABLED_MASK) == ENABLED;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @RemotableViewMethod 
	public void setEnabled(boolean enabled){
		// Original method
		/*
		{
        if (enabled == isEnabled()) return;
        setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
        refreshDrawableState();
        invalidate(true);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setFocusable(boolean focusable){
		// Original method
		/*
		{
        if (!focusable) {
            setFlags(0, FOCUSABLE_IN_TOUCH_MODE);
        }
        setFlags(focusable ? FOCUSABLE : NOT_FOCUSABLE, FOCUSABLE_MASK);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setFocusableInTouchMode(boolean focusableInTouchMode){
		// Original method
		/*
		{
        setFlags(focusableInTouchMode ? FOCUSABLE_IN_TOUCH_MODE : 0, FOCUSABLE_IN_TOUCH_MODE);
        if (focusableInTouchMode) {
            setFlags(FOCUSABLE, FOCUSABLE_MASK);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled){
		// Original method
		/*
		{
        setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public boolean isSoundEffectsEnabled(){
		// Original method
		/*
		{
        return SOUND_EFFECTS_ENABLED == (mViewFlags & SOUND_EFFECTS_ENABLED);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled){
		// Original method
		/*
		{
        setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public boolean isHapticFeedbackEnabled(){
		// Original method
		/*
		{
        return HAPTIC_FEEDBACK_ENABLED == (mViewFlags & HAPTIC_FEEDBACK_ENABLED);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(category="layout",mapping={@ViewDebug.IntToString(from=LAYOUT_DIRECTION_LTR,to="LTR"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_RTL,to="RTL"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_INHERIT,to="INHERIT"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_LOCALE,to="LOCALE")}) 
	public int getLayoutDirection(){
		// Original method
		/*
		{
        return mViewFlags & LAYOUT_DIRECTION_MASK;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @RemotableViewMethod 
	public void setLayoutDirection(int layoutDirection){
		// Original method
		/*
		{
        if (getLayoutDirection() != layoutDirection) {
            resetResolvedLayoutDirection();
            setFlags(layoutDirection, LAYOUT_DIRECTION_MASK);
        }
    }
		*/
		//Return nothing
	}
    
    @ViewDebug.ExportedProperty(category="layout",mapping={@ViewDebug.IntToString(from=LAYOUT_DIRECTION_LTR,to="RESOLVED_DIRECTION_LTR"),@ViewDebug.IntToString(from=LAYOUT_DIRECTION_RTL,to="RESOLVED_DIRECTION_RTL")}) 
	public int getResolvedLayoutDirection(){
		// Original method
		/*
		{
        resolveLayoutDirectionIfNeeded();
        return ((mPrivateFlags2 & LAYOUT_DIRECTION_RESOLVED_RTL) == LAYOUT_DIRECTION_RESOLVED_RTL) ?
                LAYOUT_DIRECTION_RTL : LAYOUT_DIRECTION_LTR;
    }
		*/
		return 0;
	}
    
    @ViewDebug.ExportedProperty(category="layout") 
	public boolean isLayoutRtl(){
		// Original method
		/*
		{
        return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setWillNotDraw(boolean willNotDraw){
		// Original method
		/*
		{
        setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean willNotDraw(){
		// Original method
		/*
		{
        return (mViewFlags & DRAW_MASK) == WILL_NOT_DRAW;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing){
		// Original method
		/*
		{
        setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean willNotCacheDrawing(){
		// Original method
		/*
		{
        return (mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public boolean isClickable(){
		// Original method
		/*
		{
        return (mViewFlags & CLICKABLE) == CLICKABLE;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setClickable(boolean clickable){
		// Original method
		/*
		{
        setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isLongClickable(){
		// Original method
		/*
		{
        return (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setLongClickable(boolean longClickable){
		// Original method
		/*
		{
        setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setPressed(boolean pressed){
		// Original method
		/*
		{
        if (pressed) {
            mPrivateFlags |= PRESSED;
        } else {
            mPrivateFlags &= ~PRESSED;
        }
        refreshDrawableState();
        dispatchSetPressed(pressed);
    }
		*/
		//Return nothing
	}

    /**
     * Dispatch setPressed to all of this View's children.
     *
     * @see #setPressed(boolean)
     *
     * @param pressed The new pressed state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.982 -0500", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "22E38040A7A6D9A82107019B4DCBEFC9")
    
protected void dispatchSetPressed(boolean pressed) {
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isPressed(){
		// Original method
		/*
		{
        return (mPrivateFlags & PRESSED) == PRESSED;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isSaveEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & SAVE_DISABLED_MASK) != SAVE_DISABLED;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSaveEnabled(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public boolean getFilterTouchesWhenObscured(){
		// Original method
		/*
		{
        return (mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setFilterTouchesWhenObscured(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                FILTER_TOUCHES_WHEN_OBSCURED);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isSaveFromParentEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSaveFromParentEnabled(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="focus") 
	public final boolean isFocusable(){
		// Original method
		/*
		{
        return FOCUSABLE == (mViewFlags & FOCUSABLE_MASK);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public final boolean isFocusableInTouchMode(){
		// Original method
		/*
		{
        return FOCUSABLE_IN_TOUCH_MODE == (mViewFlags & FOCUSABLE_IN_TOUCH_MODE);
    }
		*/
		return false;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public View focusSearch(int direction){
		// Original method
        if (mParent != null) {
            return mParent.focusSearch(this, direction);
        } else {
            return null;
        }
	}

    /**
     * This method is the last chance for the focused view and its ancestors to
     * respond to an arrow key. This is called when the focused view did not
     * consume the key internally, nor could the view system find a new view in
     * the requested direction to give focus to.
     *
     * @param focused The currently focused view.
     * @param direction The direction focus wants to move. One of FOCUS_UP,
     *        FOCUS_DOWN, FOCUS_LEFT, and FOCUS_RIGHT.
     * @return True if the this view consumed this unhandled move.
     */
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.008 -0500", hash_original_method = "3A7E0D4CA01222234C5493EC87211574", hash_generated_method = "FC584848E967C1F8159AB204C291F20A")
    
public boolean dispatchUnhandledMove(View focused, int direction) {
        return false;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    View findUserSetNextFocus(View root, int direction){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}
    
    private View findViewInsideOutShouldExist(View root, final int childViewId){
		// Original method
		/*
		{
        View result = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
            @Override
            public boolean apply(View t) {
                return t.mID == childViewId;
            }
        });
        if (result == null) {
            Log.w(VIEW_LOG_TAG, "couldn't find next focus view specified "
                    + "by user for id " + childViewId);
        }
        return result;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public ArrayList<View> getFocusables(int direction){
		// Original method
		/*
		{
        ArrayList<View> result = new ArrayList<View>(24);
        addFocusables(result, direction);
        return result;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addFocusables(ArrayList<View> views, int direction){
		// Original method
		/*
		{
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode){
		// Original method
		/*
		{
        if (!isFocusable()) {
            return;
        }
        if ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        if (views != null) {
            views.add(this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags){
		// Original method
		/*
		{
        if ((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                && !TextUtils.isEmpty(mContentDescription)) {
            String searchedLowerCase = searched.toString().toLowerCase();
            String contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
            if (contentDescriptionLowerCase.contains(searchedLowerCase)) {
                outViews.add(this);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public ArrayList<View> getTouchables(){
		// Original method
		/*
		{
        ArrayList<View> result = new ArrayList<View>();
        addTouchables(result);
        return result;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addTouchables(ArrayList<View> views){
		// Original method
		/*
		{
        final int viewFlags = mViewFlags;
        if (((viewFlags & CLICKABLE) == CLICKABLE || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)
                && (viewFlags & ENABLED_MASK) == ENABLED) {
            views.add(this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final boolean requestFocus(){
		// Original method
		/*
		{
        return requestFocus(View.FOCUS_DOWN);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final boolean requestFocus(int direction){
		// Original method
		/*
		{
        return requestFocus(direction, null);
    }
		*/
		return false;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean requestFocus(int direction, Rect previouslyFocusedRect){
		// Original method
        if ((mViewFlags & FOCUSABLE_MASK) != FOCUSABLE ||
                (mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            return false;
        }
        if (isInTouchMode() &&
            (FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE))) {
               return false;
        }
        if (hasAncestorThatBlocksDescendantFocus()) {
            return false;
        }
        handleFocusGainInternal(direction, previouslyFocusedRect);
        return true;
	}
    
    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    ViewRootImpl getViewRootImpl(){
		// Original method
        View root = getRootView();
        return root != null ? (ViewRootImpl)root.getParent() : null;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final boolean requestFocusFromTouch(){
		// Original method
        if (isInTouchMode()) {
            ViewRootImpl viewRoot = getViewRootImpl();
            if (viewRoot != null) {
                viewRoot.ensureTouchMode(false);
            }
        }
        return requestFocus(View.FOCUS_DOWN);
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean hasAncestorThatBlocksDescendantFocus(){
		// Original method
		/*
		{
        ViewParent ancestor = mParent;
        while (ancestor instanceof ViewGroup) {
            final ViewGroup vgAncestor = (ViewGroup) ancestor;
            if (vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS) {
                return true;
            } else {
                ancestor = vgAncestor.getParent();
            }
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void dispatchStartTemporaryDetach(){
		// Original method
        onStartTemporaryDetach();
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onStartTemporaryDetach(){
		// Original method
		/*
		{
        removeUnsetPressCallback();
        mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
    }
		*/
		//Return nothing
	}
    
    public void dispatchFinishTemporaryDetach(){
		// Original method
		/*
		{
        onFinishTemporaryDetach();
    }
		*/
		//Return nothing
	}

    /**
     * Called after {@link #onStartTemporaryDetach} when the container is done
     * changing the view.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.059 -0500", hash_original_method = "B87297DA0096F2C31AB92D13B4246B81", hash_generated_method = "C7F30F0F3800E9A6FDD6F12B10BAE258")
    
public void onFinishTemporaryDetach() {
    }
    
    public KeyEvent.DispatcherState getKeyDispatcherState(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mKeyDispatchState : null;
    }
		*/
		return null;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchKeyEventPreIme(KeyEvent event){
		// Original method
		/*
		{
        return onKeyPreIme(event.getKeyCode(), event);
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchKeyEvent(KeyEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        }
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnKeyListener.onKey(this, event.getKeyCode(), event)) {
            return true;
        }
        if (event.dispatch(this, mAttachInfo != null
                ? mAttachInfo.mKeyDispatchState : null, this)) {
            return true;
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchKeyShortcutEvent(KeyEvent event){
		// Original method
		/*
		{
        return onKeyShortcut(event.getKeyCode(), event);
    }
		*/
		return false;
	}
    
    @DSVerified
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchTouchEvent(MotionEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        }
        if (onFilterTouchEventForSecurity(event)) {
            ListenerInfo li = mListenerInfo;
            if (li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event)) {
                return true;
            }
            if (onTouchEvent(event)) {
                return true;
            }
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        }
        return false;
    }
		*/
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnTouchListener != null) { 
            li.mOnTouchListener.onTouch(this, event);
            return true;
        }
        if (onTouchEvent(event)) {
            return true;
        }
		return false;
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onFilterTouchEventForSecurity(MotionEvent event){
		// Original method
		/*
		{
        if ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
                && (event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0) {
            return false;
        }
        return true;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchTrackballEvent(MotionEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        }
        return onTrackballEvent(event);
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchGenericMotionEvent(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean dispatchGenericMotionEventInternal(MotionEvent event){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnGenericMotionListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnGenericMotionListener.onGenericMotion(this, event)) {
            return true;
        }
        if (onGenericMotionEvent(event)) {
            return true;
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        }
        return false;
    }
		*/
		return false;
	}
    
    protected boolean dispatchHoverEvent(MotionEvent event){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnHoverListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnHoverListener.onHover(this, event)) {
            return true;
        }
        return onHoverEvent(event);
    }
		*/
		return false;
	}

    /**
     * Returns true if the view has a child to which it has recently sent
     * {@link MotionEvent#ACTION_HOVER_ENTER}.  If this view is hovered and
     * it does not have a hovered child, then it must be the innermost hovered view.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.087 -0500", hash_original_method = "6C63870709E0BCE3150AB1DBD762BE1B", hash_generated_method = "F317A6BB6FDB4460583E17790038544B")
    
protected boolean hasHoveredChild() {
        return false;
    }

    /**
     * Dispatch a generic motion event to the view under the first pointer.
     * <p>
     * Do not call this method directly.
     * Call {@link #dispatchGenericMotionEvent(MotionEvent)} instead.
     * </p>
     *
     * @param event The motion event to be dispatched.
     * @return True if the event was handled by the view, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.089 -0500", hash_original_method = "3E380A63A40D63CB8A25C818C007B9B3", hash_generated_method = "FB4BA91682CB4D9584FA2CBD320C5780")
    
protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        return false;
    }

    /**
     * Dispatch a generic motion event to the currently focused view.
     * <p>
     * Do not call this method directly.
     * Call {@link #dispatchGenericMotionEvent(MotionEvent)} instead.
     * </p>
     *
     * @param event The motion event to be dispatched.
     * @return True if the event was handled by the view, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.091 -0500", hash_original_method = "A2221AB8B5038CA8B5C4F66BF8310DCB", hash_generated_method = "DDD7FDCD83E3FED3AD194CA823BA54A3")
    
protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        return false;
    }
    
    public final boolean dispatchPointerEvent(MotionEvent event){
		// Original method
		/*
		{
        if (event.isTouchEvent()) {
            return dispatchTouchEvent(event);
        } else {
            return dispatchGenericMotionEvent(event);
        }
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public void dispatchWindowFocusChanged(boolean hasFocus){
		// Original method
		/*
		{
        onWindowFocusChanged(hasFocus);
    }
		*/
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onWindowFocusChanged(boolean hasWindowFocus){
		// Original method
		/*
		{
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (!hasWindowFocus) {
            if (isPressed()) {
                setPressed(false);
            }
            if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
                imm.focusOut(this);
            }
            removeLongPressCallback();
            removeTapCallback();
            onFocusLost();
        } else if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
            imm.focusIn(this);
        }
        refreshDrawableState();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean hasWindowFocus(){
		// Original method
		/*
		{
        return mAttachInfo != null && mAttachInfo.mHasWindowFocus;
    }
		*/
		return false;
	}
    @DSVerified("Calling/dispatching callbacks")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void dispatchVisibilityChanged(View changedView, int visibility){
		// Original method
		/*
		*/
		//Return nothing
        onVisibilityChanged(changedView, visibility);
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onVisibilityChanged(View changedView, int visibility){
		// Original method
		/*
		{
        if (visibility == VISIBLE) {
            if (mAttachInfo != null) {
                initialAwakenScrollBars();
            } else {
                mPrivateFlags |= AWAKEN_SCROLL_BARS_ON_ATTACH;
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public void dispatchDisplayHint(int hint){
		// Original method
		/*
		{
        onDisplayHint(hint);
    }
		*/
		//Return nothing
	}

    /**
     * Gives this view a hint about whether is displayed or not. For instance, when
     * a View moves out of the screen, it might receives a display hint indicating
     * the view is not displayed. Applications should not <em>rely</em> on this hint
     * as there is no guarantee that they will receive one.
     *
     * @param hint A hint about whether or not this view is displayed:
     * {@link #VISIBLE} or {@link #INVISIBLE}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.111 -0500", hash_original_method = "5A8656B423BEB4FF4CA5CD6E6B7C0CE2", hash_generated_method = "D21E3899DC76676A78730D7B6BD97376")
    
protected void onDisplayHint(int hint) {
    }
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public void dispatchWindowVisibilityChanged(int visibility){
		// Original method
		/*
		{
        onWindowVisibilityChanged(visibility);
    }
		*/
		//Return nothing
	}
    
    protected void onWindowVisibilityChanged(int visibility){
		// Original method
		/*
		{
        if (visibility == VISIBLE) {
            initialAwakenScrollBars();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getWindowVisibility(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mWindowVisibility : GONE;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void getWindowVisibleDisplayFrame(Rect outRect){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            try {
                mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, outRect);
            } catch (RemoteException e) {
                return;
            }
            final Rect insets = mAttachInfo.mVisibleInsets;
            outRect.left += insets.left;
            outRect.top += insets.top;
            outRect.right -= insets.right;
            outRect.bottom -= insets.bottom;
            return;
        }
        Display d = WindowManagerImpl.getDefault().getDefaultDisplay();
        d.getRectSize(outRect);
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("calling callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void dispatchConfigurationChanged(Configuration newConfig){
		// Original method
        onConfigurationChanged(newConfig);
		//Return nothing
	}

    /**
     * Called when the current configuration of the resources being used
     * by the application have changed.  You can use this to decide when
     * to reload resources that can changed based on orientation and other
     * configuration characterstics.  You only need to use this if you are
     * not relying on the normal {@link android.app.Activity} mechanism of
     * recreating the activity instance upon a configuration change.
     *
     * @param newConfig The new resource configuration.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.125 -0500", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "5104AFB7AFD1C999549D7EB994254EF0")
    @DSVerified
protected void onConfigurationChanged(Configuration newConfig) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void dispatchCollectViewAttributes(int visibility){
		// Original method
		/*
		{
        performCollectViewAttributes(visibility);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void performCollectViewAttributes(int visibility){
		// Original method
		/*
		{
        if ((visibility & VISIBILITY_MASK) == VISIBLE && mAttachInfo != null) {
            if ((mViewFlags & KEEP_SCREEN_ON) == KEEP_SCREEN_ON) {
                mAttachInfo.mKeepScreenOn = true;
            }
            mAttachInfo.mSystemUiVisibility |= mSystemUiVisibility;
            ListenerInfo li = mListenerInfo;
            if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
                mAttachInfo.mHasSystemUiListeners = true;
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void needGlobalAttributesUpdate(boolean force){
		// Original method
		/*
		{
        final AttachInfo ai = mAttachInfo;
        if (ai != null) {
            if (force || ai.mKeepScreenOn || (ai.mSystemUiVisibility != 0)
                    || ai.mHasSystemUiListeners) {
                ai.mRecomputeGlobalAttributes = true;
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public boolean isInTouchMode(){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            return mAttachInfo.mInTouchMode;
        } else {
            return ViewRootImpl.isInTouchMode();
        }
    }
		*/
		return false;
	}

    /**
     * Returns the context the view is running in, through which it can
     * access the current theme, resources, etc.
     *
     * @return The view's Context.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.137 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "2565E6BAF7209C441ED7A2A85B82D51F")
    
@ViewDebug.CapturedViewProperty
    public final Context getContext() {
        return mContext;
    }

    /**
     * Handle a key event before it is processed by any input method
     * associated with the view hierarchy.  This can be used to intercept
     * key events in special situations before the IME consumes them; a
     * typical example would be handling the BACK key to update the application's
     * UI instead of allowing the IME to see it and close itself.
     *
     * @param keyCode The value in event.getKeyCode().
     * @param event Description of the key event.
     * @return If you handled the event, return true. If you want to allow the
     *         event to be handled by the next receiver, return false.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.139 -0500", hash_original_method = "3F070CAC61386FAD746F2003533AED25", hash_generated_method = "CA1FD3DCB84D25C744C9FAD02F5EC629")
    
public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        return false;
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onKeyDown(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        boolean result = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER: {
                if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    return true;
                }
                if (((mViewFlags & CLICKABLE) == CLICKABLE ||
                        (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) &&
                        (event.getRepeatCount() == 0)) {
                    setPressed(true);
                    checkForLongClick(0);
                    return true;
                }
                break;
            }
        }
        return result;
    }
		*/
		return false;
	}

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
     * KeyEvent.Callback.onKeyLongPress()}: always returns false (doesn't handle
     * the event).
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.144 -0500", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "DCA1BD8CD57F309EE5CB42ADAEA0EA5E")
    
public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onKeyUp(int keyCode, KeyEvent event){
		// Original method
        boolean result = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER: {
                if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    return true;
                }
                if ((mViewFlags & CLICKABLE) == CLICKABLE && isPressed()) {
                    setPressed(false);
                    if (!mHasPerformedLongPress) {
                        removeLongPressCallback();
                        result = performClick();
                    }
                }
                break;
            }
        }
        return result;
	}

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)
     * KeyEvent.Callback.onKeyMultiple()}: always returns false (doesn't handle
     * the event).
     *
     * @param keyCode     A key code that represents the button pressed, from
     *                    {@link android.view.KeyEvent}.
     * @param repeatCount The number of times the action was made.
     * @param event       The KeyEvent object that defines the button action.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.149 -0500", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "36A8C90D805E1CE396E3F79E76A992E5")
    
public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    /**
     * Called on the focused view when a key shortcut event is not handled.
     * Override this method to implement local key shortcuts for the View.
     * Key shortcuts can also be implemented by setting the
     * {@link MenuItem#setShortcut(char, char) shortcut} property of menu items.
     *
     * @param keyCode The value in event.getKeyCode().
     * @param event Description of the key event.
     * @return If you handled the event, return true. If you want to allow the
     *         event to be handled by the next receiver, return false.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.152 -0500", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "79AEB00DA58A022844D17B2E04B426A1")
    
public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return false;
    }

    /**
     * Check whether the called view is a text editor, in which case it
     * would make sense to automatically display a soft input window for
     * it.  Subclasses should override this if they implement
     * {@link #onCreateInputConnection(EditorInfo)} to return true if
     * a call on that method would return a non-null InputConnection, and
     * they are really a first-class editor that the user would normally
     * start typing on when the go into a window containing your view.
     *
     * <p>The default implementation always returns false.  This does
     * <em>not</em> mean that its {@link #onCreateInputConnection(EditorInfo)}
     * will not be called or the user can not otherwise perform edits on your
     * view; it is just a hint to the system that this is not the primary
     * purpose of this view.
     *
     * @return Returns true if this view is a text editor, else false.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.154 -0500", hash_original_method = "47FC099EDD591711C69A21361EB96357", hash_generated_method = "5B53E0B1202BB15F86459E0B1E8308CF")
    
public boolean onCheckIsTextEditor() {
        return false;
    }

    /**
     * Create a new InputConnection for an InputMethod to interact
     * with the view.  The default implementation returns null, since it doesn't
     * support input methods.  You can override this to implement such support.
     * This is only needed for views that take focus and text input.
     *
     * <p>When implementing this, you probably also want to implement
     * {@link #onCheckIsTextEditor()} to indicate you will return a
     * non-null InputConnection.
     *
     * @param outAttrs Fill in with attribute information about the connection.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.156 -0500", hash_original_method = "0601401EB37355AF70FCC37B4ABEB0DF", hash_generated_method = "AF45BEE97068CF271D86CB07AF9A90A7")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK) 
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return null;
    }

    /**
     * Called by the {@link android.view.inputmethod.InputMethodManager}
     * when a view who is not the current
     * input connection target is trying to make a call on the manager.  The
     * default implementation returns false; you can override this to return
     * true for certain views if you are performing InputConnection proxying
     * to them.
     * @param view The View that is making the InputMethodManager call.
     * @return Return true to allow the call, false to reject.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.158 -0500", hash_original_method = "225D79BB0F164EDB8833C9EDCA3E1422", hash_generated_method = "5E8B683FD30BC2F3BCB5ECCD4B1C4716")
    
public boolean checkInputConnectionProxy(View view) {
        return false;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSVerified
    public void createContextMenu(ContextMenu menu){
        onCreateContextMenu(menu);
		// Original method
		/*
		{
        ContextMenuInfo menuInfo = getContextMenuInfo();
        ((MenuBuilder)menu).setCurrentMenuInfo(menuInfo);
        onCreateContextMenu(menu);
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnCreateContextMenuListener != null) {
            li.mOnCreateContextMenuListener.onCreateContextMenu(menu, this, menuInfo);
        }
        ((MenuBuilder)menu).setCurrentMenuInfo(null);
        if (mParent != null) {
            mParent.createContextMenu(menu);
        }
    }
		*/
		//Return nothing
	}

    /**
     * Views should implement this if they have extra information to associate
     * with the context menu. The return result is supplied as a parameter to
     * the {@link OnCreateContextMenuListener#onCreateContextMenu(ContextMenu, View, ContextMenuInfo)}
     * callback.
     *
     * @return Extra information about the item for which the context menu
     *         should be shown. This information will vary across different
     *         subclasses of View.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.163 -0500", hash_original_method = "5F63695E16A345A992F87C295B6530DF", hash_generated_method = "D50F5F7A11219609DE7D895C0081EC1F")
    
protected ContextMenuInfo getContextMenuInfo() {
        return null;
    }

    /**
     * Views should implement this if the view itself is going to add items to
     * the context menu.
     *
     * @param menu the context menu to populate
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.166 -0500", hash_original_method = "6522DD22D3C6D7A95FA248A3D5D95901", hash_generated_method = "324350287C575D3BD196B24BCAF0E20C")
    @DSVerified
    
protected void onCreateContextMenu(ContextMenu menu) {
    }

    /**
     * Implement this method to handle trackball motion events.  The
     * <em>relative</em> movement of the trackball since the last event
     * can be retrieve with {@link MotionEvent#getX MotionEvent.getX()} and
     * {@link MotionEvent#getY MotionEvent.getY()}.  These are normalized so
     * that a movement of 1 corresponds to the user pressing one DPAD key (so
     * they will often be fractional values, representing the more fine-grained
     * movement information available from a trackball).
     *
     * @param event The motion event.
     * @return True if the event was handled, false otherwise.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.168 -0500", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "3CA4089EBE14436E733AD365EF1361B8")
    
public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }

    /**
     * Implement this method to handle generic motion events.
     * <p>
     * Generic motion events describe joystick movements, mouse hovers, track pad
     * touches, scroll wheel movements and other input events.  The
     * {@link MotionEvent#getSource() source} of the motion event specifies
     * the class of input that was received.  Implementations of this method
     * must examine the bits in the source before processing the event.
     * The following code example shows how this is done.
     * </p><p>
     * Generic motion events with source class {@link InputDevice#SOURCE_CLASS_POINTER}
     * are delivered to the view under the pointer.  All other generic motion events are
     * delivered to the focused view.
     * </p>
     * <pre> public boolean onGenericMotionEvent(MotionEvent event) {
     *     if ((event.getSource() &amp; InputDevice.SOURCE_CLASS_JOYSTICK) != 0) {
     *         if (event.getAction() == MotionEvent.ACTION_MOVE) {
     *             // process the joystick movement...
     *             return true;
     *         }
     *     }
     *     if ((event.getSource() &amp; InputDevice.SOURCE_CLASS_POINTER) != 0) {
     *         switch (event.getAction()) {
     *             case MotionEvent.ACTION_HOVER_MOVE:
     *                 // process the mouse hover movement...
     *                 return true;
     *             case MotionEvent.ACTION_SCROLL:
     *                 // process the scroll wheel movement...
     *                 return true;
     *         }
     *     }
     *     return super.onGenericMotionEvent(event);
     * }</pre>
     *
     * @param event The generic motion event being processed.
     * @return True if the event was handled, false otherwise.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.170 -0500", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "FC042457DA14CABBB898ABC65A695166")
    
public boolean onGenericMotionEvent(MotionEvent event) {
        return false;
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onHoverEvent(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean isHoverable(){
		// Original method
		/*
		{
        final int viewFlags = mViewFlags;
        if ((viewFlags & ENABLED_MASK) == DISABLED) {
            return false;
        }
        return (viewFlags & CLICKABLE) == CLICKABLE
                || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty 
	public boolean isHovered(){
		// Original method
		/*
		{
        return (mPrivateFlags & HOVERED) != 0;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setHovered(boolean hovered){
		// Original method
		/*
		{
        if (hovered) {
            if ((mPrivateFlags & HOVERED) == 0) {
                mPrivateFlags |= HOVERED;
                refreshDrawableState();
                onHoverChanged(true);
            }
        } else {
            if ((mPrivateFlags & HOVERED) != 0) {
                mPrivateFlags &= ~HOVERED;
                refreshDrawableState();
                onHoverChanged(false);
            }
        }
    }
		*/
		//Return nothing
	}

    /**
     * Implement this method to handle hover state changes.
     * <p>
     * This method is called whenever the hover state changes as a result of a
     * call to {@link #setHovered}.
     * </p>
     *
     * @param hovered The current hover state, as returned by {@link #isHovered}.
     *
     * @see #isHovered
     * @see #setHovered
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.183 -0500", hash_original_method = "E702D19B1B952DDC0E28AFCA7C53007F", hash_generated_method = "D7267BF982AB852A7028B2D26CF0BC14")
    @DSVerified
public void onHoverChanged(boolean hovered) {
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onTouchEvent(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    public boolean isInScrollingContainer(){
		// Original method
		/*
		{
        ViewParent p = getParent();
        while (p != null && p instanceof ViewGroup) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
            p = p.getParent();
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeLongPressCallback(){
		// Original method
		/*
		{
        if (mPendingCheckForLongPress != null) {
          removeCallbacks(mPendingCheckForLongPress);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removePerformClickCallback(){
		// Original method
		/*
		{
        if (mPerformClick != null) {
            removeCallbacks(mPerformClick);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeUnsetPressCallback(){
		// Original method
		/*
		{
        if ((mPrivateFlags & PRESSED) != 0 && mUnsetPressedState != null) {
            setPressed(false);
            removeCallbacks(mUnsetPressedState);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeTapCallback(){
		// Original method
		/*
		{
        if (mPendingCheckForTap != null) {
            mPrivateFlags &= ~PREPRESSED;
            removeCallbacks(mPendingCheckForTap);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void cancelLongPress(){
		// Original method
		/*
		{
        removeLongPressCallback();
        removeTapCallback();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeSendViewScrolledAccessibilityEventCallback(){
		// Original method
		/*
		{
        if (mSendViewScrolledAccessibilityEvent != null) {
            removeCallbacks(mSendViewScrolledAccessibilityEvent);
        }
    }
		*/
		//Return nothing
	}

    /**
     * Sets the TouchDelegate for this View.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.206 -0500", hash_original_method = "61F54D1D0A5A4D0B5C8BE62B3B180D19", hash_generated_method = "B5A51B7ABB5E430C24DCA4C44EDFCAE0")
    
public void setTouchDelegate(TouchDelegate delegate) {
        mTouchDelegate = delegate;
    }

    /**
     * Gets the TouchDelegate for this View.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.208 -0500", hash_original_method = "C13C756E7E3DD9AFF35525DE74B6A0AE", hash_generated_method = "F5C3D8B17B1D24D29BC2FCFBDD2A2FC4")
    
public TouchDelegate getTouchDelegate() {
        return mTouchDelegate;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void setFlags(int flags, int mask){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void bringToFront(){
		// Original method
		/*
		{
        if (mParent != null) {
            mParent.bringChildToFront(this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onScrollChanged(int l, int t, int oldl, int oldt){
		// Original method
		/*
		{
        if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            postSendViewScrolledAccessibilityEventCallback();
        }
        mBackgroundSizeChanged = true;
        final AttachInfo ai = mAttachInfo;
        if (ai != null) {
            ai.mViewScrollChanged = true;
        }
    }
		*/
		//Return nothing
	}

    /**
     * This is called during layout when the size of this view has changed. If
     * you were just added to the view hierarchy, you're called with the old
     * values of 0.
     *
     * @param w Current width of this view.
     * @param h Current height of this view.
     * @param oldw Old width of this view.
     * @param oldh Old height of this view.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.222 -0500", hash_original_method = "B552DCA4F8335CB071F137C97CB4545F", hash_generated_method = "67176277B5FC92FECCD4A90768269215")
    
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }

    /**
     * Called by draw to draw the child views. This may be overridden
     * by derived classes to gain control just before its children are drawn
     * (but after its own view has been drawn).
     * @param canvas the canvas on which to draw the view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.225 -0500", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "D2A0B8A918322CF9B55DF0C61F993E8A")
    
protected void dispatchDraw(Canvas canvas) {
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final ViewParent getParent(){
		return (ViewParent)getTaint();
		// Original method
		/*
		{
        return mParent;
    }
		*/
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setScrollX(int value){
	    addTaint(value);
		// Original method
		/*
		{
        scrollTo(value, mScrollY);
    }
		*/
		//Return nothing
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setScrollY(int value){
		// Original method
		/*
		{
        scrollTo(mScrollX, value);
    }
		*/
		//Return nothing
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getScrollX(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollX;
    }
		*/
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getScrollY(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollY;
    }
		*/
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(category="layout") 
	public final int getWidth(){
		// Original method
		/*
		{
        return mRight - mLeft;
    }
		*/
		return 0;
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(category="layout") 
	public final int getHeight(){
		// Original method
		/*
		{
        return mBottom - mTop;
    }
		*/
		return getTaintInt();
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void getDrawingRect(Rect outRect){
		// Original method
		/*
		{
        outRect.left = mScrollX;
        outRect.top = mScrollY;
        outRect.right = mScrollX + (mRight - mLeft);
        outRect.bottom = mScrollY + (mBottom - mTop);
    }
		*/
		//Return nothing
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getMeasuredWidth(){
		return getTaintInt();
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getMeasuredWidthAndState(){
		return getTaintInt();
		// Original method
		/*
		{
        return mMeasuredWidth;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getMeasuredHeight(){
		// Original method
		/*
		{
        return mMeasuredHeight & MEASURED_SIZE_MASK;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getMeasuredHeightAndState(){
		return getTaintInt();
		// Original method
		/*
		{
        return mMeasuredHeight;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getMeasuredState(){
		// Original method
		/*
		{
        return (mMeasuredWidth&MEASURED_STATE_MASK)
                | ((mMeasuredHeight>>MEASURED_HEIGHT_STATE_SHIFT)
                        & (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Matrix getMatrix(){
		// Original method
		/*
		{
        if (mTransformationInfo != null) {
            updateMatrix();
            return mTransformationInfo.mMatrix;
        }
        return Matrix.IDENTITY_MATRIX;
    }
		*/
		return null;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final boolean hasIdentityMatrix(){
		// Original method
		/*
		{
        if (mTransformationInfo != null) {
            updateMatrix();
            return mTransformationInfo.mMatrixIsIdentity;
        }
        return true;
    }
		*/
		return false;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void ensureTransformationInfo(){
		// Original method
		/*
		{
        if (mTransformationInfo == null) {
            mTransformationInfo = new TransformationInfo();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void updateMatrix(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    final Matrix getInverseMatrix(){
		// Original method
		/*
		{
        final TransformationInfo info = mTransformationInfo;
        if (info != null) {
            updateMatrix();
            if (info.mInverseMatrixDirty) {
                if (info.mInverseMatrix == null) {
                    info.mInverseMatrix = new Matrix();
                }
                info.mMatrix.invert(info.mInverseMatrix);
                info.mInverseMatrixDirty = false;
            }
            return info.mInverseMatrix;
        }
        return Matrix.IDENTITY_MATRIX;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setCameraDistance(float distance){
		// Original method
		/*
		{
        invalidateParentCaches();
        invalidate(false);
        ensureTransformationInfo();
        final float dpi = mResources.getDisplayMetrics().densityDpi;
        final TransformationInfo info = mTransformationInfo;
        if (info.mCamera == null) {
            info.mCamera = new Camera();
            info.matrix3D = new Matrix();
        }
        info.mCamera.setLocation(0.0f, 0.0f, -Math.abs(distance) / dpi);
        info.mMatrixDirty = true;
        invalidate(false);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getRotation(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mRotation : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setRotation(float rotation){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mRotation != rotation) {
            invalidateParentCaches();
            invalidate(false);
            info.mRotation = rotation;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getRotationY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mRotationY : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setRotationY(float rotationY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mRotationY != rotationY) {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationY = rotationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getRotationX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mRotationX : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setRotationX(float rotationX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mRotationX != rotationX) {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationX = rotationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getScaleX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mScaleX : 1;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setScaleX(float scaleX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mScaleX != scaleX) {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleX = scaleX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getScaleY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mScaleY : 1;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setScaleY(float scaleY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mScaleY != scaleY) {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleY = scaleY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getPivotX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mPivotX : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setPivotX(float pivotX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
        if (info.mPivotX != pivotX) {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotX = pivotX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getPivotY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mPivotY : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setPivotY(float pivotY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
        if (info.mPivotY != pivotY) {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotY = pivotY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getAlpha(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mAlpha : 1;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setAlpha(float alpha){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        invalidateParentCaches();
        if (onSetAlpha((int) (alpha * 255))) {
            mPrivateFlags |= ALPHA_SET;
            invalidate(true);
        } else {
            mPrivateFlags &= ~ALPHA_SET;
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean setAlphaNoInvalidation(float alpha){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        boolean subclassHandlesAlpha = onSetAlpha((int) (alpha * 255));
        if (subclassHandlesAlpha) {
            mPrivateFlags |= ALPHA_SET;
        } else {
            mPrivateFlags &= ~ALPHA_SET;
        }
        return subclassHandlesAlpha;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.CapturedViewProperty 
	public final int getTop(){
		return getTaintInt();
		// Original method
		/*
		{
        return mTop;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void setTop(int top){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.CapturedViewProperty 
	public final int getBottom(){
		return getTaintInt();
		// Original method
		/*
		{
        return mBottom;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isDirty(){
		// Original method
		/*
		{
        return (mPrivateFlags & DIRTY_MASK) != 0;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void setBottom(int bottom){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.CapturedViewProperty 
	public final int getLeft(){
		return getTaintInt();
		// Original method
		/*
		{
        return mLeft;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void setLeft(int left){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.CapturedViewProperty 
	public final int getRight(){
		return getTaintInt();
		// Original method
		/*
		{
        return mRight;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void setRight(int right){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getX(){
		// Original method
		/*
		{
        return mLeft + (mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0);
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setX(float x){
		// Original method
		/*
		{
        setTranslationX(x - mLeft);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getY(){
		// Original method
		/*
		{
        return mTop + (mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0);
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setY(float y){
		// Original method
		/*
		{
        setTranslationY(y - mTop);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getTranslationX(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setTranslationX(float translationX){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mTranslationX != translationX) {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationX = translationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getTranslationY(){
		// Original method
		/*
		{
        return mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setTranslationY(float translationY){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        if (info.mTranslationY != translationY) {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationY = translationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN; 
            invalidate(false);
        }
    }
		*/
		//Return nothing
	}
    
    public void setFastTranslationX(float x){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}
    
    public void setFastTranslationY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}
    
    public void setFastX(float x){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x - mLeft;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}
    
    public void setFastY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y - mTop;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}
    
    public void setFastScaleX(float x){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleX = x;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}
    
    public void setFastScaleY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleY = y;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}
    
    public void setFastAlpha(float alpha){
		// Original method
		/*
		{
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
    }
		*/
		//Return nothing
	}
    
    public void setFastRotationY(float y){
		// Original method
		/*
		{
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mRotationY = y;
        info.mMatrixDirty = true;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void getHitRect(Rect outRect){
		// Original method
		/*
		{
        updateMatrix();
        final TransformationInfo info = mTransformationInfo;
        if (info == null || info.mMatrixIsIdentity || mAttachInfo == null) {
            outRect.set(mLeft, mTop, mRight, mBottom);
        } else {
            final RectF tmpRect = mAttachInfo.mTmpTransformRect;
            tmpRect.set(-info.mPivotX, -info.mPivotY,
                    getWidth() - info.mPivotX, getHeight() - info.mPivotY);
            info.mMatrix.mapRect(tmpRect);
            outRect.set((int) tmpRect.left + mLeft, (int) tmpRect.top + mTop,
                    (int) tmpRect.right + mLeft, (int) tmpRect.bottom + mTop);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final boolean pointInView(float localX, float localY){
		// Original method
		/*
		{
        return localX >= 0 && localX < (mRight - mLeft)
                && localY >= 0 && localY < (mBottom - mTop);
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean pointInView(float localX, float localY, float slop){
		// Original method
		/*
		{
        return localX >= -slop && localY >= -slop && localX < ((mRight - mLeft) + slop) &&
                localY < ((mBottom - mTop) + slop);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void getFocusedRect(Rect r){
		// Original method
		/*
		{
        getDrawingRect(r);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset){
		// Original method
		/*
		{
        int width = mRight - mLeft;
        int height = mBottom - mTop;
        if (width > 0 && height > 0) {
            r.set(0, 0, width, height);
            if (globalOffset != null) {
                globalOffset.set(-mScrollX, -mScrollY);
            }
            return mParent == null || mParent.getChildVisibleRect(this, r, globalOffset);
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final boolean getGlobalVisibleRect(Rect r){
		// Original method
		/*
		{
        return getGlobalVisibleRect(r, null);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final boolean getLocalVisibleRect(Rect r){
		// Original method
		/*
		{
        Point offset = new Point();
        if (getGlobalVisibleRect(r, offset)) {
            r.offset(-offset.x, -offset.y); 
            return true;
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void offsetTopAndBottom(int offset){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void offsetLeftAndRight(int offset){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Get the LayoutParams associated with this view. All views should have
     * layout parameters. These supply parameters to the <i>parent</i> of this
     * view specifying how it should be arranged. There are many subclasses of
     * ViewGroup.LayoutParams, and these correspond to the different subclasses
     * of ViewGroup that are responsible for arranging their children.
     *
     * This method may return null if this View is not attached to a parent
     * ViewGroup or {@link #setLayoutParams(android.view.ViewGroup.LayoutParams)}
     * was not invoked successfully. When a View is attached to a parent
     * ViewGroup, this method must not return null.
     *
     * @return The LayoutParams associated with this view, or null if no
     *         parameters have been set yet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.404 -0500", hash_original_method = "5EB740A9A129A62709C940CDC3C1FA90", hash_generated_method = "0E7022E2AA69DD9440A61ABEEAEDDFD9")
    
@ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
    public ViewGroup.LayoutParams getLayoutParams() {
        return mLayoutParams;
    }

    @DSVerified
    @DSSafe(DSCat.GUI)
    public void setLayoutParams(ViewGroup.LayoutParams params){
		mLayoutParams = params;
		requestLayout();
		// Original method
		/*
		{
        if (params == null) {
            throw new NullPointerException("Layout parameters cannot be null");
        }
        mLayoutParams = params;
        requestLayout();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void scrollTo(int x, int y){
		// Original method
		/*
		{
        if (mScrollX != x || mScrollY != y) {
            int oldX = mScrollX;
            int oldY = mScrollY;
            mScrollX = x;
            mScrollY = y;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            if (!awakenScrollBars()) {
                invalidate(true);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void scrollBy(int x, int y){
		// Original method
		/*
		{
        scrollTo(mScrollX + x, mScrollY + y);
    }
		*/
		//Return nothing
	}
    
    protected boolean awakenScrollBars(){
		// Original method
		/*
		{
        return mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true);
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean initialAwakenScrollBars(){
		// Original method
		/*
		{
        return mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true);
    }
		*/
		return false;
	}
    
    protected boolean awakenScrollBars(int startDelay){
		// Original method
		/*
		{
        return awakenScrollBars(startDelay, true);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected boolean awakenScrollBars(int startDelay, boolean invalidate){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean skipInvalidate(){
		// Original method
		/*
		{
        return (mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                (!(mParent instanceof ViewGroup) ||
                        !((ViewGroup) mParent).isViewTransitioning(this));
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void invalidate(Rect dirty){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void invalidate(int l, int t, int r, int b){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Invalidate the whole view. If the view is visible,
     * {@link #onDraw(android.graphics.Canvas)} will be called at some point in
     * the future. This must be called from a UI thread. To call from a non-UI thread,
     * call {@link #postInvalidate()}.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.432 -0500", hash_original_method = "DD9880156AB041E4BB31F756D1AB2189", hash_generated_method = "1C46FCE896A7CC57B15BC9136261EA83")
    
public void invalidate() {
        invalidate(true);
    }
    
	@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void invalidate(boolean invalidateCache){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    public void fastInvalidate(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    protected void invalidateParentCaches(){
		// Original method
		/*
		{
        if (mParent instanceof View) {
            ((View) mParent).mPrivateFlags |= INVALIDATED;
        }
    }
		*/
		//Return nothing
	}
    
    protected void invalidateParentIfNeeded(){
		// Original method
		/*
		{
        if (isHardwareAccelerated() && mParent instanceof View) {
            ((View) mParent).invalidate(true);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean isOpaque(){
		// Original method
		/*
		{
        return (mPrivateFlags & OPAQUE_MASK) == OPAQUE_MASK &&
                ((mTransformationInfo != null ? mTransformationInfo.mAlpha : 1)
                        >= 1.0f - ViewConfiguration.ALPHA_THRESHOLD);
    }
		*/
		return false;
	}
    
    protected void computeOpaqueFlags(){
		// Original method
		/*
		{
        if (mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE) {
            mPrivateFlags |= OPAQUE_BACKGROUND;
        } else {
            mPrivateFlags &= ~OPAQUE_BACKGROUND;
        }
        final int flags = mViewFlags;
        if (((flags & SCROLLBARS_VERTICAL) == 0 && (flags & SCROLLBARS_HORIZONTAL) == 0) ||
                (flags & SCROLLBARS_STYLE_MASK) == SCROLLBARS_INSIDE_OVERLAY) {
            mPrivateFlags |= OPAQUE_SCROLLBARS;
        } else {
            mPrivateFlags &= ~OPAQUE_SCROLLBARS;
        }
    }
		*/
		//Return nothing
	}
    
    protected boolean hasOpaqueScrollbars(){
		// Original method
		/*
		{
        return (mPrivateFlags & OPAQUE_SCROLLBARS) == OPAQUE_SCROLLBARS;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Handler getHandler(){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            return mAttachInfo.mHandler;
        }
        return null;
    }
		*/
		return null;
	}
    
    static class TransformationInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.445 -0500", hash_original_field = "2E905ABA253A50CD5326C99795B09381", hash_generated_field = "D632FEE6EB1660D61E8B851D372C57FD")

        private final Matrix mMatrix = new Matrix();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.447 -0500", hash_original_field = "C5F0C7E1EEDABB853D687630723636BE", hash_generated_field = "5F11E3B225AB20CA6908F99BD2DCCD69")

        private Matrix mInverseMatrix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.450 -0500", hash_original_field = "39319A786965FE4B527A01145F904472", hash_generated_field = "39319A786965FE4B527A01145F904472")

        boolean mMatrixDirty = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.452 -0500", hash_original_field = "3BB3434D894218C11AFC436839759FFA", hash_generated_field = "0D5DDC0830CE5F8AD2A6C72FEF2EE898")

        private boolean mInverseMatrixDirty = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.454 -0500", hash_original_field = "11844DB035373C3EA5145380513A3AF7", hash_generated_field = "067E11491097A23D40918282A928EBA9")

        private boolean mMatrixIsIdentity = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.457 -0500", hash_original_field = "BB98B3A374F19F09DA7CA30A91E8F3A2", hash_generated_field = "EDD47554C3CEE3D946B262053B454BFB")

        private Camera mCamera = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.460 -0500", hash_original_field = "885DFDED530D00A843985034B1D88954", hash_generated_field = "19CC34893873FBEA96612C704706273A")

        private Matrix matrix3D = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.462 -0500", hash_original_field = "80D4201DA61C9585B84B3D4DD161BFE4", hash_generated_field = "888097DA3FEAC04F59E84914FC3B299F")

        private int mPrevWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.464 -0500", hash_original_field = "2AA61492AE07ECE9246A4F30762067DC", hash_generated_field = "3F17D196FD1B71E4E9A79484B73B3DC2")

        private int mPrevHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.467 -0500", hash_original_field = "8BC30CEDF48509C49BAC814C0FB546D0", hash_generated_field = "5BFF8D9CD2F407BBEC3BAA9D3113E814")

        @ViewDebug.ExportedProperty
        float mRotationY = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.469 -0500", hash_original_field = "79AC6B74216F082DD2C7FE758F6C1041", hash_generated_field = "1773CD64DE2B81950EEC26683C7BFC12")

        @ViewDebug.ExportedProperty
        float mRotationX = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.471 -0500", hash_original_field = "706352B73C7632104FDC299787A57F4D", hash_generated_field = "CBCF8195E197871A173AFD82B249BEE8")

        @ViewDebug.ExportedProperty
        float mRotation = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.473 -0500", hash_original_field = "6E2EADFB74006974A39EA1EEDCB6D76A", hash_generated_field = "7E653D53DDF7B3176405F85A676F9E8E")

        @ViewDebug.ExportedProperty
        float mTranslationX = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.476 -0500", hash_original_field = "BD71C35A5B768A2F1DCF1AFA32C2002B", hash_generated_field = "477946415FF37E50D7898E1A45EA53F2")

        @ViewDebug.ExportedProperty
        float mTranslationY = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.478 -0500", hash_original_field = "5E97C86F1771E514946E07316FE17DC2", hash_generated_field = "39698B539B591C7643D57DD23054914D")

        @ViewDebug.ExportedProperty
        float mScaleX = 1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.481 -0500", hash_original_field = "F8731A81B49CB8EC67AD16143768D356", hash_generated_field = "37E347D4565A795C12A91CA0C0BB20C1")

        @ViewDebug.ExportedProperty
        float mScaleY = 1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.483 -0500", hash_original_field = "FAA5ADA7D83AD474249AF76F0FEE3261", hash_generated_field = "C294D047888DF6C232DB6BC89AB6C1DE")

        @ViewDebug.ExportedProperty
        float mPivotX = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.485 -0500", hash_original_field = "D13EEC01D545C33D7A4BF7C979D6CFBC", hash_generated_field = "65227B6A59140FE7F7093243C8409FD1")

        @ViewDebug.ExportedProperty
        float mPivotY = 0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.488 -0500", hash_original_field = "C7EF7BE5EEF2DDF9D7726D89D260D263", hash_generated_field = "3F07B4C8BDBAF8B8C3DFBAA769694247")

        @ViewDebug.ExportedProperty
        float mAlpha = 1f;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.648 -0400", hash_original_method = "047CC1B263AEE84E056E34E366D57D72", hash_generated_method = "047CC1B263AEE84E056E34E366D57D72")
        public TransformationInfo ()
        {
            //Synthesized constructor
        }

    }
    
    static class ListenerInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.552 -0500", hash_original_field = "E61696A4BC2C156851D8527277179FFD", hash_generated_field = "E3E0A2AA3DAD3D497FEC69653B249F3D")

        protected OnFocusChangeListener mOnFocusChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.554 -0500", hash_original_field = "B15075E9526E599F9E87445D55CA05C7", hash_generated_field = "3E61511956959B716B0660A267A5DDB6")

        private ArrayList<OnLayoutChangeListener> mOnLayoutChangeListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.556 -0500", hash_original_field = "9A77AF786DAD6256A86172CCF5098476", hash_generated_field = "7FB9E86C55D3FC29D5ABA87F653B7F5E")

        private CopyOnWriteArrayList<OnAttachStateChangeListener> mOnAttachStateChangeListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.559 -0500", hash_original_field = "483CBBC53628034EFC0EDF51FCAFE7FA", hash_generated_field = "65DB77DAF20E9BC1F7135E1B0259ED25")

        public OnClickListener mOnClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.561 -0500", hash_original_field = "B03933F8D6E83E68AEDC762D3EEF0147", hash_generated_field = "5EAF3560EF7F9BB7565DBDF37FE7A2AA")

        protected OnLongClickListener mOnLongClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.563 -0500", hash_original_field = "1395494826EC5B585F0326224FB0E4FC", hash_generated_field = "ADA44730A1380CB9786AA8F8DC39301D")

        protected OnCreateContextMenuListener mOnCreateContextMenuListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.566 -0500", hash_original_field = "015168FBB2FF4C181AE52DE804ABA4A4", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")

        private OnKeyListener mOnKeyListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.568 -0500", hash_original_field = "0400F88F44E38F9E898A9EDC357E60D0", hash_generated_field = "538D6DAEFDEDFC1E31809D314A35E30B")

        private OnTouchListener mOnTouchListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.571 -0500", hash_original_field = "916EA46BC228FE512DC1235A99123B3B", hash_generated_field = "9960EE08CE022E6057B016EBE9068862")

        private OnHoverListener mOnHoverListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.573 -0500", hash_original_field = "98863C57A6513E3FCE2A879C9522D8B2", hash_generated_field = "6F0FC6D93F2673180702A6C98E43EB3F")

        private OnGenericMotionListener mOnGenericMotionListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.576 -0500", hash_original_field = "712209B26F3B969ACBC5CB318CBCD8E5", hash_generated_field = "BB6976B05A50BD6226C5F3224361BE75")

        private OnDragListener mOnDragListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:37.578 -0500", hash_original_field = "DAEBAE45506473BE7B3EC8FCDE646B28", hash_generated_field = "BCD3219BF0AB6E6E91E075D0ABDA8C97")

        private OnSystemUiVisibilityChangeListener mOnSystemUiVisibilityChangeListener;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.649 -0400", hash_original_method = "30D31F497118E5B2F2D60734B7298038", hash_generated_method = "30D31F497118E5B2F2D60734B7298038")
        public ListenerInfo ()
        {
            //Synthesized constructor
        }

    }
    
    public static class DragShadowBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.953 -0500", hash_original_field = "EE42612B793ECF11B4BB1DE5FB8357E6", hash_generated_field = "08E85E83D778EC246746E6855B21BE82")

        private  WeakReference<View> mView;

        /**
         * Constructs a shadow image builder based on a View. By default, the resulting drag
         * shadow will have the same appearance and dimensions as the View, with the touch point
         * over the center of the View.
         * @param view A View. Any View in scope can be used.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.956 -0500", hash_original_method = "0B0DC4A9FB3A9C12A7904682E22ADAD8", hash_generated_method = "356627736E9F58DA08CB2BA68E1B6858")
        
public DragShadowBuilder(View view) {
            mView = new WeakReference<View>(view);
        }

        /**
         * Construct a shadow builder object with no associated View.  This
         * constructor variant is only useful when the {@link #onProvideShadowMetrics(Point, Point)}
         * and {@link #onDrawShadow(Canvas)} methods are also overridden in order
         * to supply the drag shadow's dimensions and appearance without
         * reference to any View object. If they are not overridden, then the result is an
         * invisible drag shadow.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.959 -0500", hash_original_method = "39157EB374747DFD28056DCE3D5D84EC", hash_generated_method = "C44408E3B9B394EB107B05E14439FE63")
        
public DragShadowBuilder() {
            mView = new WeakReference<View>(null);
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @SuppressWarnings({"JavadocReference"}) 
		final public View getView(){
			// Original method
			/*
			{
            return mView.get();
        }
			*/
			return null;
		}
        
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint){
			// Original method
			/*
			{
            final View view = mView.get();
            if (view != null) {
                shadowSize.set(view.getWidth(), view.getHeight());
                shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
            } else {
                Log.e(View.VIEW_LOG_TAG, "Asked for drag thumb metrics but no view");
            }
        }
			*/
			//Return nothing
		}
        
        public void onDrawShadow(Canvas canvas){
			// Original method
			/*
			{
            final View view = mView.get();
            if (view != null) {
                view.draw(canvas);
            } else {
                Log.e(View.VIEW_LOG_TAG, "Asked to draw drag shadow but no view");
            }
        }
			*/
			//Return nothing
		}
        
    }
    
    public static class MeasureSpec {
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        public static int makeMeasureSpec(int size, int mode){
			// Original method
			/*
			{
            return size + mode;
        }
			*/
			return 0;
		}
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        public static int getMode(int measureSpec){
			// Original method
			/*
			{
            return (measureSpec & MODE_MASK);
        }
			*/
			return 0;
		}
        
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        public static int getSize(int measureSpec){
			// Original method
			/*
			{
            return (measureSpec & ~MODE_MASK);
        }
			*/
			return 0;
		}
        
        public static String toString(int measureSpec){
			// Original method
			/*
			{
            int mode = getMode(measureSpec);
            int size = getSize(measureSpec);
            StringBuilder sb = new StringBuilder("MeasureSpec: ");
            if (mode == UNSPECIFIED)
                sb.append("UNSPECIFIED ");
            else if (mode == EXACTLY)
                sb.append("EXACTLY ");
            else if (mode == AT_MOST)
                sb.append("AT_MOST ");
            else
                sb.append(mode).append(" ");
            sb.append(size);
            return sb.toString();
        }
			*/
			return "";
		}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.108 -0500", hash_original_field = "57082254285E8F9D970CB74F9B739331", hash_generated_field = "7E13FB3629EDD21F2BB56B2286490FD6")

        private static final int MODE_SHIFT = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.112 -0500", hash_original_field = "5BD4209024FDF48B78790A6679FE75CF", hash_generated_field = "528C4AF1BEE1BC62589DFB30A7C1B2F3")

        private static final int MODE_MASK  = 0x3 << MODE_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.114 -0500", hash_original_field = "06A7E9A7053C567BBEC26D8F1B910DE1", hash_generated_field = "A67A5415D6CD099BE0676E65CF93997F")

        public static final int UNSPECIFIED = 0 << MODE_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.117 -0500", hash_original_field = "7D345B8C75AAC8CD46C6A9E9B4308633", hash_generated_field = "89B436B79BB9AD4BDF272AC596A5C764")

        public static final int EXACTLY     = 1 << MODE_SHIFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.119 -0500", hash_original_field = "23518B0EB0D9B7DC28F2667552ADDF66", hash_generated_field = "29BD87BC74A43396432B999614D66E82")

        public static final int AT_MOST     = 2 << MODE_SHIFT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.651 -0400", hash_original_method = "2EA619F0F89BA048B9092F3C9EFB9775", hash_generated_method = "2EA619F0F89BA048B9092F3C9EFB9775")
        public MeasureSpec ()
        {
            //Synthesized constructor
        }
    }
    
    class CheckForLongPress implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.135 -0500", hash_original_field = "5A5D77B5C2FD210654E8F75C502269D3", hash_generated_field = "440C867B7432C58C78CA96D4BD4198E7")

        private int mOriginalWindowAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.652 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            //Synthesized constructor
        }
        
        public void run(){
			// Original method
			/*
			{
            if (isPressed() && (mParent != null)
                    && mOriginalWindowAttachCount == mWindowAttachCount) {
                if (performLongClick()) {
                    mHasPerformedLongPress = true;
                }
            }
        }
			*/
			//Return nothing
		}
        
        public void rememberWindowAttachCount(){
			// Original method
			/*
			{
            mOriginalWindowAttachCount = mWindowAttachCount;
        }
			*/
			//Return nothing
		}
        
    }
    
    private final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.653 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }
        
        public void run(){
			// Original method
			/*
			{
            mPrivateFlags &= ~PREPRESSED;
            mPrivateFlags |= PRESSED;
            refreshDrawableState();
            checkForLongClick(ViewConfiguration.getTapTimeout());
        }
			*/
			//Return nothing
		}
        
    }
    
    private final class PerformClick implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.653 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            //Synthesized constructor
        }
        
        public void run(){
			// Original method
            performClick();
		}
        
    }
    
    private final class UnsetPressedState implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.653 -0400", hash_original_method = "6C14B43BA30389F098070D93AD09F5B4", hash_generated_method = "6C14B43BA30389F098070D93AD09F5B4")
        public UnsetPressedState ()
        {
            //Synthesized constructor
        }
        
        public void run(){
			// Original method
			/*
			{
            setPressed(false);
        }
			*/
			//Return nothing
		}
        
    }
    
    public static class BaseSavedState extends AbsSavedState {
        
        public static final Parcelable.Creator<BaseSavedState> CREATOR =
                new Parcelable.Creator<BaseSavedState>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.195 -0500", hash_original_method = "35821D2EA4DFAF558F55A1E0F95556F9", hash_generated_method = "AFA49BD28A79891DE45104F67F4CD08E")
            
public BaseSavedState createFromParcel(Parcel in) {
                return new BaseSavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.198 -0500", hash_original_method = "6AB34CCCCE700DF19CB6D0E0E8A5F161", hash_generated_method = "A172567556A2A06D82D1F93D418F86FF")
            
public BaseSavedState[] newArray(int size) {
                return new BaseSavedState[size];
            }
        };
        /**
         * Constructor used when reading from a parcel. Reads the state of the superclass.
         *
         * @param source
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.189 -0500", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "A170B20D980951FCD7B625137DF8A752")
        
public BaseSavedState(Parcel source) {
            super(source);
        }

        /**
         * Constructor called by derived classes when creating their SavedState objects
         *
         * @param superState The state of the superclass of this view
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.192 -0500", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "47DE192996C36408BDAA9BA55ED90871")
        
public BaseSavedState(Parcelable superState) {
            super(superState);
        }
    }
    
    static class AttachInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.352 -0500", hash_original_field = "80842D7BB6FC3AC7ACF6C7940D9E38E3", hash_generated_field = "8A0661C8B0A6976975978FE86693F94C")

        static final int INVALIDATE_MSG = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.354 -0500", hash_original_field = "4BBF88E4AFDB72DB9215A586ECE45B5D", hash_generated_field = "F72E4284C0ED2AE67CE51BE3A94EBA52")

        static final int INVALIDATE_RECT_MSG = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.257 -0500", hash_original_field = "380F2E6581760A76AE57EA2F3E243A67", hash_generated_field = "380F2E6581760A76AE57EA2F3E243A67")

         IWindowSession mSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.260 -0500", hash_original_field = "B4A12BFD7130A50D27FFF405887EA83D", hash_generated_field = "B4A12BFD7130A50D27FFF405887EA83D")

         IWindow mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.263 -0500", hash_original_field = "794F056D6C296F490A191063CBE7D73B", hash_generated_field = "794F056D6C296F490A191063CBE7D73B")

         IBinder mWindowToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.265 -0500", hash_original_field = "D9C5224ACF349426CF4E47DACA6240CF", hash_generated_field = "D9C5224ACF349426CF4E47DACA6240CF")

         Callbacks mRootCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.267 -0500", hash_original_field = "CDD863CC905A95D66D4F1A2915FF3C29", hash_generated_field = "CDD863CC905A95D66D4F1A2915FF3C29")

        HardwareCanvas mHardwareCanvas;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.269 -0500", hash_original_field = "6D0C26C611FBD233667A9FA9104CED21", hash_generated_field = "6D0C26C611FBD233667A9FA9104CED21")

        View mRootView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.272 -0500", hash_original_field = "942BE5BD2F034C6C8D3F0E7C02B28BE8", hash_generated_field = "942BE5BD2F034C6C8D3F0E7C02B28BE8")

        IBinder mPanelParentWindowToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.274 -0500", hash_original_field = "718CD3BE0BDD64302FC8F6AC61AA9980", hash_generated_field = "718CD3BE0BDD64302FC8F6AC61AA9980")

        Surface mSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.277 -0500", hash_original_field = "68B6EC09532005E80B3FF968D0432D9B", hash_generated_field = "68B6EC09532005E80B3FF968D0432D9B")

        boolean mHardwareAccelerated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.279 -0500", hash_original_field = "74EE98E39C4C179E4AA66BC509EA4A56", hash_generated_field = "74EE98E39C4C179E4AA66BC509EA4A56")

        boolean mHardwareAccelerationRequested;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.281 -0500", hash_original_field = "D13B4D472586A36E031009AA64FCFC65", hash_generated_field = "D13B4D472586A36E031009AA64FCFC65")

        HardwareRenderer mHardwareRenderer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.283 -0500", hash_original_field = "D30A01C9AA1020553FD9B357D21DBD2D", hash_generated_field = "D30A01C9AA1020553FD9B357D21DBD2D")

        float mApplicationScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.285 -0500", hash_original_field = "491DD861F0499CC9AE05718FA07FF84E", hash_generated_field = "491DD861F0499CC9AE05718FA07FF84E")

        boolean mScalingRequired;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.287 -0500", hash_original_field = "463612CF0072B2D91F7638B2CC4F4779", hash_generated_field = "463612CF0072B2D91F7638B2CC4F4779")

        boolean mTurnOffWindowResizeAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.290 -0500", hash_original_field = "027A7FFA44C832AF6DBE17CAF301CFD3", hash_generated_field = "027A7FFA44C832AF6DBE17CAF301CFD3")

        int mWindowLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.292 -0500", hash_original_field = "2CCD3F58E4022E0E51EBBEE7A97CEEC6", hash_generated_field = "2CCD3F58E4022E0E51EBBEE7A97CEEC6")

        int mWindowTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.294 -0500", hash_original_field = "1E46B60B1C8864BF9327E726C9FC6A9D", hash_generated_field = "1E46B60B1C8864BF9327E726C9FC6A9D")

        boolean mUse32BitDrawingCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.297 -0500", hash_original_field = "290E9F8E6A73A2B3125DD9995CBD7840", hash_generated_field = "7E3E0CF71C5FF5FEFC1FCFE669E40B4A")

        final Rect mContentInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.299 -0500", hash_original_field = "FFC6F470A4680792125A2753E4F0C9F9", hash_generated_field = "74237CDD8A53EAC9CF0433F0AD4D3E35")

        final Rect mVisibleInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.301 -0500", hash_original_field = "2407BE01A9B70C13966089FA004856A5", hash_generated_field = "8A62AD277EFE6A58E30A5F0CEE7CACEB")

        final ViewTreeObserver.InternalInsetsInfo mGivenInternalInsets
                = new ViewTreeObserver.InternalInsetsInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.303 -0500", hash_original_field = "B6DD4962B6B0417BCEB3D785E8763FEB", hash_generated_field = "345FD42085C843C83F8EDE4F1834FEE6")

        final ArrayList<View> mScrollContainers = new ArrayList<View>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.306 -0500", hash_original_field = "DEFCA1253F755C96C140877CEA2F5326", hash_generated_field = "FFF6B9F57874D80592FB8DD373F3C84C")

        final KeyEvent.DispatcherState mKeyDispatchState
                = new KeyEvent.DispatcherState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.308 -0500", hash_original_field = "A03D646FF0D655946847407BDB557086", hash_generated_field = "A03D646FF0D655946847407BDB557086")

        boolean mHasWindowFocus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.311 -0500", hash_original_field = "3A96D9774881A4202AEE797B3EE3C1D7", hash_generated_field = "3A96D9774881A4202AEE797B3EE3C1D7")

        int mWindowVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.313 -0500", hash_original_field = "28D76E2182EF97A430A42D24DED52D44", hash_generated_field = "28D76E2182EF97A430A42D24DED52D44")

        long mDrawingTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.315 -0500", hash_original_field = "37B2655ADC8B3B21EEDE7EC8BFE1453D", hash_generated_field = "37B2655ADC8B3B21EEDE7EC8BFE1453D")

        boolean mIgnoreDirtyState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.317 -0500", hash_original_field = "E92F335BE2D9512E3DDCA1603BFA0A77", hash_generated_field = "E92F335BE2D9512E3DDCA1603BFA0A77")

        boolean mSetIgnoreDirtyState = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.319 -0500", hash_original_field = "24BF563E82E7B3377EAF3AE738C5792F", hash_generated_field = "24BF563E82E7B3377EAF3AE738C5792F")

        boolean mInTouchMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.321 -0500", hash_original_field = "E29840F7AED8F4EF12BD623D6B7943B5", hash_generated_field = "E29840F7AED8F4EF12BD623D6B7943B5")

        boolean mRecomputeGlobalAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.324 -0500", hash_original_field = "D34584B0CD3D73B43FC67A71CBBCEDA5", hash_generated_field = "D34584B0CD3D73B43FC67A71CBBCEDA5")

        boolean mForceReportNewAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.326 -0500", hash_original_field = "3FE2095DEBDC328EDDA9F609AE6396C1", hash_generated_field = "3FE2095DEBDC328EDDA9F609AE6396C1")

        boolean mKeepScreenOn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.329 -0500", hash_original_field = "BA594DC97B7780A916BA2DC51EC8AB28", hash_generated_field = "BA594DC97B7780A916BA2DC51EC8AB28")

        int mSystemUiVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.331 -0500", hash_original_field = "DE4F434008ACCD754FC4F174AA6749F2", hash_generated_field = "DE4F434008ACCD754FC4F174AA6749F2")

        boolean mHasSystemUiListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.333 -0500", hash_original_field = "880659755C401DC1FD279B3CDCEB5013", hash_generated_field = "880659755C401DC1FD279B3CDCEB5013")

        boolean mViewVisibilityChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.336 -0500", hash_original_field = "EC57C8BF7094A89AF638ACD00871F015", hash_generated_field = "EC57C8BF7094A89AF638ACD00871F015")

        boolean mViewScrollChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.338 -0500", hash_original_field = "C3C53F9010127A157023B905F36D534F", hash_generated_field = "E13EF288A8359A2A0BBA668D58D91954")

        final int[] mTransparentLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.340 -0500", hash_original_field = "95AE803E723103E1D490A230691BF2D8", hash_generated_field = "2D1B002DD69D7601933D9317EA67321A")

        final int[] mInvalidateChildLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.342 -0500", hash_original_field = "03A968061B896F83CD0DE645EA8735B3", hash_generated_field = "9464421AA3AA82093FBCB7CDAFC0B825")

        final float[] mTmpTransformLocation = new float[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.344 -0500", hash_original_field = "3E601C26EBCAD7D4AC2FBD4D14A7355C", hash_generated_field = "722D3D966A44E5DB85CE72D6A92EFD09")

        final ViewTreeObserver mTreeObserver = new ViewTreeObserver();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.347 -0500", hash_original_field = "D8DB47E921EE865182E76421C432A14B", hash_generated_field = "D8DB47E921EE865182E76421C432A14B")

        Canvas mCanvas;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.349 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

         Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.357 -0500", hash_original_field = "64B8CC68905174D2EB397C6FDD469ED5", hash_generated_field = "588DE05706C2848B18EFBA5AB5C7B09C")

        final Rect mTmpInvalRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.359 -0500", hash_original_field = "03A665FC8D6526486D1AD8B0473EC5F3", hash_generated_field = "F7AE129955F14FB825DEC531D93514BF")

        final RectF mTmpTransformRect = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.361 -0500", hash_original_field = "A0A8D04CA2A965DD3F9D9152367A6522", hash_generated_field = "5A9A000DB49C0CEED945C8004A36E778")

        final ArrayList<View> mFocusablesTempList = new ArrayList<View>(24);
        
        static class InvalidateInfo implements Poolable<InvalidateInfo> {
            
            static InvalidateInfo acquire(){
				// Original method
				/*
				{
                return sPool.acquire();
            }
				*/
				return null;
			}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.208 -0500", hash_original_field = "8B0E658DD91059EF813B52020A729F93", hash_generated_field = "B2FFB1CA44DC2BFD07F60AEC442C51E3")

            private static final int POOL_LIMIT = 10;
            private static final Pool<InvalidateInfo> sPool = Pools.synchronizedPool(
                    Pools.finitePool(new PoolableManager<InvalidateInfo>() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.212 -0500", hash_original_method = "0B6073B4A5361F27732C90B5A7AB03CC", hash_generated_method = "0875C05AB262CD486878E382742CE825")
                
public InvalidateInfo newInstance() {
                            return new InvalidateInfo();
                        }

                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.216 -0500", hash_original_method = "15287F0D7C156B8105154AB6F122F35A", hash_generated_method = "1D4EED2A5156BDA0E25FDDDDC73DA241")
                
public void onAcquired(InvalidateInfo element) {
                        }

                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.219 -0500", hash_original_method = "DFECC27E6152F902E5D7E6478A45C2CF", hash_generated_method = "60D42D20BDF076452A9CF43D8A82FBEB")
                
public void onReleased(InvalidateInfo element) {
                            element.target = null;
                        }
                    }, POOL_LIMIT)
            );
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.224 -0500", hash_original_field = "A9492E33E0C8B19BF83A4E78B960E02A", hash_generated_field = "E9AD1A72A0CA1F1648249A15490614B6")

            private InvalidateInfo mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.226 -0500", hash_original_field = "016073DCFA93DD0305C42C8759ED2078", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.229 -0500", hash_original_field = "4A3D67FC5D08B2108A5D942762FE7F37", hash_generated_field = "4A3D67FC5D08B2108A5D942762FE7F37")

            View target;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.232 -0500", hash_original_field = "F8DAB7F926CD7972429F7B948D9F5533", hash_generated_field = "F8DAB7F926CD7972429F7B948D9F5533")

            int left;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.234 -0500", hash_original_field = "9620536E5A5D6E12CC93092A5EBB857E", hash_generated_field = "9620536E5A5D6E12CC93092A5EBB857E")

            int top;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.236 -0500", hash_original_field = "49C6BE2EEC7270CFEAEFBD796F2C423B", hash_generated_field = "49C6BE2EEC7270CFEAEFBD796F2C423B")

            int right;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.239 -0500", hash_original_field = "7F74B1869951CB3A6660AA746710A714", hash_generated_field = "7F74B1869951CB3A6660AA746710A714")

            int bottom;
            
            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.656 -0400", hash_original_method = "7F8409C46E15AE6EC7087A7F4E97E2BF", hash_generated_method = "7F8409C46E15AE6EC7087A7F4E97E2BF")
            public InvalidateInfo ()
            {
                //Synthesized constructor
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.241 -0500", hash_original_method = "AAFC70DDA5FB82CEF5E58C1F01C303B7", hash_generated_method = "847188DB336AEDD8349E5A7034728A9B")
            
public void setNextPoolable(InvalidateInfo element) {
                mNext = element;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.244 -0500", hash_original_method = "8D8571C3CBC87318B5EA7A031BC44388", hash_generated_method = "CE1F2633087A3755E892010A5C08CF37")
            
public InvalidateInfo getNextPoolable() {
                return mNext;
            }
            
            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            void release(){
				// Original method
				/*
				{
                sPool.release(this);
            }
				*/
				//Return nothing
			}
            
            public boolean isPooled(){
				return getTaintBoolean();
				// Original method
				/*
				{
                return mIsPooled;
            }
				*/
			}
            
            public void setPooled(boolean isPooled){
				addTaint(isPooled);
				// Original method
				/*
				{
                mIsPooled = isPooled;
            }
				*/
				//Return nothing
			}
        }
        
        interface Callbacks {
            @DSComment("Abstract Method")
            @DSSpec(DSCat.ABSTRACT_METHOD)
            void playSoundEffect(int effectId);
            @DSComment("Abstract Method")
            @DSSpec(DSCat.ABSTRACT_METHOD)
            boolean performHapticFeedback(int effectId, boolean always);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.364 -0500", hash_original_field = "2E729681C5CD99C66AC4181B19223EFE", hash_generated_field = "2E729681C5CD99C66AC4181B19223EFE")

        int mAccessibilityWindowId = View.NO_ID;

        /**
         * Creates a new set of attachment information with the specified
         * events handler and thread.
         *
         * @param handler the events handler the view must use
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.367 -0500", hash_original_method = "0CDE5ADA82BD9455683884E38A135C3D", hash_generated_method = "0CDE5ADA82BD9455683884E38A135C3D")
        
AttachInfo(IWindowSession session, IWindow window,
                Handler handler, Callbacks effectPlayer) {
            mSession = session;
            mWindow = window;
            mWindowToken = window.asBinder();
            mHandler = handler;
            mRootCallbacks = effectPlayer;
        }
    }
    
    private static class ScrollabilityCache implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.374 -0500", hash_original_field = "7F5D05C2AD04678AD0A7EB3C7A33A273", hash_generated_field = "7C2FCAABFF0839BC46F5A1C3AF188D77")

        public static final int OFF = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.377 -0500", hash_original_field = "91CB386B4D8ED538BC8BDF0B27845088", hash_generated_field = "4AEC3247A48615FF5865CC0B1A3C7705")

        public static final int ON = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.379 -0500", hash_original_field = "C6E4CF69980BDA1614F2852182E2624E", hash_generated_field = "656FDD706C20A529B22AC373F45EB16E")

        public static final int FADING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.412 -0500", hash_original_field = "F2816E335F9E7D459BA0533EA432E5A4", hash_generated_field = "C6ECC8F0B0BA37B0E970AFED1D0BFB91")

        private static final float[] OPAQUE = { 255 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.414 -0500", hash_original_field = "A58C18E856E231E76BF329060FEEDEF7", hash_generated_field = "52ECE7CD9B5C9B08E7595DC0D955B8C4")

        private static final float[] TRANSPARENT = { 0.0f };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.382 -0500", hash_original_field = "B31EC06432763A6671CEF03DD2A81534", hash_generated_field = "C6A1369EC898F10B405072E1D6B6F8F1")

        public boolean fadeScrollBars;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.384 -0500", hash_original_field = "4FFD37ADE65AF03DB7E0BDF884999341", hash_generated_field = "1655F035B56E41B8BE16E5CF56B77BA2")

        public int fadingEdgeLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.386 -0500", hash_original_field = "6BF8D605C6E29B178BA1A37938ED200B", hash_generated_field = "0B6D856A35EB0627FF7887D758165295")

        public int scrollBarDefaultDelayBeforeFade;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.389 -0500", hash_original_field = "4476E1146EACF29004FFAF7B1A1BCF23", hash_generated_field = "E863540FC8628DCB2E031D759E080999")

        public int scrollBarFadeDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.391 -0500", hash_original_field = "69038BAD16720EBF121FB3FC6A458F4C", hash_generated_field = "83B1C5317C031D0AB20405882919848B")

        public int scrollBarSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.393 -0500", hash_original_field = "C7D733E7147ACB74D2136C014BE42929", hash_generated_field = "C08FDE67EA8E9E077C57F9B7B9A2DF77")

        public ScrollBarDrawable scrollBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.396 -0500", hash_original_field = "391D3D8FB097F27D665A9F88AEE5E613", hash_generated_field = "CB96A972AA75A47BFD6582D710EC82DF")

        public float[] interpolatorValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.399 -0500", hash_original_field = "0EAF9C38E3891EC45F2492C094078014", hash_generated_field = "56B8BC9706D6E065A7599937E8F804CC")

        public View host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.401 -0500", hash_original_field = "DB4C54537F56BBAE2B12D988521190CB", hash_generated_field = "7AA4ED035C35711F4B33B0135B4A7789")

        public  Paint paint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.404 -0500", hash_original_field = "50992BD97945D046A0EDD0BD51982AC9", hash_generated_field = "2ED3478F7527E1ECF1A41F8EA29E0792")

        public  Matrix matrix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.406 -0500", hash_original_field = "4EFAE56A0C6DCF8149A7DAA258C6A3AD", hash_generated_field = "BD5E2F7CC0958EF9E9784897D7D71294")

        public Shader shader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.408 -0500", hash_original_field = "E8DB0682D5352DE524AA1FF0572A4B49", hash_generated_field = "38B61C924838E45A7FCDE7AF77E8755E")

        public final Interpolator scrollBarInterpolator = new Interpolator(1, 2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.417 -0500", hash_original_field = "F1260F15520261FE28B1B39A15288D39", hash_generated_field = "FA7A925863D78B977D2FC3469F1DC9E9")

        public long fadeStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.419 -0500", hash_original_field = "DA938B42C9DCD672BBB14AFAA46A5B9A", hash_generated_field = "41AF84CAED377B81AC74E102DF2E9D6D")

        public int state = OFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.421 -0500", hash_original_field = "7A225E374D3C8D7B119A0014FC4380EC", hash_generated_field = "AC03B4B52C8DAA90037D992009D92CB0")

        private int mLastColor;
        
        ScrollabilityCache(ViewConfiguration configuration, View host){
			paint = new Paint();
			matrix = new Matrix();
			/*
			fadingEdgeLength = configuration.getScaledFadingEdgeLength();
			scrollBarSize = configuration.getScaledScrollBarSize();
			scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
			scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
			paint = new Paint();
			matrix = new Matrix();
			shader = new LinearGradient(0, 0, 0, 1, 0xFF000000, 0, Shader.TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
			this.host = host;
			*/
		}
        
        public void setFadeColor(int color){
			// Original method
			/*
			{
            if (color != 0 && color != mLastColor) {
                mLastColor = color;
                color |= 0xFF000000;
                shader = new LinearGradient(0, 0, 0, 1, color | 0xFF000000,
                        color & 0x00FFFFFF, Shader.TileMode.CLAMP);
                paint.setShader(shader);
                paint.setXfermode(null);
            }
        }
			*/
			//Return nothing
		}
        
        public void run(){
			// Original method
			/*
			{
            long now = AnimationUtils.currentAnimationTimeMillis();
            if (now >= fadeStartTime) {
                int nextFrame = (int) now;
                int framesCount = 0;
                Interpolator interpolator = scrollBarInterpolator;
                interpolator.setKeyFrame(framesCount++, nextFrame, OPAQUE);
                nextFrame += scrollBarFadeDuration;
                interpolator.setKeyFrame(framesCount, nextFrame, TRANSPARENT);
                state = FADING;
                host.invalidate(true);
            }
        }
			*/
			//Return nothing
		}
    }
    
    private class SendViewScrolledAccessibilityEvent implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.435 -0500", hash_original_field = "FED94FB1EAA0AA5EA7631CA7B3A3B650", hash_generated_field = "8E5087238AE27D181E6487D7D8E8CADB")

        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.663 -0400", hash_original_method = "67D827D7B507D3EF133C26B0E057ECB2", hash_generated_method = "67D827D7B507D3EF133C26B0E057ECB2")
        public SendViewScrolledAccessibilityEvent ()
        {
            //Synthesized constructor
        }
        
        public void run(){
			// Original method
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            mIsPending = false;
			//Return nothing
		}
        
    }
    
    public static class AccessibilityDelegate {
        
        @DSVerified
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:34.663 -0400", hash_original_method = "B81C1E38B66B1195ED1D00E194D402D3", hash_generated_method = "B81C1E38B66B1195ED1D00E194D402D3")
        public AccessibilityDelegate ()
        {
            //Synthesized constructor
        }
        
        @DSVerified
        @DSComment("IO movement methodName")
        @DSSpec(DSCat.IO_ACTION_METHOD)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        public void sendAccessibilityEvent(View host, int eventType){
			// Original method
			/*
			{
            host.sendAccessibilityEventInternal(eventType);
        }
			*/
			//Return nothing
		}
        
        @DSVerified
        @DSComment("IO movement methodName")
        @DSSpec(DSCat.IO_ACTION_METHOD)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event){
			// Original method
            host.sendAccessibilityEventUncheckedInternal(event);
			//Return nothing
		}
        
        @DSVerified("Callback modeled")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event){
            return host.dispatchPopulateAccessibilityEventInternal(event);
		}
        
        @DSVerified
        @DSComment("normal android callback")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event){
            host.onPopulateAccessibilityEventInternal(event);
			//Return nothing
		}
        
        @DSVerified
        @DSComment("normal android callback")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event){
			// Original method
            host.onInitializeAccessibilityEventInternal(event);
			//Return nothing
		}
        
        @DSComment("normal android callback")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSVerified
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info){
			// Original method
            host.onInitializeAccessibilityNodeInfoInternal(info);
			//Return nothing
		}
        
        @DSVerified
        @DSComment("normal android callback")
        @DSSafe(DSCat.ANDROID_CALLBACK)
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                AccessibilityEvent event){
			// Original method
            return host.onRequestSendAccessibilityEventInternal(child, event);
		}
        
    }
    
    public interface OnLayoutChangeListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onLayoutChange(View v, int left, int top, int right, int bottom,
            int oldLeft, int oldTop, int oldRight, int oldBottom);
    }
    
    public interface OnKeyListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onKey(View v, int keyCode, KeyEvent event);
    }
    
    public interface OnTouchListener {
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onTouch(View v, MotionEvent event);
    }
    
    public interface OnHoverListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onHover(View v, MotionEvent event);
    }
    
    public interface OnGenericMotionListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onGenericMotion(View v, MotionEvent event);
    }
    
    public interface OnLongClickListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onLongClick(View v);
    }
    
    public interface OnDragListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onDrag(View v, DragEvent event);
    }
    
    public interface OnFocusChangeListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onFocusChange(View v, boolean hasFocus);
    }
    
    public interface OnClickListener {
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        // @DSVerified()
        void onClick(View v);
    }
    
    public interface OnCreateContextMenuListener {
        @DSVerified
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo);
    }
    
    public interface OnSystemUiVisibilityChangeListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onSystemUiVisibilityChange(int visibility);
    }
    
    public interface OnAttachStateChangeListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onViewAttachedToWindow(View v);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onViewDetachedFromWindow(View v);
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean post(Runnable action){
		// Original method
		/*
		{
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
        } else {
            ViewRootImpl.getRunQueue().post(action);
            return true;
        }
        return handler.post(action);
    }
		*/
    	addTaint(action.getTaint());
    	Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
            handler.post(action);
        } else {
            ViewRootImpl.getRunQueue().post(action);
        }
        return getTaintBoolean();
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean postDelayed(Runnable action, long delayMillis){
		// Original method
		/*
		{
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
        } else {
            ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
            return true;
        }
        return handler.postDelayed(action, delayMillis);
    }
		*/
		return false;
	}
    
    @DSComment("no action when removing callback")
    @DSSafe(DSCat.SAFE_OTHERS)
    public boolean removeCallbacks(Runnable action){
		// Original method
		/*
		{
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
        } else {
            ViewRootImpl.getRunQueue().removeCallbacks(action);
            return true;
        }
        handler.removeCallbacks(action);
        return true;
    }
		*/
    	addTaint(action.getTaint());
    	Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            handler = attachInfo.mHandler;
            handler.removeCallbacks(action);
        } else {
            ViewRootImpl.getRunQueue().removeCallbacks(action);
        }
        
        return getTaintBoolean();
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void postInvalidate(){
		// Original method
		/*
		{
        postInvalidateDelayed(0);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void postInvalidate(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        postInvalidateDelayed(0, left, top, right, bottom);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void postInvalidateDelayed(long delayMilliseconds){
		// Original method
		/*
		{
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            Message msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_MSG;
            msg.obj = this;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top,
            int right, int bottom){
		// Original method
		/*
		{
        AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            final AttachInfo.InvalidateInfo info = AttachInfo.InvalidateInfo.acquire();
            info.target = this;
            info.left = left;
            info.top = top;
            info.right = right;
            info.bottom = bottom;
            final Message msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_RECT_MSG;
            msg.obj = info;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void postSendViewScrolledAccessibilityEventCallback(){
		// Original method
		/*
		{
        if (mSendViewScrolledAccessibilityEvent == null) {
            mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        }
        if (!mSendViewScrolledAccessibilityEvent.mIsPending) {
            mSendViewScrolledAccessibilityEvent.mIsPending = true;
            postDelayed(mSendViewScrolledAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        }
    }
		*/
		//Return nothing
	}

    /**
     * Called by a parent to request that a child update its values for mScrollX
     * and mScrollY if necessary. This will typically be done if the child is
     * animating a scroll using a {@link android.widget.Scroller Scroller}
     * object.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.475 -0500", hash_original_method = "7821AAE99E52242CE62352C839CCDCC3", hash_generated_method = "621EBF7F6DB1A379BC3EE8273771FF54")
    
public void computeScroll() {
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isHorizontalFadingEdgeEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & FADING_EDGE_HORIZONTAL) == FADING_EDGE_HORIZONTAL;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled){
		// Original method
		/*
		{
        if (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled) {
            if (horizontalFadingEdgeEnabled) {
                initScrollCache();
            }
            mViewFlags ^= FADING_EDGE_HORIZONTAL;
        }
    }
		*/
		//Return nothing
    	addTaint(horizontalFadingEdgeEnabled);
    	if (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled) {
            if (horizontalFadingEdgeEnabled) {
                initScrollCache();
            }
            mViewFlags ^= FADING_EDGE_HORIZONTAL;
        }
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isVerticalFadingEdgeEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & FADING_EDGE_VERTICAL) == FADING_EDGE_VERTICAL;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled){
		// Original method
		/*
		{
        if (isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled) {
            if (verticalFadingEdgeEnabled) {
                initScrollCache();
            }
            mViewFlags ^= FADING_EDGE_VERTICAL;
        }
    }
		*/
		//Return nothing
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected float getTopFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeVerticalScrollOffset() > 0 ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected float getBottomFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                computeVerticalScrollRange() ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected float getLeftFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeHorizontalScrollOffset() > 0 ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected float getRightFadingEdgeStrength(){
		// Original method
		/*
		{
        return computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                computeHorizontalScrollRange() ? 1.0f : 0.0f;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isHorizontalScrollBarEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled){
		// Original method
		/*
		{
        if (isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled) {
            mViewFlags ^= SCROLLBARS_HORIZONTAL;
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isVerticalScrollBarEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled){
		// Original method
		/*
		{
        if (isVerticalScrollBarEnabled() != verticalScrollBarEnabled) {
            mViewFlags ^= SCROLLBARS_VERTICAL;
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}
    
    protected void recomputePadding(){
		// Original method
		/*
		{
        setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setScrollbarFadingEnabled(boolean fadeScrollbars){
		// Original method
		/*
		{
        initScrollCache();
        final ScrollabilityCache scrollabilityCache = mScrollCache;
        scrollabilityCache.fadeScrollBars = fadeScrollbars;
        if (fadeScrollbars) {
            scrollabilityCache.state = ScrollabilityCache.OFF;
        } else {
            scrollabilityCache.state = ScrollabilityCache.ON;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isScrollbarFadingEnabled(){
		// Original method
		/*
		{
        return mScrollCache != null && mScrollCache.fadeScrollBars;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setScrollBarStyle(int style){
		// Original method
		/*
		{
        if (style != (mViewFlags & SCROLLBARS_STYLE_MASK)) {
            mViewFlags = (mViewFlags & ~SCROLLBARS_STYLE_MASK) | (style & SCROLLBARS_STYLE_MASK);
            computeOpaqueFlags();
            resolvePadding();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(mapping={@ViewDebug.IntToString(from=SCROLLBARS_INSIDE_OVERLAY,to="INSIDE_OVERLAY"),@ViewDebug.IntToString(from=SCROLLBARS_INSIDE_INSET,to="INSIDE_INSET"),@ViewDebug.IntToString(from=SCROLLBARS_OUTSIDE_OVERLAY,to="OUTSIDE_OVERLAY"),@ViewDebug.IntToString(from=SCROLLBARS_OUTSIDE_INSET,to="OUTSIDE_INSET")}) public int getScrollBarStyle(){
		// Original method
		/*
		{
        return mViewFlags & SCROLLBARS_STYLE_MASK;
    }
		*/
		return 0;
	}
    
    protected int computeHorizontalScrollRange(){
		// Original method
		/*
		{
        return getWidth();
    }
		*/
		return 0;
	}
    
    protected int computeHorizontalScrollOffset(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollX;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected int computeHorizontalScrollExtent(){
		// Original method
		/*
		{
        return getWidth();
    }
		*/
		return 0;
	}
    
    protected int computeVerticalScrollRange(){
		// Original method
		/*
		{
        return getHeight();
    }
		*/
		return 0;
	}
    
    protected int computeVerticalScrollOffset(){
		return getTaintInt();
		// Original method
		/*
		{
        return mScrollY;
    }
		*/
	}
    
    protected int computeVerticalScrollExtent(){
		// Original method
		/*
		{
        return getHeight();
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean canScrollHorizontally(int direction){
		// Original method
		/*
		{
        final int offset = computeHorizontalScrollOffset();
        final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (range == 0) return false;
        if (direction < 0) {
            return offset > 0;
        } else {
            return offset < range - 1;
        }
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean canScrollVertically(int direction){
		// Original method
		/*
		{
        final int offset = computeVerticalScrollOffset();
        final int range = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (range == 0) return false;
        if (direction < 0) {
            return offset > 0;
        } else {
            return offset < range - 1;
        }
    }
		*/
		return false;
	}
    
    protected final void onDrawScrollBars(Canvas canvas){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Override this if the vertical scrollbar needs to be hidden in a subclass, like when
     * FastScroller is visible.
     * @return whether to temporarily hide the vertical scrollbar
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.542 -0500", hash_original_method = "27496C077301642151620030AE06D353", hash_generated_method = "960F1AED158ACDC12312D3446EA49376")
    
protected boolean isVerticalScrollBarHidden() {
        return false;
    }
    
    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b){
		// Original method
		/*
		{
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
    }
		*/
		//Return nothing
	}
    
    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b){
		// Original method
		/*
		{
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
    }
		*/
		//Return nothing
	}

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.549 -0500", hash_original_method = "88C9EEC1EB66ECE8EDFB3E744FAAD32C", hash_generated_method = "E113BC8AA739CC725E469C12F71C1101")
    @DSVerified
    
protected void onDraw(Canvas canvas) {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void assignParent(ViewParent parent){
		// Original method
		/*
		{
        if (mParent == null) {
            mParent = parent;
        } else if (parent == null) {
            mParent = null;
        } else {
            throw new RuntimeException("view " + this + " being added, but"
                    + " it already has a parent");
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onAttachedToWindow(){
		// Original method
		/*
		{
        if ((mPrivateFlags & REQUEST_TRANSPARENT_REGIONS) != 0) {
            mParent.requestTransparentRegion(this);
        }
        if ((mPrivateFlags & AWAKEN_SCROLL_BARS_ON_ATTACH) != 0) {
            initialAwakenScrollBars();
            mPrivateFlags &= ~AWAKEN_SCROLL_BARS_ON_ATTACH;
        }
        jumpDrawablesToCurrentState();
        resolveLayoutDirectionIfNeeded();
        resolvePadding();
        resolveTextDirection();
        if (isFocused()) {
            InputMethodManager imm = InputMethodManager.peekInstance();
            imm.focusIn(this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void resolveLayoutDirectionIfNeeded(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    protected void resolvePadding(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    protected boolean canResolveLayoutDirection(){
		// Original method
		/*
		{
        switch (getLayoutDirection()) {
            case LAYOUT_DIRECTION_INHERIT:
                return (mParent != null);
            default:
                return true;
        }
    }
		*/
		return false;
	}
    
    protected void resetResolvedLayoutDirection(){
		// Original method
		/*
		{
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
    }
		*/
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onDetachedFromWindow(){
		// Original method
		/*
		{
        mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        removeUnsetPressCallback();
        removeLongPressCallback();
        removePerformClickCallback();
        removeSendViewScrolledAccessibilityEventCallback();
        destroyDrawingCache();
        destroyLayer();
        if (mDisplayList != null) {
            mDisplayList.invalidate();
        }
        if (mAttachInfo != null) {
            mAttachInfo.mHandler.removeMessages(AttachInfo.INVALIDATE_MSG, this);
        }
        mCurrentAnimation = null;
        resetResolvedLayoutDirection();
        resetResolvedTextDirection();
    }
		*/
		//Return nothing
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected int getWindowAttachCount(){
		return getTaintInt();
		// Original method
		/*
		{
        return mWindowAttachCount;
    }
		*/
	}
    
    @DSComment("Binder is vague, need modeling")
    @DSSpec(DSCat.IPC)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public IBinder getWindowToken(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mWindowToken : null;
    }
		*/
		return null;
	}
    
    @DSComment("Binder is vague, need modeling")
    @DSSpec(DSCat.IPC)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public IBinder getApplicationWindowToken(){
		// Original method
		/*
		{
        AttachInfo ai = mAttachInfo;
        if (ai != null) {
            IBinder appWindowToken = ai.mPanelParentWindowToken;
            if (appWindowToken == null) {
                appWindowToken = ai.mWindowToken;
            }
            return appWindowToken;
        }
        return null;
    }
		*/
		return null;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    IWindowSession getWindowSession(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mSession : null;
    }
		*/
		return null;
	}
    
    void dispatchAttachedToWindow(AttachInfo info, int visibility){
		mAttachInfo = info;
		info.mTreeObserver.merge(mFloatingTreeObserver);
		mAttachInfo.mScrollContainers.add(this);
		performCollectViewAttributes(visibility);
        onAttachedToWindow();
        ListenerInfo li = mListenerInfo;
        final CopyOnWriteArrayList<OnAttachStateChangeListener> listeners =
                li != null ? li.mOnAttachStateChangeListeners : null;
        for (OnAttachStateChangeListener listener : listeners) {
            listener.onViewAttachedToWindow(this);
        }
        int vis = info.mWindowVisibility;
        onWindowVisibilityChanged(vis);
        refreshDrawableState();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void dispatchDetachedFromWindow(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void saveHierarchyState(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        dispatchSaveInstanceState(container);
    }
		*/
		//Return nothing
	}

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container){
		// Original method
        if (mID != NO_ID && (mViewFlags & SAVE_DISABLED_MASK) == 0) {
            mPrivateFlags &= ~SAVE_STATE_CALLED;
            Parcelable state = onSaveInstanceState();
            if ((mPrivateFlags & SAVE_STATE_CALLED) == 0) {
                throw new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
            }
            if (state != null) {
                container.put(mID, state);
            }
        }
	}
    
    @DSVerified
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    protected Parcelable onSaveInstanceState(){
		// Original method
		/*
		{
        mPrivateFlags |= SAVE_STATE_CALLED;
        return BaseSavedState.EMPTY_STATE;
    }
		*/
        //return BaseSavedState.CREATOR.createFromParcel(new Parcel)
		//return null;
        return BaseSavedState.EMPTY_STATE;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void restoreHierarchyState(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        dispatchRestoreInstanceState(container);
    }
		*/
		//Return nothing
	}
    @DSVerified("Calling callbacks/dispatching function")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container){
		// Original method
        if (mID != NO_ID) {
            Parcelable state = container.get(mID);
            if (state != null) {
                onRestoreInstanceState(state);
            }
        }
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    protected void onRestoreInstanceState(Parcelable state){
		// Original method
		/*
		{
        mPrivateFlags |= SAVE_STATE_CALLED;
        if (state != BaseSavedState.EMPTY_STATE && state != null) {
            throw new IllegalArgumentException("Wrong state class, expecting View State but "
                    + "received " + state.getClass().toString() + " instead. This usually happens "
                    + "when two views of different type have the same id in the same hierarchy. "
                    + "This view's id is " + ViewDebug.resolveId(mContext, getId()) + ". Make sure "
                    + "other views do not use the same id.");
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public long getDrawingTime(){
		// Original method
		/*
		{
        return mAttachInfo != null ? mAttachInfo.mDrawingTime : 0;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setDuplicateParentStateEnabled(boolean enabled){
		// Original method
		/*
		{
        setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isDuplicateParentStateEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setLayerType(int layerType, Paint paint){
		addTaint(layerType);
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean hasStaticLayer(){
		// Original method
		/*
		{
        return mLayerType == LAYER_TYPE_NONE;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getLayerType(){
		return getTaintInt();
		// Original method
		/*
		{
        return mLayerType;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void buildLayer(){
		// Original method
		/*
		{
        if (mLayerType == LAYER_TYPE_NONE) return;
        if (mAttachInfo == null) {
            throw new IllegalStateException("This view must be attached to a window first");
        }
        switch (mLayerType) {
            case LAYER_TYPE_HARDWARE:
                if (mAttachInfo.mHardwareRenderer != null &&
                        mAttachInfo.mHardwareRenderer.isEnabled() &&
                        mAttachInfo.mHardwareRenderer.validate()) {
                    getHardwareLayer();
                }
                break;
            case LAYER_TYPE_SOFTWARE:
                buildDrawingCache(true);
                break;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    HardwareLayer getHardwareLayer(){
		return mHardwareLayer;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean destroyLayer(){
		// Original method
		/*
		{
        if (mHardwareLayer != null) {
            mHardwareLayer.destroy();
            mHardwareLayer = null;
            invalidate(true);
            invalidateParentCaches();
            return true;
        }
        return false;
    }
		*/
		return false;
	}
    
    protected void destroyHardwareResources(){
		// Original method
		/*
		{
        destroyLayer();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setDrawingCacheEnabled(boolean enabled){
		// Original method
		/*
		{
        mCachingFailed = false;
        setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="drawing") 
	public boolean isDrawingCacheEnabled(){
		// Original method
		/*
		{
        return (mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED;
    }
		*/
		return false;
	}
    
    @SuppressWarnings({"UnusedDeclaration"}) 
	public void outputDirtyFlags(String indent, boolean clear, int clearMask){
		// Original method
		/*
		{
        Log.d("View", indent + this + "             DIRTY(" + (mPrivateFlags & View.DIRTY_MASK) +
                ") DRAWN(" + (mPrivateFlags & DRAWN) + ")" + " CACHE_VALID(" +
                (mPrivateFlags & View.DRAWING_CACHE_VALID) +
                ") INVALIDATED(" + (mPrivateFlags & INVALIDATED) + ")");
        if (clear) {
            mPrivateFlags &= clearMask;
        }
        if (this instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) this;
            final int count = parent.getChildCount();
            for (int i = 0; i < count; i++) {
                final View child = parent.getChildAt(i);
                child.outputDirtyFlags(indent + "  ", clear, clearMask);
            }
        }
    }
		*/
		//Return nothing
	}

    /**
     * This method is used by ViewGroup to cause its children to restore or recreate their
     * display lists. It is called by getDisplayList() when the parent ViewGroup does not need
     * to recreate its own display list, which would happen if it went through the normal
     * draw/dispatchDraw mechanisms.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.634 -0500", hash_original_method = "F520ED30BD4141F0E67AE80815EDDC89", hash_generated_method = "3A5F2BEE817AFAE55E04154E19C32397")
    
protected void dispatchGetDisplayList() {}
    
    public boolean canHaveDisplayList(){
		// Original method
		/*
		{
        return !(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null);
    }
		*/
		return false;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public DisplayList getDisplayList(){
		return mDisplayList;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Bitmap getDrawingCache(){
		// Original method
		/*
		{
        return getDrawingCache(false);
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Bitmap getDrawingCache(boolean autoScale){
		// Original method
		/*
		{
        if ((mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING) {
            return null;
        }
        if ((mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED) {
            buildDrawingCache(autoScale);
        }
        return autoScale ? mDrawingCache : mUnscaledDrawingCache;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void destroyDrawingCache(){
		// Original method
		/*
		{
        if (mDrawingCache != null) {
            mDrawingCache.recycle();
            mDrawingCache = null;
        }
        if (mUnscaledDrawingCache != null) {
            mUnscaledDrawingCache.recycle();
            mUnscaledDrawingCache = null;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setDrawingCacheBackgroundColor(int color){
		// Original method
		/*
		{
        if (color != mDrawingCacheBackgroundColor) {
            mDrawingCacheBackgroundColor = color;
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDrawingCacheBackgroundColor(){
		return getTaintInt();
		// Original method
		/*
		{
        return mDrawingCacheBackgroundColor;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void buildDrawingCache(){
		// Original method
		/*
		{
        buildDrawingCache(false);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void buildDrawingCache(boolean autoScale){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    /**
     * Indicates whether this View is currently in edit mode. A View is usually
     * in edit mode when displayed within a developer tool. For instance, if
     * this View is being drawn by a visual user interface builder, this method
     * should return true.
     *
     * Subclasses should check the return value of this method to provide
     * different behaviors if their normal behavior might interfere with the
     * host environment. For instance: the class spawns a thread in its
     * constructor, the drawing code relies on device-specific features, etc.
     *
     * This method is usually checked in the drawing code of custom widgets.
     *
     * @return True if this View is in edit mode, false otherwise.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.664 -0500", hash_original_method = "B880B01C07154F288A73209778F72869", hash_generated_method = "70818C720D3A8CB90D23B6BC79008392")
    
public boolean isInEditMode() {
        return false;
    }

    /**
     * If the View draws content inside its padding and enables fading edges,
     * it needs to support padding offsets. Padding offsets are added to the
     * fading edges to extend the length of the fade so that it covers pixels
     * drawn inside the padding.
     *
     * Subclasses of this class should override this method if they need
     * to draw content inside the padding.
     *
     * @return True if padding offset must be applied, false otherwise.
     *
     * @see #getLeftPaddingOffset()
     * @see #getRightPaddingOffset()
     * @see #getTopPaddingOffset()
     * @see #getBottomPaddingOffset()
     *
     * @since CURRENT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.666 -0500", hash_original_method = "FAE0811CBF87AAE1D612614CB5EBE838", hash_generated_method = "97C4CA550E659F37111E25B726A31C7B")
    
protected boolean isPaddingOffsetRequired() {
        return false;
    }

    /**
     * Amount by which to extend the left fading region. Called only when
     * {@link #isPaddingOffsetRequired()} returns true.
     *
     * @return The left padding offset in pixels.
     *
     * @see #isPaddingOffsetRequired()
     *
     * @since CURRENT
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.668 -0500", hash_original_method = "4C949B81A8DC7FEE598CF97986A5D947", hash_generated_method = "C991B347824CE7D62ADD5D514755DD0E")
    
protected int getLeftPaddingOffset() {
        return 0;
    }

    /**
     * Amount by which to extend the right fading region. Called only when
     * {@link #isPaddingOffsetRequired()} returns true.
     *
     * @return The right padding offset in pixels.
     *
     * @see #isPaddingOffsetRequired()
     *
     * @since CURRENT
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.670 -0500", hash_original_method = "074FFDE548FCC46FA1E9A30627AB8A7C", hash_generated_method = "0556BE88216168855C2D91C58A83CA48")
    
protected int getRightPaddingOffset() {
        return 0;
    }

    /**
     * Amount by which to extend the top fading region. Called only when
     * {@link #isPaddingOffsetRequired()} returns true.
     *
     * @return The top padding offset in pixels.
     *
     * @see #isPaddingOffsetRequired()
     *
     * @since CURRENT
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.672 -0500", hash_original_method = "A9CEAAEF3075A726E0EAEBF5F9AFAFB2", hash_generated_method = "FC80B881609FC42261B3B51AF76E5DAE")
    
protected int getTopPaddingOffset() {
        return 0;
    }

    /**
     * Amount by which to extend the bottom fading region. Called only when
     * {@link #isPaddingOffsetRequired()} returns true.
     *
     * @return The bottom padding offset in pixels.
     *
     * @see #isPaddingOffsetRequired()
     *
     * @since CURRENT
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.676 -0500", hash_original_method = "8428DF91FD33A9244C31B60F9D34D200", hash_generated_method = "FF53ED5A195D47D16AE6F721868227F3")
    
protected int getBottomPaddingOffset() {
        return 0;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected int getFadeTop(boolean offsetRequired){
		// Original method
		/*
		{
        int top = mPaddingTop;
        if (offsetRequired) top += getTopPaddingOffset();
        return top;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected int getFadeHeight(boolean offsetRequired){
		// Original method
		/*
		{
        int padding = mPaddingTop;
        if (offsetRequired) padding += getTopPaddingOffset();        
        return mBottom - mTop - mPaddingBottom - padding;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isHardwareAccelerated(){
		// Original method
		/*
		{
        return mAttachInfo != null && mAttachInfo.mHardwareAccelerated;
    }
		*/
		return false;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void draw(Canvas canvas){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Override this if your view is known to always be drawn on top of a solid color background,
     * and needs to draw fading edges. Returning a non-zero color enables the view system to
     * optimize the drawing of the fading edges. If you do return a non-zero color, the alpha
     * should be set to 0xFF.
     *
     * @see #setVerticalFadingEdgeEnabled(boolean) 
     * @see #setHorizontalFadingEdgeEnabled(boolean) 
     *
     * @return The known solid color background for this view, or 0 if the color may vary
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.691 -0500", hash_original_method = "6ABCD0F86C11EBC98FE78FD55BB4B1CF", hash_generated_method = "106888BB941B9E9A76CD7DB736B7CCA4")
    
@ViewDebug.ExportedProperty(category = "drawing")
    public int getSolidColor() {
        return 0;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isLayoutRequested(){
		// Original method
		/*
		{
        return (mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @SuppressWarnings({"unchecked"}) public void layout(int l, int t, int r, int b){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Called from layout when this view should
     * assign a size and position to each of its children.
     *
     * Derived classes with children should override
     * this method and call layout on each of
     * their children.
     * @param changed This is a new size or position for this view
     * @param left Left position, relative to parent
     * @param top Top position, relative to parent
     * @param right Right position, relative to parent
     * @param bottom Bottom position, relative to parent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.704 -0500", hash_original_method = "E68A871B23A3BFC32DE9705D7524956B", hash_generated_method = "CA5AFEF0E64C1FE02B10DED3DB84F6B3")
    
protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }
    
    protected boolean setFrame(int left, int top, int right, int bottom){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    /**
     * Finalize inflating a view from XML.  This is called as the last phase
     * of inflation, after all child views have been added.
     *
     * <p>Even if the subclass overrides onFinishInflate, they should always be
     * sure to call the super method, so that we get called.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.710 -0500", hash_original_method = "BECA18BF96D1F48EBBDC02908C938AE4", hash_generated_method = "2D605D98334BE478AFA7DCE07EE8FCC3")
    
protected void onFinishInflate() {
    }

    /**
     * Returns the resources associated with this view.
     *
     * @return Resources object.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.712 -0500", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "05B1D2D3E0E7E913183B96A460337403")
    
public Resources getResources() {
        return mResources;
    }
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void invalidateDrawable(Drawable drawable){
		// Original method
		/*
		{
        if (verifyDrawable(drawable)) {
            final Rect dirty = drawable.getBounds();
            final int scrollX = mScrollX;
            final int scrollY = mScrollY;
            invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void scheduleDrawable(Drawable who, Runnable what, long when){
		// Original method
		/*
		{
        if (verifyDrawable(who) && what != null) {
            if (mAttachInfo != null) {
                mAttachInfo.mHandler.postAtTime(what, who, when);
            } else {
                ViewRootImpl.getRunQueue().postDelayed(what, when - SystemClock.uptimeMillis());
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void unscheduleDrawable(Drawable who, Runnable what){
		// Original method
		/*
		{
        if (verifyDrawable(who) && what != null) {
            if (mAttachInfo != null) {
                mAttachInfo.mHandler.removeCallbacks(what, who);
            } else {
                ViewRootImpl.getRunQueue().removeCallbacks(what);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void unscheduleDrawable(Drawable who){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            mAttachInfo.mHandler.removeCallbacksAndMessages(who);
        }
    }
		*/
		//Return nothing
	}
    
    public int getResolvedLayoutDirection(Drawable who){
		// Original method
		/*
		{
        return (who == mBGDrawable) ? getResolvedLayoutDirection() : LAYOUT_DIRECTION_DEFAULT;
    }
		*/
		return 0;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected boolean verifyDrawable(Drawable who){
		// Original method
		/*
		{
        return who == mBGDrawable;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected void drawableStateChanged(){
		// Original method
		/*
		{
        Drawable d = mBGDrawable;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void refreshDrawableState(){
		// Original method
		/*
		{
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        drawableStateChanged();
        ViewParent parent = mParent;
        if (parent != null) {
            parent.childDrawableStateChanged(this);
        }
    }
		*/
		//Return nothing
	}

    /**
     * Return an array of resource IDs of the drawable states representing the
     * current state of the view.
     *
     * @return The current drawable state
     *
     * @see Drawable#setState(int[]) 
     * @see #drawableStateChanged() 
     * @see #onCreateDrawableState(int) 
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.733 -0500", hash_original_method = "7B628D8EF95C580B0BB9FD927C61FF3F", hash_generated_method = "59083194AD43A498D67A0E3A4346D522")
    
public final int[] getDrawableState() {
        if ((mDrawableState != null) && ((mPrivateFlags & DRAWABLE_STATE_DIRTY) == 0)) {
            return mDrawableState;
        } else {
            mDrawableState = onCreateDrawableState(0);
            mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
            return mDrawableState;
        }
    }
    
    protected int[] onCreateDrawableState(int extraSpace){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return new int[1];
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void jumpDrawablesToCurrentState(){
		// Original method
		/*
		{
        if (mBGDrawable != null) {
            mBGDrawable.jumpToCurrentState();
        }
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @RemotableViewMethod 
	public void setBackgroundColor(int color){
		// Original method
        if (mBGDrawable instanceof ColorDrawable) {
            ((ColorDrawable) mBGDrawable).setColor(color);
        } else {
            setBackgroundDrawable(new ColorDrawable(color));
        }
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @RemotableViewMethod 
	public void setBackgroundResource(int resid){
		addTaint(resid);
		// Original method
		/*
		{
        if (resid != 0 && resid == mBackgroundResource) {
            return;
        }
        Drawable d= null;
        if (resid != 0) {
            d = mResources.getDrawable(resid);
        }
        setBackgroundDrawable(d);
        mBackgroundResource = resid;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setBackgroundDrawable(Drawable d){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Gets the background drawable
     * @return The drawable used as the background for this view, if any.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.768 -0500", hash_original_method = "80971671F36DCDE8D8060A8575F1E0DF", hash_generated_method = "F2BD5CE67A49674BC981C81EA9A10491")
    
public Drawable getBackground() {
        return mBGDrawable;
    }
    static {
        if ((VIEW_STATE_IDS.length/2) != R.styleable.ViewDrawableStates.length) {
            throw new IllegalStateException(
                    "VIEW_STATE_IDs array length does not match ViewDrawableStates style array");
        }
        int[] orderedIds = new int[VIEW_STATE_IDS.length];
        for (int i = 0; i < R.styleable.ViewDrawableStates.length; i++) {
            int viewState = R.styleable.ViewDrawableStates[i];
            for (int j = 0; j<VIEW_STATE_IDS.length; j += 2) {
                if (VIEW_STATE_IDS[j] == viewState) {
                    orderedIds[i * 2] = viewState;
                    orderedIds[i * 2 + 1] = VIEW_STATE_IDS[j + 1];
                }
            }
        }
        final int NUM_BITS = VIEW_STATE_IDS.length / 2;
        VIEW_STATE_SETS = new int[1 << NUM_BITS][];
        for (int i = 0; i < VIEW_STATE_SETS.length; i++) {
            int numBits = Integer.bitCount(i);
            int[] set = new int[numBits];
            int pos = 0;
            for (int j = 0; j < orderedIds.length; j += 2) {
                if ((i & orderedIds[j+1]) != 0) {
                    set[pos++] = orderedIds[j];
                }
            }
            VIEW_STATE_SETS[i] = set;
        }
        EMPTY_STATE_SET = VIEW_STATE_SETS[0];
        WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_WINDOW_FOCUSED];
        SELECTED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_SELECTED];
        SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED];
        FOCUSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_FOCUSED];
        FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED];
        FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED];
        FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED];
        ENABLED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_ENABLED];
        ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_ENABLED];
        ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_ENABLED];
        ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED| VIEW_STATE_ENABLED];
        PRESSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_PRESSED];
        PRESSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_PRESSED];
        PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED| VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setPadding(int left, int top, int right, int bottom){
		addTaint(left);
		addTaint(right);
		addTaint(bottom);
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    public void setPaddingRelative(int start, int top, int end, int bottom){
		addTaint(start);
		addTaint(end);
		// Original method
		/*
		{
        mUserPaddingRelative = true;
        mUserPaddingStart = start;
        mUserPaddingEnd = end;
        switch(getResolvedLayoutDirection()) {
            case LAYOUT_DIRECTION_RTL:
                setPadding(end, top, start, bottom);
                break;
            case LAYOUT_DIRECTION_LTR:
            default:
                setPadding(start, top, end, bottom);
        }
    }
		*/
		//Return nothing
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getPaddingTop(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingTop;
    }
		*/
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getPaddingBottom(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingBottom;
    }
		*/
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getPaddingLeft(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingLeft;
    }
		*/
	}
    
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getPaddingStart(){
		// Original method
		/*
		{
        return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                mPaddingRight : mPaddingLeft;
    }
		*/
		return 0;
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getPaddingRight(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPaddingRight;
    }
		*/
	}
    
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getPaddingEnd(){
		// Original method
		/*
		{
        return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                mPaddingLeft : mPaddingRight;
    }
		*/
		return 0;
	}
    
	public boolean isPaddingRelative(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mUserPaddingRelative;
    }
		*/
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setSelected(boolean selected){
	    addTaint(selected); 
		// Original method
		/*
		{
        if (((mPrivateFlags & SELECTED) != 0) != selected) {
            mPrivateFlags = (mPrivateFlags & ~SELECTED) | (selected ? SELECTED : 0);
            if (!selected) resetPressedState();
            invalidate(true);
            refreshDrawableState();
            dispatchSetSelected(selected);
        }
    }
		*/
		//Return nothing
	}

    /**
     * Dispatch setSelected to all of this View's children.
     *
     * @see #setSelected(boolean)
     *
     * @param selected The new selected state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.796 -0500", hash_original_method = "64CD219059FB9E526665FE8867E1D4B8", hash_generated_method = "30EACFCB978ECF020A63C5A1D067CAC7")
    
protected void dispatchSetSelected(boolean selected) {
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty public boolean isSelected(){
		// Original method
		/*
		{
        return (mPrivateFlags & SELECTED) != 0;
    }
		*/
		return false;
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setActivated(boolean activated){
	    addTaint(activated);
	}

    /**
     * Dispatch setActivated to all of this View's children.
     *
     * @see #setActivated(boolean)
     *
     * @param activated The new activated state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.803 -0500", hash_original_method = "857B49EDB2F7375261DD6F1ED2F34094", hash_generated_method = "B8BD3E8F9B95E7D35A7D7029E4B00FCF")
    
protected void dispatchSetActivated(boolean activated) {
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty
	
	public boolean isActivated(){
		// Original method
		/*
		{
        return (mPrivateFlags & ACTIVATED) != 0;
    }
		*/
		return getTaintBoolean();
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public ViewTreeObserver getViewTreeObserver(){
		return mFloatingTreeObserver;
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            return mAttachInfo.mTreeObserver;
        }
        if (mFloatingTreeObserver == null) {
            mFloatingTreeObserver = new ViewTreeObserver();
        }
        return mFloatingTreeObserver;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public View getRootView(){
		// Original method
		/*
		{
        if (mAttachInfo != null) {
            final View v = mAttachInfo.mRootView;
            if (v != null) {
                return v;
            }
        }
        View parent = this;
        while (parent.mParent != null && parent.mParent instanceof View) {
            parent = (View) parent.mParent;
        }
        return parent;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void getLocationOnScreen(int[] location){
		// Original method
		/*
		{
        getLocationInWindow(location);
        final AttachInfo info = mAttachInfo;
        if (info != null) {
            location[0] += info.mWindowLeft;
            location[1] += info.mWindowTop;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void getLocationInWindow(int[] location){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    protected View findViewTraversal(int id){
		return this;
		// Original method
		/*
		{
        if (id == mID) {
            return this;
        }
        return null;
    }
		*/
	}
    
    protected View findViewWithTagTraversal(Object tag){
		// Original method
		/*
		{
        if (tag != null && tag.equals(mTag)) {
            return this;
        }
        return null;
    }
		*/
		return null;
	}
    
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip){
		// Original method
		/*
		{
        if (predicate.apply(this)) {
            return this;
        }
        return null;
    }
		*/
		return null;
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final View findViewById(int id){
		return this;
		// Original method
		/*
		{
        if (id < 0) {
            return null;
        }
        return findViewTraversal(id);
    }
		*/
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final View findViewByAccessibilityId(int accessibilityId){
		// Original method
		/*
		{
        if (accessibilityId < 0) {
            return null;
        }
        return findViewByAccessibilityIdTraversal(accessibilityId);
    }
		*/
		return null;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    View findViewByAccessibilityIdTraversal(int accessibilityId){
		// Original method
		/*
		{
        if (getAccessibilityViewId() == accessibilityId) {
            return this;
        }
        return null;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final View findViewWithTag(Object tag){
		// Original method
		/*
		{
        if (tag == null) {
            return null;
        }
        return findViewWithTagTraversal(tag);
    }
		*/
		return null;
	}
    
    public final View findViewByPredicate(Predicate<View> predicate){
		// Original method
		/*
		{
        return findViewByPredicateTraversal(predicate, null);
    }
		*/
		return null;
	}
    
    public final View findViewByPredicateInsideOut(View start, Predicate<View> predicate){
		// Original method
		/*
		{
        View childToSkip = null;
        for (;;) {
            View view = start.findViewByPredicateTraversal(predicate, childToSkip);
            if (view != null || start == this) {
                return view;
            }
            ViewParent parent = start.getParent();
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            childToSkip = start;
            start = (View) parent;
        }
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setId(int id){
		addTaint(id);
		// Original method
		/*
		{
        mID = id;
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setIsRootNamespace(boolean isRoot){
		// Original method
		/*
		{
        if (isRoot) {
            mPrivateFlags |= IS_ROOT_NAMESPACE;
        } else {
            mPrivateFlags &= ~IS_ROOT_NAMESPACE;
        }
    }
		*/
		//Return nothing
	}
    
    public boolean isRootNamespace(){
		// Original method
		/*
		{
        return (mPrivateFlags&IS_ROOT_NAMESPACE) != 0;
    }
		*/
		return false;
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.CapturedViewProperty 
	public int getId(){
		return getTaintInt();
		// Original method
		/*
		{
        return mID;
    }
		*/
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty 
	public Object getTag(){
		return (Object)getTaint();
		// Original method
		/*
		{
        return mTag;
    }
		*/
	}

    /**
     * Sets the tag associated with this view. A tag can be used to mark
     * a view in its hierarchy and does not have to be unique within the
     * hierarchy. Tags can also be used to store data within a view without
     * resorting to another data structure.
     *
     * @param tag an Object to tag the view with
     *
     * @see #getTag()
     * @see #setTag(int, Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.852 -0500", hash_original_method = "8D2B18A079B1EE90519A06D435C647B9", hash_generated_method = "33E1CD81B753027A33A76D43EBE89CCE")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void setTag(final Object tag) {
        mTag = tag;
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Object getTag(int key){
		return mKeyedTags.get(key);
		// Original method
		/*
		{
        if (mKeyedTags != null) return mKeyedTags.get(key);
        return null;
    }
		*/
	}
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
	public void setTag(int key, final Object tag){
		setKeyedTag(key, tag);
		// Original method
		/*
		{
        if ((key >>> 24) < 2) {
            throw new IllegalArgumentException("The key must be an application-specific "
                    + "resource id.");
        }
        setKeyedTag(key, tag);
    }
		*/
		//Return nothing
	}

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setTagInternal(int key, Object tag){
		setKeyedTag(key, tag);
		// Original method
		/*
		{
        if ((key >>> 24) != 0x1) {
            throw new IllegalArgumentException("The key must be a framework-specific "
                    + "resource id.");
        }
        setKeyedTag(key, tag);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void setKeyedTag(int key, Object tag){
		mKeyedTags.put(key, tag);
		// Original method
		/*
		{
        if (mKeyedTags == null) {
            mKeyedTags = new SparseArray<Object>();
        }
        mKeyedTags.put(key, tag);
    }
		*/
		//Return nothing
	}
    
    protected boolean dispatchConsistencyCheck(int consistency){
		// Original method
		/*
		{
        return onConsistencyCheck(consistency);
    }
		*/
		return false;
	}
    
    protected boolean onConsistencyCheck(int consistency){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    public void debug(){
		// Original method
		/*
		{
        debug(0);
    }
		*/
		//Return nothing
	}
    
    protected void debug(int depth){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(category="layout") 
	public int getBaseline(){
		// Original method
		/*
		{
        return -1;
    }
		*/
		return 0;
	}

    /**
     * Call this when something has changed which has invalidated the
     * layout of this view. This will schedule a layout pass of the view
     * tree.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.881 -0500", hash_original_method = "B7CE3104FF9ED0677BFFACD05F948960", hash_generated_method = "345A2F414C44CB96C8C1996F7916E049")
    
public void requestLayout() {
        if (ViewDebug.TRACE_HIERARCHY) {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        }

        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;

        if (mParent != null) {
            if (mLayoutParams != null) {
                mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            }
            if (!mParent.isLayoutRequested()) {
                mParent.requestLayout();
            }
        }
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void forceLayout(){
		// Original method
		/*
		{
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void measure(int widthMeasureSpec, int heightMeasureSpec){
		addTaint(widthMeasureSpec);
		addTaint(heightMeasureSpec);
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		// Original method
		/*
		{
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected final void setMeasuredDimension(int measuredWidth, int measuredHeight){
		addTaint(measuredWidth);
		addTaint(measuredHeight);
		// Original method
		/*
		{
        mMeasuredWidth = measuredWidth;
        mMeasuredHeight = measuredHeight;
        mPrivateFlags |= MEASURED_DIMENSION_SET;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected int getSuggestedMinimumHeight(){
		// Original method
		/*
		{
        int suggestedMinHeight = mMinHeight;
        if (mBGDrawable != null) {
            final int bgMinHeight = mBGDrawable.getMinimumHeight();
            if (suggestedMinHeight < bgMinHeight) {
                suggestedMinHeight = bgMinHeight;
            }
        }
        return suggestedMinHeight;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected int getSuggestedMinimumWidth(){
		// Original method
		/*
		{
        int suggestedMinWidth = mMinWidth;
        if (mBGDrawable != null) {
            final int bgMinWidth = mBGDrawable.getMinimumWidth();
            if (suggestedMinWidth < bgMinWidth) {
                suggestedMinWidth = bgMinWidth;
            }
        }
        return suggestedMinWidth;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setMinimumHeight(int minHeight){
		addTaint(minHeight);
		// Original method
		/*
		{
        mMinHeight = minHeight;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setMinimumWidth(int minWidth){
		addTaint(minWidth);
		// Original method
		/*
		{
        mMinWidth = minWidth;
    }
		*/
		//Return nothing
	}

    /**
     * Get the animation currently associated with this view.
     *
     * @return The animation that is currently playing or
     *         scheduled to play for this view.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.913 -0500", hash_original_method = "CDBB00D26F9C60D5F3E6B97847853936", hash_generated_method = "30138526EE085CE6CE5369F7E6EB3D4B")
    
public Animation getAnimation() {
        return mCurrentAnimation;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void startAnimation(Animation animation){
		// Original method
		/*
		{
        animation.setStartTime(Animation.START_ON_FIRST_FRAME);
        setAnimation(animation);
        invalidateParentCaches();
        invalidate(true);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void clearAnimation(){
		// Original method
		/*
		{
        if (mCurrentAnimation != null) {
            mCurrentAnimation.detach();
        }
        mCurrentAnimation = null;
        invalidateParentIfNeeded();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setAnimation(Animation animation){
		mCurrentAnimation = animation;
		animation.reset();
		// Original method
		/*
		{
        mCurrentAnimation = animation;
        if (animation != null) {
            animation.reset();
        }
    }
		*/
		//Return nothing
	}
    
    protected void onAnimationStart(){
		// Original method
		/*
		{
        mPrivateFlags |= ANIMATION_STARTED;
    }
		*/
		//Return nothing
	}
    
    protected void onAnimationEnd(){
		// Original method
		/*
		{
        mPrivateFlags &= ~ANIMATION_STARTED;
    }
		*/
		//Return nothing
	}

    /**
     * Invoked if there is a Transform that involves alpha. Subclass that can
     * draw themselves with the specified alpha should return true, and then
     * respect that alpha when their onDraw() is called. If this returns false
     * then the view may be redirected to draw into an offscreen buffer to
     * fulfill the request, which will look fine, but may be slower than if the
     * subclass handles it internally. The default implementation returns false.
     *
     * @param alpha The alpha (0..255) to apply to the view's drawing
     * @return true if the view can draw with the specified alpha.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.927 -0500", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "F976C7D5D2AAD617BDE6C87C1BB8E8CF")
    
protected boolean onSetAlpha(int alpha) {
        return false;
    }
    
    public boolean gatherTransparentRegion(Region region){
		// Original method
		/*
		{
        final AttachInfo attachInfo = mAttachInfo;
        if (region != null && attachInfo != null) {
            final int pflags = mPrivateFlags;
            if ((pflags & SKIP_DRAW) == 0) {
                final int[] location = attachInfo.mTransparentLocation;
                getLocationInWindow(location);
                region.op(location[0], location[1], location[0] + mRight - mLeft,
                        location[1] + mBottom - mTop, Region.Op.DIFFERENCE);
            } else if ((pflags & ONLY_DRAWS_BACKGROUND) != 0 && mBGDrawable != null) {
                applyDrawableToTransparentRegion(mBGDrawable, region);
            }
        }
        return true;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void playSoundEffect(int soundConstant){
		// Original method
		/*
		{
        if (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled()) {
            return;
        }
        mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public boolean performHapticFeedback(int feedbackConstant){
		// Original method
		/*
		{
        return performHapticFeedback(feedbackConstant, 0);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public boolean performHapticFeedback(int feedbackConstant, int flags){
		// Original method
		/*
		{
        if (mAttachInfo == null) {
            return false;
        }
        if ((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                && !isHapticFeedbackEnabled()) {
            return false;
        }
        return mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
                (flags & HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING) != 0);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setSystemUiVisibility(int visibility){
		// Original method
		/*
		{
        if (visibility != mSystemUiVisibility) {
            mSystemUiVisibility = visibility;
            if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
                mParent.recomputeViewAttributes(this);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSystemUiVisibility(){
		return getTaintInt();
		// Original method
		/*
		{
        return mSystemUiVisibility;
    }
		*/
	}
    
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l){
		// Original method
		/*
		{
        getListenerInfo().mOnSystemUiVisibilityChangeListener = l;
        if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            mParent.recomputeViewAttributes(this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public void dispatchSystemUiVisibilityChanged(int visibility){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
            li.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(
                    visibility & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void updateLocalSystemUiVisibility(int localValue, int localChanges){
		// Original method
		/*
		{
        int val = (mSystemUiVisibility&~localChanges) | (localValue&localChanges);
        if (val != mSystemUiVisibility) {
            setSystemUiVisibility(val);
        }
    }
		*/
		//Return nothing
	}
    
    public final boolean startDrag(ClipData data, DragShadowBuilder shadowBuilder,
            Object myLocalState, int flags){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    /**
     * Handles drag events sent by the system following a call to
     * {@link android.view.View#startDrag(ClipData,DragShadowBuilder,Object,int) startDrag()}.
     *<p>
     * When the system calls this method, it passes a
     * {@link android.view.DragEvent} object. A call to
     * {@link android.view.DragEvent#getAction()} returns one of the action type constants defined
     * in DragEvent. The method uses these to determine what is happening in the drag and drop
     * operation.
     * @param event The {@link android.view.DragEvent} sent by the system.
     * The {@link android.view.DragEvent#getAction()} method returns an action type constant defined
     * in DragEvent, indicating the type of drag event represented by this object.
     * @return {@code true} if the method was successful, otherwise {@code false}.
     * <p>
     *  The method should return {@code true} in response to an action type of
     *  {@link android.view.DragEvent#ACTION_DRAG_STARTED} to receive drag events for the current
     *  operation.
     * </p>
     * <p>
     *  The method should also return {@code true} in response to an action type of
     *  {@link android.view.DragEvent#ACTION_DROP} if it consumed the drop, or
     *  {@code false} if it didn't.
     * </p>
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.975 -0500", hash_original_method = "7E645D896E88F7A2CE991A302B5729A7", hash_generated_method = "71048F05551B50B992E9638D984DA7A9")
    
public boolean onDragEvent(DragEvent event) {
        return false;
    }
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public boolean dispatchDragEvent(DragEvent event){
		// Original method
		/*
		{
        ListenerInfo li = mListenerInfo;
        if (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnDragListener.onDrag(this, event)) {
            return true;
        }
        return onDragEvent(event);
    }
		*/
		return false;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean canAcceptDrag(){
		// Original method
		/*
		{
        return (mPrivateFlags2 & DRAG_CAN_ACCEPT) != 0;
    }
		*/
		return false;
	}

    /**
     * This needs to be a better API (NOT ON VIEW) before it is exposed.  If
     * it is ever exposed at all.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.981 -0500", hash_original_method = "059265693C3FBF9CA8D6100876A0DA7C", hash_generated_method = "2CDE30E7C65346C681EDEEE52B4927CF")
    
public void onCloseSystemDialogs(String reason) {
    }
    
    public void applyDrawableToTransparentRegion(Drawable dr, Region region){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void checkForLongClick(int delayOffset){
		// Original method
		/*
		{
        if ((mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) {
            mHasPerformedLongPress = false;
            if (mPendingCheckForLongPress == null) {
                mPendingCheckForLongPress = new CheckForLongPress();
            }
            mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForLongPress,
                    ViewConfiguration.getLongPressTimeout() - delayOffset);
        }
    }
		*/
		//Return nothing
	}
    
    @SuppressWarnings({"UnusedParameters"}) 
	protected boolean overScrollBy(int deltaX, int deltaY,
            int scrollX, int scrollY,
            int scrollRangeX, int scrollRangeY,
            int maxOverScrollX, int maxOverScrollY,
            boolean isTouchEvent){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    /**
     * Called by {@link #overScrollBy(int, int, int, int, int, int, int, int, boolean)} to
     * respond to the results of an over-scroll operation.
     *
     * @param scrollX New X scroll value in pixels
     * @param scrollY New Y scroll value in pixels
     * @param clampedX True if scrollX was clamped to an over-scroll boundary
     * @param clampedY True if scrollY was clamped to an over-scroll boundary
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:38.996 -0500", hash_original_method = "4CE95B84751ED417CECEABF7E9F1BBA1", hash_generated_method = "B3CD53E41C55E310A063B6CFBD6E9CDF")
    
protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        // Intentionally empty.
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getOverScrollMode(){
		return getTaintInt();
		// Original method
		/*
		{
        return mOverScrollMode;
    }
		*/
	}
    
    static class MyFloatPropertyView extends FloatProperty<View> {
        
        public MyFloatPropertyView(String str) {
            super(str);
        }
        
        public Float get(View v) {
            return Float.valueOf(getTaintFloat());
        }
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setOverScrollMode(int overScrollMode){
		addTaint(overScrollMode);
		// Original method
		/*
		{
        if (overScrollMode != OVER_SCROLL_ALWAYS &&
                overScrollMode != OVER_SCROLL_IF_CONTENT_SCROLLS &&
                overScrollMode != OVER_SCROLL_NEVER) {
            throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        }
        mOverScrollMode = overScrollMode;
    }
		*/
		//Return nothing
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected float getVerticalScrollFactor(){
		return getTaintFloat();
		// Original method
		/*
		{
        if (mVerticalScrollFactor == 0) {
            TypedValue outValue = new TypedValue();
            if (!mContext.getTheme().resolveAttribute(
                    com.android.internal.R.attr.listPreferredItemHeight, outValue, true)) {
                throw new IllegalStateException(
                        "Expected theme to define listPreferredItemHeight.");
            }
            mVerticalScrollFactor = outValue.getDimension(
                    mContext.getResources().getDisplayMetrics());
        }
        return mVerticalScrollFactor;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected float getHorizontalScrollFactor(){
		// Original method
		/*
		{
        return getVerticalScrollFactor();
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getTextDirection(){
		return getTaintInt();
		// Original method
		/*
		{
        return mTextDirection;
    }
		*/
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setTextDirection(int textDirection){
		// Original method
		/*
		{
        if (textDirection != mTextDirection) {
            mTextDirection = textDirection;
            resetResolvedTextDirection();
            requestLayout();
        }
    }
		*/
		//Return nothing
	}

    /**
     * Return the resolved text direction.
     *
     * @return the resolved text direction. Return one of:
     *
     * {@link #TEXT_DIRECTION_FIRST_STRONG}
     * {@link #TEXT_DIRECTION_ANY_RTL},
     * {@link #TEXT_DIRECTION_LTR},
     * {@link #TEXT_DIRECTION_RTL},
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.015 -0500", hash_original_method = "99501F3EA14EF54863B388ACFA67B227", hash_generated_method = "CECE3F636F4D99DE49E32E3BC0385AF9")
    
public int getResolvedTextDirection() {
        if (mResolvedTextDirection == TEXT_DIRECTION_INHERIT) {
            resolveTextDirection();
        }
        return mResolvedTextDirection;
    }

    /**
     * Resolve the text direction.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:39.017 -0500", hash_original_method = "DF8FC39519D36B1AC7371F6D87C199FC", hash_generated_method = "86EF4CE20FD03BAE1C9794EE2CC49CE1")
    
protected void resolveTextDirection() {
        if (mTextDirection != TEXT_DIRECTION_INHERIT) {
            mResolvedTextDirection = mTextDirection;
            return;
        }
        if (mParent != null && mParent instanceof ViewGroup) {
            mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
            return;
        }
        mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
    }
    
    protected void resetResolvedTextDirection(){
		// Original method
		/*
		{
        mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    }
		*/
		//Return nothing
	}
    
    public void hackTurnOffWindowResizeAnim(boolean off){
		// Original method
		/*
		{
        mAttachInfo.mTurnOffWindowResizeAnim = off;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public ViewPropertyAnimator animate(){
        mAnimator = new ViewPropertyAnimator(this);
        return mAnimator;
		// Original method
		/*
		{
        if (mAnimator == null) {
            mAnimator = new ViewPropertyAnimator(this);
        }
        return mAnimator;
    }
		*/
	}
}

