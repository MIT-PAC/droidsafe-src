package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.NativeBreakIterator;

class RuleBasedBreakIterator extends BreakIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.501 -0400", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "D63EC8F8052DEB82C9B00437DAC7B099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
        dsTaint.addTaint(iterator.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.501 -0400", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "6343BF81B8B07D9FA059D84E1CF52291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int current() {
        int varBA2D2D328ED3FEB82FDEC26256251008_578311412 = (wrapped.current());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.current();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.501 -0400", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "32F070048E0EE4698DEA95AEAF225A20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int first() {
        int var36D1CDF8ADA63B3D5029220AC494B86E_1016314248 = (wrapped.first());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.first();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.501 -0400", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "82311CD4FCD8E9C78FDB60D7E01EB56D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int following(int offset) {
        dsTaint.addTaint(offset);
        validateOffset(offset);
        int var75F33A3A54BD8ECCB2BD217DEAF83F07_1627075882 = (wrapped.following(offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.following(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.502 -0400", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "8F84DC028E306F846FDFF671BC4B7CD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateOffset(int offset) {
        dsTaint.addTaint(offset);
        CharacterIterator it;
        it = wrapped.getText();
        {
            boolean varC65F6973E2FE73C836438C11BE38F2CD_1223068181 = (offset < it.getBeginIndex() || offset > it.getEndIndex());
            {
                String message;
                message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(message);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //CharacterIterator it = wrapped.getText();
        //if (offset < it.getBeginIndex() || offset > it.getEndIndex()) {
            //String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            //throw new IllegalArgumentException(message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.502 -0400", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "727BC51685F197207254CA5DCDA28AF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharacterIterator getText() {
        CharacterIterator varC63D82DF9EE93BF3F56D6A9953008B0C_78645042 = (wrapped.getText());
        return (CharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.502 -0400", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "8A8A16D545F3152FEFEB5DAF37F918F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int last() {
        int varD1F8981D06B202D2735FED0F8DF46D3D_1653041916 = (wrapped.last());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.last();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.503 -0400", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "87378A1EC63E564953D6C76B2E4665FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int next() {
        int var97CE2BF603169EE51D940732E4D0F4C4_1009264008 = (wrapped.next());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.503 -0400", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "28B7FC75004FFC7FBC2DADDD0230103E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int next(int n) {
        dsTaint.addTaint(n);
        int var0612142A9906CA6FC60CA7D0A48F42DF_1806057339 = (wrapped.next(n));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.next(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.503 -0400", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "D0202D5023057FF9C2726EF7668E7727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int previous() {
        int var510E4D6C7FBCF98CE6E4FAEE433EAFEB_1004298961 = (wrapped.previous());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.previous();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.503 -0400", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "DEC4A201BB2841B7E4AEFA74FA05EBAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setText(CharacterIterator newText) {
        dsTaint.addTaint(newText.dsTaint);
        newText.current();
        wrapped.setText(newText);
        // ---------- Original Method ----------
        //newText.current();
        //wrapped.setText(newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.503 -0400", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "18774E653C8B5E24F23BEA3F51B1323E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isBoundary(int offset) {
        dsTaint.addTaint(offset);
        validateOffset(offset);
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_1175449638 = (wrapped.isBoundary(offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.504 -0400", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "A63DBEDF2425F8D67C832F1B9A8180C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        validateOffset(offset);
        int var14341653A1F5B35705434E8CE35431DA_355535550 = (wrapped.preceding(offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.504 -0400", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "B60A888DFF27C49E18C9EE5A3B05351E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean varBF51C9780ECBD6F6B46C06750D92229D_1895760205 = (wrapped.equals(((RuleBasedBreakIterator) o).wrapped));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(o instanceof RuleBasedBreakIterator)) {
            //return false;
        //}
        //return wrapped.equals(((RuleBasedBreakIterator) o).wrapped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.504 -0400", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "3DEBAB8F3B2EBF9F4719F921AE3AAB31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varEA77B0FE5C684DAECB2AA627294C877A_382579628 = (wrapped.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return wrapped.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.504 -0400", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "F2A73F247A5356C47CCE9B8951A02477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var82A751D45FBB4EB1094404B61E0EB533_823685113 = (wrapped.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.504 -0400", hash_original_method = "CB8345057924EAB3D86F5E280E0AFDC7", hash_generated_method = "B630EB0550DCD5FDA467808AC4597CF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        RuleBasedBreakIterator cloned;
        cloned = (RuleBasedBreakIterator) super.clone();
        cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        //return cloned;
    }

    
}

