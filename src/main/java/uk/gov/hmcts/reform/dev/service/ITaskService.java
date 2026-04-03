package uk.gov.hmcts.reform.dev.service;

import uk.gov.hmcts.reform.dev.models.TaskModel;

import java.util.List;


public interface ITaskService {

    List<TaskModel> getAllTask();

    TaskModel getTaskDetails(Integer taskId);

    TaskModel addTask(TaskModel task);

    TaskModel updateTask(Integer taskId,TaskModel task);

    String deleteTask(Integer empId);
}
