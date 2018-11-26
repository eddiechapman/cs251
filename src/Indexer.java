import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Indexer {

	private Map<Token, List<Document>> reversedIndex;	// Maps a Token to a List of Documents
	private Map<String, Token> allTokens;				// Maps a String to a Token to avoid Token duplication
	private Map<String, Document> allDocs;				// Maps a string to a Document to avoid Document duplication
	private List<Document> allDocsSorted;				// Holds all Documents sorted by DocID
	private int assignID;								// Use for docID when creating Documents. Increments from 1.
	
	// Used for printing to console
	private String thickLine = "==================================================";	
	private String thinLine = "--------------------------------------------------";
	
	//***************************************************************************
	
	public Indexer() {
		
		reversedIndex = new HashMap<>();
		allDocs = new HashMap<>();
		allDocsSorted = new ArrayList<>();
		allTokens = new HashMap<>();
		assignID = 1;
		
	}
	
	//***************************************************************************
	
	
	/**
	 * A method used to add a String document to the Reversed Index.
	 * You must	1) Parse out the document name.  This will always appear at the front of a
	 * 			   document and be surrounded by "<" ">" symbols
	 * 			2) Use the Map allDocs to make sure the document name(a String) currently being checked has not been added already.
	 * 			   If it has been seen, do nothing
	 * 			   If it hasn't been added, update allDocs and proceed to the next steps.
	 * 			3) Parse out the file contents.  The contents of the file will always appear after the document name.
	 * 			4) Break the file contents into individual tokens.
	 * 			5) Loop over all tokens contained in file contents.
	 * 				Think of how you can use removePunctuation, checkToken, and checkToken_Document methods.
	 * 				Calling these methods in a certain order and using their return types can give you a Token and
	 * 					a List of Documents to update the reversedIndex.
	 * 				Don't forget to update the positionalIndex too!  When should this happen?
	 * 
	 * @param docString
	 */
	public void indexDocument(String docString) {
		
		// Extract document title
		int leftAngleBracket = docString.indexOf("<");
		int rightAngleBracket = docString.indexOf(">");
		String docName = docString.substring((leftAngleBracket + 1), rightAngleBracket);
		
		// Check if document already exists
		if (allDocs.containsKey(docName)) {
			return;
		}
		
		// Create document and add to list
		Document doc = new Document(assignID, docName);
		assignID += 1;
		allDocs.put(docName, doc);
		allDocsSorted.add(doc);
		
		// Tokenize document text
		List<String> tokens = new ArrayList<String>();
		tokens = Arrays.asList(docString.substring(rightAngleBracket + 1).split(" "));
		
		// Clean tokens, create token class, and add to list
		for (int i=0; i<tokens.size(); i++) {
			String dirtyToken = tokens.get(i);
			String cleanToken = removePunctuation(dirtyToken);
			Token token = checkToken(cleanToken);
			token.setPositions(doc, i+1);
			checkToken_Document(token, doc);
		}
		

	} // end indexDocument
	
	//***************************************************************************

	
	/**
	 * Remove all punctuation and convert String to lower case.
	 * Only a single term, or word, should be passed to this method at a time.
	 * Punctuation to remove: "," "." "!" "?"
	 * 
	 * @param str
	 * @return a formatted String
	 */
	protected String removePunctuation(String str) {
		
		return str.replaceAll("[\\,\\.\\!\\?]", "").toLowerCase().trim();

	} // end removePunctuation
	
	//***************************************************************************
	
	/**
	 * Use allTokens to see if the String passed in currently is a token.
	 * If it is there, what should it return?
	 * If it isn't, what set of operations should happen?
	 * This method should never return null, meaning a Token object is always returned.
	 * 
	 * @param str
	 * @return Token
	 */
	protected Token checkToken(String str) {
		
		if (allTokens.containsKey(str)) {
			return allTokens.get(str);
		}
		
		Token token = new Token(str);
		allTokens.put(str, token);
		
		return token;
		
	} // end checkToken
	
	//***************************************************************************
	
	/**
	 * Use reversedIndex to see if the Token is part of the reversedIndex.
	 * Remember, the reversedIndex maps a Token to a List of Documents.
	 * If the token is there, what should the Token be mapped to?
	 * If the Token isn't there, is the Token mapped to anything?  What should happen if it isn't mapped to anything?
	 * If the List of Documents mapped to by the Token does not contain the Document passed in, add it to the list.
	 * We need to make sure no duplicate docs are added to the List of Documents.
	 * This method should never return null, it should always return a List of Documents pointed to by the Token passed in.
	 * 
	 * @param token
	 * @param doc
	 * @return a List of Documents with the passed in Document possibly added to the List.
	 */
	protected List<Document> checkToken_Document(Token token, Document doc) {
		
		if (reversedIndex.get(token) == null) {
			reversedIndex.put(token, new ArrayList<Document>());
		}
		
		if (!reversedIndex.get(token).contains(doc)) {
			reversedIndex.get(token).add(doc);
		}

		return reversedIndex.get(token);
		
	} // end checkToken_Document
	
	//***************************************************************************
	
	/**
	 * Use the reversedIndex to answer the query and print out the list of documents that contain the term.
	 * If the query is not in the reversedIndex, Simply print out the query was not found.
	 * If the query is there:
	 * 		1)	Print out the token name and the list of documents containing the query.
	 * 			You may use the built in toString method for Lists to print them out.
	 * 		2)	For each document the query appears in ,print out each docID followed by the query location(s) for each document.
	 * See the driver output in the homework description for example output.
	 * 
	 * @param query
	 */
	public void singleQuery(String query) {
		
		query = removePunctuation(query);
		
		if (!allTokens.containsKey(query)) {
			System.out.println("Sorry, no results.");
			return;
		}
		
		Token queryToken = allTokens.get(query);
		
		List<Document> queryDocuments = reversedIndex.get(queryToken);
		
		System.out.println();
		System.out.println(thickLine);
		
		System.out.println(String.format("Token: %s", query));
		
		System.out.println(thinLine);
		
		System.out.println(String.format("Documents containing \"%s\": %s", 
				query, 
				queryDocuments.toString()));
		
		System.out.println(thinLine);
		
		for (Document doc: queryDocuments) {
			System.out.println(String.format("DocID: %d\t DocPositions: %s", 
					doc.getID(), 
					queryToken.getPositions(doc).toString()));
		}
		
		System.out.println(thickLine);
		System.out.println();
		 
	} // end singleQuery
	
	//***************************************************************************
	
	/**
	 * Graduate students must complete.
	 * Undergraduates may feel free to attempt this if they wish.
	 * Write the code to perform a two word query.
	 * This should print out a result if both words in the query occur next to each other.
	 * 
	 * @param query
	 */
	public void twoWordQuery(String[] query) {
		
		String word1 = removePunctuation(query[0]); 
		String word2 = removePunctuation(query[1]);
		
		// Exit if either query word does not appear in a document.
		if (!(allTokens.containsKey(word1) && allTokens.containsKey(word2))) {
			System.out.println("Sorry, no results.");
			return;
		}
		
		// Find pairs of adjacent query word positions for each document
		HashMap<Integer, List<List<Integer>>> docPositions = new HashMap<>();
		
		for (Document doc: docsIntersection(word1, word2)) {
			
			// Cartesian product drops non-consecutive position pairs.
			List<List<Integer>> positions  = cartesianProduct(word1, word2, doc);
			
			// Save document and positions as long as query words appear consecutively.
			if (positions.size() > 0) {
				docPositions.put(doc.getID(), positions);
			}
			
		} // end for
		
		// Exit if query words appear in document but not in consecutive positions
		if (docPositions.size() == 0) {
			System.out.println("Sorry, no results.");
			return;
		}
		
		
		
		System.out.println();
		System.out.println(thickLine);
		
		System.out.println(String.format("Tokens: %s %s", word1, word2));
		
		System.out.println(thinLine);
		
		System.out.println(String.format("Documents containing \"%s %s\": %s", 
				word1, 
				word2, 
				docPositions.keySet().toString()));
		
		System.out.println(thinLine);
		
		for (Integer docID: docPositions.keySet()) {
			
			System.out.print(String.format("DocID: %s\t", docID.toString()));
			System.out.print("DocPositions: ");
			
			for (List<Integer> position: docPositions.get(docID)) {
				System.out.print(String.format("[%s-%s]; ", 
						position.get(0).toString(), 
						position.get(1).toString()));
			}
			
			System.out.println();
		}
		
		System.out.println(thickLine);
		System.out.println();
			

	} // end twoWordQuery
	
	//***************************************************************************
	
	/**
	 * Find the intersection between lists of documents containing either query term. 
	 * 
	 * @param word1		The first query word. Punctuation, whitespace, and caps removed.
	 * @param word2		The second query word. Punctuation, whitespace, and caps removed.
	 * @return list		A list of documents that contain both query words. 
	 */
	private List<Document> docsIntersection(String word1, String word2) {
		
		List<Document> intersection = new ArrayList<>();
		List<Document> docs1 = reversedIndex.get(allTokens.get(word1));
		List<Document> docs2 = reversedIndex.get(allTokens.get(word2));

		for (Document document: docs1) {
			if (docs2.contains(document)) {
				intersection.add(document);
			}
		}
	
		return intersection;
			
	} // end docsIntersection
	
	//***************************************************************************
	
	/**
	 * Perform the cartesian product of two lists.
	 * This method will store the result as a List that holds strings since Java does not allow Tuples.
	 * Both lists must be sorted before performing the cartesian product.
	 * Elements in list1 should be the first element in each product.
	 * If the either list is empty, return a empty List.
	 * 
	 * See handout for example.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	private List<List<Integer>> cartesianProduct(String word1, String word2, Document doc) {
		
		List<Integer> positions1 = allTokens.get(word1).getPositions(doc); 
		List<Integer> positions2 = allTokens.get(word2).getPositions(doc);
		List<List<Integer>> positionPairs = new ArrayList<>();
		
		if ((positions1.size() == 0) || (positions2.size() == 0)) {
			return positionPairs;
		}
		
		for (Integer pos1: positions1) {
			for (Integer pos2: positions2) {
				if (pos2 - pos1 == 1) {
					positionPairs.add(Arrays.asList(pos1, pos2));
				}
			}
		}
		
		return positionPairs;
		
	} // end cartesianProduct
	
	//***************************************************************************
	
	/**
	 * A simple method that prints out all Documents that have been seen.
	 * Use the list containing allDocsSorted to print them out.
	 * 
	 */
	public void printOutAllDocs() {
		
		for (Document doc: allDocsSorted) {
			System.out.println(String.format("DocID: %d \tDocName: %s", doc.getID(), doc.getName()));
		}
	
	} // end printOutAllDocs
	
} // end class Indexer
