/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.app;

// Droidsafe Imports
import android.util.Slog;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.IntentFilter;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.widget.CursorAdapter;
import android.widget.AbsListView;
import android.app.FragmentManager;
import android.app.LoaderManager;

import com.android.internal.app.ActionBarImpl;
import com.android.internal.policy.PolicyManager;
import com.android.internal.view.menu.ContextMenuBuilder;
import com.android.internal.view.menu.MenuBuilder;

public class Activity extends ContextThemeWrapper implements LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback, OnCreateContextMenuListener, ComponentCallbacks2 {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String savedDialogKeyFor(int key){
		// Original method
		/*
		{
        return SAVED_DIALOG_KEY_PREFIX + key;
    }
		*/
		return "";
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String savedDialogArgsKeyFor(int key){
		// Original method
		/*
		{
        return SAVED_DIALOG_ARGS_KEY_PREFIX + key;
    }
		*/
		return "";
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:58.955 -0500", hash_original_field = "501D67C164205FCB456AD8BCCBC806C6", hash_generated_field = "8CACF19DA21B737E3F7EB34688FF057C")

    private static final String TAG = "Activity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:58.965 -0500", hash_original_field = "A856D07B0FB823768BA4029213FD5EB0", hash_generated_field = "2241ED7572C2B89FA014BFB20EB1AF72")

    public static final int RESULT_CANCELED    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:58.973 -0500", hash_original_field = "EFDE6D5794B25E3ED8ABB21A4D382062", hash_generated_field = "F91B70B7F6D5082BE48EF2C98C1E7358")

    public static final int RESULT_OK           = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:58.980 -0500", hash_original_field = "AB0D1C265E624C1987A9FD48106FC610", hash_generated_field = "5077A6A22B66E72C7578FB99A7F608D6")

    public static final int RESULT_FIRST_USER   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:58.988 -0500", hash_original_field = "7C981B7812486BF80407E00E081725AF", hash_generated_field = "935F741DC4E3364E9A53BE28D1817499")

    private static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.008 -0500", hash_original_field = "13B33411593A705589F2DA04D3DEAA8D", hash_generated_field = "925270CCB66F84A6CC5AD8E1A127DDF5")

    private static final String FRAGMENTS_TAG = "android:fragments";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.016 -0500", hash_original_field = "A2F704E2707752943497552CCABE29AA", hash_generated_field = "B84490F85315FC6A0344124DA2A9A7C1")

    private static final String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.023 -0500", hash_original_field = "D9CA2358EC2F78ED33392AA9626D3920", hash_generated_field = "F085B80E40EB97561C0DC9EEAA7EAFE2")

    private static final String SAVED_DIALOGS_TAG = "android:savedDialogs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.032 -0500", hash_original_field = "7B42CFF4F1193B60EFA59FAA18B566C6", hash_generated_field = "7A1510EAA3BBABE8CABC5BDBCC2B1DF1")

    private static final String SAVED_DIALOG_KEY_PREFIX = "android:dialog_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.041 -0500", hash_original_field = "3C7DE9A5DE90F5E7BC2D34BEC1354FDC", hash_generated_field = "7ED6DE9D8F1923634B10FAD193F62B6F")

    private static final String SAVED_DIALOG_ARGS_KEY_PREFIX = "android:dialog_args_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.408 -0500", hash_original_field = "8DEF5FAA069262DDDE3E453AF79F9071", hash_generated_field = "98D5104638F2DEE99210C785FE0E500F")
    
    protected static final int[] FOCUSED_STATE_SET = {com.android.internal.R.attr.state_focused};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.774 -0500", hash_original_field = "D3CC4E3A93F1E49612038E01336EDC17", hash_generated_field = "45127B126EE2B3619E2DE44F606F53C3")

    static public final int DEFAULT_KEYS_DISABLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.780 -0500", hash_original_field = "F954865C8A7A31F1B669E6AF04885A47", hash_generated_field = "F05278144A2B935FA742242E4E3A61A2")

    static public final int DEFAULT_KEYS_DIALER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.787 -0500", hash_original_field = "BB027D4000CA88DEF60D8FE95C7015CE", hash_generated_field = "B4C1B32500D4540AA59C81E1B33DAC14")

    static public final int DEFAULT_KEYS_SHORTCUT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.793 -0500", hash_original_field = "EF7E3796CBA6D968D92BAFDE8D96A8DA", hash_generated_field = "7B0F2176FF8E3A9C8466EB909FF8E3C8")

    static public final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.801 -0500", hash_original_field = "FEB80DB48A65BBCE572853953D3C4860", hash_generated_field = "0C973E25C195EE36EA7FD3DD74B22EB1")

    static public final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    
    public static final int START_FLAG_RETRY = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.067 -0500", hash_original_field = "7550A4376A793BDF5EA7AE91001AD92B", hash_generated_field = "D7ACA1EA4615702CAE0E6513097C1B9D")

    private SparseArray<ManagedDialog> mManagedDialogs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.073 -0500", hash_original_field = "5CBE0F2EE224A7AD181F35AE16EC5D56", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.081 -0500", hash_original_field = "DD6EB7EC256F1225D4C6DC1A42FB765B", hash_generated_field = "48FA2AB88D7976975EE44F222013EB79")

    private IBinder mToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.087 -0500", hash_original_field = "3167403B4911EC101601A479A824BC89", hash_generated_field = "1C52ADC6FAC22BA15FC5CB45EFB9C704")

    private int mIdent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.092 -0500", hash_original_field = "A96A287BB650BF201DDA299E34737419", hash_generated_field = "A96A287BB650BF201DDA299E34737419")
 String mEmbeddedID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.099 -0500", hash_original_field = "218A10E2C368F2E85F83EE2065C292CD", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.106 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "1811495D939DB843870F6315E04555CC")
 @DSVAModeled
 Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.112 -0500", hash_original_field = "FC166AFC662871D7EC38777C0105881C", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.118 -0500", hash_original_field = "C71CEE98D7B6D75F61EDC7C7807C69E4", hash_generated_field = "C71CEE98D7B6D75F61EDC7C7807C69E4")
 ActivityInfo mActivityInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.124 -0500", hash_original_field = "DAA5CF027F30E341CB6E5B438E9919B8", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")
 ActivityThread mMainThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.130 -0500", hash_original_field = "CD55C80FF47FF655766F475F33319B07", hash_generated_field = "CD55C80FF47FF655766F475F33319B07")

    Activity mParent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.136 -0500", hash_original_field = "6971FF9C6126C288092CCC2A5964E550", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.143 -0500", hash_original_field = "93A369593E1CC22C7DE8D4D5C675B065", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.149 -0500", hash_original_field = "D357ECA56BF47F1751443279339D50DF", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.155 -0500", hash_original_field = "23D2434AD22548E124B62AB7739838E9", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")
 boolean mResumed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.161 -0500", hash_original_field = "C703FF92314B1EE9638F5EE77CD641D7", hash_generated_field = "7A3A2F4FBB99BD4528DF7EC8A1065318")

    private boolean mStopped;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.167 -0500", hash_original_field = "10598AB9B4F301B505526794EAE9EAF0", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

    boolean mFinished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.173 -0500", hash_original_field = "4271970B01F3FE84D04BB6304D70A20E", hash_generated_field = "4271970B01F3FE84D04BB6304D70A20E")

    boolean mStartedActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:36:12.005 -0500", hash_original_field = "E2F9380D6A364C95010BE19858A38D28", hash_generated_field = "8A322BA9BF6E13D0E7D71186F6C44EC6")

    /*package*/ boolean mTemporaryPause = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:36:12.006 -0500", hash_original_field = "D9F8EBFD0B8B6BCDE3A24A3C3A2D769A", hash_generated_field = "D23189DD53D8D71481AC7C4A56E70A68")

    /*package*/ boolean mChangingConfigurations = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.192 -0500", hash_original_field = "8737FBBAA51F2079A35CA72C17030BD1", hash_generated_field = "8737FBBAA51F2079A35CA72C17030BD1")
 int mConfigChangeFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.199 -0500", hash_original_field = "C5BC4D87F668E7C84F089BDA831D492B", hash_generated_field = "C5BC4D87F668E7C84F089BDA831D492B")
 Configuration mCurrentConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.205 -0500", hash_original_field = "8470BADEE289DF0AB053E4469CD24A3C", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")

    private SearchManager mSearchManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.212 -0500", hash_original_field = "52EDF68A855A6A4E1C6D958055ACE764", hash_generated_field = "53E9FC1E44FE670BE318B42372895069")

    private MenuInflater mMenuInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.251 -0500", hash_original_field = "103BD895478A6A40124D791931151EE2", hash_generated_field = "103BD895478A6A40124D791931151EE2")
 NonConfigurationInstances mLastNonConfigurationInstances;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.258 -0500", hash_original_field = "C6B08D42C8EA2CB56500460CAF662F4C", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")
    
    private Window mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.265 -0500", hash_original_field = "83A062836C11DD52DC32F4325712F233", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.271 -0500", hash_original_field = "E1BBD6179BBAC61DB86866A787E8F58C", hash_generated_field = "E1BBD6179BBAC61DB86866A787E8F58C")
 View mDecor = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.277 -0500", hash_original_field = "55C28C3FE3EA0FDA8C94FC41EC701FCC", hash_generated_field = "55C28C3FE3EA0FDA8C94FC41EC701FCC")
 boolean mWindowAdded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.282 -0500", hash_original_field = "8DFFFB221D63F9E9F2CE49B7477D9272", hash_generated_field = "8DFFFB221D63F9E9F2CE49B7477D9272")
 boolean mVisibleFromServer = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.289 -0500", hash_original_field = "5F61707B4AC1003B88348BA722FB1276", hash_generated_field = "5F61707B4AC1003B88348BA722FB1276")
 boolean mVisibleFromClient = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.295 -0500", hash_original_field = "1CE82A6BEC35E312C3A47BC38BD7B9BC", hash_generated_field = "1CE82A6BEC35E312C3A47BC38BD7B9BC")
 ActionBarImpl mActionBar = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.301 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.308 -0500", hash_original_field = "2F27E770C08EAF774B32F60AC1A8D570", hash_generated_field = "CF4E9C052F96C3E80581AE8AF634872B")

    private int mTitleColor = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.315 -0500", hash_original_field = "770A646DB3FFD5D268F1207A9B6648B8", hash_generated_field = "694874072698409F6608B46B5D5A3DE1")

    final FragmentManagerImpl mFragments = new FragmentManagerImpl(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.321 -0500", hash_original_field = "207A321ED3571899F1F73399691FB216", hash_generated_field = "207A321ED3571899F1F73399691FB216")
    
    SparseArray<LoaderManagerImpl> mAllLoaderManagers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.326 -0500", hash_original_field = "6EE478DF5473556475C8D09C185A01BC", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.369 -0500", hash_original_field = "947D859635E88FF9AD755CEB7285AC51", hash_generated_field = "055EFA91DED96C0A7FAE40D00A04351C")

    private final ArrayList<ManagedCursor> mManagedCursors =
        new ArrayList<ManagedCursor>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.375 -0500", hash_original_field = "2FA7D874AF2386F63CF856FBF24A7710", hash_generated_field = "2FA7D874AF2386F63CF856FBF24A7710")

    int mResultCode = RESULT_CANCELED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.382 -0500", hash_original_field = "33B7C8CE0002446D9B0EE0274776A0A9", hash_generated_field = "33B7C8CE0002446D9B0EE0274776A0A9")

    Intent mResultData = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.387 -0500", hash_original_field = "C21BE9BD6AAB2237466A80BCA166CA70", hash_generated_field = "AB8AC56D76B8BEA00FC5296846330527")

    private boolean mTitleReady = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.394 -0500", hash_original_field = "390C7F0981BA84FE37791C6DE18A35AD", hash_generated_field = "B2DD3A4B48EBE858054417FEDBBD4E9F")

    private int mDefaultKeyMode = DEFAULT_KEYS_DISABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.400 -0500", hash_original_field = "22E5427C84A3B37A77D47D71434C1D16", hash_generated_field = "2B1292D0EBD0751B84B1BAFF83080A8F")

    private SpannableStringBuilder mDefaultKeySsb = null;
    private final Object mInstanceTracker = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.421 -0500", hash_original_field = "348A8677E1E3F1084FC4FBEC2A3E1F5D", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.427 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

    final Handler mHandler = new Handler();
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public Activity() {
		super();
		mWindow = PolicyManager.makeNewWindow((Context)this);
	}

    /** Return the intent that started this activity. */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.IPC)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.433 -0500", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "7CE6D2E5920E17BB1B744A5090D635BC")
    public Intent getIntent() {
        return mIntent;
    }

    /** 
     * Change the intent returned by {@link #getIntent}.  This holds a 
     * reference to the given intent; it does not copy it.  Often used in 
     * conjunction with {@link #onNewIntent}. 
     *  
     * @param newIntent The new Intent object to return from getIntent 
     * 
     * @see #getIntent
     * @see #onNewIntent
     */ 
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.438 -0500", hash_original_method = "CC61C883982068788EAC9DED2F81C9E5", hash_generated_method = "4FCD5B90D6018F4246EC2AA6BF36143F")
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public Intent __ds__registerIntentFilter(IntentFilter intentFilter) {
        this.__ds__intentFilters.add(intentFilter);
        Intent intent = new Intent(intentFilter.getAction(getTaintInt()));
        intent.addCategory(intentFilter.getCategory(getTaintInt()));
        this.__ds__intentsFromFilter.add(intent);
    
        //set the intent from the intent filter
        this.setIntent(intent);

        return intent;
    }

    @DSSpec(DSCat.IPC)
    @DSSink(DSSinkKind.IPC)
    public void setIntent(Intent newIntent) {
        mIntent = newIntent;
    }

    /** Return the application that owns this activity. */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.444 -0500", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "63791FE33C4BA47B317000A8E62CC095")
    
public final Application getApplication() {
        return mApplication;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final boolean isChild(){
        return mParent != null;
    }
    
    /** Return the parent activity if this view is an embedded child. */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.456 -0500", hash_original_method = "9F036901744EF56469FFF11C0925658F", hash_generated_method = "F6946DC3F22C892A127414944808F1FB")
    
public final Activity getParent() {
        return mParent;
    }
    
    //TODO: We need to find a way to model parent activity associated
    // with this activity
    @DSSpec(DSCat.IPC)
    public 
    Intent   getParentActivityIntent() {
        if (mParent != null) {
        
        }
        //what to do here?
        Intent intent = new Intent();
        intent.addTaint(getTaint());
        return intent;
        
    }
    
    /** Retrieve the window manager for showing custom windows. */
    @DSComment("Android Manager retrieved/accessed")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.462 -0500", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "0C79B12DA4736ABBDC4EC55B1426644A")
    
public WindowManager getWindowManager() {
        return mWindowManager;
    }

    /**
     * Retrieve the current {@link android.view.Window} for the activity.
     * This can be used to directly access parts of the Window API that
     * are not available through Activity/Screen.
     * 
     * @return Window The current window, or null if the activity is not
     *         visual.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.468 -0500", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "331876D44C3CE896E388411794B32F6E")
    
public Window getWindow() {
        return mWindow;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    
    public LoaderManager getLoaderManager(){
		mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
		return mLoaderManager;
		// Original method
		/*
		{
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        return mLoaderManager;
    }
		*/
	}
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    LoaderManagerImpl getLoaderManager(int index, boolean started, boolean create){
		mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
		LoaderManagerImpl lm = mAllLoaderManagers.get(index);
		lm.updateActivity(this);
		return lm;
		// Original method
		/*
		{
        if (mAllLoaderManagers == null) {
            mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        }
        LoaderManagerImpl lm = mAllLoaderManagers.get(index);
        if (lm == null) {
            if (create) {
                lm = new LoaderManagerImpl(this, started);
                mAllLoaderManagers.put(index, lm);
            }
        } else {
            lm.updateActivity(this);
        }
        return lm;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public View getCurrentFocus(){
		return mWindow.getCurrentFocus();
		// Original method
		/*
		{
        return mWindow != null ? mWindow.getCurrentFocus() : null;
    }
		*/
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSVerified("Modeled Lifecycle Event")
    protected void onCreate(Bundle savedInstanceState){
		mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
		Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
		mFragments.restoreAllState(p, mLastNonConfigurationInstances.fragments);
		mFragments.dispatchCreate();
		getApplication().dispatchActivityCreated(this, savedInstanceState);
		// Original method
		/*
		{
        if (mLastNonConfigurationInstances != null) {
            mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        }
        if (savedInstanceState != null) {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, mLastNonConfigurationInstances != null
                    ? mLastNonConfigurationInstances.fragments : null);
        }
        mFragments.dispatchCreate();
        getApplication().dispatchActivityCreated(this, savedInstanceState);
        mCalled = true;
    }
		*/
		//Return nothing
	}

    /**
     * The hook for {@link ActivityThread} to restore the state of this activity.
     *
     * Calls {@link #onSaveInstanceState(android.os.Bundle)} and
     * {@link #restoreManagedDialogs(android.os.Bundle)}.
     *
     * @param savedInstanceState contains the saved state
     */
    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.503 -0500", hash_original_method = "F96DCFB160CAE669DE173597BCAB5D29", hash_generated_method = "C734A05148AE2009F15CC2274FB39B2A")
final void performRestoreInstanceState(Bundle savedInstanceState) {
        onRestoreInstanceState(savedInstanceState);
        restoreManagedDialogs(savedInstanceState);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    //@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    protected void onRestoreInstanceState(Bundle savedInstanceState){
		Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG); //DSFIXME:  Model method in bundle
		mWindow.restoreHierarchyState(windowState);
		// Original method
		/*
		{
        if (mWindow != null) {
            Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
            if (windowState != null) {
                mWindow.restoreHierarchyState(windowState);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void restoreManagedDialogs(Bundle savedInstanceState){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private Dialog createDialog(Integer dialogId, Bundle state, Bundle args){
		final Dialog dialog = onCreateDialog(dialogId, args);
		dialog.dispatchOnCreate(state);
        return dialog;
		// Original method
		/*
		{
        final Dialog dialog = onCreateDialog(dialogId, args);
        if (dialog == null) {
            return null;
        }
        dialog.dispatchOnCreate(state);
        return dialog;
    }
		*/
	}

    @DSVerified 
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onPostCreate(Bundle savedInstanceState){
		onTitleChanged(getTitle(), getTitleColor());
		// Original method
		/*
		{
        if (!isChild()) {
            mTitleReady = true;
            onTitleChanged(getTitle(), getTitleColor());
        }
        mCalled = true;
    }
		*/
		//Return nothing
	}

    @DSVerified("Modeled Lifecycle Event")
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onStart(){
		mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
		mLoaderManager.doStart();
		getApplication().dispatchActivityStarted(this);
		// Original method
		/*
		{
        mCalled = true;
        if (!mLoadersStarted) {
            mLoadersStarted = true;
            if (mLoaderManager != null) {
                mLoaderManager.doStart();
            } else if (!mCheckedForLoaderManager) {
                mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
            }
            mCheckedForLoaderManager = true;
        }
        getApplication().dispatchActivityStarted(this);
    }
		*/
		//Return nothing
	}
    @DSVerified    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onRestart(){
		// Original method
		/*
		{
        mCalled = true;
    }
		*/
		//Return nothing
	}
    
    @DSVerified    
	@DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onResume(){
		getApplication().dispatchActivityResumed(this);
		// Original method
		/*
		{
        getApplication().dispatchActivityResumed(this);
        mCalled = true;
    }
		*/
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onPostResume(){
		final Window win = getWindow();
		win.makeActive();
		mActionBar.setShowHideAnimationEnabled(true);
		// Original method
		/*
		{
        final Window win = getWindow();
        if (win != null) win.makeActive();
        if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
        mCalled = true;
    }
		*/
		//Return nothing
	}

    /**
     * This is called for activities that set launchMode to "singleTop" in
     * their package, or if a client used the {@link Intent#FLAG_ACTIVITY_SINGLE_TOP}
     * flag when calling {@link #startActivity}.  In either case, when the
     * activity is re-launched while at the top of the activity stack instead
     * of a new instance of the activity being started, onNewIntent() will be
     * called on the existing instance with the Intent that was used to
     * re-launch it. 
     *  
     * <p>An activity will always be paused before receiving a new intent, so 
     * you can count on {@link #onResume} being called after this method. 
     * 
     * <p>Note that {@link #getIntent} still returns the original Intent.  You 
     * can use {@link #setIntent} to update it to this new Intent. 
     * 
     * @param intent The new intent that was started for the activity. 
     *  
     * @see #getIntent
     * @see #setIntent 
     * @see #onResume 
     */
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.580 -0500", hash_original_method = "ECA12E6FCFF6C8E6301C9A23FD34F5BD", hash_generated_method = "4ADDCDE3CE740D4C5E6F0A8FD5893823")
    
protected void onNewIntent(Intent intent) {
    }

    /**
     * The hook for {@link ActivityThread} to save the state of this activity.
     *
     * Calls {@link #onSaveInstanceState(android.os.Bundle)}
     * and {@link #saveManagedDialogs(android.os.Bundle)}.
     *
     * @param outState The bundle to save the state to.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.585 -0500", hash_original_method = "0B461FC0ABFD8E876BD0A4555078BB43", hash_generated_method = "AE2B1A9FF43656294DABE256804A5E19")
    
final void performSaveInstanceState(Bundle outState) {
        onSaveInstanceState(outState);
        saveManagedDialogs(outState);
    }
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onSaveInstanceState(Bundle outState){
        outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p = mFragments.saveAllState();
        outState.putParcelable(FRAGMENTS_TAG, p);
        getApplication().dispatchActivitySaveInstanceState(this, outState);
		// Original method
		/*
		{
        outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p = mFragments.saveAllState();
        if (p != null) {
            outState.putParcelable(FRAGMENTS_TAG, p);
        }
        getApplication().dispatchActivitySaveInstanceState(this, outState);
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void saveManagedDialogs(Bundle outState){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onPause(){
		getApplication().dispatchActivityPaused(this);
		// Original method
		/*
		{
        getApplication().dispatchActivityPaused(this);
        mCalled = true;
    }
		*/
		//Return nothing
	}

    /**
     * Called as part of the activity lifecycle when an activity is about to go
     * into the background as the result of user choice.  For example, when the
     * user presses the Home key, {@link #onUserLeaveHint} will be called, but
     * when an incoming phone call causes the in-call Activity to be automatically
     * brought to the foreground, {@link #onUserLeaveHint} will not be called on
     * the activity being interrupted.  In cases when it is invoked, this method
     * is called right before the activity's {@link #onPause} callback.
     * 
     * <p>This callback and {@link #onUserInteraction} are intended to help
     * activities manage status bar notifications intelligently; specifically,
     * for helping activities determine the proper time to cancel a notfication.
     * 
     * @see #onUserInteraction()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.609 -0500", hash_original_method = "F09D1B8D5CADCA3B5931B472B638BC48", hash_generated_method = "73D2546AB8FB4801322D97DDE9F8B458")
    
protected void onUserLeaveHint() {
    }
    
    /**
     * Generate a new thumbnail for this activity.  This method is called before
     * pausing the activity, and should draw into <var>outBitmap</var> the
     * imagery for the desired thumbnail in the dimensions of that bitmap.  It
     * can use the given <var>canvas</var>, which is configured to draw into the
     * bitmap, for rendering if desired.
     * 
     * <p>The default implementation returns fails and does not draw a thumbnail;
     * this will result in the platform creating its own thumbnail if needed.
     * 
     * @param outBitmap The bitmap to contain the thumbnail.
     * @param canvas Can be used to render into the bitmap.
     * 
     * @return Return true if you have drawn into the bitmap; otherwise after
     *         you return it will be filled with a default thumbnail.
     * 
     * @see #onCreateDescription
     * @see #onSaveInstanceState
     * @see #onPause
     */
    @DSVerified("Modeled Lifecycle Event")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.615 -0500", hash_original_method = "88BB0202BF6BAEB771096BFB80D04435", hash_generated_method = "89FD83C8377F7059D62B43FADD327332")
public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return false;
    }
    
    @DSVerified("Internal droidsafe use")
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafePerformSaveInstanceState(Bundle bundle) {
        performSaveInstanceState(bundle);
    }
    
    @DSVerified("Internal droidsafe use")
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafePerformRestoreInstanceState(Bundle savedInstanceState) {
        performRestoreInstanceState(savedInstanceState);
    }
 
    @DSVerified("Internal droidsafe use")
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public boolean droidsafeOnCreateThumbnail() {
        return onCreateThumbnail(new Bitmap(), new Canvas());
    }
    
    /**
     * Generate a new description for this activity.  This method is called
     * before pausing the activity and can, if desired, return some textual
     * description of its current state to be displayed to the user.
     * 
     * <p>The default implementation returns null, which will cause you to
     * inherit the description from the previous activity.  If all activities
     * return null, generally the label of the top activity will be used as the
     * description.
     * 
     * @return A description of what the user is doing.  It should be short and
     *         sweet (only a few words).
     * 
     * @see #onCreateThumbnail
     * @see #onSaveInstanceState
     * @see #onPause
     */
    @DSVerified("Modeled Lifecycle Event")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.620 -0500", hash_original_method = "ABF3FC9B35FB67DA4650457E79D2DAE8", hash_generated_method = "4A801EFBDC40FB7231D50804D2987BA1")
    
public CharSequence onCreateDescription() {
        return new String("<Activity.onCreateDescription>");
    }
    
    @DSVerified
	@DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onStop(){
		mActionBar.setShowHideAnimationEnabled(false);
		getApplication().dispatchActivityStopped(this);
		// Original method
		/*
		{
        if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
        getApplication().dispatchActivityStopped(this);
        mCalled = true;
    }
		*/
		//Return nothing
	}
    
	@DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
	@DSVerified()
    protected void onDestroy(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onConfigurationChanged(Configuration newConfig){
		mFragments.dispatchConfigurationChanged(newConfig);
		mWindow.onConfigurationChanged(newConfig);
		mActionBar.onConfigurationChanged(newConfig);
		// Original method
		/*
		{
        mCalled = true;
        mFragments.dispatchConfigurationChanged(newConfig);
        if (mWindow != null) {
            mWindow.onConfigurationChanged(newConfig);
        }
        if (mActionBar != null) {
            mActionBar.onConfigurationChanged(newConfig);
        }
    }
		*/
		//Return nothing
	}
    
    @DSSafe
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    public int getChangingConfigurations(){
        return mConfigChangeFlags;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @Deprecated public Object getLastNonConfigurationInstance(){
		return mLastNonConfigurationInstances.activity;
		// Original method
		/*
		{
        return mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.activity : null;
    }
		*/
	}
    
    /**
     * Called by the system, as part of destroying an
     * activity due to a configuration change, when it is known that a new
     * instance will immediately be created for the new configuration.  You
     * can return any object you like here, including the activity instance
     * itself, which can later be retrieved by calling
     * {@link #getLastNonConfigurationInstance()} in the new activity
     * instance.
     * 
     * <em>If you are targeting {@link android.os.Build.VERSION_CODES#HONEYCOMB}
     * or later, consider instead using a {@link Fragment} with
     * {@link Fragment#setRetainInstance(boolean)
     * Fragment.setRetainInstance(boolean}.</em>
     *
     * <p>This function is called purely as an optimization, and you must
     * not rely on it being called.  When it is called, a number of guarantees
     * will be made to help optimize configuration switching:
     * <ul>
     * <li> The function will be called between {@link #onStop} and
     * {@link #onDestroy}.
     * <li> A new instance of the activity will <em>always</em> be immediately
     * created after this one's {@link #onDestroy()} is called.  In particular,
     * <em>no</em> messages will be dispatched during this time (when the returned
     * object does not have an activity to be associated with).
     * <li> The object you return here will <em>always</em> be available from
     * the {@link #getLastNonConfigurationInstance()} method of the following
     * activity instance as described there.
     * </ul>
     * 
     * <p>These guarantees are designed so that an activity can use this API
     * to propagate extensive state from the old to new activity instance, from
     * loaded bitmaps, to network connections, to evenly actively running
     * threads.  Note that you should <em>not</em> propagate any data that
     * may change based on the configuration, including any data loaded from
     * resources such as strings, layouts, or drawables.
     * 
     * <p>The guarantee of no message handling during the switch to the next
     * activity simplifies use with active objects.  For example if your retained
     * state is an {@link android.os.AsyncTask} you are guaranteed that its
     * call back functions (like {@link android.os.AsyncTask#onPostExecute}) will
     * not be called from the call here until you execute the next instance's
     * {@link #onCreate(Bundle)}.  (Note however that there is of course no such
     * guarantee for {@link android.os.AsyncTask#doInBackground} since that is
     * running in a separate thread.)
     *
     * @return Return any Object holding the desired state to propagate to the
     * next activity instance.
     *
     * @deprecated Use the new {@link Fragment} API
     * {@link Fragment#setRetainInstance(boolean)} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.655 -0500", hash_original_method = "1AAF173FB42EFD7F047F27F49A93F1B0", hash_generated_method = "EF79CCC92D4FC8E6D4A731B85F47D767")
    
public Object onRetainNonConfigurationInstance() {
        return null;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    HashMap<String, Object> getLastNonConfigurationChildInstances(){
		return mLastNonConfigurationInstances.children;
		// Original method
		/*
		{
        return mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.children : null;
    }
		*/
	}
    
    /**
     * This method is similar to {@link #onRetainNonConfigurationInstance()} except that
     * it should return either a mapping from  child activity id strings to arbitrary objects,
     * or null.  This method is intended to be used by Activity framework subclasses that control a
     * set of child activities, such as ActivityGroup.  The same guarantees and restrictions apply
     * as for {@link #onRetainNonConfigurationInstance()}.  The default implementation returns null.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.666 -0500", hash_original_method = "342B0C995620FF868A09DAF694D00C04", hash_generated_method = "342B0C995620FF868A09DAF694D00C04")
    
HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        return null;
    }
    
    NonConfigurationInstances retainNonConfigurationInstances(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onLowMemory(){
		mFragments.dispatchLowMemory();
		// Original method
		/*
		{
        mCalled = true;
        mFragments.dispatchLowMemory();
    }
		*/
		//Return nothing
	}
    
	public void onTrimMemory(int level){
		mFragments.dispatchTrimMemory(level);
		// Original method
		/*
		{
        mCalled = true;
        mFragments.dispatchTrimMemory(level);
    }
		*/
		//Return nothing
	}

    /**
     * Return the FragmentManager for interacting with fragments associated
     * with this activity.
     */
    @DSComment("Android Manager retrieved/accessed")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.686 -0500", hash_original_method = "C5EB33D6873EE026D87972F02E8EBD4B", hash_generated_method = "564609F83A847B122B44871EAAC2C081")
    
public FragmentManager getFragmentManager() {
        return mFragments;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void invalidateFragmentIndex(int index){
		LoaderManagerImpl lm = mAllLoaderManagers.get(0);
		lm.doDestroy();
		mAllLoaderManagers.remove(0);
		// Original method
		/*
		{
        if (mAllLoaderManagers != null) {
            LoaderManagerImpl lm = mAllLoaderManagers.get(index);
            if (lm != null && !lm.mRetaining) {
                lm.doDestroy();
                mAllLoaderManagers.remove(index);
            }
        }
    }
		*/
		//Return nothing
	}
    
    /**
     * Called when a Fragment is being attached to this activity, immediately
     * after the call to its {@link Fragment#onAttach Fragment.onAttach()}
     * method and before {@link Fragment#onCreate Fragment.onCreate()}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.698 -0500", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "90E52C4BC3A65267BADEC04167F68D07")
    
public void onAttachFragment(Fragment fragment) {
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Deprecated public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String sortOrder){
		Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
		startManagingCursor(c);
		return c;
		// Original method
		/*
		{
        Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        if (c != null) {
            startManagingCursor(c);
        }
        return c;
    }
		*/
	}
    
    @DSComment("returned DB object")
    @DSSpec(DSCat.DATABASE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Deprecated public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder){
		Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
		startManagingCursor(c);
		return c;
		// Original method
		/*
		{
        Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        if (c != null) {
            startManagingCursor(c);
        }
        return c;
    }
		*/
	}
    
    @DSComment("Database access")
    @DSSpec(DSCat.DATABASE)
    @Deprecated public void startManagingCursor(Cursor c){
		// Original method
		/*
		{
        synchronized (mManagedCursors) {
            mManagedCursors.add(new ManagedCursor(c));
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @Deprecated public void stopManagingCursor(Cursor c){
		ManagedCursor mc = mManagedCursors.get(0);
		mManagedCursors.remove(0);
		// Original method
		/*
		{
        synchronized (mManagedCursors) {
            final int N = mManagedCursors.size();
            for (int i=0; i<N; i++) {
                ManagedCursor mc = mManagedCursors.get(i);
                if (mc.mCursor == c) {
                    mManagedCursors.remove(i);
                    break;
                }
            }
        }
    }
		*/
		//Return nothing
	}

    /**
     * @deprecated As of {@link android.os.Build.VERSION_CODES#GINGERBREAD}
     * this is a no-op.
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.726 -0500", hash_original_method = "14D9F664592BF6CD2790F336C855BE58", hash_generated_method = "D3F3B9EEC979AA633E423ED004E2194B")
    
@Deprecated
    public void setPersistent(boolean isPersistent) {
    }

    /**
     * Finds a view that was identified by the id attribute from the XML that
     * was processed in {@link #onCreate}.
     *
     * @return The view if found or null otherwise.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.731 -0500", hash_original_method = "6A267AF8CD8DFD046F9AA4A840E0F1F1", hash_generated_method = "755E2CA99C821360ADFBADF6E41C3E62")
    
public View findViewById(int id) {
        //return null so that fallback modeling can insert what it needs to
        //this call will be replaced by the xml modeling when it can
        return null;
    }
    
    /**
     * Retrieve a reference to this activity's ActionBar.
     *
     * @return The Activity's ActionBar, or null if it does not have one.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.736 -0500", hash_original_method = "EC6DC7C8BFDE6FF47CE21F97E3274EE5", hash_generated_method = "E5E94BEBC452D594395C0CA7D5A6B868")
    
public ActionBar getActionBar() {
        initActionBar();
        return mActionBar;
    }
    
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void initActionBar(){
		Window window = getWindow();
		window.getDecorView();
		window.hasFeature(Window.FEATURE_ACTION_BAR);
		mActionBar = new ActionBarImpl(this);
		// Original method
		/*
		{
        Window window = getWindow();
        window.getDecorView();
        if (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null) {
            return;
        }
        mActionBar = new ActionBarImpl(this);
    }
		*/
		//Return nothing
	}
    
    /**
     * Set the activity content from a layout resource.  The resource will be
     * inflated, adding all top-level views to the activity.
     *
     * @param layoutResID Resource ID to be inflated.
     * 
     * @see #setContentView(android.view.View)
     * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
	
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    //@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.747 -0500", hash_original_method = "FC4CFA409E0DBC3CD2C86D908686341E", hash_generated_method = "8A18F956B194A0C371BE43C50E45248B")
    
public void setContentView(int layoutResID) {
        getWindow().setContentView(layoutResID);
        initActionBar();
    }

    /**
     * Set the activity content to an explicit view.  This view is placed
     * directly into the activity's view hierarchy.  It can itself be a complex
     * view hierarchy.  When calling this method, the layout parameters of the
     * specified view are ignored.  Both the width and the height of the view are
     * set by default to {@link ViewGroup.LayoutParams#MATCH_PARENT}. To use
     * your own layout parameters, invoke
     * {@link #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)}
     * instead.
     * 
     * @param view The desired content to display.
     *
     * @see #setContentView(int)
     * @see #setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
	
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    //@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.752 -0500", hash_original_method = "6143DA20A0E63D3DD26D6D6CC3A0350F", hash_generated_method = "68042BCA2A6984D357903A5C198D5CDB")
    
public void setContentView(View view) {
        getWindow().setContentView(view);
        initActionBar();
    }

    /**
     * Set the activity content to an explicit view.  This view is placed
     * directly into the activity's view hierarchy.  It can itself be a complex
     * view hierarchy.
     * 
     * @param view The desired content to display.
     * @param params Layout parameters for the view.
     *
     * @see #setContentView(android.view.View)
     * @see #setContentView(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.757 -0500", hash_original_method = "FCB0E6F09A4D449F841F63B35D6A2C9A", hash_generated_method = "1913D4F1055F25C59E2EB22DE55ACB26")
    @DSVerified    
    @DSSafe(DSCat.GUI) 
public void setContentView(View view, ViewGroup.LayoutParams params) {
        getWindow().setContentView(view, params);
        initActionBar();
    }

    /**
     * Add an additional content view to the activity.  Added after any existing
     * ones in the activity -- existing views are NOT removed.
     * 
     * @param view The desired content to display.
     * @param params Layout parameters for the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.762 -0500", hash_original_method = "FC447FA34EAD1A15520CE5D8778BF36F", hash_generated_method = "CC69E4A6765A9668C67296C98FBE0BCE")
    
    @DSVerified
    @DSSafe(DSCat.GUI)
public void addContentView(View view, ViewGroup.LayoutParams params) {
        getWindow().addContentView(view, params);
        initActionBar();
    }

    /**
     * Sets whether this activity is finished when touched outside its window's
     * bounds.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.768 -0500", hash_original_method = "729048B37138D48F6A74BC6AFCECACEE", hash_generated_method = "A41EB2401D4EFCDB568228C47AA5D8B9")
    
public void setFinishOnTouchOutside(boolean finish) {
        mWindow.setCloseOnTouchOutside(finish);
    }
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void setDefaultKeyMode(int mode){
        //addTaint(mode);
        mDefaultKeySsb = new SpannableStringBuilder();
        Selection.setSelection(mDefaultKeySsb,0);
		// Original method
		/*
		{
        mDefaultKeyMode = mode;
        switch (mode) {
        case DEFAULT_KEYS_DISABLE:
        case DEFAULT_KEYS_SHORTCUT:
            mDefaultKeySsb = null;      
            break;
        case DEFAULT_KEYS_DIALER:
        case DEFAULT_KEYS_SEARCH_LOCAL:
        case DEFAULT_KEYS_SEARCH_GLOBAL:
            mDefaultKeySsb = new SpannableStringBuilder();
            Selection.setSelection(mDefaultKeySsb,0);
            break;
        default:
            throw new IllegalArgumentException();
        }
    }
		*/
		//Return nothing
	}

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeOnKeyEvents() {
        int action = getTaintInt();
        int code = getTaintInt();
        int repeatCount = getTaintInt();
        KeyEvent ev = new KeyEvent(action, code);
        onKeyDown(getTaintInt(), ev);
        onKeyUp(getTaintInt(), ev);
        onKeyLongPress(getTaintInt(), ev);
        onKeyMultiple(code, repeatCount, ev);
        
        Parcel parcel = Parcel.obtain();
        MotionEvent motionEv = MotionEvent.createFromParcelBody(parcel);
        onTouchEvent(motionEv);
        onTrackballEvent(motionEv);
        onGenericMotionEvent(motionEv);
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onKeyDown(int keyCode, KeyEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
     * KeyEvent.Callback.onKeyLongPress()}: always returns false (doesn't handle
     * the event).
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.819 -0500", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "DCA1BD8CD57F309EE5CB42ADAEA0EA5E")
    
public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onKeyUp(int keyCode, KeyEvent event){
		getApplicationInfo();
		onBackPressed();
		return (event.isCanceled() || event.isTracking()); //Probably just want to get a taint bool from inside event
		// Original method
		/*
		{
        if (getApplicationInfo().targetSdkVersion
                >= Build.VERSION_CODES.ECLAIR) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    && !event.isCanceled()) {
                onBackPressed();
                return true;
            }
        }
        return false;
    }
		*/
	}

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)
     * KeyEvent.Callback.onKeyMultiple()}: always returns false (doesn't handle
     * the event).
     */
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.829 -0500", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "36A8C90D805E1CE396E3F79E76A992E5")
    
public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onBackPressed(){
        //We don't need to do anything in the model.  This method is only called
        //incase user code overrides this
        
		// Original method
		/*
		{
        if (!mFragments.popBackStackImmediate()) {
            finish();
        }
    }
		*/
		//Return nothing
	}

    /**
     * Called when a key shortcut event is not handled by any of the views in the Activity.
     * Override this method to implement global key shortcuts for the Activity.
     * Key shortcuts can also be implemented by setting the
     * {@link MenuItem#setShortcut(char, char) shortcut} property of menu items.
     *
     * @param keyCode The value in event.getKeyCode().
     * @param event Description of the key event.
     * @return True if the key shortcut was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.840 -0500", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "79AEB00DA58A022844D17B2E04B426A1")
    
public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return false;
    }
    
    public boolean onTouchEvent(MotionEvent event){
		finish();
		return mWindow.shouldCloseOnTouch(this, event); //Taint should bubble up
		// Original method
		/*
		{
        if (mWindow.shouldCloseOnTouch(this, event)) {
            finish();
            return true;
        }
        return false;
    }
		*/
	}
    
    /**
     * Called when the trackball was moved and not handled by any of the
     * views inside of the activity.  So, for example, if the trackball moves
     * while focus is on a button, you will receive a call here because
     * buttons do not normally do anything with trackball events.  The call
     * here happens <em>before</em> trackball movements are converted to
     * DPAD key events, which then get sent back to the view hierarchy, and
     * will be processed at the point for things like focus navigation.
     * 
     * @param event The trackball event being processed.
     * 
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.850 -0500", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "3CA4089EBE14436E733AD365EF1361B8")
    
public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }

    /**
     * Called when a generic motion event was not handled by any of the
     * views inside of the activity.
     * <p>
     * Generic motion events describe joystick movements, mouse hovers, track pad
     * touches, scroll wheel movements and other input events.  The
     * {@link MotionEvent#getSource() source} of the motion event specifies
     * the class of input that was received.  Implementations of this method
     * must examine the bits in the source before processing the event.
     * The following code example shows how this is done.
     * </p><p>
     * Generic motion events with source class
     * {@link android.view.InputDevice#SOURCE_CLASS_POINTER}
     * are delivered to the view under the pointer.  All other generic motion events are
     * delivered to the focused view.
     * </p><p>
     * See {@link View#onGenericMotionEvent(MotionEvent)} for an example of how to
     * handle this event.
     * </p>
     *
     * @param event The generic motion event being processed.
     *
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.855 -0500", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "FC042457DA14CABBB898ABC65A695166")
    
public boolean onGenericMotionEvent(MotionEvent event) {
        return false;
    }

    /**
     * Called whenever a key, touch, or trackball event is dispatched to the
     * activity.  Implement this method if you wish to know that the user has
     * interacted with the device in some way while your activity is running.
     * This callback and {@link #onUserLeaveHint} are intended to help
     * activities manage status bar notifications intelligently; specifically,
     * for helping activities determine the proper time to cancel a notfication.
     * 
     * <p>All calls to your activity's {@link #onUserLeaveHint} callback will
     * be accompanied by calls to {@link #onUserInteraction}.  This
     * ensures that your activity will be told of relevant user activity such
     * as pulling down the notification pane and touching an item there.
     * 
     * <p>Note that this callback will be invoked for the touch down action
     * that begins a touch gesture, but may not be invoked for the touch-moved
     * and touch-up actions that follow.
     * 
     * @see #onUserLeaveHint()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.860 -0500", hash_original_method = "787C037504CBD45EADF1B222AFA073D0", hash_generated_method = "B4B48F394538E36891FD4BDB1FBF3D63")
    
public void onUserInteraction() {
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public void onWindowAttributesChanged(WindowManager.LayoutParams params){
		mDecor.getParent();
		getWindowManager().updateViewLayout(mDecor, params);
		// Original method
		/*
		{
        if (mParent == null) {
            View decor = mDecor;
            if (decor != null && decor.getParent() != null) {
                getWindowManager().updateViewLayout(decor, params);
            }
        }
    }
		*/
		//Return nothing
	}

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.870 -0500", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "C45B7C15E316FF99AA579496D4660410")
    
public void onContentChanged() {
    }

    /**
     * Called when the current {@link Window} of the activity gains or loses
     * focus.  This is the best indicator of whether this activity is visible
     * to the user.  The default implementation clears the key tracking
     * state, so should always be called.
     * 
     * <p>Note that this provides information about global focus state, which
     * is managed independently of activity lifecycles.  As such, while focus
     * changes will generally have some relation to lifecycle changes (an
     * activity that is stopped will not generally get window focus), you
     * should not rely on any particular order between the callbacks here and
     * those in the other lifecycle methods such as {@link #onResume}.
     * 
     * <p>As a general rule, however, a resumed activity will have window
     * focus...  unless it has displayed other dialogs or popups that take
     * input focus, in which case the activity itself will not have focus
     * when the other windows have it.  Likewise, the system may display
     * system-level windows (such as the status bar notification panel or
     * a system alert) which will temporarily take window input focus without
     * pausing the foreground activity.
     *
     * @param hasFocus Whether the window of this activity has focus.
     * 
     * @see #hasWindowFocus()
     * @see #onResume
     * @see View#onWindowFocusChanged(boolean)
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.875 -0500", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "A78A7C6B763B8F194C5AA376EFC516AD")
    
public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    /**
     * Called when the main window associated with the activity has been
     * attached to the window manager.
     * See {@link View#onAttachedToWindow() View.onAttachedToWindow()}
     * for more information.
     * @see View#onAttachedToWindow
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.880 -0500", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "36EB06ADAB10E1C549B25F3883CC9A04")
    
public void onAttachedToWindow() {
    }
    
    /**
     * Called when the main window associated with the activity has been
     * detached from the window manager.
     * See {@link View#onDetachedFromWindow() View.onDetachedFromWindow()}
     * for more information.
     * @see View#onDetachedFromWindow
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.885 -0500", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "2C686A74CA98AB92B59E2086FB62185D")
    
public void onDetachedFromWindow() {
    }
    
    public boolean hasWindowFocus(){
		Window w = getWindow();
		View d = w.getDecorView();
		return d.hasWindowFocus();
		// Original method
		/*
		{
        Window w = getWindow();
        if (w != null) {
            View d = w.getDecorView();
            if (d != null) {
                return d.hasWindowFocus();
            }
        }
        return false;
    }
		*/
	}
    
    @DSComment("potential callback called inside method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSVerified
    public boolean dispatchKeyEvent(KeyEvent event){
		onUserInteraction();
		Window win = getWindow();
		View decor = mDecor;
		decor = win.getDecorView();
		return (win.superDispatchKeyEvent(event) || event.dispatch(this, decor.getKeyDispatcherState(), this));
		// Original method
		/*
		{
        onUserInteraction();
        Window win = getWindow();
        if (win.superDispatchKeyEvent(event)) {
            return true;
        }
        View decor = mDecor;
        if (decor == null) decor = win.getDecorView();
        return event.dispatch(this, decor != null
                ? decor.getKeyDispatcherState() : null, this);
    }
		*/
	}

    @DSSafe(DSCat.SAFE_LIST)
    @DSVerified
    public boolean dispatchKeyShortcutEvent(KeyEvent event){
		onUserInteraction();
		return (getWindow().superDispatchKeyShortcutEvent(event) || onKeyShortcut(event.getKeyCode(), event));
		// Original method
		/*
		{
        onUserInteraction();
        if (getWindow().superDispatchKeyShortcutEvent(event)) {
            return true;
        }
        return onKeyShortcut(event.getKeyCode(), event);
    }
		*/
	}
    
    @DSComment("potential callback called inside method")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified
    public boolean dispatchTouchEvent(MotionEvent ev){
		onUserInteraction();
		return (getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev));
		// Original method
		/*
		{
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            onUserInteraction();
        }
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }
		*/
	}
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSVerified
    public boolean dispatchTrackballEvent(MotionEvent ev){
		onUserInteraction();
		return (getWindow().superDispatchTrackballEvent(ev) || onTrackballEvent(ev));
		// Original method
		/*
		{
        onUserInteraction();
        if (getWindow().superDispatchTrackballEvent(ev)) {
            return true;
        }
        return onTrackballEvent(ev);
    }
		*/
	}
    
    @DSSafe(DSCat.SAFE_LIST)
    public boolean dispatchGenericMotionEvent(MotionEvent ev){
        onUserInteraction();
		return (getWindow().superDispatchGenericMotionEvent(ev) || onGenericMotionEvent(ev));
		// Original method
		/*
		{
        onUserInteraction();
        if (getWindow().superDispatchGenericMotionEvent(ev)) {
            return true;
        }
        return onGenericMotionEvent(ev);
    }
		*/
	}

    @DSSafe(DSCat.SAFE_LIST)
    @DSVerified
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event){
		event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        getWindow().getAttributes();
        event.setFullScreen(true);
        TextUtils.isEmpty("");
        event.getText().add(getTitle());
        return true;
		// Original method
		/*
		{
        event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
           event.getText().add(title);
        }
        return true;
    }
		*/
	}

    /**
     * Default implementation of
     * {@link android.view.Window.Callback#onCreatePanelView}
     * for activities. This
     * simply returns null so that all panel sub-windows will have the default
     * menu behavior.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.925 -0500", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "25B127EBCB57EFECBD95579CCC6F2900")
    
public View onCreatePanelView(int featureId) {
        return null;
    }
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onCreatePanelMenu(int featureId, Menu menu){
		return (onCreateOptionsMenu(menu) || mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater()));
		// Original method
		/*
		{
        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            boolean show = onCreateOptionsMenu(menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            return show;
        }
        return false;
    }
		*/
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onPreparePanel(int featureId, View view, Menu menu){
        return 1 == ((onPrepareOptionsMenu(menu) ? 1 : 0) + 
                     (mFragments.dispatchPrepareOptionsMenu(menu) ? 1 : 0)  + (((menu.hasVisibleItems())) ? 1 : 0));
		// Original method
		/*
		{
        if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            boolean goforit = onPrepareOptionsMenu(menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            return goforit && menu.hasVisibleItems();
        }
        return true;
    }
		*/
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onMenuOpened(int featureId, Menu menu){
		initActionBar();
		mActionBar.dispatchMenuVisibilityChanged(true);
		Log.e(TAG, "Tried to open action bar menu with no action bar");
		return true;
		// Original method
		/*
		{
        if (featureId == Window.FEATURE_ACTION_BAR) {
            initActionBar();
            if (mActionBar != null) {
                mActionBar.dispatchMenuVisibilityChanged(true);
            } else {
                Log.e(TAG, "Tried to open action bar menu with no action bar");
            }
        }
        return true;
    }
		*/
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onMenuItemSelected(int featureId, MenuItem item){
		EventLog.writeEvent(50000, 0, item.getTitleCondensed());
		return (onOptionsItemSelected(item) || mFragments.dispatchContextItemSelected(item));
		// Original method
		/*
		{
        switch (featureId) {
            case Window.FEATURE_OPTIONS_PANEL:
                EventLog.writeEvent(50000, 0, item.getTitleCondensed());
                if (onOptionsItemSelected(item)) {
                    return true;
                }
                return mFragments.dispatchOptionsItemSelected(item);
            case Window.FEATURE_CONTEXT_MENU:
                EventLog.writeEvent(50000, 1, item.getTitleCondensed());
                if (onContextItemSelected(item)) {
                    return true;
                }
                return mFragments.dispatchContextItemSelected(item);
            default:
                return false;
        }
    }
		*/
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onPanelClosed(int featureId, Menu menu){
		mFragments.dispatchOptionsMenuClosed(menu);
		onOptionsMenuClosed(menu);
		initActionBar();
        mActionBar.dispatchMenuVisibilityChanged(false);
		// Original method
		/*
		{
        switch (featureId) {
            case Window.FEATURE_OPTIONS_PANEL:
                mFragments.dispatchOptionsMenuClosed(menu);
                onOptionsMenuClosed(menu);
                break;
            case Window.FEATURE_CONTEXT_MENU:
                onContextMenuClosed(menu);
                break;
            case Window.FEATURE_ACTION_BAR:
                initActionBar();
                mActionBar.dispatchMenuVisibilityChanged(false);
                break;
        }
    }
		*/
		//Return nothing
	}

    /**
     * Declare that the options menu has changed, so should be recreated.
     * The {@link #onCreateOptionsMenu(Menu)} method will be called the next
     * time it needs to be displayed.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.957 -0500", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "D884060298BD2094521858E602829233")
    
public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onCreateOptionsMenu(Menu menu){
		return mParent.onCreateOptionsMenu(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onCreateOptionsMenu(menu);
        }
        return true;
    }
		*/
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onPrepareOptionsMenu(Menu menu){
		return mParent.onPrepareOptionsMenu(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onPrepareOptionsMenu(menu);
        }
        return true;
    }
		*/
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onOptionsItemSelected(MenuItem item){
		return mParent.onOptionsItemSelected(item);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onOptionsItemSelected(item);
        }
        return false;
    }
		*/
	}
    
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onOptionsMenuClosed(Menu menu){
		mParent.onOptionsMenuClosed(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            mParent.onOptionsMenuClosed(menu);
        }
    }
		*/
		//Return nothing
	}
    
    /**
     * Programmatically opens the options menu. If the options menu is already
     * open, this method does nothing.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.982 -0500", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "3C023A20572EFC197D0EAE2E2611F4F2")
    
public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void closeOptionsMenu(){
		// Original method
		/*
		{
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }
		*/
		//Return nothing
	}

    /**
     * Called when a context menu for the {@code view} is about to be shown.
     * Unlike {@link #onCreateOptionsMenu(Menu)}, this will be called every
     * time the context menu is about to be shown and should be populated for
     * the view (or item inside the view for {@link AdapterView} subclasses,
     * this can be found in the {@code menuInfo})).
     * <p>
     * Use {@link #onContextItemSelected(android.view.MenuItem)} to know when an
     * item has been selected.
     * <p>
     * It is not safe to hold onto the context menu after this method returns.
     * {@inheritDoc}
     */
    @DSVerified    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.992 -0500", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "1B44B70B0D6B4F288A41A01A283212DF")
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    }
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    public void registerForContextMenu(View view){
        // model the callbacks.  This code is sure to be missing things
        // There are many other types of views and adapters
        if (view instanceof AbsListView) {
            AbsListView alv = (AbsListView) view;
            if (alv.mAdapter instanceof CursorAdapter) {
                CursorAdapter ca = (CursorAdapter) alv.mAdapter;
                ca.bindView (view, this, ca.getCursor());
                ca.newView (this, ca.getCursor(), null);
            }
        }
		view.setOnCreateContextMenuListener(this);
		// Original method
		/*
		{
        view.setOnCreateContextMenuListener(this);
    }
		*/
		//Return nothing
	}
    
    /**
     * Prevents a context menu to be shown for the given view. This method will remove the
     * {@link OnCreateContextMenuListener} on the view.
     * 
     * @see #registerForContextMenu(View)
     * @param view The view that should stop showing a context menu.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.002 -0500", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "75D2DB67C93B9FA99A912C90753A67CE")
    
public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
    
    /**
     * Programmatically opens the context menu for a particular {@code view}.
     * The {@code view} should have been added via
     * {@link #registerForContextMenu(View)}.
     * 
     * @param view The view to show the context menu for.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.006 -0500", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "320EBE9DAC491AFFCE2D5802170E7386")
    
public void openContextMenu(View view) {
        view.showContextMenu();
    }
    
    /**
     * Programmatically closes the most recently opened context menu, if showing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.012 -0500", hash_original_method = "0F5BE8719D80390C88A4C0CDCF0E8C81", hash_generated_method = "0ACA5F612FBD92E336AFD53D86A3A209")
    
public void closeContextMenu() {
        mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified
    public boolean onContextItemSelected(MenuItem item){
		return mParent.onContextItemSelected(item);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onContextItemSelected(item);
        }
        return false;
    }
		*/
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified
    public void onContextMenuClosed(Menu menu){
		mParent.onContextMenuClosed(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            mParent.onContextMenuClosed(menu);
        }
    }
		*/
		//Return nothing
	}

    /**
     * @deprecated Old no-arguments version of {@link #onCreateDialog(int, Bundle)}.
     */
    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.026 -0500", hash_original_method = "5C4ABBE5E4F27E10ACC00467798D80D8", hash_generated_method = "9BF122C6459667CD41B62EBC07FD4E1C")
    
@Deprecated
    protected Dialog onCreateDialog(int id) {
        return null;
    }

    /**
     * Callback for creating dialogs that are managed (saved and restored) for you
     * by the activity.  The default implementation calls through to
     * {@link #onCreateDialog(int)} for compatibility.
     *
     * <em>If you are targeting {@link android.os.Build.VERSION_CODES#HONEYCOMB}
     * or later, consider instead using a {@link DialogFragment} instead.</em>
     *
     * <p>If you use {@link #showDialog(int)}, the activity will call through to
     * this method the first time, and hang onto it thereafter.  Any dialog
     * that is created by this method will automatically be saved and restored
     * for you, including whether it is showing.
     *
     * <p>If you would like the activity to manage saving and restoring dialogs
     * for you, you should override this method and handle any ids that are
     * passed to {@link #showDialog}.
     *
     * <p>If you would like an opportunity to prepare your dialog before it is shown,
     * override {@link #onPrepareDialog(int, Dialog, Bundle)}.
     *
     * @param id The id of the dialog.
     * @param args The dialog arguments provided to {@link #showDialog(int, Bundle)}.
     * @return The dialog.  If you return null, the dialog will not be created.
     *
     * @see #onPrepareDialog(int, Dialog, Bundle)
     * @see #showDialog(int, Bundle)
     * @see #dismissDialog(int)
     * @see #removeDialog(int)
     *
     * @deprecated Use the new {@link DialogFragment} class with
     * {@link FragmentManager} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.031 -0500", hash_original_method = "34E3D2628A4C0BFC6C20A449A8141897", hash_generated_method = "89B5A5F903C7FE6A743D1C5892B9317D")
    @DSVerified    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK) 
@Deprecated
    protected Dialog onCreateDialog(int id, Bundle args) {
        return onCreateDialog(id);
    }

    /**
     * @deprecated Old no-arguments version of
     * {@link #onPrepareDialog(int, Dialog, Bundle)}.
     */

    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.036 -0500", hash_original_method = "7779942926F36CBECCFB305682D0E188", hash_generated_method = "C3F52CD22FCD74D322864C49F353283D")
    
@Deprecated
    protected void onPrepareDialog(int id, Dialog dialog) {
        dialog.setOwnerActivity(this);
    }

    /**
     * Provides an opportunity to prepare a managed dialog before it is being
     * shown.  The default implementation calls through to
     * {@link #onPrepareDialog(int, Dialog)} for compatibility.
     * 
     * <p>
     * Override this if you need to update a managed dialog based on the state
     * of the application each time it is shown. For example, a time picker
     * dialog might want to be updated with the current time. You should call
     * through to the superclass's implementation. The default implementation
     * will set this Activity as the owner activity on the Dialog.
     * 
     * @param id The id of the managed dialog.
     * @param dialog The dialog.
     * @param args The dialog arguments provided to {@link #showDialog(int, Bundle)}.
     * @see #onCreateDialog(int, Bundle)
     * @see #showDialog(int)
     * @see #dismissDialog(int)
     * @see #removeDialog(int)
     *
     * @deprecated Use the new {@link DialogFragment} class with
     * {@link FragmentManager} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.042 -0500", hash_original_method = "5C5331293ECB563ADEBB709047E6FA90", hash_generated_method = "187B10D7012B64C19222392AB7B39983")
    @DSVerified    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Deprecated
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        onPrepareDialog(id, dialog);
    }

    /**
     * Simple version of {@link #showDialog(int, Bundle)} that does not
     * take any arguments.  Simply calls {@link #showDialog(int, Bundle)}
     * with null arguments.
     *
     * @deprecated Use the new {@link DialogFragment} class with
     * {@link FragmentManager} instead; this is also
     * available on older platforms through the Android compatibility package.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.047 -0500", hash_original_method = "C69337B465910082B7749F46A60AEA22", hash_generated_method = "A523825C3D07C3A197C2A716CB3C1348")
    
@Deprecated
    public final void showDialog(int id) {
        showDialog(id, null);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSVerified
    
    @Deprecated public final boolean showDialog(int id, Bundle args){
		mManagedDialogs = new SparseArray<ManagedDialog>();
		ManagedDialog md = mManagedDialogs.get(id);
		md = new ManagedDialog();
		md.mDialog = createDialog(id, null, args);
		mManagedDialogs.put(id, md);
		md.mArgs = args;
		onPrepareDialog(id, md.mDialog, args);
		return true;
		// Original method
		/*
		{
        if (mManagedDialogs == null) {
            mManagedDialogs = new SparseArray<ManagedDialog>();
        }
        ManagedDialog md = mManagedDialogs.get(id);
        if (md == null) {
            md = new ManagedDialog();
            md.mDialog = createDialog(id, null, args);
            if (md.mDialog == null) {
                return false;
            }
            mManagedDialogs.put(id, md);
        }
        md.mArgs = args;
        onPrepareDialog(id, md.mDialog, args);
        md.mDialog.show();
        return true;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Deprecated public final void dismissDialog(int id){
		final ManagedDialog md = mManagedDialogs.get(id);
		md.mDialog.dismiss();
		throw missingDialog(id);
		// Original method
		/*
		{
        if (mManagedDialogs == null) {
            throw missingDialog(id);
        }
        final ManagedDialog md = mManagedDialogs.get(id);
        if (md == null) {
            throw missingDialog(id);
        }
        md.mDialog.dismiss();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private IllegalArgumentException missingDialog(int id){
		return new IllegalArgumentException("");
		// Original method
		/*
		{
        return new IllegalArgumentException("no dialog with id " + id + " was ever "
                + "shown via Activity#showDialog");
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Deprecated public final void removeDialog(int id){
		final ManagedDialog md = mManagedDialogs.get(id);
		md.mDialog.dismiss();
        mManagedDialogs.remove(id);
		// Original method
		/*
		{
        if (mManagedDialogs != null) {
            final ManagedDialog md = mManagedDialogs.get(id);
            if (md != null) {
                md.mDialog.dismiss();
                mManagedDialogs.remove(id);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onSearchRequested(){
        startSearch(null, false, null, false); 
        return true;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.IPC})
    public void startSearch(String initialQuery, boolean selectInitialQuery, 
            Bundle appSearchData, boolean globalSearch){
    	//addTaint(initialQuery.getTaint());
    	//addTaint(selectInitialQuery);
    	//addTaint(appSearchData.getTaint());
    	//addTaint(globalSearch);
        ensureSearchManager();
        mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                                   appSearchData, globalSearch); 
		// Original method
		/*
		{
        ensureSearchManager();
        mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        appSearchData, globalSearch); 
    }
		*/
		//Return nothing
	}

    /**
     * Similar to {@link #startSearch}, but actually fires off the search query after invoking
     * the search dialog.  Made available for testing purposes.
     *
     * @param query The query to trigger.  If empty, the request will be ignored.
     * @param appSearchData An application can insert application-specific
     * context here, in order to improve quality or specificity of its own
     * searches.  This data will be returned with SEARCH intent(s).  Null if
     * no extra data is required.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.083 -0500", hash_original_method = "A3EE90277ACB35FF640742FD629291A1", hash_generated_method = "B7C24555719EF644D646061DEC0C31AD")
    
public void triggerSearch(String query, Bundle appSearchData) {
        ensureSearchManager();
        mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
    }

    /**
     * Request that key events come to this activity. Use this if your
     * activity has no views with focus, but the activity still wants
     * a chance to process key events.
     * 
     * @see android.view.Window#takeKeyEvents
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.088 -0500", hash_original_method = "0192041795732D663EE503A2AEC04112", hash_generated_method = "C9ED2C86AE5913A25CE19DBCFB36E6CB")
    
public void takeKeyEvents(boolean get) {
        getWindow().takeKeyEvents(get);
    }

    /**
     * Enable extended window features.  This is a convenience for calling
     * {@link android.view.Window#requestFeature getWindow().requestFeature()}.
     * 
     * @param featureId The desired feature as defined in
     *                  {@link android.view.Window}.
     * @return Returns true if the requested feature is supported and now
     *         enabled.
     * 
     * @see android.view.Window#requestFeature
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.093 -0500", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "881FBD2BDEED0015ADB64FC143BF0105")
    
public final boolean requestWindowFeature(int featureId) {
        return getWindow().requestFeature(featureId);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawableResource}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.097 -0500", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "77462D4BD7A21F99BAD57C59CACE9BF5")
    
public final void setFeatureDrawableResource(int featureId, int resId) {
        getWindow().setFeatureDrawableResource(featureId, resId);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawableUri}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.103 -0500", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "CA522E500B91F795335EC5BB8DD09937")
    
public final void setFeatureDrawableUri(int featureId, Uri uri) {
        getWindow().setFeatureDrawableUri(featureId, uri);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawable(int, Drawable)}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.108 -0500", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "845589EF459B40468B119030F6839003")
    
public final void setFeatureDrawable(int featureId, Drawable drawable) {
        getWindow().setFeatureDrawable(featureId, drawable);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawableAlpha}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.113 -0500", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "42B6BECB117F777AFB6F11B60A38D749")
    
public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#getLayoutInflater}.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.117 -0500", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "3A16D6A7B6ED88109371E767B4893157")
    
public LayoutInflater getLayoutInflater() {
        return getWindow().getLayoutInflater();
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    public MenuInflater getMenuInflater(){
		initActionBar();
		mMenuInflater = new MenuInflater(mActionBar.getThemedContext()); //DSFIXME:  Look at underlying method to determine if this can be colapsed.
		mMenuInflater = new MenuInflater(this);
		return mMenuInflater;
		// Original method
		/*
		{
        if (mMenuInflater == null) {
            initActionBar();
            if (mActionBar != null) {
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            } else {
                mMenuInflater = new MenuInflater(this);
            }
        }
        return mMenuInflater;
    }
		*/
	}
    
    @Override protected void onApplyThemeResource(Resources.Theme theme, int resid,
            boolean first){
		super.onApplyThemeResource(theme, resid, first);
		theme.setTo(mParent.getTheme());
		theme.applyStyle(resid, false);
		// Original method
		/*
		{
        if (mParent == null) {
            super.onApplyThemeResource(theme, resid, first);
        } else {
            try {
                theme.setTo(mParent.getTheme());
            } catch (Exception e) {
            }
            theme.applyStyle(resid, false);
        }
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.ANDROID_ACTIVITY_STARTING)
    @DSSink({DSSinkKind.IPC})
    public void startActivityForResult(Intent intent, int requestCode){
        intent.getAction();
        intent.getBooleanArrayExtra("");
        intent.getBooleanExtra("", false);
        intent.getBundleExtra("");

        intent.getFloatArrayExtra("");
        intent.getFloatExtra("", 0.0f);

        intent.getIntArrayExtra("");
        intent.getIntExtra("", 0);

        intent.getIntegerArrayListExtra("");
        intent.getExtras();

        intent.getLongArrayExtra("");
        intent.getLongExtra("", 0);

        intent.getParcelableArrayListExtra("");
        intent.getParcelableArrayExtra("");
        intent.getParcelableExtra("");

        intent.getShortArrayExtra("");
        intent.getShortExtra("", (short)0);

        intent.getStringExtra("");
        intent.getStringArrayExtra("");
        intent.getStringArrayListExtra("");

        intent.getCharExtra("", 'a');
        intent.getCharArrayExtra("");
        
        intent.getCharSequenceArrayExtra("");
        intent.getCharSequenceArrayListExtra("");
        intent.getCharSequenceExtra("");

        intent.getData();
        intent.getFlags();
        intent.getType();
        intent.getScheme();

        intent.addCategory(Intent.CATEGORY_DEFAULT);
        //intent.setData(Uri.parse(intent.getType()));
        
        this.onActivityResult(requestCode, /* just make this up */ -1,
				intent);


		// Original method
		/*
		{
        if (mParent == null) {
            Instrumentation.ActivityResult ar =
                mInstrumentation.execStartActivity(
                    this, mMainThread.getApplicationThread(), mToken, this,
                    intent, requestCode);
            if (ar != null) {
                mMainThread.sendActivityResult(
                    mToken, mEmbeddedID, requestCode, ar.getResultCode(),
                    ar.getResultData());
            }
            if (requestCode >= 0) {
                mStartedActivity = true;
            }
        } else {
            mParent.startActivityFromChild(this, intent, requestCode);
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    public void startIntentSenderForResult(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags){
		startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, this);
		mParent.startIntentSenderFromChild(this, intent, requestCode,
                fillInIntent, flagsMask, flagsValues, extraFlags);
		// Original method
		/*
		{
        if (mParent == null) {
            startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    flagsMask, flagsValues, this);
        } else {
            mParent.startIntentSenderFromChild(this, intent, requestCode,
                    fillInIntent, flagsMask, flagsValues, extraFlags);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void startIntentSenderForResultInner(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, Activity activity){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.ANDROID_ACTIVITY_STARTING)
    @DSSink({DSSinkKind.IPC})
    @Override public void startActivity(Intent intent){
    	
    	String result = intent.getAction() + intent.getDataString();
    	
        onActivityResult(-1, -1, intent);

        intent.addCategory(Intent.CATEGORY_DEFAULT);
	
        /*
         * This is called for activities that set launchMode to "singleTop" in
         * their package, or if a client used the {@link Intent#FLAG_ACTIVITY_SINGLE_TOP}
         * flag when calling {@link #startActivity}.  In either case, when the
         * activity is re-launched while at the top of the activity stack instead
         * of a new instance of the activity being started, onNewIntent() will be
         * called on the existing instance with the Intent that was used to
         * re-launch it */
        // on lauchmode to singleStop or SINGLE_ACTIVTY_SINGLE
        // if ((intent.getFlags() & Intent.FLAG_ACTIVITY_SINGLE_TOP) != 0) {
        // }
        onNewIntent(intent);
	
        // Original method
        /*
          {
        startActivityForResult(intent, -1);
        }
		*/
		//Return nothing

        intent.addCategory(Intent.CATEGORY_DEFAULT);

        intent.getAction();
        intent.getBooleanArrayExtra("");
        intent.getBooleanExtra("", false);
        intent.getBundleExtra("");

        intent.getFloatArrayExtra("");
        intent.getFloatExtra("", 0.0f);

        intent.getIntArrayExtra("");
        intent.getIntExtra("", 0);

        intent.getIntegerArrayListExtra("");
        intent.getExtras();

        intent.getLongArrayExtra("");
        intent.getLongExtra("", 0);

        intent.getParcelableArrayListExtra("");
        intent.getParcelableArrayExtra("");
        intent.getParcelableExtra("");

        intent.getShortArrayExtra("");
        intent.getShortExtra("", (short)0);

        intent.getStringExtra("");
        intent.getStringArrayExtra("");
        intent.getStringArrayListExtra("");

        intent.getCharExtra("", 'a');
        intent.getCharArrayExtra("");
        
        intent.getCharSequenceArrayExtra("");
        intent.getCharSequenceArrayListExtra("");
        intent.getCharSequenceExtra("");

        intent.getData();
        intent.getFlags();
        intent.getType();
        intent.getScheme();
    }

    /**
     * Launch a new activity.  You will not receive any information about when
     * the activity exits.  This implementation overrides the base version,
     * providing information about
     * the activity performing the launch.  Because of this additional
     * information, the {@link Intent#FLAG_ACTIVITY_NEW_TASK} launch flag is not
     * required; if not specified, the new activity will be added to the
     * task of the caller.
     *
     * <p>This method throws {@link android.content.ActivityNotFoundException}
     * if there was no Activity found to run the given Intent.
     *
     * @param intents The intents to start.
     *
     * @throws android.content.ActivityNotFoundException
     *
     * @see #startActivityForResult
     */
    @DSVerified
    @DSSpec(DSCat.ANDROID_ACTIVITY_STARTING)
    @DSSink({DSSinkKind.IPC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.156 -0500", hash_original_method = "E2A55AFC4750254BD88786F18353EE8B", hash_generated_method = "0DAB0CC521B4AF9EA1AD5FA3E319D475")
    @Override
    public void startActivities(Intent[] intents) {
        mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                mToken, this, intents);
        for (Intent intent: intents)
            startActivity(intent);
    }

    @DSVerified
    @DSSpec(DSCat.IPC)
    @DSSink({DSSinkKind.IPC})
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags){
		startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                flagsValues, extraFlags);
		// Original method
		/*
		{
        startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                flagsValues, extraFlags);
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    public boolean startActivityIfNeeded(Intent intent, int requestCode){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    public boolean startNextMatchingActivity(Intent intent){
		try {
            intent.setAllowFds(false);
            return ActivityManagerNative.getDefault()
                .startNextMatchingActivity(mToken, intent);
        } catch (RemoteException e) {
        }
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                intent.setAllowFds(false);
                return ActivityManagerNative.getDefault()
                    .startNextMatchingActivity(mToken, intent);
            } catch (RemoteException e) {
            }
            return false;
        }
        throw new UnsupportedOperationException(
            "startNextMatchingActivity can only be called from a top-level activity");
    }
		*/
		return false;
	}
    
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    public void startActivityFromChild(Activity child, Intent intent, 
            int requestCode){
		Instrumentation.ActivityResult ar =
	            mInstrumentation.execStartActivity(
	                this, mMainThread.getApplicationThread(), mToken, child,
	                intent, requestCode);
		mMainThread.sendActivityResult(
	                mToken, child.mEmbeddedID, requestCode,
	                ar.getResultCode(), ar.getResultData());
		// Original method
		/*
		{
        Instrumentation.ActivityResult ar =
            mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, child,
                intent, requestCode);
        if (ar != null) {
            mMainThread.sendActivityResult(
                mToken, child.mEmbeddedID, requestCode,
                ar.getResultCode(), ar.getResultData());
        }
    }
		*/
		//Return nothing
	}

    @DSVerified
    
    @DSSpec(DSCat.IPC)
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode){
        fragment.onActivityCreated(new Bundle());
        fragment.onActivityResult(DSUtils.FAKE_INT, DSUtils.FAKE_INT, intent);
	    /*
		Instrumentation.ActivityResult ar =
	            mInstrumentation.execStartActivity(
	                this, mMainThread.getApplicationThread(), mToken, fragment,
	                intent, requestCode);
		mMainThread.sendActivityResult(
                mToken, fragment.mWho, requestCode,
                ar.getResultCode(), ar.getResultData());
        */        
		// Original method
		/*
		{
        Instrumentation.ActivityResult ar =
            mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, fragment,
                intent, requestCode);
        if (ar != null) {
            mMainThread.sendActivityResult(
                mToken, fragment.mWho, requestCode,
                ar.getResultCode(), ar.getResultData());
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    public void startIntentSenderFromChild(Activity child, IntentSender intent,
            int requestCode, Intent fillInIntent, int flagsMask, int flagsValues,
            int extraFlags){
		startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, child);
		// Original method
		/*
		{
        startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, child);
    }
		*/
		//Return nothing
	}

    /**
     * Call immediately after one of the flavors of {@link #startActivity(Intent)}
     * or {@link #finish} to specify an explicit transition animation to
     * perform next.
     * @param enterAnim A resource ID of the animation resource to use for
     * the incoming activity.  Use 0 for no animation.
     * @param exitAnim A resource ID of the animation resource to use for
     * the outgoing activity.  Use 0 for no animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.192 -0500", hash_original_method = "0CB07497B5E56C46E5A71AB5CB4CC143", hash_generated_method = "5ECA4772B049F342D9B4EE8C0BFC77B5")
    
public void overridePendingTransition(int enterAnim, int exitAnim) {
        try {
            ActivityManagerNative.getDefault().overridePendingTransition(
                    mToken, getPackageName(), enterAnim, exitAnim);
        } catch (RemoteException e) {
        }
    }
    
    @DSComment("Normal GUI")
    @DSSpec(DSCat.IPC)
    @DSSink(DSSinkKind.IPC)
    public final void setResult(int resultCode){
        mResultCode = resultCode;
        //addTaint(resultCode);
        // Original method
        /*
          {
          synchronized (this) {
          mResultCode = resultCode;
          mResultData = null;
          }
          }
		*/
		//Return nothing
	}
    
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.IPC)
    @DSSink(DSSinkKind.IPC)
    public final void setResult(int resultCode, Intent data){
        //addTaint(resultCode);
        mResultData = data;
        mResultCode = resultCode;
        // Original method
        /*
          {
          synchronized (this) {
          mResultCode = resultCode;
          mResultData = data;
          }
          }
		*/
		//Return nothing
	}

    /**
     * Return the name of the package that invoked this activity.  This is who
     * the data in {@link #setResult setResult()} will be sent to.  You can
     * use this information to validate that the recipient is allowed to
     * receive the data.
     * 
     * <p>Note: if the calling activity is not expecting a result (that is it
     * did not use the {@link #startActivityForResult} 
     * form that includes a request code), then the calling package will be 
     * null. 
     * 
     * @return The package of the activity that will receive your
     *         reply, or null if none.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.207 -0500", hash_original_method = "88476E01B039440C5805C3F210A00F20", hash_generated_method = "58BEC1DE13ECDF0590CAF7A4888B9BD6")
    
public String getCallingPackage() {
        try {
            return ActivityManagerNative.getDefault().getCallingPackage(mToken);
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Return the name of the activity that invoked this activity.  This is
     * who the data in {@link #setResult setResult()} will be sent to.  You
     * can use this information to validate that the recipient is allowed to
     * receive the data.
     * 
     * <p>Note: if the calling activity is not expecting a result (that is it
     * did not use the {@link #startActivityForResult} 
     * form that includes a request code), then the calling package will be 
     * null. 
     * 
     * @return String The full name of the activity that will receive your
     *         reply, or null if none.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.212 -0500", hash_original_method = "BA5844B2C9F3C6D12393731B7AECDFB9", hash_generated_method = "7A4424A9746EA476713AFC880E62344D")
    
public ComponentName getCallingActivity() {
        try {
            return ActivityManagerNative.getDefault().getCallingActivity(mToken);
        } catch (RemoteException e) {
            return null;
        }
    }
    
    public void setVisible(boolean visible){
        //addTaint(visible);
        makeVisible();
        mDecor.setVisibility(View.INVISIBLE);
        // Original method
		/*
		{
        if (mVisibleFromClient != visible) {
            mVisibleFromClient = visible;
            if (mVisibleFromServer) {
                if (visible) makeVisible();
                else mDecor.setVisibility(View.INVISIBLE);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void makeVisible(){
		ViewManager wm = getWindowManager();
        wm.addView(mDecor, getWindow().getAttributes());
		mDecor.setVisibility(View.VISIBLE);
		// Original method
		/*
		{
        if (!mWindowAdded) {
            ViewManager wm = getWindowManager();
            wm.addView(mDecor, getWindow().getAttributes());
            mWindowAdded = true;
        }
        mDecor.setVisibility(View.VISIBLE);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isFinishing(){
        return mFinished;
    }
    
    public boolean isChangingConfigurations(){
        return mChangingConfigurations;
	}
    
    @DSSafe(DSCat.SAFE_LIST)
    public void recreate(){
		mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
		// Original method
		/*
		{
        if (mParent != null) {
            throw new IllegalStateException("Can only be called on top-level activity");
        }
        if (Looper.myLooper() != mMainThread.getLooper()) {
            throw new IllegalStateException("Must be called from main thread");
        }
        mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void finish(){
		Log.v(TAG, "Finishing self: token=" + mToken);
		mResultData.setAllowFds(false);
		try {
		ActivityManagerNative.getDefault()
        .finishActivity(mToken, mResultCode, mResultData);
		} catch (RemoteException e) {
        }
		mParent.finishFromChild(this);
		// Original method
		/*
		{
        if (mParent == null) {
            int resultCode;
            Intent resultData;
            synchronized (this) {
                resultCode = mResultCode;
                resultData = mResultData;
            }
            if (false) Log.v(TAG, "Finishing self: token=" + mToken);
            try {
                if (resultData != null) {
                    resultData.setAllowFds(false);
                }
                if (ActivityManagerNative.getDefault()
                    .finishActivity(mToken, resultCode, resultData)) {
                    mFinished = true;
                }
            } catch (RemoteException e) {
            }
        } else {
            mParent.finishFromChild(this);
        }
    }
		*/
		//Return nothing
	}

    /**
     * This is called when a child activity of this one calls its 
     * {@link #finish} method.  The default implementation simply calls
     * finish() on this activity (the parent), finishing the entire group.
     * 
     * @param child The activity making the call.
     * 
     * @see #finish
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.248 -0500", hash_original_method = "75F7E4E1E03EB9263BD8694C580B708B", hash_generated_method = "DB3A6A9A763C9F1A0F6FD7BABEAE7561")
    
public void finishFromChild(Activity child) {
        finish();
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public void finishAffinity() {
        
    }

    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void finishActivity(int requestCode){
		try {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, mEmbeddedID, requestCode);
        } catch (RemoteException e) {
        }
		mParent.finishActivityFromChild(this, requestCode);
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                ActivityManagerNative.getDefault()
                    .finishSubActivity(mToken, mEmbeddedID, requestCode);
            } catch (RemoteException e) {
            }
        } else {
            mParent.finishActivityFromChild(this, requestCode);
        }
    }
		*/
		//Return nothing
	}

    /**
     * This is called when a child activity of this one calls its
     * finishActivity().
     * 
     * @param child The activity making the call.
     * @param requestCode Request code that had been used to start the
     *                    activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.258 -0500", hash_original_method = "78F43A087FD65470CED68BD5979667B7", hash_generated_method = "A92D4CFE646C2B67AF06261CC970642D")
    
public void finishActivityFromChild(Activity child, int requestCode) {
        try {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        } catch (RemoteException e) {
            // Empty
        }
    }

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     * 
     * <p>You will receive this call immediately before onResume() when your
     * activity is re-starting.
     * 
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data An Intent, which can return result data to the caller
     *               (various data can be attached to Intent "extras").
     * 
     * @see #startActivityForResult
     * @see #createPendingResult
     * @see #setResult(int)
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.263 -0500", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "62DF0F5F92A373B4F8B7952D89BB1F57")
    @DSVerified("Activity Callback")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
    
    public PendingIntent createPendingResult(int requestCode, Intent data,
            int flags){
		String packageName = getPackageName();
		IIntentSender target = null;
		try {
            data.setAllowFds(false);
            target =
                ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);
		} catch (RemoteException e) {
        }
		return new PendingIntent(target);
		// Original method
		/*
		{
        String packageName = getPackageName();
        try {
            data.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setRequestedOrientation(int requestedOrientation){
		try {
            ActivityManagerNative.getDefault().setRequestedOrientation(
                    mToken, requestedOrientation);
        } catch (RemoteException e) {
        }
		mParent.setRequestedOrientation(requestedOrientation);
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                ActivityManagerNative.getDefault().setRequestedOrientation(
                        mToken, requestedOrientation);
            } catch (RemoteException e) {
            }
        } else {
            mParent.setRequestedOrientation(requestedOrientation);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getRequestedOrientation(){
		int retval = 0;
		try {
			retval = ActivityManagerNative.getDefault().getRequestedOrientation(mToken) + mParent.getRequestedOrientation();
		} catch (RemoteException e) {
        }
		return retval;
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                return ActivityManagerNative.getDefault()
                        .getRequestedOrientation(mToken);
            } catch (RemoteException e) {
            }
        } else {
            return mParent.getRequestedOrientation();
        }
        return ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    }
		*/
	}
    
    /**
     * Return the identifier of the task this activity is in.  This identifier
     * will remain the same for the lifetime of the activity.
     * 
     * @return Task identifier, an opaque integer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.284 -0500", hash_original_method = "617D78E91C885EF783A85ACE788D978C", hash_generated_method = "68BFF31C59FC4A6126A189C753232C0A")
    
public int getTaskId() {
        try {
            return ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, false);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * Return whether this activity is the root of a task.  The root is the
     * first activity in a task.
     * 
     * @return True if this is the root activity, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.289 -0500", hash_original_method = "6E45F873D7236EF61D26B672F842F45F", hash_generated_method = "8A48D7EBC73346FA52A5B1121B779FE6")
    
public boolean isTaskRoot() {
        try {
            return ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, true) >= 0;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Move the task containing this activity to the back of the activity
     * stack.  The activity's order within the task is unchanged.
     * 
     * @param nonRoot If false then this only works if the activity is the root
     *                of a task; if true it will work for any activity in
     *                a task.
     * 
     * @return If the task was moved (or it was already at the
     *         back) true is returned, else false.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.293 -0500", hash_original_method = "9A59EFD62BA4B2B1BB27D9BF60C81F37", hash_generated_method = "9A63345DB58A1324761EA6E89EC078E6")
    
public boolean moveTaskToBack(boolean nonRoot) {
        try {
            return ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    mToken, nonRoot);
        } catch (RemoteException e) {
            // Empty
        }
        return false;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getLocalClassName(){
		return mComponent.getClassName();
		// Original method
		/*
		{
        final String pkg = getPackageName();
        final String cls = mComponent.getClassName();
        int packageLen = pkg.length();
        if (!cls.startsWith(pkg) || cls.length() <= packageLen
                || cls.charAt(packageLen) != '.') {
            return cls;
        }
        return cls.substring(packageLen+1);
    }
		*/
	}
    
    /**
     * Returns complete component name of this activity.
     * 
     * @return Returns the complete component name for this activity
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.304 -0500", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "0218C20A36476A71EF5D80D906810879")
    
public ComponentName getComponentName()
    {
        return mComponent;
    }

    /**
     * Retrieve a {@link SharedPreferences} object for accessing preferences
     * that are private to this activity.  This simply calls the underlying
     * {@link #getSharedPreferences(String, int)} method by passing in this activity's
     * class name as the preferences name.
     * 
     * @param mode Operating mode.  Use {@link #MODE_PRIVATE} for the default 
     *             operation, {@link #MODE_WORLD_READABLE} and 
     *             {@link #MODE_WORLD_WRITEABLE} to control permissions.
     *
     * @return Returns the single SharedPreferences instance that can be used
     *         to retrieve and modify the preference values.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.308 -0500", hash_original_method = "8FF11253989B916424A8F19A417B9894", hash_generated_method = "6A7862010CB94E91BABA8CAE44E8E9B2")
    
public SharedPreferences getPreferences(int mode) {
        return getSharedPreferences(getLocalClassName(), mode);
    }
    
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void ensureSearchManager(){
		mSearchManager = new SearchManager(this, null);
		// Original method
		/*
		{
        if (mSearchManager != null) {
            return;
        }
        mSearchManager = new SearchManager(this, null);
    }
		*/
		//Return nothing
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @Override public Object getSystemService(String name){
       
        if (DroidSafeAndroidRuntime.control || getBaseContext()==null) {
             IllegalStateException exception = new IllegalStateException(
                    "System services not available to Activities before onCreate()");
                 //exception.addTaint(getTaint());
        }

        if (name.equals(SEARCH_SERVICE)) {
            ensureSearchManager();
                //mSearchManager.addTaint(getTaint());
            return mSearchManager;
        }
        
        if (name.equals(WINDOW_SERVICE)) {
            //mWindowManager.addTaint(getTaint());
            return mWindowManager;
        }

		return super.getSystemService(name);
		// Original method
		/*
		{
        if (getBaseContext() == null) {
           
        }
        if (WINDOW_SERVICE.equals(name)) {
            return mWindowManager;
        } else if (SEARCH_SERVICE.equals(name)) {
            ensureSearchManager();
            return mSearchManager;
        }
        return super.getSystemService(name);
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSVerified
    public void setTitle(CharSequence title){
		mTitle = title;  //Preserved
		onTitleChanged(title, mTitleColor);
		mParent.onChildTitleChanged(this, title);
		// Original method
		/*
		{
        mTitle = title;
        onTitleChanged(title, mTitleColor);
        if (mParent != null) {
            mParent.onChildTitleChanged(this, title);
        }
    }
		*/
		//Return nothing
	}

    /**
     * Change the title associated with this activity.  If this is a
     * top-level activity, the title for its window will change.  If it
     * is an embedded activity, the parent can do whatever it wants
     * with it.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.328 -0500", hash_original_method = "A39F8277E51A7F6BD4A471D6255FEBC5", hash_generated_method = "7A9BBE5713B6FFC0915F0D939CBD832F")
    
public void setTitle(int titleId) {
        setTitle(getText(titleId));
    }
    
    public void setTitleColor(int textColor){
        mTitleColor = textColor;
        onTitleChanged(mTitle, textColor);
	}

    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.337 -0500", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "8E68CAEF2DE68CDDD808B8D3534F95EE")
    
public final CharSequence getTitle() {
        return mTitle;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getTitleColor(){
        return         mTitleColor;
	}
    
    @DSSpec(DSCat.IPC)
    
    public boolean navigateUpTo (Intent upIntent) {
        return getTaintBoolean();
    }

    @DSComment("Only checking on the intent, no action associated with it")
    @DSSafe(DSCat.SAFE_OTHERS)
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        return getTaintBoolean();
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    protected void onTitleChanged(CharSequence title, int color){
		final Window win = getWindow();
		win.setTitle(title);
		win.setTitleColor(color);
		// Original method
		/*
		{
        if (mTitleReady) {
            final Window win = getWindow();
            if (win != null) {
                win.setTitle(title);
                if (color != 0) {
                    win.setTitleColor(color);
                }
            }
        }
    }
		*/
		//Return nothing
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.351 -0500", hash_original_method = "7A7CC5A839395F1C996BC46DE28C9533", hash_generated_method = "88EB88E01641F6BC919271D10A94EC08")
    
protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    public final void setProgressBarVisibility(boolean visible){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            Window.PROGRESS_VISIBILITY_OFF);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    public final void setProgressBarIndeterminateVisibility(boolean visible){
		getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    public final void setProgressBarIndeterminate(boolean indeterminate){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_INDETERMINATE_ON);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    public final void setProgress(int progress){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_START);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void setSecondaryProgress(int secondaryProgress){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_SECONDARY_START);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                secondaryProgress + Window.PROGRESS_SECONDARY_START);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    public final void setVolumeControlStream(int streamType){
		getWindow().setVolumeControlStream(0);
		// Original method
		/*
		{
        getWindow().setVolumeControlStream(streamType);
    }
		*/
		//Return nothing
	}

    /**
     * Gets the suggested audio stream whose volume should be changed by the
     * harwdare volume controls.
     * 
     * @return The suggested audio stream type whose volume should be changed by
     *         the hardware volume controls.
     * @see #setVolumeControlStream(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.385 -0500", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "0A136881DA0A667DEE6F55CE255E857C")
    
public final int getVolumeControlStream() {
        return getWindow().getVolumeControlStream();
    }
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void runOnUiThread(Runnable action){
		mHandler.post(action);
		action.run();
		// Original method
		/*
		{
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(action);
        } else {
            action.run();
        }
    }
		*/
		//Return nothing
	}
    
	@DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public View onCreateView(String name, Context context, AttributeSet attrs){
		// Original method
		/*
		{
        return null;
    }
		*/
		return new View(context);
	}
    
	@DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return new View(context);
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    /**
     * Bit indicating that this activity is "immersive" and should not be
     * interrupted by notifications if possible.
     *
     * This value is initially set by the manifest property
     * <code>android:immersive</code> but may be changed at runtime by
     * {@link #setImmersive}.
     *
     * @see android.content.pm.ActivityInfo#FLAG_IMMERSIVE
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.415 -0500", hash_original_method = "F5F1BD517EE731E56F922C1A6872A499", hash_generated_method = "8A12328B549C8C433688BB943DEA9B73")
    
public boolean isImmersive() {
        try {
            return ActivityManagerNative.getDefault().isImmersive(mToken);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Adjust the current immersive mode setting.
     * 
     * Note that changing this value will have no effect on the activity's
     * {@link android.content.pm.ActivityInfo} structure; that is, if
     * <code>android:immersive</code> is set to <code>true</code>
     * in the application's manifest entry for this activity, the {@link
     * android.content.pm.ActivityInfo#flags ActivityInfo.flags} member will
     * always have its {@link android.content.pm.ActivityInfo#FLAG_IMMERSIVE
     * FLAG_IMMERSIVE} bit set.
     *
     * @see #isImmersive
     * @see android.content.pm.ActivityInfo#FLAG_IMMERSIVE
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.419 -0500", hash_original_method = "9D8EB8E29C9BCD315046F1934B1FF39B", hash_generated_method = "AC115FCF99656DD6FC8752FD11A99796")
    
public void setImmersive(boolean i) {
        try {
            ActivityManagerNative.getDefault().setImmersive(mToken, i);
        } catch (RemoteException e) {
            // pass
        }
    }
    @DSVerified    
    @DSComment("normal android callback registration")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    /**
     * Start an action mode.
     *
     * @param callback Callback that will manage lifecycle events for this context mode
     * @return The ContextMode that was started, or null if it was canceled
     *
     * @see ActionMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.423 -0500", hash_original_method = "2C973E12746FE944D244FE9652432CFA", hash_generated_method = "426310D8B485F00F6CAE4106DF9E1A43")
    
public ActionMode startActionMode(ActionMode.Callback callback) {

        ActionMode actionMode = new ActionMode.SimpleActionMode();
        actionMode.setTag(callback);
        onActionModeStarted(actionMode);
        //return mWindow.getDecorView().startActionMode(callback);
        return actionMode;
    }
    
    private static class ManagedDialog {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.048 -0500", hash_original_field = "0C87BCBAF0D95855709E5BEE2BDBA46D", hash_generated_field = "0C87BCBAF0D95855709E5BEE2BDBA46D")

        Dialog mDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.054 -0500", hash_original_field = "7B435E447280D5DC4E48D52C3AACF101", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        
        @DSComment("Private Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.926 -0400", hash_original_method = "9DCA77B5D1234925DAEE8DA8399779D6", hash_generated_method = "9DCA77B5D1234925DAEE8DA8399779D6")
        public ManagedDialog ()
        {
            //Synthesized constructor
        }

    }
    
    static final class NonConfigurationInstances {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.220 -0500", hash_original_field = "AE7D68ABA75D09946A953E289939C500", hash_generated_field = "AE7D68ABA75D09946A953E289939C500")

        Object activity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.226 -0500", hash_original_field = "39C55DEAC9D9B669F0F104569866C7D7", hash_generated_field = "39C55DEAC9D9B669F0F104569866C7D7")

        HashMap<String, Object> children;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.232 -0500", hash_original_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF", hash_generated_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF")

        ArrayList<Fragment> fragments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.238 -0500", hash_original_field = "D5FA06C5EF7E6F3388FB9592AB447362", hash_generated_field = "D5FA06C5EF7E6F3388FB9592AB447362")

        SparseArray<LoaderManagerImpl> loaders;
        
        @DSComment("Package priviledge")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.926 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            //Synthesized constructor
        }

    }
    
    private static final class ManagedCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.341 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

        private  Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.350 -0500", hash_original_field = "3516BB00C88A3ED425D4982D5AEEABA2", hash_generated_field = "6C470EAC7065369BBFA5B5575968482A")

        private boolean mReleased;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:47:59.357 -0500", hash_original_field = "0470D1F67FBEBB7F411C1B6CFDAAD25E", hash_generated_field = "823188B97D251C7D61AAB004C3DA6C8F")

        private boolean mUpdated;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        ManagedCursor(Cursor cursor){
			mCursor = cursor;
			/*
			mCursor = cursor;
			mReleased = false;
			mUpdated = false;
			*/
		}
        
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback){
		initActionBar();
		return mActionBar.startActionMode(callback);
		// Original method
		/*
		{
        initActionBar();
        if (mActionBar != null) {
            return mActionBar.startActionMode(callback);
        }
        return null;
    }
		*/
	}

    @DSVerified    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    /**
     * Notifies the Activity that an action mode has been started.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The new action mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.433 -0500", hash_original_method = "255BA88D048ED7CA66014BFC1FF334C0", hash_generated_method = "59326024C2A90147ADE5F72F14E6828B")
public void onActionModeStarted(ActionMode mode) {
        Object callbackTag = mode.getTag();
        if (callbackTag != null && callbackTag instanceof ActionMode.Callback) {
            ActionMode.Callback callback = (ActionMode.Callback) callbackTag;
            MenuBuilder builder = new MenuBuilder(getBaseContext());
        //technically we should use the menu from external source
            Menu menu = builder.addSubMenu(DSUtils.FAKE_INT);
            MenuItem menuItem = menu.add(DSUtils.FAKE_INT);
            callback.onCreateActionMode(mode, menu);
            callback.onPrepareActionMode(mode, menu);
            callback.onActionItemClicked(mode, menuItem);  
            callback.onDestroyActionMode(mode);
        }
    }

    /**
     * Notifies the activity that an action mode has finished.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The action mode that just finished.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.437 -0500", hash_original_method = "731D5E497065CC7A99050B1E6205CD2C", hash_generated_method = "9F51E8ED2FF8704FC9CD4009EAD434EE")
    
public void onActionModeFinished(ActionMode mode) {
    }

    // ------------------ Internal API ------------------
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.441 -0500", hash_original_method = "CB0EFE3ADA1587CB31B88C9EC51AC6CD", hash_generated_method = "5BB1E580174D709D7209019836E22001")
    
final void setParent(Activity parent) {
        mParent = parent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.447 -0500", hash_original_method = "F5D036702945AFC6D1167650D88CF89C", hash_generated_method = "7F21D6113523EF47484DC91F76C16860")
    
final void attach(Context context, ActivityThread aThread, Instrumentation instr, IBinder token,
            Application application, Intent intent, ActivityInfo info, CharSequence title, 
            Activity parent, String id, NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            lastNonConfigurationInstances, config);
    }
    
	final void attach(Context context, ActivityThread aThread,
            Instrumentation instr, IBinder token, int ident,
            Application application, Intent intent, ActivityInfo info,
            CharSequence title, Activity parent, String id,
            NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config){
		mMainThread = aThread;  //Preserved
		mInstrumentation = instr;  //Preserved
		mToken = token;  //Preserved
		//addTaint(ident);
		mApplication = application;  //Preserved
		mIntent = intent;  //Preserved
		mActivityInfo = info;  //Preserved
		mTitle = title;  //Preserved
		mParent = parent;  //Preserved
		//addTaint(id.getTaint());
		mLastNonConfigurationInstances = lastNonConfigurationInstances;  //Preserved
		mCurrentConfig = config;  //Preserved
		attachBaseContext(context);
		mFragments.attachActivity(this);
		mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.getLayoutInflater().setPrivateFactory(this);
        mWindow.setSoftInputMode(info.softInputMode);
        mWindow.setWindowManager(null, token, intent.getComponent().flattenToString(),
                (info.flags & ActivityInfo.FLAG_HARDWARE_ACCELERATED) != 0);
        mWindow.setContainer(parent.getWindow());
        mWindowManager = mWindow.getWindowManager();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    final IBinder getActivityToken(){
		return mParent.getActivityToken();
		// Original method
		/*
		{
        return mParent != null ? mParent.getActivityToken() : mToken;
    }
		*/
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.919 -0400", hash_original_method = "DAB379B095765C858B51976FA2FCF6E4", hash_generated_method = "B85FC9CA5FD75BC2569BC7FE820DA2C6")
    final void performCreate(Bundle icicle) {
        performCreate(icicle, this);
        // ---------- Original Method ----------
        //onCreate(icicle);
        //mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                //com.android.internal.R.styleable.Window_windowNoDisplay, false);
        //mFragments.dispatchActivityCreated();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final void performStart(){
		mFragments.noteStateNotSaved();
		mFragments.execPendingActions();
		mInstrumentation.callActivityOnStart(this);
		mFragments.dispatchStart();
		LoaderManagerImpl lm = mAllLoaderManagers.valueAt(0);
        lm.finishRetain();
        lm.doReportStart();
		// Original method
		/*
		{
        mFragments.noteStateNotSaved();
        mCalled = false;
        mFragments.execPendingActions();
        mInstrumentation.callActivityOnStart(this);
        if (!mCalled) {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onStart()");
        }
        mFragments.dispatchStart();
        if (mAllLoaderManagers != null) {
            for (int i=mAllLoaderManagers.size()-1; i>=0; i--) {
                LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
                lm.finishRetain();
                lm.doReportStart();
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final void performRestart(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final void performResume(){
		performRestart();
		mFragments.execPendingActions();
		mInstrumentation.callActivityOnResume(this);
		mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
		// Original method
		/*
		{
        performRestart();
        mFragments.execPendingActions();
        mLastNonConfigurationInstances = null;
        mCalled = false;
        mInstrumentation.callActivityOnResume(this);
        if (!mCalled) {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onResume()");
        }
        mCalled = false;
        mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
        if (!mCalled) {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onPostResume()");
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final void performPause(){
		mFragments.dispatchPause();
		onPause();
		getApplicationInfo();
		// Original method
		/*
		{
        mFragments.dispatchPause();
        mCalled = false;
        onPause();
        mResumed = false;
        if (!mCalled && getApplicationInfo().targetSdkVersion
                >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onPause()");
        }
        mResumed = false;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:48:00.503 -0500", hash_original_method = "ABDB3944564BF35742E6297221FCB3EA", hash_generated_method = "311E01E06ECE3930B1BDA06564246C07")
    
final void performUserLeaving() {
        onUserInteraction();
        onUserLeaveHint();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final void performStop(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    final void performDestroy(){
		mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
        mLoaderManager.doDestroy();
		// Original method
		/*
		{
        mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
        if (mLoaderManager != null) {
            mLoaderManager.doDestroy();
        }
    }
		*/
		//Return nothing
	}
    
    public final boolean isResumed(){
        return mResumed;
    }
    
    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void dispatchActivityResult(String who, int requestCode, 
        int resultCode, Intent data){
		 Log.v(
		            TAG, "Dispatching result: who=" + who + ", reqCode=" + requestCode
		            + ", resCode=" + resultCode + ", data=" + data);
		mFragments.noteStateNotSaved();
		onActivityResult(requestCode, resultCode, data);
		Fragment frag = mFragments.findFragmentByWho(who);
		frag.onActivityResult(requestCode, resultCode, data);
		// Original method
		/*
		{
        if (false) Log.v(
            TAG, "Dispatching result: who=" + who + ", reqCode=" + requestCode
            + ", resCode=" + resultCode + ", data=" + data);
        mFragments.noteStateNotSaved();
        if (who == null) {
            onActivityResult(requestCode, resultCode, data);
        } else {
            Fragment frag = mFragments.findFragmentByWho(who);
            if (frag != null) {
                frag.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
		*/
		//Return nothing
	}
    // orphaned legacy method
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
	public void droidsafeOnDestroy() {
		onDestroy();
	}

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    // orphaned legacy method
     //called by dsruntime to perform the onCreate
	public final void performCreate(Bundle icicle, Context context){
        //addTaint(icicle.getTaint());
        //addTaint(context.getTaint());
		mIntent = droidsafeGetIntent();

		this.attachBaseContext(context);
		onCreate(icicle);
		onStart();
		onPostCreate(icicle);
		mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);

		// attach ativiity to the fragments
		mFragments.attachActivity(this);
		mFragments.dispatchActivityCreated();
		// Original method
		/*
		{
        onCreate(icicle);
        mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
        mFragments.dispatchActivityCreated();
    }
		*/
		//Return nothing
	}
    
    // orphaned legacy method
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeOnResume() {
		//This method is called by droidsafe itself, and should NEVER be called by an app
    	onResume();
		mFragments.dispatchResume();
    }
    
    // orphaned legacy method
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeOnStop() {
		//This method is called by droidsafe itself, and should NEVER be called by an app
    	onStop();
		mFragments.dispatchStop();
    }

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeOnRestart() {
		//This method is called by droidsafe itself, and should NEVER be called by an app
    	onRestart();
    }
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void setApplication(Application app) { 
            this.mApplication = app;
    }
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
	public void droidsafeOnSavedInstanceState(Bundle b) {
    	this.onSaveInstanceState(b);
	}
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
	public void droidsafeOnPause() {
    	this.onPause();
	}
    
    /**
     * addition hooks to allow subactivity onXYZ to be called from droidsafe runtime
     */
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
	public void droidsafeSubActivityCallbackHook() {
        droidsafeOnOthersHook();
	}
    
	@DSVerified
	@DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeOnOthersHook() {

        this.onAttachFragment(Fragment.instantiate(getBaseContext(), new String()));

        MenuBuilder builder = new MenuBuilder(getBaseContext());
        //technically we should use the menu from external source
        Menu menu = builder.addSubMenu(DSUtils.FAKE_INT);
        this.onCreateOptionsMenu(menu);
        menu = builder.addSubMenu(DSUtils.FAKE_INT);
        this.onPrepareOptionsMenu(menu);
        this.onMenuOpened(DSUtils.FAKE_INT, menu);
        this.onContextMenuClosed(menu);
        menu = builder.addSubMenu(DSUtils.FAKE_INT);
        this.onContextItemSelected(menu.add(new String()));
        menu = builder.addSubMenu(DSUtils.FAKE_INT);
        this.onOptionsItemSelected(menu.add(new String()));
        this.onMenuItemSelected(DSUtils.FAKE_INT, menu.add(new String()));

        this.onCreatePanelMenu(DSUtils.FAKE_INT, builder.addSubMenu(DSUtils.FAKE_INT));
        this.onPreparePanel(DSUtils.FAKE_INT, this.findViewById(DSUtils.FAKE_INT), builder.addSubMenu(DSUtils.FAKE_INT));
        this.onPanelClosed(DSUtils.FAKE_INT, builder.addSubMenu(DSUtils.FAKE_INT));
        
        //TODO: WHAT ABOUT A REAL MENU?
        this.onActionModeStarted(new ActionMode.SimpleActionMode());
        this.onActionModeFinished(new ActionMode.SimpleActionMode());
        
        AttributeSet attrSet = new AttributeSet.EmptyAttributeSet();;
        this.onCreateView(new String(), getBaseContext(), attrSet);
        
        //context menu
        ContextMenu contextMenu = new ContextMenuBuilder(getBaseContext());
        
        ContextMenu.ContextMenuInfo info = null;
        this.onCreateContextMenu(contextMenu, 
                this.findViewById(DSUtils.FAKE_INT), info);
       
        onWindowFocusChanged(getTaintBoolean());
        onTouchEvent(new MotionEvent()); 
        onTrackballEvent(new MotionEvent());
        onGenericMotionEvent(new MotionEvent());

        onKeyDown(getTaintInt(), new KeyEvent()); 
        onKeyUp(getTaintInt(), new KeyEvent());
        onKeyLongPress(getTaintInt(), new KeyEvent());
        onKeyShortcut(getTaintInt(), new KeyEvent());
        onKeyMultiple(getTaintInt(), getTaintInt(), new KeyEvent());
        
        //all dispatch functions
        dispatchTouchEvent(new MotionEvent());
        dispatchGenericMotionEvent(new MotionEvent());
        dispatchKeyEvent(new KeyEvent());
        dispatchKeyShortcutEvent(new KeyEvent());
        dispatchTrackballEvent(new MotionEvent());
        dispatchPopulateAccessibilityEvent(new AccessibilityEvent(DSUtils.FAKE_INT));
        
        droidsafeOnCreateThumbnail();
        onCreateDescription();
        
    }
    
}

