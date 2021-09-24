package Trie;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode(); // root is empty
    }

    private static class TrieNode {

        private final TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26]; //storing english alphabets
            isWord = false;
        }

    }

    private void insert(String word) {

        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }

        word = word.toLowerCase();
        TrieNode current = root;

        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if(current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }
            else {
                current = current.children[index];
            }
        }

        current.isWord = true;

    }

    private boolean search(String word) {

        TrieNode current = root;

        for(int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(current.children[index] == null) {
                System.out.println("false");
                return false;
            }
            else {
                current = current.children[index];
            }
        }

        if(current.isWord) {
            System.out.println("true");
            return true;
        }

        System.out.println("false");
        return false;
    }

    private void delete(String word) {

        TrieNode current = root;

        for(int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(current.children[index] == null) {
                System.out.println("word is not present");
                return;
            }
            else {
                current = current.children[index];
            }
        }

        if(current.isWord) {
            System.out.println("word deleted from Trie");
            current.isWord = false;
        }else {
            System.out.println("word not present");
        }

    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("son");
        trie.insert("so");


        System.out.println("Success!!!");

        trie.search("cab");
        trie.search("cat");

        trie.search("can");

        trie.delete("cat");
        trie.delete("can");

        trie.search("cat");

    }



}
