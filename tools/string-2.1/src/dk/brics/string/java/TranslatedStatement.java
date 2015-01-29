package dk.brics.string.java;

import java.util.LinkedList;
import java.util.List;

import dk.brics.string.intermediate.Hotspot;
import dk.brics.string.intermediate.Statement;

/**
 * Contains the entry and exit points for the control-flow graph of a single
 * translated jimple-statement, and a list of all the {@link Hotspot} statements
 * within.
 * <p/>
 * Individual jimple-statement are always translated into a properly nested
 * control-flow graph, before being connected with the other statements.
 * <p/>
 * The statements are created by {@link StatementTranslatorImpl} and wrapped in 
 * a {@link TranslatedStatement} by {@link StatementTranslatorFacade}.
 */
public final class TranslatedStatement {
	private Statement first;
	private Statement last;
    private List<HotspotValueBoxPair> hotspots = new LinkedList<HotspotValueBoxPair>();
    private List<Statement> statements = new LinkedList<Statement>();
	
	/**
	 * Prepares the results of a translated statement. The list of hotspots is initially empty,
	 * and should be added to the list returned by {@link #getHotspots()}.
	 * @param first entry point to the translated statement's control-flow graph
	 * @param last exit point from the translated statement's control-flow graph
	 */
	public TranslatedStatement(Statement first, Statement last) {
		this.first = first;
		this.last = last;
	}
    
	/**
	 * Gets the entry point from the statement's control-flow graph.
	 */
	public Statement getFirst() {
		return first;
	}
	
	/**
	 * Gets the exit point from the statement's control-flow graph.
	 */
	public Statement getLast() {
		return last;
	}
	
	/**
	 * Returns all the statements in the translation, in an arbitrary order.
	 * @return a mutable list backed by this object. 
	 */
	public List<Statement> getStatements() {
		return statements;
	}

	/**
	 * Returns the list of hotspots in the statement's control-flow graph, along
	 * with the jimple expressions they originated from.
	 * Hotspots may be added to this list.
	 * @return a mutable reference to the list of hotspots.
	 */
	public List<HotspotValueBoxPair> getHotspots() {
		return hotspots;
	}
}
