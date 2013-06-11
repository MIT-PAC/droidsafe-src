package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.SocketException;
import java.nio.charset.Charsets;

public final class BlockGuard {
    public static final int DISALLOW_DISK_WRITE = 0x01;
    public static final int DISALLOW_DISK_READ = 0x02;
    public static final int DISALLOW_NETWORK = 0x04;
    public static final int PASS_RESTRICTIONS_VIA_RPC = 0x08;
    public static final int PENALTY_LOG = 0x10;
    public static final int PENALTY_DIALOG = 0x20;
    public static final int PENALTY_DEATH = 0x40;
    public static final Policy LAX_POLICY = new Policy() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "0E90B06880C2E9B3FF9130289C096B4D", hash_generated_method = "0953A917DC1A18D62E64853C1EDD01CF")
        @DSModeled(DSC.SAFE)
        public void onWriteToDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "7E49F028D81EA77D7BF37C6768FECE64", hash_generated_method = "5CA1A070A73D8E66C27277B20D594BE3")
        @DSModeled(DSC.SAFE)
        public void onReadFromDisk() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "9014987F02727A033B15EAEBCF962455", hash_generated_method = "F134CFCD22F119E4AE88F1F2297ED667")
        @DSModeled(DSC.SAFE)
        public void onNetwork() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "4FDDD77F117ADACFDE6CA4C31E0B0180", hash_generated_method = "F6D14FEAFED8A1D44E86717B04258541")
        @DSModeled(DSC.SAFE)
        public int getPolicyMask() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
}; //Transformed anonymous class
    private static ThreadLocal<Policy> threadPolicy = new ThreadLocal<Policy>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "DA8783B28EC2A21BB8B273AEAF0100E1", hash_generated_method = "BA4FDA64AA50FBBC8615C982D8D83CD4")
        @DSModeled(DSC.SAFE)
        @Override
        protected Policy initialValue() {
            return (Policy)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return LAX_POLICY;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "0E6BC3DAACB3346655A889CA6E7D1AFA", hash_generated_method = "7B14B1720F6FA56AB6EA6D08E00DA0C8")
    @DSModeled(DSC.SAFE)
    private BlockGuard() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "9FC01971C286366EF078625A4546728B", hash_generated_method = "E2448DB23CC15E56AEE8D84F4508C607")
    public static Policy getThreadPolicy() {
        return threadPolicy.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "AB1D490B0C91ECAF0905341A4596DD1E", hash_generated_method = "D6651CB0C4C022A0C40CC3A3B84D8335")
    public static void setThreadPolicy(Policy policy) {
        if (policy == null) {
            throw new NullPointerException("policy == null");
        }
        threadPolicy.set(policy);
    }

    
    public static class BlockGuardPolicyException extends RuntimeException {
        private final int mPolicyState;
        private final int mPolicyViolated;
        private final String mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "FE59F9C45AD8795BBBCB0FEAFA85E7D3", hash_generated_method = "34A95B1F2079D3364C36D06E6913628C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BlockGuardPolicyException(int policyState, int policyViolated) {
            this(policyState, policyViolated, null);
            dsTaint.addTaint(policyState);
            dsTaint.addTaint(policyViolated);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "CA74B61F12E68CE7397040DE549DC38F", hash_generated_method = "B2BB4CDE48AA7EC407099512C88160E4")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "7E4A409F6FF395255A09FF646F59C182", hash_generated_method = "FB1D143F6469B9A186D5B120AF4B2C95")
        @DSModeled(DSC.SAFE)
        public int getPolicy() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPolicyState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "51330C8A3B9EAC192FDD6907E318F7AB", hash_generated_method = "955132A7803BA52776C134B864A45941")
        @DSModeled(DSC.SAFE)
        public int getPolicyViolation() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPolicyViolated;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.321 -0400", hash_original_method = "AA2ABAF31AA2D7A8C7A88450DEB5E574", hash_generated_method = "04BB9CA8ECC8C11ABB18E45AD8B70774")
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
    
}


