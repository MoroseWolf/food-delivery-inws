package by.morwo.restaurantservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "dish")
public class Dish {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "imageUrl")
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
