import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _34_MagicCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] inputCards = scanner.nextLine().split(" ");
        List<String> evenCards = new ArrayList<>();
        List<String> oddCards = new ArrayList<>();
        String command = scanner.nextLine();
        String magicCard = scanner.nextLine();

        for (int i = 0; i < inputCards.length; i++) {
            if(i%2==0){
                evenCards.add(inputCards[i]);
            }else{
                oddCards.add(inputCards[i]);
            }
        }
        if(command.equals("odd")){
            sumCards(oddCards,magicCard);
        }else if(command.equals("even")){
            sumCards(evenCards,magicCard);
        }

    }

    public static void sumCards(List<String> cards, String magicCard){
        String magicFace = magicCard.substring(0,magicCard.length()-1);
        String magicSuit = magicCard.substring(magicCard.length()-1,magicCard.length());
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            String face = cards.get(i).substring(0,cards.get(i).length()-1);
            String suit = cards.get(i).substring(cards.get(i).length() - 1, cards.get(i).length());

            if(face.equals(magicFace)){
                sum+=getValueOfCard(face)*3;
            }else if(suit.equals(magicSuit)){
                sum+=getValueOfCard(face)*2;
            }else{
                sum+=getValueOfCard(face);
            }
        }
        System.out.println(sum);
    }

    public  static int getValueOfCard (String card){
        int cardValue = 0;
        switch (card){
            case "2": cardValue = 20;break;
            case "3": cardValue = 30;break;
            case "4": cardValue = 40;break;
            case "5": cardValue = 50;break;
            case "6": cardValue = 60;break;
            case "7": cardValue = 70;break;
            case "8": cardValue = 80;break;
            case "9": cardValue = 90;break;
            case "10": cardValue = 100;break;
            case "J": cardValue = 120;break;
            case "Q": cardValue = 130;break;
            case "K": cardValue = 140;break;
            case "A": cardValue = 150;break;
        }
        return cardValue;
    }
}
