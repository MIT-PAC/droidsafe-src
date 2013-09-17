package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
public class SerializableEntity extends AbstractHttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.051 -0400", hash_original_field = "0C7F5A016B3B1C89ABA1EEE01324B93F", hash_generated_field = "5E992B0B880ECD381D3DDEA22743FFE2")

    private byte[] objSer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.055 -0400", hash_original_field = "D789823643AC9B7BC53B6709F5EC7EE4", hash_generated_field = "DEF28E95A6CF8B60225389E7AE432494")

    private Serializable objRef;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.071 -0400", hash_original_method = "50E1D3F23CF8DFFC0168609829D105B6", hash_generated_method = "CC790117AFC1098AE25819503507506E")
    public  SerializableEntity(Serializable ser, boolean bufferize) throws IOException {
        super();
        addTaint(bufferize);
        if(ser == null)        
        {
            IllegalArgumentException var97B658ADFF944A5E479AB71D6A600CD3_223155298 = new IllegalArgumentException("Source object may not be null");
            var97B658ADFF944A5E479AB71D6A600CD3_223155298.addTaint(taint);
            throw var97B658ADFF944A5E479AB71D6A600CD3_223155298;
        } //End block
        if(bufferize)        
        {
            createBytes(ser);
        } //End block
        else
        {
            this.objRef = ser;
        } //End block
        // ---------- Original Method ----------
        //if (ser == null) {
            //throw new IllegalArgumentException("Source object may not be null");
        //}
        //if (bufferize) {
            //createBytes(ser);
        //} else {
            //this.objRef = ser;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.085 -0400", hash_original_method = "F8F96B1EFE3C5408C7469562A006AE42", hash_generated_method = "ED0171A35DBF9248186C31FDCF036AEB")
    private void createBytes(Serializable ser) throws IOException {
        addTaint(ser.getTaint());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(ser);
        out.flush();
        this.objSer = baos.toByteArray();
        // ---------- Original Method ----------
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //ObjectOutputStream out = new ObjectOutputStream(baos);
        //out.writeObject(ser);
        //out.flush();
        //this.objSer = baos.toByteArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.094 -0400", hash_original_method = "41C62F9ED6209D6FC57675AB476C6A9C", hash_generated_method = "5332C65FFD0946D68BBA1CDE7E160106")
    public InputStream getContent() throws IOException, IllegalStateException {
        if(this.objSer == null)        
        {
            createBytes(this.objRef);
        } //End block
InputStream varBA2594AC0932FC011301640D8AAE566A_1712346750 =         new ByteArrayInputStream(this.objSer);
        varBA2594AC0932FC011301640D8AAE566A_1712346750.addTaint(taint);
        return varBA2594AC0932FC011301640D8AAE566A_1712346750;
        // ---------- Original Method ----------
        //if (this.objSer == null) {
            //createBytes(this.objRef);
        //}
        //return new ByteArrayInputStream(this.objSer);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.114 -0400", hash_original_method = "A561CA8D724D7AB3B72F0BCAFCE9F723", hash_generated_method = "0927FB1A12BEC486CCA8B53E9A3B0071")
    public long getContentLength() {
        if(this.objSer ==  null)        
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1290706853 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1361369499 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1361369499;
        } //End block
        else
        {
            long varAC87DA87EEFF34516B781CD8B282AF34_1372666375 = (this.objSer.length);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1853549478 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1853549478;
        } //End block
        // ---------- Original Method ----------
        //if (this.objSer ==  null) { 
            //return -1;
        //} else {
            //return this.objSer.length;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.122 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "C7BF62064AC22F11C989412D6BB9F400")
    public boolean isRepeatable() {
        boolean varB326B5062B2F0E69046810717534CB09_319856856 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014221897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014221897;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.128 -0400", hash_original_method = "4B9BA0750731747351E989E259D272E6", hash_generated_method = "52D24563054107D1A8DCE0ADE588667A")
    public boolean isStreaming() {
        boolean var2F07372A22433C8312BD15AFE25B19F6_1184994678 = (this.objSer == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1058666296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1058666296;
        // ---------- Original Method ----------
        //return this.objSer == null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 22:49:31.137 -0400", hash_original_method = "777BCC972B9546F96E8BA640E747E34D", hash_generated_method = "737D04E9AC3DD182574B86052329BD40")
    public void writeTo(OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_196474578 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_196474578.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_196474578;
        } //End block
        if(this.objSer == null)        
        {
            ObjectOutputStream out = new ObjectOutputStream(outstream);
            out.writeObject(this.objRef);
            out.flush();
        } //End block
        else
        {
            outstream.write(this.objSer);
            outstream.flush();
        } //End block
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //if (this.objSer == null) {
            //ObjectOutputStream out = new ObjectOutputStream(outstream);
            //out.writeObject(this.objRef);
            //out.flush();
        //} else {
            //outstream.write(this.objSer);
            //outstream.flush();
        //}
    }

    
}

