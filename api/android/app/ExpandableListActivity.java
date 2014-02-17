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

package android.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.database.Cursor;
import android.os.Bundle;
import java.util.List;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;

import java.util.Map;

/**
 * An activity that displays an expandable list of items by binding to a data
 * source implementing the ExpandableListAdapter, and exposes event handlers
 * when the user selects an item.
 * <p>
 * ExpandableListActivity hosts a
 * {@link android.widget.ExpandableListView ExpandableListView} object that can
 * be bound to different data sources that provide a two-levels of data (the
 * top-level is group, and below each group are children). Binding, screen
 * layout, and row layout are discussed in the following sections.
 * <p>
 * <strong>Screen Layout</strong>
 * </p>
 * <p>
 * ExpandableListActivity has a default layout that consists of a single,
 * full-screen, centered expandable list. However, if you desire, you can
 * customize the screen layout by setting your own view layout with
 * setContentView() in onCreate(). To do this, your own view MUST contain an
 * ExpandableListView object with the id "@android:id/list" (or
 * {@link android.R.id#list} if it's in code)
 * <p>
 * Optionally, your custom view can contain another view object of any type to
 * display when the list view is empty. This "empty list" notifier must have an
 * id "android:empty". Note that when an empty view is present, the expandable
 * list view will be hidden when there is no data to display.
 * <p>
 * The following code demonstrates an (ugly) custom screen layout. It has a list
 * with a green background, and an alternate red "no data" message.
 * </p>
 * 
 * <pre>
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
 * &lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *         android:orientation=&quot;vertical&quot;
 *         android:layout_width=&quot;match_parent&quot; 
 *         android:layout_height=&quot;match_parent&quot;
 *         android:paddingLeft=&quot;8dp&quot;
 *         android:paddingRight=&quot;8dp&quot;&gt;
 * 
 *     &lt;ExpandableListView android:id=&quot;@id/android:list&quot;
 *               android:layout_width=&quot;match_parent&quot; 
 *               android:layout_height=&quot;match_parent&quot;
 *               android:background=&quot;#00FF00&quot;
 *               android:layout_weight=&quot;1&quot;
 *               android:drawSelectorOnTop=&quot;false&quot;/&gt;
 * 
 *     &lt;TextView android:id=&quot;@id/android:empty&quot;
 *               android:layout_width=&quot;match_parent&quot; 
 *               android:layout_height=&quot;match_parent&quot;
 *               android:background=&quot;#FF0000&quot;
 *               android:text=&quot;No data&quot;/&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 * 
 * <p>
 * <strong>Row Layout</strong>
 * </p>
 * The {@link ExpandableListAdapter} set in the {@link ExpandableListActivity}
 * via {@link #setListAdapter(ExpandableListAdapter)} provides the {@link View}s
 * for each row. This adapter has separate methods for providing the group
 * {@link View}s and child {@link View}s. There are a couple provided
 * {@link ExpandableListAdapter}s that simplify use of adapters:
 * {@link SimpleCursorTreeAdapter} and {@link SimpleExpandableListAdapter}.
 * <p>
 * With these, you can specify the layout of individual rows for groups and
 * children in the list. These constructor takes a few parameters that specify
 * layout resources for groups and children. It also has additional parameters
 * that let you specify which data field to associate with which object in the
 * row layout resource. The {@link SimpleCursorTreeAdapter} fetches data from
 * {@link Cursor}s and the {@link SimpleExpandableListAdapter} fetches data
 * from {@link List}s of {@link Map}s.
 * </p>
 * <p>
 * Android provides some standard row layout resources. These are in the
 * {@link android.R.layout} class, and have names such as simple_list_item_1,
 * simple_list_item_2, and two_line_list_item. The following layout XML is the
 * source for the resource two_line_list_item, which displays two data
 * fields,one above the other, for each list row.
 * </p>
 * 
 * <pre>
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?&gt;
 * &lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:layout_width=&quot;match_parent&quot;
 *     android:layout_height=&quot;wrap_content&quot;
 *     android:orientation=&quot;vertical&quot;&gt;
 * 
 *     &lt;TextView android:id=&quot;@+id/text1&quot;
 *         android:textSize=&quot;16sp&quot;
 *         android:textStyle=&quot;bold&quot;
 *         android:layout_width=&quot;match_parent&quot;
 *         android:layout_height=&quot;wrap_content&quot;/&gt;
 * 
 *     &lt;TextView android:id=&quot;@+id/text2&quot;
 *         android:textSize=&quot;16sp&quot;
 *         android:layout_width=&quot;match_parent&quot;
 *         android:layout_height=&quot;wrap_content&quot;/&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 * 
 * <p>
 * You must identify the data bound to each TextView object in this layout. The
 * syntax for this is discussed in the next section.
 * </p>
 * <p>
 * <strong>Binding to Data</strong>
 * </p>
 * <p>
 * You bind the ExpandableListActivity's ExpandableListView object to data using
 * a class that implements the
 * {@link android.widget.ExpandableListAdapter ExpandableListAdapter} interface.
 * Android provides two standard list adapters:
 * {@link android.widget.SimpleExpandableListAdapter SimpleExpandableListAdapter}
 * for static data (Maps), and
 * {@link android.widget.SimpleCursorTreeAdapter SimpleCursorTreeAdapter} for
 * Cursor query results.
 * </p>
 * 
 * @see #setListAdapter
 * @see android.widget.ExpandableListView
 */
public class ExpandableListActivity extends Activity implements
        OnCreateContextMenuListener,
        ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener,
        ExpandableListView.OnGroupExpandListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.851 -0500", hash_original_field = "C8593FDE34702C978989DD9A527E81D9", hash_generated_field = "C8593FDE34702C978989DD9A527E81D9")
   
    ExpandableListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.862 -0500", hash_original_field = "94BF7FD28918CF535D64E578C0C1523E", hash_generated_field = "94BF7FD28918CF535D64E578C0C1523E")

    ExpandableListView mList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.870 -0500", hash_original_field = "5D1EC77CB5A18285CC99B754B6D1F724", hash_generated_field = "5D1EC77CB5A18285CC99B754B6D1F724")

    boolean mFinishedStart = false;

    /**
     * Override this to populate the context menu when an item is long pressed. menuInfo
     * will contain an {@link android.widget.ExpandableListView.ExpandableListContextMenuInfo}
     * whose packedPosition is a packed position
     * that should be used with {@link ExpandableListView#getPackedPositionType(long)} and
     * the other similar methods.
     * <p>
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.878 -0500", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "8B1794DAF87FDA917D4408027104C7CD")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    }

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    @Override
    public void droidsafeSubActivityCallbackHook() {
        super.droidsafeSubActivityCallbackHook();
        super.onContentChanged();
        onGroupExpand(DSUtils.FAKE_INT);
        onGroupCollapse(DSUtils.FAKE_INT);
        onChildClick(mList, new View(DSOnlyType.DONTCARE), DSUtils.FAKE_INT, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
    }
    /**
     * Override this for receiving callbacks when a child has been clicked.
     * <p>
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.887 -0500", hash_original_method = "148B1F725EE0240ACB0F014B88EF7B7D", hash_generated_method = "FD12905243E6B216908E3B8779F8F99C")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
            int childPosition, long id) {
        return false;
    }

    /**
     * Override this for receiving callbacks when a group has been collapsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.894 -0500", hash_original_method = "2841CE4526AD3DDF27C3902DF7F1E509", hash_generated_method = "A1285FF6338BB8E873453086A167A2B8")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void onGroupCollapse(int groupPosition) {
    }

    /**
     * Override this for receiving callbacks when a group has been expanded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.914 -0500", hash_original_method = "78995B15C7B4DD7E0C829C6483E342E9", hash_generated_method = "D3C295919527F31A8DB1FFF22A0DDCA9")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void onGroupExpand(int groupPosition) {
    }

    /**
     * Ensures the expandable list view has been created before Activity restores all
     * of the view states.
     * 
     *@see Activity#onRestoreInstanceState(Bundle)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.922 -0500", hash_original_method = "39D3E8C83EC5D9AA90999E3A2D1BCB07", hash_generated_method = "2DE8AD90C1A42DCA55687530BB5B9E78")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    protected void onRestoreInstanceState(Bundle state) {
        ensureList();
        super.onRestoreInstanceState(state);
    }

    /**
     * Updates the screen state (current list and other views) when the
     * content changes.
     * 
     * @see Activity#onContentChanged()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.939 -0500", hash_original_method = "DC93441AA7886210FB8B7D4BBF66C0C2", hash_generated_method = "EB3C4F6178448668E0C639C5053E90B8")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void onContentChanged() {
        super.onContentChanged();
        View emptyView = findViewById(com.android.internal.R.id.empty);
        mList = (ExpandableListView)findViewById(com.android.internal.R.id.list);
        if (mList == null) {
            throw new RuntimeException(
                    "Your content must have a ExpandableListView whose id attribute is " +
                    "'android.R.id.list'");
        }
        if (emptyView != null) {
            mList.setEmptyView(emptyView);
        }
        mList.setOnChildClickListener(this);
        mList.setOnGroupExpandListener(this);
        mList.setOnGroupCollapseListener(this);
        
        if (mFinishedStart) {
            setListAdapter(mAdapter);
        }
        mFinishedStart = true;
    }

    /**
     * Provide the adapter for the expandable list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.948 -0500", hash_original_method = "A29D9C463A320B0EEFF4CD23C93CB5C7", hash_generated_method = "A296C433D5BB6DF55480E1F386447EEF")
    
public void setListAdapter(ExpandableListAdapter adapter) {
        synchronized (this) {
            ensureList();
            mAdapter = adapter;
            mList.setAdapter(adapter);
        }
    }

    /**
     * Get the activity's expandable list view widget.  This can be used to get the selection,
     * set the selection, and many other useful functions.
     * 
     * @see ExpandableListView
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.955 -0500", hash_original_method = "2F22B94C75DB37CE8939976B81D6509B", hash_generated_method = "2FF0C5C65AF87D196DB891E1667E111F")
    
public ExpandableListView getExpandableListView() {
        ensureList();
        return mList;
    }
    
    /**
     * Get the ExpandableListAdapter associated with this activity's
     * ExpandableListView.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.962 -0500", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "72DC64E495E44B4040054743218614A1")
    
public ExpandableListAdapter getExpandableListAdapter() {
        return mAdapter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.971 -0500", hash_original_method = "747EB77893A53326BE6690546CE6B949", hash_generated_method = "BB61917A688B9F9EB38D1406C459DE4C")
    
private void ensureList() {
        if (mList != null) {
            return;
        }
        setContentView(com.android.internal.R.layout.expandable_list_content);
    }

    /**
     * Gets the ID of the currently selected group or child.
     * 
     * @return The ID of the currently selected group or child.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.978 -0500", hash_original_method = "D269A0D02850950126987DFFB8BC24BB", hash_generated_method = "67F8AACFA3C6FC308CBD1F08D99044AD")
    
public long getSelectedId() {
        return mList.getSelectedId();
    }

    /**
     * Gets the position (in packed position representation) of the currently
     * selected group or child. Use
     * {@link ExpandableListView#getPackedPositionType},
     * {@link ExpandableListView#getPackedPositionGroup}, and
     * {@link ExpandableListView#getPackedPositionChild} to unpack the returned
     * packed position.
     * 
     * @return A packed position representation containing the currently
     *         selected group or child's position and type.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.985 -0500", hash_original_method = "0A3ABCC5DF6D266750E60E7B93EFBFA9", hash_generated_method = "122F5B7E4CA9B6DEB70C6353D1DB1DFA")
    
public long getSelectedPosition() {
        return mList.getSelectedPosition();
    }

    /**
     * Sets the selection to the specified child. If the child is in a collapsed
     * group, the group will only be expanded and child subsequently selected if
     * shouldExpandGroup is set to true, otherwise the method will return false.
     * 
     * @param groupPosition The position of the group that contains the child.
     * @param childPosition The position of the child within the group.
     * @param shouldExpandGroup Whether the child's group should be expanded if
     *            it is collapsed.
     * @return Whether the selection was successfully set on the child.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:24.993 -0500", hash_original_method = "12D5BB1A8EA5B36CE9F4C13B45510FF0", hash_generated_method = "E6F3789439E16C2295FC08DAC8AB9B11")
    
public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        return mList.setSelectedChild(groupPosition, childPosition, shouldExpandGroup);
    }

    /**
     * Sets the selection to the specified group.
     * @param groupPosition The position of the group that should be selected.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-17 12:29:25.001 -0500", hash_original_method = "3A247D892E79B521DDD1AEE43FAB3391", hash_generated_method = "00A6538AC308DA804FCAF754F2317AFE")
    
public void setSelectedGroup(int groupPosition) {
        mList.setSelectedGroup(groupPosition);
    }

}

