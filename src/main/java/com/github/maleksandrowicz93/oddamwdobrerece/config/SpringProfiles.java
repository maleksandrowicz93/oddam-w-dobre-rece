package com.github.maleksandrowicz93.oddamwdobrerece.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SpringProfiles {
    public static class Database {
        public static final String H2_IN_MEMORY = "db_h2_inmemory";
    }
}