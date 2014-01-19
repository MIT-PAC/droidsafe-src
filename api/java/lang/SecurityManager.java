package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;

public class SecurityManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.788 -0500", hash_original_field = "DE939C5B9522574898036292C1D8C875", hash_generated_field = "9E5AF9E744782F4ACD2178CD4DBD0985")

    @Deprecated
    protected boolean inCheck;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.790 -0500", hash_original_method = "7FD71E6D3FB4A8DD9BF04FA4D2AAA4D4", hash_generated_method = "FD88BDF8371DB2DFC2413091C4C1CFA8")
    
public SecurityManager() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.793 -0500", hash_original_method = "33353E03F38CCE3C205F21DCE963F727", hash_generated_method = "F31C239C09C57B54D39D5E6D19D0C89A")
    
public void checkAccept(String host, int port) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.795 -0500", hash_original_method = "36F107888B3E77E3CF49B5177EDF7E9A", hash_generated_method = "50AA24FF1035C95D010AF948EF0CA083")
    
public void checkAccess(Thread thread) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.798 -0500", hash_original_method = "5AA7E51DAAAF233E2DDB8D1EE8363A8E", hash_generated_method = "1B606F7393C49706FE86711F1D86456F")
    
public void checkAccess(ThreadGroup group) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.800 -0500", hash_original_method = "3BD498F27EF913D40B889A93E2AA24F9", hash_generated_method = "4E174ED8D966638DC665E33B0D4E439D")
    
public void checkConnect(String host, int port) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.802 -0500", hash_original_method = "2D5E761F7C6DB4BDDDC273A07ED405C0", hash_generated_method = "4BE44D8D7ADF393287F48FC2F07F6B2D")
    
public void checkConnect(String host, int port, Object context) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.804 -0500", hash_original_method = "8490F7E6ADD8012AF63244E1903E9866", hash_generated_method = "FE057A28A26B3D9996FEBEDA44CD4A3C")
    
public void checkCreateClassLoader() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.807 -0500", hash_original_method = "0B17A1C3AA9D11809AA604D4E5BD4994", hash_generated_method = "E2C3AC7ACCA748B231C5DC4A19A118A7")
    
public void checkDelete(String file) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.809 -0500", hash_original_method = "7C003C59CAB570CD3B63381DBAA3AF4E", hash_generated_method = "4FE7BCCFA46A3A207A6C4F90E9CB788F")
    
public void checkExec(String cmd) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.811 -0500", hash_original_method = "8A9ADA58552041193904C8083A11F7F6", hash_generated_method = "CBA16549CEEACCDA2979A90BCFCCBB18")
    
public void checkExit(int status) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.813 -0500", hash_original_method = "75433C5D6CF4249C0EE246BC57BF57E2", hash_generated_method = "707DC2F43D18A2B99BD71FBE3CDC9E38")
    
public void checkLink(String libName) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.816 -0500", hash_original_method = "5412847302AF42E3061C6779693DB418", hash_generated_method = "3CDA71291D66F3B4BE315D13E0321DF0")
    
public void checkListen(int port) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.818 -0500", hash_original_method = "8873C7B5DD5CF23CB18ABA2720E20660", hash_generated_method = "AA7149EE5F348D69C30D2AA780A04B76")
    
public void checkMemberAccess(Class<?> cls, int type) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.820 -0500", hash_original_method = "0D776561D024E069F4378E17ED49E5AF", hash_generated_method = "A0566A30131FFBE8D1C6CF5BC01FDA8D")
    
public void checkMulticast(InetAddress maddr) { }

    /**
     * @deprecated use {@link #checkMulticast(java.net.InetAddress)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.823 -0500", hash_original_method = "B705963A40DC1EBCB270E0041777CD02", hash_generated_method = "4A90964ADAA5424137E953B1EC4D1A28")
    
@Deprecated public void checkMulticast(InetAddress maddr, byte ttl) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.826 -0500", hash_original_method = "1E8CF02717496E9B31EA8F152A6EAAD3", hash_generated_method = "88C927198B40F3D70992F00847497945")
    
public void checkPackageAccess(String packageName) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.828 -0500", hash_original_method = "15FB53D386245A148D9A0D9EA27D53FA", hash_generated_method = "3FC43408A7A0DD6603B93C0F581CFC19")
    
public void checkPackageDefinition(String packageName) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.830 -0500", hash_original_method = "03937928889C65B1E71F0E79371D5926", hash_generated_method = "AF486419FCC4E2E75FC3D3F03D7C927E")
    
public void checkPropertiesAccess() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.832 -0500", hash_original_method = "2BC6BA97AA7103DE882EC8441211CBCF", hash_generated_method = "99CCB834CCC905C9820EEF2BDF3E261C")
    
public void checkPropertyAccess(String key) { }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.834 -0500", hash_original_method = "3B0F34A9B39090E476EB90B81040C7D1", hash_generated_method = "5249B501FEA70236029DBC4BE67F7BAD")
    
public void checkRead(FileDescriptor fd) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.837 -0500", hash_original_method = "51BADDB31E600F7C9A9DCE17CAEE4ABD", hash_generated_method = "9614EB12EF22AEE41A7EBEDC2853A8F0")
    
public void checkRead(String file) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.839 -0500", hash_original_method = "69F9067A125A221CFB426CF2266303C7", hash_generated_method = "6EC4D9E276995F0C594ECC3CDEA4738E")
    
public void checkRead(String file, Object context) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.842 -0500", hash_original_method = "2231CD521BF6360DD9009A387DA65FE2", hash_generated_method = "29F3DEBDB5C4B0EF2F7127C644779C9A")
    
public void checkSecurityAccess(String target) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.844 -0500", hash_original_method = "F217CE0DC3EB310EAAAF9D4806D2E409", hash_generated_method = "A67A7FAF481E93D6BA1191DE5AA4A9AB")
    
public void checkSetFactory() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.846 -0500", hash_original_method = "E08658A8A8D2FA3A353C142735F36A84", hash_generated_method = "7C8609731871DAE0559EB9A84F79CB71")
    
public boolean checkTopLevelWindow(Object window) { return true; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.848 -0500", hash_original_method = "8AB55486AE4ED05EAE2D015F13C35436", hash_generated_method = "D65ED4924F97F3DD2FD51A41D3EDAAE6")
    
public void checkSystemClipboardAccess() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.851 -0500", hash_original_method = "CF92AB5D995750BFB7FF9F031A4246A8", hash_generated_method = "5F4BF8D6B5587E9F4E7E6EA8DB516C02")
    
public void checkAwtEventQueueAccess() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.853 -0500", hash_original_method = "58C1D3B2A93E82E28FD99A55EC6954F5", hash_generated_method = "629D87241409DE54E9CEAEB53E4EE68A")
    
public void checkPrintJobAccess() { }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.855 -0500", hash_original_method = "5C84ACAAF82CCDAC7FC44A08CB5F593D", hash_generated_method = "4D65D7CBB4340374CB91A8205EFCC224")
    
public void checkWrite(FileDescriptor fd) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.857 -0500", hash_original_method = "2871DB4234901BDC284DA13B123CE1AB", hash_generated_method = "87821FAB73DD5DBFA392BF5E6AE6B4D4")
    
public void checkWrite(String file) { }

    /**
     * @deprecated Use {@link #checkPermission}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.860 -0500", hash_original_method = "866416E1EAC2C07A5E7D767D9B266DDC", hash_generated_method = "B47C617FC557D10AA2BC5A1A4A9B1341")
    
@Deprecated public boolean getInCheck() { return inCheck; }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.862 -0500", hash_original_method = "A7EABFC12C747C29197C1D84213DA551", hash_generated_method = "022EBC092EEC0076ED14963000466946")
    
protected Class[] getClassContext() { return null; }

    /**
     * @deprecated Use {@link #checkPermission}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.865 -0500", hash_original_method = "B5AF7ACC7C1515B2CC77D7C50B13C496", hash_generated_method = "2DB7B806D3298894313DA4F6C3111518")
    
@Deprecated protected ClassLoader currentClassLoader() { return null; }

    /**
     * @deprecated Use {@link #checkPermission}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.867 -0500", hash_original_method = "2F5894A33E5089040E95C5A71AB1D464", hash_generated_method = "DA7FF1BA4007DAAF3D1B3828AC5DA350")
    
@Deprecated protected int classLoaderDepth() {
        return -1;
    }

    /**
     * @deprecated Use {@link #checkPermission}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.869 -0500", hash_original_method = "971A50644C25A1AA23F94C545B2EFE88", hash_generated_method = "613C6505EE676E070277BB2540CEC33F")
    
@Deprecated protected Class<?> currentLoadedClass() { return null; }

    /**
     * @deprecated Use {@link #checkPermission}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.873 -0500", hash_original_method = "3141DB701376F59132D2E47A865226CE", hash_generated_method = "EED2DF2A6CC6835F6DEE6BEDB973BC4C")
    
@Deprecated protected int classDepth(String name) { return -1; }

    /**
     * @deprecated Use {@link #checkPermission}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.875 -0500", hash_original_method = "F03BE1FF5759480A79EF8F803256FC0D", hash_generated_method = "13094656F83C1CA453FC392169E6FDF2")
    
@Deprecated protected boolean inClass(String name) { return false; }

    /**
     * @deprecated Use {@link #checkPermission}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.877 -0500", hash_original_method = "AD16BBA5AF716809FD60AB92F9D52E9A", hash_generated_method = "EE009864A50276F83ED5B6CC593FD70B")
    
@Deprecated protected boolean inClassLoader() { return false; }

    /**
     * Returns the current thread's thread group.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.879 -0500", hash_original_method = "036AF7AD226EFB7B513484DD9E6E1DD6", hash_generated_method = "A3B0CC4916D392EB38FD62EAC53EC8A5")
    
public ThreadGroup getThreadGroup() {
        return Thread.currentThread().getThreadGroup();
    }

    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.881 -0500", hash_original_method = "9105FFA72B51771391C0727CF897942D", hash_generated_method = "2D0C20EEE67C4C727CDFAA93DDBC0406")
    
public Object getSecurityContext() { return null; }

    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.884 -0500", hash_original_method = "F83ED49980C30C3CF74F8E7C00892337", hash_generated_method = "397ACC17961D7E70D2DEEECAAE7DE9F6")
    
public void checkPermission(Permission permission) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.887 -0500", hash_original_method = "9F219EE7931C25AFA3551D0D45001223", hash_generated_method = "7789DD97CAD92F94AB9F6E5930AD892C")
    
public void checkPermission(Permission permission, Object context) { }
    
}

