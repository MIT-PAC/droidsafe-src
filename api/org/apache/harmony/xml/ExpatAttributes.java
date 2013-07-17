package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xml.sax.Attributes;

abstract class ExpatAttributes implements Attributes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.997 -0400", hash_original_method = "D4DF1C9BC2FF91CA250847447EABC788", hash_generated_method = "D4DF1C9BC2FF91CA250847447EABC788")
    public ExpatAttributes ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract int getLength();

    
    @DSModeled(DSC.SAFE)
    abstract int getParserPointer();

    
    @DSModeled(DSC.SAFE)
    public abstract int getPointer();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.998 -0400", hash_original_method = "57C7829583448928D2E62C8F0C20470B", hash_generated_method = "DAA060BF8E5828DCE540FBA8E2C7D5E3")
    public String getURI(int index) {
        addTaint(index);
        if(index < 0 || index >= getLength())        
        {
String var540C13E9E156B687226421B24F2DF178_917495641 =             null;
            var540C13E9E156B687226421B24F2DF178_917495641.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_917495641;
        } //End block
String varA2510C6EE73B8C0F038F54B09AE84839_407555177 =         getURI(getParserPointer(), getPointer(), index);
        varA2510C6EE73B8C0F038F54B09AE84839_407555177.addTaint(taint);
        return varA2510C6EE73B8C0F038F54B09AE84839_407555177;
        // ---------- Original Method ----------
        //if (index < 0 || index >= getLength()) {
            //return null;
        //}
        //return getURI(getParserPointer(), getPointer(), index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.999 -0400", hash_original_method = "0BE26DE1FC37C5F8E294AD66DA35C798", hash_generated_method = "EB513CBFCF108170350480F2C3CDF516")
    public String getLocalName(int index) {
        addTaint(index);
String varE9C78DB39C4181168A54285DD59C1B40_984839912 =         (index < 0 || index >= getLength())
                ? null
                : getLocalName(getParserPointer(), getPointer(), index);
        varE9C78DB39C4181168A54285DD59C1B40_984839912.addTaint(taint);
        return varE9C78DB39C4181168A54285DD59C1B40_984839912;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getLocalName(getParserPointer(), getPointer(), index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.999 -0400", hash_original_method = "0E62167FF9D29B28633236898C212817", hash_generated_method = "20BD49D71374103DABF3FD7748EF5F2E")
    public String getQName(int index) {
        addTaint(index);
String var83B75B73A459239093C3A115ADCAEC22_1752735922 =         (index < 0 || index >= getLength())
                ? null
                : getQName(getParserPointer(), getPointer(), index);
        var83B75B73A459239093C3A115ADCAEC22_1752735922.addTaint(taint);
        return var83B75B73A459239093C3A115ADCAEC22_1752735922;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getQName(getParserPointer(), getPointer(), index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.000 -0400", hash_original_method = "906F8D6EEECA09A0EB9B2E9E5289B227", hash_generated_method = "CB220B048C6D88929E68CA3136A870E9")
    public String getType(int index) {
        addTaint(index);
String var1C4F05A547C0F7E57CC38D5C9BDF43F4_171151068 =         (index < 0 || index >= getLength()) ? null : CDATA;
        var1C4F05A547C0F7E57CC38D5C9BDF43F4_171151068.addTaint(taint);
        return var1C4F05A547C0F7E57CC38D5C9BDF43F4_171151068;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength()) ? null : CDATA;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.000 -0400", hash_original_method = "3269AF76DE45F61A692FCC87354CAB72", hash_generated_method = "A7635DE43CEEBBC2AEC92E8F5DF8F63A")
    public String getValue(int index) {
        addTaint(index);
String varB49A60064FD492A96C55111B103E1FA7_1219411916 =         (index < 0 || index >= getLength())
                ? null
                : getValueByIndex(getPointer(), index);
        varB49A60064FD492A96C55111B103E1FA7_1219411916.addTaint(taint);
        return varB49A60064FD492A96C55111B103E1FA7_1219411916;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getValueByIndex(getPointer(), index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.001 -0400", hash_original_method = "C871C7E3F593C081235C517FE9A1E558", hash_generated_method = "9961C71D3E34F0F3C4527F642971A4EF")
    public int getIndex(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_1647488946 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_1647488946.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_1647488946;
        } //End block
        if(localName == null)        
        {
            NullPointerException var1D09B83246E8C66D38F27E4C02574BAB_1947461366 = new NullPointerException("local name");
            var1D09B83246E8C66D38F27E4C02574BAB_1947461366.addTaint(taint);
            throw var1D09B83246E8C66D38F27E4C02574BAB_1947461366;
        } //End block
        int pointer = getPointer();
        if(pointer == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_808105931 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64720872 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64720872;
        } //End block
        int varA011DC7869C6AAB8D9AF009A73BC3894_210025709 = (getIndex(pointer, uri, localName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_97830208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_97830208;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return -1;
        //}
        //return getIndex(pointer, uri, localName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.002 -0400", hash_original_method = "980758BEF60D7C26C232D3CAD78E7835", hash_generated_method = "1C0D8FC78420ABA8D83697DF8ED7C3AF")
    public int getIndex(String qName) {
        addTaint(qName.getTaint());
        if(qName == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_2068915564 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_2068915564.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_2068915564;
        } //End block
        int pointer = getPointer();
        if(pointer == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_628653745 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525058670 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525058670;
        } //End block
        int var576D4CB1A0F7EEA32ACD5591A10482F8_378575029 = (getIndexForQName(pointer, qName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437590324 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437590324;
        // ---------- Original Method ----------
        //if (qName == null) {
            //throw new NullPointerException("uri");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return -1;
        //}
        //return getIndexForQName(pointer, qName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.003 -0400", hash_original_method = "374AA6D4EA76C101E4A1F3245973703C", hash_generated_method = "E4EF96C2CD911D332C0863AC8C88151D")
    public String getType(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_1769657440 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_1769657440.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_1769657440;
        } //End block
        if(localName == null)        
        {
            NullPointerException var1D09B83246E8C66D38F27E4C02574BAB_312529348 = new NullPointerException("local name");
            var1D09B83246E8C66D38F27E4C02574BAB_312529348.addTaint(taint);
            throw var1D09B83246E8C66D38F27E4C02574BAB_312529348;
        } //End block
String varC04434C4E85414930EE6EADF3FF469A4_416617742 =         getIndex(uri, localName) == -1 ? null : CDATA;
        varC04434C4E85414930EE6EADF3FF469A4_416617742.addTaint(taint);
        return varC04434C4E85414930EE6EADF3FF469A4_416617742;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //return getIndex(uri, localName) == -1 ? null : CDATA;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.003 -0400", hash_original_method = "845C2A9D603CFD94A25AD0FA47DD5097", hash_generated_method = "287F9644D24A8C6A870AD019741D25D3")
    public String getType(String qName) {
        addTaint(qName.getTaint());
String varA41D0BC36B3E3C4AE23E8E34671D0A46_822459126 =         getIndex(qName) == -1 ? null : CDATA;
        varA41D0BC36B3E3C4AE23E8E34671D0A46_822459126.addTaint(taint);
        return varA41D0BC36B3E3C4AE23E8E34671D0A46_822459126;
        // ---------- Original Method ----------
        //return getIndex(qName) == -1 ? null : CDATA;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.004 -0400", hash_original_method = "C565081F95CF8700320081FA5DB3FD15", hash_generated_method = "F5BE7E591D494297D594520725087A49")
    public String getValue(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_777875548 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_777875548.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_777875548;
        } //End block
        if(localName == null)        
        {
            NullPointerException var1D09B83246E8C66D38F27E4C02574BAB_256948155 = new NullPointerException("local name");
            var1D09B83246E8C66D38F27E4C02574BAB_256948155.addTaint(taint);
            throw var1D09B83246E8C66D38F27E4C02574BAB_256948155;
        } //End block
        int pointer = getPointer();
        if(pointer == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_833772812 =             null;
            var540C13E9E156B687226421B24F2DF178_833772812.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_833772812;
        } //End block
String varD4D21E93203A8FF776FFEF18BDCAB032_1479601618 =         getValue(pointer, uri, localName);
        varD4D21E93203A8FF776FFEF18BDCAB032_1479601618.addTaint(taint);
        return varD4D21E93203A8FF776FFEF18BDCAB032_1479601618;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return null;
        //}
        //return getValue(pointer, uri, localName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.004 -0400", hash_original_method = "11A6BF5F6E86FB8B88CA0053A4EF72DA", hash_generated_method = "9EAF27C02329977E94A02D38401F0A2F")
    public String getValue(String qName) {
        addTaint(qName.getTaint());
        if(qName == null)        
        {
            NullPointerException var2ADFACD5558A5B11902C7CDBF1A967AA_275051397 = new NullPointerException("qName");
            var2ADFACD5558A5B11902C7CDBF1A967AA_275051397.addTaint(taint);
            throw var2ADFACD5558A5B11902C7CDBF1A967AA_275051397;
        } //End block
        int pointer = getPointer();
        if(pointer == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_645484074 =             null;
            var540C13E9E156B687226421B24F2DF178_645484074.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_645484074;
        } //End block
String varE07B6E3B798DFD23138E54E703D445BD_1748156114 =         getValueForQName(pointer, qName);
        varE07B6E3B798DFD23138E54E703D445BD_1748156114.addTaint(taint);
        return varE07B6E3B798DFD23138E54E703D445BD_1748156114;
        // ---------- Original Method ----------
        //if (qName == null) {
            //throw new NullPointerException("qName");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return null;
        //}
        //return getValueForQName(pointer, qName);
    }

    
    @DSModeled(DSC.SAFE)
    private static String getURI(int pointer, int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(pointer);
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getLocalName(int pointer, int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(pointer);
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getQName(int pointer, int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(pointer);
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getValueByIndex(int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static int getIndex(int attributePointer, String uri, String localName) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003081945 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003081945;
    }

    
    @DSModeled(DSC.SAFE)
    private static int getIndexForQName(int attributePointer, String qName) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824428906 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824428906;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getValue(int attributePointer, String uri, String localName) {
    	String ret = new String();
    	ret.addTaint(attributePointer);
    	ret.addTaint(uri.taint);
    	ret.addTaint(localName.taint);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String getValueForQName(int attributePointer, String qName) {
    	String ret = new String();
    	ret.addTaint(attributePointer);
    	ret.addTaint(qName.taint);
    	return ret;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.008 -0400", hash_original_method = "9C2FF3514BF1A56FDD02B5A5C31F714B", hash_generated_method = "89627B71E85340B676FC2D21222B8514")
    protected void freeAttributes(int pointer) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.008 -0400", hash_original_field = "833C91B89EDFBBA3080C06DEF8403445", hash_generated_field = "F3F78ECDDA218F6E2CE999A3775F902F")

    private static final String CDATA = "CDATA";
}

