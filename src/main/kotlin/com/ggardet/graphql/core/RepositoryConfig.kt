package com.ggardet.graphql.core

import com.ggardet.graphql.model.Task
import com.ggardet.graphql.repository.TaskRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.ggardet.graphql"])
class RepositoryConfig {
    @Bean
    fun init(taskRepository: TaskRepository): ApplicationRunner {
        return ApplicationRunner {
            val task1 = Task("Faire les courses")
            val task3 = Task("Regarder les costumes")
            val task2 = Task("Aller chez le coiffeur")
            val tasks = listOf(task1, task2, task3)
            taskRepository.saveAll(tasks)
        }
    }
}
