package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.314 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.314 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.314 -0400", hash_original_field = "5F90A0D33014643B0F6A2D5F0BB66C35", hash_generated_field = "197F53EC193DDE6F22FC12D776A9B51E")

    public String installerPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.314 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.314 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "5A44367B7C554CE37EA61A01D45FAC73")

    public long time;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.314 -0400", hash_original_field = "93736D48DB53F35FB4ECDC1A2AE31C25", hash_generated_field = "E6A27F82DF8950D21D06A7FB2E81C58B")

    public boolean systemApp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.314 -0400", hash_original_field = "E2830D8E0018BB9D7C72E36DDDB650B2", hash_generated_field = "FBA804E5CF855ECC62CEF36A3790B2FB")

    public CrashInfo crashInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.315 -0400", hash_original_field = "409FE9EDF2D9292FA716E19C8B0FE631", hash_generated_field = "6A45BBBCA030DD2B3FFD7329E23B5D3C")

    public AnrInfo anrInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.315 -0400", hash_original_field = "46E6D376CE5024E6E19C507E9EC31286", hash_generated_field = "0F63A0DB674D6731E0337B045B7EB045")

    public BatteryInfo batteryInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.315 -0400", hash_original_field = "FD252E36F751C92C1A875B81DFBA0E04", hash_generated_field = "D33B642B4807217FCC71196D912E4B88")

    public RunningServiceInfo runningServiceInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.316 -0400", hash_original_method = "6CC6117712C6457F9E284742535D4C3A", hash_generated_method = "A32824C33E3DAEF3E43183F720B0B2CF")
    public  ApplicationErrorReport() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.316 -0400", hash_original_method = "56C9FAB6FC92FE279C6A2DB2655BED71", hash_generated_method = "E4E7E8DA89B8D1B4BA93D4BECCA5B4E8")
      ApplicationErrorReport(Parcel in) {
        readFromParcel(in);
        addTaint(in.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.317 -0400", hash_original_method = "A097CEBB0222A4C65AC186DA78BE4FCB", hash_generated_method = "DE8F7739BE2E2E7079EE17481D4C28E3")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeString(packageName);
        dest.writeString(installerPackageName);
        dest.writeString(processName);
        dest.writeLong(time);
        dest.writeInt(systemApp ? 1 : 0);
        
        crashInfo.writeToParcel(dest, flags);
        
        
        anrInfo.writeToParcel(dest, flags);
        
        
        batteryInfo.writeToParcel(dest, flags);
        
        
        runningServiceInfo.writeToParcel(dest, flags);
        
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.319 -0400", hash_original_method = "D8BAAB71575DEB17ADCE92E48607D31D", hash_generated_method = "AE72B9EAE1C63095EC761270E2E241DC")
    public void readFromParcel(Parcel in) {
        type = in.readInt();
        packageName = in.readString();
        installerPackageName = in.readString();
        processName = in.readString();
        time = in.readLong();
        systemApp = in.readInt() == 1;
        
        crashInfo = new CrashInfo(in);
        
        
        anrInfo = null;
        
        
        batteryInfo = null;
        
        
        runningServiceInfo = null;
        
        
        anrInfo = new AnrInfo(in);
        
        
        crashInfo = null;
        
        
        batteryInfo = null;
        
        
        runningServiceInfo = null;
        
        
        batteryInfo = new BatteryInfo(in);
        
        
        anrInfo = null;
        
        
        crashInfo = null;
        
        
        runningServiceInfo = null;
        
        
        batteryInfo = null;
        
        
        anrInfo = null;
        
        
        crashInfo = null;
        
        
        runningServiceInfo = new RunningServiceInfo(in);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.320 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E1D15F3A8977503EAAC20415AAF22AE0")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159791589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159791589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.321 -0400", hash_original_method = "EB05E0A242CB818854C5BC92B57FA752", hash_generated_method = "633554671DE1F2401166AF04FDA08A76")
    public void dump(Printer pw, String prefix) {
        pw.println(prefix + "type: " + type);
        pw.println(prefix + "packageName: " + packageName);
        pw.println(prefix + "installerPackageName: " + installerPackageName);
        pw.println(prefix + "processName: " + processName);
        pw.println(prefix + "time: " + time);
        pw.println(prefix + "systemApp: " + systemApp);
        
        crashInfo.dump(pw, prefix);
        
        
        anrInfo.dump(pw, prefix);
        
        
        batteryInfo.dump(pw, prefix);
        
        
        runningServiceInfo.dump(pw, prefix);
        
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        
        
        
        
        
        
        
        
            
                
                
            
                
                
            
                
                
            
                
                
        
    }

    
    public static class CrashInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.321 -0400", hash_original_field = "FCD6ECDB9C47F92B3199DC861D2FB141", hash_generated_field = "64A4CFC776584F31DADD8ED1088FC67C")

        public String exceptionClassName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.321 -0400", hash_original_field = "0A32F30923E2B9F2D7272796EC05C488", hash_generated_field = "D36773DA8FD6053F2F11D03036B18E50")

        public String exceptionMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.321 -0400", hash_original_field = "EA75ABCDEEAF4C31A710E4AFB370812E", hash_generated_field = "8F4E83DBBFEBB927A2F201A7C280BA50")

        public String throwFileName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.321 -0400", hash_original_field = "C57CF347FD481604E76B4D1FA22571D1", hash_generated_field = "BB6C2D1FC7E043EA12C976DFCB570E3E")

        public String throwClassName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.321 -0400", hash_original_field = "548F30E72C44FCCD6A7F12AC555AAB4F", hash_generated_field = "E36BF34C42829B1C195FD3FC0F8D3478")

        public String throwMethodName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.321 -0400", hash_original_field = "111C62FA9FFAE2036CD56BBF6A236E8E", hash_generated_field = "04E0FBE65762D8F1BA1BD7B505B8DA69")

        public int throwLineNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.322 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "5AD16E48548E8F81D0DFF7F4F7B69945")

        public String stackTrace;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.322 -0400", hash_original_method = "A5C69B6119C4811D45501C8F0E46959E", hash_generated_method = "8F2057BAD303C22C04121A18F120A112")
        public  CrashInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.323 -0400", hash_original_method = "8E877A457FA4EF293EE7618CA0C5075F", hash_generated_method = "4D41929BB51533F0C3FC0BE11DBB830A")
        public  CrashInfo(Throwable tr) {
            StringWriter sw = new StringWriter();
            tr.printStackTrace(new PrintWriter(sw));
            stackTrace = sw.toString();
            exceptionMessage = tr.getMessage();
            Throwable rootTr = tr;
            {
                boolean var49386827104CDB7695A0A911D7203930_169297740 = (tr.getCause() != null);
                {
                    tr = tr.getCause();
                    {
                        boolean varFAC1DD4231C98510C5F83CEABF61BBE8_239207930 = (tr.getStackTrace() != null && tr.getStackTrace().length > 0);
                        {
                            rootTr = tr;
                        } 
                    } 
                    String msg = tr.getMessage();
                    {
                        boolean var1F789A916FEA465A3D5B39DAAFBEE0CA_1421098226 = (msg != null && msg.length() > 0);
                        {
                            exceptionMessage = msg;
                        } 
                    } 
                } 
            } 
            exceptionClassName = rootTr.getClass().getName();
            {
                boolean varB1864E601FD927D95B56A69CA736BC55_553207352 = (rootTr.getStackTrace().length > 0);
                {
                    StackTraceElement trace = rootTr.getStackTrace()[0];
                    throwFileName = trace.getFileName();
                    throwClassName = trace.getClassName();
                    throwMethodName = trace.getMethodName();
                    throwLineNumber = trace.getLineNumber();
                } 
                {
                    throwFileName = "unknown";
                    throwClassName = "unknown";
                    throwMethodName = "unknown";
                    throwLineNumber = 0;
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.324 -0400", hash_original_method = "260530F70C73453962E6EA8579F649BC", hash_generated_method = "F0C54DC18733C90CA999FB191CC2F742")
        public  CrashInfo(Parcel in) {
            exceptionClassName = in.readString();
            exceptionMessage = in.readString();
            throwFileName = in.readString();
            throwClassName = in.readString();
            throwMethodName = in.readString();
            throwLineNumber = in.readInt();
            stackTrace = in.readString();
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.324 -0400", hash_original_method = "7B93ED55B73724A8D927AFB13EC86251", hash_generated_method = "CFD8A5EFBD76A26F6A6CDC28E65F2420")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(exceptionClassName);
            dest.writeString(exceptionMessage);
            dest.writeString(throwFileName);
            dest.writeString(throwClassName);
            dest.writeString(throwMethodName);
            dest.writeInt(throwLineNumber);
            dest.writeString(stackTrace);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.325 -0400", hash_original_method = "12CDDF08CF66932EC00C47C0F2860F33", hash_generated_method = "5D6E2860B856990A24E8DEEAC335C82A")
        public void dump(Printer pw, String prefix) {
            pw.println(prefix + "exceptionClassName: " + exceptionClassName);
            pw.println(prefix + "exceptionMessage: " + exceptionMessage);
            pw.println(prefix + "throwFileName: " + throwFileName);
            pw.println(prefix + "throwClassName: " + throwClassName);
            pw.println(prefix + "throwMethodName: " + throwMethodName);
            pw.println(prefix + "throwLineNumber: " + throwLineNumber);
            pw.println(prefix + "stackTrace: " + stackTrace);
            addTaint(pw.getTaint());
            addTaint(prefix.getTaint());
            
            
            
            
            
            
            
            
        }

        
    }


    
    public static class AnrInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.325 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "2C31FC32EDD5FD275BDF859DF788A1AB")

        public String activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.325 -0400", hash_original_field = "560220FC3242A805F094EDCE47F35702", hash_generated_field = "AEA9B0E08C709D8DF0AF926ABBB6A16A")

        public String cause;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.325 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "EAE55385089271374E8F46F98DBEDE87")

        public String info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.326 -0400", hash_original_method = "76183B88EF41C33999366984D15A43B8", hash_generated_method = "97ECD60A9856E55398AB9A94F8B3E0EF")
        public  AnrInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.326 -0400", hash_original_method = "A1816E63F03CA551A7DF54BED5A962BD", hash_generated_method = "7B3407B87339FFD889C919C6A6BA2086")
        public  AnrInfo(Parcel in) {
            activity = in.readString();
            cause = in.readString();
            info = in.readString();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.327 -0400", hash_original_method = "C2E7AD44BF6B2BCB887E6B9726568F1C", hash_generated_method = "D0FBBA6AA58F15E47EBF1E4470F1838F")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(activity);
            dest.writeString(cause);
            dest.writeString(info);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.328 -0400", hash_original_method = "B28573F62D1F3D7B120AF5A59DF14509", hash_generated_method = "8BF4BD120006589FB19A53460BAC9876")
        public void dump(Printer pw, String prefix) {
            pw.println(prefix + "activity: " + activity);
            pw.println(prefix + "cause: " + cause);
            pw.println(prefix + "info: " + info);
            addTaint(pw.getTaint());
            addTaint(prefix.getTaint());
            
            
            
            
        }

        
    }


    
    public static class BatteryInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.328 -0400", hash_original_field = "24C2079D46C22AA1E1C4E08EAE0FE285", hash_generated_field = "9E192676C8B3F13371C5042FED59D2D3")

        public int usagePercent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.329 -0400", hash_original_field = "E0CE4AE5FAC7AC2FDADC925498CB11A0", hash_generated_field = "89F8076A13AB20078AEC40B417BEC3C1")

        public long durationMicros;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.329 -0400", hash_original_field = "F2C88411F6A9ECAC1C1748716C475F73", hash_generated_field = "D7CE2C36DB4FE34FCB98BD7675508466")

        public String usageDetails;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.329 -0400", hash_original_field = "29BCEC3A79F296C0012384ABD3040CA6", hash_generated_field = "E3E9CE38A0E0817F8707B7EE39B2C6FD")

        public String checkinDetails;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.330 -0400", hash_original_method = "D2192429514F02BB97F8B55205CB5D4D", hash_generated_method = "50D456E6A7890D787C7F0F99F1A3C64A")
        public  BatteryInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.331 -0400", hash_original_method = "73596E36061F6AD3279B28A01C976EEF", hash_generated_method = "7DBE90E0330715697D7D201591B2CFCE")
        public  BatteryInfo(Parcel in) {
            usagePercent = in.readInt();
            durationMicros = in.readLong();
            usageDetails = in.readString();
            checkinDetails = in.readString();
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.332 -0400", hash_original_method = "530617490987BC288812A812A090F855", hash_generated_method = "34086AB0FFD10771B5DD90864DF3F084")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(usagePercent);
            dest.writeLong(durationMicros);
            dest.writeString(usageDetails);
            dest.writeString(checkinDetails);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.332 -0400", hash_original_method = "A13E8F561D1454805516846C4F2ACB3F", hash_generated_method = "0ACE97754C24BE9BA0C247836D011060")
        public void dump(Printer pw, String prefix) {
            pw.println(prefix + "usagePercent: " + usagePercent);
            pw.println(prefix + "durationMicros: " + durationMicros);
            pw.println(prefix + "usageDetails: " + usageDetails);
            pw.println(prefix + "checkinDetails: " + checkinDetails);
            addTaint(pw.getTaint());
            addTaint(prefix.getTaint());
            
            
            
            
            
        }

        
    }


    
    public static class RunningServiceInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.332 -0400", hash_original_field = "3565FE1493DB3BF2DA6D57681F24780C", hash_generated_field = "341FEBE1083E0F8DC34C2C2DD3BFBFF4")

        public long durationMillis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.332 -0400", hash_original_field = "0ECBB44F2FC7B38706E51D20C3B9AA95", hash_generated_field = "0A4E9A2B88820041CD6FBD7FA831FA98")

        public String serviceDetails;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.333 -0400", hash_original_method = "621426751430068D32289E518662756C", hash_generated_method = "822CEFC1BD8FA9077CAB00884D317765")
        public  RunningServiceInfo() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.333 -0400", hash_original_method = "2BF3FED145657C6E98603A374CE15B79", hash_generated_method = "5E3E333557736C4BE6D78DCF7D022199")
        public  RunningServiceInfo(Parcel in) {
            durationMillis = in.readLong();
            serviceDetails = in.readString();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.334 -0400", hash_original_method = "DD72EF524B8A5B3FA338ADFF302C8897", hash_generated_method = "7F6A6AE84DB30BD2128F0F475EBDEF82")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(durationMillis);
            dest.writeString(serviceDetails);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.334 -0400", hash_original_method = "BA9B01A70699F7EA70070719DF8ACE84", hash_generated_method = "08F30A95C46256967FFA61CF5F570764")
        public void dump(Printer pw, String prefix) {
            pw.println(prefix + "durationMillis: " + durationMillis);
            pw.println(prefix + "serviceDetails: " + serviceDetails);
            addTaint(pw.getTaint());
            addTaint(prefix.getTaint());
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "C4765D26669EF9BA9A0E350BAD308085", hash_generated_field = "9F7E8694C4E604CFC7D18F276766C11A")

    static final String SYSTEM_APPS_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.system.apps";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "8EE4357790E8F834D67AED879ADC5935", hash_generated_field = "E291D5AAD7BDEC6675841591269B8EEF")

    static final String DEFAULT_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.default";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "2C9516E0D67A5E2C2F232152013D5790", hash_generated_field = "E5F2FC72F5EFEE032E1F7BB690278BAB")

    public static final int TYPE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "939D11F4DDECD38F72F233A00B4C8048", hash_generated_field = "F15F1796F388B28C4B599BE1A658CC31")

    public static final int TYPE_CRASH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "1C6EDC8F1FDF836FC1AB050CAF2C6E19", hash_generated_field = "75CA544BDE0689343F6A3680842D0DBF")

    public static final int TYPE_ANR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "073B37F9D4C641DEE064009C767E93A1", hash_generated_field = "AA4DE677ACD630EEE925B1C018580548")

    public static final int TYPE_BATTERY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "829BC5347592B7A37003C2172B84E6BC", hash_generated_field = "D21BED58CA32C36A5CB46E18EF40C6AB")

    public static final int TYPE_RUNNING_SERVICE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.335 -0400", hash_original_field = "463EB6214A90B7685070E9D5A0790DB3", hash_generated_field = "0F9628131E534559AAF7FDEF2605D1C5")

    public static final Parcelable.Creator<ApplicationErrorReport> CREATOR
            = new Parcelable.Creator<ApplicationErrorReport>() {
        public ApplicationErrorReport createFromParcel(Parcel source) {
            return new ApplicationErrorReport(source);
        }

        public ApplicationErrorReport[] newArray(int size) {
            return new ApplicationErrorReport[size];
        }
    };
    
    public ApplicationErrorReport createFromParcel(Parcel source) {
            return new ApplicationErrorReport(source);
        }
    
    
    public ApplicationErrorReport[] newArray(int size) {
            return new ApplicationErrorReport[size];
        }
    
}

