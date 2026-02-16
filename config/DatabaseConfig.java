package config;

public class DatabaseConfig {

    public static String getUrl() {
        return System.getenv("PBAOMNI");
    }

    public static String getUser() {
        return System.getenv("ellvelas");
    }

    public static String getPassword() {
        return System.getenv("V3ls$2026");
    }
}

