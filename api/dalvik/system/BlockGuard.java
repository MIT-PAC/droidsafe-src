package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public final class BlockGuard {

    /**
     * Get the current thread's policy.
     *
     * @return the current thread's policy.  Never returns null.
     *     Will return the LAX_POLICY instance if nothing else is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.500 -0500", hash_original_method = "9FC01971C286366EF078625A4546728B", hash_generated_method = "E2448DB23CC15E56AEE8D84F4508C607")
    
public static Policy getThreadPolicy() {
        return threadPolicy.get();
    }

    /**
     * Sets the current thread's block guard policy.
     *
     * @param policy policy to set.  May not be null.  Use the public LAX_POLICY
     *   if you want to unset the active policy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.503 -0500", hash_original_method = "AB1D490B0C91ECAF0905341A4596DD1E", hash_generated_method = "D6651CB0C4C022A0C40CC3A3B84D8335")
    
public static void setThreadPolicy(Policy policy) {
        if (policy == null) {
            throw new NullPointerException("policy == null");
        }
        threadPolicy.set(policy);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.438 -0500", hash_original_field = "1D315BC1873CC9DF2B504D0F6B890979", hash_generated_field = "41D3208000DEFD6D53CED0BAE928D3E5")

    // growing beyond just blocking/logging.

    public static final int DISALLOW_DISK_WRITE = 0x01;

    
    public static class BlockGuardPolicyException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.459 -0500", hash_original_field = "1AE9836DEC22F7D17F3EFC14412B9A1F", hash_generated_field = "22097F0CB35E769FF60D37AAB85D45C7")

        private  int mPolicyState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.461 -0500", hash_original_field = "ABD900F7EA31017E985FA6818B4F5CB9", hash_generated_field = "F2E65299053200088B86F3CC2B587F55")

        private  int mPolicyViolated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.464 -0500", hash_original_field = "AA6F183B8C0E9B6C851D4101DE6EFB65", hash_generated_field = "5FF5AC6E2E7DC6F2224CC91B0CC8DE72")

        private  String mMessage;   // may be null

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.468 -0500", hash_original_method = "FE59F9C45AD8795BBBCB0FEAFA85E7D3", hash_generated_method = "AB33499D9760C17EB8B2644FB0E84572")
        
public BlockGuardPolicyException(int policyState, int policyViolated) {
            this(policyState, policyViolated, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.470 -0500", hash_original_method = "CA74B61F12E68CE7397040DE549DC38F", hash_generated_method = "27A3D58671055C676C53A2837BFC996F")
        
public BlockGuardPolicyException(int policyState, int policyViolated, String message) {
            mPolicyState = policyState;
            mPolicyViolated = policyViolated;
            mMessage = message;
            fillInStackTrace();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.473 -0500", hash_original_method = "7E4A409F6FF395255A09FF646F59C182", hash_generated_method = "4235463EF38A6E5A53221C97F7B2FC3E")
        
public int getPolicy() {
            return mPolicyState;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.475 -0500", hash_original_method = "51330C8A3B9EAC192FDD6907E318F7AB", hash_generated_method = "0772710AB37BA670733FC3EE2AFCB5AF")
        
public int getPolicyViolation() {
            return mPolicyViolated;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.478 -0500", hash_original_method = "AA2ABAF31AA2D7A8C7A88450DEB5E574", hash_generated_method = "115A7BE97D13DB5D0A3713B9F0FA2346")
        
public String getMessage() {
            // Note: do not change this format casually.  It's
            // somewhat unfortunately Parceled and passed around
            // Binder calls and parsed back into an Exception by
            // Android's StrictMode.  This was the least invasive
            // option and avoided a gross mix of Java Serialization
            // combined with Parcels.
            return "policy=" + mPolicyState + " violation=" + mPolicyViolated +
                    (mMessage == null ? "" : (" msg=" + mMessage));
        }

        
    }


    
    public interface Policy {
        
        void onWriteToDisk();

        
        void onReadFromDisk();

        
        void onNetwork();

        
        int getPolicyMask();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.441 -0500", hash_original_field = "10C56D7E547128C6542891F6C95CA616", hash_generated_field = "6C6117464ADDC1180A74752B4BB63E94")

    public static final int DISALLOW_DISK_READ = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.443 -0500", hash_original_field = "B7362AE4E63647F305BD58EEC0BFCEB5", hash_generated_field = "1EA44A10BD476A5E34251684ADD3286E")

    public static final int DISALLOW_NETWORK = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.445 -0500", hash_original_field = "D3EBA66037632AEDE7890C7430969A42", hash_generated_field = "EEFA2E788AD47F5ED1B77969A6D78581")

    public static final int PASS_RESTRICTIONS_VIA_RPC = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.448 -0500", hash_original_field = "18447843D21EA9B30ED6EA1B8103C72A", hash_generated_field = "AD440199AC90AA853DAE6E553309E61E")

    public static final int PENALTY_LOG = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.450 -0500", hash_original_field = "67A2C54ADA6FBBA64CC72C0B9A697A1B", hash_generated_field = "1B09956BCE6604535346C86F86199656")

    public static final int PENALTY_DIALOG = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.453 -0500", hash_original_field = "BE667C23E13908C3A9F5E8A13874D02C", hash_generated_field = "36B2F4DE7C0AEF684C2D4A0EA98A5FF6")

    public static final int PENALTY_DEATH = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.695 -0400", hash_original_field = "E0D7D8362D54E1FE8526FC9BC7628CBD", hash_generated_field = "4AA8094D0A870BF58F179845EAB966A1")

    public static final Policy LAX_POLICY = new Policy() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.483 -0500", hash_original_method = "0E90B06880C2E9B3FF9130289C096B4D", hash_generated_method = "B7E60A76904F6F3C8ECA71212B7FA36A")
        
public void onWriteToDisk() {}
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.485 -0500", hash_original_method = "7E49F028D81EA77D7BF37C6768FECE64", hash_generated_method = "AB3F297EAC03D2171E57576FA170278F")
        
public void onReadFromDisk() {}
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.488 -0500", hash_original_method = "9014987F02727A033B15EAEBCF962455", hash_generated_method = "0331D31F43FEAA1D2BAEBB55A96511CB")
        
public void onNetwork() {}
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.490 -0500", hash_original_method = "4FDDD77F117ADACFDE6CA4C31E0B0180", hash_generated_method = "67B620CC8F62716A0D625F19534D39F1")
        
public int getPolicyMask() {
                return 0;
            }
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.592 -0400", hash_original_field = "FA0644FE78DE29FC3B6373BBD0514481", hash_generated_field = "D74F07E1FC56C17661F0BEB3EE20011C")

    private static ThreadLocal<Policy> threadPolicy = new ThreadLocal<Policy>() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.592 -0400", hash_original_method = "DA8783B28EC2A21BB8B273AEAF0100E1", hash_generated_method = "FECE05391A71714F72ACFF49F2BE0BBC")
        @Override
        protected Policy initialValue() {
            Policy varB4EAC82CA7396A68D541C85D26508E83_1583563944 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1583563944 = LAX_POLICY;
            varB4EAC82CA7396A68D541C85D26508E83_1583563944.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1583563944;
            
            
        }

        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.505 -0500", hash_original_method = "0E6BC3DAACB3346655A889CA6E7D1AFA", hash_generated_method = "57D476424577577C2CE8F431DE42A7DA")
    
private BlockGuard() {}
}

