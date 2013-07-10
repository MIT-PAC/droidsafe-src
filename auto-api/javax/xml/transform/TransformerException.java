package javax.xml.transform;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class TransformerException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.961 -0400", hash_original_field = "AB1E07F86CA37C6521CC1969EE2AC6C9", hash_generated_field = "242C14456A521485BE94EFFE33D8EF15")

    SourceLocator locator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.961 -0400", hash_original_field = "666707D818022CC67C8A24390966B951", hash_generated_field = "FB75E61C44B34E5DCDC79855DF4646BE")

    Throwable containedException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.962 -0400", hash_original_method = "ABE089B555C0BBE77A7ADBD2839474AC", hash_generated_method = "E25E38F7449D8A85CF6494F84473C4E8")
    public  TransformerException(String message) {
        super(message);
        this.containedException = null;
        this.locator            = null;
        addTaint(message.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.962 -0400", hash_original_method = "BCE7B8322CC2320F24F40E1C57B1D6A6", hash_generated_method = "6B6F250FA67E31550203926FF836ECDC")
    public  TransformerException(Throwable e) {
        super(e.toString());
        this.containedException = e;
        this.locator            = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.962 -0400", hash_original_method = "D45FC511BA6A923B19FFB66FC049AAEB", hash_generated_method = "02D43C0206009C96612E3A256C6D49E9")
    public  TransformerException(String message, Throwable e) {
        super(((message == null) || (message.length() == 0))
              ? e.toString()
              : message);
        this.containedException = e;
        this.locator            = null;
        addTaint(message.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.963 -0400", hash_original_method = "DD07B7FCC3EF7EDD2CCAD748CE266263", hash_generated_method = "D4AC2AB4A397BED69D05BF0034465BB6")
    public  TransformerException(String message, SourceLocator locator) {
        super(message);
        this.containedException = null;
        this.locator            = locator;
        addTaint(message.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.963 -0400", hash_original_method = "48CCF75E307E890A227C0CAEA85C6D48", hash_generated_method = "DF47D73B462BBA9715D7F826F815F8C2")
    public  TransformerException(String message, SourceLocator locator,
                                Throwable e) {
        super(message);
        this.containedException = e;
        this.locator            = locator;
        addTaint(message.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.963 -0400", hash_original_method = "78CCEDF93B9D36FA2F4D6EE8483F521D", hash_generated_method = "33ECC7045678AC73E7DC4B067DE59ACA")
    public SourceLocator getLocator() {
        SourceLocator varB4EAC82CA7396A68D541C85D26508E83_1909750926 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1909750926 = locator;
        varB4EAC82CA7396A68D541C85D26508E83_1909750926.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1909750926;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.964 -0400", hash_original_method = "2730D26302DDFE02DFC9B94C57BA2229", hash_generated_method = "3A60D6D9C48F9C8CC784DDE0EBAB1BA2")
    public void setLocator(SourceLocator location) {
        locator = location;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.964 -0400", hash_original_method = "4E3501B9804FC98D0826FF297E292112", hash_generated_method = "444BB89EEBBB682E2C3B3D7E6ABB605E")
    public Throwable getException() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1373795111 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1373795111 = containedException;
        varB4EAC82CA7396A68D541C85D26508E83_1373795111.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1373795111;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.964 -0400", hash_original_method = "CFB99AF15EF81FE883309E381BCDFD32", hash_generated_method = "1E8EDD4CC618E02021FC268FDFB036E7")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_253156563 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_253156563 = ((containedException == this)
                ? null
                : containedException);
        varB4EAC82CA7396A68D541C85D26508E83_253156563.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_253156563;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.965 -0400", hash_original_method = "480EED18E1765067FE991AF0B4A8D2D9", hash_generated_method = "27B3A02FD0A515001E8B6D244C1F1BBD")
    public synchronized Throwable initCause(Throwable cause) {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_299589538 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't overwrite cause");
        } 
        {
            boolean var974C88151AE5388A12E2F75475C2D5B4_827586782 = (cause == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Self-causation not permitted");
            } 
        } 
        this.containedException = cause;
        varB4EAC82CA7396A68D541C85D26508E83_299589538 = this;
        varB4EAC82CA7396A68D541C85D26508E83_299589538.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_299589538;
        
        
            
        
        
            
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.966 -0400", hash_original_method = "5F0314D1FF4AABD6580ED0D63B1DE248", hash_generated_method = "1D4D6E10BE3697848094F47791069CC9")
    public String getMessageAndLocation() {
        String varB4EAC82CA7396A68D541C85D26508E83_1348509574 = null; 
        StringBuilder sbuffer = new StringBuilder();
        String message = super.getMessage();
        {
            sbuffer.append(message);
        } 
        {
            String systemID = locator.getSystemId();
            int line = locator.getLineNumber();
            int column = locator.getColumnNumber();
            {
                sbuffer.append("; SystemID: ");
                sbuffer.append(systemID);
            } 
            {
                sbuffer.append("; Line#: ");
                sbuffer.append(line);
            } 
            {
                sbuffer.append("; Column#: ");
                sbuffer.append(column);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1348509574 = sbuffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1348509574.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1348509574;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.966 -0400", hash_original_method = "066E0A6F600039820661DC1AB443CC5D", hash_generated_method = "C15532D0686B4C98EC71394E63D1F435")
    public String getLocationAsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1002816948 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1602785078 = null; 
        {
            StringBuilder sbuffer = new StringBuilder();
            String systemID = locator.getSystemId();
            int line = locator.getLineNumber();
            int column = locator.getColumnNumber();
            {
                sbuffer.append("; SystemID: ");
                sbuffer.append(systemID);
            } 
            {
                sbuffer.append("; Line#: ");
                sbuffer.append(line);
            } 
            {
                sbuffer.append("; Column#: ");
                sbuffer.append(column);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1002816948 = sbuffer.toString();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1602785078 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_925970245; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_925970245 = varB4EAC82CA7396A68D541C85D26508E83_1002816948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_925970245 = varB4EAC82CA7396A68D541C85D26508E83_1602785078;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_925970245.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_925970245;
        
        
            
            
            
            
            
                
                
            
            
                
                
            
            
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.967 -0400", hash_original_method = "BFEE5D773C8C1A637BA8549A5548CE5E", hash_generated_method = "5DE43A2AD9D57F579CB99E2DD2DEBB6F")
    public void printStackTrace() {
        printStackTrace(new java.io.PrintWriter(System.err, true));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.967 -0400", hash_original_method = "396FE4FDBD72A1A44CDA1D64A960A2B6", hash_generated_method = "173EF8E975CA82CE9E85AD7974FC0F51")
    public void printStackTrace(java.io.PrintStream s) {
        printStackTrace(new java.io.PrintWriter(s));
        addTaint(s.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.967 -0400", hash_original_method = "A67ED2D6F45381C31C2891A6F92AFBC4", hash_generated_method = "DECE0702BB51D0753A69DC31D86FE4C1")
    public void printStackTrace(java.io.PrintWriter s) {
        {
            s = new java.io.PrintWriter(System.err, true);
        } 
        try 
        {
            String locInfo = getLocationAsString();
            {
                s.println(locInfo);
            } 
            super.printStackTrace(s);
        } 
        catch (Throwable e)
        { }
        addTaint(s.getTaint());
        
        
            
        
        
            
            
                
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.967 -0400", hash_original_field = "CF11F5DB9FDEA42A11ADE0EBA3C62E0F", hash_generated_field = "FAB3AA9E21148B68815314C0C638BF27")

    private static final long serialVersionUID = 975798773772956428L;
}

