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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

/**
 * Implementation of SearchView compatibility that can call Honeycomb APIs.
 */
class SearchViewCompatHoneycomb {

    interface OnQueryTextListenerCompatBridge {
        public boolean onQueryTextSubmit(String query);
        public boolean onQueryTextChange(String newText);
    }

    interface OnCloseListenerCompatBridge {
        public boolean onClose();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.632 -0500", hash_original_method = "47EC55BAAF40BBFFE0C4E0C5F9DEA5E4", hash_generated_method = "0C6187E3ED763BCAC38D27A79FB5D798")
    
public static View newSearchView(Context context) {
        return new SearchView(context);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.636 -0500", hash_original_method = "F01B033B3448D7B66D3DDB9CB1C4E8DF", hash_generated_method = "DD6B104DDF52E10A0F2BEED327BD2CDF")
    
public static void setSearchableInfo(View searchView, ComponentName searchableComponent) {
        SearchView sv = ((SearchView) searchView);
        SearchManager searchManager = (SearchManager)
                sv.getContext().getSystemService(Context.SEARCH_SERVICE);
        sv.setSearchableInfo(searchManager.getSearchableInfo(searchableComponent));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.642 -0500", hash_original_method = "EDAB4725BA9463B630F73DBD30EE781B", hash_generated_method = "40EB19B3C4DDA0DD14D09CB86A2A26E8")
    
public static Object newOnQueryTextListener(final OnQueryTextListenerCompatBridge listener) {
        return new OnQueryTextListener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:49.095 -0500", hash_original_method = "D5F2F74DAAAF60E7B51CA03B684B3089", hash_generated_method = "1DB8840D9C498F9459B22BB5198B80AD")
            
@Override
            public boolean onQueryTextSubmit(String query) {
                return listener.onQueryTextSubmit(query);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:49.098 -0500", hash_original_method = "77B59A3AEE38561B3E73A13D8322A844", hash_generated_method = "C057BA7A4D0B5F051C56A7287662DB1B")
            
@Override
            public boolean onQueryTextChange(String newText) {
                return listener.onQueryTextChange(newText);
            }
        };
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.643 -0500", hash_original_method = "8AEDBA760889DA3F107C418C2C402B73", hash_generated_method = "38695D0B24299FCDD4CD909307F2BC0F")
    
public static void setOnQueryTextListener(Object searchView, Object listener) {
        ((SearchView) searchView).setOnQueryTextListener((OnQueryTextListener) listener);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.646 -0500", hash_original_method = "E20BD74020DFB5106AC6ADF3EEFF0F59", hash_generated_method = "E29F3EFA5188165AFFB31F80BE5F3F87")
    
public static Object newOnCloseListener(final OnCloseListenerCompatBridge listener) {
        return new OnCloseListener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:49.107 -0500", hash_original_method = "CA2D763980D715A5D729671C516D0328", hash_generated_method = "BE64E6081B382AA002DA5E6A96D8E0F5")
            
@Override
            public boolean onClose() {
                return listener.onClose();
            }
        };
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.647 -0500", hash_original_method = "AC1D7EAEBFFF3FB59F7568F442152E18", hash_generated_method = "24ADB0FDF38BDE4EF059E733B05B7E65")
    
public static void setOnCloseListener(Object searchView, Object listener) {
        ((SearchView) searchView).setOnCloseListener((OnCloseListener) listener);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.648 -0500", hash_original_method = "4843B53FD214287C32D5D5F879F93CD2", hash_generated_method = "3EE63B52B15918C60CA2528A5C74BE09")
    
public static CharSequence getQuery(View searchView) {
        return ((SearchView) searchView).getQuery();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.649 -0500", hash_original_method = "42E3D1F67E04971707862D614B6F8442", hash_generated_method = "9A18E2AC6D8C6D8D17FF1B6A317D9CEF")
    
public static void setQuery(View searchView, CharSequence query, boolean submit) {
        ((SearchView) searchView).setQuery(query, submit);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.651 -0500", hash_original_method = "127C52EE19E02DDD7066D4D54CEA1BFF", hash_generated_method = "E0D3CB19E74D29B494178ED927E32858")
    
public static void setQueryHint(View searchView, CharSequence hint) {
        ((SearchView) searchView).setQueryHint(hint);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.652 -0500", hash_original_method = "A052720BD8558F4592174F05DDEE6807", hash_generated_method = "47A74EA92FBAE8A764076519F5473264")
    
public static void setIconified(View searchView, boolean iconify) {
        ((SearchView) searchView).setIconified(iconify);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.655 -0500", hash_original_method = "C7FB831708C43D9BCD7EFF2E363B3546", hash_generated_method = "B822D6F33CD9724C869ED10476755D09")
    
public static boolean isIconified(View searchView) {
        return ((SearchView) searchView).isIconified();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.656 -0500", hash_original_method = "D36793D1B6D3CC1C22E275C0AED4D610", hash_generated_method = "49BFA35C3BC33622CA68A1EB50C66370")
    
public static void setSubmitButtonEnabled(View searchView, boolean enabled) {
        ((SearchView) searchView).setSubmitButtonEnabled(enabled);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.657 -0500", hash_original_method = "8AAEFCA4CC7C6998E16A30633D0A6AEE", hash_generated_method = "688EC19D433F7589F6D5778B15E93FF6")
    
public static boolean isSubmitButtonEnabled(View searchView) {
        return ((SearchView) searchView).isSubmitButtonEnabled();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.659 -0500", hash_original_method = "5DDC81DBA130956B63A91F88FF112FD2", hash_generated_method = "5C19E544EC90883314FF79E645E12835")
    
public static void setQueryRefinementEnabled(View searchView, boolean enable) {
        ((SearchView) searchView).setQueryRefinementEnabled(enable);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.660 -0500", hash_original_method = "26CE910E89594DF37DC5260AC2C7FC7A", hash_generated_method = "0DF720F62ED143B06CCD901848524FB4")
    
public static boolean isQueryRefinementEnabled(View searchView) {
        return ((SearchView) searchView).isQueryRefinementEnabled();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:34.662 -0500", hash_original_method = "769F2C65D94DA5C8D2B55C59F40A01D8", hash_generated_method = "C9C9D44C7D4E19D430B0BE10F2478CEA")
    
public static void setMaxWidth(View searchView, int maxpixels) {
        ((SearchView) searchView).setMaxWidth(maxpixels);
    }
}
