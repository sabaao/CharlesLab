package charles.lab.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.VariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import charles.lab.services.ActivitiService;

@RestController
public class ActivitiController {
  @Autowired
  private ActivitiService service;
  
  @RequestMapping(value = "/startProcess")
  public String startProcessInstance(@RequestParam String assignee,@RequestParam String processId) {
      return "instance id is " + service.startProcess(processId,assignee);
  }
  
  @RequestMapping(value = "/queryCurrentTaskName")
  public String queryCurrentTaskName(@RequestParam String instanceId) {
    return service.queryCurrentTaskName(instanceId);
  }
  
  @RequestMapping(value = "/queryProcessVariables")
  public Map<String, Object> getProcessVariables(@RequestParam String instanceId){
    return service.queryProcessVariables(instanceId);
  }

  @RequestMapping(value = "/tasks/{assignee}")
  public String getTasks(@PathVariable("assignee") String assignee) {
      List<Task> tasks = service.getTasks(assignee);
      return tasks.toString();
  }

  @RequestMapping(value = "/completetask")
  public String completeTask(@RequestParam String taskId) {
    service.completeTask(taskId);
      return "Task with id " + taskId + " has been completed!";
  }
  
  @RequestMapping(value = "/createAssigneer")
  public String createAssigneer() {
    service.createPersons();
    return "OK";
  }
  
  @RequestMapping(value="/repository/processDefinitions")
  public  List<String> getDeployment() {
    List<ProcessDefinition> list = service.getProcessDefinitions();
    List<String> collect = list.stream().map(d->d.getName()).collect(Collectors.toList());
    return collect;
  }
  
  @RequestMapping(value="/history/all")
  public  List<String> getHistories() {
    List<HistoricActivityInstance> histories = service.getHistories();
    List<String> collect = histories.stream().map(h->"id is " + h.getExecutionId() +",time is " +  h.getStartTime()).collect(Collectors.toList());
    return collect;
  }
}
