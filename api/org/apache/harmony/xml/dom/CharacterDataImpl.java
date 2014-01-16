package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

public abstract class CharacterDataImpl extends LeafNodeImpl implements CharacterData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.438 -0500", hash_original_field = "A9CAEEE2FF165AC333A62258118495FF", hash_generated_field = "8AF0FC6820B1A3CAE77FB8E492E96A1F")

    protected StringBuffer buffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.440 -0500", hash_original_method = "2CB76BA87C10BADB4B5943F1B8732E1D", hash_generated_method = "2CB76BA87C10BADB4B5943F1B8732E1D")
    
CharacterDataImpl(DocumentImpl document, String data) {
        super(document);
        setData(data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.442 -0500", hash_original_method = "8D2E95955BDAA1E5036D56B6067F1E47", hash_generated_method = "7D20DBB56DC3EEA9BE11C9C2098F5A18")
    
public void appendData(String arg) throws DOMException {
        buffer.append(arg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.444 -0500", hash_original_method = "C5CFAF8AE779968C86BDE7FF84B0F3C2", hash_generated_method = "96D2A0CF005BB6E6C9C2795098D76E79")
    
public void deleteData(int offset, int count) throws DOMException {
        buffer.delete(offset, offset + count);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.447 -0500", hash_original_method = "0E5A18340A236774C2757554A3CD1C3E", hash_generated_method = "E88571BC406AD60D137504BDC277894D")
    
public String getData() throws DOMException {
        return buffer.toString();
    }

    /**
     * Appends this node's text content to the given builder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.449 -0500", hash_original_method = "DF8889919B491656E0252194C5FFA90E", hash_generated_method = "D87174C4B8E2D68B4A903DF949F60DBE")
    
public void appendDataTo(StringBuilder stringBuilder) {
        stringBuilder.append(buffer);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.451 -0500", hash_original_method = "106EC06D9039E5E9A5A139C346DB10D2", hash_generated_method = "6982BC3E7A3243A8899A15B8AA18E2B7")
    
public int getLength() {
        return buffer.length();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.453 -0500", hash_original_method = "25D9FE8F6D2D11968D5C5576BFCDE9E9", hash_generated_method = "355DC249A20997EE2DDDEF00945A93EB")
    
@Override
    public String getNodeValue() {
        return getData();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.455 -0500", hash_original_method = "A6FF009A3A3E2831559B90C314C3B8F7", hash_generated_method = "C07C5A734496CD0BAC7D6B4D348C1563")
    
public void insertData(int offset, String arg) throws DOMException {
        try {
            buffer.insert(offset, arg);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.457 -0500", hash_original_method = "902A00AF0157FBC9B2C5E619B021F2A0", hash_generated_method = "B80657FFBD1C3F72F0D9B72712F53D86")
    
public void replaceData(int offset, int count, String arg)
            throws DOMException {
        try {
            buffer.replace(offset, offset + count, arg);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.461 -0500", hash_original_method = "5BA6B073B626BFB26050E72E23806022", hash_generated_method = "D119B080B48318E2AA7109BC0FDFCB03")
    
public void setData(String data) throws DOMException {
        buffer = new StringBuffer(data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.463 -0500", hash_original_method = "A81B93BB1735B5989CFA37B27C9FA648", hash_generated_method = "1AC7A6F99FFE1123A320628FE7C21DFB")
    
public String substringData(int offset, int count) throws DOMException {
        try {
            return buffer.substring(offset, offset + count);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        }
    }
    
}

