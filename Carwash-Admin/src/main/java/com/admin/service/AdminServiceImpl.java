package com.admin.service;

import com.admin.model.WasherLeaderboard;
import com.admin.model.Washpacks;
import com.admin.repository.AdminRepository;
import com.admin.repository.WasherLeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WasherLeaderboardRepository washerLeaderboardRepository;

    @Override
    public Washpacks addNewWashPack(Washpacks pack) {
        Washpacks washpacks = new Washpacks() ;
        washpacks.setId(pack.getId());
        washpacks.setPackName(pack.getPackName());
        washpacks.setAmount(pack.getAmount());
        washpacks.setDescription(pack.getDescription());
        adminRepository.save(washpacks);
        return washpacks;
    }

    @Override
    public Washpacks findByName(String name) {
        return adminRepository.findAll().stream().filter(p -> p.getPackName()
                .contains(name)).findAny().orElse(null);
    }

    @Override
    public Washpacks findById(int id) {
        return this.adminRepository.findById(id);
    }

    @Override
    public List<Washpacks> getAllPacks() {
        return adminRepository.findAll();
    }

    @Override
    public Washpacks updateWashPack(Washpacks washpacks) {
        return adminRepository.save(washpacks);
    }


    @Override
    public void deleteById(int id) {
        Washpacks washpacks = new Washpacks();
        adminRepository.deleteById(id);
    }


    @Override
    public List<WasherLeaderboard> getWasherLeaderboard() {
        return washerLeaderboardRepository.findAll();
    }

    @Override
    public WasherLeaderboard updateLeaderboard(WasherLeaderboard washerLeaderboard) {
        return washerLeaderboardRepository.save(washerLeaderboard);
    }

    @Override
    public WasherLeaderboard getByRank(int rank) {
        return this.washerLeaderboardRepository.findById(rank);
    }


    public WasherLeaderboard addNewWasherToLeaderboard(WasherLeaderboard washerLeaderboard) {
        WasherLeaderboard washerLeaderboard1 = new WasherLeaderboard();
        washerLeaderboard1.setRank(washerLeaderboard.getRank());
        washerLeaderboard1.setWasherName(washerLeaderboard.getWasherName());
        washerLeaderboard1.setWaterSavedInLiters(washerLeaderboard.getWaterSavedInLiters());
        washerLeaderboard1.setWorkingHrs(washerLeaderboard.getWorkingHrs());
        return washerLeaderboardRepository.save(washerLeaderboard1);
    }

}
