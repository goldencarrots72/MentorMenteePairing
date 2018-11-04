# MentorMenteePairing
Matches Mentors to Mentees based on preferences (RnD)

* Takes in a test file in the same folder called test.txt
* Reads line by line, splitting into a String array on spaces
* Has a temp String line to read preferences
* Has a boolean "switchMentorToMenteePref" for the following loop
* While there are lines, for loop parses the mentor preferences
* Stores a ranking 1-3 (value) in mentor/mentee pair(key) in a fancy Node
* The node takes Mentor Mentee, and splits it into a String [] for Mentor being [0] and Mentee being [1]
* Nodes are stored in a hashmap of key as pair name, and value is fancy node
* Once done storing mentor preferences, there will still be unread lines for mentee preferences
* boolean for mentortomenteepref checks, and the next loop through adds ranking numbers to pre-existing in the hashmap
* creates a new hashmap with ranking as the key
* creates a set to hold printed pairs
* loops through rankings, high to low
* if set contains the pair, skips the pair
* if set doesn't contain the pair, prints the pair and adds it to set
