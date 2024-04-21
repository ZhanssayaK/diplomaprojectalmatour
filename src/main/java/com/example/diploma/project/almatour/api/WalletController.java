package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.WalletDTO;
import com.example.diploma.project.almatour.model.Wallet;
import com.example.diploma.project.almatour.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/wallets")
public class WalletController {

    private final WalletService walletService;

    @GetMapping(value = "/all")
    public List<WalletDTO> getAllWallets(){
        return walletService.getAllWallets();
    }

    @PostMapping(value = "/deposit/{walletId}")
    public ResponseEntity<Void> depositToWallet(@PathVariable(value = "walletId") Long walletId, int balance){
        walletService.depositToWallet(walletId, balance);
        return ResponseEntity.ok().build(); // Возвращаем статус 200 OK
    }

}
