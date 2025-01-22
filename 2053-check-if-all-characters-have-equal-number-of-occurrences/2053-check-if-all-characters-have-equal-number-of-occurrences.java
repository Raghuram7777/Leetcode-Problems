class Solution {
       public boolean areOccurrencesEqual(String se) {
       String ss = se.replaceAll(String.valueOf(se.charAt(0)), "");
        for (int i = 0; i < se.length(); i++) {
            String s= se ;
            if (s.charAt(i)!= s.charAt(0)) {
                if (s.replaceAll(String.valueOf(s.charAt(i)), "").length() != ss.length()) return false;
            }
        }
        return true;
    }
}