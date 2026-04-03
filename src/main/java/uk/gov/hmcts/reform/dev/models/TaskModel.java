package uk.gov.hmcts.reform.dev.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message="Casenumber cannot be empty")
    private String caseNumber;

    @NotNull(message="Title cannot be empty")
    @Size(min=1,max=20,message  ="name must be between 1-20 character")
    private String title;

    @NotNull(message="Description cannot be empty")
    @Size(min=1,max=20,message  ="description must be between 1-20 character")
    private String description;

    @NotNull(message="Status cannot be empty")
    @Size(min=1,max=20,message  ="status must be between 1-20 character")
    private String status;

    @NotNull(message="createdDate cannot be empty")
    @PastOrPresent(message = "Due date cannot be in the future")
    private LocalDateTime createdDate;
}
