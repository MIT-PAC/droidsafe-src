package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public final class StringBuffer extends AbstractStringBuilder implements Appendable, Serializable, CharSequence {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.268 -0400", hash_original_method = "6484BCA0EF411C515D6EAFFBE43997C3", hash_generated_method = "B53623B6085D93C1ED4728D6C0E442AB")
    public  StringBuffer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.274 -0400", hash_original_method = "7B7971D2835EB2D685FF89EC3D85C02A", hash_generated_method = "ACD878A65D547DD5A7E0BF7E057DECCD")
    public  StringBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.275 -0400", hash_original_method = "505E372B31FD7A37A1258BF28C555BD1", hash_generated_method = "AD616103A91E5BA346BA773E408C1684")
    public  StringBuffer(String string) {
        super(string);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.275 -0400", hash_original_method = "8B31F280D5DC89D8F89BF293509278C5", hash_generated_method = "E056CFC31B947A7FDB5A5FB4E73192A5")
    public  StringBuffer(CharSequence cs) {
        super(cs.toString());
        addTaint(cs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.276 -0400", hash_original_method = "AD3312372D1C20C6FA4349EE546D8C31", hash_generated_method = "C9BA5A9B6811EBD4D09571126C7265C2")
    public StringBuffer append(boolean b) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1865174811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1865174811 = append(b ? "true" : "false");
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1865174811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865174811;
        // ---------- Original Method ----------
        //return append(b ? "true" : "false");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.280 -0400", hash_original_method = "CEE54B5A4214CACDA44FA719AFBE18BD", hash_generated_method = "A2801578FEF8E9E926471A1B8DA35EC7")
    public synchronized StringBuffer append(char ch) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1288690689 = null; //Variable for return #1
        append0(ch);
        varB4EAC82CA7396A68D541C85D26508E83_1288690689 = this;
        addTaint(ch);
        varB4EAC82CA7396A68D541C85D26508E83_1288690689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1288690689;
        // ---------- Original Method ----------
        //append0(ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.300 -0400", hash_original_method = "0AFE0A1757F436EAD0779848DAA16349", hash_generated_method = "471F9221E64744670DDAA1B8639DA16B")
    public StringBuffer append(double d) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1423635771 = null; //Variable for return #1
        RealToString.getInstance().appendDouble(this, d);
        varB4EAC82CA7396A68D541C85D26508E83_1423635771 = this;
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_1423635771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423635771;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.302 -0400", hash_original_method = "E91CEA6395085A2C805805AEC660F914", hash_generated_method = "F4476D4D4888C1F674B94E496A2D8276")
    public StringBuffer append(float f) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1452396440 = null; //Variable for return #1
        RealToString.getInstance().appendFloat(this, f);
        varB4EAC82CA7396A68D541C85D26508E83_1452396440 = this;
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1452396440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452396440;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.302 -0400", hash_original_method = "BEA181157FE20523F8DAE95D96DA45D4", hash_generated_method = "1A06490B46DEEDC74FDE050CF32E577C")
    public StringBuffer append(int i) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_353445996 = null; //Variable for return #1
        IntegralToString.appendInt(this, i);
        varB4EAC82CA7396A68D541C85D26508E83_353445996 = this;
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_353445996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_353445996;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.302 -0400", hash_original_method = "83E6088E5FD422B34A78952B80516F81", hash_generated_method = "5247D0FA1D10721BDA25B657DE9DF1B1")
    public StringBuffer append(long l) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_873505235 = null; //Variable for return #1
        IntegralToString.appendLong(this, l);
        varB4EAC82CA7396A68D541C85D26508E83_873505235 = this;
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_873505235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873505235;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.303 -0400", hash_original_method = "2D15CD6872414C1946401A7870801F7E", hash_generated_method = "6D534D1E015EB884953C085335596251")
    public synchronized StringBuffer append(Object obj) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_172054762 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(obj.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_172054762 = this;
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_172054762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_172054762;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.304 -0400", hash_original_method = "BA0CFF22AB5EB829F1FAF589162ABBEB", hash_generated_method = "4452895B1E8AB47A009B3DECD7E37A29")
    public synchronized StringBuffer append(String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_165123221 = null; //Variable for return #1
        append0(string);
        varB4EAC82CA7396A68D541C85D26508E83_165123221 = this;
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_165123221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_165123221;
        // ---------- Original Method ----------
        //append0(string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.311 -0400", hash_original_method = "F6E1A459EC09255D7DD48512D99C9457", hash_generated_method = "0E09AB4364776E6054A85278163065ED")
    public synchronized StringBuffer append(StringBuffer sb) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_834504409 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            {
                append0(sb.getValue(), 0, sb.length());
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_834504409 = this;
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_834504409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_834504409;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.312 -0400", hash_original_method = "711104B80207109E628FE8DD74956179", hash_generated_method = "4BCC5674ACB30466AD516282A0757544")
    public synchronized StringBuffer append(char[] chars) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_207592100 = null; //Variable for return #1
        append0(chars);
        varB4EAC82CA7396A68D541C85D26508E83_207592100 = this;
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_207592100.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_207592100;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.325 -0400", hash_original_method = "46001E95C0F59DFED22A324D2D070740", hash_generated_method = "2075145003A9E245542C90B0B04B9DBB")
    public synchronized StringBuffer append(char[] chars, int start, int length) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_643202590 = null; //Variable for return #1
        append0(chars, start, length);
        varB4EAC82CA7396A68D541C85D26508E83_643202590 = this;
        addTaint(chars[0]);
        addTaint(start);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_643202590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_643202590;
        // ---------- Original Method ----------
        //append0(chars, start, length);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.326 -0400", hash_original_method = "2C28D2E65709E046DB9D8E48F9D4C881", hash_generated_method = "974BDEB8E1B76C28571421F4F153B7F4")
    public synchronized StringBuffer append(CharSequence s) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_3436326 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(s, 0, s.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_3436326 = this;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_3436326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3436326;
        // ---------- Original Method ----------
        //if (s == null) {
            //appendNull();
        //} else {
            //append0(s, 0, s.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.327 -0400", hash_original_method = "C1E3B870A5740951AADEEF0491CD7264", hash_generated_method = "2043F42D7F88F478EE00E63E2F56F5DE")
    public synchronized StringBuffer append(CharSequence s, int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1931304894 = null; //Variable for return #1
        append0(s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_1931304894 = this;
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1931304894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1931304894;
        // ---------- Original Method ----------
        //append0(s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.327 -0400", hash_original_method = "4B31A9F498F093ACA181C8BA507E02E7", hash_generated_method = "EBC4DE918AC041D055682AB2D62DF315")
    public StringBuffer appendCodePoint(int codePoint) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_402576876 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_402576876 = append(Character.toChars(codePoint));
        addTaint(codePoint);
        varB4EAC82CA7396A68D541C85D26508E83_402576876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_402576876;
        // ---------- Original Method ----------
        //return append(Character.toChars(codePoint));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.327 -0400", hash_original_method = "52E39D47ECD902DE3C84A8ACBB2DE582", hash_generated_method = "FFCB39BFF7CDCF7DB137EA572EE5D011")
    @Override
    public synchronized char charAt(int index) {
        char var67343F6FBD7200EB4B6E0B11BF615A09_857619801 = (super.charAt(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1165065720 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1165065720;
        // ---------- Original Method ----------
        //return super.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.328 -0400", hash_original_method = "48A83889A4814C372999BC69DB011FE1", hash_generated_method = "BE499F086CF467C70A0EB9F4AAB7E50E")
    @Override
    public synchronized int codePointAt(int index) {
        int var87028839F2D2E61732A658D75862070C_1209974446 = (super.codePointAt(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106011169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106011169;
        // ---------- Original Method ----------
        //return super.codePointAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.329 -0400", hash_original_method = "E2FD7EE4758777A7F8810D08D8C81C5F", hash_generated_method = "DF8545D22E3E008ABB928D1DB0CE1CF2")
    @Override
    public synchronized int codePointBefore(int index) {
        int var4F5E6A41BD327C670531AB1C8E85EDF9_351845166 = (super.codePointBefore(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6406411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6406411;
        // ---------- Original Method ----------
        //return super.codePointBefore(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.329 -0400", hash_original_method = "C17E5B71844DF6A2EACD3D99CBFE136F", hash_generated_method = "E6E415729F7D62875F7350A24D71BE92")
    @Override
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        int varC3B3B69B865D0E48792B1447F2B7D0D0_1397871262 = (super.codePointCount(beginIndex, endIndex));
        addTaint(beginIndex);
        addTaint(endIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379619364 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379619364;
        // ---------- Original Method ----------
        //return super.codePointCount(beginIndex, endIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.330 -0400", hash_original_method = "235414C6394F3123BE59FBE1973087EC", hash_generated_method = "814D4A186AE540765D77C38FEF5D33D4")
    public synchronized StringBuffer delete(int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1219767571 = null; //Variable for return #1
        delete0(start, end);
        varB4EAC82CA7396A68D541C85D26508E83_1219767571 = this;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1219767571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219767571;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.345 -0400", hash_original_method = "737D447D9524E38B88FDFD3CE0E844F0", hash_generated_method = "029B7B6B265CAF6B1879F5BFC726E237")
    public synchronized StringBuffer deleteCharAt(int location) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1613842508 = null; //Variable for return #1
        deleteCharAt0(location);
        varB4EAC82CA7396A68D541C85D26508E83_1613842508 = this;
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1613842508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1613842508;
        // ---------- Original Method ----------
        //deleteCharAt0(location);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.345 -0400", hash_original_method = "1B87A2C630A8B8AD61E299E2980BE5BA", hash_generated_method = "B7A5F28489197DBA043A15080FD326DB")
    @Override
    public synchronized void ensureCapacity(int min) {
        super.ensureCapacity(min);
        addTaint(min);
        // ---------- Original Method ----------
        //super.ensureCapacity(min);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.345 -0400", hash_original_method = "037A31D5BC34DCBBE5FD8C41FC89B29B", hash_generated_method = "C71095F66A2A940F5CA6459ABB858CEF")
    @Override
    public synchronized void getChars(int start, int end, char[] buffer, int idx) {
        super.getChars(start, end, buffer, idx);
        addTaint(start);
        addTaint(end);
        addTaint(buffer[0]);
        addTaint(idx);
        // ---------- Original Method ----------
        //super.getChars(start, end, buffer, idx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.346 -0400", hash_original_method = "BF7B498FDD44487B77C2BA2659BC8482", hash_generated_method = "1B7F08F49690CA82AD88D5FE235ECE74")
    @Override
    public synchronized int indexOf(String subString, int start) {
        int var908E3533399C11D447675EC6DD3F4900_1565722755 = (super.indexOf(subString, start));
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106717548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106717548;
        // ---------- Original Method ----------
        //return super.indexOf(subString, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.346 -0400", hash_original_method = "CE1956BD7F5F63F118F54E2B606E5A97", hash_generated_method = "8C443CFED81EADC698F6B73F2F776DF6")
    public synchronized StringBuffer insert(int index, char ch) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_94589592 = null; //Variable for return #1
        insert0(index, ch);
        varB4EAC82CA7396A68D541C85D26508E83_94589592 = this;
        addTaint(index);
        addTaint(ch);
        varB4EAC82CA7396A68D541C85D26508E83_94589592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_94589592;
        // ---------- Original Method ----------
        //insert0(index, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.347 -0400", hash_original_method = "162176ED227569BA5BCA4BCD896EB6BD", hash_generated_method = "9882D3FDF1A56CA7769CD3A834D9B8B2")
    public StringBuffer insert(int index, boolean b) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2136055652 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2136055652 = insert(index, b ? "true" : "false");
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_2136055652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2136055652;
        // ---------- Original Method ----------
        //return insert(index, b ? "true" : "false");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.347 -0400", hash_original_method = "5A54C4D4DA42D98D57F22399AE362D5B", hash_generated_method = "D9336D67ECA0AAF0646412092D1B0C2D")
    public StringBuffer insert(int index, int i) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_84129639 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_84129639 = insert(index, Integer.toString(i));
        addTaint(index);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_84129639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_84129639;
        // ---------- Original Method ----------
        //return insert(index, Integer.toString(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.351 -0400", hash_original_method = "5D8E4B66E2DC4C0F0AE2C3587B4A421D", hash_generated_method = "B1F60019222F652C8A98404F07C18A70")
    public StringBuffer insert(int index, long l) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1654092181 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1654092181 = insert(index, Long.toString(l));
        addTaint(index);
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_1654092181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1654092181;
        // ---------- Original Method ----------
        //return insert(index, Long.toString(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.355 -0400", hash_original_method = "6F91201558DE19CA8BB7D7C8218AE116", hash_generated_method = "F2041766BAE9BE90BB87AB2F339E33C4")
    public StringBuffer insert(int index, double d) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_609410411 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_609410411 = insert(index, Double.toString(d));
        addTaint(index);
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_609410411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609410411;
        // ---------- Original Method ----------
        //return insert(index, Double.toString(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.363 -0400", hash_original_method = "F7E2A65D054608BBB689E2070378B818", hash_generated_method = "7A1EF02C3EC4286F59737E506987C36D")
    public StringBuffer insert(int index, float f) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1108524625 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1108524625 = insert(index, Float.toString(f));
        addTaint(index);
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1108524625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1108524625;
        // ---------- Original Method ----------
        //return insert(index, Float.toString(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.363 -0400", hash_original_method = "474B289AA5CB68BD472602D89AE62101", hash_generated_method = "EAAA019CE1195208087547463266953C")
    public StringBuffer insert(int index, Object obj) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_560630293 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_560630293 = insert(index, obj == null ? "null" : obj.toString());
        addTaint(index);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_560630293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_560630293;
        // ---------- Original Method ----------
        //return insert(index, obj == null ? "null" : obj.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.364 -0400", hash_original_method = "5591CE5A2850A371416D9B24730643D5", hash_generated_method = "FF674D9ACCC058745CA60FA60EEF953B")
    public synchronized StringBuffer insert(int index, String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1775071065 = null; //Variable for return #1
        insert0(index, string);
        varB4EAC82CA7396A68D541C85D26508E83_1775071065 = this;
        addTaint(index);
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1775071065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1775071065;
        // ---------- Original Method ----------
        //insert0(index, string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.376 -0400", hash_original_method = "1121EB69A68046BEB419CFEB2B6021C8", hash_generated_method = "D5F470F3C14F038404446851A172E4F5")
    public synchronized StringBuffer insert(int index, char[] chars) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_475319170 = null; //Variable for return #1
        insert0(index, chars);
        varB4EAC82CA7396A68D541C85D26508E83_475319170 = this;
        addTaint(index);
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_475319170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_475319170;
        // ---------- Original Method ----------
        //insert0(index, chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.376 -0400", hash_original_method = "E3508FF8AABC28C56148C557B4E38064", hash_generated_method = "785C231B168B9CBC532F8EB6A00E9D6C")
    public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_183834258 = null; //Variable for return #1
        insert0(index, chars, start, length);
        varB4EAC82CA7396A68D541C85D26508E83_183834258 = this;
        addTaint(index);
        addTaint(chars[0]);
        addTaint(start);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_183834258.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183834258;
        // ---------- Original Method ----------
        //insert0(index, chars, start, length);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.377 -0400", hash_original_method = "313D5F48F5D2BFD8C8C3947312396740", hash_generated_method = "09F2DDB09B623A69091AB311F6EF7FA5")
    public synchronized StringBuffer insert(int index, CharSequence s) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1477912128 = null; //Variable for return #1
        insert0(index, s == null ? "null" : s.toString());
        varB4EAC82CA7396A68D541C85D26508E83_1477912128 = this;
        addTaint(index);
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1477912128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1477912128;
        // ---------- Original Method ----------
        //insert0(index, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.377 -0400", hash_original_method = "BBD93AF1317886AF1B5FFE12E83BEB02", hash_generated_method = "C23FE4D03B903CA48E8063EA13CE3D36")
    public synchronized StringBuffer insert(int index, CharSequence s,
            int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1105432671 = null; //Variable for return #1
        insert0(index, s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_1105432671 = this;
        addTaint(index);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1105432671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1105432671;
        // ---------- Original Method ----------
        //insert0(index, s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.386 -0400", hash_original_method = "39077D4F93550F62A3B71E5EF9B37555", hash_generated_method = "D004C029E0764BBB92DBAE156503D1F7")
    @Override
    public synchronized int lastIndexOf(String subString, int start) {
        int var5E66E0A664D3EA61A5B243FCAE7F27E6_489979746 = (super.lastIndexOf(subString, start));
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942288599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942288599;
        // ---------- Original Method ----------
        //return super.lastIndexOf(subString, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.386 -0400", hash_original_method = "C8ABB25D4960EE5BE30D58FFF30054AF", hash_generated_method = "F14F25F206E875D6741E8401A6EEBCD0")
    @Override
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        int var6A111C2FA13ECAF03A3B30B414C79D57_2122417710 = (super.offsetByCodePoints(index, codePointOffset));
        addTaint(index);
        addTaint(codePointOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874833861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874833861;
        // ---------- Original Method ----------
        //return super.offsetByCodePoints(index, codePointOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.387 -0400", hash_original_method = "7F162AB48D360AADEB1B9DD8B238BF48", hash_generated_method = "585418B8BFA22332F1E0EBA735ABA505")
    public synchronized StringBuffer replace(int start, int end, String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1243340991 = null; //Variable for return #1
        replace0(start, end, string);
        varB4EAC82CA7396A68D541C85D26508E83_1243340991 = this;
        addTaint(start);
        addTaint(end);
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1243340991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1243340991;
        // ---------- Original Method ----------
        //replace0(start, end, string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.387 -0400", hash_original_method = "098653D6B0F25929404FF528DA5234A0", hash_generated_method = "8227C0674C689BE6D2E5C89D1C4D9996")
    public synchronized StringBuffer reverse() {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1838910006 = null; //Variable for return #1
        reverse0();
        varB4EAC82CA7396A68D541C85D26508E83_1838910006 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1838910006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1838910006;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.387 -0400", hash_original_method = "5E8E344457E07DCAD9D3AB0618D1D4EE", hash_generated_method = "D9AE4CA4323AA1B6D019FACB19D61285")
    @Override
    public synchronized void setCharAt(int index, char ch) {
        super.setCharAt(index, ch);
        addTaint(index);
        addTaint(ch);
        // ---------- Original Method ----------
        //super.setCharAt(index, ch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.397 -0400", hash_original_method = "384C5D925F648A6C0E5C9532F172E2E9", hash_generated_method = "3402CE4F18B02713E2BF8FB12CD8BEA1")
    @Override
    public synchronized void setLength(int length) {
        super.setLength(length);
        addTaint(length);
        // ---------- Original Method ----------
        //super.setLength(length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.398 -0400", hash_original_method = "A9B709A81F57A675D3A25B35A00D1C6F", hash_generated_method = "08A706E685580A9357CCF0DF27710D68")
    @Override
    public synchronized CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1224275035 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1224275035 = super.substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1224275035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1224275035;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.402 -0400", hash_original_method = "9DB8630678DB6396B8F68E9EC4290146", hash_generated_method = "1E891A2AB5DE2B6E386EF30D493A9518")
    @Override
    public synchronized String substring(int start) {
        String varB4EAC82CA7396A68D541C85D26508E83_170495669 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_170495669 = super.substring(start);
        addTaint(start);
        varB4EAC82CA7396A68D541C85D26508E83_170495669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170495669;
        // ---------- Original Method ----------
        //return super.substring(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.402 -0400", hash_original_method = "8F6436CA8EA2D690A9089AF2007B25C6", hash_generated_method = "99CBD5B4F75525C5321DBB1ED0D26FA4")
    @Override
    public synchronized String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_2091629179 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2091629179 = super.substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_2091629179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2091629179;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.403 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "CCA176C3C3EED66FC7B25135EBB637AC")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_534893420 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_534893420 = super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_534893420.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_534893420;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.403 -0400", hash_original_method = "596F21FA7699F8C3786ED3A552D7371B", hash_generated_method = "4AD64ABAA1448088FDC29C19AFB55B5C")
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
        // ---------- Original Method ----------
        //super.trimToSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.403 -0400", hash_original_method = "1BC53113CC0063A57FC602AA53299ECD", hash_generated_method = "1294FC9FE85B07DF679D5FEDC99E947B")
    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = out.putFields();
        fields.put("count", length());
        fields.put("shared", false);
        fields.put("value", getValue());
        out.writeFields();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = out.putFields();
        //fields.put("count", length());
        //fields.put("shared", false);
        //fields.put("value", getValue());
        //out.writeFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.403 -0400", hash_original_method = "9B6E3FB5AF7FD24ED316678958241184", hash_generated_method = "B2B90D2337B0D6B79DA91B0227E261E7")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = in.readFields();
        int count;
        count = fields.get("count", 0);
        char[] value;
        value = (char[]) fields.get("value", null);
        set(value, count);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = in.readFields();
        //int count = fields.get("count", 0);
        //char[] value = (char[]) fields.get("value", null);
        //set(value, count);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.404 -0400", hash_original_field = "98690DEA52FA41F3A04A5E4B46C7BC91", hash_generated_field = "DBBC791224A069773BAC94871CD87C81")

    private static long serialVersionUID = 3388685877147921107L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.404 -0400", hash_original_field = "1335615F33A067E5F7D76F56EAD9B80B", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

    private static ObjectStreamField[] serialPersistentFields = ;
}

