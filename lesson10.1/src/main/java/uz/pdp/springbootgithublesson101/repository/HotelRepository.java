package uz.pdp.springbootgithublesson101.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootgithublesson101.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
