package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView.Tokenizer;

public class MultiAutoCompleteTextView extends AutoCompleteTextView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.328 -0400", hash_original_field = "F17D9A2BC894EC426CD0CB6E97DFAED1", hash_generated_field = "DC05FA21DC7A9D97C12BF9C7B68E4314")

    private Tokenizer mTokenizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.328 -0400", hash_original_method = "94554F2B341FB5EE45055739E2680C3D", hash_generated_method = "0A88EE5AB96F3B62E46AEB165D2D7CCB")
    public  MultiAutoCompleteTextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.328 -0400", hash_original_method = "42976CB810392B93881A9DEB6E0BA159", hash_generated_method = "32E4736B2995391A52228B1CF7ED9347")
    public  MultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.autoCompleteTextViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.329 -0400", hash_original_method = "C6A2FA85257B49A1F6B493810F60209F", hash_generated_method = "372B75242DB968717AD3CD35B8F39199")
    public  MultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.329 -0400", hash_original_method = "BCA16A32890B669BA239C7F8E91B803C", hash_generated_method = "54CDFBC681C1E3EEE4A842CD88F26A03")
     void finishInit() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.329 -0400", hash_original_method = "0C1CB9531D2E188C8CD299E678A81235", hash_generated_method = "3641C7F0ADB77417CC960DAB0B499BB5")
    public void setTokenizer(Tokenizer t) {
        mTokenizer = t;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.330 -0400", hash_original_method = "D73EB2C94DEE4722FCE1B5247E851200", hash_generated_method = "4FD1C0F389BF670675477F792AD56309")
    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        addTaint(keyCode);
        addTaint(text.getTaint());
    if(enoughToFilter())        
        {
            int end = getSelectionEnd();
            int start = mTokenizer.findTokenStart(text, end);
            performFiltering(text, start, end, keyCode);
        } 
        else
        {
            dismissDropDown();
            Filter f = getFilter();
    if(f != null)            
            {
                f.filter(null);
            } 
        } 
        
        
            
            
            
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.330 -0400", hash_original_method = "4B7E111CDE46EB7665419BBE701F6868", hash_generated_method = "A3DDED46BDE7EAC00EFA1E73D40D43A5")
    @Override
    public boolean enoughToFilter() {
        Editable text = getText();
        int end = getSelectionEnd();
    if(end < 0 || mTokenizer == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1909764414 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822282536 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822282536;
        } 
        int start = mTokenizer.findTokenStart(text, end);
    if(end - start >= getThreshold())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_50374584 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431386573 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_431386573;
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_789618032 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074759426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074759426;
        } 
        
        
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.331 -0400", hash_original_method = "5C2EFC56A6F7A7D1FB121838E719CAA2", hash_generated_method = "2DAEADCFF1231BA145B288355F2F9DFF")
    @Override
    public void performValidation() {
        Validator v = getValidator();
    if(v == null || mTokenizer == null)        
        {
            return;
        } 
        Editable e = getText();
        int i = getText().length();
        while
(i > 0)        
        {
            int start = mTokenizer.findTokenStart(e, i);
            int end = mTokenizer.findTokenEnd(e, start);
            CharSequence sub = e.subSequence(start, end);
    if(TextUtils.isEmpty(sub))            
            {
                e.replace(start, i, "");
            } 
            else
    if(!v.isValid(sub))            
            {
                e.replace(start, i,
                          mTokenizer.terminateToken(v.fixText(sub)));
            } 
            i = start;
        } 
        
        
        
            
        
        
        
        
            
            
            
            
                
            
                
                          
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.332 -0400", hash_original_method = "448D969C1E669B05B875BF81D75455EA", hash_generated_method = "58DD7517C0DBC5F8EE335C8FA607ACD6")
    protected void performFiltering(CharSequence text, int start, int end,
                                    int keyCode) {
        addTaint(keyCode);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        getFilter().filter(text.subSequence(start, end), this);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.332 -0400", hash_original_method = "0BC14D3B618E827E554DDB675E2805A0", hash_generated_method = "615135CFC8F7142BF4FDE3744700327C")
    @Override
    protected void replaceText(CharSequence text) {
        addTaint(text.getTaint());
        clearComposingText();
        int end = getSelectionEnd();
        int start = mTokenizer.findTokenStart(getText(), end);
        Editable editable = getText();
        String original = TextUtils.substring(editable, start, end);
        QwertyKeyListener.markAsReplaced(editable, start, end, original);
        editable.replace(start, end, mTokenizer.terminateToken(text));
        
        
        
        
        
        
        
        
    }

    
    public static class CommaTokenizer implements Tokenizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.333 -0400", hash_original_method = "F4BA1DCA501F72677108996A68C84C7B", hash_generated_method = "F4BA1DCA501F72677108996A68C84C7B")
        public CommaTokenizer ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.333 -0400", hash_original_method = "280529F27A16CE7436996477971C2C62", hash_generated_method = "14F68C698262BC73D80AAE32CBCCD2E7")
        public int findTokenStart(CharSequence text, int cursor) {
            addTaint(cursor);
            addTaint(text.getTaint());
            int i = cursor;
            while
(i > 0 && text.charAt(i - 1) != ',')            
            {
                i--;
            } 
            while
(i < cursor && text.charAt(i) == ' ')            
            {
                i++;
            } 
            int var865C0C0B4AB0E063E5CAA3387C1A8741_1518832319 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706306560 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706306560;
            
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.333 -0400", hash_original_method = "4F25D72B16DCF82C04DD0624B35F7FC4", hash_generated_method = "AA63AFCECBAE9F880F1CF9728BA57327")
        public int findTokenEnd(CharSequence text, int cursor) {
            addTaint(cursor);
            addTaint(text.getTaint());
            int i = cursor;
            int len = text.length();
            while
(i < len)            
            {
    if(text.charAt(i) == ',')                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_680144650 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921242205 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921242205;
                } 
                else
                {
                    i++;
                } 
            } 
            int varF5A8E923F8CD24B56B3BAB32358CC58A_1519573409 = (len);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194370649 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194370649;
            
            
            
            
                
                    
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.334 -0400", hash_original_method = "C1C1FDB4C90D17F74901681402AEE8BB", hash_generated_method = "C0A3E03C7F25534528F88837A4BC1AF3")
        public CharSequence terminateToken(CharSequence text) {
            addTaint(text.getTaint());
            int i = text.length();
            while
(i > 0 && text.charAt(i - 1) == ' ')            
            {
                i--;
            } 
    if(i > 0 && text.charAt(i - 1) == ',')            
            {
CharSequence var79CC641C1148018540A26F7ADC424893_1912069239 =                 text;
                var79CC641C1148018540A26F7ADC424893_1912069239.addTaint(taint);
                return var79CC641C1148018540A26F7ADC424893_1912069239;
            } 
            else
            {
    if(text instanceof Spanned)                
                {
                    SpannableString sp = new SpannableString(text + ", ");
                    TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                                            Object.class, sp, 0);
CharSequence varA4DCFF844B7753D115259E5560FDE637_441723960 =                     sp;
                    varA4DCFF844B7753D115259E5560FDE637_441723960.addTaint(taint);
                    return varA4DCFF844B7753D115259E5560FDE637_441723960;
                } 
                else
                {
CharSequence var5D7AD4DC0F1248601127BB40BD3AC89B_1116525334 =                     text + ", ";
                    var5D7AD4DC0F1248601127BB40BD3AC89B_1116525334.addTaint(taint);
                    return var5D7AD4DC0F1248601127BB40BD3AC89B_1116525334;
                } 
            } 
            
            
            
                
            
            
                
            
                
                    
                    
                                            
                    
                
                    
                
            
        }

        
    }


    
    public static interface Tokenizer {
        
        public int findTokenStart(CharSequence text, int cursor);

        
        public int findTokenEnd(CharSequence text, int cursor);

        
        public CharSequence terminateToken(CharSequence text);
    }
    
}

