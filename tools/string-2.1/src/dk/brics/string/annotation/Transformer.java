package dk.brics.string.annotation;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.Body;
import soot.BodyTransformer;
import soot.Value;
import soot.ValueBox;
import soot.jimple.IdentityStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.ParameterRef;
import soot.jimple.Stmt;
import soot.tagkit.StringTag;
import dk.brics.automaton.Automaton;
import dk.brics.string.HotspotKind;
import dk.brics.string.RuntimeHotspot;
import dk.brics.string.RuntimeResolver;
import dk.brics.string.StringAnalysis;

public class Transformer extends BodyTransformer {

	public StringAnalysis sa = null;
	public AnnotationAnalyzer analyzer = null;
	public HotspotTagger tagger = null;
	public static final String PHASE_NAME = "jsatagger";
	public static final String TAG_TYPE = "Annotation Checker";
	
	// NOTE: According to SOOT coding rules, this is not the correct way of
	// providing a singleton. Instead one should add the class name to
	// %SOOTHOME/src/singletons.list and then run:
	// %SOOTHOME/src/make_singletons > soot/src/soot/Singletons.java
	// and then provide:
	// 1. public JSATransformer(Singletons.G.global g) {}
	// 2. public static JSATransformer v() {return G.v().<singleton_name>}
	// This is so that when resetting soot by calling G.v().reset() this
	// class will also be reset.
	private static Transformer instance = new Transformer();	
	private Transformer() {}	
	public static Transformer v() {return instance;}

	@SuppressWarnings("unchecked")
	@Override
	protected void internalTransform(Body body, String arg1, Map arg2) {
		//This method is called several times, but we only need to do
		//some work the first time the method is called. Therefore we
		//check if the sa field is null
		if (sa == null) {
			RuntimeResolver rr = new RuntimeResolver();
			StringAnalysis.addResolver(rr);
			
			analyzer = new AnnotationAnalyzer();
			tagger = new HotspotTagger();
			
			Set<ValueBox> hotspots = new HashSet<ValueBox>();
			hotspots.addAll(analyzer.getHotspots());
			hotspots.addAll(rr.getHotspotExps());
			
			sa = new StringAnalysis(hotspots);
			
			handleAnnotationHotspots();
			handleAnalyzeRuntimeHotspots(rr);
		}
	}
	
	private void handleAnnotationHotspots() {
		for (ValueBox box : analyzer.getHotspots()) {
			//Stmt stmt = analyzer.getStmt(box);
			Stmt stmt = tagger.getStmt(box);
			Automaton a = analyzer.getAutomaton(box);
			Automaton b = sa.getAutomaton(box);
			Automaton diff = a.complement().intersection(b);
			if (!diff.isEmpty()) {
				String from;
				if (b.isTotal()) {
					from = "anystring";
				}
				else {
					from = quoteString(diff.getShortestExample(true));
				}
				if (stmt.containsInvokeExpr()) {
					InvokeExpr invoke = stmt.getInvokeExpr();
					for (int i=0; i<invoke.getArgCount(); i++) {
						if (box == invoke.getArgBox(i)) {
							stmt.addTag(new StringTag("Type mismatch: cannot convert argument number " + (i+1) + " from " + from + " to " + analyzer.getDescription(a)));
						}
					}
				}
				else if (stmt instanceof IdentityStmt) {
					IdentityStmt iStmt = (IdentityStmt)stmt;
					Value rvalue = iStmt.getRightOp();
					if (rvalue instanceof ParameterRef) {
						ParameterRef parameter = (ParameterRef)rvalue;
						int index = parameter.getIndex();
						stmt.addTag(new StringTag("Type mismatch: cannot convert parameter number " + (index + 1) + " from " + from + " to " + analyzer.getDescription(a)));
					}
				}
				else {
					stmt.addTag(new StringTag("Type mismatch: cannot convert from " + from + " to " + analyzer.getDescription(a)));
				}
			}
		}
	}
	
	private void handleAnalyzeRuntimeHotspots(RuntimeResolver rr) {
		List<RuntimeHotspot> runtime_hotspots = rr.getHotspots();
		for (RuntimeHotspot rh : runtime_hotspots) {
			ValueBox e = rh.spot;
			String sf = sa.getSourceFile(e);
			int line = sa.getLineNumber(e);
			String kind = "";
			if (rh.kind==HotspotKind.ANALYZE)
				kind = "RegExp.analyze()";
			else if (rh.kind==HotspotKind.CHECK)
				kind = "RegExp.check()";
			else {
				System.err.println("unrecognized runtime method!");
				System.exit(1);
			}
			System.err.println("Checking "+kind+" at line "+line+" in "+sf+"...");
			Automaton a = sa.getAutomaton(e);
			Automaton expected_neg = rh.expected.complement();
			if (rh.kind==HotspotKind.ANALYZE) {
				Automaton diff = a.intersection(expected_neg);
				if (diff.isEmpty())
					if (a.equals(rh.expected))
						System.err.println("Exact match!");
					else
						System.err.println("Always satified!");
				else {
					System.err.println("Dissatisfied by:");
					System.err.println(quoteString(diff.getShortestExample(true)));
					tagger.tag(e, "Dissatisfied by: " + quoteString(diff.getShortestExample(true)));
				}
			} else if (rh.kind==HotspotKind.CHECK) {
				if (a.intersection(expected_neg).isEmpty()) 
					System.err.println("Always satified!");
				else if (a.intersection(rh.expected).isEmpty()) {
					System.err.println("Never satified!");
					tagger.tag(e, "Never satified!");
				}
			}
		}
	}
	
	private static String quoteString(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append("\"");
		for (int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			switch (c) {
			case '\t': sb.append("\\t"); break;
			case '\n': sb.append("\\n"); break;
			case '\r': sb.append("\\r"); break;
			case '\"': sb.append("\\\""); break;
			case '\\': sb.append("\\\\"); break;
			default:
				if (c >= 32 && c <= 126)
					sb.append(c);
				else {
					String digits = Integer.toHexString(0x10000+c);
					sb.append("\\u").append(digits.substring(1));
				}
			}
		}
		sb.append("\"");
		return sb.toString();
	}
	
	public void reset() {
		sa = null;
		analyzer = null;
		tagger = null;
	}
}
