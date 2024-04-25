package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.DepositToWalletDTO;
import com.example.diploma.project.almatour.dto.WalletDTO;
import com.example.diploma.project.almatour.mapper.WalletMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.Booking;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.model.Wallet;
import com.example.diploma.project.almatour.repository.AccomodationRepository;
import com.example.diploma.project.almatour.repository.BookingRepository;
import com.example.diploma.project.almatour.repository.UserRepository;
import com.example.diploma.project.almatour.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletMapper walletMapper;
    private final WalletRepository walletRepository;
    private final UserRepository userRepository;
    private final AccomodationRepository accomodationRepository;
    private final BookingRepository bookingRepository;

    public List<WalletDTO> getAllWallets(){
        return walletMapper.toDtoList(walletRepository.findAll());
    }

    public void depositToWallet(DepositToWalletDTO dto) {
        Wallet wallet = walletRepository.findById(dto.getWalletId()).orElseThrow();
        wallet.setBalance(wallet.getBalance() + dto.getBalance());

        walletRepository.save(wallet);
    }

    public void withdrawFromWallet(DepositToWalletDTO dto, Long accommodationId, Long userId){
        Wallet wallet = walletRepository.findById(dto.getWalletId()).orElseThrow();
        int newBalance = wallet.getBalance() - dto.getBalance();
        if (newBalance < 0) {
            throw new IllegalArgumentException("No Money!");
        }
        wallet.setBalance(newBalance);
        walletRepository.save(wallet);

        Booking booking = new Booking();
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found!"));
        Accommodation accommodation = accomodationRepository.findById(accommodationId).orElseThrow(() -> new IllegalArgumentException("Accommodation not found!"));

        booking.setUser(user);
        booking.setAccommodation(accommodation);
        bookingRepository.save(booking);
    }

    public WalletDTO findWalletByUserId(Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        return walletMapper.toEntity(walletRepository.findByUser(user));
    }
}
