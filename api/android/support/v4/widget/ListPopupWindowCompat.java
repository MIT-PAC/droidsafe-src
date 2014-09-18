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
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * Helper for accessing features in ListPopupWindow introduced after API level 4
 * in a backwards compatible fashion.
 */
public class ListPopupWindowCompat {
    /**
     * Interface for the full API.
     */
    interface ListPopupWindowImpl {
        public OnTouchListener createDragToOpenListener(Object listPopupWindow, View src);
    }

    /**
     * Interface implementation that doesn't use anything above v4 APIs.
     */
    static class BaseListPopupWindowImpl implements ListPopupWindowImpl {
        @Override
        public OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
            return null;
        }
    }

    /**
     * Interface implementation for devices with at least KitKat APIs.
     */
    static class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
        @Override
        public OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
            return ListPopupWindowCompatKitKat.createDragToOpenListener(listPopupWindow, src);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.712 -0400", hash_original_field = "6DC62E6D5172A4CDD15FB2B0E9E4E765", hash_generated_field = "2751E7E306A832235B33EECE56F4019C")

    static  ListPopupWindowImpl IMPL;
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new KitKatListPopupWindowImpl();
        } else {
            IMPL = new BaseListPopupWindowImpl();
        }
    }

    /**
     * On API {@link android.os.Build.VERSION_CODES#KITKAT} and higher, returns
     * an {@link OnTouchListener} that can be added to the source view to
     * implement drag-to-open behavior. Generally, the source view should be the
     * same view that was passed to ListPopupWindow.setAnchorView(View).
     * <p>
     * When the listener is set on a view, touching that view and dragging
     * outside of its bounds will open the popup window. Lifting will select the
     * currently touched list item.
     * <p>
     * Example usage:
     * 
     * <pre>
     * ListPopupWindow myPopup = new ListPopupWindow(context);
     * myPopup.setAnchor(myAnchor);
     * OnTouchListener dragListener = myPopup.createDragToOpenListener(myAnchor);
     * myAnchor.setOnTouchListener(dragListener);
     * </pre>
     *
     * @param listPopupWindow the ListPopupWindow against which to invoke the
     *            method
     * @param src the view on which the resulting listener will be set
     * @return a touch listener that controls drag-to-open behavior, or null on
     *         unsupported APIs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.721 -0400", hash_original_method = "3F5CB369ADD9649A3FDDCFD2F91B78C1", hash_generated_method = "53C35889EC3F9FF036B5D1531DE6AEA2")
        
public static OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
        return IMPL.createDragToOpenListener(listPopupWindow, src);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:03:08.717 -0400", hash_original_method = "B05AACBB9617EF7D5BC024B9367A38DC", hash_generated_method = "E32CB8CD5BA187E49B37A2BB85C40275")
        
private ListPopupWindowCompat() {
        // This class is not publicly instantiable.
    }
}
