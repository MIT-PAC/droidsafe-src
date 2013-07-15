package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.List;
import android.util.Log;

public abstract class Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.444 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "682AB4A75DC1B6B1A2EFDFBB9B599B89")

    public State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.444 -0400", hash_original_field = "145F45FAD3D9A65F2E45DF93DC09017A", hash_generated_field = "508CDFD163A234BDAF6D1151B8AC029E")

    protected boolean isGeneric = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.444 -0400", hash_original_field = "2C3C4BA0AA1A67B454D055C30572EBF9", hash_generated_field = "548675245A66AB01BBAEC34E10E70E57")

    protected final String LOG_TAG = "Call";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.444 -0400", hash_original_method = "CB9B9DF7FC21F16DE5B641A13D14D68A", hash_generated_method = "CB9B9DF7FC21F16DE5B641A13D14D68A")
    public Call ()
    {
        
    }


    public abstract List<Connection> getConnections();

    
    public abstract Phone getPhone();

    
    public abstract boolean isMultiparty();

    
    public abstract void hangup() throws CallStateException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.445 -0400", hash_original_method = "2FDAA23821BA4C24A2BE1E56579DB7F5", hash_generated_method = "625DE4B270E6793945C1B920D4F5A65E")
    public boolean hasConnection(Connection c) {
        boolean var55436ED00E4A388847DD6F1A0A73151E_1928432132 = (c.getCall() == this);
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536997617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_536997617;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.446 -0400", hash_original_method = "2C555626402D649349C7BBEAA2F56B58", hash_generated_method = "913D3DA8BBD685781328D50126F9DDB9")
    public boolean hasConnections() {
        List connections = getConnections();
        boolean var19E6D303B61D79EE799E22D77B251D15_385612010 = (connections.size() > 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345781736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345781736;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.446 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "8FC3256A8B357053DAEC71E26CC5AA42")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_1082154939 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1082154939 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1082154939.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1082154939;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.446 -0400", hash_original_method = "647027C18C356B0A148CD756E9A6C1F9", hash_generated_method = "B765FEF9836F58D8E409B19EFB9011B0")
    public boolean isIdle() {
        boolean var285DB4CFA4C51F0FABAF97FE009E40A6_1773421044 = (!getState().isAlive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646315957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646315957;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.447 -0400", hash_original_method = "EADA1B2297DA3CAB3CFE5B591670DF74", hash_generated_method = "8161598C79731F0EC59E2A9E6BE7ADAF")
    public Connection getEarliestConnection() {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1565424725 = null; 
        Connection varB4EAC82CA7396A68D541C85D26508E83_1265941164 = null; 
        List l;
        long time = Long.MAX_VALUE;
        Connection c;
        Connection earliest = null;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_1288883934 = (l.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1565424725 = null;
            } 
        } 
        {
            int i = 0;
            int s = l.size();
            {
                c = (Connection) l.get(i);
                long t;
                t = c.getCreateTime();
                {
                    earliest = c;
                    time = t;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1265941164 = earliest;
        Connection varA7E53CE21691AB073D9660D615818899_342612272; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_342612272 = varB4EAC82CA7396A68D541C85D26508E83_1565424725;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_342612272 = varB4EAC82CA7396A68D541C85D26508E83_1265941164;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_342612272.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_342612272;
        
        
        
        
        
        
        
            
        
        
            
            
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.467 -0400", hash_original_method = "259AE56D0CCB8C7D336EA51014BAFBD4", hash_generated_method = "22DCAC2C9C917FE3657A32D584709E9D")
    public long getEarliestCreateTime() {
        List l;
        long time = Long.MAX_VALUE;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_2091230177 = (l.size() == 0);
        } 
        {
            int i = 0;
            int s = l.size();
            {
                Connection c = (Connection) l.get(i);
                long t;
                t = c.getCreateTime();
                time = t < time ? t : time;
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1773673204 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1773673204;
        
        
        
        
        
            
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.468 -0400", hash_original_method = "4FCBF4743EBF22DA857FFD7B3BA209EB", hash_generated_method = "456A372C2822F2153B5495A8B5B15373")
    public long getEarliestConnectTime() {
        long time = Long.MAX_VALUE;
        List l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_691831666 = (l.size() == 0);
        } 
        {
            int i = 0;
            int s = l.size();
            {
                Connection c = (Connection) l.get(i);
                long t;
                t = c.getConnectTime();
                time = t < time ? t : time;
            } 
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_965024630 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_965024630;
        
        
        
        
            
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.468 -0400", hash_original_method = "0639B31F7C82A2CFB39F855F1440727E", hash_generated_method = "666D2FD988F3A9A778EDC82B561F058C")
    public boolean isDialingOrAlerting() {
        boolean var4891BE681B8E73045981C6F526C7E15A_874000141 = (getState().isDialing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231882515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231882515;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.469 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "9B68E35A60B3E1988D67A9A7F6151CBB")
    public boolean isRinging() {
        boolean varA5B5B8E5598F4DA7A9B0210CD17D8F3C_1090696477 = (getState().isRinging());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033392997 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033392997;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.469 -0400", hash_original_method = "D3D12A7045E5E26EBF89650CB45460A7", hash_generated_method = "7BDD0D05F0EDB6AF07990B4A706DB552")
    public Connection getLatestConnection() {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1432027404 = null; 
        Connection varB4EAC82CA7396A68D541C85D26508E83_1154640463 = null; 
        List l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_1371742177 = (l.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1432027404 = null;
            } 
        } 
        long time = 0;
        Connection latest = null;
        {
            int i = 0;
            int s = l.size();
            {
                Connection c = (Connection) l.get(i);
                long t = c.getCreateTime();
                {
                    latest = c;
                    time = t;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1154640463 = latest;
        Connection varA7E53CE21691AB073D9660D615818899_820790297; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_820790297 = varB4EAC82CA7396A68D541C85D26508E83_1432027404;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_820790297 = varB4EAC82CA7396A68D541C85D26508E83_1154640463;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_820790297.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_820790297;
        
        
        
            
        
        
        
        
            
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.470 -0400", hash_original_method = "26476B959AA4096CC4669AF0A1E29ED1", hash_generated_method = "0C48D59C41B1BA63B8A3B97619C216F2")
    public boolean isGeneric() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228088321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_228088321;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.470 -0400", hash_original_method = "3EA9E9B35830CEB0D3B80D105DCC59E2", hash_generated_method = "514423FE597FCFBA9E7023F2C6BFEFDF")
    public void setGeneric(boolean generic) {
        isGeneric = generic;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.470 -0400", hash_original_method = "595BC30A45DB7D292DF19DA7A823683F", hash_generated_method = "371DFE99BB8779DF19B1DFA9C8D5B80A")
    public void hangupIfAlive() {
        {
            boolean var9E19D3C659A4F7F587B0E2ED224F58BA_1306849670 = (getState().isAlive());
            {
                try 
                {
                    hangup();
                } 
                catch (CallStateException ex)
                { }
            } 
        } 
        
        
            
                
            
                
            
        
    }

    
    public enum State {
        IDLE, ACTIVE, HOLDING, DIALING, ALERTING, INCOMING, WAITING, DISCONNECTED, DISCONNECTING;
        @DSModeled(DSC.SAFE)
        public boolean isAlive() {
            return !(this == IDLE || this == DISCONNECTED || this == DISCONNECTING);
        }
        @DSModeled(DSC.SAFE)
        public boolean isRinging() {
            return this == INCOMING || this == WAITING;
        }
        @DSModeled(DSC.SAFE)
        public boolean isDialing() {
            return this == DIALING || this == ALERTING;
        }
    }

    
}

