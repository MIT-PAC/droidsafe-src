package javax.xml.transform.stream;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import javax.xml.transform.Result;

public class StreamResult implements Result {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.047 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.047 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.047 -0400", hash_original_field = "A82FEEE3CC1AF8BCABDA979E8775EF0F", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")

    private Writer writer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.047 -0400", hash_original_method = "C19C2736EBF8CAB01BA3786E202D7316", hash_generated_method = "F31287276C2A464F5FF68A1022DE3F68")
    public  StreamResult() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.047 -0400", hash_original_method = "44ABD7B5C901E57BDC7AEA5540DA591C", hash_generated_method = "4A65693D6764EC5801047B01F61D5AEE")
    public  StreamResult(OutputStream outputStream) {
        setOutputStream(outputStream);
        addTaint(outputStream.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.047 -0400", hash_original_method = "4C7FF3D19CAA5E8142F763BAEAB400A6", hash_generated_method = "C5CF7638430410B69954952E8FDC2C54")
    public  StreamResult(Writer writer) {
        setWriter(writer);
        addTaint(writer.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.048 -0400", hash_original_method = "CE70A50578573A39D0EE1A321E1352B9", hash_generated_method = "6596525B6F4518BD897D217812ABED11")
    public  StreamResult(String systemId) {
        this.systemId = systemId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.048 -0400", hash_original_method = "69C6A757CEF52150252713CD9ECC25FB", hash_generated_method = "5908DE064EEBF9B4EC125EB60C53C536")
    public  StreamResult(File f) {
        setSystemId(f);
        addTaint(f.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.048 -0400", hash_original_method = "817A5A0ADE99B2865B232C517A9FCF0D", hash_generated_method = "F857F15E184B65891F5640F76C952DBE")
    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.048 -0400", hash_original_method = "05E68097FF3105B2AAABD34E89C7728F", hash_generated_method = "102EB8640192E00915BD71D5403A9EF2")
    public OutputStream getOutputStream() {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1884614436 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1884614436 = outputStream;
        varB4EAC82CA7396A68D541C85D26508E83_1884614436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1884614436;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.049 -0400", hash_original_method = "5911383E76829BA237C0C98FFA879183", hash_generated_method = "5A42584FF7D14E5EEE57ABF668EF394C")
    public void setWriter(Writer writer) {
        this.writer = writer;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.049 -0400", hash_original_method = "F0F74844AEEC9ABE14D7628D5DF26AE9", hash_generated_method = "BBA1AC37DBABF8504B2E299E3019DD9E")
    public Writer getWriter() {
        Writer varB4EAC82CA7396A68D541C85D26508E83_2110064569 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2110064569 = writer;
        varB4EAC82CA7396A68D541C85D26508E83_2110064569.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2110064569;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.049 -0400", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "DE20300D341EFA9D9888E5637810608B")
    public void setSystemId(String systemId) {
        this.systemId = systemId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.049 -0400", hash_original_method = "30231F16AB3AB378740EA121A3BAEA6C", hash_generated_method = "15625C9663782FB88EBA4526C2B24DF7")
    public void setSystemId(File f) {
        this.systemId = FilePathToURI.filepath2URI(f.getAbsolutePath());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.050 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "0392CFFB14BF527ADFCD313DB58D3F72")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1379588557 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1379588557 = systemId;
        varB4EAC82CA7396A68D541C85D26508E83_1379588557.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1379588557;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:19.050 -0400", hash_original_field = "EF3598A92D05D704F96EBDDC1EE5A12C", hash_generated_field = "07B41A84AEB1C38AEE0632EF7AA4850C")

    public static final String FEATURE =
        "http://javax.xml.transform.stream.StreamResult/feature";
}

