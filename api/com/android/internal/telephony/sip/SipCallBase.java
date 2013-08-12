package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;






abstract class SipCallBase extends Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.070 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "8202D840EE6CEF3CCCA47896EED71E34")

    protected List<Connection> connections = new ArrayList<Connection>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.071 -0400", hash_original_method = "0EF508E50423F81ECC9230D92981C1BD", hash_generated_method = "0EF508E50423F81ECC9230D92981C1BD")
    public SipCallBase ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    protected abstract void setState(State newState);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.071 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "B61D8F9D5D8B45D07E8A72A6B347CDE0")
    public List<Connection> getConnections() {
List<Connection> varD8B91E18CFFE05D77A84C03EDA812BE2_1670422350 =         connections;
        varD8B91E18CFFE05D77A84C03EDA812BE2_1670422350.addTaint(taint);
        return varD8B91E18CFFE05D77A84C03EDA812BE2_1670422350;
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.072 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "51372B373F5D8E4E007C0BAF396FCF08")
    public boolean isMultiparty() {
        boolean var29D4E14E3A46A0A5CCEDD95593D030FA_2087115458 = (connections.size() > 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580701719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580701719;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.073 -0400", hash_original_method = "7D1F122E9D021AC073DB09CCD6084B65", hash_generated_method = "4DD15297FD07231E1140C585BDA7EA0A")
    public String toString() {
String varB1A957162262627393F3B354A09765F0_1384313610 =         state.toString() + ":" + super.toString();
        varB1A957162262627393F3B354A09765F0_1384313610.addTaint(taint);
        return varB1A957162262627393F3B354A09765F0_1384313610;
        // ---------- Original Method ----------
        //return state.toString() + ":" + super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.073 -0400", hash_original_method = "2179B35862415320201802CDBF1F003D", hash_generated_method = "E379BDB30803208EE792849E5BF5BC8C")
     void clearDisconnected() {
for(Iterator<Connection> it = connections.iterator();it.hasNext();)
        {
            Connection c = it.next();
            if(c.getState() == State.DISCONNECTED)            
            it.remove();
        } //End block
        if(connections.isEmpty())        
        setState(State.IDLE);
        // ---------- Original Method ----------
        //for (Iterator<Connection> it = connections.iterator(); it.hasNext(); ) {
            //Connection c = it.next();
            //if (c.getState() == State.DISCONNECTED) it.remove();
        //}
        //if (connections.isEmpty()) setState(State.IDLE);
    }

    
}

