package org.example;

import java.util.List;

public class SecondExample {

    private ProjectService projectService;

    public void someMethod(String projectId) {
        if (projectWithIdExists(projectId)) {
            var project = projectService.getProject(projectId);
            if (projectHasSubtasks(project)) {
                if (subtasksAreFinished(project.getSubtasks())) {
                    doSomeActions();
                } else {
                    throw new IllegalStateException("Subtasks are not finished");
                }
            } else {
                throw new IllegalStateException("Project does not have subtasks");
            }
        } else {
            throw new IllegalStateException("Project does not Exists");
        }
    }

    private boolean projectWithIdExists(String projectId) {
        return false;
    }

    private boolean projectHasSubtasks(Object project) {
        return false;
    }

    private boolean subtasksAreFinished(List<Object> subtasks) {
        return false;
    }

    private void doSomeActions() {
    }

}
