package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

public abstract class CharacterDataImpl extends LeafNodeImpl implements CharacterData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.655 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "8AF0FC6820B1A3CAE77FB8E492E96A1F")

    protected StringBuffer buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.655 -0400", hash_original_method = "2CB76BA87C10BADB4B5943F1B8732E1D", hash_generated_method = "09801EB5D3962C55AEDD1229FF624858")
      CharacterDataImpl(DocumentImpl document, String data) {
        super(document);
        setData(data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //setData(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.656 -0400", hash_original_method = "8D2E95955BDAA1E5036D56B6067F1E47", hash_generated_method = "7A9B9F817AC57992D5F96ED0C01A1FE3")
    public void appendData(String arg) throws DOMException {
        buffer.append(arg);
        addTaint(arg.getTaint());
        // ---------- Original Method ----------
        //buffer.append(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.656 -0400", hash_original_method = "C5CFAF8AE779968C86BDE7FF84B0F3C2", hash_generated_method = "D929AA92BE249F49987A4DC5F1EDD120")
    public void deleteData(int offset, int count) throws DOMException {
        buffer.delete(offset, offset + count);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //buffer.delete(offset, offset + count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.656 -0400", hash_original_method = "0E5A18340A236774C2757554A3CD1C3E", hash_generated_method = "510E5077E1C3E5CC19C3DC90EA58034C")
    public String getData() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_182411638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_182411638 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_182411638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_182411638;
        // ---------- Original Method ----------
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.657 -0400", hash_original_method = "DF8889919B491656E0252194C5FFA90E", hash_generated_method = "FEADAB9CC295F55E95679E58EE4732DA")
    public void appendDataTo(StringBuilder stringBuilder) {
        stringBuilder.append(buffer);
        addTaint(stringBuilder.getTaint());
        // ---------- Original Method ----------
        //stringBuilder.append(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.657 -0400", hash_original_method = "106EC06D9039E5E9A5A139C346DB10D2", hash_generated_method = "D41116975774CA19E17DA43D3BF66CE9")
    public int getLength() {
        int var62CE76AB96B4B014CEA3E8406FB892FE_81197577 = (buffer.length());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940736144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940736144;
        // ---------- Original Method ----------
        //return buffer.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.658 -0400", hash_original_method = "25D9FE8F6D2D11968D5C5576BFCDE9E9", hash_generated_method = "88EFA71A069F0A9CAA215D3EEA1DEB79")
    @Override
    public String getNodeValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_782402136 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_782402136 = getData();
        varB4EAC82CA7396A68D541C85D26508E83_782402136.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_782402136;
        // ---------- Original Method ----------
        //return getData();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.663 -0400", hash_original_method = "A6FF009A3A3E2831559B90C314C3B8F7", hash_generated_method = "16DD63F612BEB13A0310A0EBCF212F11")
    public void insertData(int offset, String arg) throws DOMException {
        try 
        {
            buffer.insert(offset, arg);
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        } //End block
        addTaint(offset);
        addTaint(arg.getTaint());
        // ---------- Original Method ----------
        //try {
            //buffer.insert(offset, arg);
        //} catch (ArrayIndexOutOfBoundsException ex) {
            //throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.664 -0400", hash_original_method = "902A00AF0157FBC9B2C5E619B021F2A0", hash_generated_method = "33BBB32F8685C1D757D33C0CDC6B3901")
    public void replaceData(int offset, int count, String arg) throws DOMException {
        try 
        {
            buffer.replace(offset, offset + count, arg);
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        } //End block
        addTaint(offset);
        addTaint(count);
        addTaint(arg.getTaint());
        // ---------- Original Method ----------
        //try {
            //buffer.replace(offset, offset + count, arg);
        //} catch (ArrayIndexOutOfBoundsException ex) {
            //throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.664 -0400", hash_original_method = "5BA6B073B626BFB26050E72E23806022", hash_generated_method = "6496183DCE4DB6F8C176C6F810C8C422")
    public void setData(String data) throws DOMException {
        buffer = new StringBuffer(data);
        // ---------- Original Method ----------
        //buffer = new StringBuffer(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.665 -0400", hash_original_method = "A81B93BB1735B5989CFA37B27C9FA648", hash_generated_method = "F074AD4BD6BC383923612B1881948A81")
    public String substringData(int offset, int count) throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1278881142 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1278881142 = buffer.substring(offset, offset + count);
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        } //End block
        addTaint(offset);
        addTaint(count);
        varB4EAC82CA7396A68D541C85D26508E83_1278881142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1278881142;
        // ---------- Original Method ----------
        //try {
            //return buffer.substring(offset, offset + count);
        //} catch (ArrayIndexOutOfBoundsException ex) {
            //throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        //}
    }

    
}

