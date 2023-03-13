package com.ggardet.graphql.service

import com.ggardet.graphql.model.Task
import com.ggardet.graphql.repository.TaskRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun findTask(id: UUID): Optional<Task> = taskRepository.findById(id)

    fun findTasks(): MutableIterable<Task> = taskRepository.findAll()

    fun createTask(content: String): Task = taskRepository.save(Task(content))

    fun updateTask(id: UUID, content: String, isDone: Boolean): Task {
        val task = taskRepository.findById(id)
        task.ifPresent {
            it.done = isDone
            it.content = content
            taskRepository.save(it)
        }
        return task.orElseThrow { EntityNotFoundException("Task not found") }
    }

    fun deleteTask(id: UUID): UUID {
        taskRepository.deleteById(id)
        return id
    }
}
