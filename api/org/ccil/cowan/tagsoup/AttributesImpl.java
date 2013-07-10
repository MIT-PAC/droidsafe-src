package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.647 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.647 -0400", hash_original_field = "9483150F544BF05C50199D7A88E919A3", hash_generated_field = "FF698A9C75F799EB4FE98C16A723AC90")

    String data[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.648 -0400", hash_original_method = "6313F45FC494FF406CD3064C58B63747", hash_generated_method = "125C4A40CDC675B4E661BFA7A14FF3ED")
    public  AttributesImpl() {
        length = 0;
        data = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.648 -0400", hash_original_method = "8A0D874B41C17812C2FD00F4B363184D", hash_generated_method = "DECA55089DA1BBA83C0C88C650D479C0")
    public  AttributesImpl(Attributes atts) {
        setAttributes(atts);
        addTaint(atts.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.648 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "A73F8E3DE9749F4EB288101AD14E1F78")
    public int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382069224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382069224;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.649 -0400", hash_original_method = "1BF0AE5363A8618B6A71FCEE06881B7C", hash_generated_method = "CAF0DA35BAA9A1725A89D96006702032")
    public String getURI(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_902041253 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_720118935 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_902041253 = data[index*5];
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_720118935 = null;
        } 
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1099597975; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1099597975 = varB4EAC82CA7396A68D541C85D26508E83_902041253;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1099597975 = varB4EAC82CA7396A68D541C85D26508E83_720118935;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1099597975.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1099597975;
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.650 -0400", hash_original_method = "92B1686F7E458511CE45EC4DB3E3CE89", hash_generated_method = "CBE14B50EA79E2AB8A3287BD8B674B80")
    public String getLocalName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_165419056 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1104052856 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_165419056 = data[index*5+1];
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1104052856 = null;
        } 
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_2062861479; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2062861479 = varB4EAC82CA7396A68D541C85D26508E83_165419056;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2062861479 = varB4EAC82CA7396A68D541C85D26508E83_1104052856;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2062861479.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2062861479;
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.650 -0400", hash_original_method = "32BD7D7FFA2C46007E9D534F2070D779", hash_generated_method = "3FE254F4D6B4F06E4854F4D77B058511")
    public String getQName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_258466015 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1296550128 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_258466015 = data[index*5+2];
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1296550128 = null;
        } 
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1900689223; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1900689223 = varB4EAC82CA7396A68D541C85D26508E83_258466015;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1900689223 = varB4EAC82CA7396A68D541C85D26508E83_1296550128;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1900689223.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1900689223;
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.651 -0400", hash_original_method = "CD55E4A1C2CBE3FE53B5A622E57F028C", hash_generated_method = "E7AFACCBEF68936F8044779016E1E56B")
    public String getType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_24399822 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1357233652 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_24399822 = data[index*5+3];
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1357233652 = null;
        } 
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1100753567; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1100753567 = varB4EAC82CA7396A68D541C85D26508E83_24399822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1100753567 = varB4EAC82CA7396A68D541C85D26508E83_1357233652;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1100753567.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1100753567;
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.652 -0400", hash_original_method = "7BC4C2655702EDFE2361F9F97C33BDBD", hash_generated_method = "04B69B2FAF4DD09BB3F14E35AAD14262")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1696802891 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1079349297 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1696802891 = data[index*5+4];
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1079349297 = null;
        } 
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_2111790807; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2111790807 = varB4EAC82CA7396A68D541C85D26508E83_1696802891;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2111790807 = varB4EAC82CA7396A68D541C85D26508E83_1079349297;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2111790807.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2111790807;
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.653 -0400", hash_original_method = "090A4B083F61ECB7CB7169BD1EF033DF", hash_generated_method = "13220C71035D11130CDF1C6F18ECDFA2")
    public int getIndex(String uri, String localName) {
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_539727162 = (data[i].equals(uri) && data[i+1].equals(localName));
                } 
            } 
        } 
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358034242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_358034242;
        
        
        
	    
		
	    
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.653 -0400", hash_original_method = "EE3F059D65C038AB1F6CDD7302F8C95C", hash_generated_method = "52209054F3F621B6C68A6741AC2D1385")
    public int getIndex(String qName) {
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1731458103 = (data[i+2].equals(qName));
                } 
            } 
        } 
        addTaint(qName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988007502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988007502;
        
        
        
	    
		
	    
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.654 -0400", hash_original_method = "B693D2A452C34B3F63F46AE3F73B4CD6", hash_generated_method = "B2DD140BE5EFC73BB19BF4372C723BB4")
    public String getType(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_887999267 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2014441806 = null; 
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_549389692 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_887999267 = data[i+3];
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2014441806 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1841026889; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1841026889 = varB4EAC82CA7396A68D541C85D26508E83_887999267;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1841026889 = varB4EAC82CA7396A68D541C85D26508E83_2014441806;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1841026889.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1841026889;
        
        
        
	    
		
	    
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.654 -0400", hash_original_method = "EC27C5C1CA5357EEA1E16E770BA20FA2", hash_generated_method = "EBE9B36115E519BA3D58FC8A773E3028")
    public String getType(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1421542440 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_471698048 = null; 
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_106584021 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1421542440 = data[i+3];
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_471698048 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_848181370; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_848181370 = varB4EAC82CA7396A68D541C85D26508E83_1421542440;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_848181370 = varB4EAC82CA7396A68D541C85D26508E83_471698048;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_848181370.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_848181370;
        
        
        
	    
		
	    
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.655 -0400", hash_original_method = "522BBD1273EB28D82A0CFFAB0B22501D", hash_generated_method = "386CFC3ACA54263FBBF59AAFD05D62C4")
    public String getValue(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1304744143 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_551766217 = null; 
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_1007745382 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1304744143 = data[i+4];
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_551766217 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_44587005; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_44587005 = varB4EAC82CA7396A68D541C85D26508E83_1304744143;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_44587005 = varB4EAC82CA7396A68D541C85D26508E83_551766217;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_44587005.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_44587005;
        
        
        
	    
		
	    
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.656 -0400", hash_original_method = "4282B0A2744D6B6FFA141D6FBFC4111A", hash_generated_method = "329683CE6A9AEA87BD433C3E414A4804")
    public String getValue(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1135674517 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1388771382 = null; 
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_226611010 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1135674517 = data[i+4];
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1388771382 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1926932722; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1926932722 = varB4EAC82CA7396A68D541C85D26508E83_1135674517;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1926932722 = varB4EAC82CA7396A68D541C85D26508E83_1388771382;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1926932722.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1926932722;
        
        
        
	    
		
	    
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.656 -0400", hash_original_method = "03C848B66796F8DBDE7832677AAFA935", hash_generated_method = "92D92F557DB91C808602D1F195D7407C")
    public void clear() {
        {
            {
                int i = 0;
                data [i] = null;
            } 
        } 
        length = 0;
        
        
	    
		
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.657 -0400", hash_original_method = "AF86DF649668A0410832106AC7F2AE57", hash_generated_method = "383454FA757E91BF22D812C0DD7AABDF")
    public void setAttributes(Attributes atts) {
        clear();
        length = atts.getLength();
        {
            data = new String[length*5];
            {
                int i = 0;
                {
                    data[i*5] = atts.getURI(i);
                    data[i*5+1] = atts.getLocalName(i);
                    data[i*5+2] = atts.getQName(i);
                    data[i*5+3] = atts.getType(i);
                    data[i*5+4] = atts.getValue(i);
                } 
            } 
        } 
        
        
        
        
            
            
                
                
                
                
                
            
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.657 -0400", hash_original_method = "BEBCC50C9D4D6D2EEDEE155B4F15D792", hash_generated_method = "446F44EFE1522FA55D3A10F71A9677E9")
    public void addAttribute(String uri, String localName, String qName,
			      String type, String value) {
        ensureCapacity(length+1);
        data[length*5] = uri;
        data[length*5+1] = localName;
        data[length*5+2] = qName;
        data[length*5+3] = type;
        data[length*5+4] = value;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.658 -0400", hash_original_method = "FF1F65C71EB4DEEB1CAA0E424ECEBB91", hash_generated_method = "0C86CEEC437F23C72B5341F30A939074")
    public void setAttribute(int index, String uri, String localName,
			      String qName, String type, String value) {
        {
            data[index*5] = uri;
            data[index*5+1] = localName;
            data[index*5+2] = qName;
            data[index*5+3] = type;
            data[index*5+4] = value;
        } 
        {
            badIndex(index);
        } 
        
        
	    
	    
	    
	    
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.658 -0400", hash_original_method = "CCD3032C3525D921C0B3FD28370332A3", hash_generated_method = "30657D28074FA7318F5DCEEB81AE8346")
    public void removeAttribute(int index) {
        {
            {
                System.arraycopy(data, (index+1)*5, data, index*5,
				 (length-index-1)*5);
            } 
            index = (length - 1) * 5;
            data [index++] = null;
            data [index++] = null;
            data [index++] = null;
            data [index++] = null;
            data [index] = null;
        } 
        {
            badIndex(index);
        } 
        
        
	    
		
				 
	    
	    
	    
	    
	    
	    
	    
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.659 -0400", hash_original_method = "50F4EE4994BD814C254566A0C91A3159", hash_generated_method = "189634784CC3D87714F94F95CA9AE40B")
    public void setURI(int index, String uri) {
        {
            data[index*5] = uri;
        } 
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.659 -0400", hash_original_method = "752FFE3C27BC55D6B126D5816B29C527", hash_generated_method = "EE4EC8CE033CC258B23E0FB3EE329175")
    public void setLocalName(int index, String localName) {
        {
            data[index*5+1] = localName;
        } 
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.659 -0400", hash_original_method = "092FB5C36230E9F885C6748AEF4243E2", hash_generated_method = "76CA5E4B31889C44B734382CBC5C6E51")
    public void setQName(int index, String qName) {
        {
            data[index*5+2] = qName;
        } 
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.660 -0400", hash_original_method = "C2C16165C0A88812FD10B2DCA3F19338", hash_generated_method = "65D3BD8341FEBE938E1850C8859B2D71")
    public void setType(int index, String type) {
        {
            data[index*5+3] = type;
        } 
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.660 -0400", hash_original_method = "384311AE4C6374A489D3CC7FA620C40E", hash_generated_method = "7F3196238D00EEB51E7CF68BA42F8A65")
    public void setValue(int index, String value) {
        {
            data[index*5+4] = value;
        } 
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.661 -0400", hash_original_method = "CB574EAE8A001C113E60067C9D40C52E", hash_generated_method = "7CB08C395D683F782E241B21632C5B7B")
    private void ensureCapacity(int n) {
        int max;
        {
            max = 25;
        } 
        {
            max = data.length;
        } 
        {
            max *= 2;
        } 
        String newData[] = new String[max];
        {
            System.arraycopy(data, 0, newData, 0, length*5);
        } 
        data = newData;
        addTaint(n);
        
        
            
        
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.661 -0400", hash_original_method = "5A39796CA8340A67B1FFF4D32268D0FF", hash_generated_method = "0882442A793C9911842010C280906F43")
    private void badIndex(int index) throws ArrayIndexOutOfBoundsException {
        String msg = "Attempt to modify attribute at illegal index: " + index;
        if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(msg);
        addTaint(index);
        
        
	    
        
    }

    
}

