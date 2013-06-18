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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.802 -0400", hash_original_method = "6484BCA0EF411C515D6EAFFBE43997C3", hash_generated_method = "B53623B6085D93C1ED4728D6C0E442AB")
    @DSModeled(DSC.SAFE)
    public StringBuffer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.811 -0400", hash_original_method = "7B7971D2835EB2D685FF89EC3D85C02A", hash_generated_method = "D42A3346FF4D45E6D47D82C76477B1E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.824 -0400", hash_original_method = "505E372B31FD7A37A1258BF28C555BD1", hash_generated_method = "9CBD25886C2D9C08C1300F5D0E0EDCF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer(String string) {
        super(string);
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.834 -0400", hash_original_method = "8B31F280D5DC89D8F89BF293509278C5", hash_generated_method = "FA64F9C17D38AE8C3F4545E8CE08BB37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer(CharSequence cs) {
        super(cs.toString());
        dsTaint.addTaint(cs);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.858 -0400", hash_original_method = "AD3312372D1C20C6FA4349EE546D8C31", hash_generated_method = "3DA3DAEBEBABDA9610FA666209017148")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer append(boolean b) {
        dsTaint.addTaint(b);
        StringBuffer varA2DEE5BADE670B149C46A28A568B7347_1677435999 = (append(b ? "true" : "false")); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return append(b ? "true" : "false");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.894 -0400", hash_original_method = "CEE54B5A4214CACDA44FA719AFBE18BD", hash_generated_method = "31C396BFC6E943F4D593075430A8FE3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(char ch) {
        dsTaint.addTaint(ch);
        append0(ch);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.909 -0400", hash_original_method = "0AFE0A1757F436EAD0779848DAA16349", hash_generated_method = "EE2575F57970BAE8DAAA5E96D85413C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer append(double d) {
        dsTaint.addTaint(d);
        RealToString.getInstance().appendDouble(this, d);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.932 -0400", hash_original_method = "E91CEA6395085A2C805805AEC660F914", hash_generated_method = "5BDF5295D934026016C2EA3E3C562B32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer append(float f) {
        dsTaint.addTaint(f);
        RealToString.getInstance().appendFloat(this, f);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.946 -0400", hash_original_method = "BEA181157FE20523F8DAE95D96DA45D4", hash_generated_method = "21AE6C4DF8F463962B0C8D00EBABC318")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer append(int i) {
        dsTaint.addTaint(i);
        IntegralToString.appendInt(this, i);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.969 -0400", hash_original_method = "83E6088E5FD422B34A78952B80516F81", hash_generated_method = "91423F1A9343352768376225C4370ABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer append(long l) {
        dsTaint.addTaint(l);
        IntegralToString.appendLong(this, l);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:00.983 -0400", hash_original_method = "2D15CD6872414C1946401A7870801F7E", hash_generated_method = "E0E1E870C4E5354E2610133B06706A2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            appendNull();
        } //End block
        {
            append0(obj.toString());
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.000 -0400", hash_original_method = "BA0CFF22AB5EB829F1FAF589162ABBEB", hash_generated_method = "16B7A093AFDF5144196210FF1740F199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(String string) {
        dsTaint.addTaint(string);
        append0(string);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.020 -0400", hash_original_method = "F6E1A459EC09255D7DD48512D99C9457", hash_generated_method = "81CA7185D1F1F8B63682EDA91F07A072")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(StringBuffer sb) {
        dsTaint.addTaint(sb.dsTaint);
        {
            appendNull();
        } //End block
        {
            {
                append0(sb.getValue(), 0, sb.length());
            } //End block
        } //End block
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.040 -0400", hash_original_method = "711104B80207109E628FE8DD74956179", hash_generated_method = "AF72596AB6AA3C812F4709241A7D9D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(char[] chars) {
        dsTaint.addTaint(chars[0]);
        append0(chars);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.057 -0400", hash_original_method = "46001E95C0F59DFED22A324D2D070740", hash_generated_method = "C6A6712D614FCFB2C7372DC509DA662F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(char[] chars, int start, int length) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        dsTaint.addTaint(chars[0]);
        append0(chars, start, length);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(chars, start, length);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.083 -0400", hash_original_method = "2C28D2E65709E046DB9D8E48F9D4C881", hash_generated_method = "6F707AF823F5DDEDC20DCEE6CA90FB03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(CharSequence s) {
        dsTaint.addTaint(s);
        {
            appendNull();
        } //End block
        {
            append0(s, 0, s.length());
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (s == null) {
            //appendNull();
        //} else {
            //append0(s, 0, s.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.098 -0400", hash_original_method = "C1E3B870A5740951AADEEF0491CD7264", hash_generated_method = "F68C75FA332EFB20577A792740139853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer append(CharSequence s, int start, int end) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        append0(s, start, end);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.113 -0400", hash_original_method = "4B31A9F498F093ACA181C8BA507E02E7", hash_generated_method = "6BFDFC47C604680803053D2ED87CADE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer appendCodePoint(int codePoint) {
        dsTaint.addTaint(codePoint);
        StringBuffer var009DF548E8271F9E2BF0913F3988032B_323268848 = (append(Character.toChars(codePoint)));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return append(Character.toChars(codePoint));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.131 -0400", hash_original_method = "52E39D47ECD902DE3C84A8ACBB2DE582", hash_generated_method = "B430F6245BBBBF8F7097AB0EACBEBB0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized char charAt(int index) {
        dsTaint.addTaint(index);
        char var67343F6FBD7200EB4B6E0B11BF615A09_1090990677 = (super.charAt(index));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return super.charAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.150 -0400", hash_original_method = "48A83889A4814C372999BC69DB011FE1", hash_generated_method = "E5CF48770DD34D1131ACE83666DE6CB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int codePointAt(int index) {
        dsTaint.addTaint(index);
        int var87028839F2D2E61732A658D75862070C_757065554 = (super.codePointAt(index));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.codePointAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.163 -0400", hash_original_method = "E2FD7EE4758777A7F8810D08D8C81C5F", hash_generated_method = "8E5AAFFCE244D8D7774C5E532A7DD3E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int codePointBefore(int index) {
        dsTaint.addTaint(index);
        int var4F5E6A41BD327C670531AB1C8E85EDF9_50519454 = (super.codePointBefore(index));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.codePointBefore(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.180 -0400", hash_original_method = "C17E5B71844DF6A2EACD3D99CBFE136F", hash_generated_method = "93AE50A5265166FD29A72C34BF341AB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        dsTaint.addTaint(beginIndex);
        dsTaint.addTaint(endIndex);
        int varC3B3B69B865D0E48792B1447F2B7D0D0_1210640877 = (super.codePointCount(beginIndex, endIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.codePointCount(beginIndex, endIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.197 -0400", hash_original_method = "235414C6394F3123BE59FBE1973087EC", hash_generated_method = "83B364632E6922C46A7991B18E04580A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer delete(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        delete0(start, end);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.211 -0400", hash_original_method = "737D447D9524E38B88FDFD3CE0E844F0", hash_generated_method = "EBF54EA72A474E7572ED88763BF30BC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer deleteCharAt(int location) {
        dsTaint.addTaint(location);
        deleteCharAt0(location);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //deleteCharAt0(location);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.224 -0400", hash_original_method = "1B87A2C630A8B8AD61E299E2980BE5BA", hash_generated_method = "1F6B4AD3C50B841EF85FC34A8582F8F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void ensureCapacity(int min) {
        dsTaint.addTaint(min);
        super.ensureCapacity(min);
        // ---------- Original Method ----------
        //super.ensureCapacity(min);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.242 -0400", hash_original_method = "037A31D5BC34DCBBE5FD8C41FC89B29B", hash_generated_method = "05AA3D68F57AD8D7CD2A26A81543EBC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void getChars(int start, int end, char[] buffer, int idx) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(idx);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        super.getChars(start, end, buffer, idx);
        // ---------- Original Method ----------
        //super.getChars(start, end, buffer, idx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.262 -0400", hash_original_method = "BF7B498FDD44487B77C2BA2659BC8482", hash_generated_method = "4060F598F99D1C8D51F5637E3BB2C3A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int indexOf(String subString, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(subString);
        int var908E3533399C11D447675EC6DD3F4900_1153085143 = (super.indexOf(subString, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.indexOf(subString, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.281 -0400", hash_original_method = "CE1956BD7F5F63F118F54E2B606E5A97", hash_generated_method = "918CBD6854847AC15DFEC214A285F12D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer insert(int index, char ch) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(ch);
        insert0(index, ch);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(index, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.298 -0400", hash_original_method = "162176ED227569BA5BCA4BCD896EB6BD", hash_generated_method = "66E8C6E098F503106F0B1DA5F27B208C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer insert(int index, boolean b) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(b);
        StringBuffer var95343A3F5972BEE0BB602471010A3F43_1793828620 = (insert(index, b ? "true" : "false")); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return insert(index, b ? "true" : "false");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.311 -0400", hash_original_method = "5A54C4D4DA42D98D57F22399AE362D5B", hash_generated_method = "33C471FBFCA7A982B28D5BE96900093D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer insert(int index, int i) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(i);
        StringBuffer varE03612DBD1E847FA6C86D7CBFB4E48EA_545982699 = (insert(index, Integer.toString(i)));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return insert(index, Integer.toString(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.331 -0400", hash_original_method = "5D8E4B66E2DC4C0F0AE2C3587B4A421D", hash_generated_method = "DA3E7D3AF853566C7E50F0023C9BBAE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer insert(int index, long l) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(l);
        StringBuffer var5DC35BA92F66D4D52B365E9FEF80C114_1067831947 = (insert(index, Long.toString(l)));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return insert(index, Long.toString(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.347 -0400", hash_original_method = "6F91201558DE19CA8BB7D7C8218AE116", hash_generated_method = "9FE83C705F99872882AC5381960129C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer insert(int index, double d) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(d);
        StringBuffer varDF10C92F63026A3C40D70EF427997021_1417206664 = (insert(index, Double.toString(d)));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return insert(index, Double.toString(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.368 -0400", hash_original_method = "F7E2A65D054608BBB689E2070378B818", hash_generated_method = "C4A4D10010D7EF214447ACA5E7D3D8D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer insert(int index, float f) {
        dsTaint.addTaint(f);
        dsTaint.addTaint(index);
        StringBuffer var660228F4198F1464EA5287F305EC7D2B_1282577128 = (insert(index, Float.toString(f)));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return insert(index, Float.toString(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.388 -0400", hash_original_method = "474B289AA5CB68BD472602D89AE62101", hash_generated_method = "DAABB3D68975484C616251CAE20D5BC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer insert(int index, Object obj) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(obj.dsTaint);
        StringBuffer var93476B9CEED0F2F70466BC5F1EB49055_1324425001 = (insert(index, obj == null ? "null" : obj.toString())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return insert(index, obj == null ? "null" : obj.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.401 -0400", hash_original_method = "5591CE5A2850A371416D9B24730643D5", hash_generated_method = "8564C047AC713B8D3A52F95CFE195940")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer insert(int index, String string) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(string);
        insert0(index, string);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(index, string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.425 -0400", hash_original_method = "1121EB69A68046BEB419CFEB2B6021C8", hash_generated_method = "D289B701C2A967243AA1BB87F7F32566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer insert(int index, char[] chars) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(chars[0]);
        insert0(index, chars);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(index, chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.429 -0400", hash_original_method = "E3508FF8AABC28C56148C557B4E38064", hash_generated_method = "86A855B95A1D52BBDD3C905FFBC3626B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        dsTaint.addTaint(chars[0]);
        insert0(index, chars, start, length);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(index, chars, start, length);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.442 -0400", hash_original_method = "313D5F48F5D2BFD8C8C3947312396740", hash_generated_method = "E8E7D9B16DF647276DF1490FE707B353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer insert(int index, CharSequence s) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(s);
        insert0(index, s == null ? "null" : s.toString());
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(index, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.461 -0400", hash_original_method = "BBD93AF1317886AF1B5FFE12E83BEB02", hash_generated_method = "05774220D77AA3B4B7EF78FA26A88313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer insert(int index, CharSequence s,
            int start, int end) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        insert0(index, s, start, end);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(index, s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.473 -0400", hash_original_method = "39077D4F93550F62A3B71E5EF9B37555", hash_generated_method = "4A0AB976650DD6B8F04A1455F2467C87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int lastIndexOf(String subString, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(subString);
        int var5E66E0A664D3EA61A5B243FCAE7F27E6_667593294 = (super.lastIndexOf(subString, start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.lastIndexOf(subString, start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.486 -0400", hash_original_method = "C8ABB25D4960EE5BE30D58FFF30054AF", hash_generated_method = "EB4D860CF110026E054FA3B45ACD84A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(codePointOffset);
        int var6A111C2FA13ECAF03A3B30B414C79D57_348580118 = (super.offsetByCodePoints(index, codePointOffset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.offsetByCodePoints(index, codePointOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.502 -0400", hash_original_method = "7F162AB48D360AADEB1B9DD8B238BF48", hash_generated_method = "434898864E7919171C43FB6EFBB6F623")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer replace(int start, int end, String string) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(string);
        dsTaint.addTaint(end);
        replace0(start, end, string);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //replace0(start, end, string);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.506 -0400", hash_original_method = "098653D6B0F25929404FF528DA5234A0", hash_generated_method = "08550B9289C3AEAC200F3BA99305622E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized StringBuffer reverse() {
        reverse0();
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.522 -0400", hash_original_method = "5E8E344457E07DCAD9D3AB0618D1D4EE", hash_generated_method = "2A259A934502C2FC8FAFC88342F556D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void setCharAt(int index, char ch) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(ch);
        super.setCharAt(index, ch);
        // ---------- Original Method ----------
        //super.setCharAt(index, ch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.532 -0400", hash_original_method = "384C5D925F648A6C0E5C9532F172E2E9", hash_generated_method = "0068343167CF95CF8FA59C3E9BAF9A76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void setLength(int length) {
        dsTaint.addTaint(length);
        super.setLength(length);
        // ---------- Original Method ----------
        //super.setLength(length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.542 -0400", hash_original_method = "A9B709A81F57A675D3A25B35A00D1C6F", hash_generated_method = "CB30F447F63A19CB423EF52B27F78CFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence var42A2AA8AD1052CE5B70C4F72A62953D8_1596228988 = (super.substring(start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.560 -0400", hash_original_method = "9DB8630678DB6396B8F68E9EC4290146", hash_generated_method = "9BD537683E21B0897B32114C16CE41D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized String substring(int start) {
        dsTaint.addTaint(start);
        String var494425ED4E3EFA20A1EDB742D4E49B3B_2129628578 = (super.substring(start));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.substring(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.564 -0400", hash_original_method = "8F6436CA8EA2D690A9089AF2007B25C6", hash_generated_method = "3912BB1E9D519A7EE8BB05624436710B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized String substring(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        String var42A2AA8AD1052CE5B70C4F72A62953D8_1599553627 = (super.substring(start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.568 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "27FC0EE107E148C824C305E818EC1A65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized String toString() {
        String var68E86BD9F434ADE8AAF95F248D77470C_272056309 = (super.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.573 -0400", hash_original_method = "596F21FA7699F8C3786ED3A552D7371B", hash_generated_method = "4AD64ABAA1448088FDC29C19AFB55B5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
        // ---------- Original Method ----------
        //super.trimToSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.578 -0400", hash_original_method = "1BC53113CC0063A57FC602AA53299ECD", hash_generated_method = "9293BAF53A0BDAA58FBC4A936F0469F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = out.putFields();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:18:01.583 -0400", hash_original_method = "9B6E3FB5AF7FD24ED316678958241184", hash_generated_method = "B88C2D59BD57FBD5A25814BB5C1C93CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        ObjectInputStream.GetField fields;
        fields = in.readFields();
        int count;
        count = fields.get("count", 0);
        char[] value;
        value = (char[]) fields.get("value", null);
        set(value, count);
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = in.readFields();
        //int count = fields.get("count", 0);
        //char[] value = (char[]) fields.get("value", null);
        //set(value, count);
    }

    
    private static final long serialVersionUID = 3388685877147921107L;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("count", int.class),
        new ObjectStreamField("shared", boolean.class),
        new ObjectStreamField("value", char[].class),
    };
}

