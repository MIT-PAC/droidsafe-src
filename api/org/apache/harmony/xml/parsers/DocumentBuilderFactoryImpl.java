package org.apache.harmony.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuilderFactoryImpl extends DocumentBuilderFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.970 -0400", hash_original_method = "CAFBFE87DB9B664F26C15EE0CE72FE04", hash_generated_method = "CAFBFE87DB9B664F26C15EE0CE72FE04")
    public DocumentBuilderFactoryImpl ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.970 -0400", hash_original_method = "ACE2451F013C7800286FF5717C2987CD", hash_generated_method = "CADF042E68E5AE21C5DEC4539E5C1EAA")
    @Override
    public Object getAttribute(String name) throws IllegalArgumentException {
        addTaint(name.getTaint());
        IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_707239918 = new IllegalArgumentException(name);
        varBF6A5C454ED01F0F986515C3E9A9CEA3_707239918.addTaint(taint);
        throw varBF6A5C454ED01F0F986515C3E9A9CEA3_707239918;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.971 -0400", hash_original_method = "64128D577B53B34B78055B7B7FC0B66E", hash_generated_method = "A6EE69CF7A37E4005424CCE8ECB56C43")
    @Override
    public boolean getFeature(String name) throws ParserConfigurationException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1244388239 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1244388239.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1244388239;
        } 
    if(NAMESPACES.equals(name))        
        {
            boolean varB94774236316EE50DC294BB6C9D2E16B_1184371343 = (isNamespaceAware());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939941321 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_939941321;
        } 
        else
    if(VALIDATION.equals(name))        
        {
            boolean varFA288071F5211BA94CE228424C0EAD8B_1610418526 = (isValidating());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157133921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_157133921;
        } 
        else
        {
            ParserConfigurationException var7A8A9BD806152DF4EA81815776F904CD_746885393 = new ParserConfigurationException(name);
            var7A8A9BD806152DF4EA81815776F904CD_746885393.addTaint(taint);
            throw var7A8A9BD806152DF4EA81815776F904CD_746885393;
        } 
        
        
            
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.972 -0400", hash_original_method = "02EA7BC2BA423DC2D4E19D42E2725988", hash_generated_method = "D2A875965377D52EFAFFAF249E1D16A5")
    @Override
    public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
    if(isValidating())        
        {
            ParserConfigurationException var634C2F9400942A1BE03A4C85C83F3B9D_1253866011 = new ParserConfigurationException(
                    "No validating DocumentBuilder implementation available");
            var634C2F9400942A1BE03A4C85C83F3B9D_1253866011.addTaint(taint);
            throw var634C2F9400942A1BE03A4C85C83F3B9D_1253866011;
        } 
        DocumentBuilderImpl builder = new DocumentBuilderImpl();
        builder.setCoalescing(isCoalescing());
        builder.setIgnoreComments(isIgnoringComments());
        builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        builder.setNamespaceAware(isNamespaceAware());
DocumentBuilder varFD34A536430ED6812E338CBCF7B883AA_312149181 =         builder;
        varFD34A536430ED6812E338CBCF7B883AA_312149181.addTaint(taint);
        return varFD34A536430ED6812E338CBCF7B883AA_312149181;
        
        
            
                    
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.972 -0400", hash_original_method = "0A4757F3D6B7A1DEAD03596DF47811E0", hash_generated_method = "6DFA4850F68396B9E2C586233D4BC137")
    @Override
    public void setAttribute(String name, Object value) throws IllegalArgumentException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_1521687211 = new IllegalArgumentException(name);
        varBF6A5C454ED01F0F986515C3E9A9CEA3_1521687211.addTaint(taint);
        throw varBF6A5C454ED01F0F986515C3E9A9CEA3_1521687211;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.972 -0400", hash_original_method = "C59D3A431C1BE604F6A4E910499EE08A", hash_generated_method = "65874C4DEE948F81CDD71D046564E92B")
    @Override
    public void setFeature(String name, boolean value) throws ParserConfigurationException {
        addTaint(value);
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_230445387 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_230445387.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_230445387;
        } 
    if(NAMESPACES.equals(name))        
        {
            setNamespaceAware(value);
        } 
        else
    if(VALIDATION.equals(name))        
        {
            setValidating(value);
        } 
        else
        {
            ParserConfigurationException var7A8A9BD806152DF4EA81815776F904CD_264515239 = new ParserConfigurationException(name);
            var7A8A9BD806152DF4EA81815776F904CD_264515239.addTaint(taint);
            throw var7A8A9BD806152DF4EA81815776F904CD_264515239;
        } 
        
        
            
        
        
            
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.973 -0400", hash_original_field = "57DAABD72ED77A96967246F7788B1447", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")

    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.973 -0400", hash_original_field = "1A6983F26F9A43F675933304E11A084C", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")

    private static final String VALIDATION = "http://xml.org/sax/features/validation";
}

