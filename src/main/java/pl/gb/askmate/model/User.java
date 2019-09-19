package pl.gb.askmate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Question> questions;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Answer> answers;
}
