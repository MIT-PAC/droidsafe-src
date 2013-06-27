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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.317 -0400", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "DA4EC3AD95D3DFC18B77F5FCB55D20F9")
    public  StringBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.317 -0400", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "C87B8D5CC2E4D8F22859443EF81E10F6")
    public  StringBuilder(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.318 -0400", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "9636F2E0396542ADA0291846333512D2")
    public  StringBuilder(CharSequence seq) {
        super(seq.toString());
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.318 -0400", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "53D779637098BD5B700EC43E5EA94586")
    public  StringBuilder(String str) {
        super(str);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.318 -0400", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "F6249C5E256750731DD35CC9B177C037")
    public StringBuilder append(boolean b) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_847741434 = null; //Variable for return #1
        append0(b ? "true" : "false");
        varB4EAC82CA7396A68D541C85D26508E83_847741434 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_847741434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_847741434;
        // ---------- Original Method ----------
        //append0(b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.319 -0400", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "D72547F1AF3BD3056FE64316453A04A1")
    public StringBuilder append(char c) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_966573203 = null; //Variable for return #1
        append0(c);
        varB4EAC82CA7396A68D541C85D26508E83_966573203 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_966573203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_966573203;
        // ---------- Original Method ----------
        //append0(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.319 -0400", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "B9CA6617D0ABD1247ACA11F21674901B")
    public StringBuilder append(int i) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1293185732 = null; //Variable for return #1
        IntegralToString.appendInt(this, i);
        varB4EAC82CA7396A68D541C85D26508E83_1293185732 = this;
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1293185732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1293185732;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.320 -0400", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "8B844A019EEFF078B17C704710EB9CE9")
    public StringBuilder append(long l) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1221922064 = null; //Variable for return #1
        IntegralToString.appendLong(this, l);
        varB4EAC82CA7396A68D541C85D26508E83_1221922064 = this;
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_1221922064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1221922064;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.320 -0400", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "B4C08CAA3D5CB4F25D59B86A2AD33C14")
    public StringBuilder append(float f) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1977807457 = null; //Variable for return #1
        RealToString.getInstance().appendFloat(this, f);
        varB4EAC82CA7396A68D541C85D26508E83_1977807457 = this;
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1977807457.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1977807457;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.333 -0400", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "A097479BD10451E7B1EAADA0FB7326E2")
    public StringBuilder append(double d) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_354731867 = null; //Variable for return #1
        RealToString.getInstance().appendDouble(this, d);
        varB4EAC82CA7396A68D541C85D26508E83_354731867 = this;
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_354731867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_354731867;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.335 -0400", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "803E9AD8857EF0D7173B1272AD68E2BB")
    public StringBuilder append(Object obj) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_2040617772 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(obj.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2040617772 = this;
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2040617772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2040617772;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.341 -0400", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "A19A544D4D5A9B0294B8C7D495DAD47C")
    public StringBuilder append(String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1820066458 = null; //Variable for return #1
        append0(str);
        varB4EAC82CA7396A68D541C85D26508E83_1820066458 = this;
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1820066458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1820066458;
        // ---------- Original Method ----------
        //append0(str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.342 -0400", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "A0FA52585CB9DE4B95E78B02DB1CF18C")
    public StringBuilder append(StringBuffer sb) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1452916024 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(sb.getValue(), 0, sb.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1452916024 = this;
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1452916024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452916024;
        // ---------- Original Method ----------
        //if (sb == null) {
            //appendNull();
        //} else {
            //append0(sb.getValue(), 0, sb.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.342 -0400", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "F9222334209BD9A258032D95923D3335")
    public StringBuilder append(char[] chars) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_508361150 = null; //Variable for return #1
        append0(chars);
        varB4EAC82CA7396A68D541C85D26508E83_508361150 = this;
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_508361150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_508361150;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.357 -0400", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "9E02C8FD374ED3645C63842088A3227B")
    public StringBuilder append(char[] str, int offset, int len) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_2018784566 = null; //Variable for return #1
        append0(str, offset, len);
        varB4EAC82CA7396A68D541C85D26508E83_2018784566 = this;
        addTaint(str[0]);
        addTaint(offset);
        addTaint(len);
        varB4EAC82CA7396A68D541C85D26508E83_2018784566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2018784566;
        // ---------- Original Method ----------
        //append0(str, offset, len);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.357 -0400", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "883A86298827F80B841C3BDE97DD104D")
    public StringBuilder append(CharSequence csq) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1812865851 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(csq, 0, csq.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1812865851 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1812865851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1812865851;
        // ---------- Original Method ----------
        //if (csq == null) {
            //appendNull();
        //} else {
            //append0(csq, 0, csq.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.358 -0400", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "C2300CEDBBF25B376310F181F68F8558")
    public StringBuilder append(CharSequence csq, int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_2013511271 = null; //Variable for return #1
        append0(csq, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_2013511271 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_2013511271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2013511271;
        // ---------- Original Method ----------
        //append0(csq, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.358 -0400", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "F372355738C45A5349D46C5B71E5924C")
    public StringBuilder appendCodePoint(int codePoint) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1615745233 = null; //Variable for return #1
        append0(Character.toChars(codePoint));
        varB4EAC82CA7396A68D541C85D26508E83_1615745233 = this;
        addTaint(codePoint);
        varB4EAC82CA7396A68D541C85D26508E83_1615745233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1615745233;
        // ---------- Original Method ----------
        //append0(Character.toChars(codePoint));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.359 -0400", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "60DABC2555468E97BDAE90469EE81878")
    public StringBuilder delete(int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_262430662 = null; //Variable for return #1
        delete0(start, end);
        varB4EAC82CA7396A68D541C85D26508E83_262430662 = this;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_262430662.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_262430662;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.359 -0400", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "C1AE7B1AF43435003CD5AAF030798FA4")
    public StringBuilder deleteCharAt(int index) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1140750119 = null; //Variable for return #1
        deleteCharAt0(index);
        varB4EAC82CA7396A68D541C85D26508E83_1140750119 = this;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1140750119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1140750119;
        // ---------- Original Method ----------
        //deleteCharAt0(index);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.360 -0400", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "3AC89D65667BDCE85B5B94EC21157E37")
    public StringBuilder insert(int offset, boolean b) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_72128642 = null; //Variable for return #1
        insert0(offset, b ? "true" : "false");
        varB4EAC82CA7396A68D541C85D26508E83_72128642 = this;
        addTaint(offset);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_72128642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_72128642;
        // ---------- Original Method ----------
        //insert0(offset, b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.360 -0400", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "39332C0D5AA8012BA55FD61AD7CF6BE7")
    public StringBuilder insert(int offset, char c) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1626188831 = null; //Variable for return #1
        insert0(offset, c);
        varB4EAC82CA7396A68D541C85D26508E83_1626188831 = this;
        addTaint(offset);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1626188831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1626188831;
        // ---------- Original Method ----------
        //insert0(offset, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.365 -0400", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "688219842C2BB2978F620AC5FD9110AA")
    public StringBuilder insert(int offset, int i) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1871161499 = null; //Variable for return #1
        insert0(offset, Integer.toString(i));
        varB4EAC82CA7396A68D541C85D26508E83_1871161499 = this;
        addTaint(offset);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1871161499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1871161499;
        // ---------- Original Method ----------
        //insert0(offset, Integer.toString(i));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.366 -0400", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "029566847BDB457165A630A27090B9DB")
    public StringBuilder insert(int offset, long l) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_2026190824 = null; //Variable for return #1
        insert0(offset, Long.toString(l));
        varB4EAC82CA7396A68D541C85D26508E83_2026190824 = this;
        addTaint(offset);
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_2026190824.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2026190824;
        // ---------- Original Method ----------
        //insert0(offset, Long.toString(l));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.379 -0400", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "CB144001159D6222DE4D856023AC5DB1")
    public StringBuilder insert(int offset, float f) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1366188177 = null; //Variable for return #1
        insert0(offset, Float.toString(f));
        varB4EAC82CA7396A68D541C85D26508E83_1366188177 = this;
        addTaint(offset);
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1366188177.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366188177;
        // ---------- Original Method ----------
        //insert0(offset, Float.toString(f));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.379 -0400", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "615094F8D495BFCAA8EC0398E9C6E68A")
    public StringBuilder insert(int offset, double d) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1856020471 = null; //Variable for return #1
        insert0(offset, Double.toString(d));
        varB4EAC82CA7396A68D541C85D26508E83_1856020471 = this;
        addTaint(offset);
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_1856020471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1856020471;
        // ---------- Original Method ----------
        //insert0(offset, Double.toString(d));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.380 -0400", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "DF2D791B97AF10EAE28DAC0AD4B25278")
    public StringBuilder insert(int offset, Object obj) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_603340018 = null; //Variable for return #1
        insert0(offset, obj == null ? "null" : obj.toString());
        varB4EAC82CA7396A68D541C85D26508E83_603340018 = this;
        addTaint(offset);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_603340018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603340018;
        // ---------- Original Method ----------
        //insert0(offset, obj == null ? "null" : obj.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.380 -0400", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "BB7179C4D583301FF137449858795254")
    public StringBuilder insert(int offset, String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_252576063 = null; //Variable for return #1
        insert0(offset, str);
        varB4EAC82CA7396A68D541C85D26508E83_252576063 = this;
        addTaint(offset);
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_252576063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_252576063;
        // ---------- Original Method ----------
        //insert0(offset, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.381 -0400", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "125F97EBE28FC0125A00E2A78FB2E3A3")
    public StringBuilder insert(int offset, char[] ch) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_2065209307 = null; //Variable for return #1
        insert0(offset, ch);
        varB4EAC82CA7396A68D541C85D26508E83_2065209307 = this;
        addTaint(offset);
        addTaint(ch[0]);
        varB4EAC82CA7396A68D541C85D26508E83_2065209307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2065209307;
        // ---------- Original Method ----------
        //insert0(offset, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.383 -0400", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "86092ED689C01D8EC3832A9CF028605B")
    public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_903775101 = null; //Variable for return #1
        insert0(offset, str, strOffset, strLen);
        varB4EAC82CA7396A68D541C85D26508E83_903775101 = this;
        addTaint(offset);
        addTaint(str[0]);
        addTaint(strOffset);
        addTaint(strLen);
        varB4EAC82CA7396A68D541C85D26508E83_903775101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_903775101;
        // ---------- Original Method ----------
        //insert0(offset, str, strOffset, strLen);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.383 -0400", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "B2D86F356D8BA0EAD20D4074B8E9CE8D")
    public StringBuilder insert(int offset, CharSequence s) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_613686921 = null; //Variable for return #1
        insert0(offset, s == null ? "null" : s.toString());
        varB4EAC82CA7396A68D541C85D26508E83_613686921 = this;
        addTaint(offset);
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_613686921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_613686921;
        // ---------- Original Method ----------
        //insert0(offset, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.390 -0400", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "33113DDFD9C5409178CCF85D19DE9584")
    public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_612100776 = null; //Variable for return #1
        insert0(offset, s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_612100776 = this;
        addTaint(offset);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_612100776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_612100776;
        // ---------- Original Method ----------
        //insert0(offset, s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.390 -0400", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "0F1CE71ADC31F8E2498BC506E351ACDF")
    public StringBuilder replace(int start, int end, String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_902683489 = null; //Variable for return #1
        replace0(start, end, str);
        varB4EAC82CA7396A68D541C85D26508E83_902683489 = this;
        addTaint(start);
        addTaint(end);
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_902683489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_902683489;
        // ---------- Original Method ----------
        //replace0(start, end, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.391 -0400", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "E12F40E8E07313033C29836C5CBF57BE")
    public StringBuilder reverse() {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_824944841 = null; //Variable for return #1
        reverse0();
        varB4EAC82CA7396A68D541C85D26508E83_824944841 = this;
        varB4EAC82CA7396A68D541C85D26508E83_824944841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_824944841;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.391 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "260367DA182BD2ECA0202D3B6569C102")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2139820533 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2139820533 = super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2139820533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2139820533;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.391 -0400", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "01DB8AD795973ACDEC2E5FE0276750F6")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        int count;
        count = in.readInt();
        char[] value;
        value = (char[]) in.readObject();
        set(value, count);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //int count = in.readInt();
        //char[] value = (char[]) in.readObject();
        //set(value, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.397 -0400", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "8115630D18763F35F96FC3870255ABFF")
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(length());
        out.writeObject(getValue());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.defaultWriteObject();
        //out.writeInt(length());
        //out.writeObject(getValue());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.397 -0400", hash_original_field = "F4B2354B73ADC1BA12DBC18B912FD456", hash_generated_field = "4CB1A36FCD3CC49CB7DC80BF3FE5F825")

    private static long serialVersionUID = 4383685877147921099L;
}

