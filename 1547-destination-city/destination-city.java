class Solution {
    public String destCity(List<List<String>> paths) {

        for (List<String> path : paths) {
            String destination = path.get(1);
            boolean isStartingPoint = false;

            for (List<String> p : paths) {
                if (p.get(0).equals(destination)) {
                    isStartingPoint = true;
                    break;
                }
            }

            if (!isStartingPoint) {
                return destination;
            }
        }

        return "";
    }
}