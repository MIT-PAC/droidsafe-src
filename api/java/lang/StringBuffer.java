package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public final class StringBuffer extends AbstractStringBuilder implements Appendable, Serializable, CharSequence {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.193 -0400", hash_original_method = "6484BCA0EF411C515D6EAFFBE43997C3", hash_generated_method = "B53623B6085D93C1ED4728D6C0E442AB")
    public  StringBuffer() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.194 -0400", hash_original_method = "7B7971D2835EB2D685FF89EC3D85C02A", hash_generated_method = "ACD878A65D547DD5A7E0BF7E057DECCD")
    public  StringBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.194 -0400", hash_original_method = "505E372B31FD7A37A1258BF28C555BD1", hash_generated_method = "AD616103A91E5BA346BA773E408C1684")
    public  StringBuffer(String string) {
        super(string);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.195 -0400", hash_original_method = "8B31F280D5DC89D8F89BF293509278C5", hash_generated_method = "E056CFC31B947A7FDB5A5FB4E73192A5")
    public  StringBuffer(CharSequence cs) {
        super(cs.toString());
        addTaint(cs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.196 -0400", hash_original_method = "AD3312372D1C20C6FA4349EE546D8C31", hash_generated_method = "3A8536FF7F77828DB09E6780691E72D3")
    public StringBuffer append(boolean b) {
        addTaint(b);
StringBuffer var130C12590BA34282469039C6BABC8DEB_2103064482 =         append(b ? "true" : "false");
        var130C12590BA34282469039C6BABC8DEB_2103064482.addTaint(taint);
        return var130C12590BA34282469039C6BABC8DEB_2103064482;
        // ---------- Original Method ----------
        //return append(b ? "true" : "false");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.196 -0400", hash_original_method = "CEE54B5A4214CACDA44FA719AFBE18BD", hash_generated_method = "FA27E5BEF9A2665F50B6EA96C3927A56")
    public synchronized StringBuffer append(char ch) {
        addTaint(ch);
        append0(ch);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1271069481 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1271069481.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1271069481;
        // ---------- Original Method ----------
        //append0(ch);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.197 -0400", hash_original_method = "0AFE0A1757F436EAD0779848DAA16349", hash_generated_method = "319777142F8BF6C1B240289C3AFD6767")
    public StringBuffer append(double d) {
        addTaint(d);
        RealToString.getInstance().appendDouble(this, d);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_809419041 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_809419041.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_809419041;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.198 -0400", hash_original_method = "E91CEA6395085A2C805805AEC660F914", hash_generated_method = "A1D4717F367AFB196A6CB7015DDB81A0")
    public StringBuffer append(float f) {
        addTaint(f);
        RealToString.getInstance().appendFloat(this, f);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1430839410 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1430839410.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1430839410;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.199 -0400", hash_original_method = "BEA181157FE20523F8DAE95D96DA45D4", hash_generated_method = "A547325747D2A890C0A943527A54693D")
    public StringBuffer append(int i) {
        addTaint(i);
        IntegralToString.appendInt(this, i);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1526622871 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1526622871.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1526622871;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.199 -0400", hash_original_method = "83E6088E5FD422B34A78952B80516F81", hash_generated_method = "4D5DC9E7D19EABEC4EB2545EC5F8CACB")
    public StringBuffer append(long l) {
        addTaint(l);
        IntegralToString.appendLong(this, l);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1046802375 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1046802375.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1046802375;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.200 -0400", hash_original_method = "2D15CD6872414C1946401A7870801F7E", hash_generated_method = "F79FDF187F6847836A6C7C6DA8738E43")
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
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1337692765 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1337692765.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1337692765;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.200 -0400", hash_original_method = "BA0CFF22AB5EB829F1FAF589162ABBEB", hash_generated_method = "6010A88E3F96CB3DC955481BA062A1F5")
    public synchronized StringBuffer append(String string) {
        addTaint(string.getTaint());
        append0(string);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_740374289 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_740374289.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_740374289;
        // ---------- Original Method ----------
        //append0(string);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.201 -0400", hash_original_method = "F6E1A459EC09255D7DD48512D99C9457", hash_generated_method = "11A79721C85FE314E3FA2E8A2845E7E2")
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
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1874740713 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1874740713.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1874740713;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.201 -0400", hash_original_method = "711104B80207109E628FE8DD74956179", hash_generated_method = "8063BC3DAE7F2BD799DB6E9FA58F5167")
    public synchronized StringBuffer append(char[] chars) {
        addTaint(chars[0]);
        append0(chars);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1839199904 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1839199904.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1839199904;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.202 -0400", hash_original_method = "46001E95C0F59DFED22A324D2D070740", hash_generated_method = "389F0CE3A53147DA8F451674596950AE")
    public synchronized StringBuffer append(char[] chars, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(chars[0]);
        append0(chars, start, length);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1037504319 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1037504319.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1037504319;
        // ---------- Original Method ----------
        //append0(chars, start, length);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.202 -0400", hash_original_method = "2C28D2E65709E046DB9D8E48F9D4C881", hash_generated_method = "A49E8DABC62DD95529E0AA0AC55874DB")
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
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_404441668 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_404441668.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_404441668;
        // ---------- Original Method ----------
        //if (s == null) {
            //appendNull();
        //} else {
            //append0(s, 0, s.length());
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.203 -0400", hash_original_method = "C1E3B870A5740951AADEEF0491CD7264", hash_generated_method = "629B80BB485B91620511AAFD0B742587")
    public synchronized StringBuffer append(CharSequence s, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(s.getTaint());
        append0(s, start, end);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_104491484 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_104491484.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_104491484;
        // ---------- Original Method ----------
        //append0(s, start, end);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.204 -0400", hash_original_method = "4B31A9F498F093ACA181C8BA507E02E7", hash_generated_method = "882AAEEBE456DAD02CEBCB7919EF4637")
    public StringBuffer appendCodePoint(int codePoint) {
        addTaint(codePoint);
StringBuffer var4C0203D74E51B2F91E7701E4A300B4A9_384390239 =         append(Character.toChars(codePoint));
        var4C0203D74E51B2F91E7701E4A300B4A9_384390239.addTaint(taint);
        return var4C0203D74E51B2F91E7701E4A300B4A9_384390239;
        // ---------- Original Method ----------
        //return append(Character.toChars(codePoint));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.204 -0400", hash_original_method = "52E39D47ECD902DE3C84A8ACBB2DE582", hash_generated_method = "04E77FEC793FD2DDB5DD58420401FF14")
    @Override
    public synchronized char charAt(int index) {
        addTaint(index);
        char varC77B6AA90A2E12629DA6506AB3CF2F2C_1074774382 = (super.charAt(index));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1670289735 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1670289735;
        // ---------- Original Method ----------
        //return super.charAt(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.205 -0400", hash_original_method = "48A83889A4814C372999BC69DB011FE1", hash_generated_method = "20558F53C0CD9070E20BC90630782EF6")
    @Override
    public synchronized int codePointAt(int index) {
        addTaint(index);
        int varF9E998C8AE026979742EC9C57267C271_479102804 = (super.codePointAt(index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56577559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56577559;
        // ---------- Original Method ----------
        //return super.codePointAt(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.205 -0400", hash_original_method = "E2FD7EE4758777A7F8810D08D8C81C5F", hash_generated_method = "74F7238A29D5DAFE128740A475824DB8")
    @Override
    public synchronized int codePointBefore(int index) {
        addTaint(index);
        int var0E7E22C7802FBE1ADD96F4603B08358D_1470027407 = (super.codePointBefore(index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851716058 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851716058;
        // ---------- Original Method ----------
        //return super.codePointBefore(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.206 -0400", hash_original_method = "C17E5B71844DF6A2EACD3D99CBFE136F", hash_generated_method = "1BE99822359D2D986C2755318F9FEBBF")
    @Override
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(beginIndex);
        int var3E967BDE19A61E2EAAE6FFCB13B64A8D_1939848871 = (super.codePointCount(beginIndex, endIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814248138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814248138;
        // ---------- Original Method ----------
        //return super.codePointCount(beginIndex, endIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.206 -0400", hash_original_method = "235414C6394F3123BE59FBE1973087EC", hash_generated_method = "343BECFBA6600C295B0FCB12DB94FD58")
    public synchronized StringBuffer delete(int start, int end) {
        addTaint(end);
        addTaint(start);
        delete0(start, end);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1897397190 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1897397190.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1897397190;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.207 -0400", hash_original_method = "737D447D9524E38B88FDFD3CE0E844F0", hash_generated_method = "23AC02CD7492C745D5416AB97904BB32")
    public synchronized StringBuffer deleteCharAt(int location) {
        addTaint(location);
        deleteCharAt0(location);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1716240894 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1716240894.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1716240894;
        // ---------- Original Method ----------
        //deleteCharAt0(location);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.207 -0400", hash_original_method = "1B87A2C630A8B8AD61E299E2980BE5BA", hash_generated_method = "C3C66DBA64850B3185A98E163393AA9F")
    @Override
    public synchronized void ensureCapacity(int min) {
        addTaint(min);
        super.ensureCapacity(min);
        // ---------- Original Method ----------
        //super.ensureCapacity(min);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.208 -0400", hash_original_method = "037A31D5BC34DCBBE5FD8C41FC89B29B", hash_generated_method = "5BF9643B5EEA1A665908FE60885A71AF")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.208 -0400", hash_original_method = "BF7B498FDD44487B77C2BA2659BC8482", hash_generated_method = "6E12C9E7BC32A7DF3204A1BAE9F604D3")
    @Override
    public synchronized int indexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
        int varE9439051DCE9A34B7C94186B031D64A6_1032227086 = (super.indexOf(subString, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153829152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153829152;
        // ---------- Original Method ----------
        //return super.indexOf(subString, start);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.209 -0400", hash_original_method = "CE1956BD7F5F63F118F54E2B606E5A97", hash_generated_method = "AECA6F2515CD90773268D56FB7A7B345")
    public synchronized StringBuffer insert(int index, char ch) {
        addTaint(ch);
        addTaint(index);
        insert0(index, ch);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_148050565 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_148050565.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_148050565;
        // ---------- Original Method ----------
        //insert0(index, ch);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.209 -0400", hash_original_method = "162176ED227569BA5BCA4BCD896EB6BD", hash_generated_method = "08490F55214A7AFB3313E12CB205B69F")
    public StringBuffer insert(int index, boolean b) {
        addTaint(b);
        addTaint(index);
StringBuffer var93863484329C2BF98F5899B2FA110CBC_1148703632 =         insert(index, b ? "true" : "false");
        var93863484329C2BF98F5899B2FA110CBC_1148703632.addTaint(taint);
        return var93863484329C2BF98F5899B2FA110CBC_1148703632;
        // ---------- Original Method ----------
        //return insert(index, b ? "true" : "false");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.209 -0400", hash_original_method = "5A54C4D4DA42D98D57F22399AE362D5B", hash_generated_method = "F1DBE2715AB02909FDFD2EA0221DFA31")
    public StringBuffer insert(int index, int i) {
        addTaint(i);
        addTaint(index);
StringBuffer varB42A4A525B97E60EF951DC8D1CC9B36B_1252180719 =         insert(index, Integer.toString(i));
        varB42A4A525B97E60EF951DC8D1CC9B36B_1252180719.addTaint(taint);
        return varB42A4A525B97E60EF951DC8D1CC9B36B_1252180719;
        // ---------- Original Method ----------
        //return insert(index, Integer.toString(i));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.210 -0400", hash_original_method = "5D8E4B66E2DC4C0F0AE2C3587B4A421D", hash_generated_method = "A511795A6B2671F90FEBEE28D0476CE3")
    public StringBuffer insert(int index, long l) {
        addTaint(l);
        addTaint(index);
StringBuffer var83AC19B8B049893B2BAF1B16354C95BA_1599904055 =         insert(index, Long.toString(l));
        var83AC19B8B049893B2BAF1B16354C95BA_1599904055.addTaint(taint);
        return var83AC19B8B049893B2BAF1B16354C95BA_1599904055;
        // ---------- Original Method ----------
        //return insert(index, Long.toString(l));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.210 -0400", hash_original_method = "6F91201558DE19CA8BB7D7C8218AE116", hash_generated_method = "B83316291C3369A09300EB0B442AE080")
    public StringBuffer insert(int index, double d) {
        addTaint(d);
        addTaint(index);
StringBuffer var2CA0641C58602FF9E3266C3B1E01E441_172769440 =         insert(index, Double.toString(d));
        var2CA0641C58602FF9E3266C3B1E01E441_172769440.addTaint(taint);
        return var2CA0641C58602FF9E3266C3B1E01E441_172769440;
        // ---------- Original Method ----------
        //return insert(index, Double.toString(d));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.211 -0400", hash_original_method = "F7E2A65D054608BBB689E2070378B818", hash_generated_method = "66AC6B8A7014E853E0E62BD912181E7C")
    public StringBuffer insert(int index, float f) {
        addTaint(f);
        addTaint(index);
StringBuffer var0477D0646173D91A1BCF5346E6B01118_368724793 =         insert(index, Float.toString(f));
        var0477D0646173D91A1BCF5346E6B01118_368724793.addTaint(taint);
        return var0477D0646173D91A1BCF5346E6B01118_368724793;
        // ---------- Original Method ----------
        //return insert(index, Float.toString(f));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.211 -0400", hash_original_method = "474B289AA5CB68BD472602D89AE62101", hash_generated_method = "25B81ADA150B750CA924CAB966CD1FC9")
    public StringBuffer insert(int index, Object obj) {
        addTaint(obj.getTaint());
        addTaint(index);
StringBuffer var63AA4C3B80CF0B85B72BD1353E8F7B31_2069308633 =         insert(index, obj == null ? "null" : obj.toString());
        var63AA4C3B80CF0B85B72BD1353E8F7B31_2069308633.addTaint(taint);
        return var63AA4C3B80CF0B85B72BD1353E8F7B31_2069308633;
        // ---------- Original Method ----------
        //return insert(index, obj == null ? "null" : obj.toString());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.212 -0400", hash_original_method = "5591CE5A2850A371416D9B24730643D5", hash_generated_method = "EABC7E9D705EE27405C51101D8846B87")
    public synchronized StringBuffer insert(int index, String string) {
        addTaint(string.getTaint());
        addTaint(index);
        insert0(index, string);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_701689486 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_701689486.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_701689486;
        // ---------- Original Method ----------
        //insert0(index, string);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.212 -0400", hash_original_method = "1121EB69A68046BEB419CFEB2B6021C8", hash_generated_method = "95E9A160E4A51652AE92C1FD841196C6")
    public synchronized StringBuffer insert(int index, char[] chars) {
        addTaint(chars[0]);
        addTaint(index);
        insert0(index, chars);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_25485133 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_25485133.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_25485133;
        // ---------- Original Method ----------
        //insert0(index, chars);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.213 -0400", hash_original_method = "E3508FF8AABC28C56148C557B4E38064", hash_generated_method = "565C83C8457ED0E0F56BE2559A44C08B")
    public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {
        addTaint(length);
        addTaint(start);
        addTaint(chars[0]);
        addTaint(index);
        insert0(index, chars, start, length);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1380071893 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1380071893.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1380071893;
        // ---------- Original Method ----------
        //insert0(index, chars, start, length);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.213 -0400", hash_original_method = "313D5F48F5D2BFD8C8C3947312396740", hash_generated_method = "B6BEE1F7628C5F09D41349FFDEF3EA30")
    public synchronized StringBuffer insert(int index, CharSequence s) {
        addTaint(s.getTaint());
        addTaint(index);
        insert0(index, s == null ? "null" : s.toString());
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_690935783 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_690935783.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_690935783;
        // ---------- Original Method ----------
        //insert0(index, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.214 -0400", hash_original_method = "BBD93AF1317886AF1B5FFE12E83BEB02", hash_generated_method = "9437DEC2C828F2A528DAA908D36BD1BD")
    public synchronized StringBuffer insert(int index, CharSequence s,
            int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(s.getTaint());
        addTaint(index);
        insert0(index, s, start, end);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_393161228 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_393161228.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_393161228;
        // ---------- Original Method ----------
        //insert0(index, s, start, end);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.214 -0400", hash_original_method = "39077D4F93550F62A3B71E5EF9B37555", hash_generated_method = "A0BAF0D79ABFA8C0033524A58B676807")
    @Override
    public synchronized int lastIndexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
        int var85598CC8432C4365FDDDA954BC092948_2020090048 = (super.lastIndexOf(subString, start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6437714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6437714;
        // ---------- Original Method ----------
        //return super.lastIndexOf(subString, start);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.215 -0400", hash_original_method = "C8ABB25D4960EE5BE30D58FFF30054AF", hash_generated_method = "3665D04A83BA198C5FFA941318C3618C")
    @Override
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        addTaint(codePointOffset);
        addTaint(index);
        int varFF95C4E2778C4F7DA061CDD035957D2B_1874595368 = (super.offsetByCodePoints(index, codePointOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_374457958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_374457958;
        // ---------- Original Method ----------
        //return super.offsetByCodePoints(index, codePointOffset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.215 -0400", hash_original_method = "7F162AB48D360AADEB1B9DD8B238BF48", hash_generated_method = "9DA9EF6801E45551E24F71E472C77C44")
    public synchronized StringBuffer replace(int start, int end, String string) {
        addTaint(string.getTaint());
        addTaint(end);
        addTaint(start);
        replace0(start, end, string);
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_252524457 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_252524457.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_252524457;
        // ---------- Original Method ----------
        //replace0(start, end, string);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.216 -0400", hash_original_method = "098653D6B0F25929404FF528DA5234A0", hash_generated_method = "D6885F99EED6B13B4F15B066630C7BA8")
    public synchronized StringBuffer reverse() {
        reverse0();
StringBuffer var72A74007B2BE62B849F475C7BDA4658B_1959388599 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1959388599.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1959388599;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.216 -0400", hash_original_method = "5E8E344457E07DCAD9D3AB0618D1D4EE", hash_generated_method = "5A62247C2084CD03691976F629FF38B5")
    @Override
    public synchronized void setCharAt(int index, char ch) {
        addTaint(ch);
        addTaint(index);
        super.setCharAt(index, ch);
        // ---------- Original Method ----------
        //super.setCharAt(index, ch);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.217 -0400", hash_original_method = "384C5D925F648A6C0E5C9532F172E2E9", hash_generated_method = "1286CDE5AA423D0024C274C930761746")
    @Override
    public synchronized void setLength(int length) {
        addTaint(length);
        super.setLength(length);
        // ---------- Original Method ----------
        //super.setLength(length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.217 -0400", hash_original_method = "A9B709A81F57A675D3A25B35A00D1C6F", hash_generated_method = "A666CD094F1B6640BD412BD0F10ABA34")
    @Override
    public synchronized CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var22823C830D93509278FF531FD0D8BDA5_322916327 =         super.substring(start, end);
        var22823C830D93509278FF531FD0D8BDA5_322916327.addTaint(taint);
        return var22823C830D93509278FF531FD0D8BDA5_322916327;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.217 -0400", hash_original_method = "9DB8630678DB6396B8F68E9EC4290146", hash_generated_method = "1E26977275E0910CC18BC5692FFC3EA7")
    @Override
    public synchronized String substring(int start) {
        addTaint(start);
String var3FEDAFDBD417AA79EA3230674DE00A84_1259581012 =         super.substring(start);
        var3FEDAFDBD417AA79EA3230674DE00A84_1259581012.addTaint(taint);
        return var3FEDAFDBD417AA79EA3230674DE00A84_1259581012;
        // ---------- Original Method ----------
        //return super.substring(start);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.218 -0400", hash_original_method = "8F6436CA8EA2D690A9089AF2007B25C6", hash_generated_method = "9B155453EB98E47128EDD6F2C3B3A041")
    @Override
    public synchronized String substring(int start, int end) {
        addTaint(end);
        addTaint(start);
String var22823C830D93509278FF531FD0D8BDA5_979200151 =         super.substring(start, end);
        var22823C830D93509278FF531FD0D8BDA5_979200151.addTaint(taint);
        return var22823C830D93509278FF531FD0D8BDA5_979200151;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.218 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "B126FD1B5B84DD4A854E5E9945A8C473")
    @Override
    public synchronized String toString() {
String varD8287C6801A4C167675BF9EBA9EC2C1B_2126458863 =         super.toString();
        varD8287C6801A4C167675BF9EBA9EC2C1B_2126458863.addTaint(taint);
        return varD8287C6801A4C167675BF9EBA9EC2C1B_2126458863;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.219 -0400", hash_original_method = "596F21FA7699F8C3786ED3A552D7371B", hash_generated_method = "4AD64ABAA1448088FDC29C19AFB55B5C")
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
        // ---------- Original Method ----------
        //super.trimToSize();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.220 -0400", hash_original_method = "1BC53113CC0063A57FC602AA53299ECD", hash_generated_method = "CB0FA5AF54292924BE9FC32F39D3CB18")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.220 -0400", hash_original_method = "9B6E3FB5AF7FD24ED316678958241184", hash_generated_method = "4B7AA79BE0D5A9F0CC1F5266938FD8D2")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.221 -0400", hash_original_field = "98690DEA52FA41F3A04A5E4B46C7BC91", hash_generated_field = "FC0674932C46ABA4FCCDFE0606287381")

    private static final long serialVersionUID = 3388685877147921107L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.221 -0400", hash_original_field = "1335615F33A067E5F7D76F56EAD9B80B", hash_generated_field = "B99DBA28D5BC805935B08D57FFE80361")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("count", int.class),
        new ObjectStreamField("shared", boolean.class),
        new ObjectStreamField("value", char[].class),
    };
}

