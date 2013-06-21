package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;

public class SecurityManager {
    @Deprecated protected boolean inCheck;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.036 -0400", hash_original_method = "7FD71E6D3FB4A8DD9BF04FA4D2AAA4D4", hash_generated_method = "10F82CBF8C065A15711155F7BC44F06C")
    @DSModeled(DSC.SAFE)
    public SecurityManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.036 -0400", hash_original_method = "33353E03F38CCE3C205F21DCE963F727", hash_generated_method = "359280C961E5A308804039DBF6FC4C4A")
    @DSModeled(DSC.SAFE)
    public void checkAccept(String host, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.036 -0400", hash_original_method = "36F107888B3E77E3CF49B5177EDF7E9A", hash_generated_method = "1D046EA93125E591C95854EC0C98BEC3")
    @DSModeled(DSC.SAFE)
    public void checkAccess(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.037 -0400", hash_original_method = "5AA7E51DAAAF233E2DDB8D1EE8363A8E", hash_generated_method = "12995FDDB9E5A95B2BC4A2018B23C79F")
    @DSModeled(DSC.SAFE)
    public void checkAccess(ThreadGroup group) {
        dsTaint.addTaint(group.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.037 -0400", hash_original_method = "3BD498F27EF913D40B889A93E2AA24F9", hash_generated_method = "7884C58C458010C63B5CED032D71BA01")
    @DSModeled(DSC.SAFE)
    public void checkConnect(String host, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.037 -0400", hash_original_method = "2D5E761F7C6DB4BDDDC273A07ED405C0", hash_generated_method = "3421844C231696547F86CADA799154C4")
    @DSModeled(DSC.SAFE)
    public void checkConnect(String host, int port, Object context) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.037 -0400", hash_original_method = "8490F7E6ADD8012AF63244E1903E9866", hash_generated_method = "4206A8859EFB69212A75A66F61C96B51")
    @DSModeled(DSC.SAFE)
    public void checkCreateClassLoader() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.037 -0400", hash_original_method = "0B17A1C3AA9D11809AA604D4E5BD4994", hash_generated_method = "798134DE0893D85EE2B91E05CC15AB0A")
    @DSModeled(DSC.SAFE)
    public void checkDelete(String file) {
        dsTaint.addTaint(file);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.037 -0400", hash_original_method = "7C003C59CAB570CD3B63381DBAA3AF4E", hash_generated_method = "7C59BD58E96718CFEE4124853B954C91")
    @DSModeled(DSC.SAFE)
    public void checkExec(String cmd) {
        dsTaint.addTaint(cmd);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.038 -0400", hash_original_method = "8A9ADA58552041193904C8083A11F7F6", hash_generated_method = "5EB819050C99C31EF72C26EB8D2E26BB")
    @DSModeled(DSC.SAFE)
    public void checkExit(int status) {
        dsTaint.addTaint(status);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.038 -0400", hash_original_method = "75433C5D6CF4249C0EE246BC57BF57E2", hash_generated_method = "A28B4458E99A02CB6CFE6D66A3C15F42")
    @DSModeled(DSC.SAFE)
    public void checkLink(String libName) {
        dsTaint.addTaint(libName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.038 -0400", hash_original_method = "5412847302AF42E3061C6779693DB418", hash_generated_method = "9C051E66AA1417B1DA921067F6D1B9AE")
    @DSModeled(DSC.SAFE)
    public void checkListen(int port) {
        dsTaint.addTaint(port);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.038 -0400", hash_original_method = "8873C7B5DD5CF23CB18ABA2720E20660", hash_generated_method = "321F31856446470AB95D870B7CE2FB07")
    @DSModeled(DSC.SAFE)
    public void checkMemberAccess(Class<?> cls, int type) {
        dsTaint.addTaint(cls.dsTaint);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.038 -0400", hash_original_method = "0D776561D024E069F4378E17ED49E5AF", hash_generated_method = "C0B4144ECF7A39B33C434C1D829643B7")
    @DSModeled(DSC.SAFE)
    public void checkMulticast(InetAddress maddr) {
        dsTaint.addTaint(maddr.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.039 -0400", hash_original_method = "B705963A40DC1EBCB270E0041777CD02", hash_generated_method = "8288D6803D33EEB633299C45FB0AC417")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void checkMulticast(InetAddress maddr, byte ttl) {
        dsTaint.addTaint(ttl);
        dsTaint.addTaint(maddr.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.039 -0400", hash_original_method = "1E8CF02717496E9B31EA8F152A6EAAD3", hash_generated_method = "A99159AF7ACD3F2F2F7AEFA699ED8236")
    @DSModeled(DSC.SAFE)
    public void checkPackageAccess(String packageName) {
        dsTaint.addTaint(packageName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.039 -0400", hash_original_method = "15FB53D386245A148D9A0D9EA27D53FA", hash_generated_method = "A9B9A2C078768466A755B7232A363FDC")
    @DSModeled(DSC.SAFE)
    public void checkPackageDefinition(String packageName) {
        dsTaint.addTaint(packageName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.039 -0400", hash_original_method = "03937928889C65B1E71F0E79371D5926", hash_generated_method = "1777D1D5A96109E8F9520DDCD5330AEF")
    @DSModeled(DSC.SAFE)
    public void checkPropertiesAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.049 -0400", hash_original_method = "2BC6BA97AA7103DE882EC8441211CBCF", hash_generated_method = "59D49C969F72D12DC009BB6A95ECDA73")
    @DSModeled(DSC.SAFE)
    public void checkPropertyAccess(String key) {
        dsTaint.addTaint(key);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.050 -0400", hash_original_method = "3B0F34A9B39090E476EB90B81040C7D1", hash_generated_method = "ACA697618E510F3DE7B54676EE30420E")
    @DSModeled(DSC.SAFE)
    public void checkRead(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.050 -0400", hash_original_method = "51BADDB31E600F7C9A9DCE17CAEE4ABD", hash_generated_method = "83A3A77E408CD575C8748E1945C8DF0F")
    @DSModeled(DSC.SAFE)
    public void checkRead(String file) {
        dsTaint.addTaint(file);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.050 -0400", hash_original_method = "69F9067A125A221CFB426CF2266303C7", hash_generated_method = "36DB5B4A1AAAD3396752A73F02363CF8")
    @DSModeled(DSC.SAFE)
    public void checkRead(String file, Object context) {
        dsTaint.addTaint(file);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.051 -0400", hash_original_method = "2231CD521BF6360DD9009A387DA65FE2", hash_generated_method = "48A2C3CA0DA196A24108D4C8FEDAAE51")
    @DSModeled(DSC.SAFE)
    public void checkSecurityAccess(String target) {
        dsTaint.addTaint(target);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.053 -0400", hash_original_method = "F217CE0DC3EB310EAAAF9D4806D2E409", hash_generated_method = "8A03D75B144D71C0D274D98D79E3AE2A")
    @DSModeled(DSC.SAFE)
    public void checkSetFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.055 -0400", hash_original_method = "E08658A8A8D2FA3A353C142735F36A84", hash_generated_method = "DC985C35279E87D14F5661A304EF6377")
    @DSModeled(DSC.SAFE)
    public boolean checkTopLevelWindow(Object window) {
        dsTaint.addTaint(window.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.056 -0400", hash_original_method = "8AB55486AE4ED05EAE2D015F13C35436", hash_generated_method = "0F61F5AD77B8F62ABFA4EC158605A22B")
    @DSModeled(DSC.SAFE)
    public void checkSystemClipboardAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.057 -0400", hash_original_method = "CF92AB5D995750BFB7FF9F031A4246A8", hash_generated_method = "2397CF2F184F1284560FAE451934637C")
    @DSModeled(DSC.SAFE)
    public void checkAwtEventQueueAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.057 -0400", hash_original_method = "58C1D3B2A93E82E28FD99A55EC6954F5", hash_generated_method = "C3B834D6C36A5606179169AB3721866E")
    @DSModeled(DSC.SAFE)
    public void checkPrintJobAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.057 -0400", hash_original_method = "5C84ACAAF82CCDAC7FC44A08CB5F593D", hash_generated_method = "2E6E5B345C4004D866F4D32AD3E7A83D")
    @DSModeled(DSC.SAFE)
    public void checkWrite(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.057 -0400", hash_original_method = "2871DB4234901BDC284DA13B123CE1AB", hash_generated_method = "64B8509CB93FDB108965FC649C5E6DE7")
    @DSModeled(DSC.SAFE)
    public void checkWrite(String file) {
        dsTaint.addTaint(file);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.058 -0400", hash_original_method = "866416E1EAC2C07A5E7D767D9B266DDC", hash_generated_method = "C30C3F75A309261E1820FCC0BB8CAC2C")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean getInCheck() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return inCheck;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.058 -0400", hash_original_method = "A7EABFC12C747C29197C1D84213DA551", hash_generated_method = "1E4BEA9AC34F5F7274B02B1E712E1E0D")
    @DSModeled(DSC.SAFE)
    protected Class[] getClassContext() {
        return (Class[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.058 -0400", hash_original_method = "B5AF7ACC7C1515B2CC77D7C50B13C496", hash_generated_method = "8EC863BF8E5CB4CAF56D4ACBB1A2D163")
    @DSModeled(DSC.BAN)
    @Deprecated
    protected ClassLoader currentClassLoader() {
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.059 -0400", hash_original_method = "2F5894A33E5089040E95C5A71AB1D464", hash_generated_method = "C8C70CD80DB9D91F57714DFB51D36D17")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected int classLoaderDepth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.059 -0400", hash_original_method = "971A50644C25A1AA23F94C545B2EFE88", hash_generated_method = "4D6159CF299C857C241F00EFFA63ED80")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected Class<?> currentLoadedClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.060 -0400", hash_original_method = "3141DB701376F59132D2E47A865226CE", hash_generated_method = "485B8A08EB670A224A122D1F3FB282A0")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected int classDepth(String name) {
        dsTaint.addTaint(name);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.061 -0400", hash_original_method = "F03BE1FF5759480A79EF8F803256FC0D", hash_generated_method = "0A9833C414B6756F620FD5C69454F619")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected boolean inClass(String name) {
        dsTaint.addTaint(name);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.061 -0400", hash_original_method = "AD16BBA5AF716809FD60AB92F9D52E9A", hash_generated_method = "922B1E8541705F392E9DEC74534145ED")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected boolean inClassLoader() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.062 -0400", hash_original_method = "036AF7AD226EFB7B513484DD9E6E1DD6", hash_generated_method = "D80FD07B417EDE0F884EE278A8C5B392")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadGroup getThreadGroup() {
        ThreadGroup var810EEEF0C7E14748B1F8BD1C7C81C9B9_131963860 = (Thread.currentThread().getThreadGroup());
        return (ThreadGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Thread.currentThread().getThreadGroup();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.062 -0400", hash_original_method = "9105FFA72B51771391C0727CF897942D", hash_generated_method = "222BC9EF40BEC42422BD739407213A28")
    @DSModeled(DSC.SAFE)
    public Object getSecurityContext() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.062 -0400", hash_original_method = "F83ED49980C30C3CF74F8E7C00892337", hash_generated_method = "DFC2218E9D1861166E29C8A05DADA303")
    @DSModeled(DSC.SAFE)
    public void checkPermission(Permission permission) {
        dsTaint.addTaint(permission.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.062 -0400", hash_original_method = "9F219EE7931C25AFA3551D0D45001223", hash_generated_method = "E4BEB978BDFE56BD193013CC0E6EC8B3")
    @DSModeled(DSC.SAFE)
    public void checkPermission(Permission permission, Object context) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(permission.dsTaint);
        // ---------- Original Method ----------
    }

    
}

