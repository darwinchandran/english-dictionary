package com.util.dictionary;

import java.util.HashMap;
import java.util.List;

import com.util.dictionary.constants.EnglishDictionaryConstants;

public class EnglishDictionary extends HashMap<String, HashMap<String, List<String>>>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates of Updates the Noun Meanings of the given Word
	 * @param word
	 * @param nounMeanings
	 */
	public void putNounMeanings(String word, List<String> nounMeanings) {
		putMeanings(word, EnglishDictionaryConstants.NOUN, nounMeanings);
	}
	
	/**
	 * Creates or Updates the Verb Meanings of the given Word.
	 * @param word
	 * @param verbMeanings
	 */
	public void putVerbMeanings(String word, List<String> verbMeanings) {
		putMeanings(word, EnglishDictionaryConstants.VERB, verbMeanings);
	}

	/**
	 * Creates of updates the specified parts of speech meanings, of the given word.
	 * @param word
	 * @param partType
	 * @param meanings
	 */
	public void putMeanings(String word, String partType, List<String> meanings) {
		HashMap<String, List<String>> partTypeToMeanings =  null;
		
		if(super.containsKey(word)) {
			partTypeToMeanings = super.get(word);
		} else {
			partTypeToMeanings = new HashMap<String, List<String>>();
		}
		
		partTypeToMeanings.put(partType, meanings);
		
		super.put(word, partTypeToMeanings);
	}
	
	/**
	 * Retrieves the Noun Meanings of the given word
	 * @param word
	 * @return
	 */
	public List<String> getNounMeanings(String word) {
		return getMeanings(word, EnglishDictionaryConstants.NOUN);
	}
	
	/**
	 * Retrieves the Verb Meanings of the given word
	 * @param word
	 * @return
	 */
	public List<String> getVerbMeanings(String word) {
		return getMeanings(word, EnglishDictionaryConstants.VERB);
	}
	
	/**
	 * Retrieves the meanings of the specified parts of speech, of the given word
	 * @param word
	 * @param partType
	 * @return
	 */
	public List<String> getMeanings(String word, String partType) {
		if(super.isEmpty())
			return null;
		
		if(super.get(word).isEmpty())
			return null;
		
		return super.get(word).get(partType);
	}
	
	/**
	 * Removes only the Noun Meanings of the given word
	 * @param word
	 */
	public void removeNounMeanings(String word) {
		removeMeanings(word, EnglishDictionaryConstants.NOUN);
	}
	
	/**
	 * Removes only the Verb meanings of the given word
	 * @param word
	 */
	public void removeVerbMeanings(String word) {
		removeMeanings(word, EnglishDictionaryConstants.VERB);
	}
	
	/**
	 * Removes the meanings of the specified part of speech, of the given word.
	 * @param word
	 * @param partType
	 */
	private void removeMeanings(String word, String partType) {
		if(!super.isEmpty()) {
			super.get(word).remove(partType);
		}
	}
}