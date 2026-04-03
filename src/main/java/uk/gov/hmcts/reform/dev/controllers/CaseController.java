package uk.gov.hmcts.reform.dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gov.hmcts.reform.dev.exception.AppResponse;
import uk.gov.hmcts.reform.dev.models.ExampleCase;
import uk.gov.hmcts.reform.dev.models.TaskModel;
import uk.gov.hmcts.reform.dev.service.ITaskService;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CaseController {

    @Autowired
    private ITaskService iTaskService;

    @GetMapping(value = "/get-example-case", produces = "application/json")
    public ResponseEntity<ExampleCase> getExampleCase() {
        return ok(new ExampleCase(1, "ABC12345", "Case Title",
                                  "Case Description", "Case Status", LocalDateTime.now()
        ));
    }

    @GetMapping("/tasks")
    public ResponseEntity<Object> getTasks() {
        List<TaskModel> taskModels = iTaskService.getAllTask();
        if (!taskModels.isEmpty()) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),taskModels);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return ResponseEntity.ok(taskModels);
    }

    @GetMapping("/getTask/{taskId}")
    public ResponseEntity<Object> getTask(@PathVariable Integer taskId) {
        TaskModel taskModel = iTaskService.getTaskDetails(taskId);
        if (taskModel != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),taskModel);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return ResponseEntity.ok(taskModel);
    }

    @PostMapping("/addTask")
    public ResponseEntity<Object> addTask(@RequestBody TaskModel taskModel) {
        TaskModel taskMo = iTaskService.addTask(taskModel);
        if (taskMo != null ) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),taskModel);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return ResponseEntity.ok(taskModel);
    }

    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity<Object> updateTask(@PathVariable Integer taskId, @RequestBody TaskModel taskModel) {
        TaskModel taskMo = iTaskService.updateTask(taskId, taskModel);
        if (taskMo != null ) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),taskModel);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return ResponseEntity.ok(taskModel);
    }


    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<Object> deleteTask(@PathVariable Integer taskId) {
        String taskMo = iTaskService.deleteTask(taskId);
        if (taskMo != null ) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),taskMo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return ResponseEntity.ok("Deleted");
    }

}
