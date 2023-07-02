package coding.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * EASY


 There's an algorithms tournament taking place in which teams of programmers
 compete against each other to solve algorithmic problems as fast as possible.
 Teams compete in a round robin, where each team faces off against all other
 teams. Only two teams compete against each other at a time, and for each
 competition, one team is designated the home team, while the other team is the
 away team. In each competition there's always one winner and one loser; there
 are no ties. A team receives 3 points if it wins and 0 points if it loses. The
 winner of the tournament is the team that receives the most amount of points.


 Given an array of pairs representing the teams that have competed against each
 other and an array containing the results of each competition, write a
 function that returns the winner of the tournament. The input arrays are named
 competitions and results, respectively. The competitions array has elements in the form of
 [homeTeam, awayTeam] , where each team is a string of at most 30 characters representing the name of the team. The results  array
 contains information about the winner of each corresponding competition in the competitions array. Specifically,
 results[i] denotes the winner of competitions[i], where a 1 in the results  array means that the home team in the corresponding
 competition won and a 0  means that the away team won.

 It's guaranteed that exactly one team will win the tournament and that each
 team will compete against all other teams exactly once. It's also guaranteed
 that the tournament will always have at least two teams.

 Sample Input
 competitions = [
 ["HTML", "C#"],
 ["C#", "Python"],
 ["Python", "HTML"],
 ]
 results = [0, 0, 1]

 Sample Output
 "Python"
 // C# beats HTML, Python Beats C#, and Python Beats HTML.
 // HTML - 0 points
 // C# -  3 points
 // Python -  6 points
 */
public class TournamentWinner {

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    /*
      traversing each pair of competitions.
      as per results, calculate score.
      Map<String, Integer> teamToScoreMap
      return max scoring team
      O(n) time | O(k) space - where n is the number of competitions and k is the number of teams
    */
        Map<String, Integer> teamToScoreMap = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> teams = competitions.get(i);
            String homeTeam = teams.get(0);
            String awayTeam = teams.get(1);

            if (results.get(i) == 1) {
                teamToScoreMap.put(homeTeam, teamToScoreMap.getOrDefault(homeTeam, 0) + 3);
            } else {
                teamToScoreMap.put(awayTeam, teamToScoreMap.getOrDefault(awayTeam, 0) + 3);
            }
        }

        int maxValue = teamToScoreMap.values().stream().max(Integer::compare).get();
        return teamToScoreMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxValue))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }


    public static final int HOME_TEAM_WON = 1;

    // O(n) time | O(k) space - where n is the number of competitions and k is the number of teams
    public String tournamentWinner2(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentBestTeam = "";
        HashMap<String, Integer> teamToScoreMap = new HashMap<>();
        teamToScoreMap.put(currentBestTeam, 0);

        for (int idx = 0; idx < competitions.size(); idx++) {
            ArrayList<String> competition = competitions.get(idx);
            int result = results.get(idx);

            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winningTeam = result == HOME_TEAM_WON ? homeTeam : awayTeam;

            updateScores(winningTeam, 3, teamToScoreMap);

            if (teamToScoreMap.get(winningTeam) > teamToScoreMap.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }

        return currentBestTeam;
    }

    public void updateScores(String team, int points, HashMap<String, Integer> teamToScoreMap) {
        teamToScoreMap.put(team, teamToScoreMap.getOrDefault(team, 0) + points);
    }
}
