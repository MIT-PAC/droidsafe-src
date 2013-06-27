package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.provider.Settings.System;
import android.text.*;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.text.InputType;
import java.lang.ref.WeakReference;

public class TextKeyListener extends BaseKeyListener implements SpanWatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.056 -0400", hash_original_field = "7B00CDF214A58D964DB1FD6D561A182A", hash_generated_field = "BEDDE5D3B36AFDA96122F6739A399D24")

    private Capitalize mAutoCap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.056 -0400", hash_original_field = "3D18F8DF226A678B64C4D4C4D035A79A", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.056 -0400", hash_original_field = "4A65E4AFE2E6A8567B2303B5B414D0A2", hash_generated_field = "6926B19407F5E0ECC3F4CEC11E041C87")

    private int mPrefs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.056 -0400", hash_original_field = "9977F77CE5547DA73F8036BC498B4EC9", hash_generated_field = "1D299557689B8C33CC4C3DF3BE9D5C3D")

    private boolean mPrefsInited;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.056 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "5D46AECEC0347C1327E8060B0CEDA4B8")

    private WeakReference<ContentResolver> mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.056 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "94A6065FC7822989FE2C83137CC2E2A5")

    private TextKeyListener.SettingsObserver mObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.057 -0400", hash_original_method = "9DAB45081F29D4D9259EECD11A475A04", hash_generated_method = "B59FD9AE6465D27FF27D624847BFBF79")
    public  TextKeyListener(Capitalize cap, boolean autotext) {
        mAutoCap = cap;
        mAutoText = autotext;
        // ---------- Original Method ----------
        //mAutoCap = cap;
        //mAutoText = autotext;
    }

    
        public static TextKeyListener getInstance(boolean autotext,
                                              Capitalize cap) {
        int off = cap.ordinal() * 2 + (autotext ? 1 : 0);
        if (sInstance[off] == null) {
            sInstance[off] = new TextKeyListener(cap, autotext);
        }
        return sInstance[off];
    }

    
        public static TextKeyListener getInstance() {
        return getInstance(false, Capitalize.NONE);
    }

    
        public static boolean shouldCap(Capitalize cap, CharSequence cs, int off) {
        int i;
        char c;
        if (cap == Capitalize.NONE) {
            return false;
        }
        if (cap == Capitalize.CHARACTERS) {
            return true;
        }
        return TextUtils.getCapsMode(cs, off, cap == Capitalize.WORDS
                ? TextUtils.CAP_MODE_WORDS : TextUtils.CAP_MODE_SENTENCES)
                != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.058 -0400", hash_original_method = "77B762D33BA1CBC4DB995B196C907EDB", hash_generated_method = "A9BA1A89DB91E1F821CC6F54335A01E9")
    public int getInputType() {
        int var9E11457640925EE0EF1D4E5A2BEB5EA9_1680158240 = (makeTextContentType(mAutoCap, mAutoText));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143555818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143555818;
        // ---------- Original Method ----------
        //return makeTextContentType(mAutoCap, mAutoText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.058 -0400", hash_original_method = "81E68D18E6AAF9C62286CED7FE623E2E", hash_generated_method = "2D54F223DC1702C1C8DEF5578AFF8006")
    @Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        KeyListener im;
        im = getKeyListener(event);
        boolean varF286B59ADFF6299A37098A9DB0C8357B_1358445634 = (im.onKeyDown(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21970982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_21970982;
        // ---------- Original Method ----------
        //KeyListener im = getKeyListener(event);
        //return im.onKeyDown(view, content, keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.059 -0400", hash_original_method = "4D169ED96CD6963312694BD71629C37D", hash_generated_method = "B03C49A15910D3296F35EE3562AAA0D5")
    @Override
    public boolean onKeyUp(View view, Editable content,
                           int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        KeyListener im;
        im = getKeyListener(event);
        boolean var95A6FE6B62FCC62B201DE8A79EC297F9_1476439936 = (im.onKeyUp(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1768194331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1768194331;
        // ---------- Original Method ----------
        //KeyListener im = getKeyListener(event);
        //return im.onKeyUp(view, content, keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.059 -0400", hash_original_method = "BC51D61DF5BB87B519CDA007F0E35AD4", hash_generated_method = "AC1B79D9FD23BCE7E56B904230DC9745")
    @Override
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        KeyListener im;
        im = getKeyListener(event);
        boolean varEE7D10462EE6111109AAADBA63F6F0F6_83772571 = (im.onKeyOther(view, content, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1374097789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1374097789;
        // ---------- Original Method ----------
        //KeyListener im = getKeyListener(event);
        //return im.onKeyOther(view, content, event);
    }

    
        public static void clear(Editable e) {
        e.clear();
        e.removeSpan(ACTIVE);
        e.removeSpan(CAPPED);
        e.removeSpan(INHIBIT_REPLACEMENT);
        e.removeSpan(LAST_TYPED);
        QwertyKeyListener.Replaced[] repl = e.getSpans(0, e.length(),
                                   QwertyKeyListener.Replaced.class);
        final int count = repl.length;
        for (int i = 0; i < count; i++) {
            e.removeSpan(repl[i]);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.063 -0400", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "7B286C8C34C0CB912482A9582E50ADC8")
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.063 -0400", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "F033A2BD7F1AB312500D2F37A623D63A")
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.064 -0400", hash_original_method = "C422051A9042B505708BBCABB42F0EAF", hash_generated_method = "1235A9E630F04714A1D4FE1D9F021FE3")
    public void onSpanChanged(Spannable s, Object what, int start, int end,
                              int st, int en) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            s.removeSpan(ACTIVE);
        } //End block
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(st);
        addTaint(en);
        // ---------- Original Method ----------
        //if (what == Selection.SELECTION_END) {
            //s.removeSpan(ACTIVE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.086 -0400", hash_original_method = "AD20E29A89E7D41F4894A2F9AC99B4E0", hash_generated_method = "0C74F28ECE3D054A5B529B958681381B")
    private KeyListener getKeyListener(KeyEvent event) {
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_2040379239 = null; //Variable for return #1
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_1452552985 = null; //Variable for return #2
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_474337521 = null; //Variable for return #3
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_1921262711 = null; //Variable for return #4
        KeyCharacterMap kmap;
        kmap = event.getKeyCharacterMap();
        int kind;
        kind = kmap.getKeyboardType();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2040379239 = QwertyKeyListener.getInstance(mAutoText, mAutoCap);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1452552985 = MultiTapKeyListener.getInstance(mAutoText, mAutoCap);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_474337521 = QwertyKeyListener.getInstanceForFullKeyboard();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1921262711 = NullKeyListener.getInstance();
        addTaint(event.getTaint());
        KeyListener varA7E53CE21691AB073D9660D615818899_603506882; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_603506882 = varB4EAC82CA7396A68D541C85D26508E83_2040379239;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_603506882 = varB4EAC82CA7396A68D541C85D26508E83_1452552985;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_603506882 = varB4EAC82CA7396A68D541C85D26508E83_474337521;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_603506882 = varB4EAC82CA7396A68D541C85D26508E83_1921262711;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_603506882.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_603506882;
        // ---------- Original Method ----------
        //KeyCharacterMap kmap = event.getKeyCharacterMap();
        //int kind = kmap.getKeyboardType();
        //if (kind == KeyCharacterMap.ALPHA) {
            //return QwertyKeyListener.getInstance(mAutoText, mAutoCap);
        //} else if (kind == KeyCharacterMap.NUMERIC) {
            //return MultiTapKeyListener.getInstance(mAutoText, mAutoCap);
        //} else if (kind == KeyCharacterMap.FULL
                //|| kind == KeyCharacterMap.SPECIAL_FUNCTION) {
            //return QwertyKeyListener.getInstanceForFullKeyboard();
        //}
        //return NullKeyListener.getInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.087 -0400", hash_original_method = "565C1A1138C97E5AB635581DD94969A4", hash_generated_method = "F9F8F1C80974850B6583FC933614D4B4")
    public void release() {
        {
            ContentResolver contentResolver;
            contentResolver = mResolver.get();
            {
                contentResolver.unregisterContentObserver(mObserver);
                mResolver.clear();
            } //End block
            mObserver = null;
            mResolver = null;
            mPrefsInited = false;
        } //End block
        // ---------- Original Method ----------
        //if (mResolver != null) {
            //final ContentResolver contentResolver = mResolver.get();
            //if (contentResolver != null) {
                //contentResolver.unregisterContentObserver(mObserver);
                //mResolver.clear();
            //}
            //mObserver = null;
            //mResolver = null;
            //mPrefsInited = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.088 -0400", hash_original_method = "083A24B7721BE4E40A2817E04F6CDAB7", hash_generated_method = "76956AED3D9B5071A22378A90A0DF636")
    private void initPrefs(Context context) {
        ContentResolver contentResolver;
        contentResolver = context.getContentResolver();
        mResolver = new WeakReference<ContentResolver>(contentResolver);
        {
            mObserver = new SettingsObserver();
            contentResolver.registerContentObserver(Settings.System.CONTENT_URI, true, mObserver);
        } //End block
        updatePrefs(contentResolver);
        mPrefsInited = true;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //final ContentResolver contentResolver = context.getContentResolver();
        //mResolver = new WeakReference<ContentResolver>(contentResolver);
        //if (mObserver == null) {
            //mObserver = new SettingsObserver();
            //contentResolver.registerContentObserver(Settings.System.CONTENT_URI, true, mObserver);
        //}
        //updatePrefs(contentResolver);
        //mPrefsInited = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.089 -0400", hash_original_method = "4FB87B933010A67FA68BED5325D02530", hash_generated_method = "A41B8AF91E8B317765C7EDE8EC69D829")
    private void updatePrefs(ContentResolver resolver) {
        boolean cap;
        cap = System.getInt(resolver, System.TEXT_AUTO_CAPS, 1) > 0;
        boolean text;
        text = System.getInt(resolver, System.TEXT_AUTO_REPLACE, 1) > 0;
        boolean period;
        period = System.getInt(resolver, System.TEXT_AUTO_PUNCTUATE, 1) > 0;
        boolean pw;
        pw = System.getInt(resolver, System.TEXT_SHOW_PASSWORD, 1) > 0;
        mPrefs = (cap ? AUTO_CAP : 0) |
                 (text ? AUTO_TEXT : 0) |
                 (period ? AUTO_PERIOD : 0) |
                 (pw ? SHOW_PASSWORD : 0);
        addTaint(resolver.getTaint());
        // ---------- Original Method ----------
        //boolean cap = System.getInt(resolver, System.TEXT_AUTO_CAPS, 1) > 0;
        //boolean text = System.getInt(resolver, System.TEXT_AUTO_REPLACE, 1) > 0;
        //boolean period = System.getInt(resolver, System.TEXT_AUTO_PUNCTUATE, 1) > 0;
        //boolean pw = System.getInt(resolver, System.TEXT_SHOW_PASSWORD, 1) > 0;
        //mPrefs = (cap ? AUTO_CAP : 0) |
                 //(text ? AUTO_TEXT : 0) |
                 //(period ? AUTO_PERIOD : 0) |
                 //(pw ? SHOW_PASSWORD : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.090 -0400", hash_original_method = "27BF28A81EBEDB0A58E981BB8A0B8A16", hash_generated_method = "19E3479027DB6A368E4E488DE25F931C")
     int getPrefs(Context context) {
        {
            {
                boolean var8392636308BE7795B7CB7BDE39EE99F5_605570205 = (!mPrefsInited || mResolver.get() == null);
                {
                    initPrefs(context);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(context.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402221377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402221377;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mPrefsInited || mResolver.get() == null) {
                //initPrefs(context);
            //}
        //}
        //return mPrefs;
    }

    
    public enum Capitalize {
        NONE, SENTENCES, WORDS, CHARACTERS,
    }

    
    private static class NullKeyListener implements KeyListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.090 -0400", hash_original_method = "F358F3B966187D3EEEEBD171D03A4696", hash_generated_method = "F358F3B966187D3EEEEBD171D03A4696")
        public NullKeyListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.090 -0400", hash_original_method = "579E66F4F4B0748C979BD80ED5F12401", hash_generated_method = "FABDC4BC2ABCDDBBADBA84A38B373AD7")
        public int getInputType() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434543049 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434543049;
            // ---------- Original Method ----------
            //return InputType.TYPE_NULL;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.090 -0400", hash_original_method = "3A5E70FDE36A1D45C2BCBEA410D24514", hash_generated_method = "CB1071B47BA58222F2608D22412AC5A3")
        public boolean onKeyDown(View view, Editable content,
                                 int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891128560 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891128560;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.091 -0400", hash_original_method = "1D7ECDFDE217EC70CAE84F2DF1B7B165", hash_generated_method = "6BBB12373D95DB0A335972BEB0EB887B")
        public boolean onKeyUp(View view, Editable content, int keyCode,
                                        KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729866520 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729866520;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.091 -0400", hash_original_method = "2352E2665ECFCE8217C303C63497A70F", hash_generated_method = "0FAA37E5301AD5FEFC32CA3F71ABB5B2")
        public boolean onKeyOther(View view, Editable content, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580655592 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_580655592;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.099 -0400", hash_original_method = "7A4583B5F6FBB25B3AFA5ED32AFA7AE1", hash_generated_method = "1A62862E11E4D00BF167C37E2E071C4D")
        public void clearMetaKeyState(View view, Editable content, int states) {
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(states);
            // ---------- Original Method ----------
        }

        
                public static NullKeyListener getInstance() {
            if (sInstance != null)
                return sInstance;
            sInstance = new NullKeyListener();
            return sInstance;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.100 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "DDEE448534DDF1827F49C320D91A9424")

        private static NullKeyListener sInstance;
    }


    
    private class SettingsObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.100 -0400", hash_original_method = "3A67C3C9DA9AFE8F3EB6304BC772D062", hash_generated_method = "EDD4606589505CE8A23486C182973460")
        public  SettingsObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_method = "9B798686FD4009B7C6E0CF4CD0BD37F7", hash_generated_method = "EB0C903A47AB460E29DC9EEFB1F129B7")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                ContentResolver contentResolver;
                contentResolver = mResolver.get();
                {
                    mPrefsInited = false;
                } //End block
                {
                    updatePrefs(contentResolver);
                } //End block
            } //End block
            {
                mPrefsInited = false;
            } //End block
            addTaint(selfChange);
            // ---------- Original Method ----------
            //if (mResolver != null) {
                //final ContentResolver contentResolver = mResolver.get();
                //if (contentResolver == null) {
                    //mPrefsInited = false;
                //} else {
                    //updatePrefs(contentResolver);
                //}
            //} else {
                //mPrefsInited = false;
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "9258D9C5B5D004A481333BEC5D25DADD", hash_generated_field = "2C8F1064E829F05C17C9AD853633A8D2")

    private static TextKeyListener[] sInstance = new TextKeyListener[Capitalize.values().length * 2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "D7E62BE07D36065BBAE7FCF76BD042F0", hash_generated_field = "7297D59BE54217D420FED12A53EC3630")

    static Object ACTIVE = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "CF1FCDC699B0BABB0FF36519F5BA35A2", hash_generated_field = "06709A4E334E633377D52DC83F6F2714")

    static Object CAPPED = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "8F441AE1C3A141D347EC7210C51AABA9", hash_generated_field = "C4F95B3B326406FCE45F97B75A383511")

    static Object INHIBIT_REPLACEMENT = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "2FC62B3E0CE00FD717FA9EE885D9A2FF", hash_generated_field = "B04B92AB305E13C7F668D2B8023DB518")

    static Object LAST_TYPED = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "1DF7B80DEB34DE88F5EE38227854DBB6", hash_generated_field = "4D1D2FD19D44EDDF2F2B1B5C3C4AFBE9")

    static int AUTO_CAP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "A2BC4196F6C7F0E3DA52F4C2E0EBBCB6", hash_generated_field = "129C2D82E7B3743FF5E7F4527A9D2256")

    static int AUTO_TEXT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "0988C732F6B13B5D29A128A2F4B08B03", hash_generated_field = "6E5E8612A194BFAFF11E0E1BA670015A")

    static int AUTO_PERIOD = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.104 -0400", hash_original_field = "5401DB338DB4F4AAF2C8F0CCF7EF68B4", hash_generated_field = "AAF098B222E25499969DAE675BBD6746")

    static int SHOW_PASSWORD = 8;
}

