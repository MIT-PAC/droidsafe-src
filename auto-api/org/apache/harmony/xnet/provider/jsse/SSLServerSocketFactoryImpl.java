package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import javax.net.ssl.SSLServerSocketFactory;
import libcore.util.EmptyArray;

public class SSLServerSocketFactoryImpl extends SSLServerSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.894 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.894 -0400", hash_original_field = "ED2222BD8464114597349D4FC408BA2C", hash_generated_field = "2D5C9847E3AA9248107E9F6E4986B2D4")

    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.895 -0400", hash_original_method = "73CB7C407A43304FA150044B815B6A46", hash_generated_method = "DA509C88D8CBE2F9A5C5ADAE49E05105")
    public  SSLServerSocketFactoryImpl() {
        try 
        {
            this.sslParameters = SSLParametersImpl.getDefault();
            this.sslParameters.setUseClientMode(false);
        } 
        catch (KeyManagementException e)
        {
            instantiationException =
                new IOException("Delayed instantiation exception:");
            instantiationException.initCause(e);
        } 
        
        
            
            
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.895 -0400", hash_original_method = "76241236FAFD17D5464286E69E45CFDE", hash_generated_method = "BC3AAD450653E595B44F6BC12859BFC7")
    protected  SSLServerSocketFactoryImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = (SSLParametersImpl) sslParameters.clone();
        this.sslParameters.setUseClientMode(false);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.896 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "9067A750B9C13F94A9B3E72C99BFEB10")
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1302143434 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1206316822 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1302143434 = EmptyArray.STRING;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1206316822 = sslParameters.getEnabledCipherSuites();
        String[] varA7E53CE21691AB073D9660D615818899_1713446304; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1713446304 = varB4EAC82CA7396A68D541C85D26508E83_1302143434;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1713446304 = varB4EAC82CA7396A68D541C85D26508E83_1206316822;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1713446304.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1713446304;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.897 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "263321B4277D1A6411E24568A960C656")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2092934497 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1241407175 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2092934497 = EmptyArray.STRING;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1241407175 = CipherSuite.getSupportedCipherSuiteNames();
        String[] varA7E53CE21691AB073D9660D615818899_2077892000; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2077892000 = varB4EAC82CA7396A68D541C85D26508E83_2092934497;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2077892000 = varB4EAC82CA7396A68D541C85D26508E83_1241407175;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2077892000.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2077892000;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.897 -0400", hash_original_method = "8CBCDC02B624BDC3EBB9915D8C4D504E", hash_generated_method = "00627CDA445F11E45A4482E1DFD9807A")
    @Override
    public ServerSocket createServerSocket() throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1665303883 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1665303883 = new SSLServerSocketImpl((SSLParametersImpl) sslParameters.clone());
        varB4EAC82CA7396A68D541C85D26508E83_1665303883.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1665303883;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.898 -0400", hash_original_method = "38B1F9FB8A801D54D6140D98F9574C0C", hash_generated_method = "827DF06961B58EF29151E6D151CB1E2B")
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_934461757 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_934461757 = new SSLServerSocketImpl(port,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_934461757.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_934461757;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.899 -0400", hash_original_method = "DB92DF56A4C60994E7A02C3BBC7271E4", hash_generated_method = "9189B51D177814FE39B37B815E7C264B")
    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_1519409100 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1519409100 = new SSLServerSocketImpl(port, backlog,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        addTaint(backlog);
        varB4EAC82CA7396A68D541C85D26508E83_1519409100.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1519409100;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.899 -0400", hash_original_method = "05EB93BEC7CA6CC8959662993B7E734B", hash_generated_method = "1518E04DD82024121DB1E6A36DFCEFAC")
    @Override
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress iAddress) throws IOException {
        ServerSocket varB4EAC82CA7396A68D541C85D26508E83_298345111 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_298345111 = new SSLServerSocketImpl(port, backlog, iAddress,
                (SSLParametersImpl) sslParameters.clone());
        addTaint(port);
        addTaint(backlog);
        addTaint(iAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_298345111.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_298345111;
        
        
            
        
        
                
    }

    
}

