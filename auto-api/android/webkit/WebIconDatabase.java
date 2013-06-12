package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String LOGTAG = "WebIconDatabase";
    private static WebIconDatabase sIconDatabase;
    private final EventHandler mEventHandler = new EventHandler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.929 -0400", hash_original_method = "D97F7EFB28FBFEC67D724170FB0509C5", hash_generated_method = "ABC328E00EA77080E9011AA153ACF320")
    @DSModeled(DSC.SAFE)
    private WebIconDatabase() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.929 -0400", hash_original_method = "3087EA5DA62EA4F11A4DE20CD6A73D07", hash_generated_method = "9F808229B1925BEE8D9EE54E343C0678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void open(String path) {
        dsTaint.addTaint(path);
        {
            File db;
            db = new File(path);
            {
                boolean varB622938D402E011904848985C78EB22E_1983289068 = (!db.exists());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.929 -0400", hash_original_method = "331AABE14B3E5742E4C5E7CDDA5A9C2E", hash_generated_method = "F1C1E4BC94064C81991C23CE3364FB9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.CLOSE));
        // ---------- Original Method ----------
        //mEventHandler.postMessage(
                //Message.obtain(null, EventHandler.CLOSE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.929 -0400", hash_original_method = "A85BFB776007018F103CC92C345AF37F", hash_generated_method = "1C46E62F36BD69B9C9228AFC6F0A47A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllIcons() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.REMOVE_ALL));
        // ---------- Original Method ----------
        //mEventHandler.postMessage(
                //Message.obtain(null, EventHandler.REMOVE_ALL));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.929 -0400", hash_original_method = "794C674767A8A815CC73A4F95B03095B", hash_generated_method = "09BAEB2CE3A6AC9206CE14AA2B327EE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestIconForPageUrl(String url, IconListener listener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "7ACE864BB2DE1EE9743E78ECD884C38E", hash_generated_method = "60DBE19802653F3FC5FC6014590DADBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bulkRequestIconForPageUrl(ContentResolver cr, String where,
            IconListener listener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cr.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(where);
        {
            boolean var46D479A9F8E9FE39318F478CD5FAD643_1727114557 = (mEventHandler.hasHandler());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "4FB0334B2FC007108F7A611624721C63", hash_generated_method = "5E0AD288E4C5C35FADC62CB5466D2827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void retainIconForPageUrl(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "742C1A356F3DFC35D629978FF2508090", hash_generated_method = "822F97DAE80861E09D987C0736ADD180")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void releaseIconForPageUrl(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "4E10B7DC211B271410E858DC486E4F74", hash_generated_method = "7BA6E0B9D54168A708F19BB300E65904")
    public static WebIconDatabase getInstance() {
        if (sIconDatabase == null) {
            sIconDatabase = new WebIconDatabase();
        }
        return sIconDatabase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "B1AD2CC25FCD72FA4E655F2F00EE9B34", hash_generated_method = "20EEEF6629B4C2E21C0CDFB5E9F80508")
    @DSModeled(DSC.SAFE)
     void createHandler() {
        mEventHandler.createHandler();
        // ---------- Original Method ----------
        //mEventHandler.createHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "09DB41E915458842B66716A0F4A99298", hash_generated_method = "279C52AD6C2DD0481083FB4E918F34F7")
    private static void nativeOpen(String path) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "05CE1FD565A687411AE79788D0AD3AC0", hash_generated_method = "8EE85F915A6968E7323D3B181ABF3E16")
    private static void nativeClose() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "97348A58E6F3F441F5641A708F990E53", hash_generated_method = "5DEC1CD32704B254EA327B3096C31C29")
    private static void nativeRemoveAllIcons() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "7A9F29B2861B02F7FC3392BEC615F1CE", hash_generated_method = "46EB9442FBB5752F2C2945C2B14AFC07")
    private static Bitmap nativeIconForPageUrl(String url) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "2C00D0447EBAC3016EE45074237E9738", hash_generated_method = "EFFB3158D07A81A014574B48DB9444A3")
    private static void nativeRetainIconForPageUrl(String url) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "37E8D938E87B68417ABA379E40BEC4F3", hash_generated_method = "23AF527C61229738B13BDD1A48F08EF5")
    private static void nativeReleaseIconForPageUrl(String url) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    private static class EventHandler extends Handler {
        static final int OPEN         = 0;
        static final int CLOSE        = 1;
        static final int REMOVE_ALL   = 2;
        static final int REQUEST_ICON = 3;
        static final int RETAIN_ICON  = 4;
        static final int RELEASE_ICON = 5;
        static final int BULK_REQUEST_ICON = 6;
        private static final int ICON_RESULT = 10;
        private Handler mHandler;
        private Vector<Message> mMessages = new Vector<Message>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "933A9372A0E78DFEA9569EC4FAF2FF2F", hash_generated_method = "4F234A21E3A4B5DB36A8E8E22AB4C329")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "93C53855D8E83D18C38BE52A1D7D3DDC", hash_generated_method = "80B51728114C920A6BEE7BA8ADF032A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private synchronized void createHandler() {
            {
                mHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.930 -0400", hash_original_method = "9D0DE68A4BFD007DC242C5FC5FA57FA9", hash_generated_method = "DF5E144838FD47816CA1E629DAEAB2D5")
        @DSModeled(DSC.SAFE)
        private synchronized boolean hasHandler() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mHandler != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.931 -0400", hash_original_method = "4B2498A7504C7636E794F105FA929903", hash_generated_method = "D244E9CACDD60DECE0CB5C7C3A8AAB55")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.931 -0400", hash_original_method = "14DAA8F1389B41CD064DE9C446247235", hash_generated_method = "BB952E6601D6BF4937C180A4A364AF84")
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
                    boolean varED44997391BF703F93FF8714A8F8E209_1369045310 = (c.moveToFirst());
                    {
                        {
                            String url;
                            url = c.getString(0);
                            requestIconAndSendResult(url, listener);
                        } //End block
                        {
                            boolean varC617FF8D7663D3FF178F4C9831B26157_492570236 = (c.moveToNext());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.931 -0400", hash_original_method = "FD70C30826AD390D3E7262DECFBF2A75", hash_generated_method = "39B5515AB7F03DDB68E1B7CEC4404105")
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
            private final String mUrl;
            private final Bitmap mIcon;
            private final IconListener mListener;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.931 -0400", hash_original_method = "88D8D1712732D1C320641A492AB35980", hash_generated_method = "69B9315F061BB9E2419AC8126D3FA141")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.931 -0400", hash_original_method = "0BD69C5EE78EDD047C8FC1E711DA2EA8", hash_generated_method = "2EA249CA3B2960DAC899F24F110D0421")
            @DSModeled(DSC.SAFE)
             void dispatch() {
                mListener.onReceivedIcon(mUrl, mIcon);
                // ---------- Original Method ----------
                //mListener.onReceivedIcon(mUrl, mIcon);
            }

            
        }


        
    }


    
    public interface IconListener {
        
        public void onReceivedIcon(String url, Bitmap icon);
    }
    
}


