package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.574 -0400", hash_original_field = "7B00CDF214A58D964DB1FD6D561A182A", hash_generated_field = "BEDDE5D3B36AFDA96122F6739A399D24")

    private Capitalize mAutoCap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.574 -0400", hash_original_field = "3D18F8DF226A678B64C4D4C4D035A79A", hash_generated_field = "C101024EE87082E36D969AEA4683627E")

    private boolean mAutoText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.574 -0400", hash_original_field = "4A65E4AFE2E6A8567B2303B5B414D0A2", hash_generated_field = "6926B19407F5E0ECC3F4CEC11E041C87")

    private int mPrefs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.574 -0400", hash_original_field = "9977F77CE5547DA73F8036BC498B4EC9", hash_generated_field = "1D299557689B8C33CC4C3DF3BE9D5C3D")

    private boolean mPrefsInited;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.574 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "5D46AECEC0347C1327E8060B0CEDA4B8")

    private WeakReference<ContentResolver> mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.574 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "94A6065FC7822989FE2C83137CC2E2A5")

    private TextKeyListener.SettingsObserver mObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.574 -0400", hash_original_method = "9DAB45081F29D4D9259EECD11A475A04", hash_generated_method = "B59FD9AE6465D27FF27D624847BFBF79")
    public  TextKeyListener(Capitalize cap, boolean autotext) {
        mAutoCap = cap;
        mAutoText = autotext;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static TextKeyListener getInstance(boolean autotext,
                                              Capitalize cap) {
        int off = cap.ordinal() * 2 + (autotext ? 1 : 0);
        if (sInstance[off] == null) {
            sInstance[off] = new TextKeyListener(cap, autotext);
        }
        return sInstance[off];
    }

    
    @DSModeled(DSC.SAFE)
    public static TextKeyListener getInstance() {
        return getInstance(false, Capitalize.NONE);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.575 -0400", hash_original_method = "77B762D33BA1CBC4DB995B196C907EDB", hash_generated_method = "CD97FAED6E2E5E8BF9D146AFCF4372B2")
    public int getInputType() {
        int var9E11457640925EE0EF1D4E5A2BEB5EA9_1323633459 = (makeTextContentType(mAutoCap, mAutoText));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068752307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068752307;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.575 -0400", hash_original_method = "81E68D18E6AAF9C62286CED7FE623E2E", hash_generated_method = "AC4B69081227AACF55FFFCECC53F4F93")
    @Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        
        KeyListener im = getKeyListener(event);
        boolean varF286B59ADFF6299A37098A9DB0C8357B_167092905 = (im.onKeyDown(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060758335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060758335;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.576 -0400", hash_original_method = "4D169ED96CD6963312694BD71629C37D", hash_generated_method = "0A390AF57A9684CBDE5D6AF8AFC7822C")
    @Override
    public boolean onKeyUp(View view, Editable content,
                           int keyCode, KeyEvent event) {
        
        KeyListener im = getKeyListener(event);
        boolean var95A6FE6B62FCC62B201DE8A79EC297F9_510958228 = (im.onKeyUp(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_208449949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_208449949;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.576 -0400", hash_original_method = "BC51D61DF5BB87B519CDA007F0E35AD4", hash_generated_method = "E877940B3DC6DB416E95D3C6E279AA4F")
    @Override
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        
        KeyListener im = getKeyListener(event);
        boolean varEE7D10462EE6111109AAADBA63F6F0F6_1672156438 = (im.onKeyOther(view, content, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107142665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107142665;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.577 -0400", hash_original_method = "A7E02D03E9AB7CF614DD169102D03FAF", hash_generated_method = "7B286C8C34C0CB912482A9582E50ADC8")
    public void onSpanAdded(Spannable s, Object what, int start, int end) {
        
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.577 -0400", hash_original_method = "2C716670C272F54C9EB4064D90DB3C4E", hash_generated_method = "F033A2BD7F1AB312500D2F37A623D63A")
    public void onSpanRemoved(Spannable s, Object what, int start, int end) {
        
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.578 -0400", hash_original_method = "C422051A9042B505708BBCABB42F0EAF", hash_generated_method = "1235A9E630F04714A1D4FE1D9F021FE3")
    public void onSpanChanged(Spannable s, Object what, int start, int end,
                              int st, int en) {
        
        {
            s.removeSpan(ACTIVE);
        } 
        addTaint(s.getTaint());
        addTaint(what.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(st);
        addTaint(en);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.578 -0400", hash_original_method = "AD20E29A89E7D41F4894A2F9AC99B4E0", hash_generated_method = "A148E467A51B139C1D5FD29E5A2BA298")
    private KeyListener getKeyListener(KeyEvent event) {
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_1161827332 = null; 
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_1287207585 = null; 
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_882799251 = null; 
        KeyListener varB4EAC82CA7396A68D541C85D26508E83_2144761283 = null; 
        KeyCharacterMap kmap = event.getKeyCharacterMap();
        int kind = kmap.getKeyboardType();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1161827332 = QwertyKeyListener.getInstance(mAutoText, mAutoCap);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1287207585 = MultiTapKeyListener.getInstance(mAutoText, mAutoCap);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_882799251 = QwertyKeyListener.getInstanceForFullKeyboard();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2144761283 = NullKeyListener.getInstance();
        addTaint(event.getTaint());
        KeyListener varA7E53CE21691AB073D9660D615818899_1238210396; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1238210396 = varB4EAC82CA7396A68D541C85D26508E83_1161827332;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1238210396 = varB4EAC82CA7396A68D541C85D26508E83_1287207585;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1238210396 = varB4EAC82CA7396A68D541C85D26508E83_882799251;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1238210396 = varB4EAC82CA7396A68D541C85D26508E83_2144761283;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1238210396.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1238210396;
        
        
        
        
            
        
            
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.579 -0400", hash_original_method = "565C1A1138C97E5AB635581DD94969A4", hash_generated_method = "2127E09276CC5A041C8C79D8C83F39F3")
    public void release() {
        {
            final ContentResolver contentResolver = mResolver.get();
            {
                contentResolver.unregisterContentObserver(mObserver);
                mResolver.clear();
            } 
            mObserver = null;
            mResolver = null;
            mPrefsInited = false;
        } 
        
        
            
            
                
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.579 -0400", hash_original_method = "083A24B7721BE4E40A2817E04F6CDAB7", hash_generated_method = "E05697A0C6467BEBA4A3FF4C9487EA25")
    private void initPrefs(Context context) {
        final ContentResolver contentResolver = context.getContentResolver();
        mResolver = new WeakReference<ContentResolver>(contentResolver);
        {
            mObserver = new SettingsObserver();
            contentResolver.registerContentObserver(Settings.System.CONTENT_URI, true, mObserver);
        } 
        updatePrefs(contentResolver);
        mPrefsInited = true;
        addTaint(context.getTaint());
        
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.580 -0400", hash_original_method = "4FB87B933010A67FA68BED5325D02530", hash_generated_method = "9127DB2EBD53A5C9BBA003DA4F2D451C")
    private void updatePrefs(ContentResolver resolver) {
        boolean cap = System.getInt(resolver, System.TEXT_AUTO_CAPS, 1) > 0;
        boolean text = System.getInt(resolver, System.TEXT_AUTO_REPLACE, 1) > 0;
        boolean period = System.getInt(resolver, System.TEXT_AUTO_PUNCTUATE, 1) > 0;
        boolean pw = System.getInt(resolver, System.TEXT_SHOW_PASSWORD, 1) > 0;
        mPrefs = (cap ? AUTO_CAP : 0) |
                 (text ? AUTO_TEXT : 0) |
                 (period ? AUTO_PERIOD : 0) |
                 (pw ? SHOW_PASSWORD : 0);
        addTaint(resolver.getTaint());
        
        
        
        
        
        
                 
                 
                 
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.580 -0400", hash_original_method = "27BF28A81EBEDB0A58E981BB8A0B8A16", hash_generated_method = "040B3EBC6F1CEAA7949E1409F51E021F")
     int getPrefs(Context context) {
        {
            {
                boolean var8392636308BE7795B7CB7BDE39EE99F5_1212064128 = (!mPrefsInited || mResolver.get() == null);
                {
                    initPrefs(context);
                } 
            } 
        } 
        addTaint(context.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235580387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235580387;
        
        
            
                
            
        
        
    }

    
    public enum Capitalize {
        NONE, SENTENCES, WORDS, CHARACTERS,
    }

    
    private static class NullKeyListener implements KeyListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.580 -0400", hash_original_method = "F358F3B966187D3EEEEBD171D03A4696", hash_generated_method = "F358F3B966187D3EEEEBD171D03A4696")
        public NullKeyListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.581 -0400", hash_original_method = "579E66F4F4B0748C979BD80ED5F12401", hash_generated_method = "A2AF79B94AB6D3ACACDDF391E6BF61B9")
        public int getInputType() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772520160 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772520160;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.581 -0400", hash_original_method = "3A5E70FDE36A1D45C2BCBEA410D24514", hash_generated_method = "5E3ECA244A96514B04531CBAAA859A65")
        public boolean onKeyDown(View view, Editable content,
                                 int keyCode, KeyEvent event) {
            
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903312888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_903312888;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.581 -0400", hash_original_method = "1D7ECDFDE217EC70CAE84F2DF1B7B165", hash_generated_method = "A2E9A7322F5CBB4292253F0C26EC7B4F")
        public boolean onKeyUp(View view, Editable content, int keyCode,
                                        KeyEvent event) {
            
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227551992 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227551992;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.582 -0400", hash_original_method = "2352E2665ECFCE8217C303C63497A70F", hash_generated_method = "86FF6B8B90DEE6613AFC914E9C9456E9")
        public boolean onKeyOther(View view, Editable content, KeyEvent event) {
            
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136412397 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136412397;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.582 -0400", hash_original_method = "7A4583B5F6FBB25B3AFA5ED32AFA7AE1", hash_generated_method = "1A62862E11E4D00BF167C37E2E071C4D")
        public void clearMetaKeyState(View view, Editable content, int states) {
            addTaint(view.getTaint());
            addTaint(content.getTaint());
            addTaint(states);
            
        }

        
                public static NullKeyListener getInstance() {
            if (sInstance != null)
                return sInstance;
            sInstance = new NullKeyListener();
            return sInstance;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.582 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "DDEE448534DDF1827F49C320D91A9424")

        private static NullKeyListener sInstance;
    }


    
    private class SettingsObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.582 -0400", hash_original_method = "3A67C3C9DA9AFE8F3EB6304BC772D062", hash_generated_method = "EDD4606589505CE8A23486C182973460")
        public  SettingsObserver() {
            super(new Handler());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_method = "9B798686FD4009B7C6E0CF4CD0BD37F7", hash_generated_method = "DF2673ADFBE7C125E62F0EE3A914C552")
        @Override
        public void onChange(boolean selfChange) {
            
            {
                final ContentResolver contentResolver = mResolver.get();
                {
                    mPrefsInited = false;
                } 
                {
                    updatePrefs(contentResolver);
                } 
            } 
            {
                mPrefsInited = false;
            } 
            addTaint(selfChange);
            
            
                
                
                    
                
                    
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "9258D9C5B5D004A481333BEC5D25DADD", hash_generated_field = "2C8F1064E829F05C17C9AD853633A8D2")

    private static TextKeyListener[] sInstance = new TextKeyListener[Capitalize.values().length * 2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "D7E62BE07D36065BBAE7FCF76BD042F0", hash_generated_field = "C7C6152808A642DF24CDDBE9C0C44FB8")

    static final Object ACTIVE = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "CF1FCDC699B0BABB0FF36519F5BA35A2", hash_generated_field = "4534209FB212FC97D916347B1E619FAF")

    static final Object CAPPED = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "8F441AE1C3A141D347EC7210C51AABA9", hash_generated_field = "03A8D7254F9C3831689DC1883FAC45ED")

    static final Object INHIBIT_REPLACEMENT = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "2FC62B3E0CE00FD717FA9EE885D9A2FF", hash_generated_field = "14991993D4613839CACE1341F63244AB")

    static final Object LAST_TYPED = new NoCopySpan.Concrete();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "1DF7B80DEB34DE88F5EE38227854DBB6", hash_generated_field = "3BD9B820858A620A3188F9E94EAB91D5")

    static final int AUTO_CAP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "A2BC4196F6C7F0E3DA52F4C2E0EBBCB6", hash_generated_field = "6794BDCF24212BCF37790B73A597BB47")

    static final int AUTO_TEXT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "0988C732F6B13B5D29A128A2F4B08B03", hash_generated_field = "CAA762C7FC8B8D1FEFBD15F8D9F5F986")

    static final int AUTO_PERIOD = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.583 -0400", hash_original_field = "5401DB338DB4F4AAF2C8F0CCF7EF68B4", hash_generated_field = "FEF3F36C40B66E3713ABD6008B964639")

    static final int SHOW_PASSWORD = 8;
}

