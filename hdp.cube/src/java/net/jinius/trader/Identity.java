package net.jinius.trader;

/**
 *
 */
public class Identity {

    protected Number id;
    protected String code;

    public Identity(Number id) {
        this(id,null);
    }

    public Identity(String code) {
        this.code = code;
    }

    public Identity(Number id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }
}
