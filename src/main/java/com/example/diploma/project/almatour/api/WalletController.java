package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.DepositToWalletDTO;
import com.example.diploma.project.almatour.dto.WalletDTO;
import com.example.diploma.project.almatour.dto.WithdrawAndBookDTO;
import com.example.diploma.project.almatour.model.Wallet;
import com.example.diploma.project.almatour.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdrawFromWalletAndBookAccommodation(@RequestBody WithdrawAndBookDTO dto) {
        try {
            walletService.withdrawFromWallet(dto.getDepositDto(), dto.getAccommodationId(), dto.getUserId());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "/findByUserId/{userId}")
    public WalletDTO findByUserId(@PathVariable(value = "userId") Long userId){
        return walletService.findWalletByUserId(userId);
    }
}
