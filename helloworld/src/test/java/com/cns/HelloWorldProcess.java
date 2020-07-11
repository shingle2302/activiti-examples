package com.cns;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldProcess {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();


    @Test
    public void deployProcessDefinition() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .name("helloWorldProcess")
                .addClasspathResource("diagrams/HelloWorld-Process.bpmn")
                .addClasspathResource("diagrams/HelloWorld-Process.png")
                .deploy();
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
        System.out.println(deployment.getDeploymentTime());
    }

    @Test
    public void startProcessInstance() {
        String processDefinitionId= "helloWorldProcess";
        ProcessInstance processInstance = processEngine.getRuntimeService()
				.startProcessInstanceById(processDefinitionId);
		System.out.println(processInstance.getId());
		System.out.println(processInstance.getProcessInstanceId());
		System.out.println(processInstance.getProcessDefinitionId());

    }

}
