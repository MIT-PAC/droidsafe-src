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


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.880 -0500", hash_original_field = "AFCDB43F15D9604C60DF81DB309311CD", hash_generated_field = "6AD876BF1B2A93FF841DC0A6CDF82D53")

    protected int[] mFrom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.882 -0500", hash_original_field = "51C70736F499787D82D1093BC908680A", hash_generated_field = "793C2D88DE3BA12DDE77A56E8B34D202")

    protected int[] mTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.884 -0500", hash_original_field = "14E762043CB48AC077260FF08B82CF80", hash_generated_field = "76FAAB307CBAB2502A74F2FD4809A2B4")

    private int mStringConversionColumn = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.886 -0500", hash_original_field = "F8263407921113CB7A610A2339B65BA8", hash_generated_field = "9EC5CDC29EBE32FECD7EDABDB5C61341")

    private CursorToStringConverter mCursorToStringConverter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.888 -0500", hash_original_field = "5860CDE70C11C388F482671B0B0F2511", hash_generated_field = "308F8B2EF2E94DF958649BB3CD716341")

    private ViewBinder mViewBinder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.889 -0500", hash_original_field = "393D022CD0A88B84A417682AA08505E2", hash_generated_field = "393D022CD0A88B84A417682AA08505E2")

    String[] mOriginalFrom;

    /**
     * Constructor the enables auto-requery.
     *
     * @deprecated This option is discouraged, as it results in Cursor queries
     * being performed on the application's UI thread and thus can cause poor
     * responsiveness or even Application Not Responding errors.  As an alternative,
     * use {@link android.app.LoaderManager} with a {@link android.content.CursorLoader}.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.892 -0500", hash_original_method = "4CA266072E0BEF58A4BC70323B402D31", hash_generated_method = "6B7F935D2F35D8A0B1A77449115435C4")
    
@Deprecated
    public SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c);
        mTo = to;
        mOriginalFrom = from;
        findColumns(from);
    }

    /**
     * Standard constructor.
     * 
     * @param context The context where the ListView associated with this
     *            SimpleListItemFactory is running
     * @param layout resource identifier of a layout file that defines the views
     *            for this list item. The layout file should include at least
     *            those named views defined in "to"
     * @param c The database cursor.  Can be null if the cursor is not available yet.
     * @param from A list of column names representing the data to bind to the UI.  Can be null 
     *            if the cursor is not available yet.
     * @param to The views that should display column in the "from" parameter.
     *            These should all be TextViews. The first N views in this list
     *            are given the values of the first N columns in the from
     *            parameter.  Can be null if the cursor is not available yet.
     * @param flags Flags used to determine the behavior of the adapter,
     * as per {@link CursorAdapter#CursorAdapter(Context, Cursor, int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.895 -0500", hash_original_method = "07FEC305B6EF36E13BFB609FC3D08908", hash_generated_method = "D87625839B42EA84B49136225DC04AD3")
    
public SimpleCursorAdapter(Context context, int layout, Cursor c, String[] from,
            int[] to, int flags) {
        super(context, layout, c, flags);
        mTo = to;
        mOriginalFrom = from;
        findColumns(from);
    }

    /**
     * Binds all of the field names passed into the "to" parameter of the
     * constructor with their corresponding cursor columns as specified in the
     * "from" parameter.
     *
     * Binding occurs in two phases. First, if a
     * {@link android.widget.SimpleCursorAdapter.ViewBinder} is available,
     * {@link ViewBinder#setViewValue(android.view.View, android.database.Cursor, int)}
     * is invoked. If the returned value is true, binding has occured. If the
     * returned value is false and the view to bind is a TextView,
     * {@link #setViewText(TextView, String)} is invoked. If the returned value is
     * false and the view to bind is an ImageView,
     * {@link #setViewImage(ImageView, String)} is invoked. If no appropriate
     * binding can be found, an {@link IllegalStateException} is thrown.
     *
     * @throws IllegalStateException if binding cannot occur
     * 
     * @see android.widget.CursorAdapter#bindView(android.view.View,
     *      android.content.Context, android.database.Cursor)
     * @see #getViewBinder()
     * @see #setViewBinder(android.widget.SimpleCursorAdapter.ViewBinder)
     * @see #setViewImage(ImageView, String)
     * @see #setViewText(TextView, String)
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.899 -0500", hash_original_method = "DC8B275A35A5B1D2099C370F56E50BB9", hash_generated_method = "01273149BA86C6FD86C6E74045C8A8EE")
    
@Override
    public void bindView(View view, Context context, Cursor cursor) {
        final ViewBinder binder = mViewBinder;
        final int count = mTo.length;
        final int[] from = mFrom;
        final int[] to = mTo;

        for (int i = 0; i < count; i++) {
            final View v = view.findViewById(to[i]);
            if (v != null) {
                boolean bound = false;
                if (binder != null) {
                    bound = binder.setViewValue(v, cursor, from[i]);
                }

                if (!bound) {
                    String text = cursor.getString(from[i]);
                    if (text == null) {
                        text = "";
                    }

                    if (v instanceof TextView) {
                        setViewText((TextView) v, text);
                    } else if (v instanceof ImageView) {
                        setViewImage((ImageView) v, text);
                    } else {
                        throw new IllegalStateException(v.getClass().getName() + " is not a " +
                                " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    /**
     * Returns the {@link ViewBinder} used to bind data to views.
     *
     * @return a ViewBinder or null if the binder does not exist
     *
     * @see #bindView(android.view.View, android.content.Context, android.database.Cursor)
     * @see #setViewBinder(android.widget.SimpleCursorAdapter.ViewBinder)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.901 -0500", hash_original_method = "E0E2C9BDE209838004B6CAB60CB87613", hash_generated_method = "24EF2DCAC9F252399E7488BB4B6717A3")
    
public ViewBinder getViewBinder() {
        return mViewBinder;
    }

    /**
     * Sets the binder used to bind data to views.
     *
     * @param viewBinder the binder used to bind data to views, can be null to
     *        remove the existing binder
     *
     * @see #bindView(android.view.View, android.content.Context, android.database.Cursor)
     * @see #getViewBinder()
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.903 -0500", hash_original_method = "119DFC3ED073D5B4FB9A3C0337902379", hash_generated_method = "CD8F00DE3A674A18D556142232BB8469")
    
public void setViewBinder(ViewBinder viewBinder) {
        mViewBinder = viewBinder;
    }

    /**
     * Called by bindView() to set the image for an ImageView but only if
     * there is no existing ViewBinder or if the existing ViewBinder cannot
     * handle binding to an ImageView.
     *
     * By default, the value will be treated as an image resource. If the
     * value cannot be used as an image resource, the value is used as an
     * image Uri.
     *
     * Intended to be overridden by Adapters that need to filter strings
     * retrieved from the database.
     *
     * @param v ImageView to receive an image
     * @param value the value retrieved from the cursor
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.905 -0500", hash_original_method = "31A5526470C992FDAE212BFFA88B0730", hash_generated_method = "A3BA9232B932A48C4241116FDADFE82E")
    
public void setViewImage(ImageView v, String value) {
        try {
            v.setImageResource(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            v.setImageURI(Uri.parse(value));
        }
    }

    /**
     * Called by bindView() to set the text for a TextView but only if
     * there is no existing ViewBinder or if the existing ViewBinder cannot
     * handle binding to an TextView.
     *
     * Intended to be overridden by Adapters that need to filter strings
     * retrieved from the database.
     * 
     * @param v TextView to receive text
     * @param text the text to be set for the TextView
     */    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.907 -0500", hash_original_method = "5AA8DD17AC94ADB8D267F5D4267EA13E", hash_generated_method = "78A796D1AAAB9527A328641E2AF2A0ED")
    
public void setViewText(TextView v, String text) {
        v.setText(text);
    }

    /**
     * Return the index of the column used to get a String representation
     * of the Cursor.
     *
     * @return a valid index in the current Cursor or -1
     *
     * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
     * @see #setStringConversionColumn(int) 
     * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter)
     * @see #getCursorToStringConverter()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.909 -0500", hash_original_method = "505C15BD7A524BAA123874B0B6BE7D4B", hash_generated_method = "4748C86A8A294C786E42F1CAB875D0E2")
    
public int getStringConversionColumn() {
        return mStringConversionColumn;
    }

    /**
     * Defines the index of the column in the Cursor used to get a String
     * representation of that Cursor. The column is used to convert the
     * Cursor to a String only when the current CursorToStringConverter
     * is null.
     *
     * @param stringConversionColumn a valid index in the current Cursor or -1 to use the default
     *        conversion mechanism
     *
     * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
     * @see #getStringConversionColumn()
     * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter)
     * @see #getCursorToStringConverter()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.911 -0500", hash_original_method = "CAA7C791E82A28ED194AFE600FF6DEEE", hash_generated_method = "A04D52F96CBD825C390926357CBB3767")
    
public void setStringConversionColumn(int stringConversionColumn) {
        mStringConversionColumn = stringConversionColumn;
    }

    /**
     * Returns the converter used to convert the filtering Cursor
     * into a String.
     *
     * @return null if the converter does not exist or an instance of
     *         {@link android.widget.SimpleCursorAdapter.CursorToStringConverter}
     *
     * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter)
     * @see #getStringConversionColumn()
     * @see #setStringConversionColumn(int)
     * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.913 -0500", hash_original_method = "80E6B5584C3F52CF90E7103CF53469C6", hash_generated_method = "2159E9B220EB00EFBBD6466CB188A47D")
    
public CursorToStringConverter getCursorToStringConverter() {
        return mCursorToStringConverter;
    }

    /**
     * Sets the converter  used to convert the filtering Cursor
     * into a String.
     *
     * @param cursorToStringConverter the Cursor to String converter, or
     *        null to remove the converter
     *
     * @see #setCursorToStringConverter(android.widget.SimpleCursorAdapter.CursorToStringConverter) 
     * @see #getStringConversionColumn()
     * @see #setStringConversionColumn(int)
     * @see android.widget.CursorAdapter#convertToString(android.database.Cursor)
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.915 -0500", hash_original_method = "5D90B32B884A493C1622C9D829A83B10", hash_generated_method = "DFE617ADD8B61894A6CE4B159A12E09D")
    
public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        mCursorToStringConverter = cursorToStringConverter;
    }

    /**
     * Returns a CharSequence representation of the specified Cursor as defined
     * by the current CursorToStringConverter. If no CursorToStringConverter
     * has been set, the String conversion column is used instead. If the
     * conversion column is -1, the returned String is empty if the cursor
     * is null or Cursor.toString().
     *
     * @param cursor the Cursor to convert to a CharSequence
     *
     * @return a non-null CharSequence representing the cursor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.918 -0500", hash_original_method = "600E1910E4ECD6C26E4D3B813A27ACFC", hash_generated_method = "92FBC115C9B18DFF04C67ACA9C6FAA42")
    
@Override
    public CharSequence convertToString(Cursor cursor) {
        if (mCursorToStringConverter != null) {
            return mCursorToStringConverter.convertToString(cursor);
        } else if (mStringConversionColumn > -1) {
            return cursor.getString(mStringConversionColumn);
        }

        return super.convertToString(cursor);
    }

    /**
     * Create a map from an array of strings to an array of column-id integers in mCursor.
     * If mCursor is null, the array will be discarded.
     * 
     * @param from the Strings naming the columns of interest
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.920 -0500", hash_original_method = "FB1AB395EA625B0EC9BE174CD444F84E", hash_generated_method = "F6BB161E6EF8993E01BF9BFC3DEBA729")
    
private void findColumns(String[] from) {
        if (mCursor != null) {
            int i;
            int count = from.length;
            if (mFrom == null || mFrom.length != count) {
                mFrom = new int[count];
            }
            for (i = 0; i < count; i++) {
                mFrom[i] = mCursor.getColumnIndexOrThrow(from[i]);
            }
        } else {
            mFrom = null;
        }
    }

    @DSComment("returned DB object")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.923 -0500", hash_original_method = "4582D229162590CE1749F675A6BA90D6", hash_generated_method = "DCAFF21CFF90CAE27D942A9EA9291B7A")
    
@Override
    public Cursor swapCursor(Cursor c) {
        // super.swapCursor() will notify observers before we have
        // a valid mapping, make sure we have a mapping before this
        // happens
        if (mFrom == null) {
            findColumns(mOriginalFrom);
        }
        Cursor res = super.swapCursor(c);
        // rescan columns in case cursor layout is different
        findColumns(mOriginalFrom);
        return res;
    }
    
    /**
     * Change the cursor and change the column-to-view mappings at the same time.
     *  
     * @param c The database cursor.  Can be null if the cursor is not available yet.
     * @param from A list of column names representing the data to bind to the UI.  Can be null 
     *            if the cursor is not available yet.
     * @param to The views that should display column in the "from" parameter.
     *            These should all be TextViews. The first N views in this list
     *            are given the values of the first N columns in the from
     *            parameter.  Can be null if the cursor is not available yet.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:16.925 -0500", hash_original_method = "6EF93FFBB8E610946B54D3F2EC498321", hash_generated_method = "EDD54B4A4DEF333250C82AA09EE72669")
    
public void changeCursorAndColumns(Cursor c, String[] from, int[] to) {
        mOriginalFrom = from;
        mTo = to;
        // super.changeCursor() will notify observers before we have
        // a valid mapping, make sure we have a mapping before this
        // happens
        if (mFrom == null) {
            findColumns(mOriginalFrom);
        }
        super.changeCursor(c);
        findColumns(mOriginalFrom);
    }
    
    public static interface ViewBinder {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean setViewValue(View view, Cursor cursor, int columnIndex);
    }
    
    public static interface CursorToStringConverter {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        CharSequence convertToString(Cursor cursor);
    }
    
}

