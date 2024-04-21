package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.BookingDTO;
import com.example.diploma.project.almatour.dto.WalletDTO;
import com.example.diploma.project.almatour.model.Booking;
import com.example.diploma.project.almatour.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    WalletMapper INSTANCE = Mappers.getMapper(WalletMapper.class);

    @Mapping(source = "user.id", target = "userId")
    WalletDTO toEntity(Wallet wallet);

    Wallet toDTO(WalletDTO walletDTO);

    List<WalletDTO> toDtoList(List<Wallet> wallets);
}
