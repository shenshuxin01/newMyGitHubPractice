package ssxlog4j.mylevel;

import org.apache.log4j.Level;
import org.apache.log4j.net.SyslogAppender;

public interface IDemoLevel {
    public static final Level DEMO_LEVEL = new DemoLevel(35000, "DEMOLEVEL", SyslogAppender.LOG_LOCAL0);
}
