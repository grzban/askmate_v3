package pl.gb.askmate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
