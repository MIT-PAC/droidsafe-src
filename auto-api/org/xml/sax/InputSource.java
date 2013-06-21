package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.io.Reader;

public class InputSource {
    private String publicId;
    private String systemId;
    private InputStream byteStream;
    private String encoding;
    private Reader characterStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.412 -0400", hash_original_method = "ECF04DED512C86950B6E52F582DBB4DE", hash_generated_method = "179D2E0E4F762DB57C25831D6BADEBE2")
    @DSModeled(DSC.SAFE)
    public InputSource() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.413 -0400", hash_original_method = "7919F547FCB87899F58CF069384E6AAD", hash_generated_method = "BB4568B9E93602AD3D665188404FC5A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputSource(String systemId) {
        dsTaint.addTaint(systemId);
        setSystemId(systemId);
        // ---------- Original Method ----------
        //setSystemId(systemId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.413 -0400", hash_original_method = "7C3B72CDCF95023F438211CC038E601E", hash_generated_method = "60BBA91BB534B942EB1EE0928BBDB417")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputSource(InputStream byteStream) {
        dsTaint.addTaint(byteStream.dsTaint);
        setByteStream(byteStream);
        // ---------- Original Method ----------
        //setByteStream(byteStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.413 -0400", hash_original_method = "F589E4069755916CEDC29D447D78E1F5", hash_generated_method = "DE28031F0C4EE3D50B5BEE8427A971CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputSource(Reader characterStream) {
        dsTaint.addTaint(characterStream.dsTaint);
        setCharacterStream(characterStream);
        // ---------- Original Method ----------
        //setCharacterStream(characterStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.413 -0400", hash_original_method = "0C418225BFB03C04E3636F3891B47A3E", hash_generated_method = "A63FB664BFF43757802E46F09831E67B")
    @DSModeled(DSC.SAFE)
    public void setPublicId(String publicId) {
        dsTaint.addTaint(publicId);
        // ---------- Original Method ----------
        //this.publicId = publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.413 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "80E14D34056E183CC70BFA8E6AC62A29")
    @DSModeled(DSC.SAFE)
    public String getPublicId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.414 -0400", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "CA0D92AF74DF0B83297874E289017F25")
    @DSModeled(DSC.SAFE)
    public void setSystemId(String systemId) {
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.systemId = systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.414 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "A23C365E1375B215042F45D99272D5FD")
    @DSModeled(DSC.SAFE)
    public String getSystemId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.414 -0400", hash_original_method = "E15E53FA80250CBE7F24584A185B9018", hash_generated_method = "E9640E0C6E8A309B61883BEF9C3CC06E")
    @DSModeled(DSC.SAFE)
    public void setByteStream(InputStream byteStream) {
        dsTaint.addTaint(byteStream.dsTaint);
        // ---------- Original Method ----------
        //this.byteStream = byteStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.414 -0400", hash_original_method = "831A861201E96F794D74C2B24BAB3555", hash_generated_method = "E50636A5CB8AF3C1F93436FF4BCA4B6D")
    @DSModeled(DSC.SAFE)
    public InputStream getByteStream() {
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.414 -0400", hash_original_method = "109F4EE072FF4A68A1B686347AFE92DB", hash_generated_method = "27156723D1E3FA1BA675915616B1D20A")
    @DSModeled(DSC.SAFE)
    public void setEncoding(String encoding) {
        dsTaint.addTaint(encoding);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.415 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "CBEFCA9969C56A89ACF5940A8F5F0AD9")
    @DSModeled(DSC.SAFE)
    public String getEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.415 -0400", hash_original_method = "079C1AFEC48E7E3C6462740060167438", hash_generated_method = "001C942FB671CF37380ED25EA05CB6A0")
    @DSModeled(DSC.SAFE)
    public void setCharacterStream(Reader characterStream) {
        dsTaint.addTaint(characterStream.dsTaint);
        // ---------- Original Method ----------
        //this.characterStream = characterStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.415 -0400", hash_original_method = "420D22C3C623A59BA758E1AC6387B142", hash_generated_method = "75287713F86A4BEBB055539543B02282")
    @DSModeled(DSC.SAFE)
    public Reader getCharacterStream() {
        return (Reader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return characterStream;
    }

    
}

