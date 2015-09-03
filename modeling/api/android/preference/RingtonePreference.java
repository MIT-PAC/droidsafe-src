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


package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;

public class RingtonePreference extends Preference implements PreferenceManager.OnActivityResultListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.708 -0500", hash_original_field = "56A1992F57CD1924005ABC17085148FA", hash_generated_field = "03561407E8406E5A39E47D0AFC27E984")

    private static final String TAG = "RingtonePreference";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.711 -0500", hash_original_field = "4B2A2895326A27589C2FEFC503436FF2", hash_generated_field = "94A7358A6004BBA5ED4F762F8CB38E98")

    private int mRingtoneType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.713 -0500", hash_original_field = "02BFEC04AE288B6525C13AF6E6319CDD", hash_generated_field = "130B43374579980A9579B58E0CD66AF8")

    private boolean mShowDefault;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.715 -0500", hash_original_field = "4F5792EC603C204E4DFF3464FB18180B", hash_generated_field = "8DA646E2063FB9AF7649770779C16018")

    private boolean mShowSilent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.717 -0500", hash_original_field = "7DFBC3B390A93C26F8D09A6E08442EF1", hash_generated_field = "475686F1F8A4FC0EFBA10CFC5E693B3C")
    
    private int mRequestCode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.720 -0500", hash_original_method = "29160518A38B8F608A0DA24D9951A92B", hash_generated_method = "79EBDB42A3C41F899F2C7343F52369AC")
    
public RingtonePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.RingtonePreference, defStyle, 0);
        mRingtoneType = a.getInt(com.android.internal.R.styleable.RingtonePreference_ringtoneType,
                RingtoneManager.TYPE_RINGTONE);
        mShowDefault = a.getBoolean(com.android.internal.R.styleable.RingtonePreference_showDefault,
                true);
        mShowSilent = a.getBoolean(com.android.internal.R.styleable.RingtonePreference_showSilent,
                true);
        a.recycle();
    }

    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.723 -0500", hash_original_method = "AC92DB267D2F88D8705E896D57E3E92B", hash_generated_method = "04CF2FA73D484A47A33A7546CDEE1CEF")
    
public RingtonePreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.ringtonePreferenceStyle);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.725 -0500", hash_original_method = "00710FDF3ABE24D79A48628D9B9EF606", hash_generated_method = "84C07F82B94B3D41FFB2C51FC9743954")
    
public RingtonePreference(Context context) {
        this(context, null);
    }

    /**
     * Returns the sound type(s) that are shown in the picker.
     * 
     * @return The sound type(s) that are shown in the picker.
     * @see #setRingtoneType(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.728 -0500", hash_original_method = "1A2D4AB1416848B6CAAD7584C5AE9825", hash_generated_method = "B0885575A71B774A9C6DE91C037D49AE")
    
public int getRingtoneType() {
        return mRingtoneType;
    }

    /**
     * Sets the sound type(s) that are shown in the picker.
     * 
     * @param type The sound type(s) that are shown in the picker.
     * @see RingtoneManager#EXTRA_RINGTONE_TYPE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.730 -0500", hash_original_method = "D7B05FA08D1473DF1FF0F577252B94E4", hash_generated_method = "37CA30581B11F86FA81B248C4D736F72")
    
public void setRingtoneType(int type) {
        mRingtoneType = type;
    }

    /**
     * Returns whether to a show an item for the default sound/ringtone.
     * 
     * @return Whether to show an item for the default sound/ringtone.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.732 -0500", hash_original_method = "1EDF917BBB16A2DD7FDEFF560CC91C95", hash_generated_method = "9597BC61ABE2DEF8B403E3EDC453F4F9")
    
public boolean getShowDefault() {
        return mShowDefault;
    }

    /**
     * Sets whether to show an item for the default sound/ringtone. The default
     * to use will be deduced from the sound type(s) being shown.
     * 
     * @param showDefault Whether to show the default or not.
     * @see RingtoneManager#EXTRA_RINGTONE_SHOW_DEFAULT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.734 -0500", hash_original_method = "14F174C1761E0E1021260A615E0701C9", hash_generated_method = "671EA5E4AE2F093C49DA21BE294F2536")
    
public void setShowDefault(boolean showDefault) {
        mShowDefault = showDefault;
    }

    /**
     * Returns whether to a show an item for 'Silent'.
     * 
     * @return Whether to show an item for 'Silent'.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.736 -0500", hash_original_method = "78493F49FCDC7F2B17EDE4C6D3C9ED80", hash_generated_method = "BC7E753E10F078BC1EC5A10CD6185A35")
    
public boolean getShowSilent() {
        return mShowSilent;
    }

    /**
     * Sets whether to show an item for 'Silent'.
     * 
     * @param showSilent Whether to show 'Silent'.
     * @see RingtoneManager#EXTRA_RINGTONE_SHOW_SILENT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.738 -0500", hash_original_method = "96AD95F70E483549E08CF3AF9865FE34", hash_generated_method = "ED9A52E43C4E13A1AC073562FF44E841")
    
public void setShowSilent(boolean showSilent) {
        mShowSilent = showSilent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.741 -0500", hash_original_method = "086179E398C72E137D63A84E9C2B557A", hash_generated_method = "DD9080048B70F477EC82ACC08018AE6D")
    
@Override
    protected void onClick() {
        // Launch the ringtone picker
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        onPrepareRingtonePickerIntent(intent);
        PreferenceFragment owningFragment = getPreferenceManager().getFragment();
        if (owningFragment != null) {
            owningFragment.startActivityForResult(intent, mRequestCode);
        } else {
            getPreferenceManager().getActivity().startActivityForResult(intent, mRequestCode);
        }
    }

    /**
     * Prepares the intent to launch the ringtone picker. This can be modified
     * to adjust the parameters of the ringtone picker.
     * 
     * @param ringtonePickerIntent The ringtone picker intent that can be
     *            modified by putting extras.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.743 -0500", hash_original_method = "3115FC99B9C3EE3EE3896CF41F72D355", hash_generated_method = "ADC6A4DABB5C962FC6FFAE4CB65D03D8")
    
protected void onPrepareRingtonePickerIntent(Intent ringtonePickerIntent) {

        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,
                onRestoreRingtone());
        
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, mShowDefault);
        if (mShowDefault) {
            ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI,
                    RingtoneManager.getDefaultUri(getRingtoneType()));
        }

        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, mShowSilent);
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, mRingtoneType);
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, getTitle());
    }
    
    /**
     * Called when a ringtone is chosen.
     * <p>
     * By default, this saves the ringtone URI to the persistent storage as a
     * string.
     * 
     * @param ringtoneUri The chosen ringtone's {@link Uri}. Can be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.746 -0500", hash_original_method = "61F749C53ECEF8AEA7C45AB0E864D889", hash_generated_method = "97E54B5514BAD5F6FE975E62C7DE9C0E")
    
protected void onSaveRingtone(Uri ringtoneUri) {
        persistString(ringtoneUri != null ? ringtoneUri.toString() : "");
    }

    /**
     * Called when the chooser is about to be shown and the current ringtone
     * should be marked. Can return null to not mark any ringtone.
     * <p>
     * By default, this restores the previous ringtone URI from the persistent
     * storage.
     * 
     * @return The ringtone to be marked as the current ringtone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.748 -0500", hash_original_method = "0D14EAB00EC2474BC71AEF293B196DEA", hash_generated_method = "D2F960F779FD939B2BC59978D4D13AA0")
    
protected Uri onRestoreRingtone() {
        final String uriString = getPersistedString(null);
        return !TextUtils.isEmpty(uriString) ? Uri.parse(uriString) : null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.750 -0500", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "497DF6D525CC8FE96585CAFDDA47A41E")
    
@Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.752 -0500", hash_original_method = "4538BE331A2E9864F7BFD6437D81EA48", hash_generated_method = "E35CADEDDDAAFCFC72E6D2425C91B3A9")
    
@Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValueObj) {
        String defaultValue = (String) defaultValueObj;
        
        /*
         * This method is normally to make sure the internal state and UI
         * matches either the persisted value or the default value. Since we
         * don't show the current value in the UI (until the dialog is opened)
         * and we don't keep local state, if we are restoring the persisted
         * value we don't need to do anything.
         */
        if (restorePersistedValue) {
            return;
        }
        
        // If we are setting to the default value, we should persist it.
        if (!TextUtils.isEmpty(defaultValue)) {
            onSaveRingtone(Uri.parse(defaultValue));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.755 -0500", hash_original_method = "66AC871F7FDA479CD38955DE80C07AF7", hash_generated_method = "570064CFB7C390AF03FFD74E83DD848A")
    
@Override
    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        
        preferenceManager.registerOnActivityResultListener(this);
        mRequestCode = preferenceManager.getNextRequestCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.757 -0500", hash_original_method = "E8C8E72048A77FCD0D377098E6D641A4", hash_generated_method = "CAAEDAFD4D14B2C6CC9FB50E8E8E0951")
    
public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        
        if (requestCode == mRequestCode) {
            
            if (data != null) {
                Uri uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                
                if (callChangeListener(uri != null ? uri.toString() : "")) {
                    onSaveRingtone(uri);
                }
            }
            
            return true;
        }
        
        return false;
    }
}

