package com.devsuperior.dslearn.entities;

import com.devsuperior.dslearn.entities.enums.DeliverStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_deliver")
public class Deliver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uri;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "offer_id"),
            @JoinColumn(name = "user_id")
    })
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Deliver(Long id, String uri, Instant moment, DeliverStatus status, String feedback, Integer correctCount,
                   Enrollment enrollment, Lesson lesson) {
        super();
        this.id = id;
        this.uri = uri;
        this.moment = moment;
        this.status = status;
        this.feedback = feedback;
        this.correctCount = correctCount;
        this.enrollment = enrollment;
        this.lesson = lesson;
    }
}
