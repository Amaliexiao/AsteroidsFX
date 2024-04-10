package dk.sdu.mmmi.cbse.scoresystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoreSystemApplication {

	private long totalScore = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoreSystemApplication.class, args);
    }

    @GetMapping("/score")
    public Long calculateHealt(@RequestParam(value = "point") Long point) {
        totalScore += point;
        return totalScore;
    }

}
