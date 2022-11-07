package org.example.correct;

import org.example.ProjectService;

import java.util.List;

public class SecondExample {

    private ProjectService projectService;

    public void someMethod(String projectId) {
        if (!projectWithIdExists(projectId)) {
            throw new IllegalStateException("Project does not Exists");
        }
        var project = projectService.getProject(projectId);

        if (!projectHasSubtasks(project)) {
            throw new IllegalStateException("Project does not have subtasks");
        }

        if (!subtasksAreFinished(project.getSubtasks())) {
            throw new IllegalStateException("Subtasks are not finished");
        }
        doSomeActions();
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
