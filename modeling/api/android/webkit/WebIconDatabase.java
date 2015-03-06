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


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;

public final class WebIconDatabase {

    /**
     * Get the global instance of WebIconDatabase.
     * @return A single instance of WebIconDatabase. It will be the same
     *         instance for the current process each time this method is
     *         called.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.376 -0500", hash_original_method = "4E10B7DC211B271410E858DC486E4F74", hash_generated_method = "C7F34D0C15F050226015FFD7AF608759")
    
public static WebIconDatabase getInstance() {
        // XXX: Must be created in the UI thread.
        if (sIconDatabase == null) {
            sIconDatabase = new WebIconDatabase();
        }
        return sIconDatabase;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeOpen(String path) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeClose() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRemoveAllIcons() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Bitmap nativeIconForPageUrl(String url) {
    	Bitmap bm = BitmapFactory.decodeByteArray(new byte[1], 0, 0);
    	return bm; 
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRetainIconForPageUrl(String url) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeReleaseIconForPageUrl(String url) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.289 -0500", hash_original_field = "24455ABE358B662CDEC483182BA9B932", hash_generated_field = "1F07299C39AF9E2A5CCA0FEC4BF5CF2A")

    private static final String LOGTAG = "WebIconDatabase";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.292 -0500", hash_original_field = "F8111B76967B028C4EC1A2230910FBAD", hash_generated_field = "30A3B2F719758B961B07CE52D4048FB9")

    private static WebIconDatabase sIconDatabase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.295 -0500", hash_original_field = "B12E4FA94C54D1BFCD468CBF8719E2FD", hash_generated_field = "5C95C2A575938D20E6F446AEF22802CE")

    // ready.
    private final EventHandler mEventHandler = new EventHandler();

    /**
     * Private constructor to avoid anyone else creating an instance.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.380 -0500", hash_original_method = "D97F7EFB28FBFEC67D724170FB0509C5", hash_generated_method = "ACA4506DB54BBD3943536973731E5E2E")
    
private WebIconDatabase() {}

    /**
     * Open a the icon database and store the icons in the given path.
     * @param path The directory path where the icon database will be stored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.360 -0500", hash_original_method = "3087EA5DA62EA4F11A4DE20CD6A73D07", hash_generated_method = "4ABB1964905CCA71D45CADAABECCD9A4")
    
public void open(String path) {
        if (path != null) {
            // Make the directories and parents if they don't exist
            File db = new File(path);
            if (!db.exists()) {
                db.mkdirs();
            }
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.OPEN, db.getAbsolutePath()));
        }
    }

    /**
     * Close the shared instance of the icon database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.362 -0500", hash_original_method = "331AABE14B3E5742E4C5E7CDDA5A9C2E", hash_generated_method = "60D98765531292F96CC071A7DEDF0FE9")
    
public void close() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.CLOSE));
    }

    /**
     * Removes all the icons in the database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.365 -0500", hash_original_method = "A85BFB776007018F103CC92C345AF37F", hash_generated_method = "94C4E7BDEFD681030A7C9C28A7D8437A")
    
public void removeAllIcons() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.REMOVE_ALL));
    }

    /**
     * Request the Bitmap representing the icon for the given page
     * url. If the icon exists, the listener will be called with the result.
     * @param url The page's url.
     * @param listener An implementation on IconListener to receive the result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.367 -0500", hash_original_method = "794C674767A8A815CC73A4F95B03095B", hash_generated_method = "D51B369AD3B0C23F076643D8A36DC310")
    
public void requestIconForPageUrl(String url, IconListener listener) {
        if (listener == null || url == null) {
            return;
        }
        Message msg = Message.obtain(null, EventHandler.REQUEST_ICON, listener);
        msg.getData().putString("url", url);
        mEventHandler.postMessage(msg);
    }

    /** {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.369 -0500", hash_original_method = "7ACE864BB2DE1EE9743E78ECD884C38E", hash_generated_method = "29655F3D0E5CBB0E607328A0AA10C931")
    
public void bulkRequestIconForPageUrl(ContentResolver cr, String where,
            IconListener listener) {
        if (listener == null) {
            return;
        }

        // Special case situation: we don't want to add this message to the
        // queue if there is no handler because we may never have a real
        // handler to service the messages and the cursor will never get
        // closed.
        if (mEventHandler.hasHandler()) {
            // Don't use Bundle as it is parcelable.
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("contentResolver", cr);
            map.put("where", where);
            map.put("listener", listener);
            Message msg =
                    Message.obtain(null, EventHandler.BULK_REQUEST_ICON, map);
            mEventHandler.postMessage(msg);
        }
    }

    /**
     * Retain the icon for the given page url.
     * @param url The page's url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.371 -0500", hash_original_method = "4FB0334B2FC007108F7A611624721C63", hash_generated_method = "E4EADCB993F5D5F2F71CDC46FF66E03C")
    
public void retainIconForPageUrl(String url) {
        if (url != null) {
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.RETAIN_ICON, url));
        }
    }
    
    private static class EventHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.298 -0500", hash_original_field = "050305D36072878F0238F8BF54B855BF", hash_generated_field = "1E570EBE80E5338300BCCB2022DC26E3")

        static final int OPEN         = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.300 -0500", hash_original_field = "3830EFA3CA7D9F0C05C14703172405BE", hash_generated_field = "A51E20F4691086AF2C72AAF5EE5A9914")

        static final int CLOSE        = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.303 -0500", hash_original_field = "339E3CFC97273D31CEAACA8136821836", hash_generated_field = "716F1C3E603A06F1507CFAA9733E8B89")

        static final int REMOVE_ALL   = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.305 -0500", hash_original_field = "93364A6636D1D7A58FE30D22230EFDA8", hash_generated_field = "2CBD1EDD3DFEDFC0E9FD8D72A1133969")

        static final int REQUEST_ICON = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.307 -0500", hash_original_field = "47259975128EF9A05ECB21033CFFA418", hash_generated_field = "B30A72E74E189578C2C06D7364CD4163")

        static final int RETAIN_ICON  = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.309 -0500", hash_original_field = "46F57D2C0EEE14003AC0F096E167A18A", hash_generated_field = "9CC14ECB732977917B0E84738C888F5C")

        static final int RELEASE_ICON = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.311 -0500", hash_original_field = "36881644DB144F907FF8A1D92B21C211", hash_generated_field = "2F9B877ECA5216C8090B560C55BCCA1A")

        static final int BULK_REQUEST_ICON = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.313 -0500", hash_original_field = "D71DD9DFC569A94CBA241D0ACAA3D9D9", hash_generated_field = "B0A0879D569A0231D6AC374E4FE85D66")

        private static final int ICON_RESULT = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.316 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        private class IconResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.321 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

            private  String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.324 -0500", hash_original_field = "EC076BF50357690C1FC8AB2DC0D41329", hash_generated_field = "817E9CCF7085AADAC424D9C5A9C974DC")

            private  Bitmap mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.327 -0500", hash_original_field = "19CAAE46323B093FD81348C3D9034B47", hash_generated_field = "5923DC2A4A9F5F2A44874626DE94545F")

            private  IconListener mListener;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.329 -0500", hash_original_method = "88D8D1712732D1C320641A492AB35980", hash_generated_method = "88D8D1712732D1C320641A492AB35980")
            
IconResult(String url, Bitmap icon, IconListener l) {
                mUrl = url;
                mIcon = icon;
                mListener = l;
            }
            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.331 -0500", hash_original_method = "0BD69C5EE78EDD047C8FC1E711DA2EA8", hash_generated_method = "0BD69C5EE78EDD047C8FC1E711DA2EA8")
            
void dispatch() {
                mListener.onReceivedIcon(mUrl, mIcon);
            }
            
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.319 -0500", hash_original_field = "F4EAC04A17F2B69CB24C3DC3766FE86B", hash_generated_field = "9B89FFC17BC75E97744A4692FA4B431D")

        private Vector<Message> mMessages = new Vector<Message>();
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.415 -0400", hash_original_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779", hash_generated_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779")
        public EventHandler ()
        {
            //Synthesized constructor
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.335 -0500", hash_original_method = "933A9372A0E78DFEA9569EC4FAF2FF2F", hash_generated_method = "81591D9A6F3795AB36738A360B3D8C11")
        
@Override
        public void handleMessage(Message msg) {
            // Note: This is the message handler for the UI thread.
            switch (msg.what) {
                case ICON_RESULT:
                    ((IconResult) msg.obj).dispatch();
                    break;
            }
        }

        // Called by WebCore thread to create the actual handler
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.342 -0500", hash_original_method = "93C53855D8E83D18C38BE52A1D7D3DDC", hash_generated_method = "9CEBFAB253FE1599DCDD779F22A9BEE0")
        
private synchronized void createHandler() {
            if (mHandler == null) {
                mHandler = new Handler() {
                    @DSSafe(DSCat.SAFE_LIST)
            @Override
                    public void handleMessage(Message msg) {
                        // Note: This is the message handler for the WebCore
                        // thread.
                        switch (msg.what) {
                            case OPEN:
                                nativeOpen((String) msg.obj);
                                break;

                            case CLOSE:
                                nativeClose();
                                break;

                            case REMOVE_ALL:
                                nativeRemoveAllIcons();
                                break;

                            case REQUEST_ICON:
                                IconListener l = (IconListener) msg.obj;
                                String url = msg.getData().getString("url");
                                requestIconAndSendResult(url, l);
                                break;

                            case BULK_REQUEST_ICON:
                                bulkRequestIcons(msg);
                                break;

                            case RETAIN_ICON:
                                nativeRetainIconForPageUrl((String) msg.obj);
                                break;

                            case RELEASE_ICON:
                                nativeReleaseIconForPageUrl((String) msg.obj);
                                break;
                        }
                    }
                };
                // Transfer all pending messages
                for (int size = mMessages.size(); size > 0; size--) {
                    mHandler.sendMessage(mMessages.remove(0));
                }
                mMessages = null;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.345 -0500", hash_original_method = "9D0DE68A4BFD007DC242C5FC5FA57FA9", hash_generated_method = "45D23FF17766BECACD89444CBA1F9B4F")
        
private synchronized boolean hasHandler() {
            return mHandler != null;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.348 -0500", hash_original_method = "4B2498A7504C7636E794F105FA929903", hash_generated_method = "BFF1BE7A56B3F7891A1C123884C790D7")
        
private synchronized void postMessage(Message msg) {
            if (mMessages != null) {
                mMessages.add(msg);
            } else {
                mHandler.sendMessage(msg);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.350 -0500", hash_original_method = "14DAA8F1389B41CD064DE9C446247235", hash_generated_method = "88B6ACE53A08318FE233E45328642E9E")
        
private void bulkRequestIcons(Message msg) {
            HashMap map = (HashMap) msg.obj;
            IconListener listener = (IconListener) map.get("listener");
            ContentResolver cr = (ContentResolver) map.get("contentResolver");
            String where = (String) map.get("where");

            Cursor c = null;
            try {
                c = cr.query(
                        Browser.BOOKMARKS_URI,
                        new String[] { Browser.BookmarkColumns.URL },
                        where, null, null);
                if (c.moveToFirst()) {
                    do {
                        String url = c.getString(0);
                        requestIconAndSendResult(url, listener);
                    } while (c.moveToNext());
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "BulkRequestIcons", e);
            } finally {
                if (c != null) c.close();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.352 -0500", hash_original_method = "FD70C30826AD390D3E7262DECFBF2A75", hash_generated_method = "95423EE78BF9CE6FD41B83663DC6E31D")
        
private void requestIconAndSendResult(String url, IconListener listener) {
            Bitmap icon = nativeIconForPageUrl(url);
            if (icon != null) {
                sendMessage(obtainMessage(ICON_RESULT,
                            new IconResult(url, icon, listener)));
            }
        }
    }
    
    public interface IconListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onReceivedIcon(String url, Bitmap icon);
    }

    /**
     * Release the icon for the given page url.
     * @param url The page's url.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.374 -0500", hash_original_method = "742C1A356F3DFC35D629978FF2508090", hash_generated_method = "4597327D83531D32CFAF4C88DA1A652D")
    
public void releaseIconForPageUrl(String url) {
        if (url != null) {
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.RELEASE_ICON, url));
        }
    }

    /**
     * Create the internal handler and transfer all pending messages.
     * XXX: Called by WebCore thread only!
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:02.378 -0500", hash_original_method = "B1AD2CC25FCD72FA4E655F2F00EE9B34", hash_generated_method = "B1AD2CC25FCD72FA4E655F2F00EE9B34")
    
void createHandler() {
        mEventHandler.createHandler();
    }
}

