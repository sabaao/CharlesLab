package charles.lab.services;

import java.util.List;
import java.util.Map;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

public interface ActivitiService {
  public String startProcess(String processId, String assignee);
  public List<Task> getTasks(String assignee);
  public void completeTask(String taskId);
  public List<Task> getTaskById(String instanceId);
  public void createPersons();
  public String queryCurrentTaskName(String instanceId);
  public Map<String, Object> queryProcessVariables(String instanceId);
  public List<ProcessDefinition> getProcessDefinitions();
  public List<HistoricActivityInstance> getHistories();
}
