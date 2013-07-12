package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.867 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.867 -0400", hash_original_field = "9483150F544BF05C50199D7A88E919A3", hash_generated_field = "FF698A9C75F799EB4FE98C16A723AC90")

    String data[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.867 -0400", hash_original_method = "6313F45FC494FF406CD3064C58B63747", hash_generated_method = "125C4A40CDC675B4E661BFA7A14FF3ED")
    public  AttributesImpl() {
        length = 0;
        data = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.868 -0400", hash_original_method = "8A0D874B41C17812C2FD00F4B363184D", hash_generated_method = "3B791DF39E85C515832471A4650048CF")
    public  AttributesImpl(Attributes atts) {
        addTaint(atts.getTaint());
        setAttributes(atts);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.868 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "37AB901E7C300CD20091A247ABC02151")
    public int getLength() {
        int var2FA47F7C65FEC19CC163B195725E3844_1064740720 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564412881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564412881;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.868 -0400", hash_original_method = "1BF0AE5363A8618B6A71FCEE06881B7C", hash_generated_method = "5CBE8E7C7C3BEEEC3406D5EC4D3EC346")
    public String getURI(int index) {
        addTaint(index);
    if(index >= 0 && index < length)        
        {
String var95434D24A9F9C0BB221335CC7B21DB58_518895977 =             data[index*5];
            var95434D24A9F9C0BB221335CC7B21DB58_518895977.addTaint(taint);
            return var95434D24A9F9C0BB221335CC7B21DB58_518895977;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_1244426275 =             null;
            var540C13E9E156B687226421B24F2DF178_1244426275.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1244426275;
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.869 -0400", hash_original_method = "92B1686F7E458511CE45EC4DB3E3CE89", hash_generated_method = "EEE342E44B4D97294CAD8C707B9A5440")
    public String getLocalName(int index) {
        addTaint(index);
    if(index >= 0 && index < length)        
        {
String varF55F81CCFE212CE75C71B6A4F79FDCBE_396397237 =             data[index*5+1];
            varF55F81CCFE212CE75C71B6A4F79FDCBE_396397237.addTaint(taint);
            return varF55F81CCFE212CE75C71B6A4F79FDCBE_396397237;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_1438692826 =             null;
            var540C13E9E156B687226421B24F2DF178_1438692826.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1438692826;
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.869 -0400", hash_original_method = "32BD7D7FFA2C46007E9D534F2070D779", hash_generated_method = "6B61F76CC62F49988EE44DA1AEC68FBF")
    public String getQName(int index) {
        addTaint(index);
    if(index >= 0 && index < length)        
        {
String var4CDEDB5A63059951DB3E8DDA3B424519_17053116 =             data[index*5+2];
            var4CDEDB5A63059951DB3E8DDA3B424519_17053116.addTaint(taint);
            return var4CDEDB5A63059951DB3E8DDA3B424519_17053116;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_749929187 =             null;
            var540C13E9E156B687226421B24F2DF178_749929187.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_749929187;
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.869 -0400", hash_original_method = "CD55E4A1C2CBE3FE53B5A622E57F028C", hash_generated_method = "463BF2B251D9781709232ADD5CF78798")
    public String getType(int index) {
        addTaint(index);
    if(index >= 0 && index < length)        
        {
String varBFB9612AF994A88438B71FEDF20B7958_2056661200 =             data[index*5+3];
            varBFB9612AF994A88438B71FEDF20B7958_2056661200.addTaint(taint);
            return varBFB9612AF994A88438B71FEDF20B7958_2056661200;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_149206027 =             null;
            var540C13E9E156B687226421B24F2DF178_149206027.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_149206027;
        } 
        
        
	    
	
	    
	
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.870 -0400", hash_original_method = "7BC4C2655702EDFE2361F9F97C33BDBD", hash_generated_method = "D9EB38460CB8A38DA2ADB467AC5A149F")
    public String getValue(int index) {
        addTaint(index);
    if(index >= 0 && index < length)        
        {
String var8077B4B05F2B5CDB78D827F9A6A6B085_1654610760 =             data[index*5+4];
            var8077B4B05F2B5CDB78D827F9A6A6B085_1654610760.addTaint(taint);
            return var8077B4B05F2B5CDB78D827F9A6A6B085_1654610760;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_1755037700 =             null;
            var540C13E9E156B687226421B24F2DF178_1755037700.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1755037700;
        } 
        
        
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.870 -0400", hash_original_method = "090A4B083F61ECB7CB7169BD1EF033DF", hash_generated_method = "4583CE12C22323DFCFB0F8BF8C9E59AA")
    public int getIndex(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        int max = length * 5;
for(int i = 0;i < max;i += 5)
        {
    if(data[i].equals(uri) && data[i+1].equals(localName))            
            {
                int var4ACA45CA7574117645E1AA3B47DBA994_389826310 = (i / 5);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348122523 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348122523;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1011437072 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338264547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338264547;
        
        
        
	    
		
	    
	
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.871 -0400", hash_original_method = "EE3F059D65C038AB1F6CDD7302F8C95C", hash_generated_method = "32F14E4925F683A6FCE081668757D9CB")
    public int getIndex(String qName) {
        addTaint(qName.getTaint());
        int max = length * 5;
for(int i = 0;i < max;i += 5)
        {
    if(data[i+2].equals(qName))            
            {
                int var4ACA45CA7574117645E1AA3B47DBA994_362762833 = (i / 5);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129860474 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129860474;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_187254946 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58126175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58126175;
        
        
        
	    
		
	    
	
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.872 -0400", hash_original_method = "B693D2A452C34B3F63F46AE3F73B4CD6", hash_generated_method = "099DE27D20EA655503A04407CF4D33A5")
    public String getType(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        int max = length * 5;
for(int i = 0;i < max;i += 5)
        {
    if(data[i].equals(uri) && data[i+1].equals(localName))            
            {
String varCB7F46453B963C1F8700DDE6A3A7C24F_811954665 =                 data[i+3];
                varCB7F46453B963C1F8700DDE6A3A7C24F_811954665.addTaint(taint);
                return varCB7F46453B963C1F8700DDE6A3A7C24F_811954665;
            } 
        } 
String var540C13E9E156B687226421B24F2DF178_788619438 =         null;
        var540C13E9E156B687226421B24F2DF178_788619438.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_788619438;
        
        
        
	    
		
	    
	
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.872 -0400", hash_original_method = "EC27C5C1CA5357EEA1E16E770BA20FA2", hash_generated_method = "2F8962EFD5F92428A2932FBFE080463E")
    public String getType(String qName) {
        addTaint(qName.getTaint());
        int max = length * 5;
for(int i = 0;i < max;i += 5)
        {
    if(data[i+2].equals(qName))            
            {
String varCB7F46453B963C1F8700DDE6A3A7C24F_613844331 =                 data[i+3];
                varCB7F46453B963C1F8700DDE6A3A7C24F_613844331.addTaint(taint);
                return varCB7F46453B963C1F8700DDE6A3A7C24F_613844331;
            } 
        } 
String var540C13E9E156B687226421B24F2DF178_997602658 =         null;
        var540C13E9E156B687226421B24F2DF178_997602658.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_997602658;
        
        
        
	    
		
	    
	
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.873 -0400", hash_original_method = "522BBD1273EB28D82A0CFFAB0B22501D", hash_generated_method = "632EE71AC94CF411D853DFB02FAA6B87")
    public String getValue(String uri, String localName) {
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        int max = length * 5;
for(int i = 0;i < max;i += 5)
        {
    if(data[i].equals(uri) && data[i+1].equals(localName))            
            {
String var0C1EB3387F710BB8CDFBF236935915BE_1948136175 =                 data[i+4];
                var0C1EB3387F710BB8CDFBF236935915BE_1948136175.addTaint(taint);
                return var0C1EB3387F710BB8CDFBF236935915BE_1948136175;
            } 
        } 
String var540C13E9E156B687226421B24F2DF178_584932479 =         null;
        var540C13E9E156B687226421B24F2DF178_584932479.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_584932479;
        
        
        
	    
		
	    
	
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.873 -0400", hash_original_method = "4282B0A2744D6B6FFA141D6FBFC4111A", hash_generated_method = "E49151AA7A17D59428B093A1C3EED264")
    public String getValue(String qName) {
        addTaint(qName.getTaint());
        int max = length * 5;
for(int i = 0;i < max;i += 5)
        {
    if(data[i+2].equals(qName))            
            {
String var0C1EB3387F710BB8CDFBF236935915BE_1436667648 =                 data[i+4];
                var0C1EB3387F710BB8CDFBF236935915BE_1436667648.addTaint(taint);
                return var0C1EB3387F710BB8CDFBF236935915BE_1436667648;
            } 
        } 
String var540C13E9E156B687226421B24F2DF178_1422569897 =         null;
        var540C13E9E156B687226421B24F2DF178_1422569897.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1422569897;
        
        
        
	    
		
	    
	
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.874 -0400", hash_original_method = "03C848B66796F8DBDE7832677AAFA935", hash_generated_method = "6A5B90232418EF65C55D8A5A53AB2614")
    public void clear() {
    if(data != null)        
        {
for(int i = 0;i < (length * 5);i++)
            data [i] = null;
        } 
        length = 0;
        
        
	    
		
	
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.876 -0400", hash_original_method = "AF86DF649668A0410832106AC7F2AE57", hash_generated_method = "2A31CA141C504790CD26B2945B4DC368")
    public void setAttributes(Attributes atts) {
        clear();
        length = atts.getLength();
    if(length > 0)        
        {
            data = new String[length*5];
for(int i = 0;i < length;i++)
            {
                data[i*5] = atts.getURI(i);
                data[i*5+1] = atts.getLocalName(i);
                data[i*5+2] = atts.getQName(i);
                data[i*5+3] = atts.getType(i);
                data[i*5+4] = atts.getValue(i);
            } 
        } 
        
        
        
        
            
            
                
                
                
                
                
            
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.878 -0400", hash_original_method = "BEBCC50C9D4D6D2EEDEE155B4F15D792", hash_generated_method = "AE74B3228B8DA121737B85D26643426A")
    public void addAttribute(String uri, String localName, String qName,
			      String type, String value) {
        ensureCapacity(length+1);
        data[length*5] = uri;
        data[length*5+1] = localName;
        data[length*5+2] = qName;
        data[length*5+3] = type;
        data[length*5+4] = value;
        length++;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.879 -0400", hash_original_method = "FF1F65C71EB4DEEB1CAA0E424ECEBB91", hash_generated_method = "9F0E7A8B6591843EFE3205044075C074")
    public void setAttribute(int index, String uri, String localName,
			      String qName, String type, String value) {
    if(index >= 0 && index < length)        
        {
            data[index*5] = uri;
            data[index*5+1] = localName;
            data[index*5+2] = qName;
            data[index*5+3] = type;
            data[index*5+4] = value;
        } 
        else
        {
            badIndex(index);
        } 
        
        
	    
	    
	    
	    
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.880 -0400", hash_original_method = "CCD3032C3525D921C0B3FD28370332A3", hash_generated_method = "6921100D2ACBA555F1A60AA2F674868F")
    public void removeAttribute(int index) {
    if(index >= 0 && index < length)        
        {
    if(index < length - 1)            
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
            length--;
        } 
        else
        {
            badIndex(index);
        } 
        
        
	    
		
				 
	    
	    
	    
	    
	    
	    
	    
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.880 -0400", hash_original_method = "50F4EE4994BD814C254566A0C91A3159", hash_generated_method = "B18B1ADE72E2765C0AFF99773AB86E1F")
    public void setURI(int index, String uri) {
    if(index >= 0 && index < length)        
        {
            data[index*5] = uri;
        } 
        else
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.880 -0400", hash_original_method = "752FFE3C27BC55D6B126D5816B29C527", hash_generated_method = "0A86A21B8B87F0FA69356867B79F50FA")
    public void setLocalName(int index, String localName) {
    if(index >= 0 && index < length)        
        {
            data[index*5+1] = localName;
        } 
        else
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.880 -0400", hash_original_method = "092FB5C36230E9F885C6748AEF4243E2", hash_generated_method = "9A73B5AF4BDD09305CBDC4DB76CF88C9")
    public void setQName(int index, String qName) {
    if(index >= 0 && index < length)        
        {
            data[index*5+2] = qName;
        } 
        else
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.880 -0400", hash_original_method = "C2C16165C0A88812FD10B2DCA3F19338", hash_generated_method = "7AF03ABDFCFDD4C20B5134CCAEABC10B")
    public void setType(int index, String type) {
    if(index >= 0 && index < length)        
        {
            data[index*5+3] = type;
        } 
        else
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.881 -0400", hash_original_method = "384311AE4C6374A489D3CC7FA620C40E", hash_generated_method = "FB15AF7F6708C30B56D4E6D73CD0AB29")
    public void setValue(int index, String value) {
    if(index >= 0 && index < length)        
        {
            data[index*5+4] = value;
        } 
        else
        {
            badIndex(index);
        } 
        
        
	    
	
	    
	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.881 -0400", hash_original_method = "CB574EAE8A001C113E60067C9D40C52E", hash_generated_method = "B4F0205D74EE5BE54E3DB5F901BA23FB")
    private void ensureCapacity(int n) {
        addTaint(n);
    if(n <= 0)        
        {
            return;
        } 
        int max;
    if(data == null || data.length == 0)        
        {
            max = 25;
        } 
        else
    if(data.length >= n * 5)        
        {
            return;
        } 
        else
        {
            max = data.length;
        } 
        while
(max < n * 5)        
        {
            max *= 2;
        } 
        String newData[] = new String[max];
    if(length > 0)        
        {
            System.arraycopy(data, 0, newData, 0, length*5);
        } 
        data = newData;
        
        
            
        
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.881 -0400", hash_original_method = "5A39796CA8340A67B1FFF4D32268D0FF", hash_generated_method = "DEE14E654C79FA27852A334D948DB357")
    private void badIndex(int index) throws ArrayIndexOutOfBoundsException {
        addTaint(index);
        String msg = "Attempt to modify attribute at illegal index: " + index;
        ArrayIndexOutOfBoundsException var06403C82FB97763551DB036E1D4BB483_1646523158 = new ArrayIndexOutOfBoundsException(msg);
        var06403C82FB97763551DB036E1D4BB483_1646523158.addTaint(taint);
        throw var06403C82FB97763551DB036E1D4BB483_1646523158;
        
        
	    
        
    }

    
}

