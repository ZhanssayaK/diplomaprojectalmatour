package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.DepositToWalletDTO;
import com.example.diploma.project.almatour.dto.WalletDTO;
import com.example.diploma.project.almatour.model.Wallet;
import com.example.diploma.project.almatour.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/deposit")
    public ResponseEntity<Void> depositToWallet(@RequestBody DepositToWalletDTO dto){
        walletService.depositToWallet(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/withdraw")
    public ResponseEntity<Void> withdrawFromWallet(@RequestBody DepositToWalletDTO dto){
        walletService.withdrawFromWallet(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findByUserId/{userId}")
    public WalletDTO findByUserId(@PathVariable(value = "userId") Long userId){
        return walletService.findWalletByUserId(userId);
    }
}
