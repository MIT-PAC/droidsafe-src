/*
 * Copyright (C) 2011 The Android Open Source Project
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
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Base class for activities that want to use the support-based
 * {@link android.support.v4.app.Fragment} and
 * {@link android.support.v4.content.Loader} APIs.
 *
 * <p>When using this class as opposed to new platform's built-in fragment
 * and loader support, you must use the {@link #getSupportFragmentManager()}
 * and {@link #getSupportLoaderManager()} methods respectively to access
 * those features.
 *
 * <p class="note"><strong>Note:</strong> If you want to implement an activity that includes
 * an <a href="{@docRoot}guide/topics/ui/actionbar.html">action bar</a>, you should instead use
 * the {@link android.support.v7.app.ActionBarActivity} class, which is a subclass of this one,
 * so allows you to use {@link android.support.v4.app.Fragment} APIs on API level 7 and higher.</p>
 *
 * <p>Known limitations:</p>
 * <ul>
 * <li> <p>When using the <code>&lt;fragment></code> tag, this implementation can not
 * use the parent view's ID as the new fragment's ID.  You must explicitly
 * specify an ID (or tag) in the <code>&lt;fragment></code>.</p>
 * <li> <p>Prior to Honeycomb (3.0), an activity's state was saved before pausing.
 * Fragments are a significant amount of new state, and dynamic enough that one
 * often wants them to change between pausing and stopping.  These classes
 * throw an exception if you try to change the fragment state after it has been
 * saved, to avoid accidental loss of UI state.  However this is too restrictive
 * prior to Honeycomb, where the state is saved before pausing.  To address this,
 * when running on platforms prior to Honeycomb an exception will not be thrown
 * if you change fragments between the state save and the activity being stopped.
 * This means that in some cases if the activity is restored from its last saved
 * state, this may be a snapshot slightly before what the user last saw.</p>
 * </ul>
 */
public class FragmentActivity extends Activity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.766 -0400", hash_original_field = "58B9F4E1E96DA66D6280C812FCABE83B", hash_generated_field = "C05D29547F0FF3FBBC06D3D9747B009C")

    private static final String TAG = "FragmentActivity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.777 -0400", hash_original_field = "2AF235EEED0492E0CB0E7DE85B56C523", hash_generated_field = "1476D3F2166208C74AB619F6216B021B")

    
    static final String FRAGMENTS_TAG = "android:support:fragments";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.786 -0400", hash_original_field = "96C0E1C589D3827CD74FAEAD9361F1E8", hash_generated_field = "9B5590C251929187BF81DBAD4FF353CC")

    private static final int HONEYCOMB = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.794 -0400", hash_original_field = "EAAFB98425DBE846CB8FBA82BAAF6325", hash_generated_field = "3858BC703C64AB39E77D6A854C205B10")


    static final int MSG_REALLY_STOPPED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.802 -0400", hash_original_field = "28C9C9C3A034C36DDBDED7A2C6A353CA", hash_generated_field = "85BC97DB38BAD7BD3198C330C85F8A73")

    static final int MSG_RESUME_PENDING = 2;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.306 -0400", hash_original_method = "3274893E9C9F22CAC70DF93D680DD8B1", hash_generated_method = "CF399103EB831757AC957B278C4C83D7")
    
private static String viewToString(View view) {
        StringBuilder out = new StringBuilder(128);
        out.append(view.getClass().getName());
        out.append('{');
        out.append(Integer.toHexString(System.identityHashCode(view)));
        out.append(' ');
        switch (view.getVisibility()) {
            case View.VISIBLE: out.append('V'); break;
            case View.INVISIBLE: out.append('I'); break;
            case View.GONE: out.append('G'); break;
            default: out.append('.'); break;
        }
        out.append(view.isFocusable() ? 'F' : '.');
        out.append(view.isEnabled() ? 'E' : '.');
        out.append(view.willNotDraw() ? '.' : 'D');
        out.append(view.isHorizontalScrollBarEnabled()? 'H' : '.');
        out.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        out.append(view.isClickable() ? 'C' : '.');
        out.append(view.isLongClickable() ? 'L' : '.');
        out.append(' ');
        out.append(view.isFocused() ? 'F' : '.');
        out.append(view.isSelected() ? 'S' : '.');
        out.append(view.isPressed() ? 'P' : '.');
        out.append(' ');
        out.append(view.getLeft());
        out.append(',');
        out.append(view.getTop());
        out.append('-');
        out.append(view.getRight());
        out.append(',');
        out.append(view.getBottom());
        final int id = view.getId();
        if (id != View.NO_ID) {
            out.append(" #");
            out.append(Integer.toHexString(id));
            final Resources r = view.getResources();
            if (id != 0 && r != null) {
                try {
                    String pkgname;
                    switch (id&0xff000000) {
                        case 0x7f000000:
                            pkgname="app";
                            break;
                        case 0x01000000:
                            pkgname="android";
                            break;
                        default:
                            pkgname = r.getResourcePackageName(id);
                            break;
                    }
                    String typename = r.getResourceTypeName(id);
                    String entryname = r.getResourceEntryName(id);
                    out.append(" ");
                    out.append(pkgname);
                    out.append(":");
                    out.append(typename);
                    out.append("/");
                    out.append(entryname);
                } catch (Resources.NotFoundException e) {
                }
            }
        }
        out.append("}");
        return out.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.843 -0400", hash_original_field = "B6CF24EA10173E0BC85E43BB41A9FCDE", hash_generated_field = "BECA490C14B3A85E8F6656B501E4FB1A")


    final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_REALLY_STOPPED:
                    if (mStopped) {
                        doReallyStop(false);
                    }
                    break;
                case MSG_RESUME_PENDING:
                    onResumeFragments();
                    mFragments.execPendingActions();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.852 -0400", hash_original_field = "770A646DB3FFD5D268F1207A9B6648B8", hash_generated_field = "694874072698409F6608B46B5D5A3DE1")

    final FragmentManagerImpl mFragments = new FragmentManagerImpl();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.873 -0400", hash_original_field = "5FCD3FCB0C48EC9F428EAE9789E56596", hash_generated_field = "19B31D6A5D2DDF3AAD759FDDD8EE70CE")

    final FragmentContainer mContainer = new FragmentContainer() {
        @Override
        public View findViewById(int id) {
            return FragmentActivity.this.findViewById(id);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.880 -0400", hash_original_field = "271824B07358893C73D20BA1540862F9", hash_generated_field = "271824B07358893C73D20BA1540862F9")

    
    boolean mCreated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.886 -0400", hash_original_field = "23D2434AD22548E124B62AB7739838E9", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.894 -0400", hash_original_field = "C703FF92314B1EE9638F5EE77CD641D7", hash_generated_field = "C703FF92314B1EE9638F5EE77CD641D7")

    boolean mStopped;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.901 -0400", hash_original_field = "747FF298A79A7C3192A681D678D25FE6", hash_generated_field = "747FF298A79A7C3192A681D678D25FE6")

    boolean mReallyStopped;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.907 -0400", hash_original_field = "9B9EA230363F2EF227C5BE272DCC6838", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.915 -0400", hash_original_field = "DB8D4CEB8A7AAD8A9737A3EEEA202045", hash_generated_field = "DB8D4CEB8A7AAD8A9737A3EEEA202045")


    boolean mOptionsMenuInvalidated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.922 -0400", hash_original_field = "93A369593E1CC22C7DE8D4D5C675B065", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")


    boolean mCheckedForLoaderManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.930 -0400", hash_original_field = "D357ECA56BF47F1751443279339D50DF", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.938 -0400", hash_original_field = "2D0CD0A16ADD5E9C3F3AC0483AC37718", hash_generated_field = "2D0CD0A16ADD5E9C3F3AC0483AC37718")

    SimpleArrayMap<String, LoaderManagerImpl> mAllLoaderManagers;

    static final class NonConfigurationInstances {
        Object activity;
        Object custom;
        SimpleArrayMap<String, Object> children;
        ArrayList<Fragment> fragments;
        SimpleArrayMap<String, LoaderManagerImpl> loaders;
    }
    
    static class FragmentTag {
        public static final int[] Fragment = {
            0x01010003, 0x010100d0, 0x010100d1
        };
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:26.946 -0400", hash_original_field = "6EE478DF5473556475C8D09C185A01BC", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    
    // ------------------------------------------------------------------------
    // HOOKS INTO ACTIVITY
    // ------------------------------------------------------------------------
    
    /**
     * Dispatch incoming result to the correct fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.054 -0400", hash_original_method = "AE8D2F77597464B24506681CBB435A18", hash_generated_method = "F96AA07650E84FF2DD96427AE369120F")
    
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mFragments.noteStateNotSaved();
        int index = requestCode>>16;
        if (index != 0) {
            index--;
            if (mFragments.mActive == null || index < 0 || index >= mFragments.mActive.size()) {
                Log.w(TAG, "Activity result fragment index out of range: 0x"
                        + Integer.toHexString(requestCode));
                return;
            }
            Fragment frag = mFragments.mActive.get(index);
            if (frag == null) {
                Log.w(TAG, "Activity result no fragment exists for index: 0x"
                        + Integer.toHexString(requestCode));
            } else {
                frag.onActivityResult(requestCode&0xffff, resultCode, data);
            }
            return;
        }
        
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.063 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "CF5708D46158611B2F85B74F95385050")
    
public void onBackPressed() {
        if (!mFragments.popBackStackImmediate()) {
            finish();
        }
    }

    /**
     * Dispatch configuration change to all fragments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.071 -0400", hash_original_method = "55FDC064636609C07EA6D352B59B7C90", hash_generated_method = "76BDF28D6E929F021A1122FAA7735C20")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mFragments.dispatchConfigurationChanged(newConfig);
    }

    /**
     * Perform initialization of all fragments and loaders.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.083 -0400", hash_original_method = "C455F2D927ADC92D1A4791D782C4857A", hash_generated_method = "37BBEA285A8084C4915C89DE4C0CCC39")
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        mFragments.attachActivity(this, mContainer, null);
        // Old versions of the platform didn't do this!
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        
        super.onCreate(savedInstanceState);
        
        NonConfigurationInstances nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
        if (nc != null) {
            mAllLoaderManagers = nc.loaders;
        }
        if (savedInstanceState != null) {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, nc != null ? nc.fragments : null);
        }
        mFragments.dispatchCreate();
    }

    /**
     * Dispatch to Fragment.onCreateOptionsMenu().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.094 -0400", hash_original_method = "7F7FAA4BD379FD5B7B024567C1869B85", hash_generated_method = "13CF782AFB733F50D45620274C50E190")
    
@Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            boolean show = super.onCreatePanelMenu(featureId, menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            if (android.os.Build.VERSION.SDK_INT >= HONEYCOMB) {
                return show;
            }
            // Prior to Honeycomb, the framework can't invalidate the options
            // menu, so we must always say we have one in case the app later
            // invalidates it and needs to have it shown.
            return true;
        }
        return super.onCreatePanelMenu(featureId, menu);
    }
    
    /**
     * Add support for inflating the &lt;fragment> tag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.125 -0400", hash_original_method = "17F38949B7A4A56647BD97EEE6C9AAD8", hash_generated_method = "CC32EABA9B6FF3719BCE49104F003BF5")
    
@Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        if (!"fragment".equals(name)) {
            return super.onCreateView(name, context, attrs);
        }
        
        String fname = attrs.getAttributeValue(null, "class");
        TypedArray a =  context.obtainStyledAttributes(attrs, FragmentTag.Fragment);
        if (fname == null) {
            fname = a.getString(FragmentTag.Fragment_name);
        }
        int id = a.getResourceId(FragmentTag.Fragment_id, View.NO_ID);
        String tag = a.getString(FragmentTag.Fragment_tag);
        a.recycle();

        if (!Fragment.isSupportFragmentClass(this, fname)) {
            // Invalid support lib fragment; let the device's framework handle it.
            // This will allow android.app.Fragments to do the right thing.
            return super.onCreateView(name, context, attrs);
        }
        
        View parent = null; // NOTE: no way to get parent pre-Honeycomb.
        int containerId = parent != null ? parent.getId() : 0;
        if (containerId == View.NO_ID && id == View.NO_ID && tag == null) {
            throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
        }

        // If we restored from a previous state, we may already have
        // instantiated this fragment from the state and should use
        // that instance instead of making a new one.
        Fragment fragment = id != View.NO_ID ? mFragments.findFragmentById(id) : null;
        if (fragment == null && tag != null) {
            fragment = mFragments.findFragmentByTag(tag);
        }
        if (fragment == null && containerId != View.NO_ID) {
            fragment = mFragments.findFragmentById(containerId);
        }

        if (FragmentManagerImpl.DEBUG) Log.v(TAG, "onCreateView: id=0x"
                + Integer.toHexString(id) + " fname=" + fname
                + " existing=" + fragment);
        if (fragment == null) {
            fragment = Fragment.instantiate(this, fname);
            fragment.mFromLayout = true;
            fragment.mFragmentId = id != 0 ? id : containerId;
            fragment.mContainerId = containerId;
            fragment.mTag = tag;
            fragment.mInLayout = true;
            fragment.mFragmentManager = mFragments;
            fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            mFragments.addFragment(fragment, true);

        } else if (fragment.mInLayout) {
            // A fragment already exists and it is not one we restored from
            // previous state.
            throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Duplicate id 0x" + Integer.toHexString(id)
                    + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId)
                    + " with another fragment for " + fname);
        } else {
            // This fragment was retained from a previous instance; get it
            // going now.
            fragment.mInLayout = true;
            // If this fragment is newly instantiated (either right now, or
            // from last saved state), then give it the attributes to
            // initialize itself.
            if (!fragment.mRetaining) {
                fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            }
            mFragments.moveToState(fragment);
        }

        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + fname
                    + " did not create a view.");
        }
        if (id != 0) {
            fragment.mView.setId(id);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(tag);
        }
        return fragment.mView;
    }

    /**
     * Destroy all fragments and loaders.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.134 -0400", hash_original_method = "81DE240BA78D06EF3CA4E4150F572C81", hash_generated_method = "808CF2626AF6DCC1C8634FF7BB4FDEE1")
    
@Override
    protected void onDestroy() {
        super.onDestroy();

        doReallyStop(false);

        mFragments.dispatchDestroy();
        if (mLoaderManager != null) {
            mLoaderManager.doDestroy();
        }
    }

    /**
     * Take care of calling onBackPressed() for pre-Eclair platforms.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.146 -0400", hash_original_method = "9885A8D8E166C211280B71A198245DDA", hash_generated_method = "E8C178F9BC4F744C815BC004DC198F2A")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (android.os.Build.VERSION.SDK_INT < 5 /* ECLAIR */
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            // Take care of calling this method on earlier versions of
            // the platform where it doesn't exist.
            onBackPressed();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * Dispatch onLowMemory() to all fragments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.154 -0400", hash_original_method = "5060399A61D97F30C880AACCBE3D1906", hash_generated_method = "DBB8A84F8043B0C98655B4E0475841C9")
    
@Override
    public void onLowMemory() {
        super.onLowMemory();
        mFragments.dispatchLowMemory();
    }

    /**
     * Dispatch context and options menu to fragments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.163 -0400", hash_original_method = "07B1A6CC471050623DC993725853B976", hash_generated_method = "530F671A3A990FD3917307868BC0297B")
    
@Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        
        switch (featureId) {
            case Window.FEATURE_OPTIONS_PANEL:
                return mFragments.dispatchOptionsItemSelected(item);
                
            case Window.FEATURE_CONTEXT_MENU:
                return mFragments.dispatchContextItemSelected(item);

            default:
                return false;
        }
    }

    /**
     * Call onOptionsMenuClosed() on fragments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.171 -0400", hash_original_method = "B1F57A749E35030E5CB8EAB506D19441", hash_generated_method = "620193A6AA3E0D720E2B0FB228FA1084")
    
@Override
    public void onPanelClosed(int featureId, Menu menu) {
        switch (featureId) {
            case Window.FEATURE_OPTIONS_PANEL:
                mFragments.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(featureId, menu);
    }
    
    /**
     * Dispatch onPause() to fragments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.180 -0400", hash_original_method = "EBBC480BA94BD3D79D683AB555C9F857", hash_generated_method = "CBF7C94BC9CFD995420B236C0E481D7C")
    
@Override
    protected void onPause() {
        super.onPause();
        mResumed = false;
        if (mHandler.hasMessages(MSG_RESUME_PENDING)) {
            mHandler.removeMessages(MSG_RESUME_PENDING);
            onResumeFragments();
        }
        mFragments.dispatchPause();
    }

    /**
     * Handle onNewIntent() to inform the fragment manager that the
     * state is not saved.  If you are handling new intents and may be
     * making changes to the fragment state, you want to be sure to call
     * through to the super-class here first.  Otherwise, if your state
     * is saved but the activity is not stopped, you could get an
     * onNewIntent() call which happens before onResume() and trying to
     * perform fragment operations at that point will throw IllegalStateException
     * because the fragment manager thinks the state is still saved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.187 -0400", hash_original_method = "22DD6D11219C23D125AE29FC1331896B", hash_generated_method = "53E5B217C7BAF31B412612C6A27C6C3C")
    
@Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mFragments.noteStateNotSaved();
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.195 -0400", hash_original_method = "3FCB5D73B297020DDBEAF38F4A9C2458", hash_generated_method = "EBD9DE655F7E270E45122113F3A44AEA")
    
@Override
    protected void onResume() {
        super.onResume();
        mHandler.sendEmptyMessage(MSG_RESUME_PENDING);
        mResumed = true;
        mFragments.execPendingActions();
    }

    /**
     * Dispatch onResume() to fragments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.202 -0400", hash_original_method = "6B2BC88BC45E8448086501D1DCC5CA8F", hash_generated_method = "68332A465763AA2B520D839C0EAB3025")
    
@Override
    protected void onPostResume() {
        super.onPostResume();
        mHandler.removeMessages(MSG_RESUME_PENDING);
        onResumeFragments();
        mFragments.execPendingActions();
    }

    /**
     * This is the fragment-orientated version of {@link #onResume()} that you
     * can override to perform operations in the Activity at the same point
     * where its fragments are resumed.  Be sure to always call through to
     * the super-class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.208 -0400", hash_original_method = "571F1484F02501E8599B33312B988FBD", hash_generated_method = "7B7758434599706A4943A71A2355767C")
    
protected void onResumeFragments() {
        mFragments.dispatchResume();
    }

    /**
     * Dispatch onPrepareOptionsMenu() to fragments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.217 -0400", hash_original_method = "8752F68D48E0E30171A3505F074FD7CA", hash_generated_method = "DF020307F5580C93864A55F8DCFB6283")
    
@Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            if (mOptionsMenuInvalidated) {
                mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(featureId, menu);
            }
            boolean goforit = onPrepareOptionsPanel(view, menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            return goforit;
        }
        return super.onPreparePanel(featureId, view, menu);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.225 -0400", hash_original_method = "EEA7C88B5ECEA90DEF8DDF72CC395A60", hash_generated_method = "3175417E6133C2CAFA94BAEAE945513A")
    
protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(Window.FEATURE_OPTIONS_PANEL, view, menu);
    }

    /**
     * Retain all appropriate fragment and loader state.  You can NOT
     * override this yourself!  Use {@link #onRetainCustomNonConfigurationInstance()}
     * if you want to retain your own state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.236 -0400", hash_original_method = "F5AD0FD471F029F48A575488BAAF9E63", hash_generated_method = "574CE013B6FFBCFC7A16675B40226EB1")
    
@Override
    public final Object onRetainNonConfigurationInstance() {
        if (mStopped) {
            doReallyStop(true);
        }

        Object custom = onRetainCustomNonConfigurationInstance();

        ArrayList<Fragment> fragments = mFragments.retainNonConfig();
        boolean retainLoaders = false;
        if (mAllLoaderManagers != null) {
            // prune out any loader managers that were already stopped and so
            // have nothing useful to retain.
            final int N = mAllLoaderManagers.size();
            LoaderManagerImpl loaders[] = new LoaderManagerImpl[N];
            for (int i=N-1; i>=0; i--) {
                loaders[i] = mAllLoaderManagers.valueAt(i);
            }
            for (int i=0; i<N; i++) {
                LoaderManagerImpl lm = loaders[i];
                if (lm.mRetaining) {
                    retainLoaders = true;
                } else {
                    lm.doDestroy();
                    mAllLoaderManagers.remove(lm.mWho);
                }
            }
        }
        if (fragments == null && !retainLoaders && custom == null) {
            return null;
        }
        
        NonConfigurationInstances nci = new NonConfigurationInstances();
        nci.activity = null;
        nci.custom = custom;
        nci.children = null;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
        return nci;
    }

    /**
     * Save all appropriate fragment state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.244 -0400", hash_original_method = "C79CD565EF7D4DAA3E1BC7711F48F8E1", hash_generated_method = "2E6E2F5F57A21F8DEC19DF3B846B8726")
    
@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Parcelable p = mFragments.saveAllState();
        if (p != null) {
            outState.putParcelable(FRAGMENTS_TAG, p);
        }
    }

    /**
     * Dispatch onStart() to all fragments.  Ensure any created loaders are
     * now started.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.254 -0400", hash_original_method = "37CE581611F46DA12123359EFF80059E", hash_generated_method = "DE6BE77CB4B024DF69719EA7CFFDFE7E")
    
@Override
    protected void onStart() {
        super.onStart();

        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(MSG_REALLY_STOPPED);

        if (!mCreated) {
            mCreated = true;
            mFragments.dispatchActivityCreated();
        }

        mFragments.noteStateNotSaved();
        mFragments.execPendingActions();
        
        if (!mLoadersStarted) {
            mLoadersStarted = true;
            if (mLoaderManager != null) {
                mLoaderManager.doStart();
            } else if (!mCheckedForLoaderManager) {
                mLoaderManager = getLoaderManager("(root)", mLoadersStarted, false);
                // the returned loader manager may be a new one, so we have to start it
                if ((mLoaderManager != null) && (!mLoaderManager.mStarted)) {
                    mLoaderManager.doStart();
                }
            }
            mCheckedForLoaderManager = true;
        }
        // NOTE: HC onStart goes here.
        
        mFragments.dispatchStart();
        if (mAllLoaderManagers != null) {
            final int N = mAllLoaderManagers.size();
            LoaderManagerImpl loaders[] = new LoaderManagerImpl[N];
            for (int i=N-1; i>=0; i--) {
                loaders[i] = mAllLoaderManagers.valueAt(i);
            }
            for (int i=0; i<N; i++) {
                LoaderManagerImpl lm = loaders[i];
                lm.finishRetain();
                lm.doReportStart();
            }
        }
    }

    /**
     * Dispatch onStop() to all fragments.  Ensure all loaders are stopped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.262 -0400", hash_original_method = "F60F215A385D287752751758F3F3D1D2", hash_generated_method = "FDEC7156FC09FAF744D2194CB181DF6D")
    
@Override
    protected void onStop() {
        super.onStop();

        mStopped = true;
        mHandler.sendEmptyMessage(MSG_REALLY_STOPPED);
        
        mFragments.dispatchStop();
    }

    // ------------------------------------------------------------------------
    // NEW METHODS
    // ------------------------------------------------------------------------
    
    /**
     * Use this instead of {@link #onRetainNonConfigurationInstance()}.
     * Retrieve later with {@link #getLastCustomNonConfigurationInstance()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.268 -0400", hash_original_method = "F55A4C6A01F3D0AB15650B3080E9EF76", hash_generated_method = "ED3655B6F542816CCC0E0842D7F40916")
    
public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /**
     * Return the value previously returned from
     * {@link #onRetainCustomNonConfigurationInstance()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.275 -0400", hash_original_method = "350BC71A71D255050EA53218D39061A7", hash_generated_method = "42962F67ED40C598C3F1E6BC405681FE")
    
public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
        return nc != null ? nc.custom : null;
    }

    /**
     * Support library version of {@link Activity#invalidateOptionsMenu}.
     *
     * <p>Invalidate the activity's options menu. This will cause relevant presentations
     * of the menu to fully update via calls to onCreateOptionsMenu and
     * onPrepareOptionsMenu the next time the menu is requested.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.283 -0400", hash_original_method = "9AD1865EB184E07C9164FA8858758524", hash_generated_method = "65EE9AE13852D2235D9D2C15ABF8F320")
    
public void supportInvalidateOptionsMenu() {
        if (android.os.Build.VERSION.SDK_INT >= HONEYCOMB) {
            // If we are running on HC or greater, we can use the framework
            // API to invalidate the options menu.
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
            return;
        }

        // Whoops, older platform...  we'll use a hack, to manually rebuild
        // the options menu the next time it is prepared.
        mOptionsMenuInvalidated = true;
    }

    /**
     * Print the Activity's state into the given stream.  This gets invoked if
     * you run "adb shell dumpsys activity <activity_component_name>".
     *
     * @param prefix Desired prefix to prepend at each line of output.
     * @param fd The raw file descriptor that the dump is being sent to.
     * @param writer The PrintWriter to which you should dump your state.  This will be
     * closed for you after you return.
     * @param args additional arguments to the dump request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.293 -0400", hash_original_method = "793A438044EEB54318015A62231AC042", hash_generated_method = "7DE5CD94519222AFEEE75BA864A79CC0")
    
public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (android.os.Build.VERSION.SDK_INT >= HONEYCOMB) {
            // XXX This can only work if we can call the super-class impl. :/
            //ActivityCompatHoneycomb.dump(this, prefix, fd, writer, args);
        }
        writer.print(prefix); writer.print("Local FragmentActivity ");
                writer.print(Integer.toHexString(System.identityHashCode(this)));
                writer.println(" State:");
        String innerPrefix = prefix + "  ";
        writer.print(innerPrefix); writer.print("mCreated=");
                writer.print(mCreated); writer.print("mResumed=");
                writer.print(mResumed); writer.print(" mStopped=");
                writer.print(mStopped); writer.print(" mReallyStopped=");
                writer.println(mReallyStopped);
        writer.print(innerPrefix); writer.print("mLoadersStarted=");
                writer.println(mLoadersStarted);
        if (mLoaderManager != null) {
            writer.print(prefix); writer.print("Loader Manager ");
                    writer.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
                    writer.println(":");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        }
        mFragments.dump(prefix, fd, writer, args);
        writer.print(prefix); writer.println("View Hierarchy:");
        dumpViewHierarchy(prefix + "  ", writer, getWindow().getDecorView());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.314 -0400", hash_original_method = "0B7E3349E1F0303BBAAE6767112F50B2", hash_generated_method = "6A3DAAEAA2C9E6732B30ABDD653554F6")
    
private void dumpViewHierarchy(String prefix, PrintWriter writer, View view) {
        writer.print(prefix);
        if (view == null) {
            writer.println("null");
            return;
        }
        writer.println(viewToString(view));
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup grp = (ViewGroup)view;
        final int N = grp.getChildCount();
        if (N <= 0) {
            return;
        }
        prefix = prefix + "  ";
        for (int i=0; i<N; i++) {
            dumpViewHierarchy(prefix, writer, grp.getChildAt(i));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.321 -0400", hash_original_method = "4C92BE36A72450E440D9BAAFB03D8955", hash_generated_method = "4C92BE36A72450E440D9BAAFB03D8955")
    
void doReallyStop(boolean retaining) {
        if (!mReallyStopped) {
            mReallyStopped = true;
            mRetaining = retaining;
            mHandler.removeMessages(MSG_REALLY_STOPPED);
            onReallyStop();
        }
    }

    /**
     * Pre-HC, we didn't have a way to determine whether an activity was
     * being stopped for a config change or not until we saw
     * onRetainNonConfigurationInstance() called after onStop().  However
     * we need to know this, to know whether to retain fragments.  This will
     * tell us what we need to know.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.328 -0400", hash_original_method = "E4D0A1E9799E4532B863FFE2D6A92452", hash_generated_method = "E4D0A1E9799E4532B863FFE2D6A92452")
    
void onReallyStop() {
        if (mLoadersStarted) {
            mLoadersStarted = false;
            if (mLoaderManager != null) {
                if (!mRetaining) {
                    mLoaderManager.doStop();
                } else {
                    mLoaderManager.doRetain();
                }
            }
        }

        mFragments.dispatchReallyStop();
    }

    // ------------------------------------------------------------------------
    // FRAGMENT SUPPORT
    // ------------------------------------------------------------------------
    
    /**
     * Called when a fragment is attached to the activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.335 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "90E52C4BC3A65267BADEC04167F68D07")
    
public void onAttachFragment(Fragment fragment) {
    }
    
    /**
     * Return the FragmentManager for interacting with fragments associated
     * with this activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.341 -0400", hash_original_method = "A30369BEE359642894950823DFC915CE", hash_generated_method = "B5CD8D953477451DBD109BD650F133D0")
    
public FragmentManager getSupportFragmentManager() {
        return mFragments;
    }

    /**
     * Modifies the standard behavior to allow results to be delivered to fragments.
     * This imposes a restriction that requestCode be <= 0xffff.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.349 -0400", hash_original_method = "5BE63D387764C79BADD7265D6253130D", hash_generated_method = "228971E4038BBD75957201B044AA9C5F")
    
@Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (requestCode != -1 && (requestCode&0xffff0000) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, requestCode);
    }

    /**
     * Called by Fragment.startActivityForResult() to implement its behavior.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.359 -0400", hash_original_method = "62E7172DD8437600599EFB859FBECAC1", hash_generated_method = "F18A99B335F562AFDA4B0537816312B8")
    
public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        if (requestCode == -1) {
            super.startActivityForResult(intent, -1);
            return;
        }
        if ((requestCode&0xffff0000) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, ((fragment.mIndex+1)<<16) + (requestCode&0xffff));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.366 -0400", hash_original_method = "6D742EEA8D7FFBA4C7362E83B04A53C8", hash_generated_method = "3032C09552B4E17980204B5CA8CEBD57")
    
void invalidateSupportFragment(String who) {
        //Log.v(TAG, "invalidateSupportFragment: who=" + who);
        if (mAllLoaderManagers != null) {
            LoaderManagerImpl lm = mAllLoaderManagers.get(who);
            if (lm != null && !lm.mRetaining) {
                lm.doDestroy();
                mAllLoaderManagers.remove(who);
            }
        }
    }
    
    // ------------------------------------------------------------------------
    // LOADER SUPPORT
    // ------------------------------------------------------------------------
    
    /**
     * Return the LoaderManager for this fragment, creating it if needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.373 -0400", hash_original_method = "028F901E5E204520B890CD9EE4450F4C", hash_generated_method = "CA0FB9052EF5AD21F6401CC4F2DD15BF")
    
public LoaderManager getSupportLoaderManager() {
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager("(root)", mLoadersStarted, true);
        return mLoaderManager;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 12:44:27.382 -0400", hash_original_method = "8A15810F89181824BB2AE7768363BB1E", hash_generated_method = "8A15810F89181824BB2AE7768363BB1E")
    
LoaderManagerImpl getLoaderManager(String who, boolean started, boolean create) {
        if (mAllLoaderManagers == null) {
            mAllLoaderManagers = new SimpleArrayMap<String, LoaderManagerImpl>();
        }
        LoaderManagerImpl lm = mAllLoaderManagers.get(who);
        if (lm == null) {
            if (create) {
                lm = new LoaderManagerImpl(who, this, started);
                mAllLoaderManagers.put(who, lm);
            }
        } else {
            lm.updateActivity(this);
        }
        return lm;
    }
}
