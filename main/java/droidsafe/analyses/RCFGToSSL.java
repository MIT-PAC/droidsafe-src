package droidsafe.analyses;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.analyses.rcfg.RCFG;
import droidsafe.android.app.Project;
import droidsafe.speclang.SecuritySpecification;


public class RCFGToSSL {
	private final static Logger logger = LoggerFactory.getLogger(RCFGToSSL.class);
	
	public static void run() {
		SecuritySpecification spec = new SecuritySpecification();
		
		String fname = Project.v().getOutputDir() + "/" + "NAME" + ".ssl";
		writeSpecToFile(spec.toString(), fname);

        String html_fname = Project.v().getOutputDir() + "/spec.html";
        writeSpecToFile(spec.toHtmlString(), html_fname);        
	}
	
	private static void writeSpecToFile(String secspec, String fname) {
		try{
			FileWriter fstream = new FileWriter(fname);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(secspec);
			out.close();
		}catch (Exception e){//Catch exception if any
          logger.error("Writing specification file.", e.getMessage());
		}
	}
}
