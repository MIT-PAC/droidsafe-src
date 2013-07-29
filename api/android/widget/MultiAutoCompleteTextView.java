package android.widget;

// Droidsafe Imports
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MultiAutoCompleteTextView extends AutoCompleteTextView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.362 -0400", hash_original_field = "F17D9A2BC894EC426CD0CB6E97DFAED1", hash_generated_field = "DC05FA21DC7A9D97C12BF9C7B68E4314")

    private Tokenizer mTokenizer;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.363 -0400", hash_original_method = "94554F2B341FB5EE45055739E2680C3D", hash_generated_method = "0A88EE5AB96F3B62E46AEB165D2D7CCB")
    public  MultiAutoCompleteTextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.363 -0400", hash_original_method = "42976CB810392B93881A9DEB6E0BA159", hash_generated_method = "32E4736B2995391A52228B1CF7ED9347")
    public  MultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.autoCompleteTextViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.363 -0400", hash_original_method = "C6A2FA85257B49A1F6B493810F60209F", hash_generated_method = "372B75242DB968717AD3CD35B8F39199")
    public  MultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.363 -0400", hash_original_method = "BCA16A32890B669BA239C7F8E91B803C", hash_generated_method = "54CDFBC681C1E3EEE4A842CD88F26A03")
     void finishInit() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.364 -0400", hash_original_method = "0C1CB9531D2E188C8CD299E678A81235", hash_generated_method = "3641C7F0ADB77417CC960DAB0B499BB5")
    public void setTokenizer(Tokenizer t) {
        mTokenizer = t;
        // ---------- Original Method ----------
        //mTokenizer = t;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.365 -0400", hash_original_method = "D73EB2C94DEE4722FCE1B5247E851200", hash_generated_method = "4FD1C0F389BF670675477F792AD56309")
    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        addTaint(keyCode);
        addTaint(text.getTaint());
        if(enoughToFilter())        
        {
            int end = getSelectionEnd();
            int start = mTokenizer.findTokenStart(text, end);
            performFiltering(text, start, end, keyCode);
        } //End block
        else
        {
            dismissDropDown();
            Filter f = getFilter();
            if(f != null)            
            {
                f.filter(null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (enoughToFilter()) {
            //int end = getSelectionEnd();
            //int start = mTokenizer.findTokenStart(text, end);
            //performFiltering(text, start, end, keyCode);
        //} else {
            //dismissDropDown();
            //Filter f = getFilter();
            //if (f != null) {
                //f.filter(null);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.365 -0400", hash_original_method = "4B7E111CDE46EB7665419BBE701F6868", hash_generated_method = "D5CEB5521BDBEFF42BD9153E05550746")
    @Override
    public boolean enoughToFilter() {
        Editable text = getText();
        int end = getSelectionEnd();
        if(end < 0 || mTokenizer == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1316413916 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951863226 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951863226;
        } //End block
        int start = mTokenizer.findTokenStart(text, end);
        if(end - start >= getThreshold())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1844607313 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423489070 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423489070;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_491865517 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348529471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348529471;
        } //End block
        // ---------- Original Method ----------
        //Editable text = getText();
        //int end = getSelectionEnd();
        //if (end < 0 || mTokenizer == null) {
            //return false;
        //}
        //int start = mTokenizer.findTokenStart(text, end);
        //if (end - start >= getThreshold()) {
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.366 -0400", hash_original_method = "5C2EFC56A6F7A7D1FB121838E719CAA2", hash_generated_method = "2DAEADCFF1231BA145B288355F2F9DFF")
    @Override
    public void performValidation() {
        Validator v = getValidator();
        if(v == null || mTokenizer == null)        
        {
            return;
        } //End block
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
            } //End block
            else
            if(!v.isValid(sub))            
            {
                e.replace(start, i,
                          mTokenizer.terminateToken(v.fixText(sub)));
            } //End block
            i = start;
        } //End block
        // ---------- Original Method ----------
        //Validator v = getValidator();
        //if (v == null || mTokenizer == null) {
            //return;
        //}
        //Editable e = getText();
        //int i = getText().length();
        //while (i > 0) {
            //int start = mTokenizer.findTokenStart(e, i);
            //int end = mTokenizer.findTokenEnd(e, start);
            //CharSequence sub = e.subSequence(start, end);
            //if (TextUtils.isEmpty(sub)) {
                //e.replace(start, i, "");
            //} else if (!v.isValid(sub)) {
                //e.replace(start, i,
                          //mTokenizer.terminateToken(v.fixText(sub)));
            //}
            //i = start;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.367 -0400", hash_original_method = "448D969C1E669B05B875BF81D75455EA", hash_generated_method = "58DD7517C0DBC5F8EE335C8FA607ACD6")
    protected void performFiltering(CharSequence text, int start, int end,
                                    int keyCode) {
        addTaint(keyCode);
        addTaint(end);
        addTaint(start);
        addTaint(text.getTaint());
        getFilter().filter(text.subSequence(start, end), this);
        // ---------- Original Method ----------
        //getFilter().filter(text.subSequence(start, end), this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.368 -0400", hash_original_method = "0BC14D3B618E827E554DDB675E2805A0", hash_generated_method = "615135CFC8F7142BF4FDE3744700327C")
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
        // ---------- Original Method ----------
        //clearComposingText();
        //int end = getSelectionEnd();
        //int start = mTokenizer.findTokenStart(getText(), end);
        //Editable editable = getText();
        //String original = TextUtils.substring(editable, start, end);
        //QwertyKeyListener.markAsReplaced(editable, start, end, original);
        //editable.replace(start, end, mTokenizer.terminateToken(text));
    }

    
    public static class CommaTokenizer implements Tokenizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.368 -0400", hash_original_method = "F4BA1DCA501F72677108996A68C84C7B", hash_generated_method = "F4BA1DCA501F72677108996A68C84C7B")
        public CommaTokenizer ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.368 -0400", hash_original_method = "280529F27A16CE7436996477971C2C62", hash_generated_method = "181AD7875ABC89454D6526D7085E2E0C")
        public int findTokenStart(CharSequence text, int cursor) {
            addTaint(cursor);
            addTaint(text.getTaint());
            int i = cursor;
            while
(i > 0 && text.charAt(i - 1) != ',')            
            {
                i--;
            } //End block
            while
(i < cursor && text.charAt(i) == ' ')            
            {
                i++;
            } //End block
            int var865C0C0B4AB0E063E5CAA3387C1A8741_8138070 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328869648 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328869648;
            // ---------- Original Method ----------
            //int i = cursor;
            //while (i > 0 && text.charAt(i - 1) != ',') {
                //i--;
            //}
            //while (i < cursor && text.charAt(i) == ' ') {
                //i++;
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.369 -0400", hash_original_method = "4F25D72B16DCF82C04DD0624B35F7FC4", hash_generated_method = "7E78A5E7CE9B3D7983401C143E1A904F")
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
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1374846983 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806321729 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806321729;
                } //End block
                else
                {
                    i++;
                } //End block
            } //End block
            int varF5A8E923F8CD24B56B3BAB32358CC58A_1376175127 = (len);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376337232 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376337232;
            // ---------- Original Method ----------
            //int i = cursor;
            //int len = text.length();
            //while (i < len) {
                //if (text.charAt(i) == ',') {
                    //return i;
                //} else {
                    //i++;
                //}
            //}
            //return len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.370 -0400", hash_original_method = "C1C1FDB4C90D17F74901681402AEE8BB", hash_generated_method = "702F4ECB1C0D9C36E02E3459FEBA5727")
        public CharSequence terminateToken(CharSequence text) {
            addTaint(text.getTaint());
            int i = text.length();
            while
(i > 0 && text.charAt(i - 1) == ' ')            
            {
                i--;
            } //End block
            if(i > 0 && text.charAt(i - 1) == ',')            
            {
CharSequence var79CC641C1148018540A26F7ADC424893_972744283 =                 text;
                var79CC641C1148018540A26F7ADC424893_972744283.addTaint(taint);
                return var79CC641C1148018540A26F7ADC424893_972744283;
            } //End block
            else
            {
                if(text instanceof Spanned)                
                {
                    SpannableString sp = new SpannableString(text + ", ");
                    TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                                            Object.class, sp, 0);
CharSequence varA4DCFF844B7753D115259E5560FDE637_1606630808 =                     sp;
                    varA4DCFF844B7753D115259E5560FDE637_1606630808.addTaint(taint);
                    return varA4DCFF844B7753D115259E5560FDE637_1606630808;
                } //End block
                else
                {
CharSequence var5D7AD4DC0F1248601127BB40BD3AC89B_359535042 =                     text + ", ";
                    var5D7AD4DC0F1248601127BB40BD3AC89B_359535042.addTaint(taint);
                    return var5D7AD4DC0F1248601127BB40BD3AC89B_359535042;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //int i = text.length();
            //while (i > 0 && text.charAt(i - 1) == ' ') {
                //i--;
            //}
            //if (i > 0 && text.charAt(i - 1) == ',') {
                //return text;
            //} else {
                //if (text instanceof Spanned) {
                    //SpannableString sp = new SpannableString(text + ", ");
                    //TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                                            //Object.class, sp, 0);
                    //return sp;
                //} else {
                    //return text + ", ";
                //}
            //}
        }

        
    }


    
    public static interface Tokenizer {
        
        public int findTokenStart(CharSequence text, int cursor);

        
        public int findTokenEnd(CharSequence text, int cursor);

        
        public CharSequence terminateToken(CharSequence text);
    }
    
}

