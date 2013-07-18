package java.lang;

// Droidsafe Imports
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class StringBuilder extends AbstractStringBuilder implements Appendable, CharSequence, Serializable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.256 -0400", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "DA4EC3AD95D3DFC18B77F5FCB55D20F9")
    public  StringBuilder() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.256 -0400", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "C87B8D5CC2E4D8F22859443EF81E10F6")
    public  StringBuilder(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.256 -0400", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "9636F2E0396542ADA0291846333512D2")
    public  StringBuilder(CharSequence seq) {
        super(seq.toString());
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.257 -0400", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "53D779637098BD5B700EC43E5EA94586")
    public  StringBuilder(String str) {
        super(str);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.257 -0400", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "879976EEB10F513ACABF0D688D0CD6BD")
    public StringBuilder append(boolean b) {
        addTaint(b);
        append0(b ? "true" : "false");
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1439541659 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1439541659.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1439541659;
        // ---------- Original Method ----------
        //append0(b ? "true" : "false");
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.257 -0400", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "AB369F74A3D877880880B8D5EDCA633B")
    public StringBuilder append(char c) {
        addTaint(c);
        append0(c);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_418667761 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_418667761.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_418667761;
        // ---------- Original Method ----------
        //append0(c);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.257 -0400", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "ABB28E43998DA715C3B08BE22CB18379")
    public StringBuilder append(int i) {
        addTaint(i);
        IntegralToString.appendInt(this, i);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1879777885 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1879777885.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1879777885;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.258 -0400", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "ACB5D16D4E6ED83D901341D5D020C599")
    public StringBuilder append(long l) {
        addTaint(l);
        IntegralToString.appendLong(this, l);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_889463036 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_889463036.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_889463036;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.258 -0400", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "217DC1A3B7198594194F47E14683CE52")
    public StringBuilder append(float f) {
        addTaint(f);
        RealToString.getInstance().appendFloat(this, f);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1096831149 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1096831149.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1096831149;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.258 -0400", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "9408392D65FB3C3CE7AD316D5D230E28")
    public StringBuilder append(double d) {
        addTaint(d);
        RealToString.getInstance().appendDouble(this, d);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1664686412 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1664686412.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1664686412;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.258 -0400", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "8E7D80627EF9DE898B2F39CA0F3CBF43")
    public StringBuilder append(Object obj) {
        addTaint(obj.getTaint());
        if(obj == null)        
        {
            appendNull();
        } //End block
        else
        {
            append0(obj.toString());
        } //End block
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1187954154 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1187954154.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1187954154;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.259 -0400", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "9BA35BB7F8FEE948560C982CEF5F2967")
    public StringBuilder append(String str) {
        addTaint(str.getTaint());
        append0(str);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1165466372 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1165466372.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1165466372;
        // ---------- Original Method ----------
        //append0(str);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.259 -0400", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "AE6EBE577B9B49DAA284E48CDE20547E")
    public StringBuilder append(StringBuffer sb) {
        addTaint(sb.getTaint());
        if(sb == null)        
        {
            appendNull();
        } //End block
        else
        {
            append0(sb.getValue(), 0, sb.length());
        } //End block
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1599179103 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1599179103.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1599179103;
        // ---------- Original Method ----------
        //if (sb == null) {
            //appendNull();
        //} else {
            //append0(sb.getValue(), 0, sb.length());
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.259 -0400", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "77BB8710870215CB0723CEC3177996D7")
    public StringBuilder append(char[] chars) {
        addTaint(chars[0]);
        append0(chars);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_2013061112 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2013061112.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2013061112;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.260 -0400", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "FB112D550DC5210AA9A764FCC178769E")
    public StringBuilder append(char[] str, int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(str[0]);
        append0(str, offset, len);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_248438315 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_248438315.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_248438315;
        // ---------- Original Method ----------
        //append0(str, offset, len);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.260 -0400", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "C45FED5A3FF4D242470223EB2CC96B63")
    public StringBuilder append(CharSequence csq) {
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            appendNull();
        } //End block
        else
        {
            append0(csq, 0, csq.length());
        } //End block
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1110018839 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1110018839.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1110018839;
        // ---------- Original Method ----------
        //if (csq == null) {
            //appendNull();
        //} else {
            //append0(csq, 0, csq.length());
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.260 -0400", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "E1B4E83B1BD70EBC5821B178D5A98DD5")
    public StringBuilder append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
        append0(csq, start, end);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_985524693 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_985524693.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_985524693;
        // ---------- Original Method ----------
        //append0(csq, start, end);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.261 -0400", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "74E4645FC4C581238A692419DA046A95")
    public StringBuilder appendCodePoint(int codePoint) {
        addTaint(codePoint);
        append0(Character.toChars(codePoint));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1177999217 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1177999217.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1177999217;
        // ---------- Original Method ----------
        //append0(Character.toChars(codePoint));
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.261 -0400", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "EB15DF61BC443217837D83D0E074A6B9")
    public StringBuilder delete(int start, int end) {
        addTaint(end);
        addTaint(start);
        delete0(start, end);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_56191742 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_56191742.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_56191742;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.261 -0400", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "78A78CA7256DB477672A188C5E2AEF30")
    public StringBuilder deleteCharAt(int index) {
        addTaint(index);
        deleteCharAt0(index);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1770272222 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1770272222.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1770272222;
        // ---------- Original Method ----------
        //deleteCharAt0(index);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.262 -0400", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "17632FCD8916D04C14DF6ADEB5DEEE52")
    public StringBuilder insert(int offset, boolean b) {
        addTaint(b);
        addTaint(offset);
        insert0(offset, b ? "true" : "false");
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1653976691 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1653976691.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1653976691;
        // ---------- Original Method ----------
        //insert0(offset, b ? "true" : "false");
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.262 -0400", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "996928D224FA036DAE4D43786B5568F4")
    public StringBuilder insert(int offset, char c) {
        addTaint(c);
        addTaint(offset);
        insert0(offset, c);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_441631237 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_441631237.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_441631237;
        // ---------- Original Method ----------
        //insert0(offset, c);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.262 -0400", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "6B46E7D706EDDA087E6CAFFA2E5C44CA")
    public StringBuilder insert(int offset, int i) {
        addTaint(i);
        addTaint(offset);
        insert0(offset, Integer.toString(i));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_665389580 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_665389580.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_665389580;
        // ---------- Original Method ----------
        //insert0(offset, Integer.toString(i));
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.262 -0400", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "034DD929B3D8483380E646E48F0A9797")
    public StringBuilder insert(int offset, long l) {
        addTaint(l);
        addTaint(offset);
        insert0(offset, Long.toString(l));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1546532500 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1546532500.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1546532500;
        // ---------- Original Method ----------
        //insert0(offset, Long.toString(l));
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.263 -0400", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "61A43831631BFE8D1EE91B5C1BC3A74E")
    public StringBuilder insert(int offset, float f) {
        addTaint(f);
        addTaint(offset);
        insert0(offset, Float.toString(f));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1104737939 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1104737939.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1104737939;
        // ---------- Original Method ----------
        //insert0(offset, Float.toString(f));
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.263 -0400", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "50B6CB8B0DE058CCF377770593B3CE40")
    public StringBuilder insert(int offset, double d) {
        addTaint(d);
        addTaint(offset);
        insert0(offset, Double.toString(d));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_186855954 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_186855954.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_186855954;
        // ---------- Original Method ----------
        //insert0(offset, Double.toString(d));
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.263 -0400", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "4E81702337D3C5583393D0037F7A92A5")
    public StringBuilder insert(int offset, Object obj) {
        addTaint(obj.getTaint());
        addTaint(offset);
        insert0(offset, obj == null ? "null" : obj.toString());
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_107191723 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_107191723.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_107191723;
        // ---------- Original Method ----------
        //insert0(offset, obj == null ? "null" : obj.toString());
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.263 -0400", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "450CE72B181AF2614A599F01BA583D76")
    public StringBuilder insert(int offset, String str) {
        addTaint(str.getTaint());
        addTaint(offset);
        insert0(offset, str);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_11000954 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_11000954.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_11000954;
        // ---------- Original Method ----------
        //insert0(offset, str);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.264 -0400", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "03929DD48AB26CE211FF20AC6682A624")
    public StringBuilder insert(int offset, char[] ch) {
        addTaint(ch[0]);
        addTaint(offset);
        insert0(offset, ch);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1432779407 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1432779407.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1432779407;
        // ---------- Original Method ----------
        //insert0(offset, ch);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.264 -0400", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "42C723C9FD2C5796149B9D8D8C32352C")
    public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        addTaint(strLen);
        addTaint(strOffset);
        addTaint(str[0]);
        addTaint(offset);
        insert0(offset, str, strOffset, strLen);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1558351922 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1558351922.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1558351922;
        // ---------- Original Method ----------
        //insert0(offset, str, strOffset, strLen);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.264 -0400", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "F25B317BC41C07667894FC9C055B9331")
    public StringBuilder insert(int offset, CharSequence s) {
        addTaint(s.getTaint());
        addTaint(offset);
        insert0(offset, s == null ? "null" : s.toString());
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_612576772 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_612576772.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_612576772;
        // ---------- Original Method ----------
        //insert0(offset, s == null ? "null" : s.toString());
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.264 -0400", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "06212EB7BE06430B7ABC77A5F75BD0C1")
    public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(s.getTaint());
        addTaint(offset);
        insert0(offset, s, start, end);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_152705086 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_152705086.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_152705086;
        // ---------- Original Method ----------
        //insert0(offset, s, start, end);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.265 -0400", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "D0E8275BBEFC124D84006EB327FB0D6C")
    public StringBuilder replace(int start, int end, String str) {
        addTaint(str.getTaint());
        addTaint(end);
        addTaint(start);
        replace0(start, end, str);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_538867040 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_538867040.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_538867040;
        // ---------- Original Method ----------
        //replace0(start, end, str);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.265 -0400", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "A28A869FD35941E725A4BB3CA5D3FF36")
    public StringBuilder reverse() {
        reverse0();
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_726554741 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_726554741.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_726554741;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.265 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "183208EF0566FE902469CF6D70EEE577")
    @Override
    public String toString() {
String varD8287C6801A4C167675BF9EBA9EC2C1B_235870127 =         super.toString();
        varD8287C6801A4C167675BF9EBA9EC2C1B_235870127.addTaint(taint);
        return varD8287C6801A4C167675BF9EBA9EC2C1B_235870127;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.265 -0400", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "4DE1DD5BE1C3D644C6D668838FFFE727")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        int count = in.readInt();
        char[] value = (char[]) in.readObject();
        set(value, count);
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //int count = in.readInt();
        //char[] value = (char[]) in.readObject();
        //set(value, count);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.266 -0400", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "0CF6F2B40A5C1B15330F2F0B53F306B6")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.defaultWriteObject();
        out.writeInt(length());
        out.writeObject(getValue());
        // ---------- Original Method ----------
        //out.defaultWriteObject();
        //out.writeInt(length());
        //out.writeObject(getValue());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.266 -0400", hash_original_field = "F4B2354B73ADC1BA12DBC18B912FD456", hash_generated_field = "B39011C4BB0C9D7DCA32E1A2469D43EC")

    private static final long serialVersionUID = 4383685877147921099L;
}

