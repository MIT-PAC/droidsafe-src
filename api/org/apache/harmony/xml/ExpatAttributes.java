package org.apache.harmony.xml;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xml.sax.Attributes;

abstract class ExpatAttributes implements Attributes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.884 -0400", hash_original_method = "D4DF1C9BC2FF91CA250847447EABC788", hash_generated_method = "D4DF1C9BC2FF91CA250847447EABC788")
    public ExpatAttributes ()
    {
        
    }


    public abstract int getLength();

    
    abstract int getParserPointer();

    
    public abstract int getPointer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.885 -0400", hash_original_method = "57C7829583448928D2E62C8F0C20470B", hash_generated_method = "37DAF6F6C3F29E3A876682FAA21F2B11")
    public String getURI(int index) {
        addTaint(index);
    if(index < 0 || index >= getLength())        
        {
String var540C13E9E156B687226421B24F2DF178_468183508 =             null;
            var540C13E9E156B687226421B24F2DF178_468183508.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_468183508;
        } 
String varA2510C6EE73B8C0F038F54B09AE84839_1760359056 =         getURI(getParserPointer(), getPointer(), index);
        varA2510C6EE73B8C0F038F54B09AE84839_1760359056.addTaint(taint);
        return varA2510C6EE73B8C0F038F54B09AE84839_1760359056;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.885 -0400", hash_original_method = "0BE26DE1FC37C5F8E294AD66DA35C798", hash_generated_method = "1DE23036B67D15CC5D010033D1CA56AF")
    public String getLocalName(int index) {
        addTaint(index);
String varE9C78DB39C4181168A54285DD59C1B40_325244092 =         (index < 0 || index >= getLength())
                ? null
                : getLocalName(getParserPointer(), getPointer(), index);
        varE9C78DB39C4181168A54285DD59C1B40_325244092.addTaint(taint);
        return varE9C78DB39C4181168A54285DD59C1B40_325244092;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.885 -0400", hash_original_method = "0E62167FF9D29B28633236898C212817", hash_generated_method = "8F26EEDC9EFD3A8FB8FF92A76DE36304")
    public String getQName(int index) {
        addTaint(index);
String var83B75B73A459239093C3A115ADCAEC22_136350485 =         (index < 0 || index >= getLength())
                ? null
                : getQName(getParserPointer(), getPointer(), index);
        var83B75B73A459239093C3A115ADCAEC22_136350485.addTaint(taint);
        return var83B75B73A459239093C3A115ADCAEC22_136350485;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.885 -0400", hash_original_method = "906F8D6EEECA09A0EB9B2E9E5289B227", hash_generated_method = "69A4494FD4B3E8A202E4FB4BBC98C52D")
    public String getType(int index) {
        addTaint(index);
String var1C4F05A547C0F7E57CC38D5C9BDF43F4_661517899 =         (index < 0 || index >= getLength()) ? null : CDATA;
        var1C4F05A547C0F7E57CC38D5C9BDF43F4_661517899.addTaint(taint);
        return var1C4F05A547C0F7E57CC38D5C9BDF43F4_661517899;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.885 -0400", hash_original_method = "3269AF76DE45F61A692FCC87354CAB72", hash_generated_method = "26AF43F3660E2F72335CE06C9DD77270")
    public String getValue(int index) {
        addTaint(index);
String varB49A60064FD492A96C55111B103E1FA7_883475951 =         (index < 0 || index >= getLength())
                ? null
                : getValueByIndex(getPointer(), index);
        varB49A60064FD492A96C55111B103E1FA7_883475951.addTaint(taint);
        return varB49A60064FD492A96C55111B103E1FA7_883475951;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.886 -0400", hash_original_method = "C871C7E3F593C081235C517FE9A1E558", hash_generated_method = "EEF7F96E155E2E098335A3D8EEBC853C")
    public int getIndex(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_917171249 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_917171249.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_917171249;
        } 
    if(localName == null)        
        {
            NullPointerException var1D09B83246E8C66D38F27E4C02574BAB_1014446326 = new NullPointerException("local name");
            var1D09B83246E8C66D38F27E4C02574BAB_1014446326.addTaint(taint);
            throw var1D09B83246E8C66D38F27E4C02574BAB_1014446326;
        } 
        int pointer = getPointer();
    if(pointer == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1085141011 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219444847 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219444847;
        } 
        int varA011DC7869C6AAB8D9AF009A73BC3894_413313187 = (getIndex(pointer, uri, localName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689408628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689408628;
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.886 -0400", hash_original_method = "980758BEF60D7C26C232D3CAD78E7835", hash_generated_method = "2F4EC87DFC5F4AE679D404F32F3E4F3A")
    public int getIndex(String qName) {
        addTaint(qName.getTaint());
    if(qName == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_1114286030 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_1114286030.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_1114286030;
        } 
        int pointer = getPointer();
    if(pointer == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1288752643 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681005226 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681005226;
        } 
        int var576D4CB1A0F7EEA32ACD5591A10482F8_5565374 = (getIndexForQName(pointer, qName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142254736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142254736;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.886 -0400", hash_original_method = "374AA6D4EA76C101E4A1F3245973703C", hash_generated_method = "654FCB9CE0AE37034F9AAFD4FA926927")
    public String getType(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_1934752888 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_1934752888.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_1934752888;
        } 
    if(localName == null)        
        {
            NullPointerException var1D09B83246E8C66D38F27E4C02574BAB_614697318 = new NullPointerException("local name");
            var1D09B83246E8C66D38F27E4C02574BAB_614697318.addTaint(taint);
            throw var1D09B83246E8C66D38F27E4C02574BAB_614697318;
        } 
String varC04434C4E85414930EE6EADF3FF469A4_1488704840 =         getIndex(uri, localName) == -1 ? null : CDATA;
        varC04434C4E85414930EE6EADF3FF469A4_1488704840.addTaint(taint);
        return varC04434C4E85414930EE6EADF3FF469A4_1488704840;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.886 -0400", hash_original_method = "845C2A9D603CFD94A25AD0FA47DD5097", hash_generated_method = "FD95818ABB5734915E7BAC2909A380A7")
    public String getType(String qName) {
        addTaint(qName.getTaint());
String varA41D0BC36B3E3C4AE23E8E34671D0A46_1727284847 =         getIndex(qName) == -1 ? null : CDATA;
        varA41D0BC36B3E3C4AE23E8E34671D0A46_1727284847.addTaint(taint);
        return varA41D0BC36B3E3C4AE23E8E34671D0A46_1727284847;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.887 -0400", hash_original_method = "C565081F95CF8700320081FA5DB3FD15", hash_generated_method = "710262155FB54245C98B48CEDFD2F94D")
    public String getValue(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            NullPointerException var0A06F819995E53F46E9CCB946CCC07D9_317522953 = new NullPointerException("uri");
            var0A06F819995E53F46E9CCB946CCC07D9_317522953.addTaint(taint);
            throw var0A06F819995E53F46E9CCB946CCC07D9_317522953;
        } 
    if(localName == null)        
        {
            NullPointerException var1D09B83246E8C66D38F27E4C02574BAB_1011729118 = new NullPointerException("local name");
            var1D09B83246E8C66D38F27E4C02574BAB_1011729118.addTaint(taint);
            throw var1D09B83246E8C66D38F27E4C02574BAB_1011729118;
        } 
        int pointer = getPointer();
    if(pointer == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_1681066546 =             null;
            var540C13E9E156B687226421B24F2DF178_1681066546.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1681066546;
        } 
String varD4D21E93203A8FF776FFEF18BDCAB032_915026484 =         getValue(pointer, uri, localName);
        varD4D21E93203A8FF776FFEF18BDCAB032_915026484.addTaint(taint);
        return varD4D21E93203A8FF776FFEF18BDCAB032_915026484;
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.887 -0400", hash_original_method = "11A6BF5F6E86FB8B88CA0053A4EF72DA", hash_generated_method = "B799BE554C0F9C96135773DC46FC80D6")
    public String getValue(String qName) {
        addTaint(qName.getTaint());
    if(qName == null)        
        {
            NullPointerException var2ADFACD5558A5B11902C7CDBF1A967AA_1493732708 = new NullPointerException("qName");
            var2ADFACD5558A5B11902C7CDBF1A967AA_1493732708.addTaint(taint);
            throw var2ADFACD5558A5B11902C7CDBF1A967AA_1493732708;
        } 
        int pointer = getPointer();
    if(pointer == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_144103379 =             null;
            var540C13E9E156B687226421B24F2DF178_144103379.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_144103379;
        } 
String varE07B6E3B798DFD23138E54E703D445BD_1262533456 =         getValueForQName(pointer, qName);
        varE07B6E3B798DFD23138E54E703D445BD_1262533456.addTaint(taint);
        return varE07B6E3B798DFD23138E54E703D445BD_1262533456;
        
        
            
        
        
        
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.888 -0400", hash_original_method = "9C2FF3514BF1A56FDD02B5A5C31F714B", hash_generated_method = "89627B71E85340B676FC2D21222B8514")
    protected void freeAttributes(int pointer) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.888 -0400", hash_original_field = "833C91B89EDFBBA3080C06DEF8403445", hash_generated_field = "F3F78ECDDA218F6E2CE999A3775F902F")

    private static final String CDATA = "CDATA";
}

