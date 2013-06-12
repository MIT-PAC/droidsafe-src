package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.InputStream;
import java.io.Reader;

public class InputSource {
    private String publicId;
    private String systemId;
    private InputStream byteStream;
    private String encoding;
    private Reader characterStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "ECF04DED512C86950B6E52F582DBB4DE", hash_generated_method = "43D3D24E201E636C61DC4D04537A1631")
    @DSModeled(DSC.SAFE)
    public InputSource() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "7919F547FCB87899F58CF069384E6AAD", hash_generated_method = "85F8AC17DC9760CC52DE0B4D20D56442")
    @DSModeled(DSC.SAFE)
    public InputSource(String systemId) {
        dsTaint.addTaint(systemId);
        setSystemId(systemId);
        // ---------- Original Method ----------
        //setSystemId(systemId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "7C3B72CDCF95023F438211CC038E601E", hash_generated_method = "00A8B3FCF0BEFA77C4C931C9662EAEDB")
    @DSModeled(DSC.SAFE)
    public InputSource(InputStream byteStream) {
        dsTaint.addTaint(byteStream.dsTaint);
        setByteStream(byteStream);
        // ---------- Original Method ----------
        //setByteStream(byteStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "F589E4069755916CEDC29D447D78E1F5", hash_generated_method = "EC9044F58300D4C0535AF2BF2BD041F6")
    @DSModeled(DSC.SAFE)
    public InputSource(Reader characterStream) {
        dsTaint.addTaint(characterStream.dsTaint);
        setCharacterStream(characterStream);
        // ---------- Original Method ----------
        //setCharacterStream(characterStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "0C418225BFB03C04E3636F3891B47A3E", hash_generated_method = "4E7146FBEBB06ED988760E8544E754CA")
    @DSModeled(DSC.SAFE)
    public void setPublicId(String publicId) {
        dsTaint.addTaint(publicId);
        // ---------- Original Method ----------
        //this.publicId = publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "7C29F0C6DC4E298965F868DC34008C67")
    @DSModeled(DSC.SAFE)
    public String getPublicId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "A0E2D8CB00AF551A50C3F8763A1E1CDB")
    @DSModeled(DSC.SAFE)
    public void setSystemId(String systemId) {
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.systemId = systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6EF27482968D634EC06A5CE842D09947")
    @DSModeled(DSC.SAFE)
    public String getSystemId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "E15E53FA80250CBE7F24584A185B9018", hash_generated_method = "93FE9133342217D1EB151E07944A671B")
    @DSModeled(DSC.SAFE)
    public void setByteStream(InputStream byteStream) {
        dsTaint.addTaint(byteStream.dsTaint);
        // ---------- Original Method ----------
        //this.byteStream = byteStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "831A861201E96F794D74C2B24BAB3555", hash_generated_method = "5B294BB62C265362CFDA82D4F15407B1")
    @DSModeled(DSC.SAFE)
    public InputStream getByteStream() {
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "109F4EE072FF4A68A1B686347AFE92DB", hash_generated_method = "EC1875A91083C01B81AE14EE21CA8B11")
    @DSModeled(DSC.SAFE)
    public void setEncoding(String encoding) {
        dsTaint.addTaint(encoding);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "D4B53047CB2B7D0B87000BF925D71E5E")
    @DSModeled(DSC.SAFE)
    public String getEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "079C1AFEC48E7E3C6462740060167438", hash_generated_method = "18D10E281F4CAF0426170010A4E7E0BF")
    @DSModeled(DSC.SAFE)
    public void setCharacterStream(Reader characterStream) {
        dsTaint.addTaint(characterStream.dsTaint);
        // ---------- Original Method ----------
        //this.characterStream = characterStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.163 -0400", hash_original_method = "420D22C3C623A59BA758E1AC6387B142", hash_generated_method = "EDDC1CE74AD341E9931D8EF010A34074")
    @DSModeled(DSC.SAFE)
    public Reader getCharacterStream() {
        return (Reader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return characterStream;
    }

    
}


