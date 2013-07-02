package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class UserInfo extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.552 -0400", hash_original_field = "EE11CBB19052E40B07AAC0CA060C23EE", hash_generated_field = "2E8D8BE8172FDAA496B4216DD847F959")

    protected String user;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.552 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "24B4D2B0B8A23D8C0FAB238006B574DA")

    protected String password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.552 -0400", hash_original_field = "3D88FCBAA3581C4957147EF9AD47EC5E", hash_generated_field = "A84E54971210FD20E9F93C9D58D4FA09")

    protected int userType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.553 -0400", hash_original_method = "F45B016F8E384DB218E594119B9CAF8C", hash_generated_method = "B84D01599B6AD9928E5FE27573600BA5")
    public  UserInfo() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.554 -0400", hash_original_method = "A09C3D32ACE02300A3630780DF7DA73F", hash_generated_method = "839138BCFE82CC643686A0A681BEEC69")
    public boolean equals(Object obj) {
        {
            boolean var0BDD716692710C348B07111E17BD2B29_1360413684 = (getClass() != obj.getClass());
        } 
        UserInfo other = (UserInfo) obj;
        {
            boolean var1378E0A61ABA01F3E69F31B70A354F56_851514101 = (!this.user.equalsIgnoreCase(other.user));
        } 
        boolean varB39BC6BA949574B109F798F5CD930BF4_1706304732 = ((this.password.equals(other.password)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788899824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788899824;
        
        
            
        
        
        
            
        
        
            
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.555 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "EE9ADE4C2B6557706233DCE8F8DB529A")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1172983776 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1172983776 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1172983776.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1172983776;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.556 -0400", hash_original_method = "7AE7B8A415769E92878FFEC035C52AE0", hash_generated_method = "CF02175F14D5A789DB4C489FE789107C")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1682198638 = null; 
        buffer.append(user).append(COLON).append(password);
        buffer.append(user);
        varB4EAC82CA7396A68D541C85D26508E83_1682198638 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1682198638.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1682198638;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.556 -0400", hash_original_method = "B45A9D19151CAED15569D78F83AD2095", hash_generated_method = "C8505DC09422B6CFF865611C6AB8A6C3")
    public void clearPassword() {
        this.password = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.557 -0400", hash_original_method = "0304D4B17F9026D87C6633B5EFA54170", hash_generated_method = "9E1477CC144F3CB3FBA9D8DBB308E8E9")
    public int getUserType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569419071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569419071;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.557 -0400", hash_original_method = "067A1216625EE4AD320B5B1536FC853E", hash_generated_method = "0F37C9EFD6E0C78D2D758F191A4411F8")
    public String getUser() {
        String varB4EAC82CA7396A68D541C85D26508E83_287047733 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_287047733 = user;
        varB4EAC82CA7396A68D541C85D26508E83_287047733.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_287047733;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.557 -0400", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "86DC84DC088DCAD3E4FD64194B52D1E5")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_622786066 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_622786066 = password;
        varB4EAC82CA7396A68D541C85D26508E83_622786066.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_622786066;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.558 -0400", hash_original_method = "3D02333C0789FC569CF57CEE9E3D36D7", hash_generated_method = "67AF31F06DFD5D4390DF641BB7B067FA")
    public void setUser(String user) {
        this.user = user;
        {
            boolean var5B9A832A8605FFA227F45C77CE3754E7_113531682 = (user != null
            && (user.indexOf(POUND) >= 0 || user.indexOf(SEMICOLON) >= 0));
            {
                setUserType(TELEPHONE_SUBSCRIBER);
            } 
            {
                setUserType(USER);
            } 
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.558 -0400", hash_original_method = "914969AC5F0FD02943850406A5ADB2DF", hash_generated_method = "F4C8503980BC4D291DEAF6570BD57166")
    public void setPassword(String p) {
        password = p;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.558 -0400", hash_original_method = "D88C19BFECDFF9E40F4106FE0C0D9444", hash_generated_method = "579C0B365229D95BC47F02464176C763")
    public void setUserType(int type) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parameter not in range");
        } 
        userType = type;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.558 -0400", hash_original_field = "43231819C48FB9A06188A2B06AFC5E10", hash_generated_field = "E4DBADE234AE16A77F53FEF34BDC568F")

    private static final long serialVersionUID = 7268593273924256144L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.558 -0400", hash_original_field = "E16DFB7AE7E6A4B6889DA697A63EA8FD", hash_generated_field = "2961967C21DF0AFF555C9722B216BAA2")

    public final static int TELEPHONE_SUBSCRIBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.558 -0400", hash_original_field = "20409D8B07DC11D8EACCABC83145D39D", hash_generated_field = "10FB0621E7A7DF7F148CB5C5899EF9ED")

    public final static int USER = 2;
}

