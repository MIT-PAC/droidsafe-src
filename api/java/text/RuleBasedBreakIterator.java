package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.icu.NativeBreakIterator;

class RuleBasedBreakIterator extends BreakIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.645 -0400", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "F8A2ED20A01EA7682FD7468CB9B145ED")
      RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.646 -0400", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "32D8C5D6B552F167247B2AB53CB007E7")
    @Override
    public int current() {
        int varB3E6BDA0FA71F18BC558DA082AF1E2AE_370318426 = (wrapped.current());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164831272 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164831272;
        // ---------- Original Method ----------
        //return wrapped.current();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.646 -0400", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "D19A1C7862076C12254A1140EBD3C163")
    @Override
    public int first() {
        int varF9A7B801088F0D36D9C9F6010C2BD145_1033052548 = (wrapped.first());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726592809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726592809;
        // ---------- Original Method ----------
        //return wrapped.first();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.646 -0400", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "3852B8CCD63D40EADF174B66C5474BD5")
    @Override
    public int following(int offset) {
        addTaint(offset);
        validateOffset(offset);
        int varC869B4931B398ED66E4CC1DB2B1A3657_1222889316 = (wrapped.following(offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102890259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102890259;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.following(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.647 -0400", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "32C5D4579C4DC622303B81DCBA409555")
    private void validateOffset(int offset) {
        addTaint(offset);
        CharacterIterator it = wrapped.getText();
    if(offset < it.getBeginIndex() || offset > it.getEndIndex())        
        {
            String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            IllegalArgumentException varA85EF382D290CB247A238DE6CCA227E0_1031904406 = new IllegalArgumentException(message);
            varA85EF382D290CB247A238DE6CCA227E0_1031904406.addTaint(taint);
            throw varA85EF382D290CB247A238DE6CCA227E0_1031904406;
        } //End block
        // ---------- Original Method ----------
        //CharacterIterator it = wrapped.getText();
        //if (offset < it.getBeginIndex() || offset > it.getEndIndex()) {
            //String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            //throw new IllegalArgumentException(message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.647 -0400", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "9F7468A449F9058C6AE49BE7653A7982")
    @Override
    public CharacterIterator getText() {
CharacterIterator var4C8771EB387BD04E1F70B3FD4201C9FD_12018364 =         wrapped.getText();
        var4C8771EB387BD04E1F70B3FD4201C9FD_12018364.addTaint(taint);
        return var4C8771EB387BD04E1F70B3FD4201C9FD_12018364;
        // ---------- Original Method ----------
        //return wrapped.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.647 -0400", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "BF25EE0B4AF42FF4DA32DFA603B2FB76")
    @Override
    public int last() {
        int varBEC91D8F70CAF0CFA42A9DA5580AF895_1535805120 = (wrapped.last());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924803510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924803510;
        // ---------- Original Method ----------
        //return wrapped.last();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.647 -0400", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "CCAEFDEDC49D1763B04BB7DF7A925A19")
    @Override
    public int next() {
        int varF415221327193ABE7EE0E0BD62F415E0_799074464 = (wrapped.next());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38022286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38022286;
        // ---------- Original Method ----------
        //return wrapped.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.648 -0400", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "D037FC1DE25AAC748B4B4979D75D9768")
    @Override
    public int next(int n) {
        addTaint(n);
        int var56685713150863609D09BAEA0D39F539_1314320949 = (wrapped.next(n));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1483621587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1483621587;
        // ---------- Original Method ----------
        //return wrapped.next(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.648 -0400", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "B02BB93869F27845EEDD46ED50C8CB65")
    @Override
    public int previous() {
        int varA4C94957F1AA8DB58351E465D23F2197_1036628345 = (wrapped.previous());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145480144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145480144;
        // ---------- Original Method ----------
        //return wrapped.previous();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.648 -0400", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "189F6EFFA0D89111CCA36633E7C479CE")
    @Override
    public void setText(CharacterIterator newText) {
        addTaint(newText.getTaint());
        newText.current();
        wrapped.setText(newText);
        // ---------- Original Method ----------
        //newText.current();
        //wrapped.setText(newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.648 -0400", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "F8F7E5D35BBB764D7C9104450620B04C")
    @Override
    public boolean isBoundary(int offset) {
        addTaint(offset);
        validateOffset(offset);
        boolean var555B9C99F84B19502BCD77FE9A14CBFB_403093329 = (wrapped.isBoundary(offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647355427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647355427;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.649 -0400", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "FC63C316B99900C8B99EDC38B2619C0E")
    @Override
    public int preceding(int offset) {
        addTaint(offset);
        validateOffset(offset);
        int var22FB19483F51E7C2262EC946C0BBAC14_1973913485 = (wrapped.preceding(offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866339190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866339190;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.649 -0400", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "94EB20364336C80986E94FAE2F03D995")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof RuleBasedBreakIterator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1933963499 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166931444 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166931444;
        } //End block
        boolean var6354424D7AD16BEB11E78AAF8C66ECB6_426345553 = (wrapped.equals(((RuleBasedBreakIterator) o).wrapped));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435547620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_435547620;
        // ---------- Original Method ----------
        //if (!(o instanceof RuleBasedBreakIterator)) {
            //return false;
        //}
        //return wrapped.equals(((RuleBasedBreakIterator) o).wrapped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.649 -0400", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "CC6B3285943DAD07C7175AC4A043C0AE")
    @Override
    public String toString() {
String var84C865F6B41C94911694573E55C4F857_1211264416 =         wrapped.toString();
        var84C865F6B41C94911694573E55C4F857_1211264416.addTaint(taint);
        return var84C865F6B41C94911694573E55C4F857_1211264416;
        // ---------- Original Method ----------
        //return wrapped.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.650 -0400", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "BDDA051923CA0449D230247D3AFBA6D6")
    @Override
    public int hashCode() {
        int varE7735E0DE93B960AAE60F0B41495460B_446156617 = (wrapped.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202657483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202657483;
        // ---------- Original Method ----------
        //return wrapped.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:00.650 -0400", hash_original_method = "CB8345057924EAB3D86F5E280E0AFDC7", hash_generated_method = "BCA68EBE1B1B688918C3DA17F91F9347")
    @Override
    public Object clone() {
        RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        cloned.wrapped = (NativeBreakIterator) wrapped.clone();
Object var7733EC69B7B77450072710EF7316B904_638297735 =         cloned;
        var7733EC69B7B77450072710EF7316B904_638297735.addTaint(taint);
        return var7733EC69B7B77450072710EF7316B904_638297735;
        // ---------- Original Method ----------
        //RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        //return cloned;
    }

    
}

