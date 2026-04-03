package uk.gov.hmcts.reform.dev.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppResponse {
    private int status;
    private String message;
    private Object data;
}
