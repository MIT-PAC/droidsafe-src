package android.provider;

// Droidsafe Imports
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
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class Browser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.002 -0400", hash_original_method = "B2A4FF14215B3ADDA31B48F394E70575", hash_generated_method = "B2A4FF14215B3ADDA31B48F394E70575")
    public Browser ()
    {
        //Synthesized constructor
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.007 -0400", hash_original_method = "F477E31945C7D2DE3BB9433F18AA1C9B", hash_generated_method = "F477E31945C7D2DE3BB9433F18AA1C9B")
        public BookmarkColumns ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.007 -0400", hash_original_field = "EB4F25E00531307AAF116949A9E3C17E", hash_generated_field = "D4B533878C2C6A734F3A7F2C927B92AE")

        public static final String URL = "url";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.007 -0400", hash_original_field = "46F997AC68C0D359A69627B1E9B638A2", hash_generated_field = "B9FABE931FD0773FB5B45208C26CE7D5")

        public static final String VISITS = "visits";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.007 -0400", hash_original_field = "F0E69C8EA78964FE5493D0AE61D90B08", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.007 -0400", hash_original_field = "1299A1A8B7AE6D578EFB7A18ED1B8D5F", hash_generated_field = "9FD6A7A19D0AC27AC026CD95BD2DC180")

        public static final String BOOKMARK = "bookmark";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "9E269B31B78A189F060D2477A999115E", hash_generated_field = "CC2A30295F4B54C534C25CFD7CF431A8")

        public static final String TITLE = "title";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "6A91EB9F59E20D569DE4AD744DA221D4", hash_generated_field = "0F4705AFFEC18F07821A3C1EE6976D2F")

        public static final String CREATED = "created";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "11E7ECA263C8512A3945ED11B3BCD53D", hash_generated_field = "40F0D5892EFD121081488EA37F91796D")

        public static final String FAVICON = "favicon";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "9C2BC3BD68E49611273E3724400B7FC7", hash_generated_field = "2D8D694285B49596C90ABC91D6E607BF")

        public static final String THUMBNAIL = "thumbnail";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "70663E0A0DDE113F1EE9A15BFBEAE4CA", hash_generated_field = "CC3166006671547CADE77ABE8FB3D6F7")

        public static final String TOUCH_ICON = "touch_icon";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "A6D919E32309929C0F4D40BEB1F83134", hash_generated_field = "50794F3CE6D238AA789E24FD26D8671A")

        public static final String USER_ENTERED = "user_entered";
    }


    
    public static class SearchColumns implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_method = "AD4AB7ABF1D748D8E2B97CBDABE5BB4B", hash_generated_method = "AD4AB7ABF1D748D8E2B97CBDABE5BB4B")
        public SearchColumns ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "EB4F25E00531307AAF116949A9E3C17E", hash_generated_field = "5D63C2FA270EB949351722671D81CB69")

        @Deprecated
        public static final String URL = "url";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "A4D3382BC0DFD72731E9EE63C90DA839", hash_generated_field = "FED10D8306AFD8BF2F59B1EAF3D09D65")

        public static final String SEARCH = "search";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "F0E69C8EA78964FE5493D0AE61D90B08", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "4CDFCDDC2AC3F867A722992B4ED32022", hash_generated_field = "AB95A4C9380218C135F9857A6B666B57")

    private static final String LOGTAG = "browser";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "69E5A314E8112FAD896B0FE51FEF9176", hash_generated_field = "7F308C41A2D9FDE61AE2A455122FF052")

    public static final Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "7D0FEA1A3002707CC175ABAFDD0C2D95", hash_generated_field = "6F099D17A5039FDDF3EBAFF874D9032A")

    public static final String INITIAL_ZOOM_LEVEL = "browser.initialZoomLevel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "BDE21026B619D8AE19193177B4F859F5", hash_generated_field = "C4B0A7BA0AE0409E3CFE12E31E65B57C")

    public static final String EXTRA_APPLICATION_ID = "com.android.browser.application_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "6F093894CD5E0D1FDAC863CA47646FEE", hash_generated_field = "B7EE8F98AD2A359713E65D544C27BFC4")

    public static final String EXTRA_HEADERS = "com.android.browser.headers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "F3A99B2244F06B11672B8648D351A638", hash_generated_field = "24622DA4A8DC698D2871197678A1738B")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.008 -0400", hash_original_field = "5F0E259889A437D57E25DD573AAC8B49", hash_generated_field = "37FFEA9DF2B396DB97DB268E45356E30")

    public static final int HISTORY_PROJECTION_ID_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "2127A965BF65F37B93EA0BF2EB9E7D9F", hash_generated_field = "F7D8134B6F06BE565B0E8485ADD1FC06")

    public static final int HISTORY_PROJECTION_URL_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "AC3475479217E5A5EC8EE69DBABD34D8", hash_generated_field = "2D4C9707143B5829EA4E3973EC30C045")

    public static final int HISTORY_PROJECTION_VISITS_INDEX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "5F24F79D6D966E8FAE657833A3F0D19B", hash_generated_field = "6C668B297B8A0E33D11429EB536841D6")

    public static final int HISTORY_PROJECTION_DATE_INDEX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "E1F232021665729755EFBB4CE6A4CA53", hash_generated_field = "DC45989F32802B337078DDC5DC733CF9")

    public static final int HISTORY_PROJECTION_BOOKMARK_INDEX = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "BACDBC8B099F601CECFCD37C7066BF15", hash_generated_field = "E04B719B1451BC26139BDD659CA17409")

    public static final int HISTORY_PROJECTION_TITLE_INDEX = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "33193C8A81A571F5C2DE94CB69BD095C", hash_generated_field = "2E8C84CA82D5D3597707CA910DE3768A")

    public static final int HISTORY_PROJECTION_FAVICON_INDEX = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "DAF66A8C2EF5B3E6910D33381DAF1034", hash_generated_field = "27A6B20A21B6CB22CD498653CD7422F4")

    public static final int HISTORY_PROJECTION_THUMBNAIL_INDEX = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "2DC205AABB5C569360C6E8308CD14B70", hash_generated_field = "FC3B7E09E27311FEE99954AE56DE796B")

    public static final int HISTORY_PROJECTION_TOUCH_ICON_INDEX = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "3A816393053CF305BAA540FC48FC1F16", hash_generated_field = "38DEA6F29ADD33911E14851BCA3191B2")

    public static final String[] TRUNCATE_HISTORY_PROJECTION = new String[] {
            BookmarkColumns._ID,
            BookmarkColumns.DATE,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "6C5C3BDC4DD490A7974AAADA72D567B4", hash_generated_field = "06E26CC9D35A26BA9C8C79D7FCAE260F")

    public static final int TRUNCATE_HISTORY_PROJECTION_ID_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "EF2C53DB33C2287ABE91D4B2C0677BFA", hash_generated_field = "B86AD1698DC59B89082AF8FA951227C7")

    public static final int TRUNCATE_N_OLDEST = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "DBF6D8BD481CBAC2F378CF7CBB6EEB68", hash_generated_field = "0726596ABD7F56882B58EFA91EDD5C4C")

    public static final Uri SEARCHES_URI = Uri.parse("content://browser/searches");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "16B4453A394F69B1F1D5D4E68D576672", hash_generated_field = "9CC9798CF13A5D823AEC1473869EA838")

    public static final String[] SEARCHES_PROJECTION = new String[] {
            
            SearchColumns._ID, 
            SearchColumns.SEARCH, 
            SearchColumns.DATE, 
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "46E130BEC5FD9868629EACC72AD3D59B", hash_generated_field = "9C3F2C8B16C58376904B651C1693E93A")

    public static final int SEARCHES_PROJECTION_SEARCH_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "1E825FFE7E52185DDF138029ABE24165", hash_generated_field = "80CA1F6FDFD5979E2C7880875A4869B1")

    public static final int SEARCHES_PROJECTION_DATE_INDEX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "2AAA1497EC54D64B6CA370EB4B59B53C", hash_generated_field = "BF6486DDBD625F035F5DD77BB5F2FE07")

    private static final int MAX_HISTORY_COUNT = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "9E448F2445291904C24793F8302214DC", hash_generated_field = "9D7855A05D34C628DAFA8756F214D22F")

    public static final String EXTRA_CREATE_NEW_TAB = "create_new_tab";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.009 -0400", hash_original_field = "472F565170C78281B1D379691C4575DB", hash_generated_field = "6CA5D4AC37B1C013B661A6B3B9BEBBE3")

    public final static String EXTRA_SHARE_SCREENSHOT = "share_screenshot";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.010 -0400", hash_original_field = "6B30863E08211264F98497F781921807", hash_generated_field = "AA63208C0DA81F69E3ED3A794F5D4D4E")

    public final static String EXTRA_SHARE_FAVICON = "share_favicon";
}

