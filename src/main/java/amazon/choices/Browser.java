package amazon.choices;

import java.util.HashMap;
import java.util.Map;

/**
 * As of Spring 2017, PhantomJS is not supported anymore.
 * Since August 17, 2021 IE 11 is also not supported.
 */
public enum Browser {
    CHROME("chrome"),
    EDGE("edge"),
    FIREFOX("firefox"),
    OPERA("opera");

    public final String label;

    Browser(String label) {
        this.label = label;
    }

    private static final Map<String, Browser> BY_LABEL = new HashMap<>();

    static {
        for (Browser host : values()) {
            BY_LABEL.put(host.label, host);
        }
    }

    // To get enum name from a label (choice specified in application.conf)
    public static Browser parse(String label) {
        if (BY_LABEL.get(label) == null) {
            throw new IllegalStateException(String.format("%s is not a valid browser choice. Pick your browser from %s." +
                    "Check the value of 'BROWSER' property in amazon.choices.conf; Or in CI, if running from continuous integration.", label, BY_LABEL.keySet()));
        } else {
            return BY_LABEL.get(label);
        }
    }
}
