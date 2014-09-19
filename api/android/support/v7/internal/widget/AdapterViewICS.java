package android.support.v7.internal.widget;

/*
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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * An AdapterView is a view whose children are determined by an {@link android.widget.Adapter}.
 *
 * <p>
 * See {@link ListView}, {@link android.widget.GridView}, {@link android.widget.Spinner} and
 *      {@link android.widget.Gallery} for commonly used subclasses of AdapterView.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using AdapterView, read the
 * <a href="{@docRoot}guide/topics/ui/binding.html">Binding to Data with AdapterView</a>
 * developer guide.</p></div>
 */
abstract class AdapterViewICS<T extends Adapter> extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.170 -0400", hash_original_field = "513745049371ED57634399D6D1B582C0", hash_generated_field = "C752618D807358452C4DCE234A930146")

    static final int ITEM_VIEW_TYPE_IGNORE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.172 -0400", hash_original_field = "C95668F49A14AD91587E2055DA5471BB", hash_generated_field = "24CA32D210B1098A9A28A100F34CD93E")

    static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.189 -0400", hash_original_field = "D8BFA7BDF76CBFB47AFBB09AEB28A329", hash_generated_field = "2ACDB95EC8FD03E59D37276160271BE6")

    static final int SYNC_SELECTED_POSITION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.191 -0400", hash_original_field = "42D05A504FC92381CCCFE88A1A575896", hash_generated_field = "067E495BB5F5DE55AD427633175B121C")

    static final int SYNC_FIRST_POSITION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.194 -0400", hash_original_field = "AF94CA461EFD2EFD9C98A7EA265CAD52", hash_generated_field = "E651483062BE384270CDB5009C3349DB")

    static final int SYNC_MAX_DURATION_MILLIS = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.220 -0400", hash_original_field = "08744EB4FDECE919536D545565C93AB6", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

    public static final int INVALID_POSITION = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.222 -0400", hash_original_field = "A918E385C9B25886EC8F756520BCE396", hash_generated_field = "716DCF1EC82526D22545C9F2FC7D9345")

    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.174 -0400", hash_original_field = "022C7F4AEEAF074317E59E54ED696E65", hash_generated_field = "4CE3CF821E7A7D08A592A5CA9EDE4305")

    @ViewDebug.ExportedProperty(category = "scrolling")
    int mFirstPosition = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.176 -0400", hash_original_field = "1356C3FA4037F030D6AAE99FCBE84372", hash_generated_field = "1356C3FA4037F030D6AAE99FCBE84372")

    int mSpecificTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.178 -0400", hash_original_field = "7CC7B89C1FD47B35803D575B68BC5B76", hash_generated_field = "7CC7B89C1FD47B35803D575B68BC5B76")

    int mSyncPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.180 -0400", hash_original_field = "4F8608A52A53AF9807409C41B4527AFB", hash_generated_field = "4F8608A52A53AF9807409C41B4527AFB")

    long mSyncRowId = INVALID_ROW_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.181 -0400", hash_original_field = "F7AF8C2BAFE5F1DFE6D7A4BF607BDBCD", hash_generated_field = "F7AF8C2BAFE5F1DFE6D7A4BF607BDBCD")

    long mSyncHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.183 -0400", hash_original_field = "36E09949FE1A68F854979C9033FBC538", hash_generated_field = "36E09949FE1A68F854979C9033FBC538")

    boolean mNeedSync = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.185 -0400", hash_original_field = "2B35CC092A6C6E8EEC9E34C6BB35EE65", hash_generated_field = "2B35CC092A6C6E8EEC9E34C6BB35EE65")

    int mSyncMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.187 -0400", hash_original_field = "01AD5D893D75034E69612BB96A370DD7", hash_generated_field = "2D1B3EFC128ADAB2A0F451FD22243A4A")

    private int mLayoutHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.196 -0400", hash_original_field = "A271CAA49C9300336DF6C9AF1632606C", hash_generated_field = "A271CAA49C9300336DF6C9AF1632606C")

    boolean mInLayout = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.198 -0400", hash_original_field = "8F5666816AF47A9E3F5850773164443C", hash_generated_field = "8F5666816AF47A9E3F5850773164443C")

    OnItemSelectedListener mOnItemSelectedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.199 -0400", hash_original_field = "08FFFEF948BF0E48E5DC5A108DD5C034", hash_generated_field = "08FFFEF948BF0E48E5DC5A108DD5C034")

    OnItemClickListener mOnItemClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.202 -0400", hash_original_field = "4BAB6029D01B2FF02C842E49999DC46D", hash_generated_field = "4BAB6029D01B2FF02C842E49999DC46D")

    OnItemLongClickListener mOnItemLongClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.203 -0400", hash_original_field = "83E549BBF91CC465CA61B08DEBC896EF", hash_generated_field = "83E549BBF91CC465CA61B08DEBC896EF")

    boolean mDataChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.205 -0400", hash_original_field = "610CFF6F038DFD13C3A144A791C1266B", hash_generated_field = "66B8EF13CF844CE1F3C5141C656F857A")

    @ViewDebug.ExportedProperty(category = "list")
    int mNextSelectedPosition = INVALID_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.207 -0400", hash_original_field = "906F39A3FAE64762B6F7A2D4072C0BAD", hash_generated_field = "906F39A3FAE64762B6F7A2D4072C0BAD")

    long mNextSelectedRowId = INVALID_ROW_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.210 -0400", hash_original_field = "015BEE2A20964210CED0581A4F45ADFF", hash_generated_field = "E706686D8FE4DBC37237587CD10C50B2")

    @ViewDebug.ExportedProperty(category = "list")
    int mSelectedPosition = INVALID_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.212 -0400", hash_original_field = "98FDE0E0DABA26150FB8FA9058D8AFC6", hash_generated_field = "98FDE0E0DABA26150FB8FA9058D8AFC6")

    long mSelectedRowId = INVALID_ROW_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.214 -0400", hash_original_field = "7791203818A2C8C23F9ABF8545C329FB", hash_generated_field = "23D73844C09FA19BF301A2A8334AD4E3")

    private View mEmptyView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.216 -0400", hash_original_field = "8883D5B70873EA360381DF330DA13CE1", hash_generated_field = "E38048D7118EEC0395C87E12259EFC13")

    @ViewDebug.ExportedProperty(category = "list")
    int mItemCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.218 -0400", hash_original_field = "11CEF45C71860367629AA01FA1F19186", hash_generated_field = "11CEF45C71860367629AA01FA1F19186")

    int mOldItemCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.224 -0400", hash_original_field = "45F58AF0B51928EE668B688AA98FB139", hash_generated_field = "45F58AF0B51928EE668B688AA98FB139")

    int mOldSelectedPosition = INVALID_POSITION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.226 -0400", hash_original_field = "CB32ED3EEEBFFF33346065AAF76C3C3F", hash_generated_field = "CB32ED3EEEBFFF33346065AAF76C3C3F")

    long mOldSelectedRowId = INVALID_ROW_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.228 -0400", hash_original_field = "96D2E25279F14BDA0EBAA1E47368E3C6", hash_generated_field = "0083FDFAC63D8D5618A73B94F2CA2AA1")

    private boolean mDesiredFocusableState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.230 -0400", hash_original_field = "0B09A668E7932D6F1682FDA0EA52E756", hash_generated_field = "131C0A29C612D5C490F82CC6B3FE313B")

    private boolean mDesiredFocusableInTouchModeState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.232 -0400", hash_original_field = "1A8DDBBE6E4DA967F5DEACBEFA2C0D29", hash_generated_field = "D942A048D23A80D010658FB1C8D03182")


    private SelectionNotifier mSelectionNotifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.234 -0400", hash_original_field = "9EF8ED98BBEB87000E69C25673FFDD81", hash_generated_field = "9EF8ED98BBEB87000E69C25673FFDD81")

    boolean mBlockLayoutRequests = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.236 -0400", hash_original_method = "2CB1DE40F5CA41003A3F76FE8AC74FFF", hash_generated_method = "2CB1DE40F5CA41003A3F76FE8AC74FFF")
    
AdapterViewICS(Context context) {
        super(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.238 -0400", hash_original_method = "1A275BFEC0228EFF0D3B556D7C9D0D55", hash_generated_method = "1A275BFEC0228EFF0D3B556D7C9D0D55")
    
AdapterViewICS(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.241 -0400", hash_original_method = "A064E8FB3A891DD2BF58411E387B85F1", hash_generated_method = "A064E8FB3A891DD2BF58411E387B85F1")
    
AdapterViewICS(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Interface definition for a callback to be invoked when an item in this
     * AdapterView has been clicked.
     */
    public interface OnItemClickListener {

        /**
         * Callback method to be invoked when an item in this AdapterView has
         * been clicked.
         * <p>
         * Implementers can call getItemAtPosition(position) if they need
         * to access the data associated with the selected item.
         *
         * @param parent The AdapterView where the click happened.
         * @param view The view within the AdapterView that was clicked (this
         *            will be a view provided by the adapter)
         * @param position The position of the view in the adapter.
         * @param id The row id of the item that was clicked.
         */
        void onItemClick(AdapterViewICS<?> parent, View view, int position, long id);
    }

    class OnItemClickListenerWrapper implements AdapterView.OnItemClickListener {

        private final OnItemClickListener mWrappedListener;

        public OnItemClickListenerWrapper(OnItemClickListener listener) {
            mWrappedListener = listener;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mWrappedListener.onItemClick(AdapterViewICS.this, view, position, id);
        }
    }

    /**
     * Register a callback to be invoked when an item in this AdapterView has
     * been clicked.
     *
     * @param listener The callback that will be invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.256 -0400", hash_original_method = "3AA164DD2030E1BF06F3CA1CD9427DA1", hash_generated_method = "55073E17A9ADE671366AA0FD0433A2EF")
        
public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    /**
     * @return The callback to be invoked with an item in this AdapterView has
     *         been clicked, or null id no callback has been set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.258 -0400", hash_original_method = "53FBB33228561FD1F46130BA576FD131", hash_generated_method = "3D9F6F39644A66B08EDDAAAEA44D28DD")
        
public final OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    /**
     * Call the OnItemClickListener, if it is defined.
     *
     * @param view The view within the AdapterView that was clicked.
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     * @return True if there was an assigned OnItemClickListener that was
     *         called, false otherwise is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.261 -0400", hash_original_method = "60B3F62567C83CF5181D16CCAFD621F4", hash_generated_method = "8AC53BB706E2BA988C71512AA9F19962")
        
public boolean performItemClick(View view, int position, long id) {
        if (mOnItemClickListener != null) {
            playSoundEffect(SoundEffectConstants.CLICK);
            if (view != null) {
                view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
            }
            mOnItemClickListener.onItemClick(this, view, position, id);
            return true;
        }

        return false;
    }

    /**
     * Interface definition for a callback to be invoked when an item in this
     * view has been clicked and held.
     */
    public interface OnItemLongClickListener {
        /**
         * Callback method to be invoked when an item in this view has been
         * clicked and held.
         *
         * Implementers can call getItemAtPosition(position) if they need to access
         * the data associated with the selected item.
         *
         * @param parent The AbsListView where the click happened
         * @param view The view within the AbsListView that was clicked
         * @param position The position of the view in the list
         * @param id The row id of the item that was clicked
         *
         * @return true if the callback consumed the long click, false otherwise
         */
        boolean onItemLongClick(AdapterViewICS<?> parent, View view, int position, long id);
    }


    /**
     * Register a callback to be invoked when an item in this AdapterView has
     * been clicked and held
     *
     * @param listener The callback that will run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.266 -0400", hash_original_method = "8890007B6750F9F3A0AF363421C33470", hash_generated_method = "61F9D91F91DF3E0733CD083126E71A92")
            
public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        mOnItemLongClickListener = listener;
    }

    /**
     * @return The callback to be invoked with an item in this AdapterView has
     *         been clicked and held, or null id no callback as been set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.268 -0400", hash_original_method = "450D7DEA9BB200CD772C171D001DF2F0", hash_generated_method = "1EC90C0D13D78B2B0F69C150EEEEB408")
            
public final OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    /**
     * Interface definition for a callback to be invoked when
     * an item in this view has been selected.
     */
    public interface OnItemSelectedListener {
        /**
         * <p>Callback method to be invoked when an item in this view has been
         * selected. This callback is invoked only when the newly selected
         * position is different from the previously selected position or if
         * there was no selected item.</p>
         *
         * Impelmenters can call getItemAtPosition(position) if they need to access the
         * data associated with the selected item.
         *
         * @param parent The AdapterView where the selection happened
         * @param view The view within the AdapterView that was clicked
         * @param position The position of the view in the adapter
         * @param id The row id of the item that is selected
         */
        void onItemSelected(AdapterViewICS<?> parent, View view, int position, long id);

        /**
         * Callback method to be invoked when the selection disappears from this
         * view. The selection can disappear for instance when touch is activated
         * or when the adapter becomes empty.
         *
         * @param parent The AdapterView that now contains no selected item.
         */
        void onNothingSelected(AdapterViewICS<?> parent);
    }


    /**
     * Register a callback to be invoked when an item in this AdapterView has
     * been selected.
     *
     * @param listener The callback that will run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.273 -0400", hash_original_method = "9092AD2A5F83CE601E3913D803C386F2", hash_generated_method = "2D3BB4E9340D49E8E59E0B4D10064887")
                
public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        mOnItemSelectedListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.275 -0400", hash_original_method = "C1B2E8F5BC8E80BA634AE326A645C328", hash_generated_method = "10F0D77C2F0F6DF3EA3824C2C66600BA")
                
public final OnItemSelectedListener getOnItemSelectedListener() {
        return mOnItemSelectedListener;
    }

    /**
     * Extra menu information provided to the
     * {@link android.view.View.OnCreateContextMenuListener#onCreateContextMenu(ContextMenu, View, ContextMenuInfo) }
     * callback when a context menu is brought up for this AdapterView.
     *
     */
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {

        public AdapterContextMenuInfo(View targetView, int position, long id) {
            this.targetView = targetView;
            this.position = position;
            this.id = id;
        }

        /**
         * The child view for which the context menu is being displayed. This
         * will be one of the children of this AdapterView.
         */
        public View targetView;

        /**
         * The position in the adapter for which the context menu is being
         * displayed.
         */
        public int position;

        /**
         * The row id of the item for which the context menu is being displayed.
         */
        public long id;
    }

    /**
     * Returns the adapter currently associated with this widget.
     *
     * @return The adapter used to provide this view's content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.289 -0400", hash_original_method = "A0D14CFDF948E28FE8D8741A033FF666", hash_generated_method = "6F799C158744ABEEA3E3237B64E67AE4")
                
public abstract T getAdapter();

    /**
     * Sets the adapter that provides the data and the views to represent the data
     * in this widget.
     *
     * @param adapter The adapter to use to create this view's content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.291 -0400", hash_original_method = "7B7D99DABD5D300B67690D303D431110", hash_generated_method = "C68C88EDB6431D5B47CAC9B60E2CF04B")
                
public abstract void setAdapter(T adapter);

    /**
     * This method is not supported and throws an UnsupportedOperationException when called.
     *
     * @param child Ignored.
     *
     * @throws UnsupportedOperationException Every time this method is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.294 -0400", hash_original_method = "F16CCCAA9B27A0794F506D96FD601909", hash_generated_method = "3D1FAD0B295761D9C71A2816BE4EB040")
                
@Override
    public void addView(View child) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    /**
     * This method is not supported and throws an UnsupportedOperationException when called.
     *
     * @param child Ignored.
     * @param index Ignored.
     *
     * @throws UnsupportedOperationException Every time this method is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.296 -0400", hash_original_method = "A0B74413A848464618EA89DE3FE41FDC", hash_generated_method = "57C457453C84B5086E72C23356148C52")
                
@Override
    public void addView(View child, int index) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    /**
     * This method is not supported and throws an UnsupportedOperationException when called.
     *
     * @param child Ignored.
     * @param params Ignored.
     *
     * @throws UnsupportedOperationException Every time this method is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.299 -0400", hash_original_method = "18B2907968F7312EE2BBDDA25EF143B2", hash_generated_method = "AA4E9BBF34D49C681131DBD1DB9C56BD")
                
@Override
    public void addView(View child, LayoutParams params) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) "
                + "is not supported in AdapterView");
    }

    /**
     * This method is not supported and throws an UnsupportedOperationException when called.
     *
     * @param child Ignored.
     * @param index Ignored.
     * @param params Ignored.
     *
     * @throws UnsupportedOperationException Every time this method is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.302 -0400", hash_original_method = "ECB319B81CB6A3F46E583210A29BAF16", hash_generated_method = "250809DAB3D7EE155F5C5E6E1A8EA10F")
                
@Override
    public void addView(View child, int index, LayoutParams params) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) "
                + "is not supported in AdapterView");
    }

    /**
     * This method is not supported and throws an UnsupportedOperationException when called.
     *
     * @param child Ignored.
     *
     * @throws UnsupportedOperationException Every time this method is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.305 -0400", hash_original_method = "886BA97B45AC28A61B534339E77983B5", hash_generated_method = "73656E482CBE0A6512F4E5D91729E477")
                
@Override
    public void removeView(View child) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    /**
     * This method is not supported and throws an UnsupportedOperationException when called.
     *
     * @param index Ignored.
     *
     * @throws UnsupportedOperationException Every time this method is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.307 -0400", hash_original_method = "EB15614617786EFEBA3A034D912AA71E", hash_generated_method = "F5ED2A291BF9C1A632D6A76E7C88CB61")
                
@Override
    public void removeViewAt(int index) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    /**
     * This method is not supported and throws an UnsupportedOperationException when called.
     *
     * @throws UnsupportedOperationException Every time this method is invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.310 -0400", hash_original_method = "F33294BE6C28FDF867EC6161A7E416F0", hash_generated_method = "8B82C4C9F1C6AE23A7015AD8F775937F")
                
@Override
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.313 -0400", hash_original_method = "5EA85597DECD951B7F4C51D999F17C5D", hash_generated_method = "C8F69E7E447B38FEF00C4F0425E9B931")
                
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mLayoutHeight = getHeight();
    }

    /**
     * Return the position of the currently selected item within the adapter's data set
     *
     * @return int Position (starting at 0), or {@link #INVALID_POSITION} if there is nothing selected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.315 -0400", hash_original_method = "40CA9E4E71293F3BC1D33E874AD305A1", hash_generated_method = "EC81B80CFE8ACA8738EA07C9D9C967BD")
                
@ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return mNextSelectedPosition;
    }

    /**
     * @return The id corresponding to the currently selected item, or {@link #INVALID_ROW_ID}
     * if nothing is selected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.317 -0400", hash_original_method = "52C80BDBAB2E8D6D945028E83F843260", hash_generated_method = "820C39987DD95F59D5D3BE333149B927")
                
@ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return mNextSelectedRowId;
    }

    /**
     * @return The view corresponding to the currently selected item, or null
     * if nothing is selected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.319 -0400", hash_original_method = "85052E8B82875B0400B20534D23148A4", hash_generated_method = "BDD96676A259437E2C7F81CBFCEBE8EA")
                
public abstract View getSelectedView();

    /**
     * @return The data corresponding to the currently selected item, or
     * null if there is nothing selected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.322 -0400", hash_original_method = "F45E40D646583F63F7A00B28C1D0B4AE", hash_generated_method = "D019C759994956F18259D1889D97E428")
                
public Object getSelectedItem() {
        T adapter = getAdapter();
        int selection = getSelectedItemPosition();
        if (adapter != null && adapter.getCount() > 0 && selection >= 0) {
            return adapter.getItem(selection);
        } else {
            return null;
        }
    }

    /**
     * @return The number of items owned by the Adapter associated with this
     *         AdapterView. (This is the number of data items, which may be
     *         larger than the number of visible views.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.324 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "97987607FBFB8B0BEEB59451C0C41C97")
                
@ViewDebug.CapturedViewProperty
    public int getCount() {
        return mItemCount;
    }

    /**
     * Get the position within the adapter's data set for the view, where view is a an adapter item
     * or a descendant of an adapter item.
     *
     * @param view an adapter item, or a descendant of an adapter item. This must be visible in this
     *        AdapterView at the time of the call.
     * @return the position within the adapter's data set of the view, or {@link #INVALID_POSITION}
     *         if the view does not correspond to a list item (or it is not currently visible).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.326 -0400", hash_original_method = "7F8A3609232C6E4C7447DF803294CB0C", hash_generated_method = "59055F050B01ED29E469F7608FF65FCC")
                
public int getPositionForView(View view) {
        View listItem = view;
        try {
            View v;
            while (!(v = (View) listItem.getParent()).equals(this)) {
                listItem = v;
            }
        } catch (ClassCastException e) {
            // We made it up to the window without find this list view
            return INVALID_POSITION;
        }

        // Search the children for the list item
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(listItem)) {
                return mFirstPosition + i;
            }
        }

        // Child not found!
        return INVALID_POSITION;
    }

    /**
     * Returns the position within the adapter's data set for the first item
     * displayed on screen.
     *
     * @return The position within the adapter's data set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.328 -0400", hash_original_method = "3F582E36FEB434C42F8F2A7A83CA506D", hash_generated_method = "4C661882740384910ED3AFB6B02BB431")
                
public int getFirstVisiblePosition() {
        return mFirstPosition;
    }

    /**
     * Returns the position within the adapter's data set for the last item
     * displayed on screen.
     *
     * @return The position within the adapter's data set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.331 -0400", hash_original_method = "E5B0A16A7A6C9870BA6F980F2DB39BC0", hash_generated_method = "7E8296BB544C7048CCEA7F5EF15E6D5A")
                
public int getLastVisiblePosition() {
        return mFirstPosition + getChildCount() - 1;
    }

    /**
     * Sets the currently selected item. To support accessibility subclasses that
     * override this method must invoke the overriden super method first.
     *
     * @param position Index (starting at 0) of the data item to be selected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.333 -0400", hash_original_method = "C52E7BA94981C9816D91FF9AA5FE127B", hash_generated_method = "15EA841E1ED836D0E82EF5123E10DA17")
                
public abstract void setSelection(int position);

    /**
     * Sets the view to show if the adapter is empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.335 -0400", hash_original_method = "0D2B56D1373B44CFA7E95FC0E87B79DB", hash_generated_method = "2A21475F22C518DB15E366DCBC37F31D")
                
public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;

        final T adapter = getAdapter();
        final boolean empty = ((adapter == null) || adapter.isEmpty());
        updateEmptyStatus(empty);
    }

    /**
     * When the current adapter is empty, the AdapterView can display a special view
     * call the empty view. The empty view is used to provide feedback to the user
     * that no data is available in this AdapterView.
     *
     * @return The view to show if the adapter is empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.337 -0400", hash_original_method = "1914B98508B1C21B71F42F5D07F0BF47", hash_generated_method = "BE7F29BDB6E79277FA84306F608F9634")
                
public View getEmptyView() {
        return mEmptyView;
    }

    /**
     * Indicates whether this view is in filter mode. Filter mode can for instance
     * be enabled by a user when typing on the keyboard.
     *
     * @return True if the view is in filter mode, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.339 -0400", hash_original_method = "FD285526E2677013E6DDAFB01C953F85", hash_generated_method = "FD285526E2677013E6DDAFB01C953F85")
                
boolean isInFilterMode() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.341 -0400", hash_original_method = "2405FD914E83FFA9F0D8BC78F36E017E", hash_generated_method = "490362F415B1C2C93A8801C8323B85A7")
                
@Override
    public void setFocusable(boolean focusable) {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;

        mDesiredFocusableState = focusable;
        if (!focusable) {
            mDesiredFocusableInTouchModeState = false;
        }

        super.setFocusable(focusable && (!empty || isInFilterMode()));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.344 -0400", hash_original_method = "510CB97D998AEB67CD24BEC214B467D4", hash_generated_method = "A4EDA43245915A38F48ADFB763FED2DC")
                
@Override
    public void setFocusableInTouchMode(boolean focusable) {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;

        mDesiredFocusableInTouchModeState = focusable;
        if (focusable) {
            mDesiredFocusableState = true;
        }

        super.setFocusableInTouchMode(focusable && (!empty || isInFilterMode()));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.346 -0400", hash_original_method = "247C1C860FE83D8C6969E8D7AD161A84", hash_generated_method = "7C038D34CD2E1914CE6CE0793E0CC63A")
                
void checkFocus() {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;
        final boolean focusable = !empty || isInFilterMode();
        // The order in which we set focusable in touch mode/focusable may matter
        // for the client, see View.setFocusableInTouchMode() comments for more
        // details
        super.setFocusableInTouchMode(focusable && mDesiredFocusableInTouchModeState);
        super.setFocusable(focusable && mDesiredFocusableState);
        if (mEmptyView != null) {
            updateEmptyStatus((adapter == null) || adapter.isEmpty());
        }
    }

    /**
     * Update the status of the list based on the empty parameter.  If empty is true and
     * we have an empty view, display it.  In all the other cases, make sure that the listview
     * is VISIBLE and that the empty view is GONE (if it's not null).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.349 -0400", hash_original_method = "621A0CC8ACC29C73BC5E156B3A1CCE3C", hash_generated_method = "D06E60EE0A7735F1C8BDCEFFA366F218")
                
private void updateEmptyStatus(boolean empty) {
        if (isInFilterMode()) {
            empty = false;
        }

        if (empty) {
            if (mEmptyView != null) {
                mEmptyView.setVisibility(View.VISIBLE);
                setVisibility(View.GONE);
            } else {
                // If the caller just removed our empty view, make sure the list view is visible
                setVisibility(View.VISIBLE);
            }

            // We are now GONE, so pending layouts will not be dispatched.
            // Force one here to make sure that the state of the list matches
            // the state of the adapter.
            if (mDataChanged) {
                this.onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            }
        } else {
            if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
            setVisibility(View.VISIBLE);
        }
    }

    /**
     * Gets the data associated with the specified position in the list.
     *
     * @param position Which data to get
     * @return The data associated with the specified position in the list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.352 -0400", hash_original_method = "D3C6D351E34AE1C5D83960F098A550AE", hash_generated_method = "0AFA26C7A541A584DF50322067FC59B2")
                
public Object getItemAtPosition(int position) {
        T adapter = getAdapter();
        return (adapter == null || position < 0) ? null : adapter.getItem(position);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.354 -0400", hash_original_method = "1B8B19ED8D728A74BB7DD4694FA31397", hash_generated_method = "A9E50CF165C723153601F5212FDC6C34")
                
public long getItemIdAtPosition(int position) {
        T adapter = getAdapter();
        return (adapter == null || position < 0) ? INVALID_ROW_ID : adapter.getItemId(position);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.357 -0400", hash_original_method = "1A557FA8FE05A519D86B900EB24DF4D7", hash_generated_method = "E814A4CAF870B2A3DB77B13C6B0B42E8")
                
@Override
    public void setOnClickListener(OnClickListener l) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                + "You probably want setOnItemClickListener instead");
    }

    /**
     * Override to prevent freezing of any views created by the adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.359 -0400", hash_original_method = "0F3E63187E008FDE1692E75AF7E8484F", hash_generated_method = "1BDE1F94F0E2664277F773022732A7F6")
                
@Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /**
     * Override to prevent thawing of any views created by the adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.361 -0400", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "C22EB0BEA05DE70A2CBD1DE4B70D044B")
                
@Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    class AdapterDataSetObserver extends DataSetObserver {

        private Parcelable mInstanceState = null;

        @Override
        public void onChanged() {
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = getAdapter().getCount();

            // Detect the case where a cursor that was previously invalidated has
            // been repopulated with new data.
            if (AdapterViewICS.this.getAdapter().hasStableIds() && mInstanceState != null
                    && mOldItemCount == 0 && mItemCount > 0) {
                AdapterViewICS.this.onRestoreInstanceState(mInstanceState);
                mInstanceState = null;
            } else {
                rememberSyncState();
            }
            checkFocus();
            requestLayout();
        }

        @Override
        public void onInvalidated() {
            mDataChanged = true;

            if (AdapterViewICS.this.getAdapter().hasStableIds()) {
                // Remember the current state for the case where our hosting activity is being
                // stopped and later restarted
                mInstanceState = AdapterViewICS.this.onSaveInstanceState();
            }

            // Data is invalid so we should reset our state
            mOldItemCount = mItemCount;
            mItemCount = 0;
            mSelectedPosition = INVALID_POSITION;
            mSelectedRowId = INVALID_ROW_ID;
            mNextSelectedPosition = INVALID_POSITION;
            mNextSelectedRowId = INVALID_ROW_ID;
            mNeedSync = false;

            checkFocus();
            requestLayout();
        }

        public void clearSavedState() {
            mInstanceState = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.375 -0400", hash_original_method = "8130EF0B42BA515F653DEDC83DE0BC01", hash_generated_method = "17D25D35340055C0BFBBE435ADE26095")
                
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mSelectionNotifier);
    }

    private class SelectionNotifier implements Runnable {
        public void run() {
            if (mDataChanged) {
                // Data has changed between when this SelectionNotifier
                // was posted and now. We need to wait until the AdapterView
                // has been synched to the new data.
                if (getAdapter() != null) {
                    post(this);
                }
            } else {
                fireOnSelected();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.382 -0400", hash_original_method = "BC6042705725732210E15D64CD41C7D9", hash_generated_method = "BEC930CC4FF34A76E63FC98A3BCF7D4D")
                
void selectionChanged() {
        if (mOnItemSelectedListener != null) {
            if (mInLayout || mBlockLayoutRequests) {
                // If we are in a layout traversal, defer notification
                // by posting. This ensures that the view tree is
                // in a consistent state and is able to accomodate
                // new layout or invalidate requests.
                if (mSelectionNotifier == null) {
                    mSelectionNotifier = new SelectionNotifier();
                }
                post(mSelectionNotifier);
            } else {
                fireOnSelected();
            }
        }

        // we fire selection events here not in View
        if (mSelectedPosition != ListView.INVALID_POSITION && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.384 -0400", hash_original_method = "02337B5D029912B3F89D3F5D70F11AFE", hash_generated_method = "E7C6C970F38B605CA994418F5D67F019")
                
private void fireOnSelected() {
        if (mOnItemSelectedListener == null)
            return;

        int selection = this.getSelectedItemPosition();
        if (selection >= 0) {
            View v = getSelectedView();
            mOnItemSelectedListener.onItemSelected(this, v, selection,
                    getAdapter().getItemId(selection));
        } else {
            mOnItemSelectedListener.onNothingSelected(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.386 -0400", hash_original_method = "2ECE900C628E5D932F56A2139561AD87", hash_generated_method = "A9280A59230C3D17314504BF4C302325")
                
@Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getVisibility() == VISIBLE
                && selectedView.dispatchPopulateAccessibilityEvent(event)) {
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.389 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "CC1AEAD8AD1B4127904290637F03EBAB")
                
@Override
    protected boolean canAnimate() {
        return super.canAnimate() && mItemCount > 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.392 -0400", hash_original_method = "E1C2247A84AC5366AD699C7DB3F92349", hash_generated_method = "1A0A39C25C9EB90D1D3C527FB7F6826A")
                
void handleDataChanged() {
        final int count = mItemCount;
        boolean found = false;

        if (count > 0) {

            int newPos;

            // Find the row we are supposed to sync to
            if (mNeedSync) {
                // Update this first, since setNextSelectedPositionInt inspects
                // it
                mNeedSync = false;

                // See if we can find a position in the new data with the same
                // id as the old selection
                newPos = findSyncPosition();
                if (newPos >= 0) {
                    // Verify that new selection is selectable
                    int selectablePos = lookForSelectablePosition(newPos, true);
                    if (selectablePos == newPos) {
                        // Same row id is selected
                        setNextSelectedPositionInt(newPos);
                        found = true;
                    }
                }
            }
            if (!found) {
                // Try to use the same position if we can't find matching data
                newPos = getSelectedItemPosition();

                // Pin position to the available range
                if (newPos >= count) {
                    newPos = count - 1;
                }
                if (newPos < 0) {
                    newPos = 0;
                }

                // Make sure we select something selectable -- first look down
                int selectablePos = lookForSelectablePosition(newPos, true);
                if (selectablePos < 0) {
                    // Looking down didn't work -- try looking up
                    selectablePos = lookForSelectablePosition(newPos, false);
                }
                if (selectablePos >= 0) {
                    setNextSelectedPositionInt(selectablePos);
                    checkSelectionChanged();
                    found = true;
                }
            }
        }
        if (!found) {
            // Nothing is selected
            mSelectedPosition = INVALID_POSITION;
            mSelectedRowId = INVALID_ROW_ID;
            mNextSelectedPosition = INVALID_POSITION;
            mNextSelectedRowId = INVALID_ROW_ID;
            mNeedSync = false;
            checkSelectionChanged();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.394 -0400", hash_original_method = "25705A5902194616A467B0383F1D3CBC", hash_generated_method = "25705A5902194616A467B0383F1D3CBC")
                
void checkSelectionChanged() {
        if ((mSelectedPosition != mOldSelectedPosition) || (mSelectedRowId != mOldSelectedRowId)) {
            selectionChanged();
            mOldSelectedPosition = mSelectedPosition;
            mOldSelectedRowId = mSelectedRowId;
        }
    }

    /**
     * Searches the adapter for a position matching mSyncRowId. The search starts at mSyncPosition
     * and then alternates between moving up and moving down until 1) we find the right position, or
     * 2) we run out of time, or 3) we have looked at every position
     *
     * @return Position of the row that matches mSyncRowId, or {@link #INVALID_POSITION} if it can't
     *         be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.397 -0400", hash_original_method = "40C5EABEA31AF953B54DF3485AA93D4F", hash_generated_method = "FBD6735F4FC1D38FFA80A976DCD06E28")
                
int findSyncPosition() {
        int count = mItemCount;

        if (count == 0) {
            return INVALID_POSITION;
        }

        long idToMatch = mSyncRowId;
        int seed = mSyncPosition;

        // If there isn't a selection don't hunt for it
        if (idToMatch == INVALID_ROW_ID) {
            return INVALID_POSITION;
        }

        // Pin seed to reasonable values
        seed = Math.max(0, seed);
        seed = Math.min(count - 1, seed);

        long endTime = SystemClock.uptimeMillis() + SYNC_MAX_DURATION_MILLIS;

        long rowId;

        // first position scanned so far
        int first = seed;

        // last position scanned so far
        int last = seed;

        // True if we should move down on the next iteration
        boolean next = false;

        // True when we have looked at the first item in the data
        boolean hitFirst;

        // True when we have looked at the last item in the data
        boolean hitLast;

        // Get the item ID locally (instead of getItemIdAtPosition), so
        // we need the adapter
        T adapter = getAdapter();
        if (adapter == null) {
            return INVALID_POSITION;
        }

        while (SystemClock.uptimeMillis() <= endTime) {
            rowId = adapter.getItemId(seed);
            if (rowId == idToMatch) {
                // Found it!
                return seed;
            }

            hitLast = last == count - 1;
            hitFirst = first == 0;

            if (hitLast && hitFirst) {
                // Looked at everything
                break;
            }

            if (hitFirst || (next && !hitLast)) {
                // Either we hit the top, or we are trying to move down
                last++;
                seed = last;
                // Try going up next time
                next = false;
            } else if (hitLast || (!next && !hitFirst)) {
                // Either we hit the bottom, or we are trying to move up
                first--;
                seed = first;
                // Try going down next time
                next = true;
            }

        }

        return INVALID_POSITION;
    }

    /**
     * Find a position that can be selected (i.e., is not a separator).
     *
     * @param position The starting position to look at.
     * @param lookDown Whether to look down for other positions.
     * @return The next selectable position starting at position and then searching either up or
     *         down. Returns {@link #INVALID_POSITION} if nothing can be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.399 -0400", hash_original_method = "63DA3BDCCF3458E05F2C2D5853C22A6D", hash_generated_method = "63DA3BDCCF3458E05F2C2D5853C22A6D")
                
int lookForSelectablePosition(int position, boolean lookDown) {
        return position;
    }

    /**
     * Utility to keep mSelectedPosition and mSelectedRowId in sync
     * @param position Our current position
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.401 -0400", hash_original_method = "DDA5E37B089AD4C213077E832500B341", hash_generated_method = "DDA5E37B089AD4C213077E832500B341")
                
void setSelectedPositionInt(int position) {
        mSelectedPosition = position;
        mSelectedRowId = getItemIdAtPosition(position);
    }

    /**
     * Utility to keep mNextSelectedPosition and mNextSelectedRowId in sync
     * @param position Intended value for mSelectedPosition the next time we go
     * through layout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.403 -0400", hash_original_method = "8F63B2D5F340C4F249BDEC055C5E8E67", hash_generated_method = "503BF1A120DAA6329C552ADFE86EB02B")
                
void setNextSelectedPositionInt(int position) {
        mNextSelectedPosition = position;
        mNextSelectedRowId = getItemIdAtPosition(position);
        // If we are trying to sync to the selection, update that too
        if (mNeedSync && mSyncMode == SYNC_SELECTED_POSITION && position >= 0) {
            mSyncPosition = position;
            mSyncRowId = mNextSelectedRowId;
        }
    }

    /**
     * Remember enough information to restore the screen state when the data has
     * changed.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:47.406 -0400", hash_original_method = "1A0C0740A6F6610404D57CE1BAD32EA0", hash_generated_method = "50DC9847521FA546F01EF679EC303C9D")
                
void rememberSyncState() {
        if (getChildCount() > 0) {
            mNeedSync = true;
            mSyncHeight = mLayoutHeight;
            if (mSelectedPosition >= 0) {
                // Sync the selection state
                View v = getChildAt(mSelectedPosition - mFirstPosition);
                mSyncRowId = mNextSelectedRowId;
                mSyncPosition = mNextSelectedPosition;
                if (v != null) {
                    mSpecificTop = v.getTop();
                }
                mSyncMode = SYNC_SELECTED_POSITION;
            } else {
                // Sync the based on the offset of the first view
                View v = getChildAt(0);
                T adapter = getAdapter();
                if (mFirstPosition >= 0 && mFirstPosition < adapter.getCount()) {
                    mSyncRowId = adapter.getItemId(mFirstPosition);
                } else {
                    mSyncRowId = NO_ID;
                }
                mSyncPosition = mFirstPosition;
                if (v != null) {
                    mSpecificTop = v.getTop();
                }
                mSyncMode = SYNC_FIRST_POSITION;
            }
        }
    }
}