package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.ext.LexicalHandler;

public class PYXWriter implements ScanHandler, ContentHandler, LexicalHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.197 -0400", hash_original_field = "29DE0C7BE9C5B26DD178E31FE931944B", hash_generated_field = "49F3A48A6073C357DEA9F2D054F0CF5A")

    private PrintWriter theWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.198 -0400", hash_original_field = "E6CBE9BA0F775DDC964E131A97543586", hash_generated_field = "1D790F77E1C6AE59D6044130824E23AE")

    private String attrName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.198 -0400", hash_original_method = "B358C277B5E2AD8935F1F06BA02E5093", hash_generated_method = "7E06F9A3DD0D146797AF22B3E80D4F4B")
    public  PYXWriter(Writer w) {
    if(w instanceof PrintWriter)        
        {
            theWriter = (PrintWriter)w;
        } 
        else
        {
            theWriter = new PrintWriter(w);
        } 
        
        
			
			
		
			
			
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.199 -0400", hash_original_method = "387AEB9DCE887E98A76AE2F20CD71AE2", hash_generated_method = "5466ADD270A11872DC76669A9AE00475")
    public void adup(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.println(attrName);
        attrName = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.199 -0400", hash_original_method = "7D20D176BBEC71DA76C0647D5C25D5A3", hash_generated_method = "EC053AB6B03C84BABD4ED2C8768D9B86")
    public void aname(char[] buff, int offset, int length) throws SAXException {
        theWriter.print('A');
        theWriter.write(buff, offset, length);
        theWriter.print(' ');
        attrName = new String(buff, offset, length);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.200 -0400", hash_original_method = "0B592E26491ABBF6D6340D0C31CDF40A", hash_generated_method = "B2A5D6759AFE8D0F9508A2DF497760B1")
    public void aval(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.write(buff, offset, length);
        theWriter.println();
        attrName = null;
        
        
        
        
    }

    @DSOverride
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.200 -0400", hash_original_method = "1B347B27BFF7BB03486A9C3953014010", hash_generated_method = "A69F4BB3139A30AE29048B59041500BE")
    public void cmnt(char [] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.201 -0400", hash_original_method = "0C74769D0F9D1592330B85E57E53C137", hash_generated_method = "7753065BB5F27F19B69F0E29878E7078")
    public void entity(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.201 -0400", hash_original_method = "3C08B6E043A6E028BC79049543201CA8", hash_generated_method = "5A3F0BAA7BC0299F2FCDC24FD16F056C")
    public int getEntity() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2104727559 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078794460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078794460;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.201 -0400", hash_original_method = "D330469217CBCDF6CFC5B6F4299F7DED", hash_generated_method = "88A48D9CE88B81DA05A6C4CB83BA6CBA")
    public void eof(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.close();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.202 -0400", hash_original_method = "26BADE83A21B645404502BDE9A94D5D0", hash_generated_method = "3C55794E7DA952F0E1A7F2DF347459C8")
    public void etag(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.print(')');
        theWriter.write(buff, offset, length);
        theWriter.println();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.203 -0400", hash_original_method = "D7373B13D97F6239D6FE9A75A6C3C4CD", hash_generated_method = "E2E2E111C23CB49772DE5EDEF28E294D")
    public void decl(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.204 -0400", hash_original_method = "F17CC0C0B50085C85B2E9F440AE2C746", hash_generated_method = "61566874696B9573264CAD0D075D6C9A")
    public void gi(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.print('(');
        theWriter.write(buff, offset, length);
        theWriter.println();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.205 -0400", hash_original_method = "A1521B964CA14C9F176B788365114A3A", hash_generated_method = "1EB8129B6CA88172B1C64D2E93BDD09B")
    public void cdsect(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        pcdata(buff, offset, length);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.206 -0400", hash_original_method = "EA665DB78182CC462806E2E30B0F15A4", hash_generated_method = "674C4C19ADB558AB0EB530C436B1E83A")
    public void pcdata(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(length == 0)        
        return;
        boolean inProgress = false;
        length += offset;
for(int i = offset;i < length;i++)
        {
    if(buff[i] == '\n')            
            {
    if(inProgress)                
                {
                    theWriter.println();
                } 
                theWriter.println("-\\n");
                inProgress = false;
            } 
            else
            {
    if(!inProgress)                
                {
                    theWriter.print('-');
                } 
switch(buff[i]){
                case '\t':
                theWriter.print("\\t");
                break;
                case '\\':
                theWriter.print("\\\\");
                break;
                default:
                theWriter.print(buff[i]);
}                inProgress = true;
            } 
        } 
    if(inProgress)        
        {
            theWriter.println();
        } 
        
        
        
        
        
			
				
					
					
				
				
				
			
				
					
					
				
				
					
					
				
					
					
				
					
					
				
				
			
        
			
			
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.207 -0400", hash_original_method = "434533230F3CD22E7AA0C553CAF97C2F", hash_generated_method = "8B165F3927FC63F8BD904E3F86A63FD5")
    public void pitarget(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.print('?');
        theWriter.write(buff, offset, length);
        theWriter.write(' ');
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.207 -0400", hash_original_method = "ED46B5C6DF2EC4C94179D535403EEAEA", hash_generated_method = "768E0BCDE205A1F1632EB544EACF56AC")
    public void pi(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.write(buff, offset, length);
        theWriter.println();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.207 -0400", hash_original_method = "96E02538AF8972317DC22DC52C9FCA89", hash_generated_method = "1ACF0BCB86749EE4C2B60BB83C470817")
    public void stagc(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.208 -0400", hash_original_method = "7F7C0809B3837070EBC39FFF348639C7", hash_generated_method = "BF7D539665C7572AF39A50267E3494A0")
    public void stage(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theWriter.println("!");
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.208 -0400", hash_original_method = "908998A64774886455085A6988C60433", hash_generated_method = "C1CD1C9ED8794B73072868413C0E0DC8")
    public void characters(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        pcdata(buff, offset, length);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.208 -0400", hash_original_method = "07AC39EBDED7098E926E255FC164A2D5", hash_generated_method = "129EEEA29FDFB63334E96FC98253B8C7")
    public void endDocument() throws SAXException {
        theWriter.close();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.209 -0400", hash_original_method = "52900B9FEFC9FE65D64402526E52F683", hash_generated_method = "F8D30026C6CFB5BAD43C4CD7AF795CDB")
    public void endElement(String uri, String localname, String qname) throws SAXException {
        addTaint(qname.getTaint());
        addTaint(localname.getTaint());
        addTaint(uri.getTaint());
    if(qname.length() == 0)        
        qname = localname;
        theWriter.print(')');
        theWriter.println(qname);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.209 -0400", hash_original_method = "0E90E85A66154559EA3C98CC7177C34F", hash_generated_method = "5B3A24B5853AE441BDBBB759C4F775AE")
    public void endPrefixMapping(String prefix) throws SAXException {
        addTaint(prefix.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.209 -0400", hash_original_method = "2E1F534279DED267EA0D6CCAD700E3B2", hash_generated_method = "8C9A43D7B1BD843C646E072F2D34453A")
    public void ignorableWhitespace(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        characters(buff, offset, length);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.210 -0400", hash_original_method = "53BDE4B1E3F8AE32ABB1D442EEBC1FC0", hash_generated_method = "4DB922F4F7FF81D9B768A460BD04AC3A")
    public void processingInstruction(String target, String data) throws SAXException {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
        theWriter.print('?');
        theWriter.print(target);
        theWriter.print(' ');
        theWriter.println(data);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.210 -0400", hash_original_method = "764EC710ED4FDFB68C9E6FE9ED249649", hash_generated_method = "8982242C86C53DDD9F8374B3C93C1CFB")
    public void setDocumentLocator(Locator locator) {
        addTaint(locator.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.210 -0400", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "78177C3306D49108B776A6C694C380AB")
    public void skippedEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.211 -0400", hash_original_method = "FAA725B72A2ADC391C781CAB49B849AD", hash_generated_method = "F5ABC17320CB17FAFC02F6F62510312E")
    public void startDocument() throws SAXException {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.211 -0400", hash_original_method = "3DE0561ECA4CEE2171786A759675C078", hash_generated_method = "0EA5320C8132A0FE57F18FE3130AD8BA")
    public void startElement(String uri, String localname, String qname,
			Attributes atts) throws SAXException {
        addTaint(atts.getTaint());
        addTaint(qname.getTaint());
        addTaint(localname.getTaint());
        addTaint(uri.getTaint());
    if(qname.length() == 0)        
        qname=localname;
        theWriter.print('(');
        theWriter.println(qname);
        int length = atts.getLength();
for(int i = 0;i < length;i++)
        {
            qname = atts.getQName(i);
    if(qname.length() == 0)            
            qname = atts.getLocalName(i);
            theWriter.print('A');
            theWriter.print(qname);
            theWriter.print(' ');
            theWriter.println(atts.getValue(i));
        } 
        
        
        
        
        
        
			
			
			
			
			
			
			
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.212 -0400", hash_original_method = "9A8DBFCDD6673580DBBCEDB8AE69733A", hash_generated_method = "20857BED78DD6479B3F78F4A256F1BE5")
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.212 -0400", hash_original_method = "E94210BE8A910F2AF0BA66BAC743271D", hash_generated_method = "3EF40672DD68D8A8055CE5BE33343B58")
    public void comment(char[] ch, int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
        cmnt(ch, start, length);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.212 -0400", hash_original_method = "B026A18FCF4D46E60EDFCDEA2654D91E", hash_generated_method = "B842EEA0DE9052ECF61866BD9EB9FFB0")
    public void endCDATA() throws SAXException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.213 -0400", hash_original_method = "3D36862B53F533617A1DD5C66B985713", hash_generated_method = "84D215898BE9C8AA399821A662E8380F")
    public void endDTD() throws SAXException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.213 -0400", hash_original_method = "A799CD2136F4389F2AB6AC2E97C1C7E3", hash_generated_method = "2EAC67D67612A09592B6D4AE3BE5EB34")
    public void endEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.213 -0400", hash_original_method = "E4BBD9A45ED517D6BA1A0F40E8CDD7AD", hash_generated_method = "1EFEFFE32283B3B2E0EFBC09815C5A15")
    public void startCDATA() throws SAXException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.213 -0400", hash_original_method = "AAB7E6DA97E949BBCF227EF9A66B4F67", hash_generated_method = "CBCBC9DC65B5200D410D05D9F9AC2E73")
    public void startDTD(String name, String publicId, String systemId) throws SAXException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(name.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.213 -0400", hash_original_method = "DCC3E349AFEA1A7195E89C47AA33A3E4", hash_generated_method = "CD87BEA40ED554D51CC2691C961E2B5E")
    public void startEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.213 -0400", hash_original_field = "A44CF1691B15368E5BF9F7C47A18C393", hash_generated_field = "02CD84A92AAD7C67C826D5A169B700D9")

    private static char[] dummy = new char[1];
}

