package com.android.internal.telephony.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import android.net.sip.SipManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class SipCallBase extends Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.064 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "8202D840EE6CEF3CCCA47896EED71E34")

    protected List<Connection> connections = new ArrayList<Connection>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.064 -0400", hash_original_method = "0EF508E50423F81ECC9230D92981C1BD", hash_generated_method = "0EF508E50423F81ECC9230D92981C1BD")
    public SipCallBase ()
    {
        
    }


    protected abstract void setState(State newState);

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.065 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "5FB8D660AF0A212E9C4FA42CB80ACAA0")
    public List<Connection> getConnections() {
List<Connection> varD8B91E18CFFE05D77A84C03EDA812BE2_1850083990 =         connections;
        varD8B91E18CFFE05D77A84C03EDA812BE2_1850083990.addTaint(taint);
        return varD8B91E18CFFE05D77A84C03EDA812BE2_1850083990;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.066 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "190A8C213ACD2456ED3FEA49E075E171")
    public boolean isMultiparty() {
        boolean var29D4E14E3A46A0A5CCEDD95593D030FA_1781548658 = (connections.size() > 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613181784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613181784;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.066 -0400", hash_original_method = "7D1F122E9D021AC073DB09CCD6084B65", hash_generated_method = "0E12B49A0ADCBB37D34011C76DC66FC3")
    public String toString() {
String varB1A957162262627393F3B354A09765F0_219152679 =         state.toString() + ":" + super.toString();
        varB1A957162262627393F3B354A09765F0_219152679.addTaint(taint);
        return varB1A957162262627393F3B354A09765F0_219152679;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.066 -0400", hash_original_method = "2179B35862415320201802CDBF1F003D", hash_generated_method = "E379BDB30803208EE792849E5BF5BC8C")
     void clearDisconnected() {
for(Iterator<Connection> it = connections.iterator();it.hasNext();)
        {
            Connection c = it.next();
    if(c.getState() == State.DISCONNECTED)            
            it.remove();
        } 
    if(connections.isEmpty())        
        setState(State.IDLE);
        
        
            
            
        
        
    }

    
}

