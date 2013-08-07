package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.Cursor;
import java.net.URISyntaxException;
import android.content.Intent;
import android.util.Log;
import android.content.Context;
import android.provider.Settings;
import android.view.KeyEvent;
import android.database.ContentObserver;
import android.view.KeyCharacterMap;
import android.util.SparseArray;
import android.os.Handler;
class ShortcutManager extends ContentObserver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.182 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.182 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.183 -0400", hash_original_field = "0E95B0CC64EF0B729E849D443DA61FFA", hash_generated_field = "94CDD4CE703492DE0D9982794A55B5DF")

    private SparseArray<Intent> mShortcutIntents;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.183 -0400", hash_original_method = "77CDC2E8063495E0242DECD3C4557BE8", hash_generated_method = "A935418562050E5C3B3A25D2F3409DC6")
    public  ShortcutManager(Context context, Handler handler) {
        super(handler);
        addTaint(handler.getTaint());
        addTaint(context.getTaint());
mContext=contextmShortcutIntents=new SparseArray<Intent>()
        // ---------- Original Method ----------
        //mContext = context;
        //mShortcutIntents = new SparseArray<Intent>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.184 -0400", hash_original_method = "D5E8E70B95F123F6E11F7479A75FAE3A", hash_generated_method = "64024BD020EAC0AF18DFAC79BBE1384B")
    public void observe() {
mCursor=mContext.getContentResolver().query(Settings.Bookmarks.CONTENT_URI, sProjection, null, null, null)mCursor.registerContentObserver(this)updateShortcuts()
        // ---------- Original Method ----------
        //mCursor = mContext.getContentResolver().query(
                //Settings.Bookmarks.CONTENT_URI, sProjection, null, null, null);
        //mCursor.registerContentObserver(this);
        //updateShortcuts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.184 -0400", hash_original_method = "13E8E09B4416FC749F60A949BAEA9F3C", hash_generated_method = "0E5464D9056535DCB21EA823A4559A7D")
    @Override
    public void onChange(boolean selfChange) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(selfChange);
updateShortcuts()
        // ---------- Original Method ----------
        //updateShortcuts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.185 -0400", hash_original_method = "6D4361E8959EDED57DBC397879982D5B", hash_generated_method = "F3663C033DB19D9EFA38376A17738D68")
    private void updateShortcuts() {
        Cursor c = mCursor;
        if(!c.requery())        
        {
            return;
        } //End block
mShortcutIntents.clear()        while
(c.moveToNext())        
        {
            int shortcut = c.getInt(COLUMN_SHORTCUT);
            if(shortcut==0)            
            continue;
            String intentURI = c.getString(COLUMN_INTENT);
            Intent intent = null;
            try 
            {
intent=Intent.getIntent(intentURI)
            } //End block
            catch (URISyntaxException e)
            {
            } //End block
            if(intent==null)            
            continue;
mShortcutIntents.put(shortcut, intent)
        } //End block
        // ---------- Original Method ----------
        //Cursor c = mCursor;
        //if (!c.requery()) {
            //Log.e(TAG, "ShortcutObserver could not re-query shortcuts.");
            //return;
        //}
        //mShortcutIntents.clear();
        //while (c.moveToNext()) {
            //int shortcut = c.getInt(COLUMN_SHORTCUT);
            //if (shortcut == 0) continue;
            //String intentURI = c.getString(COLUMN_INTENT);
            //Intent intent = null;
            //try {
                //intent = Intent.getIntent(intentURI);
            //} catch (URISyntaxException e) {
                //Log.w(TAG, "Intent URI for shortcut invalid.", e);
            //}
            //if (intent == null) continue;
            //mShortcutIntents.put(shortcut, intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.186 -0400", hash_original_method = "CA1FBD2768BD210E925D51F49475A643", hash_generated_method = "5313150BAB8128C97ED09E4CBBB5916D")
    public Intent getIntent(KeyCharacterMap kcm, int keyCode, int metaState) {
        addTaint(metaState);
        addTaint(keyCode);
        addTaint(kcm.getTaint());
        Intent intent = null;
        int shortcut = kcm.get(keyCode, metaState);
        if(shortcut!=0)        
        {
intent=mShortcutIntents.get(shortcut)
        } //End block
        if(intent==null)        
        {
shortcut=Character.toLowerCase(kcm.getDisplayLabel(keyCode))            if(shortcut!=0)            
            {
intent=mShortcutIntents.get(shortcut)
            } //End block
        } //End block
Intent var095937E5B36214360A2644916BF0E8DF_61114989 = intent        var095937E5B36214360A2644916BF0E8DF_61114989.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_61114989;
        // ---------- Original Method ----------
        //Intent intent = null;
        //int shortcut = kcm.get(keyCode, metaState);
        //if (shortcut != 0) {
            //intent = mShortcutIntents.get(shortcut);
        //}
        //if (intent == null) {
            //shortcut = Character.toLowerCase(kcm.getDisplayLabel(keyCode));
            //if (shortcut != 0) {
                //intent = mShortcutIntents.get(shortcut);
            //}
        //}
        //return intent;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.186 -0400", hash_original_field = "4E0AADF73FFB78F8AA3A1BD49AAFCE15", hash_generated_field = "CFF6BA25B17E1C2DCC93CA9D88DE9E98")

    private static final String TAG = "ShortcutManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.186 -0400", hash_original_field = "A17854CDABA64E2EB2155E860BFCADEB", hash_generated_field = "2A22589FBFA20583A06E9CDCF3404646")

    private static final int COLUMN_SHORTCUT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.187 -0400", hash_original_field = "D352C0F1488057231C4A8FBEE86B8168", hash_generated_field = "0EE44B3D476A398F28910F57BF8E5B14")

    private static final int COLUMN_INTENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.187 -0400", hash_original_field = "7FA318BA8400A878B6D5431054C33988", hash_generated_field = "83455371BB3AA395630B42C8984697AF")

    private static final String[] sProjection = new String;
}

