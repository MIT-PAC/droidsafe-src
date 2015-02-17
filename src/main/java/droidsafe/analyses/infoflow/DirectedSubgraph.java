package droidsafe.analyses.infoflow;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.StringEscapeUtils;

import soot.Body;
import soot.SootMethod;
import soot.Unit;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.DirectedGraph;

/**
 * Class for generating control flow of a subgraph reachable from
 * a given basic block.  This class will add single entry and exit
 * points as well as other adjustments (for preserving post-dominance
 * relationships for loops).
 * 
 * @author jeikenberry
 */
public class DirectedSubgraph implements DirectedGraph<Block> {
	List<Block> heads, tails;
	Map<Block, List<Block>> preds, succs;

	/**
	 * Create a subgraph of body over all blocks reachable from start.
	 * This will insert dummy start and end blocks to ensure there is
	 * exactly one entrance and one exit.
	 * 
	 * @param body Body of the method
	 * @param start Block to start from
	 */
	public DirectedSubgraph(Block start) {
		Body body = start.getBody();
		this.heads = new ArrayList<Block>();
		this.tails = new ArrayList<Block>();
		this.preds = new HashMap<Block, List<Block>>();
		this.succs = new HashMap<Block, List<Block>>();
		
		// construct a map of nodes to edges that represents
		// a subgraph that is reachable from start
		Set<Block> marked = new HashSet<Block>();
		Stack<Block> stack = new Stack<Block>();
		stack.push(start);
		while (!stack.isEmpty()) {
			Block nextBlock = stack.pop();
			if (marked.contains(nextBlock))
				continue;
			marked.add(nextBlock);
			List<Block> succSet = new ArrayList<Block>();
			succs.put(nextBlock, succSet);
			succSet.addAll(nextBlock.getSuccs());
			for (Block succBlock : succSet) {
				List<Block> predSet = preds.get(succBlock);
				if (predSet == null) {
					predSet = new ArrayList<Block>();
					preds.put(succBlock, predSet);
				}
				predSet.add(nextBlock);
				stack.push(succBlock);
			}
		}
		
		// Let there be only one head and one tail.
		Block psuedoHead = new Block(null, null, body, Integer.MIN_VALUE, 0, null);
		Block psuedoTail = new Block(null, null, body, Integer.MAX_VALUE, 0, null);
		this.heads.add(psuedoHead);
		this.tails.add(psuedoTail);
		
		// For loops we need to add edges from all of the preds of
		// start to go to the succs of start.  The reason is because
		// backedges mess up the post-dominance relationship (i.e. the
		// loop body will be children of start and not siblings).  By
		// bipassing start, we move loop body up the post-dominance tree
		// and we will now effectively be propagating taint from start to
		// the loop body. 
		List<Block> loopBacks = this.preds.get(start);
		List<Block> startSuccs = this.succs.get(start);
		if (loopBacks != null) {
			for (Block loopBlock : this.preds.get(start)) {
				List<Block> loopBlockSuccs = succs.get(loopBlock);
				loopBlockSuccs.addAll(startSuccs);
			}
		}
		
		// Add an edge from pseudoHead to start.
		List<Block> psuedoHeadSuccs = new ArrayList<Block>();
		psuedoHeadSuccs.add(start);
		this.preds.put(psuedoHead, new ArrayList<Block>());
		this.succs.put(psuedoHead, psuedoHeadSuccs);
		List<Block> headPredSet = preds.get(start);
		if (headPredSet == null) {
			headPredSet = new ArrayList<Block>();
			preds.put(start, headPredSet);
		}
		headPredSet.add(psuedoHead);
		
		// Add an edge from each tail to psuedoTail.
		List<Block> psuedoTailPreds = new ArrayList<Block>();
		this.preds.put(psuedoTail, psuedoTailPreds);
		this.succs.put(psuedoTail, new ArrayList<Block>());
		for (Block block : marked) {
			List<Block> succs = this.succs.get(block);
			if (succs == null) {
				succs = new ArrayList<Block>();
				succs.add(psuedoTail);
				this.succs.put(block, succs);
				psuedoTailPreds.add(block);
			} else if (succs.isEmpty()) {
				succs.add(psuedoTail);
				psuedoTailPreds.add(block);
			}
		}
	}

	@Override
	public List<Block> getHeads() {
		return heads;
	}

	@Override
	public List<Block> getPredsOf(Block s) {
		List<Block> predList = preds.get(s);
		if (predList == null)
			return new ArrayList<Block>();
		return predList;
	}

	@Override
	public List<Block> getSuccsOf(Block s) {
		List<Block> succList = succs.get(s);
		if (succList == null)
			return new ArrayList<Block>();
		return succList;
	}

	@Override
	public List<Block> getTails() {
		return tails;
	}

	@Override
	public Iterator<Block> iterator() {
		return succs.keySet().iterator();
	}

	@Override
	public int size() {
		return succs.size();
	}
	
	/**
	 * Generate graphviz dot output on method and marking the start
	 * block in red.
	 * 
	 * @param method SootMethod of interest
	 * @param start Block to start from
	 * @return String of the dot output
	 */
    public String toString(SootMethod method, Block start) {
		Map<Block, Integer> blockNumbers = new HashMap<Block, Integer>();
		StringBuilder sb = new StringBuilder("digraph " + method.getName() + "CFG {\n");
		
		// Generate the nodes
		int bIdx = 0;
		int instOff = 0;
		for (Block b : this) {
			blockNumbers.put(b, bIdx);
			sb.append("  bb");
			sb.append(bIdx);
			sb.append(" [shape=none, margin=0, label=<\n");
			if (b.equals(start))
				sb.append("    <table bgcolor=\"#FF6666\" border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n");
			else
				sb.append("    <table border=\"0\" cellborder=\"1\" cellspacing=\"0\" cellpadding=\"4\">\n");
			int idx = b.getIndexInMethod();
			if (heads.contains(b)) {
				sb.append("      <tr><td align=\"center\">START</td></tr>");
			} else if (tails.contains(b)) {
				sb.append("      <tr><td align=\"center\">END</td></tr>");
			} else {
				for (Unit unit : b) {
					sb.append("      <tr><td align=\"left\">");
					sb.append(idx+instOff);
					sb.append("</td><td align=\"left\">");
					sb.append(StringEscapeUtils.escapeHtml4(unit.toString()));
					sb.append("</td></tr>\n");
					instOff++;
				}
				instOff--;
			}
			sb.append("    </table>>];\n");
			bIdx++;
		}
		
		// Generate the edges
		for (Block b : this) {
			int bFrom = blockNumbers.containsKey(b) ? 
					blockNumbers.get(b) : blockNumbers.size();
			for (Block succ : getSuccsOf(b)) {
				int bTo = blockNumbers.containsKey(succ) ? 
						blockNumbers.get(succ) : blockNumbers.size();
				sb.append("  bb");
				sb.append(bFrom);
				sb.append(" -> bb");
				sb.append(bTo);
				sb.append(";\n");
			}
		}
		
		sb.append("}");
		return sb.toString();
	}
	
    /**
     * Write out the .dot file of a particular method to destDir and 
     * prefixed by prefix.
     * 
     * @param method SootMethod of interest
     * @param destDir File of the directory to write to
     * @param suffix String of the file suffix 
	 * @param start Block to start from
     * @throws IOException
     */
	public void toDotFile(SootMethod method, File destDir, String suffix, 
			Block start) throws IOException {
		if (!destDir.exists()) {
			if (!destDir.mkdirs())
				throw new IOException("could not create directory " + destDir);
		} else if (!destDir.isDirectory()) {
			throw new IOException(destDir + " exists, but is a file");
		}
		
		String className = method.getDeclaringClass().getName();
		try (PrintWriter fileOut = new PrintWriter(new File(destDir,
				className + "." + method.getName() + "." + start.getIndexInMethod() 
				+ suffix + ".dot"))) {
			fileOut.println(this.toString(method, start));
		}
	}
}
