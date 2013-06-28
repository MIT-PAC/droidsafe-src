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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.987 -0400", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "DA4EC3AD95D3DFC18B77F5FCB55D20F9")
    public  StringBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.988 -0400", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "C87B8D5CC2E4D8F22859443EF81E10F6")
    public  StringBuilder(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.988 -0400", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "9636F2E0396542ADA0291846333512D2")
    public  StringBuilder(CharSequence seq) {
        super(seq.toString());
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.988 -0400", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "53D779637098BD5B700EC43E5EA94586")
    public  StringBuilder(String str) {
        super(str);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.989 -0400", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "81713ED8420D65EE7E057BEEC61A4341")
    public StringBuilder append(boolean b) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1132381722 = null; //Variable for return #1
        append0(b ? "true" : "false");
        varB4EAC82CA7396A68D541C85D26508E83_1132381722 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_1132381722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1132381722;
        // ---------- Original Method ----------
        //append0(b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.989 -0400", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "D82BE45D4130BD2C4E9A5E6AC1B7459A")
    public StringBuilder append(char c) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1468875744 = null; //Variable for return #1
        append0(c);
        varB4EAC82CA7396A68D541C85D26508E83_1468875744 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1468875744.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1468875744;
        // ---------- Original Method ----------
        //append0(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.990 -0400", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "2C13A6645A56AA972CE7721CAA07627D")
    public StringBuilder append(int i) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_658240750 = null; //Variable for return #1
        IntegralToString.appendInt(this, i);
        varB4EAC82CA7396A68D541C85D26508E83_658240750 = this;
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_658240750.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658240750;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.990 -0400", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "0B1D2FBF5B193C5663D154F326CF0A66")
    public StringBuilder append(long l) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_884522257 = null; //Variable for return #1
        IntegralToString.appendLong(this, l);
        varB4EAC82CA7396A68D541C85D26508E83_884522257 = this;
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_884522257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_884522257;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.991 -0400", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "07FBD16F970CAE7002C9FC6847548229")
    public StringBuilder append(float f) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1462868297 = null; //Variable for return #1
        RealToString.getInstance().appendFloat(this, f);
        varB4EAC82CA7396A68D541C85D26508E83_1462868297 = this;
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1462868297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1462868297;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.992 -0400", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "88559F4280246DA915321022345926C1")
    public StringBuilder append(double d) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1143657978 = null; //Variable for return #1
        RealToString.getInstance().appendDouble(this, d);
        varB4EAC82CA7396A68D541C85D26508E83_1143657978 = this;
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_1143657978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1143657978;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.992 -0400", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "48EFFB46B7DB511FD13FE414CD4FB27D")
    public StringBuilder append(Object obj) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_491648584 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(obj.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_491648584 = this;
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_491648584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_491648584;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.993 -0400", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "71DE99310AF91DD0967F9420453AB7BF")
    public StringBuilder append(String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_14658494 = null; //Variable for return #1
        append0(str);
        varB4EAC82CA7396A68D541C85D26508E83_14658494 = this;
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_14658494.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_14658494;
        // ---------- Original Method ----------
        //append0(str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.993 -0400", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "30943C7CAEBAE170F99343373067CAEE")
    public StringBuilder append(StringBuffer sb) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1011706715 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(sb.getValue(), 0, sb.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1011706715 = this;
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1011706715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011706715;
        // ---------- Original Method ----------
        //if (sb == null) {
            //appendNull();
        //} else {
            //append0(sb.getValue(), 0, sb.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.993 -0400", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "E70E6DF9B741A99E3ABB5D15A9745036")
    public StringBuilder append(char[] chars) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_46273857 = null; //Variable for return #1
        append0(chars);
        varB4EAC82CA7396A68D541C85D26508E83_46273857 = this;
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_46273857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46273857;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.994 -0400", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "8DD753DD106C238061A63DC9F488C976")
    public StringBuilder append(char[] str, int offset, int len) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_322493829 = null; //Variable for return #1
        append0(str, offset, len);
        varB4EAC82CA7396A68D541C85D26508E83_322493829 = this;
        addTaint(str[0]);
        addTaint(offset);
        addTaint(len);
        varB4EAC82CA7396A68D541C85D26508E83_322493829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_322493829;
        // ---------- Original Method ----------
        //append0(str, offset, len);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.994 -0400", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "72685F588387E5B167D04A16CBA31B81")
    public StringBuilder append(CharSequence csq) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_993322404 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(csq, 0, csq.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_993322404 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_993322404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_993322404;
        // ---------- Original Method ----------
        //if (csq == null) {
            //appendNull();
        //} else {
            //append0(csq, 0, csq.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.995 -0400", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "BEE81179AC183540F26520DD3C5430E2")
    public StringBuilder append(CharSequence csq, int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_2145818795 = null; //Variable for return #1
        append0(csq, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_2145818795 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_2145818795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145818795;
        // ---------- Original Method ----------
        //append0(csq, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.995 -0400", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "20E2314F8437F38902F48838C2AC2CBC")
    public StringBuilder appendCodePoint(int codePoint) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_337738748 = null; //Variable for return #1
        append0(Character.toChars(codePoint));
        varB4EAC82CA7396A68D541C85D26508E83_337738748 = this;
        addTaint(codePoint);
        varB4EAC82CA7396A68D541C85D26508E83_337738748.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_337738748;
        // ---------- Original Method ----------
        //append0(Character.toChars(codePoint));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.995 -0400", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "AAED484B90F1EB148DABE4C87538EE24")
    public StringBuilder delete(int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_844728765 = null; //Variable for return #1
        delete0(start, end);
        varB4EAC82CA7396A68D541C85D26508E83_844728765 = this;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_844728765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_844728765;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.996 -0400", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "D7D0E5BB8C1B8862E8F33FA82B17A832")
    public StringBuilder deleteCharAt(int index) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1571696308 = null; //Variable for return #1
        deleteCharAt0(index);
        varB4EAC82CA7396A68D541C85D26508E83_1571696308 = this;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1571696308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1571696308;
        // ---------- Original Method ----------
        //deleteCharAt0(index);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.996 -0400", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "D40CE1F2F419632641C31D9C3201004E")
    public StringBuilder insert(int offset, boolean b) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_210310036 = null; //Variable for return #1
        insert0(offset, b ? "true" : "false");
        varB4EAC82CA7396A68D541C85D26508E83_210310036 = this;
        addTaint(offset);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_210310036.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_210310036;
        // ---------- Original Method ----------
        //insert0(offset, b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.997 -0400", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "D2C7C4D584A03FC4C7DFEDE6946353EB")
    public StringBuilder insert(int offset, char c) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_965721168 = null; //Variable for return #1
        insert0(offset, c);
        varB4EAC82CA7396A68D541C85D26508E83_965721168 = this;
        addTaint(offset);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_965721168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_965721168;
        // ---------- Original Method ----------
        //insert0(offset, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.997 -0400", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "8DF60B1AFE5E9F232EC83A7B5B136BFA")
    public StringBuilder insert(int offset, int i) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1129227881 = null; //Variable for return #1
        insert0(offset, Integer.toString(i));
        varB4EAC82CA7396A68D541C85D26508E83_1129227881 = this;
        addTaint(offset);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1129227881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1129227881;
        // ---------- Original Method ----------
        //insert0(offset, Integer.toString(i));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.997 -0400", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "BFB4586D7618F142F1595B6F736EE347")
    public StringBuilder insert(int offset, long l) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1186652176 = null; //Variable for return #1
        insert0(offset, Long.toString(l));
        varB4EAC82CA7396A68D541C85D26508E83_1186652176 = this;
        addTaint(offset);
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_1186652176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1186652176;
        // ---------- Original Method ----------
        //insert0(offset, Long.toString(l));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.998 -0400", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "945C595DF45CCE0AF0AA21606011B49D")
    public StringBuilder insert(int offset, float f) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1966216476 = null; //Variable for return #1
        insert0(offset, Float.toString(f));
        varB4EAC82CA7396A68D541C85D26508E83_1966216476 = this;
        addTaint(offset);
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1966216476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1966216476;
        // ---------- Original Method ----------
        //insert0(offset, Float.toString(f));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.998 -0400", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "D1447DFC4A4732848AA77FAFFF482558")
    public StringBuilder insert(int offset, double d) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_804044458 = null; //Variable for return #1
        insert0(offset, Double.toString(d));
        varB4EAC82CA7396A68D541C85D26508E83_804044458 = this;
        addTaint(offset);
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_804044458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_804044458;
        // ---------- Original Method ----------
        //insert0(offset, Double.toString(d));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.999 -0400", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "0A53FBCF86FB195BDEFEDED1F434AB57")
    public StringBuilder insert(int offset, Object obj) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_2012229682 = null; //Variable for return #1
        insert0(offset, obj == null ? "null" : obj.toString());
        varB4EAC82CA7396A68D541C85D26508E83_2012229682 = this;
        addTaint(offset);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2012229682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012229682;
        // ---------- Original Method ----------
        //insert0(offset, obj == null ? "null" : obj.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.999 -0400", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "54028471CD78C7B05D8E09DA36D10FBF")
    public StringBuilder insert(int offset, String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1854641884 = null; //Variable for return #1
        insert0(offset, str);
        varB4EAC82CA7396A68D541C85D26508E83_1854641884 = this;
        addTaint(offset);
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1854641884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1854641884;
        // ---------- Original Method ----------
        //insert0(offset, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.999 -0400", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "590B4E96BA3742D013E0D93C81E82765")
    public StringBuilder insert(int offset, char[] ch) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_541655633 = null; //Variable for return #1
        insert0(offset, ch);
        varB4EAC82CA7396A68D541C85D26508E83_541655633 = this;
        addTaint(offset);
        addTaint(ch[0]);
        varB4EAC82CA7396A68D541C85D26508E83_541655633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541655633;
        // ---------- Original Method ----------
        //insert0(offset, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.001 -0400", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "3132C15F16BA32F811C3A52547E218A0")
    public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1393364254 = null; //Variable for return #1
        insert0(offset, str, strOffset, strLen);
        varB4EAC82CA7396A68D541C85D26508E83_1393364254 = this;
        addTaint(offset);
        addTaint(str[0]);
        addTaint(strOffset);
        addTaint(strLen);
        varB4EAC82CA7396A68D541C85D26508E83_1393364254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393364254;
        // ---------- Original Method ----------
        //insert0(offset, str, strOffset, strLen);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.002 -0400", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "935BE2B5EEFD282B6DC47F4470BF3D89")
    public StringBuilder insert(int offset, CharSequence s) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1182978963 = null; //Variable for return #1
        insert0(offset, s == null ? "null" : s.toString());
        varB4EAC82CA7396A68D541C85D26508E83_1182978963 = this;
        addTaint(offset);
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1182978963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1182978963;
        // ---------- Original Method ----------
        //insert0(offset, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.003 -0400", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "24D8CFE8428D6FEA4E5712453B15D96E")
    public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_130395655 = null; //Variable for return #1
        insert0(offset, s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_130395655 = this;
        addTaint(offset);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_130395655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_130395655;
        // ---------- Original Method ----------
        //insert0(offset, s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.004 -0400", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "31D2C295F8A63268037D99A53A322A2E")
    public StringBuilder replace(int start, int end, String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_684102702 = null; //Variable for return #1
        replace0(start, end, str);
        varB4EAC82CA7396A68D541C85D26508E83_684102702 = this;
        addTaint(start);
        addTaint(end);
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_684102702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_684102702;
        // ---------- Original Method ----------
        //replace0(start, end, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.005 -0400", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "570CDB45B4BC93617459A9A97EA38A29")
    public StringBuilder reverse() {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_43030042 = null; //Variable for return #1
        reverse0();
        varB4EAC82CA7396A68D541C85D26508E83_43030042 = this;
        varB4EAC82CA7396A68D541C85D26508E83_43030042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_43030042;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.008 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "C00144D5DCA6285335E7B413BD1D76B1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_456902460 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_456902460 = super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_456902460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_456902460;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.009 -0400", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "F4ABACC936A6FBCD3A66D626F6FE6A6B")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        int count = in.readInt();
        char[] value = (char[]) in.readObject();
        set(value, count);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //int count = in.readInt();
        //char[] value = (char[]) in.readObject();
        //set(value, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.010 -0400", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "8115630D18763F35F96FC3870255ABFF")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.010 -0400", hash_original_field = "F4B2354B73ADC1BA12DBC18B912FD456", hash_generated_field = "B39011C4BB0C9D7DCA32E1A2469D43EC")

    private static final long serialVersionUID = 4383685877147921099L;
}

