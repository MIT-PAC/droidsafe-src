package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.SocketException;
import java.nio.charset.Charsets;

public final class BlockGuard {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.208 -0400", hash_original_method = "0E6BC3DAACB3346655A889CA6E7D1AFA", hash_generated_method = "69110DD784D65387D879431CB3C0A133")
    @DSModeled(DSC.SAFE)
    private BlockGuard() {
        // ---------- Original Method ----------
    }

    
        public static Policy getThreadPolicy() {
        return threadPolicy.get();
    }

    
        public static void setThreadPolicy(Policy policy) {
        if (policy == null) {
            throw new NullPointerException("policy == null");
        }
        threadPolicy.set(policy);
    }

    
    public static class BlockGuardPolicyException extends RuntimeException {
        private int mPolicyState;
        private int mPolicyViolated;
        private String mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.209 -0400", hash_original_method = "FE59F9C45AD8795BBBCB0FEAFA85E7D3", hash_generated_method = "065306A93B4DC706D54F752F89675BC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BlockGuardPolicyException(int policyState, int policyViolated) {
            this(policyState, policyViolated, null);
            dsTaint.addTaint(policyState);
            dsTaint.addTaint(policyViolated);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.209 -0400", hash_original_method = "CA74B61F12E68CE7397040DE549DC38F", hash_generated_method = "6284D597E455902BB5C57E0629850BCE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BlockGuardPolicyException(int policyState, int policyViolated, String message) {
            dsTaint.addTaint(message);
            dsTaint.addTaint(policyState);
            dsTaint.addTaint(policyViolated);
            fillInStackTrace();
            // ---------- Original Method ----------
            //mPolicyState = policyState;
            //mPolicyViolated = policyViolated;
            //mMessage = message;
            //fillInStackTrace();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.209 -0400", hash_original_method = "7E4A409F6FF395255A09FF646F59C182", hash_generated_method = "D20FACDABC353C5D59DC2E6751D3FBFE")
        @DSModeled(DSC.SAFE)
        public int getPolicy() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPolicyState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.209 -0400", hash_original_method = "51330C8A3B9EAC192FDD6907E318F7AB", hash_generated_method = "A4CE501F3DC1AEF03D433A654F1B103D")
        @DSModeled(DSC.SAFE)
        public int getPolicyViolation() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPolicyViolated;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.209 -0400", hash_original_method = "AA2ABAF31AA2D7A8C7A88450DEB5E574", hash_generated_method = "74CB3981E1D9E4CD9A65BBB0553C6B68")
        @DSModeled(DSC.SAFE)
        public String getMessage() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "policy=" + mPolicyState + " violation=" + mPolicyViolated +
                    //(mMessage == null ? "" : (" msg=" + mMessage));
        }

        
    }


    
    public interface Policy {
        
        void onWriteToDisk();

        
        void onReadFromDisk();

        
        void onNetwork();

        
        int getPolicyMask();
    }
    
    public static final int DISALLOW_DISK_WRITE = 0x01;
    public static final int DISALLOW_DISK_READ = 0x02;
    public static final int DISALLOW_NETWORK = 0x04;
    public static final int PASS_RESTRICTIONS_VIA_RPC = 0x08;
    public static final int PENALTY_LOG = 0x10;
    public static final int PENALTY_DIALOG = 0x20;
    public static final int PENALTY_DEATH = 0x40;
    public static final Policy LAX_POLICY = new Policy() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.209 -0400", hash_original_method = "0E90B06880C2E9B3FF9130289C096B4D", hash_generated_method = "E73A577257996397E5B3EBF79B33930B")
        @DSModeled(DSC.SAFE)
        public void onWriteToDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.210 -0400", hash_original_method = "7E49F028D81EA77D7BF37C6768FECE64", hash_generated_method = "6396F58EBA1D7BA29BDE9D68F6B104AA")
        @DSModeled(DSC.SAFE)
        public void onReadFromDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.210 -0400", hash_original_method = "9014987F02727A033B15EAEBCF962455", hash_generated_method = "5BACCC817B5A4C0BAA8A14F39EFD6B18")
        @DSModeled(DSC.SAFE)
        public void onNetwork() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.210 -0400", hash_original_method = "4FDDD77F117ADACFDE6CA4C31E0B0180", hash_generated_method = "DE7F47FBDD1BDE730D1A5268C6408F00")
        @DSModeled(DSC.SAFE)
        public int getPolicyMask() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
}; //Transformed anonymous class
    private static ThreadLocal<Policy> threadPolicy = new ThreadLocal<Policy>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.210 -0400", hash_original_method = "DA8783B28EC2A21BB8B273AEAF0100E1", hash_generated_method = "D352ECDFF4D0581035C80D3202D9A0CF")
        @DSModeled(DSC.SAFE)
        @Override
        protected Policy initialValue() {
            return (Policy)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return LAX_POLICY;
        }

        
}; //Transformed anonymous class
}

