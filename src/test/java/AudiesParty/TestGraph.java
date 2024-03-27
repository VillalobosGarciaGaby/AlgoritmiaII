package AudiesParty;
import AudiesParty.DataStructure.CalculatorAudieParty;
import org.junit.Test;

public class TestGraph {

    @Test
    public void testGraph() {

        CalculatorAudieParty calculatorAudieParty = new CalculatorAudieParty();
        String listFriends = calculatorAudieParty.generateBestPartyPlan("src/main/java/AudiesParty/File/CaseOne.txt", 7, 2);

        System.out.println(listFriends);

    }
    @Test
    public void testGraph1() {

        CalculatorAudieParty calculatorAudieParty = new CalculatorAudieParty();
        String listFriends = calculatorAudieParty.generateBestPartyPlan("src/main/java/AudiesParty/File/CaseTwo", 10, 4);

        System.out.println(listFriends);
    }
    @Test
    public void testGraph2() {

        CalculatorAudieParty calculatorAudieParty = new CalculatorAudieParty();
        String listFriends = calculatorAudieParty.generateBestPartyPlan("src/main/java/AudiesParty/File/CaseTwo", 10, 3);

        System.out.println(listFriends);
    }

    @Test
    public void testGraph3() {

        CalculatorAudieParty calculatorAudieParty = new CalculatorAudieParty();
        String listFriends = calculatorAudieParty.generateBestPartyPlan("src/main/java/AudiesParty/File/CaseTwo", 14, 3);

        System.out.println(listFriends);
    }

    @Test
    public void testGraph4() {

        CalculatorAudieParty calculatorAudieParty = new CalculatorAudieParty();
        String listFriends = calculatorAudieParty.generateBestPartyPlan("src/main/java/AudiesParty/File/CaseThree", 14, 4);

        System.out.println(listFriends);
    }

}