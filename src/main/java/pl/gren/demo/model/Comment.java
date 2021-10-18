package pl.gren.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;

    private LocalDateTime time;

    @ManyToOne
    private User user;



}
