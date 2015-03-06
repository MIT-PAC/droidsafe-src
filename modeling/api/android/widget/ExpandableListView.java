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
import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ExpandableListConnector.PositionMetadata;

import com.android.internal.R;

public class ExpandableListView extends ListView {
    
    /**
     * Gets the type of a packed position. See
     * {@link #getPackedPositionForChild(int, int)}.
     * 
     * @param packedPosition The packed position for which to return the type.
     * @return The type of the position contained within the packed position,
     *         either {@link #PACKED_POSITION_TYPE_CHILD}, {@link #PACKED_POSITION_TYPE_GROUP}, or
     *         {@link #PACKED_POSITION_TYPE_NULL}.
     */
    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.869 -0500", hash_original_method = "8F2A6759AB2DE8E848B42C8EAF8E7669", hash_generated_method = "F855F629A016C8C9CDB78C54E5F942B5")
    
public static int getPackedPositionType(long packedPosition) {
        if (packedPosition == PACKED_POSITION_VALUE_NULL) {
            return PACKED_POSITION_TYPE_NULL;
        }
        
        return (packedPosition & PACKED_POSITION_MASK_TYPE) == PACKED_POSITION_MASK_TYPE
                ? PACKED_POSITION_TYPE_CHILD
                : PACKED_POSITION_TYPE_GROUP;
    }

    /**
     * Gets the group position from a packed position. See
     * {@link #getPackedPositionForChild(int, int)}.
     * 
     * @param packedPosition The packed position from which the group position
     *            will be returned.
     * @return The group position portion of the packed position. If this does
     *         not contain a group, returns -1.
     */
    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.872 -0500", hash_original_method = "E7FEB201B74C7CCB951F4732DACD43EF", hash_generated_method = "82A6DAD2CD3647D08D4E3A69DAB541F7")
    
public static int getPackedPositionGroup(long packedPosition) {
        // Null
        if (packedPosition == PACKED_POSITION_VALUE_NULL) return -1;
        
        return (int) ((packedPosition & PACKED_POSITION_MASK_GROUP) >> PACKED_POSITION_SHIFT_GROUP);
    }

    /**
     * Gets the child position from a packed position that is of
     * {@link #PACKED_POSITION_TYPE_CHILD} type (use {@link #getPackedPositionType(long)}).
     * To get the group that this child belongs to, use
     * {@link #getPackedPositionGroup(long)}. See
     * {@link #getPackedPositionForChild(int, int)}.
     * 
     * @param packedPosition The packed position from which the child position
     *            will be returned.
     * @return The child position portion of the packed position. If this does
     *         not contain a child, returns -1.
     */
    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.874 -0500", hash_original_method = "A693593CBB4108EEE9837B598724899E", hash_generated_method = "4B7A2B748BF5F662054C05D7FCC5E082")
    
public static int getPackedPositionChild(long packedPosition) {
        // Null
        if (packedPosition == PACKED_POSITION_VALUE_NULL) return -1;
        
        // Group since a group type clears this bit
        if ((packedPosition & PACKED_POSITION_MASK_TYPE) != PACKED_POSITION_MASK_TYPE) return -1;

        return (int) (packedPosition & PACKED_POSITION_MASK_CHILD);
    }

    /**
     * Returns the packed position representation of a child's position.
     * <p>
     * In general, a packed position should be used in
     * situations where the position given to/returned from an
     * {@link ExpandableListAdapter} or {@link ExpandableListView} method can
     * either be a child or group. The two positions are packed into a single
     * long which can be unpacked using
     * {@link #getPackedPositionChild(long)},
     * {@link #getPackedPositionGroup(long)}, and
     * {@link #getPackedPositionType(long)}.
     * 
     * @param groupPosition The child's parent group's position.
     * @param childPosition The child position within the group.
     * @return The packed position representation of the child (and parent group).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.876 -0500", hash_original_method = "5B4CC69588F0ACA613873ADA235651BB", hash_generated_method = "38B1A9B54F6D94D6249EFBCEA3BFBEAE")
    
public static long getPackedPositionForChild(int groupPosition, int childPosition) {
        return (((long)PACKED_POSITION_TYPE_CHILD) << PACKED_POSITION_SHIFT_TYPE)
                | ((((long)groupPosition) & PACKED_POSITION_INT_MASK_GROUP)
                        << PACKED_POSITION_SHIFT_GROUP)
                | (childPosition & PACKED_POSITION_INT_MASK_CHILD);  
    }

    /**
     * Returns the packed position representation of a group's position. See
     * {@link #getPackedPositionForChild(int, int)}.
     * 
     * @param groupPosition The child's parent group's position.
     * @return The packed position representation of the group.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.879 -0500", hash_original_method = "27360F23AD3CB4DC8767FCC2C52E81C8", hash_generated_method = "5C2F47FE0AEEA9081AF102D91E7B3CEF")
    
public static long getPackedPositionForGroup(int groupPosition) {
        // No need to OR a type in because PACKED_POSITION_GROUP == 0
        return ((((long)groupPosition) & PACKED_POSITION_INT_MASK_GROUP)
                        << PACKED_POSITION_SHIFT_GROUP); 
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.712 -0500", hash_original_field = "222FEE0F5FB2511CBD93FB0D4BC8B8EC", hash_generated_field = "274C21CE7A488F023B0625CA14D88100")

    public static final int PACKED_POSITION_TYPE_GROUP = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.715 -0500", hash_original_field = "BEF1CE64762F7DAEE4F52AAC542025A6", hash_generated_field = "4E8C2D4B8B85562458F6C9D66E9E5F03")

    public static final int PACKED_POSITION_TYPE_CHILD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.717 -0500", hash_original_field = "98ED1DE5C10B5F0E382B63A45B1986E3", hash_generated_field = "9D25CF38FF287DAEF83DC57742BD5076")

    public static final int PACKED_POSITION_TYPE_NULL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.719 -0500", hash_original_field = "DD9032EACF06659E7F3DFC246C220B90", hash_generated_field = "0F2426D399D5691403E0EDA0F36FC6D0")

    public static final long PACKED_POSITION_VALUE_NULL = 0x00000000FFFFFFFFL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.721 -0500", hash_original_field = "FFE5D13C0FFCFEBDE197475FF7E50A9E", hash_generated_field = "E0FE034FEC282B7F93FFDE72DD2D3219")

    private static final long PACKED_POSITION_MASK_CHILD = 0x00000000FFFFFFFFL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.723 -0500", hash_original_field = "E955AE1ECEEE161D3522D56D84DB5CF5", hash_generated_field = "59A0E712737FBD265DD87ACDCF16737F")

    private static final long PACKED_POSITION_MASK_GROUP = 0x7FFFFFFF00000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.726 -0500", hash_original_field = "2D27DEDC6DA62D96B4353BCD03E737F8", hash_generated_field = "D79EFEF9C5FBC1BE7E88BE0E06E0FE4F")

    private static final long PACKED_POSITION_MASK_TYPE  = 0x8000000000000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.729 -0500", hash_original_field = "B3940E22E4E7C1A12A9AC50C63D011A2", hash_generated_field = "146C19D5B48298B5D734EB44D6768C65")

    private static final long PACKED_POSITION_SHIFT_GROUP = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.731 -0500", hash_original_field = "484CB4EEF52DD63D5C39ABC66F8AA718", hash_generated_field = "14EAC7043F6ABDA410932DEEB6AE5C03")

    private static final long PACKED_POSITION_SHIFT_TYPE  = 63;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.733 -0500", hash_original_field = "69434C966F85330971E44D650152D2FC", hash_generated_field = "4D6BC17B5B26166659D5AAD4B1990380")

    private static final long PACKED_POSITION_INT_MASK_CHILD = 0xFFFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.736 -0500", hash_original_field = "8662241389CCB7024465BE569D79C950", hash_generated_field = "79D45339991F29158AC8A1EBA08E588B")

    private static final long PACKED_POSITION_INT_MASK_GROUP = 0x7FFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.751 -0500", hash_original_field = "C66F1CAA4C1DB5E5CA4AC6F142202B11", hash_generated_field = "93B5880BE1196224A189BBB86B50C2C6")

    public static final int CHILD_INDICATOR_INHERIT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.758 -0500", hash_original_field = "04CE81C4B23C98A24231852CC8F6705F", hash_generated_field = "75129B8EA8BF65CAF94DB4FCF5C9C901")

    private static final int[] EMPTY_STATE_SET = {};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.760 -0500", hash_original_field = "F6ECCEB8DB39C8BA76FA90C068771211", hash_generated_field = "04B3A62702CD159E93BDFF5FC821FAC4")

    private static final int[] GROUP_EXPANDED_STATE_SET =
            {R.attr.state_expanded};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.762 -0500", hash_original_field = "17B6F1F2D92E83400CAA50D0434AE1B7", hash_generated_field = "CC56A355FBA84512C5E8B1AC68745D92")

    private static final int[] GROUP_EMPTY_STATE_SET =
            {R.attr.state_empty};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.764 -0500", hash_original_field = "3137CA53CE7862CF0826EBF37F252515", hash_generated_field = "F510BC18DB870FE705F7C0AC3E6EFD03")

    private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET =
            {R.attr.state_expanded, R.attr.state_empty};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.767 -0500", hash_original_field = "743C36535A12F061E2CA45E0BF1A1EDD", hash_generated_field = "DEC7C09E71358ECCB46FDCCCC112DAED")

    private static final int[][] GROUP_STATE_SETS = {
         EMPTY_STATE_SET, // 00
         GROUP_EXPANDED_STATE_SET, // 01
         GROUP_EMPTY_STATE_SET, // 10
         GROUP_EXPANDED_EMPTY_STATE_SET // 11
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.769 -0500", hash_original_field = "78964372CA3CB46EDA1FA3E3FAC6435F", hash_generated_field = "02D8778C96FFA9BD5271481EC4FB608F")

    private static final int[] CHILD_LAST_STATE_SET =
            {R.attr.state_last};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.738 -0500", hash_original_field = "2AAF564940E353F21B622EF10ACFE4D7", hash_generated_field = "FE34358DF167C9E1E63AC77E2A37F15F")

    private ExpandableListConnector mConnector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.740 -0500", hash_original_field = "C8593FDE34702C978989DD9A527E81D9", hash_generated_field = "50CBA9C919B713B047967190E3A8BC96")
 
    private ExpandableListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.742 -0500", hash_original_field = "C0072F26B55E1B66003A98141E04A059", hash_generated_field = "434428F0996A50D31944C2878AAD16A1")

    private int mIndicatorLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.744 -0500", hash_original_field = "C160175C5C47B748E75F1D9B0B8C9E66", hash_generated_field = "BB8094FC75AC0BA3C9B8F4CF1268604E")

    private int mIndicatorRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.747 -0500", hash_original_field = "2F0295CCD156E7BCFB40BE49E67B3B7E", hash_generated_field = "0DA79C52D420D6028700BB7C8910FEFD")

    private int mChildIndicatorLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.749 -0500", hash_original_field = "6C41F8641062E9D712C7655C3C9A610C", hash_generated_field = "1C9E41A7B8CB0E401BC23B70CC97D1BF")

    private int mChildIndicatorRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.753 -0500", hash_original_field = "FD94302FE46868084AFFF910E9B18FFB", hash_generated_field = "B1733A25DCAA61D2D46C3759966CDFC8")

    private Drawable mGroupIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.756 -0500", hash_original_field = "D111A126B5763AB4D860F3E776432505", hash_generated_field = "7B54373951293DFF2C9D6CDE6C045E25")

    private Drawable mChildIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.772 -0500", hash_original_field = "88F7A69AE824F82DECF0B77A77EEDB86", hash_generated_field = "AA0C5E1AC01E1496ECE888E4E17EB749")

    private Drawable mChildDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.774 -0500", hash_original_field = "27D3E2B0FCA4F20BE8A1EB76BE0DBB8F", hash_generated_field = "75F1B505E97CBF26CFCC7667594E8799")

    private final Rect mIndicatorRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.829 -0500", hash_original_field = "770C7B491B95A84C136547BA916527FC", hash_generated_field = "4AE25EFC7015417499591D568114EEE0")
    
    private OnGroupCollapseListener mOnGroupCollapseListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.835 -0500", hash_original_field = "DEFBF96B4E7468CF5AF58FABB202B9C4", hash_generated_field = "10562726C639BB35125692F5C4D1ABBF")
    
    private OnGroupExpandListener mOnGroupExpandListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.842 -0500", hash_original_field = "ED5403BDB0DECBAEDA94079739CEA4F0", hash_generated_field = "90010A4046DD0FEDC5C052D5BA45FC4D")
    
    private OnGroupClickListener mOnGroupClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.849 -0500", hash_original_field = "DC113D4DA592BA2BD7ABFB118E1FBC46", hash_generated_field = "A18EFBC744D484264D8A553D85190EB1")
    
    private OnChildClickListener mOnChildClickListener;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.776 -0500", hash_original_method = "883D95D0AB13C2DE7BE0B98484A4295B", hash_generated_method = "BA07C12D521DFBE960446C3AF40E68D9")
    
public ExpandableListView(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.779 -0500", hash_original_method = "4019A5446CFBA13B5DEBC7A85D6066EA", hash_generated_method = "5DA27CE48A126D4DD46C60E83CE3DDD2")
    
public ExpandableListView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.expandableListViewStyle);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.782 -0500", hash_original_method = "9ABBDB13FF145C988C5879C289ADA198", hash_generated_method = "26B658E4AF12632E54E92C248963A216")
    
public ExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a =
            context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.ExpandableListView, defStyle,
                    0);

        mGroupIndicator = a
                .getDrawable(com.android.internal.R.styleable.ExpandableListView_groupIndicator);
        mChildIndicator = a
                .getDrawable(com.android.internal.R.styleable.ExpandableListView_childIndicator);
        mIndicatorLeft = a
                .getDimensionPixelSize(com.android.internal.R.styleable.ExpandableListView_indicatorLeft, 0);
        mIndicatorRight = a
                .getDimensionPixelSize(com.android.internal.R.styleable.ExpandableListView_indicatorRight, 0);
        if (mIndicatorRight == 0 && mGroupIndicator != null) {
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        }
        mChildIndicatorLeft = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ExpandableListView_childIndicatorLeft, CHILD_INDICATOR_INHERIT);
        mChildIndicatorRight = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ExpandableListView_childIndicatorRight, CHILD_INDICATOR_INHERIT);
        mChildDivider = a.getDrawable(com.android.internal.R.styleable.ExpandableListView_childDivider);
        
        a.recycle();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.786 -0500", hash_original_method = "7A23721B5E073FBA7FD49FF2A748467D", hash_generated_method = "2184CC6A6CF032182D4C188E0AA9342E")
    
@Override
    protected void dispatchDraw(Canvas canvas) {
        // Draw children, etc.
        super.dispatchDraw(canvas);

        // If we have any indicators to draw, we do it here
        if ((mChildIndicator == null) && (mGroupIndicator == null)) {
            return;
        }

        int saveCount = 0;
        final boolean clipToPadding = (mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        if (clipToPadding) {
            saveCount = canvas.save();
            final int scrollX = mScrollX;
            final int scrollY = mScrollY;
            canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                    scrollX + mRight - mLeft - mPaddingRight,
                    scrollY + mBottom - mTop - mPaddingBottom);
        }

        final int headerViewsCount = getHeaderViewsCount();
        
        final int lastChildFlPos = mItemCount - getFooterViewsCount() - headerViewsCount - 1;

        final int myB = mBottom;
        
        PositionMetadata pos;
        View item;
        Drawable indicator; 
        int t, b;
        
        // Start at a value that is neither child nor group
        int lastItemType = ~(ExpandableListPosition.CHILD | ExpandableListPosition.GROUP);

        final Rect indicatorRect = mIndicatorRect;

        // The "child" mentioned in the following two lines is this
        // View's child, not referring to an expandable list's
        // notion of a child (as opposed to a group)
        final int childCount = getChildCount(); 
        for (int i = 0, childFlPos = mFirstPosition - headerViewsCount; i < childCount;
             i++, childFlPos++) {

            if (childFlPos < 0) {
                // This child is header
                continue;
            } else if (childFlPos > lastChildFlPos) {
                // This child is footer, so are all subsequent children
                break;
            }
            
            item = getChildAt(i);
            t = item.getTop();
            b = item.getBottom();
            
            // This item isn't on the screen
            if ((b < 0) || (t > myB)) continue;

            // Get more expandable list-related info for this item
            pos = mConnector.getUnflattenedPos(childFlPos);

            // If this item type and the previous item type are different, then we need to change
            // the left & right bounds
            
/*            if (pos.position.type != lastItemType) {
                
                if (pos.position.type == ExpandableListPosition.CHILD) {
                    indicatorRect.left = (mChildIndicatorLeft == CHILD_INDICATOR_INHERIT) ?
                            mIndicatorLeft : mChildIndicatorLeft;
                    indicatorRect.right = (mChildIndicatorRight == CHILD_INDICATOR_INHERIT) ?
                            mIndicatorRight : mChildIndicatorRight;
                } else {
                    indicatorRect.left = mIndicatorLeft;
                    indicatorRect.right = mIndicatorRight;
                }
                
                indicatorRect.left += mPaddingLeft;
                indicatorRect.right += mPaddingLeft;

                lastItemType = pos.position.type; 
            }
*/
            
            indicatorRect.addTaint(getTaintInt() + pos.position.type);
            lastItemType = pos.position.type;
            
         if (indicatorRect.left != indicatorRect.right) {
                // Use item's full height + the divider height
              /*
                if (mStackFromBottom) {
                    // See ListView#dispatchDraw
                    indicatorRect.top = t;// - mDividerHeight;
                    indicatorRect.bottom = b;
                } else {
                    indicatorRect.top = t;
                    indicatorRect.bottom = b;// + mDividerHeight;
                }
                */
                
                indicatorRect.addTaint(t + b);
                indicatorRect.addTaint(mStackFromBottom);
                
                // Get the indicator (with its state set to the item's state)
                indicator = getIndicator(pos);
                if (indicator != null) {
                    // Draw the indicator
                    indicator.setBounds(indicatorRect);
                    indicator.draw(canvas);
                }
            }

            pos.recycle();
        }

        if (clipToPadding) {
            canvas.restoreToCount(saveCount);
        }
    }

    /**
     * Gets the indicator for the item at the given position. If the indicator
     * is stateful, the state will be given to the indicator.
     * 
     * @param pos The flat list position of the item whose indicator
     *            should be returned.
     * @return The indicator in the proper state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.789 -0500", hash_original_method = "D5F058A591B90F6E54D4D617313791EB", hash_generated_method = "4BE8CCD69C1ECF6DDD177DF74D1C3FF9")
    
private Drawable getIndicator(PositionMetadata pos) {
        Drawable indicator;
        
        if (pos.position.type == ExpandableListPosition.GROUP) {
            indicator = mGroupIndicator;
            
            if (indicator != null && indicator.isStateful()) {
                // Empty check based on availability of data.  If the groupMetadata isn't null,
                // we do a check on it. Otherwise, the group is collapsed so we consider it
                // empty for performance reasons.
                boolean isEmpty = (pos.groupMetadata == null) ||
                        (pos.groupMetadata.lastChildFlPos == pos.groupMetadata.flPos);
                
                final int stateSetIndex =
                    (pos.isExpanded() ? 1 : 0) | // Expanded?
                    (isEmpty ? 2 : 0); // Empty?
                indicator.setState(GROUP_STATE_SETS[stateSetIndex]);
            }
        } else {
            indicator = mChildIndicator;
            
            if (indicator != null && indicator.isStateful()) {
                // No need for a state sets array for the child since it only has two states
                final int stateSet[] = pos.position.flatListPos == pos.groupMetadata.lastChildFlPos
                        ? CHILD_LAST_STATE_SET
                        : EMPTY_STATE_SET;
                indicator.setState(stateSet);
            }
        }
        
        return indicator;
    }
    
    /**
     * Sets the drawable that will be drawn adjacent to every child in the list. This will
     * be drawn using the same height as the normal divider ({@link #setDivider(Drawable)}) or
     * if it does not have an intrinsic height, the height set by {@link #setDividerHeight(int)}.
     * 
     * @param childDivider The drawable to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.791 -0500", hash_original_method = "4C83D9B2FEDBCDF12BA1F2A0723CD37C", hash_generated_method = "A11391F76183AB3202B4A1A4311FA8B8")
    
public void setChildDivider(Drawable childDivider) {
        mChildDivider = childDivider;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.793 -0500", hash_original_method = "1C2A86D3B4CD7E5098111C8F9235F268", hash_generated_method = "9AA28320A27C85C8E0AD998F4E8B47B8")
    
@Override
    void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        int flatListPosition = childIndex + mFirstPosition;
        
        // Only proceed as possible child if the divider isn't above all items (if it is above
        // all items, then the item below it has to be a group)
        if (flatListPosition >= 0) {
            final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
            PositionMetadata pos = mConnector.getUnflattenedPos(adjustedPosition);
            // If this item is a child, or it is a non-empty group that is expanded
            if ((pos.position.type == ExpandableListPosition.CHILD) || (pos.isExpanded() &&
                    pos.groupMetadata.lastChildFlPos != pos.groupMetadata.flPos)) {
                // These are the cases where we draw the child divider
                final Drawable divider = mChildDivider;
                divider.setBounds(bounds);
                divider.draw(canvas);
                pos.recycle();
                return;
            }
            pos.recycle();
        }
        
        // Otherwise draw the default divider
        super.drawDivider(canvas, bounds, flatListPosition);
    }

    /**
     * This overloaded method should not be used, instead use
     * {@link #setAdapter(ExpandableListAdapter)}.
     * <p>
     * {@inheritDoc}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.796 -0500", hash_original_method = "A4E4696C244BB97A42B35DBC06E7550F", hash_generated_method = "8F357777D7FDD1DE58862E6356F4C563")
    
@Override
    public void setAdapter(ListAdapter adapter) {
        throw new RuntimeException(
                "For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of " +
                "setAdapter(ListAdapter)");
    }

    /**
     * This method should not be used, use {@link #getExpandableListAdapter()}.
     */
    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.798 -0500", hash_original_method = "1C0E40F01B81CC446BCB9E503587C60C", hash_generated_method = "AD4EED210FC927083466B4E53D9186CE")
    
@Override
    public ListAdapter getAdapter() {
        /*
         * The developer should never really call this method on an
         * ExpandableListView, so it would be nice to throw a RuntimeException,
         * but AdapterView calls this
         */
        return super.getAdapter();
    }

    /**
     * Register a callback to be invoked when an item has been clicked and the
     * caller prefers to receive a ListView-style position instead of a group
     * and/or child position. In most cases, the caller should use
     * {@link #setOnGroupClickListener} and/or {@link #setOnChildClickListener}.
     * <p />
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.801 -0500", hash_original_method = "B7F875362109C546409DA14CD03B0627", hash_generated_method = "838DA70518B00B72ED518316BB3B654D")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public void setOnItemClickListener(OnItemClickListener l) {
        super.setOnItemClickListener(l);
    }

    /**
     * Sets the adapter that provides data to this view.
     * @param adapter The adapter that provides data to this view.
     */
    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.803 -0500", hash_original_method = "86A402EAE8E162910BEF1CBB540CA500", hash_generated_method = "27BC0852675A405C13BDC2A25C5C6142")
    
public void setAdapter(ExpandableListAdapter adapter) {
        // Set member variable
        mAdapter = adapter;
        
        if (adapter != null) {
            // Create the connector
            mConnector = new ExpandableListConnector(adapter);
        } else {
            mConnector = null;
        }
        
        // Link the ListView (superclass) to the expandable list data through the connector
        super.setAdapter(mConnector);
    }
    
    /**
     * Gets the adapter that provides data to this view.
     * @return The adapter that provides data to this view.
     */
    @DSComment("CompoundButton, check modeling")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.805 -0500", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "72DC64E495E44B4040054743218614A1")
    
public ExpandableListAdapter getExpandableListAdapter() {
        return mAdapter;
    }
    
    /**
     * @param position An absolute (including header and footer) flat list position.
     * @return true if the position corresponds to a header or a footer item.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.808 -0500", hash_original_method = "A9D0233B5C169CC66750AD88D31A38E9", hash_generated_method = "74BD10D7D47D662C510C4167355EB8C4")
    
private boolean isHeaderOrFooterPosition(int position) {
        final int footerViewsStart = mItemCount - getFooterViewsCount();
        return (position < getHeaderViewsCount() || position >= footerViewsStart);
    }

    /**
     * Converts an absolute item flat position into a group/child flat position, shifting according
     * to the number of header items.
     * 
     * @param flatListPosition The absolute flat position
     * @return A group/child flat position as expected by the connector.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.810 -0500", hash_original_method = "8FB53CC37B504290AC6948A7A815A683", hash_generated_method = "EDCB78D6ED26D5A20E1CE956E7AAE40A")
    
private int getFlatPositionForConnector(int flatListPosition) {
        return flatListPosition - getHeaderViewsCount();
    }

    /**
     * Converts a group/child flat position into an absolute flat position, that takes into account
     * the possible headers.
     * 
     * @param flatListPosition The child/group flat position
     * @return An absolute flat position.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.812 -0500", hash_original_method = "D8821ADD18913687E76F2B3166416BE8", hash_generated_method = "C5CFCFBC89B7B708C6A4508EFD8C68DA")
    
private int getAbsoluteFlatPosition(int flatListPosition) {
        return flatListPosition + getHeaderViewsCount();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.814 -0500", hash_original_method = "351E469927E1B73D6D643A520D2ADA68", hash_generated_method = "9F24F27F7D56BF8727788EBA09E35592")
    
@Override
    public boolean performItemClick(View v, int position, long id) {
        // Ignore clicks in header/footers
        if (isHeaderOrFooterPosition(position)) {
            // Clicked on a header/footer, so ignore pass it on to super
            return super.performItemClick(v, position, id);
        }
        
        // Internally handle the item click
        final int adjustedPosition = getFlatPositionForConnector(position);
        return handleItemClick(v, adjustedPosition, id);
    }
    
    /**
     * This will either expand/collapse groups (if a group was clicked) or pass
     * on the click to the proper child (if a child was clicked)
     * 
     * @param position The flat list position. This has already been factored to
     *            remove the header/footer.
     * @param id The ListAdapter ID, not the group or child ID.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.818 -0500", hash_original_method = "6AFB7BBE8B57133AA9AA93690C5E22BA", hash_generated_method = "24BB97D6FAA0289BEF28A499FA0557B1")
    
boolean handleItemClick(View v, int position, long id) {
        final PositionMetadata posMetadata = mConnector.getUnflattenedPos(position);
        
        id = getChildOrGroupId(posMetadata.position);
        
        boolean returnValue;
        if (posMetadata.position.type == ExpandableListPosition.GROUP) {
            /* It's a group, so handle collapsing/expanding */

            /* It's a group click, so pass on event */
            if (mOnGroupClickListener != null) {
                if (mOnGroupClickListener.onGroupClick(this, v,
                        posMetadata.position.groupPos, id)) {
                    posMetadata.recycle();
                    return true;
                }
            }

            if (posMetadata.isExpanded()) {
                /* Collapse it */
                mConnector.collapseGroup(posMetadata);

                playSoundEffect(SoundEffectConstants.CLICK);

                if (mOnGroupCollapseListener != null) {
                    mOnGroupCollapseListener.onGroupCollapse(posMetadata.position.groupPos);
                }
            } else {
                /* Expand it */
                mConnector.expandGroup(posMetadata);

                playSoundEffect(SoundEffectConstants.CLICK);

                if (mOnGroupExpandListener != null) {
                    mOnGroupExpandListener.onGroupExpand(posMetadata.position.groupPos);
                }
                
                final int groupPos = posMetadata.position.groupPos;
                final int groupFlatPos = posMetadata.position.flatListPos;

                final int shiftedGroupPosition = groupFlatPos + getHeaderViewsCount(); 
                smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                        shiftedGroupPosition);
            }

            returnValue = true;
        } else {
            /* It's a child, so pass on event */
            if (mOnChildClickListener != null) {
                playSoundEffect(SoundEffectConstants.CLICK);
                return mOnChildClickListener.onChildClick(this, v, posMetadata.position.groupPos,
                        posMetadata.position.childPos, id);
            }

            returnValue = false;
        }

        posMetadata.recycle();

        return returnValue;
    }

    /**
     * Expand a group in the grouped list view
     *
     * @param groupPos the group to be expanded
     * @return True if the group was expanded, false otherwise (if the group
     *         was already expanded, this will return false)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.820 -0500", hash_original_method = "98581B0D5B3DDD77A367749C65B03049", hash_generated_method = "45B814FFC6D73C00A32A984838985D94")
    
public boolean expandGroup(int groupPos) {
       return expandGroup(groupPos, false);
    }

    /**
     * Expand a group in the grouped list view
     *
     * @param groupPos the group to be expanded
     * @param animate true if the expanding group should be animated in
     * @return True if the group was expanded, false otherwise (if the group
     *         was already expanded, this will return false)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.823 -0500", hash_original_method = "0C4613B5CED32082A0135BD7DC8647D8", hash_generated_method = "DED3BD1EFBA40AA89B93C80CAF024643")
    
public boolean expandGroup(int groupPos, boolean animate) {
        PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue = mConnector.expandGroup(pm);

        if (mOnGroupExpandListener != null) {
            mOnGroupExpandListener.onGroupExpand(groupPos);
        }

        if (animate) {
            final int groupFlatPos = pm.position.flatListPos;

            final int shiftedGroupPosition = groupFlatPos + getHeaderViewsCount();
            smoothScrollToPosition(shiftedGroupPosition + mAdapter.getChildrenCount(groupPos),
                    shiftedGroupPosition);
        }
        pm.recycle();

        return retValue;
    }
    
    /**
     * Collapse a group in the grouped list view
     * 
     * @param groupPos position of the group to collapse
     * @return True if the group was collapsed, false otherwise (if the group
     *         was already collapsed, this will return false)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.825 -0500", hash_original_method = "32E02BBD4C2448429B8A9BB97BA3197B", hash_generated_method = "FA91F14805BF29783111F44ACD78B457")
    
public boolean collapseGroup(int groupPos) {
        boolean retValue = mConnector.collapseGroup(groupPos);
        
        if (mOnGroupCollapseListener != null) {
            mOnGroupCollapseListener.onGroupCollapse(groupPos);
        }

        return retValue;
    }
    
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.831 -0500", hash_original_method = "A0CC4D2398D57CD6BE21425007A2E39D", hash_generated_method = "ED445B82E40B149D9AB5DB54B69DB345")
    
public void setOnGroupCollapseListener(
            OnGroupCollapseListener onGroupCollapseListener) {
        mOnGroupCollapseListener = onGroupCollapseListener;
    }
    
    public static class ExpandableListContextMenuInfo implements ContextMenu.ContextMenuInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.898 -0500", hash_original_field = "3BB1E86D410535A3C31772C2239AADE8", hash_generated_field = "7EF03B9C3ED3327C63848AE59101E3FF")

        public View targetView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.900 -0500", hash_original_field = "FADA9F4886CDEA4F7B98668AF2296491", hash_generated_field = "1098F2F73CC2A84B7C54D09679B48A6B")

        public long packedPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.902 -0500", hash_original_field = "FF4AD99D820B36F46F04892B42F122AA", hash_generated_field = "ED8148F95ABDB86AF6D25639B34D9053")

        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.896 -0500", hash_original_method = "ACA0779BC3809F87388EA7D4891DD0AD", hash_generated_method = "700C637F271A1B21D3AA48A221117E03")
        
public ExpandableListContextMenuInfo(View targetView, long packedPosition, long id) {
            this.targetView = targetView;
            this.packedPosition = packedPosition;
            this.id = id;
        }
        
    }
    
    static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.923 -0500", hash_original_field = "AD99978CDC5E698C2A4DD1DC3100EFC5", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.907 -0500", hash_original_field = "882BE828140B4D6DD36411E2A468D4C2", hash_generated_field = "882BE828140B4D6DD36411E2A468D4C2")

        ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList;
        
        /**
         * Constructor called from {@link ExpandableListView#onSaveInstanceState()}
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.909 -0500", hash_original_method = "9176098383EC9C7D58FDF70E89009D8B", hash_generated_method = "9176098383EC9C7D58FDF70E89009D8B")
        
SavedState(
                Parcelable superState,
                ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList) {
            super(superState);
            this.expandedGroupMetadataList = expandedGroupMetadataList;
        }

        /**
         * Constructor called from {@link #CREATOR}
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.912 -0500", hash_original_method = "D29B1E3F2DF62BC80E56BCC4A8E9B099", hash_generated_method = "3833DC44E1A060D2177644884B992C55")
        
private SavedState(Parcel in) {
            super(in);
            expandedGroupMetadataList = new ArrayList<ExpandableListConnector.GroupMetadata>();
            in.readList(expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.915 -0500", hash_original_method = "AB17BDA53DFB838896B21BA39777EED2", hash_generated_method = "9B67C97A4F3D4255F986F4E888AD0782")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeList(expandedGroupMetadataList);
        }
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }
    
    public interface OnGroupCollapseListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onGroupCollapse(int groupPosition);
    }
    
    public interface OnGroupExpandListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onGroupExpand(int groupPosition);
    }
    
    public interface OnGroupClickListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onGroupClick(ExpandableListView parent, View v, int groupPosition,
                long id);
    }
    
    public interface OnChildClickListener {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                int childPosition, long id);
    }
    
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.837 -0500", hash_original_method = "10BB1A471420C27FBFE382BB84A3E76C", hash_generated_method = "6D3F1E438D19EE23A42692B8178FB021")
    
public void setOnGroupExpandListener(
            OnGroupExpandListener onGroupExpandListener) {
        mOnGroupExpandListener = onGroupExpandListener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.844 -0500", hash_original_method = "C8C3684AA79EC58EA45C462FF87BD202", hash_generated_method = "0B608BCFF019FA1A2D56B8512679B266")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        mOnGroupClickListener = onGroupClickListener;
        onGroupClickListener.onGroupClick(this, null, 0, 0);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.851 -0500", hash_original_method = "26EE7772CEF1895E61E52189D15F9720", hash_generated_method = "1D2C0B735E016F90BCC7C248AD89CF02")
    @DSVerified
public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        mOnChildClickListener = onChildClickListener;
        if (onChildClickListener != null) {
            onChildClickListener.onChildClick(this, new View(DSOnlyType.DONTCARE), 
                    DSUtils.FAKE_INT, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
        }

    }
    
    /**
     * Converts a flat list position (the raw position of an item (child or group)
     * in the list) to an group and/or child position (represented in a
     * packed position). This is useful in situations where the caller needs to
     * use the underlying {@link ListView}'s methods. Use
     * {@link ExpandableListView#getPackedPositionType} ,
     * {@link ExpandableListView#getPackedPositionChild},
     * {@link ExpandableListView#getPackedPositionGroup} to unpack.
     * 
     * @param flatListPosition The flat list position to be converted.
     * @return The group and/or child position for the given flat list position
     *         in packed position representation. #PACKED_POSITION_VALUE_NULL if
     *         the position corresponds to a header or a footer item.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.853 -0500", hash_original_method = "6797E267DF9CCDAD7E03E9610CE356DD", hash_generated_method = "AE18A2934C271EE4255C042017CEC9B1")
    
public long getExpandableListPosition(int flatListPosition) {
        if (isHeaderOrFooterPosition(flatListPosition)) {
            return PACKED_POSITION_VALUE_NULL;
        }

        final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        long packedPos = pm.position.getPackedPosition();
        pm.recycle();
        return packedPos;
    }
    
    /**
     * Converts a group and/or child position to a flat list position. This is
     * useful in situations where the caller needs to use the underlying
     * {@link ListView}'s methods.
     * 
     * @param packedPosition The group and/or child positions to be converted in
     *            packed position representation. Use
     *            {@link #getPackedPositionForChild(int, int)} or
     *            {@link #getPackedPositionForGroup(int)}.
     * @return The flat list position for the given child or group.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.855 -0500", hash_original_method = "C3C2613158D48075F4D80761E996AC8D", hash_generated_method = "48A2E76816F4860724AD3D129C27FAEC")
    
public int getFlatListPosition(long packedPosition) {
        PositionMetadata pm = mConnector.getFlattenedPos(ExpandableListPosition
                .obtainPosition(packedPosition));
        final int flatListPosition = pm.position.flatListPos;
        pm.recycle();
        return getAbsoluteFlatPosition(flatListPosition);
    }

    /**
     * Gets the position of the currently selected group or child (along with
     * its type). Can return {@link #PACKED_POSITION_VALUE_NULL} if no selection.
     * 
     * @return A packed position containing the currently selected group or
     *         child's position and type. #PACKED_POSITION_VALUE_NULL if no selection
     *         or if selection is on a header or a footer item.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.857 -0500", hash_original_method = "249AE284AF367E3E33266910F561E468", hash_generated_method = "8AC1384AD48FD830DFD341409F22EADB")
    
public long getSelectedPosition() {
        final int selectedPos = getSelectedItemPosition();

        // The case where there is no selection (selectedPos == -1) is also handled here.
        return getExpandableListPosition(selectedPos);
    }
    
    /**
     * Gets the ID of the currently selected group or child. Can return -1 if no
     * selection.
     * 
     * @return The ID of the currently selected group or child. -1 if no
     *         selection.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.859 -0500", hash_original_method = "0F549A577DA8ED79E79C3134155D319B", hash_generated_method = "C40FF77BB392610F0DF40101A5BAB794")
    
public long getSelectedId() {
        long packedPos = getSelectedPosition();
        if (packedPos == PACKED_POSITION_VALUE_NULL) return -1;

        int groupPos = getPackedPositionGroup(packedPos);
        
        if (getPackedPositionType(packedPos) == PACKED_POSITION_TYPE_GROUP) {
            // It's a group
            return mAdapter.getGroupId(groupPos);
        } else {
            // It's a child
            return mAdapter.getChildId(groupPos, getPackedPositionChild(packedPos));
        }
    }
    
    /**
     * Sets the selection to the specified group.
     * @param groupPosition The position of the group that should be selected.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.862 -0500", hash_original_method = "89C81106BDF582AFAD7189203633A87D", hash_generated_method = "C2019975B34CB9F1E35D6455C21A0EBD")
    
public void setSelectedGroup(int groupPosition) {
        ExpandableListPosition elGroupPos = ExpandableListPosition
                .obtainGroupPosition(groupPosition);
        PositionMetadata pm = mConnector.getFlattenedPos(elGroupPos);
        elGroupPos.recycle();
        final int absoluteFlatPosition = getAbsoluteFlatPosition(pm.position.flatListPos);
        super.setSelection(absoluteFlatPosition);
        pm.recycle();
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
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.865 -0500", hash_original_method = "1A768FE324BC96140FFAB346485D606B", hash_generated_method = "DDFA679849E732890403E14F67AEE509")
    
public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        ExpandableListPosition elChildPos = ExpandableListPosition.obtainChildPosition(
                groupPosition, childPosition); 
        PositionMetadata flatChildPos = mConnector.getFlattenedPos(elChildPos);
        
        if (flatChildPos == null) {
            // The child's group isn't expanded
            
            // Shouldn't expand the group, so return false for we didn't set the selection
            if (!shouldExpandGroup) return false;

            expandGroup(groupPosition);
            
            flatChildPos = mConnector.getFlattenedPos(elChildPos);
            
            // Sanity check
            if (flatChildPos == null) {
                throw new IllegalStateException("Could not find child");
            }
        }
        
        int absoluteFlatPosition = getAbsoluteFlatPosition(flatChildPos.position.flatListPos);
        super.setSelection(absoluteFlatPosition);
        
        elChildPos.recycle();
        flatChildPos.recycle();
        
        return true;
    }

    /**
     * Whether the given group is currently expanded.
     * 
     * @param groupPosition The group to check.
     * @return Whether the group is currently expanded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.867 -0500", hash_original_method = "1725653D4BF466A5CF5EF618E531911D", hash_generated_method = "85A26A62E7B509C582968BFBCF350B2C")
    
public boolean isGroupExpanded(int groupPosition) {
        return mConnector.isGroupExpanded(groupPosition);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.881 -0500", hash_original_method = "E91ADE02598601B56CDD6CB9CE298E24", hash_generated_method = "315B88758F6EBCB441A84DC019A76A8D")
    
@Override
    ContextMenuInfo createContextMenuInfo(View view, int flatListPosition, long id) {
        if (isHeaderOrFooterPosition(flatListPosition)) {
            // Return normal info for header/footer view context menus
            return new AdapterContextMenuInfo(view, flatListPosition, id);
        }

        final int adjustedPosition = getFlatPositionForConnector(flatListPosition);
        PositionMetadata pm = mConnector.getUnflattenedPos(adjustedPosition);
        ExpandableListPosition pos = pm.position;
        pm.recycle();
        
        id = getChildOrGroupId(pos);
        long packedPosition = pos.getPackedPosition();
        pos.recycle();
        
        return new ExpandableListContextMenuInfo(view, packedPosition, id);
    }

    /**
     * Gets the ID of the group or child at the given <code>position</code>.
     * This is useful since there is no ListAdapter ID -> ExpandableListAdapter
     * ID conversion mechanism (in some cases, it isn't possible).
     * 
     * @param position The position of the child or group whose ID should be
     *            returned.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.883 -0500", hash_original_method = "FEE5EC0BA8444C3E23B9BF5AFE8AF9D9", hash_generated_method = "1C6151BEE6103DBF11F9EBFFEAAFB538")
    
private long getChildOrGroupId(ExpandableListPosition position) {
        if (position.type == ExpandableListPosition.CHILD) {
            return mAdapter.getChildId(position.groupPos, position.childPos);
        } else {
            return mAdapter.getGroupId(position.groupPos);
        }
    }
    
    /**
     * Sets the indicator to be drawn next to a child.
     * 
     * @param childIndicator The drawable to be used as an indicator. If the
     *            child is the last child for a group, the state
     *            {@link android.R.attr#state_last} will be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.886 -0500", hash_original_method = "ED7EE4CBDCF7577D87176969D6DCB802", hash_generated_method = "F38D6E793FCE20E12DCA1147E1443737")
    
public void setChildIndicator(Drawable childIndicator) {
        mChildIndicator = childIndicator;
    }
    
    /**
     * Sets the drawing bounds for the child indicator. For either, you can
     * specify {@link #CHILD_INDICATOR_INHERIT} to use inherit from the general
     * indicator's bounds.
     *
     * @see #setIndicatorBounds(int, int)
     * @param left The left position (relative to the left bounds of this View)
     *            to start drawing the indicator.
     * @param right The right position (relative to the left bounds of this
     *            View) to end the drawing of the indicator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.888 -0500", hash_original_method = "CC0F573BF0E3363C1E0D2AF3089F451E", hash_generated_method = "93209E8BC149C932D66CD1F4FF923541")
    
public void setChildIndicatorBounds(int left, int right) {
        mChildIndicatorLeft = left;
        mChildIndicatorRight = right;
    }
    
    /**
     * Sets the indicator to be drawn next to a group.
     * 
     * @param groupIndicator The drawable to be used as an indicator. If the
     *            group is empty, the state {@link android.R.attr#state_empty} will be
     *            set. If the group is expanded, the state
     *            {@link android.R.attr#state_expanded} will be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.891 -0500", hash_original_method = "23AAB419B9D32765056529A2DC5EA53F", hash_generated_method = "019C32C165DA4676612357EA6BE00446")
    
public void setGroupIndicator(Drawable groupIndicator) {
        mGroupIndicator = groupIndicator;
        if (mIndicatorRight == 0 && mGroupIndicator != null) {
            mIndicatorRight = mIndicatorLeft + mGroupIndicator.getIntrinsicWidth();
        }
    }

    /**
     * Sets the drawing bounds for the indicators (at minimum, the group indicator
     * is affected by this; the child indicator is affected by this if the
     * child indicator bounds are set to inherit).
     * 
     * @see #setChildIndicatorBounds(int, int) 
     * @param left The left position (relative to the left bounds of this View)
     *            to start drawing the indicator.
     * @param right The right position (relative to the left bounds of this
     *            View) to end the drawing of the indicator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.893 -0500", hash_original_method = "442AEE74CE0C61614A47372E9A48F50C", hash_generated_method = "A9AD36AB777326C1CDD9AF8257DC59F6")
    
public void setIndicatorBounds(int left, int right) {
        mIndicatorLeft = left;
        mIndicatorRight = right;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.927 -0500", hash_original_method = "D1B709DD85334DB90D0ABC47C1E74159", hash_generated_method = "DF0EE4B90E3C87AD1F1D67C2FE8646E8")
    
@Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return new SavedState(superState,
                mConnector != null ? mConnector.getExpandedGroupMetadataList() : null);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.929 -0500", hash_original_method = "FA4E85B1CE7B753D6AFB9648E78FCCBA", hash_generated_method = "6B16222A99996667548F647B4F7E930B")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        
        if (mConnector != null && ss.expandedGroupMetadataList != null) {
            mConnector.setExpandedGroupMetadataList(ss.expandedGroupMetadataList);
        }
    }
}

