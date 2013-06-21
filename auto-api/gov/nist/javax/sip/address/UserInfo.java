package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class UserInfo extends NetObject {
    protected String user;
    protected String password;
    protected int userType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.511 -0400", hash_original_method = "F45B016F8E384DB218E594119B9CAF8C", hash_generated_method = "B84D01599B6AD9928E5FE27573600BA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UserInfo() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.511 -0400", hash_original_method = "A09C3D32ACE02300A3630780DF7DA73F", hash_generated_method = "A6585AF0399D3FB594C6D21EB48EF261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var0BDD716692710C348B07111E17BD2B29_928929133 = (getClass() != obj.getClass());
        } //End collapsed parenthetic
        UserInfo other;
        other = (UserInfo) obj;
        {
            boolean var1378E0A61ABA01F3E69F31B70A354F56_1583538530 = (!this.user.equalsIgnoreCase(other.user));
        } //End collapsed parenthetic
        boolean varB39BC6BA949574B109F798F5CD930BF4_1977606671 = ((this.password.equals(other.password)));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.512 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "E8523F4E510B50EECCA523DC10CABE1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_366508431 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.512 -0400", hash_original_method = "7AE7B8A415769E92878FFEC035C52AE0", hash_generated_method = "656D26EDE17BEFB37918979F4657909A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(user).append(COLON).append(password);
        buffer.append(user);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (password != null)
            //buffer.append(user).append(COLON).append(password);
        //else
            //buffer.append(user);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.512 -0400", hash_original_method = "B45A9D19151CAED15569D78F83AD2095", hash_generated_method = "C8505DC09422B6CFF865611C6AB8A6C3")
    @DSModeled(DSC.SAFE)
    public void clearPassword() {
        this.password = null;
        // ---------- Original Method ----------
        //this.password = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.512 -0400", hash_original_method = "0304D4B17F9026D87C6633B5EFA54170", hash_generated_method = "35A71E2B85DFE9BF546326F49CAFDD47")
    @DSModeled(DSC.SAFE)
    public int getUserType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return userType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.513 -0400", hash_original_method = "067A1216625EE4AD320B5B1536FC853E", hash_generated_method = "E25617900E3D115BA4D5513EA29423D6")
    @DSModeled(DSC.SAFE)
    public String getUser() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return user;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.513 -0400", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "6274637C3EA24839E467047CF7B75504")
    @DSModeled(DSC.SAFE)
    public String getPassword() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.513 -0400", hash_original_method = "3D02333C0789FC569CF57CEE9E3D36D7", hash_generated_method = "1939F159AC8BA5269024337A896ACB1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUser(String user) {
        dsTaint.addTaint(user);
        {
            boolean var5B9A832A8605FFA227F45C77CE3754E7_1892012234 = (user != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.513 -0400", hash_original_method = "914969AC5F0FD02943850406A5ADB2DF", hash_generated_method = "F22700EF2282724F315BB2DF4386881A")
    @DSModeled(DSC.SAFE)
    public void setPassword(String p) {
        dsTaint.addTaint(p);
        // ---------- Original Method ----------
        //password = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.513 -0400", hash_original_method = "D88C19BFECDFF9E40F4106FE0C0D9444", hash_generated_method = "600C0B7516165672844FD8291DEBE083")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUserType(int type) throws IllegalArgumentException {
        dsTaint.addTaint(type);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parameter not in range");
        } //End block
        // ---------- Original Method ----------
        //if (type != TELEPHONE_SUBSCRIBER && type != USER) {
            //throw new IllegalArgumentException("Parameter not in range");
        //}
        //userType = type;
    }

    
    private static final long serialVersionUID = 7268593273924256144L;
    public final static int TELEPHONE_SUBSCRIBER = 1;
    public final static int USER = 2;
}

