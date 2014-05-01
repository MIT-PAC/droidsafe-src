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

package android.support.v4.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

/**
 * Helper for accessing features in {@link android.widget.SearchView}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class SearchViewCompat {

    interface SearchViewCompatImpl {
        View newSearchView(Context context);
        void setSearchableInfo(View searchView, ComponentName searchableComponent);
        void setImeOptions(View searchView, int imeOptions);
        void setInputType(View searchView, int inputType);
        Object newOnQueryTextListener(OnQueryTextListenerCompat listener);
        void setOnQueryTextListener(Object searchView, Object listener);
        Object newOnCloseListener(OnCloseListenerCompat listener);
        void setOnCloseListener(Object searchView, Object listener);
        CharSequence getQuery(View searchView);
        void setQuery(View searchView, CharSequence query, boolean submit);
        void setQueryHint(View searchView, CharSequence hint);
        void setIconified(View searchView, boolean iconify);
        boolean isIconified(View searchView);
        void setSubmitButtonEnabled(View searchView, boolean enabled);
        boolean isSubmitButtonEnabled(View searchView);
        void setQueryRefinementEnabled(View searchView, boolean enable);
        boolean isQueryRefinementEnabled(View searchView);
        void setMaxWidth(View searchView, int maxpixels);
    }

    static class SearchViewCompatStubImpl implements SearchViewCompatImpl {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.689 -0500", hash_original_method = "601679CFAB3495EA7ECC75098CF37042", hash_generated_method = "01B8D925AF84FA2F5F4F192CDC4B9979")
        
@Override
        public View newSearchView(Context context) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.691 -0500", hash_original_method = "B76D0F0AD70FBD993AA054AC966C0226", hash_generated_method = "C6C7B70F2A7F83E0FCF90D4B7C995C4B")
        
@Override
        public void setSearchableInfo(View searchView, ComponentName searchableComponent) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.692 -0500", hash_original_method = "A525123A13CFF6A0AFCFA2982BFEE16A", hash_generated_method = "CB00AC21F52D4D35B43E9A48EDE970B5")
        
@Override
        public void setImeOptions(View searchView, int imeOptions) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.693 -0500", hash_original_method = "6D0E10A0E31C98A87AF3C581EEADAA4A", hash_generated_method = "6B733800A136597907E8848068C55F27")
        
@Override
        public void setInputType(View searchView, int inputType) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.694 -0500", hash_original_method = "6491A9091D249E5011F8DD599AEB3CCA", hash_generated_method = "006E3F7ABE0A6FBEE4310B24753538C9")
        
@Override
        public Object newOnQueryTextListener(OnQueryTextListenerCompat listener) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.695 -0500", hash_original_method = "567DC5C1492382FEB616EED2C402A4F7", hash_generated_method = "1E5C85C0F161370AEA9DB20B31B995EC")
        
@Override
        public void setOnQueryTextListener(Object searchView, Object listener) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.696 -0500", hash_original_method = "991A38E7B52D21C9B1D5F35AE238AB09", hash_generated_method = "11EEFE792D32D2754EF8ADABE79336BC")
        
@Override
        public Object newOnCloseListener(OnCloseListenerCompat listener) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.697 -0500", hash_original_method = "76971B325212E9DD3D41974ACD70434E", hash_generated_method = "9000F76A969149C547059AD76BFD3A52")
        
@Override
        public void setOnCloseListener(Object searchView, Object listener) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.698 -0500", hash_original_method = "C78964F5320EF9565DC8DC327FD894B2", hash_generated_method = "D957D3B53A2A7F2A425612B2CBD9C8A1")
        
@Override
        public CharSequence getQuery(View searchView) {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.699 -0500", hash_original_method = "D4A58D7E3132BD0AB88560C3E97D1D57", hash_generated_method = "F084A60A81158B2C92566BCFFDD07D4C")
        
@Override
        public void setQuery(View searchView, CharSequence query, boolean submit) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.701 -0500", hash_original_method = "D7D6366C0A83FD1B8E7FCE8071B745C2", hash_generated_method = "344F4D461B3BC92655604CE355A22306")
        
@Override
        public void setQueryHint(View searchView, CharSequence hint) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.702 -0500", hash_original_method = "10E7D23740AED00E2BC47599B22C08AF", hash_generated_method = "126695CCFF1D339F0F450BF85111B8BD")
        
@Override
        public void setIconified(View searchView, boolean iconify) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.704 -0500", hash_original_method = "7E6006EDBD3BA325BC55954C51734681", hash_generated_method = "77F5F1E8946C454017A414F0CB404CFF")
        
@Override
        public boolean isIconified(View searchView) {
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.708 -0500", hash_original_method = "DE75EC18DF3FA78E36F41AA5C6418913", hash_generated_method = "AE84465BB0A1010E51FDFF16400C1C7E")
        
@Override
        public void setSubmitButtonEnabled(View searchView, boolean enabled) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.710 -0500", hash_original_method = "7EE2BA9E232D2C3B0D88E92BC4D8764B", hash_generated_method = "A9D2BB651671A2F51F406A3F8A815F7F")
        
@Override
        public boolean isSubmitButtonEnabled(View searchView) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.712 -0500", hash_original_method = "914624A6E648AEE67FC473A87D6DBD91", hash_generated_method = "8D7AF58102186020240BE07AA75638B0")
        
@Override
        public void setQueryRefinementEnabled(View searchView, boolean enable) {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.714 -0500", hash_original_method = "5A3B9DB7D37066F146E5F4C39F86F3AF", hash_generated_method = "805E5C5118F8E621A716A9C2544BAF2C")
        
@Override
        public boolean isQueryRefinementEnabled(View searchView) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:38.716 -0500", hash_original_method = "67C28A2BB127572D04E6FF76F952CC8C", hash_generated_method = "9E08AFAB2E2B11DBCBF59213B0B83E36")
        
@Override
        public void setMaxWidth(View searchView, int maxpixels) {
        }
    }

    static class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.052 -0500", hash_original_method = "3F3313353AF86074CB948A37F97575DD", hash_generated_method = "3CB9C7596757F706442476256CB38590")
        
@Override
        public View newSearchView(Context context) {
            return SearchViewCompatHoneycomb.newSearchView(context);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.055 -0500", hash_original_method = "5A0E3D1DA8EFCC40B67127D1FD734E5B", hash_generated_method = "BD2414FCF350A50ABC1012B92B5147FD")
        
@Override
        public void setSearchableInfo(View searchView, ComponentName searchableComponent) {
            SearchViewCompatHoneycomb.setSearchableInfo(searchView, searchableComponent);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.063 -0500", hash_original_method = "18C32C37E3B5529BB32FD609E2137238", hash_generated_method = "52341BBC91F6037BA4D1E4A474E18A73")
        
@Override
        public Object newOnQueryTextListener(final OnQueryTextListenerCompat listener) {
            return SearchViewCompatHoneycomb.newOnQueryTextListener(
                    new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:53.446 -0500", hash_original_method = "D5F2F74DAAAF60E7B51CA03B684B3089", hash_generated_method = "1DB8840D9C498F9459B22BB5198B80AD")
                
@Override
                        public boolean onQueryTextSubmit(String query) {
                            return listener.onQueryTextSubmit(query);
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:53.447 -0500", hash_original_method = "77B59A3AEE38561B3E73A13D8322A844", hash_generated_method = "C057BA7A4D0B5F051C56A7287662DB1B")
                
@Override
                        public boolean onQueryTextChange(String newText) {
                            return listener.onQueryTextChange(newText);
                        }
                    });
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.066 -0500", hash_original_method = "B8BB88E51187575EF90C6D368DC7FCD7", hash_generated_method = "7D475CF0E72628BC9C68D9DD89FE025D")
        
@Override
        public void setOnQueryTextListener(Object searchView, Object listener) {
            SearchViewCompatHoneycomb.setOnQueryTextListener(searchView, listener);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.068 -0500", hash_original_method = "92007614B8ED41E82FC43932A32D1E39", hash_generated_method = "C64ADE51723ECDFFDEA23FE36C4E3BA5")
        
@Override
        public Object newOnCloseListener(final OnCloseListenerCompat listener) {
            return SearchViewCompatHoneycomb.newOnCloseListener(
                    new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge() {
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:53.452 -0500", hash_original_method = "CA2D763980D715A5D729671C516D0328", hash_generated_method = "BE64E6081B382AA002DA5E6A96D8E0F5")
                
@Override
                        public boolean onClose() {
                            return listener.onClose();
                        }
                    });
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.069 -0500", hash_original_method = "33CF917C5FB6C1190F3CD89A1AC3F440", hash_generated_method = "BD52E73F1CB550D8AE3C4FC175A9D46A")
        
@Override
        public void setOnCloseListener(Object searchView, Object listener) {
            SearchViewCompatHoneycomb.setOnCloseListener(searchView, listener);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.071 -0500", hash_original_method = "D851CACDEB3C940AA10E2B0D392D9759", hash_generated_method = "651EC28BA23C12CDE814EE7B7678D821")
        
@Override
        public CharSequence getQuery(View searchView) {
            return SearchViewCompatHoneycomb.getQuery(searchView);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.072 -0500", hash_original_method = "0D5A26A203A9BAA27F5EEBD5C0017813", hash_generated_method = "78D5CF153AF2A3AE8F60EC8ABB0D657A")
        
@Override
        public void setQuery(View searchView, CharSequence query, boolean submit) {
            SearchViewCompatHoneycomb.setQuery(searchView, query, submit);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.074 -0500", hash_original_method = "B87B5CF7E9151A87B09469A27DF643FD", hash_generated_method = "4C80DDC7565CD2D2735B34EF7D96184F")
        
@Override
        public void setQueryHint(View searchView, CharSequence hint) {
            SearchViewCompatHoneycomb.setQueryHint(searchView, hint);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.078 -0500", hash_original_method = "9C3E9BA2F0566AF2F9531703E3823A38", hash_generated_method = "F5C2C739350F47132C62E9C62CE1D3D8")
        
@Override
        public void setIconified(View searchView, boolean iconify) {
            SearchViewCompatHoneycomb.setIconified(searchView, iconify);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.080 -0500", hash_original_method = "499F19F788FB9FCA57B43F074A0B33F1", hash_generated_method = "B034AC410323BBA2E90ECC4B8A1E323C")
        
@Override
        public boolean isIconified(View searchView) {
            return SearchViewCompatHoneycomb.isIconified(searchView);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.083 -0500", hash_original_method = "00871882DA152846CA80C87FA933E401", hash_generated_method = "8F708A0FA22964E0207E21B7BB89A666")
        
@Override
        public void setSubmitButtonEnabled(View searchView, boolean enabled) {
            SearchViewCompatHoneycomb.setSubmitButtonEnabled(searchView, enabled);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.084 -0500", hash_original_method = "F08FB3F15210977E4A1E7BE44E4A6859", hash_generated_method = "7074AADCE5135A48453221D7155C55A0")
        
@Override
        public boolean isSubmitButtonEnabled(View searchView) {
            return SearchViewCompatHoneycomb.isSubmitButtonEnabled(searchView);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.085 -0500", hash_original_method = "D99029AF60F285ED018BAE7C09721F77", hash_generated_method = "1871DF7CF0E50C6497DC143C5311C7B2")
        
@Override
        public void setQueryRefinementEnabled(View searchView, boolean enable) {
            SearchViewCompatHoneycomb.setQueryRefinementEnabled(searchView, enable);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.087 -0500", hash_original_method = "34C1A5C4269609F773E016BCD54C8C30", hash_generated_method = "1EDE1B42AEFA6EE88CAF9DA2FF33C643")
        
@Override
        public boolean isQueryRefinementEnabled(View searchView) {
            return SearchViewCompatHoneycomb.isQueryRefinementEnabled(searchView);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.088 -0500", hash_original_method = "0B3DB0DB5CE6B6A3C8D9205F6E748CEC", hash_generated_method = "64BD8D3BA27A4F0DC99BE90C7C10DB72")
        
@Override
        public void setMaxWidth(View searchView, int maxpixels) {
            SearchViewCompatHoneycomb.setMaxWidth(searchView, maxpixels);
        }
    }

    static class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.095 -0500", hash_original_method = "E776F8434C2C960D2EDCCFDB94C38427", hash_generated_method = "3663E27CD32F31005802F5AFBE872EA4")
        
@Override
        public View newSearchView(Context context) {
            return SearchViewCompatIcs.newSearchView(context);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.097 -0500", hash_original_method = "85122B8AF025347595EE2D135C1A521D", hash_generated_method = "91E5B5F24FF22A03F33ECEAB6A5AC106")
        
@Override
        public void setImeOptions(View searchView, int imeOptions) {
            SearchViewCompatIcs.setImeOptions(searchView, imeOptions);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.099 -0500", hash_original_method = "A66B6FC8B94DB6A5AEC3F5811B6DB9C8", hash_generated_method = "3A1B275BA70A898CFC843D5A38DD5D16")
        
@Override
        public void setInputType(View searchView, int inputType) {
            SearchViewCompatIcs.setInputType(searchView, inputType);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.103 -0500", hash_original_field = "3A56788C22D1BF5CC18CE5F3EAAF4970", hash_generated_field = "BBCCB66EA2DE763E1C8298D067A19169")

    private static  SearchViewCompatImpl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new SearchViewCompatIcsImpl();
        } else if (Build.VERSION.SDK_INT >= 11) { // Honeycomb
            IMPL = new SearchViewCompatHoneycombImpl();
        } else {
            IMPL = new SearchViewCompatStubImpl();
        }
    }

    /**
     * Creates a new SearchView.
     *
     * @param context The Context the view is running in.
     * @return A SearchView instance if the class is present on the current
     *         platform, null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.109 -0500", hash_original_method = "D6BFED68F21DEA45FB10539F24DABB1D", hash_generated_method = "63A2E6198AEF28F44F8996CEF130F9CB")
    
public static View newSearchView(Context context) {
        return IMPL.newSearchView(context);
    }

    /**
     * Sets the SearchableInfo for this SearchView. Properties in the SearchableInfo are used
     * to display labels, hints, suggestions, create intents for launching search results screens
     * and controlling other affordances such as a voice button.
     *
     * @param searchView The SearchView to operate on.
     * @param searchableComponent The application component whose
     * {@link android.app.SearchableInfo} should be loaded and applied to
     * the SearchView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.111 -0500", hash_original_method = "0D1729E11FB1DBB193AD78666D84A874", hash_generated_method = "7871B50B4C1DE382F15E224C82ED0416")
    
public static void setSearchableInfo(View searchView, ComponentName searchableComponent) {
        IMPL.setSearchableInfo(searchView, searchableComponent);
    }

    /**
     * Sets the IME options on the query text field.  This is a no-op if
     * called on pre-{@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}
     * platforms.
     *
     * @see TextView#setImeOptions(int)
     * @param searchView The SearchView to operate on.
     * @param imeOptions the options to set on the query text field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.113 -0500", hash_original_method = "9E28D631F01631648CB33ED4CB19D53B", hash_generated_method = "AC6CBF3DAC7FAFA9E6E4BC375289F5AE")
    
public static void setImeOptions(View searchView, int imeOptions) {
        IMPL.setImeOptions(searchView, imeOptions);
    }

    /**
     * Sets the input type on the query text field.  This is a no-op if
     * called on pre-{@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}
     * platforms.
     *
     * @see TextView#setInputType(int)
     * @param searchView The SearchView to operate on.
     * @param inputType the input type to set on the query text field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.115 -0500", hash_original_method = "545E6882D7B1BE52C473FA9457982C9F", hash_generated_method = "54E2FCC4037DB9B2FD9ADBAD20ED25A9")
    
public static void setInputType(View searchView, int inputType) {
        IMPL.setInputType(searchView, inputType);
    }

    /**
     * Sets a listener for user actions within the SearchView.
     *
     * @param searchView The SearchView in which to register the listener.
     * @param listener the listener object that receives callbacks when the user performs
     *     actions in the SearchView such as clicking on buttons or typing a query.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.116 -0500", hash_original_method = "85EA4B25BB9E4E8641030BC97EA5B617", hash_generated_method = "1571B2E6FB8F4FC016BFD1EA763184AC")
    
public static void setOnQueryTextListener(View searchView, OnQueryTextListenerCompat listener) {
        IMPL.setOnQueryTextListener(searchView, listener.mListener);
    }

    /**
     * Sets a listener to inform when the user closes the SearchView.
     *
     * @param searchView The SearchView in which to register the listener.
     * @param listener the listener to call when the user closes the SearchView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.129 -0500", hash_original_method = "BBAE6C51D8EBF722B1D48635E12A8CF4", hash_generated_method = "EB16A42EB3E26E498E15164F853E3976")
    
public static void setOnCloseListener(View searchView, OnCloseListenerCompat listener) {
        IMPL.setOnCloseListener(searchView, listener.mListener);
    }

    /**
     * Callbacks for changes to the query text.
     */
    public static abstract class OnQueryTextListenerCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.118 -0500", hash_original_field = "6298872A0C122A375C2BF0CC5B8647C6", hash_generated_field = "6298872A0C122A375C2BF0CC5B8647C6")

         Object mListener;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.119 -0500", hash_original_method = "33B8BA196EF02A66C4C50F86A0DE8E7C", hash_generated_method = "295C0DF1B2567A50ACFCE85134F77CDE")
        
public OnQueryTextListenerCompat() {
            mListener = IMPL.newOnQueryTextListener(this);
        }

        /**
         * Called when the user submits the query. This could be due to a key press on the
         * keyboard or due to pressing a submit button.
         * The listener can override the standard behavior by returning true
         * to indicate that it has handled the submit request. Otherwise return false to
         * let the SearchView handle the submission by launching any associated intent.
         *
         * @param query the query text that is to be submitted
         *
         * @return true if the query has been handled by the listener, false to let the
         * SearchView perform the default action.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.121 -0500", hash_original_method = "3B39F743641514621D841B3390715E91", hash_generated_method = "CA0DBD656427F9DD7DF29C2CA8E65819")
        
public boolean onQueryTextSubmit(String query) {
            return false;
        }

        /**
         * Called when the query text is changed by the user.
         *
         * @param newText the new content of the query text field.
         *
         * @return false if the SearchView should perform the default action of showing any
         * suggestions if available, true if the action was handled by the listener.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.122 -0500", hash_original_method = "B6F5742F5D55A0164A53BADD48E4641B", hash_generated_method = "3C78693A2A590CC4D13D3E1995175A29")
        
public boolean onQueryTextChange(String newText) {
            return false;
        }
    }

    /**
     * Returns the query string currently in the text field.
     *
     * @param searchView The SearchView to operate on.
     *
     * @return the query string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.140 -0500", hash_original_method = "4FD53AC90F10EC0D70D7E649F0CF5803", hash_generated_method = "261F8A8D1765878ECFD73FE097593DAD")
    
public static CharSequence getQuery(View searchView) {
        return IMPL.getQuery(searchView);
    }

    /**
     * Callback for closing the query UI.
     */
    public static abstract class OnCloseListenerCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.132 -0500", hash_original_field = "6298872A0C122A375C2BF0CC5B8647C6", hash_generated_field = "6298872A0C122A375C2BF0CC5B8647C6")

         Object mListener;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.134 -0500", hash_original_method = "75162C0FB43600CA43E619EC75EF7BC7", hash_generated_method = "A67FECEB1010128AFD0BB47B14E774D0")
        
public OnCloseListenerCompat() {
            mListener = IMPL.newOnCloseListener(this);
        }

        /**
         * The user is attempting to close the SearchView.
         *
         * @return true if the listener wants to override the default behavior of clearing the
         * text field and dismissing it, false otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.136 -0500", hash_original_method = "D2873CA669226F3F5383EED3E4A66C2F", hash_generated_method = "CF17A1D5C75D2718D1584D512FBC8316")
        
public boolean onClose() {
            return false;
        }
    }

    /**
     * Sets a query string in the text field and optionally submits the query as well.
     *
     * @param searchView The SearchView to operate on.
     * @param query the query string. This replaces any query text already present in the
     * text field.
     * @param submit whether to submit the query right now or only update the contents of
     * text field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.141 -0500", hash_original_method = "3051F226E0CA054689F321D72984E7E8", hash_generated_method = "CEBCE39898F42BA40CD4A42ACCD76324")
    
public static void setQuery(View searchView, CharSequence query, boolean submit) {
        IMPL.setQuery(searchView, query, submit);
    }

    /**
     * Sets the hint text to display in the query text field. This overrides any hint specified
     * in the SearchableInfo.
     *
     * @param searchView The SearchView to operate on.
     * @param hint the hint text to display
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.143 -0500", hash_original_method = "FEB2D75CEAAB675E2C11FC423920F7F3", hash_generated_method = "DB791052E7055D23CB315D7661DD72CF")
    
public static void setQueryHint(View searchView, CharSequence hint) {
        IMPL.setQueryHint(searchView, hint);
    }

    /**
     * Iconifies or expands the SearchView. Any query text is cleared when iconified. This is
     * a temporary state and does not override the default iconified state set by
     * setIconifiedByDefault(boolean). If the default state is iconified, then
     * a false here will only be valid until the user closes the field. And if the default
     * state is expanded, then a true here will only clear the text field and not close it.
     *
     * @param searchView The SearchView to operate on.
     * @param iconify a true value will collapse the SearchView to an icon, while a false will
     * expand it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.145 -0500", hash_original_method = "39C0F367A317DFA213F9E02A2660E1E8", hash_generated_method = "81FA4A60365A790D1B040D1FEEB2D2D8")
    
public static void setIconified(View searchView, boolean iconify) {
        IMPL.setIconified(searchView, iconify);
    }

    /**
     * Returns the current iconified state of the SearchView.
     *
     * @param searchView The SearchView to operate on.
     * @return true if the SearchView is currently iconified, false if the search field is
     * fully visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.146 -0500", hash_original_method = "3D24863EF980D693D45BD66829EDFC86", hash_generated_method = "CF2714E2ABF821B22AE01B60F3D61A7F")
    
public static boolean isIconified(View searchView) {
        return IMPL.isIconified(searchView);
    }

    /**
     * Enables showing a submit button when the query is non-empty. In cases where the SearchView
     * is being used to filter the contents of the current activity and doesn't launch a separate
     * results activity, then the submit button should be disabled.
     *
     * @param searchView The SearchView to operate on.
     * @param enabled true to show a submit button for submitting queries, false if a submit
     * button is not required.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.147 -0500", hash_original_method = "75D2D395BE2853FA85EB2E684C15300F", hash_generated_method = "B330538FFD19E8EA0F121EAA11BD182F")
    
public static void setSubmitButtonEnabled(View searchView, boolean enabled) {
        IMPL.setSubmitButtonEnabled(searchView, enabled);
    }

    /**
     * Returns whether the submit button is enabled when necessary or never displayed.
     *
     * @param searchView The SearchView to operate on.
     * @return whether the submit button is enabled automatically when necessary
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.150 -0500", hash_original_method = "11A09CD481E241000B7B19A2E39D06B7", hash_generated_method = "6E94499364A5912BCF56535DE2DB5CAA")
    
public static boolean isSubmitButtonEnabled(View searchView) {
        return IMPL.isSubmitButtonEnabled(searchView);
    }

    /**
     * Specifies if a query refinement button should be displayed alongside each suggestion
     * or if it should depend on the flags set in the individual items retrieved from the
     * suggestions provider. Clicking on the query refinement button will replace the text
     * in the query text field with the text from the suggestion. This flag only takes effect
     * if a SearchableInfo has been specified with {@link #setSearchableInfo(View, ComponentName)}
     * and not when using a custom adapter.
     *
     * @param searchView The SearchView to operate on.
     * @param enable true if all items should have a query refinement button, false if only
     * those items that have a query refinement flag set should have the button.
     *
     * @see SearchManager#SUGGEST_COLUMN_FLAGS
     * @see SearchManager#FLAG_QUERY_REFINEMENT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.152 -0500", hash_original_method = "7D5C6BECC25F9CE74DBE18B74F0E9948", hash_generated_method = "A79B9699D95DC6967196AE0709A787D6")
    
public static void setQueryRefinementEnabled(View searchView, boolean enable) {
        IMPL.setQueryRefinementEnabled(searchView, enable);
    }

    /**
     * Returns whether query refinement is enabled for all items or only specific ones.
     * @param searchView The SearchView to operate on.
     * @return true if enabled for all items, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.155 -0500", hash_original_method = "4B9BDC013601DA9E227E43FECCA63537", hash_generated_method = "05B6F66BA23F592156DCA5D8AEA081EA")
    
public static boolean isQueryRefinementEnabled(View searchView) {
        return IMPL.isQueryRefinementEnabled(searchView);
    }

    /**
     * Makes the view at most this many pixels wide
     * @param searchView The SearchView to operate on.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.157 -0500", hash_original_method = "EEA9AD64C80C1AB09E2CA9F7BCFB2D28", hash_generated_method = "C84958FAFB885B1D5FD6695E0772068A")
    
public static void setMaxWidth(View searchView, int maxpixels) {
        IMPL.setMaxWidth(searchView, maxpixels);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:39.106 -0500", hash_original_method = "B4E26FED5815C0AEAAC238751F28DE83", hash_generated_method = "9C5D2866662105FB7A09F14DFE2C00DF")
    
private SearchViewCompat(Context context) {
        /* Hide constructor */
    }
}
