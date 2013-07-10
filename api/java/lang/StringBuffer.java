package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public final class StringBuffer extends AbstractStringBuilder implements Appendable, Serializable, CharSequence {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.933 -0400", hash_original_method = "6484BCA0EF411C515D6EAFFBE43997C3", hash_generated_method = "B53623B6085D93C1ED4728D6C0E442AB")
    public  StringBuffer() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.933 -0400", hash_original_method = "7B7971D2835EB2D685FF89EC3D85C02A", hash_generated_method = "ACD878A65D547DD5A7E0BF7E057DECCD")
    public  StringBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.933 -0400", hash_original_method = "505E372B31FD7A37A1258BF28C555BD1", hash_generated_method = "AD616103A91E5BA346BA773E408C1684")
    public  StringBuffer(String string) {
        super(string);
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.933 -0400", hash_original_method = "8B31F280D5DC89D8F89BF293509278C5", hash_generated_method = "E056CFC31B947A7FDB5A5FB4E73192A5")
    public  StringBuffer(CharSequence cs) {
        super(cs.toString());
        addTaint(cs.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.934 -0400", hash_original_method = "AD3312372D1C20C6FA4349EE546D8C31", hash_generated_method = "92E3B146FF50AA34F8B9E4D41D1E528B")
    public StringBuffer append(boolean b) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1674484998 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1674484998 = append(b ? "true" : "false");
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1674484998.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1674484998;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.934 -0400", hash_original_method = "CEE54B5A4214CACDA44FA719AFBE18BD", hash_generated_method = "18D81E55A4F57A24929564C063696912")
    public synchronized StringBuffer append(char ch) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_472059995 = null; 
        append0(ch);
        varB4EAC82CA7396A68D541C85D26508E83_472059995 = this;
        addTaint(ch);
        varB4EAC82CA7396A68D541C85D26508E83_472059995.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_472059995;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.935 -0400", hash_original_method = "0AFE0A1757F436EAD0779848DAA16349", hash_generated_method = "4B1A85617DA4FC8FCE4500897AC37796")
    public StringBuffer append(double d) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_167505195 = null; 
        RealToString.getInstance().appendDouble(this, d);
        varB4EAC82CA7396A68D541C85D26508E83_167505195 = this;
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_167505195.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_167505195;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.935 -0400", hash_original_method = "E91CEA6395085A2C805805AEC660F914", hash_generated_method = "29C6029DCB33450F6CAE38C52F08E0DD")
    public StringBuffer append(float f) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1058039843 = null; 
        RealToString.getInstance().appendFloat(this, f);
        varB4EAC82CA7396A68D541C85D26508E83_1058039843 = this;
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1058039843.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1058039843;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.936 -0400", hash_original_method = "BEA181157FE20523F8DAE95D96DA45D4", hash_generated_method = "331AB9C5654CF96A946B0AEE6F28680C")
    public StringBuffer append(int i) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2048730478 = null; 
        IntegralToString.appendInt(this, i);
        varB4EAC82CA7396A68D541C85D26508E83_2048730478 = this;
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_2048730478.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2048730478;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.936 -0400", hash_original_method = "83E6088E5FD422B34A78952B80516F81", hash_generated_method = "A6395D7DC857B039BAFE1DB766D6E46B")
    public StringBuffer append(long l) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1751005857 = null; 
        IntegralToString.appendLong(this, l);
        varB4EAC82CA7396A68D541C85D26508E83_1751005857 = this;
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_1751005857.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1751005857;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.937 -0400", hash_original_method = "2D15CD6872414C1946401A7870801F7E", hash_generated_method = "C8FEBA3A41844AD7FD1DC3AD7B4DE2B4")
    public synchronized StringBuffer append(Object obj) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2055517015 = null; 
        {
            appendNull();
        } 
        {
            append0(obj.toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2055517015 = this;
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2055517015.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2055517015;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.937 -0400", hash_original_method = "BA0CFF22AB5EB829F1FAF589162ABBEB", hash_generated_method = "D8835352628534A0FA8FAE165AAB55A0")
    public synchronized StringBuffer append(String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_415894721 = null; 
        append0(string);
        varB4EAC82CA7396A68D541C85D26508E83_415894721 = this;
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_415894721.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_415894721;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.937 -0400", hash_original_method = "F6E1A459EC09255D7DD48512D99C9457", hash_generated_method = "7A7CDE0103683CF1AE828FF600F50D85")
    public synchronized StringBuffer append(StringBuffer sb) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1452717546 = null; 
        {
            appendNull();
        } 
        {
            {
                append0(sb.getValue(), 0, sb.length());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1452717546 = this;
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1452717546.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1452717546;
        
        
            
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.938 -0400", hash_original_method = "711104B80207109E628FE8DD74956179", hash_generated_method = "0D51EC06BBC4AC4F5626630AFFC02F0D")
    public synchronized StringBuffer append(char[] chars) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_962173871 = null; 
        append0(chars);
        varB4EAC82CA7396A68D541C85D26508E83_962173871 = this;
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_962173871.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_962173871;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.938 -0400", hash_original_method = "46001E95C0F59DFED22A324D2D070740", hash_generated_method = "56B4590FA6BFDE48F508B580892DB67F")
    public synchronized StringBuffer append(char[] chars, int start, int length) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_867304594 = null; 
        append0(chars, start, length);
        varB4EAC82CA7396A68D541C85D26508E83_867304594 = this;
        addTaint(chars[0]);
        addTaint(start);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_867304594.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_867304594;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.939 -0400", hash_original_method = "2C28D2E65709E046DB9D8E48F9D4C881", hash_generated_method = "22644C426EF409F1E38A7ACB51BF0FBC")
    public synchronized StringBuffer append(CharSequence s) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1852150414 = null; 
        {
            appendNull();
        } 
        {
            append0(s, 0, s.length());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1852150414 = this;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1852150414.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1852150414;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.939 -0400", hash_original_method = "C1E3B870A5740951AADEEF0491CD7264", hash_generated_method = "7791C564433B21DA8ECFCFC14AAF5C60")
    public synchronized StringBuffer append(CharSequence s, int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_741417761 = null; 
        append0(s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_741417761 = this;
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_741417761.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_741417761;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.940 -0400", hash_original_method = "4B31A9F498F093ACA181C8BA507E02E7", hash_generated_method = "5DE79553E53FAA07CAB5C272195B4CB5")
    public StringBuffer appendCodePoint(int codePoint) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_229866883 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_229866883 = append(Character.toChars(codePoint));
        addTaint(codePoint);
        varB4EAC82CA7396A68D541C85D26508E83_229866883.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_229866883;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.940 -0400", hash_original_method = "52E39D47ECD902DE3C84A8ACBB2DE582", hash_generated_method = "F885BE564DCED538BE33EFF6E8C3C6EA")
    @Override
    public synchronized char charAt(int index) {
        char var67343F6FBD7200EB4B6E0B11BF615A09_1385373532 = (super.charAt(index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_577455701 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_577455701;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.941 -0400", hash_original_method = "48A83889A4814C372999BC69DB011FE1", hash_generated_method = "EC8D0D89D8A5CAE4E6ECA404B5F94217")
    @Override
    public synchronized int codePointAt(int index) {
        int var87028839F2D2E61732A658D75862070C_578216128 = (super.codePointAt(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950891026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950891026;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.941 -0400", hash_original_method = "E2FD7EE4758777A7F8810D08D8C81C5F", hash_generated_method = "04D0564B9500C8B58BA8FBF08AE60E0D")
    @Override
    public synchronized int codePointBefore(int index) {
        int var4F5E6A41BD327C670531AB1C8E85EDF9_2036561054 = (super.codePointBefore(index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027112652 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027112652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.942 -0400", hash_original_method = "C17E5B71844DF6A2EACD3D99CBFE136F", hash_generated_method = "E8D9DE37674E13689C5FC49BBEF9EAA1")
    @Override
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        int varC3B3B69B865D0E48792B1447F2B7D0D0_1616779029 = (super.codePointCount(beginIndex, endIndex));
        addTaint(beginIndex);
        addTaint(endIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328734106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328734106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.942 -0400", hash_original_method = "235414C6394F3123BE59FBE1973087EC", hash_generated_method = "970E82AD2F41452316075312777E53EE")
    public synchronized StringBuffer delete(int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1138139742 = null; 
        delete0(start, end);
        varB4EAC82CA7396A68D541C85D26508E83_1138139742 = this;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1138139742.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1138139742;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.943 -0400", hash_original_method = "737D447D9524E38B88FDFD3CE0E844F0", hash_generated_method = "D37C487461E3B6FB977F8E77A4D531C8")
    public synchronized StringBuffer deleteCharAt(int location) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_44498 = null; 
        deleteCharAt0(location);
        varB4EAC82CA7396A68D541C85D26508E83_44498 = this;
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_44498.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_44498;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.944 -0400", hash_original_method = "1B87A2C630A8B8AD61E299E2980BE5BA", hash_generated_method = "B7A5F28489197DBA043A15080FD326DB")
    @Override
    public synchronized void ensureCapacity(int min) {
        super.ensureCapacity(min);
        addTaint(min);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.944 -0400", hash_original_method = "037A31D5BC34DCBBE5FD8C41FC89B29B", hash_generated_method = "C71095F66A2A940F5CA6459ABB858CEF")
    @Override
    public synchronized void getChars(int start, int end, char[] buffer, int idx) {
        super.getChars(start, end, buffer, idx);
        addTaint(start);
        addTaint(end);
        addTaint(buffer[0]);
        addTaint(idx);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.945 -0400", hash_original_method = "BF7B498FDD44487B77C2BA2659BC8482", hash_generated_method = "6F12EB263429CB9392F4E2830AA915C4")
    @Override
    public synchronized int indexOf(String subString, int start) {
        int var908E3533399C11D447675EC6DD3F4900_1553237338 = (super.indexOf(subString, start));
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844218033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844218033;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.946 -0400", hash_original_method = "CE1956BD7F5F63F118F54E2B606E5A97", hash_generated_method = "98D05B4982D44200CB3AD139E28B095C")
    public synchronized StringBuffer insert(int index, char ch) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1668362472 = null; 
        insert0(index, ch);
        varB4EAC82CA7396A68D541C85D26508E83_1668362472 = this;
        addTaint(index);
        addTaint(ch);
        varB4EAC82CA7396A68D541C85D26508E83_1668362472.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1668362472;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.946 -0400", hash_original_method = "162176ED227569BA5BCA4BCD896EB6BD", hash_generated_method = "D3AEAC87DB13C409400DF1556813A9EA")
    public StringBuffer insert(int index, boolean b) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1755282105 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1755282105 = insert(index, b ? "true" : "false");
        addTaint(index);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1755282105.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1755282105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.947 -0400", hash_original_method = "5A54C4D4DA42D98D57F22399AE362D5B", hash_generated_method = "B77A5DE22BD3061C88CD5A5A65252F39")
    public StringBuffer insert(int index, int i) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1065588177 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1065588177 = insert(index, Integer.toString(i));
        addTaint(index);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1065588177.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1065588177;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.948 -0400", hash_original_method = "5D8E4B66E2DC4C0F0AE2C3587B4A421D", hash_generated_method = "0FFFEAE42BE8D512FF58BFB03B237851")
    public StringBuffer insert(int index, long l) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1827083919 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1827083919 = insert(index, Long.toString(l));
        addTaint(index);
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_1827083919.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1827083919;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.949 -0400", hash_original_method = "6F91201558DE19CA8BB7D7C8218AE116", hash_generated_method = "A3EEA17E6117B270FA9FC469901991BF")
    public StringBuffer insert(int index, double d) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_111870094 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_111870094 = insert(index, Double.toString(d));
        addTaint(index);
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_111870094.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_111870094;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.950 -0400", hash_original_method = "F7E2A65D054608BBB689E2070378B818", hash_generated_method = "821D12F1B6F40944205ED6E4E570F2FD")
    public StringBuffer insert(int index, float f) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1780696243 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1780696243 = insert(index, Float.toString(f));
        addTaint(index);
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1780696243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1780696243;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.951 -0400", hash_original_method = "474B289AA5CB68BD472602D89AE62101", hash_generated_method = "54E70706094DF2C94FEC01772A2330DA")
    public StringBuffer insert(int index, Object obj) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_214255889 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_214255889 = insert(index, obj == null ? "null" : obj.toString());
        addTaint(index);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_214255889.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_214255889;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.952 -0400", hash_original_method = "5591CE5A2850A371416D9B24730643D5", hash_generated_method = "56307BB90D9885B01ED08AC56E862D0D")
    public synchronized StringBuffer insert(int index, String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1874709453 = null; 
        insert0(index, string);
        varB4EAC82CA7396A68D541C85D26508E83_1874709453 = this;
        addTaint(index);
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1874709453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1874709453;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.953 -0400", hash_original_method = "1121EB69A68046BEB419CFEB2B6021C8", hash_generated_method = "C4272479F741ABF89FD694D24397C3A4")
    public synchronized StringBuffer insert(int index, char[] chars) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_293638994 = null; 
        insert0(index, chars);
        varB4EAC82CA7396A68D541C85D26508E83_293638994 = this;
        addTaint(index);
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_293638994.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_293638994;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.954 -0400", hash_original_method = "E3508FF8AABC28C56148C557B4E38064", hash_generated_method = "9F248E4EA3CFB8DDEA0A8D63E73F1788")
    public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_596043669 = null; 
        insert0(index, chars, start, length);
        varB4EAC82CA7396A68D541C85D26508E83_596043669 = this;
        addTaint(index);
        addTaint(chars[0]);
        addTaint(start);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_596043669.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_596043669;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.955 -0400", hash_original_method = "313D5F48F5D2BFD8C8C3947312396740", hash_generated_method = "2228D13B1BA9768E2622349A88BAA3E4")
    public synchronized StringBuffer insert(int index, CharSequence s) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_658564536 = null; 
        insert0(index, s == null ? "null" : s.toString());
        varB4EAC82CA7396A68D541C85D26508E83_658564536 = this;
        addTaint(index);
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_658564536.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_658564536;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.957 -0400", hash_original_method = "BBD93AF1317886AF1B5FFE12E83BEB02", hash_generated_method = "F9D083B5193874936E8A3C4296074366")
    public synchronized StringBuffer insert(int index, CharSequence s,
            int start, int end) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2035155052 = null; 
        insert0(index, s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_2035155052 = this;
        addTaint(index);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_2035155052.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2035155052;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.959 -0400", hash_original_method = "39077D4F93550F62A3B71E5EF9B37555", hash_generated_method = "2B3B934A531FEAE4C18DF7C898E79646")
    @Override
    public synchronized int lastIndexOf(String subString, int start) {
        int var5E66E0A664D3EA61A5B243FCAE7F27E6_2069438229 = (super.lastIndexOf(subString, start));
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464207730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464207730;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.960 -0400", hash_original_method = "C8ABB25D4960EE5BE30D58FFF30054AF", hash_generated_method = "657583FDCC0B5993FACBD5969C66AFC0")
    @Override
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        int var6A111C2FA13ECAF03A3B30B414C79D57_2136559545 = (super.offsetByCodePoints(index, codePointOffset));
        addTaint(index);
        addTaint(codePointOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111182758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111182758;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.961 -0400", hash_original_method = "7F162AB48D360AADEB1B9DD8B238BF48", hash_generated_method = "47A8113F37921EC6E7F08F663A063E35")
    public synchronized StringBuffer replace(int start, int end, String string) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1999187027 = null; 
        replace0(start, end, string);
        varB4EAC82CA7396A68D541C85D26508E83_1999187027 = this;
        addTaint(start);
        addTaint(end);
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1999187027.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1999187027;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.963 -0400", hash_original_method = "098653D6B0F25929404FF528DA5234A0", hash_generated_method = "D38A7AF775090175B5FDE71AE947BCEB")
    public synchronized StringBuffer reverse() {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1326267771 = null; 
        reverse0();
        varB4EAC82CA7396A68D541C85D26508E83_1326267771 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1326267771.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1326267771;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.963 -0400", hash_original_method = "5E8E344457E07DCAD9D3AB0618D1D4EE", hash_generated_method = "D9AE4CA4323AA1B6D019FACB19D61285")
    @Override
    public synchronized void setCharAt(int index, char ch) {
        super.setCharAt(index, ch);
        addTaint(index);
        addTaint(ch);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.964 -0400", hash_original_method = "384C5D925F648A6C0E5C9532F172E2E9", hash_generated_method = "3402CE4F18B02713E2BF8FB12CD8BEA1")
    @Override
    public synchronized void setLength(int length) {
        super.setLength(length);
        addTaint(length);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.965 -0400", hash_original_method = "A9B709A81F57A675D3A25B35A00D1C6F", hash_generated_method = "314269D4311E7DC24884603999063867")
    @Override
    public synchronized CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1126045865 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1126045865 = super.substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1126045865.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1126045865;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.966 -0400", hash_original_method = "9DB8630678DB6396B8F68E9EC4290146", hash_generated_method = "EDA289DA3062F9FF53E45B4793F34790")
    @Override
    public synchronized String substring(int start) {
        String varB4EAC82CA7396A68D541C85D26508E83_579886868 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_579886868 = super.substring(start);
        addTaint(start);
        varB4EAC82CA7396A68D541C85D26508E83_579886868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_579886868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.967 -0400", hash_original_method = "8F6436CA8EA2D690A9089AF2007B25C6", hash_generated_method = "5DDAA4137AED5FACB2B30E8B18A442EA")
    @Override
    public synchronized String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_1556735256 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1556735256 = super.substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1556735256.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1556735256;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.968 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "1B9A30DBC10A6F5CECF93AED6F372010")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1344121517 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1344121517 = super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1344121517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1344121517;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.968 -0400", hash_original_method = "596F21FA7699F8C3786ED3A552D7371B", hash_generated_method = "4AD64ABAA1448088FDC29C19AFB55B5C")
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.968 -0400", hash_original_method = "1BC53113CC0063A57FC602AA53299ECD", hash_generated_method = "43D22BC7D942240AC40FBA18A84F0CE6")
    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("count", length());
        fields.put("shared", false);
        fields.put("value", getValue());
        out.writeFields();
        addTaint(out.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.969 -0400", hash_original_method = "9B6E3FB5AF7FD24ED316678958241184", hash_generated_method = "11B6300FEF8F4CC97FE18AF0AC330D71")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        int count = fields.get("count", 0);
        char[] value = (char[]) fields.get("value", null);
        set(value, count);
        addTaint(in.getTaint());
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.969 -0400", hash_original_field = "98690DEA52FA41F3A04A5E4B46C7BC91", hash_generated_field = "FC0674932C46ABA4FCCDFE0606287381")

    private static final long serialVersionUID = 3388685877147921107L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.969 -0400", hash_original_field = "1335615F33A067E5F7D76F56EAD9B80B", hash_generated_field = "B99DBA28D5BC805935B08D57FFE80361")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("count", int.class),
        new ObjectStreamField("shared", boolean.class),
        new ObjectStreamField("value", char[].class),
    };
}

