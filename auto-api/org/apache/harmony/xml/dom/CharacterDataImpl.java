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
    protected StringBuffer buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.126 -0400", hash_original_method = "2CB76BA87C10BADB4B5943F1B8732E1D", hash_generated_method = "50A08254C23FC94A4A3ACC1197421797")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharacterDataImpl(DocumentImpl document, String data) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(data);
        setData(data);
        // ---------- Original Method ----------
        //setData(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.126 -0400", hash_original_method = "8D2E95955BDAA1E5036D56B6067F1E47", hash_generated_method = "90FDF169C617C3617B248C2F0A028B37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendData(String arg) throws DOMException {
        dsTaint.addTaint(arg);
        buffer.append(arg);
        // ---------- Original Method ----------
        //buffer.append(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.126 -0400", hash_original_method = "C5CFAF8AE779968C86BDE7FF84B0F3C2", hash_generated_method = "F3B1AF2345A320F271B9AAA3F234DE2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteData(int offset, int count) throws DOMException {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        buffer.delete(offset, offset + count);
        // ---------- Original Method ----------
        //buffer.delete(offset, offset + count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.126 -0400", hash_original_method = "0E5A18340A236774C2757554A3CD1C3E", hash_generated_method = "AE6F6E899B414A3F0AF7A3096DA7E7F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getData() throws DOMException {
        String varAD28D02EB1C6982A5710D014292E1955_1139528997 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.126 -0400", hash_original_method = "DF8889919B491656E0252194C5FFA90E", hash_generated_method = "80A225A376F8152B8E2666AE240F3466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendDataTo(StringBuilder stringBuilder) {
        dsTaint.addTaint(stringBuilder.dsTaint);
        stringBuilder.append(buffer);
        // ---------- Original Method ----------
        //stringBuilder.append(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.126 -0400", hash_original_method = "106EC06D9039E5E9A5A139C346DB10D2", hash_generated_method = "8FD8E76F39E3C12BF07E1D95A32CA038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLength() {
        int var62CE76AB96B4B014CEA3E8406FB892FE_10204728 = (buffer.length());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return buffer.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.127 -0400", hash_original_method = "25D9FE8F6D2D11968D5C5576BFCDE9E9", hash_generated_method = "F67E83285639C3DDCE053C118423C232")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getNodeValue() {
        String varF24084D93896ED437198C8604B2E7A74_1432155905 = (getData());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getData();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.127 -0400", hash_original_method = "A6FF009A3A3E2831559B90C314C3B8F7", hash_generated_method = "F765C15B5B6F5F17AEC8273479573D9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void insertData(int offset, String arg) throws DOMException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(offset);
        try 
        {
            buffer.insert(offset, arg);
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        } //End block
        // ---------- Original Method ----------
        //try {
            //buffer.insert(offset, arg);
        //} catch (ArrayIndexOutOfBoundsException ex) {
            //throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.127 -0400", hash_original_method = "902A00AF0157FBC9B2C5E619B021F2A0", hash_generated_method = "50D77458A63464334CEEEDD46E35F4D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void replaceData(int offset, int count, String arg) throws DOMException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        try 
        {
            buffer.replace(offset, offset + count, arg);
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        } //End block
        // ---------- Original Method ----------
        //try {
            //buffer.replace(offset, offset + count, arg);
        //} catch (ArrayIndexOutOfBoundsException ex) {
            //throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.127 -0400", hash_original_method = "5BA6B073B626BFB26050E72E23806022", hash_generated_method = "EB00D2F19B8152F4B7BC5EC4443A705F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setData(String data) throws DOMException {
        dsTaint.addTaint(data);
        buffer = new StringBuffer(data);
        // ---------- Original Method ----------
        //buffer = new StringBuffer(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.127 -0400", hash_original_method = "A81B93BB1735B5989CFA37B27C9FA648", hash_generated_method = "3EF88475BD9A345A1AA79A3B351D499A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String substringData(int offset, int count) throws DOMException {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        try 
        {
            String varFD42D5188E0AFA774EC1D96C65D269F0_618305812 = (buffer.substring(offset, offset + count));
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return buffer.substring(offset, offset + count);
        //} catch (ArrayIndexOutOfBoundsException ex) {
            //throw new DOMException(DOMException.INDEX_SIZE_ERR, null);
        //}
    }

    
}

