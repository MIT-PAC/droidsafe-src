package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;






public class DocumentBuilderFactoryImpl extends DocumentBuilderFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.725 -0400", hash_original_method = "CAFBFE87DB9B664F26C15EE0CE72FE04", hash_generated_method = "CAFBFE87DB9B664F26C15EE0CE72FE04")
    public DocumentBuilderFactoryImpl ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.725 -0400", hash_original_method = "ACE2451F013C7800286FF5717C2987CD", hash_generated_method = "E10CF80F2AF767616C1A8BF2C6962E11")
    @Override
    public Object getAttribute(String name) throws IllegalArgumentException {
        addTaint(name.getTaint());
        IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_958211117 = new IllegalArgumentException(name);
        varBF6A5C454ED01F0F986515C3E9A9CEA3_958211117.addTaint(taint);
        throw varBF6A5C454ED01F0F986515C3E9A9CEA3_958211117;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.726 -0400", hash_original_method = "64128D577B53B34B78055B7B7FC0B66E", hash_generated_method = "D3D628F3D6BA33E9745DB7A38776749C")
    @Override
    public boolean getFeature(String name) throws ParserConfigurationException {
        addTaint(name.getTaint());
        if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_326886967 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_326886967.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_326886967;
        } //End block
        if(NAMESPACES.equals(name))        
        {
            boolean varB94774236316EE50DC294BB6C9D2E16B_359574687 = (isNamespaceAware());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837416645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837416645;
        } //End block
        else
        if(VALIDATION.equals(name))        
        {
            boolean varFA288071F5211BA94CE228424C0EAD8B_1863442994 = (isValidating());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042400370 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042400370;
        } //End block
        else
        {
            ParserConfigurationException var7A8A9BD806152DF4EA81815776F904CD_1397581283 = new ParserConfigurationException(name);
            var7A8A9BD806152DF4EA81815776F904CD_1397581283.addTaint(taint);
            throw var7A8A9BD806152DF4EA81815776F904CD_1397581283;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (NAMESPACES.equals(name)) {
            //return isNamespaceAware();
        //} else if (VALIDATION.equals(name)) {
            //return isValidating();
        //} else {
            //throw new ParserConfigurationException(name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.727 -0400", hash_original_method = "02EA7BC2BA423DC2D4E19D42E2725988", hash_generated_method = "D8648CC68455FF50147BB94517BD2E4D")
    @Override
    public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        if(isValidating())        
        {
            ParserConfigurationException var634C2F9400942A1BE03A4C85C83F3B9D_255205897 = new ParserConfigurationException(
                    "No validating DocumentBuilder implementation available");
            var634C2F9400942A1BE03A4C85C83F3B9D_255205897.addTaint(taint);
            throw var634C2F9400942A1BE03A4C85C83F3B9D_255205897;
        } //End block
        DocumentBuilderImpl builder = new DocumentBuilderImpl();
        builder.setCoalescing(isCoalescing());
        builder.setIgnoreComments(isIgnoringComments());
        builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        builder.setNamespaceAware(isNamespaceAware());
DocumentBuilder varFD34A536430ED6812E338CBCF7B883AA_683773113 =         builder;
        varFD34A536430ED6812E338CBCF7B883AA_683773113.addTaint(taint);
        return varFD34A536430ED6812E338CBCF7B883AA_683773113;
        // ---------- Original Method ----------
        //if (isValidating()) {
            //throw new ParserConfigurationException(
                    //"No validating DocumentBuilder implementation available");
        //}
        //DocumentBuilderImpl builder = new DocumentBuilderImpl();
        //builder.setCoalescing(isCoalescing());
        //builder.setIgnoreComments(isIgnoringComments());
        //builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        //builder.setNamespaceAware(isNamespaceAware());
        //return builder;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.728 -0400", hash_original_method = "0A4757F3D6B7A1DEAD03596DF47811E0", hash_generated_method = "8B08190257BD1D4820E27F4E78D955FD")
    @Override
    public void setAttribute(String name, Object value) throws IllegalArgumentException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_1222953797 = new IllegalArgumentException(name);
        varBF6A5C454ED01F0F986515C3E9A9CEA3_1222953797.addTaint(taint);
        throw varBF6A5C454ED01F0F986515C3E9A9CEA3_1222953797;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.729 -0400", hash_original_method = "C59D3A431C1BE604F6A4E910499EE08A", hash_generated_method = "E4C97D94E57619A2EC092041463F7AD0")
    @Override
    public void setFeature(String name, boolean value) throws ParserConfigurationException {
        addTaint(value);
        addTaint(name.getTaint());
        if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_9686595 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_9686595.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_9686595;
        } //End block
        if(NAMESPACES.equals(name))        
        {
            setNamespaceAware(value);
        } //End block
        else
        if(VALIDATION.equals(name))        
        {
            setValidating(value);
        } //End block
        else
        {
            ParserConfigurationException var7A8A9BD806152DF4EA81815776F904CD_756658711 = new ParserConfigurationException(name);
            var7A8A9BD806152DF4EA81815776F904CD_756658711.addTaint(taint);
            throw var7A8A9BD806152DF4EA81815776F904CD_756658711;
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (NAMESPACES.equals(name)) {
            //setNamespaceAware(value);
        //} else if (VALIDATION.equals(name)) {
            //setValidating(value);
        //} else {
            //throw new ParserConfigurationException(name);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.729 -0400", hash_original_field = "57DAABD72ED77A96967246F7788B1447", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")

    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.729 -0400", hash_original_field = "1A6983F26F9A43F675933304E11A084C", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")

    private static final String VALIDATION = "http://xml.org/sax/features/validation";
}

