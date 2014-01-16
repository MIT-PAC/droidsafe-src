package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.xml.sax.Attributes;

import droidsafe.helpers.DSUtils;

abstract class ExpatAttributes implements Attributes {
    
    private static String getURI(int pointer, int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(pointer);
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }
    
    private static String getLocalName(int pointer, int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(pointer);
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }
    
    private static String getQName(int pointer, int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(pointer);
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }
    
    private static String getValueByIndex(int attributePointer, int index) {
    	String ret = new String();
    	ret.addTaint(attributePointer);
    	ret.addTaint(index);
    	return ret;
    }
    
    private static int getIndex(int attributePointer, String uri, String localName) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003081945 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003081945;
    }
    
    private static int getIndexForQName(int attributePointer, String qName) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824428906 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824428906;
    }
    
    private static String getValue(int attributePointer, String uri, String localName) {
    	String ret = new String();
    	ret.addTaint(attributePointer);
    	ret.addTaint(uri.taint);
    	ret.addTaint(localName.taint);
    	return ret;
    }
    
    private static String getValueForQName(int attributePointer, String qName) {
    	String ret = new String();
    	ret.addTaint(attributePointer);
    	ret.addTaint(qName.taint);
    	return ret;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.257 -0500", hash_original_field = "5BA7CA622D233542C87EE6134AF7D100", hash_generated_field = "F3F78ECDDA218F6E2CE999A3775F902F")

    private static final String CDATA = "CDATA";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.997 -0400", hash_original_method = "D4DF1C9BC2FF91CA250847447EABC788", hash_generated_method = "D4DF1C9BC2FF91CA250847447EABC788")
    public ExpatAttributes ()
    {
        //Synthesized constructor
    }

    /**
     * Gets the number of attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.259 -0500", hash_original_method = "D4463566A46F2BB30D4DDE68BB591E19", hash_generated_method = "2FC4530CCBAE5C61CB39F40EA394F0C7")
    
public abstract int getLength();

    /**
     * Gets the pointer to the parser. We need this so we can get to the
     * interned string pool.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.261 -0500", hash_original_method = "BBDF056B00D4C6DB8963F7C247848525", hash_generated_method = "365B5919512E2F7EE3567ECC55AD66B2")
    
abstract int getParserPointer();

    /**
     * Gets the pointer to the underlying attribute array. Can be 0 if the
     * length is 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.263 -0500", hash_original_method = "E7A6A6BC4A3124D64B54EBF7490342ED", hash_generated_method = "957D6E9B37991F1FE5F343F8CB47FE99")
    
public abstract int getPointer();

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.266 -0500", hash_original_method = "57C7829583448928D2E62C8F0C20470B", hash_generated_method = "D44D9B2F6F876B0DD533D027E2251D75")
    
public String getURI(int index) {
        if (index < 0 || index >= getLength()) {
            return null;
        }
        return getURI(getParserPointer(), getPointer(), index);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.268 -0500", hash_original_method = "0BE26DE1FC37C5F8E294AD66DA35C798", hash_generated_method = "75A124B5A812511743303C11A7C5F8BF")
    
public String getLocalName(int index) {
        return (index < 0 || index >= getLength())
                ? null
                : getLocalName(getParserPointer(), getPointer(), index);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.270 -0500", hash_original_method = "0E62167FF9D29B28633236898C212817", hash_generated_method = "86C153B103570822649435FFE000EFBA")
    
public String getQName(int index) {
        return (index < 0 || index >= getLength())
                ? null
                : getQName(getParserPointer(), getPointer(), index);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.273 -0500", hash_original_method = "906F8D6EEECA09A0EB9B2E9E5289B227", hash_generated_method = "3DA7637C02F123D6A1C9A96EB4E7641F")
    
public String getType(int index) {
        return (index < 0 || index >= getLength()) ? null : CDATA;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.275 -0500", hash_original_method = "3269AF76DE45F61A692FCC87354CAB72", hash_generated_method = "94F8F53587BB02C73C96AE6A5ACEE7B6")
    
public String getValue(int index) {
        return (index < 0 || index >= getLength())
                ? null
                : getValueByIndex(getPointer(), index);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.277 -0500", hash_original_method = "C871C7E3F593C081235C517FE9A1E558", hash_generated_method = "5A7D792BE7E975B22C73FB9F60075C99")
    
public int getIndex(String uri, String localName) {
        if (uri == null) {
            throw new NullPointerException("uri");
        }
        if (localName == null) {
            throw new NullPointerException("local name");
        }
        int pointer = getPointer();
        if (pointer == 0) {
            return -1;
        }
        return getIndex(pointer, uri, localName);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.279 -0500", hash_original_method = "980758BEF60D7C26C232D3CAD78E7835", hash_generated_method = "7572B56221D3A77033066354DCE60F38")
    
public int getIndex(String qName) {
        if (qName == null) {
            throw new NullPointerException("uri");
        }
        int pointer = getPointer();
        if (pointer == 0) {
            return -1;
        }
        return getIndexForQName(pointer, qName);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.281 -0500", hash_original_method = "374AA6D4EA76C101E4A1F3245973703C", hash_generated_method = "36E38E31951FF1891C04A34963A6096F")
    
public String getType(String uri, String localName) {
        if (uri == null) {
            throw new NullPointerException("uri");
        }
        if (localName == null) {
            throw new NullPointerException("local name");
        }
        return getIndex(uri, localName) == -1 ? null : CDATA;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.283 -0500", hash_original_method = "845C2A9D603CFD94A25AD0FA47DD5097", hash_generated_method = "874E9A6EECCAEA1BFA628B6B54FEBDEF")
    
public String getType(String qName) {
        return getIndex(qName) == -1 ? null : CDATA;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.286 -0500", hash_original_method = "C565081F95CF8700320081FA5DB3FD15", hash_generated_method = "4375BAEA40259069AF0CAB860AC70B4E")
    
public String getValue(String uri, String localName) {
        if (uri == null) {
            throw new NullPointerException("uri");
        }
        if (localName == null) {
            throw new NullPointerException("local name");
        }
        int pointer = getPointer();
        if (pointer == 0) {
            return null;
        }
        return getValue(pointer, uri, localName);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.288 -0500", hash_original_method = "11A6BF5F6E86FB8B88CA0053A4EF72DA", hash_generated_method = "4C7E227D33C828CB6FCE6EDA782F385C")
    
public String getValue(String qName) {
        if (qName == null) {
            throw new NullPointerException("qName");
        }
        int pointer = getPointer();
        if (pointer == 0) {
            return null;
        }
        return getValueForQName(pointer, qName);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.324 -0500", hash_original_method = "9C2FF3514BF1A56FDD02B5A5C31F714B", hash_generated_method = "EFDE7CB565D59927C707284257F19756")
    
    protected void freeAttributes(int pointer){
    	//Formerly a native method
    	addTaint(pointer);
    }

}

