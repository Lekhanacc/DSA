//Time limit exceeded (striver approach )

// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

//         List<List<String>> ans = new ArrayList<>();

//         Set<String> set = new HashSet<>(wordList);

//         if (!set.contains(endWord)) {
//             return ans;
//         }

//         Queue<List<String>> q = new LinkedList<>();

//         List<String> start = new ArrayList<>();
//         start.add(beginWord);

//         q.add(start);
//         set.remove(beginWord);

//         boolean found = false;

//         while (!q.isEmpty() && !found) {

//             int size = q.size();

//             Set<String> used = new HashSet<>();

//             for (int i = 0; i < size; i++) {

//                 List<String> path = q.poll();

//                 String word = path.get(path.size() - 1);

//                 if (word.equals(endWord)) {
//                     ans.add(path);
//                     found = true;
//                     continue;
//                 }

//                 char[] arr = word.toCharArray();

//                 for (int j = 0; j < arr.length; j++) {

//                     char original = arr[j];

//                     for (char ch = 'a'; ch <= 'z'; ch++) {

//                         arr[j] = ch;

//                         String newWord = new String(arr);

//                         if (set.contains(newWord)) {

//                             List<String> newPath = new ArrayList<>(path);

//                             newPath.add(newWord);

//                             q.add(newPath);

//                             used.add(newWord);
//                         }
//                     }

//                     arr[j] = original;
//                 }
//             }

//             // Remove words after processing the entire level
//             set.removeAll(used);
//         }

//         return ans;
//     }
// }


// Optimized striver approach

// class Solution {

//     List<List<String>> ans = new ArrayList<>();
//     Map<String, Integer> map = new HashMap<>();

//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

//         Set<String> set = new HashSet<>(wordList);

//         if (!set.contains(endWord)) {
//             return ans;
//         }

//         Queue<String> q = new LinkedList<>();

//         q.add(beginWord);
//         map.put(beginWord, 0);
//         set.remove(beginWord);

//         // STEP 1: BFS - Calculate levels

//         while (!q.isEmpty()) {

//             String word = q.poll();
//             int level = map.get(word);

//             if (word.equals(endWord)) {
//                 break;
//             }

//             char[] arr = word.toCharArray();

//             for (int i = 0; i < arr.length; i++) {

//                 char original = arr[i];

//                 for (char ch = 'a'; ch <= 'z'; ch++) {

//                     arr[i] = ch;

//                     String newWord = new String(arr);

//                     if (set.contains(newWord)) {

//                         q.add(newWord);
//                         map.put(newWord, level + 1);

//                         set.remove(newWord);
//                     }
//                 }

//                 arr[i] = original;
//             }
//         }

//         // STEP 2: DFS - Backtracking

//         if (map.containsKey(endWord)) {

//             List<String> path = new ArrayList<>();
//             path.add(endWord);

//             dfs(endWord, beginWord, path);
//         }

//         return ans;
//     }

//     private void dfs(String word, String beginWord, List<String> path) {

//         if (word.equals(beginWord)) {

//             List<String> result = new ArrayList<>(path);

//             Collections.reverse(result);

//             ans.add(result);

//             return;
//         }

//         int level = map.get(word);

//         char[] arr = word.toCharArray();

//         for (int i = 0; i < arr.length; i++) {

//             char original = arr[i];

//             for (char ch = 'a'; ch <= 'z'; ch++) {

//                 arr[i] = ch;

//                 String newWord = new String(arr);

//                 if (map.containsKey(newWord) &&
//                     map.get(newWord) == level - 1) {

//                     path.add(newWord);

//                     dfs(newWord, beginWord, path);

//                     path.remove(path.size() - 1);
//                 }
//             }

//             arr[i] = original;
//         }
//     }
// }

// Graph + BFS + HashSet + Backtracking (chat gpt)
class Solution {

    Map<String, List<String>> parents = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(
        String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return ans;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        set.remove(beginWord);

        boolean found = false;

        // BFS
        while (!q.isEmpty() && !found) {

            int size = q.size();

            Set<String> used = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = q.poll();

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;

                        String newWord = new String(arr);

                        if (set.contains(newWord)) {

                            parents.computeIfAbsent(
                                newWord, k -> new ArrayList<>()
                            ).add(word);

                            if (used.add(newWord)) {
                                q.add(newWord);
                            }

                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    arr[j] = original;
                }
            }

            // Remove words after processing the entire level
            set.removeAll(used);
        }

        // Backtracking
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);

            dfs(endWord, beginWord, path);
        }

        return ans;
    }

    private void dfs(String word, String beginWord,
                     List<String> path) {

        if (word.equals(beginWord)) {

            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            ans.add(result);

            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, path);

            path.remove(path.size() - 1);
        }
    }
}