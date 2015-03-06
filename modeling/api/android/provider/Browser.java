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


package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.provider.BrowserContract.Bookmarks;
import android.provider.BrowserContract.Combined;
import android.provider.BrowserContract.History;
import android.provider.BrowserContract.Searches;
import android.util.Log;
import android.webkit.WebIconDatabase;

public class Browser {

    /**
     *  Open an activity to save a bookmark. Launch with a title
     *  and/or a url, both of which can be edited by the user before saving.
     *
     *  @param c        Context used to launch the activity to add a bookmark.
     *  @param title    Title for the bookmark. Can be null or empty string.
     *  @param url      Url for the bookmark. Can be null or empty string.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.629 -0500", hash_original_method = "05CB0469E06BEBC8972F8D92F854C7D5", hash_generated_method = "AA0F34F1CF918B76A7AD216B81334502")
    
public static final void saveBookmark(Context c, 
                                          String title, 
                                          String url) {
        Intent i = new Intent(Intent.ACTION_INSERT, Browser.BOOKMARKS_URI);
        i.putExtra("title", title);
        i.putExtra("url", url);
        c.startActivity(i);
    }

    /**
     * Sends the given string using an Intent with {@link Intent#ACTION_SEND} and a mime type
     * of text/plain. The string is put into {@link Intent#EXTRA_TEXT}.
     *
     * @param context the context used to start the activity
     * @param string the string to send
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.639 -0500", hash_original_method = "F04DBF4F64C92357C727D860AE16AEA9", hash_generated_method = "C2462AC33BD3842546B4A0F1E024D433")
    
public static final void sendString(Context context, String string) {
        sendString(context, string, context.getString(com.android.internal.R.string.sendText));
    }

    /**
     *  Find an application to handle the given string and, if found, invoke
     *  it with the given string as a parameter.
     *  @param c Context used to launch the new activity.
     *  @param stringToSend The string to be handled.
     *  @param chooserDialogTitle The title of the dialog that allows the user
     *  to select between multiple applications that are all capable of handling
     *  the string.
     *  @hide pending API council approval
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.641 -0500", hash_original_method = "A937CDF4977A6CFA8A3A1B3C5B973338", hash_generated_method = "C837F7FAA76CC9E5CBEA50EF512EA5E0")
    
public static final void sendString(Context c,
                                        String stringToSend,
                                        String chooserDialogTitle) {
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("text/plain");
        send.putExtra(Intent.EXTRA_TEXT, stringToSend);

        try {
            Intent i = Intent.createChooser(send, chooserDialogTitle);
            // In case this is called from outside an Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(i);
        } catch(android.content.ActivityNotFoundException ex) {
            // if no app handles it, do nothing
        }
    }

    /**
     *  Return a cursor pointing to a list of all the bookmarks. The cursor will have a single
     *  column, {@link BookmarkColumns#URL}.
     *  <p>
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     *
     *  @param cr   The ContentResolver used to access the database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.645 -0500", hash_original_method = "23BF8CED94B64B71292C995ACA08CA5B", hash_generated_method = "ABAE2B507094051FF5AFFB1400CCAB49")
    
public static final Cursor getAllBookmarks(ContentResolver cr) throws 
            IllegalStateException {
        return cr.query(Bookmarks.CONTENT_URI,
                new String[] { Bookmarks.URL }, 
                Bookmarks.IS_FOLDER + " = 0", null, null);
    }

    /**
     *  Return a cursor pointing to a list of all visited site urls. The cursor will
     *  have a single column, {@link BookmarkColumns#URL}.
     *  <p>
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     *
     *  @param cr   The ContentResolver used to access the database.
     */
    @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.647 -0500", hash_original_method = "1C34E1025D9BC4CE20E5F812E4CB7964", hash_generated_method = "066798A98A0074B24CF48F0C0D8D8823")
    
public static final Cursor getAllVisitedUrls(ContentResolver cr) throws
            IllegalStateException {
        return cr.query(Combined.CONTENT_URI,
                new String[] { Combined.URL }, null, null,
                Combined.DATE_CREATED + " ASC");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.650 -0500", hash_original_method = "CC1F18686D571794573EDA6311E8020A", hash_generated_method = "7976A57CB4C544C23F7AA2BA7142D68E")
    
private static final void addOrUrlEquals(StringBuilder sb) {
        sb.append(" OR " + BookmarkColumns.URL + " = ");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.653 -0500", hash_original_method = "789FC1644556002CD63BBE379D3F91B8", hash_generated_method = "E2B330AC174A03167EC6F51CADB52D2F")
    
private static final Cursor getVisitedLike(ContentResolver cr, String url) {
        boolean secure = false;
        String compareString = url;
        if (compareString.startsWith("http://")) {
            compareString = compareString.substring(7);
        } else if (compareString.startsWith("https://")) {
            compareString = compareString.substring(8);
            secure = true;
        }
        if (compareString.startsWith("www.")) {
            compareString = compareString.substring(4);
        }
        StringBuilder whereClause = null;
        if (secure) {
            whereClause = new StringBuilder(Bookmarks.URL + " = ");
            DatabaseUtils.appendEscapedSQLString(whereClause,
                    "https://" + compareString);
            addOrUrlEquals(whereClause);
            DatabaseUtils.appendEscapedSQLString(whereClause,
                    "https://www." + compareString);
        } else {
            whereClause = new StringBuilder(Bookmarks.URL + " = ");
            DatabaseUtils.appendEscapedSQLString(whereClause,
                    compareString);
            addOrUrlEquals(whereClause);
            String wwwString = "www." + compareString;
            DatabaseUtils.appendEscapedSQLString(whereClause,
                    wwwString);
            addOrUrlEquals(whereClause);
            DatabaseUtils.appendEscapedSQLString(whereClause,
                    "http://" + compareString);
            addOrUrlEquals(whereClause);
            DatabaseUtils.appendEscapedSQLString(whereClause,
                    "http://" + wwwString);
        }
        return cr.query(History.CONTENT_URI, new String[] { History._ID, History.VISITS },
                whereClause.toString(), null, null);
    }

    /**
     *  Update the visited history to acknowledge that a site has been
     *  visited.
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     *  Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     *  @param cr   The ContentResolver used to access the database.
     *  @param url  The site being visited.
     *  @param real If true, this is an actual visit, and should add to the
     *              number of visits.  If false, the user entered it manually.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.656 -0500", hash_original_method = "2ED29FEE8D5C9E40AA00A7CBA9632197", hash_generated_method = "7781E8A0CDC61659ABD7A1430AEBF950")
    
public static final void updateVisitedHistory(ContentResolver cr,
                                                  String url, boolean real) {
        long now = System.currentTimeMillis();
        Cursor c = null;
        try {
            c = getVisitedLike(cr, url);
            /* We should only get one answer that is exactly the same. */
            if (c.moveToFirst()) {
                ContentValues values = new ContentValues();
                if (real) {
                    values.put(History.VISITS, c.getInt(1) + 1);
                } else {
                    values.put(History.USER_ENTERED, 1);
                }
                values.put(History.DATE_LAST_VISITED, now);
                cr.update(ContentUris.withAppendedId(History.CONTENT_URI, c.getLong(0)),
                        values, null, null);
            } else {
                truncateHistory(cr);
                ContentValues values = new ContentValues();
                int visits;
                int user_entered;
                if (real) {
                    visits = 1;
                    user_entered = 0;
                } else {
                    visits = 0;
                    user_entered = 1;
                }
                values.put(History.URL, url);
                values.put(History.VISITS, visits);
                values.put(History.DATE_LAST_VISITED, now);
                values.put(History.TITLE, url);
                values.put(History.DATE_CREATED, 0);
                values.put(History.USER_ENTERED, user_entered);
                cr.insert(History.CONTENT_URI, values);
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "updateVisitedHistory", e);
        } finally {
            if (c != null) c.close();
        }
    }

    /**
     *  Returns all the URLs in the history.
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     *  @param cr   The ContentResolver used to access the database.
     *  @hide pending API council approval
     */
    @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.659 -0500", hash_original_method = "26718D5F7CBBEBA2A18502A7EAB90E54", hash_generated_method = "A62CC9FC8896E9F46A9A6269E28A1C3E")
    
public static final String[] getVisitedHistory(ContentResolver cr) {
        Cursor c = null;
        String[] str = null;
        try {
            String[] projection = new String[] {
                    History.URL,
            };
            c = cr.query(History.CONTENT_URI, projection, History.VISITS + " > 0", null, null);
            if (c == null) return new String[0];
            str = new String[c.getCount()];
            int i = 0;
            while (c.moveToNext()) {
                str[i] = c.getString(0);
                i++;
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "getVisitedHistory", e);
            str = new String[0];
        } finally {
            if (c != null) c.close();
        }
        return str;
    }

    /**
     * If there are more than MAX_HISTORY_COUNT non-bookmark history
     * items in the bookmark/history table, delete TRUNCATE_N_OLDEST
     * of them.  This is used to keep our history table to a
     * reasonable size.  Note: it does not prune bookmarks.  If the
     * user wants 1000 bookmarks, the user gets 1000 bookmarks.
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     *  Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     *
     * @param cr The ContentResolver used to access the database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.661 -0500", hash_original_method = "E3A3246963A2B7CBA6AAB28D568E8371", hash_generated_method = "A3D3AF5ED241CC9BB75E42DE0DDB2D11")
    
public static final void truncateHistory(ContentResolver cr) {
        // TODO make a single request to the provider to do this in a single transaction
        Cursor cursor = null;
        try {
            
            // Select non-bookmark history, ordered by date
            cursor = cr.query(History.CONTENT_URI,
                    new String[] { History._ID, History.URL, History.DATE_LAST_VISITED },
                    null, null, History.DATE_LAST_VISITED + " ASC");

            if (cursor.moveToFirst() && cursor.getCount() >= MAX_HISTORY_COUNT) {
                final WebIconDatabase iconDb = WebIconDatabase.getInstance();
                /* eliminate oldest history items */
                for (int i = 0; i < TRUNCATE_N_OLDEST; i++) {
                    cr.delete(ContentUris.withAppendedId(History.CONTENT_URI, cursor.getLong(0)),
                            null, null);
                    iconDb.releaseIconForPageUrl(cursor.getString(1));
                    if (!cursor.moveToNext()) break;
                }
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "truncateHistory", e);
        } finally {
            if (cursor != null) cursor.close();
        }
    }

    /**
     * Returns whether there is any history to clear.
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     * @param cr   The ContentResolver used to access the database.
     * @return boolean  True if the history can be cleared.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.664 -0500", hash_original_method = "B83C8E009AAE1DCC01BF6B4C31BA99E0", hash_generated_method = "B4C3BBF546F10FF92ADD4F9A12F851F1")
    
public static final boolean canClearHistory(ContentResolver cr) {
        Cursor cursor = null;
        boolean ret = false;
        try {
            cursor = cr.query(History.CONTENT_URI,
                new String [] { History._ID, History.VISITS },
                null, null, null);
            ret = cursor.getCount() > 0;
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "canClearHistory", e);
        } finally {
            if (cursor != null) cursor.close();
        }
        return ret;
    }

    /**
     *  Delete all entries from the bookmarks/history table which are
     *  not bookmarks.  Also set all visited bookmarks to unvisited.
     *  Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     *  @param cr   The ContentResolver used to access the database.
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.666 -0500", hash_original_method = "388E8C0C4CF414D3FC7BD42E270D6F1B", hash_generated_method = "479F4B4474DB9337B23C07B7FBDD1FB9")
    
public static final void clearHistory(ContentResolver cr) {
        deleteHistoryWhere(cr, null);
    }

    /**
     * Helper function to delete all history items and release the icons for them in the
     * {@link WebIconDatabase}.
     *
     * Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     * Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     *
     * @param cr   The ContentResolver used to access the database.
     * @param whereClause   String to limit the items affected.
     *                      null means all items.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.669 -0500", hash_original_method = "1F6C0758F6A5058B5FD6EF87FF0282F3", hash_generated_method = "401EF8DE74069AF80CF65959D6B10B42")
    
private static final void deleteHistoryWhere(ContentResolver cr, String whereClause) {
        Cursor cursor = null;
        try {
            cursor = cr.query(History.CONTENT_URI, new String[] { History.URL }, whereClause,
                    null, null);
            if (cursor.moveToFirst()) {
                final WebIconDatabase iconDb = WebIconDatabase.getInstance();
                do {
                    // Delete favicons
                    // TODO don't release if the URL is bookmarked
                    iconDb.releaseIconForPageUrl(cursor.getString(0));
                } while (cursor.moveToNext());

                cr.delete(History.CONTENT_URI, whereClause, null);
            }
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "deleteHistoryWhere", e);
            return;
        } finally {
            if (cursor != null) cursor.close();
        }
    }

    /**
     * Delete all history items from begin to end.
     *  Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     * @param cr    The ContentResolver used to access the database.
     * @param begin First date to remove.  If -1, all dates before end.
     *              Inclusive.
     * @param end   Last date to remove. If -1, all dates after begin.
     *              Non-inclusive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.672 -0500", hash_original_method = "3A349447F7FA279321C2A6BECD4CA156", hash_generated_method = "A019D5813C4F45D46BEBA23A7BC06A18")
    
public static final void deleteHistoryTimeFrame(ContentResolver cr,
            long begin, long end) {
        String whereClause;
        String date = BookmarkColumns.DATE;
        if (-1 == begin) {
            if (-1 == end) {
                clearHistory(cr);
                return;
            }
            whereClause = date + " < " + Long.toString(end);
        } else if (-1 == end) {
            whereClause = date + " >= " + Long.toString(begin);
        } else {
            whereClause = date + " >= " + Long.toString(begin) + " AND " + date
                    + " < " + Long.toString(end);
        }
        deleteHistoryWhere(cr, whereClause);
    }

    /**
     * Remove a specific url from the history database.
     *  Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     * @param cr    The ContentResolver used to access the database.
     * @param url   url to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.675 -0500", hash_original_method = "6B68E87B888DD9D6ED1A773FDA2B8FC5", hash_generated_method = "4845A75EEC80670590C2715D0C5D546F")
    
public static final void deleteFromHistory(ContentResolver cr, 
                                               String url) {
        cr.delete(History.CONTENT_URI, History.URL + "=?", new String[] { url });
    }

    /**
     * Add a search string to the searches database.
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     *  Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     * @param cr   The ContentResolver used to access the database.
     * @param search    The string to add to the searches database.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.677 -0500", hash_original_method = "A993CF70E193B53B1DE5C8850E081FA1", hash_generated_method = "F21DB6E964FDD245492F72413C7D0CBB")
    
public static final void addSearchUrl(ContentResolver cr, String search) {
        // The content provider will take care of updating existing searches instead of duplicating
        ContentValues values = new ContentValues();
        values.put(Searches.SEARCH, search);
        values.put(Searches.DATE, System.currentTimeMillis());
        cr.insert(Searches.CONTENT_URI, values);
    }

    /**
     * Remove all searches from the search database.
     *  Requires {@link android.Manifest.permission#WRITE_HISTORY_BOOKMARKS}
     * @param cr   The ContentResolver used to access the database.
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.680 -0500", hash_original_method = "A074831E238F153F12D3C6C2678D83AE", hash_generated_method = "64A05DCE5B310A2FA0CFA09709FDD153")
    
public static final void clearSearches(ContentResolver cr) {
        // FIXME: Should this clear the urls to which these searches lead?
        // (i.e. remove google.com/query= blah blah blah)
        try {
            cr.delete(Searches.CONTENT_URI, null, null);
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "clearSearches", e);
        }
    }
    
    /**
     *  Request all icons from the database.  This call must either be called
     *  in the main thread or have had Looper.prepare() invoked in the calling
     *  thread.
     *  Requires {@link android.Manifest.permission#READ_HISTORY_BOOKMARKS}
     *  @param  cr The ContentResolver used to access the database.
     *  @param  where Clause to be used to limit the query from the database.
     *          Must be an allowable string to be passed into a database query.
     *  @param  listener IconListener that gets the icons once they are 
     *          retrieved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.683 -0500", hash_original_method = "293AB206029836CBBB5119708C8C5224", hash_generated_method = "887F58D5B9DB95FE8148BDE49433B9E2")
    
public static final void requestAllIcons(ContentResolver cr, String where,
            WebIconDatabase.IconListener listener) {
        WebIconDatabase.getInstance().bulkRequestIconForPageUrl(cr, where, listener);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.570 -0500", hash_original_field = "7945DE8AC52A4D82824DB6DABEBBB6A3", hash_generated_field = "AB95A4C9380218C135F9857A6B666B57")

    private static final String LOGTAG = "browser";
    
    public static class BookmarkColumns implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.686 -0500", hash_original_field = "8D1B43EDD925FB0F61F6B3415E7511F8", hash_generated_field = "D4B533878C2C6A734F3A7F2C927B92AE")

        public static final String URL = "url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.688 -0500", hash_original_field = "E893DBB93C73F0F174B7A535D18A0060", hash_generated_field = "B9FABE931FD0773FB5B45208C26CE7D5")

        public static final String VISITS = "visits";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.690 -0500", hash_original_field = "5B6FCEF8C44CB783DFFC37049083A6ED", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.693 -0500", hash_original_field = "DE85C96E921B725D7D29B4640B819A86", hash_generated_field = "9FD6A7A19D0AC27AC026CD95BD2DC180")

        public static final String BOOKMARK = "bookmark";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.695 -0500", hash_original_field = "A5249F61E8BCAFD7BA526765268E7EE8", hash_generated_field = "CC2A30295F4B54C534C25CFD7CF431A8")

        public static final String TITLE = "title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.698 -0500", hash_original_field = "911F3EABEC1FE191ACE9F7A7F389541F", hash_generated_field = "0F4705AFFEC18F07821A3C1EE6976D2F")

        public static final String CREATED = "created";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.701 -0500", hash_original_field = "B05EF3A95DD3CFBD334E3C0DD1D64638", hash_generated_field = "40F0D5892EFD121081488EA37F91796D")

        public static final String FAVICON = "favicon";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.703 -0500", hash_original_field = "1B26CE40C646496E65DFC989475EC040", hash_generated_field = "2D8D694285B49596C90ABC91D6E607BF")

        public static final String THUMBNAIL = "thumbnail";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.705 -0500", hash_original_field = "EC50C8F6ABBEAED1C8FEBA9E2FD842E0", hash_generated_field = "CC3166006671547CADE77ABE8FB3D6F7")

        public static final String TOUCH_ICON = "touch_icon";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.708 -0500", hash_original_field = "BBC25961BD999EAE86670D0510F38EBF", hash_generated_field = "50794F3CE6D238AA789E24FD26D8671A")

        public static final String USER_ENTERED = "user_entered";
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.007 -0400", hash_original_method = "F477E31945C7D2DE3BB9433F18AA1C9B", hash_generated_method = "F477E31945C7D2DE3BB9433F18AA1C9B")
        public BookmarkColumns ()
        {
            //Synthesized constructor
        }
    }
    
    public static class SearchColumns implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.713 -0500", hash_original_field = "8D1B43EDD925FB0F61F6B3415E7511F8", hash_generated_field = "5D63C2FA270EB949351722671D81CB69")

        @Deprecated
        public static final String URL = "url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.716 -0500", hash_original_field = "F9A3A3183BB01BC91F2419D4415C4CB0", hash_generated_field = "FED10D8306AFD8BF2F59B1EAF3D09D65")

        public static final String SEARCH = "search";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.718 -0500", hash_original_field = "5B6FCEF8C44CB783DFFC37049083A6ED", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_method = "AD4AB7ABF1D748D8E2B97CBDABE5BB4B", hash_generated_method = "AD4AB7ABF1D748D8E2B97CBDABE5BB4B")
        public SearchColumns ()
        {
            //Synthesized constructor
        }
    }
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "69E5A314E8112FAD896B0FE51FEF9176", hash_generated_field = "7F308C41A2D9FDE61AE2A455122FF052")

    public static final Uri BOOKMARKS_URI = new android.net.Uri("content://browser/bookmarks");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.575 -0500", hash_original_field = "F4CEB53D323A9EDC80DB33A340C90FF0", hash_generated_field = "6F099D17A5039FDDF3EBAFF874D9032A")

    public static final String INITIAL_ZOOM_LEVEL = "browser.initialZoomLevel";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.577 -0500", hash_original_field = "7C5061CED4546A16E370D68D0F07796F", hash_generated_field = "C4B0A7BA0AE0409E3CFE12E31E65B57C")

    public static final String EXTRA_APPLICATION_ID = "com.android.browser.application_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.580 -0500", hash_original_field = "6E750F34A956C7567019CC1405395C2D", hash_generated_field = "B7EE8F98AD2A359713E65D544C27BFC4")

    public static final String EXTRA_HEADERS = "com.android.browser.headers";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.583 -0500", hash_original_field = "DE3FC439DCC8CFE888E5CC6F82BE09C2", hash_generated_field = "8C12DF7C93C68D2EE02410ACF2D9C491")

    public static final String[] HISTORY_PROJECTION = new String[] {
            BookmarkColumns._ID, // 0
            BookmarkColumns.URL, // 1
            BookmarkColumns.VISITS, // 2
            BookmarkColumns.DATE, // 3
            BookmarkColumns.BOOKMARK, // 4
            BookmarkColumns.TITLE, // 5
            BookmarkColumns.FAVICON, // 6
            BookmarkColumns.THUMBNAIL, // 7
            BookmarkColumns.TOUCH_ICON, // 8
            BookmarkColumns.USER_ENTERED, // 9
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.585 -0500", hash_original_field = "B04B7E23C6BBC7A554D193DE4DCE6E43", hash_generated_field = "37FFEA9DF2B396DB97DB268E45356E30")

    public static final int HISTORY_PROJECTION_ID_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.588 -0500", hash_original_field = "6793B3C8435856C3B7FB611E270C6246", hash_generated_field = "F7D8134B6F06BE565B0E8485ADD1FC06")

    public static final int HISTORY_PROJECTION_URL_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.591 -0500", hash_original_field = "2FF62CCA9FE651074D4CEDF683DE3363", hash_generated_field = "2D4C9707143B5829EA4E3973EC30C045")

    public static final int HISTORY_PROJECTION_VISITS_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.593 -0500", hash_original_field = "2476B90E78C5547D5855E5D68E87AC8A", hash_generated_field = "6C668B297B8A0E33D11429EB536841D6")

    public static final int HISTORY_PROJECTION_DATE_INDEX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.595 -0500", hash_original_field = "6C2479F0A3FD1DD7CCB928EE96A0ABB9", hash_generated_field = "DC45989F32802B337078DDC5DC733CF9")

    public static final int HISTORY_PROJECTION_BOOKMARK_INDEX = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.598 -0500", hash_original_field = "5456FC72B825F79F4BF9B6F00A74173B", hash_generated_field = "E04B719B1451BC26139BDD659CA17409")

    public static final int HISTORY_PROJECTION_TITLE_INDEX = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.600 -0500", hash_original_field = "E3DCB11E1CB7CCD0240AE99E54B9F5EC", hash_generated_field = "2E8C84CA82D5D3597707CA910DE3768A")

    public static final int HISTORY_PROJECTION_FAVICON_INDEX = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.602 -0500", hash_original_field = "6A2B00962C21C34855016C8B7307DDEE", hash_generated_field = "27A6B20A21B6CB22CD498653CD7422F4")

    public static final int HISTORY_PROJECTION_THUMBNAIL_INDEX = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.605 -0500", hash_original_field = "E88854B54719F58CD642974CC45404C3", hash_generated_field = "FC3B7E09E27311FEE99954AE56DE796B")

    public static final int HISTORY_PROJECTION_TOUCH_ICON_INDEX = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.607 -0500", hash_original_field = "C587EDD27AAB1AA80A6FC792CD3893D7", hash_generated_field = "38DEA6F29ADD33911E14851BCA3191B2")

    public static final String[] TRUNCATE_HISTORY_PROJECTION = new String[] {
            BookmarkColumns._ID,
            BookmarkColumns.DATE,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.611 -0500", hash_original_field = "3C97A64CDD3FA513F922E8530844B5E7", hash_generated_field = "06E26CC9D35A26BA9C8C79D7FCAE260F")

    public static final int TRUNCATE_HISTORY_PROJECTION_ID_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.614 -0500", hash_original_field = "426E8B8603B2C6CA915CA795D720D971", hash_generated_field = "B86AD1698DC59B89082AF8FA951227C7")

    public static final int TRUNCATE_N_OLDEST = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.617 -0500", hash_original_field = "94DAD653159C6A59FE96EF17D6304598", hash_generated_field = "0726596ABD7F56882B58EFA91EDD5C4C")

    public static final Uri SEARCHES_URI = Uri.parse("content://browser/searches");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.619 -0500", hash_original_field = "EEE865ADECE208A96B840D2C206420E8", hash_generated_field = "5E02CA8E4544876142758D0E083BABF5")

    public static final String[] SEARCHES_PROJECTION = new String[] {
            // if you change column order you must also change indices below
            SearchColumns._ID, // 0
            SearchColumns.SEARCH, // 1
            SearchColumns.DATE, // 2
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.621 -0500", hash_original_field = "6BB417755D536C798084E31035546284", hash_generated_field = "9C3F2C8B16C58376904B651C1693E93A")

    public static final int SEARCHES_PROJECTION_SEARCH_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.624 -0500", hash_original_field = "5B70B63678EBC4965A1B6630B19739CB", hash_generated_field = "80CA1F6FDFD5979E2C7880875A4869B1")

    public static final int SEARCHES_PROJECTION_DATE_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.627 -0500", hash_original_field = "C82910879C292C21BA69457BB73148F8", hash_generated_field = "BF6486DDBD625F035F5DD77BB5F2FE07")

    private static final int MAX_HISTORY_COUNT = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.632 -0500", hash_original_field = "B08F713EE6D0AA059CFB71C5F18907CF", hash_generated_field = "9D7855A05D34C628DAFA8756F214D22F")

    public static final String EXTRA_CREATE_NEW_TAB = "create_new_tab";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.634 -0500", hash_original_field = "99D11E748F95B1609DC8A5B6C0AEC7F5", hash_generated_field = "6CA5D4AC37B1C013B661A6B3B9BEBBE3")

    public final static String EXTRA_SHARE_SCREENSHOT = "share_screenshot";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:01.637 -0500", hash_original_field = "70962799F8CEF244F122D229288D1286", hash_generated_field = "AA63208C0DA81F69E3ED3A794F5D4D4E")

    public final static String EXTRA_SHARE_FAVICON = "share_favicon";
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.002 -0400", hash_original_method = "B2A4FF14215B3ADDA31B48F394E70575", hash_generated_method = "B2A4FF14215B3ADDA31B48F394E70575")
    public Browser ()
    {
        //Synthesized constructor
    }
}

