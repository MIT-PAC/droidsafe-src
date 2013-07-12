package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Enumeration;

public class LazyDERSequence extends DERSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.316 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.316 -0400", hash_original_field = "0E27CA10ED218E22AD1B0B35F24A7764", hash_generated_field = "8C5EC66D29868A1962676316469FC881")

    private boolean parsed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.316 -0400", hash_original_field = "304D03889695AEE9913D341019E1E376", hash_generated_field = "10F76FD865BC4D8F6F2C3440897633F6")

    private int size = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.316 -0400", hash_original_method = "774E91359D875B822740E8694BBD0378", hash_generated_method = "F13296280E5E5D813549095EB53048EE")
      LazyDERSequence(
        byte[] encoded) throws IOException {
        this.encoded = encoded;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.317 -0400", hash_original_method = "F52BE1D6A2A2A6E978CE6B87E0C287FA", hash_generated_method = "4066B9F0C1E6B43C8F07FEF950399A2A")
    private void parse() {
        Enumeration en = new LazyDERConstructionEnumeration(encoded);
        while
(en.hasMoreElements())        
        {
            addObject((DEREncodable)en.nextElement());
        } 
        parsed = true;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.317 -0400", hash_original_method = "D55432484A7204F62197A1C42F1222BB", hash_generated_method = "0C1EC9139AC19B1D72E5532BCE576EDB")
    public synchronized DEREncodable getObjectAt(int index) {
        addTaint(index);
    if(!parsed)        
        {
            parse();
        } 
DEREncodable varC3804AE80A9D974831C6A8C893D1AF39_718516268 =         super.getObjectAt(index);
        varC3804AE80A9D974831C6A8C893D1AF39_718516268.addTaint(taint);
        return varC3804AE80A9D974831C6A8C893D1AF39_718516268;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.317 -0400", hash_original_method = "939539D3FCA2F2720237F25863622D9D", hash_generated_method = "1223CC3C0F33CD39AF254FAF24C4E352")
    public synchronized Enumeration getObjects() {
    if(parsed)        
        {
Enumeration var0946A8F7E50977A659B8833DB09708BE_948065940 =             super.getObjects();
            var0946A8F7E50977A659B8833DB09708BE_948065940.addTaint(taint);
            return var0946A8F7E50977A659B8833DB09708BE_948065940;
        } 
Enumeration var8EEBD713CC6C39B1C08E644169D4EB15_805907160 =         new LazyDERConstructionEnumeration(encoded);
        var8EEBD713CC6C39B1C08E644169D4EB15_805907160.addTaint(taint);
        return var8EEBD713CC6C39B1C08E644169D4EB15_805907160;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.318 -0400", hash_original_method = "4DAF8F12C79E02A5B25C6CFF5DA9F3C5", hash_generated_method = "96BCBBE698BC9E1AC9F8246573C7A1C4")
    public int size() {
    if(size < 0)        
        {
            Enumeration en = new LazyDERConstructionEnumeration(encoded);
            size = 0;
            while
(en.hasMoreElements())            
            {
                en.nextElement();
                size++;
            } 
        } 
        int varF7BD60B75B29D79B660A2859395C1A24_79420447 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580330409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580330409;
        
        
        
            
            
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.318 -0400", hash_original_method = "46D9E51ED6BB4A9637D586153D86E513", hash_generated_method = "7A5DF5C27037FCBEFF2C921FE01002E3")
     void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(SEQUENCE | CONSTRUCTED, encoded);
        
        
    }

    
}

