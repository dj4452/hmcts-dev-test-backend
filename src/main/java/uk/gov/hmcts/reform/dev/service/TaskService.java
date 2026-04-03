package uk.gov.hmcts.reform.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.hmcts.reform.dev.models.TaskModel;
import uk.gov.hmcts.reform.dev.taskrepo.ITaskRepo;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    ITaskRepo iTaskRepository;

    @Override
    public List<TaskModel> getAllTask() {
        return iTaskRepository.findAll();
    }

    @Override
    public TaskModel getTaskDetails(Integer taskId) {
        return iTaskRepository.findById(taskId).orElse(new TaskModel());
    }

    @Override
    public TaskModel addTask(TaskModel task) {
        return iTaskRepository.save(task);
    }

    @Override
    public TaskModel updateTask(Integer taskId, TaskModel updatedTask) {
        return iTaskRepository.findById(taskId)
            .map(existingTask -> {
                existingTask.setCaseNumber(updatedTask.getCaseNumber());
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setStatus(updatedTask.getStatus());
                existingTask.setCreatedDate(updatedTask.getCreatedDate());
                return iTaskRepository.save(existingTask);
            })
            .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
    }

    @Override
    public String deleteTask(Integer taskId) {
        iTaskRepository.deleteById(taskId);
        return "DELETED";
    }
}
