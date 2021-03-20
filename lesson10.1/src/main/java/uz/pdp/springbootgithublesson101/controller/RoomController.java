package uz.pdp.springbootgithublesson101.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootgithublesson101.entity.Hotel;
import uz.pdp.springbootgithublesson101.entity.Room;
import uz.pdp.springbootgithublesson101.payload.RoomDto;
import uz.pdp.springbootgithublesson101.repository.HotelRepository;
import uz.pdp.springbootgithublesson101.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;

    @GetMapping
    List<Room> getRoom(){
        return roomRepository.findAll();
    }
    @GetMapping("/byHotel/{hotelId}")
    public Page<Room> getRoomByHotelPage(@PathVariable Integer hotelId, @RequestParam int page){
        Pageable pageable = PageRequest.of(page, 10);
        Page<Room> roomPage = roomRepository.findAllByHotel_Id(hotelId, pageable);
        return roomPage;
    }
    @PostMapping
    public String addRoom(@RequestBody RoomDto roomDto){
        Room room = new Room();
        room.setFloor(roomDto.getFloor());
        room.setNumber(roomDto.getNumber());
        room.setSize(roomDto.getSize());

        Optional<Hotel> hotelId = hotelRepository.findById(roomDto.getHotelId());
        if (!hotelId.isPresent()) return "Hotel not found";
        room.setHotel(hotelId.get());
        roomRepository.save(room);
        return "Room saved";
    }
    @PutMapping("/{id}")
    public String editRoom(@PathVariable Integer id, @RequestBody RoomDto roomDto){
        Optional<Room> roomId = roomRepository.findById(id);
        if (!roomId.isPresent()) return "Room not found";
        Room editingRoom = roomId.get();
        editingRoom.setFloor(roomDto.getFloor());
        editingRoom.setNumber(roomDto.getNumber());
        editingRoom.setSize(roomDto.getSize());

        Optional<Hotel> hotelId = hotelRepository.findById(roomDto.getHotelId());
        if (!hotelId.isPresent()) return "Hotel not found";
        editingRoom.setHotel(hotelId.get());
        roomRepository.save(editingRoom);
        return "Room info edited";
    }
    @DeleteMapping("/{id}")
    public String delRoom(@PathVariable Integer id){
        Optional<Room> roomId = roomRepository.findById(id);
        if (!roomId.isPresent()) return "Room not found";
        roomRepository.deleteById(id);
        return "Room deleted";
    }






}













