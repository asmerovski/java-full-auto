package testrail.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RunRequest {

  public Integer suite_id;
  public String name;
  public String description;
  public Integer milestone_id;
  public Integer assignedto_id;
  public Boolean include_all;
  public List<Integer> case_ids;
  public String refs;

  public static RunRequest getRunRequest(int suiteId, String name) {
    return RunRequest.builder()
        .suite_id(suiteId)
        .name(name)
        .assignedto_id(null)
        .include_all(true)
        .build();
  }
}
