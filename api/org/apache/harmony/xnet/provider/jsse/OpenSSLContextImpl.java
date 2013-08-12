package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;



public class OpenSSLContextImpl extends SSLContextImpl {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.727 -0400", hash_original_method = "AC85303C5261AE8C561C9D0D813887D0", hash_generated_method = "BA56A83C11C4D548CDA5AAC3BEDBB357")
    public  OpenSSLContextImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.727 -0400", hash_original_method = "F07877C7A70CCB9546F67CAFD785B8D1", hash_generated_method = "4AB7A8A94F9DDD43C12E832C92955DE0")
    protected  OpenSSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        super(dummy);
        addTaint(dummy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.727 -0400", hash_original_method = "A469C9A4B5A6A159DDADCF53650EE287", hash_generated_method = "4AD6452DB0275539DC96252564A0CB94")
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_1893246103 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_1893246103.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_1893246103;
        } //End block
SSLSocketFactory var82CD0BF44F938BA1AC3328FDCC51399C_1695954829 =         new OpenSSLSocketFactoryImpl(sslParameters);
        var82CD0BF44F938BA1AC3328FDCC51399C_1695954829.addTaint(taint);
        return var82CD0BF44F938BA1AC3328FDCC51399C_1695954829;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLSocketFactoryImpl(sslParameters);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.727 -0400", hash_original_method = "7F20F3D24E73FCFDF0CE368826678110", hash_generated_method = "08CF8AB2DBA652203155B63033A07980")
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_833872737 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_833872737.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_833872737;
        } //End block
SSLServerSocketFactory var8E47A225B0DEAB7C85AF9EA976791C8D_1237657525 =         new OpenSSLServerSocketFactoryImpl(sslParameters);
        var8E47A225B0DEAB7C85AF9EA976791C8D_1237657525.addTaint(taint);
        return var8E47A225B0DEAB7C85AF9EA976791C8D_1237657525;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new OpenSSLServerSocketFactoryImpl(sslParameters);
    }

    
}

