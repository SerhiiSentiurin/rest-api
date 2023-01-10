package com.my.restapi.mapper;

import com.my.restapi.dto.TaskDto;
import com.my.restapi.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperTaskToTaskDto {
    public TaskDto map(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setTitle(task.getTitle());
        taskDto.setCompleted(task.getCompleted());
        return taskDto;
    }

    public List<TaskDto> mapList(List<Task> taskList){
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (Task task: taskList) {
            TaskDto taskDto = new TaskDto();
            taskDto.setTitle(task.getTitle());
            taskDto.setCompleted(task.getCompleted());
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }
}
