class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> counts = new HashMap<>();
        for (String s: cpdomains) {
            String[] tokens = s.split(" ");
            int count = Integer.valueOf(tokens[0]);
            String[] subDomainStrings = tokens[1].split("\\.");
            for (int i = 0; i < subDomainStrings.length; i++) {
                String[] subDomainArr = Arrays.copyOfRange(subDomainStrings, i, subDomainStrings.length); 
                String subDomain = String.join(".", subDomainArr);
                counts.putIfAbsent(subDomain, 0);
                counts.put(subDomain, counts.get(subDomain) + count);
            }
        }
        
        List<String> results = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : counts.entrySet()) {
            String resultString = entry.getValue() + " " + entry.getKey();
            results.add(resultString);
        }
        
        return results;
    }
}