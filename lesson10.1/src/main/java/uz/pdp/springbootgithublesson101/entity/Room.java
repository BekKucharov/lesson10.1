package uz.pdp.springbootgithublesson101.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private Integer size;

    @ManyToOne
    private Hotel hotel;
}
