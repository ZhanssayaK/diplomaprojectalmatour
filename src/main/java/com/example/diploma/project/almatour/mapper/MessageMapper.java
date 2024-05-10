package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.MessageDTO;
import com.example.diploma.project.almatour.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(source = "sender.id", target = "senderId")
    @Mapping(source = "message.sender.fullName", target = "messageSender")
    @Mapping(source = "receiver.id", target = "receiverId")
    MessageDTO messageToMessageDTO(Message message);

    @Mapping(source = "senderId", target = "sender.id")
    @Mapping(source = "receiverId", target = "receiver.id")
    Message messageDTOToMessage(MessageDTO messageDTO);

    List<MessageDTO> toDtoList(List<Message> messages);
}
