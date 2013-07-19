package android.widget;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TabHost extends FrameLayout implements ViewTreeObserver.OnTouchModeChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "BD9EB412161EDE3095E73C7561A13D17", hash_generated_field = "216F44777CE4F68AB739BEBE93C294F9")

    private TabWidget mTabWidget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "A7F1EA497040BBFBF8BE2A90A6E0B6E4", hash_generated_field = "77FD3C218A6BAD9F714CE5CA95EA4CA6")

    private FrameLayout mTabContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "E7320822C44EB689BE7746CC6AF343CE", hash_generated_field = "2D97E88ACCB60806D13703DBDD6845B4")

    private List<TabSpec> mTabSpecs = new ArrayList<TabSpec>(2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "8BAB9D447E0B22F1F61BB3F1E7AC6396", hash_generated_field = "EBF64AB6B735156C87B0B9A0231F6E50")

    protected int mCurrentTab = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "C3E9C3C3B19D7F8BF41317696660FE8C", hash_generated_field = "C8EB085B592C5D26A6E1BFD0C692443B")

    private View mCurrentView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "B950898C2FC7B46BB242C0B79D705704", hash_generated_field = "F5E4EFC7C2394AFB77154901FF2FBDDE")

    protected LocalActivityManager mLocalActivityManager = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "D55E0A212E5BEA43B1240B875AEBE97B", hash_generated_field = "6248C12AC19AE72AAA3A94E933F7A0A8")

    private OnTabChangeListener mOnTabChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "EBC9C1440F16CAD95197DE77BA132C75", hash_generated_field = "91D7CD0B364B56EF4F58B7B937977D5A")

    private OnKeyListener mTabKeyListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_field = "CB97DAC54535B44E8FF0A143C043A85A", hash_generated_field = "EC3CB9EB63ECAC6215AE20410DD9CC0F")

    private int mTabLayoutId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_method = "81177E2AB2CE2AADA9E4D9B57D5EE61E", hash_generated_method = "B68776E3AE8F26CA5F69D2AF694A3A75")
    public  TabHost(Context context) {
        super(context);
        addTaint(context.getTaint());
        initTabHost();
        // ---------- Original Method ----------
        //initTabHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_method = "6A9D0785655056C88014FFCBE8AF5DF8", hash_generated_method = "14F45BFBC48A6C4571EEB7701D65E9BA")
    public  TabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.TabWidget,
                com.android.internal.R.attr.tabWidgetStyle, 0);
        mTabLayoutId = a.getResourceId(R.styleable.TabWidget_tabLayout, 0);
        a.recycle();
        if(mTabLayoutId == 0)        
        {
            mTabLayoutId = R.layout.tab_indicator_holo;
        } //End block
        initTabHost();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.TabWidget,
                //com.android.internal.R.attr.tabWidgetStyle, 0);
        //mTabLayoutId = a.getResourceId(R.styleable.TabWidget_tabLayout, 0);
        //a.recycle();
        //if (mTabLayoutId == 0) {
            //mTabLayoutId = R.layout.tab_indicator_holo;
        //}
        //initTabHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_method = "E225D110F749DDFECF8013DBC90AF66D", hash_generated_method = "AFD8B2E46F167093444B29ADE7F14CDB")
    private void initTabHost() {
        setFocusableInTouchMode(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        mCurrentTab = -1;
        mCurrentView = null;
        // ---------- Original Method ----------
        //setFocusableInTouchMode(true);
        //setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        //mCurrentTab = -1;
        //mCurrentView = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.728 -0400", hash_original_method = "9E260D3987C01C55D906A5443FE1F250", hash_generated_method = "E0879C8FFA02E42AE9B487C1E1BAA6DD")
    public TabSpec newTabSpec(String tag) {
        addTaint(tag.getTaint());
TabSpec var9394CA671E7F01C66F85FB413430087C_1322729479 =         new TabSpec(tag);
        var9394CA671E7F01C66F85FB413430087C_1322729479.addTaint(taint);
        return var9394CA671E7F01C66F85FB413430087C_1322729479;
        // ---------- Original Method ----------
        //return new TabSpec(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.729 -0400", hash_original_method = "11DAEE90670B382AFFC7A5048665264E", hash_generated_method = "49A6449CE74CD7D926A6486072B7FCDF")
    public void setup() {
        mTabWidget = (TabWidget) findViewById(com.android.internal.R.id.tabs);
        if(mTabWidget == null)        
        {
            RuntimeException var5DC7F166BF9B3AC526B0E6AA20AA1352_31541219 = new RuntimeException(
                    "Your TabHost must have a TabWidget whose id attribute is 'android.R.id.tabs'");
            var5DC7F166BF9B3AC526B0E6AA20AA1352_31541219.addTaint(taint);
            throw var5DC7F166BF9B3AC526B0E6AA20AA1352_31541219;
        } //End block
        mTabKeyListener = new OnKeyListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.729 -0400", hash_original_method = "C0EA49319FD8B41812699E631E771535", hash_generated_method = "4005DE61CE5AC0EE87869CCF26FB6F3A")
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(keyCode);
            addTaint(v.getTaint());
switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_ENTER:
            boolean var68934A3E9455FA72420237EB05902327_2100525329 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090970721 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090970721;
}            mTabContent.requestFocus(View.FOCUS_FORWARD);
            boolean var273DA003ADCFDB92D0EBA136175532C1_23091397 = (mTabContent.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541895008 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_541895008;
            // ---------- Original Method ----------
            //switch (keyCode) {
                    //case KeyEvent.KEYCODE_DPAD_CENTER:
                    //case KeyEvent.KEYCODE_DPAD_LEFT:
                    //case KeyEvent.KEYCODE_DPAD_RIGHT:
                    //case KeyEvent.KEYCODE_DPAD_UP:
                    //case KeyEvent.KEYCODE_DPAD_DOWN:
                    //case KeyEvent.KEYCODE_ENTER:
                        //return false;
                //}
            //mTabContent.requestFocus(View.FOCUS_FORWARD);
            //return mTabContent.dispatchKeyEvent(event);
        }
};
        mTabWidget.setTabSelectionListener(new TabWidget.OnTabSelectionChanged() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.729 -0400", hash_original_method = "A259B917D04BDEAF062BC2DB0803EBFA", hash_generated_method = "01DB11C570923A2CD1267A6ECE6AA313")
        public void onTabSelectionChanged(int tabIndex, boolean clicked) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(clicked);
            addTaint(tabIndex);
            setCurrentTab(tabIndex);
            if(clicked)            
            {
                mTabContent.requestFocus(View.FOCUS_FORWARD);
            } //End block
            // ---------- Original Method ----------
            //setCurrentTab(tabIndex);
            //if (clicked) {
                    //mTabContent.requestFocus(View.FOCUS_FORWARD);
                //}
        }
});
        mTabContent = (FrameLayout) findViewById(com.android.internal.R.id.tabcontent);
        if(mTabContent == null)        
        {
            RuntimeException var716C43C79B3FC02886B0E6FC5F09CF65_1238661435 = new RuntimeException(
                    "Your TabHost must have a FrameLayout whose id attribute is "
                            + "'android.R.id.tabcontent'");
            var716C43C79B3FC02886B0E6FC5F09CF65_1238661435.addTaint(taint);
            throw var716C43C79B3FC02886B0E6FC5F09CF65_1238661435;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.729 -0400", hash_original_method = "F557CD251A66C23831BE55ECFE0FD6EB", hash_generated_method = "6A09BD8EA53A915AB5F822E12CBC5F98")
    @Override
    public void sendAccessibilityEvent(int eventType) {
        addTaint(eventType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.729 -0400", hash_original_method = "7224354A386E6E21E9006426BE4B5FE4", hash_generated_method = "DB89070E35CFC42DA1D1C60F5FB06ED5")
    public void setup(LocalActivityManager activityGroup) {
        setup();
        mLocalActivityManager = activityGroup;
        // ---------- Original Method ----------
        //setup();
        //mLocalActivityManager = activityGroup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "1749A697E4E6C7318205DA9AE02BC223", hash_generated_method = "4C1B09CC4A3161ACA376A60E7B4F4A76")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.addOnTouchModeChangeListener(this);
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //final ViewTreeObserver treeObserver = getViewTreeObserver();
        //treeObserver.addOnTouchModeChangeListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "56196D931FB093B5A1146C07A075CA12", hash_generated_method = "F26B48291C057827C5C1790AF0239B41")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        treeObserver.removeOnTouchModeChangeListener(this);
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //final ViewTreeObserver treeObserver = getViewTreeObserver();
        //treeObserver.removeOnTouchModeChangeListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "F30EBD0BC50E7240BEF5418DD0D95D1E", hash_generated_method = "7F48E72F2966E5F1130533C717A97650")
    public void onTouchModeChanged(boolean isInTouchMode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(isInTouchMode);
        if(!isInTouchMode)        
        {
            if(mCurrentView != null && (!mCurrentView.hasFocus() || mCurrentView.isFocused()))            
            {
                mTabWidget.getChildTabViewAt(mCurrentTab).requestFocus();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!isInTouchMode) {
            //if (mCurrentView != null && (!mCurrentView.hasFocus() || mCurrentView.isFocused())) {
                //mTabWidget.getChildTabViewAt(mCurrentTab).requestFocus();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "7B3B3CDC4F6E22F75BE659816FB8A96F", hash_generated_method = "2A1F8D09D29E761BF782958FD2FDDEA0")
    public void addTab(TabSpec tabSpec) {
        addTaint(tabSpec.getTaint());
        if(tabSpec.mIndicatorStrategy == null)        
        {
            IllegalArgumentException varA59285131EC8FBC7020DCD85D85A8377_297552275 = new IllegalArgumentException("you must specify a way to create the tab indicator.");
            varA59285131EC8FBC7020DCD85D85A8377_297552275.addTaint(taint);
            throw varA59285131EC8FBC7020DCD85D85A8377_297552275;
        } //End block
        if(tabSpec.mContentStrategy == null)        
        {
            IllegalArgumentException var811A2D321ECE4A7272DFDBE4B3F1A05F_1241449139 = new IllegalArgumentException("you must specify a way to create the tab content");
            var811A2D321ECE4A7272DFDBE4B3F1A05F_1241449139.addTaint(taint);
            throw var811A2D321ECE4A7272DFDBE4B3F1A05F_1241449139;
        } //End block
        View tabIndicator = tabSpec.mIndicatorStrategy.createIndicatorView();
        tabIndicator.setOnKeyListener(mTabKeyListener);
        if(tabSpec.mIndicatorStrategy instanceof ViewIndicatorStrategy)        
        {
            mTabWidget.setStripEnabled(false);
        } //End block
        mTabWidget.addView(tabIndicator);
        mTabSpecs.add(tabSpec);
        if(mCurrentTab == -1)        
        {
            setCurrentTab(0);
        } //End block
        // ---------- Original Method ----------
        //if (tabSpec.mIndicatorStrategy == null) {
            //throw new IllegalArgumentException("you must specify a way to create the tab indicator.");
        //}
        //if (tabSpec.mContentStrategy == null) {
            //throw new IllegalArgumentException("you must specify a way to create the tab content");
        //}
        //View tabIndicator = tabSpec.mIndicatorStrategy.createIndicatorView();
        //tabIndicator.setOnKeyListener(mTabKeyListener);
        //if (tabSpec.mIndicatorStrategy instanceof ViewIndicatorStrategy) {
            //mTabWidget.setStripEnabled(false);
        //}
        //mTabWidget.addView(tabIndicator);
        //mTabSpecs.add(tabSpec);
        //if (mCurrentTab == -1) {
            //setCurrentTab(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "FE75A14568F4641ABF7C1D51B3B055E3", hash_generated_method = "EDB41B266040C47F9666482EE95C9A5D")
    public void clearAllTabs() {
        mTabWidget.removeAllViews();
        initTabHost();
        mTabContent.removeAllViews();
        mTabSpecs.clear();
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mTabWidget.removeAllViews();
        //initTabHost();
        //mTabContent.removeAllViews();
        //mTabSpecs.clear();
        //requestLayout();
        //invalidate();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "43D996FE1B0AF9FB74C6533DD719F381", hash_generated_method = "999C2718D7C5A7BDBDF3809AA5AEFBAF")
    public TabWidget getTabWidget() {
TabWidget varB3FC95A9DAD9613B1E41023CF16F4D5C_976987007 =         mTabWidget;
        varB3FC95A9DAD9613B1E41023CF16F4D5C_976987007.addTaint(taint);
        return varB3FC95A9DAD9613B1E41023CF16F4D5C_976987007;
        // ---------- Original Method ----------
        //return mTabWidget;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "715443AB3E5984F89EAA89C58AA4B1A0", hash_generated_method = "9470D45AB6CA60EB201CC979664F48D0")
    public int getCurrentTab() {
        int var6655CA683CFF0C7E3ACACBBF6B5DF883_888541007 = (mCurrentTab);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130433611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130433611;
        // ---------- Original Method ----------
        //return mCurrentTab;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "4BF4FAE03E9E8C0B1DA1E933710D00F0", hash_generated_method = "DD59D330EF0F75B84978F0736072F08E")
    public String getCurrentTabTag() {
        if(mCurrentTab >= 0 && mCurrentTab < mTabSpecs.size())        
        {
String var2CDA14817F2AE5AD78244DB54528EE2A_1949429771 =             mTabSpecs.get(mCurrentTab).getTag();
            var2CDA14817F2AE5AD78244DB54528EE2A_1949429771.addTaint(taint);
            return var2CDA14817F2AE5AD78244DB54528EE2A_1949429771;
        } //End block
String var540C13E9E156B687226421B24F2DF178_170892712 =         null;
        var540C13E9E156B687226421B24F2DF178_170892712.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_170892712;
        // ---------- Original Method ----------
        //if (mCurrentTab >= 0 && mCurrentTab < mTabSpecs.size()) {
            //return mTabSpecs.get(mCurrentTab).getTag();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.730 -0400", hash_original_method = "42AE505B98E20EE6CD2716BFC7687421", hash_generated_method = "3628D40B51AF5A1D2A36308AFCC03E8B")
    public View getCurrentTabView() {
        if(mCurrentTab >= 0 && mCurrentTab < mTabSpecs.size())        
        {
View var1161A3EF81B3A36EBD6DFD15E63B3F4A_1860464452 =             mTabWidget.getChildTabViewAt(mCurrentTab);
            var1161A3EF81B3A36EBD6DFD15E63B3F4A_1860464452.addTaint(taint);
            return var1161A3EF81B3A36EBD6DFD15E63B3F4A_1860464452;
        } //End block
View var540C13E9E156B687226421B24F2DF178_1132684777 =         null;
        var540C13E9E156B687226421B24F2DF178_1132684777.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1132684777;
        // ---------- Original Method ----------
        //if (mCurrentTab >= 0 && mCurrentTab < mTabSpecs.size()) {
            //return mTabWidget.getChildTabViewAt(mCurrentTab);
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.731 -0400", hash_original_method = "EEE501665EA90FABC7BF921A8CA32190", hash_generated_method = "9CA9827AE467149C906026956F88A5BD")
    public View getCurrentView() {
View var91CDA2CE07B9AFD30FCF6AED3E40A3D8_344153225 =         mCurrentView;
        var91CDA2CE07B9AFD30FCF6AED3E40A3D8_344153225.addTaint(taint);
        return var91CDA2CE07B9AFD30FCF6AED3E40A3D8_344153225;
        // ---------- Original Method ----------
        //return mCurrentView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.731 -0400", hash_original_method = "8C15D02B8DC442237A4CA8C57AA1B8BD", hash_generated_method = "6D6E06D2732C5CEE4151A73D4BBEB12B")
    public void setCurrentTabByTag(String tag) {
        addTaint(tag.getTaint());
        int i;
for(i = 0;i < mTabSpecs.size();i++)
        {
            if(mTabSpecs.get(i).getTag().equals(tag))            
            {
                setCurrentTab(i);
                break;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int i;
        //for (i = 0; i < mTabSpecs.size(); i++) {
            //if (mTabSpecs.get(i).getTag().equals(tag)) {
                //setCurrentTab(i);
                //break;
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.731 -0400", hash_original_method = "14B19444D2789515B31F45C4D21A2D48", hash_generated_method = "687198E7CC395F05D118A6057D03A83F")
    public FrameLayout getTabContentView() {
FrameLayout varB62F3AA3ED8906E8B6C427D442F6F39B_1514590079 =         mTabContent;
        varB62F3AA3ED8906E8B6C427D442F6F39B_1514590079.addTaint(taint);
        return varB62F3AA3ED8906E8B6C427D442F6F39B_1514590079;
        // ---------- Original Method ----------
        //return mTabContent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.731 -0400", hash_original_method = "C8998AD47D2F3EF23C8F7D2AD28B98AB", hash_generated_method = "A9BFF49A938E3E78019656F27487F32A")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        final boolean handled = super.dispatchKeyEvent(event);
        if(!handled
                && (event.getAction() == KeyEvent.ACTION_DOWN)
                && (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP)
                && (mCurrentView != null)
                && (mCurrentView.isRootNamespace())
                && (mCurrentView.hasFocus())
                && (mCurrentView.findFocus().focusSearch(View.FOCUS_UP) == null))        
        {
            mTabWidget.getChildTabViewAt(mCurrentTab).requestFocus();
            playSoundEffect(SoundEffectConstants.NAVIGATION_UP);
            boolean varB326B5062B2F0E69046810717534CB09_1415719284 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544798840 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_544798840;
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_700477362 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1320058721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1320058721;
        // ---------- Original Method ----------
        //final boolean handled = super.dispatchKeyEvent(event);
        //if (!handled
                //&& (event.getAction() == KeyEvent.ACTION_DOWN)
                //&& (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP)
                //&& (mCurrentView != null)
                //&& (mCurrentView.isRootNamespace())
                //&& (mCurrentView.hasFocus())
                //&& (mCurrentView.findFocus().focusSearch(View.FOCUS_UP) == null)) {
            //mTabWidget.getChildTabViewAt(mCurrentTab).requestFocus();
            //playSoundEffect(SoundEffectConstants.NAVIGATION_UP);
            //return true;
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.731 -0400", hash_original_method = "96A22F6DD8439F6A02086A8F9D6622C9", hash_generated_method = "B59DE55F3D1D44CD4C83D7B811421C3C")
    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        addTaint(hasFocus);
        if(mCurrentView != null)        
        {
            mCurrentView.dispatchWindowFocusChanged(hasFocus);
        } //End block
        // ---------- Original Method ----------
        //if (mCurrentView != null){
            //mCurrentView.dispatchWindowFocusChanged(hasFocus);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.731 -0400", hash_original_method = "E2648DF1C44758803127AAF509A8077D", hash_generated_method = "9818FC744E795A1F211F4AB7BBEE36BA")
    public void setCurrentTab(int index) {
        if(index < 0 || index >= mTabSpecs.size())        
        {
            return;
        } //End block
        if(index == mCurrentTab)        
        {
            return;
        } //End block
        if(mCurrentTab != -1)        
        {
            mTabSpecs.get(mCurrentTab).mContentStrategy.tabClosed();
        } //End block
        mCurrentTab = index;
        final TabHost.TabSpec spec = mTabSpecs.get(index);
        mTabWidget.focusCurrentTab(mCurrentTab);
        mCurrentView = spec.mContentStrategy.getContentView();
        if(mCurrentView.getParent() == null)        
        {
            mTabContent
                    .addView(
                            mCurrentView,
                            new ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT));
        } //End block
        if(!mTabWidget.hasFocus())        
        {
            mCurrentView.requestFocus();
        } //End block
        invokeOnTabChangeListener();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "CAD2636558BA92FD3B25434077F437FA", hash_generated_method = "81BDC8026576E158152F1D6A433CB82E")
    public void setOnTabChangedListener(OnTabChangeListener l) {
        mOnTabChangeListener = l;
        // ---------- Original Method ----------
        //mOnTabChangeListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "1A4924ED406293CF6C6A6C1455DF4ECD", hash_generated_method = "043E42BE1BF65E44F0810118880856D7")
    private void invokeOnTabChangeListener() {
        if(mOnTabChangeListener != null)        
        {
            mOnTabChangeListener.onTabChanged(getCurrentTabTag());
        } //End block
        // ---------- Original Method ----------
        //if (mOnTabChangeListener != null) {
            //mOnTabChangeListener.onTabChanged(getCurrentTabTag());
        //}
    }

    
    public class TabSpec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_field = "DF854942C9043CEFD4BEC608F0EA2575", hash_generated_field = "50BB928D871FCE30C43D2A945AFF6AB0")

        private IndicatorStrategy mIndicatorStrategy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_field = "8514227FF9072119B8C98F24E4C63792", hash_generated_field = "D26BEBF611E08BB218DC29C4D4842A86")

        private ContentStrategy mContentStrategy;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "B448A25FB17665A97225C3E034B27800", hash_generated_method = "8C52576964B21F07DD2BCCD9B11DF51C")
        private  TabSpec(String tag) {
            mTag = tag;
            // ---------- Original Method ----------
            //mTag = tag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "5E409F9D1F2DECB24B35FF4D25A5BAE5", hash_generated_method = "5BC11188BE7F476A0CF993BE284EC189")
        public TabSpec setIndicator(CharSequence label) {
            mIndicatorStrategy = new LabelIndicatorStrategy(label);
TabSpec var72A74007B2BE62B849F475C7BDA4658B_1395496220 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1395496220.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1395496220;
            // ---------- Original Method ----------
            //mIndicatorStrategy = new LabelIndicatorStrategy(label);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "23880839A48B028850E58B36E2EDF15E", hash_generated_method = "2B29E5C14C301FAD18A98DCD089EA907")
        public TabSpec setIndicator(CharSequence label, Drawable icon) {
            mIndicatorStrategy = new LabelAndIconIndicatorStrategy(label, icon);
TabSpec var72A74007B2BE62B849F475C7BDA4658B_1471282381 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1471282381.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1471282381;
            // ---------- Original Method ----------
            //mIndicatorStrategy = new LabelAndIconIndicatorStrategy(label, icon);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "BD5297BEFA4518E605FA03EA203960DD", hash_generated_method = "7F75E1FF8F0AAAFC64C005CB25F94167")
        public TabSpec setIndicator(View view) {
            mIndicatorStrategy = new ViewIndicatorStrategy(view);
TabSpec var72A74007B2BE62B849F475C7BDA4658B_2114963256 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2114963256.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2114963256;
            // ---------- Original Method ----------
            //mIndicatorStrategy = new ViewIndicatorStrategy(view);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "4C505DBFF1019A4E7D7D5286BB033694", hash_generated_method = "D73FD5CFEA8198EE06E08AC46862F749")
        public TabSpec setContent(int viewId) {
            mContentStrategy = new ViewIdContentStrategy(viewId);
TabSpec var72A74007B2BE62B849F475C7BDA4658B_1261478740 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1261478740.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1261478740;
            // ---------- Original Method ----------
            //mContentStrategy = new ViewIdContentStrategy(viewId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.732 -0400", hash_original_method = "B29A01466A3B1FB70EA06E4B795F088E", hash_generated_method = "E266CE0C75B9E8E90B7DA81C2A8BD1B7")
        public TabSpec setContent(TabContentFactory contentFactory) {
            mContentStrategy = new FactoryContentStrategy(mTag, contentFactory);
TabSpec var72A74007B2BE62B849F475C7BDA4658B_203378821 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_203378821.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_203378821;
            // ---------- Original Method ----------
            //mContentStrategy = new FactoryContentStrategy(mTag, contentFactory);
            //return this;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_method = "0D57BE6053E1E40100589C46AD4E8491", hash_generated_method = "0006346AC29CD8A2F9292B4BD6BFFCAB")
        public TabSpec setContent(Intent intent) {
            mContentStrategy = new IntentContentStrategy(mTag, intent);
TabSpec var72A74007B2BE62B849F475C7BDA4658B_938543540 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_938543540.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_938543540;
            // ---------- Original Method ----------
            //mContentStrategy = new IntentContentStrategy(mTag, intent);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "28B1A462D47DA0291C3E8AB86AA1E2BB")
        public String getTag() {
String varD6A25044F8E609F6CD67330C1523D33D_1708513686 =             mTag;
            varD6A25044F8E609F6CD67330C1523D33D_1708513686.addTaint(taint);
            return varD6A25044F8E609F6CD67330C1523D33D_1708513686;
            // ---------- Original Method ----------
            //return mTag;
        }

        
    }


    
    private class LabelIndicatorStrategy implements IndicatorStrategy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

        private CharSequence mLabel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_method = "8DE7E2F209482BC83865CDCF3C7C3957", hash_generated_method = "08E3A6DB2473BDD30016B577A75C17DA")
        private  LabelIndicatorStrategy(CharSequence label) {
            mLabel = label;
            // ---------- Original Method ----------
            //mLabel = label;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_method = "DC1E36DC8692A133E2BAD2847D81CB26", hash_generated_method = "E355CBAB50F1C78EE634C1001A1BEC4F")
        public View createIndicatorView() {
            final Context context = getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View tabIndicator = inflater.inflate(mTabLayoutId,
                    mTabWidget, 
                    false);
            final TextView tv = (TextView) tabIndicator.findViewById(R.id.title);
            tv.setText(mLabel);
            if(context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT)            
            {
                tabIndicator.setBackgroundResource(R.drawable.tab_indicator_v4);
                tv.setTextColor(context.getResources().getColorStateList(R.color.tab_indicator_text_v4));
            } //End block
View var01EB2B982C218B50E10E237D1B17CF95_14473746 =             tabIndicator;
            var01EB2B982C218B50E10E237D1B17CF95_14473746.addTaint(taint);
            return var01EB2B982C218B50E10E237D1B17CF95_14473746;
            // ---------- Original Method ----------
            //final Context context = getContext();
            //LayoutInflater inflater =
                    //(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //View tabIndicator = inflater.inflate(mTabLayoutId,
                    //mTabWidget, 
                    //false);
            //final TextView tv = (TextView) tabIndicator.findViewById(R.id.title);
            //tv.setText(mLabel);
            //if (context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT) {
                //tabIndicator.setBackgroundResource(R.drawable.tab_indicator_v4);
                //tv.setTextColor(context.getResources().getColorStateList(R.color.tab_indicator_text_v4));
            //}
            //return tabIndicator;
        }

        
    }


    
    private class LabelAndIconIndicatorStrategy implements IndicatorStrategy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

        private CharSequence mLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

        private Drawable mIcon;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_method = "A623A8042A1AC955C3AA9DCF282E65F2", hash_generated_method = "FE807DD5917584DB1910CFAB97FFD970")
        private  LabelAndIconIndicatorStrategy(CharSequence label, Drawable icon) {
            mLabel = label;
            mIcon = icon;
            // ---------- Original Method ----------
            //mLabel = label;
            //mIcon = icon;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.733 -0400", hash_original_method = "9B2F586B6F3639CDD79EFCA223D857D6", hash_generated_method = "6FC96C09C5841722EDA77F1F7325EAD3")
        public View createIndicatorView() {
            final Context context = getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View tabIndicator = inflater.inflate(mTabLayoutId,
                    mTabWidget, 
                    false);
            final TextView tv = (TextView) tabIndicator.findViewById(R.id.title);
            final ImageView iconView = (ImageView) tabIndicator.findViewById(R.id.icon);
            final boolean exclusive = iconView.getVisibility() == View.GONE;
            final boolean bindIcon = !exclusive || TextUtils.isEmpty(mLabel);
            tv.setText(mLabel);
            if(bindIcon && mIcon != null)            
            {
                iconView.setImageDrawable(mIcon);
                iconView.setVisibility(VISIBLE);
            } //End block
            if(context.getApplicationInfo().targetSdkVersion <= Build.VERSION_CODES.DONUT)            
            {
                tabIndicator.setBackgroundResource(R.drawable.tab_indicator_v4);
                tv.setTextColor(context.getResources().getColorStateList(R.color.tab_indicator_text_v4));
            } //End block
View var01EB2B982C218B50E10E237D1B17CF95_415436124 =             tabIndicator;
            var01EB2B982C218B50E10E237D1B17CF95_415436124.addTaint(taint);
            return var01EB2B982C218B50E10E237D1B17CF95_415436124;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class ViewIndicatorStrategy implements IndicatorStrategy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

        private View mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_method = "70774C2CF3D512F90368753CBBBC1864", hash_generated_method = "EDE3C0618D5B4758FB8E879A8598955F")
        private  ViewIndicatorStrategy(View view) {
            mView = view;
            // ---------- Original Method ----------
            //mView = view;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_method = "E81C3A0236D0948C1B54CB0897C263EB", hash_generated_method = "9CEE9DB1714DDD3C4C73C24BB765B89E")
        public View createIndicatorView() {
View var2A050D4EA4182130A6C1E6806618CCD0_2069998091 =             mView;
            var2A050D4EA4182130A6C1E6806618CCD0_2069998091.addTaint(taint);
            return var2A050D4EA4182130A6C1E6806618CCD0_2069998091;
            // ---------- Original Method ----------
            //return mView;
        }

        
    }


    
    private class ViewIdContentStrategy implements ContentStrategy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

        private View mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_method = "DD6B61194EE85E32120CD7630D172F73", hash_generated_method = "F846159176267F0C8722C267B7CE9015")
        private  ViewIdContentStrategy(int viewId) {
            mView = mTabContent.findViewById(viewId);
            if(mView != null)            
            {
                mView.setVisibility(View.GONE);
            } //End block
            else
            {
                RuntimeException var14C4B813E7CF01D911162B729C89DFCA_1703719327 = new RuntimeException("Could not create tab content because " +
                        "could not find view with id " + viewId);
                var14C4B813E7CF01D911162B729C89DFCA_1703719327.addTaint(taint);
                throw var14C4B813E7CF01D911162B729C89DFCA_1703719327;
            } //End block
            // ---------- Original Method ----------
            //mView = mTabContent.findViewById(viewId);
            //if (mView != null) {
                //mView.setVisibility(View.GONE);
            //} else {
                //throw new RuntimeException("Could not create tab content because " +
                        //"could not find view with id " + viewId);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_method = "FAF9C6C424D99CBF1D87945750D97718", hash_generated_method = "BFB46A9694306880BC521A0EB315F548")
        public View getContentView() {
            mView.setVisibility(View.VISIBLE);
View var2A050D4EA4182130A6C1E6806618CCD0_1875467908 =             mView;
            var2A050D4EA4182130A6C1E6806618CCD0_1875467908.addTaint(taint);
            return var2A050D4EA4182130A6C1E6806618CCD0_1875467908;
            // ---------- Original Method ----------
            //mView.setVisibility(View.VISIBLE);
            //return mView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_method = "1538BDA0E7D9A0DE19E0F5AE4CBE24FE", hash_generated_method = "116E4E15B96A554AEE4000FB89294B7A")
        public void tabClosed() {
            mView.setVisibility(View.GONE);
            // ---------- Original Method ----------
            //mView.setVisibility(View.GONE);
        }

        
    }


    
    private class FactoryContentStrategy implements ContentStrategy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_field = "A7F1EA497040BBFBF8BE2A90A6E0B6E4", hash_generated_field = "26B32329200530E6945EB791CCFA7B16")

        private View mTabContent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "90E823197545D5DE4C4A5E73822FE24E")

        private CharSequence mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.734 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "0AB71F610C660047CA6A684CD66A9872")

        private TabContentFactory mFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_method = "ADEE9FCDC20A1EAC6F11E73C35E4CE28", hash_generated_method = "A8E2CD4A1C77F30F180F465F0347A654")
        public  FactoryContentStrategy(CharSequence tag, TabContentFactory factory) {
            mTag = tag;
            mFactory = factory;
            // ---------- Original Method ----------
            //mTag = tag;
            //mFactory = factory;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_method = "ED11D1341C028F4F2DA686CA9100CB0F", hash_generated_method = "B87FE0596BCBF0ED5C97350E9563FD7C")
        public View getContentView() {
            if(mTabContent == null)            
            {
                mTabContent = mFactory.createTabContent(mTag.toString());
            } //End block
            mTabContent.setVisibility(View.VISIBLE);
View varB62F3AA3ED8906E8B6C427D442F6F39B_2057484906 =             mTabContent;
            varB62F3AA3ED8906E8B6C427D442F6F39B_2057484906.addTaint(taint);
            return varB62F3AA3ED8906E8B6C427D442F6F39B_2057484906;
            // ---------- Original Method ----------
            //if (mTabContent == null) {
                //mTabContent = mFactory.createTabContent(mTag.toString());
            //}
            //mTabContent.setVisibility(View.VISIBLE);
            //return mTabContent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_method = "F4CF7743D7975FC61814EFF15B52191C", hash_generated_method = "A6B6F41E27B96F885E5ACD81C8BD5D11")
        public void tabClosed() {
            mTabContent.setVisibility(View.GONE);
            // ---------- Original Method ----------
            //mTabContent.setVisibility(View.GONE);
        }

        
    }


    
    private class IntentContentStrategy implements ContentStrategy {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_field = "3FAD37ED8354BCCC7205B995A4E5D88D", hash_generated_field = "88756EAB8F8EDEB0E827033676248AB0")

        private View mLaunchedView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_method = "ED843E62CBFAC6E94798B5D03DF8D93E", hash_generated_method = "EE558715B969A8470C33B2F87416FE7A")
        private  IntentContentStrategy(String tag, Intent intent) {
            mTag = tag;
            mIntent = intent;
            // ---------- Original Method ----------
            //mTag = tag;
            //mIntent = intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.735 -0400", hash_original_method = "FE3CC83835F910E93083BF6BA67BB115", hash_generated_method = "8D6FA107B2D0D249DD0C139E49B9CF9D")
        public View getContentView() {
            if(mLocalActivityManager == null)            
            {
                IllegalStateException varEFCC8C65F690CEBB889ED8137D9312F8_167252400 = new IllegalStateException("Did you forget to call 'public void setup(LocalActivityManager activityGroup)'?");
                varEFCC8C65F690CEBB889ED8137D9312F8_167252400.addTaint(taint);
                throw varEFCC8C65F690CEBB889ED8137D9312F8_167252400;
            } //End block
            final Window w = mLocalActivityManager.startActivity(
                    mTag, mIntent);
            final View wd = w != null ? w.getDecorView() : null;
            if(mLaunchedView != wd && mLaunchedView != null)            
            {
                if(mLaunchedView.getParent() != null)                
                {
                    mTabContent.removeView(mLaunchedView);
                } //End block
            } //End block
            mLaunchedView = wd;
            if(mLaunchedView != null)            
            {
                mLaunchedView.setVisibility(View.VISIBLE);
                mLaunchedView.setFocusableInTouchMode(true);
                ((ViewGroup) mLaunchedView).setDescendantFocusability(
                        FOCUS_AFTER_DESCENDANTS);
            } //End block
View var4E470CFFB94CC98352E53CCF75906AE0_622721787 =             mLaunchedView;
            var4E470CFFB94CC98352E53CCF75906AE0_622721787.addTaint(taint);
            return var4E470CFFB94CC98352E53CCF75906AE0_622721787;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:05.736 -0400", hash_original_method = "94FBE3B8432975AC17E234FCD4A9B7F4", hash_generated_method = "E05336B7D19FAEDD0AD1353B8B3065D1")
        public void tabClosed() {
            if(mLaunchedView != null)            
            {
                mLaunchedView.setVisibility(View.GONE);
            } //End block
            // ---------- Original Method ----------
            //if (mLaunchedView != null) {
                //mLaunchedView.setVisibility(View.GONE);
            //}
        }

        
    }


    
    public interface OnTabChangeListener {
        void onTabChanged(String tabId);
    }
    
    public interface TabContentFactory {
        
        View createTabContent(String tag);
    }
    
    private static interface IndicatorStrategy {

        
        View createIndicatorView();
    }
    
    private static interface ContentStrategy {

        
        View getContentView();

        
        void tabClosed();
    }
    
}

