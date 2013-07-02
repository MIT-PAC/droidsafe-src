package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;

public class PUserDatabase extends gov.nist.javax.sip.header.ParametersHeader implements PUserDatabaseHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.405 -0400", hash_original_field = "F618483EEF4956A817EFB2CA268621CA", hash_generated_field = "86C05D139AEEDD5C16FB836B4667558E")

    private String databaseName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.405 -0400", hash_original_method = "7F14AD9E055B0EDA573715DABAF69E4A", hash_generated_method = "D92B52698CB02D38DCC6FEC6BDD40EC8")
    public  PUserDatabase(String databaseName) {
        super(NAME);
        this.databaseName = databaseName;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.406 -0400", hash_original_method = "E39FCB193BD9E02D223AAEA09A512240", hash_generated_method = "7ADBEBC1D5F5E2626F7290454A00780A")
    public  PUserDatabase() {
        super(P_USER_DATABASE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.407 -0400", hash_original_method = "1786B1376B4CD3FEAEBCAB28A560C6C6", hash_generated_method = "B9EB4E984EFBCABC4D00022C782DEEB0")
    public String getDatabaseName() {
        String varB4EAC82CA7396A68D541C85D26508E83_211129604 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_211129604 = this.databaseName;
        varB4EAC82CA7396A68D541C85D26508E83_211129604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_211129604;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.408 -0400", hash_original_method = "D51F20AACD3B656F6DA8A7AF0FAAC017", hash_generated_method = "89E00AB5C60CFC75FBC397012086BA04")
    public void setDatabaseName(String databaseName) {
        {
            boolean var6F885EEACD664FF487C08E325F655CE7_727599562 = ((databaseName==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
            {
                boolean varE80BF1BFB6096183B0C913A4D14DBC6F_28385024 = (!databaseName.contains("aaa://"));
                this.databaseName = new StringBuffer().append("aaa://").append(databaseName).toString();
                this.databaseName = databaseName;
            } 
        } 
        
        
            
        
            
        
            
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.408 -0400", hash_original_method = "C5A419AE4F54D4DB306D1B917A489A39", hash_generated_method = "C33B0AC44E3C9B672A5F9E80405FE176")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_848138425 = null; 
        StringBuffer retval = new StringBuffer();
        retval.append("<");
        {
            boolean varA9B2934EF83AB045E2C5BEB25251AC8C_1618279855 = (getDatabaseName()!=null);
            retval.append(getDatabaseName());
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_155280661 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } 
        retval.append(">");
        varB4EAC82CA7396A68D541C85D26508E83_848138425 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_848138425.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_848138425;
        
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.409 -0400", hash_original_method = "E720B3A09C72EF9AD917691C9271EB0A", hash_generated_method = "A75A421B73A285296FE263AC581E9CD2")
    public boolean equals(Object other) {
        boolean varB67670436F072ACD0F3C6E986BAF90AF_2070612849 = ((other instanceof PUserDatabaseHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28580318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_28580318;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.409 -0400", hash_original_method = "0C530D20B34B6FA1A3EDDB9B09D02FD1", hash_generated_method = "77F79CFE6A0B4BDDC84C413A557BC40F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_929500894 = null; 
        PUserDatabase retval = (PUserDatabase) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_929500894 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_929500894.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_929500894;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.409 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
}

