package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.provider.Settings.System;
import android.text.Editable;
import android.text.InputType;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;

public class TextKeyListener extends BaseKeyListener implements SpanWatcher {

    /**
     * Returns a new or existing instance with the specified capitalization
     * and correction properties.
     *
     * @param cap when, if ever, to automatically capitalize.
     * @param autotext whether to automatically do spelling corrections.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.759 -0500", hash_original_method = "70441C1D43581828EDB4BAD5AB924677", hash_generated_method = "58512CE2163B3B8792AB9A52FF94A92F")
    
public static TextKeyListener getInstance(boolean autotext,
                                              Capitalize cap) {
        int off = cap.ordinal() * 2 + (autotext ? 1 : 0);

        if (sInstance[off] == null) {
            sInstance[off] = new TextKeyListener(cap, autotext);
        }

        return sInstance[off];
    }

    /**
     * Returns a new or existing instance with no automatic capitalization
     * or correction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.762 -0500", hash_original_method = "936D7D79BC1B2ACFC739513AECD7DAAE", hash_generated_method = "023E15A409E87AD8CED46DA23633F6B9")
    
public static TextKeyListener getInstance() {
        return getInstance(false, Capitalize.NONE);
    }

    /**
     * Returns whether it makes sense to automatically capitalize at the
     * specified position in the specified text, with the specified rules.
     *
     * @param cap the capitalization rules to consider.
     * @param cs the text in which an insertion is being made.
     * @param off the offset into that text where the insertion is being made.
     *
     * @return whether the character being inserted should be capitalized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.765 -0500", hash_original_method = "6C04521FA8F839DEBC2B7BBE9D95E585", hash_generated_method = "BFFBE8223A396DBD3D67310C7959581B")
    
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

    /**
     * Clear all the input state (autotext, autocap, multitap, undo)
     * from the specified Editable, going beyond Editable.clear(), which
     * just clears the text but not the input state.
     *
     * @param e the buffer whose text and state are to be cleared.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.781 -0500", hash_original_method = "DDCDD16B215513F049C48DCCB34052D5", hash_generated_method = "E2BF4A07043A385FD8DCCBBCD0FC0AF4")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.709 -0500", hash_original_field = "1FC1501736E399EA2B03C71B0B54A8DC", hash_generated_field = "2C8F1064E829F05C17C9AD853633A8D2")

    private static TextKeyListener[] sInstance =
        new TextKeyListener[Capitalize.values().length * 2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.713 -0500", hash_original_field = "062E29A13019E094F6669D56E09FB351", hash_generated_field = "C7C6152808A642DF24CDDBE9C0C44FB8")
 static final Object ACTIVE = new NoCopySpan.Concrete();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.716 -0500", hash_original_field = "DCCD0DE816CDF8613DFC0C8ED981F821", hash_generated_field = "4534209FB212FC97D916347B1E619FAF")
 static final Object CAPPED = new NoCopySpan.Concrete();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.719 -0500", hash_original_field = "43347DBCB8B7D90C5B359015872F108C", hash_generated_field = "03A8D7254F9C3831689DC1883FAC45ED")
 static final Object INHIBIT_REPLACEMENT = new NoCopySpan.Concrete();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.722 -0500", hash_original_field = "F044329ACA6CDAA60A2E61428937E146", hash_generated_field = "14991993D4613839CACE1341F63244AB")
 static final Object LAST_TYPED = new NoCopySpan.Concrete();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.737 -0500", hash_original_field = "1439BDDA9DC2C863CDF85BB0C32F9026", hash_generated_field = "3BD9B820858A620A3188F9E94EAB91D5")
 static final int AUTO_CAP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.739 -0500", hash_original_field = "FB3C6000EB830CFE338758C17BA1DC84", hash_generated_field = "6794BDCF24212BCF37790B73A597BB47")
 static final int AUTO_TEXT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.743 -0500", hash_original_field = "DFC3B74B0B239938CBB82AF1E2FB9146", hash_generated_field = "CAA762C7FC8B8D1FEFBD15F8D9F5F986")
 static final int AUTO_PERIOD = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.746 -0500", hash_original_field = "085E7A2D798DD649CB8A908885ACD939", hash_generated_field = "FEF3F36C40B66E3713ABD6008B964639")
 static final int SHOW_PASSWORD = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.725 -0500", hash_original_field = "3B5E34829A96BDB56A96B72761630C9F", hash_generated_field = "BEDDE5D3B36AFDA96122F6739A399D24")

    private Capitalize mAutoCap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.728 -0500", hash_original_field = "CD7A811405529AA08CC45A606C53B887", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.730 -0500", hash_original_field = "EC7552BC5986A5953F14301904A976B7", hash_generated_field = "6926B19407F5E0ECC3F4CEC11E041C87")

    private int mPrefs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.733 -0500", hash_original_field = "F56764DC21E0A9C79CD729C84D43AF22", hash_generated_field = "1D299557689B8C33CC4C3DF3BE9D5C3D")

    private boolean mPrefsInited;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.749 -0500", hash_original_field = "2623DC09028481BBFC31885FF1F55C62", hash_generated_field = "5D46AECEC0347C1327E8060B0CEDA4B8")

    private WeakReference<ContentResolver> mResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.752 -0500", hash_original_field = "F6EF96039CDE004D04F193009E19E19A", hash_generated_field = "94A6065FC7822989FE2C83137CC2E2A5")

    private TextKeyListener.SettingsObserver mObserver;

    /**
     * Creates a new TextKeyListener with the specified capitalization
     * and correction properties.
     *
     * @param cap when, if ever, to automatically capitalize.
     * @param autotext whether to automatically do spelling corrections.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.755 -0500", hash_original_method = "9DAB45081F29D4D9259EECD11A475A04", hash_generated_method = "F03AC4D8BE1EF4472303AAEAE6D16334")
    
public TextKeyListener(Capitalize cap, boolean autotext) {
        mAutoCap = cap;
        mAutoText = autotext;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.768 -0500", hash_original_method = "77B762D33BA1CBC4DB995B196C907EDB", hash_generated_method = "514B58733981F5CADFDD316D670DD46D")
    
public int getInputType() {
        return makeTextContentType(mAutoCap, mAutoText);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.771 -0500", hash_original_method = "81E68D18E6AAF9C62286CED7FE623E2E", hash_generated_method = "8DC712458BB74D26286CDA994A4AF4EF")
    
@Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        KeyListener im = getKeyListener(event);

        return im.onKeyDown(view, content, keyCode, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.774 -0500", hash_original_method = "4D169ED96CD6963312694BD71629C37D", hash_generated_method = "47AF4ABEA5FFF41EF3671970CFBD60C2")
    
@Override
    public boolean onKeyUp(View view, Editable content,
                           int keyCode, KeyEvent event) {
        KeyListener im = getKeyListener(event);

        return im.onKeyUp(view, content, keyCode, event);
    }
    
    public enum Capitalize {
        NONE, SENTENCES, WORDS, CHARACTERS,
    }
    
    private static class NullKeyListener implements KeyListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.815 -0500", hash_original_method = "36CD1AB75C69574C06941F903A19CA8E", hash_generated_method = "3DC79C320B285EE35E8142D0FBDBC523")
        
public static NullKeyListener getInstance() {
            if (sInstance != null)
                return sInstance;

            sInstance = new NullKeyListener();
            return sInstance;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.818 -0500", hash_original_field = "C47CAB46E2BF813B13E28B30F60F7B8E", hash_generated_field = "DDEE448534DDF1827F49C320D91A9424")

        private static NullKeyListener sInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.774 -0400", hash_original_method = "F358F3B966187D3EEEEBD171D03A4696", hash_generated_method = "F358F3B966187D3EEEEBD171D03A4696")
        public NullKeyListener ()
        {
            //Synthesized constructor
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.799 -0500", hash_original_method = "579E66F4F4B0748C979BD80ED5F12401", hash_generated_method = "5D22ECBEF26F905AE3EDE3DE48227D32")
        
public int getInputType() {
            return InputType.TYPE_NULL;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.802 -0500", hash_original_method = "3A5E70FDE36A1D45C2BCBEA410D24514", hash_generated_method = "4D58B7FAF3A1C26D55695EC490510E7E")
        
public boolean onKeyDown(View view, Editable content,
                                 int keyCode, KeyEvent event) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.805 -0500", hash_original_method = "1D7ECDFDE217EC70CAE84F2DF1B7B165", hash_generated_method = "E5E666654DDDC06BEA455FAB2F1BB679")
        
public boolean onKeyUp(View view, Editable content, int keyCode,
                                        KeyEvent event) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.808 -0500", hash_original_method = "2352E2665ECFCE8217C303C63497A70F", hash_generated_method = "AE9000D48CDE176B720A95BAFA23DB6A")
        
public boolean onKeyOther(View view, Editable content, KeyEvent event) {
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.812 -0500", hash_original_method = "7A4583B5F6FBB25B3AFA5ED32AFA7AE1", hash_generated_method = "D0C2AD041DC6B6DD32A926C41F329888")
        
public void clearMetaKeyState(View view, Editable content, int states) {
        }
    }
    
    private class SettingsObserver extends ContentObserver {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.831 -0500", hash_original_method = "3A67C3C9DA9AFE8F3EB6304BC772D062", hash_generated_method = "487B419738ED264BC3F36FB8DB230AC9")
        
public SettingsObserver() {
            super(new Handler());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.834 -0500", hash_original_method = "9B798686FD4009B7C6E0CF4CD0BD37F7", hash_generated_method = "690D3859B03EA88154F48800F00D1452")
        
@Override
        public void onChange(boolean selfChange) {
            if (mResolver != null) {
                final ContentResolver contentResolver = mResolver.get();
                if (contentResolver == null) {
                    mPrefsInited = false;
                } else {
                    updatePrefs(contentResolver);
                }
            } else {
                mPrefsInited = false;
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.777 -0500", hash_original_method = "BC51D61DF5BB87B519CDA007F0E35AD4", hash_generated_method = "0D06E3772B7AF10A65578E0F60A16559")
    
@Override
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        KeyListener im = getKeyListener(event);

        return im.onKeyOther(view, content, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.784 -0500", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "D0D44080BF1B8B0853634EBEFA340901")
    
public void onSpanAdded(Spannable s, Object what, int start, int end) { }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.786 -0500", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "5B4B7AFD86AC085C95BBA97BAFF2BD93")
    
public void onSpanRemoved(Spannable s, Object what, int start, int end) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.789 -0500", hash_original_method = "C422051A9042B505708BBCABB42F0EAF", hash_generated_method = "33AEF148EF8655B2C11372FC2DB1664F")
    
public void onSpanChanged(Spannable s, Object what, int start, int end,
                              int st, int en) {
        if (what == Selection.SELECTION_END) {
            s.removeSpan(ACTIVE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.792 -0500", hash_original_method = "AD20E29A89E7D41F4894A2F9AC99B4E0", hash_generated_method = "158B0C4054D88AC275FE93C71E14E239")
    
private KeyListener getKeyListener(KeyEvent event) {
        KeyCharacterMap kmap = event.getKeyCharacterMap();
        int kind = kmap.getKeyboardType();

        if (kind == KeyCharacterMap.ALPHA) {
            return QwertyKeyListener.getInstance(mAutoText, mAutoCap);
        } else if (kind == KeyCharacterMap.NUMERIC) {
            return MultiTapKeyListener.getInstance(mAutoText, mAutoCap);
        } else if (kind == KeyCharacterMap.FULL
                || kind == KeyCharacterMap.SPECIAL_FUNCTION) {
            // We consider special function keyboards full keyboards as a workaround for
            // devices that do not have built-in keyboards.  Applications may try to inject
            // key events using the built-in keyboard device id which may be configured as
            // a special function keyboard using a default key map.  Ideally, as of Honeycomb,
            // these applications should be modified to use KeyCharacterMap.VIRTUAL_KEYBOARD.
            return QwertyKeyListener.getInstanceForFullKeyboard();
        }

        return NullKeyListener.getInstance();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.823 -0500", hash_original_method = "565C1A1138C97E5AB635581DD94969A4", hash_generated_method = "08CDBEB787485277FFC31E398701E64B")
    
public void release() {
        if (mResolver != null) {
            final ContentResolver contentResolver = mResolver.get();
            if (contentResolver != null) {
                contentResolver.unregisterContentObserver(mObserver);
                mResolver.clear();
            }
            mObserver = null;
            mResolver = null;
            mPrefsInited = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.827 -0500", hash_original_method = "083A24B7721BE4E40A2817E04F6CDAB7", hash_generated_method = "AA95F48A0D4EC0C7E2390B426DAD9C6A")
    
private void initPrefs(Context context) {
        final ContentResolver contentResolver = context.getContentResolver();
        mResolver = new WeakReference<ContentResolver>(contentResolver);
        if (mObserver == null) {
            mObserver = new SettingsObserver();
            contentResolver.registerContentObserver(Settings.System.CONTENT_URI, true, mObserver);
        }

        updatePrefs(contentResolver);
        mPrefsInited = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.839 -0500", hash_original_method = "4FB87B933010A67FA68BED5325D02530", hash_generated_method = "4FBD6D0E1DAF0361C913AF31C5629D8C")
    
private void updatePrefs(ContentResolver resolver) {
        boolean cap = System.getInt(resolver, System.TEXT_AUTO_CAPS, 1) > 0;
        boolean text = System.getInt(resolver, System.TEXT_AUTO_REPLACE, 1) > 0;
        boolean period = System.getInt(resolver, System.TEXT_AUTO_PUNCTUATE, 1) > 0;
        boolean pw = System.getInt(resolver, System.TEXT_SHOW_PASSWORD, 1) > 0;

        mPrefs = (cap ? AUTO_CAP : 0) |
                 (text ? AUTO_TEXT : 0) |
                 (period ? AUTO_PERIOD : 0) |
                 (pw ? SHOW_PASSWORD : 0);
    }

    /* package */ @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.841 -0500", hash_original_method = "27BF28A81EBEDB0A58E981BB8A0B8A16", hash_generated_method = "27BF28A81EBEDB0A58E981BB8A0B8A16")
    
int getPrefs(Context context) {
        synchronized (this) {
            if (!mPrefsInited || mResolver.get() == null) {
                initPrefs(context);
            }
        }

        return mPrefs;
    }
}

