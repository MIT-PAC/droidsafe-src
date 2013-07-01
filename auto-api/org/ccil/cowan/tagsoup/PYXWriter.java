package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.ext.LexicalHandler;

public class PYXWriter implements ScanHandler, ContentHandler, LexicalHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.931 -0400", hash_original_field = "29DE0C7BE9C5B26DD178E31FE931944B", hash_generated_field = "49F3A48A6073C357DEA9F2D054F0CF5A")

    private PrintWriter theWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.931 -0400", hash_original_field = "E6CBE9BA0F775DDC964E131A97543586", hash_generated_field = "1D790F77E1C6AE59D6044130824E23AE")

    private String attrName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.931 -0400", hash_original_method = "B358C277B5E2AD8935F1F06BA02E5093", hash_generated_method = "97C00D63B9D239A33A593449D71DAC7D")
    public  PYXWriter(Writer w) {
        {
            theWriter = (PrintWriter)w;
        } //End block
        {
            theWriter = new PrintWriter(w);
        } //End block
        // ---------- Original Method ----------
        //if (w instanceof PrintWriter) {
			//theWriter = (PrintWriter)w;
			//}
		//else {
			//theWriter = new PrintWriter(w);
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.932 -0400", hash_original_method = "387AEB9DCE887E98A76AE2F20CD71AE2", hash_generated_method = "7E760B4DB03E0D2418573BDB1638F252")
    public void adup(char[] buff, int offset, int length) throws SAXException {
        theWriter.println(attrName);
        attrName = null;
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.println(attrName);
        //attrName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.932 -0400", hash_original_method = "7D20D176BBEC71DA76C0647D5C25D5A3", hash_generated_method = "EC053AB6B03C84BABD4ED2C8768D9B86")
    public void aname(char[] buff, int offset, int length) throws SAXException {
        theWriter.print('A');
        theWriter.write(buff, offset, length);
        theWriter.print(' ');
        attrName = new String(buff, offset, length);
        // ---------- Original Method ----------
        //theWriter.print('A');
        //theWriter.write(buff, offset, length);
        //theWriter.print(' ');
        //attrName = new String(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.932 -0400", hash_original_method = "0B592E26491ABBF6D6340D0C31CDF40A", hash_generated_method = "B922644ED6CF8CA9ACA80D196A39B043")
    public void aval(char[] buff, int offset, int length) throws SAXException {
        theWriter.write(buff, offset, length);
        theWriter.println();
        attrName = null;
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.write(buff, offset, length);
        //theWriter.println();
        //attrName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.933 -0400", hash_original_method = "1B347B27BFF7BB03486A9C3953014010", hash_generated_method = "71099CF07497C2AC7764D1678D32BDA0")
    public void cmnt(char [] buff, int offset, int length) throws SAXException {
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.933 -0400", hash_original_method = "0C74769D0F9D1592330B85E57E53C137", hash_generated_method = "5806BA8BE7EDEC28C9427613BF7C460A")
    public void entity(char[] buff, int offset, int length) throws SAXException {
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.934 -0400", hash_original_method = "3C08B6E043A6E028BC79049543201CA8", hash_generated_method = "2345776F734AAE34ED37465A399EF780")
    public int getEntity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337955242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337955242;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.934 -0400", hash_original_method = "D330469217CBCDF6CFC5B6F4299F7DED", hash_generated_method = "03409AB4A0BE5D4F59A4AF798969B726")
    public void eof(char[] buff, int offset, int length) throws SAXException {
        theWriter.close();
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.935 -0400", hash_original_method = "26BADE83A21B645404502BDE9A94D5D0", hash_generated_method = "3C81DDCD2721C71A305394A179D1D2E4")
    public void etag(char[] buff, int offset, int length) throws SAXException {
        theWriter.print(')');
        theWriter.write(buff, offset, length);
        theWriter.println();
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.print(')');
        //theWriter.write(buff, offset, length);
        //theWriter.println();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.936 -0400", hash_original_method = "D7373B13D97F6239D6FE9A75A6C3C4CD", hash_generated_method = "B4A3E12EAA1D2812561576A28AA2C0D3")
    public void decl(char[] buff, int offset, int length) throws SAXException {
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.936 -0400", hash_original_method = "F17CC0C0B50085C85B2E9F440AE2C746", hash_generated_method = "0DBB9F655C0A0095BDCF45FA9006259A")
    public void gi(char[] buff, int offset, int length) throws SAXException {
        theWriter.print('(');
        theWriter.write(buff, offset, length);
        theWriter.println();
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.print('(');
        //theWriter.write(buff, offset, length);
        //theWriter.println();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.936 -0400", hash_original_method = "A1521B964CA14C9F176B788365114A3A", hash_generated_method = "DEF15EC86F6678B6D92FC1B828369B7C")
    public void cdsect(char[] buff, int offset, int length) throws SAXException {
        pcdata(buff, offset, length);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //pcdata(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.937 -0400", hash_original_method = "EA665DB78182CC462806E2E30B0F15A4", hash_generated_method = "9242E9C774A8CDB32B8943186A41034B")
    public void pcdata(char[] buff, int offset, int length) throws SAXException {
        boolean inProgress = false;
        length += offset;
        {
            int i = offset;
            {
                {
                    {
                        theWriter.println();
                    } //End block
                    theWriter.println("-\\n");
                    inProgress = false;
                } //End block
                {
                    {
                        theWriter.print('-');
                    } //End block
                    //Begin case '\t' 
                    theWriter.print("\\t");
                    //End case '\t' 
                    //Begin case '\\' 
                    theWriter.print("\\\\");
                    //End case '\\' 
                    //Begin case default 
                    theWriter.print(buff[i]);
                    //End case default 
                    inProgress = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            theWriter.println();
        } //End block
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (length == 0) return;
        //boolean inProgress = false;
        //length += offset;
        //for (int i = offset; i < length; i++) {
			//if (buff[i] == '\n') {
				//if (inProgress) {
					//theWriter.println();
					//}
				//theWriter.println("-\\n");
				//inProgress = false;
				//}
			//else {
				//if (!inProgress) {
					//theWriter.print('-');
					//}
				//switch(buff[i]) {
				//case '\t':
					//theWriter.print("\\t");
					//break;
				//case '\\':
					//theWriter.print("\\\\");
					//break;
				//default:
					//theWriter.print(buff[i]);
					//}
				//inProgress = true;
				//}
			//}
        //if (inProgress) {
			//theWriter.println();
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.937 -0400", hash_original_method = "434533230F3CD22E7AA0C553CAF97C2F", hash_generated_method = "128829D549439A71211EE6FA8E84C6CE")
    public void pitarget(char[] buff, int offset, int length) throws SAXException {
        theWriter.print('?');
        theWriter.write(buff, offset, length);
        theWriter.write(' ');
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.print('?');
        //theWriter.write(buff, offset, length);
        //theWriter.write(' ');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.938 -0400", hash_original_method = "ED46B5C6DF2EC4C94179D535403EEAEA", hash_generated_method = "7078226FBAF4119053230DB3E3E6EEFA")
    public void pi(char[] buff, int offset, int length) throws SAXException {
        theWriter.write(buff, offset, length);
        theWriter.println();
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.write(buff, offset, length);
        //theWriter.println();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.938 -0400", hash_original_method = "96E02538AF8972317DC22DC52C9FCA89", hash_generated_method = "3D5BE493515BE99DFDD5F719299ECEFB")
    public void stagc(char[] buff, int offset, int length) throws SAXException {
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.938 -0400", hash_original_method = "7F7C0809B3837070EBC39FFF348639C7", hash_generated_method = "87F2B6701CE7CF77C8E5EDAC860A8F13")
    public void stage(char[] buff, int offset, int length) throws SAXException {
        theWriter.println("!");
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theWriter.println("!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.938 -0400", hash_original_method = "908998A64774886455085A6988C60433", hash_generated_method = "C0E3EFC4B27FEA9121578A6ECBB0746A")
    public void characters(char[] buff, int offset, int length) throws SAXException {
        pcdata(buff, offset, length);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //pcdata(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.938 -0400", hash_original_method = "07AC39EBDED7098E926E255FC164A2D5", hash_generated_method = "129EEEA29FDFB63334E96FC98253B8C7")
    public void endDocument() throws SAXException {
        theWriter.close();
        // ---------- Original Method ----------
        //theWriter.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.939 -0400", hash_original_method = "52900B9FEFC9FE65D64402526E52F683", hash_generated_method = "8A578EC4CAC78591655B396AC666D762")
    public void endElement(String uri, String localname, String qname) throws SAXException {
        {
            boolean var999C0C85587811AC50F2DB131A312BE9_7252080 = (qname.length() == 0);
            qname = localname;
        } //End collapsed parenthetic
        theWriter.print(')');
        theWriter.println(qname);
        addTaint(uri.getTaint());
        addTaint(localname.getTaint());
        addTaint(qname.getTaint());
        // ---------- Original Method ----------
        //if (qname.length() == 0) qname = localname;
        //theWriter.print(')');
        //theWriter.println(qname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.939 -0400", hash_original_method = "0E90E85A66154559EA3C98CC7177C34F", hash_generated_method = "5B3A24B5853AE441BDBBB759C4F775AE")
    public void endPrefixMapping(String prefix) throws SAXException {
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.939 -0400", hash_original_method = "2E1F534279DED267EA0D6CCAD700E3B2", hash_generated_method = "064E175EA8AF1D3800D7F7BFBF9BEF67")
    public void ignorableWhitespace(char[] buff, int offset, int length) throws SAXException {
        characters(buff, offset, length);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //characters(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.939 -0400", hash_original_method = "53BDE4B1E3F8AE32ABB1D442EEBC1FC0", hash_generated_method = "6D984709D4EF9C6E720B797DDE8FAAED")
    public void processingInstruction(String target, String data) throws SAXException {
        theWriter.print('?');
        theWriter.print(target);
        theWriter.print(' ');
        theWriter.println(data);
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //theWriter.print('?');
        //theWriter.print(target);
        //theWriter.print(' ');
        //theWriter.println(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.940 -0400", hash_original_method = "764EC710ED4FDFB68C9E6FE9ED249649", hash_generated_method = "8982242C86C53DDD9F8374B3C93C1CFB")
    public void setDocumentLocator(Locator locator) {
        addTaint(locator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.940 -0400", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "78177C3306D49108B776A6C694C380AB")
    public void skippedEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.940 -0400", hash_original_method = "FAA725B72A2ADC391C781CAB49B849AD", hash_generated_method = "F5ABC17320CB17FAFC02F6F62510312E")
    public void startDocument() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.940 -0400", hash_original_method = "3DE0561ECA4CEE2171786A759675C078", hash_generated_method = "C38FFFE062C96E77F73CB2818D18BC5B")
    public void startElement(String uri, String localname, String qname,
			Attributes atts) throws SAXException {
        {
            boolean var999C0C85587811AC50F2DB131A312BE9_1227755412 = (qname.length() == 0);
            qname=localname;
        } //End collapsed parenthetic
        theWriter.print('(');
        theWriter.println(qname);
        int length = atts.getLength();
        {
            int i = 0;
            {
                qname = atts.getQName(i);
                {
                    boolean varC13F188079069C5FB2B6DCA404347431_1724586721 = (qname.length() == 0);
                    qname = atts.getLocalName(i);
                } //End collapsed parenthetic
                theWriter.print('A');
                theWriter.print(qname);
                theWriter.print(' ');
                theWriter.println(atts.getValue(i));
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(localname.getTaint());
        addTaint(qname.getTaint());
        addTaint(atts.getTaint());
        // ---------- Original Method ----------
        //if (qname.length() == 0) qname=localname;
        //theWriter.print('(');
        //theWriter.println(qname);
        //int length = atts.getLength();
        //for (int i = 0; i < length; i++) {
			//qname = atts.getQName(i);
			//if (qname.length() == 0) qname = atts.getLocalName(i);
			//theWriter.print('A');
			//theWriter.print(qname);
			//theWriter.print(' ');
			//theWriter.println(atts.getValue(i));
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.941 -0400", hash_original_method = "9A8DBFCDD6673580DBBCEDB8AE69733A", hash_generated_method = "D2DEDFEF366F67889D9FA3A94A552C63")
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.941 -0400", hash_original_method = "E94210BE8A910F2AF0BA66BAC743271D", hash_generated_method = "DA5BE844E63BC5E58D81B911E59FCA55")
    public void comment(char[] ch, int start, int length) throws SAXException {
        cmnt(ch, start, length);
        addTaint(ch[0]);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
        //cmnt(ch, start, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.941 -0400", hash_original_method = "B026A18FCF4D46E60EDFCDEA2654D91E", hash_generated_method = "B842EEA0DE9052ECF61866BD9EB9FFB0")
    public void endCDATA() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.942 -0400", hash_original_method = "3D36862B53F533617A1DD5C66B985713", hash_generated_method = "84D215898BE9C8AA399821A662E8380F")
    public void endDTD() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.942 -0400", hash_original_method = "A799CD2136F4389F2AB6AC2E97C1C7E3", hash_generated_method = "2EAC67D67612A09592B6D4AE3BE5EB34")
    public void endEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.942 -0400", hash_original_method = "E4BBD9A45ED517D6BA1A0F40E8CDD7AD", hash_generated_method = "1EFEFFE32283B3B2E0EFBC09815C5A15")
    public void startCDATA() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.942 -0400", hash_original_method = "AAB7E6DA97E949BBCF227EF9A66B4F67", hash_generated_method = "531E4E0E99A590313617911952C91A43")
    public void startDTD(String name, String publicId, String systemId) throws SAXException {
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.942 -0400", hash_original_method = "DCC3E349AFEA1A7195E89C47AA33A3E4", hash_generated_method = "CD87BEA40ED554D51CC2691C961E2B5E")
    public void startEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.942 -0400", hash_original_field = "A44CF1691B15368E5BF9F7C47A18C393", hash_generated_field = "02CD84A92AAD7C67C826D5A169B700D9")

    private static char[] dummy = new char[1];
}

