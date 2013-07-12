package org.bouncycastle.jce.provider;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;
import org.bouncycastle.jce.ProviderConfigurationPermission;
import org.bouncycastle.jce.interfaces.ConfigurableProvider;
import org.bouncycastle.jce.provider.asymmetric.ec.EC5Util;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class ProviderUtil {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.672 -0400", hash_original_method = "3B38983DBBB4F78AB4315AD498EBEF25", hash_generated_method = "3B38983DBBB4F78AB4315AD498EBEF25")
    public ProviderUtil ()
    {
        
    }


        @DSModeled(DSC.BAN)
    static void setParameter(String parameterName, Object parameter) {
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
            else  
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
            else  
            {
                ecImplicitCaParams = EC5Util.convertSpec((java.security.spec.ECParameterSpec)parameter, false);
            }
        }
    }

    
        public static ECParameterSpec getEcImplicitlyCa() {
        ECParameterSpec spec = (ECParameterSpec)threadSpec.get();
        if (spec != null)
        {
            return spec;
        }
        return ecImplicitCaParams;
    }

    
        static int getReadLimit(InputStream in) throws IOException {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.673 -0400", hash_original_field = "91B33CA2DCB2C7E0EA1B91CCA708C4E7", hash_generated_field = "149AA4E72EFB1C4C71BFED45E1E596C7")

    private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.673 -0400", hash_original_field = "D4AAEF9561CA45970CD3A12FBF9D4C09", hash_generated_field = "32A3648F1C97FCBCA10D3B7E92706891")

    private static Permission BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission(
                                                   BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.673 -0400", hash_original_field = "2954AE86888F52B6032FFB7F084A5CD0", hash_generated_field = "6DE99D887CBDBCAEE71A9ECF2EC2253D")

    private static Permission BC_EC_PERMISSION = new ProviderConfigurationPermission(
                                                   BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.EC_IMPLICITLY_CA);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.673 -0400", hash_original_field = "2160D3DA016BA8BCD751D97860B06319", hash_generated_field = "2C64121CA4C81C23DDD3DDCE8301A182")

    private static ThreadLocal threadSpec = new ThreadLocal();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.673 -0400", hash_original_field = "574DD7C5D4A16C72A2FFC11D33E28354", hash_generated_field = "13B48DE98077836F2FD596682B471365")

    private static volatile ECParameterSpec ecImplicitCaParams;
}

