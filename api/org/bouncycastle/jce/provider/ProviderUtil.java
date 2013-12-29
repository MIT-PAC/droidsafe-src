package org.bouncycastle.jce.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;

import org.bouncycastle.jce.ProviderConfigurationPermission;
import org.bouncycastle.jce.interfaces.ConfigurableProvider;
import org.bouncycastle.jce.provider.asymmetric.ec.EC5Util;
import org.bouncycastle.jce.spec.ECParameterSpec;






public class ProviderUtil {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.000 -0500", hash_original_method = "A7DC5B91450FFE4B344462BF68654569", hash_generated_method = "F7D989378EBA7BA1A7F50B296D1038E0")
    static void setParameter(String parameterName, Object parameter)
    {
        SecurityManager securityManager = System.getSecurityManager();

        if (parameterName.equals(ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA))
        {
            ECParameterSpec curveSpec;

            if (securityManager != null)
            {
                securityManager.checkPermission(BC_EC_LOCAL_PERMISSION);
            }

            if (parameter instanceof ECParameterSpec || parameter == null)
            {
                curveSpec = (ECParameterSpec)parameter;
            }
            else  // assume java.security.spec
            {
                curveSpec = EC5Util.convertSpec((java.security.spec.ECParameterSpec)parameter, false);
            }

            if (curveSpec == null)
            {
                threadSpec.remove();
            }
            else
            {
                threadSpec.set(curveSpec);
            }
        }
        else if (parameterName.equals(ConfigurableProvider.EC_IMPLICITLY_CA))
        {
            if (securityManager != null)
            {
                securityManager.checkPermission(BC_EC_PERMISSION);
            }

            if (parameter instanceof ECParameterSpec || parameter == null)
            {
                ecImplicitCaParams = (ECParameterSpec)parameter;
            }
            else  // assume java.security.spec
            {
                ecImplicitCaParams = EC5Util.convertSpec((java.security.spec.ECParameterSpec)parameter, false);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.000 -0500", hash_original_method = "EC8B0DFD35D95264133AD6B3ADF19151", hash_generated_method = "798AF3CD994F9E4D7603B00E53F22829")
    public static ECParameterSpec getEcImplicitlyCa()
    {
        ECParameterSpec spec = (ECParameterSpec)threadSpec.get();

        if (spec != null)
        {
            return spec;
        }

        return ecImplicitCaParams;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:58.001 -0500", hash_original_method = "5D6BD5271BA6E2165580441D00723C55", hash_generated_method = "3D41289F69342537976D8B2A16D9956C")
    static int getReadLimit(InputStream in)
        throws IOException
    {
        if (in instanceof ByteArrayInputStream)
        {
            return in.available();
        }

        if (MAX_MEMORY > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        return (int)MAX_MEMORY;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.995 -0500", hash_original_field = "1100B9D3F7ADDCF2963DB52A0BCE0D4D", hash_generated_field = "149AA4E72EFB1C4C71BFED45E1E596C7")

    private static final long  MAX_MEMORY = Runtime.getRuntime().maxMemory();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.996 -0500", hash_original_field = "E33976C9BA280D6C6ED62C9A87A3C20F", hash_generated_field = "32A3648F1C97FCBCA10D3B7E92706891")


    private static Permission BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission(
                                                   BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.997 -0500", hash_original_field = "71BF299AA72D19CEBC41972311AE3936", hash_generated_field = "6DE99D887CBDBCAEE71A9ECF2EC2253D")

    private static Permission BC_EC_PERMISSION = new ProviderConfigurationPermission(
                                                   BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.EC_IMPLICITLY_CA);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.998 -0500", hash_original_field = "E7E750652EAEF3E5B130142ECABDA900", hash_generated_field = "2C64121CA4C81C23DDD3DDCE8301A182")


    private static ThreadLocal threadSpec = new ThreadLocal();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:57.999 -0500", hash_original_field = "940FDB492FA81E1042EC1E157D6A36E8", hash_generated_field = "13B48DE98077836F2FD596682B471365")

    private static volatile ECParameterSpec ecImplicitCaParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.672 -0400", hash_original_method = "3B38983DBBB4F78AB4315AD498EBEF25", hash_generated_method = "3B38983DBBB4F78AB4315AD498EBEF25")
    public ProviderUtil ()
    {
        //Synthesized constructor
    }
}

