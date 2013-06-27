package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.NativeBreakIterator;

class RuleBasedBreakIterator extends BreakIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.630 -0400", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "F8A2ED20A01EA7682FD7468CB9B145ED")
      RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.631 -0400", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "CC7A86DF7C4CE5D6A7A057E3B1DC4780")
    @Override
    public int current() {
        int varBA2D2D328ED3FEB82FDEC26256251008_1998316922 = (wrapped.current());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134782297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134782297;
        // ---------- Original Method ----------
        //return wrapped.current();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.631 -0400", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "809747378639C7A491060E80D32FC6A4")
    @Override
    public int first() {
        int var36D1CDF8ADA63B3D5029220AC494B86E_1142279859 = (wrapped.first());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764553185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764553185;
        // ---------- Original Method ----------
        //return wrapped.first();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.631 -0400", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "A888E0797BE9FED3308DD14747EDF421")
    @Override
    public int following(int offset) {
        validateOffset(offset);
        int var75F33A3A54BD8ECCB2BD217DEAF83F07_1897570855 = (wrapped.following(offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941667429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941667429;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.following(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.632 -0400", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "2583C0CBAFF947FA3EB8321D46FDA167")
    private void validateOffset(int offset) {
        CharacterIterator it;
        it = wrapped.getText();
        {
            boolean varC65F6973E2FE73C836438C11BE38F2CD_1046491554 = (offset < it.getBeginIndex() || offset > it.getEndIndex());
            {
                String message;
                message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(message);
            } //End block
        } //End collapsed parenthetic
        addTaint(offset);
        // ---------- Original Method ----------
        //CharacterIterator it = wrapped.getText();
        //if (offset < it.getBeginIndex() || offset > it.getEndIndex()) {
            //String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            //throw new IllegalArgumentException(message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.638 -0400", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "945B377A696D1D78665578A087DFC701")
    @Override
    public CharacterIterator getText() {
        CharacterIterator varB4EAC82CA7396A68D541C85D26508E83_31882980 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_31882980 = wrapped.getText();
        varB4EAC82CA7396A68D541C85D26508E83_31882980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_31882980;
        // ---------- Original Method ----------
        //return wrapped.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.656 -0400", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "D2C314A1E03E65FCCD55211F16A433AD")
    @Override
    public int last() {
        int varD1F8981D06B202D2735FED0F8DF46D3D_165735049 = (wrapped.last());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331980599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331980599;
        // ---------- Original Method ----------
        //return wrapped.last();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.656 -0400", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "CDF754E86B1264747B35566C94963AB3")
    @Override
    public int next() {
        int var97CE2BF603169EE51D940732E4D0F4C4_1494710445 = (wrapped.next());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2024209631 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2024209631;
        // ---------- Original Method ----------
        //return wrapped.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.656 -0400", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "3D70D1E8FC16326BED803FE03579E9DE")
    @Override
    public int next(int n) {
        int var0612142A9906CA6FC60CA7D0A48F42DF_95258124 = (wrapped.next(n));
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446895600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446895600;
        // ---------- Original Method ----------
        //return wrapped.next(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.657 -0400", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "EC12725C3818405859FAC64522B280FD")
    @Override
    public int previous() {
        int var510E4D6C7FBCF98CE6E4FAEE433EAFEB_1469029638 = (wrapped.previous());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442385422 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442385422;
        // ---------- Original Method ----------
        //return wrapped.previous();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.658 -0400", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "730A775296B8F58A45F66E4C2733B1DC")
    @Override
    public void setText(CharacterIterator newText) {
        newText.current();
        wrapped.setText(newText);
        addTaint(newText.getTaint());
        // ---------- Original Method ----------
        //newText.current();
        //wrapped.setText(newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.658 -0400", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "4C9DFC3101E08DD824B73E3CDB278650")
    @Override
    public boolean isBoundary(int offset) {
        validateOffset(offset);
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_921227242 = (wrapped.isBoundary(offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1289223714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1289223714;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.658 -0400", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "A6244841B84C74DCD33FB9F06083832D")
    @Override
    public int preceding(int offset) {
        validateOffset(offset);
        int var14341653A1F5B35705434E8CE35431DA_1311746764 = (wrapped.preceding(offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536094860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536094860;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.659 -0400", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "967313A2A53FE44D8E6EC10F2DD6F1B7")
    @Override
    public boolean equals(Object o) {
        boolean varBF51C9780ECBD6F6B46C06750D92229D_609554736 = (wrapped.equals(((RuleBasedBreakIterator) o).wrapped));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056834349 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056834349;
        // ---------- Original Method ----------
        //if (!(o instanceof RuleBasedBreakIterator)) {
            //return false;
        //}
        //return wrapped.equals(((RuleBasedBreakIterator) o).wrapped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.673 -0400", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "BAA452D7099C1AABE46636B5DD215CC5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_873658345 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_873658345 = wrapped.toString();
        varB4EAC82CA7396A68D541C85D26508E83_873658345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873658345;
        // ---------- Original Method ----------
        //return wrapped.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.673 -0400", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "F031A18E3175B98325DC6E9920C8E8D6")
    @Override
    public int hashCode() {
        int var82A751D45FBB4EB1094404B61E0EB533_601090222 = (wrapped.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998158421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998158421;
        // ---------- Original Method ----------
        //return wrapped.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.674 -0400", hash_original_method = "CB8345057924EAB3D86F5E280E0AFDC7", hash_generated_method = "2AE57F005F4AB1B784314C8353871D2C")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_753838872 = null; //Variable for return #1
        RuleBasedBreakIterator cloned;
        cloned = (RuleBasedBreakIterator) super.clone();
        cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        varB4EAC82CA7396A68D541C85D26508E83_753838872 = cloned;
        varB4EAC82CA7396A68D541C85D26508E83_753838872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_753838872;
        // ---------- Original Method ----------
        //RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        //return cloned;
    }

    
}

