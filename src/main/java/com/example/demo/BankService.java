package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankRepository.save(bankAccount);
    }

    public Optional<BankAccount> getBankAccountById(int id) {
        return bankRepository.findById(id);
    }

    public List<BankAccount> getAllBankAccounts() {
        return (List<BankAccount>) bankRepository.findAll();
    }

    public boolean deleteBankAccount(int id) {
        if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
