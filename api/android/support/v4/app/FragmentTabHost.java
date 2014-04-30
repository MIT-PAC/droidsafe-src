/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

/**
 * Special TabHost that allows the use of {@link Fragment} objects for
 * its tab content.  When placing this in a view hierarchy, after inflating
 * the hierarchy you must call {@link #setup(Context, FragmentManager, int)}
 * to complete the initialization of the tab host.
 *
 * <p>Here is a simple example of using a FragmentTabHost in an Activity:
 *
 * {@sample development/samples/Support4Demos/src/com/example/android/supportv4/app/FragmentTabs.java
 *      complete}
 *
 * <p>This can also be used inside of a fragment through fragment nesting:
 *
 * {@sample development/samples/Support4Demos/src/com/example/android/supportv4/app/FragmentTabsFragmentSupport.java
 *      complete}
 */
public class FragmentTabHost extends TabHost
        implements TabHost.OnTabChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.531 -0500", hash_original_field = "FC15725589282D8EC7156C0B2C370186", hash_generated_field = "7278E86B55ACC14CF749CE5DF3FB37EF")

    private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.532 -0500", hash_original_field = "A9C412F575B24137ED89EEAD9C33AA9D", hash_generated_field = "E72BBE4DE5EF0EEE1139F2110ABB439A")

    private FrameLayout mRealTabContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.534 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.536 -0500", hash_original_field = "0C27EED22F6A82BBBA86D53215B0BF17", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private FragmentManager mFragmentManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.539 -0500", hash_original_field = "2072CAADE2B3735D2B37FDBC10B7F08E", hash_generated_field = "87397C038C98DC289F650858B5AF34ED")

    private int mContainerId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.541 -0500", hash_original_field = "4CC2B9652DC16234E2B26C50B0E9F5C1", hash_generated_field = "AF064DEFB344B7ED4286326884A6DB9A")

    private TabHost.OnTabChangeListener mOnTabChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.543 -0500", hash_original_field = "8D22EE824A3EC1DB7B9829BE24032E61", hash_generated_field = "818D518CE7D8F0B4041594A72B767093")

    private TabInfo mLastTab;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.545 -0500", hash_original_field = "499E771B7750573A477FC07ED759E79C", hash_generated_field = "1232E3D42FB259E0D63C7FE3AEEB5801")

    private boolean mAttached;

    static final class TabInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.548 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "21B5B848D650825609ACDCB16F135AD3")

        private  String tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.551 -0500", hash_original_field = "5DC05358300615FC75CBDAB81601D87E", hash_generated_field = "8A86BAFC0FFC60C992D574AFC26D4F2E")

        private  Class<?> clss;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.555 -0500", hash_original_field = "CA610C0264353BD11E8E27AD6E5EE412", hash_generated_field = "1C89FF8BE4662D783606B596A25F549C")

        private  Bundle args;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.558 -0500", hash_original_field = "CC9B687FC89CACD9827C1873C7A34AB5", hash_generated_field = "AE5245DE43EC957A6625DF19B8ED79AD")

        private Fragment fragment;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.561 -0500", hash_original_method = "48C2D236163C0DF7CC7E99E7B011CB15", hash_generated_method = "48C2D236163C0DF7CC7E99E7B011CB15")
        
TabInfo(String _tag, Class<?> _class, Bundle _args) {
            tag = _tag;
            clss = _class;
            args = _args;
        }
    }

    static class DummyTabFactory implements TabHost.TabContentFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.565 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private  Context mContext;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.568 -0500", hash_original_method = "503EF87C7A3D1E177868D071C049B588", hash_generated_method = "2818B720E816FC572A7E1CAA8341D87C")
        
public DummyTabFactory(Context context) {
            mContext = context;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.570 -0500", hash_original_method = "970A9F84247A90102A17C68ED6E09878", hash_generated_method = "8CBEB65CD2B5564AFB6407BCAB699BE2")
        
@Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
    }

    static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.584 -0500", hash_original_field = "AD99978CDC5E698C2A4DD1DC3100EFC5", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:27.311 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:27.313 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.573 -0500", hash_original_field = "0BF87626034CBD42EC47C849802713F5", hash_generated_field = "0BF87626034CBD42EC47C849802713F5")

        String curTab;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.575 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "89EB4EC154F05BF905ECA8E02BBD14BC")
        
SavedState(Parcelable superState) {
            super(superState);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.576 -0500", hash_original_method = "AB7C9954D53F94F9085174F4490CBA05", hash_generated_method = "F3511B3B6291B72E43E2102A04E6B1A0")
        
private SavedState(Parcel in) {
            super(in);
            curTab = in.readString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.578 -0500", hash_original_method = "176F8DA37A35989F2146E2AD430FEF82", hash_generated_method = "1D5CC3A112040C968DC44BE970951CBD")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(curTab);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.579 -0500", hash_original_method = "60AEE9C632C71CE84A075D97F6C8EE8D", hash_generated_method = "46B0017B0C01F79E4DF35180BDE70C47")
        
@Override
        public String toString() {
            return "FragmentTabHost.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " curTab=" + curTab + "}";
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.589 -0500", hash_original_method = "62BE1A1BB2CD272E6608731E0EF5DED6", hash_generated_method = "C9BFC9FF4D8A6757123E071A3E8C2184")
    
public FragmentTabHost(Context context) {
        // Note that we call through to the version that takes an AttributeSet,
        // because the simple Context construct can result in a broken object!
        super(context, null);
        initFragmentTabHost(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.590 -0500", hash_original_method = "C58235E7C037C7EDF921B140B94EF8FB", hash_generated_method = "B8D66B6E3E915575A1F595BDCE032876")
    
public FragmentTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFragmentTabHost(context, attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.595 -0500", hash_original_method = "42AAEEAE9FF86FE2BEA81AB882DE4711", hash_generated_method = "19B79AD03627C382766951B27D2ACC47")
    
private void initFragmentTabHost(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                new int[] { android.R.attr.inflatedId }, 0, 0);
        mContainerId = a.getResourceId(0, 0);
        a.recycle();

        super.setOnTabChangedListener(this);

        // If owner hasn't made its own view hierarchy, then as a convenience
        // we will construct a standard one here.
        if (findViewById(android.R.id.tabs) == null) {
            LinearLayout ll = new LinearLayout(context);
            ll.setOrientation(LinearLayout.VERTICAL);
            addView(ll, new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.FILL_PARENT));

            TabWidget tw = new TabWidget(context);
            tw.setId(android.R.id.tabs);
            tw.setOrientation(TabWidget.HORIZONTAL);
            ll.addView(tw, new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0));

            FrameLayout fl = new FrameLayout(context);
            fl.setId(android.R.id.tabcontent);
            ll.addView(fl, new LinearLayout.LayoutParams(0, 0, 0));

            mRealTabContent = fl = new FrameLayout(context);
            mRealTabContent.setId(mContainerId);
            ll.addView(fl, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, 0, 1));
        }
    }

    /**
     * @deprecated Don't call the original TabHost setup, you must instead
     * call {@link #setup(Context, FragmentManager)} or
     * {@link #setup(Context, FragmentManager, int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.597 -0500", hash_original_method = "05C9957A4DCEFF7C41A9BE35BEB9A8D6", hash_generated_method = "47F51515FB37C21137DDBEA7BAA305DA")
    
@Override @Deprecated
    public void setup() {
        throw new IllegalStateException(
                "Must call setup() that takes a Context and FragmentManager");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.599 -0500", hash_original_method = "BEA87448A8F620CF25486462EAD40656", hash_generated_method = "ABEB5865C3DCE1D0BB87413C3D7D6E0D")
    
public void setup(Context context, FragmentManager manager) {
        super.setup();
        mContext = context;
        mFragmentManager = manager;
        ensureContent();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.601 -0500", hash_original_method = "8C2E5B314060B3DAC2CC3B33FD147996", hash_generated_method = "D8E2FB5A77788A3A3C126714F81A46A9")
    
public void setup(Context context, FragmentManager manager, int containerId) {
        super.setup();
        mContext = context;
        mFragmentManager = manager;
        mContainerId = containerId;
        ensureContent();
        mRealTabContent.setId(containerId);

        // We must have an ID to be able to save/restore our state.  If
        // the owner hasn't set one at this point, we will set it ourself.
        if (getId() == View.NO_ID) {
            setId(android.R.id.tabhost);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.603 -0500", hash_original_method = "E573AA9E8A82A5687D7AD5397977D367", hash_generated_method = "3D6F86187FCF93430D1385FDA3767286")
    
private void ensureContent() {
        if (mRealTabContent == null) {
            mRealTabContent = (FrameLayout)findViewById(mContainerId);
            if (mRealTabContent == null) {
                throw new IllegalStateException(
                        "No tab content FrameLayout found for id " + mContainerId);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.606 -0500", hash_original_method = "CAD2636558BA92FD3B25434077F437FA", hash_generated_method = "D9FF1584C7DD9E598DA7E29BE55236E0")
    
    @DSVerified("Callback registration")
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void setOnTabChangedListener(OnTabChangeListener l) {
        mOnTabChangeListener = l;
        if (l != null) {
            l.onTabChanged(new String());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.608 -0500", hash_original_method = "B272F2CD0D376DB45BFCD5A09F6A3201", hash_generated_method = "E66CEE54B1F0C4E663440E99701D8473")
    
public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args) {
        tabSpec.setContent(new DummyTabFactory(mContext));
        String tag = tabSpec.getTag();

        TabInfo info = new TabInfo(tag, clss, args);

        if (mAttached) {
            // If we are already attached to the window, then check to make
            // sure this tab's fragment is inactive if it exists.  This shouldn't
            // normally happen.
            info.fragment = mFragmentManager.findFragmentByTag(tag);
            if (info.fragment != null && !info.fragment.isDetached()) {
                FragmentTransaction ft = mFragmentManager.beginTransaction();
                ft.detach(info.fragment);
                ft.commit();
            }
        }

        mTabs.add(info);
        addTab(tabSpec);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.611 -0500", hash_original_method = "BB44C588C184374268714C6329B57A58", hash_generated_method = "81E8F6D9EBE28C65A965AC65DC6CBB29")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        String currentTab = getCurrentTabTag();

        // Go through all tabs and make sure their fragments match
        // the correct state.
        FragmentTransaction ft = null;
        for (int i=0; i<mTabs.size(); i++) {
            TabInfo tab = mTabs.get(i);
            tab.fragment = mFragmentManager.findFragmentByTag(tab.tag);
            if (tab.fragment != null && !tab.fragment.isDetached()) {
                if (tab.tag.equals(currentTab)) {
                    // The fragment for this tab is already there and
                    // active, and it is what we really want to have
                    // as the current tab.  Nothing to do.
                    mLastTab = tab;
                } else {
                    // This fragment was restored in the active state,
                    // but is not the current tab.  Deactivate it.
                    if (ft == null) {
                        ft = mFragmentManager.beginTransaction();
                    }
                    ft.detach(tab.fragment);
                }
            }
        }

        // We are now ready to go.  Make sure we are switched to the
        // correct tab.
        mAttached = true;
        ft = doTabChanged(currentTab, ft);
        if (ft != null) {
            ft.commit();
            mFragmentManager.executePendingTransactions();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.613 -0500", hash_original_method = "BB933237265996C32F40DAFA02CC0974", hash_generated_method = "3B9B1A6033CAEB32D2469255F165433C")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAttached = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.614 -0500", hash_original_method = "BC9DBC504CA8982190C3F187F9B9C6DC", hash_generated_method = "EE8C298E76C3579F41F8211E36B92A81")
    
@Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.curTab = getCurrentTabTag();
        return ss;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.616 -0500", hash_original_method = "B613B42AC24307866CE220AE6075D90A", hash_generated_method = "399DDC6E8789E47F174B69AC4F753D9E")
    
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCurrentTabByTag(ss.curTab);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.618 -0500", hash_original_method = "797307ED4EF363D106B23877320FB5E5", hash_generated_method = "3EDCB157F125CBBD5C7AFD23E4765316")
    
@Override
    public void onTabChanged(String tabId) {
        if (mAttached) {
            FragmentTransaction ft = doTabChanged(tabId, null);
            if (ft != null) {
                ft.commit();
            }
        }
        if (mOnTabChangeListener != null) {
            mOnTabChangeListener.onTabChanged(tabId);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:13.621 -0500", hash_original_method = "F57C18B3BB396717773B7D7B14EB3F45", hash_generated_method = "7431B2E81987B636A47FCD89C38872B9")
    
private FragmentTransaction doTabChanged(String tabId, FragmentTransaction ft) {
        TabInfo newTab = null;
        for (int i=0; i<mTabs.size(); i++) {
            TabInfo tab = mTabs.get(i);
            if (tab.tag.equals(tabId)) {
                newTab = tab;
            }
        }
        if (newTab == null) {
            throw new IllegalStateException("No tab known for tag " + tabId);
        }
        if (mLastTab != newTab) {
            if (ft == null) {
                ft = mFragmentManager.beginTransaction();
            }
            if (mLastTab != null) {
                if (mLastTab.fragment != null) {
                    ft.detach(mLastTab.fragment);
                }
            }
            if (newTab != null) {
                if (newTab.fragment == null) {
                    newTab.fragment = Fragment.instantiate(mContext,
                            newTab.clss.getName(), newTab.args);
                    ft.add(mContainerId, newTab.fragment, newTab.tag);
                } else {
                    ft.attach(newTab.fragment);
                }
            }

            mLastTab = newTab;
        }
        return ft;
    }
}
