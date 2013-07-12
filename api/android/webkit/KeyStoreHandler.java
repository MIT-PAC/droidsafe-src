package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

class KeyStoreHandler extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.511 -0400", hash_original_field = "1F82295670D8C49C778553291F467693", hash_generated_field = "C2ADEC4B7675869DD34EF84CA5DC8ADA")

    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.511 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.512 -0400", hash_original_method = "587ABBBEDE647D3237F91706DA6610BD", hash_generated_method = "0B2E23A7411CC981C66241E70E1BCCAE")
    public  KeyStoreHandler(String mimeType) {
        mMimeType = mimeType;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.512 -0400", hash_original_method = "2DA424A8A87A21D10409F02AA8AEC0E6", hash_generated_method = "A1EFE5DBA7389295434AFF0E208F3A35")
    public void didReceiveData(byte[] data, int length) {
        addTaint(length);
        addTaint(data[0]);
        synchronized
(mDataBuilder)        {
            mDataBuilder.append(data, 0, length);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.513 -0400", hash_original_method = "736EF2EF4199424B0094A77A85DC708B", hash_generated_method = "80CC87B957C647B80E9ED4449155AF2C")
    public void installCert(Context context) {
        addTaint(context.getTaint());
        String type = CertTool.getCertType(mMimeType);
    if(type == null)        
        return;
        synchronized
(mDataBuilder)        {
            byte[] cert = new byte[mDataBuilder.getByteSize()];
            int offset = 0;
            while
(true)            
            {
                ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
    if(c == null)                
                break;
    if(c.mLength != 0)                
                {
                    System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                    offset += c.mLength;
                } 
                c.release();
            } 
            CertTool.addCertificate(context, type, cert);
            return;
        } 
        
        
        
        
            
            
            
                
                
                
                    
                    
                
                
            
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.513 -0400", hash_original_field = "57BF66CDF3DA6CF7C4606CCDC898C652", hash_generated_field = "C9E2CFC610075E6FBB1A3E399A292AA6")

    private static final String LOGTAG = "KeyStoreHandler";
}

