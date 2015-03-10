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
 * Copyright (C) 2008 The Android Open Source Project
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


package com.android.internal.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.android.internal.R;

public class AlertController {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.504 -0500", hash_original_method = "72DE9F1667F0AC69B84EC6B497C20732", hash_generated_method = "8B4C999718DE3CFEA840007E7081B23B")
    
private static boolean shouldCenterSingleButton(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.alertDialogCenterButtons,
                outValue, true);
        return outValue.data != 0;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.510 -0500", hash_original_method = "71B58AF2F457DFA0A129B301D5386B40", hash_generated_method = "2C9AAF0AB02E0D558666791D023EC365")
    
static boolean canTextInput(View v) {
        if (v.onCheckIsTextEditor()) {
            return true;
        }
        
        if (!(v instanceof ViewGroup)) {
            return false;
        }
        
        ViewGroup vg = (ViewGroup)v;
        int i = vg.getChildCount();
        while (i > 0) {
            i--;
            v = vg.getChildAt(i);
            if (canTextInput(v)) {
                return true;
            }
        }
        
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.404 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.406 -0500", hash_original_field = "9B7EA35002D8CFBAE566C5A6F1FEF945", hash_generated_field = "2B4497FE8D3BE69F04001AB183F843A0")

    private  DialogInterface mDialogInterface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.408 -0500", hash_original_field = "C6B08D42C8EA2CB56500460CAF662F4C", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private  Window mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.410 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")
    
    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.412 -0500", hash_original_field = "63AD8EC50650F4FC1A994F2CF8879BF9", hash_generated_field = "B242999524A78B5E31650BFBB7850632")

    private CharSequence mMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.414 -0500", hash_original_field = "564994122F8B404810DDCD714146F030", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.417 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")
    
    private View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.419 -0500", hash_original_field = "2CF3E38AC479CF7DC9414424A4186819", hash_generated_field = "19A8BE4EA4CB90940A5BCBECC9F99055")

    private int mViewSpacingLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.422 -0500", hash_original_field = "976BC4F473C472616CC6AEF3B3BB1773", hash_generated_field = "6557ACD495F3B6484326AC57AECFA558")
    
    private int mViewSpacingTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.424 -0500", hash_original_field = "A0153DFFF914D7E3767800DDD5367256", hash_generated_field = "47FEE73BA7B0F5642CD916931DB4B990")
    
    private int mViewSpacingRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.426 -0500", hash_original_field = "386C34F4001746DAA3939E8E126B9579", hash_generated_field = "E6D3207EA728175311B7208886F6CFF1")
    
    private int mViewSpacingBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.428 -0500", hash_original_field = "6ADF7C1F4575C08C987BB9C48C3376ED", hash_generated_field = "0F9BEABC6DA1B172890E35E612ED5285")
    
    private boolean mViewSpacingSpecified = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.430 -0500", hash_original_field = "75B52113A6D5C3EB151C16101C4A6C05", hash_generated_field = "2DE16827139A20C2B2C0D130D64C1F22")
    
    private Button mButtonPositive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.432 -0500", hash_original_field = "7EB1A770C105FC98881C436D73151FF3", hash_generated_field = "ADEC89EC1C6163464CAB74778BA7F455")

    private CharSequence mButtonPositiveText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.435 -0500", hash_original_field = "AF9872F1284FB38C953DBADE44C54B68", hash_generated_field = "4C64AEB4AC17D726F0EC573D273C85E4")

    private Message mButtonPositiveMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.437 -0500", hash_original_field = "133DE2C59C343AFAA6F1C251D0D078CF", hash_generated_field = "B5032704B1FD6BFE5557786C4C3D3EFC")

    private Button mButtonNegative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.439 -0500", hash_original_field = "5BABAC81AA58472B57285AFB238B9A83", hash_generated_field = "D91959E3DC6E2952E856CD3FA0A399C6")

    private CharSequence mButtonNegativeText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.441 -0500", hash_original_field = "3FC1A72596615EA31669FEABD97F0D63", hash_generated_field = "41F19F2D8C745871D17F5F9D098B77CB")

    private Message mButtonNegativeMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.443 -0500", hash_original_field = "C06B82C562FC34C9AE636C0D7FDE445C", hash_generated_field = "C9AFBBF32C64214706F68A15A4CC359B")

    private Button mButtonNeutral;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.445 -0500", hash_original_field = "CBBD856E8B9D3DE8DF34C1CA44686861", hash_generated_field = "16D3F864CF92B4D23F4B348C46186A72")

    private CharSequence mButtonNeutralText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.448 -0500", hash_original_field = "040561749CACE5542A0B57CFF0248FB1", hash_generated_field = "DE3A282A2612C858747AAF0293D78E5E")

    private Message mButtonNeutralMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.450 -0500", hash_original_field = "B7306C5499512DEC892EA20F4301F947", hash_generated_field = "48D52DD8E91130A1127C5E6751BAFC93")

    private ScrollView mScrollView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.453 -0500", hash_original_field = "C0615F41CF51A97CD409B5FC231BDFAF", hash_generated_field = "B9362750FD7578B98AC9480BFD1C22E4")
    
    private int mIconId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.455 -0500", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")
    
    private Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.457 -0500", hash_original_field = "069158469BB60C88A2C4A541C6AFB8D2", hash_generated_field = "411E3339296CF54457E86988903AF1A7")
    
    private ImageView mIconView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.459 -0500", hash_original_field = "B3B1177DB6C3A24EAC74C6705FD25300", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")
    
    private TextView mTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.461 -0500", hash_original_field = "3C68F58819B50F04C23C7889C2B27482", hash_generated_field = "461DDCE97AF551A1C6803EBC4533C15B")

    private TextView mMessageView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.463 -0500", hash_original_field = "754616A8D9EF9E33715AD37C44D8A17C", hash_generated_field = "E82D7636327F928026C806257B855F78")

    private View mCustomTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.466 -0500", hash_original_field = "87E1F65C64A2775382E85229E9AAE3D2", hash_generated_field = "5757562CC2DDACDF9B83AC60F3588BE8")
    
    private boolean mForceInverseBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.468 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "90F29768206AB431EA361CD94838716F")
    
    private ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.470 -0500", hash_original_field = "DE1EDD1BAE16FBBE89B10E88AACE9CEA", hash_generated_field = "7A33F03E17B63A6DBC30C9361577261E")
    
    private int mCheckedItem = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.472 -0500", hash_original_field = "DD4807035BCAA15DCADD8673868E6B6E", hash_generated_field = "C70E5EEEC2873FFD1D1516A4074C73D3")

    private int mAlertDialogLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.474 -0500", hash_original_field = "51DA4AD6454408A5ADBCBCB363DF258B", hash_generated_field = "386A7DC9605332794254886861F5C37D")

    private int mListLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.477 -0500", hash_original_field = "38A72FF627D3D1DB638A59A6C6F28DE2", hash_generated_field = "8704F6656CC8C6AA48BBAD3808E8165C")

    private int mMultiChoiceItemLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.479 -0500", hash_original_field = "EA8E467E96EE6A785C097DE0A16511D7", hash_generated_field = "482A719AFBD82F78F9D4411A75756FC3")

    private int mSingleChoiceItemLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.481 -0500", hash_original_field = "9028CF8F6AA13867345E246653C7FE24", hash_generated_field = "E1CB1AD1E8153C313B8B64994AF8C7E5")

    private int mListItemLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.484 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.870 -0400", hash_original_field = "64F9D11F1E11AE4CE243EDB97198552B", hash_generated_field = "A4A348A11ABF8F43A17AFAE144216A4B")

    View.OnClickListener mButtonHandler = new View.OnClickListener() {        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.870 -0400", hash_original_method = "23692F5F6532A376A1C310E4C1F7AE36", hash_generated_method = "C93E9241920A99CF968E82D80BD17750")
        public void onClick(View v) {
            
            Message m = null;
            {
                m = Message.obtain(mButtonPositiveMessage);
            } 
            {
                m = Message.obtain(mButtonNegativeMessage);
            } 
            {
                m = Message.obtain(mButtonNeutralMessage);
            } 
            {
                m.sendToTarget();
            } 
            mHandler.obtainMessage(ButtonHandler.MSG_DISMISS_DIALOG, mDialogInterface)
                    .sendToTarget();
            addTaint(v.getTaint());
                    
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.507 -0500", hash_original_method = "1F16FD36E11C30DD7C480C9A0A11F40F", hash_generated_method = "73E4C775136E03CD10D192A07FF6994A")
    
public AlertController(Context context, DialogInterface di, Window window) {
        mContext = context;
        mDialogInterface = di;
        mWindow = window;
        mHandler = new ButtonHandler(di);

        TypedArray a = context.obtainStyledAttributes(null,
                com.android.internal.R.styleable.AlertDialog,
                com.android.internal.R.attr.alertDialogStyle, 0);

        mAlertDialogLayout = a.getResourceId(com.android.internal.R.styleable.AlertDialog_layout,
                com.android.internal.R.layout.alert_dialog);
        mListLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_listLayout,
                com.android.internal.R.layout.select_dialog);
        mMultiChoiceItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_multiChoiceItemLayout,
                com.android.internal.R.layout.select_dialog_multichoice);
        mSingleChoiceItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_singleChoiceItemLayout,
                com.android.internal.R.layout.select_dialog_singlechoice);
        mListItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_listItemLayout,
                com.android.internal.R.layout.select_dialog_item);

        a.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.512 -0500", hash_original_method = "9A4AA3E1D6FBAA7AEFBA0C5C78FA5BFD", hash_generated_method = "E023C94551371D5AAF97BC79610717FB")
    
public void installContent() {
        /* We use a custom title so never request a window title */
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        
        if (mView == null || !canTextInput(mView)) {
            mWindow.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        }
        mWindow.setContentView(mAlertDialogLayout);
        setupView();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.515 -0500", hash_original_method = "27E388CB8AFA6CAD5DDDE89F3EB645E1", hash_generated_method = "38B5B66DE8E1E8FAAB6595391B3D5775")
    
public void setTitle(CharSequence title) {
        mTitle = title;
        if (mTitleView != null) {
            mTitleView.setText(title);
        }
    }

    /**
     * @see AlertDialog.Builder#setCustomTitle(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.518 -0500", hash_original_method = "94C17D404D39F375178D63AA6F858393", hash_generated_method = "49988D1E50A2D0095819D55FBC073A66")
    
public void setCustomTitle(View customTitleView) {
        mCustomTitleView = customTitleView;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.520 -0500", hash_original_method = "BE4B8F8527E733138AAA8E77FCFD81CC", hash_generated_method = "CCA6B5FE5B7D2819E083D4421A1750CC")
    
public void setMessage(CharSequence message) {
        mMessage = message;
        if (mMessageView != null) {
            mMessageView.setText(message);
        }
    }

    /**
     * Set the view to display in the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.522 -0500", hash_original_method = "042A2BE3A9972DB9108969963EFE2152", hash_generated_method = "7ADC968ECD92B06FD808716C4F935562")
    
public void setView(View view) {
        mView = view;
        mViewSpacingSpecified = false;
    }
    
    /**
     * Set the view to display in the dialog along with the spacing around that view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.524 -0500", hash_original_method = "2847E990E96B77DB4BD87DDDB577F2D4", hash_generated_method = "E884286728C918DEAF935FAE763FA3EA")
    
public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        mView = view;
        mViewSpacingSpecified = true;
        mViewSpacingLeft = viewSpacingLeft;
        mViewSpacingTop = viewSpacingTop;
        mViewSpacingRight = viewSpacingRight;
        mViewSpacingBottom = viewSpacingBottom;
    }

    /**
     * Sets a click listener or a message to be sent when the button is clicked.
     * You only need to pass one of {@code listener} or {@code msg}.
     * 
     * @param whichButton Which button, can be one of
     *            {@link DialogInterface#BUTTON_POSITIVE},
     *            {@link DialogInterface#BUTTON_NEGATIVE}, or
     *            {@link DialogInterface#BUTTON_NEUTRAL}
     * @param text The text to display in positive button.
     * @param listener The {@link DialogInterface.OnClickListener} to use.
     * @param msg The {@link Message} to be sent when clicked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.527 -0500", hash_original_method = "F0CE922A10C717C707A211DED1E4F7AA", hash_generated_method = "70874D33038639E6DA8D2B9B539638BE")
    
public void setButton(int whichButton, CharSequence text,
            DialogInterface.OnClickListener listener, Message msg) {

        if (msg == null && listener != null) {
            msg = mHandler.obtainMessage(whichButton, listener);
        }
        
        switch (whichButton) {

            case DialogInterface.BUTTON_POSITIVE:
                mButtonPositiveText = text;
                mButtonPositiveMessage = msg;
                break;
                
            case DialogInterface.BUTTON_NEGATIVE:
                mButtonNegativeText = text;
                mButtonNegativeMessage = msg;
                break;
                
            case DialogInterface.BUTTON_NEUTRAL:
                mButtonNeutralText = text;
                mButtonNeutralMessage = msg;
                break;
                
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /**
     * Set resId to 0 if you don't want an icon.
     * @param resId the resourceId of the drawable to use as the icon or 0
     * if you don't want an icon.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.529 -0500", hash_original_method = "FB4271E4605E30D98972B290FB7DEC88", hash_generated_method = "CCC660D5D12366C1A40070C60C73E148")
    
public void setIcon(int resId) {
        mIconId = resId;
        if (mIconView != null) {
            if (resId > 0) {
                mIconView.setImageResource(mIconId);
            } else if (resId == 0) {
                mIconView.setVisibility(View.GONE);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.531 -0500", hash_original_method = "5C2407A3F3458DD1635D398D03E8F03F", hash_generated_method = "1DC96DB1ACCE4712A4D1AC967791CE9E")
    
public void setIcon(Drawable icon) {
        mIcon = icon;
        if ((mIconView != null) && (mIcon != null)) {
            mIconView.setImageDrawable(icon);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.533 -0500", hash_original_method = "19D779B93DDFF4465E595606B06C3EFE", hash_generated_method = "247D0B1C580D2EFC1CF8FD37788E2EFB")
    
public void setInverseBackgroundForced(boolean forceInverseBackground) {
        mForceInverseBackground = forceInverseBackground;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.535 -0500", hash_original_method = "3273CA9467A607A59D9BD9C18D0394BC", hash_generated_method = "F103D805F94DC1063FF9887BFC2DF752")
    
public ListView getListView() {
        return mListView;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.538 -0500", hash_original_method = "3833583B80F66F9531985629B1AE2E3F", hash_generated_method = "0C0AC5F0A0CCBFB5A9ADE60497530B17")
    
public Button getButton(int whichButton) {
        switch (whichButton) {
            case DialogInterface.BUTTON_POSITIVE:
                return mButtonPositive;
            case DialogInterface.BUTTON_NEGATIVE:
                return mButtonNegative;
            case DialogInterface.BUTTON_NEUTRAL:
                return mButtonNeutral;
            default:
                return null;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.540 -0500", hash_original_method = "B7833AF2811E127AB8391879126162ED", hash_generated_method = "4E019FF455581419A53A3F2151961E9B")
    
@SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mScrollView != null && mScrollView.executeKeyEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.542 -0500", hash_original_method = "98FE899904FE72C0DB5091897F5A09B0", hash_generated_method = "6D8D100FBA9D66895651D76F81B90133")
    
@SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return mScrollView != null && mScrollView.executeKeyEvent(event);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.545 -0500", hash_original_method = "0CE32455CB333C36B4EB85B89D65D186", hash_generated_method = "80CA0AABA965A440DAA0C85ADBC1CFAA")
    
private void setupView() {
        LinearLayout contentPanel = (LinearLayout) mWindow.findViewById(R.id.contentPanel);
        setupContent(contentPanel);
        boolean hasButtons = setupButtons();
        
        LinearLayout topPanel = (LinearLayout) mWindow.findViewById(R.id.topPanel);
        TypedArray a = mContext.obtainStyledAttributes(
                null, com.android.internal.R.styleable.AlertDialog, com.android.internal.R.attr.alertDialogStyle, 0);
        boolean hasTitle = setupTitle(topPanel);
            
        View buttonPanel = mWindow.findViewById(R.id.buttonPanel);
        if (!hasButtons) {
            buttonPanel.setVisibility(View.GONE);
            mWindow.setCloseOnTouchOutsideIfNotSet(true);
        }

        FrameLayout customPanel = null;
        if (mView != null) {
            customPanel = (FrameLayout) mWindow.findViewById(R.id.customPanel);
            FrameLayout custom = (FrameLayout) mWindow.findViewById(R.id.custom);
            custom.addView(mView, new LayoutParams(MATCH_PARENT, MATCH_PARENT));
            if (mViewSpacingSpecified) {
                custom.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                        mViewSpacingBottom);
            }
            if (mListView != null) {
                ((LinearLayout.LayoutParams) customPanel.getLayoutParams()).weight = 0;
            }
        } else {
            mWindow.findViewById(R.id.customPanel).setVisibility(View.GONE);
        }
        
        /* Only display the divider if we have a title and a 
         * custom view or a message.
         */
        if (hasTitle) {
            View divider = null;
            if (mMessage != null || mView != null || mListView != null) {
                divider = mWindow.findViewById(R.id.titleDivider);
            } else {
                divider = mWindow.findViewById(R.id.titleDividerTop);
            }

            if (divider != null) {
                divider.setVisibility(View.VISIBLE);
            }
        }
        
        setBackground(topPanel, contentPanel, customPanel, hasButtons, a, hasTitle, buttonPanel);
        a.recycle();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.549 -0500", hash_original_method = "291261EC5A45F15B0AF035A0FADD9120", hash_generated_method = "F9E4DF28E433B482CC6BAE1313DB3D3A")
    
private boolean setupTitle(LinearLayout topPanel) {
        boolean hasTitle = true;
        
        if (mCustomTitleView != null) {
            // Add the custom title view directly to the topPanel layout
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            
            topPanel.addView(mCustomTitleView, 0, lp);
            
            // Hide the title template
            View titleTemplate = mWindow.findViewById(R.id.title_template);
            titleTemplate.setVisibility(View.GONE);
        } else {
            final boolean hasTextTitle = !TextUtils.isEmpty(mTitle);
            
            mIconView = (ImageView) mWindow.findViewById(R.id.icon);
            if (hasTextTitle) {
                /* Display the title if a title is supplied, else hide it */
                mTitleView = (TextView) mWindow.findViewById(R.id.alertTitle);

                mTitleView.setText(mTitle);
                
                /* Do this last so that if the user has supplied any
                 * icons we use them instead of the default ones. If the
                 * user has specified 0 then make it disappear.
                 */
                if (mIconId > 0) {
                    mIconView.setImageResource(mIconId);
                } else if (mIcon != null) {
                    mIconView.setImageDrawable(mIcon);
                } else if (mIconId == 0) {
                    
                    /* Apply the padding from the icon to ensure the
                     * title is aligned correctly.
                     */
                    mTitleView.setPadding(mIconView.getPaddingLeft(),
                            mIconView.getPaddingTop(),
                            mIconView.getPaddingRight(),
                            mIconView.getPaddingBottom());
                    mIconView.setVisibility(View.GONE);
                }
            } else {
                
                // Hide the title template
                View titleTemplate = mWindow.findViewById(R.id.title_template);
                titleTemplate.setVisibility(View.GONE);
                mIconView.setVisibility(View.GONE);
                topPanel.setVisibility(View.GONE);
                hasTitle = false;
            }
        }
        return hasTitle;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.551 -0500", hash_original_method = "887622C8B8EC01B1F9012F53B044827B", hash_generated_method = "B535E7B8B1A1A771215AE6652FC5B60F")
    
private void setupContent(LinearLayout contentPanel) {
        mScrollView = (ScrollView) mWindow.findViewById(R.id.scrollView);
        mScrollView.setFocusable(false);
        
        // Special case for users that only want to display a String
        mMessageView = (TextView) mWindow.findViewById(R.id.message);
        if (mMessageView == null) {
            return;
        }
        
        if (mMessage != null) {
            mMessageView.setText(mMessage);
        } else {
            mMessageView.setVisibility(View.GONE);
            mScrollView.removeView(mMessageView);
            
            if (mListView != null) {
                contentPanel.removeView(mWindow.findViewById(R.id.scrollView));
                contentPanel.addView(mListView,
                        new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
                contentPanel.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, 0, 1.0f));
            } else {
                contentPanel.setVisibility(View.GONE);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.554 -0500", hash_original_method = "5BA34AF0614F863A3B9D6C4A8679B5AF", hash_generated_method = "483516A14A56E303C8586E059E4FF151")
    
private boolean setupButtons() {
        int BIT_BUTTON_POSITIVE = 1;
        int BIT_BUTTON_NEGATIVE = 2;
        int BIT_BUTTON_NEUTRAL = 4;
        int whichButtons = 0;
        mButtonPositive = (Button) mWindow.findViewById(R.id.button1);
        mButtonPositive.setOnClickListener(mButtonHandler);

        if (TextUtils.isEmpty(mButtonPositiveText)) {
            mButtonPositive.setVisibility(View.GONE);
        } else {
            mButtonPositive.setText(mButtonPositiveText);
            mButtonPositive.setVisibility(View.VISIBLE);
            whichButtons = whichButtons | BIT_BUTTON_POSITIVE;
        }

        mButtonNegative = (Button) mWindow.findViewById(R.id.button2);
        mButtonNegative.setOnClickListener(mButtonHandler);

        if (TextUtils.isEmpty(mButtonNegativeText)) {
            mButtonNegative.setVisibility(View.GONE);
        } else {
            mButtonNegative.setText(mButtonNegativeText);
            mButtonNegative.setVisibility(View.VISIBLE);

            whichButtons = whichButtons | BIT_BUTTON_NEGATIVE;
        }

        mButtonNeutral = (Button) mWindow.findViewById(R.id.button3);
        mButtonNeutral.setOnClickListener(mButtonHandler);

        if (TextUtils.isEmpty(mButtonNeutralText)) {
            mButtonNeutral.setVisibility(View.GONE);
        } else {
            mButtonNeutral.setText(mButtonNeutralText);
            mButtonNeutral.setVisibility(View.VISIBLE);

            whichButtons = whichButtons | BIT_BUTTON_NEUTRAL;
        }

        if (shouldCenterSingleButton(mContext)) {
            /*
             * If we only have 1 button it should be centered on the layout and
             * expand to fill 50% of the available space.
             */
            if (whichButtons == BIT_BUTTON_POSITIVE) {
                centerButton(mButtonPositive);
            } else if (whichButtons == BIT_BUTTON_NEGATIVE) {
                centerButton(mButtonNeutral);
            } else if (whichButtons == BIT_BUTTON_NEUTRAL) {
                centerButton(mButtonNeutral);
            }
        }
        
        return whichButtons != 0;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.558 -0500", hash_original_method = "28BC3CB500322D129CBA8E7C7A78AD5A", hash_generated_method = "F3759F0CDD5BF0C425F81539F9C680F0")
    
private void centerButton(Button button) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.weight = 0.5f;
        button.setLayoutParams(params);
        View leftSpacer = mWindow.findViewById(R.id.leftSpacer);
        if (leftSpacer != null) {
            leftSpacer.setVisibility(View.VISIBLE);
        }
        View rightSpacer = mWindow.findViewById(R.id.rightSpacer);
        if (rightSpacer != null) {
            rightSpacer.setVisibility(View.VISIBLE);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.562 -0500", hash_original_method = "6198B5046244FDCE77443F1833B74949", hash_generated_method = "FBA9B6650722BB2345B5A35C17F23F9B")
    
private void setBackground(LinearLayout topPanel, LinearLayout contentPanel,
            View customPanel, boolean hasButtons, TypedArray a, boolean hasTitle, 
            View buttonPanel) {
        
        /* Get all the different background required */
        int fullDark = a.getResourceId(
                R.styleable.AlertDialog_fullDark, R.drawable.popup_full_dark);
        int topDark = a.getResourceId(
                R.styleable.AlertDialog_topDark, R.drawable.popup_top_dark);
        int centerDark = a.getResourceId(
                R.styleable.AlertDialog_centerDark, R.drawable.popup_center_dark);
        int bottomDark = a.getResourceId(
                R.styleable.AlertDialog_bottomDark, R.drawable.popup_bottom_dark);
        int fullBright = a.getResourceId(
                R.styleable.AlertDialog_fullBright, R.drawable.popup_full_bright);
        int topBright = a.getResourceId(
                R.styleable.AlertDialog_topBright, R.drawable.popup_top_bright);
        int centerBright = a.getResourceId(
                R.styleable.AlertDialog_centerBright, R.drawable.popup_center_bright);
        int bottomBright = a.getResourceId(
                R.styleable.AlertDialog_bottomBright, R.drawable.popup_bottom_bright);
        int bottomMedium = a.getResourceId(
                R.styleable.AlertDialog_bottomMedium, R.drawable.popup_bottom_medium);
        
        /*
         * We now set the background of all of the sections of the alert.
         * First collect together each section that is being displayed along
         * with whether it is on a light or dark background, then run through
         * them setting their backgrounds.  This is complicated because we need
         * to correctly use the full, top, middle, and bottom graphics depending
         * on how many views they are and where they appear.
         */
        
        View[] views = new View[4];
        boolean[] light = new boolean[4];
        View lastView = null;
        boolean lastLight = false;
        
        int pos = 0;
        if (hasTitle) {
            views[pos] = topPanel;
            light[pos] = false;
            pos++;
        }
        
        /* The contentPanel displays either a custom text message or
         * a ListView. If it's text we should use the dark background
         * for ListView we should use the light background. If neither
         * are there the contentPanel will be hidden so set it as null.
         */
        views[pos] = (contentPanel.getVisibility() == View.GONE) 
                ? null : contentPanel;
        light[pos] = mListView != null;
        pos++;
        if (customPanel != null) {
            views[pos] = customPanel;
            light[pos] = mForceInverseBackground;
            pos++;
        }
        if (hasButtons) {
            views[pos] = buttonPanel;
            light[pos] = true;
        }
        
        boolean setView = false;
        for (pos=0; pos<views.length; pos++) {
            View v = views[pos];
            if (v == null) {
                continue;
            }
            if (lastView != null) {
                if (!setView) {
                    lastView.setBackgroundResource(lastLight ? topBright : topDark);
                } else {
                    lastView.setBackgroundResource(lastLight ? centerBright : centerDark);
                }
                setView = true;
            }
            lastView = v;
            lastLight = light[pos];
        }
        
        if (lastView != null) {
            if (setView) {
                
                /* ListViews will use the Bright background but buttons use
                 * the Medium background.
                 */ 
                lastView.setBackgroundResource(
                        lastLight ? (hasButtons ? bottomMedium : bottomBright) : bottomDark);
            } else {
                lastView.setBackgroundResource(lastLight ? fullBright : fullDark);
            }
        }
        
        /* TODO: uncomment section below. The logic for this should be if 
         * it's a Contextual menu being displayed AND only a Cancel button 
         * is shown then do this.
         */
//        if (hasButtons && (mListView != null)) {
            
            /* Yet another *special* case. If there is a ListView with buttons
             * don't put the buttons on the bottom but instead put them in the
             * footer of the ListView this will allow more items to be
             * displayed.
             */
            
            /*
            contentPanel.setBackgroundResource(bottomBright);
            buttonPanel.setBackgroundResource(centerMedium);
            ViewGroup parent = (ViewGroup) mWindow.findViewById(R.id.parentPanel);
            parent.removeView(buttonPanel);
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                    AbsListView.LayoutParams.MATCH_PARENT, 
                    AbsListView.LayoutParams.MATCH_PARENT);
            buttonPanel.setLayoutParams(params);
            mListView.addFooterView(buttonPanel);
            */
//        }
        
        if ((mListView != null) && (mAdapter != null)) {
            mListView.setAdapter(mAdapter);
            if (mCheckedItem > -1) {
                mListView.setItemChecked(mCheckedItem, true);
                mListView.setSelection(mCheckedItem);
            }
        }
    }
    
    private static final class ButtonHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.493 -0500", hash_original_field = "E6044B58D33A24BD8C03989D9BFC6755", hash_generated_field = "837E07B94F9B99EC5A8E2663317A1F02")

        private static final int MSG_DISMISS_DIALOG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.495 -0500", hash_original_field = "DC7483C81552C4D76DF4759BE53BA423", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")
        
        private WeakReference<DialogInterface> mDialog;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.498 -0500", hash_original_method = "94BD8A25739D33DF469E488FF271595A", hash_generated_method = "5AD6F4826FA70505440FF8FE12479241")
        
public ButtonHandler(DialogInterface dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.500 -0500", hash_original_method = "278B02327B6D097A80A5697E74542815", hash_generated_method = "C1FC77D5A9BD5529F398A0F7FE1EFA8A")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                
                case DialogInterface.BUTTON_POSITIVE:
                case DialogInterface.BUTTON_NEGATIVE:
                case DialogInterface.BUTTON_NEUTRAL:
                    ((DialogInterface.OnClickListener) msg.obj).onClick(mDialog.get(), msg.what);
                    break;
                    
                case MSG_DISMISS_DIALOG:
                    ((DialogInterface) msg.obj).dismiss();
            }
        }
    }
    
    public static class RecycleListView extends ListView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.565 -0500", hash_original_field = "3DD4A4EF0D713F0ADFB04515FD02F627", hash_generated_field = "3DD4A4EF0D713F0ADFB04515FD02F627")

        boolean mRecycleOnMeasure = true;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.568 -0500", hash_original_method = "EE9FD5306D2F93DFDAA34BAADCE625A8", hash_generated_method = "35979333B57FF432DF718DD90B2A1411")
        
public RecycleListView(Context context) {
            super(context);
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.570 -0500", hash_original_method = "FD9F3D8D98E58119FCDEC82734593D0D", hash_generated_method = "B2B531B24B2CDFCEF90E54B2BC50823B")
        
public RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.574 -0500", hash_original_method = "B696B9456EBFFE7A743BD389E8B7B605", hash_generated_method = "C185F301BFC244486A27368C446ECAC6")
        
public RecycleListView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.576 -0500", hash_original_method = "9DCA0509220194E0D65C0AA0793BD261", hash_generated_method = "21F1233BDCA2C291CF8765757BCC71DA")
        
@Override
        protected boolean recycleOnMeasure() {
            return mRecycleOnMeasure;
        }
        
    }
    
    public static class AlertParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.581 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

        public  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.583 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "26B6EDB1B2B17244BBBF36956F817F15")

        public  LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.587 -0500", hash_original_field = "EA052C7000713EBD5CB241A285D3399E", hash_generated_field = "C2DC3CCA222E71D43D27ECAB851034A0")
        
        public int mIconId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.589 -0500", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "E5243F47D3999E8E6530788895E90100")

        public Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.591 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "04F7F9DD6D2510CBB15DFDFFE1807D8E")

        public CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.593 -0500", hash_original_field = "754616A8D9EF9E33715AD37C44D8A17C", hash_generated_field = "814166582DF1A24C00D1625C5488672A")

        public View mCustomTitleView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.595 -0500", hash_original_field = "63AD8EC50650F4FC1A994F2CF8879BF9", hash_generated_field = "E05582EF743E1ACAA4AA9356CB30BC94")

        public CharSequence mMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.598 -0500", hash_original_field = "C455BA97656CBA9FD4747BFBD43F169E", hash_generated_field = "2CA24C7B094B26BA6E936F6BBC901F5D")

        public CharSequence mPositiveButtonText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.600 -0500", hash_original_field = "9A8060786B1540173F3BD2CF545B990F", hash_generated_field = "1BE202C2CAD8DB621DCDD3372ED2D171")

        public DialogInterface.OnClickListener mPositiveButtonListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.603 -0500", hash_original_field = "F3614752E21AFBE21C5C8D2CE5A72EA1", hash_generated_field = "2D3FBAA9E0AD2228B46D75FBECE56655")

        public CharSequence mNegativeButtonText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.606 -0500", hash_original_field = "A8B4C1211EB354DF99DE285B1FEF4A01", hash_generated_field = "B8D1F988895A94C1B77F97F848992793")

        public DialogInterface.OnClickListener mNegativeButtonListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.608 -0500", hash_original_field = "F313E2DE27CF299CDA89AE75C0D3C7D5", hash_generated_field = "C67CE1D73A0301923AC9C0DDF272716F")

        public CharSequence mNeutralButtonText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.610 -0500", hash_original_field = "0B83D5E23824BE01F098EDF4F900501F", hash_generated_field = "C6F2573A08FEF0DF77F903DEE8742754")

        public DialogInterface.OnClickListener mNeutralButtonListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.613 -0500", hash_original_field = "3282504DA3A8851DD37ECD55A563D502", hash_generated_field = "690DB816AF9947EBA54C6AD5450363A0")

        public boolean mCancelable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.616 -0500", hash_original_field = "BDF08D30418E02F11840649744F841D3", hash_generated_field = "D57560FB4E6739D7CCFF128C31469BB1")

        public DialogInterface.OnCancelListener mOnCancelListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.618 -0500", hash_original_field = "42D9E17FC9709079BE76151C3DA4A581", hash_generated_field = "CA7076FF3B23B43DA0C003C9464E1AB3")

        public DialogInterface.OnKeyListener mOnKeyListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.621 -0500", hash_original_field = "B043A5597F4D3C8FBFABEFD0ED32C868", hash_generated_field = "770D760EB2D47D87B74F516C630F54A9")

        public CharSequence[] mItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.624 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "25FA7FD85E13A481D223BDA4FAF494D1")

        public ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.627 -0500", hash_original_field = "06C5353EEC29A7849ADDD61195ECF49E", hash_generated_field = "D617C33C039CBCFD65B3C22DBA07CFF5")

        public DialogInterface.OnClickListener mOnClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.629 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "6C373AA66951237B18143051CA3FC35A")

        public View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.632 -0500", hash_original_field = "2CF3E38AC479CF7DC9414424A4186819", hash_generated_field = "133421CFB34A08A745D0DABDF172D654")

        public int mViewSpacingLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.634 -0500", hash_original_field = "976BC4F473C472616CC6AEF3B3BB1773", hash_generated_field = "AACBB04D340CCDFCD16549D9477D1053")

        public int mViewSpacingTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.636 -0500", hash_original_field = "A0153DFFF914D7E3767800DDD5367256", hash_generated_field = "B5693872E335B49FF25BCA5D1000771A")

        public int mViewSpacingRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.638 -0500", hash_original_field = "386C34F4001746DAA3939E8E126B9579", hash_generated_field = "16138D3B0F72ADA1373081D480EF4F2A")

        public int mViewSpacingBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.641 -0500", hash_original_field = "6ADF7C1F4575C08C987BB9C48C3376ED", hash_generated_field = "15FC623F24AED707F20028F138CB4155")

        public boolean mViewSpacingSpecified = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.643 -0500", hash_original_field = "39B3477303DF18E56FE86F3AE7F57C62", hash_generated_field = "34261E0AFA1935DD7182F7BE1D273C66")

        public boolean[] mCheckedItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.646 -0500", hash_original_field = "8DF322E8DA524256824D4AEB5719DD70", hash_generated_field = "2928823CCF761707AADE97A3C31F0E37")

        public boolean mIsMultiChoice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.649 -0500", hash_original_field = "BFC22E28EF1B900B17C5C6FBBEED36A3", hash_generated_field = "264C969397A5870832FCC712B67D9AED")

        public boolean mIsSingleChoice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.651 -0500", hash_original_field = "DE1EDD1BAE16FBBE89B10E88AACE9CEA", hash_generated_field = "B28C90765377E391E20D88849A9B1FCD")

        public int mCheckedItem = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.654 -0500", hash_original_field = "2693617B200722887E5EA3B5381C4245", hash_generated_field = "C1D53F530A35F1502CC3200362215D8B")

        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.656 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "6691A457869D5E472564204CDF0EADCB")

        public Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.658 -0500", hash_original_field = "983485403D5304BB0B6696164C5F7C28", hash_generated_field = "8663F263214822FF04034DE81B9E539F")

        public String mLabelColumn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.660 -0500", hash_original_field = "D14BB61571737A83A63375102DD2B5F2", hash_generated_field = "D868CCDF8866E0B4C22A7B4AB9003B23")

        public String mIsCheckedColumn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.663 -0500", hash_original_field = "87E1F65C64A2775382E85229E9AAE3D2", hash_generated_field = "CEBAA7027B15CFA5FFECBE008E938B45")

        public boolean mForceInverseBackground;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.666 -0500", hash_original_field = "C8740CD7F0A353C7305DE5F794DEA6CC", hash_generated_field = "E0E2BC3A5346F1A907B72B36F89366E0")

        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.668 -0500", hash_original_field = "C48E1C721036EB1AEDD4156BBE45399B", hash_generated_field = "3AB01332941910606794E5FE4F180916")

        public OnPrepareListViewListener mOnPrepareListViewListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.670 -0500", hash_original_field = "3DD4A4EF0D713F0ADFB04515FD02F627", hash_generated_field = "D4A086061D2FEBA35D1D1938D92E949F")

        public boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.676 -0500", hash_original_method = "30F42D5772B75365825E237386B4299E", hash_generated_method = "D19872037B8945B866C3DBF256E89565")
        
public AlertParams(Context context) {
            mContext = context;
            mCancelable = true;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.679 -0500", hash_original_method = "80497DB7CC0D98B7F92FD843E557F0AA", hash_generated_method = "D01B8D240C126EBF3B5810C263B3F1A2")
        
public void apply(AlertController dialog) {
            if (mCustomTitleView != null) {
                dialog.setCustomTitle(mCustomTitleView);
            } else {
                if (mTitle != null) {
                    dialog.setTitle(mTitle);
                }
                if (mIcon != null) {
                    dialog.setIcon(mIcon);
                }
                if (mIconId >= 0) {
                    dialog.setIcon(mIconId);
                }
            }
            if (mMessage != null) {
                dialog.setMessage(mMessage);
            }
            if (mPositiveButtonText != null) {
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, mPositiveButtonText,
                        mPositiveButtonListener, null);
            }
            if (mNegativeButtonText != null) {
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, mNegativeButtonText,
                        mNegativeButtonListener, null);
            }
            if (mNeutralButtonText != null) {
                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, mNeutralButtonText,
                        mNeutralButtonListener, null);
            }
            if (mForceInverseBackground) {
                dialog.setInverseBackgroundForced(true);
            }
            // For a list, the client can either supply an array of items or an
            // adapter or a cursor
            if ((mItems != null) || (mCursor != null) || (mAdapter != null)) {
                createListView(dialog);
            }
            if (mView != null) {
                if (mViewSpacingSpecified) {
                    dialog.setView(mView, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                            mViewSpacingBottom);
                } else {
                    dialog.setView(mView);
                }
            }
            
            /*
            dialog.setCancelable(mCancelable);
            dialog.setOnCancelListener(mOnCancelListener);
            if (mOnKeyListener != null) {
                dialog.setOnKeyListener(mOnKeyListener);
            }
            */
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:56.709 -0500", hash_original_method = "8E786D28D6E36F7AAC42E3AE032D9CF8", hash_generated_method = "81E12AE059241C66E1BC0ACC695038E8")
        
private void createListView(final AlertController dialog) {
            final RecycleListView listView = (RecycleListView)
                    mInflater.inflate(dialog.mListLayout, null);
            ListAdapter adapter;
            
            if (mIsMultiChoice) {
                if (mCursor == null) {
                    adapter = new ArrayAdapter<CharSequence>(
                            mContext, dialog.mMultiChoiceItemLayout, R.id.text1, mItems) {
                        @DSSafe(DSCat.SAFE_LIST)
            
            @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            if (mCheckedItems != null) {
                                boolean isItemChecked = mCheckedItems[position];
                                if (isItemChecked) {
                                    listView.setItemChecked(position, true);
                                }
                            }
                            return view;
                        }
                    };
                } else {
                    adapter = new CursorAdapter(mContext, mCursor, false) {
                        private final int mLabelIndex;
                        private final int mIsCheckedIndex;

                        {
                            final Cursor cursor = getCursor();
                            mLabelIndex = cursor.getColumnIndexOrThrow(mLabelColumn);
                            mIsCheckedIndex = cursor.getColumnIndexOrThrow(mIsCheckedColumn);
                        }

                        @Override
                        public void bindView(View view, Context context, Cursor cursor) {
                            CheckedTextView text = (CheckedTextView) view.findViewById(R.id.text1);
                            text.setText(cursor.getString(mLabelIndex));
                            listView.setItemChecked(cursor.getPosition(),
                                    cursor.getInt(mIsCheckedIndex) == 1);
                        }
    
                        @Override
                        public View newView(Context context, Cursor cursor, ViewGroup parent) {
                            return mInflater.inflate(dialog.mMultiChoiceItemLayout,
                                    parent, false);
                        }
                        
                    };
                }
            } else {
                int layout = mIsSingleChoice 
                        ? dialog.mSingleChoiceItemLayout : dialog.mListItemLayout;
                if (mCursor == null) {
                    adapter = (mAdapter != null) ? mAdapter
                            : new ArrayAdapter<CharSequence>(mContext, layout, R.id.text1, mItems);
                } else {
                    adapter = new SimpleCursorAdapter(mContext, layout, 
                            mCursor, new String[]{mLabelColumn}, new int[]{R.id.text1});
                }
            }
            
            if (mOnPrepareListViewListener != null) {
                mOnPrepareListViewListener.onPrepareListView(listView);
            }
            
            /* Don't directly set the adapter on the ListView as we might
             * want to add a footer to the ListView later.
             */
            dialog.mAdapter = adapter;
            dialog.mCheckedItem = mCheckedItem;
            
            if (mOnClickListener != null) {
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        mOnClickListener.onClick(dialog.mDialogInterface, position);
                        if (!mIsSingleChoice) {
                            dialog.mDialogInterface.dismiss();
                        }
                    }
                });
            } else if (mOnCheckboxClickListener != null) {
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        if (mCheckedItems != null) {
                            mCheckedItems[position] = listView.isItemChecked(position);
                        }
                        mOnCheckboxClickListener.onClick(
                                dialog.mDialogInterface, position, listView.isItemChecked(position));
                    }
                });
            }
            
            // Attach a given OnItemSelectedListener to the ListView
            if (mOnItemSelectedListener != null) {
                listView.setOnItemSelectedListener(mOnItemSelectedListener);
            }
            
            if (mIsSingleChoice) {
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            } else if (mIsMultiChoice) {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            }
            listView.mRecycleOnMeasure = mRecycleOnMeasure;
            dialog.mListView = listView;
        }
        
        public interface OnPrepareListViewListener {
            
            @DSComment("Abstract Method")
            @DSSpec(DSCat.ABSTRACT_METHOD)
            void onPrepareListView(ListView listView);
        }
        
    }
    
}

