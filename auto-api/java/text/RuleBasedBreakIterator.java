package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.icu.NativeBreakIterator;

class RuleBasedBreakIterator extends BreakIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.010 -0400", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "F8A2ED20A01EA7682FD7468CB9B145ED")
      RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
        addTaint(iterator.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.010 -0400", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "F90B71872ECF34F63CDC21AA6A56972C")
    @Override
    public int current() {
        int varBA2D2D328ED3FEB82FDEC26256251008_1782736228 = (wrapped.current());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289809900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289809900;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.010 -0400", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "95552AC16018978660A3136834CD389E")
    @Override
    public int first() {
        int var36D1CDF8ADA63B3D5029220AC494B86E_925587505 = (wrapped.first());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987214999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987214999;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.011 -0400", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "F69CA0213316ADE16396B4454B5DC56E")
    @Override
    public int following(int offset) {
        validateOffset(offset);
        int var75F33A3A54BD8ECCB2BD217DEAF83F07_673022167 = (wrapped.following(offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887837367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887837367;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.011 -0400", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "6CAD30F2CCBB97FE82C6C4986E595953")
    private void validateOffset(int offset) {
        CharacterIterator it = wrapped.getText();
        {
            boolean varC65F6973E2FE73C836438C11BE38F2CD_445845095 = (offset < it.getBeginIndex() || offset > it.getEndIndex());
            {
                String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(message);
            } 
        } 
        addTaint(offset);
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.012 -0400", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "D9EA17BC0CCDF5FF594B56910E6213CD")
    @Override
    public CharacterIterator getText() {
        CharacterIterator varB4EAC82CA7396A68D541C85D26508E83_955305544 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_955305544 = wrapped.getText();
        varB4EAC82CA7396A68D541C85D26508E83_955305544.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_955305544;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.012 -0400", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "D8369995E5E9AF6CE42930BF07489A68")
    @Override
    public int last() {
        int varD1F8981D06B202D2735FED0F8DF46D3D_1167170242 = (wrapped.last());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221906952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221906952;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.012 -0400", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "DCA0EFA17582D84EAF07D713D1EC6A1C")
    @Override
    public int next() {
        int var97CE2BF603169EE51D940732E4D0F4C4_190853204 = (wrapped.next());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343650903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343650903;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.012 -0400", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "831B57EF53A7AB8DD31CE42B79C20CF8")
    @Override
    public int next(int n) {
        int var0612142A9906CA6FC60CA7D0A48F42DF_1253491776 = (wrapped.next(n));
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697950980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_697950980;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.013 -0400", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "8BA48376FB5F0D41C41FCDA4086E6154")
    @Override
    public int previous() {
        int var510E4D6C7FBCF98CE6E4FAEE433EAFEB_458944702 = (wrapped.previous());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577742021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577742021;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.013 -0400", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "730A775296B8F58A45F66E4C2733B1DC")
    @Override
    public void setText(CharacterIterator newText) {
        newText.current();
        wrapped.setText(newText);
        addTaint(newText.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.014 -0400", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "CC471A74C8DCD53FBEBDCB87566B1EB2")
    @Override
    public boolean isBoundary(int offset) {
        validateOffset(offset);
        boolean var07A670DF3E20C08BF3ACC7905CB9625F_82347180 = (wrapped.isBoundary(offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316097655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316097655;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.014 -0400", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "A10B36B1D181264BDC4CD1745DE6881A")
    @Override
    public int preceding(int offset) {
        validateOffset(offset);
        int var14341653A1F5B35705434E8CE35431DA_1577111631 = (wrapped.preceding(offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750161216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750161216;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.014 -0400", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "C0B70A160A85516FAE92976B6CCE6900")
    @Override
    public boolean equals(Object o) {
        boolean varBF51C9780ECBD6F6B46C06750D92229D_866708698 = (wrapped.equals(((RuleBasedBreakIterator) o).wrapped));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936323457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936323457;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.015 -0400", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "0FCAFA31176D57ACBC968ECA33650BF1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1665235654 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1665235654 = wrapped.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1665235654.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1665235654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.015 -0400", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "5EC5956E0CC302C37038EE4985E743AD")
    @Override
    public int hashCode() {
        int var82A751D45FBB4EB1094404B61E0EB533_1266147404 = (wrapped.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985271216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985271216;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.016 -0400", hash_original_method = "CB8345057924EAB3D86F5E280E0AFDC7", hash_generated_method = "DB54C278BB3BFAD64DDE1B57CD1DE125")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_517286150 = null; 
        RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        varB4EAC82CA7396A68D541C85D26508E83_517286150 = cloned;
        varB4EAC82CA7396A68D541C85D26508E83_517286150.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_517286150;
        
        
        
        
    }

    
}

