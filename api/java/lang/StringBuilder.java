package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class StringBuilder extends AbstractStringBuilder implements Appendable, CharSequence, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.246 -0400", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "DA4EC3AD95D3DFC18B77F5FCB55D20F9")
    public  StringBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.247 -0400", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "C87B8D5CC2E4D8F22859443EF81E10F6")
    public  StringBuilder(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.247 -0400", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "9636F2E0396542ADA0291846333512D2")
    public  StringBuilder(CharSequence seq) {
        super(seq.toString());
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.248 -0400", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "53D779637098BD5B700EC43E5EA94586")
    public  StringBuilder(String str) {
        super(str);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.248 -0400", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "7AB0DD52E9B60D4626747D67EC2B3F3B")
    public StringBuilder append(boolean b) {
        addTaint(b);
        append0(b ? "true" : "false");
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_329972231 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_329972231.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_329972231;
        // ---------- Original Method ----------
        //append0(b ? "true" : "false");
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.249 -0400", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "5CDFF38BFE5664AF9ACC667F1A7D839E")
    public StringBuilder append(char c) {
        addTaint(c);
        append0(c);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1115167991 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1115167991.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1115167991;
        // ---------- Original Method ----------
        //append0(c);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.250 -0400", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "CA3F0E23F5F2329AC822D5CE75E5D721")
    public StringBuilder append(int i) {
        addTaint(i);
        IntegralToString.appendInt(this, i);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_675547414 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_675547414.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_675547414;
        // ---------- Original Method ----------
        //IntegralToString.appendInt(this, i);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.250 -0400", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "30B086AE543F1EF722E6F150503CED1D")
    public StringBuilder append(long l) {
        addTaint(l);
        IntegralToString.appendLong(this, l);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_943437327 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_943437327.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_943437327;
        // ---------- Original Method ----------
        //IntegralToString.appendLong(this, l);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.251 -0400", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "B9E4BC27096C0CD92A7E868F4886DFE6")
    public StringBuilder append(float f) {
        addTaint(f);
        RealToString.getInstance().appendFloat(this, f);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_955182297 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_955182297.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_955182297;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendFloat(this, f);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.251 -0400", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "B1C01C58AC53FFE9CED71041D9018D15")
    public StringBuilder append(double d) {
        addTaint(d);
        RealToString.getInstance().appendDouble(this, d);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_796367280 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_796367280.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_796367280;
        // ---------- Original Method ----------
        //RealToString.getInstance().appendDouble(this, d);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.252 -0400", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "A986CD904EA0E7001D65AC4C6ECAB5E7")
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
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_702077542 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_702077542.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_702077542;
        // ---------- Original Method ----------
        //if (obj == null) {
            //appendNull();
        //} else {
            //append0(obj.toString());
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.252 -0400", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "A33B99E966A505662973A9C408B14535")
    public StringBuilder append(String str) {
        addTaint(str.getTaint());
        append0(str);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_56366246 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_56366246.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_56366246;
        // ---------- Original Method ----------
        //append0(str);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.253 -0400", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "84CABCADB4F405FE93B48C78B73D76D0")
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
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1674148471 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1674148471.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1674148471;
        // ---------- Original Method ----------
        //if (sb == null) {
            //appendNull();
        //} else {
            //append0(sb.getValue(), 0, sb.length());
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.254 -0400", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "A4DEBA749F81B16197CEC99884E157B0")
    public StringBuilder append(char[] chars) {
        addTaint(chars[0]);
        append0(chars);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_219979397 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_219979397.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_219979397;
        // ---------- Original Method ----------
        //append0(chars);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.255 -0400", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "C5D92DC5826F280014BB9B208DA8D86A")
    public StringBuilder append(char[] str, int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(str[0]);
        append0(str, offset, len);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_542023539 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_542023539.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_542023539;
        // ---------- Original Method ----------
        //append0(str, offset, len);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.256 -0400", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "FBDC6F22FBCDB7C0952BBFA82D66C70D")
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
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_807076947 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_807076947.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_807076947;
        // ---------- Original Method ----------
        //if (csq == null) {
            //appendNull();
        //} else {
            //append0(csq, 0, csq.length());
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.257 -0400", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "24F9ED36969A45CA4EE28C28B31B761D")
    public StringBuilder append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
        append0(csq, start, end);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_2017467054 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2017467054.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2017467054;
        // ---------- Original Method ----------
        //append0(csq, start, end);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.257 -0400", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "A19387256820A9DCD4E8253FE406F147")
    public StringBuilder appendCodePoint(int codePoint) {
        addTaint(codePoint);
        append0(Character.toChars(codePoint));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1000794997 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1000794997.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1000794997;
        // ---------- Original Method ----------
        //append0(Character.toChars(codePoint));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.258 -0400", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "5F4F5BA55A3C80B213269C6F4AB379F4")
    public StringBuilder delete(int start, int end) {
        addTaint(end);
        addTaint(start);
        delete0(start, end);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1139290942 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1139290942.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1139290942;
        // ---------- Original Method ----------
        //delete0(start, end);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.258 -0400", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "4C949CA20412575661E8506DA63E9EF5")
    public StringBuilder deleteCharAt(int index) {
        addTaint(index);
        deleteCharAt0(index);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1023934568 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1023934568.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1023934568;
        // ---------- Original Method ----------
        //deleteCharAt0(index);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.258 -0400", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "C47D31F4A7061415C27CC213A5B8D4FA")
    public StringBuilder insert(int offset, boolean b) {
        addTaint(b);
        addTaint(offset);
        insert0(offset, b ? "true" : "false");
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_193194965 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_193194965.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_193194965;
        // ---------- Original Method ----------
        //insert0(offset, b ? "true" : "false");
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.259 -0400", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "CD1DDEE68C4051DB95D906ACD81B9CE1")
    public StringBuilder insert(int offset, char c) {
        addTaint(c);
        addTaint(offset);
        insert0(offset, c);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1274684432 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1274684432.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1274684432;
        // ---------- Original Method ----------
        //insert0(offset, c);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.259 -0400", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "1CB6D254F16ACE488F0D32D90CB2FE9A")
    public StringBuilder insert(int offset, int i) {
        addTaint(i);
        addTaint(offset);
        insert0(offset, Integer.toString(i));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_949260927 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_949260927.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_949260927;
        // ---------- Original Method ----------
        //insert0(offset, Integer.toString(i));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.260 -0400", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "5238175F123FFCD2254D12D9E17FB977")
    public StringBuilder insert(int offset, long l) {
        addTaint(l);
        addTaint(offset);
        insert0(offset, Long.toString(l));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_2026638606 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2026638606.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2026638606;
        // ---------- Original Method ----------
        //insert0(offset, Long.toString(l));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.260 -0400", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "F2540EE301A3882146E6CA3DABFEB73C")
    public StringBuilder insert(int offset, float f) {
        addTaint(f);
        addTaint(offset);
        insert0(offset, Float.toString(f));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_360145162 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_360145162.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_360145162;
        // ---------- Original Method ----------
        //insert0(offset, Float.toString(f));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.261 -0400", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "08CFFBC3A044F863B54BC37429321486")
    public StringBuilder insert(int offset, double d) {
        addTaint(d);
        addTaint(offset);
        insert0(offset, Double.toString(d));
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_780661606 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_780661606.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_780661606;
        // ---------- Original Method ----------
        //insert0(offset, Double.toString(d));
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.261 -0400", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "AC0A414AA90E44FA04E79B234DEA02B4")
    public StringBuilder insert(int offset, Object obj) {
        addTaint(obj.getTaint());
        addTaint(offset);
        insert0(offset, obj == null ? "null" : obj.toString());
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1842575888 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1842575888.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1842575888;
        // ---------- Original Method ----------
        //insert0(offset, obj == null ? "null" : obj.toString());
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.262 -0400", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "53DEFE8095D6DF1815AB02CE776DC2CC")
    public StringBuilder insert(int offset, String str) {
        addTaint(str.getTaint());
        addTaint(offset);
        insert0(offset, str);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1654350563 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1654350563.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1654350563;
        // ---------- Original Method ----------
        //insert0(offset, str);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.262 -0400", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "002B18B4544C35AF8978DB4268149687")
    public StringBuilder insert(int offset, char[] ch) {
        addTaint(ch[0]);
        addTaint(offset);
        insert0(offset, ch);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_417457245 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_417457245.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_417457245;
        // ---------- Original Method ----------
        //insert0(offset, ch);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.262 -0400", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "C345B5FEFDE237BA5C1ECF04FBCF62D9")
    public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        addTaint(strLen);
        addTaint(strOffset);
        addTaint(str[0]);
        addTaint(offset);
        insert0(offset, str, strOffset, strLen);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1374546319 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1374546319.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1374546319;
        // ---------- Original Method ----------
        //insert0(offset, str, strOffset, strLen);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.263 -0400", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "CCE5AD345556361BF18EC5297A0C2421")
    public StringBuilder insert(int offset, CharSequence s) {
        addTaint(s.getTaint());
        addTaint(offset);
        insert0(offset, s == null ? "null" : s.toString());
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_158044866 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_158044866.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_158044866;
        // ---------- Original Method ----------
        //insert0(offset, s == null ? "null" : s.toString());
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.263 -0400", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "F84D6D0496DF9FE33050F3EF69453D3B")
    public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(s.getTaint());
        addTaint(offset);
        insert0(offset, s, start, end);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1869952936 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1869952936.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1869952936;
        // ---------- Original Method ----------
        //insert0(offset, s, start, end);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.263 -0400", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "A6BA9DA881AF06F215C302D9133A969B")
    public StringBuilder replace(int start, int end, String str) {
        addTaint(str.getTaint());
        addTaint(end);
        addTaint(start);
        replace0(start, end, str);
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_129905673 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_129905673.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_129905673;
        // ---------- Original Method ----------
        //replace0(start, end, str);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.264 -0400", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "E3A9269D9C9AF43FAD31D4B7EA8D5D2D")
    public StringBuilder reverse() {
        reverse0();
StringBuilder var72A74007B2BE62B849F475C7BDA4658B_1981388200 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1981388200.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1981388200;
        // ---------- Original Method ----------
        //reverse0();
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.264 -0400", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "5658F202BC4E7353172B0777ED4947F6")
    @Override
    public String toString() {
String varD8287C6801A4C167675BF9EBA9EC2C1B_1091183331 =         super.toString();
        varD8287C6801A4C167675BF9EBA9EC2C1B_1091183331.addTaint(taint);
        return varD8287C6801A4C167675BF9EBA9EC2C1B_1091183331;
        // ---------- Original Method ----------
        //return super.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.264 -0400", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "4DE1DD5BE1C3D644C6D668838FFFE727")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.264 -0400", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "0CF6F2B40A5C1B15330F2F0B53F306B6")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.265 -0400", hash_original_field = "F4B2354B73ADC1BA12DBC18B912FD456", hash_generated_field = "B39011C4BB0C9D7DCA32E1A2469D43EC")

    private static final long serialVersionUID = 4383685877147921099L;
}

