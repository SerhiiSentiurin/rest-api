package com.my.restapi.mapper;

import com.my.restapi.dto.TaskDto;
import com.my.restapi.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperTaskDtoToTask {
    public Task map(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setCompleted(taskDto.getCompleted());
        return task;
    }

    public List<Task> mapList(List<TaskDto> taskDto) {
        List<Task> taskList = new ArrayList<>();
        for (TaskDto dto : taskDto) {
            Task task = new Task();
            task.setTitle(dto.getTitle());
            task.setCompleted(dto.getCompleted());
            taskList.add(task);
        }
        return taskList;
    }
}
