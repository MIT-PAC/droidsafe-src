package javax.xml.transform.stream;

// Droidsafe Imports
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

import javax.xml.transform.Result;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class StreamResult implements Result {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.173 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.173 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.173 -0400", hash_original_field = "A82FEEE3CC1AF8BCABDA979E8775EF0F", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")

    private Writer writer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.174 -0400", hash_original_method = "C19C2736EBF8CAB01BA3786E202D7316", hash_generated_method = "F31287276C2A464F5FF68A1022DE3F68")
    public  StreamResult() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.174 -0400", hash_original_method = "44ABD7B5C901E57BDC7AEA5540DA591C", hash_generated_method = "557196352779CF2E07FBAD9DF0588D49")
    public  StreamResult(OutputStream outputStream) {
        addTaint(outputStream.getTaint());
        setOutputStream(outputStream);
        // ---------- Original Method ----------
        //setOutputStream(outputStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.175 -0400", hash_original_method = "4C7FF3D19CAA5E8142F763BAEAB400A6", hash_generated_method = "4230E210F4FAC30E7BF77992BDC61E96")
    public  StreamResult(Writer writer) {
        addTaint(writer.getTaint());
        setWriter(writer);
        // ---------- Original Method ----------
        //setWriter(writer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.175 -0400", hash_original_method = "CE70A50578573A39D0EE1A321E1352B9", hash_generated_method = "6596525B6F4518BD897D217812ABED11")
    public  StreamResult(String systemId) {
        this.systemId = systemId;
        // ---------- Original Method ----------
        //this.systemId = systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.176 -0400", hash_original_method = "69C6A757CEF52150252713CD9ECC25FB", hash_generated_method = "9C9F5C34F9E65A26C367F805C3B95361")
    public  StreamResult(File f) {
        addTaint(f.getTaint());
        setSystemId(f);
        // ---------- Original Method ----------
        //setSystemId(f);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.177 -0400", hash_original_method = "817A5A0ADE99B2865B232C517A9FCF0D", hash_generated_method = "F857F15E184B65891F5640F76C952DBE")
    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        // ---------- Original Method ----------
        //this.outputStream = outputStream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.177 -0400", hash_original_method = "05E68097FF3105B2AAABD34E89C7728F", hash_generated_method = "B0CFA19F3B42A8F7B9376D70CD723D5D")
    public OutputStream getOutputStream() {
OutputStream var864D919353B9AF56DB2472A4EBA3E730_1842788045 =         outputStream;
        var864D919353B9AF56DB2472A4EBA3E730_1842788045.addTaint(taint);
        return var864D919353B9AF56DB2472A4EBA3E730_1842788045;
        // ---------- Original Method ----------
        //return outputStream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.178 -0400", hash_original_method = "5911383E76829BA237C0C98FFA879183", hash_generated_method = "5A42584FF7D14E5EEE57ABF668EF394C")
    public void setWriter(Writer writer) {
        this.writer = writer;
        // ---------- Original Method ----------
        //this.writer = writer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.179 -0400", hash_original_method = "F0F74844AEEC9ABE14D7628D5DF26AE9", hash_generated_method = "ED5077ED834D1BF423C63240AF652BF7")
    public Writer getWriter() {
Writer varF684C05FE6F21143B285791952B93F74_359198972 =         writer;
        varF684C05FE6F21143B285791952B93F74_359198972.addTaint(taint);
        return varF684C05FE6F21143B285791952B93F74_359198972;
        // ---------- Original Method ----------
        //return writer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.179 -0400", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "DE20300D341EFA9D9888E5637810608B")
    public void setSystemId(String systemId) {
        this.systemId = systemId;
        // ---------- Original Method ----------
        //this.systemId = systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.180 -0400", hash_original_method = "30231F16AB3AB378740EA121A3BAEA6C", hash_generated_method = "15625C9663782FB88EBA4526C2B24DF7")
    public void setSystemId(File f) {
        this.systemId = FilePathToURI.filepath2URI(f.getAbsolutePath());
        // ---------- Original Method ----------
        //this.systemId = FilePathToURI.filepath2URI(f.getAbsolutePath());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.180 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "2B6FF9BB038BE8599EA3299C963B3C66")
    public String getSystemId() {
String varB7D0727ACC7388EA86587212DD1C6E9F_875080041 =         systemId;
        varB7D0727ACC7388EA86587212DD1C6E9F_875080041.addTaint(taint);
        return varB7D0727ACC7388EA86587212DD1C6E9F_875080041;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.180 -0400", hash_original_field = "EF3598A92D05D704F96EBDDC1EE5A12C", hash_generated_field = "07B41A84AEB1C38AEE0632EF7AA4850C")

    public static final String FEATURE =
        "http://javax.xml.transform.stream.StreamResult/feature";
}

