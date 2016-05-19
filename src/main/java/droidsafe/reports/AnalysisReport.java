package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;

/**
 * This class stores data and produces a report for an analyst of any issues encountered during 
 * the analysis that are suspicious or could lead to imprecision or inaccuracy in the results.
 * 
 * @author mgordon
 *
 */
public class AnalysisReport {

	/** Warning levels from highest to lowest */
	public enum Level {
		SEVERE, HIGH, ELEVATED, GUARDED, LOW 
	}

	private String[] BANNED_PACKAGES = new String[] {
			"java.lang.reflect", "dalvik.system", "dalvik.bytecode"
	};
	
	public static final String FILE_NAME = "analysis-warning-report.txt";
	/** entries of the report */
	private Set<AnalysisReportEntry> entries;

	private AnalysisReport() {
		entries = new HashSet<AnalysisReportEntry>();
	}
	
	/** Class for each entry in the report */
	class AnalysisReportEntry implements Comparable<AnalysisReportEntry> {
		String location;
		Level level;
		String text;			

		public AnalysisReportEntry(String location, Level level, String text) {
			super();
			this.location = location;
			this.level = level;
			this.text = text;
		}

		@Override
		public int compareTo(AnalysisReportEntry o) {
			int ret = Integer.compare(this.level.ordinal(), o.level.ordinal());

			if (ret == 0) {
				//same level, then sort by sourcelocationtag
				if (this.location != null)
					return this.location.compareTo(o.location);
				else
					return -1;
			} else 
				return ret;					
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((level == null) ? 0 : level.hashCode());
			result = prime * result + ((location == null) ? 0 : location.hashCode());
			result = prime * result + ((text == null) ? 0 : text.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AnalysisReportEntry other = (AnalysisReportEntry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (level != other.level)
				return false;
			if (location == null) {
				if (other.location != null)
					return false;
			} else if (!location.equals(other.location))
				return false;
			if (text == null) {
				if (other.text != null)
					return false;
			} else if (!text.equals(other.text))
				return false;
			return true;
		}

		private AnalysisReport getOuterType() {
			return AnalysisReport.this;
		}		

		public String toString() {
			return level.name() + ": " + text + " [" + 
					(location == null ? "no source info" :
						location.toString()) +"]";


		}
	}

	/** static singleton */
	private static AnalysisReport v;

	/** Soot singleton pattern */
	public static AnalysisReport v() {
		if (v == null) {
			v = new AnalysisReport(); 
		}

		return v;
	}

	public void addEntry(String text, Stmt stmt, Level level) {
		SourceLocationTag src = SootUtils.getSourceLocation(stmt);
		String location;

		if (src != null) {
			location = src.toString();
		} else {
			SootMethod enclosingM = JimpleRelationships.v().getEnclosingMethod(stmt);
			if (enclosingM != null)
				location = enclosingM.toString();
			else 
				location = "No Source Location";
		}

		addEntry(text, location, level);
	}

	public void addEntry(String text, Level level) {
		addEntry(text, "No Source Location", level);
	}

	public void addEntry(String text, SourceLocationTag location, Level level) {
		if (location == null) {
			addEntry(text, level);
		} else {
			addEntry(text, location.toString(), level);
		}
	}

	public void addEntry(String text, SootClass clz, Level level) {
		addEntry(text, clz.getName(), level);
	}

	public void addEntry(String text, SootMethod method, Level level) {
		addEntry(text, method.getName(), level);
	}

	public void addEntry(String text, String location, Level level) {
		AnalysisReportEntry entry = new AnalysisReportEntry(location, level, text);
		entries.add(entry);
	}

	private void reportBannedCalls() {
		for (SootMethod containingMthd : PTABridge.v().getReachableMethods()) {
			// filter out abstract, not concrete, phantom and stub methods
			if (API.v().isSystemMethod(containingMthd) 
					|| containingMthd.isAbstract() 
					|| !containingMthd.isConcrete() 
					|| containingMthd.isPhantom() 
					|| SootUtils.isRuntimeStubMethod(containingMthd))
				continue;

			// iterate over the containing method's body statements
			StmtBody stmtBody = (StmtBody)containingMthd.getActiveBody();
			Iterator stmtIt = stmtBody.getUnits().snapshotIterator();
			while (stmtIt.hasNext()) {
				Stmt stmt = (Stmt)stmtIt.next();

				if (!stmt.containsInvokeExpr())
					continue;
				
				for (SootMethod callee : PTABridge.v().getTargetsInsNoContext(containingMthd, stmt)) {                        
					if (targetInBannedPackage(callee) ||
							API.v().isBannedMethod(callee)) {
						addEntry("Potential call to banned package: " + callee, stmt, Level.HIGH);
					}
				}
			}
		}
	}
	
	/** 
	 * Return true if method in a banned package.
	 */
	private boolean targetInBannedPackage(SootMethod target) {
		for (String pkg : BANNED_PACKAGES) {
			if (target.getName().startsWith(pkg))
				return true;
		}
		return false;
	}

	public void writeReport() {
		reportBannedCalls();
		
		//sort by priority 
		List<AnalysisReportEntry> sorted = new LinkedList<AnalysisReportEntry>();
		sorted.addAll(entries);
		Collections.sort(sorted);

		try {
			FileWriter fw = new FileWriter(Project.v().getOutputDir() + File.separator + FILE_NAME);

			for (AnalysisReportEntry entry : entries) {
				fw.write(entry.toString() + "\n");
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
