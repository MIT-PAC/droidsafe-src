package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
public class EntityTemplate extends AbstractHttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.296 -0400", hash_original_field = "D93F8685D89CD76B2E36E2C6C779666B", hash_generated_field = "A99FB28A10897E24D1BB65A3EC202A4B")

    private ContentProducer contentproducer;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.312 -0400", hash_original_method = "00598D1ACBA1C09EA0328079C62636B7", hash_generated_method = "79F09046A3D96974F32D8B05D7CE1B05")
    public  EntityTemplate(final ContentProducer contentproducer) {
        super();
        if(contentproducer == null)        
        {
            IllegalArgumentException varA79910EDA633CBA128F0505D0494F5C5_1143405818 = new IllegalArgumentException("Content producer may not be null");
            varA79910EDA633CBA128F0505D0494F5C5_1143405818.addTaint(taint);
            throw varA79910EDA633CBA128F0505D0494F5C5_1143405818;
        } //End block
        this.contentproducer = contentproducer;
        // ---------- Original Method ----------
        //if (contentproducer == null) {
            //throw new IllegalArgumentException("Content producer may not be null");
        //}
        //this.contentproducer = contentproducer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.320 -0400", hash_original_method = "8F3921A7A9D3B2470F819E16ABC2318F", hash_generated_method = "2704C9453BA0617EB5494BF309C17387")
    public long getContentLength() {
        long var6BB61E3B7BCE0931DA574D19D1D82C88_256295208 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1236230744 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1236230744;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.325 -0400", hash_original_method = "34C97105122275A5F1AFAA7197ED4E75", hash_generated_method = "D97C33DE31C3A908AFE6F77B2588AD9B")
    public InputStream getContent() {
        UnsupportedOperationException varC15D6188EC356B035AD71FA8D395C521_2139217435 = new UnsupportedOperationException("Entity template does not implement getContent()");
        varC15D6188EC356B035AD71FA8D395C521_2139217435.addTaint(taint);
        throw varC15D6188EC356B035AD71FA8D395C521_2139217435;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Entity template does not implement getContent()");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.342 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "C926FC83130E99F8D0856FFD01C73F26")
    public boolean isRepeatable() {
        boolean varB326B5062B2F0E69046810717534CB09_2049332506 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400324719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400324719;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.349 -0400", hash_original_method = "592FE25978346EDEF8B202F993477346", hash_generated_method = "7CD6692EAED64A757D52FA0DE2A60B87")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_11578375 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_11578375.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_11578375;
        } //End block
        this.contentproducer.writeTo(outstream);
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //this.contentproducer.writeTo(outstream);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.356 -0400", hash_original_method = "06CB3F2A2C5EF7DDBC28F65520517EC2", hash_generated_method = "780AEFC6792CBF8EC9169D29FC57BE0B")
    public boolean isStreaming() {
        boolean varB326B5062B2F0E69046810717534CB09_2134093902 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1862953920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1862953920;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:12:15.360 -0400", hash_original_method = "62C2D9F9627B879E4D265B8DAE26FBD7", hash_generated_method = "D0DDF27E035FF4F036F0599FD4E804DB")
    public void consumeContent() throws IOException {
        // ---------- Original Method ----------
    }

    
}

