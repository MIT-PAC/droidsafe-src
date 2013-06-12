package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.BrowserContract.Bookmarks;
import android.provider.BrowserContract.Combined;
import android.provider.BrowserContract.History;
import android.provider.BrowserContract.Searches;
import android.util.Log;
import android.webkit.WebIconDatabase;

public class Browser {
    private static final String LOGTAG = "browser";
    public static final Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
    public static final String INITIAL_ZOOM_LEVEL = "browser.initialZoomLevel";
    public static final String EXTRA_APPLICATION_ID = "com.android.browser.application_id";
    public static final String EXTRA_HEADERS = "com.android.browser.headers";
    public static final String[] HISTORY_PROJECTION = new String[] {
            BookmarkColumns._ID, 
            BookmarkColumns.URL, 
            BookmarkColumns.VISITS, 
            BookmarkColumns.DATE, 
            BookmarkColumns.BOOKMARK, 
            BookmarkColumns.TITLE, 
            BookmarkColumns.FAVICON, 
            BookmarkColumns.THUMBNAIL, 
            BookmarkColumns.TOUCH_ICON, 
            BookmarkColumns.USER_ENTERED, 
    };
    public static final int HISTORY_PROJECTION_ID_INDEX = 0;
    public static final int HISTORY_PROJECTION_URL_INDEX = 1;
    public static final int HISTORY_PROJECTION_VISITS_INDEX = 2;
    public static final int HISTORY_PROJECTION_DATE_INDEX = 3;
    public static final int HISTORY_PROJECTION_BOOKMARK_INDEX = 4;
    public static final int HISTORY_PROJECTION_TITLE_INDEX = 5;
    public static final int HISTORY_PROJECTION_FAVICON_INDEX = 6;
    public static final int HISTORY_PROJECTION_THUMBNAIL_INDEX = 7;
    public static final int HISTORY_PROJECTION_TOUCH_ICON_INDEX = 8;
    public static final String[] TRUNCATE_HISTORY_PROJECTION = new String[] {
            BookmarkColumns._ID,
            BookmarkColumns.DATE,
    };
    public static final int TRUNCATE_HISTORY_PROJECTION_ID_INDEX = 0;
    public static final int TRUNCATE_N_OLDEST = 5;
    public static final Uri SEARCHES_URI = Uri.parse("content://browser/searches");
    public static final String[] SEARCHES_PROJECTION = new String[] {
            
            SearchColumns._ID, 
            SearchColumns.SEARCH, 
            SearchColumns.DATE, 
    };
    public static final int SEARCHES_PROJECTION_SEARCH_INDEX = 1;
    public static final int SEARCHES_PROJECTION_DATE_INDEX = 2;
    private static final int MAX_HISTORY_COUNT = 250;
    public static final String EXTRA_CREATE_NEW_TAB = "create_new_tab";
    public final static String EXTRA_SHARE_SCREENSHOT = "share_screenshot";
    public final static String EXTRA_SHARE_FAVICON = "share_favicon";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.090 -0400", hash_original_method = "05CB0469E06BEBC8972F8D92F854C7D5", hash_generated_method = "AA0F34F1CF918B76A7AD216B81334502")
    public static final void saveBookmark(Context c, 
                                          String title, 
                                          String url) {
        Intent i = new Intent(Intent.ACTION_INSERT, Browser.BOOKMARKS_URI);
        i.putExtra("title", title);
        i.putExtra("url", url);
        c.startActivity(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.090 -0400", hash_original_method = "F04DBF4F64C92357C727D860AE16AEA9", hash_generated_method = "C2462AC33BD3842546B4A0F1E024D433")
    public static final void sendString(Context context, String string) {
        sendString(context, string, context.getString(com.android.internal.R.string.sendText));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.090 -0400", hash_original_method = "A937CDF4977A6CFA8A3A1B3C5B973338", hash_generated_method = "AE9A6C8C7FCE686FF1844681B35DA017")
    public static final void sendString(Context c,
                                        String stringToSend,
                                        String chooserDialogTitle) {
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("text/plain");
        send.putExtra(Intent.EXTRA_TEXT, stringToSend);
        try {
            Intent i = Intent.createChooser(send, chooserDialogTitle);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(i);
        } catch(android.content.ActivityNotFoundException ex) {
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.091 -0400", hash_original_method = "23BF8CED94B64B71292C995ACA08CA5B", hash_generated_method = "ABAE2B507094051FF5AFFB1400CCAB49")
    public static final Cursor getAllBookmarks(ContentResolver cr) throws IllegalStateException {
        return cr.query(Bookmarks.CONTENT_URI,
                new String[] { Bookmarks.URL }, 
                Bookmarks.IS_FOLDER + " = 0", null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.091 -0400", hash_original_method = "1C34E1025D9BC4CE20E5F812E4CB7964", hash_generated_method = "066798A98A0074B24CF48F0C0D8D8823")
    public static final Cursor getAllVisitedUrls(ContentResolver cr) throws IllegalStateException {
        return cr.query(Combined.CONTENT_URI,
                new String[] { Combined.URL }, null, null,
                Combined.DATE_CREATED + " ASC");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.091 -0400", hash_original_method = "CC1F18686D571794573EDA6311E8020A", hash_generated_method = "7976A57CB4C544C23F7AA2BA7142D68E")
    private static final void addOrUrlEquals(StringBuilder sb) {
        sb.append(" OR " + BookmarkColumns.URL + " = ");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.091 -0400", hash_original_method = "4F321025619AA8AE460AC99A6910FF7C", hash_generated_method = "E2B330AC174A03167EC6F51CADB52D2F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.091 -0400", hash_original_method = "2ED29FEE8D5C9E40AA00A7CBA9632197", hash_generated_method = "61C070AF1F99884EE78554B95D0A5762")
    public static final void updateVisitedHistory(ContentResolver cr,
                                                  String url, boolean real) {
        long now = System.currentTimeMillis();
        Cursor c = null;
        try {
            c = getVisitedLike(cr, url);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.091 -0400", hash_original_method = "26718D5F7CBBEBA2A18502A7EAB90E54", hash_generated_method = "A62CC9FC8896E9F46A9A6269E28A1C3E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.091 -0400", hash_original_method = "E3A3246963A2B7CBA6AAB28D568E8371", hash_generated_method = "0803DE0E2DC5205D07F07C02542AE6FD")
    public static final void truncateHistory(ContentResolver cr) {
        Cursor cursor = null;
        try {
            cursor = cr.query(History.CONTENT_URI,
                    new String[] { History._ID, History.URL, History.DATE_LAST_VISITED },
                    null, null, History.DATE_LAST_VISITED + " ASC");
            if (cursor.moveToFirst() && cursor.getCount() >= MAX_HISTORY_COUNT) {
                final WebIconDatabase iconDb = WebIconDatabase.getInstance();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "B83C8E009AAE1DCC01BF6B4C31BA99E0", hash_generated_method = "B4C3BBF546F10FF92ADD4F9A12F851F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "388E8C0C4CF414D3FC7BD42E270D6F1B", hash_generated_method = "479F4B4474DB9337B23C07B7FBDD1FB9")
    public static final void clearHistory(ContentResolver cr) {
        deleteHistoryWhere(cr, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "1F6C0758F6A5058B5FD6EF87FF0282F3", hash_generated_method = "62A2D45B725D46381D5DBFC5A8121266")
    private static final void deleteHistoryWhere(ContentResolver cr, String whereClause) {
        Cursor cursor = null;
        try {
            cursor = cr.query(History.CONTENT_URI, new String[] { History.URL }, whereClause,
                    null, null);
            if (cursor.moveToFirst()) {
                final WebIconDatabase iconDb = WebIconDatabase.getInstance();
                do {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "3A349447F7FA279321C2A6BECD4CA156", hash_generated_method = "A019D5813C4F45D46BEBA23A7BC06A18")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "6B68E87B888DD9D6ED1A773FDA2B8FC5", hash_generated_method = "4845A75EEC80670590C2715D0C5D546F")
    public static final void deleteFromHistory(ContentResolver cr, 
                                               String url) {
        cr.delete(History.CONTENT_URI, History.URL + "=?", new String[] { url });
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "A993CF70E193B53B1DE5C8850E081FA1", hash_generated_method = "045C791E2272B74D46EDB2812B8F7914")
    public static final void addSearchUrl(ContentResolver cr, String search) {
        ContentValues values = new ContentValues();
        values.put(Searches.SEARCH, search);
        values.put(Searches.DATE, System.currentTimeMillis());
        cr.insert(Searches.CONTENT_URI, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "A074831E238F153F12D3C6C2678D83AE", hash_generated_method = "5280FF9EF658EFBB6007FA46969C7973")
    public static final void clearSearches(ContentResolver cr) {
        try {
            cr.delete(Searches.CONTENT_URI, null, null);
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "clearSearches", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.092 -0400", hash_original_method = "293AB206029836CBBB5119708C8C5224", hash_generated_method = "887F58D5B9DB95FE8148BDE49433B9E2")
    public static final void requestAllIcons(ContentResolver cr, String where,
            WebIconDatabase.IconListener listener) {
        WebIconDatabase.getInstance().bulkRequestIconForPageUrl(cr, where, listener);
    }

    
    public static class BookmarkColumns implements BaseColumns {
        public static final String URL = "url";
        public static final String VISITS = "visits";
        public static final String DATE = "date";
        public static final String BOOKMARK = "bookmark";
        public static final String TITLE = "title";
        public static final String CREATED = "created";
        public static final String FAVICON = "favicon";
        public static final String THUMBNAIL = "thumbnail";
        public static final String TOUCH_ICON = "touch_icon";
        public static final String USER_ENTERED = "user_entered";
        
    }


    
    public static class SearchColumns implements BaseColumns {
        @Deprecated
        public static final String URL = "url";
        public static final String SEARCH = "search";
        public static final String DATE = "date";
        
    }


    
}


