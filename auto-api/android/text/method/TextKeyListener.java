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
    private Capitalize mAutoCap;
    private boolean mAutoText;
    private int mPrefs;
    private boolean mPrefsInited;
    private WeakReference<ContentResolver> mResolver;
    private TextKeyListener.SettingsObserver mObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.718 -0400", hash_original_method = "9DAB45081F29D4D9259EECD11A475A04", hash_generated_method = "F0571A4D7F7B16061E901CF5BE6C426C")
    @DSModeled(DSC.SAFE)
    public TextKeyListener(Capitalize cap, boolean autotext) {
        dsTaint.addTaint(autotext);
        dsTaint.addTaint(cap.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.730 -0400", hash_original_method = "77B762D33BA1CBC4DB995B196C907EDB", hash_generated_method = "DCC00A36111952B199CCA20E471DA95B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInputType() {
        int var9E11457640925EE0EF1D4E5A2BEB5EA9_1646961792 = (makeTextContentType(mAutoCap, mAutoText));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return makeTextContentType(mAutoCap, mAutoText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.730 -0400", hash_original_method = "81E68D18E6AAF9C62286CED7FE623E2E", hash_generated_method = "8F60DFCC0307573C797326BAF89226CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        KeyListener im;
        im = getKeyListener(event);
        boolean varF286B59ADFF6299A37098A9DB0C8357B_1619283620 = (im.onKeyDown(view, content, keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //KeyListener im = getKeyListener(event);
        //return im.onKeyDown(view, content, keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.730 -0400", hash_original_method = "4D169ED96CD6963312694BD71629C37D", hash_generated_method = "314DB17C5938E439F941224FF6DDAC6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(View view, Editable content,
                           int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        KeyListener im;
        im = getKeyListener(event);
        boolean var95A6FE6B62FCC62B201DE8A79EC297F9_1651782826 = (im.onKeyUp(view, content, keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //KeyListener im = getKeyListener(event);
        //return im.onKeyUp(view, content, keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.731 -0400", hash_original_method = "BC51D61DF5BB87B519CDA007F0E35AD4", hash_generated_method = "C3562035D23B65DB6D784AF139D38383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        KeyListener im;
        im = getKeyListener(event);
        boolean varEE7D10462EE6111109AAADBA63F6F0F6_54234842 = (im.onKeyOther(view, content, event));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.731 -0400", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "C22D61E999AA1E9951E285D7DC2268B9")
    @DSModeled(DSC.SAFE)
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.731 -0400", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "ED0028870DFADED4E715BEB8F9C515AF")
    @DSModeled(DSC.SAFE)
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.731 -0400", hash_original_method = "C422051A9042B505708BBCABB42F0EAF", hash_generated_method = "322B269F128AD89BDD4C6FC3FCD1C2F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSpanChanged(Spannable s, Object what, int start, int end,
                              int st, int en) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(en);
        dsTaint.addTaint(st);
        dsTaint.addTaint(end);
        {
            s.removeSpan(ACTIVE);
        } //End block
        // ---------- Original Method ----------
        //if (what == Selection.SELECTION_END) {
            //s.removeSpan(ACTIVE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.732 -0400", hash_original_method = "AD20E29A89E7D41F4894A2F9AC99B4E0", hash_generated_method = "8D689BD70D619E3E7BCFB372C47FCE68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private KeyListener getKeyListener(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        KeyCharacterMap kmap;
        kmap = event.getKeyCharacterMap();
        int kind;
        kind = kmap.getKeyboardType();
        {
            KeyListener var26B4765C565876FF47A9108ACA77E9D0_957092751 = (QwertyKeyListener.getInstance(mAutoText, mAutoCap));
        } //End block
        {
            KeyListener varC24BA191798CD94F7348D65BA7075BC0_1598610303 = (MultiTapKeyListener.getInstance(mAutoText, mAutoCap));
        } //End block
        {
            KeyListener var4CB21B5627D2117699A1FD461A046E30_1272265720 = (QwertyKeyListener.getInstanceForFullKeyboard());
        } //End block
        KeyListener varBCCBAD71F4906EF9F69CBF5D04F419F3_1953161666 = (NullKeyListener.getInstance());
        return (KeyListener)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.732 -0400", hash_original_method = "565C1A1138C97E5AB635581DD94969A4", hash_generated_method = "F9F8F1C80974850B6583FC933614D4B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.732 -0400", hash_original_method = "083A24B7721BE4E40A2817E04F6CDAB7", hash_generated_method = "1C9C0583C159B3B01C48D54E56C5CDB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initPrefs(Context context) {
        dsTaint.addTaint(context.dsTaint);
        ContentResolver contentResolver;
        contentResolver = context.getContentResolver();
        mResolver = new WeakReference<ContentResolver>(contentResolver);
        {
            mObserver = new SettingsObserver();
            contentResolver.registerContentObserver(Settings.System.CONTENT_URI, true, mObserver);
        } //End block
        updatePrefs(contentResolver);
        mPrefsInited = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.733 -0400", hash_original_method = "4FB87B933010A67FA68BED5325D02530", hash_generated_method = "4FD50B7057B9FC26019C17C1D8FC1A8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updatePrefs(ContentResolver resolver) {
        dsTaint.addTaint(resolver.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.733 -0400", hash_original_method = "27BF28A81EBEDB0A58E981BB8A0B8A16", hash_generated_method = "66A0DB8974DEDE5B4DD88736C7B6A7F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getPrefs(Context context) {
        dsTaint.addTaint(context.dsTaint);
        {
            {
                boolean var8392636308BE7795B7CB7BDE39EE99F5_324356351 = (!mPrefsInited || mResolver.get() == null);
                {
                    initPrefs(context);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.733 -0400", hash_original_method = "1A668B0ED39F9A0BF061787FEF014357", hash_generated_method = "1A668B0ED39F9A0BF061787FEF014357")
                public NullKeyListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.733 -0400", hash_original_method = "579E66F4F4B0748C979BD80ED5F12401", hash_generated_method = "ACA9AF1E2C1A889C4CAC5CCB1A08BBFF")
        @DSModeled(DSC.SAFE)
        public int getInputType() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return InputType.TYPE_NULL;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.734 -0400", hash_original_method = "3A5E70FDE36A1D45C2BCBEA410D24514", hash_generated_method = "762DD23E3351794FF11C53C0DB0F49F2")
        @DSModeled(DSC.SAFE)
        public boolean onKeyDown(View view, Editable content,
                                 int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(content.dsTaint);
            dsTaint.addTaint(keyCode);
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.734 -0400", hash_original_method = "1D7ECDFDE217EC70CAE84F2DF1B7B165", hash_generated_method = "845898AAF1752EF45B59E238EF1023D2")
        @DSModeled(DSC.SAFE)
        public boolean onKeyUp(View view, Editable content, int keyCode,
                                        KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(content.dsTaint);
            dsTaint.addTaint(keyCode);
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.734 -0400", hash_original_method = "2352E2665ECFCE8217C303C63497A70F", hash_generated_method = "D53083B2C95E5D27A49D70D6B9BF8710")
        @DSModeled(DSC.SAFE)
        public boolean onKeyOther(View view, Editable content, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(content.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.734 -0400", hash_original_method = "7A4583B5F6FBB25B3AFA5ED32AFA7AE1", hash_generated_method = "0C97CE822C219DA2D59E11EB94E538CF")
        @DSModeled(DSC.SAFE)
        public void clearMetaKeyState(View view, Editable content, int states) {
            dsTaint.addTaint(content.dsTaint);
            dsTaint.addTaint(states);
            dsTaint.addTaint(view.dsTaint);
            // ---------- Original Method ----------
        }

        
                public static NullKeyListener getInstance() {
            if (sInstance != null)
                return sInstance;
            sInstance = new NullKeyListener();
            return sInstance;
        }

        
        private static NullKeyListener sInstance;
    }


    
    private class SettingsObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.734 -0400", hash_original_method = "3A67C3C9DA9AFE8F3EB6304BC772D062", hash_generated_method = "EDD4606589505CE8A23486C182973460")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SettingsObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.735 -0400", hash_original_method = "9B798686FD4009B7C6E0CF4CD0BD37F7", hash_generated_method = "A6B8980B183BC4C2EB920A6EA1172955")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
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


    
    private static TextKeyListener[] sInstance =
        new TextKeyListener[Capitalize.values().length * 2];
    static final Object ACTIVE = new NoCopySpan.Concrete();
    static final Object CAPPED = new NoCopySpan.Concrete();
    static final Object INHIBIT_REPLACEMENT = new NoCopySpan.Concrete();
    static final Object LAST_TYPED = new NoCopySpan.Concrete();
    static final int AUTO_CAP = 1;
    static final int AUTO_TEXT = 2;
    static final int AUTO_PERIOD = 4;
    static final int SHOW_PASSWORD = 8;
}

