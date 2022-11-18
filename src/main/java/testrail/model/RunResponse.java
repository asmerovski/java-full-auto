package testrail.model;

import java.sql.Timestamp;
import java.util.List;
import lombok.Data;

@Data
public class RunResponse {

  public Integer id;
  public Integer suite_id;
  public String name;
  public String description;
  public Integer milestone_id;
  public Integer assignedto_id;
  public Boolean include_all;
  public Boolean is_completed;
  public Timestamp completed_on;
  public String config;
  public List<Object> config_ids;
  public Integer passed_count;
  public Integer blocked_count;
  public Integer untested_count;
  public Integer retest_count;
  public Integer failed_count;
  public Integer custom_status1_count;
  public Integer custom_status2_count;
  public Integer custom_status3_count;
  public Integer custom_status4_count;
  public Integer custom_status5_count;
  public Integer custom_status6_count;
  public Integer custom_status7_count;
  public Integer project_id;
  public Integer plan_id;
  public Integer created_on;
  public Integer updated_on;
  public String refs;
  public Integer created_by	;
  public String url;
}
