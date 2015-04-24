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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;

import android.content.res.AssetManager;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.util.TypedValue;

import com.android.internal.R;

class FileLoader extends StreamLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.123 -0500", hash_original_field = "EB9F0DA7226F09B1BEBAFC8B7084A19D", hash_generated_field = "2386E910C23CC098E2AFE444C68F6B86")

    // used for files under asset directory
    static final int TYPE_ASSET = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.125 -0500", hash_original_field = "A87C2B8F0CB69BF64123B6643C5678CC", hash_generated_field = "37CFCBEAA36971A1B22E497F54B484AC")

    static final int TYPE_RES = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.127 -0500", hash_original_field = "5242112E61C91F63D0C4250E69D4424B", hash_generated_field = "9E507F10BB893E2897D9DF437CDF3C57")

    static final int TYPE_FILE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.130 -0500", hash_original_field = "CF5103981B618784F76950E4558FDBCC", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.117 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.119 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.121 -0500", hash_original_field = "20CA612BF24253CD0FC221B1AD7F740F", hash_generated_field = "B054B0568675CAED6B0FC902EBB17D6A")

    private boolean mAllowFileAccess;

    /**
     * Construct a FileLoader with the file URL specified as the content
     * source.
     *
     * @param url Full file url pointing to content to be loaded
     * @param loadListener LoadListener to pass the content to
     * @param asset true if url points to an asset.
     * @param allowFileAccess true if this WebView is allowed to access files
     *                        on the file system.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.133 -0500", hash_original_method = "0A468BF2FF018C04A055F46D2001401C", hash_generated_method = "030E5997862439D9E8876001FF164B61")
    
FileLoader(String url, LoadListener loadListener, int type,
            boolean allowFileAccess) {
        super(loadListener);
        mType = type;
        mAllowFileAccess = allowFileAccess;

        // clean the Url
        int index = url.indexOf('?');
        if (mType == TYPE_ASSET) {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.ASSET_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.ASSET_BASE.length()));
        } else if (mType == TYPE_RES) {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.RESOURCE_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.RESOURCE_BASE.length()));
        } else {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.FILE_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.FILE_BASE.length()));
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.135 -0500", hash_original_method = "987DD890C3289D23A785AB1F430BD4A8", hash_generated_method = "363217D5C0B22809618E324C1C500FBA")
    
private String errString(Exception ex) {
        String exMessage = ex.getMessage();
        String errString = mContext.getString(R.string.httpErrorFileNotFound);
        if (exMessage != null) {
            errString += " " + exMessage;
        }
        return errString;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.140 -0500", hash_original_method = "97D1B11BE7CB4BE78107ED00EAAEAEA4", hash_generated_method = "D57BC4C86CF32169C758589F5117BE81")
    
@Override
    protected boolean setupStreamAndSendStatus() {
        try {
            if (mType == TYPE_ASSET) {
                try {
                    mDataStream = mContext.getAssets().open(mPath);
                } catch (java.io.FileNotFoundException ex) {
                    // try the rest files included in the package
                    mDataStream = mContext.getAssets().openNonAsset(mPath);
                }
            } else if (mType == TYPE_RES) {
                // get the resource id from the path. e.g. for the path like
                // drawable/foo.png, the id is located at field "foo" of class
                // "<package>.R$drawable"
                if (mPath == null || mPath.length() == 0) {
                    Log.e(LOGTAG, "Need a path to resolve the res file");
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                    return false;

                }
                int slash = mPath.indexOf('/');
                int dot = mPath.indexOf('.', slash);
                if (slash == -1 || dot == -1) {
                    Log.e(LOGTAG, "Incorrect res path: " + mPath);
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                    return false;
                }
                String subClassName = mPath.substring(0, slash);
                String fieldName = mPath.substring(slash + 1, dot);
                String errorMsg = null;
                try {
                    final Class<?> d = mContext.getApplicationContext()
                            .getClassLoader().loadClass(
                                    mContext.getPackageName() + ".R$"
                                            + subClassName);
                    final Field field = d.getField(fieldName);
                    final int id = field.getInt(null);
                    TypedValue value = new TypedValue();
                    mContext.getResources().getValue(id, value, true);
                    if (value.type == TypedValue.TYPE_STRING) {
                        mDataStream = mContext.getAssets().openNonAsset(
                                value.assetCookie, value.string.toString(),
                                AssetManager.ACCESS_STREAMING);
                    } else {
                        errorMsg = "Only support TYPE_STRING for the res files";
                    }
                } catch (ClassNotFoundException e) {
                    errorMsg = "Can't find class:  "
                            + mContext.getPackageName() + ".R$" + subClassName;
                } catch (SecurityException e) {
                    errorMsg = "Caught SecurityException: " + e;
                } catch (NoSuchFieldException e) {
                    errorMsg = "Can't find field:  " + fieldName + " in "
                            + mContext.getPackageName() + ".R$" + subClassName;
                } catch (IllegalArgumentException e) {
                    errorMsg = "Caught IllegalArgumentException: " + e;
                } catch (IllegalAccessException e) {
                    errorMsg = "Caught IllegalAccessException: " + e;
                }
                if (errorMsg != null) {
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                    return false;
                }
            } else {
                if (!mAllowFileAccess) {
                    mLoadListener.error(EventHandler.FILE_ERROR,
                            mContext.getString(R.string.httpErrorFileNotFound));
                    return false;
                }

                mDataStream = new FileInputStream(mPath);
                mContentLength = (new File(mPath)).length();
            }
            mLoadListener.status(1, 1, 200, "OK");

        } catch (java.io.FileNotFoundException ex) {
            mLoadListener.error(EventHandler.FILE_NOT_FOUND_ERROR, errString(ex));
            return false;

        } catch (java.io.IOException ex) {
            mLoadListener.error(EventHandler.FILE_ERROR, errString(ex));
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.142 -0500", hash_original_method = "EECFC31B2787C18B03F2C6B112B9990D", hash_generated_method = "D8D690A91D5C6417F488AAAE5C24337C")
    
@Override
    protected void buildHeaders(Headers headers) {
        // do nothing.
    }
}

