package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.Via;
import gov.nist.javax.sip.message.SIPResponse;
import java.security.MessageDigest;
import java.util.HashSet;

public class Utils implements UtilsExt {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.938 -0400", hash_original_method = "4A92704CBFAAEA8B3C41F62FC777198C", hash_generated_method = "4A92704CBFAAEA8B3C41F62FC777198C")
    public Utils ()
    {
        
    }


        @DSModeled(DSC.SAFE)
    public static Utils getInstance() {
        return instance;
    }

    
        public static String toHexString(byte b[]) {
        int pos = 0;
        char[] c = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            c[pos++] = toHex[(b[i] >> 4) & 0x0F];
            c[pos++] = toHex[b[i] & 0x0f];
        }
        return new String(c);
    }

    
        public static String getQuotedString(String str) {
        return '"' + str.replace( "\"", "\\\"" ) + '"';
    }

    
        @DSModeled(DSC.SAFE)
    protected static String reduceString(String input) {
        String newString = input.toLowerCase();
        int len = newString.length();
        String retval = "";
        for (int i = 0; i < len; i++) {
            if (newString.charAt(i) == ' ' || newString.charAt(i) == '\t')
                continue;
            else
                retval += newString.charAt(i);
        }
        return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.939 -0400", hash_original_method = "8B9CD4355F65A61EBC08146A51CEAFC7", hash_generated_method = "346A6E1B3328171B634A19A2157DEFEF")
    public synchronized String generateCallIdentifier(String address) {
        addTaint(address.getTaint());
        String date = Long.toString(System.currentTimeMillis() + callIDCounter++
                    + rand.nextLong());
        byte cid[] = digester.digest(date.getBytes());
        String cidString = Utils.toHexString(cid);
String var3A784E5AEB9086FAC40382C7254AF3F6_283084151 =         cidString + "@" + address;
        var3A784E5AEB9086FAC40382C7254AF3F6_283084151.addTaint(taint);
        return var3A784E5AEB9086FAC40382C7254AF3F6_283084151;
        
        
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.939 -0400", hash_original_method = "9AA82EE1A1BEF7CB34AB2EE7CC0970FC", hash_generated_method = "F5BB101F8394067C02870F2FB83EC4BD")
    public synchronized String generateTag() {
String var2334723CC90AD9070F7AA233F208C289_715474797 =         Integer.toHexString(rand.nextInt());
        var2334723CC90AD9070F7AA233F208C289_715474797.addTaint(taint);
        return var2334723CC90AD9070F7AA233F208C289_715474797;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.940 -0400", hash_original_method = "7AE3A829A02A70B14E30FF17666004A8", hash_generated_method = "9DAFDF0FA9ACD2CB0D35921ACEF2603E")
    public synchronized String generateBranchId() {
        long num = rand.nextLong() + Utils.counter++  + System.currentTimeMillis();
        byte bid[] = digester.digest(Long.toString(num).getBytes());
String var9F4A62C177DDEACC16AA2E7B03FF1348_384256951 =         SIPConstants.BRANCH_MAGIC_COOKIE + Utils.toHexString(bid) + this.signature;
        var9F4A62C177DDEACC16AA2E7B03FF1348_384256951.addTaint(taint);
        return var9F4A62C177DDEACC16AA2E7B03FF1348_384256951;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.940 -0400", hash_original_method = "C81ECDD34C7D54B91D88A9F561BC20EF", hash_generated_method = "C7775B5913D9726B990B21DB3064C139")
    public boolean responseBelongsToUs(SIPResponse response) {
        addTaint(response.getTaint());
        Via topmostVia = response.getTopmostVia();
        String branch = topmostVia.getBranch();
        boolean varDA10D57C566756FBE5428B7E3642068D_228182166 = (branch != null && branch.endsWith(this.signature));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802580615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802580615;
        
        
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static String getSignature() {
        return signature;
    }

    
        @DSModeled(DSC.SAFE)
    public static void main(String[] args) {
        HashSet branchIds = new HashSet();
        for (int b = 0; b < 100000; b++) {
            String bid = Utils.getInstance().generateBranchId();
            if (branchIds.contains(bid)) {
                throw new RuntimeException("Duplicate Branch ID");
            } else {
                branchIds.add(bid);
            }
        }
        System.out.println("Done!!");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.949 -0400", hash_original_field = "0E286381F5EE9C742D836883DC1DB90C", hash_generated_field = "75DF3FBD64D6EA0108E137FADE714C1F")

    private static MessageDigest digester;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.949 -0400", hash_original_field = "34D1C35063280164066ECC517050DA0B", hash_generated_field = "7E238EAE548E2EE44C039EC6AC75AC3D")

    private static java.util.Random rand;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.949 -0400", hash_original_field = "CDC8BEE919EF2CD97F33CAFC1AD12080", hash_generated_field = "AE51E4CF92FF648669819D7B0481713C")

    private static long counter = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.950 -0400", hash_original_field = "14BBD058D9B067ADFEE3A864FC3182FD", hash_generated_field = "6CF948D0E8697F6CBD93101CC8EE4EA8")

    private static int callIDCounter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.950 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "512F210EC728FA3837ABDE0579788961")

    private static String signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.950 -0400", hash_original_field = "0E6E923839CD164B73A56473EDEA9972", hash_generated_field = "B26221B75DD3069F1E7CEE68F1C1307C")

    private static Utils instance = new Utils();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.950 -0400", hash_original_field = "AE6F89DC8E13D1AB97EC10B40F16B520", hash_generated_field = "D08ABC333720B6C25B9902ED84803CDE")

    private static final char[] toHex = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        } catch (Exception ex) {
            throw new RuntimeException("Could not intialize Digester ", ex);
        }
        rand = new java.util.Random();
        signature = toHexString(Integer.toString(Math.abs( rand.nextInt() % 1000 )).getBytes());
    }
    
}

