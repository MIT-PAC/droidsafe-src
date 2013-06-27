package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class UserInfo extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.674 -0400", hash_original_field = "EE11CBB19052E40B07AAC0CA060C23EE", hash_generated_field = "2E8D8BE8172FDAA496B4216DD847F959")

    protected String user;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.675 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "24B4D2B0B8A23D8C0FAB238006B574DA")

    protected String password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.675 -0400", hash_original_field = "3D88FCBAA3581C4957147EF9AD47EC5E", hash_generated_field = "A84E54971210FD20E9F93C9D58D4FA09")

    protected int userType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.675 -0400", hash_original_method = "F45B016F8E384DB218E594119B9CAF8C", hash_generated_method = "B84D01599B6AD9928E5FE27573600BA5")
    public  UserInfo() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.689 -0400", hash_original_method = "A09C3D32ACE02300A3630780DF7DA73F", hash_generated_method = "63211DDC3D2DD03ADE392E329F503046")
    public boolean equals(Object obj) {
        {
            boolean var0BDD716692710C348B07111E17BD2B29_1034064602 = (getClass() != obj.getClass());
        } //End collapsed parenthetic
        UserInfo other;
        other = (UserInfo) obj;
        {
            boolean var1378E0A61ABA01F3E69F31B70A354F56_1036279268 = (!this.user.equalsIgnoreCase(other.user));
        } //End collapsed parenthetic
        boolean varB39BC6BA949574B109F798F5CD930BF4_306658670 = ((this.password.equals(other.password)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344472302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344472302;
        // ---------- Original Method ----------
        //if (getClass() != obj.getClass()) {
            //return false;
        //}
        //UserInfo other = (UserInfo) obj;
        //if (this.userType != other.userType) {
            //return false;
        //}
        //if (!this.user.equalsIgnoreCase(other.user)) {
            //return false;
        //}
        //if (this.password != null && other.password == null)
            //return false;
        //if (other.password != null && this.password == null)
            //return false;
        //if (this.password == other.password)
            //return true;
        //return (this.password.equals(other.password));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.689 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "E390FBBC813DDF08D9D7AD7DFCB976B3")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1040567298 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1040567298 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1040567298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1040567298;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.690 -0400", hash_original_method = "7AE7B8A415769E92878FFEC035C52AE0", hash_generated_method = "A5A0B1442E623BF908C4B8EAC4414EB8")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1368237879 = null; //Variable for return #1
        buffer.append(user).append(COLON).append(password);
        buffer.append(user);
        varB4EAC82CA7396A68D541C85D26508E83_1368237879 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1368237879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368237879;
        // ---------- Original Method ----------
        //if (password != null)
            //buffer.append(user).append(COLON).append(password);
        //else
            //buffer.append(user);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.691 -0400", hash_original_method = "B45A9D19151CAED15569D78F83AD2095", hash_generated_method = "C8505DC09422B6CFF865611C6AB8A6C3")
    public void clearPassword() {
        this.password = null;
        // ---------- Original Method ----------
        //this.password = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.692 -0400", hash_original_method = "0304D4B17F9026D87C6633B5EFA54170", hash_generated_method = "D287CE2722F301E9987E875FCC0D58AE")
    public int getUserType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173668280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173668280;
        // ---------- Original Method ----------
        //return userType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.692 -0400", hash_original_method = "067A1216625EE4AD320B5B1536FC853E", hash_generated_method = "62698F62F21602F6BE351594189308F5")
    public String getUser() {
        String varB4EAC82CA7396A68D541C85D26508E83_1360430844 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1360430844 = user;
        varB4EAC82CA7396A68D541C85D26508E83_1360430844.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1360430844;
        // ---------- Original Method ----------
        //return user;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.693 -0400", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "8D191D549D88B029C9454C0F79406590")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_1687588773 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1687588773 = password;
        varB4EAC82CA7396A68D541C85D26508E83_1687588773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1687588773;
        // ---------- Original Method ----------
        //return password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.699 -0400", hash_original_method = "3D02333C0789FC569CF57CEE9E3D36D7", hash_generated_method = "A81B5D7B8AEB4D35C9D70C3F6E5BDE58")
    public void setUser(String user) {
        this.user = user;
        {
            boolean var5B9A832A8605FFA227F45C77CE3754E7_636968179 = (user != null
            && (user.indexOf(POUND) >= 0 || user.indexOf(SEMICOLON) >= 0));
            {
                setUserType(TELEPHONE_SUBSCRIBER);
            } //End block
            {
                setUserType(USER);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.user = user;
        //if (user != null
            //&& (user.indexOf(POUND) >= 0 || user.indexOf(SEMICOLON) >= 0)) {
            //setUserType(TELEPHONE_SUBSCRIBER);
        //} else {
            //setUserType(USER);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.701 -0400", hash_original_method = "914969AC5F0FD02943850406A5ADB2DF", hash_generated_method = "F4C8503980BC4D291DEAF6570BD57166")
    public void setPassword(String p) {
        password = p;
        // ---------- Original Method ----------
        //password = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.702 -0400", hash_original_method = "D88C19BFECDFF9E40F4106FE0C0D9444", hash_generated_method = "579C0B365229D95BC47F02464176C763")
    public void setUserType(int type) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parameter not in range");
        } //End block
        userType = type;
        // ---------- Original Method ----------
        //if (type != TELEPHONE_SUBSCRIBER && type != USER) {
            //throw new IllegalArgumentException("Parameter not in range");
        //}
        //userType = type;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.702 -0400", hash_original_field = "43231819C48FB9A06188A2B06AFC5E10", hash_generated_field = "49B3345EA94B22C8D3DAF0A7EEB980D1")

    private static long serialVersionUID = 7268593273924256144L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.702 -0400", hash_original_field = "E16DFB7AE7E6A4B6889DA697A63EA8FD", hash_generated_field = "2961967C21DF0AFF555C9722B216BAA2")

    public final static int TELEPHONE_SUBSCRIBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.702 -0400", hash_original_field = "20409D8B07DC11D8EACCABC83145D39D", hash_generated_field = "10FB0621E7A7DF7F148CB5C5899EF9ED")

    public final static int USER = 2;
}

