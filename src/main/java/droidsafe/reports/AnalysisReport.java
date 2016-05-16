package droidsafe.reports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import droidsafe.android.app.Project;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.Stmt;

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
	
	public static final String FILE_NAME = "analysis-warning-report.txt";
	/** entries of the report */
	private List<AnalysisReportEntry> entries; 
	
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
			int ret = Integer.compare(o.level.ordinal(), this.level.ordinal());
			
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
			location = JimpleRelationships.v().getEnclosingMethod(stmt).toString();
		}
		
		addEntry(text, location, level);
	}
	
	public void addEntry(String text, Level level) {
		addEntry(text, "No Source Location", level);
	}
	
	public void addEntry(String text, SourceLocationTag location, Level level) {
		addEntry(text, location.toString(), level);
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
	
	public void writeReport() {		
		//sort by priority 
		Collections.sort(entries);
		
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
