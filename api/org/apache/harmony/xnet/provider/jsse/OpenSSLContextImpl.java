package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class OpenSSLContextImpl extends SSLContextImpl {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.552 -0400", hash_original_method = "AC85303C5261AE8C561C9D0D813887D0", hash_generated_method = "BA56A83C11C4D548CDA5AAC3BEDBB357")
    public  OpenSSLContextImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.552 -0400", hash_original_method = "F07877C7A70CCB9546F67CAFD785B8D1", hash_generated_method = "4AB7A8A94F9DDD43C12E832C92955DE0")
    protected  OpenSSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        super(dummy);
        addTaint(dummy.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.552 -0400", hash_original_method = "A469C9A4B5A6A159DDADCF53650EE287", hash_generated_method = "9266BA43657CB91AF27FDA833DF46E87")
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
    if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_245219106 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_245219106.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_245219106;
        } 
SSLSocketFactory var82CD0BF44F938BA1AC3328FDCC51399C_1760615109 =         new OpenSSLSocketFactoryImpl(sslParameters);
        var82CD0BF44F938BA1AC3328FDCC51399C_1760615109.addTaint(taint);
        return var82CD0BF44F938BA1AC3328FDCC51399C_1760615109;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.552 -0400", hash_original_method = "7F20F3D24E73FCFDF0CE368826678110", hash_generated_method = "D9554F8FD123AEFE2080614E0C23B047")
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
    if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_591409693 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_591409693.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_591409693;
        } 
SSLServerSocketFactory var8E47A225B0DEAB7C85AF9EA976791C8D_1778167178 =         new OpenSSLServerSocketFactoryImpl(sslParameters);
        var8E47A225B0DEAB7C85AF9EA976791C8D_1778167178.addTaint(taint);
        return var8E47A225B0DEAB7C85AF9EA976791C8D_1778167178;
        
        
            
        
        
    }

    
}

