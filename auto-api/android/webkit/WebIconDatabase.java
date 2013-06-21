package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

public final class WebIconDatabase {
    private EventHandler mEventHandler = new EventHandler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.010 -0400", hash_original_method = "D97F7EFB28FBFEC67D724170FB0509C5", hash_generated_method = "282A0D53C15427A619DE121EA3CBF850")
    @DSModeled(DSC.SAFE)
    private WebIconDatabase() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.010 -0400", hash_original_method = "3087EA5DA62EA4F11A4DE20CD6A73D07", hash_generated_method = "52CA0B715083442F7015981DF17B46EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void open(String path) {
        dsTaint.addTaint(path);
        {
            File db;
            db = new File(path);
            {
                boolean varB622938D402E011904848985C78EB22E_1129521499 = (!db.exists());
                {
                    db.mkdirs();
                } //End block
            } //End collapsed parenthetic
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.OPEN, db.getAbsolutePath()));
        } //End block
        // ---------- Original Method ----------
        //if (path != null) {
            //File db = new File(path);
            //if (!db.exists()) {
                //db.mkdirs();
            //}
            //mEventHandler.postMessage(
                    //Message.obtain(null, EventHandler.OPEN, db.getAbsolutePath()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.011 -0400", hash_original_method = "331AABE14B3E5742E4C5E7CDDA5A9C2E", hash_generated_method = "A4D270AD90EEAE71E57F3A5DC98F2FC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.CLOSE));
        // ---------- Original Method ----------
        //mEventHandler.postMessage(
                //Message.obtain(null, EventHandler.CLOSE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.011 -0400", hash_original_method = "A85BFB776007018F103CC92C345AF37F", hash_generated_method = "7BDEB7DCE0A1FAA95EC131AE3AF5AB03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllIcons() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.REMOVE_ALL));
        // ---------- Original Method ----------
        //mEventHandler.postMessage(
                //Message.obtain(null, EventHandler.REMOVE_ALL));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.011 -0400", hash_original_method = "794C674767A8A815CC73A4F95B03095B", hash_generated_method = "4F96FDC368A76CAD4BADA90F3F9D9483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestIconForPageUrl(String url, IconListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(url);
        Message msg;
        msg = Message.obtain(null, EventHandler.REQUEST_ICON, listener);
        msg.getData().putString("url", url);
        mEventHandler.postMessage(msg);
        // ---------- Original Method ----------
        //if (listener == null || url == null) {
            //return;
        //}
        //Message msg = Message.obtain(null, EventHandler.REQUEST_ICON, listener);
        //msg.getData().putString("url", url);
        //mEventHandler.postMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.011 -0400", hash_original_method = "7ACE864BB2DE1EE9743E78ECD884C38E", hash_generated_method = "6B217B786F1ED35339F5A61368B17D2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bulkRequestIconForPageUrl(ContentResolver cr, String where,
            IconListener listener) {
        dsTaint.addTaint(cr.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(where);
        {
            boolean var46D479A9F8E9FE39318F478CD5FAD643_1738421766 = (mEventHandler.hasHandler());
            {
                HashMap<String, Object> map;
                map = new HashMap<String, Object>();
                map.put("contentResolver", cr);
                map.put("where", where);
                map.put("listener", listener);
                Message msg;
                msg = Message.obtain(null, EventHandler.BULK_REQUEST_ICON, map);
                mEventHandler.postMessage(msg);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (listener == null) {
            //return;
        //}
        //if (mEventHandler.hasHandler()) {
            //HashMap<String, Object> map = new HashMap<String, Object>();
            //map.put("contentResolver", cr);
            //map.put("where", where);
            //map.put("listener", listener);
            //Message msg =
                    //Message.obtain(null, EventHandler.BULK_REQUEST_ICON, map);
            //mEventHandler.postMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.011 -0400", hash_original_method = "4FB0334B2FC007108F7A611624721C63", hash_generated_method = "FF1D9BCDFE4293301C495B7CC8FF8C8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void retainIconForPageUrl(String url) {
        dsTaint.addTaint(url);
        {
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.RETAIN_ICON, url));
        } //End block
        // ---------- Original Method ----------
        //if (url != null) {
            //mEventHandler.postMessage(
                    //Message.obtain(null, EventHandler.RETAIN_ICON, url));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.012 -0400", hash_original_method = "742C1A356F3DFC35D629978FF2508090", hash_generated_method = "A13F8BE05F9DC5912CC0A9304DDF9B2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void releaseIconForPageUrl(String url) {
        dsTaint.addTaint(url);
        {
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.RELEASE_ICON, url));
        } //End block
        // ---------- Original Method ----------
        //if (url != null) {
            //mEventHandler.postMessage(
                    //Message.obtain(null, EventHandler.RELEASE_ICON, url));
        //}
    }

    
        public static WebIconDatabase getInstance() {
        if (sIconDatabase == null) {
            sIconDatabase = new WebIconDatabase();
        }
        return sIconDatabase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.012 -0400", hash_original_method = "B1AD2CC25FCD72FA4E655F2F00EE9B34", hash_generated_method = "C9CAC81B44791934BB05AC045BCDD274")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void createHandler() {
        mEventHandler.createHandler();
        // ---------- Original Method ----------
        //mEventHandler.createHandler();
    }

    
        private static void nativeOpen(String path) {
    }

    
        private static void nativeClose() {
    }

    
        private static void nativeRemoveAllIcons() {
    }

    
        private static Bitmap nativeIconForPageUrl(String url) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static void nativeRetainIconForPageUrl(String url) {
    }

    
        private static void nativeReleaseIconForPageUrl(String url) {
    }

    
    private static class EventHandler extends Handler {
        private Handler mHandler;
        private Vector<Message> mMessages = new Vector<Message>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.013 -0400", hash_original_method = "A6B283281D2E30FEC9C27B06A0776A9C", hash_generated_method = "A6B283281D2E30FEC9C27B06A0776A9C")
                public EventHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.013 -0400", hash_original_method = "933A9372A0E78DFEA9569EC4FAF2FF2F", hash_generated_method = "E0C15EE9824E6CEDC684173D91D506D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case ICON_RESULT 
            ((IconResult) msg.obj).dispatch();
            //End case ICON_RESULT 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case ICON_RESULT:
                    //((IconResult) msg.obj).dispatch();
                    //break;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.014 -0400", hash_original_method = "93C53855D8E83D18C38BE52A1D7D3DDC", hash_generated_method = "62E5803FC35A5F84227335C9872EF637")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void createHandler() {
            {
                mHandler = new Handler() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.014 -0400", hash_original_method = "3C22CFB4454B8CCB86512982F7DADD26", hash_generated_method = "5C5C40A50EE641C2AC60C775056A583B")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void handleMessage(Message msg) {
                        dsTaint.addTaint(msg.dsTaint);
                        //Begin case OPEN 
                        nativeOpen((String) msg.obj);
                        //End case OPEN 
                        //Begin case CLOSE 
                        nativeClose();
                        //End case CLOSE 
                        //Begin case REMOVE_ALL 
                        nativeRemoveAllIcons();
                        //End case REMOVE_ALL 
                        //Begin case REQUEST_ICON 
                        IconListener l;
                        l = (IconListener) msg.obj;
                        //End case REQUEST_ICON 
                        //Begin case REQUEST_ICON 
                        String url;
                        url = msg.getData().getString("url");
                        //End case REQUEST_ICON 
                        //Begin case REQUEST_ICON 
                        requestIconAndSendResult(url, l);
                        //End case REQUEST_ICON 
                        //Begin case BULK_REQUEST_ICON 
                        bulkRequestIcons(msg);
                        //End case BULK_REQUEST_ICON 
                        //Begin case RETAIN_ICON 
                        nativeRetainIconForPageUrl((String) msg.obj);
                        //End case RETAIN_ICON 
                        //Begin case RELEASE_ICON 
                        nativeReleaseIconForPageUrl((String) msg.obj);
                        //End case RELEASE_ICON 
                        // ---------- Original Method ----------
                        // Original Method Too Long, Refer to Original Implementation
                    }
};
                {
                    int size;
                    size = mMessages.size();
                    {
                        mHandler.sendMessage(mMessages.remove(0));
                    } //End block
                } //End collapsed parenthetic
                mMessages = null;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.014 -0400", hash_original_method = "9D0DE68A4BFD007DC242C5FC5FA57FA9", hash_generated_method = "0C0D3CEE1521A4E77D3114E4DBDC0F12")
        @DSModeled(DSC.SAFE)
        private synchronized boolean hasHandler() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mHandler != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.015 -0400", hash_original_method = "4B2498A7504C7636E794F105FA929903", hash_generated_method = "FC39336D5BA1355C29E1DFC1376F4332")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void postMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                mMessages.add(msg);
            } //End block
            {
                mHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //if (mMessages != null) {
                //mMessages.add(msg);
            //} else {
                //mHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.015 -0400", hash_original_method = "14DAA8F1389B41CD064DE9C446247235", hash_generated_method = "2A9FD38FE61D0D909F982C1AE555CC1F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void bulkRequestIcons(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            HashMap map;
            map = (HashMap) msg.obj;
            IconListener listener;
            listener = (IconListener) map.get("listener");
            ContentResolver cr;
            cr = (ContentResolver) map.get("contentResolver");
            String where;
            where = (String) map.get("where");
            Cursor c;
            c = null;
            try 
            {
                c = cr.query(
                        Browser.BOOKMARKS_URI,
                        new String[] { Browser.BookmarkColumns.URL },
                        where, null, null);
                {
                    boolean varED44997391BF703F93FF8714A8F8E209_809947736 = (c.moveToFirst());
                    {
                        {
                            String url;
                            url = c.getString(0);
                            requestIconAndSendResult(url, listener);
                        } //End block
                        {
                            boolean varC617FF8D7663D3FF178F4C9831B26157_1532274906 = (c.moveToNext());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            { }
            finally 
            {
                c.close();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.015 -0400", hash_original_method = "FD70C30826AD390D3E7262DECFBF2A75", hash_generated_method = "298F9B2FDBAC8968A9A5D5ABAFC88397")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void requestIconAndSendResult(String url, IconListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(url);
            Bitmap icon;
            icon = nativeIconForPageUrl(url);
            {
                sendMessage(obtainMessage(ICON_RESULT,
                            new IconResult(url, icon, listener)));
            } //End block
            // ---------- Original Method ----------
            //Bitmap icon = nativeIconForPageUrl(url);
            //if (icon != null) {
                //sendMessage(obtainMessage(ICON_RESULT,
                            //new IconResult(url, icon, listener)));
            //}
        }

        
        private class IconResult {
            private String mUrl;
            private Bitmap mIcon;
            private IconListener mListener;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.015 -0400", hash_original_method = "88D8D1712732D1C320641A492AB35980", hash_generated_method = "DD3D8B8FDCBBBA76213B4457EC8641DA")
            @DSModeled(DSC.SAFE)
             IconResult(String url, Bitmap icon, IconListener l) {
                dsTaint.addTaint(icon.dsTaint);
                dsTaint.addTaint(l.dsTaint);
                dsTaint.addTaint(url);
                // ---------- Original Method ----------
                //mUrl = url;
                //mIcon = icon;
                //mListener = l;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.016 -0400", hash_original_method = "0BD69C5EE78EDD047C8FC1E711DA2EA8", hash_generated_method = "37E27E327CE1FC5B9184E444CD4F387F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             void dispatch() {
                mListener.onReceivedIcon(mUrl, mIcon);
                // ---------- Original Method ----------
                //mListener.onReceivedIcon(mUrl, mIcon);
            }

            
        }


        
        static final int OPEN         = 0;
        static final int CLOSE        = 1;
        static final int REMOVE_ALL   = 2;
        static final int REQUEST_ICON = 3;
        static final int RETAIN_ICON  = 4;
        static final int RELEASE_ICON = 5;
        static final int BULK_REQUEST_ICON = 6;
        private static final int ICON_RESULT = 10;
    }


    
    public interface IconListener {
        
        public void onReceivedIcon(String url, Bitmap icon);
    }
    
    private static final String LOGTAG = "WebIconDatabase";
    private static WebIconDatabase sIconDatabase;
}

