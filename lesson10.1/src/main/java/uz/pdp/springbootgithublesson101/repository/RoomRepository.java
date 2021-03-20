package uz.pdp.springbootgithublesson101.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootgithublesson101.entity.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Page<Room> findAllByHotel_Id(Integer hotel_id, Pageable pageable);
}
