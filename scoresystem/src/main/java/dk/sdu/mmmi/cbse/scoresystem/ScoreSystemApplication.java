package dk.sdu.mmmi.cbse.scoresystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoreSystemApplication {

	private int totalScore = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoreSystemApplication.class, args);
    }

    @GetMapping("/AddToScore")
    public void addPoint() {
        totalScore ++;
    }
    @GetMapping("/GetScore")
    public int getTotalScore(){
        return totalScore;
    }

}
