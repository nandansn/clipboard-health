package amazon.choices;

import java.util.HashMap;
import java.util.Map;

public enum Host {
    LOCALHOST("host.localhost"),
    DOCKER_CONTAINER("host.docker.container"),
    DOCKER_SELENIUM_GRID("host.docker.selenium.grid");

    public final String label;

    Host(String label) {
        this.label = label;
    }

    private static final Map<String, Host> BY_LABEL = new HashMap<>();

    static {
        for (Host appEnv : values()) {
            BY_LABEL.put(appEnv.label, appEnv);
        }
    }

    // To get enum name from a label (choice specified in application.conf)
    public static Host parse(String label) {
        if (BY_LABEL.get(label) == null) {
            throw new IllegalStateException(String.format("%s is not a valid host env choice. Pick your host env from %s." +
                    "Check the value of 'HOST' property in amazon.choices.conf; Or in CI, if running from continuous integration.", label, BY_LABEL.keySet()));
        } else {
            return BY_LABEL.get(label);
        }
    }
}
