package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;

import com.android.internal.R;

public class TabHost extends FrameLayout implements ViewTreeObserver.OnTouchModeChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.546 -0500", hash_original_field = "E56A6850DB8693E101A91E8FC52A23DC", hash_generated_field = "216F44777CE4F68AB739BEBE93C294F9")

    private TabWidget mTabWidget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.548 -0500", hash_original_field = "76AB0AFD077B380DA1E6B7F01A200A4B", hash_generated_field = "77FD3C218A6BAD9F714CE5CA95EA4CA6")

    private FrameLayout mTabContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.551 -0500", hash_original_field = "2623071FA8B9D05B5F47B75B83EEEB53", hash_generated_field = "2D97E88ACCB60806D13703DBDD6845B4")

    private List<TabSpec> mTabSpecs = new ArrayList<TabSpec>(2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.553 -0500", hash_original_field = "71CFA2F52F16CD147900DEAC2ACD58F4", hash_generated_field = "EBF64AB6B735156C87B0B9A0231F6E50")

    protected int mCurrentTab = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.555 -0500", hash_original_field = "94906ACB48AB06B5C84FE283C2C28564", hash_generated_field = "C8EB085B592C5D26A6E1BFD0C692443B")

    private View mCurrentView = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.557 -0500", hash_original_field = "A5DFC41CC653CD55C59EE3D506FC595A", hash_generated_field = "F5E4EFC7C2394AFB77154901FF2FBDDE")

    protected LocalActivityManager mLocalActivityManager = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.560 -0500", hash_original_field = "2490A55FD411D53812F96980396D7409", hash_generated_field = "6248C12AC19AE72AAA3A94E933F7A0A8")

    private OnTabChangeListener mOnTabChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.562 -0500", hash_original_field = "066FE86F6CAE3C56373966CE57EE84FD", hash_generated_field = "91D7CD0B364B56EF4F58B7B937977D5A")

    private OnKeyListener mTabKeyListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.564 -0500", hash_original_field = "9F469B5D970EFA700EDCC2DC0C2A8761", hash_generated_field = "EC3CB9EB63ECAC6215AE20410DD9CC0F")

    private int mTabLayoutId;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.567 -0500", hash_original_method = "81177E2AB2CE2AADA9E4D9B57D5EE61E", hash_generated_method = "1974FB29BBEE5CBE2B7611BE4D2F4E31")
    
public TabHost(Context context) {
        super(context);
        initTabHost();
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.570 -0500", hash_original_method = "6A9D0785655056C88014FFCBE8AF5DF8", hash_generated_method = "C057BB56C35A71EA0AE296190D007541")
    
public TabHost(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.TabWidget,
                com.android.internal.R.attr.tabWidgetStyle, 0);

        mTabLayoutId = a.getResourceId(R.styleable.TabWidget_tabLayout, 0);
        a.recycle();

        if (mTabLayoutId == 0) {
            // In case the tabWidgetStyle does not inherit from Widget.TabWidget and tabLayout is
            // not defined.
            mTabLayoutId = R.layout.tab_indicator_holo;
        }

        initTabHost();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.572 -0500", hash_original_method = "E225D110F749DDFECF8013DBC90AF66D", hash_generated_method = "C1FD2C646020A1EBB2A45DB7C6A75D14")
    
private void initTabHost() {
        setFocusableInTouchMode(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);

        mCurrentTab = -1;
        mCurrentView = null;
    }

    /**
     * Get a new {@link TabSpec} associated with this tab host.
     * @param tag required tag of tab.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.574 -0500", hash_original_method = "9E260D3987C01C55D906A5443FE1F250", hash_generated_method = "A4E462546AA9F6622B95E5FD4A82210C")
    
public TabSpec newTabSpec(String tag) {
        return new TabSpec(tag);
    }

    /**
      * <p>Call setup() before adding tabs if loading TabHost using findViewById().
      * <i><b>However</i></b>: You do not need to call setup() after getTabHost()
      * in {@link android.app.TabActivity TabActivity}.
      * Example:</p>
<pre>mTabHost = (TabHost)findViewById(R.id.tabhost);
mTabHost.setup();
mTabHost.addTab(TAB_TAG_1, "Hello, world!", "Tab 1");
      */
    @DSComment("TabHost, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.583 -0500", hash_original_method = "11DAEE90670B382AFFC7A5048665264E", hash_generated_method = "374CEFE29F9971D694CA48BB7801411A")
    
public void setup() {
        mTabWidget = (TabWidget) findViewById(com.android.internal.R.id.tabs);
        if (mTabWidget == null) {
            throw new RuntimeException(
                    "Your TabHost must have a TabWidget whose id attribute is 'android.R.id.tabs'");
        }

        // KeyListener to attach to all tabs. Detects non-navigation keys
        // and relays them to the tab content.
        mTabKeyListener = new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_DPAD_CENTER:
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                    case KeyEvent.KEYCODE_DPAD_UP:
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                    case KeyEvent.KEYCODE_ENTER:
                        return false;

                }
                mTabContent.requestFocus(View.FOCUS_FORWARD);
                return mTabContent.dispatchKeyEvent(event);
            }

        };

        mTabWidget.setTabSelectionListener(new TabWidget.OnTabSelectionChanged() {
            public void onTabSelectionChanged(int tabIndex, boolean clicked) {
                setCurrentTab(tabIndex);
                if (clicked) {
                    mTabContent.requestFocus(View.FOCUS_FORWARD);
                }
            }
        });

        mTabContent = (FrameLayout) findViewById(com.android.internal.R.id.tabcontent);
        if (mTabContent == null) {
            throw new RuntimeException(
                    "Your TabHost must have a FrameLayout whose id attribute is "
                            + "'android.R.id.tabcontent'");
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.585 -0500", hash_original_method = "F557CD251A66C23831BE55ECFE0FD6EB", hash_generated_method = "A3F584E5571A8A23D51BC2163CD7463A")
    
@Override
    public void sendAccessibilityEvent(int eventType) {
        /* avoid super class behavior - TabWidget sends the right events */
    }

    /**
     * If you are using {@link TabSpec#setContent(android.content.Intent)}, this
     * must be called since the activityGroup is needed to launch the local activity.
     *
     * This is done for you if you extend {@link android.app.TabActivity}.
     * @param activityGroup Used to launch activities for tab content.
     */
    @DSComment("TabHost, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.587 -0500", hash_original_method = "7224354A386E6E21E9006426BE4B5FE4", hash_generated_method = "FF0C2418470E83B5D3CE17E1B5910722")
    
public void setup(LocalActivityManager activityGroup) {
        setup();
        mLocalActivityManager = activityGroup;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.589 -0500", hash_original_method = "1749A697E4E6C7318205DA9AE02BC223", hash_generated_method = "1AF86CC162390F94E1650FCDAF567B2A")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.addOnTouchModeChangeListener(this);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.591 -0500", hash_original_method = "56196D931FB093B5A1146C07A075CA12", hash_generated_method = "34C0FFC8212596F5B35A5046055DAE23")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.removeOnTouchModeChangeListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.593 -0500", hash_original_method = "F30EBD0BC50E7240BEF5418DD0D95D1E", hash_generated_method = "E32DAAE321543DBDB3A3254A661003E5")
    
public void onTouchModeChanged(boolean isInTouchMode) {
        if (!isInTouchMode) {
            // leaving touch mode.. if nothing has focus, let's give it to
            // the indicator of the current tab
            if (mCurrentView != null && (!mCurrentView.hasFocus() || mCurrentView.isFocused())) {
                mTabWidget.getChildTabViewAt(mCurrentTab).requestFocus();
            }
        }
    }

    /**
     * Add a tab.
     * @param tabSpec Specifies how to create the indicator and content.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.597 -0500", hash_original_method = "7B3B3CDC4F6E22F75BE659816FB8A96F", hash_generated_method = "6607B25D611E173B00C4B9CB03AD311D")
    
public void addTab(TabSpec tabSpec) {

        if (tabSpec.mIndicatorStrategy == null) {
            throw new IllegalArgumentException("you must specify a way to create the tab indicator.");
        }

        if (tabSpec.mContentStrategy == null) {
            throw new IllegalArgumentException("you must specify a way to create the tab content");
        }
        View tabIndicator = tabSpec.mIndicatorStrategy.createIndicatorView();
        tabIndicator.setOnKeyListener(mTabKeyListener);

        // If this is a custom view, then do not draw the bottom strips for
        // the tab indicators.
        if (tabSpec.mIndicatorStrategy instanceof ViewIndicatorStrategy) {
            mTabWidget.setStripEnabled(false);
        }

        mTabWidget.addView(tabIndicator);
        mTabSpecs.add(tabSpec);

        if (mCurrentTab == -1) {
            setCurrentTab(0);
        }
    }

    /**
     * Removes all tabs from the tab widget associated with this tab host.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.599 -0500", hash_original_method = "FE75A14568F4641ABF7C1D51B3B055E3", hash_generated_method = "97DB4A49EB39BC9AF2821C26841C391E")
    
public void clearAllTabs() {
        mTabWidget.removeAllViews();
        initTabHost();
        mTabContent.removeAllViews();
        mTabSpecs.clear();
        requestLayout();
        invalidate();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.602 -0500", hash_original_method = "43D996FE1B0AF9FB74C6533DD719F381", hash_generated_method = "1500F7CDDAB81EE80C1A4BEEAAC5FB07")
    
public TabWidget getTabWidget() {
        return mTabWidget;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.604 -0500", hash_original_method = "715443AB3E5984F89EAA89C58AA4B1A0", hash_generated_method = "17F33289529B0E89B7B16D65A713E3E1")
    
public int getCurrentTab() {
        return mCurrentTab;
    }

    @DSComment("TabHost, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.606 -0500", hash_original_method = "4BF4FAE03E9E8C0B1DA1E933710D00F0", hash_generated_method = "A6FB86ECEB48E046478F1C51BFB94634")
    
public String getCurrentTabTag() {
        if (mCurrentTab >= 0 && mCurrentTab < mTabSpecs.size()) {
            return mTabSpecs.get(mCurrentTab).getTag();
        }
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.608 -0500", hash_original_method = "42AE505B98E20EE6CD2716BFC7687421", hash_generated_method = "C527EC015A9F0DEAD429CF82FD09D1E8")
    
public View getCurrentTabView() {
        if (mCurrentTab >= 0 && mCurrentTab < mTabSpecs.size()) {
            return mTabWidget.getChildTabViewAt(mCurrentTab);
        }
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.610 -0500", hash_original_method = "EEE501665EA90FABC7BF921A8CA32190", hash_generated_method = "02BE3B7229DE1654F2F7D5C6FFE9334F")
    
public View getCurrentView() {
        return mCurrentView;
    }

    @DSComment("TabHost, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.612 -0500", hash_original_method = "8C15D02B8DC442237A4CA8C57AA1B8BD", hash_generated_method = "FB2B46C880E73551097555E51328B111")
    
public void setCurrentTabByTag(String tag) {
        int i;
        for (i = 0; i < mTabSpecs.size(); i++) {
            if (mTabSpecs.get(i).getTag().equals(tag)) {
                setCurrentTab(i);
                break;
            }
        }
    }

    /**
     * Get the FrameLayout which holds tab content
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.614 -0500", hash_original_method = "14B19444D2789515B31F45C4D21A2D48", hash_generated_method = "C37F4FCE614239D54240897980162ECE")
    
public FrameLayout getTabContentView() {
        return mTabContent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.617 -0500", hash_original_method = "C8998AD47D2F3EF23C8F7D2AD28B98AB", hash_generated_method = "126FB2C3745DD284626E3F7E345A4D1C")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        final boolean handled = super.dispatchKeyEvent(event);

        // unhandled key ups change focus to tab indicator for embedded activities
        // when there is nothing that will take focus from default focus searching
        if (!handled
                && (event.getAction() == KeyEvent.ACTION_DOWN)
                && (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP)
                && (mCurrentView != null)
                && (mCurrentView.isRootNamespace())
                && (mCurrentView.hasFocus())
                && (mCurrentView.findFocus().focusSearch(View.FOCUS_UP) == null)) {
            mTabWidget.getChildTabViewAt(mCurrentTab).requestFocus();
            playSoundEffect(SoundEffectConstants.NAVIGATION_UP);
            return true;
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.619 -0500", hash_original_method = "96A22F6DD8439F6A02086A8F9D6622C9", hash_generated_method = "9F9444F67FA0AD52D1456040C9B57F83")
    
@Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        if (mCurrentView != null){
            mCurrentView.dispatchWindowFocusChanged(hasFocus);
        }
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.622 -0500", hash_original_method = "E2648DF1C44758803127AAF509A8077D", hash_generated_method = "F8A7159B9E24FFC79BACDC551729E18F")
    
public void setCurrentTab(int index) {
        if (index < 0 || index >= mTabSpecs.size()) {
            return;
        }

        if (index == mCurrentTab) {
            return;
        }

        // notify old tab content
        if (mCurrentTab != -1) {
            mTabSpecs.get(mCurrentTab).mContentStrategy.tabClosed();
        }

        mCurrentTab = index;
        final TabHost.TabSpec spec = mTabSpecs.get(index);

        // Call the tab widget's focusCurrentTab(), instead of just
        // selecting the tab.
        mTabWidget.focusCurrentTab(mCurrentTab);

        // tab content
        mCurrentView = spec.mContentStrategy.getContentView();

        if (mCurrentView.getParent() == null) {
            mTabContent
                    .addView(
                            mCurrentView,
                            new ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT));
        }

        if (!mTabWidget.hasFocus()) {
            // if the tab widget didn't take focus (likely because we're in touch mode)
            // give the current tab content view a shot
            mCurrentView.requestFocus();
        }

        //mTabContent.requestFocus(View.FOCUS_FORWARD);
        invokeOnTabChangeListener();
    }

    /**
     * Register a callback to be invoked when the selected state of any of the items
     * in this list changes
     * @param l
     * The callback that will run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.624 -0500", hash_original_method = "CAD2636558BA92FD3B25434077F437FA", hash_generated_method = "D99F564D264294062CE40B73B7F6CF69")
    
    @DSVerified("Callback registration")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnTabChangedListener(OnTabChangeListener l) {
        mOnTabChangeListener = l;
        if (l != null) {
            l.onTabChanged(new String());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.627 -0500", hash_original_method = "1A4924ED406293CF6C6A6C1455DF4ECD", hash_generated_method = "0557684ED61A1F884AEA11BA4E0192AD")
    
private void invokeOnTabChangeListener() {
        if (mOnTabChangeListener != null) {
            mOnTabChangeListener.onTabChanged(getCurrentTabTag());
        }
    }
    
    public class TabSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.633 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.635 -0500", hash_original_field = "3814A1D9EFAA5246CD482C76DBA110B1", hash_generated_field = "50BB928D871FCE30C43D2A945AFF6AB0")

        private IndicatorStrategy mIndicatorStrategy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.637 -0500", hash_original_field = "67D66349C25C421BEE2889A1B604B902", hash_generated_field = "D26BEBF611E08BB218DC29C4D4842A86")

        private ContentStrategy mContentStrategy;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.641 -0500", hash_original_method = "B448A25FB17665A97225C3E034B27800", hash_generated_method = "F48648596FEDDE69BE8CC23D5E11F070")
        
private TabSpec(String tag) {
            mTag = tag;
        }

        /**
         * Specify a label as the tab indicator.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.643 -0500", hash_original_method = "5E409F9D1F2DECB24B35FF4D25A5BAE5", hash_generated_method = "6F8A0E39E911288B7F81393CB46277B3")
        
public TabSpec setIndicator(CharSequence label) {
            mIndicatorStrategy = new LabelIndicatorStrategy(label);
            return this;
        }

        /**
         * Specify a label and icon as the tab indicator.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.646 -0500", hash_original_method = "23880839A48B028850E58B36E2EDF15E", hash_generated_method = "26E97D3A38B37000C1E6CF79E098DEE4")
        
public TabSpec setIndicator(CharSequence label, Drawable icon) {
            mIndicatorStrategy = new LabelAndIconIndicatorStrategy(label, icon);
            return this;
        }

        /**
         * Specify a view as the tab indicator.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.648 -0500", hash_original_method = "BD5297BEFA4518E605FA03EA203960DD", hash_generated_method = "EECA0CE53A8F5FA5D88ECA91ECA7F639")
        
public TabSpec setIndicator(View view) {
            mIndicatorStrategy = new ViewIndicatorStrategy(view);
            return this;
        }

        /**
         * Specify the id of the view that should be used as the content
         * of the tab.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.650 -0500", hash_original_method = "4C505DBFF1019A4E7D7D5286BB033694", hash_generated_method = "F96BD8467684D4725655647FCC103BB4")
        
public TabSpec setContent(int viewId) {
            mContentStrategy = new ViewIdContentStrategy(viewId);
            return this;
        }

        /**
         * Specify a {@link android.widget.TabHost.TabContentFactory} to use to
         * create the content of the tab.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.653 -0500", hash_original_method = "B29A01466A3B1FB70EA06E4B795F088E", hash_generated_method = "5F5B4524584E3E59556DF4CA8532948B")
        
public TabSpec setContent(TabContentFactory contentFactory) {
            mContentStrategy = new FactoryContentStrategy(mTag, contentFactory);
            return this;
        }

        /**
         * Specify an intent to use to launch an activity as the tab content.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.655 -0500", hash_original_method = "0D57BE6053E1E40100589C46AD4E8491", hash_generated_method = "3826885F899FE1A7F3E300B46A249FD8")
        
public TabSpec setContent(Intent intent) {
            mContentStrategy = new IntentContentStrategy(mTag, intent);
            return this;
        }

        @DSComment("not sensitive/not an action")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.657 -0500", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "0B538D6B7E10340EACEB66882A3752E4")
        
public String getTag() {
            return mTag;
        }
        
    }
    
    private class LabelIndicatorStrategy implements IndicatorStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.666 -0500", hash_original_field = "3688992A2E5C86A7BA94DE38FB1043D1", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

        private  CharSequence mLabel;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.669 -0500", hash_original_method = "8DE7E2F209482BC83865CDCF3C7C3957", hash_generated_method = "CDB38C3415D0D8BB2AA67396E944329F")
        
private LabelIndicatorStrategy(CharSequence label) {
            mLabel = label;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.673 -0500", hash_original_method = "DC1E36DC8692A133E2BAD2847D81CB26", hash_generated_method = "2DAE5BDA1795A5A6DBBDA8E0F3EA0C09")
        
public View createIndicatorView() {
            final Context context = getContext();
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View tabIndicator = inflater.inflate(mTabLayoutId,
                    mTabWidget, // tab widget is the parent
                    false); // no inflate params

            final TextView tv = (TextView) tabIndicator.findViewById(R.id.title);
            tv.setText(mLabel);

            if (context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT) {
                // Donut apps get old color scheme
                tabIndicator.setBackgroundResource(R.drawable.tab_indicator_v4);
                tv.setTextColor(context.getResources().getColorStateList(R.color.tab_indicator_text_v4));
            }

            return tabIndicator;
        }
        
    }
    
    private class LabelAndIconIndicatorStrategy implements IndicatorStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.677 -0500", hash_original_field = "3688992A2E5C86A7BA94DE38FB1043D1", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

        private  CharSequence mLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.679 -0500", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

        private  Drawable mIcon;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.682 -0500", hash_original_method = "A623A8042A1AC955C3AA9DCF282E65F2", hash_generated_method = "7C1A13B288CD714C1F059D607530D64A")
        
private LabelAndIconIndicatorStrategy(CharSequence label, Drawable icon) {
            mLabel = label;
            mIcon = icon;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.684 -0500", hash_original_method = "9B2F586B6F3639CDD79EFCA223D857D6", hash_generated_method = "8CA91ABA8A2969A61368930D6D063212")
        
public View createIndicatorView() {
            final Context context = getContext();
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View tabIndicator = inflater.inflate(mTabLayoutId,
                    mTabWidget, // tab widget is the parent
                    false); // no inflate params

            final TextView tv = (TextView) tabIndicator.findViewById(R.id.title);
            final ImageView iconView = (ImageView) tabIndicator.findViewById(R.id.icon);

            // when icon is gone by default, we're in exclusive mode
            final boolean exclusive = iconView.getVisibility() == View.GONE;
            final boolean bindIcon = !exclusive || TextUtils.isEmpty(mLabel);

            tv.setText(mLabel);

            if (bindIcon && mIcon != null) {
                iconView.setImageDrawable(mIcon);
                iconView.setVisibility(VISIBLE);
            }

            if (context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT) {
                // Donut apps get old color scheme
                tabIndicator.setBackgroundResource(R.drawable.tab_indicator_v4);
                tv.setTextColor(context.getResources().getColorStateList(R.color.tab_indicator_text_v4));
            }

            return tabIndicator;
        }
        
    }
    
    private class ViewIndicatorStrategy implements IndicatorStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.690 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

        private  View mView;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.692 -0500", hash_original_method = "70774C2CF3D512F90368753CBBBC1864", hash_generated_method = "FD1537778564493A9AB1331F6493B306")
        
private ViewIndicatorStrategy(View view) {
            mView = view;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.694 -0500", hash_original_method = "E81C3A0236D0948C1B54CB0897C263EB", hash_generated_method = "700804B1F52CCD6FFD0C1DEA1E04B6FD")
        
public View createIndicatorView() {
            return mView;
        }
        
    }
    
    private class ViewIdContentStrategy implements ContentStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.699 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

        private  View mView;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.701 -0500", hash_original_method = "DD6B61194EE85E32120CD7630D172F73", hash_generated_method = "2E6E459F696FF1108A8C8664F9624F9F")
        
private ViewIdContentStrategy(int viewId) {
            mView = mTabContent.findViewById(viewId);
            if (mView != null) {
                mView.setVisibility(View.GONE);
            } else {
                throw new RuntimeException("Could not create tab content because " +
                        "could not find view with id " + viewId);
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.704 -0500", hash_original_method = "FAF9C6C424D99CBF1D87945750D97718", hash_generated_method = "8F6BBD0D58C50FC93A6B0F73FC034728")
        
public View getContentView() {
            mView.setVisibility(View.VISIBLE);
            return mView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.707 -0500", hash_original_method = "1538BDA0E7D9A0DE19E0F5AE4CBE24FE", hash_generated_method = "9DB36E66DA1A806DE5AEB4CEB8134A5A")
        
public void tabClosed() {
            mView.setVisibility(View.GONE);
        }
        
    }
    
    private class FactoryContentStrategy implements ContentStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.711 -0500", hash_original_field = "43ACCCA62A6557420E47915617C1E09E", hash_generated_field = "26B32329200530E6945EB791CCFA7B16")

        private View mTabContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.713 -0500", hash_original_field = "6CAF2EB9DE0CF9C2C8D9DDA77EEBA7B3", hash_generated_field = "90E823197545D5DE4C4A5E73822FE24E")

        private  CharSequence mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.716 -0500", hash_original_field = "AF958AF168773FD1AF099D0B3B41AC93", hash_generated_field = "0AB71F610C660047CA6A684CD66A9872")

        private TabContentFactory mFactory;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.718 -0500", hash_original_method = "ADEE9FCDC20A1EAC6F11E73C35E4CE28", hash_generated_method = "CE05824A22BBAB77713D185C3EDAC93B")
        
public FactoryContentStrategy(CharSequence tag, TabContentFactory factory) {
            mTag = tag;
            mFactory = factory;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.721 -0500", hash_original_method = "ED11D1341C028F4F2DA686CA9100CB0F", hash_generated_method = "D3E27D5F5789C8EFBB4F418168A8FD30")
        @DSVerified
        @DSSafe(DSCat.GUI)
public View getContentView() {
            if (mTabContent == null) {
                mTabContent = mFactory.createTabContent(mTag.toString());
            }
            mTabContent.setVisibility(View.VISIBLE);
            return mTabContent;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.723 -0500", hash_original_method = "F4CF7743D7975FC61814EFF15B52191C", hash_generated_method = "729171273AB4AA5C156EFB50B6B508A4")
        
public void tabClosed() {
            mTabContent.setVisibility(View.GONE);
        }
        
    }
    
    private class IntentContentStrategy implements ContentStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.727 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private  String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.729 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private  Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.732 -0500", hash_original_field = "C7DE39C5195196B9EBD4993B626F168F", hash_generated_field = "88756EAB8F8EDEB0E827033676248AB0")

        private View mLaunchedView;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.735 -0500", hash_original_method = "ED843E62CBFAC6E94798B5D03DF8D93E", hash_generated_method = "B75E1B52BBC4DFA0797662D36AB76338")
        
private IntentContentStrategy(String tag, Intent intent) {
            mTag = tag;
            mIntent = intent;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.737 -0500", hash_original_method = "FE3CC83835F910E93083BF6BA67BB115", hash_generated_method = "EE601A01F8FEDE25BB02740BFCAF76FE")
        
public View getContentView() {
            if (mLocalActivityManager == null) {
                throw new IllegalStateException("Did you forget to call 'public void setup(LocalActivityManager activityGroup)'?");
            }
            final Window w = mLocalActivityManager.startActivity(
                    mTag, mIntent);
            final View wd = w != null ? w.getDecorView() : null;
            if (mLaunchedView != wd && mLaunchedView != null) {
                if (mLaunchedView.getParent() != null) {
                    mTabContent.removeView(mLaunchedView);
                }
            }
            mLaunchedView = wd;

            // XXX Set FOCUS_AFTER_DESCENDANTS on embedded activities for now so they can get
            // focus if none of their children have it. They need focus to be able to
            // display menu items.
            //
            // Replace this with something better when Bug 628886 is fixed...
            //
            if (mLaunchedView != null) {
                mLaunchedView.setVisibility(View.VISIBLE);
                mLaunchedView.setFocusableInTouchMode(true);
                ((ViewGroup) mLaunchedView).setDescendantFocusability(
                        FOCUS_AFTER_DESCENDANTS);
            }
            return mLaunchedView;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:49.740 -0500", hash_original_method = "94FBE3B8432975AC17E234FCD4A9B7F4", hash_generated_method = "908490328AA9667A875EEF6B71712CC5")
        
public void tabClosed() {
            if (mLaunchedView != null) {
                mLaunchedView.setVisibility(View.GONE);
            }
        }
        
    }
    
    public interface OnTabChangeListener {
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onTabChanged(String tabId);
    }
    
    public interface TabContentFactory {
        
        @DSVerified("Class interface, not for callback")
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        View createTabContent(String tag);
    }
    
    private static interface IndicatorStrategy {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        View createIndicatorView();
    }
    
    private static interface ContentStrategy {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        View getContentView();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void tabClosed();
    }
    
}

