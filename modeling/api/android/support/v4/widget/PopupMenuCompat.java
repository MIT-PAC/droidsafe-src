/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.View.OnTouchListener;

/**
 * Helper for accessing features in PopupMenu introduced after API level 4 in a
 * backwards compatible fashion.
 */
public class PopupMenuCompat {
    /**
     * Interface for the full API.
     */
    interface PopupMenuImpl {
        public OnTouchListener getDragToOpenListener(Object popupMenu);
    }

    /**
     * Interface implementation that doesn't use anything above v4 APIs.
     */
    static class BasePopupMenuImpl implements PopupMenuImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public OnTouchListener getDragToOpenListener(Object popupMenu) {
            return null;
        }
    }

    /**
     * Interface implementation for devices with at least KitKat APIs.
     */
    static class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public OnTouchListener getDragToOpenListener(Object popupMenu) {
            return PopupMenuCompatKitKat.getDragToOpenListener(popupMenu);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.792 -0400", hash_original_field = "0189530AF642DA20A39B70BCD5C1CDC7", hash_generated_field = "051C628D41F4E8A8BDBA6E85FA74F990")

    static  PopupMenuImpl IMPL;
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new KitKatPopupMenuImpl();
        } else {
            IMPL = new BasePopupMenuImpl();
        }
    }

    /**
     * On API {@link android.os.Build.VERSION_CODES#KITKAT} and higher, returns
     * an {@link OnTouchListener} that can be added to the anchor view to
     * implement drag-to-open behavior.
     * <p>
     * When the listener is set on a view, touching that view and dragging
     * outside of its bounds will open the popup window. Lifting will select the
     * currently touched list item.
     * <p>
     * Example usage:
     * <pre>
     * PopupMenu myPopup = new PopupMenu(context, myAnchor);
     * myAnchor.setOnTouchListener(myPopup.getDragToOpenListener());
     * </pre>
     *
     * @param popupMenu the PopupMenu against which to invoke the method
     * @return a touch listener that controls drag-to-open behavior, or null on
     *         unsupported APIs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.801 -0400", hash_original_method = "A4FD7B50030FC56CA133C89D2E782DAC", hash_generated_method = "EBCC5D91CBEA6C6A29E3164F3623907E")
        
public static OnTouchListener getDragToOpenListener(Object popupMenu) {
        return IMPL.getDragToOpenListener(popupMenu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.797 -0400", hash_original_method = "67B6D7A73AFD7EDA89D823A0910639BC", hash_generated_method = "14008B56A5F034999EFD11762DDA8021")
        
private PopupMenuCompat() {
        // This class is not publicly instantiable.
    }
}
