package com.xby;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author :xby
 * @date :2019/1/20 19:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

        @Test
        public void test1() {
            String name = "test";
            String password = "123456";
            log.debug("debug...");
            log.info("name: " + name + " ,password: " + password);
            log.info("name: {}, password: {}", name, password);
            log.error("error...");
            log.warn("warn...");
        }
    }
