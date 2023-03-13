package com.ggardet.graphql.web

import com.ggardet.graphql.model.Task
import com.ggardet.graphql.service.TaskService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.Optional
import java.util.UUID


@Controller
class TaskController(private val taskService: TaskService) {
    @QueryMapping
    fun getTask(@Argument id: UUID): Optional<Task> = taskService.findTask(id)

    @QueryMapping
    fun getTasks(): MutableIterable<Task> = taskService.findTasks()

    @MutationMapping
    fun createTask(@Argument content: String): Task = taskService.createTask(content)

    @MutationMapping
    fun updateTask(@Argument id: UUID, @Argument content: String, @Argument isDone: Boolean): Task =
        taskService.updateTask(id, content, isDone)

    @MutationMapping
    fun deleteTask(@Argument id: UUID): UUID = taskService.deleteTask(id)
}
