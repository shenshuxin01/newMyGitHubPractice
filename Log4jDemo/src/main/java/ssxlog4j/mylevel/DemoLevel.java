package ssxlog4j.mylevel;

import org.apache.log4j.Level;

public class DemoLevel extends Level {
    public DemoLevel(int level, String name, int sysLogLevel) {
        super(level, name, sysLogLevel);
    }
}
