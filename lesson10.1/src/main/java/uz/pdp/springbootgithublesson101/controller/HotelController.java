package uz.pdp.springbootgithublesson101.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootgithublesson101.entity.Hotel;
import uz.pdp.springbootgithublesson101.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> getHotel(){
        return hotelRepository.findAll();
    }
    @PostMapping
    public String addHotel(@RequestBody Hotel hotelDto){
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotelRepository.save(hotel);
        return "Hotel added";
    }
    @PutMapping("/{id}")
    public String editHotel(@RequestBody Hotel hotelDto, @PathVariable Integer id){
        Optional<Hotel> hotelId = hotelRepository.findById(id);
        if (!hotelId.isPresent()) return "Hotel not found";
        Hotel editingHotel = hotelId.get();
        editingHotel.setName(hotelDto.getName());
        hotelRepository.save(editingHotel);
        return "Hotel info edited";
    }
    @DeleteMapping("/{id}")
    public String delHotel(@PathVariable Integer id){
        Optional<Hotel> hotelId = hotelRepository.findById(id);
        if (!hotelId.isPresent()) return "Hotel not found";
        hotelRepository.deleteById(id);
        return "Hotel deleted";
    }


}
