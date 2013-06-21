package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Printer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ApplicationErrorReport implements Parcelable {
    public int type;
    public String packageName;
    public String installerPackageName;
    public String processName;
    public long time;
    public boolean systemApp;
    public CrashInfo crashInfo;
    public AnrInfo anrInfo;
    public BatteryInfo batteryInfo;
    public RunningServiceInfo runningServiceInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.575 -0400", hash_original_method = "6CC6117712C6457F9E284742535D4C3A", hash_generated_method = "A32824C33E3DAEF3E43183F720B0B2CF")
    @DSModeled(DSC.SAFE)
    public ApplicationErrorReport() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.575 -0400", hash_original_method = "56C9FAB6FC92FE279C6A2DB2655BED71", hash_generated_method = "112780957AAADE58BDB64727D4CA648B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ApplicationErrorReport(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
        public static ComponentName getErrorReportReceiver(Context context,
            String packageName, int appFlags) {
        int enabled = Settings.Secure.getInt(context.getContentResolver(),
                Settings.Secure.SEND_ACTION_APP_ERROR, 0);
        if (enabled == 0) {
            return null;
        }
        PackageManager pm = context.getPackageManager();
        String candidate = pm.getInstallerPackageName(packageName);
        ComponentName result = getErrorReportReceiver(pm, packageName, candidate);
        if (result != null) {
            return result;
        }
        if ((appFlags&ApplicationInfo.FLAG_SYSTEM) != 0) {
            candidate = SystemProperties.get(SYSTEM_APPS_ERROR_RECEIVER_PROPERTY);
            result = getErrorReportReceiver(pm, packageName, candidate);
            if (result != null) {
                return result;
            }
        }
        candidate = SystemProperties.get(DEFAULT_ERROR_RECEIVER_PROPERTY);
        return getErrorReportReceiver(pm, packageName, candidate);
    }

    
        static ComponentName getErrorReportReceiver(PackageManager pm, String errorPackage,
            String receiverPackage) {
        if (receiverPackage == null || receiverPackage.length() == 0) {
            return null;
        }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.577 -0400", hash_original_method = "A097CEBB0222A4C65AC186DA78BE4FCB", hash_generated_method = "33E590D4FCACC8DC8BE37DE158FA0B87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(type);
        dest.writeString(packageName);
        dest.writeString(installerPackageName);
        dest.writeString(processName);
        dest.writeLong(time);
        dest.writeInt(systemApp ? 1 : 0);
        //Begin case TYPE_CRASH 
        crashInfo.writeToParcel(dest, flags);
        //End case TYPE_CRASH 
        //Begin case TYPE_ANR 
        anrInfo.writeToParcel(dest, flags);
        //End case TYPE_ANR 
        //Begin case TYPE_BATTERY 
        batteryInfo.writeToParcel(dest, flags);
        //End case TYPE_BATTERY 
        //Begin case TYPE_RUNNING_SERVICE 
        runningServiceInfo.writeToParcel(dest, flags);
        //End case TYPE_RUNNING_SERVICE 
        // ---------- Original Method ----------
        //dest.writeInt(type);
        //dest.writeString(packageName);
        //dest.writeString(installerPackageName);
        //dest.writeString(processName);
        //dest.writeLong(time);
        //dest.writeInt(systemApp ? 1 : 0);
        //switch (type) {
            //case TYPE_CRASH:
                //crashInfo.writeToParcel(dest, flags);
                //break;
            //case TYPE_ANR:
                //anrInfo.writeToParcel(dest, flags);
                //break;
            //case TYPE_BATTERY:
                //batteryInfo.writeToParcel(dest, flags);
                //break;
            //case TYPE_RUNNING_SERVICE:
                //runningServiceInfo.writeToParcel(dest, flags);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.578 -0400", hash_original_method = "D8BAAB71575DEB17ADCE92E48607D31D", hash_generated_method = "EA2432E48E7A0637E082ABFB830B9045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFromParcel(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        type = in.readInt();
        packageName = in.readString();
        installerPackageName = in.readString();
        processName = in.readString();
        time = in.readLong();
        systemApp = in.readInt() == 1;
        //Begin case TYPE_CRASH 
        crashInfo = new CrashInfo(in);
        //End case TYPE_CRASH 
        //Begin case TYPE_CRASH 
        anrInfo = null;
        //End case TYPE_CRASH 
        //Begin case TYPE_CRASH 
        batteryInfo = null;
        //End case TYPE_CRASH 
        //Begin case TYPE_CRASH 
        runningServiceInfo = null;
        //End case TYPE_CRASH 
        //Begin case TYPE_ANR 
        anrInfo = new AnrInfo(in);
        //End case TYPE_ANR 
        //Begin case TYPE_ANR 
        crashInfo = null;
        //End case TYPE_ANR 
        //Begin case TYPE_ANR 
        batteryInfo = null;
        //End case TYPE_ANR 
        //Begin case TYPE_ANR 
        runningServiceInfo = null;
        //End case TYPE_ANR 
        //Begin case TYPE_BATTERY 
        batteryInfo = new BatteryInfo(in);
        //End case TYPE_BATTERY 
        //Begin case TYPE_BATTERY 
        anrInfo = null;
        //End case TYPE_BATTERY 
        //Begin case TYPE_BATTERY 
        crashInfo = null;
        //End case TYPE_BATTERY 
        //Begin case TYPE_BATTERY 
        runningServiceInfo = null;
        //End case TYPE_BATTERY 
        //Begin case TYPE_RUNNING_SERVICE 
        batteryInfo = null;
        //End case TYPE_RUNNING_SERVICE 
        //Begin case TYPE_RUNNING_SERVICE 
        anrInfo = null;
        //End case TYPE_RUNNING_SERVICE 
        //Begin case TYPE_RUNNING_SERVICE 
        crashInfo = null;
        //End case TYPE_RUNNING_SERVICE 
        //Begin case TYPE_RUNNING_SERVICE 
        runningServiceInfo = new RunningServiceInfo(in);
        //End case TYPE_RUNNING_SERVICE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.578 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.579 -0400", hash_original_method = "EB05E0A242CB818854C5BC92B57FA752", hash_generated_method = "13BAE4AEF6D85E558874BC0C966CC62F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        pw.println(prefix + "type: " + type);
        pw.println(prefix + "packageName: " + packageName);
        pw.println(prefix + "installerPackageName: " + installerPackageName);
        pw.println(prefix + "processName: " + processName);
        pw.println(prefix + "time: " + time);
        pw.println(prefix + "systemApp: " + systemApp);
        //Begin case TYPE_CRASH 
        crashInfo.dump(pw, prefix);
        //End case TYPE_CRASH 
        //Begin case TYPE_ANR 
        anrInfo.dump(pw, prefix);
        //End case TYPE_ANR 
        //Begin case TYPE_BATTERY 
        batteryInfo.dump(pw, prefix);
        //End case TYPE_BATTERY 
        //Begin case TYPE_RUNNING_SERVICE 
        runningServiceInfo.dump(pw, prefix);
        //End case TYPE_RUNNING_SERVICE 
        // ---------- Original Method ----------
        //pw.println(prefix + "type: " + type);
        //pw.println(prefix + "packageName: " + packageName);
        //pw.println(prefix + "installerPackageName: " + installerPackageName);
        //pw.println(prefix + "processName: " + processName);
        //pw.println(prefix + "time: " + time);
        //pw.println(prefix + "systemApp: " + systemApp);
        //switch (type) {
            //case TYPE_CRASH:
                //crashInfo.dump(pw, prefix);
                //break;
            //case TYPE_ANR:
                //anrInfo.dump(pw, prefix);
                //break;
            //case TYPE_BATTERY:
                //batteryInfo.dump(pw, prefix);
                //break;
            //case TYPE_RUNNING_SERVICE:
                //runningServiceInfo.dump(pw, prefix);
                //break;
        //}
    }

    
    public static class CrashInfo {
        public String exceptionClassName;
        public String exceptionMessage;
        public String throwFileName;
        public String throwClassName;
        public String throwMethodName;
        public int throwLineNumber;
        public String stackTrace;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.579 -0400", hash_original_method = "A5C69B6119C4811D45501C8F0E46959E", hash_generated_method = "8F2057BAD303C22C04121A18F120A112")
        @DSModeled(DSC.SAFE)
        public CrashInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.581 -0400", hash_original_method = "8E877A457FA4EF293EE7618CA0C5075F", hash_generated_method = "A967EA81D548D4954E470376E253DE87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CrashInfo(Throwable tr) {
            dsTaint.addTaint(tr.dsTaint);
            StringWriter sw;
            sw = new StringWriter();
            tr.printStackTrace(new PrintWriter(sw));
            stackTrace = sw.toString();
            exceptionMessage = tr.getMessage();
            Throwable rootTr;
            rootTr = tr;
            {
                boolean var49386827104CDB7695A0A911D7203930_1997972846 = (tr.getCause() != null);
                {
                    tr = tr.getCause();
                    {
                        boolean varFAC1DD4231C98510C5F83CEABF61BBE8_937989313 = (tr.getStackTrace() != null && tr.getStackTrace().length > 0);
                        {
                            rootTr = tr;
                        } //End block
                    } //End collapsed parenthetic
                    String msg;
                    msg = tr.getMessage();
                    {
                        boolean var1F789A916FEA465A3D5B39DAAFBEE0CA_395719329 = (msg != null && msg.length() > 0);
                        {
                            exceptionMessage = msg;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            exceptionClassName = rootTr.getClass().getName();
            {
                boolean varB1864E601FD927D95B56A69CA736BC55_1558164788 = (rootTr.getStackTrace().length > 0);
                {
                    StackTraceElement trace;
                    trace = rootTr.getStackTrace()[0];
                    throwFileName = trace.getFileName();
                    throwClassName = trace.getClassName();
                    throwMethodName = trace.getMethodName();
                    throwLineNumber = trace.getLineNumber();
                } //End block
                {
                    throwFileName = "unknown";
                    throwClassName = "unknown";
                    throwMethodName = "unknown";
                    throwLineNumber = 0;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.581 -0400", hash_original_method = "260530F70C73453962E6EA8579F649BC", hash_generated_method = "B1738BAAE256B192E19041230FAACB84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CrashInfo(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            exceptionClassName = in.readString();
            exceptionMessage = in.readString();
            throwFileName = in.readString();
            throwClassName = in.readString();
            throwMethodName = in.readString();
            throwLineNumber = in.readInt();
            stackTrace = in.readString();
            // ---------- Original Method ----------
            //exceptionClassName = in.readString();
            //exceptionMessage = in.readString();
            //throwFileName = in.readString();
            //throwClassName = in.readString();
            //throwMethodName = in.readString();
            //throwLineNumber = in.readInt();
            //stackTrace = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.582 -0400", hash_original_method = "7B93ED55B73724A8D927AFB13EC86251", hash_generated_method = "1F3CF8055A4ABAC93211CE0F7CCE6D62")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeString(exceptionClassName);
            dest.writeString(exceptionMessage);
            dest.writeString(throwFileName);
            dest.writeString(throwClassName);
            dest.writeString(throwMethodName);
            dest.writeInt(throwLineNumber);
            dest.writeString(stackTrace);
            // ---------- Original Method ----------
            //dest.writeString(exceptionClassName);
            //dest.writeString(exceptionMessage);
            //dest.writeString(throwFileName);
            //dest.writeString(throwClassName);
            //dest.writeString(throwMethodName);
            //dest.writeInt(throwLineNumber);
            //dest.writeString(stackTrace);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.583 -0400", hash_original_method = "12CDDF08CF66932EC00C47C0F2860F33", hash_generated_method = "DF2CF963F7CF879CCBEDEFB298453BD7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dump(Printer pw, String prefix) {
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(pw.dsTaint);
            pw.println(prefix + "exceptionClassName: " + exceptionClassName);
            pw.println(prefix + "exceptionMessage: " + exceptionMessage);
            pw.println(prefix + "throwFileName: " + throwFileName);
            pw.println(prefix + "throwClassName: " + throwClassName);
            pw.println(prefix + "throwMethodName: " + throwMethodName);
            pw.println(prefix + "throwLineNumber: " + throwLineNumber);
            pw.println(prefix + "stackTrace: " + stackTrace);
            // ---------- Original Method ----------
            //pw.println(prefix + "exceptionClassName: " + exceptionClassName);
            //pw.println(prefix + "exceptionMessage: " + exceptionMessage);
            //pw.println(prefix + "throwFileName: " + throwFileName);
            //pw.println(prefix + "throwClassName: " + throwClassName);
            //pw.println(prefix + "throwMethodName: " + throwMethodName);
            //pw.println(prefix + "throwLineNumber: " + throwLineNumber);
            //pw.println(prefix + "stackTrace: " + stackTrace);
        }

        
    }


    
    public static class AnrInfo {
        public String activity;
        public String cause;
        public String info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.583 -0400", hash_original_method = "76183B88EF41C33999366984D15A43B8", hash_generated_method = "97ECD60A9856E55398AB9A94F8B3E0EF")
        @DSModeled(DSC.SAFE)
        public AnrInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.584 -0400", hash_original_method = "A1816E63F03CA551A7DF54BED5A962BD", hash_generated_method = "85767D15FEB08DC240ACE89141FB4A3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AnrInfo(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            activity = in.readString();
            cause = in.readString();
            info = in.readString();
            // ---------- Original Method ----------
            //activity = in.readString();
            //cause = in.readString();
            //info = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.585 -0400", hash_original_method = "C2E7AD44BF6B2BCB887E6B9726568F1C", hash_generated_method = "DAF1666E6E7FCFB9520696BF93086AB1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeString(activity);
            dest.writeString(cause);
            dest.writeString(info);
            // ---------- Original Method ----------
            //dest.writeString(activity);
            //dest.writeString(cause);
            //dest.writeString(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.586 -0400", hash_original_method = "B28573F62D1F3D7B120AF5A59DF14509", hash_generated_method = "50DDC82C5ECEBF205BD946F95648063D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dump(Printer pw, String prefix) {
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(pw.dsTaint);
            pw.println(prefix + "activity: " + activity);
            pw.println(prefix + "cause: " + cause);
            pw.println(prefix + "info: " + info);
            // ---------- Original Method ----------
            //pw.println(prefix + "activity: " + activity);
            //pw.println(prefix + "cause: " + cause);
            //pw.println(prefix + "info: " + info);
        }

        
    }


    
    public static class BatteryInfo {
        public int usagePercent;
        public long durationMicros;
        public String usageDetails;
        public String checkinDetails;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.587 -0400", hash_original_method = "D2192429514F02BB97F8B55205CB5D4D", hash_generated_method = "50D456E6A7890D787C7F0F99F1A3C64A")
        @DSModeled(DSC.SAFE)
        public BatteryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.588 -0400", hash_original_method = "73596E36061F6AD3279B28A01C976EEF", hash_generated_method = "828BD388F112EC8BC09E50A6BDDDC35A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BatteryInfo(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            usagePercent = in.readInt();
            durationMicros = in.readLong();
            usageDetails = in.readString();
            checkinDetails = in.readString();
            // ---------- Original Method ----------
            //usagePercent = in.readInt();
            //durationMicros = in.readLong();
            //usageDetails = in.readString();
            //checkinDetails = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.588 -0400", hash_original_method = "530617490987BC288812A812A090F855", hash_generated_method = "B3F0E929DAE15F7817EB7917A3C0A3A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(usagePercent);
            dest.writeLong(durationMicros);
            dest.writeString(usageDetails);
            dest.writeString(checkinDetails);
            // ---------- Original Method ----------
            //dest.writeInt(usagePercent);
            //dest.writeLong(durationMicros);
            //dest.writeString(usageDetails);
            //dest.writeString(checkinDetails);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.589 -0400", hash_original_method = "A13E8F561D1454805516846C4F2ACB3F", hash_generated_method = "49910E7181E7778EE22D28792AA82131")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dump(Printer pw, String prefix) {
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(pw.dsTaint);
            pw.println(prefix + "usagePercent: " + usagePercent);
            pw.println(prefix + "durationMicros: " + durationMicros);
            pw.println(prefix + "usageDetails: " + usageDetails);
            pw.println(prefix + "checkinDetails: " + checkinDetails);
            // ---------- Original Method ----------
            //pw.println(prefix + "usagePercent: " + usagePercent);
            //pw.println(prefix + "durationMicros: " + durationMicros);
            //pw.println(prefix + "usageDetails: " + usageDetails);
            //pw.println(prefix + "checkinDetails: " + checkinDetails);
        }

        
    }


    
    public static class RunningServiceInfo {
        public long durationMillis;
        public String serviceDetails;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.589 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "822CEFC1BD8FA9077CAB00884D317765")
        @DSModeled(DSC.SAFE)
        public RunningServiceInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.590 -0400", hash_original_method = "2BF3FED145657C6E98603A374CE15B79", hash_generated_method = "CF9CD3E9BB172C9C4E5FDA2CA8A71DD8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RunningServiceInfo(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            durationMillis = in.readLong();
            serviceDetails = in.readString();
            // ---------- Original Method ----------
            //durationMillis = in.readLong();
            //serviceDetails = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.590 -0400", hash_original_method = "DD72EF524B8A5B3FA338ADFF302C8897", hash_generated_method = "674813DC4B8954A3EECBAE5B8D0302DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeLong(durationMillis);
            dest.writeString(serviceDetails);
            // ---------- Original Method ----------
            //dest.writeLong(durationMillis);
            //dest.writeString(serviceDetails);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.591 -0400", hash_original_method = "BA9B01A70699F7EA70070719DF8ACE84", hash_generated_method = "9DA9781CB7F53431FA3395DF60F83BAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dump(Printer pw, String prefix) {
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(pw.dsTaint);
            pw.println(prefix + "durationMillis: " + durationMillis);
            pw.println(prefix + "serviceDetails: " + serviceDetails);
            // ---------- Original Method ----------
            //pw.println(prefix + "durationMillis: " + durationMillis);
            //pw.println(prefix + "serviceDetails: " + serviceDetails);
        }

        
    }


    
    static final String SYSTEM_APPS_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.system.apps";
    static final String DEFAULT_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.default";
    public static final int TYPE_NONE = 0;
    public static final int TYPE_CRASH = 1;
    public static final int TYPE_ANR = 2;
    public static final int TYPE_BATTERY = 3;
    public static final int TYPE_RUNNING_SERVICE = 5;
    public static final Parcelable.Creator<ApplicationErrorReport> CREATOR = new Parcelable.Creator<ApplicationErrorReport>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.591 -0400", hash_original_method = "D02E7C98CADEACD71C390EF313CCEAC7", hash_generated_method = "7B3DAE36EEA7A52DBD2662CB418AD767")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ApplicationErrorReport createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ApplicationErrorReport varDEB1E74CA060D1FE7FFCFBEF3C27185D_202160681 = (new ApplicationErrorReport(source));
            return (ApplicationErrorReport)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ApplicationErrorReport(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.592 -0400", hash_original_method = "910469A5C451BE7A7AD117B169DA9905", hash_generated_method = "86096685BDFD9BC33BCCEEC414074EA2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ApplicationErrorReport[] newArray(int size) {
            dsTaint.addTaint(size);
            ApplicationErrorReport[] var745C9C1DC2BA712B7E1960DED8D77B69_1960651356 = (new ApplicationErrorReport[size]);
            return (ApplicationErrorReport[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ApplicationErrorReport[size];
        }

        
}; //Transformed anonymous class
}

