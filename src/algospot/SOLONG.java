package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SOLONG {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for (int n = 0; n < N; n++) {

			}

		}

	}

}

class TrieNode {

	private Map<Character, TrieNode> children;
	private boolean endOfWord;

	public TrieNode() {
		children = new HashMap<>();
		endOfWord = false;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

}

class Trie {

	private TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
	
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		current.setEndOfWord(true);

	}

	public boolean containsNode(String word) {
		
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.getChildren().get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord();
	
	}

}