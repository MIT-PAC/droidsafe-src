package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

import org.bouncycastle.util.Strings;

public class ProviderConfigurationPermission extends BasicPermission {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.396 -0500", hash_original_field = "3F64B7EC32D4947C6A66E6FB99A1EC53", hash_generated_field = "138D6228500C7D432FC943682CD3B740")

    private static final int  THREAD_LOCAL_EC_IMPLICITLY_CA = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.399 -0500", hash_original_field = "319A5C0C74BB14172000D2B6EA026617", hash_generated_field = "A8B92EE2FD960A895718438E95236F43")

    private static final int  EC_IMPLICITLY_CA = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.402 -0500", hash_original_field = "0B4114F83FBFE6FE5F82B764509010F5", hash_generated_field = "8C0DD804A06BF2CD4E32866C53227F6E")

    private static final int  ALL = THREAD_LOCAL_EC_IMPLICITLY_CA | EC_IMPLICITLY_CA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.404 -0500", hash_original_field = "25EA47CEC88C639EC965C39E2C07E4C7", hash_generated_field = "FB009F48C3F79E949B43FEC81FA2D2A7")

    private static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.406 -0500", hash_original_field = "FD42ACA9BC0376B76DD86D4AC00FF1CB", hash_generated_field = "0A44DA4FDE8AE07EF1E90B2E2FBAFF37")

    private static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.409 -0500", hash_original_field = "931E203CE561542EF1AD97279AC04564", hash_generated_field = "6DF35217A61BD87AD889126A98885AB6")

    private static final String ALL_STR = "all";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.411 -0500", hash_original_field = "80C94ABE5BECF7CA5F71E61AF8088216", hash_generated_field = "11F45FCBAC06C059A01DA75B04C41C4C")

    private  String actions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.414 -0500", hash_original_field = "A2744B405E134A2B77B2118FD9ACC851", hash_generated_field = "8A108EC41FCFC9BA86B38B5E2DC6A613")

    private  int permissionMask;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.417 -0500", hash_original_method = "813A9EE5B8EE1175D591BD09E18CED38", hash_generated_method = "9F72B626E27B64731DBEEB3ECF7B331B")
    
public ProviderConfigurationPermission(String name)
    {
        super(name);
        this.actions = "all";
        this.permissionMask = ALL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.419 -0500", hash_original_method = "9B1904E70CAFE5BEE7C2393BADCC8D35", hash_generated_method = "6A3666F45B75FAD114473C99E47E0EBD")
    
public ProviderConfigurationPermission(String name, String actions)
    {
        super(name, actions);
        this.actions = actions;
        this.permissionMask = calculateMask(actions);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.422 -0500", hash_original_method = "6399F88877EC5072B688E348331D79AE", hash_generated_method = "45347AE3B89D9791A8B073303F55819B")
    
private int calculateMask(
        String actions)
    {
        StringTokenizer tok = new StringTokenizer(Strings.toLowerCase(actions), " ,");
        int             mask = 0;

        while (tok.hasMoreTokens())
        {
            String s = tok.nextToken();

            if (s.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR))
            {
                mask |= THREAD_LOCAL_EC_IMPLICITLY_CA;
            }
            else if (s.equals(EC_IMPLICITLY_CA_STR))
            {
                mask |= EC_IMPLICITLY_CA;
            }
            else if (s.equals(ALL_STR))
            {
                mask |= ALL;
            }
        }

        if (mask == 0)
        {
            throw new IllegalArgumentException("unknown permissions passed to mask");
        }
        
        return mask;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.424 -0500", hash_original_method = "737F906A6DB979CE36581422EA476EF8", hash_generated_method = "586F1D29E947353869F6C7C0E4B4B24D")
    
public String getActions()
    {
        return actions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.427 -0500", hash_original_method = "D56E3F2CB9D0216BFD594EEAAA62CE47", hash_generated_method = "D6F7FC83E46131D4C4482E5B84A480A2")
    
public boolean implies(
        Permission permission)
    {
        if (!(permission instanceof ProviderConfigurationPermission))
        {
            return false;
        }

        if (!this.getName().equals(permission.getName()))
        {
            return false;
        }
        
        ProviderConfigurationPermission other = (ProviderConfigurationPermission)permission;
        
        return (this.permissionMask & other.permissionMask) == other.permissionMask;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.429 -0500", hash_original_method = "AB59B8CA6295ACB3F9F36D0B84BA1CCF", hash_generated_method = "700C0B8CC4A33C675D6472DC4F59F222")
    
public boolean equals(
        Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (obj instanceof ProviderConfigurationPermission)
        {
            ProviderConfigurationPermission other = (ProviderConfigurationPermission)obj;

            return this.permissionMask == other.permissionMask && this.getName().equals(other.getName());
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.431 -0500", hash_original_method = "8E474C8FDA83B9292E3AC02815650F0C", hash_generated_method = "B64A3FA06ACCEBD33BDB0AF87A33148F")
    
public int hashCode()
    {
        return this.getName().hashCode() + this.permissionMask;
    }
}

