package Status;

public enum Difficulty {
    ALL("ALL"),
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private final String className;
    private Difficulty(final String className){
        this.className = className;
    }
    public String getClassName(){
        return this.className;
    }
}
