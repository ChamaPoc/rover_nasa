package nasa.rover.element.engine;

public enum Action {
    R("RIGHT"),
    L("LEFT"),
    M("MOVE");

    private final String action;

    private Action(String a) {
        action = a;
    }
}
