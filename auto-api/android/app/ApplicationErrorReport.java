package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final String SYSTEM_APPS_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.system.apps";
    static final String DEFAULT_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.default";
    public static final int TYPE_NONE = 0;
    public static final int TYPE_CRASH = 1;
    public static final int TYPE_ANR = 2;
    public static final int TYPE_BATTERY = 3;
    public static final int TYPE_RUNNING_SERVICE = 5;
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
    public static final Parcelable.Creator<ApplicationErrorReport> CREATOR = new Parcelable.Creator<ApplicationErrorReport>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.753 -0400", hash_original_method = "D02E7C98CADEACD71C390EF313CCEAC7", hash_generated_method = "9EADE481C23E1933C958B4E0AC47B224")
        @DSModeled(DSC.SAFE)
        public ApplicationErrorReport createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ApplicationErrorReport)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ApplicationErrorReport(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.754 -0400", hash_original_method = "910469A5C451BE7A7AD117B169DA9905", hash_generated_method = "E1AAB49DD146999E765D3B8E8C29EA9A")
        @DSModeled(DSC.SAFE)
        public ApplicationErrorReport[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ApplicationErrorReport[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ApplicationErrorReport[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.754 -0400", hash_original_method = "6CC6117712C6457F9E284742535D4C3A", hash_generated_method = "C578B2373547E2D0BC7DD89DD97E6348")
    @DSModeled(DSC.SAFE)
    public ApplicationErrorReport() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.754 -0400", hash_original_method = "56C9FAB6FC92FE279C6A2DB2655BED71", hash_generated_method = "56C62A9E73F26E1878FC095B8FF870C8")
    @DSModeled(DSC.SAFE)
     ApplicationErrorReport(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        readFromParcel(in);
        // ---------- Original Method ----------
        //readFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.755 -0400", hash_original_method = "113BB55A947D145420F5CC219A4706D7", hash_generated_method = "2CE219B5DA8C1C773C84D5B9C63EB865")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.755 -0400", hash_original_method = "E8A44BB5F91823678290CFFD8154BF15", hash_generated_method = "CE5B7AF521BD346C94C471FA8397C804")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.755 -0400", hash_original_method = "A097CEBB0222A4C65AC186DA78BE4FCB", hash_generated_method = "EDC12AE54F7D53E979D91E0F005179B2")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.756 -0400", hash_original_method = "D8BAAB71575DEB17ADCE92E48607D31D", hash_generated_method = "91A2B51933555D94E99681B98D91C99C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.756 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.757 -0400", hash_original_method = "EB05E0A242CB818854C5BC92B57FA752", hash_generated_method = "6F1FAE4E41112C9520BCC65C517290AE")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.757 -0400", hash_original_method = "A5C69B6119C4811D45501C8F0E46959E", hash_generated_method = "4D52CD3EBF4F7379D1A526C84F0D9EA1")
        @DSModeled(DSC.SAFE)
        public CrashInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.758 -0400", hash_original_method = "8E877A457FA4EF293EE7618CA0C5075F", hash_generated_method = "FBE8CB43B108630BABAF725CCF1D9272")
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
                boolean var49386827104CDB7695A0A911D7203930_1660258638 = (tr.getCause() != null);
                {
                    tr = tr.getCause();
                    {
                        boolean varFAC1DD4231C98510C5F83CEABF61BBE8_1488055454 = (tr.getStackTrace() != null && tr.getStackTrace().length > 0);
                        {
                            rootTr = tr;
                        } //End block
                    } //End collapsed parenthetic
                    String msg;
                    msg = tr.getMessage();
                    {
                        boolean var1F789A916FEA465A3D5B39DAAFBEE0CA_1751704208 = (msg != null && msg.length() > 0);
                        {
                            exceptionMessage = msg;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            exceptionClassName = rootTr.getClass().getName();
            {
                boolean varB1864E601FD927D95B56A69CA736BC55_1283798336 = (rootTr.getStackTrace().length > 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.758 -0400", hash_original_method = "260530F70C73453962E6EA8579F649BC", hash_generated_method = "5DBB873E0C7C946E1B9D4323CA5FCDDD")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.758 -0400", hash_original_method = "7B93ED55B73724A8D927AFB13EC86251", hash_generated_method = "D28F05703B7E858A1B66F5B1E8550E34")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.759 -0400", hash_original_method = "12CDDF08CF66932EC00C47C0F2860F33", hash_generated_method = "83C7DDE76EC9D527307E051BBC8CB1F6")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.759 -0400", hash_original_method = "76183B88EF41C33999366984D15A43B8", hash_generated_method = "6853368D02B8C63A3B62E4A04DF3BB56")
        @DSModeled(DSC.SAFE)
        public AnrInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.759 -0400", hash_original_method = "A1816E63F03CA551A7DF54BED5A962BD", hash_generated_method = "E8B7BA22FDE4C12B47BD3A173B60FC42")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.760 -0400", hash_original_method = "C2E7AD44BF6B2BCB887E6B9726568F1C", hash_generated_method = "45E4C7E4F918906F8B3BA9153FA98833")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
            dest.writeString(activity);
            dest.writeString(cause);
            dest.writeString(info);
            // ---------- Original Method ----------
            //dest.writeString(activity);
            //dest.writeString(cause);
            //dest.writeString(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.760 -0400", hash_original_method = "B28573F62D1F3D7B120AF5A59DF14509", hash_generated_method = "8031017A8FD36967E6182A7F992AF35B")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.760 -0400", hash_original_method = "D2192429514F02BB97F8B55205CB5D4D", hash_generated_method = "7B6B43B4B91AC49439F12B7DA6768F98")
        @DSModeled(DSC.SAFE)
        public BatteryInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.761 -0400", hash_original_method = "73596E36061F6AD3279B28A01C976EEF", hash_generated_method = "8553060EB6E6EFF283657F9F45579383")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.761 -0400", hash_original_method = "530617490987BC288812A812A090F855", hash_generated_method = "7788107997C55E11EC1F9B6D09DFA35C")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.761 -0400", hash_original_method = "A13E8F561D1454805516846C4F2ACB3F", hash_generated_method = "4E2470BB1F10136CA9F2D4500A047B11")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.762 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "4C034224787D515760D957854524B900")
        @DSModeled(DSC.SAFE)
        public RunningServiceInfo() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.762 -0400", hash_original_method = "2BF3FED145657C6E98603A374CE15B79", hash_generated_method = "E2E4CCF02C747BBFE33EEE0E677069F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RunningServiceInfo(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            durationMillis = in.readLong();
            serviceDetails = in.readString();
            // ---------- Original Method ----------
            //durationMillis = in.readLong();
            //serviceDetails = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.762 -0400", hash_original_method = "DD72EF524B8A5B3FA338ADFF302C8897", hash_generated_method = "40F42B5A7AB7A9BE08DEE969ECB6917D")
        @DSModeled(DSC.SAFE)
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(dest.dsTaint);
            dsTaint.addTaint(flags);
            dest.writeLong(durationMillis);
            dest.writeString(serviceDetails);
            // ---------- Original Method ----------
            //dest.writeLong(durationMillis);
            //dest.writeString(serviceDetails);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.762 -0400", hash_original_method = "BA9B01A70699F7EA70070719DF8ACE84", hash_generated_method = "A90B0A37B732EE983C1B2C239A23AD35")
        @DSModeled(DSC.SAFE)
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


    
}


