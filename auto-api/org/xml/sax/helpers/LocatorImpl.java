package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Locator;

public class LocatorImpl implements Locator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.180 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.181 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.181 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.181 -0400", hash_original_field = "9D2C17DB0A32EEAAF3B613AC483AEB6C", hash_generated_field = "26A7E6694FD33EFB482AC4BA7726E9A4")

    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.181 -0400", hash_original_method = "1944A965405A65742195C130B4EA39CD", hash_generated_method = "41C9F2F41F2C736A19B0FB99C5AC7CBE")
    public  LocatorImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.182 -0400", hash_original_method = "5648D7E11C6AEEB11BABA800E96BBFD7", hash_generated_method = "823222423003D5AD1BA1606718B46542")
    public  LocatorImpl(Locator locator) {
        setPublicId(locator.getPublicId());
        setSystemId(locator.getSystemId());
        setLineNumber(locator.getLineNumber());
        setColumnNumber(locator.getColumnNumber());
        addTaint(locator.getTaint());
        // ---------- Original Method ----------
        //setPublicId(locator.getPublicId());
        //setSystemId(locator.getSystemId());
        //setLineNumber(locator.getLineNumber());
        //setColumnNumber(locator.getColumnNumber());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.182 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "20182AF8FDB2A8465FA5744B297CAF28")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1489298788 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1489298788 = publicId;
        varB4EAC82CA7396A68D541C85D26508E83_1489298788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489298788;
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.186 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "A6C6223DC73D0186A36D71468812D73A")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1979786783 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1979786783 = systemId;
        varB4EAC82CA7396A68D541C85D26508E83_1979786783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1979786783;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.186 -0400", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "3D0474239E8C5EC4A57222BB6DA0D269")
    public int getLineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775710485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775710485;
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.186 -0400", hash_original_method = "50401770B079F9FC2B373BD150CB3B15", hash_generated_method = "98EC0A6EFD99ABE413E66BE0A13C7703")
    public int getColumnNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733894891 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733894891;
        // ---------- Original Method ----------
        //return columnNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.187 -0400", hash_original_method = "0C418225BFB03C04E3636F3891B47A3E", hash_generated_method = "784431903087FA4FFEF9763F16480709")
    public void setPublicId(String publicId) {
        this.publicId = publicId;
        // ---------- Original Method ----------
        //this.publicId = publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.189 -0400", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "DE20300D341EFA9D9888E5637810608B")
    public void setSystemId(String systemId) {
        this.systemId = systemId;
        // ---------- Original Method ----------
        //this.systemId = systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.204 -0400", hash_original_method = "57105994EF91DD2584057988497ACBF5", hash_generated_method = "07212E907D790DC6F7BB6A6C3A61B057")
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
        // ---------- Original Method ----------
        //this.lineNumber = lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.204 -0400", hash_original_method = "4B7308C11003E2EBA4BF69C9D8266B60", hash_generated_method = "92DC60B83C9715659F4A09690400C6C8")
    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
        // ---------- Original Method ----------
        //this.columnNumber = columnNumber;
    }

    
}

