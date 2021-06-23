package net.probs.java;

import java.util.*;
import java.util.stream.Collectors;

public class RankTeamsByVotes {
	
	
	public static void input() {
		String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
		String[] votes1 = {"ABC","CAB","CBA","ABC","ACB","ACB"};
		String[] votes3 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
		int length = votes.length;
		   if(length >= 1){
		       rankTeams(votes1);
		       rankTeams(votes3);
		       rankTeams(votes);
		   }
	}

	public static String rankTeams(String[] votes){
		   int length = votes[0].length();
		   HashMap<Character, int[]> map = new HashMap<>();
		   for(String str : votes){
		       for(int i = 0; i < length; i++){
		           char c = str.charAt(i);
		           map.putIfAbsent(c, new int[length]);
		           map.get(c)[i]++;
		       }
		   }
		   
		   for(Character key: map.keySet()){
		       System.out.println(Arrays.toString(map.get(key)));
		   }
		   
		   List<Character> teams = new ArrayList<>(map.keySet());
		   
		   /*Collections.sort(teams, new Comparator<Character>() {
		            public int compare(Character rank, Character rank1) {
		                for(int i = 0; i < length; i++){
		                    if(map.get(rank)[i] != map.get(rank1)[i]){
		                        return map.get(rank1)[i] - map.get(rank)[i];
		                       
		                    }
		                }
		                    return rank1 - rank;
		                }
		            }
		   );*/
		   
		   Collections.sort(teams, (a, b) -> {
		            for(int i = 0; i < length; i++){
		                if(map.get(a)[i] != map.get(b)[i]){
		                    return map.get(b)[i] - map.get(a)[i];
		                }
		            }
		            return b - a;
		        });
		       
		   String string =  teams.stream().map(String::valueOf).collect(Collectors.joining());
		   //for(Character c : teams)
		   System.out.println(string);
		   return null;
		}
}
