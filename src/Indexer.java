import java.util.List;
import java.util.Map;

//TODO
//Import all necessary libraries.

public class Indexer 
{

	private Map<Token, List<Document>> reversedIndex;	// Maps a Token to a List of Documents
	private Map<String, Token> allTokens;				// Maps a String to a Token to avoid Token duplication
	private Map<String, Document> allDocs;				// Maps a string to a Document to avoid Document duplication
	private List<Document> allDocsSorted;				// Holds all Documents sorted by DocID
	private int assignID;								// Use for docID when creating Documents. Increments from 1.
	
	//***************************************************************************
	
	public Indexer() 
	{
		//TODO
		//Declare all instance variables
		//What should each variable be initialized to?
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
	public void indexDocument(String docString) 
	{

		//TODO - indexDocument

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
	protected String removePunctuation(String str) 
	{
		
		//TODO - removePunctuation
		
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
	protected Token checkToken(String str) 
	{

		//TODO - checkToken
		
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
	protected List<Document> checkToken_Document(Token token, Document doc)
	{
		
		//TODO - checkToken
		
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
	public void singleQuery(String query) 
	{
		
		//TODO - singleQuery
		 
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
	public void twoWordQuery(String[] query) 
	{
		
		//TODO - twoWordQuery
		//Remove the print statement when you try to complete this method.
		System.out.println("Two word queries method not implemented yet.");
		
		
	} // end twoWordQuery
	
	//***************************************************************************
		
	/**
	 * A simple method that prints out all Documents that have been seen.
	 * Use the list containing allDocsSorted to print them out.
	 * 
	 */
	public void printOutAllDocs() 
	{
		
		//TODO - printOutAllDocs
	
	} // end printOutAllDocs
	
} // end class Indexer
