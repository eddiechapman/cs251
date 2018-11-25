import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//TODO
//Import all necessary libraries.

public class Indexer {

	private Map<Token, List<Document>> reversedIndex;	// Maps a Token to a List of Documents
	private Map<String, Token> allTokens;				// Maps a String to a Token to avoid Token duplication
	private Map<String, Document> allDocs;				// Maps a string to a Document to avoid Document duplication
	private List<Document> allDocsSorted;				// Holds all Documents sorted by DocID
	private int assignID;								// Use for docID when creating Documents. Increments from 1.
	
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
//		for (String t: tokens) {
//			Token token = checkToken(removePunctuation(t));
//			checkToken_Document(token, doc);
//		}
		
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
		
		System.out.println(String.format("Token: %s", query));
		System.out.println(String.format("Documents containing \"%s\": %s", 
				query, queryDocuments.toString()));
		
		for (Document doc: queryDocuments) {
			System.out.println(String.format("DocID: %d, DocPositions: %s", 
					doc.getID(), queryToken.getPositions(doc).toString()));
		}
		
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
		
		String queryWord1 = removePunctuation(query[0]);
		String queryWord2 = removePunctuation(query[1]);
		
		if (!(allTokens.containsKey(queryWord1) 
				&& allTokens.containsKey(queryWord2))) {
			System.out.println("Sorry, no results.");
			return;
		}
		
		Token tokenQueryWord1 = allTokens.get(queryWord1);
		Token tokenQueryWord2 = allTokens.get(queryWord2);
		
		List<Document> docsQueryWord1 = reversedIndex.get(tokenQueryWord1);
		List<Document> docsQueryWord2 = reversedIndex.get(tokenQueryWord2);
		
		List<Document> docsFullQuery = intersection(docsQueryWord1, docsQueryWord2);
		
		HashMap<Integer, List<List<Integer>>> queryPositionsPairs = new HashMap<>();
		
		for (Document doc: docsFullQuery) {
			Integer docID = doc.getID();
			List<Integer> positionsQueryWord1 = tokenQueryWord1.getPositions(doc);
			List<Integer> positionsQueryWord2 = tokenQueryWord2.getPositions(doc);
			queryPositionsPairs.put(docID, cartesianProduct(positionsQueryWord1, positionsQueryWord2));
		}
		
		HashMap<Integer, List<List<Integer>>> queryPositionsCleaned = new HashMap<>();
		
		for (Integer docID: queryPositionsPairs.keySet()) {
			if (queryPositionsPairs.get(docID).size() > 0) {
				queryPositionsCleaned.put(docID, queryPositionsPairs.get(docID));
			}
		}
		
		System.out.println("\n==================================================");
		System.out.println(String.format("Tokens: %s %s", queryWord1, queryWord2));
		System.out.println("--------------------------------------------------");
		System.out.println(String.format("Documents containing \"%s %s\": %s", 
				queryWord1, queryWord2, queryPositionsCleaned.keySet().toString()));
		System.out.println("--------------------------------------------------");
		for (Integer docID: queryPositionsCleaned.keySet()) {
			
			System.out.print("DocID: " + docID.toString() + "\t");
			System.out.print("DocPositions: ");
			
			for (List<Integer> position: queryPositionsCleaned.get(docID)) {
				System.out.print(position.get(0).toString() + "-" + position.get(1).toString() + "; ");
			}
			
			System.out.println();
		}
		System.out.println("==================================================");
		System.out.println();
			

	} // end twoWordQuery
	
	//***************************************************************************
	
	/**
	 * Perform intersection of list1 and list2.
	 * Intersection means to only include an element if it is in both Lists.
	 * This method will return a new interesected List.
	 * 
	 * @param list1
	 * @param list2
	 * @return list
	 */
	public static List<Document> intersection(List<Document> list1,List<Document> list2) {
		
		List<Document> intersection = new ArrayList<>();
		
		for (Document document: list1) {
			if (list2.contains(document)) {
				intersection.add(document);
			}
		}
	
		return intersection;
			
	} // end intersection
	
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
	public static List<List<Integer>> cartesianProduct(List<Integer> list1, List<Integer> list2) {
		
		List<List<Integer>> cartesianProduct = new ArrayList<>();
		
		if ((list1.size() == 0) || (list2.size() == 0)) {
			return cartesianProduct;
		}
		
		for (Integer i: list1) {
			for (Integer j: list2) {
				if (j - i == 1) {
					cartesianProduct.add(Arrays.asList(i, j));
				}
			}
		}
		
		return cartesianProduct;
		
	} // end cartesianProduct
	
	//***************************************************************************
	
	/**
	 * A simple method that prints out all Documents that have been seen.
	 * Use the list containing allDocsSorted to print them out.
	 * 
	 */
	public void printOutAllDocs() {
		
		for (Document doc: allDocsSorted) {
			System.out.println(String.format("DocID: %d, DocName: %s", doc.getID(), doc.getName()));
		}
	
	} // end printOutAllDocs
	
} // end class Indexer
