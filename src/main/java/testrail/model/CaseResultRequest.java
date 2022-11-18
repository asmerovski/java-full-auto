package testrail.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseResultRequest {

  public Integer status_id;
  public String comment;
  public Integer assignedto_id;

  public static CaseResultRequest getCaseResultRequest(int status_id, String comment) {
    return CaseResultRequest.builder()
        .status_id(status_id)
        .comment(comment)
        .assignedto_id(null)
        .build();
  }
}
