package com.ggardet.graphql.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.apache.commons.lang3.StringUtils
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "task")
data class Task(
    @Id @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    var id: UUID? = null,
    @Column(name = "content")
    var content: String? = StringUtils.EMPTY,
    @Column(name = "done", nullable = false)
    var done: Boolean? = false,
    @Column(name = "created_at")
    @field:CreationTimestamp
    var createdAt: LocalDateTime? = LocalDateTime.now(),
    @Column(name = "updated_at")
    @field:UpdateTimestamp
    var updatedAt: LocalDateTime? = LocalDateTime.now()
) {
    constructor(content: String) : this(null, content, false, LocalDateTime.now(), LocalDateTime.now())
}

