package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.Reader;






public class InputSource {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.201 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.201 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.201 -0400", hash_original_field = "04C58E7EA9C250FD95881822011BDF22", hash_generated_field = "F48D8933D1E0CC3DCA366E513A5A0250")

    private InputStream byteStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.201 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.201 -0400", hash_original_field = "537EB9017301361716D8F0B0A9C21991", hash_generated_field = "063FD46ACCBF055B33EB5A7725463DCE")

    private Reader characterStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.201 -0400", hash_original_method = "ECF04DED512C86950B6E52F582DBB4DE", hash_generated_method = "179D2E0E4F762DB57C25831D6BADEBE2")
    public  InputSource() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.202 -0400", hash_original_method = "7919F547FCB87899F58CF069384E6AAD", hash_generated_method = "5C8DC55271245F54C5895098E7D088D2")
    public  InputSource(String systemId) {
        addTaint(systemId.getTaint());
        setSystemId(systemId);
        // ---------- Original Method ----------
        //setSystemId(systemId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.202 -0400", hash_original_method = "7C3B72CDCF95023F438211CC038E601E", hash_generated_method = "EFF5430C840A38D076B7A7F747401349")
    public  InputSource(InputStream byteStream) {
        addTaint(byteStream.getTaint());
        setByteStream(byteStream);
        // ---------- Original Method ----------
        //setByteStream(byteStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.202 -0400", hash_original_method = "F589E4069755916CEDC29D447D78E1F5", hash_generated_method = "74EB651189824C5FFF175F27ABA62352")
    public  InputSource(Reader characterStream) {
        addTaint(characterStream.getTaint());
        setCharacterStream(characterStream);
        // ---------- Original Method ----------
        //setCharacterStream(characterStream);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.203 -0400", hash_original_method = "0C418225BFB03C04E3636F3891B47A3E", hash_generated_method = "784431903087FA4FFEF9763F16480709")
    public void setPublicId(String publicId) {
        this.publicId = publicId;
        // ---------- Original Method ----------
        //this.publicId = publicId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.203 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "BF78659BC6D8C59129BF6F4D8D6FB0E3")
    public String getPublicId() {
String var76991CCBEF027A0871CF61642EBA53AB_13959332 =         publicId;
        var76991CCBEF027A0871CF61642EBA53AB_13959332.addTaint(taint);
        return var76991CCBEF027A0871CF61642EBA53AB_13959332;
        // ---------- Original Method ----------
        //return publicId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.204 -0400", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "DE20300D341EFA9D9888E5637810608B")
    public void setSystemId(String systemId) {
        this.systemId = systemId;
        // ---------- Original Method ----------
        //this.systemId = systemId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.204 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "A9A32ED526C3E008AE355DB9E6675566")
    public String getSystemId() {
String varB7D0727ACC7388EA86587212DD1C6E9F_730257358 =         systemId;
        varB7D0727ACC7388EA86587212DD1C6E9F_730257358.addTaint(taint);
        return varB7D0727ACC7388EA86587212DD1C6E9F_730257358;
        // ---------- Original Method ----------
        //return systemId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.205 -0400", hash_original_method = "E15E53FA80250CBE7F24584A185B9018", hash_generated_method = "B841545B8F2C566C639881C15FF48B83")
    public void setByteStream(InputStream byteStream) {
        this.byteStream = byteStream;
        // ---------- Original Method ----------
        //this.byteStream = byteStream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.206 -0400", hash_original_method = "831A861201E96F794D74C2B24BAB3555", hash_generated_method = "4FB830C69F54580B73DDFBB9B6411A81")
    public InputStream getByteStream() {
InputStream var5991B75FB36D48D1B405290D28A5B1D9_1461890710 =         byteStream;
        var5991B75FB36D48D1B405290D28A5B1D9_1461890710.addTaint(taint);
        return var5991B75FB36D48D1B405290D28A5B1D9_1461890710;
        // ---------- Original Method ----------
        //return byteStream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.206 -0400", hash_original_method = "109F4EE072FF4A68A1B686347AFE92DB", hash_generated_method = "7E8E9F5581B45D04B721857DE5AE6090")
    public void setEncoding(String encoding) {
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.207 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "B1280A564B513E5E7AD8286B62C5313F")
    public String getEncoding() {
String varE424DD5E6E58EB63E1272B71B5A81966_1490574975 =         encoding;
        varE424DD5E6E58EB63E1272B71B5A81966_1490574975.addTaint(taint);
        return varE424DD5E6E58EB63E1272B71B5A81966_1490574975;
        // ---------- Original Method ----------
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.207 -0400", hash_original_method = "079C1AFEC48E7E3C6462740060167438", hash_generated_method = "81D26BAB949E3D4C89EA05FA577F07A9")
    public void setCharacterStream(Reader characterStream) {
        this.characterStream = characterStream;
        // ---------- Original Method ----------
        //this.characterStream = characterStream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.207 -0400", hash_original_method = "420D22C3C623A59BA758E1AC6387B142", hash_generated_method = "E0EB0F1E8DA27AA34AC4A415E040F7BC")
    public Reader getCharacterStream() {
Reader var5F7C051DCFB839DE58097C10207CC6DF_439445146 =         characterStream;
        var5F7C051DCFB839DE58097C10207CC6DF_439445146.addTaint(taint);
        return var5F7C051DCFB839DE58097C10207CC6DF_439445146;
        // ---------- Original Method ----------
        //return characterStream;
    }

    
}

