package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "8A98D96AFDB493B0D3F4E3D64BFD83B1", hash_generated_field = "092F21E4BD139FC7E0A58B98625CDAD5")

    private ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "B0898F7C5B9DAD36C5DCE2CFCBA4E10F", hash_generated_field = "E72BBE4DE5EF0EEE1139F2110ABB439A")

    private FrameLayout mRealTabContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private FragmentManager mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "87397C038C98DC289F650858B5AF34ED")

    private int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "D55E0A212E5BEA43B1240B875AEBE97B", hash_generated_field = "AF064DEFB344B7ED4286326884A6DB9A")

    private TabHost.OnTabChangeListener mOnTabChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "5B2D96FF52130985D96C9B1762C52B46", hash_generated_field = "818D518CE7D8F0B4041594A72B767093")

    private TabInfo mLastTab;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.153 -0400", hash_original_field = "5FA0F8F73D793EE9F68BC9250D57B472", hash_generated_field = "1232E3D42FB259E0D63C7FE3AEEB5801")

    private boolean mAttached;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.154 -0400", hash_original_method = "62BE1A1BB2CD272E6608731E0EF5DED6", hash_generated_method = "48690794C079862D6CA37B23292788E5")
    public  FragmentTabHost(Context context) {
        super(context, null);
        initFragmentTabHost(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //initFragmentTabHost(context, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.154 -0400", hash_original_method = "C58235E7C037C7EDF921B140B94EF8FB", hash_generated_method = "74C9B3511347064FC618056B895E8B3B")
    public  FragmentTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFragmentTabHost(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //initFragmentTabHost(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.155 -0400", hash_original_method = "42AAEEAE9FF86FE2BEA81AB882DE4711", hash_generated_method = "1CFFB6F42D8F2BB8E7559E6256C5E4A5")
    private void initFragmentTabHost(Context context, AttributeSet attrs) {
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                new int[] { android.R.attr.inflatedId }, 0, 0);
        mContainerId = a.getResourceId(0, 0);
        a.recycle();
        super.setOnTabChangedListener(this);
        {
            boolean var2305B03C8B99EE7043E8AD669C3678A9_1486681874 = (findViewById(android.R.id.tabs) == null);
            {
                LinearLayout ll;
                ll = new LinearLayout(context);
                ll.setOrientation(LinearLayout.VERTICAL);
                addView(ll, new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.FILL_PARENT));
                TabWidget tw;
                tw = new TabWidget(context);
                tw.setId(android.R.id.tabs);
                tw.setOrientation(TabWidget.HORIZONTAL);
                ll.addView(tw, new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0));
                FrameLayout fl;
                fl = new FrameLayout(context);
                fl.setId(android.R.id.tabcontent);
                ll.addView(fl, new LinearLayout.LayoutParams(0, 0, 0));
                mRealTabContent = fl = new FrameLayout(context);
                mRealTabContent.setId(mContainerId);
                ll.addView(fl, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, 0, 1));
            } //End block
        } //End collapsed parenthetic
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.168 -0400", hash_original_method = "05C9957A4DCEFF7C41A9BE35BEB9A8D6", hash_generated_method = "445F17DD46555957AEB90B59504F4A9E")
    @Override
    @Deprecated
    public void setup() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                "Must call setup() that takes a Context and FragmentManager");
        // ---------- Original Method ----------
        //throw new IllegalStateException(
                //"Must call setup() that takes a Context and FragmentManager");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.169 -0400", hash_original_method = "BEA87448A8F620CF25486462EAD40656", hash_generated_method = "867E471760B39FCAFE99803532DEECB5")
    public void setup(Context context, FragmentManager manager) {
        super.setup();
        mContext = context;
        mFragmentManager = manager;
        ensureContent();
        // ---------- Original Method ----------
        //super.setup();
        //mContext = context;
        //mFragmentManager = manager;
        //ensureContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.170 -0400", hash_original_method = "8C2E5B314060B3DAC2CC3B33FD147996", hash_generated_method = "9570118CA04475C8A50A7471C0C7CDB9")
    public void setup(Context context, FragmentManager manager, int containerId) {
        super.setup();
        mContext = context;
        mFragmentManager = manager;
        mContainerId = containerId;
        ensureContent();
        mRealTabContent.setId(containerId);
        {
            boolean var94DE255413D29EB51E9F5A05501C98E8_578505768 = (getId() == View.NO_ID);
            {
                setId(android.R.id.tabhost);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.setup();
        //mContext = context;
        //mFragmentManager = manager;
        //mContainerId = containerId;
        //ensureContent();
        //mRealTabContent.setId(containerId);
        //if (getId() == View.NO_ID) {
            //setId(android.R.id.tabhost);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.171 -0400", hash_original_method = "E573AA9E8A82A5687D7AD5397977D367", hash_generated_method = "2D4D4658C57B4EAF37D6AD5170A10A6A")
    private void ensureContent() {
        {
            mRealTabContent = (FrameLayout)findViewById(mContainerId);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "No tab content FrameLayout found for id " + mContainerId);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mRealTabContent == null) {
            //mRealTabContent = (FrameLayout)findViewById(mContainerId);
            //if (mRealTabContent == null) {
                //throw new IllegalStateException(
                        //"No tab content FrameLayout found for id " + mContainerId);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.171 -0400", hash_original_method = "CAD2636558BA92FD3B25434077F437FA", hash_generated_method = "0D1D8D97A2BD8ED256400C3F2341E4A8")
    @Override
    public void setOnTabChangedListener(OnTabChangeListener l) {
        mOnTabChangeListener = l;
        // ---------- Original Method ----------
        //mOnTabChangeListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.188 -0400", hash_original_method = "B272F2CD0D376DB45BFCD5A09F6A3201", hash_generated_method = "3AC98DAA2D52340959C20B282A32A653")
    public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args) {
        tabSpec.setContent(new DummyTabFactory(mContext));
        String tag;
        tag = tabSpec.getTag();
        TabInfo info;
        info = new TabInfo(tag, clss, args);
        {
            info.fragment = mFragmentManager.findFragmentByTag(tag);
            {
                boolean varB4E6C168D4A034771625DEEED11671F4_604617777 = (info.fragment != null && !info.fragment.isDetached());
                {
                    FragmentTransaction ft;
                    ft = mFragmentManager.beginTransaction();
                    ft.detach(info.fragment);
                    ft.commit();
                } //End block
            } //End collapsed parenthetic
        } //End block
        mTabs.add(info);
        addTab(tabSpec);
        addTaint(tabSpec.getTaint());
        addTaint(clss.getTaint());
        addTaint(args.getTaint());
        // ---------- Original Method ----------
        //tabSpec.setContent(new DummyTabFactory(mContext));
        //String tag = tabSpec.getTag();
        //TabInfo info = new TabInfo(tag, clss, args);
        //if (mAttached) {
            //info.fragment = mFragmentManager.findFragmentByTag(tag);
            //if (info.fragment != null && !info.fragment.isDetached()) {
                //FragmentTransaction ft = mFragmentManager.beginTransaction();
                //ft.detach(info.fragment);
                //ft.commit();
            //}
        //}
        //mTabs.add(info);
        //addTab(tabSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.190 -0400", hash_original_method = "BB44C588C184374268714C6329B57A58", hash_generated_method = "F0B6988804F3C737FDC2FBA9BF5F2485")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        String currentTab;
        currentTab = getCurrentTabTag();
        FragmentTransaction ft;
        ft = null;
        {
            int i;
            i = 0;
            boolean var8571DB74C9B8AFE317FDCFB4B81CB6FB_678723326 = (i<mTabs.size());
            {
                TabInfo tab;
                tab = mTabs.get(i);
                tab.fragment = mFragmentManager.findFragmentByTag(tab.tag);
                {
                    boolean var90648159E6BCAF591DAC09D73CC52E47_2108123932 = (tab.fragment != null && !tab.fragment.isDetached());
                    {
                        {
                            boolean var4081D120129D480E59E50DEC260EC533_1857774545 = (tab.tag.equals(currentTab));
                            {
                                mLastTab = tab;
                            } //End block
                            {
                                {
                                    ft = mFragmentManager.beginTransaction();
                                } //End block
                                ft.detach(tab.fragment);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mAttached = true;
        ft = doTabChanged(currentTab, ft);
        {
            ft.commit();
            mFragmentManager.executePendingTransactions();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.197 -0400", hash_original_method = "BB933237265996C32F40DAFA02CC0974", hash_generated_method = "B5F139BD8B0657B98B5C88139B35CEDD")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        mAttached = false;
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //mAttached = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.198 -0400", hash_original_method = "BC9DBC504CA8982190C3F187F9B9C6DC", hash_generated_method = "32DF4F1ACFD314433C7ABF6CA1199C7A")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_773872017 = null; //Variable for return #1
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState ss;
        ss = new SavedState(superState);
        ss.curTab = getCurrentTabTag();
        varB4EAC82CA7396A68D541C85D26508E83_773872017 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_773872017.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_773872017;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.curTab = getCurrentTabTag();
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.199 -0400", hash_original_method = "B613B42AC24307866CE220AE6075D90A", hash_generated_method = "D56989F7EC2B4AB3A37C318FFD8EB406")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SavedState ss;
        ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCurrentTabByTag(ss.curTab);
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //SavedState ss = (SavedState)state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setCurrentTabByTag(ss.curTab);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.199 -0400", hash_original_method = "797307ED4EF363D106B23877320FB5E5", hash_generated_method = "7EFC6801755DF37753DDFF4E2532EF5A")
    @Override
    public void onTabChanged(String tabId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            FragmentTransaction ft;
            ft = doTabChanged(tabId, null);
            {
                ft.commit();
            } //End block
        } //End block
        {
            mOnTabChangeListener.onTabChanged(tabId);
        } //End block
        addTaint(tabId.getTaint());
        // ---------- Original Method ----------
        //if (mAttached) {
            //FragmentTransaction ft = doTabChanged(tabId, null);
            //if (ft != null) {
                //ft.commit();
            //}
        //}
        //if (mOnTabChangeListener != null) {
            //mOnTabChangeListener.onTabChanged(tabId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.215 -0400", hash_original_method = "F57C18B3BB396717773B7D7B14EB3F45", hash_generated_method = "4526BA78015C2C13D8131D893F969F1A")
    private FragmentTransaction doTabChanged(String tabId, FragmentTransaction ft) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_765885483 = null; //Variable for return #1
        TabInfo newTab;
        newTab = null;
        {
            int i;
            i = 0;
            boolean var8571DB74C9B8AFE317FDCFB4B81CB6FB_416671667 = (i<mTabs.size());
            {
                TabInfo tab;
                tab = mTabs.get(i);
                {
                    boolean var42B6B5C6CF7E136D3626D6532F3A2D64_1183458908 = (tab.tag.equals(tabId));
                    {
                        newTab = tab;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No tab known for tag " + tabId);
        } //End block
        {
            {
                ft = mFragmentManager.beginTransaction();
            } //End block
            {
                {
                    ft.detach(mLastTab.fragment);
                } //End block
            } //End block
            {
                {
                    newTab.fragment = Fragment.instantiate(mContext,
                            newTab.clss.getName(), newTab.args);
                    ft.add(mContainerId, newTab.fragment, newTab.tag);
                } //End block
                {
                    ft.attach(newTab.fragment);
                } //End block
            } //End block
            mLastTab = newTab;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_765885483 = ft;
        addTaint(tabId.getTaint());
        addTaint(ft.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_765885483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_765885483;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static final class TabInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.215 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

        private String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.215 -0400", hash_original_field = "5E31E9D2BD20EA1B5372BB5D404297C9", hash_generated_field = "8A86BAFC0FFC60C992D574AFC26D4F2E")

        private Class<?> clss;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.215 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "1C89FF8BE4662D783606B596A25F549C")

        private Bundle args;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.215 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "AE5245DE43EC957A6625DF19B8ED79AD")

        private Fragment fragment;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.217 -0400", hash_original_method = "48C2D236163C0DF7CC7E99E7B011CB15", hash_generated_method = "9C18385D948D65D9F26A03762F05F9F5")
          TabInfo(String _tag, Class<?> _class, Bundle _args) {
            tag = _tag;
            clss = _class;
            args = _args;
            // ---------- Original Method ----------
            //tag = _tag;
            //clss = _class;
            //args = _args;
        }

        
    }


    
    static class DummyTabFactory implements TabHost.TabContentFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.217 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.217 -0400", hash_original_method = "503EF87C7A3D1E177868D071C049B588", hash_generated_method = "9C4D885266140A7C5A9D8DE6C49C82A5")
        public  DummyTabFactory(Context context) {
            mContext = context;
            // ---------- Original Method ----------
            //mContext = context;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.232 -0400", hash_original_method = "970A9F84247A90102A17C68ED6E09878", hash_generated_method = "99C54FBBEBC59438441D65EBFFE9EA89")
        @Override
        public View createTabContent(String tag) {
            View varB4EAC82CA7396A68D541C85D26508E83_79036437 = null; //Variable for return #1
            View v;
            v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            varB4EAC82CA7396A68D541C85D26508E83_79036437 = v;
            addTaint(tag.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_79036437.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_79036437;
            // ---------- Original Method ----------
            //View v = new View(mContext);
            //v.setMinimumWidth(0);
            //v.setMinimumHeight(0);
            //return v;
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.232 -0400", hash_original_field = "51D752CC81360C8E0A95D8B35A6AC95D", hash_generated_field = "0BF87626034CBD42EC47C849802713F5")

        String curTab;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.233 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.234 -0400", hash_original_method = "AB7C9954D53F94F9085174F4490CBA05", hash_generated_method = "1A37BEA355DC682E9D473581632A6BD7")
        private  SavedState(Parcel in) {
            super(in);
            curTab = in.readString();
            // ---------- Original Method ----------
            //curTab = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.234 -0400", hash_original_method = "176F8DA37A35989F2146E2AD430FEF82", hash_generated_method = "0D73A212E76195345406621FE6FBB04E")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(curTab);
            addTaint(out.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeString(curTab);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.247 -0400", hash_original_method = "60AEE9C632C71CE84A075D97F6C8EE8D", hash_generated_method = "7DF72172E3674CC6AA36E4EAB87FA17F")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_451503580 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_451503580 = "FragmentTabHost.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " curTab=" + curTab + "}";
            varB4EAC82CA7396A68D541C85D26508E83_451503580.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_451503580;
            // ---------- Original Method ----------
            //return "FragmentTabHost.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " curTab=" + curTab + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.247 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
}

