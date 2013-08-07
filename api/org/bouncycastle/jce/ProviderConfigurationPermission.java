package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

import org.bouncycastle.util.Strings;






public class ProviderConfigurationPermission extends BasicPermission {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.569 -0400", hash_original_field = "EBB67A4271ABE715344471B0F16321F6", hash_generated_field = "11F45FCBAC06C059A01DA75B04C41C4C")

    private String actions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.569 -0400", hash_original_field = "2F56CAB616F677C9B1161205949477FB", hash_generated_field = "8A108EC41FCFC9BA86B38B5E2DC6A613")

    private int permissionMask;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.570 -0400", hash_original_method = "813A9EE5B8EE1175D591BD09E18CED38", hash_generated_method = "FCE0D7AA50C8BAFE22B8F6A947994E84")
    public  ProviderConfigurationPermission(String name) {
        super(name);
        addTaint(name.getTaint());
        this.actions = "all";
        this.permissionMask = ALL;
        // ---------- Original Method ----------
        //this.actions = "all";
        //this.permissionMask = ALL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.570 -0400", hash_original_method = "9B1904E70CAFE5BEE7C2393BADCC8D35", hash_generated_method = "89C2E39FB4EB257283BFAFBDFB68BC65")
    public  ProviderConfigurationPermission(String name, String actions) {
        super(name, actions);
        addTaint(name.getTaint());
        this.actions = actions;
        this.permissionMask = calculateMask(actions);
        // ---------- Original Method ----------
        //this.actions = actions;
        //this.permissionMask = calculateMask(actions);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.571 -0400", hash_original_method = "6399F88877EC5072B688E348331D79AE", hash_generated_method = "202EF4150C0BCD72B46B63FC91FA2E4A")
    private int calculateMask(
        String actions) {
        addTaint(actions.getTaint());
        StringTokenizer tok = new StringTokenizer(Strings.toLowerCase(actions), " ,");
        int mask = 0;
        while
(tok.hasMoreTokens())        
        {
            String s = tok.nextToken();
    if(s.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR))            
            {
                mask |= THREAD_LOCAL_EC_IMPLICITLY_CA;
            } //End block
            else
    if(s.equals(EC_IMPLICITLY_CA_STR))            
            {
                mask |= EC_IMPLICITLY_CA;
            } //End block
            else
    if(s.equals(ALL_STR))            
            {
                mask |= ALL;
            } //End block
        } //End block
    if(mask == 0)        
        {
            IllegalArgumentException var0E6114EAF994A9A12FFA6113719F0C01_523762307 = new IllegalArgumentException("unknown permissions passed to mask");
            var0E6114EAF994A9A12FFA6113719F0C01_523762307.addTaint(taint);
            throw var0E6114EAF994A9A12FFA6113719F0C01_523762307;
        } //End block
        int varF2CE11EBF110993621BEDD8E747D7B1B_1446566366 = (mask);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496186865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496186865;
        // ---------- Original Method ----------
        //StringTokenizer tok = new StringTokenizer(Strings.toLowerCase(actions), " ,");
        //int             mask = 0;
        //while (tok.hasMoreTokens())
        //{
            //String s = tok.nextToken();
            //if (s.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR))
            //{
                //mask |= THREAD_LOCAL_EC_IMPLICITLY_CA;
            //}
            //else if (s.equals(EC_IMPLICITLY_CA_STR))
            //{
                //mask |= EC_IMPLICITLY_CA;
            //}
            //else if (s.equals(ALL_STR))
            //{
                //mask |= ALL;
            //}
        //}
        //if (mask == 0)
        //{
            //throw new IllegalArgumentException("unknown permissions passed to mask");
        //}
        //return mask;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.572 -0400", hash_original_method = "737F906A6DB979CE36581422EA476EF8", hash_generated_method = "30DA9F8383A33B1F052E41F6EE9AE2B2")
    public String getActions() {
String var1D92EB8012A9AFD0473D135A86226554_1613626180 =         actions;
        var1D92EB8012A9AFD0473D135A86226554_1613626180.addTaint(taint);
        return var1D92EB8012A9AFD0473D135A86226554_1613626180;
        // ---------- Original Method ----------
        //return actions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.575 -0400", hash_original_method = "D56E3F2CB9D0216BFD594EEAAA62CE47", hash_generated_method = "91C2B75DE025C41F5747C3F84AE0B611")
    public boolean implies(
        Permission permission) {
        addTaint(permission.getTaint());
    if(!(permission instanceof ProviderConfigurationPermission))        
        {
            boolean var68934A3E9455FA72420237EB05902327_683785851 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769470467 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_769470467;
        } //End block
    if(!this.getName().equals(permission.getName()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_920762825 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161067132 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161067132;
        } //End block
        ProviderConfigurationPermission other = (ProviderConfigurationPermission)permission;
        boolean varBCB419270106332CA45ABC1986C39F5A_1796958234 = ((this.permissionMask & other.permissionMask) == other.permissionMask);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684122089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_684122089;
        // ---------- Original Method ----------
        //if (!(permission instanceof ProviderConfigurationPermission))
        //{
            //return false;
        //}
        //if (!this.getName().equals(permission.getName()))
        //{
            //return false;
        //}
        //ProviderConfigurationPermission other = (ProviderConfigurationPermission)permission;
        //return (this.permissionMask & other.permissionMask) == other.permissionMask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.576 -0400", hash_original_method = "AB59B8CA6295ACB3F9F36D0B84BA1CCF", hash_generated_method = "0B255C3FAAA43A849EF71F2A0A7ED150")
    public boolean equals(
        Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1900435854 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1364576756 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1364576756;
        } //End block
    if(obj instanceof ProviderConfigurationPermission)        
        {
            ProviderConfigurationPermission other = (ProviderConfigurationPermission)obj;
            boolean varDE88C9705A284255BA1D5BE633629A83_237454196 = (this.permissionMask == other.permissionMask && this.getName().equals(other.getName()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744387349 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_744387349;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_357634725 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373461528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373461528;
        // ---------- Original Method ----------
        //if (obj == this)
        //{
            //return true;
        //}
        //if (obj instanceof ProviderConfigurationPermission)
        //{
            //ProviderConfigurationPermission other = (ProviderConfigurationPermission)obj;
            //return this.permissionMask == other.permissionMask && this.getName().equals(other.getName());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.576 -0400", hash_original_method = "8E474C8FDA83B9292E3AC02815650F0C", hash_generated_method = "5FE8BD9E02498B214DC6AA0873BC7A8C")
    public int hashCode() {
        int var67BC157D7EEE983D7151E66AB672C5A0_1929468853 = (this.getName().hashCode() + this.permissionMask);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1637208802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1637208802;
        // ---------- Original Method ----------
        //return this.getName().hashCode() + this.permissionMask;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.576 -0400", hash_original_field = "1634A7522DDF810027466C5366D003AC", hash_generated_field = "138D6228500C7D432FC943682CD3B740")

    private static final int THREAD_LOCAL_EC_IMPLICITLY_CA = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.576 -0400", hash_original_field = "4F36C2FF06A2ADC57395EC8FFA0D6250", hash_generated_field = "A8B92EE2FD960A895718438E95236F43")

    private static final int EC_IMPLICITLY_CA = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.576 -0400", hash_original_field = "42912296BB940B511406954A6AEB9C5B", hash_generated_field = "8C0DD804A06BF2CD4E32866C53227F6E")

    private static final int ALL = THREAD_LOCAL_EC_IMPLICITLY_CA | EC_IMPLICITLY_CA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.577 -0400", hash_original_field = "D5691D88994C26D0CDB68FE90301A8B2", hash_generated_field = "FB009F48C3F79E949B43FEC81FA2D2A7")

    private static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.577 -0400", hash_original_field = "F8DD50FBB92B41BD373BAC7D492E93AE", hash_generated_field = "0A44DA4FDE8AE07EF1E90B2E2FBAFF37")

    private static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.577 -0400", hash_original_field = "24837F2CF914B7DFF2775279515FFADF", hash_generated_field = "6DF35217A61BD87AD889126A98885AB6")

    private static final String ALL_STR = "all";
}

