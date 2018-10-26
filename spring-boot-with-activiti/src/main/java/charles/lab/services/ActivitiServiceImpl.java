package charles.lab.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.VariableInstance;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import charles.lab.entities.Person;
import charles.lab.repositories.PersonRepository;

@Service
@Transactional
public class ActivitiServiceImpl implements ActivitiService {

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private RuntimeService runtimeService;

  @Autowired
  private TaskService taskService;

  @Autowired
  private RepositoryService repositoryService;
  
  @Autowired
  private HistoryService historyService;

  @Override
  public String startProcess(String processId, String assignee) {
    Person person = personRepository.findByName(assignee);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("person", person);
    
    ProcessInstance instance = runtimeService.startProcessInstanceByKey(processId, map);

    return instance.getProcessInstanceId();
  }
  
  @Override
  public String queryCurrentTaskName(String instanceId) {
    List<Task> list = taskService.createTaskQuery().processInstanceId(instanceId).list();
    return "name is " + list.get(0).getName() + ", task id is " + list.get(0).getId();
  }

  @Override
  public List<Task> getTasks(String assignee) {
    return taskService.createTaskQuery().taskAssignee(assignee).list();
  }
  

  @Override
  public void completeTask(String taskId) {
    taskService.complete(taskId);
  }

  @Override
  public List<Task> getTaskById(String instanceId) {
    List<Task> list = taskService.createTaskQuery().processInstanceId(instanceId).list();
    list.get(0).getProcessVariables();
    return list;
  }
  
  @Override
  public Map<String, Object> queryProcessVariables(String instanceId) {
    
    Person person = (Person)runtimeService.getVariable(instanceId, "person");
    Map<String,Object> map = new HashMap<>();
    map.put("person", person);
    return map;
  }

  @Override
  public void createPersons() {
    if (personRepository.findAll().size() == 0) {

      personRepository.save(new Person("John", new Date()));
      personRepository.save(new Person("David", new Date()));
      personRepository.save(new Person("Katherin", new Date()));
    }
  }

  @Override
  public List<ProcessDefinition> getProcessDefinitions() {
    List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
    return list;
  }
  
  @Override
  public List<HistoricActivityInstance> getHistories() {
    List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery().finished().list();
    return list;
  }
}
