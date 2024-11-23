package practice;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
You are given N cards. Each card consists of a suit and a rank. There are four suits: 
S (Spades), H (Hearts), D (Diamonds), and C (Clubs), and thirteen ranks, 
ordered (from the lowest to the highest) 2, 3, 4, 5, 6, 7, 8, 9, 10, J (Jack), Q (Queen), K (King), and A (Ace).
Each card is represented by a string in the format . For example, 10 of Spades is described as "10S", and Queen of Hearts as "QH".

There are six ranked card sets (described in detail below).
Sets are ordered by their strength from the weakest to the strongest.
Your task is to detect the card sets that can be formed from the given cards. 
Detecting each card set is scored separately and is worth an equal number of points. 
If you detect more than one set, select the strongest one.

Write a function:

Results solve(vector<string> &cards) { }

Assume that the following declarations are given:

class Results {
  String set_name; 
  vector<string>taken_cards
}

Card Sets

There are six card sets ordered by their strength from the weakest (single card) to the strongest (a triple and a pair).

Set 1: Single Card
Name: 'single card'
Description: A single card of the highest rank; the suit does not matter.
Example : cards=["2H","4H","7C", "9D", "10D", "KS"] should return
set_name = "single card", taken_cards=["KS"]

Set 2: Pair
Name: "pair"
Description: Two cards sharing the same rank; suits do not matter. If there are multiple pairs, return any one with the highest
rank.
Example : cards=["AS","10H","8H", "10S", "8D"] should return
set_name = "pair", taken_cards=["10H", "10S"]

Set 3: Triple
Name: "triple"
Description: Three cards sharing the same rank; suits do not matter. If there are multiple ways to choose a triple, 
return any with the highest rank.
Example : cards=["AS","JS","AH", "AD", "10D", "AC"] one of possible answers is
set_name = "triple", taken_cards=["AH", "AD", "AC"]

Set 4: Five in a Row
Name: "five in a row"
Description: Five cards of consecutive ranks starting with the highest possible rank; suits do not matter. 
If there are multiple ways to choose five such cards, return any.
Example : cards=["6H","7S","8S", "9S", "10S", "JD", "JC", "KC", "AC"] one of possible answers is
set_name = "five in a row", taken_cards=["7S", "8S", "9S", "10S", "JC"]

Set 5: Suit
Name: "suit"
Description: Five cards sharing the same suit; the ranks do not matter. 
If there are multiple ways to choose five cards with the same suit, 
choose any set with the highest suit. The order of the suits (from the highest to the lowest) is S, H, D, C.
Example : cards=["2D","4D","6D", "8D", "9D", "AC", "KC", "QC", "JC", "7C"] one of possible answers is
set_name = "suit", taken_cards=["2D","4D","6D", "8D", "9D"]

Set 6: Triple and a Pair
Name: "a triple and a pair"
Description: Five cards, consisting of a triple (three cards of the same rank) and a pair (two cards of the same rank). 
If there are multiple ways to choose this set, choose one with the highest rank of the triple, 
then one with the highest rank of the pair. 
The suits do not matter.
Example : cards=["10H","10D","10C", "2S", "2H", "2D", "JH", "JC"] one of possible answers is
set_name = "suit", taken_cards=["10H","10D","10C","JH", "JC" ]

Scoring
Detecting each card set is scored separately and is worth an equal number of points.
In tests worth 50% of points, only the strongest set's set_name is checked. 
Checking the cards field of the Result object is omitted.
Constraints

N is an integer within the range [1..10).
The elements of cards are all distinct.
Each string in the cards array is a correct representation of a card in "" format.

Starting Code is :

Result solution(vector<string>&cards) {

Result result;
result .setname = 
result.selectted.cards= 
return result ;
}

*/

public class MicrosoftOA {

  public static void main(String[] args) {
    String[] suits = {"S", "H", "D", "C"};
    String[] cards = {
      "2S", "2H", "2D","2C",
      "3S", "3H", "3D","3C",
      "4S", "4H", "4D","4C",
      "5S", "5H", "5D","5C",
      "6S", "6H", "6D","6C",
      "7S", "7H", "7D","7C",
      "8S", "8H", "8D","8C",
      "9S", "9H", "9D","9C",
      "10S", "10H", "10D","10C",
      "JS", "JH", "JD","JC",
      "QS", "QH", "QD","QC",
      "KS", "KH", "KD","KC",
      "AS", "AH", "AD","AC"
    };

    // String set_name = "single card";
    // assume sorted
    // String[] taken_cards = {"2H","4H","7C", "9D", "10D", "KS"};

    String set_name = "pair";
    String[] taken_cards = {"AS","10H","8H", "10S", "8D"};

    Arrays.sort(taken_cards, (a, b) ->
     getRank(a.substring(0, a.length() - 1)) - getRank(b.substring(0, b.length() - 1))); 
     
    System.out.println(Arrays.toString(taken_cards));

    List<String> result = new ArrayList<>();
    if (set_name.equals("single card")) {
      result = getSingleCard(taken_cards);
    }

    if (set_name.equals("pair")) {
      result = getPairs(taken_cards);
      result = result.subList(result.size() - 2, result.size());
    }
    System.out.println(result);
  }

  private static List<String> getPairs(String[] cards) {
    // {
    //   2: "2S", "2H", "2D","2C",
    //   3: "3S", "3H", "3D","3C",
    // }
    Map<Integer, List<String>> rankGroups = groupByRank(cards);
    List<String> pairCards = new ArrayList<>();
    for (List<String> rankCards : rankGroups.values()) {
      if (rankCards.size() >= 2) {
        pairCards.addAll(rankCards.subList(0, 2));
      }
    }
    return pairCards;
  }

  private static Map<Integer, List<String>> groupByRank(String[] cards) {
    Map<Integer, List<String>> rankGroup = new HashMap<>(); 
    for (String card : cards) {
      int rank = getRank(card.substring(0, card.length() - 1));
      List<String> list = rankGroup.getOrDefault(rank, new ArrayList<>());
      list.add(card);
      rankGroup.put(rank, list);
    }
    return rankGroup;
  }

     private static Integer getRank(String rank) {
      if (rank.equals("2")) return 2;
      if (rank.equals("3")) return 3;
      if (rank.equals("4")) return 4; 
      if (rank.equals("5")) return 5;
      if (rank.equals("6")) return 6; 
      if (rank.equals("7")) return 7;
      if (rank.equals("8")) return 8;
      if (rank.equals("9")) return 9;
      if (rank.equals("10")) return 10; 
      if (rank.equals("J")) return 11;
      if (rank.equals("Q")) return 12;  
      if (rank.equals("K")) return 13;
      if (rank.equals("A")) return 14;

      throw new IllegalArgumentException();
    }

  private static List<String> getSingleCard(String[] cards) {
    int n = cards.length;
    return Arrays.asList(cards[n - 1]);
  }
  
}
