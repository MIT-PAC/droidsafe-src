/*
 * Copyright (C) 2012 The Android Open Source Project
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
import android.content.Context;
import android.view.View;
import android.widget.SearchView;

/**
 * Implementation of SearchView compatibility that can call ICS APIs.
 */
class SearchViewCompatIcs {

    public static class MySearchView extends SearchView {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.247 -0500", hash_original_method = "58DCF89988C851B95306F376E575AD93", hash_generated_method = "36515B6A7AFE68522085769DB0B6AF38")
        
public MySearchView(Context context) {
            super(context);
        }

        // The normal SearchView doesn't clear its search text when
        // collapsed, so we will do this for it.
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.248 -0500", hash_original_method = "E5687251D1F88E61D23992BF3CD9FD01", hash_generated_method = "1359B0846B97D32A5C84EBAC79A6F9E0")
        
@Override
        public void onActionViewCollapsed() {
            setQuery("", false);
            super.onActionViewCollapsed();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.250 -0500", hash_original_method = "2B819AB785909BEF41694881B01D550A", hash_generated_method = "FC9064C413605E8658365B3B67176F78")
    
public static View newSearchView(Context context) {
        return new MySearchView(context);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.251 -0500", hash_original_method = "C8204A6FCB580F191EB8157433EC5C84", hash_generated_method = "EC8DC9FE3E822BC2A7358B304D942459")
    
public static void setImeOptions(View searchView, int imeOptions) {
        ((SearchView) searchView).setImeOptions(imeOptions);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.252 -0500", hash_original_method = "D6D2D57ED99B395C40122C9A058EA520", hash_generated_method = "64B40734BF8B07D78141E9E790CAE51F")
    
public static void setInputType(View searchView, int inputType) {
        ((SearchView) searchView).setInputType(inputType);
    }
}
