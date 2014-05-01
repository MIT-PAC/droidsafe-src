package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.util.Log.d;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.R;

public class RelativeLayout extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.748 -0500", hash_original_field = "169005C941FC7F7E100BA41616FA682F", hash_generated_field = "57E1FE47E9272F2D3908282BD0F70602")

    private static final String LOG_TAG = "RelativeLayout";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.750 -0500", hash_original_field = "643C3FD67311BF2F34753A1AC581691D", hash_generated_field = "2C82381CD2A9F5B5C76AFEACEC85DDDB")

    private static final boolean DEBUG_GRAPH = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.752 -0500", hash_original_field = "0AD2CCC562A090EBE1618CB32DADD040", hash_generated_field = "B2899320334F57908731E112E94F1CDE")

    public static final int TRUE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.755 -0500", hash_original_field = "5FD95E0A5EA54AA7A833FA46549BDCB7", hash_generated_field = "096208EA2AF3CC7E7141BFD38797A0EC")

    public static final int LEFT_OF                  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.757 -0500", hash_original_field = "70D7446EF976C1E2214EAD09DBD67F05", hash_generated_field = "3F8E96F44674079400E1FE6BBEE7D7E2")

    public static final int RIGHT_OF                 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.759 -0500", hash_original_field = "84CF839E20CD86CD96C471D2669E403A", hash_generated_field = "B25BAD9E800E104591FBDEB68402C4D7")

    public static final int ABOVE                    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.762 -0500", hash_original_field = "EC5460FB4A5246D8976354CBD4A64B86", hash_generated_field = "C33F54ACAC005E4F7B577DF5ECD8B8CB")

    public static final int BELOW                    = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.765 -0500", hash_original_field = "781E287741295FBD42C6EA4356B5C4FD", hash_generated_field = "0367429D50A8B97E51A0EA79D61E8341")

    public static final int ALIGN_BASELINE           = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.767 -0500", hash_original_field = "012DF7AE2F13258B144250F39DEE5118", hash_generated_field = "B08FA699BB0A7B8EE01E81D8523B06B8")

    public static final int ALIGN_LEFT               = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.769 -0500", hash_original_field = "E2DDEBDFD7D76E12FB000BB852400450", hash_generated_field = "503D8ED8ADEFA09061443AB73E1105EB")

    public static final int ALIGN_TOP                = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.771 -0500", hash_original_field = "3CBA6C1AFDDEFDA7DC1023BE2890817C", hash_generated_field = "066A8ADE746ECE1F1116FA381AA46454")

    public static final int ALIGN_RIGHT              = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.774 -0500", hash_original_field = "E0403605E3D7DE5B8756D125AD768FF5", hash_generated_field = "0F184873DB5DF31E2DCF140BE0923551")

    public static final int ALIGN_BOTTOM             = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.777 -0500", hash_original_field = "CD7EECB38C06DE487410D22DF0F4E47B", hash_generated_field = "07136E510188D5E09CB6F7AA93561D06")

    public static final int ALIGN_PARENT_LEFT        = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.779 -0500", hash_original_field = "F79CD697E1AB4C4A48C2DDFF6C795ADE", hash_generated_field = "0949503221E389CCE8FB0E1467A44822")

    public static final int ALIGN_PARENT_TOP         = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.781 -0500", hash_original_field = "074A37847CBE944E051D882F599B6B08", hash_generated_field = "3EFDDDF20B46B24CC5FB727D20BD8554")

    public static final int ALIGN_PARENT_RIGHT       = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.784 -0500", hash_original_field = "704429770A7E1027B7D983855FF58FBD", hash_generated_field = "82EE6CB558A3BB3B4C93A79C69887380")

    public static final int ALIGN_PARENT_BOTTOM      = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.786 -0500", hash_original_field = "DFB5EA196B6AA64B562A5EC5B723FCAE", hash_generated_field = "D045131D6C0978E01C7E1F593FBD0FC4")

    public static final int CENTER_IN_PARENT         = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.788 -0500", hash_original_field = "6B712EE8C5A8CFB10C1A279E4FE9042F", hash_generated_field = "E7BDEFDBB1D8A752BEF0DA17BCC1DA06")

    public static final int CENTER_HORIZONTAL        = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.791 -0500", hash_original_field = "9D3A8C13ED7036B3B3942CBFA5AB11CB", hash_generated_field = "12CCDDB6CE0278C45C3ED35DE6FCDC8B")

    public static final int CENTER_VERTICAL          = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.794 -0500", hash_original_field = "0488C977BE3DA7023B9960129C34263B", hash_generated_field = "4C06C39E645DF1A64F0D7148873000D8")

    private static final int VERB_COUNT              = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.796 -0500", hash_original_field = "EC6C21865E2D148FB90AA744AB6F80AC", hash_generated_field = "C96F9BEAD28A0E01882C41D253AFA846")

    private View mBaselineView = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.798 -0500", hash_original_field = "45C693CBCAE113606E119E6BE2888D3A", hash_generated_field = "6D2C0346DC0DDE3AEF5B4E55639F7BAB")

    private boolean mHasBaselineAlignedChild;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.800 -0500", hash_original_field = "25D2AE967F212D40A7861414150A2389", hash_generated_field = "0B3CD20786EC1640C99D342CF17DE4BB")

    private int mGravity = Gravity.LEFT | Gravity.TOP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.802 -0500", hash_original_field = "5F531E2EED9BE73D1FE09735D9D75C84", hash_generated_field = "24DC767A3ADC7BC83961E5A62989B517")

    private final Rect mContentBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.804 -0500", hash_original_field = "AEBFB1CC0E9149E5984F190C14B99AED", hash_generated_field = "3B16C2D681BFC370000C0D459ADC9C55")

    private final Rect mSelfBounds = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.807 -0500", hash_original_field = "22C842EBC892CF38904B9B9C7743883B", hash_generated_field = "40144C1646BB169CEE55D007B33717AC")

    private int mIgnoreGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.809 -0500", hash_original_field = "BEBFA666A1757C3B869D6609F51BAB86", hash_generated_field = "681342FA517F01301240A0DCB6966955")

    private SortedSet<View> mTopToBottomLeftToRightSet = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.811 -0500", hash_original_field = "1E02C6BDDCCCC6F8154EE639FC772BCC", hash_generated_field = "0C8E33895AC589A2FF55DFCBCE389221")
    
    private boolean mDirtyHierarchy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.813 -0500", hash_original_field = "1780A37D6E496F9B10B65159037B852D", hash_generated_field = "224DF440DDF6B166B3D2E241F0F3F984")

    private View[] mSortedHorizontalChildren = new View[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.815 -0500", hash_original_field = "346129388D8AE68DC634717A95061E5C", hash_generated_field = "AB00FD5297C1C0ADA708BCFC1E36BC84")

    private View[] mSortedVerticalChildren = new View[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.817 -0500", hash_original_field = "8C488F1B8195116B4C93352D1F93521B", hash_generated_field = "A2A346771E3A79053A739D0A482EAA8C")

    private final DependencyGraph mGraph = new DependencyGraph();

    @DSComment("Layout")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.820 -0500", hash_original_method = "88251BE26FFBF8D7F97872F9366B970C", hash_generated_method = "BA05857430E8CEE496EDF9209AE2C671")
    
public RelativeLayout(Context context) {
        super(context);
    }

    @DSComment("Layout")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.822 -0500", hash_original_method = "9502583C8FA8687465E0A06E15614A2F", hash_generated_method = "47D2CAF223A3954AE429BCD5431860B7")
    
public RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromAttributes(context, attrs);
    }

    @DSComment("Layout")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.825 -0500", hash_original_method = "4BEC7267CBAB87A927F52EE3092CF249", hash_generated_method = "A841B418971C03DC56CB5B1F78E892E2")
    
public RelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFromAttributes(context, attrs);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.827 -0500", hash_original_method = "2508EFC88C6F20ACAB1B8BFE22290A1F", hash_generated_method = "035C1D3E7CE7B3023D1F89667DF7364D")
    
private void initFromAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RelativeLayout);
        mIgnoreGravity = a.getResourceId(R.styleable.RelativeLayout_ignoreGravity, View.NO_ID);
        mGravity = a.getInt(R.styleable.RelativeLayout_gravity, mGravity);
        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.829 -0500", hash_original_method = "9DA99B4E01A506E72BA59AF598A3C38D", hash_generated_method = "FF1288C9953DCFF93F8070857A51FACB")
    
@Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /**
     * Defines which View is ignored when the gravity is applied. This setting has no
     * effect if the gravity is <code>Gravity.LEFT | Gravity.TOP</code>.
     *
     * @param viewId The id of the View to be ignored by gravity, or 0 if no View
     *        should be ignored.
     *
     * @see #setGravity(int)
     *
     * @attr ref android.R.styleable#RelativeLayout_ignoreGravity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.832 -0500", hash_original_method = "4B00B99E3D4A35B389EB4D3ED9BF824A", hash_generated_method = "AAE2AFA3237D050A1016F87EDD108E37")
    
@android.view.RemotableViewMethod
    public void setIgnoreGravity(int viewId) {
        mIgnoreGravity = viewId;
    }

    /**
     * Describes how the child views are positioned. Defaults to
     * <code>Gravity.LEFT | Gravity.TOP</code>.
     *
     * <p>Note that since RelativeLayout considers the positioning of each child
     * relative to one another to be significant, setting gravity will affect
     * the positioning of all children as a single unit within the parent.
     * This happens after children have been relatively positioned.</p>
     *
     * @param gravity See {@link android.view.Gravity}
     *
     * @see #setHorizontalGravity(int)
     * @see #setVerticalGravity(int)
     *
     * @attr ref android.R.styleable#RelativeLayout_gravity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.834 -0500", hash_original_method = "DC8D5E1211DE0926B9DDA2FADCED75EE", hash_generated_method = "ACC460D6D3A88CDE5F61A25B30D37A34")
    
@android.view.RemotableViewMethod
    public void setGravity(int gravity) {
        if (mGravity != gravity) {
            if ((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
                gravity |= Gravity.START;
            }

            if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
                gravity |= Gravity.TOP;
            }

            mGravity = gravity;
            requestLayout();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.837 -0500", hash_original_method = "076C59065FCBD07F7CAA4FFA6D12CC3A", hash_generated_method = "DD9C3C2378492508B428C0D28CCABAA5")
    
@android.view.RemotableViewMethod
    public void setHorizontalGravity(int horizontalGravity) {
        final int gravity = horizontalGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) != gravity) {
            mGravity = (mGravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) | gravity;
            requestLayout();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.840 -0500", hash_original_method = "EE245B70888F9F1582A126D948173E64", hash_generated_method = "0591F7E10EF7E02B9451B299C8FAC684")
    
@android.view.RemotableViewMethod
    public void setVerticalGravity(int verticalGravity) {
        final int gravity = verticalGravity & Gravity.VERTICAL_GRAVITY_MASK;
        if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != gravity) {
            mGravity = (mGravity & ~Gravity.VERTICAL_GRAVITY_MASK) | gravity;
            requestLayout();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.842 -0500", hash_original_method = "73585EFBB2973430E05667E2654BAD3F", hash_generated_method = "1B31E1BC181531E4C927179CADD06337")
    
@Override
    public int getBaseline() {
        return mBaselineView != null ? mBaselineView.getBaseline() : super.getBaseline();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.844 -0500", hash_original_method = "D40C3344998DDA8004351F538E92F8E3", hash_generated_method = "2B720D662B7DB6163ABA6B6C3731A805")
    
@Override
    public void requestLayout() {
        super.requestLayout();
        mDirtyHierarchy = true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.847 -0500", hash_original_method = "701273CD7B3C60F684ABCCF0BE7DD8A5", hash_generated_method = "8DBEAC2230F15061FF523D186D1C89E4")
    
private void sortChildren() {
        int count = getChildCount();
        if (mSortedVerticalChildren.length != count) mSortedVerticalChildren = new View[count];
        if (mSortedHorizontalChildren.length != count) mSortedHorizontalChildren = new View[count];

        final DependencyGraph graph = mGraph;
        graph.clear();

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            graph.add(child);
        }

        if (DEBUG_GRAPH) {
            d(LOG_TAG, "=== Sorted vertical children");
            graph.log(getResources(), ABOVE, BELOW, ALIGN_BASELINE, ALIGN_TOP, ALIGN_BOTTOM);
            d(LOG_TAG, "=== Sorted horizontal children");
            graph.log(getResources(), LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);
        }

        graph.getSortedViews(mSortedVerticalChildren, ABOVE, BELOW, ALIGN_BASELINE,
                ALIGN_TOP, ALIGN_BOTTOM);
        graph.getSortedViews(mSortedHorizontalChildren, LEFT_OF, RIGHT_OF, ALIGN_LEFT, ALIGN_RIGHT);

        if (DEBUG_GRAPH) {
            d(LOG_TAG, "=== Ordered list of vertical children");
            for (View view : mSortedVerticalChildren) {
                DependencyGraph.printViewId(getResources(), view);
            }
            d(LOG_TAG, "=== Ordered list of horizontal children");
            for (View view : mSortedHorizontalChildren) {
                DependencyGraph.printViewId(getResources(), view);
            }
        }        
    }
    
    private class TopToBottomLeftToRightComparator implements Comparator<View> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.545 -0400", hash_original_method = "32220C1DAB888BE59E67ED1F2F5003D8", hash_generated_method = "32220C1DAB888BE59E67ED1F2F5003D8")
        public TopToBottomLeftToRightComparator ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.908 -0500", hash_original_method = "A3AAE4860228E849F39A667518F04B9E", hash_generated_method = "0050142F3FBC23713D5F9DA65F5E8DAE")
        
public int compare(View first, View second) {
            // top - bottom
            int topDifference = first.getTop() - second.getTop();
            if (topDifference != 0) {
                return topDifference;
            }
            // left - right
            int leftDifference = first.getLeft() - second.getLeft();
            if (leftDifference != 0) {
                return leftDifference;
            }
            // break tie by height
            int heightDiference = first.getHeight() - second.getHeight();
            if (heightDiference != 0) {
                return heightDiference;
            }
            // break tie by width
            int widthDiference = first.getWidth() - second.getWidth();
            if (widthDiference != 0) {
                return widthDiference;
            }
            return 0;
        }
        
    }
    
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.913 -0500", hash_original_field = "7CF62E1092EE225F39556F2BE1B1396D", hash_generated_field = "138597A9D627AA60011D0A51DCF0C547")

        @ViewDebug.ExportedProperty(category = "layout", resolveId = true, indexMapping = {
            @ViewDebug.IntToString(from = ABOVE,               to = "above"),
            @ViewDebug.IntToString(from = ALIGN_BASELINE,      to = "alignBaseline"),
            @ViewDebug.IntToString(from = ALIGN_BOTTOM,        to = "alignBottom"),
            @ViewDebug.IntToString(from = ALIGN_LEFT,          to = "alignLeft"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_BOTTOM, to = "alignParentBottom"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_LEFT,   to = "alignParentLeft"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_RIGHT,  to = "alignParentRight"),
            @ViewDebug.IntToString(from = ALIGN_PARENT_TOP,    to = "alignParentTop"),
            @ViewDebug.IntToString(from = ALIGN_RIGHT,         to = "alignRight"),
            @ViewDebug.IntToString(from = ALIGN_TOP,           to = "alignTop"),
            @ViewDebug.IntToString(from = BELOW,               to = "below"),
            @ViewDebug.IntToString(from = CENTER_HORIZONTAL,   to = "centerHorizontal"),
            @ViewDebug.IntToString(from = CENTER_IN_PARENT,    to = "center"),
            @ViewDebug.IntToString(from = CENTER_VERTICAL,     to = "centerVertical"),
            @ViewDebug.IntToString(from = LEFT_OF,             to = "leftOf"),
            @ViewDebug.IntToString(from = RIGHT_OF,            to = "rightOf")
        }, mapping = {
            @ViewDebug.IntToString(from = TRUE, to = "true"),
            @ViewDebug.IntToString(from = 0,    to = "false/NO_ID")
        })
        private int[] mRules = new int[VERB_COUNT];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "B5B776A6642DD69B16A47E6FCCAEEB6E", hash_generated_field = "AB08F003659B306A95990D148DDB5C29")

        private int mLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "D09DA346C6637C81F0228C8D0347388B", hash_generated_field = "B14441554FAC41961538E028958B2C0C")

        private int mTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "720807298C0DE3DCF41AEC725F26A5A1", hash_generated_field = "C26B1BDD0746218442C7F597FAB6F7D0")

        private int mRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.547 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "4AF6ECE77AC654346D9C0CD81051EB99")

        private int mBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.918 -0500", hash_original_field = "12AE64BB2EAB9832CF6B29F292393E4A", hash_generated_field = "666873D7B6DA8C6785E6C7DFC911FFA3")

        @ViewDebug.ExportedProperty(category = "layout")
        public boolean alignWithParent;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.923 -0500", hash_original_method = "A3B36B82744E08B8B1AFF03A4315BD99", hash_generated_method = "D0591FCEF8430F909BBA32E4B7EF78D4")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            TypedArray a = c.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.RelativeLayout_Layout);

            final int[] rules = mRules;

            final int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignWithParentIfMissing:
                        alignWithParent = a.getBoolean(attr, false);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toLeftOf:
                        rules[LEFT_OF] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_toRightOf:
                        rules[RIGHT_OF] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_above:
                        rules[ABOVE] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_below:
                        rules[BELOW] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBaseline:
                        rules[ALIGN_BASELINE] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignLeft:
                        rules[ALIGN_LEFT] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignTop:
                        rules[ALIGN_TOP] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignRight:
                        rules[ALIGN_RIGHT] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignBottom:
                        rules[ALIGN_BOTTOM] = a.getResourceId(attr, 0);
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentLeft:
                        rules[ALIGN_PARENT_LEFT] = a.getBoolean(attr, false) ? TRUE : 0;
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentTop:
                        rules[ALIGN_PARENT_TOP] = a.getBoolean(attr, false) ? TRUE : 0;
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentRight:
                        rules[ALIGN_PARENT_RIGHT] = a.getBoolean(attr, false) ? TRUE : 0;
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_alignParentBottom:
                        rules[ALIGN_PARENT_BOTTOM] = a.getBoolean(attr, false) ? TRUE : 0;
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerInParent:
                        rules[CENTER_IN_PARENT] = a.getBoolean(attr, false) ? TRUE : 0;
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerHorizontal:
                        rules[CENTER_HORIZONTAL] = a.getBoolean(attr, false) ? TRUE : 0;
                        break;
                    case com.android.internal.R.styleable.RelativeLayout_Layout_layout_centerVertical:
                        rules[CENTER_VERTICAL] = a.getBoolean(attr, false) ? TRUE : 0;
                       break;
                }
            }

            a.recycle();
        }

        @DSComment("Layout info")
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.926 -0500", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A7516D57E99F3298A4CB1C063C44A289")
        
public LayoutParams(int w, int h) {
            super(w, h);
        }

        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.928 -0500", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "35FAB65EFD30EE5BC910187CB4DA6F67")
        
public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        /**
         * {@inheritDoc}
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.931 -0500", hash_original_method = "600A366FF17B7D40DFA738E77A628E8F", hash_generated_method = "DB62CC5C6AE5A2357A6BB246E8789BF6")
        
public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.933 -0500", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "3703F05F5DB5EE24B2B7671244D04F5E")
        
@Override
        public String debug(String output) {
            return output + "ViewGroup.LayoutParams={ width=" + sizeToString(width) +
                    ", height=" + sizeToString(height) + " }";
        }

        /**
         * Adds a layout rule to be interpreted by the RelativeLayout. This
         * method should only be used for constraints that don't refer to another sibling
         * (e.g., CENTER_IN_PARENT) or take a boolean value ({@link RelativeLayout#TRUE}
         * for true or - for false). To specify a verb that takes a subject, use
         * {@link #addRule(int, int)} instead.
         *
         * @param verb One of the verbs defined by
         *        {@link android.widget.RelativeLayout RelativeLayout}, such as
         *        ALIGN_WITH_PARENT_LEFT.
         * @see #addRule(int, int)
         */
        @DSComment("Layout info")
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.935 -0500", hash_original_method = "F14B7CDC14D112CF9F86D0C64F4D29ED", hash_generated_method = "F888C197D33A9DD27F819D40D54B028F")
        
public void addRule(int verb) {
            mRules[verb] = TRUE;
        }

        /**
         * Adds a layout rule to be interpreted by the RelativeLayout. Use this for
         * verbs that take a target, such as a sibling (ALIGN_RIGHT) or a boolean
         * value (VISIBLE).
         *
         * @param verb One of the verbs defined by
         *        {@link android.widget.RelativeLayout RelativeLayout}, such as
         *         ALIGN_WITH_PARENT_LEFT.
         * @param anchor The id of another view to use as an anchor,
         *        or a boolean value(represented as {@link RelativeLayout#TRUE})
         *        for true or 0 for false).  For verbs that don't refer to another sibling
         *        (for example, ALIGN_WITH_PARENT_BOTTOM) just use -1.
         * @see #addRule(int)
         */
        @DSComment("Layout info")
        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.937 -0500", hash_original_method = "E6336A158C939972C1CFCFE234B123CF", hash_generated_method = "77CD180C6E32DEBAEFF64B715469A756")
        
public void addRule(int verb, int anchor) {
            mRules[verb] = anchor;
        }

        /**
         * Retrieves a complete list of all supported rules, where the index is the rule
         * verb, and the element value is the value specified, or "false" if it was never
         * set.
         *
         * @return the supported rules
         * @see #addRule(int, int)
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.939 -0500", hash_original_method = "42AF2398E9BA5CDF378E196E0674D4AF", hash_generated_method = "070C893267A247F6E4018633C24E9BB0")
        
public int[] getRules() {
            return mRules;
        }
        
    }
    
    private static class DependencyGraph {

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.967 -0500", hash_original_method = "FAE4DC70618F6C3634F51BB32C060397", hash_generated_method = "4F30F97F72F8C27BB39E8A6F6AE387E1")
        
static void printViewId(Resources resources, View view) {
            if (view.getId() != View.NO_ID) {
                d(LOG_TAG, resources.getResourceEntryName(view.getId()));
            } else {
                d(LOG_TAG, "NO_ID");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.969 -0500", hash_original_method = "9BBD1012C278C7D59EF7B9276E2C427A", hash_generated_method = "42599B0D4B2DEDA11894706758A47862")
        
private static void appendViewId(Resources resources, Node node, StringBuilder buffer) {
            if (node.view.getId() != View.NO_ID) {
                buffer.append(resources.getResourceEntryName(node.view.getId()));
            } else {
                buffer.append("NO_ID");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.972 -0500", hash_original_method = "EE33BB5914A230FEE21DAD74E82F4181", hash_generated_method = "8DA7C7D141128F7FFB5BB525806B2FEA")
        
private static void printNode(Resources resources, Node node) {
            if (node.dependents.size() == 0) {
                printViewId(resources, node.view);
            } else {
                for (Node dependent : node.dependents) {
                    StringBuilder buffer = new StringBuilder();
                    appendViewId(resources, node, buffer);
                    printdependents(resources, dependent, buffer);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.975 -0500", hash_original_method = "D89FF62CD57013CC8FF22E8F5ABB7F55", hash_generated_method = "B253F7E66455D31732BCF41C5ED8A2FF")
        
private static void printdependents(Resources resources, Node node, StringBuilder buffer) {
            buffer.append(" -> ");
            appendViewId(resources, node, buffer);

            if (node.dependents.size() == 0) {
                d(LOG_TAG, buffer.toString());
            } else {
                for (Node dependent : node.dependents) {
                    StringBuilder subBuffer = new StringBuilder(buffer);
                    printdependents(resources, dependent, subBuffer);
                }
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.947 -0500", hash_original_field = "EEBCED0903B78B03542BECF17A6D32DC", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

        private ArrayList<Node> mNodes = new ArrayList<Node>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.949 -0500", hash_original_field = "7944E2BBA8066F3F708A1B5CF8FAF331", hash_generated_field = "060FE5603F47B674AFC0F0792F7CB200")

        private SparseArray<Node> mKeyNodes = new SparseArray<Node>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.952 -0500", hash_original_field = "51F5C2B9DD0E6B38CF17C5A9DA650B55", hash_generated_field = "249978BD32E42A0796E8254A85A11B49")

        private LinkedList<Node> mRoots = new LinkedList<Node>();
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.554 -0400", hash_original_method = "970FB9BC48F419CD4D1512AB366BD03A", hash_generated_method = "970FB9BC48F419CD4D1512AB366BD03A")
        public DependencyGraph ()
        {
            //Synthesized constructor
        }

        /**
         * Clears the graph.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.954 -0500", hash_original_method = "686A3AF8289E33425B30BEC25704B03B", hash_generated_method = "686A3AF8289E33425B30BEC25704B03B")
        
void clear() {
            final ArrayList<Node> nodes = mNodes;
            final int count = nodes.size();

            for (int i = 0; i < count; i++) {
                nodes.get(i).release();
            }
            nodes.clear();

            mKeyNodes.clear();
            mRoots.clear();
        }

        /**
         * Adds a view to the graph.
         *
         * @param view The view to be added as a node to the graph.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.956 -0500", hash_original_method = "2AE2D90F3BED583D61A7D72DDE9D78E7", hash_generated_method = "2AE2D90F3BED583D61A7D72DDE9D78E7")
        
void add(View view) {
            final int id = view.getId();
            final Node node = Node.acquire(view);

            if (id != View.NO_ID) {
                mKeyNodes.put(id, node);
            }

            mNodes.add(node);
        }

        /**
         * Builds a sorted list of views. The sorting order depends on the dependencies
         * between the view. For instance, if view C needs view A to be processed first
         * and view A needs view B to be processed first, the dependency graph
         * is: B -> A -> C. The sorted array will contain views B, A and C in this order.
         *
         * @param sorted The sorted list of views. The length of this array must
         *        be equal to getChildCount().
         * @param rules The list of rules to take into account.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.959 -0500", hash_original_method = "A9C10EB6FA89DCA6CFC24E3AC1BF04E7", hash_generated_method = "A9C10EB6FA89DCA6CFC24E3AC1BF04E7")
        
void getSortedViews(View[] sorted, int... rules) {
            final LinkedList<Node> roots = findRoots(rules);
            int index = 0;

            while (roots.size() > 0) {
                final Node node = roots.removeFirst();
                final View view = node.view;
                final int key = view.getId();

                sorted[index++] = view;

                final HashSet<Node> dependents = node.dependents;
                for (Node dependent : dependents) {
                    final SparseArray<Node> dependencies = dependent.dependencies;

                    dependencies.remove(key);
                    if (dependencies.size() == 0) {
                        roots.add(dependent);
                    }
                }
            }

            if (index < sorted.length) {
                throw new IllegalStateException("Circular dependencies cannot exist"
                        + " in RelativeLayout");
            }
        }

        /**
         * Finds the roots of the graph. A root is a node with no dependency and
         * with [0..n] dependents.
         *
         * @param rulesFilter The list of rules to consider when building the
         *        dependencies
         *
         * @return A list of node, each being a root of the graph
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.962 -0500", hash_original_method = "3833904997A1288F1E7950B84718C1E5", hash_generated_method = "3C85F6F19C37221BA26E3341906EA33F")
        
private LinkedList<Node> findRoots(int[] rulesFilter) {
            final SparseArray<Node> keyNodes = mKeyNodes;
            final ArrayList<Node> nodes = mNodes;
            final int count = nodes.size();

            // Find roots can be invoked several times, so make sure to clear
            // all dependents and dependencies before running the algorithm
            for (int i = 0; i < count; i++) {
                final Node node = nodes.get(i);
                node.dependents.clear();
                node.dependencies.clear();
            }

            // Builds up the dependents and dependencies for each node of the graph
            for (int i = 0; i < count; i++) {
                final Node node = nodes.get(i);

                final LayoutParams layoutParams = (LayoutParams) node.view.getLayoutParams();
                final int[] rules = layoutParams.mRules;
                final int rulesCount = rulesFilter.length;

                // Look only the the rules passed in parameter, this way we build only the
                // dependencies for a specific set of rules
                for (int j = 0; j < rulesCount; j++) {
                    final int rule = rules[rulesFilter[j]];
                    if (rule > 0) {
                        // The node this node depends on
                        final Node dependency = keyNodes.get(rule);
                        // Skip unknowns and self dependencies
                        if (dependency == null || dependency == node) {
                            continue;
                        }
                        // Add the current node as a dependent
                        dependency.dependents.add(node);
                        // Add a dependency to the current node
                        node.dependencies.put(rule, dependency);
                    }
                }
            }

            final LinkedList<Node> roots = mRoots;
            roots.clear();

            // Finds all the roots in the graph: all nodes with no dependencies
            for (int i = 0; i < count; i++) {
                final Node node = nodes.get(i);
                if (node.dependencies.size() == 0) roots.add(node);
            }

            return roots;
        }

        /**
         * Prints the dependency graph for the specified rules.
         *
         * @param resources The context's resources to print the ids.
         * @param rules The list of rules to take into account.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.964 -0500", hash_original_method = "6C6DA74626C9CD8B150D67A2E9AEA5BB", hash_generated_method = "6C6DA74626C9CD8B150D67A2E9AEA5BB")
        
void log(Resources resources, int... rules) {
            final LinkedList<Node> roots = findRoots(rules);
            for (Node node : roots) {
                printNode(resources, node);
            }
        }
        
        static class Node implements Poolable<Node> {

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.014 -0500", hash_original_method = "5BEA2EBE8A9726A61D7727A98B817545", hash_generated_method = "FE4170A50397D1C582004617E5635711")
            
static Node acquire(View view) {
                final Node node = sPool.acquire();
                node.view = view;

                return node;
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.985 -0500", hash_original_field = "4ECB48BEA7396C11BE182F6F36669B1F", hash_generated_field = "6FB52636485DA57366423F0D25A74C1D")

            // The pool is static, so all nodes instances are shared across
            // activities, that's why we give it a rather high limit
            private static final int POOL_LIMIT = 100;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.560 -0400", hash_original_field = "698BA341680326808CDA69878C18B225", hash_generated_field = "0C54963AD1342FCB8B8CE9807462CEFA")

            private static final Pool<Node> sPool = Pools.synchronizedPool(
                    Pools.finitePool(new PoolableManager<Node>() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.988 -0500", hash_original_method = "CFC301DC547DCB51E71118D3B9DE66B5", hash_generated_method = "CCB5CCF51D5F75F1F21B03543304635A")
                
public Node newInstance() {
                            return new Node();
                        }

                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.992 -0500", hash_original_method = "D1D5932E05B7F3CB123A8C60A984D3D0", hash_generated_method = "6605188C75CB989C66BE0D8DCBC2AC5B")
                
public void onAcquired(Node element) {
                        }

                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.995 -0500", hash_original_method = "80A28A87F7D5CAD8A3CF8F1873AA6233", hash_generated_method = "A7D7CD798D3DFDCE92306E20BBEF5413")
                
public void onReleased(Node element) {
                        }
                    }, POOL_LIMIT)
            );
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.978 -0500", hash_original_field = "203A52904F64FA8CF6CE15F1E8FE3025", hash_generated_field = "203A52904F64FA8CF6CE15F1E8FE3025")

            View view;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.980 -0500", hash_original_field = "15404FAB3E19CCE5CED42FA586FF679D", hash_generated_field = "A98125254E0172625F934FA16377E7CD")

            final HashSet<Node> dependents = new HashSet<Node>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.982 -0500", hash_original_field = "51D91DD50794A2AD7CC8B731763D84F6", hash_generated_field = "316BDC31957F2C9443C511FFBE84DF28")

            final SparseArray<Node> dependencies = new SparseArray<Node>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.000 -0500", hash_original_field = "8B01B5FFB32F0F6A4DE0D73A6D01885C", hash_generated_field = "0A1E5AFC0BA7AE75B487CB8ED7E2A9F4")

            private Node mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.002 -0500", hash_original_field = "016073DCFA93DD0305C42C8759ED2078", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            
            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:03.559 -0400", hash_original_method = "4AE6680246A461A411C2DCFC3E5C235E", hash_generated_method = "4AE6680246A461A411C2DCFC3E5C235E")
            public Node ()
            {
                //Synthesized constructor
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.004 -0500", hash_original_method = "A08BF9EBBE4B2747346D150314791002", hash_generated_method = "099EC2311D7A372794CCC40C4E16622B")
            
public void setNextPoolable(Node element) {
                mNext = element;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.007 -0500", hash_original_method = "3B74D9DA1E659E0940912A17ED2BA31C", hash_generated_method = "A9DEB90049533275703549BDFF83B197")
            
public Node getNextPoolable() {
                return mNext;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.009 -0500", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "B6A97050680DD62F0E280740D1E9FA7B")
            
public boolean isPooled() {
                return mIsPooled;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.011 -0500", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "B03D6BD405969AD6559FEB8A8380BDD8")
            
public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
            }

            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:47.016 -0500", hash_original_method = "4A4B6653C3D2EF8B0AE5BB1353D36229", hash_generated_method = "4A4B6653C3D2EF8B0AE5BB1353D36229")
            
void release() {
                view = null;
                dependents.clear();
                dependencies.clear();

                sPool.release(this);
            }
            // orphaned legacy method
            public void onReleased(Node element) {
                        }
            
            // orphaned legacy method
            public void onAcquired(Node element) {
                        }
            
            // orphaned legacy method
            public Node newInstance() {
                            return new Node();
                        }
            
        }
        
    }

    // TODO: we need to find another way to implement RelativeLayout
    // This implementation cannot handle every case
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.854 -0500", hash_original_method = "E2AF18A4E301BF9A8D0B175790671ACC", hash_generated_method = "182B860CF816F14578C0BA51E4345437")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mDirtyHierarchy) {
            mDirtyHierarchy = false;
            sortChildren();
        }

        int myWidth = -1;
        int myHeight = -1;

        int width = 0;
        int height = 0;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        // Record our dimensions if they are known;
        if (widthMode != MeasureSpec.UNSPECIFIED) {
            myWidth = widthSize;
        }

        if (heightMode != MeasureSpec.UNSPECIFIED) {
            myHeight = heightSize;
        }

        if (widthMode == MeasureSpec.EXACTLY) {
            width = myWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = myHeight;
        }

        mHasBaselineAlignedChild = false;

        View ignore = null;
        int gravity = mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        final boolean horizontalGravity = gravity != Gravity.LEFT && gravity != 0;
        gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        final boolean verticalGravity = gravity != Gravity.TOP && gravity != 0;

        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;

        boolean offsetHorizontalAxis = false;
        boolean offsetVerticalAxis = false;

        if ((horizontalGravity || verticalGravity) && mIgnoreGravity != View.NO_ID) {
            ignore = findViewById(mIgnoreGravity);
        }

        final boolean isWrapContentWidth = widthMode != MeasureSpec.EXACTLY;
        final boolean isWrapContentHeight = heightMode != MeasureSpec.EXACTLY;

        View[] views = mSortedHorizontalChildren;
        int count = views.length;
        for (int i = 0; i < count; i++) {
            View child = views[i];
            if (child.getVisibility() != GONE) {
                LayoutParams params = (LayoutParams) child.getLayoutParams();

                applyHorizontalSizeRules(params, myWidth);
                measureChildHorizontal(child, params, myWidth, myHeight);
                if (positionChildHorizontal(child, params, myWidth, isWrapContentWidth)) {
                    offsetHorizontalAxis = true;
                }
            }
        }

        views = mSortedVerticalChildren;
        count = views.length;

        for (int i = 0; i < count; i++) {
            View child = views[i];
            if (child.getVisibility() != GONE) {
                LayoutParams params = (LayoutParams) child.getLayoutParams();
                
                applyVerticalSizeRules(params, myHeight);
                measureChild(child, params, myWidth, myHeight);
                if (positionChildVertical(child, params, myHeight, isWrapContentHeight)) {
                    offsetVerticalAxis = true;
                }

                if (isWrapContentWidth) {
                    width = Math.max(width, params.mRight);
                }

                if (isWrapContentHeight) {
                    height = Math.max(height, params.mBottom);
                }

                if (child != ignore || verticalGravity) {
                    left = Math.min(left, params.mLeft - params.leftMargin);
                    top = Math.min(top, params.mTop - params.topMargin);
                }

                if (child != ignore || horizontalGravity) {
                    right = Math.max(right, params.mRight + params.rightMargin);
                    bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                }
            }
        }

        if (mHasBaselineAlignedChild) {
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                if (child.getVisibility() != GONE) {
                    LayoutParams params = (LayoutParams) child.getLayoutParams();
                    alignBaseline(child, params);

                    if (child != ignore || verticalGravity) {
                        left = Math.min(left, params.mLeft - params.leftMargin);
                        top = Math.min(top, params.mTop - params.topMargin);
                    }

                    if (child != ignore || horizontalGravity) {
                        right = Math.max(right, params.mRight + params.rightMargin);
                        bottom = Math.max(bottom, params.mBottom + params.bottomMargin);
                    }
                }
            }
        }

        if (isWrapContentWidth) {
            // Width already has left padding in it since it was calculated by looking at
            // the right of each child view
            width += mPaddingRight;

            if (mLayoutParams.width >= 0) {
                width = Math.max(width, mLayoutParams.width);
            }

            width = Math.max(width, getSuggestedMinimumWidth());
            width = resolveSize(width, widthMeasureSpec);

            if (offsetHorizontalAxis) {
                for (int i = 0; i < count; i++) {
                    View child = getChildAt(i);
                    if (child.getVisibility() != GONE) {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        final int[] rules = params.getRules();
                        if (rules[CENTER_IN_PARENT] != 0 || rules[CENTER_HORIZONTAL] != 0) {
                            centerHorizontal(child, params, width);
                        } else if (rules[ALIGN_PARENT_RIGHT] != 0) {
                            final int childWidth = child.getMeasuredWidth();
                            params.mLeft = width - mPaddingRight - childWidth;
                            params.mRight = params.mLeft + childWidth;
                        }
                    }
                }
            }
        }

        if (isWrapContentHeight) {
            // Height already has top padding in it since it was calculated by looking at
            // the bottom of each child view
            height += mPaddingBottom;

            if (mLayoutParams.height >= 0) {
                height = Math.max(height, mLayoutParams.height);
            }

            height = Math.max(height, getSuggestedMinimumHeight());
            height = resolveSize(height, heightMeasureSpec);

            if (offsetVerticalAxis) {
                for (int i = 0; i < count; i++) {
                    View child = getChildAt(i);
                    if (child.getVisibility() != GONE) {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        final int[] rules = params.getRules();
                        if (rules[CENTER_IN_PARENT] != 0 || rules[CENTER_VERTICAL] != 0) {
                            centerVertical(child, params, height);
                        } else if (rules[ALIGN_PARENT_BOTTOM] != 0) {
                            final int childHeight = child.getMeasuredHeight();
                            params.mTop = height - mPaddingBottom - childHeight;
                            params.mBottom = params.mTop + childHeight;
                        }
                    }
                }
            }
        }

        if (horizontalGravity || verticalGravity) {
            final Rect selfBounds = mSelfBounds;
            selfBounds.set(mPaddingLeft, mPaddingTop, width - mPaddingRight,
                    height - mPaddingBottom);

            final Rect contentBounds = mContentBounds;
            final int layoutDirection = getResolvedLayoutDirection();
            Gravity.apply(mGravity, right - left, bottom - top, selfBounds, contentBounds,
                    layoutDirection);

            final int horizontalOffset = contentBounds.left - left;
            final int verticalOffset = contentBounds.top - top;
            if (horizontalOffset != 0 || verticalOffset != 0) {
                for (int i = 0; i < count; i++) {
                    View child = getChildAt(i);
                    if (child.getVisibility() != GONE && child != ignore) {
                        LayoutParams params = (LayoutParams) child.getLayoutParams();
                        if (horizontalGravity) {
                            params.mLeft += horizontalOffset;
                            params.mRight += horizontalOffset;
                        }
                        if (verticalGravity) {
                            params.mTop += verticalOffset;
                            params.mBottom += verticalOffset;
                        }
                    }
                }
            }
        }

        setMeasuredDimension(width, height);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.857 -0500", hash_original_method = "572E26DE16208C5960AF0F468C9CEB6F", hash_generated_method = "150B0976AFEBCE23A3F9621F683A208B")
    
private void alignBaseline(View child, LayoutParams params) {
        int[] rules = params.getRules();
        int anchorBaseline = getRelatedViewBaseline(rules, ALIGN_BASELINE);

        if (anchorBaseline != -1) {
            LayoutParams anchorParams = getRelatedViewParams(rules, ALIGN_BASELINE);
            if (anchorParams != null) {
                int offset = anchorParams.mTop + anchorBaseline;
                int baseline = child.getBaseline();
                if (baseline != -1) {
                    offset -= baseline;
                }
                int height = params.mBottom - params.mTop;
                params.mTop = offset;
                params.mBottom = params.mTop + height;
            }
        }

        if (mBaselineView == null) {
            mBaselineView = child;
        } else {
            LayoutParams lp = (LayoutParams) mBaselineView.getLayoutParams();
            if (params.mTop < lp.mTop || (params.mTop == lp.mTop && params.mLeft < lp.mLeft)) {
                mBaselineView = child;
            }
        }
    }

    /**
     * Measure a child. The child should have left, top, right and bottom information
     * stored in its LayoutParams. If any of these values is -1 it means that the view
     * can extend up to the corresponding edge.
     *
     * @param child Child to measure
     * @param params LayoutParams associated with child
     * @param myWidth Width of the the RelativeLayout
     * @param myHeight Height of the RelativeLayout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.859 -0500", hash_original_method = "6FAB1FA940C67F7A3A04C20DF403CDD7", hash_generated_method = "3C00073F57D54F6B181CA8CC2696B60B")
    
private void measureChild(View child, LayoutParams params, int myWidth, int myHeight) {
        int childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                params.mRight, params.width,
                params.leftMargin, params.rightMargin,
                mPaddingLeft, mPaddingRight,
                myWidth);
        int childHeightMeasureSpec = getChildMeasureSpec(params.mTop,
                params.mBottom, params.height,
                params.topMargin, params.bottomMargin,
                mPaddingTop, mPaddingBottom,
                myHeight);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.862 -0500", hash_original_method = "C649DEFF309C12811323B81F575C7972", hash_generated_method = "E97E6BC329F3080441FC412C4198730C")
    
private void measureChildHorizontal(View child, LayoutParams params, int myWidth, int myHeight) {
        int childWidthMeasureSpec = getChildMeasureSpec(params.mLeft,
                params.mRight, params.width,
                params.leftMargin, params.rightMargin,
                mPaddingLeft, mPaddingRight,
                myWidth);
        int childHeightMeasureSpec;
        if (params.width == LayoutParams.MATCH_PARENT) {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(myHeight, MeasureSpec.AT_MOST);
        }
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    /**
     * Get a measure spec that accounts for all of the constraints on this view.
     * This includes size contstraints imposed by the RelativeLayout as well as
     * the View's desired dimension.
     *
     * @param childStart The left or top field of the child's layout params
     * @param childEnd The right or bottom field of the child's layout params
     * @param childSize The child's desired size (the width or height field of
     *        the child's layout params)
     * @param startMargin The left or top margin
     * @param endMargin The right or bottom margin
     * @param startPadding mPaddingLeft or mPaddingTop
     * @param endPadding mPaddingRight or mPaddingBottom
     * @param mySize The width or height of this view (the RelativeLayout)
     * @return MeasureSpec for the child
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.865 -0500", hash_original_method = "78354A3A0D2C9A2AC648B99E7333EDDC", hash_generated_method = "16282200745A58B93E2CA5E9F000A4C6")
    
private int getChildMeasureSpec(int childStart, int childEnd,
            int childSize, int startMargin, int endMargin, int startPadding,
            int endPadding, int mySize) {
        int childSpecMode = 0;
        int childSpecSize = 0;

        // Figure out start and end bounds.
        int tempStart = childStart;
        int tempEnd = childEnd;

        // If the view did not express a layout constraint for an edge, use
        // view's margins and our padding
        if (tempStart < 0) {
            tempStart = startPadding + startMargin;
        }
        if (tempEnd < 0) {
            tempEnd = mySize - endPadding - endMargin;
        }

        // Figure out maximum size available to this view
        int maxAvailable = tempEnd - tempStart;

        if (childStart >= 0 && childEnd >= 0) {
            // Constraints fixed both edges, so child must be an exact size
            childSpecMode = MeasureSpec.EXACTLY;
            childSpecSize = maxAvailable;
        } else {
            if (childSize >= 0) {
                // Child wanted an exact size. Give as much as possible
                childSpecMode = MeasureSpec.EXACTLY;

                if (maxAvailable >= 0) {
                    // We have a maxmum size in this dimension.
                    childSpecSize = Math.min(maxAvailable, childSize);
                } else {
                    // We can grow in this dimension.
                    childSpecSize = childSize;
                }
            } else if (childSize == LayoutParams.MATCH_PARENT) {
                // Child wanted to be as big as possible. Give all availble
                // space
                childSpecMode = MeasureSpec.EXACTLY;
                childSpecSize = maxAvailable;
            } else if (childSize == LayoutParams.WRAP_CONTENT) {
                // Child wants to wrap content. Use AT_MOST
                // to communicate available space if we know
                // our max size
                if (maxAvailable >= 0) {
                    // We have a maxmum size in this dimension.
                    childSpecMode = MeasureSpec.AT_MOST;
                    childSpecSize = maxAvailable;
                } else {
                    // We can grow in this dimension. Child can be as big as it
                    // wants
                    childSpecMode = MeasureSpec.UNSPECIFIED;
                    childSpecSize = 0;
                }
            }
        }

        return MeasureSpec.makeMeasureSpec(childSpecSize, childSpecMode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.868 -0500", hash_original_method = "B9478380B54B111B46A13309CA4FBB39", hash_generated_method = "D416526859F67E914711B10B6344011D")
    
private boolean positionChildHorizontal(View child, LayoutParams params, int myWidth,
            boolean wrapContent) {

        int[] rules = params.getRules();

        if (params.mLeft < 0 && params.mRight >= 0) {
            // Right is fixed, but left varies
            params.mLeft = params.mRight - child.getMeasuredWidth();
        } else if (params.mLeft >= 0 && params.mRight < 0) {
            // Left is fixed, but right varies
            params.mRight = params.mLeft + child.getMeasuredWidth();
        } else if (params.mLeft < 0 && params.mRight < 0) {
            // Both left and right vary
            if (rules[CENTER_IN_PARENT] != 0 || rules[CENTER_HORIZONTAL] != 0) {
                if (!wrapContent) {
                    centerHorizontal(child, params, myWidth);
                } else {
                    params.mLeft = mPaddingLeft + params.leftMargin;
                    params.mRight = params.mLeft + child.getMeasuredWidth();
                }
                return true;
            } else {
                params.mLeft = mPaddingLeft + params.leftMargin;
                params.mRight = params.mLeft + child.getMeasuredWidth();
            }
        }
        return rules[ALIGN_PARENT_RIGHT] != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.870 -0500", hash_original_method = "09EB493CF05E8E659EC89F37304CD399", hash_generated_method = "C0912D5A51A7AAEFB4D466AC9736EAB6")
    
private boolean positionChildVertical(View child, LayoutParams params, int myHeight,
            boolean wrapContent) {

        int[] rules = params.getRules();

        if (params.mTop < 0 && params.mBottom >= 0) {
            // Bottom is fixed, but top varies
            params.mTop = params.mBottom - child.getMeasuredHeight();
        } else if (params.mTop >= 0 && params.mBottom < 0) {
            // Top is fixed, but bottom varies
            params.mBottom = params.mTop + child.getMeasuredHeight();
        } else if (params.mTop < 0 && params.mBottom < 0) {
            // Both top and bottom vary
            if (rules[CENTER_IN_PARENT] != 0 || rules[CENTER_VERTICAL] != 0) {
                if (!wrapContent) {
                    centerVertical(child, params, myHeight);
                } else {
                    params.mTop = mPaddingTop + params.topMargin;
                    params.mBottom = params.mTop + child.getMeasuredHeight();
                }
                return true;
            } else {
                params.mTop = mPaddingTop + params.topMargin;
                params.mBottom = params.mTop + child.getMeasuredHeight();
            }
        }
        return rules[ALIGN_PARENT_BOTTOM] != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.874 -0500", hash_original_method = "C61E9BCFF76D7B76D77F18D001923EFF", hash_generated_method = "32AA0EFA954962EE942A93E7F0DC8E2B")
    
private void applyHorizontalSizeRules(LayoutParams childParams, int myWidth) {
        int[] rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;

        // -1 indicated a "soft requirement" in that direction. For example:
        // left=10, right=-1 means the view must start at 10, but can go as far as it wants to the right
        // left =-1, right=10 means the view must end at 10, but can go as far as it wants to the left
        // left=10, right=20 means the left and right ends are both fixed
        childParams.mLeft = -1;
        childParams.mRight = -1;

        anchorParams = getRelatedViewParams(rules, LEFT_OF);
        if (anchorParams != null) {
            childParams.mRight = anchorParams.mLeft - (anchorParams.leftMargin +
                    childParams.rightMargin);
        } else if (childParams.alignWithParent && rules[LEFT_OF] != 0) {
            if (myWidth >= 0) {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } else {
                // FIXME uh oh...
            }
        }

        anchorParams = getRelatedViewParams(rules, RIGHT_OF);
        if (anchorParams != null) {
            childParams.mLeft = anchorParams.mRight + (anchorParams.rightMargin +
                    childParams.leftMargin);
        } else if (childParams.alignWithParent && rules[RIGHT_OF] != 0) {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        }

        anchorParams = getRelatedViewParams(rules, ALIGN_LEFT);
        if (anchorParams != null) {
            childParams.mLeft = anchorParams.mLeft + childParams.leftMargin;
        } else if (childParams.alignWithParent && rules[ALIGN_LEFT] != 0) {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        }

        anchorParams = getRelatedViewParams(rules, ALIGN_RIGHT);
        if (anchorParams != null) {
            childParams.mRight = anchorParams.mRight - childParams.rightMargin;
        } else if (childParams.alignWithParent && rules[ALIGN_RIGHT] != 0) {
            if (myWidth >= 0) {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } else {
                // FIXME uh oh...
            }
        }

        if (0 != rules[ALIGN_PARENT_LEFT]) {
            childParams.mLeft = mPaddingLeft + childParams.leftMargin;
        }

        if (0 != rules[ALIGN_PARENT_RIGHT]) {
            if (myWidth >= 0) {
                childParams.mRight = myWidth - mPaddingRight - childParams.rightMargin;
            } else {
                // FIXME uh oh...
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.877 -0500", hash_original_method = "B3DE38D6CE01D7E90C154524E3D3CC84", hash_generated_method = "B5FECB6636B7008DC2ACD689D4845B51")
    
private void applyVerticalSizeRules(LayoutParams childParams, int myHeight) {
        int[] rules = childParams.getRules();
        RelativeLayout.LayoutParams anchorParams;

        childParams.mTop = -1;
        childParams.mBottom = -1;

        anchorParams = getRelatedViewParams(rules, ABOVE);
        if (anchorParams != null) {
            childParams.mBottom = anchorParams.mTop - (anchorParams.topMargin +
                    childParams.bottomMargin);
        } else if (childParams.alignWithParent && rules[ABOVE] != 0) {
            if (myHeight >= 0) {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } else {
                // FIXME uh oh...
            }
        }

        anchorParams = getRelatedViewParams(rules, BELOW);
        if (anchorParams != null) {
            childParams.mTop = anchorParams.mBottom + (anchorParams.bottomMargin +
                    childParams.topMargin);
        } else if (childParams.alignWithParent && rules[BELOW] != 0) {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        }

        anchorParams = getRelatedViewParams(rules, ALIGN_TOP);
        if (anchorParams != null) {
            childParams.mTop = anchorParams.mTop + childParams.topMargin;
        } else if (childParams.alignWithParent && rules[ALIGN_TOP] != 0) {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        }

        anchorParams = getRelatedViewParams(rules, ALIGN_BOTTOM);
        if (anchorParams != null) {
            childParams.mBottom = anchorParams.mBottom - childParams.bottomMargin;
        } else if (childParams.alignWithParent && rules[ALIGN_BOTTOM] != 0) {
            if (myHeight >= 0) {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } else {
                // FIXME uh oh...
            }
        }

        if (0 != rules[ALIGN_PARENT_TOP]) {
            childParams.mTop = mPaddingTop + childParams.topMargin;
        }

        if (0 != rules[ALIGN_PARENT_BOTTOM]) {
            if (myHeight >= 0) {
                childParams.mBottom = myHeight - mPaddingBottom - childParams.bottomMargin;
            } else {
                // FIXME uh oh...
            }
        }

        if (rules[ALIGN_BASELINE] != 0) {
            mHasBaselineAlignedChild = true;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.880 -0500", hash_original_method = "1C833E1C2ADE997D1187353BA16BCE70", hash_generated_method = "83F4CE1F5B509C83152C214D53FEC76D")
    
private View getRelatedView(int[] rules, int relation) {
        int id = rules[relation];
        if (id != 0) {
            DependencyGraph.Node node = mGraph.mKeyNodes.get(id);
            if (node == null) return null;
            View v = node.view;

            // Find the first non-GONE view up the chain
            while (v.getVisibility() == View.GONE) {
                rules = ((LayoutParams) v.getLayoutParams()).getRules();
                node = mGraph.mKeyNodes.get((rules[relation]));
                if (node == null) return null;
                v = node.view;
            }

            return v;
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.882 -0500", hash_original_method = "1432C4369AF9849456CCA14753707552", hash_generated_method = "87E0F8DD296FA0AA8E41B2D82A034AA5")
    
private LayoutParams getRelatedViewParams(int[] rules, int relation) {
        View v = getRelatedView(rules, relation);
        if (v != null) {
            ViewGroup.LayoutParams params = v.getLayoutParams();
            if (params instanceof LayoutParams) {
                return (LayoutParams) v.getLayoutParams();
            }
        }
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.884 -0500", hash_original_method = "B96AFAE3C58D6FFF0F9AB9328789A20B", hash_generated_method = "299A78988211003B8179EA049732589D")
    
private int getRelatedViewBaseline(int[] rules, int relation) {
        View v = getRelatedView(rules, relation);
        if (v != null) {
            return v.getBaseline();
        }
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.887 -0500", hash_original_method = "8A1AB6E076A6FFB22058EEC6C343479D", hash_generated_method = "33328618EF9E37013A7E8E94B72E04F8")
    
private void centerHorizontal(View child, LayoutParams params, int myWidth) {
        int childWidth = child.getMeasuredWidth();
        int left = (myWidth - childWidth) / 2;

        params.mLeft = left;
        params.mRight = left + childWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.889 -0500", hash_original_method = "D7FF6A5DD857E80D590F5847BEDB8204", hash_generated_method = "18B708FABB2FF905BD9FD6AAA82FE571")
    
private void centerVertical(View child, LayoutParams params, int myHeight) {
        int childHeight = child.getMeasuredHeight();
        int top = (myHeight - childHeight) / 2;

        params.mTop = top;
        params.mBottom = top + childHeight;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.891 -0500", hash_original_method = "05FEBBF616C51C2D421358B4A05D22CE", hash_generated_method = "C8BD01794E72F9D0106426EDAF308952")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //  The layout has actually already been performed and the positions
        //  cached.  Apply the cached values to the children.
        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                RelativeLayout.LayoutParams st =
                        (RelativeLayout.LayoutParams) child.getLayoutParams();
                child.layout(st.mLeft, st.mTop, st.mRight, st.mBottom);

            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.893 -0500", hash_original_method = "233CD3CEF6FDC0096CEB70C074DAEDA3", hash_generated_method = "B50C38CF72F0312F7A4581FF4C56C893")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new RelativeLayout.LayoutParams(getContext(), attrs);
    }

    /**
     * Returns a set of layout parameters with a width of
     * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT},
     * a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} and no spanning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.896 -0500", hash_original_method = "9A6A2F1616AFA891B0951E317B143439", hash_generated_method = "74CC428643796A680918FE0DB1A65779")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    // Override to allow type-checking of LayoutParams.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.900 -0500", hash_original_method = "7AAD3A1C062434D08215151012F2CF47", hash_generated_method = "5A37B644F5BCF6C2E9DC21DC8359141A")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof RelativeLayout.LayoutParams;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.902 -0500", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "F04F425EAA932DD15846B3A8E447FBE2")
    
@Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:46.904 -0500", hash_original_method = "02980C12A71A151B5687E23560D62A05", hash_generated_method = "4F67BB22C02463A3BF21D4A6D96588A0")
    
@Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (mTopToBottomLeftToRightSet == null) {
            mTopToBottomLeftToRightSet = new TreeSet<View>(new TopToBottomLeftToRightComparator());
        }

        // sort children top-to-bottom and left-to-right
        for (int i = 0, count = getChildCount(); i < count; i++) {
            mTopToBottomLeftToRightSet.add(getChildAt(i));
        }

        for (View view : mTopToBottomLeftToRightSet) {
            if (view.getVisibility() == View.VISIBLE
                    && view.dispatchPopulateAccessibilityEvent(event)) {
                mTopToBottomLeftToRightSet.clear();
                return true;
            }
        }

        mTopToBottomLeftToRightSet.clear();
        return false;
    }
}

