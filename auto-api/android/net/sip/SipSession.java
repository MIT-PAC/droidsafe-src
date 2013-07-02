package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.RemoteException;
import android.util.Log;

public final class SipSession {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.168 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "B127E608132911BCC4FB99E4A8F915FC")

    private ISipSession mSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.168 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "55B4CC9A7CFEB5835D007742DA36AADE")

    private Listener mListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.169 -0400", hash_original_method = "B71DAA3D1365DDABF697A1D97F8D88A8", hash_generated_method = "36D981E3452C300DADB2CDC7CE07E3E6")
      SipSession(ISipSession realSession) {
        mSession = realSession;
        {
            try 
            {
                realSession.setListener(createListener());
            } 
            catch (RemoteException e)
            { }
        } 
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.169 -0400", hash_original_method = "26EA80DBAC1B6413B57EA6A425A19EE9", hash_generated_method = "588AC4DBA7B4CD249DF3DF0B977DB305")
      SipSession(ISipSession realSession, Listener listener) {
        this(realSession);
        setListener(listener);
        addTaint(realSession.getTaint());
        addTaint(listener.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.171 -0400", hash_original_method = "E9A721906097EBC1FEB98095FAB057F5", hash_generated_method = "7237537CEE7E12E50F1D6D3F82BE97FA")
    public String getLocalIp() {
        String varB4EAC82CA7396A68D541C85D26508E83_126475292 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1978077928 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_126475292 = mSession.getLocalIp();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1978077928 = "127.0.0.1";
        } 
        String varA7E53CE21691AB073D9660D615818899_407164893; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_407164893 = varB4EAC82CA7396A68D541C85D26508E83_126475292;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_407164893 = varB4EAC82CA7396A68D541C85D26508E83_1978077928;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_407164893.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_407164893;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.172 -0400", hash_original_method = "87F54D512869FBB2D14566F63922D1B6", hash_generated_method = "F3932578B252B027D443A7063D7E0A6C")
    public SipProfile getLocalProfile() {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_5615424 = null; 
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_1071237855 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_5615424 = mSession.getLocalProfile();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1071237855 = null;
        } 
        SipProfile varA7E53CE21691AB073D9660D615818899_1188328170; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1188328170 = varB4EAC82CA7396A68D541C85D26508E83_5615424;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1188328170 = varB4EAC82CA7396A68D541C85D26508E83_1071237855;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1188328170.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1188328170;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.173 -0400", hash_original_method = "D61110CB083F8C813E52FD778D269E44", hash_generated_method = "3099C03D48F869EE890D88CA7ED2534F")
    public SipProfile getPeerProfile() {
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_1968509822 = null; 
        SipProfile varB4EAC82CA7396A68D541C85D26508E83_330076624 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1968509822 = mSession.getPeerProfile();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_330076624 = null;
        } 
        SipProfile varA7E53CE21691AB073D9660D615818899_1992411258; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1992411258 = varB4EAC82CA7396A68D541C85D26508E83_1968509822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1992411258 = varB4EAC82CA7396A68D541C85D26508E83_330076624;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1992411258.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1992411258;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.174 -0400", hash_original_method = "9EA9E21B58E34C7FB49C45688377E72F", hash_generated_method = "3A1FA34CD28CDA82C5BC265EAA9D0B45")
    public int getState() {
        try 
        {
            int var5C9BD891D63C83243CB7DCB3EA826EE9_600639905 = (mSession.getState());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082059416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082059416;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.174 -0400", hash_original_method = "9EAE3F24E2C650B2D541A86A9F9A7795", hash_generated_method = "6DFEC013670F548B62D8F4B836B38FA2")
    public boolean isInCall() {
        try 
        {
            boolean var756F7B5AF584B3E3C76961D5CC547EFB_1104669272 = (mSession.isInCall());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256199873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256199873;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.175 -0400", hash_original_method = "A52F1B195D0D0A598BE5EAF9C188D1E2", hash_generated_method = "9EE150263980FAFB9E1E2FD4A5FF1470")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1188282997 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_381490522 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1188282997 = mSession.getCallId();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_381490522 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_388779068; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_388779068 = varB4EAC82CA7396A68D541C85D26508E83_1188282997;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_388779068 = varB4EAC82CA7396A68D541C85D26508E83_381490522;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_388779068.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_388779068;
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.176 -0400", hash_original_method = "DF1CB7C0481108A53612C7FB72F6204A", hash_generated_method = "B57A845A372FD6A039C823BE04B31497")
    public void setListener(Listener listener) {
        mListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.176 -0400", hash_original_method = "8D2FD08823732E1C2D815A7E90C0FC77", hash_generated_method = "726D65C48D55FF7A95B4275FB51BDB93")
    public void register(int duration) {
        try 
        {
            mSession.register(duration);
        } 
        catch (RemoteException e)
        { }
        addTaint(duration);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.177 -0400", hash_original_method = "E4AB4EE14705E79FAB12EC8A1515405F", hash_generated_method = "15915D17B734726F063C06BEDF2C586F")
    public void unregister() {
        try 
        {
            mSession.unregister();
        } 
        catch (RemoteException e)
        { }
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.177 -0400", hash_original_method = "D9BC3F90AB4006B9EA6C3281D0F8E8EF", hash_generated_method = "BB80CAB87054E9FC76A23B6CAE26547B")
    public void makeCall(SipProfile callee, String sessionDescription,
            int timeout) {
        try 
        {
            mSession.makeCall(callee, sessionDescription, timeout);
        } 
        catch (RemoteException e)
        { }
        addTaint(callee.getTaint());
        addTaint(sessionDescription.getTaint());
        addTaint(timeout);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.178 -0400", hash_original_method = "A5A5F75F0E41462274C36F9EA8217848", hash_generated_method = "7FA213D7CDE20F282EC35A936C3075A8")
    public void answerCall(String sessionDescription, int timeout) {
        try 
        {
            mSession.answerCall(sessionDescription, timeout);
        } 
        catch (RemoteException e)
        { }
        addTaint(sessionDescription.getTaint());
        addTaint(timeout);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.178 -0400", hash_original_method = "B98ACA998657ED3CD995605D9A274D2E", hash_generated_method = "E55C0707BC087D614AF4675C2179A526")
    public void endCall() {
        try 
        {
            mSession.endCall();
        } 
        catch (RemoteException e)
        { }
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.178 -0400", hash_original_method = "0DCF9DE8E2729C90E933890D545801E4", hash_generated_method = "C0DD866B31DD7DDFFCD669FC04F31793")
    public void changeCall(String sessionDescription, int timeout) {
        try 
        {
            mSession.changeCall(sessionDescription, timeout);
        } 
        catch (RemoteException e)
        { }
        addTaint(sessionDescription.getTaint());
        addTaint(timeout);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.179 -0400", hash_original_method = "457DE503669A22F9796CDD5163AC081E", hash_generated_method = "E28EAFBAECD6702A8AF2FE62D771F45C")
     ISipSession getRealSession() {
        ISipSession varB4EAC82CA7396A68D541C85D26508E83_1541542798 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1541542798 = mSession;
        varB4EAC82CA7396A68D541C85D26508E83_1541542798.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1541542798;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.179 -0400", hash_original_method = "346C5E2A278D0A9A8B61352C5712D581", hash_generated_method = "753FEDBC0C7A1559393E2A1E4BBC170B")
    private ISipSessionListener createListener() {
        ISipSessionListener varB4EAC82CA7396A68D541C85D26508E83_344632529 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_344632529 = new ISipSessionListener.Stub() {
            public void onCalling(ISipSession session) {
                if (mListener != null) {
                    mListener.onCalling(SipSession.this);
                }
            }
            public void onRinging(ISipSession session, SipProfile caller,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onRinging(SipSession.this, caller,
                            sessionDescription);
                }
            }
            public void onRingingBack(ISipSession session) {
                if (mListener != null) {
                    mListener.onRingingBack(SipSession.this);
                }
            }
            public void onCallEstablished(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallEstablished(SipSession.this,
                            sessionDescription);
                }
            }
            public void onCallEnded(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallEnded(SipSession.this);
                }
            }
            public void onCallBusy(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallBusy(SipSession.this);
                }
            }
            public void onCallTransferring(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallTransferring(
                            new SipSession(session, SipSession.this.mListener),
                            sessionDescription);
                }
            }
            public void onCallChangeFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onCallChangeFailed(SipSession.this, errorCode,
                            message);
                }
            }
            public void onError(ISipSession session, int errorCode, String message) {
                if (mListener != null) {
                    mListener.onError(SipSession.this, errorCode, message);
                }
            }
            public void onRegistering(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistering(SipSession.this);
                }
            }
            public void onRegistrationDone(ISipSession session, int duration) {
                if (mListener != null) {
                    mListener.onRegistrationDone(SipSession.this, duration);
                }
            }
            public void onRegistrationFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onRegistrationFailed(SipSession.this, errorCode,
                            message);
                }
            }
            public void onRegistrationTimeout(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistrationTimeout(SipSession.this);
                }
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_344632529.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_344632529;
        
        
    }

    
    public static class State {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "362016197A85F3060127375CB2C169F9")
        private  State() {
            
        }

        
        public static String toString(int state) {
            switch (state) {
                case READY_TO_CALL:
                    return "READY_TO_CALL";
                case REGISTERING:
                    return "REGISTERING";
                case DEREGISTERING:
                    return "DEREGISTERING";
                case INCOMING_CALL:
                    return "INCOMING_CALL";
                case INCOMING_CALL_ANSWERING:
                    return "INCOMING_CALL_ANSWERING";
                case OUTGOING_CALL:
                    return "OUTGOING_CALL";
                case OUTGOING_CALL_RING_BACK:
                    return "OUTGOING_CALL_RING_BACK";
                case OUTGOING_CALL_CANCELING:
                    return "OUTGOING_CALL_CANCELING";
                case IN_CALL:
                    return "IN_CALL";
                case PINGING:
                    return "PINGING";
                default:
                    return "NOT_DEFINED";
            }
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "99A1F425B57D19FD75E48DF2C2C74A47", hash_generated_field = "D6CF7815116771C30F5505C0D30DAAA0")

        public static final int READY_TO_CALL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "23212F5EE4F8A111A02BC17B034D7D77", hash_generated_field = "6E8D637253813E25EE79327490FD11DB")

        public static final int REGISTERING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "238419291A66C1089DF7A69A3DCDAE34", hash_generated_field = "53325B9453E2CDBB5536AA0006D59656")

        public static final int DEREGISTERING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "7F7D4BEEA76C0E0FBB872E6F7B2C9E42", hash_generated_field = "4CF84D38E6E85F0013C36CDED43365C3")

        public static final int INCOMING_CALL = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "B7BB9561DD6FD2BDAA83862BE868FC7C", hash_generated_field = "8FCBA6A42A23BE1381F16A8A22F19DFB")

        public static final int INCOMING_CALL_ANSWERING = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "9D8A65355A87278E5637B5FCA9F77F71", hash_generated_field = "D525E8AB9F7FA02B8F0A85C344DB10F6")

        public static final int OUTGOING_CALL = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "D6A1E138D04923F28A4070DA4D4C3CB8", hash_generated_field = "427EF79B93399A5C3B799BBBE9407455")

        public static final int OUTGOING_CALL_RING_BACK = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "8A154CBDEBD55CB733461C499E6BFB17", hash_generated_field = "03C3904064D9ACFD5D047226208158C2")

        public static final int OUTGOING_CALL_CANCELING = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "0049140B8BB0B18A3B2E9943AB155113", hash_generated_field = "2DD221BAEB49EF885927070B38698CD6")

        public static final int IN_CALL = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "785460D49D2EB9EA797E7FE950A2EDF6", hash_generated_field = "FD07CBF55A8245950B7B2648AFEEBDFB")

        public static final int PINGING = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "1624A640D44E34DB103131BCABD62C6A", hash_generated_field = "43AC0184E67B2E974A2CDEEC81A3D3DF")

        public static final int ENDING_CALL = 10;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_field = "BFB26318EC54871807746114F98B080E", hash_generated_field = "777618F477CD835F0BBFD9A5E1AF42B8")

        public static final int NOT_DEFINED = 101;
    }


    
    public static class Listener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.180 -0400", hash_original_method = "5575F820891B6AD64AFC44C76A4BA5AF", hash_generated_method = "5575F820891B6AD64AFC44C76A4BA5AF")
        public Listener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.181 -0400", hash_original_method = "AE0E913F9E3F8804DBC653BF8673EC2F", hash_generated_method = "DEA829A09039A527CA98846EDC2F4ACF")
        public void onCalling(SipSession session) {
            
            addTaint(session.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.181 -0400", hash_original_method = "A6495E0C14482D9554C3F987B616D040", hash_generated_method = "D2FE500449CA2504C9B71457B8EA5453")
        public void onRinging(SipSession session, SipProfile caller,
                String sessionDescription) {
            
            addTaint(session.getTaint());
            addTaint(caller.getTaint());
            addTaint(sessionDescription.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.181 -0400", hash_original_method = "3040682D1BCFEA9BA338FA9FE200A62D", hash_generated_method = "734D120B16431C158B81B709F8D3F8DF")
        public void onRingingBack(SipSession session) {
            
            addTaint(session.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.181 -0400", hash_original_method = "E5D299BA3CDE0EE166AC2795783FB427", hash_generated_method = "243BEA7166B8A5E29C68ED25D0865C26")
        public void onCallEstablished(SipSession session,
                String sessionDescription) {
            
            addTaint(session.getTaint());
            addTaint(sessionDescription.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.182 -0400", hash_original_method = "711404AF80F30F53943AF0817E2DC7DA", hash_generated_method = "4B4B0C8857AD559F3C6FAE56F4202E36")
        public void onCallEnded(SipSession session) {
            
            addTaint(session.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.182 -0400", hash_original_method = "DF73FA582D888219D7BAD8AC6A6DFD56", hash_generated_method = "3CB7A353A87EFF26ADA549ED713B3DD5")
        public void onCallBusy(SipSession session) {
            
            addTaint(session.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.182 -0400", hash_original_method = "BA5AD9CB5800C0FF06E65720317D213F", hash_generated_method = "9389B51D6338B1B039E32D37BAF2C49F")
        public void onCallTransferring(SipSession newSession,
                String sessionDescription) {
            
            addTaint(newSession.getTaint());
            addTaint(sessionDescription.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.183 -0400", hash_original_method = "4CD681E2D11D80A916993A5E2A67B6D2", hash_generated_method = "D7EF0224F0CDF59CBF008227DAF727E4")
        public void onError(SipSession session, int errorCode,
                String errorMessage) {
            
            addTaint(session.getTaint());
            addTaint(errorCode);
            addTaint(errorMessage.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.183 -0400", hash_original_method = "98747504BDA403336DDC3899112D7C4E", hash_generated_method = "5F24C8B8159D82EF6700BA14B872750F")
        public void onCallChangeFailed(SipSession session, int errorCode,
                String errorMessage) {
            
            addTaint(session.getTaint());
            addTaint(errorCode);
            addTaint(errorMessage.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.184 -0400", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "49556F3917EE074EE7287D4C2426EBC3")
        public void onRegistering(SipSession session) {
            
            addTaint(session.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.184 -0400", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "FBEF814628A6B17E4528CB04E1F2F9B1")
        public void onRegistrationDone(SipSession session, int duration) {
            
            addTaint(session.getTaint());
            addTaint(duration);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.185 -0400", hash_original_method = "3E873AF3736F468DF3025CAE14D73D95", hash_generated_method = "27A36AAC9516CB737E4D229703284149")
        public void onRegistrationFailed(SipSession session, int errorCode,
                String errorMessage) {
            
            addTaint(session.getTaint());
            addTaint(errorCode);
            addTaint(errorMessage.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.186 -0400", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "92DD4357599040EC3BD89E95FDDF4AD7")
        public void onRegistrationTimeout(SipSession session) {
            
            addTaint(session.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.186 -0400", hash_original_field = "D9ED94DB6A5D4F0166BBD806D4CCC0A3", hash_generated_field = "C71A0754A378907E73E85A0E7FA4A060")

    private static final String TAG = "SipSession";
    
    public void onCallBusy(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallBusy(SipSession.this);
                }
            }
    
    
    public void onRegistrationFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onRegistrationFailed(SipSession.this, errorCode,
                            message);
                }
            }
    
    
    public void onCallEstablished(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallEstablished(SipSession.this,
                            sessionDescription);
                }
            }
    
    
    public void onRinging(ISipSession session, SipProfile caller,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onRinging(SipSession.this, caller,
                            sessionDescription);
                }
            }
    
    
    public void onRegistrationTimeout(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistrationTimeout(SipSession.this);
                }
            }
    
    
    public void onCalling(ISipSession session) {
                if (mListener != null) {
                    mListener.onCalling(SipSession.this);
                }
            }
    
    
    public void onRingingBack(ISipSession session) {
                if (mListener != null) {
                    mListener.onRingingBack(SipSession.this);
                }
            }
    
    
    public void onCallEnded(ISipSession session) {
                if (mListener != null) {
                    mListener.onCallEnded(SipSession.this);
                }
            }
    
    
    public void onCallTransferring(ISipSession session,
                    String sessionDescription) {
                if (mListener != null) {
                    mListener.onCallTransferring(
                            new SipSession(session, SipSession.this.mListener),
                            sessionDescription);
                }
            }
    
    
    public void onRegistrationDone(ISipSession session, int duration) {
                if (mListener != null) {
                    mListener.onRegistrationDone(SipSession.this, duration);
                }
            }
    
    
    public void onError(ISipSession session, int errorCode, String message) {
                if (mListener != null) {
                    mListener.onError(SipSession.this, errorCode, message);
                }
            }
    
    
    public void onCallChangeFailed(ISipSession session, int errorCode,
                    String message) {
                if (mListener != null) {
                    mListener.onCallChangeFailed(SipSession.this, errorCode,
                            message);
                }
            }
    
    
    public void onRegistering(ISipSession session) {
                if (mListener != null) {
                    mListener.onRegistering(SipSession.this);
                }
            }
    
}

