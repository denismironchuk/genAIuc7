package genAIuc7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerAnalyzerTest {

    private PlayerAnalyzer analyzer = new PlayerAnalyzer();

    @Test
    public void testNormalPlayer() {
        Player player = new Player();
        player.setAge(25);
        player.setExperience(5);
        player.setSkills(Arrays.asList(2, 2, 2));
        List<Player> players = Collections.singletonList(player);

        double result = analyzer.calculateScore(players);

        assertEquals(250, result);
    }

    @Test
    public void testJuniorPlayer() {
        Player player = new Player();
        player.setAge(15);
        player.setExperience(3);
        player.setSkills(Arrays.asList(3, 3, 3));
        List<Player> players = Collections.singletonList(player);

        double result = analyzer.calculateScore(players);

        assertEquals(67.5, result);
    }

    @Test
    public void testSeniorPlayer() {
        Player player = new Player();
        player.setAge(35);
        player.setExperience(15);
        player.setSkills(Arrays.asList(4, 4, 4));
        List<Player> players = Collections.singletonList(player);

        double result = analyzer.calculateScore(players);

        assertEquals(2520, result);
    }

    @Test
    public void testMultiplePlayers() {
        Player player1 = new Player();
        player1.setAge(25);
        player1.setExperience(5);
        player1.setSkills(Arrays.asList(2, 2, 2));

        Player player2 = new Player();
        player2.setAge(35);
        player2.setExperience(15);
        player2.setSkills(Arrays.asList(4, 4, 4));

        List<Player> players = Arrays.asList(player1, player2);

        double result = analyzer.calculateScore(players);

        assertEquals(250 + 2520, result);
    }

    @Test
    public void testNullSkills() {
        Player player = new Player();
        player.setAge(25);
        player.setExperience(5);
        player.setSkills(null);
        List<Player> players = Collections.singletonList(player);

        assertThrows(NullPointerException.class, () -> analyzer.calculateScore(players));
    }

    @Test
    public void testEmptyArray() {
        List<Player> players = Collections.emptyList();
        double result = analyzer.calculateScore(players);

        assertEquals(0, result);
    }
}
