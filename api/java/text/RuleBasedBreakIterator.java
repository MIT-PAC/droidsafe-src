package java.text;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.icu.NativeBreakIterator;




class RuleBasedBreakIterator extends BreakIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.905 -0400", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "F8A2ED20A01EA7682FD7468CB9B145ED")
      RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
        addTaint(iterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.905 -0400", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "B71986D80B2D395E2A8CB2CD4A95803E")
    @Override
    public int current() {
        int varB3E6BDA0FA71F18BC558DA082AF1E2AE_1253260250 = (wrapped.current());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565340326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565340326;
        // ---------- Original Method ----------
        //return wrapped.current();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.905 -0400", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "C09AAB2784C32D12933A1C86767E6AA8")
    @Override
    public int first() {
        int varF9A7B801088F0D36D9C9F6010C2BD145_1967633508 = (wrapped.first());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632550164 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632550164;
        // ---------- Original Method ----------
        //return wrapped.first();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.906 -0400", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "C1159FA2E5279DCC86A99EC97FDB200C")
    @Override
    public int following(int offset) {
        addTaint(offset);
        validateOffset(offset);
        int varC869B4931B398ED66E4CC1DB2B1A3657_392025535 = (wrapped.following(offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393492636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393492636;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.following(offset);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.906 -0400", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "D40E9AC97EE5E7B156F794513EB4C83F")
    private void validateOffset(int offset) {
        addTaint(offset);
        CharacterIterator it = wrapped.getText();
        if(offset < it.getBeginIndex() || offset > it.getEndIndex())        
        {
            String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            IllegalArgumentException varA85EF382D290CB247A238DE6CCA227E0_1458145577 = new IllegalArgumentException(message);
            varA85EF382D290CB247A238DE6CCA227E0_1458145577.addTaint(taint);
            throw varA85EF382D290CB247A238DE6CCA227E0_1458145577;
        } //End block
        // ---------- Original Method ----------
        //CharacterIterator it = wrapped.getText();
        //if (offset < it.getBeginIndex() || offset > it.getEndIndex()) {
            //String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            //throw new IllegalArgumentException(message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.907 -0400", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "E3E06D37C7F7BA66DDB4C5A1A199AC9B")
    @Override
    public CharacterIterator getText() {
CharacterIterator var4C8771EB387BD04E1F70B3FD4201C9FD_1466816885 =         wrapped.getText();
        var4C8771EB387BD04E1F70B3FD4201C9FD_1466816885.addTaint(taint);
        return var4C8771EB387BD04E1F70B3FD4201C9FD_1466816885;
        // ---------- Original Method ----------
        //return wrapped.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.907 -0400", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "941E50876E32792772EE7D48977937B0")
    @Override
    public int last() {
        int varBEC91D8F70CAF0CFA42A9DA5580AF895_844269794 = (wrapped.last());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330987548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330987548;
        // ---------- Original Method ----------
        //return wrapped.last();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.907 -0400", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "B84363655C79FFC47A3053C23957BDEA")
    @Override
    public int next() {
        int varF415221327193ABE7EE0E0BD62F415E0_6824550 = (wrapped.next());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596653836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596653836;
        // ---------- Original Method ----------
        //return wrapped.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.907 -0400", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "FEE788D4C0271D619EF9DBD7AD1E8C39")
    @Override
    public int next(int n) {
        addTaint(n);
        int var56685713150863609D09BAEA0D39F539_796285501 = (wrapped.next(n));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023627525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023627525;
        // ---------- Original Method ----------
        //return wrapped.next(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.907 -0400", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "D374569E217AD20F938B057796662A82")
    @Override
    public int previous() {
        int varA4C94957F1AA8DB58351E465D23F2197_1222162885 = (wrapped.previous());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227172902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227172902;
        // ---------- Original Method ----------
        //return wrapped.previous();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.908 -0400", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "189F6EFFA0D89111CCA36633E7C479CE")
    @Override
    public void setText(CharacterIterator newText) {
        addTaint(newText.getTaint());
        newText.current();
        wrapped.setText(newText);
        // ---------- Original Method ----------
        //newText.current();
        //wrapped.setText(newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.908 -0400", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "7C4D9D466E453F43CA7A43CE97B10C92")
    @Override
    public boolean isBoundary(int offset) {
        addTaint(offset);
        validateOffset(offset);
        boolean var555B9C99F84B19502BCD77FE9A14CBFB_1528846124 = (wrapped.isBoundary(offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300534774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300534774;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.isBoundary(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.908 -0400", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "C5BD97ED4052A03F7BFA8CC1ABEDF2CF")
    @Override
    public int preceding(int offset) {
        addTaint(offset);
        validateOffset(offset);
        int var22FB19483F51E7C2262EC946C0BBAC14_1364696471 = (wrapped.preceding(offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370453912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370453912;
        // ---------- Original Method ----------
        //validateOffset(offset);
        //return wrapped.preceding(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.909 -0400", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "6D6CF3563E8672F73A78B28F6874751C")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof RuleBasedBreakIterator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_500597098 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704751368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_704751368;
        } //End block
        boolean var6354424D7AD16BEB11E78AAF8C66ECB6_308826376 = (wrapped.equals(((RuleBasedBreakIterator) o).wrapped));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837952607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_837952607;
        // ---------- Original Method ----------
        //if (!(o instanceof RuleBasedBreakIterator)) {
            //return false;
        //}
        //return wrapped.equals(((RuleBasedBreakIterator) o).wrapped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.909 -0400", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "0688D2FF3271D6E31E227802C53D4FB6")
    @Override
    public String toString() {
String var84C865F6B41C94911694573E55C4F857_566457431 =         wrapped.toString();
        var84C865F6B41C94911694573E55C4F857_566457431.addTaint(taint);
        return var84C865F6B41C94911694573E55C4F857_566457431;
        // ---------- Original Method ----------
        //return wrapped.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.909 -0400", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "70FEDDF28221C4BE33714373E5049E4D")
    @Override
    public int hashCode() {
        int varE7735E0DE93B960AAE60F0B41495460B_1487295715 = (wrapped.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584356166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584356166;
        // ---------- Original Method ----------
        //return wrapped.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.910 -0400", hash_original_method = "CB8345057924EAB3D86F5E280E0AFDC7", hash_generated_method = "C3A4BAB15F9D5344DD654622A3D9EA00")
    @Override
    public Object clone() {
        RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        cloned.wrapped = (NativeBreakIterator) wrapped.clone();
Object var7733EC69B7B77450072710EF7316B904_1578448102 =         cloned;
        var7733EC69B7B77450072710EF7316B904_1578448102.addTaint(taint);
        return var7733EC69B7B77450072710EF7316B904_1578448102;
        // ---------- Original Method ----------
        //RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        //cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        //return cloned;
    }

    
}

