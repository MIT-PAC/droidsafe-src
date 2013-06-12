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
    private static long serialVersionUID = 4383685877147921099L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.169 -0400", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "C4D810675F2A64226382D164456BEACA")
    @DSModeled(DSC.SAFE)
    public StringBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.187 -0400", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "5903A0DDE5357D800C9C38D22C6CF7F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.200 -0400", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "E6D58D65DDE8016D4367BAF8A64D37EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder(CharSequence seq) {
        super(seq.toString());
        dsTaint.addTaint(seq);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.212 -0400", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "9134A1DAEE02E5CFF44DC8C44CE73E0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder(String str) {
        super(str);
        dsTaint.addTaint(str);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.245 -0400", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "4D2FA6264714191657F472856D692350")
    @DSModeled(DSC.SAFE)
    public StringBuilder append(boolean b) {
        dsTaint.addTaint(b);
        append0(b ? "true" : "false");
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.261 -0400", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "CF29B775C34F13F24486AB44B14BF78D")
    @DSModeled(DSC.SAFE)
    public StringBuilder append(char c) {
        dsTaint.addTaint(c);
        append0(c);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.269 -0400", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "014BEAB1E88369699273E248DFD76A50")
    @DSModeled(DSC.SAFE)
    public StringBuilder append(int i) {
        dsTaint.addTaint(i);
        IntegralToString.appendInt(this, i);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.277 -0400", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "A309BEC240FC376EB9F9EF2F427816ED")
    @DSModeled(DSC.SAFE)
    public StringBuilder append(long l) {
        dsTaint.addTaint(l);
        IntegralToString.appendLong(this, l);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.285 -0400", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "77929D862941D376F83DDD6B3D69E60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(float f) {
        dsTaint.addTaint(f);
        RealToString.getInstance().appendFloat(this, f);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.294 -0400", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "822C966604BCF146B83CAD3CFCD99F7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder append(double d) {
        dsTaint.addTaint(d);
        RealToString.getInstance().appendDouble(this, d);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.309 -0400", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "7A164AFEE425A3991B617E6E56D04D3D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.322 -0400", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "82488ADB89D79FC74BD187D61777EFF1")
    @DSModeled(DSC.SAFE)
    public StringBuilder append(String str) {
        dsTaint.addTaint(str);
        append0(str);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.332 -0400", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "531C9C257E37EB7903807A637C2490A8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.346 -0400", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "E1AB00F95AF48ADEF771A57E660180AA")
    @DSModeled(DSC.SAFE)
    public StringBuilder append(char[] chars) {
        dsTaint.addTaint(chars[0]);
        append0(chars);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.353 -0400", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "DA46EC7677E7887C14A1CB9EAC875362")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.363 -0400", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "CDAE46522F95841593EE5E785CB72BDB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.380 -0400", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "EF9B17DCF53AF7343A7795B7E7E65C80")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.396 -0400", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "B90368A97BEF1C6DA270F3AA2AE0E79D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuilder appendCodePoint(int codePoint) {
        dsTaint.addTaint(codePoint);
        append0(Character.toChars(codePoint));
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //append0(Character.toChars(codePoint));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.401 -0400", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "13EA672BA9B0C79D45E6137D202A21E2")
    @DSModeled(DSC.SAFE)
    public StringBuilder delete(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        delete0(start, end);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.419 -0400", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "0D69F947B338980CFDB46157F02EE6D7")
    @DSModeled(DSC.SAFE)
    public StringBuilder deleteCharAt(int index) {
        dsTaint.addTaint(index);
        deleteCharAt0(index);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //deleteCharAt0(index);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.430 -0400", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "EE576B22C664C8B7E05B9C14C033137E")
    @DSModeled(DSC.SAFE)
    public StringBuilder insert(int offset, boolean b) {
        dsTaint.addTaint(b);
        dsTaint.addTaint(offset);
        insert0(offset, b ? "true" : "false");
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.443 -0400", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "C38D9246B22F86FB935DA69AF73E7CA8")
    @DSModeled(DSC.SAFE)
    public StringBuilder insert(int offset, char c) {
        dsTaint.addTaint(c);
        dsTaint.addTaint(offset);
        insert0(offset, c);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.449 -0400", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "57AC904B6754801ECFB232B8CBCE294B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.456 -0400", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "8935010488E6151D53077BE481E8C5E1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.461 -0400", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "9CC8794963F135672AA9D7CC812B7BA7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.467 -0400", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "7ED27FBDB3BCE289AA5A70208EF10B79")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.472 -0400", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "B74596237942ECCED1F9441008F3F153")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.477 -0400", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "1792524B5AFD32E4DF8EE1C6F2F5189C")
    @DSModeled(DSC.SAFE)
    public StringBuilder insert(int offset, String str) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(offset);
        insert0(offset, str);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.483 -0400", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "C84D19B8B3114D0E2858C6AFC2C02E31")
    @DSModeled(DSC.SAFE)
    public StringBuilder insert(int offset, char[] ch) {
        dsTaint.addTaint(ch[0]);
        dsTaint.addTaint(offset);
        insert0(offset, ch);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //insert0(offset, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.488 -0400", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "ED75FE7289874BAC895A3DB1D4845D23")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.496 -0400", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "BBD9C58E5E6F8ECD0DF5FE57A1687DC2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.501 -0400", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "6DE1A93530524F5D1D8300CA13CD25E2")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.507 -0400", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "0E22C4906155BBAD06C59237569D0CD6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.513 -0400", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "27E65DD87BE0BD1A27AC0D4C8587CE4B")
    @DSModeled(DSC.SAFE)
    public StringBuilder reverse() {
        reverse0();
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.518 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "115FB6F611F9A5BA5554D1E8258B1D1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var68E86BD9F434ADE8AAF95F248D77470C_1381627703 = (super.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.524 -0400", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "D3BF67F587D4B491AF911C18E00E42E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:20:26.530 -0400", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "7B37C71ED12A2383B964E87C10AADA44")
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

    
}


