/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * This file is part of TagSoup and is Copyright 2002-2008 by John Cowan.
 *
 * TagSoup is licensed under the Apache License,
 * Version 2.0.  You may obtain a copy of this license at
 * http: *www.apache.org/licenses/LICENSE-2.0 .  You may also have
 * additional legal rights not granted by this license.
 *
 * TagSoup is distributed in the hope that it will be useful, but
 * unless required by applicable law or agreed to in writing, TagSoup
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied; not even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 */ 


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


// PYX Writer
// FIXME: does not do escapes in attribute values
// FIXME: outputs entities as bare '&' character

package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.io.Writer;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

public class PYXWriter implements ScanHandler, ContentHandler, LexicalHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.291 -0500", hash_original_field = "E289977DD763E2EB74F5C17AAAA2FFDD", hash_generated_field = "02CD84A92AAD7C67C826D5A169B700D9")

	private static char[] dummy = new char[1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.288 -0500", hash_original_field = "513F69EA21D11E56A05149090A0A48B2", hash_generated_field = "49F3A48A6073C357DEA9F2D054F0CF5A")

	private PrintWriter theWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.293 -0500", hash_original_field = "F10689903BED993CD29E6B6C9E0C9EED", hash_generated_field = "1D790F77E1C6AE59D6044130824E23AE")

	private String attrName;

	// Constructor

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.373 -0500", hash_original_method = "B358C277B5E2AD8935F1F06BA02E5093", hash_generated_method = "11D9F47342E4D734B4EC40F74ABDFB01")
	
public PYXWriter(Writer w) {
		if (w instanceof PrintWriter) {
			theWriter = (PrintWriter)w;
			}
		else {
			theWriter = new PrintWriter(w);
			}
		}		// saved attribute name

	// ScanHandler implementation

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.296 -0500", hash_original_method = "387AEB9DCE887E98A76AE2F20CD71AE2", hash_generated_method = "526FA9AEC0F1A90A1BE35BF9B9AE25E0")
	
public void adup(char[] buff, int offset, int length) throws SAXException {
		theWriter.println(attrName);
		attrName = null;
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.298 -0500", hash_original_method = "7D20D176BBEC71DA76C0647D5C25D5A3", hash_generated_method = "0A0CC9AABA223BDFFBA4E47C65FABF55")
	
public void aname(char[] buff, int offset, int length) throws SAXException {
		theWriter.print('A');
		theWriter.write(buff, offset, length);
		theWriter.print(' ');
		attrName = new String(buff, offset, length);
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.300 -0500", hash_original_method = "0B592E26491ABBF6D6340D0C31CDF40A", hash_generated_method = "87B3B6FDF477986BC213B0731D31D3A1")
	
public void aval(char[] buff, int offset, int length) throws SAXException {
		theWriter.write(buff, offset, length);
		theWriter.println();
		attrName = null;
		}
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.200 -0400", hash_original_method = "1B347B27BFF7BB03486A9C3953014010", hash_generated_method = "A69F4BB3139A30AE29048B59041500BE")
    public void cmnt(char [] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        // ---------- Original Method ----------
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.305 -0500", hash_original_method = "0C74769D0F9D1592330B85E57E53C137", hash_generated_method = "6AEE14EEADC2BF8E21E1B4F5FFB18749")
	
public void entity(char[] buff, int offset, int length) throws SAXException { }

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.307 -0500", hash_original_method = "3C08B6E043A6E028BC79049543201CA8", hash_generated_method = "7477A79F9C1C54C788DB94DD5E638D18")
	
public int getEntity() { return 0; }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.309 -0500", hash_original_method = "D330469217CBCDF6CFC5B6F4299F7DED", hash_generated_method = "129074752853BFEC38516FEBEAFA4C1F")
	
public void eof(char[] buff, int offset, int length) throws SAXException {
		theWriter.close();
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.311 -0500", hash_original_method = "26BADE83A21B645404502BDE9A94D5D0", hash_generated_method = "04A34FF66493AE97B9A8CBA326163A07")
	
public void etag(char[] buff, int offset, int length) throws SAXException {
		theWriter.print(')');
		theWriter.write(buff, offset, length);
		theWriter.println();
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.313 -0500", hash_original_method = "D7373B13D97F6239D6FE9A75A6C3C4CD", hash_generated_method = "335DB75A469EE693A6D24448407742FE")
	
public void decl(char[] buff, int offset, int length) throws SAXException {
        }

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.316 -0500", hash_original_method = "F17CC0C0B50085C85B2E9F440AE2C746", hash_generated_method = "D9BCBC4A4EB1DD3688875513E155308E")
	
public void gi(char[] buff, int offset, int length) throws SAXException {
		theWriter.print('(');
		theWriter.write(buff, offset, length);
		theWriter.println();
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.318 -0500", hash_original_method = "A1521B964CA14C9F176B788365114A3A", hash_generated_method = "4744839A41B9051628C90600ED693003")
	
public void cdsect(char[] buff, int offset, int length) throws SAXException {
		pcdata(buff, offset, length);
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.320 -0500", hash_original_method = "EA665DB78182CC462806E2E30B0F15A4", hash_generated_method = "F18A7C9E1994DDA5C857E86600BA7EE2")
	
public void pcdata(char[] buff, int offset, int length) throws SAXException {
		if (length == 0) return;	// nothing to do
		boolean inProgress = false;
		length += offset;
		for (int i = offset; i < length; i++) {
			if (buff[i] == '\n') {
				if (inProgress) {
					theWriter.println();
					}
				theWriter.println("-\\n");
				inProgress = false;
				}
			else {
				if (!inProgress) {
					theWriter.print('-');
					}
				switch(buff[i]) {
				case '\t':
					theWriter.print("\\t");
					break;
				case '\\':
					theWriter.print("\\\\");
					break;
				default:
					theWriter.print(buff[i]);
					}
				inProgress = true;
				}
			}
		if (inProgress) {
			theWriter.println();
			}
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.323 -0500", hash_original_method = "434533230F3CD22E7AA0C553CAF97C2F", hash_generated_method = "00595BAD87DA24F670D148B39B40FCE3")
	
public void pitarget(char[] buff, int offset, int length) throws SAXException {
		theWriter.print('?');
		theWriter.write(buff, offset, length);
		theWriter.write(' ');
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.325 -0500", hash_original_method = "ED46B5C6DF2EC4C94179D535403EEAEA", hash_generated_method = "16A09E2E3785805AED518BEEFD81EE58")
	
public void pi(char[] buff, int offset, int length) throws SAXException {
		theWriter.write(buff, offset, length);
		theWriter.println();
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.327 -0500", hash_original_method = "96E02538AF8972317DC22DC52C9FCA89", hash_generated_method = "C5928B5A36AFF64325A01D13F3496405")
	
public void stagc(char[] buff, int offset, int length) throws SAXException {
//		theWriter.println("!");			// FIXME
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.329 -0500", hash_original_method = "7F7C0809B3837070EBC39FFF348639C7", hash_generated_method = "D9C8A6AEB19344EEABA739C67A78EFF8")
	
public void stage(char[] buff, int offset, int length) throws SAXException {
		theWriter.println("!");			// FIXME
		}

	// SAX ContentHandler implementation

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.332 -0500", hash_original_method = "908998A64774886455085A6988C60433", hash_generated_method = "794DAD7B2D0114A4EE5A2C9C8ADAD450")
	
public void characters(char[] buff, int offset, int length) throws SAXException {
		pcdata(buff, offset, length);
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.334 -0500", hash_original_method = "07AC39EBDED7098E926E255FC164A2D5", hash_generated_method = "74626E1BC9C8F8735C604E830BF8EF70")
	
public void endDocument() throws SAXException {
		theWriter.close();
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.337 -0500", hash_original_method = "52900B9FEFC9FE65D64402526E52F683", hash_generated_method = "277B755B6BF5F1804CA28F1D80841AFA")
	
public void endElement(String uri, String localname, String qname) throws SAXException {
		if (qname.length() == 0) qname = localname;
		theWriter.print(')');
		theWriter.println(qname);
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.339 -0500", hash_original_method = "0E90E85A66154559EA3C98CC7177C34F", hash_generated_method = "C57BA1B797F9B6AF7FE79D44FF6640CA")
	
public void endPrefixMapping(String prefix) throws SAXException { }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.341 -0500", hash_original_method = "2E1F534279DED267EA0D6CCAD700E3B2", hash_generated_method = "A05D8ADA1F35B1E9E7EC070634FFC1A7")
	
public void ignorableWhitespace(char[] buff, int offset, int length) throws SAXException {
		characters(buff, offset, length);
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.343 -0500", hash_original_method = "53BDE4B1E3F8AE32ABB1D442EEBC1FC0", hash_generated_method = "E07BCA12D8BCF1FA30BC32D0C3D20BF0")
	
public void processingInstruction(String target, String data) throws SAXException {
		theWriter.print('?');
		theWriter.print(target);
		theWriter.print(' ');
		theWriter.println(data);
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.346 -0500", hash_original_method = "764EC710ED4FDFB68C9E6FE9ED249649", hash_generated_method = "2A03485A9C7E9AF053D0769877C42163")
	
public void setDocumentLocator(Locator locator) { }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.348 -0500", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "A990924CA217DA9AB88497E28F935EE3")
	
public void skippedEntity(String name) throws SAXException { }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.350 -0500", hash_original_method = "FAA725B72A2ADC391C781CAB49B849AD", hash_generated_method = "B7DDED468AEC81414C9CDB2776677119")
	
public void startDocument() throws SAXException { }

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.353 -0500", hash_original_method = "3DE0561ECA4CEE2171786A759675C078", hash_generated_method = "FD5B3B997BBFF5DDDFE462A6DE1A898D")
	
public void startElement(String uri, String localname, String qname,
			Attributes atts) throws SAXException {
		if (qname.length() == 0) qname=localname;
		theWriter.print('(');
		theWriter.println(qname);
		int length = atts.getLength();
		for (int i = 0; i < length; i++) {
			qname = atts.getQName(i);
			if (qname.length() == 0) qname = atts.getLocalName(i);
			theWriter.print('A');
//			theWriter.print(atts.getType(i));	// DEBUG
			theWriter.print(qname);
			theWriter.print(' ');
			theWriter.println(atts.getValue(i));
			}
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.355 -0500", hash_original_method = "9A8DBFCDD6673580DBBCEDB8AE69733A", hash_generated_method = "B995952A1DAC319BF5A213B6DF1E548E")
	
public void startPrefixMapping(String prefix, String uri) throws SAXException { }

	// Default LexicalHandler implementation

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.357 -0500", hash_original_method = "E94210BE8A910F2AF0BA66BAC743271D", hash_generated_method = "4AB86CFE3726D984425AC161058BA1CC")
	
public void comment(char[] ch, int start, int length) throws SAXException {
		cmnt(ch, start, length);
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.359 -0500", hash_original_method = "B026A18FCF4D46E60EDFCDEA2654D91E", hash_generated_method = "5436D7E012C1BB7651D047DE2AC3E706")
	
public void endCDATA() throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.361 -0500", hash_original_method = "3D36862B53F533617A1DD5C66B985713", hash_generated_method = "9481DC6C7665CC2EE67A168AF6997592")
	
public void endDTD() throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.364 -0500", hash_original_method = "A799CD2136F4389F2AB6AC2E97C1C7E3", hash_generated_method = "9E4C022B93F86FA2501718917A3E8660")
	
public void endEntity(String name) throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.366 -0500", hash_original_method = "E4BBD9A45ED517D6BA1A0F40E8CDD7AD", hash_generated_method = "4424B19DE8198582589012365F320887")
	
public void startCDATA() throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.369 -0500", hash_original_method = "AAB7E6DA97E949BBCF227EF9A66B4F67", hash_generated_method = "460DE7CDD5B1214F9C4D0EB2B5E8FD57")
	
public void startDTD(String name, String publicId, String systemId) throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.371 -0500", hash_original_method = "DCC3E349AFEA1A7195E89C47AA33A3E4", hash_generated_method = "B61B8BDA3EE5CD516ADAEFA172F35910")
	
public void startEntity(String name) throws SAXException { }
}

