package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import libcore.icu.NativeBreakIterator;

class RuleBasedBreakIterator extends BreakIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.784 -0400", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "5812B1C5D1480A4611918ADAF9DC62DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
        dsTaint.addTaint(iterator.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.786 -0400", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "784CD2C2C1BD6ABB5D39A5325100A661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int current() {
        int varBA2D2D328ED3FEB82FDEC26256251008_1887841699 = (wrapped.current());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.current();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.787 -0400", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "956097705FEE837BE20C07327F408C79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int first() {
        int var36D1CDF8ADA63B3D5029220AC494B86E_294216003 = (wrapped.first());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.first();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.788 -0400", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "DEDE6CBF4F75278CA1B76E605E43A255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int following(int offset) {
        dsTaint.addTaint(offset);
        validateOffset(offset);
        int var75F33A3A54BD8ECCB2BD217DEAF83F07_966203217 = (wrapped.following(offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.following(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.790 -0400", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "C538305121E2E57DDB24FEE512C945CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateOffset(int offset) {
        dsTaint.addTaint(offset);
        CharacterIterator it;
        it = wrapped.getText();
        {
            boolean varC65F6973E2FE73C836438C11BE38F2CD_262625891 = (offset < it.getBeginIndex() || offset > it.getEndIndex());
            {
                String message;
                message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
                throw new IllegalArgumentException(message);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //CharacterIterator it = wrapped.getText();
        //if (offset < it.getBeginIndex() || offset > it.getEndIndex()) {
            //String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            //throw new IllegalArgumentException(message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.791 -0400", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "662F2191D0255D9A640362F0DF23E43D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharacterIterator getText() {
        CharacterIterator varC63D82DF9EE93BF3F56D6A9953008B0C_783424186 = (wrapped.getText());
        return (CharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrapped.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.791 -0400", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "BF84C20E5D62B66451E0ECEFCF66A962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int last() {
        int varD1F8981D06B202D2735FED0F8DF46D3D_1557529905 = (wrapped.last());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.last();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.792 -0400", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "A05CED35661DB10FB15ABD318E2C3F85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int next() {
        int var97CE2BF603169EE51D940732E4D0F4C4_483218956 = (wrapped.next());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.793 -0400", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "9C1CC7ECB4B393FE627EA089D87BD286")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int next(int n) {
        dsTaint.addTaint(n);
        int var0612142A9906CA6FC60CA7D0A48F42DF_46470152 = (wrapped.next(n));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.next(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.794 -0400", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "2F5248C6BCC4169E3ED67D6EE4BFDA4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int previous() {
        int var510E4D6C7FBCF98CE6E4FAEE433EAFEB_1969958608 = (wrapped.previous());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.previous();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.795 -0400", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "481771631144387760CC8347DDC7246E")
    @DSModeled(DSC.SAFE)
    @Override
    public void setText(CharacterIterator newText) {
        dsTaint.addTaint(newText.dsTaint);
        newText.current();
        wrapped.setText(newText);
        // ---------- Original Method ----------
        //newText.current();
        //wrapped.setText(newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.796 -0400", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "6B33A7CB2EFCBA4D2A6299EAA4C2A4DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isBoundary(int offset) {
        dsTaint.addTaint(offset);
        validateOffset(offset);
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_1757304830 = (wrapped.isBoundary(offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.797 -0400", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "0492BD323B7B49A20C7C41F6A3B78229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        validateOffset(offset);
        int var14341653A1F5B35705434E8CE35431DA_1268830714 = (wrapped.preceding(offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.798 -0400", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "A29C007F22086986F7739C5FC1854403")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean varBF51C9780ECBD6F6B46C06750D92229D_1920024764 = (wrapped.equals(((RuleBasedBreakIterator) o).wrapped));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(o instanceof RuleBasedBreakIterator)) {
            //return false;
        //}
        //return wrapped.equals(((RuleBasedBreakIterator) o).wrapped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.799 -0400", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "D426CEA0C9EA46C595DEC02ED592B43C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varEA77B0FE5C684DAECB2AA627294C877A_1082104078 = (wrapped.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return wrapped.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:37:46.800 -0400", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "844AA9991F7470A58782767AF42DBA0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var82A751D45FBB4EB1094404B61E0EB533_1747015739 = (wrapped.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return wrapped.hashCode();
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 15:32:19.700 -0400",hash_original_method="CB8345057924EAB3D86F5E280E0AFDC7",hash_generated_method="7A3889955E24DA3835A78A57C533C6FE")
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


