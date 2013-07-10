package org.apache.harmony.xml;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.xml.sax.Attributes;

abstract class ExpatAttributes implements Attributes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.603 -0400", hash_original_method = "D4DF1C9BC2FF91CA250847447EABC788", hash_generated_method = "D4DF1C9BC2FF91CA250847447EABC788")
    public ExpatAttributes ()
    {
        
    }


    public abstract int getLength();

    
    abstract int getParserPointer();

    
    public abstract int getPointer();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.605 -0400", hash_original_method = "57C7829583448928D2E62C8F0C20470B", hash_generated_method = "2BC441A39092CB575910EA84C36218E5")
    public String getURI(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_2135924183 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2028081247 = null; 
        {
            boolean var203EB8F451F243B3D8A451211B677024_469681777 = (index < 0 || index >= getLength());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2135924183 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2028081247 = getURI(getParserPointer(), getPointer(), index);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1685416500; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1685416500 = varB4EAC82CA7396A68D541C85D26508E83_2135924183;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1685416500 = varB4EAC82CA7396A68D541C85D26508E83_2028081247;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1685416500.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1685416500;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.606 -0400", hash_original_method = "0BE26DE1FC37C5F8E294AD66DA35C798", hash_generated_method = "C8482188BECBC5ABB96DF07E85211F98")
    public String getLocalName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_665525518 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_665525518 = (index < 0 || index >= getLength())
                ? null
                : getLocalName(getParserPointer(), getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_665525518.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_665525518;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.607 -0400", hash_original_method = "0E62167FF9D29B28633236898C212817", hash_generated_method = "8176A3C3B8DD7A93C0932D249E532A78")
    public String getQName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_457325168 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_457325168 = (index < 0 || index >= getLength())
                ? null
                : getQName(getParserPointer(), getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_457325168.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_457325168;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.608 -0400", hash_original_method = "906F8D6EEECA09A0EB9B2E9E5289B227", hash_generated_method = "92ACC305F55927A6ADC295010D0AC6A9")
    public String getType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1353383903 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1353383903 = (index < 0 || index >= getLength()) ? null : CDATA;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1353383903.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1353383903;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.609 -0400", hash_original_method = "3269AF76DE45F61A692FCC87354CAB72", hash_generated_method = "722BC93CE1635C9E12B4DFC45C539A67")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_136865702 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_136865702 = (index < 0 || index >= getLength())
                ? null
                : getValueByIndex(getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_136865702.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_136865702;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.609 -0400", hash_original_method = "C871C7E3F593C081235C517FE9A1E558", hash_generated_method = "6D200AC74621E2C7BEB038BE50312435")
    public int getIndex(String uri, String localName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } 
        int pointer = getPointer();
        int var475C57EF25B01A7CB049CE2D3EAD6E3C_1289822291 = (getIndex(pointer, uri, localName));
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224312810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_224312810;
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.609 -0400", hash_original_method = "980758BEF60D7C26C232D3CAD78E7835", hash_generated_method = "81B9A674AF13491DB06CAE92E5F73A2B")
    public int getIndex(String qName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } 
        int pointer = getPointer();
        int var96B5423CA7106BED454AAFC40E7EE7D4_1923363594 = (getIndexForQName(pointer, qName));
        addTaint(qName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641159114 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641159114;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.610 -0400", hash_original_method = "374AA6D4EA76C101E4A1F3245973703C", hash_generated_method = "B87D6B4DC2E442E10EC6AFACF1EBDC5F")
    public String getType(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_145047384 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_145047384 = getIndex(uri, localName) == -1 ? null : CDATA;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_145047384.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_145047384;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.610 -0400", hash_original_method = "845C2A9D603CFD94A25AD0FA47DD5097", hash_generated_method = "D4C800F02E2BBDE5014BF1942C136CB3")
    public String getType(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_310047646 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_310047646 = getIndex(qName) == -1 ? null : CDATA;
        addTaint(qName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_310047646.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_310047646;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.611 -0400", hash_original_method = "C565081F95CF8700320081FA5DB3FD15", hash_generated_method = "F80591B89758225A082133AFE60B1190")
    public String getValue(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_220592141 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_390111018 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } 
        int pointer = getPointer();
        {
            varB4EAC82CA7396A68D541C85D26508E83_220592141 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_390111018 = getValue(pointer, uri, localName);
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_579021567; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_579021567 = varB4EAC82CA7396A68D541C85D26508E83_220592141;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_579021567 = varB4EAC82CA7396A68D541C85D26508E83_390111018;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_579021567.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_579021567;
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.611 -0400", hash_original_method = "11A6BF5F6E86FB8B88CA0053A4EF72DA", hash_generated_method = "5C5D73B00B634A41B804D460860FAFDA")
    public String getValue(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1121980726 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_994077892 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("qName");
        } 
        int pointer = getPointer();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1121980726 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_994077892 = getValueForQName(pointer, qName);
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1691903902; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1691903902 = varB4EAC82CA7396A68D541C85D26508E83_1121980726;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1691903902 = varB4EAC82CA7396A68D541C85D26508E83_994077892;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1691903902.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1691903902;
        
        
            
        
        
        
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.613 -0400", hash_original_method = "9C2FF3514BF1A56FDD02B5A5C31F714B", hash_generated_method = "89627B71E85340B676FC2D21222B8514")
    protected void freeAttributes(int pointer) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.613 -0400", hash_original_field = "833C91B89EDFBBA3080C06DEF8403445", hash_generated_field = "F3F78ECDDA218F6E2CE999A3775F902F")

    private static final String CDATA = "CDATA";
}

