package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

class KeyStoreHandler extends Handler {
    private ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    private String mMimeType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.443 -0400", hash_original_method = "587ABBBEDE647D3237F91706DA6610BD", hash_generated_method = "6CB27688692CA4F393020814838C58FA")
    @DSModeled(DSC.SAFE)
    public KeyStoreHandler(String mimeType) {
        dsTaint.addTaint(mimeType);
        // ---------- Original Method ----------
        //mMimeType = mimeType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.444 -0400", hash_original_method = "2DA424A8A87A21D10409F02AA8AEC0E6", hash_generated_method = "629FD542D844EA759D0C05E557C57D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void didReceiveData(byte[] data, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
        {
            mDataBuilder.append(data, 0, length);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mDataBuilder) {
            //mDataBuilder.append(data, 0, length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.445 -0400", hash_original_method = "736EF2EF4199424B0094A77A85DC708B", hash_generated_method = "BC9AA8062F565267B65FC64F60382C39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void installCert(Context context) {
        dsTaint.addTaint(context.dsTaint);
        String type;
        type = CertTool.getCertType(mMimeType);
        {
            byte[] cert;
            cert = new byte[mDataBuilder.getByteSize()];
            int offset;
            offset = 0;
            {
                ByteArrayBuilder.Chunk c;
                c = mDataBuilder.getFirstChunk();
                {
                    System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    offset += c.mLength;
                } //End block
                c.release();
            } //End block
            CertTool.addCertificate(context, type, cert);
        } //End block
        // ---------- Original Method ----------
        //String type = CertTool.getCertType(mMimeType);
        //if (type == null) return;
        //synchronized (mDataBuilder) {
            //byte[] cert = new byte[mDataBuilder.getByteSize()];
            //int offset = 0;
            //while (true) {
                //ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
                //if (c == null) break;
                //if (c.mLength != 0) {
                    //System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    //offset += c.mLength;
                //}
                //c.release();
            //}
            //CertTool.addCertificate(context, type, cert);
            //return;
        //}
    }

    
    private static final String LOGTAG = "KeyStoreHandler";
}

