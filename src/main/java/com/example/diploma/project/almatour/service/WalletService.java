package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.WalletDTO;
import com.example.diploma.project.almatour.mapper.WalletMapper;
import com.example.diploma.project.almatour.model.Wallet;
import com.example.diploma.project.almatour.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletMapper walletMapper;
    private final WalletRepository walletRepository;

    public List<WalletDTO> getAllWallets(){
        return walletMapper.toDtoList(walletRepository.findAll());
    }

    public void depositToWallet(Long walletId, int balance) {
        // Получаем кошелек по его идентификатору
        Wallet wallet = walletRepository.findById(walletId).orElseThrow();
        // Получаем текущий баланс кошелька и сумму пополнения
//        Double currentBalance = wallet.getBalance();
//        Double newBalance = currentBalance + depositAmount;

        // Обновляем баланс кошелька
        wallet.setBalance(5000);

        // Сохраняем обновленный кошелек
        walletRepository.save(wallet);
    }
}
