package com.ProTeen.backend.repository;

import com.ProTeen.backend.dto.RoomDto;
import com.ProTeen.backend.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<ChatRoom, String> {


}
