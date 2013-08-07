package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.content.Context;
import android.content.res.XmlResourceParser;
import java.util.Locale;
import android.inputmethodservice.Keyboard;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.KeyboardView;
import android.content.res.Resources;
public class PasswordEntryKeyboard extends Keyboard {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.104 -0400", hash_original_field = "8E5F2A5C884A3CC8A042C37F6FDD5712", hash_generated_field = "72A1B1D050AA32C288E6BD4B8A3EB383")

    private Drawable mShiftIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.104 -0400", hash_original_field = "4347B86504455CB9893CB2AA1872C98D", hash_generated_field = "18EBD0CC110FFB3F039EB41AE3AF3037")

    private Drawable mShiftLockIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.104 -0400", hash_original_field = "84FE801828E968E6A3D0134866A3357E", hash_generated_field = "3C38F9F4C0957E37C500DD54681F46BA")

    private Drawable[] mOldShiftIcons = {null, null, };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.104 -0400", hash_original_field = "1C10118944B85656CB6EA6807AF0F90E", hash_generated_field = "87C86A799EEF8EB6C9FC1825507FF0B0")

    private Key[] mShiftKeys = {null, null, };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.104 -0400", hash_original_field = "17317C61341C0F7A950A16B61FA2351C", hash_generated_field = "634F11FFFEAE1B1EB1AC0BEB246D520D")

    private Key mEnterKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.104 -0400", hash_original_field = "B47459C4E20BB3208167982B3DBCF229", hash_generated_field = "AC7E8DA94396E8164D55ED4566697617")

    private Key mF1Key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.105 -0400", hash_original_field = "7F435923E7B9DA0DF48D23C7E4E244C4", hash_generated_field = "FB73414DE754310C6779ECA2AC55B29C")

    private Key mSpaceKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.105 -0400", hash_original_field = "2A863C5396A7F94DD401B3BDC0BFCD86", hash_generated_field = "6EDAB2FBB21781A4F96E95C456847BA8")

    private int mShiftState = SHIFT_OFF;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.105 -0400", hash_original_method = "7E99FA34D1FDBCEE8D6B514C23FA43C7", hash_generated_method = "B7168FA0CBD25873797266B7028F438D")
    public  PasswordEntryKeyboard(Context context, int xmlLayoutResId) {
        this(context, xmlLayoutResId, 0);
        addTaint(xmlLayoutResId);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.106 -0400", hash_original_method = "6327242F510D33851FBA741FDA7BD2A2", hash_generated_method = "2D30898492F8DDF573FA68CFA539BD45")
    public  PasswordEntryKeyboard(Context context, int xmlLayoutResId, int width, int height) {
        this(context, xmlLayoutResId, 0, width, height);
        addTaint(height);
        addTaint(width);
        addTaint(xmlLayoutResId);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.106 -0400", hash_original_method = "BB835F95EF0792618CC16D000F25A2B4", hash_generated_method = "378917D6AE0233CC91D9916D14CBA175")
    public  PasswordEntryKeyboard(Context context, int xmlLayoutResId, int mode) {
        super(context, xmlLayoutResId, mode);
        addTaint(mode);
        addTaint(xmlLayoutResId);
        addTaint(context.getTaint());
init(context)
        // ---------- Original Method ----------
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.107 -0400", hash_original_method = "18643263C4A0E377FAE4AE2935FD771A", hash_generated_method = "79543D85FC99F28B2C9BA078A3F6B5D3")
    public  PasswordEntryKeyboard(Context context, int xmlLayoutResId, int mode,
            int width, int height) {
        super(context, xmlLayoutResId, mode, width, height);
        addTaint(height);
        addTaint(width);
        addTaint(mode);
        addTaint(xmlLayoutResId);
        addTaint(context.getTaint());
init(context)
        // ---------- Original Method ----------
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.108 -0400", hash_original_method = "6163773A303A3F04205C9E80EBCBD876", hash_generated_method = "777C8E9ADE6087F9B5099AED92152F03")
    public  PasswordEntryKeyboard(Context context, int layoutTemplateResId,
            CharSequence characters, int columns, int horizontalPadding) {
        super(context, layoutTemplateResId, characters, columns, horizontalPadding);
        addTaint(horizontalPadding);
        addTaint(columns);
        addTaint(characters.getTaint());
        addTaint(layoutTemplateResId);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.108 -0400", hash_original_method = "2CC46A693268202B7F71D5C5F4C7FFB2", hash_generated_method = "9327303AD40D9A6CCFCFE8962B76D183")
    private void init(Context context) {
        addTaint(context.getTaint());
        final Resources res = context.getResources();
mShiftIcon=res.getDrawable(R.drawable.sym_keyboard_shift)mShiftLockIcon=res.getDrawable(R.drawable.sym_keyboard_shift_locked)sSpacebarVerticalCorrection=res.getDimensionPixelOffset(R.dimen.password_keyboard_spacebar_vertical_correction)
        // ---------- Original Method ----------
        //final Resources res = context.getResources();
        //mShiftIcon = res.getDrawable(R.drawable.sym_keyboard_shift);
        //mShiftLockIcon = res.getDrawable(R.drawable.sym_keyboard_shift_locked);
        //sSpacebarVerticalCorrection = res.getDimensionPixelOffset(
                //R.dimen.password_keyboard_spacebar_vertical_correction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.109 -0400", hash_original_method = "F0BEF97E570012ABC3B5A53A9574CB79", hash_generated_method = "E0B48B2046DB6E67CFB3B093D52D72CA")
    @Override
    protected Key createKeyFromXml(Resources res, Row parent, int x, int y,
            XmlResourceParser parser) {
        addTaint(parser.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(parent.getTaint());
        addTaint(res.getTaint());
        LatinKey key = new LatinKey(res, parent, x, y, parser);
        final int code = key.codes[0];
        if(code>=0&&code!='\n'&&(code<32||code>127))        
        {
key.label=" "key.setEnabled(false)
        } //End block
        switch(key.codes[0]){
        case 10:
mEnterKey=key        break;
        case PasswordEntryKeyboardView.KEYCODE_F1:
mF1Key=key        break;
        case 32:
mSpaceKey=key        break;
}Key var6A95247616A3A8B93CFF7783DABD08D4_1664694201 = key        var6A95247616A3A8B93CFF7783DABD08D4_1664694201.addTaint(taint);
        return var6A95247616A3A8B93CFF7783DABD08D4_1664694201;
        // ---------- Original Method ----------
        //LatinKey key = new LatinKey(res, parent, x, y, parser);
        //final int code = key.codes[0];
        //if (code >=0 && code != '\n' && (code < 32 || code > 127)) {
            //key.label = " ";
            //key.setEnabled(false);
        //}
        //switch (key.codes[0]) {
            //case 10:
                //mEnterKey = key;
                //break;
            //case PasswordEntryKeyboardView.KEYCODE_F1:
                //mF1Key = key;
                //break;
            //case 32:
                //mSpaceKey = key;
                //break;
        //}
        //return key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.110 -0400", hash_original_method = "FCBA94CE76462DF2166AAB4D1E7CCC26", hash_generated_method = "5194EC70F107A288C96190BBB2532049")
     void setEnterKeyResources(Resources res, int previewId, int iconId, int labelId) {
        addTaint(labelId);
        addTaint(iconId);
        addTaint(previewId);
        addTaint(res.getTaint());
        if(mEnterKey!=null)        
        {
mEnterKey.popupCharacters=nullmEnterKey.popupResId=0mEnterKey.text=nullmEnterKey.iconPreview=res.getDrawable(previewId)mEnterKey.icon=res.getDrawable(iconId)mEnterKey.label=res.getText(labelId)            if(mEnterKey.iconPreview!=null)            
            {
mEnterKey.iconPreview.setBounds(0, 0, mEnterKey.iconPreview.getIntrinsicWidth(), mEnterKey.iconPreview.getIntrinsicHeight())
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mEnterKey != null) {
            //mEnterKey.popupCharacters = null;
            //mEnterKey.popupResId = 0;
            //mEnterKey.text = null;
            //mEnterKey.iconPreview = res.getDrawable(previewId);
            //mEnterKey.icon = res.getDrawable(iconId);
            //mEnterKey.label = res.getText(labelId);
            //if (mEnterKey.iconPreview != null) {
                //mEnterKey.iconPreview.setBounds(0, 0,
                        //mEnterKey.iconPreview.getIntrinsicWidth(),
                        //mEnterKey.iconPreview.getIntrinsicHeight());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.111 -0400", hash_original_method = "EF54447915DD00689848896A617A4C01", hash_generated_method = "DB166C6DAB4C8497931A5926BE374E2D")
     void enableShiftLock() {
        int i = 0;
for(int index : getShiftKeyIndices())
        {
            if(index>=0&&i<mShiftKeys.length)            
            {
mShiftKeys[i]=getKeys().get(index)                if(mShiftKeys[i] instanceof LatinKey)                
                {
((LatinKey) mShiftKeys[i]).enableShiftLock()
                } //End block
mOldShiftIcons[i]=mShiftKeys[i].iconi
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int i = 0;
        //for (int index : getShiftKeyIndices()) {
            //if (index >= 0 && i < mShiftKeys.length) {
                //mShiftKeys[i] = getKeys().get(index);
                //if (mShiftKeys[i] instanceof LatinKey) {
                    //((LatinKey)mShiftKeys[i]).enableShiftLock();
                //}
                //mOldShiftIcons[i] = mShiftKeys[i].icon;
                //i++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.112 -0400", hash_original_method = "2FD60925F98FC00F1D582ED795F27D50", hash_generated_method = "7D5767D145E11B138850AC6E19CC6578")
     void setShiftLocked(boolean shiftLocked) {
        addTaint(shiftLocked);
for(Key shiftKey : mShiftKeys)
        {
            if(shiftKey!=null)            
            {
shiftKey.on=shiftLockedshiftKey.icon=mShiftLockIcon
            } //End block
        } //End block
mShiftState=shiftLocked?SHIFT_LOCKED:SHIFT_LOCKED
        // ---------- Original Method ----------
        //for (Key shiftKey : mShiftKeys) {
            //if (shiftKey != null) {
                //shiftKey.on = shiftLocked;
                //shiftKey.icon = mShiftLockIcon;
            //}
        //}
        //mShiftState = shiftLocked ? SHIFT_LOCKED : SHIFT_ON;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.113 -0400", hash_original_method = "C127FA93F68725D9F204B6CFBACFBC8A", hash_generated_method = "958866D2017E1371D102E4891823B262")
    @Override
    public boolean setShifted(boolean shiftState) {
        addTaint(shiftState);
        boolean shiftChanged = false;
        if(shiftState==false)        
        {
shiftChanged=mShiftState!=SHIFT_OFFmShiftState=SHIFT_OFF
        } //End block
        else
        if(mShiftState==SHIFT_OFF)        
        {
shiftChanged=mShiftState==SHIFT_OFFmShiftState=SHIFT_ON
        } //End block
for(int i = 0;i<mShiftKeys.length;i)
        {
            if(mShiftKeys[i]!=null)            
            {
                if(shiftState==false)                
                {
mShiftKeys[i].on=falsemShiftKeys[i].icon=mOldShiftIcons[i]
                } //End block
                else
                if(mShiftState==SHIFT_OFF)                
                {
mShiftKeys[i].on=falsemShiftKeys[i].icon=mShiftIcon
                } //End block
            } //End block
            else
            {
            } //End block
        } //End block
        boolean varB0C5631AC3A78E5F5A977EB8748BA959_1255770800 = (shiftChanged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_276108491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_276108491;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.115 -0400", hash_original_method = "08DDF55894F647058ACA9012299BAA91", hash_generated_method = "DCE5D7AE4E5D42584B33525A8B54ABDB")
    @Override
    public boolean isShifted() {
        if(mShiftKeys[0]!=null)        
        {
            boolean varD01672B5C734EF62310B1258F0C02EC2_1264545444 = (mShiftState!=SHIFT_OFF);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1565922716 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1565922716;
        } //End block
        else
        {
            boolean varEF547D9B23783BDE6C7320404D8F5AFD_1740277124 = (super.isShifted());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775545806 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775545806;
        } //End block
        // ---------- Original Method ----------
        //if (mShiftKeys[0] != null) {
            //return mShiftState != SHIFT_OFF;
        //} else {
            //return super.isShifted();
        //}
    }

    
    static class LatinKey extends Keyboard.Key {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.115 -0400", hash_original_field = "795BD0A10F0602C9B4F9F29433079F4A", hash_generated_field = "151B0DB46BB7EC922486819BAE8EC8E1")

        private boolean mShiftLockEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.115 -0400", hash_original_field = "71AB1146E1CEE92AB74D832DEFFE135F", hash_generated_field = "8BBE5745FA7C6470C8EA4F0513877CD6")

        private boolean mEnabled = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.116 -0400", hash_original_method = "71F937C92311051FB86E96C31EF889D4", hash_generated_method = "72755750E56404D045E5BB90A816357A")
        public  LatinKey(Resources res, Keyboard.Row parent, int x, int y,
                XmlResourceParser parser) {
            super(res, parent, x, y, parser);
            addTaint(parser.getTaint());
            addTaint(y);
            addTaint(x);
            addTaint(parent.getTaint());
            addTaint(res.getTaint());
            if(popupCharacters!=null&&popupCharacters.length()==0)            
            {
popupResId=0
            } //End block
            // ---------- Original Method ----------
            //if (popupCharacters != null && popupCharacters.length() == 0) {
                //popupResId = 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.116 -0400", hash_original_method = "E431274334564F99DE06BE0647F24670", hash_generated_method = "966D4C2E73EE646AD0A53E760FA027F1")
         void setEnabled(boolean enabled) {
            addTaint(enabled);
mEnabled=enabled
            // ---------- Original Method ----------
            //mEnabled = enabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.116 -0400", hash_original_method = "830DE4AA604F63C85B7618AB8744071C", hash_generated_method = "7365B5CE30F739C58AA5B8133B5229F8")
         void enableShiftLock() {
mShiftLockEnabled=true
            // ---------- Original Method ----------
            //mShiftLockEnabled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.117 -0400", hash_original_method = "7C218F05A693710E7ECD3CB507B10605", hash_generated_method = "AC3D5C02EF246D68F0C637D8A88A6216")
        @Override
        public void onReleased(boolean inside) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(inside);
            if(!mShiftLockEnabled)            
            {
super.onReleased(inside)
            } //End block
            else
            {
pressed=!pressed
            } //End block
            // ---------- Original Method ----------
            //if (!mShiftLockEnabled) {
                //super.onReleased(inside);
            //} else {
                //pressed = !pressed;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.118 -0400", hash_original_method = "B303B38B66FD048816A5DEA3EEE636EE", hash_generated_method = "2626ACC074662C4EBEE5C84D4F64A8B0")
        @Override
        public boolean isInside(int x, int y) {
            addTaint(y);
            addTaint(x);
            if(!mEnabled)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1432651348 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857378914 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_857378914;
            } //End block
            final int code = codes[0];
            if(code==KEYCODE_SHIFT||code==KEYCODE_DELETE)            
            {
y-=height/10                if(code==KEYCODE_SHIFT)                
x+=width/6
                if(code==KEYCODE_DELETE)                
x-=width/6
            } //End block
            else
            if(code==KEYCODE_SPACE)            
            {
y+=PasswordEntryKeyboard.sSpacebarVerticalCorrection
            } //End block
            boolean varF51987AA3A36DF36B268E07327A833F7_470665820 = (super.isInside(x, y));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1203212782 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1203212782;
            // ---------- Original Method ----------
            //if (!mEnabled) {
                //return false;
            //}
            //final int code = codes[0];
            //if (code == KEYCODE_SHIFT || code == KEYCODE_DELETE) {
                //y -= height / 10;
                //if (code == KEYCODE_SHIFT) x += width / 6;
                //if (code == KEYCODE_DELETE) x -= width / 6;
            //} else if (code == KEYCODE_SPACE) {
                //y += PasswordEntryKeyboard.sSpacebarVerticalCorrection;
            //}
            //return super.isInside(x, y);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.119 -0400", hash_original_field = "60B26E66C68CEC2A00288A16D992DAEC", hash_generated_field = "C1A5D1D15F685B946B8E190A1B1F23A7")

    private static final int SHIFT_OFF = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.119 -0400", hash_original_field = "D53AE134ACCF45DF44CFE0846E69AD90", hash_generated_field = "3FEE3FCD872BF56F9BCEF85F15CE6155")

    private static final int SHIFT_ON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.119 -0400", hash_original_field = "1C1030AB0F2365A3DF4413FAF55E186E", hash_generated_field = "08E5021148B5A01F1B0DE314527EC612")

    private static final int SHIFT_LOCKED = 2;

