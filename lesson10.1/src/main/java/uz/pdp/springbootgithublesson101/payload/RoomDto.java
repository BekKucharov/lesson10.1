package uz.pdp.springbootgithublesson101.payload;

import lombok.Data;

@Data
public class RoomDto {
    private String number;
    private Integer floor;
    private Integer size;

    private Integer hotelId;
}
