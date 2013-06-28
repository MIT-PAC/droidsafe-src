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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.589 -0400", hash_original_method = "0E6BC3DAACB3346655A889CA6E7D1AFA", hash_generated_method = "69110DD784D65387D879431CB3C0A133")
    private  BlockGuard() {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.589 -0400", hash_original_field = "6CE6D5E4B5FBA369F3354FE41C84F79F", hash_generated_field = "22097F0CB35E769FF60D37AAB85D45C7")

        private int mPolicyState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.590 -0400", hash_original_field = "A48ABC5FD986ABF086D4D9B0811E6099", hash_generated_field = "F2E65299053200088B86F3CC2B587F55")

        private int mPolicyViolated;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.590 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "5FF5AC6E2E7DC6F2224CC91B0CC8DE72")

        private String mMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.590 -0400", hash_original_method = "FE59F9C45AD8795BBBCB0FEAFA85E7D3", hash_generated_method = "A3AA704AF27FC9159869D7C5908C2BB6")
        public  BlockGuardPolicyException(int policyState, int policyViolated) {
            this(policyState, policyViolated, null);
            addTaint(policyState);
            addTaint(policyViolated);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.590 -0400", hash_original_method = "CA74B61F12E68CE7397040DE549DC38F", hash_generated_method = "0AE0F1A66733E14D239803D5E1E8520F")
        public  BlockGuardPolicyException(int policyState, int policyViolated, String message) {
            mPolicyState = policyState;
            mPolicyViolated = policyViolated;
            mMessage = message;
            fillInStackTrace();
            // ---------- Original Method ----------
            //mPolicyState = policyState;
            //mPolicyViolated = policyViolated;
            //mMessage = message;
            //fillInStackTrace();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.590 -0400", hash_original_method = "7E4A409F6FF395255A09FF646F59C182", hash_generated_method = "569BCF828591554F5FF39439915ED6F9")
        public int getPolicy() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037016033 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037016033;
            // ---------- Original Method ----------
            //return mPolicyState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.590 -0400", hash_original_method = "51330C8A3B9EAC192FDD6907E318F7AB", hash_generated_method = "5F4E04A5494E956D8001B9C865FB970F")
        public int getPolicyViolation() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509996075 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509996075;
            // ---------- Original Method ----------
            //return mPolicyViolated;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_method = "AA2ABAF31AA2D7A8C7A88450DEB5E574", hash_generated_method = "38A6830ACEA931CD6EDCE24916965607")
        public String getMessage() {
            String varB4EAC82CA7396A68D541C85D26508E83_1288596970 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1288596970 = "policy=" + mPolicyState + " violation=" + mPolicyViolated +
                    (mMessage == null ? "" : (" msg=" + mMessage));
            varB4EAC82CA7396A68D541C85D26508E83_1288596970.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1288596970;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "7808E83091E8CCA64936674053812D87", hash_generated_field = "5D99117C513E4B485F5F93E6AAEB8777")

    public static final int DISALLOW_DISK_WRITE = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "CD8E59A0C434378EA900BC07828E486A", hash_generated_field = "6C6117464ADDC1180A74752B4BB63E94")

    public static final int DISALLOW_DISK_READ = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "F5454BD49006CACA9E37C8C04685C3BE", hash_generated_field = "1EA44A10BD476A5E34251684ADD3286E")

    public static final int DISALLOW_NETWORK = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "F6F68F2E3C4ABA38EBDAC0054EE7A905", hash_generated_field = "EEFA2E788AD47F5ED1B77969A6D78581")

    public static final int PASS_RESTRICTIONS_VIA_RPC = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "8FC0A17F12BDF8741B92E5F01FD7DCB6", hash_generated_field = "AD440199AC90AA853DAE6E553309E61E")

    public static final int PENALTY_LOG = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "5237B015D0FD40554D978C3F16F56117", hash_generated_field = "1B09956BCE6604535346C86F86199656")

    public static final int PENALTY_DIALOG = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "F3FAE1CCEDA4AC19AA37F2365135E9ED", hash_generated_field = "36B2F4DE7C0AEF684C2D4A0EA98A5FF6")

    public static final int PENALTY_DEATH = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.591 -0400", hash_original_field = "E0D7D8362D54E1FE8526FC9BC7628CBD", hash_generated_field = "4AA8094D0A870BF58F179845EAB966A1")

    public static final Policy LAX_POLICY = new Policy() {
            public void onWriteToDisk() {}
            public void onReadFromDisk() {}
            public void onNetwork() {}
            public int getPolicyMask() {
                return 0;
            }
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.592 -0400", hash_original_field = "FA0644FE78DE29FC3B6373BBD0514481", hash_generated_field = "D74F07E1FC56C17661F0BEB3EE20011C")

    private static ThreadLocal<Policy> threadPolicy = new ThreadLocal<Policy>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.592 -0400", hash_original_method = "DA8783B28EC2A21BB8B273AEAF0100E1", hash_generated_method = "FECE05391A71714F72ACFF49F2BE0BBC")
        @Override
        protected Policy initialValue() {
            Policy varB4EAC82CA7396A68D541C85D26508E83_1583563944 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1583563944 = LAX_POLICY;
            varB4EAC82CA7396A68D541C85D26508E83_1583563944.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1583563944;
            // ---------- Original Method ----------
            //return LAX_POLICY;
        }

        
};
}

