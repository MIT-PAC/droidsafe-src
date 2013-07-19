package java.lang;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class StringBuffer extends AbstractStringBuilder implements Appendable, Serializable, CharSequence {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.231 -0400", hash_original_method = "6484BCA0EF411C515D6EAFFBE43997C3", hash_generated_method = "B53623B6085D93C1ED4728D6C0E442AB")
    public  StringBuffer() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.231 -0400", hash_original_method = "7B7971D2835EB2D685FF89EC3D85C02A", hash_generated_method = "ACD878A65D547DD5A7E0BF7E057DECCD")
    public  StringBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.231 -0400", hash_original_method = "505E372B31FD7A37A1258BF28C555BD1", hash_generated_method = "AD616103A91E5BA346BA773E408C1684")
    public  StringBuffer(String string) {
        super(string);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.231 -0400", hash_original_method = "8B31F280D5DC89D8F89BF293509278C5", hash_generated_method = "E056CFC31B947A7FDB5A5FB4E73192A5")
    public  StringBuffer(CharSequence cs) {
        super(cs.toString());
        addTaint(cs.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.231 -0400", hash_original_method = "AD3312372D1C20C6FA4349EE546D8C31", hash_generated_method = "813CA5EEDD44457EAEDBBCE3A593B3A8")
    public StringBuffer append(boolean b) {
        addTaint(b);
StringBuffer var130C12590BA34282469039C6BABC8DEB_1989303360 =         append(b ? "true" : "false");
        var130C12590BA34282469039C6BABC8DEB_1989303360.addTaint(taint);
        return var130C12590BA34282469039C6BABC8DEB_1989303360;
        // ---------- Original Method ----------
        //return append(b ? "true" : "false");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.231 -0400", hash_original_method = "CEE54B5A4214CACDA44FA719AFBE18BD", hash_generated_method = "CB3B43D1C021A5962CE4A62CC1E20414")
    public synchronized StringBuffer append(char ch) {
        addTaint(ch);
        append0(ch);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1517343202 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1517343202.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1517343202;
        // ---------- Original Method ----------
        //append0(ch);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.232 -0400", hash_original_method = "0AFE0A1757F436EAD0779848DAA16349", hash_generated_method = "DE4EAC3EFBD1E54375DEF1BE0A242D9E")
    public StringBuffer append(double d) {
        addTaint(d);
        RealToString.getInstance().appendDouble(this, d);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_665502100 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_665502100.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_665502100;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.232 -0400", hash_original_method = "E91CEA6395085A2C805805AEC660F914", hash_generated_method = "B70A00CF78DF0DCB14D005578DF3948F")
    public StringBuffer append(float f) {
        addTaint(f);
        RealToString.getInstance().appendFloat(this, f);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_123347563 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_123347563.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_123347563;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.232 -0400", hash_original_method = "BEA181157FE20523F8DAE95D96DA45D4", hash_generated_method = "F1772485C484E68EE7703AADE204C0FD")
    public StringBuffer append(int i) {
        addTaint(i);
        IntegralToString.appendInt(this, i);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_946033915 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_946033915.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_946033915;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.232 -0400", hash_original_method = "83E6088E5FD422B34A78952B80516F81", hash_generated_method = "8F6E6733079F5F125256505CCB4E88E1")
    public StringBuffer append(long l) {
        addTaint(l);
        IntegralToString.appendLong(this, l);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_931703421 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_931703421.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_931703421;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.232 -0400", hash_original_method = "2D15CD6872414C1946401A7870801F7E", hash_generated_method = "B5750AA3E88EBFB945CB1A43F8293B56")
    public synchronized StringBuffer append(Object obj) {
        addTaint(obj.getTaint());
        if(obj == null)        
        {
            appendNull();
        } //End block
        else
        {
            append0(obj.toString());
        } //End block
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1263701071 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1263701071.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1263701071;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.232 -0400", hash_original_method = "BA0CFF22AB5EB829F1FAF589162ABBEB", hash_generated_method = "1DFD23A5850F8CECE54A8AE272EE9E70")
    public synchronized StringBuffer append(String string) {
        addTaint(string.getTaint());
        append0(string);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1204135335 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1204135335.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1204135335;
        // ---------- Original Method ----------
        //append0(string);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.232 -0400", hash_original_method = "F6E1A459EC09255D7DD48512D99C9457", hash_generated_method = "CC6E48642D3A4D0E2CB396C41EB13CAD")
    public synchronized StringBuffer append(StringBuffer sb) {
        addTaint(sb.getTaint());
        if(sb == null)        
        {
            appendNull();
        } //End block
        else
        {
            synchronized
(sb)            {
                append0(sb.getValue(), 0, sb.length());
            } //End block
        } //End block
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_206118776 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_206118776.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_206118776;
        // ---------- Original Method ----------
        //if (sb == null) {
            //appendNull();
        //} else {
            //synchronized (sb) {
                //append0(sb.getValue(), 0, sb.length());
            //}
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.233 -0400", hash_original_method = "711104B80207109E628FE8DD74956179", hash_generated_method = "56E3B5A36BCBCC42D1309EDC40207BA6")
    public synchronized StringBuffer append(char[] chars) {
        addTaint(chars[0]);
        append0(chars);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_209596061 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_209596061.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_209596061;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.233 -0400", hash_original_method = "46001E95C0F59DFED22A324D2D070740", hash_generated_method = "ED2E70358B134CA07B9305D6BB9BC80E")
    public synchronized StringBuffer append(char[] chars, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(chars[0]);
        append0(chars, start, length);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_589158183 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_589158183.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_589158183;
        // ---------- Original Method ----------
        //append0(chars, start, length);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.233 -0400", hash_original_method = "2C28D2E65709E046DB9D8E48F9D4C881", hash_generated_method = "292CB47DD23E1ADA8D30778052A04A61")
    public synchronized StringBuffer append(CharSequence s) {
        addTaint(s.getTaint());
        if(s == null)        
        {
            appendNull();
        } //End block
        else
        {
            append0(s, 0, s.length());
        } //End block
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1672653460 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1672653460.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1672653460;
        // ---------- Original Method ----------
        //if (s == null) {
            //appendNull();
        //} else {
            //append0(s, 0, s.length());
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.233 -0400", hash_original_method = "C1E3B870A5740951AADEEF0491CD7264", hash_generated_method = "ABB18C142D0931DE0DB770F64E59BE1D")
    public synchronized StringBuffer append(CharSequence s, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(s.getTaint());
        append0(s, start, end);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1032017263 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1032017263.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1032017263;
        // ---------- Original Method ----------
        //append0(s, start, end);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.233 -0400", hash_original_method = "4B31A9F498F093ACA181C8BA507E02E7", hash_generated_method = "55D30DD219EE0735651BDC3AB7A835F6")
    public StringBuffer appendCodePoint(int codePoint) {
        addTaint(codePoint);
StringBuffer var4C0203D74E51B2F91E7701E4A300B4A9_1414922143 =         append(Character.toChars(codePoint));
        var4C0203D74E51B2F91E7701E4A300B4A9_1414922143.addTaint(taint);
        return var4C0203D74E51B2F91E7701E4A300B4A9_1414922143;
        // ---------- Original Method ----------
        //return append(Character.toChars(codePoint));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.233 -0400", hash_original_method = "52E39D47ECD902DE3C84A8ACBB2DE582", hash_generated_method = "5206D8D9E348A6479D3D380BEEEB56C6")
    @Override
    public synchronized char charAt(int index) {
        addTaint(index);
        char varC77B6AA90A2E12629DA6506AB3CF2F2C_1218170181 = (super.charAt(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_781123754 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_781123754;
        // ---------- Original Method ----------
        //return super.charAt(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.233 -0400", hash_original_method = "48A83889A4814C372999BC69DB011FE1", hash_generated_method = "DCB1574E5CA7DDF3A8A2931FF59D0151")
    @Override
    public synchronized int codePointAt(int index) {
        addTaint(index);
        int varF9E998C8AE026979742EC9C57267C271_1123427037 = (super.codePointAt(index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663093317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663093317;
        // ---------- Original Method ----------
        //return super.codePointAt(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.234 -0400", hash_original_method = "E2FD7EE4758777A7F8810D08D8C81C5F", hash_generated_method = "AC90B3BB172CBC5971D3D460013C9AC6")
    @Override
    public synchronized int codePointBefore(int index) {
        addTaint(index);
        int var0E7E22C7802FBE1ADD96F4603B08358D_943708748 = (super.codePointBefore(index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455411596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455411596;
        // ---------- Original Method ----------
        //return super.codePointBefore(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.234 -0400", hash_original_method = "C17E5B71844DF6A2EACD3D99CBFE136F", hash_generated_method = "2039E108520091008D212762146BE258")
    @Override
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(beginIndex);
        int var3E967BDE19A61E2EAAE6FFCB13B64A8D_395213863 = (super.codePointCount(beginIndex, endIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363952647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363952647;
        // ---------- Original Method ----------
        //return super.codePointCount(beginIndex, endIndex);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.234 -0400", hash_original_method = "235414C6394F3123BE59FBE1973087EC", hash_generated_method = "B21780AB5AF7BC559984169D105336D7")
    public synchronized StringBuffer delete(int start, int end) {
        addTaint(end);
        addTaint(start);
        delete0(start, end);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_893139984 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_893139984.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_893139984;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "737D447D9524E38B88FDFD3CE0E844F0", hash_generated_method = "8264A047DE92FBAC767806D42D4A19DA")
    public synchronized StringBuffer deleteCharAt(int location) {
        addTaint(location);
        deleteCharAt0(location);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1127322301 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1127322301.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1127322301;
        // ---------- Original Method ----------
        //deleteCharAt0(location);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "1B87A2C630A8B8AD61E299E2980BE5BA", hash_generated_method = "C3C66DBA64850B3185A98E163393AA9F")
    @Override
    public synchronized void ensureCapacity(int min) {
        addTaint(min);
        super.ensureCapacity(min);
        // ---------- Original Method ----------
        //super.ensureCapacity(min);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "037A31D5BC34DCBBE5FD8C41FC89B29B", hash_generated_method = "5BF9643B5EEA1A665908FE60885A71AF")
    @Override
    public synchronized void getChars(int start, int end, char[] buffer, int idx) {
        addTaint(idx);
        addTaint(buffer[0]);
        addTaint(end);
        addTaint(start);
        super.getChars(start, end, buffer, idx);
        // ---------- Original Method ----------
        //super.getChars(start, end, buffer, idx);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "BF7B498FDD44487B77C2BA2659BC8482", hash_generated_method = "F23941171703BFA5E357DFB167B86BD8")
    @Override
    public synchronized int indexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
        int varE9439051DCE9A34B7C94186B031D64A6_1395724933 = (super.indexOf(subString, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735864338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735864338;
        // ---------- Original Method ----------
        //return super.indexOf(subString, start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "CE1956BD7F5F63F118F54E2B606E5A97", hash_generated_method = "5C3C174CCFBE80B273E75C9351B2D4EA")
    public synchronized StringBuffer insert(int index, char ch) {
        addTaint(ch);
        addTaint(index);
        insert0(index, ch);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1170878720 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1170878720.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1170878720;
        // ---------- Original Method ----------
        //insert0(index, ch);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "162176ED227569BA5BCA4BCD896EB6BD", hash_generated_method = "F3C41BC78F439A2214AAEB851B821B27")
    public StringBuffer insert(int index, boolean b) {
        addTaint(b);
        addTaint(index);
StringBuffer var93863484329C2BF98F5899B2FA110CBC_1936494319 =         insert(index, b ? "true" : "false");
        var93863484329C2BF98F5899B2FA110CBC_1936494319.addTaint(taint);
        return var93863484329C2BF98F5899B2FA110CBC_1936494319;
        // ---------- Original Method ----------
        //return insert(index, b ? "true" : "false");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "5A54C4D4DA42D98D57F22399AE362D5B", hash_generated_method = "1BF4FFB2D30325D0EEBCECEB3CC14742")
    public StringBuffer insert(int index, int i) {
        addTaint(i);
        addTaint(index);
StringBuffer varB42A4A525B97E60EF951DC8D1CC9B36B_59135331 =         insert(index, Integer.toString(i));
        varB42A4A525B97E60EF951DC8D1CC9B36B_59135331.addTaint(taint);
        return varB42A4A525B97E60EF951DC8D1CC9B36B_59135331;
        // ---------- Original Method ----------
        //return insert(index, Integer.toString(i));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.235 -0400", hash_original_method = "5D8E4B66E2DC4C0F0AE2C3587B4A421D", hash_generated_method = "917BFDA90C12D163BD84A877F4677046")
    public StringBuffer insert(int index, long l) {
        addTaint(l);
        addTaint(index);
StringBuffer var83AC19B8B049893B2BAF1B16354C95BA_935183441 =         insert(index, Long.toString(l));
        var83AC19B8B049893B2BAF1B16354C95BA_935183441.addTaint(taint);
        return var83AC19B8B049893B2BAF1B16354C95BA_935183441;
        // ---------- Original Method ----------
        //return insert(index, Long.toString(l));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "6F91201558DE19CA8BB7D7C8218AE116", hash_generated_method = "3BCC7FAFF1D939B97DBE98B2BFC542F7")
    public StringBuffer insert(int index, double d) {
        addTaint(d);
        addTaint(index);
StringBuffer var2CA0641C58602FF9E3266C3B1E01E441_262819675 =         insert(index, Double.toString(d));
        var2CA0641C58602FF9E3266C3B1E01E441_262819675.addTaint(taint);
        return var2CA0641C58602FF9E3266C3B1E01E441_262819675;
        // ---------- Original Method ----------
        //return insert(index, Double.toString(d));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "F7E2A65D054608BBB689E2070378B818", hash_generated_method = "9C8C6E7DC83AC854EAEA315F6C4899AE")
    public StringBuffer insert(int index, float f) {
        addTaint(f);
        addTaint(index);
StringBuffer var0477D0646173D91A1BCF5346E6B01118_360501239 =         insert(index, Float.toString(f));
        var0477D0646173D91A1BCF5346E6B01118_360501239.addTaint(taint);
        return var0477D0646173D91A1BCF5346E6B01118_360501239;
        // ---------- Original Method ----------
        //return insert(index, Float.toString(f));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "474B289AA5CB68BD472602D89AE62101", hash_generated_method = "F3957CB29227DBD07C30F7D0DBE2BB60")
    public StringBuffer insert(int index, Object obj) {
        addTaint(obj.getTaint());
        addTaint(index);
StringBuffer var63AA4C3B80CF0B85B72BD1353E8F7B31_1748584082 =         insert(index, obj == null ? "null" : obj.toString());
        var63AA4C3B80CF0B85B72BD1353E8F7B31_1748584082.addTaint(taint);
        return var63AA4C3B80CF0B85B72BD1353E8F7B31_1748584082;
        // ---------- Original Method ----------
        //return insert(index, obj == null ? "null" : obj.toString());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "5591CE5A2850A371416D9B24730643D5", hash_generated_method = "CE20687E0A0EB609D70D812F10FB599A")
    public synchronized StringBuffer insert(int index, String string) {
        addTaint(string.getTaint());
        addTaint(index);
        insert0(index, string);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1064088598 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1064088598.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1064088598;
        // ---------- Original Method ----------
        //insert0(index, string);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "1121EB69A68046BEB419CFEB2B6021C8", hash_generated_method = "35EC17DC63E753FB481CFBFFD3C0ECDF")
    public synchronized StringBuffer insert(int index, char[] chars) {
        addTaint(chars[0]);
        addTaint(index);
        insert0(index, chars);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1274597355 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1274597355.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1274597355;
        // ---------- Original Method ----------
        //insert0(index, chars);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "E3508FF8AABC28C56148C557B4E38064", hash_generated_method = "F4229E2A5EA8ACA6B791E3C839F9E229")
    public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(chars[0]);
        addTaint(index);
        insert0(index, chars, start, length);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1557885946 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1557885946.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1557885946;
        // ---------- Original Method ----------
        //insert0(index, chars, start, length);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "313D5F48F5D2BFD8C8C3947312396740", hash_generated_method = "1BBB71B683E1092F54287307F3EBD773")
    public synchronized StringBuffer insert(int index, CharSequence s) {
        addTaint(s.getTaint());
        addTaint(index);
        insert0(index, s == null ? "null" : s.toString());
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1768385391 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1768385391.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1768385391;
        // ---------- Original Method ----------
        //insert0(index, s == null ? "null" : s.toString());
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.236 -0400", hash_original_method = "BBD93AF1317886AF1B5FFE12E83BEB02", hash_generated_method = "14BBC854E543A9A9287B101273739E82")
    public synchronized StringBuffer insert(int index, CharSequence s,
            int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(s.getTaint());
        addTaint(index);
        insert0(index, s, start, end);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_919032134 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_919032134.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_919032134;
        // ---------- Original Method ----------
        //insert0(index, s, start, end);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "39077D4F93550F62A3B71E5EF9B37555", hash_generated_method = "7679412EA9525BF1D870F7E553033C0D")
    @Override
    public synchronized int lastIndexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
        int var85598CC8432C4365FDDDA954BC092948_1884120191 = (super.lastIndexOf(subString, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287934017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287934017;
        // ---------- Original Method ----------
        //return super.lastIndexOf(subString, start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "C8ABB25D4960EE5BE30D58FFF30054AF", hash_generated_method = "6E839EACCA42D0DADB425DDFB9CB45B0")
    @Override
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        addTaint(codePointOffset);
        addTaint(index);
        int varFF95C4E2778C4F7DA061CDD035957D2B_444565001 = (super.offsetByCodePoints(index, codePointOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27552736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27552736;
        // ---------- Original Method ----------
        //return super.offsetByCodePoints(index, codePointOffset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "7F162AB48D360AADEB1B9DD8B238BF48", hash_generated_method = "BDEB347754B12EF5524B7661B912C0E1")
    public synchronized StringBuffer replace(int start, int end, String string) {
        addTaint(string.getTaint());
        addTaint(end);
        addTaint(start);
        replace0(start, end, string);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1937377348 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1937377348.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1937377348;
        // ---------- Original Method ----------
        //replace0(start, end, string);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "098653D6B0F25929404FF528DA5234A0", hash_generated_method = "6DA6AE8157A3420E067F7D38D45BF0CD")
    public synchronized StringBuffer reverse() {
        reverse0();
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1717325880 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1717325880.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1717325880;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "5E8E344457E07DCAD9D3AB0618D1D4EE", hash_generated_method = "5A62247C2084CD03691976F629FF38B5")
    @Override
    public synchronized void setCharAt(int index, char ch) {
        addTaint(ch);
        addTaint(index);
        super.setCharAt(index, ch);
        // ---------- Original Method ----------
        //super.setCharAt(index, ch);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "384C5D925F648A6C0E5C9532F172E2E9", hash_generated_method = "1286CDE5AA423D0024C274C930761746")
    @Override
    public synchronized void setLength(int length) {
        addTaint(length);
        super.setLength(length);
        // ---------- Original Method ----------
        //super.setLength(length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "A9B709A81F57A675D3A25B35A00D1C6F", hash_generated_method = "DD1A7127C26799E3727AAC7E278C6471")
    @Override
    public synchronized CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var22823C830D93509278FF531FD0D8BDA5_849244895 =         super.substring(start, end);
        var22823C830D93509278FF531FD0D8BDA5_849244895.addTaint(taint);
        return var22823C830D93509278FF531FD0D8BDA5_849244895;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.237 -0400", hash_original_method = "9DB8630678DB6396B8F68E9EC4290146", hash_generated_method = "8DB39592F5C84FE3F9C81E3CD6075860")
    @Override
    public synchronized String substring(int start) {
        addTaint(start);
String var3FEDAFDBD417AA79EA3230674DE00A84_1877484573 =         super.substring(start);
        var3FEDAFDBD417AA79EA3230674DE00A84_1877484573.addTaint(taint);
        return var3FEDAFDBD417AA79EA3230674DE00A84_1877484573;
        // ---------- Original Method ----------
        //return super.substring(start);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.238 -0400", hash_original_method = "8F6436CA8EA2D690A9089AF2007B25C6", hash_generated_method = "A4AB10AA6E9ED8C62EF1B7DB4DDAC75E")
    @Override
    public synchronized String substring(int start, int end) {
        addTaint(end);
        addTaint(start);
String var22823C830D93509278FF531FD0D8BDA5_1808725791 =         super.substring(start, end);
        var22823C830D93509278FF531FD0D8BDA5_1808725791.addTaint(taint);
        return var22823C830D93509278FF531FD0D8BDA5_1808725791;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.238 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "0F7E5BD002704A08E9A80C8EB2AFB368")
    @Override
    public synchronized String toString() {
String varD8287C6801A4C167675BF9EBA9EC2C1B_1561378269 =         super.toString();
        varD8287C6801A4C167675BF9EBA9EC2C1B_1561378269.addTaint(taint);
        return varD8287C6801A4C167675BF9EBA9EC2C1B_1561378269;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.238 -0400", hash_original_method = "596F21FA7699F8C3786ED3A552D7371B", hash_generated_method = "4AD64ABAA1448088FDC29C19AFB55B5C")
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
        // ---------- Original Method ----------
        //super.trimToSize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.238 -0400", hash_original_method = "1BC53113CC0063A57FC602AA53299ECD", hash_generated_method = "CB0FA5AF54292924BE9FC32F39D3CB18")
    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("count", length());
        fields.put("shared", false);
        fields.put("value", getValue());
        out.writeFields();
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = out.putFields();
        //fields.put("count", length());
        //fields.put("shared", false);
        //fields.put("value", getValue());
        //out.writeFields();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.238 -0400", hash_original_method = "9B6E3FB5AF7FD24ED316678958241184", hash_generated_method = "4B7AA79BE0D5A9F0CC1F5266938FD8D2")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        addTaint(in.getTaint());
        ObjectInputStream.GetField fields = in.readFields();
        int count = fields.get("count", 0);
        char[] value = (char[]) fields.get("value", null);
        set(value, count);
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = in.readFields();
        //int count = fields.get("count", 0);
        //char[] value = (char[]) fields.get("value", null);
        //set(value, count);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.238 -0400", hash_original_field = "98690DEA52FA41F3A04A5E4B46C7BC91", hash_generated_field = "FC0674932C46ABA4FCCDFE0606287381")

    private static final long serialVersionUID = 3388685877147921107L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.238 -0400", hash_original_field = "1335615F33A067E5F7D76F56EAD9B80B", hash_generated_field = "B99DBA28D5BC805935B08D57FFE80361")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("count", int.class),
        new ObjectStreamField("shared", boolean.class),
        new ObjectStreamField("value", char[].class),
    };
}

