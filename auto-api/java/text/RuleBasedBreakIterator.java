package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.icu.NativeBreakIterator;

class RuleBasedBreakIterator extends BreakIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.805 -0400", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "F8A2ED20A01EA7682FD7468CB9B145ED")
      RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.813 -0400", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "EE59D6438A412AE1611BFE4A8FC66D38")
    @Override
    public int current() {
        int varBA2D2D328ED3FEB82FDEC26256251008_1305923662 = (wrapped.current());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941919127 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941919127;
        // ---------- Original Method ----------
        //return wrapped.current();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.814 -0400", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "5E874041F0C0FAEB207438F4AC02A3DC")
    @Override
    public int first() {
        int var36D1CDF8ADA63B3D5029220AC494B86E_1203344726 = (wrapped.first());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522452346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1522452346;
        // ---------- Original Method ----------
        //return wrapped.first();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.820 -0400", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "BF1ED385A7E5176FE5FD80686FB3605F")
    @Override
    public int following(int offset) {
        validateOffset(offset);
        int var75F33A3A54BD8ECCB2BD217DEAF83F07_183972034 = (wrapped.following(offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412862171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412862171;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.following(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.820 -0400", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "A8B588DE79E101F3B24386784353A56A")
    private void validateOffset(int offset) {
        CharacterIterator it;
        it = wrapped.getText();
        {
            boolean varC65F6973E2FE73C836438C11BE38F2CD_599048112 = (offset < it.getBeginIndex() || offset > it.getEndIndex());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.821 -0400", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "CEF304D1B825E505ECE9ADAC1224DF49")
    @Override
    public CharacterIterator getText() {
        CharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1620020814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1620020814 = wrapped.getText();
        varB4EAC82CA7396A68D541C85D26508E83_1620020814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1620020814;
        // ---------- Original Method ----------
        //return wrapped.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.821 -0400", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "8E2C3A929766FDC621F58342BF9A4A0C")
    @Override
    public int last() {
        int varD1F8981D06B202D2735FED0F8DF46D3D_1429309957 = (wrapped.last());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665989350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665989350;
        // ---------- Original Method ----------
        //return wrapped.last();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.821 -0400", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "2CCF4167940C284995DB2E707ED88D4D")
    @Override
    public int next() {
        int var97CE2BF603169EE51D940732E4D0F4C4_1028616004 = (wrapped.next());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677325401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677325401;
        // ---------- Original Method ----------
        //return wrapped.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.821 -0400", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "DDDF810E628057FBBE344B41E440201B")
    @Override
    public int next(int n) {
        int var0612142A9906CA6FC60CA7D0A48F42DF_796708512 = (wrapped.next(n));
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226872527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226872527;
        // ---------- Original Method ----------
        //return wrapped.next(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.822 -0400", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "9C1BDB6526F4E1A2A691610CC3471E8A")
    @Override
    public int previous() {
        int var510E4D6C7FBCF98CE6E4FAEE433EAFEB_1813661633 = (wrapped.previous());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394821504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394821504;
        // ---------- Original Method ----------
        //return wrapped.previous();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.822 -0400", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "730A775296B8F58A45F66E4C2733B1DC")
    @Override
    public void setText(CharacterIterator newText) {
        newText.current();
        wrapped.setText(newText);
        addTaint(newText.getTaint());
        // ---------- Original Method ----------
        //newText.current();
        //wrapped.setText(newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.822 -0400", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "9E32CC1973816450A54BB87822DDF709")
    @Override
    public boolean isBoundary(int offset) {
        validateOffset(offset);
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_1512135564 = (wrapped.isBoundary(offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668675429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668675429;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.823 -0400", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "386617BB3344307DA2A69907F4B19763")
    @Override
    public int preceding(int offset) {
        validateOffset(offset);
        int var14341653A1F5B35705434E8CE35431DA_1779552783 = (wrapped.preceding(offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456916862 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456916862;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.828 -0400", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "FBD135A385CBB8E08BAE1BF4A24038DC")
    @Override
    public boolean equals(Object o) {
        boolean varBF51C9780ECBD6F6B46C06750D92229D_1450436740 = (wrapped.equals(((RuleBasedBreakIterator) o).wrapped));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016415175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016415175;
        // ---------- Original Method ----------
        //if (!(o instanceof RuleBasedBreakIterator)) {
            //return false;
        //}
        //return wrapped.equals(((RuleBasedBreakIterator) o).wrapped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.837 -0400", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "80432F107BF2E7F3FDED71F494A8D815")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_913311192 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_913311192 = wrapped.toString();
        varB4EAC82CA7396A68D541C85D26508E83_913311192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_913311192;
        // ---------- Original Method ----------
        //return wrapped.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.837 -0400", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "E98A7AA9ED0082A675B9F83C6EB296E8")
    @Override
    public int hashCode() {
        int var82A751D45FBB4EB1094404B61E0EB533_1637273153 = (wrapped.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801402584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801402584;
        // ---------- Original Method ----------
        //return wrapped.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.838 -0400", hash_original_method = "CB8345057924EAB3D86F5E280E0AFDC7", hash_generated_method = "F18FEAAAB916BAF494EE331C1AC54A65")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2021359153 = null; //Variable for return #1
        RuleBasedBreakIterator cloned;
        cloned = (RuleBasedBreakIterator) super.clone();
        cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2021359153 = cloned;
        varB4EAC82CA7396A68D541C85D26508E83_2021359153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021359153;
        // ---------- Original Method ----------
        //RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        //return cloned;
    }

    
}

