package org.example.correct;

public class FirstExample {

    public void someMethod(Object user) {
        if (!isUserAuthenticated(user)) {
            throw new IllegalStateException("User is not authenticated");
        }
        if (!isUserAdmin(user)) {
            throw new IllegalStateException("User is not an admin");
        }
        doSomeActions();
    }

    private boolean isUserAuthenticated(Object user) {
        return false;
    }

    private boolean isUserAdmin(Object user) {
        return false;
    }

    private void doSomeActions() {

    }

}
