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
import java.io.Serializable;

public final class StringBuilder extends AbstractStringBuilder implements Appendable, CharSequence, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.231 -0400", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "DA4EC3AD95D3DFC18B77F5FCB55D20F9")
    @DSModeled(DSC.SAFE)
    public StringBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.231 -0400", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "8648BB5857CCFB397FFC72C2D3A72C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.231 -0400", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "D3A679D0F35A1E7ED77B5DF1ED38F8A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder(CharSequence seq) {
        super(seq.toString());
        dsTaint.addTaint(seq);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.231 -0400", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "2E5B981BD41519B64FC14733DC9BAA84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder(String str) {
        super(str);
        dsTaint.addTaint(str);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.232 -0400", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "77539914AD4074909DF4D3193D3C89F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(boolean b) {
        dsTaint.addTaint(b);
        append0(b ? "true" : "false");
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.232 -0400", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "91F3C6D00503B9B9CBB2B964BB309E4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(char c) {
        dsTaint.addTaint(c);
        append0(c);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.232 -0400", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "BE2CBE4F1EC1C5D37F87CA29A1B680F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(int i) {
        dsTaint.addTaint(i);
        IntegralToString.appendInt(this, i);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.232 -0400", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "188B4F835B33431D005F9C96C5D15D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(long l) {
        dsTaint.addTaint(l);
        IntegralToString.appendLong(this, l);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.232 -0400", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "216BF4EC337E49027C43CB52B95E7BFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(float f) {
        dsTaint.addTaint(f);
        RealToString.getInstance().appendFloat(this, f);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.233 -0400", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "1F3EB0D3321F5BB4855DE6EFC8A22B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(double d) {
        dsTaint.addTaint(d);
        RealToString.getInstance().appendDouble(this, d);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.233 -0400", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "B7A60D7305A26ABEF8A12464CDE742D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            appendNull();
        } //End block
        {
            append0(obj.toString());
        } //End block
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.233 -0400", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "7F313966FDEB699730F401EA23E1A029")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(String str) {
        dsTaint.addTaint(str);
        append0(str);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.234 -0400", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "29A45E96BFAAC75E3CB5480943CBD572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(StringBuffer sb) {
        dsTaint.addTaint(sb.dsTaint);
        {
            appendNull();
        } //End block
        {
            append0(sb.getValue(), 0, sb.length());
        } //End block
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sb == null) {
            //appendNull();
        //} else {
            //append0(sb.getValue(), 0, sb.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.234 -0400", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "9B72A5F83782EE99FC2CFE53FCDCEED4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(char[] chars) {
        dsTaint.addTaint(chars[0]);
        append0(chars);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.234 -0400", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "7DCF9DC1E510E8EA13A11A2C5F052BC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(char[] str, int offset, int len) {
        dsTaint.addTaint(str[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        append0(str, offset, len);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(str, offset, len);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.234 -0400", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "74062CED5AEF1932E1FB8CABFE0C89FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(CharSequence csq) {
        dsTaint.addTaint(csq);
        {
            appendNull();
        } //End block
        {
            append0(csq, 0, csq.length());
        } //End block
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //appendNull();
        //} else {
            //append0(csq, 0, csq.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.235 -0400", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "43F07B12CF073822DDA0FE81299646C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(CharSequence csq, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(csq);
        dsTaint.addTaint(end);
        append0(csq, start, end);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(csq, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.235 -0400", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "F9BE6461189E0313CCD3CD2A8CA8AD15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder appendCodePoint(int codePoint) {
        dsTaint.addTaint(codePoint);
        append0(Character.toChars(codePoint));
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(Character.toChars(codePoint));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.235 -0400", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "3047EC6679457623E66E4A62AC35951A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder delete(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        delete0(start, end);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.235 -0400", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "DC659E38D5BB78D8C9935C4EC13B1192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder deleteCharAt(int index) {
        dsTaint.addTaint(index);
        deleteCharAt0(index);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //deleteCharAt0(index);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.235 -0400", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "47FBA1C8251B4CB3852CABCC66E31660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, boolean b) {
        dsTaint.addTaint(b);
        dsTaint.addTaint(offset);
        insert0(offset, b ? "true" : "false");
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.236 -0400", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "A11728F3736869BFA600CB05F927ACD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, char c) {
        dsTaint.addTaint(c);
        dsTaint.addTaint(offset);
        insert0(offset, c);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.236 -0400", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "BDE1BACE1D7AA5470AD583992299DC42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, int i) {
        dsTaint.addTaint(offset);
        dsTaint.addTaint(i);
        insert0(offset, Integer.toString(i));
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, Integer.toString(i));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.236 -0400", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "E02BB4F059ACA8CD6CF710FAE225D8F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, long l) {
        dsTaint.addTaint(l);
        dsTaint.addTaint(offset);
        insert0(offset, Long.toString(l));
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, Long.toString(l));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.236 -0400", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "95E2261105363FD2E000CE3F1A37A6B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, float f) {
        dsTaint.addTaint(f);
        dsTaint.addTaint(offset);
        insert0(offset, Float.toString(f));
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, Float.toString(f));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.237 -0400", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "82780B5B2FF78B2FB9F97F588EA0E450")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, double d) {
        dsTaint.addTaint(d);
        dsTaint.addTaint(offset);
        insert0(offset, Double.toString(d));
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, Double.toString(d));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.237 -0400", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "DE1D8DDDBDCC7A5A48A01D924DB8AC11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(offset);
        insert0(offset, obj == null ? "null" : obj.toString());
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, obj == null ? "null" : obj.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.237 -0400", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "F3538084940BF9A3B0A9DD3784E0B240")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, String str) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(offset);
        insert0(offset, str);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.237 -0400", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "42F758567C680F8C8EC3722733F99D61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, char[] ch) {
        dsTaint.addTaint(ch[0]);
        dsTaint.addTaint(offset);
        insert0(offset, ch);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.237 -0400", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "2CCC507E880E823E081F43A00BDBA5E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        dsTaint.addTaint(strOffset);
        dsTaint.addTaint(str[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(strLen);
        insert0(offset, str, strOffset, strLen);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, str, strOffset, strLen);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.238 -0400", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "9F363A5F2B24230563B18E28F16CF519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, CharSequence s) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(offset);
        insert0(offset, s == null ? "null" : s.toString());
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.238 -0400", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "2F158759384A5F91A1947D07AFF95F03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(end);
        insert0(offset, s, start, end);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.238 -0400", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "EDEB9BA6FDF8D248325158D253952A7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder replace(int start, int end, String str) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        replace0(start, end, str);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //replace0(start, end, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.238 -0400", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "D04C8A1D43AEA7CB93E5796C7FA805C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder reverse() {
        reverse0();
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.238 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "9E1351A72AB7C45B811A807D48E74DEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var68E86BD9F434ADE8AAF95F248D77470C_3861427 = (super.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.239 -0400", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "85FF1EBC7EF9955B91964483F4C092C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        int count;
        count = in.readInt();
        char[] value;
        value = (char[]) in.readObject();
        set(value, count);
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //int count = in.readInt();
        //char[] value = (char[]) in.readObject();
        //set(value, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.239 -0400", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "45068AD3FB8726618A662619A473D9C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        out.defaultWriteObject();
        out.writeInt(length());
        out.writeObject(getValue());
        // ---------- Original Method ----------
        //out.defaultWriteObject();
        //out.writeInt(length());
        //out.writeObject(getValue());
    }

    
    private static final long serialVersionUID = 4383685877147921099L;
}

