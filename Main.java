import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File("src/test.txt");
        if (file.length() == 0) {
            System.out.println("Empty File");
            return;
        }
        Scanner sc = new Scanner(file);
        //read file
        int len = Integer.parseInt(sc.nextLine());
        HashMap <String, Node> rankMap = new HashMap<>();

        //string array of mentors & mentees
        String[] mentors = sc.nextLine().trim().split(" ");
        String[] mentees = sc.nextLine().trim().split(" ");

        //temp line to parse names per line
        String[] line;

        //parse through mentor preferences, switchM, then mentee preferences
        boolean switchMentorToMenteePref = false;
        while(sc.hasNextLine()) {
            for (int i = 0; i < len; i++) {
                line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < len; j++) {
                    String pairName = !switchMentorToMenteePref ? mentors[i] +" "+ line[j]: line[j]+" "+mentees[i]; //MentorMentee
                    if(!rankMap.containsKey(pairName)) {        //make new pair
                        Node node = new Node(pairName, 3 - j, null);
                        rankMap.put(pairName, node);
                    }else{                                  //update pair ranking
                        Node node = rankMap.get(pairName);
                        node.rank = node.rank+(3-j);
                        rankMap.put(pairName, node);
                    }
                }
            }
            switchMentorToMenteePref = true;
        }
        sc.close();

        //Create a sorted by rank hashmap
        HashMap<Integer, Node> sortedMap = new HashMap<>();
        for (String name : rankMap.keySet()) {
            Node node = rankMap.get(name);
            if (sortedMap.containsKey(node.rank)){
                sortedMap.put(node.rank, new Node(node.name[0]+ " " +node.name[1], node.rank, sortedMap.get(node.rank)));
            } else{
                sortedMap.put(node.rank, node);
            }
        }

        //once a pair is printed, it's mentor & mentee is considered check
        HashSet<String> checked = new HashSet<>();

        //check sortedMap from greatest ranking to lowest
        for (int i = 6; i >0; i--){
            Node node = sortedMap.get(i);
            while (node!=null) {
                String mentor = node.name[0];
                String mentee = node.name[1];
                if (checked.contains(mentor) || checked.contains(mentee)) {
                    //mentor or mentee already matched; skip pair
                    node = node.next;
                    continue;
                }else {
                    //print and check mentor & mentee
                    System.out.println(mentor+" "+mentee);
                    checked.add(mentor);
                    checked.add(mentee);
                    node = node.next;
                }
            }
        }
    }
}
