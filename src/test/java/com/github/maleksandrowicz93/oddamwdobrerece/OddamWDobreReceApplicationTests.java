package com.github.maleksandrowicz93.oddamwdobrerece;

import com.github.maleksandrowicz93.oddamwdobrerece.config.SpringProfiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(SpringProfiles.Database.H2_IN_MEMORY)
public class OddamWDobreReceApplicationTests {

    @Test
    public void contextLoads() {
    }

}
