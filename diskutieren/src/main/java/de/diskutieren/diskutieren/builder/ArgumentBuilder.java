package de.diskutieren.diskutieren.builder;

public class ArgumentBuilder {

    private String these = "";
    private String example = "";
    private String reason = "";

    private boolean isPro;

    public String getThese() {
        return these;
    }

    public void setThese(String these) {
        this.these = these;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean getIsPro() { return isPro; }

    public void setIsPro(boolean bool) {this.isPro = bool; }
}
