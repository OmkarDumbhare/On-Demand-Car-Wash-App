package com.admin.service;

import com.admin.model.WasherLeaderboard;
import com.admin.model.Washpacks;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    public Washpacks addNewWashPack(Washpacks pack);

    public Washpacks findByName(String name);

    public Washpacks findById(int id);

    public List<Washpacks> getAllPacks();

    public Washpacks updateWashPack(Washpacks washpacks);

    public void deleteById(int id);

    public List<WasherLeaderboard> getWasherLeaderboard();

    public WasherLeaderboard updateLeaderboard(WasherLeaderboard washerLeaderboard);

    public WasherLeaderboard getByRank(int rank);

}
