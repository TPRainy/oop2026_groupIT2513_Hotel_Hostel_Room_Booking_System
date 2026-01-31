package com.hotel.repositories;
import com.hotel.model.Guest;

public interface GuestRepository extends CrudRepository<Guest> {

    @Override
    default Guest getById(int id) {
        return getGuestById(id);
    }

    Guest getGuestById(int id);

    Guest saveGuest(Guest guest);
}