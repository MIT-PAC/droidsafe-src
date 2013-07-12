package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

public abstract class CharacterDataImpl extends LeafNodeImpl implements CharacterData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.516 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "8AF0FC6820B1A3CAE77FB8E492E96A1F")

    protected StringBuffer buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.516 -0400", hash_original_method = "2CB76BA87C10BADB4B5943F1B8732E1D", hash_generated_method = "8F15F2CC9C5F87747EE4E20D290E4362")
      CharacterDataImpl(DocumentImpl document, String data) {
        super(document);
        addTaint(data.getTaint());
        addTaint(document.getTaint());
        setData(data);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.517 -0400", hash_original_method = "8D2E95955BDAA1E5036D56B6067F1E47", hash_generated_method = "059971E5260F5004355F12D91A21B538")
    public void appendData(String arg) throws DOMException {
        addTaint(arg.getTaint());
        buffer.append(arg);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.517 -0400", hash_original_method = "C5CFAF8AE779968C86BDE7FF84B0F3C2", hash_generated_method = "ADC178DB02344097BAF3C71212EE3B37")
    public void deleteData(int offset, int count) throws DOMException {
        addTaint(count);
        addTaint(offset);
        buffer.delete(offset, offset + count);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.517 -0400", hash_original_method = "0E5A18340A236774C2757554A3CD1C3E", hash_generated_method = "54BB65D21D96BEAB4B10E776A20025C1")
    public String getData() throws DOMException {
String varD03843288D33B9E1D3062E25339ECF6D_306354697 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_306354697.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_306354697;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.517 -0400", hash_original_method = "DF8889919B491656E0252194C5FFA90E", hash_generated_method = "A918F92CF730A33AC3F60E20C95E0B62")
    public void appendDataTo(StringBuilder stringBuilder) {
        addTaint(stringBuilder.getTaint());
        stringBuilder.append(buffer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.518 -0400", hash_original_method = "106EC06D9039E5E9A5A139C346DB10D2", hash_generated_method = "112FD4E6417F78BC42C8109C0ADEF1EE")
    public int getLength() {
        int var2F91DDEFEC2C6B29A9FB08A23412E50A_1934097825 = (buffer.length());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939908736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939908736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.518 -0400", hash_original_method = "25D9FE8F6D2D11968D5C5576BFCDE9E9", hash_generated_method = "29B8C1E17B592157179D15560BE2C463")
    @Override
    public String getNodeValue() {
String var440EBBDCD2C81ACAD0A4F29C408AA623_2026453894 =         getData();
        var440EBBDCD2C81ACAD0A4F29C408AA623_2026453894.addTaint(taint);
        return var440EBBDCD2C81ACAD0A4F29C408AA623_2026453894;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.518 -0400", hash_original_method = "A6FF009A3A3E2831559B90C314C3B8F7", hash_generated_method = "9B1DE97861B912D6E106F10B47BB51C6")
    public void insertData(int offset, String arg) throws DOMException {
        addTaint(arg.getTaint());
        addTaint(offset);
        try 
        {
            buffer.insert(offset, arg);
        } 
        catch (ArrayIndexOutOfBoundsException ex)
        {
            DOMException var9289CB175910D102FDEE25262796A51E_1403229810 = new DOMException(DOMException.INDEX_SIZE_ERR, null);
            var9289CB175910D102FDEE25262796A51E_1403229810.addTaint(taint);
            throw var9289CB175910D102FDEE25262796A51E_1403229810;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.519 -0400", hash_original_method = "902A00AF0157FBC9B2C5E619B021F2A0", hash_generated_method = "FA2404DBDF8C2CE4E2C729DB5C0B8691")
    public void replaceData(int offset, int count, String arg) throws DOMException {
        addTaint(arg.getTaint());
        addTaint(count);
        addTaint(offset);
        try 
        {
            buffer.replace(offset, offset + count, arg);
        } 
        catch (ArrayIndexOutOfBoundsException ex)
        {
            DOMException var9289CB175910D102FDEE25262796A51E_1829943248 = new DOMException(DOMException.INDEX_SIZE_ERR, null);
            var9289CB175910D102FDEE25262796A51E_1829943248.addTaint(taint);
            throw var9289CB175910D102FDEE25262796A51E_1829943248;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.519 -0400", hash_original_method = "5BA6B073B626BFB26050E72E23806022", hash_generated_method = "6496183DCE4DB6F8C176C6F810C8C422")
    public void setData(String data) throws DOMException {
        buffer = new StringBuffer(data);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.520 -0400", hash_original_method = "A81B93BB1735B5989CFA37B27C9FA648", hash_generated_method = "F881625343AB71A77709331FB7DB6863")
    public String substringData(int offset, int count) throws DOMException {
        addTaint(count);
        addTaint(offset);
        try 
        {
String varA73FBC0ECD565CFC05C059EA0FBBD8AE_1686487499 =             buffer.substring(offset, offset + count);
            varA73FBC0ECD565CFC05C059EA0FBBD8AE_1686487499.addTaint(taint);
            return varA73FBC0ECD565CFC05C059EA0FBBD8AE_1686487499;
        } 
        catch (ArrayIndexOutOfBoundsException ex)
        {
            DOMException var9289CB175910D102FDEE25262796A51E_1452921041 = new DOMException(DOMException.INDEX_SIZE_ERR, null);
            var9289CB175910D102FDEE25262796A51E_1452921041.addTaint(taint);
            throw var9289CB175910D102FDEE25262796A51E_1452921041;
        } 
        
        
            
        
            
        
    }

    
}

