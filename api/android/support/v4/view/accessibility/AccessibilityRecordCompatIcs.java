/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.support.v4.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

import java.util.List;

/**
 * ICS specific AccessibilityRecord API implementation.
 */
class AccessibilityRecordCompatIcs {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.152 -0500", hash_original_method = "0DD67D8AFB133825CF53DCEDCDA39423", hash_generated_method = "323EB4547BB1340E21E569B04BB6213E")
    
public static Object obtain() {
        return AccessibilityRecord.obtain();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.153 -0500", hash_original_method = "580D7DE3970E43C999D626619C08C41D", hash_generated_method = "26D8401152747F83BA397888552C4CD1")
    
public static Object obtain(Object record) {
        return AccessibilityRecord.obtain((AccessibilityRecord) record);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.154 -0500", hash_original_method = "25FE2EE51AE2DA2060D7EECE54C32E14", hash_generated_method = "7C1CBC4A22BC672B858EA3E14E520EC7")
    
public static int getAddedCount(Object record) {
        return ((AccessibilityRecord) record).getAddedCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.155 -0500", hash_original_method = "8EF7B08CDD23A32903A4E0713A0DC723", hash_generated_method = "EADA629F94388CA0733424CA06AF9F10")
    
public static CharSequence getBeforeText(Object record) {
        return ((AccessibilityRecord) record).getBeforeText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.157 -0500", hash_original_method = "99A4AD931C76CE0F1770CC02947BAD50", hash_generated_method = "0D67A9A7F0F7AFBB1F959DF8ACD42141")
    
public static CharSequence getClassName(Object record) {
        return ((AccessibilityRecord) record).getClassName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.159 -0500", hash_original_method = "895803878F9A64D48C91A386E9DBD2D3", hash_generated_method = "2E4242D57CD274BB507401CF60E3F131")
    
public static CharSequence getContentDescription(Object record) {
        return ((AccessibilityRecord) record).getContentDescription();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.161 -0500", hash_original_method = "BB7E19D2E2EDD1F20EDD085979BE67B3", hash_generated_method = "8F06C95C8B63A4AD2E363B5CA33B47C5")
    
public static int getCurrentItemIndex(Object record) {
        return ((AccessibilityRecord) record).getCurrentItemIndex();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.164 -0500", hash_original_method = "2B1BD7FBEAF499D9BF6E5985BBCB40D0", hash_generated_method = "BA3CCAC5E1740F4C60A95E1F6CAEAD03")
    
public static int getFromIndex(Object record) {
        return ((AccessibilityRecord) record).getFromIndex();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.166 -0500", hash_original_method = "3BC55E1122CD0E333E6A2F48BC7B4107", hash_generated_method = "320A175741953D10F07CA4B0B896E592")
    
public static int getItemCount(Object record) {
        return ((AccessibilityRecord) record).getItemCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.168 -0500", hash_original_method = "2264B314BAD35FD97FD3128BF830A4D0", hash_generated_method = "235B97B4026078FC823312A4CFCF41DA")
    
public static Parcelable getParcelableData(Object record) {
        return ((AccessibilityRecord) record).getParcelableData();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.170 -0500", hash_original_method = "E9D1A9D936DA737DDFB50E2CF984AD59", hash_generated_method = "F30DBAAEF981946FF981980CA740BBBD")
    
public static int getRemovedCount(Object record) {
        return ((AccessibilityRecord) record).getRemovedCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.172 -0500", hash_original_method = "AC26A8EFA31067276C10B30E24D60425", hash_generated_method = "F56C9DF05800094D37305843C5449D25")
    
public static int getScrollX(Object record) {
        return ((AccessibilityRecord) record).getScrollX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.175 -0500", hash_original_method = "38CF8DDE6565F683166E31F32A657178", hash_generated_method = "39E0D155F5AE6F83ECE0ED1D1F666AF0")
    
public static int getScrollY(Object record) {
        return ((AccessibilityRecord) record).getScrollY();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.177 -0500", hash_original_method = "C0A75BA13D2975A38A86174E2822A966", hash_generated_method = "782535B31D5AB876762266BC4A5C1FA9")
    
public static Object getSource(Object record) {
        return ((AccessibilityRecord) record).getSource();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.179 -0500", hash_original_method = "297D7CB2E280047FDF94054B55217B78", hash_generated_method = "1F3A6160419D1AE6F744BA4AB4245F2C")
    
public static List<CharSequence> getText(Object record) {
        return ((AccessibilityRecord) record).getText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.182 -0500", hash_original_method = "73460B85CCF2EBE8375FAC02917F2C1F", hash_generated_method = "B5856925C7F40BDFD66865001B5DDD49")
    
public static int getToIndex(Object record) {
        return ((AccessibilityRecord) record).getToIndex();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.184 -0500", hash_original_method = "389DC85CD41F99CAB0B9FAB72B3129B4", hash_generated_method = "6973A9337FD0FB19C13922FE333B3811")
    
public static int getWindowId(Object record) {
        return ((AccessibilityRecord) record).getWindowId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.187 -0500", hash_original_method = "8699B98DD6DDFACF10BFCD5D9C617408", hash_generated_method = "014D1B3BEA153DFB8378ABE07564B229")
    
public static boolean isChecked(Object record) {
        return ((AccessibilityRecord) record).isChecked();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.190 -0500", hash_original_method = "067B601DA90294AD171EF27BFDD66F3B", hash_generated_method = "1036369EF9D6C48661D19A498BEEF803")
    
public static boolean isEnabled(Object record) {
        return ((AccessibilityRecord) record).isEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.191 -0500", hash_original_method = "2DDED1F060FB2DDD4CD0B839ED0D3AA0", hash_generated_method = "7320AFD3CCCCBD2309415E6D5E557876")
    
public static boolean isFullScreen(Object record) {
        return ((AccessibilityRecord) record).isFullScreen();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.193 -0500", hash_original_method = "028FF2FB06585272B548761B910C7DD6", hash_generated_method = "26175A62E2E5B65B027B2F3F622EFDE1")
    
public static boolean isPassword(Object record) {
        return ((AccessibilityRecord) record).isPassword();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.194 -0500", hash_original_method = "8A72DDA4A2037086C07827130DE53BE3", hash_generated_method = "1462629EF3B1875BF4DD06A018C037B3")
    
public static boolean isScrollable(Object record) {
        return ((AccessibilityRecord) record).isScrollable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.195 -0500", hash_original_method = "2B9D679FA1938B2D319757B4252C6E04", hash_generated_method = "2C43D6213CB3ED543D69150D10B02ED5")
    
public static void recycle(Object record) {
        ((AccessibilityRecord) record).recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.199 -0500", hash_original_method = "494F7C69D87CBD468C13DF13DAE353AE", hash_generated_method = "15F802C69B08CE96EBC4248D0F2CE002")
    
public static void setAddedCount(Object record, int addedCount) {
        ((AccessibilityRecord) record).setAddedCount(addedCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.200 -0500", hash_original_method = "8EE81DD41961210E8146461DD675FF6E", hash_generated_method = "B8BB6CE2845AF8C1FF048D2E95B8949A")
    
public static void setBeforeText(Object record, CharSequence beforeText) {
        ((AccessibilityRecord) record).setBeforeText(beforeText);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.201 -0500", hash_original_method = "9136F9B8F4B423620A1ADFB2BD8C4A46", hash_generated_method = "A99FE8331A462071D5D8A789B9158DD5")
    
public static void setChecked(Object record, boolean isChecked) {
        ((AccessibilityRecord) record).setChecked(isChecked);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.203 -0500", hash_original_method = "897E7CE012BBEA8A70E196208DEC2090", hash_generated_method = "BEEA0E97F750D5C38C501C5D4C75F448")
    
public static void setClassName(Object record, CharSequence className) {
        ((AccessibilityRecord) record).setClassName(className);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.204 -0500", hash_original_method = "63EBC71B1A0C6E9950E60535D91E7FF7", hash_generated_method = "E5441EA05FD359540DB0C764A62D3D55")
    
public static void setContentDescription(Object record, CharSequence contentDescription) {
        ((AccessibilityRecord) record).setContentDescription(contentDescription);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.206 -0500", hash_original_method = "21F75294B4B24AD1EC3137DF5716C03A", hash_generated_method = "CEFA65C4B739E01042BE9824D284B17C")
    
public static void setCurrentItemIndex(Object record, int currentItemIndex) {
        ((AccessibilityRecord) record).setCurrentItemIndex(currentItemIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.324 -0500", hash_original_method = "70E99BBF15F362740C741F5B2A201C48", hash_generated_method = "B70E819150EC2072C84A8C2107024CC7")
    
public static void setEnabled(Object record, boolean isEnabled) {
        ((AccessibilityRecord) record).setEnabled(isEnabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.327 -0500", hash_original_method = "195CE70E5848F46F2666F93C4F342A83", hash_generated_method = "CB2173C072941A1A1727256937D68ED8")
    
public static void setFromIndex(Object record, int fromIndex) {
        ((AccessibilityRecord) record).setFromIndex(fromIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.330 -0500", hash_original_method = "A11D6B9AC5C0F18C24FB90992510EF5B", hash_generated_method = "8FC079D75A9BD6C9C7C20B140241DCF4")
    
public static void setFullScreen(Object record, boolean isFullScreen) {
        ((AccessibilityRecord) record).setFullScreen(isFullScreen);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.333 -0500", hash_original_method = "BFF9CFA5DA0C467BCD8C45487BC6FCB6", hash_generated_method = "51FCCE4A9E0724B703F31840978707FA")
    
public static void setItemCount(Object record, int itemCount) {
        ((AccessibilityRecord) record).setItemCount(itemCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.337 -0500", hash_original_method = "9A12D4567A261CFF94C4CE047D840242", hash_generated_method = "6FF32137D37230BA2426C27B83D14CEC")
    
public static void setParcelableData(Object record, Parcelable parcelableData) {
        ((AccessibilityRecord) record).setParcelableData(parcelableData);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.339 -0500", hash_original_method = "4D7D474D482FD85353AB65E8BDA6DE11", hash_generated_method = "DF45E9DDF70690D6C0A56A3945218FCC")
    
public static void setPassword(Object record, boolean isPassword) {
        ((AccessibilityRecord) record).setPassword(isPassword);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.342 -0500", hash_original_method = "0C69E924DE564A535EF502F8DFDADF81", hash_generated_method = "9D48612F76EE558C99BD6F25472ED8DB")
    
public static void setRemovedCount(Object record, int removedCount) {
        ((AccessibilityRecord) record).setRemovedCount(removedCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.345 -0500", hash_original_method = "E8D48A334EACF8DD228339C8F1EE4A1A", hash_generated_method = "F6113D6D47B7DEC43D3BE2FA001BE411")
    
public static void setScrollX(Object record, int scrollX) {
        ((AccessibilityRecord) record).setScrollX(scrollX);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.347 -0500", hash_original_method = "0545CAA4D3DB8FCB0E4EF839FA51252A", hash_generated_method = "6004AC94CB7D74A7D83DD5056A595064")
    
public static void setScrollY(Object record, int scrollY) {
        ((AccessibilityRecord) record).setScrollY(scrollY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.350 -0500", hash_original_method = "D75B4FDB7227E518685D16A3FC5831C2", hash_generated_method = "5CA3B5AAFA8FAE47CCE645E8168DCE63")
    
public static void setScrollable(Object record, boolean scrollable) {
        ((AccessibilityRecord) record).setScrollable(scrollable);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.354 -0500", hash_original_method = "C12E3D914FB5C57CC6F7865AE13DEDE3", hash_generated_method = "64D8E861C8FF98DBB51C9E90D5F09961")
    
public static void setSource(Object record, View source) {
        ((AccessibilityRecord) record).setSource(source);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:23.356 -0500", hash_original_method = "E71548FF263E2C758FD37284E3C81116", hash_generated_method = "295799672393DBF0DB2E3B5EE7DD9DBD")
    
public static void setToIndex(Object record, int toIndex) {
        ((AccessibilityRecord) record).setToIndex(toIndex);
    }
}
