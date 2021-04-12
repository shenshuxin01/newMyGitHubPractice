package entity;

import java.io.Serializable;

public class SSX implements Serializable {
    private String ssxpro1;

    @Override
    public String toString() {
        return "SSX{" +
                "ssxpro1='" + ssxpro1 + '\'' +
                '}';
    }

    public String getSsxpro1() {
        return ssxpro1;
    }

    public void setSsxpro1(String ssxpro1) {
        this.ssxpro1 = ssxpro1;
    }

    public SSX() {
    }

    public SSX(String ssxpro1) {
        this.ssxpro1 = ssxpro1;
    }
}
