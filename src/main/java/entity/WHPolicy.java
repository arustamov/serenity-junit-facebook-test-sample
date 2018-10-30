package entity;

public enum WHPolicy {
    ANNUITIES("Annuities"),
    HEALTH("Health"),
    LIFE("Life"),
    OVERALL("overall - multiple products");

    private final String dataTarget;

    WHPolicy(String dataTarget){
        this.dataTarget = dataTarget;
    }

    public String dataTargetAttributeValue() {
        return dataTarget;
    }
}
