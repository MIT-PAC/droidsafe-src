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
 * Copyright (C) 2007 The Android Open Source Project
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
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.internal.app.AlertController;

public class AlertDialog extends Dialog implements DialogInterface {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.001 -0500", hash_original_method = "B16DF712FADBC6F763054B9AFC3C54C8", hash_generated_method = "25D3EA26FBF1141D80814F97B62D6ECC")
    
static int resolveDialogTheme(Context context, int resid) {
        if (resid == THEME_TRADITIONAL) {
            return com.android.internal.R.style.Theme_Dialog_Alert;
        } else if (resid == THEME_HOLO_DARK) {
            return com.android.internal.R.style.Theme_Holo_Dialog_Alert;
        } else if (resid == THEME_HOLO_LIGHT) {
            return com.android.internal.R.style.Theme_Holo_Light_Dialog_Alert;
        } else if (resid == THEME_DEVICE_DEFAULT_DARK) {
            return com.android.internal.R.style.Theme_DeviceDefault_Dialog_Alert;
        } else if (resid == THEME_DEVICE_DEFAULT_LIGHT) {
            return com.android.internal.R.style.Theme_DeviceDefault_Light_Dialog_Alert;
        } else if (resid >= 0x01000000) {   // start of real resource IDs.
            return resid;
        } else {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(com.android.internal.R.attr.alertDialogTheme,
                    outValue, true);
            return outValue.resourceId;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.979 -0500", hash_original_field = "BE68711F6AD47498F48471F7006A30C8", hash_generated_field = "04F8A3C57B2864E838978D2CD85E8969")

    public static final int THEME_TRADITIONAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.981 -0500", hash_original_field = "468E538EDE7F08FE3742E66631617383", hash_generated_field = "2784576D25C201833EBEF780244434BE")

    public static final int THEME_HOLO_DARK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.984 -0500", hash_original_field = "BF7E0FE32873E3A8CDF57D89BFE1A41C", hash_generated_field = "C3AAAE4F57F49818B346717868538E05")

    public static final int THEME_HOLO_LIGHT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.986 -0500", hash_original_field = "C9CBBE84B17AA7C6A1ABF58D7A24FB85", hash_generated_field = "BFF34475E73341D4B4E388DEB93A3440")

    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.988 -0500", hash_original_field = "187BB0096153F6C4394C559D6AA0DE9A", hash_generated_field = "E0D4DDCC01DBB4B3153128208E0562F5")

    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.976 -0500", hash_original_field = "9C55F471F1447595FF019E93CE11F7EE", hash_generated_field = "167B5CF3490749BA13C3817234C227CF")

    private AlertController mAlert;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.990 -0500", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "C00D98D2C1C3A60A7C1F347ACBD61899")
    
protected AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
    }

    /**
     * Construct an AlertDialog that uses an explicit theme.  The actual style
     * that an AlertDialog uses is a private implementation, however you can
     * here supply either the name of an attribute in the theme from which
     * to get the dialog's style (such as {@link android.R.attr#alertDialogTheme}
     * or one of the constants {@link #THEME_TRADITIONAL},
     * {@link #THEME_HOLO_DARK}, or {@link #THEME_HOLO_LIGHT}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.993 -0500", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "11835A879826C9E25E737022FC134103")
    
protected AlertDialog(Context context, int theme) {
        this(context, theme, true);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.996 -0500", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "6D386DC5BAB559A725B0E80B3B80739F")
    
AlertDialog(Context context, int theme, boolean createContextWrapper) {
        super(context, resolveDialogTheme(context, theme), createContextWrapper);
        mWindow.alwaysReadCloseOnTouchAttr();
        mAlert = new AlertController(getContext(), this, getWindow());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:21.999 -0500", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "6BB5D4D65D0741BBA829B5502D7AFC6D")
    
    @DSVerified
    @DSComment("GUI constructor with callback registration modeled")
    @DSSafe(DSCat.SAFE_OTHERS)
protected AlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, resolveDialogTheme(context, 0));
        mWindow.alwaysReadCloseOnTouchAttr();
        setCancelable(cancelable);
        setOnCancelListener(cancelListener);

        mAlert = new AlertController(context, this, getWindow());
    }

    /**
     * Gets one of the buttons used in the dialog.
     * <p>
     * If a button does not exist in the dialog, null will be returned.
     * 
     * @param whichButton The identifier of the button that should be returned.
     *            For example, this can be
     *            {@link DialogInterface#BUTTON_POSITIVE}.
     * @return The button from the dialog, or null if a button does not exist.
     */
    @DSComment("GUI, alert dialog")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.003 -0500", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "B085ED52457D458E48F09C261A47BA82")
    
public Button getButton(int whichButton) {
        return mAlert.getButton(whichButton);
    }
    
    /**
     * Gets the list view used in the dialog.
     *  
     * @return The {@link ListView} from the dialog.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.006 -0500", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "C83DDCA0D5A4BE40169F1EE6BE034F63")
    
public ListView getListView() {
        return mAlert.getListView();
    }
    
    @DSComment("GUI, alert dialog")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.008 -0500", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "26AF562DBD989B710AC7960278F44650")
    
@Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mAlert.setTitle(title);
    }

    /**
     * @see Builder#setCustomTitle(View)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.010 -0500", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "25D57FD691BD0F556687B6AEB5E48BBF")
    
public void setCustomTitle(View customTitleView) {
        mAlert.setCustomTitle(customTitleView);
    }
    
    @DSComment("GUI, alert dialog")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.012 -0500", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "89AE63E331E776DD0006DBDEB8468520")
    
public void setMessage(CharSequence message) {
        mAlert.setMessage(message);
    }

    /**
     * Set the view to display in that dialog.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.015 -0500", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "7D1301105820BDDE7285DE576977D3BF")
    
public void setView(View view) {
        mAlert.setView(view);
    }
    
    /**
     * Set the view to display in that dialog, specifying the spacing to appear around that 
     * view.
     *
     * @param view The view to show in the content area of the dialog
     * @param viewSpacingLeft Extra space to appear to the left of {@code view}
     * @param viewSpacingTop Extra space to appear above {@code view}
     * @param viewSpacingRight Extra space to appear to the right of {@code view}
     * @param viewSpacingBottom Extra space to appear below {@code view}
     */
    @DSComment("GUI, alert dialog")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.017 -0500", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "AF0B58B488D79D0F8E3CA214011A0CEC")
    
public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
    }

    /**
     * Set a message to be sent when a button is pressed.
     * 
     * @param whichButton Which button to set the message for, can be one of
     *            {@link DialogInterface#BUTTON_POSITIVE},
     *            {@link DialogInterface#BUTTON_NEGATIVE}, or
     *            {@link DialogInterface#BUTTON_NEUTRAL}
     * @param text The text to display in positive button.
     * @param msg The {@link Message} to be sent when clicked.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.019 -0500", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "0046613B36C60BA64ACC9976D324A9E9")
    
public void setButton(int whichButton, CharSequence text, Message msg) {
        mAlert.setButton(whichButton, text, null, msg);
    }
    
    /**
     * Set a listener to be invoked when the positive button of the dialog is pressed.
     * 
     * @param whichButton Which button to set the listener on, can be one of
     *            {@link DialogInterface#BUTTON_POSITIVE},
     *            {@link DialogInterface#BUTTON_NEGATIVE}, or
     *            {@link DialogInterface#BUTTON_NEUTRAL}
     * @param text The text to display in positive button.
     * @param listener The {@link DialogInterface.OnClickListener} to use.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.021 -0500", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "D3DE8E23F2B038E81D912168B20BA86B")
    
public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        mAlert.setButton(whichButton, text, listener, null);
    }

    /**
     * @deprecated Use {@link #setButton(int, CharSequence, Message)} with
     *             {@link DialogInterface#BUTTON_POSITIVE}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.024 -0500", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "3783B1507BFE8068752A0D0B164EE313")
    
@Deprecated
    public void setButton(CharSequence text, Message msg) {
        setButton(BUTTON_POSITIVE, text, msg);
    }
        
    /**
     * @deprecated Use {@link #setButton(int, CharSequence, Message)} with
     *             {@link DialogInterface#BUTTON_NEGATIVE}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.026 -0500", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "D4884C89A1C94D1ECBF8C79E701A6876")
    
@Deprecated
    public void setButton2(CharSequence text, Message msg) {
        setButton(BUTTON_NEGATIVE, text, msg);
    }

    /**
     * @deprecated Use {@link #setButton(int, CharSequence, Message)} with
     *             {@link DialogInterface#BUTTON_NEUTRAL}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.028 -0500", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "5202EF20E6EDC4ECE7E596ECE04916F3")
    
@Deprecated
    public void setButton3(CharSequence text, Message msg) {
        setButton(BUTTON_NEUTRAL, text, msg);
    }

    /**
     * Set a listener to be invoked when button 1 of the dialog is pressed.
     * 
     * @param text The text to display in button 1.
     * @param listener The {@link DialogInterface.OnClickListener} to use.
     * @deprecated Use
     *             {@link #setButton(int, CharSequence, android.content.DialogInterface.OnClickListener)}
     *             with {@link DialogInterface#BUTTON_POSITIVE}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.031 -0500", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "B658EED7CF0009AA347A5F14DAD846DB")
    
@Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_POSITIVE, text, listener);
    }

    /**
     * Set a listener to be invoked when button 2 of the dialog is pressed.
     * @param text The text to display in button 2.
     * @param listener The {@link DialogInterface.OnClickListener} to use.
     * @deprecated Use
     *             {@link #setButton(int, CharSequence, android.content.DialogInterface.OnClickListener)}
     *             with {@link DialogInterface#BUTTON_NEGATIVE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.033 -0500", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "DA2AED0F23B167CC3FB1137A5942A939")
    
@Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEGATIVE, text, listener);
    }

    /**
     * Set a listener to be invoked when button 3 of the dialog is pressed.
     * @param text The text to display in button 3.
     * @param listener The {@link DialogInterface.OnClickListener} to use.
     * @deprecated Use
     *             {@link #setButton(int, CharSequence, android.content.DialogInterface.OnClickListener)}
     *             with {@link DialogInterface#BUTTON_POSITIVE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.035 -0500", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "392B071FC0B6B786680D257DBC3EEBB0")
    
@Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEUTRAL, text, listener);
    }

    /**
     * Set resId to 0 if you don't want an icon.
     * @param resId the resourceId of the drawable to use as the icon or 0
     * if you don't want an icon.
     */
    @DSComment("GUI, alert dialog")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.037 -0500", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "473496E8EFD550346F20C86156F373DF")
    
public void setIcon(int resId) {
        mAlert.setIcon(resId);
    }
    
    @DSComment("GUI, alert dialog")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.039 -0500", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "6B370B792F8AA46DE34678423A94EE2C")
    
public void setIcon(Drawable icon) {
        mAlert.setIcon(icon);
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.054 -0500", hash_original_field = "1DC78937194A9EA3900107777E6924E5", hash_generated_field = "A137DC00364323BBFDABBB1A415FA549")

        private  AlertController.AlertParams P;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.056 -0500", hash_original_field = "FB3425DED13E4977175AE9276B730509", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        /**
         * Constructor using a context for this builder and the {@link AlertDialog} it creates.
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.059 -0500", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "0F6F28BA388F588C46FF4901DEA377E8")
        
public Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
        }

        /**
         * Constructor using a context and theme for this builder and
         * the {@link AlertDialog} it creates.  The actual theme
         * that an AlertDialog uses is a private implementation, however you can
         * here supply either the name of an attribute in the theme from which
         * to get the dialog's style (such as {@link android.R.attr#alertDialogTheme}
         * or one of the constants
         * {@link AlertDialog#THEME_TRADITIONAL AlertDialog.THEME_TRADITIONAL},
         * {@link AlertDialog#THEME_HOLO_DARK AlertDialog.THEME_HOLO_DARK}, or
         * {@link AlertDialog#THEME_HOLO_LIGHT AlertDialog.THEME_HOLO_LIGHT}.
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.062 -0500", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "FC7699A0F2A3B06BF3E1311C765B25A6")
        
public Builder(Context context, int theme) {
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            mTheme = theme;
        }
        
        /**
         * Returns a {@link Context} with the appropriate theme for dialogs created by this Builder.
         * Applications should use this Context for obtaining LayoutInflaters for inflating views
         * that will be used in the resulting dialogs, as it will cause views to be inflated with
         * the correct theme.
         *
         * @return A Context for built Dialogs.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.064 -0500", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "5AE1219313A917C064B5760C49E9B59F")
        @DSSafe(DSCat.GUI)
        
public Context getContext() {
            return P.mContext;
        }

        /**
         * Set the title using the given resource id.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.066 -0500", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "C1B321AD7C109A70C6B989AF777C61FA")
        @DSSafe(DSCat.GUI)
public Builder setTitle(int titleId) {
            P.mTitle = P.mContext.getText(titleId);
            return this;
        }
        
        /**
         * Set the title displayed in the {@link Dialog}.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.068 -0500", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "1AFDB2B8A5FCE2E28D2D1C58F58EC5B8")
        @DSSafe(DSCat.GUI)
public Builder setTitle(CharSequence title) {
            P.mTitle = title;
            return this;
        }
        
        /**
         * Set the title using the custom view {@code customTitleView}. The
         * methods {@link #setTitle(int)} and {@link #setIcon(int)} should be
         * sufficient for most titles, but this is provided if the title needs
         * more customization. Using this will replace the title and icon set
         * via the other methods.
         * 
         * @param customTitleView The custom view to use as the title.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.071 -0500", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "71642A15466E050148BEE69BDB2B1787")
        @DSSafe(DSCat.GUI)
public Builder setCustomTitle(View customTitleView) {
            P.mCustomTitleView = customTitleView;
            return this;
        }
        
        /**
         * Set the message to display using the given resource id.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.074 -0500", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "8C276A1062CC9ECE1527F7D9107E8E66")
        @DSSafe(DSCat.GUI)
public Builder setMessage(int messageId) {
            P.mMessage = P.mContext.getText(messageId);
            return this;
        }
        
        /**
         * Set the message to display.
          *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.076 -0500", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "BC1096BDDA51F124002315B6E17E5702")
        @DSSafe(DSCat.GUI)
public Builder setMessage(CharSequence message) {
            P.mMessage = message;
            return this;
        }
        
        /**
         * Set the resource id of the {@link Drawable} to be used in the title.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.078 -0500", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "94655B8424EF9A24442657C671A58206")
        @DSSafe(DSCat.GUI)
public Builder setIcon(int iconId) {
            P.mIconId = iconId;
            return this;
        }
        
        /**
         * Set the {@link Drawable} to be used in the title.
          *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.080 -0500", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "3C6ED940C21C72F0CCD25F6246E11021")
        @DSSafe(DSCat.GUI)
public Builder setIcon(Drawable icon) {
            P.mIcon = icon;
            return this;
        }

        /**
         * Set an icon as supplied by a theme attribute. e.g. android.R.attr.alertDialogIcon
         *
         * @param attrId ID of a theme attribute that points to a drawable resource.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.082 -0500", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "3E02C58DA8DADBC3FB261BAACAC5BA20")
        @DSSafe(DSCat.GUI)
public Builder setIconAttribute(int attrId) {
            TypedValue out = new TypedValue();
            P.mContext.getTheme().resolveAttribute(attrId, out, true);
            P.mIconId = out.resourceId;
            return this;
        }

        /**
         * Set a listener to be invoked when the positive button of the dialog is pressed.
         * @param textId The resource id of the text to display in the positive button
         * @param listener The {@link DialogInterface.OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.084 -0500", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "2F5BAAC067B9ADA408583697C46D7274")
        @DSVerified
        @DSSafe(DSCat.GUI)
public Builder setPositiveButton(int textId, final OnClickListener listener) {
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;            
            return this;
        }
        
        /**
         * Set a listener to be invoked when the positive button of the dialog is pressed.
         * @param text The text to display in the positive button
         * @param listener The {@link DialogInterface.OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.087 -0500", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "1B725E35B3DB53C9480DA42C86D26A92")
        @DSSafe(DSCat.GUI)
        @DSVerified
public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the negative button of the dialog is pressed.
         * @param textId The resource id of the text to display in the negative button
         * @param listener The {@link DialogInterface.OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.090 -0500", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "B8835945689101A5B72EC7CF869619DA")
        @DSSafe(DSCat.GUI)
public Builder setNegativeButton(int textId, final OnClickListener listener) {
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the negative button of the dialog is pressed.
         * @param text The text to display in the negative button
         * @param listener The {@link DialogInterface.OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.092 -0500", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "94AF7F7BDC95ADF7F606F7D6302D55C4")
        @DSSafe(DSCat.GUI)
public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the neutral button of the dialog is pressed.
         * @param textId The resource id of the text to display in the neutral button
         * @param listener The {@link DialogInterface.OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.094 -0500", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "6402658DECA119E7ABB66256669A75CD")
        @DSSafe(DSCat.GUI)
public Builder setNeutralButton(int textId, final OnClickListener listener) {
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
            return this;
        }
        
        /**
         * Set a listener to be invoked when the neutral button of the dialog is pressed.
         * @param text The text to display in the neutral button
         * @param listener The {@link DialogInterface.OnClickListener} to use.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.097 -0500", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "F7A58A0D5FAA5472EA021A9A5916CD3A")
        @DSSafe(DSCat.GUI)
public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
            return this;
        }
        
        /**
         * Sets whether the dialog is cancelable or not.  Default is true.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.099 -0500", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "511A8EFD482F74CB240B2FF5E5CE817C")
        @DSSafe(DSCat.GUI)
public Builder setCancelable(boolean cancelable) {
            P.mCancelable = cancelable;
            return this;
        }
        
        /**
         * Sets the callback that will be called if the dialog is canceled.
         * @see #setCancelable(boolean)
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.101 -0500", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "48D9633D0088989C2BDE9DFDAEA0D8D0")
        @DSSafe(DSCat.GUI)
public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            P.mOnCancelListener = onCancelListener;
            return this;
        }
        
        /**
         * Sets the callback that will be called if a key is dispatched to the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.103 -0500", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "E1F90638C4DF6B880D4A71B27B9AB750")
        @DSSafe(DSCat.GUI)
        @DSVerified
public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            P.mOnKeyListener = onKeyListener;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener. This should be an array type i.e. R.array.foo
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.105 -0500", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "2EE86EC3C773C994166A055A443210DA")
        @DSSafe(DSCat.GUI)
public Builder setItems(int itemsId, final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.108 -0500", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "1DE5D2AB39561FE0EB9ED55669BB02AD")
        @DSSafe(DSCat.GUI)
public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
            return this;
        }
        
        /**
         * Set a list of items, which are supplied by the given {@link ListAdapter}, to be
         * displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener.
         * 
         * @param adapter The {@link ListAdapter} to supply the list of items
         * @param listener The listener that will be called when an item is clicked.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.110 -0500", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "5EFDB3AA1BD0466672A2A8C5BFD10D57")
        @DSSafe(DSCat.GUI)
public Builder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            return this;
        }
        
        /**
         * Set a list of items, which are supplied by the given {@link Cursor}, to be
         * displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener.
         * 
         * @param cursor The {@link Cursor} to supply the list of items
         * @param listener The listener that will be called when an item is clicked.
         * @param labelColumn The column name on the cursor containing the string to display
         *          in the label.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.113 -0500", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "D1F2CC81FB32C7181079A669AD1EEA5A")
        @DSSafe(DSCat.GUI)
public Builder setCursor(final Cursor cursor, final OnClickListener listener,
                String labelColumn) {
            P.mCursor = cursor;
            P.mLabelColumn = labelColumn;
            P.mOnClickListener = listener;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content,
         * you will be notified of the selected item via the supplied listener.
         * This should be an array type, e.g. R.array.foo. The list will have
         * a check mark displayed to the right of the text for each checked
         * item. Clicking on an item in the list will not dismiss the dialog.
         * Clicking on a button will dismiss the dialog.
         * 
         * @param itemsId the resource id of an array i.e. R.array.foo
         * @param checkedItems specifies which items are checked. It should be null in which case no
         *        items are checked. If non null it must be exactly the same length as the array of
         *        items.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.116 -0500", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "6701BC1622752371D4F62F38ACAA84FE")
        @DSSafe(DSCat.GUI)
public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content,
         * you will be notified of the selected item via the supplied listener.
         * The list will have a check mark displayed to the right of the text
         * for each checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param items the text of the items to be displayed in the list.
         * @param checkedItems specifies which items are checked. It should be null in which case no
         *        items are checked. If non null it must be exactly the same length as the array of
         *        items.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.118 -0500", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "97E9BF19397F59DD8D525153E723E5F8")
        @DSSafe(DSCat.GUI)
public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content,
         * you will be notified of the selected item via the supplied listener.
         * The list will have a check mark displayed to the right of the text
         * for each checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param cursor the cursor used to provide the items.
         * @param isCheckedColumn specifies the column name on the cursor to use to determine
         *        whether a checkbox is checked or not. It must return an integer value where 1
         *        means checked and 0 means unchecked.
         * @param labelColumn The column name on the cursor containing the string to display in the
         *        label.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.121 -0500", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "BC32B07AAA253F2377B40FE6AE14D358")
        @DSSafe(DSCat.GUI)
public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, 
                final OnMultiChoiceClickListener listener) {
            P.mCursor = cursor;
            P.mOnCheckboxClickListener = listener;
            P.mIsCheckedColumn = isCheckedColumn;
            P.mLabelColumn = labelColumn;
            P.mIsMultiChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. This should be an array type i.e.
         * R.array.foo The list will have a check mark displayed to the right of the text for the
         * checked item. Clicking on an item in the list will not dismiss the dialog. Clicking on a
         * button will dismiss the dialog.
         * 
         * @param itemsId the resource id of an array i.e. R.array.foo
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.123 -0500", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "6B40AC85A4B478B0B3BE50193B7D295E")
        @DSSafe(DSCat.GUI)
public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. The list will have a check mark displayed to
         * the right of the text for the checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param cursor the cursor to retrieve the items from.
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param labelColumn The column name on the cursor containing the string to display in the
         *        label.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.125 -0500", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "0D4613148EE114E4101E8FE15EA82382")
        @DSSafe(DSCat.GUI)
public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. The list will have a check mark displayed to
         * the right of the text for the checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param items the items to be displayed.
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.128 -0500", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "55C7F08B04F9720934A616734548F4F9")
        @DSSafe(DSCat.GUI)
public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return this;
        }
        
        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of
         * the selected item via the supplied listener. The list will have a check mark displayed to
         * the right of the text for the checked item. Clicking on an item in the list will not
         * dismiss the dialog. Clicking on a button will dismiss the dialog.
         * 
         * @param adapter The {@link ListAdapter} to supply the list of items
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener notified when an item on the list is clicked. The dialog will not be
         *        dismissed when an item is clicked. It will only be dismissed if clicked on a
         *        button, if no buttons are supplied it's up to the user to dismiss the dialog.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.130 -0500", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "9B2F3B167497F8BA7E022001EE927AC5")
        @DSSafe(DSCat.GUI)
public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return this;
        }
        
        /**
         * Sets a listener to be invoked when an item in the list is selected.
         * 
         * @param listener The listener to be invoked.
         * @see AdapterView#setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener)
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.132 -0500", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "B9B840396D5C1F2D12D374A69232DD85")
        @DSSafe(DSCat.GUI)
public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            P.mOnItemSelectedListener = listener;
            return this;
        }
        
        /**
         * Set a custom view to be the contents of the Dialog. If the supplied view is an instance
         * of a {@link ListView} the light background will be used.
         *
         * @param view The view to use as the contents of the Dialog.
         * 
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.135 -0500", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "7928CC8716E776AC2961F8AA517FB3E2")
        @DSSafe(DSCat.GUI)
public Builder setView(View view) {
            P.mView = view;
            P.mViewSpacingSpecified = false;
            return this;
        }
        
        /**
         * Set a custom view to be the contents of the Dialog, specifying the
         * spacing to appear around that view. If the supplied view is an
         * instance of a {@link ListView} the light background will be used.
         * 
         * @param view The view to use as the contents of the Dialog.
         * @param viewSpacingLeft Spacing between the left edge of the view and
         *        the dialog frame
         * @param viewSpacingTop Spacing between the top edge of the view and
         *        the dialog frame
         * @param viewSpacingRight Spacing between the right edge of the view
         *        and the dialog frame
         * @param viewSpacingBottom Spacing between the bottom edge of the view
         *        and the dialog frame
         * @return This Builder object to allow for chaining of calls to set
         *         methods
         *         
         * 
         * This is currently hidden because it seems like people should just
         * be able to put padding around the view.
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.137 -0500", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "2C41C333F81092D3948E6DDB11667FAB")
        @DSSafe(DSCat.GUI)
public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop,
                int viewSpacingRight, int viewSpacingBottom) {
            P.mView = view;
            P.mViewSpacingSpecified = true;
            P.mViewSpacingLeft = viewSpacingLeft;
            P.mViewSpacingTop = viewSpacingTop;
            P.mViewSpacingRight = viewSpacingRight;
            P.mViewSpacingBottom = viewSpacingBottom;
            return this;
        }
        
        /**
         * Sets the Dialog to use the inverse background, regardless of what the
         * contents is.
         * 
         * @param useInverseBackground Whether to use the inverse background
         * 
         * @return This Builder object to allow for chaining of calls to set methods
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.139 -0500", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "B32914095F6F5C84CCEA954B030A0DAA")
        @DSSafe(DSCat.GUI)
public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            P.mForceInverseBackground = useInverseBackground;
            return this;
        }

        /**
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.143 -0500", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "6CC8DBE7F755A014019857E9072DEA3D")
        @DSSafe(DSCat.GUI)
public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            P.mRecycleOnMeasure = enabled;
            return this;
        }

        /**
         * Creates a {@link AlertDialog} with the arguments supplied to this builder. It does not
         * {@link Dialog#show()} the dialog. This allows the user to do any extra processing
         * before displaying the dialog. Use {@link #show()} if you don't have any other processing
         * to do and want this to be created and displayed.
         */
        @DSComment("New Dialog")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.145 -0500", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "316857243741277D06918E544FCD71B7")
        
public AlertDialog create() {
            final AlertDialog dialog = new AlertDialog(P.mContext, mTheme, false);
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
            if (P.mCancelable) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(P.mOnCancelListener);
            if (P.mOnKeyListener != null) {
                dialog.setOnKeyListener(P.mOnKeyListener);
                //P.mOnKeyListener.onKey(dialog, DSUtils.FAKE_INT, new KeyEvent());
            }
            if (P.mOnCancelListener != null) {
               //P.mOnCancelListener.onCancel(dialog);
               dialog.setOnCancelListener(P.mOnCancelListener);
            }
            if (P.mOnCheckboxClickListener != null) {
                P.mOnCheckboxClickListener.onClick(dialog, DSUtils.FAKE_INT, false);
            }
            
            if (P.mOnItemSelectedListener != null) {
                AdapterView av =  (AdapterView)P.mView;
                P.mOnItemSelectedListener.onItemSelected(av, new View(DSOnlyType.DONTCARE),
                        DSUtils.FAKE_INT, DSUtils.FAKE_INT);
                P.mOnItemSelectedListener.onNothingSelected(av);
            }
            if (P.mOnClickListener != null) {
                P.mOnClickListener.onClick(dialog, DSUtils.FAKE_INT);
            }
            if (P.mNegativeButtonListener != null) {
                P.mNegativeButtonListener.onClick(dialog, DSUtils.FAKE_INT);
            }

            if (P.mPositiveButtonListener != null) {
                P.mPositiveButtonListener.onClick(dialog, DSUtils.FAKE_INT);
            }

            if (P.mNeutralButtonListener != null) {
                P.mNeutralButtonListener.onClick(dialog, DSUtils.FAKE_INT);
            }

            //TODO:
            // we proably need to inflate all the items added to the builder
            // and call them in here
            return dialog;
        }

        /**
         * Creates a {@link AlertDialog} with the arguments supplied to this builder and
         * {@link Dialog#show()}'s the dialog.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.147 -0500", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "FECC0B8CEF43AB35AB1E1B32C0D7658C")
        
public AlertDialog show() {
            AlertDialog dialog = create();
            dialog.show();
            return dialog;
        }
        
    }

    /**
     * Set an icon as supplied by a theme attribute. e.g. android.R.attr.alertDialogIcon
     *
     * @param attrId ID of a theme attribute that points to a drawable resource.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.042 -0500", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "6E400D4EB3C46F271936899BA09F853E")
    @DSSafe(DSCat.GUI)
public void setIconAttribute(int attrId) {
        TypedValue out = new TypedValue();
        mContext.getTheme().resolveAttribute(attrId, out, true);
        mAlert.setIcon(out.resourceId);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.044 -0500", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "22B6B58432E30210C8CBE76AA4BB4DEB")
    @DSSafe(DSCat.GUI)
public void setInverseBackgroundForced(boolean forceInverseBackground) {
        mAlert.setInverseBackgroundForced(forceInverseBackground);
    }
    
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.046 -0500", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "EDD922029DB087B0F937A5B2CFDC27A2")
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAlert.installContent();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.048 -0500", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "27DFB88588CFB33554A656F3049D56EF")
    @DSSafe(DSCat.GUI)
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mAlert.onKeyDown(keyCode, event)) return true;
        return super.onKeyDown(keyCode, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:22.051 -0500", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "A096E8FF98E1A1DD6D94952D3A8CA1EB")
    @DSSafe(DSCat.GUI)
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (mAlert.onKeyUp(keyCode, event)) return true;
        return super.onKeyUp(keyCode, event);
    }
}

