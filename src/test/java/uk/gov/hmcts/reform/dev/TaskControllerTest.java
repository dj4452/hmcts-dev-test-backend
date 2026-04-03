package uk.gov.hmcts.reform.dev;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.gov.hmcts.reform.dev.models.TaskModel;
import uk.gov.hmcts.reform.dev.service.TaskService;
import uk.gov.hmcts.reform.dev.taskrepo.ITaskRepo;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TaskControllerTest {

    @Mock
    private ITaskRepo repo;

    @InjectMocks
    private TaskService service;

    public TaskControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnTaskDetails() {
        TaskModel task = new TaskModel(1, "CN1", "Title", "Desc", "Open", null);

        when(repo.findById(1)).thenReturn(Optional.of(task));

        TaskModel result = service.getTaskDetails(1);

        assertThat(result).isNotNull();
        assertThat(result.getCaseNumber()).isEqualTo("CN1");
    }
}
