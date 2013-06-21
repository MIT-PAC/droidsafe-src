package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import javax.net.ssl.SSLSocketFactory;
import libcore.util.EmptyArray;

public class SSLSocketFactoryImpl extends SSLSocketFactory {
    private SSLParametersImpl sslParameters;
    private IOException instantiationException;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.227 -0400", hash_original_method = "3B70F1FB7142745DE6253CA770AA85DF", hash_generated_method = "AFAFC10411E0805BF7CA29F98654EB70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLSocketFactoryImpl() {
        SSLParametersImpl sslParametersLocal;
        sslParametersLocal = null;
        IOException instantiationExceptionLocal;
        instantiationExceptionLocal = null;
        try 
        {
            sslParametersLocal = SSLParametersImpl.getDefault();
        } //End block
        catch (KeyManagementException e)
        {
            instantiationExceptionLocal = new IOException("Delayed instantiation exception:");
            instantiationExceptionLocal.initCause(e);
        } //End block
        this.sslParameters = sslParametersLocal;
        this.instantiationException = instantiationExceptionLocal;
        // ---------- Original Method ----------
        //SSLParametersImpl sslParametersLocal = null;
        //IOException instantiationExceptionLocal = null;
        //try {
            //sslParametersLocal = SSLParametersImpl.getDefault();
        //} catch (KeyManagementException e) {
            //instantiationExceptionLocal = new IOException("Delayed instantiation exception:");
            //instantiationExceptionLocal.initCause(e);
        //}
        //this.sslParameters = sslParametersLocal;
        //this.instantiationException = instantiationExceptionLocal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.227 -0400", hash_original_method = "BC2150A7C00CB445EF2AA02677D69C68", hash_generated_method = "6BC24EDF984567A1ACEFA348635E2D0D")
    @DSModeled(DSC.SAFE)
    protected SSLSocketFactoryImpl(SSLParametersImpl sslParameters) {
        dsTaint.addTaint(sslParameters.dsTaint);
        this.instantiationException = null;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.instantiationException = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.229 -0400", hash_original_method = "D2E4703F25DE73045253D43D661F8658", hash_generated_method = "A090B4F0894998ECB17D14229E355191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getDefaultCipherSuites() {
        String[] varC3ED4EB907904E69984EFC846C8D14D7_526723862 = (sslParameters.getEnabledCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.229 -0400", hash_original_method = "107E6937D2B525F81A260013B97CF7D4", hash_generated_method = "D0B2EC612267595A14A4EC3D1B564114")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var7538431C68A39BDF527B3279B9F226C5_293948573 = (CipherSuite.getSupportedCipherSuiteNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //return EmptyArray.STRING;
        //}
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.229 -0400", hash_original_method = "770FADDB251D7948083EF0D02F3938EE", hash_generated_method = "48756788D712A348E049BFB2BF936F0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(Socket s, String host, int port,
            boolean autoClose) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(autoClose);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        Socket var9916EC28B255732302B13D1080670167_1079788865 = (new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                .clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketWrapper(s, autoClose, (SSLParametersImpl) sslParameters
                //.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.230 -0400", hash_original_method = "0CDA18BD18854D909AC84115F509C8F0", hash_generated_method = "336FAE518569117362916F145BD0D757")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        Socket var30F340A547B427BD71E6CBF316347482_1978049914 = (new SSLSocketImpl((SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl((SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.230 -0400", hash_original_method = "F68AAAAA9B8D61B174802E7029AF7953", hash_generated_method = "12016E390229A117AD956EB8EAFABF00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        Socket var49BF293BA77B68398B1A8F123E2A6BD9_1883246950 = (new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.230 -0400", hash_original_method = "53A1989EA3FBEE45809A2C11EADE957A", hash_generated_method = "B24A4594F815E0B12BA6BB1D651B6158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(String host, int port,
            InetAddress localHost, int localPort) throws IOException,
            UnknownHostException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(localPort);
        dsTaint.addTaint(localHost.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        Socket varE4867FD1DB31CB5D76CB5A07996E478F_218170558 = (new SSLSocketImpl(host, port, localHost, localPort,
                (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port, localHost, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.232 -0400", hash_original_method = "FD8C4D4ADA3C87BB97218603199064D4", hash_generated_method = "D4A8E1032C2B685C77361002174C5852")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        Socket var49BF293BA77B68398B1A8F123E2A6BD9_926356187 = (new SSLSocketImpl(host, port,
                (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(host, port,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.232 -0400", hash_original_method = "3B16D41EDAC8F54354185F57BF630F58", hash_generated_method = "4871839D937E1904E99A7F37D9A449D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Socket createSocket(InetAddress address, int port,
            InetAddress localAddress, int localPort) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(localAddress.dsTaint);
        dsTaint.addTaint(localPort);
        {
            if (DroidSafeAndroidRuntime.control) throw instantiationException;
        } //End block
        Socket var986EDAC8A562F9DAD16A5B70B673C5ED_1593367829 = (new SSLSocketImpl(address, port, localAddress, localPort,
                (SSLParametersImpl) sslParameters.clone()));
        return (Socket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (instantiationException != null) {
            //throw instantiationException;
        //}
        //return new SSLSocketImpl(address, port, localAddress, localPort,
                //(SSLParametersImpl) sslParameters.clone());
    }

    
}

