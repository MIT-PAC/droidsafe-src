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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.375 -0400", hash_original_method = "6484BCA0EF411C515D6EAFFBE43997C3", hash_generated_method = "B53623B6085D93C1ED4728D6C0E442AB")
    public  StringBuffer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.375 -0400", hash_original_method = "7B7971D2835EB2D685FF89EC3D85C02A", hash_generated_method = "ACD878A65D547DD5A7E0BF7E057DECCD")
    public  StringBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.375 -0400", hash_original_method = "505E372B31FD7A37A1258BF28C555BD1", hash_generated_method = "AD616103A91E5BA346BA773E408C1684")
    public  StringBuffer(String string) {
        super(string);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.376 -0400", hash_original_method = "8B31F280D5DC89D8F89BF293509278C5", hash_generated_method = "E056CFC31B947A7FDB5A5FB4E73192A5")
    public  StringBuffer(CharSequence cs) {
        super(cs.toString());
        addTaint(cs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.376 -0400", hash_original_method = "AD3312372D1C20C6FA4349EE546D8C31", hash_generated_method = "75D736A68716F98B28B536E39CB1EE8A")
    public StringBuffer append(boolean b) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1391465933 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1391465933 = append(b ? "true" : "false");
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1391465933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391465933;
        // ---------- Original Method ----------
        //return append(b ? "true" : "false");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.377 -0400", hash_original_method = "CEE54B5A4214CACDA44FA719AFBE18BD", hash_generated_method = "3A4846798A0AA29F04B0911030E98B43")
    public synchronized StringBuffer append(char ch) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_945079043 = null; //Variable for return #1
        append0(ch);
        varB4EAC82CA7396A68D541C85D26508E83_945079043 = this;
        addTaint(ch);
        varB4EAC82CA7396A68D541C85D26508E83_945079043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_945079043;
        // ---------- Original Method ----------
        //append0(ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.378 -0400", hash_original_method = "0AFE0A1757F436EAD0779848DAA16349", hash_generated_method = "953C4EFFCE5EC991B965AA5EFBC4206C")
    public StringBuffer append(double d) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_848595072 = null; //Variable for return #1
        RealToString.getInstance().appendDouble(this, d);
        varB4EAC82CA7396A68D541C85D26508E83_848595072 = this;
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_848595072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848595072;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.378 -0400", hash_original_method = "E91CEA6395085A2C805805AEC660F914", hash_generated_method = "EF1398B6E24A759FBA181A7909A88493")
    public StringBuffer append(float f) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1374985566 = null; //Variable for return #1
        RealToString.getInstance().appendFloat(this, f);
        varB4EAC82CA7396A68D541C85D26508E83_1374985566 = this;
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1374985566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374985566;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.378 -0400", hash_original_method = "BEA181157FE20523F8DAE95D96DA45D4", hash_generated_method = "CCD0A6486C863B97E5AA4620BF765BFB")
    public StringBuffer append(int i) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1566970760 = null; //Variable for return #1
        IntegralToString.appendInt(this, i);
        varB4EAC82CA7396A68D541C85D26508E83_1566970760 = this;
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1566970760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1566970760;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.396 -0400", hash_original_method = "83E6088E5FD422B34A78952B80516F81", hash_generated_method = "42F2AA4D32AB1C8A6B8B44DB1F7AA8B3")
    public StringBuffer append(long l) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1016426671 = null; //Variable for return #1
        IntegralToString.appendLong(this, l);
        varB4EAC82CA7396A68D541C85D26508E83_1016426671 = this;
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_1016426671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1016426671;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.397 -0400", hash_original_method = "2D15CD6872414C1946401A7870801F7E", hash_generated_method = "DDDA351CAFAD48D9B90BFC6C00FBE99A")
    public synchronized StringBuffer append(Object obj) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_877439851 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(obj.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_877439851 = this;
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_877439851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_877439851;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.397 -0400", hash_original_method = "BA0CFF22AB5EB829F1FAF589162ABBEB", hash_generated_method = "E51C9ECA7E8C3A33909AD61142FFEBDD")
    public synchronized StringBuffer append(String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_37129853 = null; //Variable for return #1
        append0(string);
        varB4EAC82CA7396A68D541C85D26508E83_37129853 = this;
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_37129853.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_37129853;
        // ---------- Original Method ----------
        //append0(string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.398 -0400", hash_original_method = "F6E1A459EC09255D7DD48512D99C9457", hash_generated_method = "8387346C038371514899C79D184C600B")
    public synchronized StringBuffer append(StringBuffer sb) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1167201359 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            {
                append0(sb.getValue(), 0, sb.length());
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1167201359 = this;
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1167201359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167201359;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.398 -0400", hash_original_method = "711104B80207109E628FE8DD74956179", hash_generated_method = "B886976EB5DE4F02A8E25845B84FFC7C")
    public synchronized StringBuffer append(char[] chars) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_520828961 = null; //Variable for return #1
        append0(chars);
        varB4EAC82CA7396A68D541C85D26508E83_520828961 = this;
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_520828961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_520828961;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.399 -0400", hash_original_method = "46001E95C0F59DFED22A324D2D070740", hash_generated_method = "8860D0764B9A7DAE532816C49997C455")
    public synchronized StringBuffer append(char[] chars, int start, int length) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_442157698 = null; //Variable for return #1
        append0(chars, start, length);
        varB4EAC82CA7396A68D541C85D26508E83_442157698 = this;
        addTaint(chars[0]);
        addTaint(start);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_442157698.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_442157698;
        // ---------- Original Method ----------
        //append0(chars, start, length);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.409 -0400", hash_original_method = "2C28D2E65709E046DB9D8E48F9D4C881", hash_generated_method = "D9408CC212F8AEEB9E962BF6BB18CD8A")
    public synchronized StringBuffer append(CharSequence s) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_504065069 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(s, 0, s.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_504065069 = this;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_504065069.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_504065069;
        // ---------- Original Method ----------
        //if (s == null) {
            //appendNull();
        //} else {
            //append0(s, 0, s.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.409 -0400", hash_original_method = "C1E3B870A5740951AADEEF0491CD7264", hash_generated_method = "399A813EF34D948FFF8140D9F8E15B9F")
    public synchronized StringBuffer append(CharSequence s, int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_48654787 = null; //Variable for return #1
        append0(s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_48654787 = this;
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_48654787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_48654787;
        // ---------- Original Method ----------
        //append0(s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.410 -0400", hash_original_method = "4B31A9F498F093ACA181C8BA507E02E7", hash_generated_method = "DE904AC57CE52D8CC73630E74E8E9B2B")
    public StringBuffer appendCodePoint(int codePoint) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_393271457 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_393271457 = append(Character.toChars(codePoint));
        addTaint(codePoint);
        varB4EAC82CA7396A68D541C85D26508E83_393271457.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_393271457;
        // ---------- Original Method ----------
        //return append(Character.toChars(codePoint));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.411 -0400", hash_original_method = "52E39D47ECD902DE3C84A8ACBB2DE582", hash_generated_method = "FA4A3F253E3BBE4C27A30DFE43D48F26")
    @Override
    public synchronized char charAt(int index) {
        char var67343F6FBD7200EB4B6E0B11BF615A09_1044705164 = (super.charAt(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_701512834 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_701512834;
        // ---------- Original Method ----------
        //return super.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.411 -0400", hash_original_method = "48A83889A4814C372999BC69DB011FE1", hash_generated_method = "BCE6B36A9BD22F57DF85111BC134408F")
    @Override
    public synchronized int codePointAt(int index) {
        int var87028839F2D2E61732A658D75862070C_1243797349 = (super.codePointAt(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732430186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732430186;
        // ---------- Original Method ----------
        //return super.codePointAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.411 -0400", hash_original_method = "E2FD7EE4758777A7F8810D08D8C81C5F", hash_generated_method = "A458E87254BA81F72722C982CAFB8A25")
    @Override
    public synchronized int codePointBefore(int index) {
        int var4F5E6A41BD327C670531AB1C8E85EDF9_1049487289 = (super.codePointBefore(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995771167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995771167;
        // ---------- Original Method ----------
        //return super.codePointBefore(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.411 -0400", hash_original_method = "C17E5B71844DF6A2EACD3D99CBFE136F", hash_generated_method = "ED295E9872D4E1B7F87869D8C5BE2B33")
    @Override
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        int varC3B3B69B865D0E48792B1447F2B7D0D0_1092005983 = (super.codePointCount(beginIndex, endIndex));
        addTaint(beginIndex);
        addTaint(endIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583047838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583047838;
        // ---------- Original Method ----------
        //return super.codePointCount(beginIndex, endIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.412 -0400", hash_original_method = "235414C6394F3123BE59FBE1973087EC", hash_generated_method = "BF632CBE6E290412255378FF24DED6AD")
    public synchronized StringBuffer delete(int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_59192050 = null; //Variable for return #1
        delete0(start, end);
        varB4EAC82CA7396A68D541C85D26508E83_59192050 = this;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_59192050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_59192050;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.412 -0400", hash_original_method = "737D447D9524E38B88FDFD3CE0E844F0", hash_generated_method = "45F737804424AEF7320591ACB528E8E3")
    public synchronized StringBuffer deleteCharAt(int location) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_725935573 = null; //Variable for return #1
        deleteCharAt0(location);
        varB4EAC82CA7396A68D541C85D26508E83_725935573 = this;
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_725935573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725935573;
        // ---------- Original Method ----------
        //deleteCharAt0(location);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.413 -0400", hash_original_method = "1B87A2C630A8B8AD61E299E2980BE5BA", hash_generated_method = "B7A5F28489197DBA043A15080FD326DB")
    @Override
    public synchronized void ensureCapacity(int min) {
        super.ensureCapacity(min);
        addTaint(min);
        // ---------- Original Method ----------
        //super.ensureCapacity(min);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.413 -0400", hash_original_method = "037A31D5BC34DCBBE5FD8C41FC89B29B", hash_generated_method = "C71095F66A2A940F5CA6459ABB858CEF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.432 -0400", hash_original_method = "BF7B498FDD44487B77C2BA2659BC8482", hash_generated_method = "5E478B8C1366D7AA583CB9BBC2AF2CDD")
    @Override
    public synchronized int indexOf(String subString, int start) {
        int var908E3533399C11D447675EC6DD3F4900_1703354941 = (super.indexOf(subString, start));
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314174716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314174716;
        // ---------- Original Method ----------
        //return super.indexOf(subString, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.433 -0400", hash_original_method = "CE1956BD7F5F63F118F54E2B606E5A97", hash_generated_method = "344C86E8FF01CAFB9A43FBD5B63B8176")
    public synchronized StringBuffer insert(int index, char ch) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_463060480 = null; //Variable for return #1
        insert0(index, ch);
        varB4EAC82CA7396A68D541C85D26508E83_463060480 = this;
        addTaint(index);
        addTaint(ch);
        varB4EAC82CA7396A68D541C85D26508E83_463060480.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_463060480;
        // ---------- Original Method ----------
        //insert0(index, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.433 -0400", hash_original_method = "162176ED227569BA5BCA4BCD896EB6BD", hash_generated_method = "D14ED97CD12E34190E570B4D1A26C72F")
    public StringBuffer insert(int index, boolean b) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_421587332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_421587332 = insert(index, b ? "true" : "false");
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_421587332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_421587332;
        // ---------- Original Method ----------
        //return insert(index, b ? "true" : "false");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.434 -0400", hash_original_method = "5A54C4D4DA42D98D57F22399AE362D5B", hash_generated_method = "FEF5BDA8F2BE78C1AA32FF86DE3801BD")
    public StringBuffer insert(int index, int i) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_666853207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_666853207 = insert(index, Integer.toString(i));
        addTaint(index);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_666853207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_666853207;
        // ---------- Original Method ----------
        //return insert(index, Integer.toString(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.435 -0400", hash_original_method = "5D8E4B66E2DC4C0F0AE2C3587B4A421D", hash_generated_method = "ED12944ADF4AD607C74922447FDEFCCA")
    public StringBuffer insert(int index, long l) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_416801979 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_416801979 = insert(index, Long.toString(l));
        addTaint(index);
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_416801979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_416801979;
        // ---------- Original Method ----------
        //return insert(index, Long.toString(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.435 -0400", hash_original_method = "6F91201558DE19CA8BB7D7C8218AE116", hash_generated_method = "D8F42DDA487D9D20726BC843A478E0D0")
    public StringBuffer insert(int index, double d) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1196735369 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1196735369 = insert(index, Double.toString(d));
        addTaint(index);
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_1196735369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1196735369;
        // ---------- Original Method ----------
        //return insert(index, Double.toString(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.442 -0400", hash_original_method = "F7E2A65D054608BBB689E2070378B818", hash_generated_method = "0FA414C6BBF8E210FDC41F9FE426D6B6")
    public StringBuffer insert(int index, float f) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1360986192 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1360986192 = insert(index, Float.toString(f));
        addTaint(index);
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1360986192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1360986192;
        // ---------- Original Method ----------
        //return insert(index, Float.toString(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.443 -0400", hash_original_method = "474B289AA5CB68BD472602D89AE62101", hash_generated_method = "9F46155E53C12C356AE1B31254799911")
    public StringBuffer insert(int index, Object obj) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1557744027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1557744027 = insert(index, obj == null ? "null" : obj.toString());
        addTaint(index);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1557744027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1557744027;
        // ---------- Original Method ----------
        //return insert(index, obj == null ? "null" : obj.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.444 -0400", hash_original_method = "5591CE5A2850A371416D9B24730643D5", hash_generated_method = "3CDE48CD01BA1B7E6A271D5D1C4EE737")
    public synchronized StringBuffer insert(int index, String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1544926416 = null; //Variable for return #1
        insert0(index, string);
        varB4EAC82CA7396A68D541C85D26508E83_1544926416 = this;
        addTaint(index);
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1544926416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1544926416;
        // ---------- Original Method ----------
        //insert0(index, string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.444 -0400", hash_original_method = "1121EB69A68046BEB419CFEB2B6021C8", hash_generated_method = "88E564FF1C07464021ED4ED1AC44F97F")
    public synchronized StringBuffer insert(int index, char[] chars) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_196817319 = null; //Variable for return #1
        insert0(index, chars);
        varB4EAC82CA7396A68D541C85D26508E83_196817319 = this;
        addTaint(index);
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_196817319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_196817319;
        // ---------- Original Method ----------
        //insert0(index, chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.445 -0400", hash_original_method = "E3508FF8AABC28C56148C557B4E38064", hash_generated_method = "BAF71515C3F5212F2CC7B1A8C516914B")
    public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_439352182 = null; //Variable for return #1
        insert0(index, chars, start, length);
        varB4EAC82CA7396A68D541C85D26508E83_439352182 = this;
        addTaint(index);
        addTaint(chars[0]);
        addTaint(start);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_439352182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439352182;
        // ---------- Original Method ----------
        //insert0(index, chars, start, length);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.457 -0400", hash_original_method = "313D5F48F5D2BFD8C8C3947312396740", hash_generated_method = "D18D37A8EE810D524A9304AAC711611C")
    public synchronized StringBuffer insert(int index, CharSequence s) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1893754926 = null; //Variable for return #1
        insert0(index, s == null ? "null" : s.toString());
        varB4EAC82CA7396A68D541C85D26508E83_1893754926 = this;
        addTaint(index);
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1893754926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1893754926;
        // ---------- Original Method ----------
        //insert0(index, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.458 -0400", hash_original_method = "BBD93AF1317886AF1B5FFE12E83BEB02", hash_generated_method = "E44CB70ABB7BF3DB8C8C9AD5E02E83DD")
    public synchronized StringBuffer insert(int index, CharSequence s,
            int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1466207398 = null; //Variable for return #1
        insert0(index, s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_1466207398 = this;
        addTaint(index);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1466207398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1466207398;
        // ---------- Original Method ----------
        //insert0(index, s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.458 -0400", hash_original_method = "39077D4F93550F62A3B71E5EF9B37555", hash_generated_method = "D5DC56A893546A9BCA7F059ADB116832")
    @Override
    public synchronized int lastIndexOf(String subString, int start) {
        int var5E66E0A664D3EA61A5B243FCAE7F27E6_1654903792 = (super.lastIndexOf(subString, start));
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746598461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746598461;
        // ---------- Original Method ----------
        //return super.lastIndexOf(subString, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.458 -0400", hash_original_method = "C8ABB25D4960EE5BE30D58FFF30054AF", hash_generated_method = "DAA3E9E9786EE76E850AB4DC9D3265AB")
    @Override
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        int var6A111C2FA13ECAF03A3B30B414C79D57_548036391 = (super.offsetByCodePoints(index, codePointOffset));
        addTaint(index);
        addTaint(codePointOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645695142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645695142;
        // ---------- Original Method ----------
        //return super.offsetByCodePoints(index, codePointOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.459 -0400", hash_original_method = "7F162AB48D360AADEB1B9DD8B238BF48", hash_generated_method = "821B3C925187B3198BD3DB282E7B62C4")
    public synchronized StringBuffer replace(int start, int end, String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_889586534 = null; //Variable for return #1
        replace0(start, end, string);
        varB4EAC82CA7396A68D541C85D26508E83_889586534 = this;
        addTaint(start);
        addTaint(end);
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_889586534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889586534;
        // ---------- Original Method ----------
        //replace0(start, end, string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.459 -0400", hash_original_method = "098653D6B0F25929404FF528DA5234A0", hash_generated_method = "A042970A662D76F5F40D2C3C70CCBCDF")
    public synchronized StringBuffer reverse() {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_596187849 = null; //Variable for return #1
        reverse0();
        varB4EAC82CA7396A68D541C85D26508E83_596187849 = this;
        varB4EAC82CA7396A68D541C85D26508E83_596187849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_596187849;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.462 -0400", hash_original_method = "5E8E344457E07DCAD9D3AB0618D1D4EE", hash_generated_method = "D9AE4CA4323AA1B6D019FACB19D61285")
    @Override
    public synchronized void setCharAt(int index, char ch) {
        super.setCharAt(index, ch);
        addTaint(index);
        addTaint(ch);
        // ---------- Original Method ----------
        //super.setCharAt(index, ch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.463 -0400", hash_original_method = "384C5D925F648A6C0E5C9532F172E2E9", hash_generated_method = "3402CE4F18B02713E2BF8FB12CD8BEA1")
    @Override
    public synchronized void setLength(int length) {
        super.setLength(length);
        addTaint(length);
        // ---------- Original Method ----------
        //super.setLength(length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.463 -0400", hash_original_method = "A9B709A81F57A675D3A25B35A00D1C6F", hash_generated_method = "8ACF6206EC680C5F669641CCA0647B74")
    @Override
    public synchronized CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1636617559 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1636617559 = super.substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1636617559.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1636617559;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.463 -0400", hash_original_method = "9DB8630678DB6396B8F68E9EC4290146", hash_generated_method = "5BBB3205B33433AA5F46306F04F04FE8")
    @Override
    public synchronized String substring(int start) {
        String varB4EAC82CA7396A68D541C85D26508E83_2025481634 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2025481634 = super.substring(start);
        addTaint(start);
        varB4EAC82CA7396A68D541C85D26508E83_2025481634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2025481634;
        // ---------- Original Method ----------
        //return super.substring(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.464 -0400", hash_original_method = "8F6436CA8EA2D690A9089AF2007B25C6", hash_generated_method = "BBE86C11AA4B0A934BA6A40352199297")
    @Override
    public synchronized String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_1586285648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1586285648 = super.substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1586285648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1586285648;
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.464 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "FDF862340CD6B731EC39E28D4D918E7E")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_37827560 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_37827560 = super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_37827560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_37827560;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.467 -0400", hash_original_method = "596F21FA7699F8C3786ED3A552D7371B", hash_generated_method = "4AD64ABAA1448088FDC29C19AFB55B5C")
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
        // ---------- Original Method ----------
        //super.trimToSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.468 -0400", hash_original_method = "1BC53113CC0063A57FC602AA53299ECD", hash_generated_method = "1294FC9FE85B07DF679D5FEDC99E947B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.468 -0400", hash_original_method = "9B6E3FB5AF7FD24ED316678958241184", hash_generated_method = "B2B90D2337B0D6B79DA91B0227E261E7")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.468 -0400", hash_original_field = "98690DEA52FA41F3A04A5E4B46C7BC91", hash_generated_field = "DBBC791224A069773BAC94871CD87C81")

    private static long serialVersionUID = 3388685877147921107L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.469 -0400", hash_original_field = "1335615F33A067E5F7D76F56EAD9B80B", hash_generated_field = "041D577DE2AB15A0301441F139839D44")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("count", int.class),
        new ObjectStreamField("shared", boolean.class),
        new ObjectStreamField("value", char[].class),
    };
}

