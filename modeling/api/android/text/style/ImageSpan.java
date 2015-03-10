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


package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

public class ImageSpan extends DynamicDrawableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.787 -0500", hash_original_field = "38BA53DD394F85639C99ED8E666FF8FB", hash_generated_field = "F17AF26B1AE93DE0DD2EED2442B6F076")

    private Drawable mDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.790 -0500", hash_original_field = "51D45F174AF8981FCE604D5639A0B9EE", hash_generated_field = "5230A0318FFD99BBF5DCA1BF9243AE7A")

    private Uri mContentUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.792 -0500", hash_original_field = "641E06FC0A3C0A94A3294754C591BD1B", hash_generated_field = "C75E6DA122FF842A3C7D587E6E200AF8")

    private int mResourceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.795 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.797 -0500", hash_original_field = "1AEA727B3BB073E5F13ED3E9E384638B", hash_generated_field = "5EB2E77F51594E2C1DE90F3545DAFA8A")

    private String mSource;

    /**
     * @deprecated Use {@link #ImageSpan(Context, Bitmap)} instead.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.800 -0500", hash_original_method = "185ED0AA6BEAFCFF142A4CFD45E574FC", hash_generated_method = "624EC4071B8522AAE0D4EBEFCB21EF98")
    
@Deprecated
    public ImageSpan(Bitmap b) {
        this(null, b, ALIGN_BOTTOM);
    }

    /**
     * @deprecated Use {@link #ImageSpan(Context, Bitmap, int) instead.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.803 -0500", hash_original_method = "34B2A214F0FD529DA939313FB3C3E538", hash_generated_method = "8E8550FCD976314D923DEFCFA1FC0453")
    
@Deprecated
    public ImageSpan(Bitmap b, int verticalAlignment) {
        this(null, b, verticalAlignment);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.806 -0500", hash_original_method = "7AEE11D7D0A74AC540256E446F7A2408", hash_generated_method = "539749FEC0F15BD12798EBE87A210568")
    
public ImageSpan(Context context, Bitmap b) {
        this(context, b, ALIGN_BOTTOM);
    }

    /**
     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
     * {@link DynamicDrawableSpan#ALIGN_BASELINE}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.809 -0500", hash_original_method = "3963AA6755EF0F8E669BE02E5FE48B0A", hash_generated_method = "BCF7A8F09E1702CBCFA9735C9A92F82E")
    
public ImageSpan(Context context, Bitmap b, int verticalAlignment) {
        super(verticalAlignment);
        mContext = context;
        mDrawable = context != null
                ? new BitmapDrawable(context.getResources(), b)
                : new BitmapDrawable(b);
        int width = mDrawable.getIntrinsicWidth();
        int height = mDrawable.getIntrinsicHeight();
        mDrawable.setBounds(0, 0, width > 0 ? width : 0, height > 0 ? height : 0); 
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.812 -0500", hash_original_method = "0D126CCCA77E2FB90C8091AB4A5A8377", hash_generated_method = "55AD8A1D6AAD9B36C0BD9E94B1DBCBD1")
    
public ImageSpan(Drawable d) {
        this(d, ALIGN_BOTTOM);
    }

    /**
     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
     * {@link DynamicDrawableSpan#ALIGN_BASELINE}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.816 -0500", hash_original_method = "A8A2FDBB2FE3A38ECC14673F42D0EA39", hash_generated_method = "C079A45C63C93828EF855887222E14D3")
    
public ImageSpan(Drawable d, int verticalAlignment) {
        super(verticalAlignment);
        mDrawable = d;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.819 -0500", hash_original_method = "54F6AA82EA4B003ADF5D8246E336A82D", hash_generated_method = "409B3E7F46A0B59F6B502674E298C7AA")
    
public ImageSpan(Drawable d, String source) {
        this(d, source, ALIGN_BOTTOM);
    }

    /**
     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
     * {@link DynamicDrawableSpan#ALIGN_BASELINE}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.822 -0500", hash_original_method = "F9636F3F26DA70FC2592614F77D85D71", hash_generated_method = "A59A9AAF97620FF240E515933F3F045E")
    
public ImageSpan(Drawable d, String source, int verticalAlignment) {
        super(verticalAlignment);
        mDrawable = d;
        mSource = source;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.825 -0500", hash_original_method = "E44302541FD4ECECF2698F7D07EBCA57", hash_generated_method = "A3FE01B92EE49FDD6CF9B884BFEBFBFE")
    
public ImageSpan(Context context, Uri uri) {
        this(context, uri, ALIGN_BOTTOM);
    }

    /**
     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
     * {@link DynamicDrawableSpan#ALIGN_BASELINE}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.828 -0500", hash_original_method = "97E5D1114EAA0CA1A8404960D716AC3A", hash_generated_method = "88D8B77573C72D20FA5551EF9DF9B30D")
    
public ImageSpan(Context context, Uri uri, int verticalAlignment) {
        super(verticalAlignment);
        mContext = context;
        mContentUri = uri;
        mSource = uri.toString();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.831 -0500", hash_original_method = "9E8FB6BDEE77C38D81FCBDDCFBDDF78F", hash_generated_method = "37385C5EF61CD732A668ECF71D98738B")
    
public ImageSpan(Context context, int resourceId) {
        this(context, resourceId, ALIGN_BOTTOM);
    }

    /**
     * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
     * {@link DynamicDrawableSpan#ALIGN_BASELINE}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.834 -0500", hash_original_method = "112063CFBD1BF410C553139A09CB99FD", hash_generated_method = "2BA006D4A6FC0FEA7C3CCBAA2DEF9F1D")
    
public ImageSpan(Context context, int resourceId, int verticalAlignment) {
        super(verticalAlignment);
        mContext = context;
        mResourceId = resourceId;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.837 -0500", hash_original_method = "16DECD9D0B2DB9DD9C51FE274851DFB5", hash_generated_method = "EF0FF21DEC8BC201EE4C65D597D6BECC")
    
@Override
    public Drawable getDrawable() {
        Drawable drawable = null;
        
        if (mDrawable != null) {
            drawable = mDrawable;
        } else  if (mContentUri != null) {
            Bitmap bitmap = null;
            try {
                InputStream is = mContext.getContentResolver().openInputStream(
                        mContentUri);
                bitmap = BitmapFactory.decodeStream(is);
                drawable = new BitmapDrawable(mContext.getResources(), bitmap);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
                is.close();
            } catch (Exception e) {
                Log.e("sms", "Failed to loaded content " + mContentUri, e);
            }
        } else {
            try {
                drawable = mContext.getResources().getDrawable(mResourceId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight());
            } catch (Exception e) {
                Log.e("sms", "Unable to find resource: " + mResourceId);
            }                
        }

        return drawable;
    }

    /**
     * Returns the source string that was saved during construction.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.840 -0500", hash_original_method = "6D9DB226EA21C548410845AA7A7E2DD4", hash_generated_method = "AF9874FA5096A31AE97D22EB7DD799B5")
    
public String getSource() {
        return mSource;
    }
    
}

