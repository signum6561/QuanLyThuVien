package presentation.cui.util;

public class Command {
    private String defaultPrompt;
    private String alias;
    private String description;

    public Command() {
    }

    public Command(String defaultPrompt, String description) {
        this.defaultPrompt = defaultPrompt;
        this.alias = "";
        this.description = description;
    }

    public Command(String defaultPrompt, String alias, String description) {
        this.defaultPrompt = defaultPrompt;
        this.alias = alias;
        this.description = description;
    }

    public boolean matches(String value) {
        return value.equalsIgnoreCase(alias) || value.equalsIgnoreCase(defaultPrompt);
    }

    public String getDefaultPrompt() {
        return this.defaultPrompt;
    }

    public void setDefaultPrompt(String defaultPrompt) {
        this.defaultPrompt = defaultPrompt;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
