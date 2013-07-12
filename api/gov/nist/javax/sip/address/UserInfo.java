package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class UserInfo extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.425 -0400", hash_original_field = "EE11CBB19052E40B07AAC0CA060C23EE", hash_generated_field = "2E8D8BE8172FDAA496B4216DD847F959")

    protected String user;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.425 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "24B4D2B0B8A23D8C0FAB238006B574DA")

    protected String password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.425 -0400", hash_original_field = "3D88FCBAA3581C4957147EF9AD47EC5E", hash_generated_field = "A84E54971210FD20E9F93C9D58D4FA09")

    protected int userType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.425 -0400", hash_original_method = "F45B016F8E384DB218E594119B9CAF8C", hash_generated_method = "B84D01599B6AD9928E5FE27573600BA5")
    public  UserInfo() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.426 -0400", hash_original_method = "A09C3D32ACE02300A3630780DF7DA73F", hash_generated_method = "AC015369A280623ED22B63F740738DCA")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(getClass() != obj.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_646012408 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164445625 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_164445625;
        } 
        UserInfo other = (UserInfo) obj;
    if(this.userType != other.userType)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1658129296 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459789626 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_459789626;
        } 
    if(!this.user.equalsIgnoreCase(other.user))        
        {
            boolean var68934A3E9455FA72420237EB05902327_554367502 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662749503 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662749503;
        } 
    if(this.password != null && other.password == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_316858029 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711701093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_711701093;
        }
    if(other.password != null && this.password == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1184552219 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1698030841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1698030841;
        }
    if(this.password == other.password)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_968809961 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903780668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903780668;
        }
        boolean varDBE1820E03E80EFC11DF64D2A92A059A_422480104 = ((this.password.equals(other.password)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551893617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551893617;
        
        
            
        
        
        
            
        
        
            
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.426 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "85BB6A3DD802686F7A955897D141F603")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1337227620 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1337227620.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1337227620;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.427 -0400", hash_original_method = "7AE7B8A415769E92878FFEC035C52AE0", hash_generated_method = "1E35C1F463264226AE2BAD432816E1D0")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(password != null)        
        buffer.append(user).append(COLON).append(password);
        else
        buffer.append(user);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1257918735 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1257918735.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1257918735;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.427 -0400", hash_original_method = "B45A9D19151CAED15569D78F83AD2095", hash_generated_method = "C8505DC09422B6CFF865611C6AB8A6C3")
    public void clearPassword() {
        this.password = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.428 -0400", hash_original_method = "0304D4B17F9026D87C6633B5EFA54170", hash_generated_method = "16892FC8A438F7E939B7EAD6FA8D16D3")
    public int getUserType() {
        int var3D88FCBAA3581C4957147EF9AD47EC5E_758874359 = (userType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109823345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_109823345;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.428 -0400", hash_original_method = "067A1216625EE4AD320B5B1536FC853E", hash_generated_method = "949C7112D97A03C06AF7487697F7E4B8")
    public String getUser() {
String var1ABA5703084F105A1CF02655AEDE82C9_1824270919 =         user;
        var1ABA5703084F105A1CF02655AEDE82C9_1824270919.addTaint(taint);
        return var1ABA5703084F105A1CF02655AEDE82C9_1824270919;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.428 -0400", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "8F50B30DFB3332A5FEA7426BD46F2579")
    public String getPassword() {
String var8371B008E722D01F0CA3A116DA23853F_1279613163 =         password;
        var8371B008E722D01F0CA3A116DA23853F_1279613163.addTaint(taint);
        return var8371B008E722D01F0CA3A116DA23853F_1279613163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.429 -0400", hash_original_method = "3D02333C0789FC569CF57CEE9E3D36D7", hash_generated_method = "ABA2B06BD258D22F296622B437D308ED")
    public void setUser(String user) {
        this.user = user;
    if(user != null
            && (user.indexOf(POUND) >= 0 || user.indexOf(SEMICOLON) >= 0))        
        {
            setUserType(TELEPHONE_SUBSCRIBER);
        } 
        else
        {
            setUserType(USER);
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.430 -0400", hash_original_method = "914969AC5F0FD02943850406A5ADB2DF", hash_generated_method = "F4C8503980BC4D291DEAF6570BD57166")
    public void setPassword(String p) {
        password = p;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.430 -0400", hash_original_method = "D88C19BFECDFF9E40F4106FE0C0D9444", hash_generated_method = "3AF5E78B9CD82078D1CDB7574192D179")
    public void setUserType(int type) throws IllegalArgumentException {
    if(type != TELEPHONE_SUBSCRIBER && type != USER)        
        {
            IllegalArgumentException var08F7568D6B78264D943D1F314BFD0791_280097438 = new IllegalArgumentException("Parameter not in range");
            var08F7568D6B78264D943D1F314BFD0791_280097438.addTaint(taint);
            throw var08F7568D6B78264D943D1F314BFD0791_280097438;
        } 
        userType = type;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.430 -0400", hash_original_field = "43231819C48FB9A06188A2B06AFC5E10", hash_generated_field = "E4DBADE234AE16A77F53FEF34BDC568F")

    private static final long serialVersionUID = 7268593273924256144L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.430 -0400", hash_original_field = "E16DFB7AE7E6A4B6889DA697A63EA8FD", hash_generated_field = "2961967C21DF0AFF555C9722B216BAA2")

    public final static int TELEPHONE_SUBSCRIBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.431 -0400", hash_original_field = "20409D8B07DC11D8EACCABC83145D39D", hash_generated_field = "10FB0621E7A7DF7F148CB5C5899EF9ED")

    public final static int USER = 2;
}

