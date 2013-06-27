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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.371 -0400", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "DA4EC3AD95D3DFC18B77F5FCB55D20F9")
    public  StringBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.372 -0400", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "C87B8D5CC2E4D8F22859443EF81E10F6")
    public  StringBuilder(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.372 -0400", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "9636F2E0396542ADA0291846333512D2")
    public  StringBuilder(CharSequence seq) {
        super(seq.toString());
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.372 -0400", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "53D779637098BD5B700EC43E5EA94586")
    public  StringBuilder(String str) {
        super(str);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.385 -0400", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "68DA325698CEBF1AF149FC6BF2AB974B")
    public StringBuilder append(boolean b) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_196075271 = null; //Variable for return #1
        append0(b ? "true" : "false");
        varB4EAC82CA7396A68D541C85D26508E83_196075271 = this;
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_196075271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_196075271;
        // ---------- Original Method ----------
        //append0(b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.385 -0400", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "1A8A094A3BE4A3952256DFD9016B95F3")
    public StringBuilder append(char c) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_118907552 = null; //Variable for return #1
        append0(c);
        varB4EAC82CA7396A68D541C85D26508E83_118907552 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_118907552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_118907552;
        // ---------- Original Method ----------
        //append0(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.386 -0400", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "327194C601770D59C134D9E084B4ADC1")
    public StringBuilder append(int i) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1920559138 = null; //Variable for return #1
        IntegralToString.appendInt(this, i);
        varB4EAC82CA7396A68D541C85D26508E83_1920559138 = this;
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1920559138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1920559138;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.386 -0400", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "75348370A1DD28B9315F7B7C96B89A06")
    public StringBuilder append(long l) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_100812559 = null; //Variable for return #1
        IntegralToString.appendLong(this, l);
        varB4EAC82CA7396A68D541C85D26508E83_100812559 = this;
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_100812559.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_100812559;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.387 -0400", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "588A4DFB6B5A1C78DA2C82C251977E8A")
    public StringBuilder append(float f) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_503305894 = null; //Variable for return #1
        RealToString.getInstance().appendFloat(this, f);
        varB4EAC82CA7396A68D541C85D26508E83_503305894 = this;
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_503305894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_503305894;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.387 -0400", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "CF18E7A02F42E869DBBF843695CA8BE7")
    public StringBuilder append(double d) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_156112615 = null; //Variable for return #1
        RealToString.getInstance().appendDouble(this, d);
        varB4EAC82CA7396A68D541C85D26508E83_156112615 = this;
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_156112615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_156112615;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.388 -0400", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "82F579297D73C64F6ACEA42CF80D04EA")
    public StringBuilder append(Object obj) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_166326655 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(obj.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_166326655 = this;
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_166326655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_166326655;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.388 -0400", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "35D323E8DA5D496489C0D97420CD157A")
    public StringBuilder append(String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1689062999 = null; //Variable for return #1
        append0(str);
        varB4EAC82CA7396A68D541C85D26508E83_1689062999 = this;
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1689062999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689062999;
        // ---------- Original Method ----------
        //append0(str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.400 -0400", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "61B228134A9BAEE86377B9AE52BD7F56")
    public StringBuilder append(StringBuffer sb) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_436377170 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(sb.getValue(), 0, sb.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_436377170 = this;
        addTaint(sb.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_436377170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_436377170;
        // ---------- Original Method ----------
        //if (sb == null) {
            //appendNull();
        //} else {
            //append0(sb.getValue(), 0, sb.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.400 -0400", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "6804137B525D9FAF2DAF95646C6D054B")
    public StringBuilder append(char[] chars) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_950894494 = null; //Variable for return #1
        append0(chars);
        varB4EAC82CA7396A68D541C85D26508E83_950894494 = this;
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_950894494.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_950894494;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.400 -0400", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "7849E97C44F6E6957E1A9E0E29A375BC")
    public StringBuilder append(char[] str, int offset, int len) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_504784227 = null; //Variable for return #1
        append0(str, offset, len);
        varB4EAC82CA7396A68D541C85D26508E83_504784227 = this;
        addTaint(str[0]);
        addTaint(offset);
        addTaint(len);
        varB4EAC82CA7396A68D541C85D26508E83_504784227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_504784227;
        // ---------- Original Method ----------
        //append0(str, offset, len);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.401 -0400", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "D50CEA90D21DD65C68658E0FA314508D")
    public StringBuilder append(CharSequence csq) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1464827165 = null; //Variable for return #1
        {
            appendNull();
        } //End block
        {
            append0(csq, 0, csq.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1464827165 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1464827165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1464827165;
        // ---------- Original Method ----------
        //if (csq == null) {
            //appendNull();
        //} else {
            //append0(csq, 0, csq.length());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.401 -0400", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "607AFA999E105ADDB64C602D6927FFA1")
    public StringBuilder append(CharSequence csq, int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1440266688 = null; //Variable for return #1
        append0(csq, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_1440266688 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1440266688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1440266688;
        // ---------- Original Method ----------
        //append0(csq, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.402 -0400", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "D14214C0C285267C74C2DB1FA306DF5C")
    public StringBuilder appendCodePoint(int codePoint) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1832724394 = null; //Variable for return #1
        append0(Character.toChars(codePoint));
        varB4EAC82CA7396A68D541C85D26508E83_1832724394 = this;
        addTaint(codePoint);
        varB4EAC82CA7396A68D541C85D26508E83_1832724394.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1832724394;
        // ---------- Original Method ----------
        //append0(Character.toChars(codePoint));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.402 -0400", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "8C1061961A9719813CEEC452B1691938")
    public StringBuilder delete(int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_709728869 = null; //Variable for return #1
        delete0(start, end);
        varB4EAC82CA7396A68D541C85D26508E83_709728869 = this;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_709728869.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_709728869;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.418 -0400", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "A120427058EEF45184D38401014DFDED")
    public StringBuilder deleteCharAt(int index) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1384462637 = null; //Variable for return #1
        deleteCharAt0(index);
        varB4EAC82CA7396A68D541C85D26508E83_1384462637 = this;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1384462637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1384462637;
        // ---------- Original Method ----------
        //deleteCharAt0(index);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.423 -0400", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "FA9D087F15C37F0671CC0B680A20B997")
    public StringBuilder insert(int offset, boolean b) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_150461977 = null; //Variable for return #1
        insert0(offset, b ? "true" : "false");
        varB4EAC82CA7396A68D541C85D26508E83_150461977 = this;
        addTaint(offset);
        addTaint(b);
        varB4EAC82CA7396A68D541C85D26508E83_150461977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_150461977;
        // ---------- Original Method ----------
        //insert0(offset, b ? "true" : "false");
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.424 -0400", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "D021503C8E59FE8C8EFB92FC12224D41")
    public StringBuilder insert(int offset, char c) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1890889183 = null; //Variable for return #1
        insert0(offset, c);
        varB4EAC82CA7396A68D541C85D26508E83_1890889183 = this;
        addTaint(offset);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1890889183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1890889183;
        // ---------- Original Method ----------
        //insert0(offset, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.424 -0400", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "A9FD83E12EA7D92971C610F1528A4CD2")
    public StringBuilder insert(int offset, int i) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_273962614 = null; //Variable for return #1
        insert0(offset, Integer.toString(i));
        varB4EAC82CA7396A68D541C85D26508E83_273962614 = this;
        addTaint(offset);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_273962614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_273962614;
        // ---------- Original Method ----------
        //insert0(offset, Integer.toString(i));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.425 -0400", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "99A9513109EBE0EFA0025B1A4EC7916D")
    public StringBuilder insert(int offset, long l) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_674171155 = null; //Variable for return #1
        insert0(offset, Long.toString(l));
        varB4EAC82CA7396A68D541C85D26508E83_674171155 = this;
        addTaint(offset);
        addTaint(l);
        varB4EAC82CA7396A68D541C85D26508E83_674171155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_674171155;
        // ---------- Original Method ----------
        //insert0(offset, Long.toString(l));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.425 -0400", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "372DE00C64BF9D740B1C65B6045882E7")
    public StringBuilder insert(int offset, float f) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1442518681 = null; //Variable for return #1
        insert0(offset, Float.toString(f));
        varB4EAC82CA7396A68D541C85D26508E83_1442518681 = this;
        addTaint(offset);
        addTaint(f);
        varB4EAC82CA7396A68D541C85D26508E83_1442518681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442518681;
        // ---------- Original Method ----------
        //insert0(offset, Float.toString(f));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.430 -0400", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "AAFCB4EF4B2783B938EF6FC4E2F759CB")
    public StringBuilder insert(int offset, double d) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1967880905 = null; //Variable for return #1
        insert0(offset, Double.toString(d));
        varB4EAC82CA7396A68D541C85D26508E83_1967880905 = this;
        addTaint(offset);
        addTaint(d);
        varB4EAC82CA7396A68D541C85D26508E83_1967880905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1967880905;
        // ---------- Original Method ----------
        //insert0(offset, Double.toString(d));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.431 -0400", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "23AAFD714FFB30F654CB0A3D7F7AF346")
    public StringBuilder insert(int offset, Object obj) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1583933387 = null; //Variable for return #1
        insert0(offset, obj == null ? "null" : obj.toString());
        varB4EAC82CA7396A68D541C85D26508E83_1583933387 = this;
        addTaint(offset);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1583933387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1583933387;
        // ---------- Original Method ----------
        //insert0(offset, obj == null ? "null" : obj.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.432 -0400", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "8A47DC7D029ED0645833AEDF10BB8D81")
    public StringBuilder insert(int offset, String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1180696168 = null; //Variable for return #1
        insert0(offset, str);
        varB4EAC82CA7396A68D541C85D26508E83_1180696168 = this;
        addTaint(offset);
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1180696168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1180696168;
        // ---------- Original Method ----------
        //insert0(offset, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.449 -0400", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "F83D7A19307289B1B7DACBB124040F2A")
    public StringBuilder insert(int offset, char[] ch) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_660548645 = null; //Variable for return #1
        insert0(offset, ch);
        varB4EAC82CA7396A68D541C85D26508E83_660548645 = this;
        addTaint(offset);
        addTaint(ch[0]);
        varB4EAC82CA7396A68D541C85D26508E83_660548645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_660548645;
        // ---------- Original Method ----------
        //insert0(offset, ch);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.450 -0400", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "9A089EC9D59706F7588834585D28562B")
    public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1471358632 = null; //Variable for return #1
        insert0(offset, str, strOffset, strLen);
        varB4EAC82CA7396A68D541C85D26508E83_1471358632 = this;
        addTaint(offset);
        addTaint(str[0]);
        addTaint(strOffset);
        addTaint(strLen);
        varB4EAC82CA7396A68D541C85D26508E83_1471358632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1471358632;
        // ---------- Original Method ----------
        //insert0(offset, str, strOffset, strLen);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.451 -0400", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "8EA93A0C1FF85ED25FD41647B1BB2753")
    public StringBuilder insert(int offset, CharSequence s) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1835509477 = null; //Variable for return #1
        insert0(offset, s == null ? "null" : s.toString());
        varB4EAC82CA7396A68D541C85D26508E83_1835509477 = this;
        addTaint(offset);
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1835509477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1835509477;
        // ---------- Original Method ----------
        //insert0(offset, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.451 -0400", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "DB4556481BE8F891F43926F81157A209")
    public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1761027571 = null; //Variable for return #1
        insert0(offset, s, start, end);
        varB4EAC82CA7396A68D541C85D26508E83_1761027571 = this;
        addTaint(offset);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1761027571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1761027571;
        // ---------- Original Method ----------
        //insert0(offset, s, start, end);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.452 -0400", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "E857A675A72A3A8DB18C80A698C968E8")
    public StringBuilder replace(int start, int end, String str) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1789723712 = null; //Variable for return #1
        replace0(start, end, str);
        varB4EAC82CA7396A68D541C85D26508E83_1789723712 = this;
        addTaint(start);
        addTaint(end);
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1789723712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1789723712;
        // ---------- Original Method ----------
        //replace0(start, end, str);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.455 -0400", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "F31463D2562B4CEAB8F51B9DB2E88337")
    public StringBuilder reverse() {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_472063228 = null; //Variable for return #1
        reverse0();
        varB4EAC82CA7396A68D541C85D26508E83_472063228 = this;
        varB4EAC82CA7396A68D541C85D26508E83_472063228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_472063228;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.456 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "6EE7B1C721DAE70F7D120CEBA7BFC0C7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1030266092 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1030266092 = super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1030266092.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1030266092;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.456 -0400", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "01DB8AD795973ACDEC2E5FE0276750F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.457 -0400", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "8115630D18763F35F96FC3870255ABFF")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.457 -0400", hash_original_field = "F4B2354B73ADC1BA12DBC18B912FD456", hash_generated_field = "4CB1A36FCD3CC49CB7DC80BF3FE5F825")

    private static long serialVersionUID = 4383685877147921099L;
}

