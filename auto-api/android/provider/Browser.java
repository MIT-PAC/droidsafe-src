package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.805 -0400", hash_original_method = "F46FC621F05426D7CCA75DBE6F974ADA", hash_generated_method = "F46FC621F05426D7CCA75DBE6F974ADA")
        public Browser ()
    {
    }


        public static final void saveBookmark(Context c, 
                                          String title, 
                                          String url) {
        Intent i = new Intent(Intent.ACTION_INSERT, Browser.BOOKMARKS_URI);
        i.putExtra("title", title);
        i.putExtra("url", url);
        c.startActivity(i);
    }

    
        public static final void sendString(Context context, String string) {
        sendString(context, string, context.getString(com.android.internal.R.string.sendText));
    }

    
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

    
        public static final Cursor getAllBookmarks(ContentResolver cr) throws IllegalStateException {
        return cr.query(Bookmarks.CONTENT_URI,
                new String[] { Bookmarks.URL }, 
                Bookmarks.IS_FOLDER + " = 0", null, null);
    }

    
        public static final Cursor getAllVisitedUrls(ContentResolver cr) throws IllegalStateException {
        return cr.query(Combined.CONTENT_URI,
                new String[] { Combined.URL }, null, null,
                Combined.DATE_CREATED + " ASC");
    }

    
        private static final void addOrUrlEquals(StringBuilder sb) {
        sb.append(" OR " + BookmarkColumns.URL + " = ");
    }

    
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

    
        public static final void clearHistory(ContentResolver cr) {
        deleteHistoryWhere(cr, null);
    }

    
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

    
        public static final void deleteFromHistory(ContentResolver cr, 
                                               String url) {
        cr.delete(History.CONTENT_URI, History.URL + "=?", new String[] { url });
    }

    
        public static final void addSearchUrl(ContentResolver cr, String search) {
        ContentValues values = new ContentValues();
        values.put(Searches.SEARCH, search);
        values.put(Searches.DATE, System.currentTimeMillis());
        cr.insert(Searches.CONTENT_URI, values);
    }

    
        public static final void clearSearches(ContentResolver cr) {
        try {
            cr.delete(Searches.CONTENT_URI, null, null);
        } catch (IllegalStateException e) {
            Log.e(LOGTAG, "clearSearches", e);
        }
    }

    
        public static final void requestAllIcons(ContentResolver cr, String where,
            WebIconDatabase.IconListener listener) {
        WebIconDatabase.getInstance().bulkRequestIconForPageUrl(cr, where, listener);
    }

    
    public static class BookmarkColumns implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.809 -0400", hash_original_method = "18862204B8A30EB3021D7FD4C02021AE", hash_generated_method = "18862204B8A30EB3021D7FD4C02021AE")
                public BookmarkColumns ()
        {
        }


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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.809 -0400", hash_original_method = "F725C664A14296AB7A0BFE62B41183C5", hash_generated_method = "F725C664A14296AB7A0BFE62B41183C5")
                public SearchColumns ()
        {
        }


        @Deprecated public static final String URL = "url";
        public static final String SEARCH = "search";
        public static final String DATE = "date";
    }


    
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
}

