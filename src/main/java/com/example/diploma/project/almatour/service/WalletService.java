package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.DepositToWalletDTO;
import com.example.diploma.project.almatour.dto.WalletDTO;
import com.example.diploma.project.almatour.mapper.WalletMapper;
import com.example.diploma.project.almatour.model.Wallet;
import com.example.diploma.project.almatour.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletMapper walletMapper;
    private final WalletRepository walletRepository;

    public List<WalletDTO> getAllWallets() {
        return walletMapper.toDtoList(walletRepository.findAll());
    }

    public void depositToWallet(DepositToWalletDTO dto) {
        Wallet wallet = walletRepository.findById(dto.getWalletId()).orElseThrow();
        wallet.setBalance(wallet.getBalance() + dto.getBalance());

        walletRepository.save(wallet);
    }
}
