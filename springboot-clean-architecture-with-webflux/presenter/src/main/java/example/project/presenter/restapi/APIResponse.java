package example.project.presenter.restapi;

public record APIResponse(boolean success, String message) {
    public static APIResponse ok(String message) {
        return new APIResponse(true, message);
    }

    public static APIResponse error(String message) {
        return new APIResponse(false, message);
    }
}
