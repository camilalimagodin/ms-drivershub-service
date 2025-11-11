package io.github.douglasdreer.drivershub.infraestructure.adapter.output.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

/**
 * Entity representing a Brand in the persistence layer.
 * @param id Unique identifier of the brand.
 * @param name Name of the brand.
 * @param site Official website of the brand.
 * @param logoUrl URL of the brand's logo.
 * @author Douglas Dreer
 * @since 2024-06
 */
@Entity
@Table(name = "brands")
data class BrandEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,
    @Column(nullable = false, unique = true, length = 50)
    val name: String,
    @Column(nullable = false, unique = false, length = 250)
    val site: String,
    @Column(nullable = false, unique = false, length = 250)
    val logoUrl: String,
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    val status: Boolean = true
)