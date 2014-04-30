package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.io.StringWriter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Printer;

public class ApplicationErrorReport implements Parcelable {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.788 -0500", hash_original_method = "113BB55A947D145420F5CC219A4706D7", hash_generated_method = "8DF0B455A56F04F688B9B0BB6A4F184E")
    
public static ComponentName getErrorReportReceiver(Context context,
            String packageName, int appFlags) {
        // check if error reporting is enabled in secure settings
        int enabled = Settings.Secure.getInt(context.getContentResolver(),
                Settings.Secure.SEND_ACTION_APP_ERROR, 0);
        if (enabled == 0) {
            return null;
        }

        PackageManager pm = context.getPackageManager();

        // look for receiver in the installer package
        String candidate = pm.getInstallerPackageName(packageName);
        ComponentName result = getErrorReportReceiver(pm, packageName, candidate);
        if (result != null) {
            return result;
        }

        // if the error app is on the system image, look for system apps
        // error receiver
        if ((appFlags&ApplicationInfo.FLAG_SYSTEM) != 0) {
            candidate = SystemProperties.get(SYSTEM_APPS_ERROR_RECEIVER_PROPERTY);
            result = getErrorReportReceiver(pm, packageName, candidate);
            if (result != null) {
                return result;
            }
        }

        // if there is a default receiver, try that
        candidate = SystemProperties.get(DEFAULT_ERROR_RECEIVER_PROPERTY);
        return getErrorReportReceiver(pm, packageName, candidate);
    }

    /**
     * Return activity in receiverPackage that handles ACTION_APP_ERROR.
     *
     * @param pm PackageManager instance
     * @param errorPackage package which caused the error
     * @param receiverPackage candidate package to receive the error
     * @return activity component within receiverPackage which handles
     * ACTION_APP_ERROR, or null if not found
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.792 -0500", hash_original_method = "E8A44BB5F91823678290CFFD8154BF15", hash_generated_method = "CAD628A415C65030DB8FF1513D964A6E")
    
static ComponentName getErrorReportReceiver(PackageManager pm, String errorPackage,
            String receiverPackage) {
        if (receiverPackage == null || receiverPackage.length() == 0) {
            return null;
        }

        // break the loop if it's the error report receiver package that crashed
        if (receiverPackage.equals(errorPackage)) {
            return null;
        }

        Intent intent = new Intent(Intent.ACTION_APP_ERROR);
        intent.setPackage(receiverPackage);
        ResolveInfo info = pm.resolveActivity(intent, 0);
        if (info == null || info.activityInfo == null) {
            return null;
        }
        return new ComponentName(receiverPackage, info.activityInfo.name);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.745 -0500", hash_original_field = "74C0CC64A9FE40EA2925DB2F7A24050D", hash_generated_field = "9F7E8694C4E604CFC7D18F276766C11A")

    static final String SYSTEM_APPS_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.system.apps";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.748 -0500", hash_original_field = "88C61C6EB17F75D3833BD194B30363BA", hash_generated_field = "E291D5AAD7BDEC6675841591269B8EEF")

    static final String DEFAULT_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.default";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.750 -0500", hash_original_field = "B8C5121E1C7F140CE2B73D34E0AAC7EB", hash_generated_field = "E5F2FC72F5EFEE032E1F7BB690278BAB")

    public static final int TYPE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.752 -0500", hash_original_field = "082290B91F158E41BE13379E887EED1A", hash_generated_field = "F15F1796F388B28C4B599BE1A658CC31")

    public static final int TYPE_CRASH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.755 -0500", hash_original_field = "2529F301956E206B9D960DF96BF9214D", hash_generated_field = "75CA544BDE0689343F6A3680842D0DBF")

    public static final int TYPE_ANR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.758 -0500", hash_original_field = "CE56B0FD34335E3D7F2BE6BFAFC947D5", hash_generated_field = "AA4DE677ACD630EEE925B1C018580548")

    public static final int TYPE_BATTERY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.760 -0500", hash_original_field = "623F122D82A900F9DEB1A2A29DB4B264", hash_generated_field = "D21BED58CA32C36A5CB46E18EF40C6AB")

    public static final int TYPE_RUNNING_SERVICE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.305 -0400", hash_original_field = "463EB6214A90B7685070E9D5A0790DB3", hash_generated_field = "0F9628131E534559AAF7FDEF2605D1C5")

    public static final Parcelable.Creator<ApplicationErrorReport> CREATOR
            = new Parcelable.Creator<ApplicationErrorReport>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.889 -0500", hash_original_method = "D02E7C98CADEACD71C390EF313CCEAC7", hash_generated_method = "1654D8AB8523F725D653BBEBF31060C6")
        
public ApplicationErrorReport createFromParcel(Parcel source) {
            return new ApplicationErrorReport(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.892 -0500", hash_original_method = "910469A5C451BE7A7AD117B169DA9905", hash_generated_method = "0502AC9C5D5B1486545A197D907BD614")
        
public ApplicationErrorReport[] newArray(int size) {
            return new ApplicationErrorReport[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.762 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.764 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.766 -0500", hash_original_field = "634027F5BAF15AC148ABB8587B7F70EA", hash_generated_field = "197F53EC193DDE6F22FC12D776A9B51E")

    public String installerPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.768 -0500", hash_original_field = "182AC29DC74CEB0C6C89C5576E47A4DD", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.770 -0500", hash_original_field = "FB68C26D0BB5DD6577F61578B9AE66A8", hash_generated_field = "5A44367B7C554CE37EA61A01D45FAC73")

    public long time;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.772 -0500", hash_original_field = "2F329B2BA8030CB7ABA218B5BDFE7585", hash_generated_field = "E6A27F82DF8950D21D06A7FB2E81C58B")

    public boolean systemApp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.774 -0500", hash_original_field = "C1A9DA26C62151932C06C320A8DE9F2E", hash_generated_field = "FBA804E5CF855ECC62CEF36A3790B2FB")

    public CrashInfo crashInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.777 -0500", hash_original_field = "88861DEC679D8E0AAF7F42901B7B5B5A", hash_generated_field = "6A45BBBCA030DD2B3FFD7329E23B5D3C")

    public AnrInfo anrInfo;
    
    public static class CrashInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.800 -0500", hash_original_field = "DE781DE5EA111ED3AAA482F422BD246D", hash_generated_field = "64A4CFC776584F31DADD8ED1088FC67C")

        public String exceptionClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.802 -0500", hash_original_field = "F958E93442AF9FDDA46C261503A54D3E", hash_generated_field = "D36773DA8FD6053F2F11D03036B18E50")

        public String exceptionMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.804 -0500", hash_original_field = "6ABE7C25E8871210884D1012A209293D", hash_generated_field = "8F4E83DBBFEBB927A2F201A7C280BA50")

        public String throwFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.807 -0500", hash_original_field = "D72E9462CEF6332A8934BB29B5D965EA", hash_generated_field = "BB6C2D1FC7E043EA12C976DFCB570E3E")

        public String throwClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.809 -0500", hash_original_field = "AF71D8B7F1A4C2ED141F6148307D8DEF", hash_generated_field = "E36BF34C42829B1C195FD3FC0F8D3478")

        public String throwMethodName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.811 -0500", hash_original_field = "6E913ECA98DC2252E23FFB2CD9F0C632", hash_generated_field = "04E0FBE65762D8F1BA1BD7B505B8DA69")

        public int throwLineNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.813 -0500", hash_original_field = "43939ED17E777DB55D0797009C2B6B15", hash_generated_field = "5AD16E48548E8F81D0DFF7F4F7B69945")

        public String stackTrace;

        /**
         * Create an uninitialized instance of CrashInfo.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.815 -0500", hash_original_method = "A5C69B6119C4811D45501C8F0E46959E", hash_generated_method = "F01CF52EE5C49CE30F45591F6E9FBBA6")
        
public CrashInfo() {
        }

        /**
         * Create an instance of CrashInfo initialized from an exception.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.818 -0500", hash_original_method = "8E877A457FA4EF293EE7618CA0C5075F", hash_generated_method = "AF2A9047422A9C3EE1FFAD5706368FAB")
        
public CrashInfo(Throwable tr) {
            StringWriter sw = new StringWriter();
            tr.printStackTrace(new PrintWriter(sw));
            stackTrace = sw.toString();
            exceptionMessage = tr.getMessage();

            // Populate fields with the "root cause" exception
            Throwable rootTr = tr;
            while (tr.getCause() != null) {
                tr = tr.getCause();
                if (tr.getStackTrace() != null && tr.getStackTrace().length > 0) {
                    rootTr = tr;
                }
                String msg = tr.getMessage();
                if (msg != null && msg.length() > 0) {
                    exceptionMessage = msg;
                }
            }

            exceptionClassName = rootTr.getClass().getName();
            if (rootTr.getStackTrace().length > 0) {
                StackTraceElement trace = rootTr.getStackTrace()[0];
                throwFileName = trace.getFileName();
                throwClassName = trace.getClassName();
                throwMethodName = trace.getMethodName();
                throwLineNumber = trace.getLineNumber();
            } else {
                throwFileName = "unknown";
                throwClassName = "unknown";
                throwMethodName = "unknown";
                throwLineNumber = 0;
            }
        }

        /**
         * Create an instance of CrashInfo initialized from a Parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.822 -0500", hash_original_method = "260530F70C73453962E6EA8579F649BC", hash_generated_method = "376CC4AACE3D4EF2452DFC71C9AD511A")
        
public CrashInfo(Parcel in) {
            exceptionClassName = in.readString();
            exceptionMessage = in.readString();
            throwFileName = in.readString();
            throwClassName = in.readString();
            throwMethodName = in.readString();
            throwLineNumber = in.readInt();
            stackTrace = in.readString();
        }

        /**
         * Save a CrashInfo instance to a parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.824 -0500", hash_original_method = "7B93ED55B73724A8D927AFB13EC86251", hash_generated_method = "CB02D8B39A62AE9F494D3453E700A589")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(exceptionClassName);
            dest.writeString(exceptionMessage);
            dest.writeString(throwFileName);
            dest.writeString(throwClassName);
            dest.writeString(throwMethodName);
            dest.writeInt(throwLineNumber);
            dest.writeString(stackTrace);
        }

        /**
         * Dump a CrashInfo instance to a Printer.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.827 -0500", hash_original_method = "12CDDF08CF66932EC00C47C0F2860F33", hash_generated_method = "11A2E6CBF0E0777D3F44E46ECBDC07EF")
        
public void dump(Printer pw, String prefix) {
            pw.println(prefix + "exceptionClassName: " + exceptionClassName);
            pw.println(prefix + "exceptionMessage: " + exceptionMessage);
            pw.println(prefix + "throwFileName: " + throwFileName);
            pw.println(prefix + "throwClassName: " + throwClassName);
            pw.println(prefix + "throwMethodName: " + throwMethodName);
            pw.println(prefix + "throwLineNumber: " + throwLineNumber);
            pw.println(prefix + "stackTrace: " + stackTrace);
        }
        
    }
    
    public static class AnrInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.832 -0500", hash_original_field = "04A79E076EA612F90C72BFBF18A4C4BA", hash_generated_field = "2C31FC32EDD5FD275BDF859DF788A1AB")

        public String activity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.834 -0500", hash_original_field = "3BB77C7D4A948DE559A59CF1E3E0514A", hash_generated_field = "AEA9B0E08C709D8DF0AF926ABBB6A16A")

        public String cause;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.836 -0500", hash_original_field = "51A3ED67E300F80A591B74C6FCA4A0D2", hash_generated_field = "EAE55385089271374E8F46F98DBEDE87")

        public String info;

        /**
         * Create an uninitialized instance of AnrInfo.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.839 -0500", hash_original_method = "76183B88EF41C33999366984D15A43B8", hash_generated_method = "E42E5828FE7CEF906AC34B480078F837")
        
public AnrInfo() {
        }

        /**
         * Create an instance of AnrInfo initialized from a Parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.842 -0500", hash_original_method = "A1816E63F03CA551A7DF54BED5A962BD", hash_generated_method = "075B773FB3F09FE525835BB7E064F4BD")
        
public AnrInfo(Parcel in) {
            activity = in.readString();
            cause = in.readString();
            info = in.readString();
        }

        /**
         * Save an AnrInfo instance to a parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.845 -0500", hash_original_method = "C2E7AD44BF6B2BCB887E6B9726568F1C", hash_generated_method = "27CD2F962D4BA9E3B360C7DBEFB959CC")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(activity);
            dest.writeString(cause);
            dest.writeString(info);
        }

        /**
         * Dump an AnrInfo instance to a Printer.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.847 -0500", hash_original_method = "B28573F62D1F3D7B120AF5A59DF14509", hash_generated_method = "5A20277F73B401E0A3A0B01C0673AEFE")
        
public void dump(Printer pw, String prefix) {
            pw.println(prefix + "activity: " + activity);
            pw.println(prefix + "cause: " + cause);
            pw.println(prefix + "info: " + info);
        }
        
    }
    
    public static class BatteryInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.852 -0500", hash_original_field = "91A3EF4482A5F3F1C098F0A15E356363", hash_generated_field = "9E192676C8B3F13371C5042FED59D2D3")

        public int usagePercent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.854 -0500", hash_original_field = "F132815CA173AF9230EA1E6D6057215E", hash_generated_field = "89F8076A13AB20078AEC40B417BEC3C1")

        public long durationMicros;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.856 -0500", hash_original_field = "4FC81CA5F4D180302757595F4489A30C", hash_generated_field = "D7CE2C36DB4FE34FCB98BD7675508466")

        public String usageDetails;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.858 -0500", hash_original_field = "A8E4B9A05FDB64CFE53538CA9D4F57F1", hash_generated_field = "E3E9CE38A0E0817F8707B7EE39B2C6FD")

        public String checkinDetails;

        /**
         * Create an uninitialized instance of BatteryInfo.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.860 -0500", hash_original_method = "D2192429514F02BB97F8B55205CB5D4D", hash_generated_method = "46098DD1AA981646C8749E2B1102D5BC")
        
public BatteryInfo() {
        }

        /**
         * Create an instance of BatteryInfo initialized from a Parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.863 -0500", hash_original_method = "73596E36061F6AD3279B28A01C976EEF", hash_generated_method = "DC8D0DC8B22C81089826E8C3560CD49B")
        
public BatteryInfo(Parcel in) {
            usagePercent = in.readInt();
            durationMicros = in.readLong();
            usageDetails = in.readString();
            checkinDetails = in.readString();
        }

        /**
         * Save a BatteryInfo instance to a parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.866 -0500", hash_original_method = "530617490987BC288812A812A090F855", hash_generated_method = "65F03713B2CC1B6E54436E9A2163F7A7")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(usagePercent);
            dest.writeLong(durationMicros);
            dest.writeString(usageDetails);
            dest.writeString(checkinDetails);
        }

        /**
         * Dump a BatteryInfo instance to a Printer.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.868 -0500", hash_original_method = "A13E8F561D1454805516846C4F2ACB3F", hash_generated_method = "7AFB85B6ED9D1B4895FE3646E7F116A7")
        
public void dump(Printer pw, String prefix) {
            pw.println(prefix + "usagePercent: " + usagePercent);
            pw.println(prefix + "durationMicros: " + durationMicros);
            pw.println(prefix + "usageDetails: " + usageDetails);
            pw.println(prefix + "checkinDetails: " + checkinDetails);
        }
        
    }
    
    public static class RunningServiceInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.873 -0500", hash_original_field = "B03A6C1817AF920FFB4158E2B54A5112", hash_generated_field = "341FEBE1083E0F8DC34C2C2DD3BFBFF4")

        public long durationMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.875 -0500", hash_original_field = "BFF7CFAA372D750FA7F5A90CABD1CB76", hash_generated_field = "0A4E9A2B88820041CD6FBD7FA831FA98")

        public String serviceDetails;

        /**
         * Create an uninitialized instance of RunningServiceInfo.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.878 -0500", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "46CFC49EE8BA41524B35A3152203501D")
        
public RunningServiceInfo() {
        }

        /**
         * Create an instance of RunningServiceInfo initialized from a Parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.880 -0500", hash_original_method = "2BF3FED145657C6E98603A374CE15B79", hash_generated_method = "11A5B00E7636E9CA07C81C697BF127BA")
        
public RunningServiceInfo(Parcel in) {
            durationMillis = in.readLong();
            serviceDetails = in.readString();
        }

        /**
         * Save a RunningServiceInfo instance to a parcel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.883 -0500", hash_original_method = "DD72EF524B8A5B3FA338ADFF302C8897", hash_generated_method = "E02B8FF1D1D899E020F14CC4178D9E93")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(durationMillis);
            dest.writeString(serviceDetails);
        }

        /**
         * Dump a BatteryInfo instance to a Printer.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.885 -0500", hash_original_method = "BA9B01A70699F7EA70070719DF8ACE84", hash_generated_method = "A9B20A2F30412BBB4B42DB4B59A89726")
        
public void dump(Printer pw, String prefix) {
            pw.println(prefix + "durationMillis: " + durationMillis);
            pw.println(prefix + "serviceDetails: " + serviceDetails);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.779 -0500", hash_original_field = "91881ED66BBCA81F66903BD702E3AD39", hash_generated_field = "0F63A0DB674D6731E0337B045B7EB045")

    public BatteryInfo batteryInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.781 -0500", hash_original_field = "2F6AA045B5D031B3CB44763CDD206D35", hash_generated_field = "D33B642B4807217FCC71196D912E4B88")

    public RunningServiceInfo runningServiceInfo;

    /**
     * Create an uninitialized instance of {@link ApplicationErrorReport}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.783 -0500", hash_original_method = "6CC6117712C6457F9E284742535D4C3A", hash_generated_method = "41DDB6AC8B65C05EFD93A733AB6D913C")
    
public ApplicationErrorReport() {
    }

    /**
     * Create an instance of {@link ApplicationErrorReport} initialized from
     * a parcel.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.786 -0500", hash_original_method = "56C9FAB6FC92FE279C6A2DB2655BED71", hash_generated_method = "56C9FAB6FC92FE279C6A2DB2655BED71")
    
ApplicationErrorReport(Parcel in) {
        readFromParcel(in);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.794 -0500", hash_original_method = "A097CEBB0222A4C65AC186DA78BE4FCB", hash_generated_method = "A5ED89D679C1DAB1EA9E7D8237256851")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeString(packageName);
        dest.writeString(installerPackageName);
        dest.writeString(processName);
        dest.writeLong(time);
        dest.writeInt(systemApp ? 1 : 0);

        switch (type) {
            case TYPE_CRASH:
                crashInfo.writeToParcel(dest, flags);
                break;
            case TYPE_ANR:
                anrInfo.writeToParcel(dest, flags);
                break;
            case TYPE_BATTERY:
                batteryInfo.writeToParcel(dest, flags);
                break;
            case TYPE_RUNNING_SERVICE:
                runningServiceInfo.writeToParcel(dest, flags);
                break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.797 -0500", hash_original_method = "D8BAAB71575DEB17ADCE92E48607D31D", hash_generated_method = "1AE9964F0A06A8244DED3021E506E0F4")
    
public void readFromParcel(Parcel in) {
        type = in.readInt();
        packageName = in.readString();
        installerPackageName = in.readString();
        processName = in.readString();
        time = in.readLong();
        systemApp = in.readInt() == 1;

        switch (type) {
            case TYPE_CRASH:
                crashInfo = new CrashInfo(in);
                anrInfo = null;
                batteryInfo = null;
                runningServiceInfo = null;
                break;
            case TYPE_ANR:
                anrInfo = new AnrInfo(in);
                crashInfo = null;
                batteryInfo = null;
                runningServiceInfo = null;
                break;
            case TYPE_BATTERY:
                batteryInfo = new BatteryInfo(in);
                anrInfo = null;
                crashInfo = null;
                runningServiceInfo = null;
                break;
            case TYPE_RUNNING_SERVICE:
                batteryInfo = null;
                anrInfo = null;
                crashInfo = null;
                runningServiceInfo = new RunningServiceInfo(in);
                break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.897 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Dump the report to a Printer.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.899 -0500", hash_original_method = "EB05E0A242CB818854C5BC92B57FA752", hash_generated_method = "E915A8BE7FBA81DC7C0DB04A0C473549")
    
public void dump(Printer pw, String prefix) {
        pw.println(prefix + "type: " + type);
        pw.println(prefix + "packageName: " + packageName);
        pw.println(prefix + "installerPackageName: " + installerPackageName);
        pw.println(prefix + "processName: " + processName);
        pw.println(prefix + "time: " + time);
        pw.println(prefix + "systemApp: " + systemApp);

        switch (type) {
            case TYPE_CRASH:
                crashInfo.dump(pw, prefix);
                break;
            case TYPE_ANR:
                anrInfo.dump(pw, prefix);
                break;
            case TYPE_BATTERY:
                batteryInfo.dump(pw, prefix);
                break;
            case TYPE_RUNNING_SERVICE:
                runningServiceInfo.dump(pw, prefix);
                break;
        }
    }
    // orphaned legacy method
    public ApplicationErrorReport createFromParcel(Parcel source) {
            return new ApplicationErrorReport(source);
        }
    
    // orphaned legacy method
    public ApplicationErrorReport[] newArray(int size) {
            return new ApplicationErrorReport[size];
        }
    
}

